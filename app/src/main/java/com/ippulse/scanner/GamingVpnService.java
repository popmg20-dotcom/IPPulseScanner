package com.ippulse.scanner;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.net.VpnService;
import android.os.Build;
import android.os.ParcelFileDescriptor;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class GamingVpnService extends VpnService {
    private static final String ACTION_START = "com.ippulse.scanner.START";
    private static final String ACTION_STOP = "com.ippulse.scanner.STOP";
    private static final String CHANNEL_ID = "gaming_vpn";
    private static final String VPN_ADDRESS = "10.0.0.2";
    private static final String DNS_ADDRESS = "10.0.0.1";
    private ParcelFileDescriptor vpnInterface;
    private String dns = "8.8.8.8";
    private int mtu = 1400;
    private HashMap<String, String> hostsMap = new HashMap<>();
    private Thread tunThread;
    private volatile boolean running = false;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            if (ACTION_STOP.equals(intent.getAction())) {
                stopVpn();
                return START_NOT_STICKY;
            }
            dns = intent.getStringExtra("dns");
            mtu = intent.getIntExtra("mtu", 1400);
            SerializableHosts serializableHosts = (SerializableHosts) intent.getSerializableExtra("hosts");
            if (serializableHosts != null) {
                hostsMap = serializableHosts.map;
            }
        }

        createNotificationChannel();
        startForegroundCompatible();
        startVpn();
        return START_STICKY;
    }

    private void startForegroundCompatible() {
        Notification notification = buildNotification("VPN Active");
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                startForeground(1, notification, ServiceInfo.FOREGROUND_SERVICE_TYPE_SPECIAL_USE);
            } else {
                startForeground(1, notification);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startVpn() {
        try {
            if (vpnInterface != null) return;

            Builder builder = new Builder();
            builder.setSession("Gaming VPN");
            builder.addAddress(VPN_ADDRESS, 32);
            builder.addRoute(DNS_ADDRESS, 32);
            builder.addDnsServer(DNS_ADDRESS);
            builder.setMtu(mtu);
            builder.setBlocking(true);
            vpnInterface = builder.establish();

            running = true;
            startTunReader();
        } catch (Exception e) {
            e.printStackTrace();
            stopVpn();
        }
    }

    private void startTunReader() {
        tunThread = new Thread(() -> {
            try (FileInputStream in = new FileInputStream(vpnInterface.getFileDescriptor());
                 FileOutputStream out = new FileOutputStream(vpnInterface.getFileDescriptor())) {
                byte[] buffer = new byte[32767];
                while (running && !Thread.currentThread().isInterrupted()) {
                    int length = in.read(buffer);
                    if (length > 0) {
                        handlePacket(buffer, length, out);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        tunThread.start();
    }

    private void handlePacket(byte[] packet, int length, FileOutputStream out) {
        try {
            ByteBuffer buf = ByteBuffer.wrap(packet, 0, length);
            int versionIHL = buf.get(0) & 0xFF;
            int version = (versionIHL >> 4) & 0xF;
            if (version != 4) return;

            int headerLength = (versionIHL & 0xF) * 4;
            int protocol = buf.get(9) & 0xFF;

            // Source IP (starting at offset 12)
            byte[] srcIpBytes = new byte[4];
            buf.position(12);
            buf.get(srcIpBytes);
            InetAddress srcAddr = InetAddress.getByAddress(srcIpBytes);

            // Destination IP
            byte[] dstIpBytes = new byte[4];
            buf.get(dstIpBytes);
            InetAddress dstAddr = InetAddress.getByAddress(dstIpBytes);

            if (!dstAddr.getHostAddress().equals(DNS_ADDRESS)) return;

            if (protocol == 17) { // UDP
                handleUdp(packet, length, headerLength, srcAddr, dstAddr, out);
            } else if (protocol == 6) { // TCP
                handleTcp(packet, length, headerLength, srcAddr, dstAddr, out);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleUdp(byte[] packet, int length, int headerLength, InetAddress srcAddr, InetAddress dstAddr, FileOutputStream out) {
        try {
            ByteBuffer buf = ByteBuffer.wrap(packet, headerLength, length - headerLength);
            int srcPort = buf.getShort() & 0xFFFF;
            int dstPort = buf.getShort() & 0xFFFF;
            if (dstPort != 53) return;

            int udpLength = buf.getShort() & 0xFFFF;
            int dnsPayloadOffset = headerLength + 8;
            int dnsPayloadLength = udpLength - 8;
            if (dnsPayloadLength <= 0) return;

            byte[] dnsQuery = new byte[dnsPayloadLength];
            System.arraycopy(packet, dnsPayloadOffset, dnsQuery, 0, dnsPayloadLength);

            String domain = extractDomain(dnsQuery);
            byte[] dnsResponse;
            if (domain != null && hostsMap.containsKey(domain)) {
                dnsResponse = buildDnsResponse(dnsQuery, hostsMap.get(domain));
            } else {
                dnsResponse = forwardUdpDns(dnsQuery);
            }

            if (dnsResponse != null) {
                byte[] responsePacket = buildUdpResponsePacket(srcAddr, srcPort, dnsResponse);
                out.write(responsePacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleTcp(byte[] packet, int length, int headerLength, InetAddress srcAddr, InetAddress dstAddr, FileOutputStream out) {
        // فقط TCP SYN به پورت 53 را قبول می‌کنیم و یک اتصال ساده برقرار می‌کنیم
        try {
            ByteBuffer tcpBuf = ByteBuffer.wrap(packet, headerLength, length - headerLength);
            int srcPort = tcpBuf.getShort() & 0xFFFF;
            int dstPort = tcpBuf.getShort() & 0xFFFF;
            if (dstPort != 53) return;

            int flags = tcpBuf.get(13) & 0xFF;
            boolean isSyn = (flags & 0x02) != 0;
            if (isSyn) {
                // ارسال SYN-ACK ساده (بدون هندشیک کامل)
                // فقط برای اینکه برنامه بفهمد اتصال برقرار شده
                // این پیاده‌سازی ساده ممکن است برای بعضی برنامه‌ها کافی نباشد
                // اما بهتر از قطع کامل است
                byte[] synAck = buildTcpSynAck(srcAddr, srcPort, dstPort);
                out.write(synAck);
            }
            // برای سادگی، TCP DNS را کامل پشتیبانی نمی‌کنیم؛ اما برنامه‌ها معمولاً از UDP استفاده می‌کنند
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private byte[] buildTcpSynAck(InetAddress srcAddr, int srcPort, int dstPort) {
        // ساده‌سازی: فقط یک بسته TCP با فلگ SYN-ACK و بدون payload
        // برای جلوگیری از قطع کامل، بهتر است از هیچی نباشد
        ByteBuffer packet = ByteBuffer.allocate(40);
        packet.put((byte) 0x45);
        packet.put((byte) 0x00);
        packet.putShort((short) 40);
        packet.putShort((short) 0);
        packet.putShort((short) 0);
        packet.put((byte) 64);
        packet.put((byte) 6);
        packet.putShort((short) 0); // IP checksum
        packet.put(new byte[]{10,0,0,1});
        packet.put(srcAddr.getAddress());
        packet.putShort((short) 53);
        packet.putShort((short) srcPort);
        packet.putInt(0); // SEQ
        packet.putInt(0); // ACK
        packet.put((byte) 0x60); // offset 6, flags SYN|ACK
        packet.put((byte) 0x12);
        packet.putShort((short) 65535); // window
        packet.putShort((short) 0); // checksum
        packet.putShort((short) 0); // urgent
        // Calculate TCP checksum (ignored for simplicity)
        return packet.array();
    }

    private byte[] forwardUdpDns(byte[] query) {
        try {
            DatagramSocket socket = new DatagramSocket();
            socket.setSoTimeout(5000);
            DatagramPacket request = new DatagramPacket(query, query.length, InetAddress.getByName(dns), 53);
            socket.send(request);
            byte[] responseBuffer = new byte[1024];
            DatagramPacket response = new DatagramPacket(responseBuffer, responseBuffer.length);
            socket.receive(response);
            byte[] data = new byte[response.getLength()];
            System.arraycopy(response.getData(), 0, data, 0, response.getLength());
            socket.close();
            return data;
        } catch (Exception e) {
            return null;
        }
    }

    private byte[] buildUdpResponsePacket(InetAddress clientAddr, int clientPort, byte[] dnsPayload) {
        try {
            int udpLength = 8 + dnsPayload.length;
            ByteBuffer packet = ByteBuffer.allocate(20 + udpLength);
            packet.put((byte) 0x45);
            packet.put((byte) 0x00);
            packet.putShort((short) (20 + udpLength));
            packet.putShort((short) 0);
            packet.putShort((short) 0);
            packet.put((byte) 64);
            packet.put((byte) 17);
            packet.putShort((short) 0); // IP checksum placeholder
            packet.put(new byte[]{10,0,0,1});
            packet.put(clientAddr.getAddress());
            packet.putShort((short) 53);
            packet.putShort((short) clientPort);
            packet.putShort((short) udpLength);
            packet.putShort((short) 0); // UDP checksum placeholder
            packet.put(dnsPayload);

            // محاسبه UDP checksum
            byte[] array = packet.array();
            int udpChecksum = calculateUdpChecksum(array, 12, 20, 8 + dnsPayload.length);
            packet.putShort(26, (short) udpChecksum);

            // محاسبه IP checksum
            int ipChecksum = calculateIpChecksum(array, 0, 20);
            packet.putShort(10, (short) ipChecksum);

            return array;
        } catch (Exception e) {
            return null;
        }
    }

    private int calculateUdpChecksum(byte[] packet, int srcIpOffset, int udpOffset, int udpLength) {
        long sum = 0;
        // Pseudo-header
        sum += ((packet[srcIpOffset] & 0xFF) << 8) | (packet[srcIpOffset + 1] & 0xFF);
        sum += ((packet[srcIpOffset + 2] & 0xFF) << 8) | (packet[srcIpOffset + 3] & 0xFF);
        sum += ((packet[srcIpOffset + 4] & 0xFF) << 8) | (packet[srcIpOffset + 5] & 0xFF);
        sum += ((packet[srcIpOffset + 6] & 0xFF) << 8) | (packet[srcIpOffset + 7] & 0xFF);
        sum += 0x0011; // protocol UDP
        sum += udpLength;
        // UDP header + payload
        int end = udpOffset + udpLength;
        for (int i = udpOffset; i < end; i += 2) {
            int word = ((packet[i] & 0xFF) << 8);
            if (i + 1 < end) word |= (packet[i + 1] & 0xFF);
            sum += word;
        }
        while ((sum >> 16) != 0) {
            sum = (sum & 0xFFFF) + (sum >> 16);
        }
        return (int) (~sum & 0xFFFF);
    }

    private int calculateIpChecksum(byte[] packet, int offset, int length) {
        long sum = 0;
        for (int i = offset; i < offset + length; i += 2) {
            int word = ((packet[i] & 0xFF) << 8);
            if (i + 1 < offset + length) word |= (packet[i + 1] & 0xFF);
            sum += word;
        }
        while ((sum >> 16) != 0) {
            sum = (sum & 0xFFFF) + (sum >> 16);
        }
        return (int) (~sum & 0xFFFF);
    }

    private String extractDomain(byte[] data) {
        try {
            int pos = 12;
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            while (pos < data.length) {
                int labelLength = data[pos] & 0xFF;
                if (labelLength == 0) break;
                if ((labelLength & 0xC0) == 0xC0) {
                    if (pos + 1 >= data.length) return null;
                    int pointer = ((labelLength & 0x3F) << 8) | (data[pos + 1] & 0xFF);
                    return extractDomainFromOffset(data, pointer);
                }
                if (labelLength > 63) return null;
                pos++;
                if (pos + labelLength > data.length) return null;
                if (!first) sb.append('.');
                for (int i = 0; i < labelLength; i++) {
                    sb.append((char) (data[pos + i] & 0xFF));
                }
                first = false;
                pos += labelLength;
            }
            return sb.toString().toLowerCase();
        } catch (Exception e) {
            return null;
        }
    }

    private String extractDomainFromOffset(byte[] data, int offset) {
        try {
            int pos = offset;
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            while (pos < data.length) {
                int labelLength = data[pos] & 0xFF;
                if (labelLength == 0) break;
                if ((labelLength & 0xC0) == 0xC0) {
                    if (pos + 1 >= data.length) return null;
                    int pointer = ((labelLength & 0x3F) << 8) | (data[pos + 1] & 0xFF);
                    return extractDomainFromOffset(data, pointer);
                }
                if (labelLength > 63) return null;
                pos++;
                if (pos + labelLength > data.length) return null;
                if (!first) sb.append('.');
                for (int i = 0; i < labelLength; i++) {
                    sb.append((char) (data[pos + i] & 0xFF));
                }
                first = false;
                pos += labelLength;
            }
            return sb.toString().toLowerCase();
        } catch (Exception e) {
            return null;
        }
    }

    private byte[] buildDnsResponse(byte[] query, String ip) {
        try {
            ByteBuffer response = ByteBuffer.allocate(1024);
            response.put(query[0]);
            response.put(query[1]);
            response.put((byte) 0x81);
            response.put((byte) 0x80);
            response.putShort((short) 1);
            response.putShort((short) 1);
            response.putShort((short) 0);
            response.putShort((short) 0);

            // Copy question
            int pos = 12;
            while (pos < query.length && query[pos] != 0) {
                response.put(query[pos++]);
            }
            response.put((byte) 0);
            pos++;
            response.put(query[pos++]);
            response.put(query[pos++]);
            response.put(query[pos++]);
            response.put(query[pos++]);

            // Answer
            response.put((byte) 0xC0);
            response.put((byte) 0x0C);
            response.putShort((short) 1); // Type A
            response.putShort((short) 1); // Class IN
            response.putInt(60); // TTL
            response.putShort((short) 4); // RDLENGTH
            String[] ipParts = ip.split("\\.");
            for (String part : ipParts) {
                response.put((byte) Integer.parseInt(part));
            }
            byte[] result = new byte[response.position()];
            response.rewind();
            response.get(result);
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    private void stopVpn() {
        running = false;
        if (tunThread != null) {
            tunThread.interrupt();
            tunThread = null;
        }
        try {
            if (vpnInterface != null) {
                vpnInterface.close();
                vpnInterface = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        stopForeground(true);
        stopSelf();
    }

    @Override
    public void onDestroy() {
        stopVpn();
        super.onDestroy();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                CHANNEL_ID, "Gaming VPN", NotificationManager.IMPORTANCE_LOW);
            NotificationManager manager = getSystemService(NotificationManager.class);
            if (manager != null) manager.createNotificationChannel(channel);
        }
    }

    private Notification buildNotification(String text) {
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_IMMUTABLE);
        Notification.Builder builder = Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
                ? new Notification.Builder(this, CHANNEL_ID)
                : new Notification.Builder(this);
        return builder.setContentTitle("IPPulseScanner VPN")
                .setContentText(text)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentIntent(pendingIntent)
                .build();
    }

    public static void start(Context context, String dns, int mtu, HashMap<String, String> hostsMap) {
        Intent intent = new Intent(context, GamingVpnService.class);
        intent.setAction(ACTION_START);
        intent.putExtra("dns", dns);
        intent.putExtra("mtu", mtu);
        SerializableHosts serializableHosts = new SerializableHosts(hostsMap);
        intent.putExtra("hosts", serializableHosts);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    public static void stop(Context context) {
        Intent intent = new Intent(context, GamingVpnService.class);
        intent.setAction(ACTION_STOP);
        context.startService(intent);
    }

    public static class SerializableHosts implements java.io.Serializable {
        public HashMap<String, String> map;
        public SerializableHosts(HashMap<String, String> map) {
            this.map = map;
        }
    }
}
