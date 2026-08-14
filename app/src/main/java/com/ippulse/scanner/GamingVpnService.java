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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class GamingVpnService extends VpnService {
    private static final String ACTION_START = "com.ippulse.scanner.START";
    private static final String ACTION_STOP = "com.ippulse.scanner.STOP";
    private static final String CHANNEL_ID = "gaming_vpn";
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
            builder.addAddress("10.0.0.1", 32);
            builder.addRoute("10.0.0.1", 32); // فقط DNS server از تونل رد بشه
            builder.addDnsServer("10.0.0.1");
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
            if (protocol != 17) return; // فقط UDP

            byte[] srcIpBytes = new byte[4];
            buf.position(12);
            buf.get(srcIpBytes);
            InetAddress srcAddr = InetAddress.getByAddress(srcIpBytes);

            byte[] dstIpBytes = new byte[4];
            buf.get(dstIpBytes);
            InetAddress dstAddr = InetAddress.getByAddress(dstIpBytes);

            int srcPort = ((buf.get(headerLength) & 0xFF) << 8) | (buf.get(headerLength + 1) & 0xFF);
            int dstPort = ((buf.get(headerLength + 2) & 0xFF) << 8) | (buf.get(headerLength + 3) & 0xFF);
            if (dstPort != 53 || !dstAddr.getHostAddress().equals("10.0.0.1")) return;

            int udpLength = ((buf.get(headerLength + 4) & 0xFF) << 8) | (buf.get(headerLength + 5) & 0xFF);
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
                dnsResponse = forwardDns(dnsQuery);
            }

            if (dnsResponse != null) {
                byte[] responsePacket = buildUdpPacket(srcAddr, srcPort, dnsResponse);
                out.write(responsePacket);
            }
        } catch (Exception ignored) {}
    }

    private byte[] forwardDns(byte[] query) {
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

    private byte[] buildUdpPacket(InetAddress srcAddr, int srcPort, byte[] dnsPayload) {
        try {
            ByteBuffer packet = ByteBuffer.allocate(20 + 8 + dnsPayload.length);
            packet.put((byte) 0x45); // version/IHL
            packet.put((byte) 0x00); // DSCP/ECN
            int totalLength = 20 + 8 + dnsPayload.length;
            packet.putShort((short) totalLength);
            packet.putShort((short) 0); // identification
            packet.putShort((short) 0); // flags/fragment
            packet.put((byte) 64); // TTL
            packet.put((byte) 17); // protocol UDP
            packet.putShort((short) 0); // checksum (zero)
            packet.put(InetAddress.getByName("10.0.0.1").getAddress());
            packet.put(srcAddr.getAddress());
            packet.putShort((short) 53); // source port
            packet.putShort((short) srcPort); // dest port
            int udpLength = 8 + dnsPayload.length;
            packet.putShort((short) udpLength);
            packet.putShort((short) 0); // checksum (zero)
            packet.put(dnsPayload);
            return packet.array();
        } catch (Exception e) {
            return null;
        }
    }

    private String extractDomain(byte[] data) {
        try {
            int pos = 12;
            StringBuilder sb = new StringBuilder();
            while (pos < data.length) {
                int labelLength = data[pos] & 0xFF;
                if (labelLength == 0) break;
                if (labelLength > 63) return null;
                pos++;
                if (pos + labelLength > data.length) return null;
                for (int i = 0; i < labelLength; i++) {
                    sb.append((char) (data[pos + i] & 0xFF));
                }
                sb.append('.');
                pos += labelLength;
            }
            if (sb.length() > 0) sb.setLength(sb.length() - 1);
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
