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
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GamingVpnService extends VpnService {

    private static final String TAG = "GamingVpn";
    private static final String ACTION_START = "com.ippulse.scanner.START";
    private static final String ACTION_STOP = "com.ippulse.scanner.STOP";
    private static final String CHANNEL_ID = "gaming_vpn";
    private static final String VPN_ADDRESS = "10.0.0.2";
    private static final String DNS_ADDRESS = "10.0.0.1";

    private ParcelFileDescriptor vpnInterface;
    private FileInputStream tunIn;
    private FileOutputStream tunOut;

    private HashMap<String, String> hostsMap = new HashMap<>();
    private String dns = "8.8.8.8";
    private int currentMtu = 1400;
    private volatile boolean running = false;

    private Thread tunThread;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            if (ACTION_STOP.equals(intent.getAction())) {
                stopVpn();
                return START_NOT_STICKY;
            }
            if (intent.hasExtra("dns")) dns = intent.getStringExtra("dns");
            if (intent.hasExtra("mtu")) currentMtu = intent.getIntExtra("mtu", 1400);
            SerializableHosts serializableHosts = (SerializableHosts) intent.getSerializableExtra("hosts");
            if (serializableHosts != null && serializableHosts.map != null) {
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
            startForeground(1, notification);
        }
    }

    private void startVpn() {
        try {
            if (vpnInterface != null) return;
            running = true;

            Builder builder = new Builder();
            builder.setSession("Gaming VPN");
            builder.addAddress(VPN_ADDRESS, 32);
            builder.addRoute(DNS_ADDRESS, 32); // فقط DNS از تونل رد می‌شود
            builder.addDnsServer(DNS_ADDRESS);
            builder.setMtu(currentMtu);
            builder.setBlocking(true);

            vpnInterface = builder.establish();
            tunIn = new FileInputStream(vpnInterface.getFileDescriptor());
            tunOut = new FileOutputStream(vpnInterface.getFileDescriptor());

            tunThread = new Thread(this::runTunLoop, "TunReaderThread");
            tunThread.start();

            Log.i(TAG, "DNS-only VPN started. MTU=" + currentMtu);
        } catch (Exception e) {
            Log.e(TAG, "Error starting VPN", e);
            stopVpn();
        }
    }

    private void runTunLoop() {
        byte[] buffer = new byte[32767];
        while (running && !Thread.currentThread().isInterrupted()) {
            try {
                int length = tunIn.read(buffer);
                if (length > 0) {
                    handlePacket(buffer, length);
                }
            } catch (IOException e) {
                if (running) Log.e(TAG, "TUN read error", e);
                break;
            }
        }
    }

    private void handlePacket(byte[] packet, int length) {
        try {
            ByteBuffer buf = ByteBuffer.wrap(packet, 0, length);
            int versionIhl = buf.get(0) & 0xFF;
            int version = (versionIhl >> 4) & 0xF;
            if (version != 4) return;

            int headerLength = (versionIhl & 0x0F) * 4;
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

            if (!dstAddr.getHostAddress().equals(DNS_ADDRESS) || dstPort != 53) return;

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
                byte[] responsePacket = buildUdpPacket(DNS_ADDRESS, 53, srcAddr, srcPort, dnsResponse);
                tunOut.write(responsePacket);
                tunOut.flush();
            }
        } catch (Exception e) {
            Log.e(TAG, "Packet handling error", e);
        }
    }

    private byte[] forwardDns(byte[] query) {
        try {
            DatagramSocket socket = new DatagramSocket();
            protect(socket);
            socket.setSoTimeout(2000);
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

    private byte[] buildUdpPacket(String sourceIp, int sourcePort, InetAddress clientAddr, int clientPort, byte[] payload) {
        try {
            int udpLength = 8 + payload.length;
            int totalLength = 20 + udpLength;
            ByteBuffer packet = ByteBuffer.allocate(totalLength);

            // IPv4 Header
            packet.put((byte) 0x45); // version/IHL
            packet.put((byte) 0x00); // TOS
            packet.putShort((short) totalLength);
            packet.putShort((short) 0); // ID
            packet.putShort((short) 0); // flags/fragment
            packet.put((byte) 64); // TTL
            packet.put((byte) 17); // protocol UDP
            packet.putShort((short) 0); // checksum placeholder
            packet.put(InetAddress.getByName(sourceIp).getAddress());
            packet.put(clientAddr.getAddress());

            // UDP Header
            packet.putShort((short) sourcePort);
            packet.putShort((short) clientPort);
            packet.putShort((short) udpLength);
            packet.putShort((short) 0); // UDP checksum = 0 (optional in IPv4)

            packet.put(payload);

            byte[] array = packet.array();
            int ipChecksum = calculateIpChecksum(array, 0, 20);
            array[10] = (byte) (ipChecksum >> 8);
            array[11] = (byte) (ipChecksum & 0xFF);

            return array;
        } catch (Exception e) {
            return null;
        }
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
                for (int i = 0; i < labelLength; i++) sb.append((char) (data[pos + i] & 0xFF));
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
                for (int i = 0; i < labelLength; i++) sb.append((char) (data[pos + i] & 0xFF));
                first = false;
                pos += labelLength;
            }
            return sb.toString().toLowerCase();
        } catch (Exception e) {
            return null;
        }
    }

    private byte[] buildDnsResponse(byte[] query, String ip) {
        ByteBuffer response = ByteBuffer.allocate(1024);
        response.put(query[0]);
        response.put(query[1]);
        response.put((byte) 0x81);
        response.put((byte) 0x80);
        response.putShort((short) 1); // QDCOUNT
        response.putShort((short) 1); // ANCOUNT
        response.putShort((short) 0);
        response.putShort((short) 0);

        int pos = 12;
        while (pos < query.length && query[pos] != 0) {
            response.put(query[pos++]);
        }
        response.put((byte) 0);
        pos++;
        response.put(query[pos++]); // QTYPE high
        response.put(query[pos++]); // QTYPE low
        response.put(query[pos++]); // QCLASS high
        response.put(query[pos++]); // QCLASS low

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
        System.arraycopy(response.array(), 0, result, 0, response.position());
        return result;
    }

    private void stopVpn() {
        running = false;
        if (tunThread != null) {
            tunThread.interrupt();
            tunThread = null;
        }
        try { if (tunIn != null) tunIn.close(); } catch (IOException ignored) {}
        try { if (tunOut != null) tunOut.close(); } catch (IOException ignored) {}
        try { if (vpnInterface != null) vpnInterface.close(); } catch (IOException ignored) {}
        vpnInterface = null;
        stopForeground(true);
        stopSelf();
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
        intent.putExtra("hosts", new SerializableHosts(hostsMap));
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
        public SerializableHosts(HashMap<String, String> map) { this.map = map; }
    }
}