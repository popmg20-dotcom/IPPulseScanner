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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GamingVpnService extends VpnService implements Runnable {
    private static final String TAG = "GamingVpn";
    private static final String ACTION_START = "com.ippulse.scanner.START";
    private static final String ACTION_STOP = "com.ippulse.scanner.STOP";
    private static final String CHANNEL_ID = "gaming_vpn";
    private static final String VPN_ADDRESS = "10.0.0.2";
    private static final String DNS_ADDRESS = "10.0.0.1";

    private Thread vpnThread;
    private ParcelFileDescriptor vpnInterface;
    private FileInputStream tunIn;
    private FileOutputStream tunOut;

    private HashMap<String, String> hostsMap = new HashMap<>();
    private String dns = "8.8.8.8";
    private int currentMtu = 1400;
    private volatile boolean running = false;

    private final Map<String, UdpSession> udpSessions = new ConcurrentHashMap<>();

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
            running = true;

            Builder builder = new Builder();
            builder.setSession("Gaming VPN");
            builder.addAddress(VPN_ADDRESS, 32);
            builder.addRoute("0.0.0.0", 0); // Full Tunnel
            builder.addDnsServer(DNS_ADDRESS);
            builder.setMtu(currentMtu);
            builder.setBlocking(true);

            vpnInterface = builder.establish();
            tunIn = new FileInputStream(vpnInterface.getFileDescriptor());
            tunOut = new FileOutputStream(vpnInterface.getFileDescriptor());

            vpnThread = new Thread(this, "VpnReaderThread");
            vpnThread.start();
        } catch (Exception e) {
            Log.e(TAG, "Error starting VPN", e);
            stopVpn();
        }
    }

    @Override
    public void run() {
        byte[] packet = new byte[32767];
        while (running && !Thread.interrupted()) {
            try {
                int length = tunIn.read(packet);
                if (length > 0) {
                    processPacket(packet, length);
                }
            } catch (IOException e) {
                if (running) Log.e(TAG, "Read error", e);
                break;
            }
        }
        stopVpn();
    }

    private void processPacket(byte[] packet, int length) {
        int versionIhl = packet[0] & 0xFF;
        int ihl = versionIhl & 0x0F;
        int ipHeaderLen = ihl * 4;
        int protocol = packet[9] & 0xFF;

        byte[] srcIp = new byte[4], dstIp = new byte[4];
        System.arraycopy(packet, 12, srcIp, 0, 4);
        System.arraycopy(packet, 16, dstIp, 0, 4);

        if (protocol == 1) { // ICMP (Ping)
            handleIcmpPacket(packet, length, ipHeaderLen);
        } else if (protocol == 17) { // UDP
            handleUdpPacket(packet, length, ipHeaderLen, srcIp, dstIp);
        } else if (protocol == 6) { // TCP
            rejectTcpConnection(packet, ipHeaderLen, srcIp, dstIp);
        }
    }

    // =====================================
    // ICMP Echo Responder
    // =====================================
    private void handleIcmpPacket(byte[] packet, int length, int ipHeaderLen) {
        int icmpType = packet[ipHeaderLen] & 0xFF;
        if (icmpType == 8) { // Echo Request
            byte[] response = new byte[length];
            System.arraycopy(packet, 0, response, 0, length);

            // Swap Source and Dest IP
            System.arraycopy(packet, 12, response, 16, 4);
            System.arraycopy(packet, 16, response, 12, 4);

            // Change Type 8 (Request) to Type 0 (Reply)
            response[ipHeaderLen] = 0;
            response[ipHeaderLen + 2] = 0;
            response[ipHeaderLen + 3] = 0;

            // Recalculate ICMP Checksum
            int icmpLen = length - ipHeaderLen;
            int icmpChecksum = calculateChecksum(response, ipHeaderLen, icmpLen);
            response[ipHeaderLen + 2] = (byte) (icmpChecksum >> 8);
            response[ipHeaderLen + 3] = (byte) (icmpChecksum & 0xFF);

            try {
                tunOut.write(response);
            } catch (IOException ignored) {}
        }
    }

    // =====================================
    // UDP NAT & DNS Proxy
    // =====================================
    private void handleUdpPacket(byte[] packet, int length, int ipHeaderLen, byte[] srcIp, byte[] dstIp) {
        int srcPort = ((packet[ipHeaderLen] & 0xFF) << 8) | (packet[ipHeaderLen + 1] & 0xFF);
        int dstPort = ((packet[ipHeaderLen + 2] & 0xFF) << 8) | (packet[ipHeaderLen + 3] & 0xFF);

        int payloadLen = length - ipHeaderLen - 8;
        if (payloadLen <= 0) return;
        byte[] payload = new byte[payloadLen];
        System.arraycopy(packet, ipHeaderLen + 8, payload, 0, payloadLen);

        if (dstPort == 53) {
            handleDnsRequest(payload, srcIp, srcPort, dstIp);
        } else {
            try {
                String destIpStr = InetAddress.getByAddress(dstIp).getHostAddress();
                String sessionKey = srcPort + "-" + destIpStr + ":" + dstPort;

                UdpSession session = udpSessions.get(sessionKey);
                if (session == null) {
                    session = new UdpSession(srcIp, srcPort, dstIp, dstPort);
                    udpSessions.put(sessionKey, session);
                }
                session.sendToServer(payload);
            } catch (Exception e) {
                Log.e(TAG, "UDP NAT error", e);
            }
        }
    }

    private class UdpSession {
        private DatagramSocket socket;
        private byte[] vpnClientIp, serverIp;
        private int vpnClientPort, serverPort;

        UdpSession(byte[] clientIp, int clientPort, byte[] serverIp, int serverPort) throws IOException {
            this.vpnClientIp = clientIp.clone();
            this.vpnClientPort = clientPort;
            this.serverIp = serverIp.clone();
            this.serverPort = serverPort;

            socket = new DatagramSocket();
            protect(socket); // Bypass VPN

            new Thread(() -> {
                try {
                    byte[] recvBuf = new byte[65535];
                    while (running && !socket.isClosed()) {
                        DatagramPacket inPacket = new DatagramPacket(recvBuf, recvBuf.length);
                        socket.receive(inPacket);
                        byte[] payload = new byte[inPacket.getLength()];
                        System.arraycopy(recvBuf, 0, payload, 0, payload.length);
                        injectUdpToTun(this.serverIp, this.serverPort, this.vpnClientIp, this.vpnClientPort, payload);
                    }
                } catch (Exception ignored) {
                } finally {
                    try {
                        String ipStr = InetAddress.getByAddress(this.serverIp).getHostAddress();
                        udpSessions.remove(vpnClientPort + "-" + ipStr + ":" + serverPort);
                    } catch (Exception e) {}
                }
            }).start();
        }

        void sendToServer(byte[] payload) throws IOException {
            InetAddress dest = InetAddress.getByAddress(serverIp);
            DatagramPacket p = new DatagramPacket(payload, payload.length, dest, serverPort);
            socket.send(p);
        }
    }

    private void handleDnsRequest(byte[] dnsPayload, byte[] srcIp, int srcPort, byte[] dstIp) {
        new Thread(() -> {
            try {
                String domain = extractDomain(dnsPayload);
                if (hostsMap.containsKey(domain)) {
                    byte[] responsePayload = buildDnsResponse(dnsPayload, hostsMap.get(domain));
                    injectUdpToTun(dstIp, 53, srcIp, srcPort, responsePayload);
                } else {
                    DatagramSocket dnsSocket = new DatagramSocket();
                    protect(dnsSocket);
                    DatagramPacket outPacket = new DatagramPacket(dnsPayload, dnsPayload.length, InetAddress.getByName(dns), 53);
                    dnsSocket.send(outPacket);

                    byte[] recvBuf = new byte[1024];
                    DatagramPacket inPacket = new DatagramPacket(recvBuf, recvBuf.length);
                    dnsSocket.setSoTimeout(3000);
                    dnsSocket.receive(inPacket);

                    byte[] actualResponse = new byte[inPacket.getLength()];
                    System.arraycopy(recvBuf, 0, actualResponse, 0, inPacket.getLength());
                    injectUdpToTun(dstIp, 53, srcIp, srcPort, actualResponse);
                    dnsSocket.close();
                }
            } catch (Exception ignored) {}
        }).start();
    }

    private synchronized void injectUdpToTun(byte[] srcIp, int srcPort, byte[] dstIp, int dstPort, byte[] payload) throws IOException {
        int udpLen = 8 + payload.length;
        int totalLen = 20 + udpLen;
        ByteBuffer res = ByteBuffer.allocate(totalLen);

        res.put((byte) 0x45); res.put((byte) 0x00);
        res.putShort((short) totalLen);
        res.putShort((short) 0); res.putShort((short) 0);
        res.put((byte) 64); res.put((byte) 17);
        res.putShort((short) 0);
        res.put(srcIp); res.put(dstIp);

        res.putShort((short) srcPort); res.putShort((short) dstPort);
        res.putShort((short) udpLen); res.putShort((short) 0);

        res.put(payload);
        byte[] array = res.array();
        int ipChecksum = calculateChecksum(array, 0, 20);
        array[10] = (byte) (ipChecksum >> 8);
        array[11] = (byte) (ipChecksum & 0xFF);

        tunOut.write(array);
    }

    // =====================================
    // TCP Rejector
    // =====================================
    private void rejectTcpConnection(byte[] packet, int ipHeaderLen, byte[] srcIp, byte[] dstIp) {
        int srcPort = ((packet[ipHeaderLen] & 0xFF) << 8) | (packet[ipHeaderLen + 1] & 0xFF);
        int dstPort = ((packet[ipHeaderLen + 2] & 0xFF) << 8) | (packet[ipHeaderLen + 3] & 0xFF);

        long seq = ((long) (packet[ipHeaderLen + 4] & 0xFF) << 24) | ((packet[ipHeaderLen + 5] & 0xFF) << 16) |
                   ((packet[ipHeaderLen + 6] & 0xFF) << 8) | (packet[ipHeaderLen + 7] & 0xFF);

        ByteBuffer rst = ByteBuffer.allocate(40);
        rst.put((byte) 0x45); rst.put((byte) 0x00);
        rst.putShort((short) 40);
        rst.putShort((short) 0); rst.putShort((short) 0);
        rst.put((byte) 64); rst.put((byte) 6);
        rst.putShort((short) 0);
        rst.put(dstIp); rst.put(srcIp);

        rst.putShort((short) dstPort); rst.putShort((short) srcPort);
        rst.putInt(0); // Our Seq
        rst.putInt((int) (seq + 1)); // Ack = Client Seq + 1
        rst.put((byte) 0x50); // Header Len
        rst.put((byte) 0x14); // Flags: RST + ACK
        rst.putShort((short) 0); // Window
        rst.putShort((short) 0); // Checksum (optional 0 trick)
        rst.putShort((short) 0);

        byte[] array = rst.array();
        int ipChecksum = calculateChecksum(array, 0, 20);
        array[10] = (byte) (ipChecksum >> 8);
        array[11] = (byte) (ipChecksum & 0xFF);

        try { tunOut.write(array); } catch (Exception ignored) {}
    }

    // =====================================
    // Utils
    // =====================================
    private String extractDomain(byte[] dnsPayload) {
        StringBuilder domain = new StringBuilder();
        int pos = 12;
        while (pos < dnsPayload.length && dnsPayload[pos] != 0) {
            int len = dnsPayload[pos++];
            for (int i = 0; i < len; i++) domain.append((char) dnsPayload[pos++]);
            domain.append(".");
        }
        if (domain.length() > 0) domain.setLength(domain.length() - 1);
        return domain.toString();
    }

    private byte[] buildDnsResponse(byte[] query, String ip) {
        ByteBuffer res = ByteBuffer.allocate(512);
        res.put(query[0]); res.put(query[1]);
        res.put((byte) 0x81); res.put((byte) 0x80);
        res.putShort((short) 1); res.putShort((short) 1);
        res.putShort((short) 0); res.putShort((short) 0);

        int pos = 12;
        while (pos < query.length && query[pos] != 0) res.put(query[pos++]);
        res.put((byte) 0); pos++;
        res.put(query[pos++]); res.put(query[pos++]);
        res.put(query[pos++]); res.put(query[pos++]);

        res.put((byte) 0xC0); res.put((byte) 0x0C);
        res.putShort((short) 1); res.putShort((short) 1);
        res.putInt(60); res.putShort((short) 4);
        for (String part : ip.split("\\.")) res.put((byte) Integer.parseInt(part));

        byte[] result = new byte[res.position()];
        System.arraycopy(res.array(), 0, result, 0, res.position());
        return result;
    }

    private int calculateChecksum(byte[] buf, int offset, int length) {
        long sum = 0;
        int i = offset;
        while (length > 1) {
            sum += (((buf[i] & 0xFF) << 8) | (buf[i + 1] & 0xFF));
            i += 2;
            length -= 2;
        }
        if (length > 0) sum += ((buf[i] & 0xFF) << 8);
        while ((sum >> 16) > 0) sum = (sum & 0xFFFF) + (sum >> 16);
        return (int) (~sum & 0xFFFF);
    }

    private void stopVpn() {
        running = false;
        if (vpnThread != null) { vpnThread.interrupt(); vpnThread = null; }
        try { if (tunIn != null) tunIn.close(); } catch (IOException ignored) {}
        try { if (tunOut != null) tunOut.close(); } catch (IOException ignored) {}
        try { if (vpnInterface != null) vpnInterface.close(); } catch (IOException ignored) {}
        for (UdpSession session : udpSessions.values()) {
            if (session.socket != null && !session.socket.isClosed()) session.socket.close();
        }
        udpSessions.clear();
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
