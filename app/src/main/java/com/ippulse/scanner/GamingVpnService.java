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
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
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
    private final Map<String, TcpSession> tcpSessions = new ConcurrentHashMap<>();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            if (ACTION_STOP.equals(intent.getAction())) {
                stopVpn();
                return START_NOT_STICKY;
            }
            dns = intent.getStringExtra("dns");
            currentMtu = intent.getIntExtra("mtu", 1400);
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

        if (protocol == 17) { // UDP
            handleUdpPacket(packet, length, ipHeaderLen, srcIp, dstIp);
        } else if (protocol == 6) { // TCP
            handleTcpPacket(packet, length, ipHeaderLen, srcIp, dstIp);
        }
    }

    // -------------------- UDP --------------------
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
            } catch (Exception e) {
                Log.e(TAG, "DNS error", e);
            }
        }).start();
    }

    // -------------------- TCP --------------------
    private void handleTcpPacket(byte[] packet, int length, int ipHeaderLen, byte[] srcIp, byte[] dstIp) {
        int srcPort = ((packet[ipHeaderLen] & 0xFF) << 8) | (packet[ipHeaderLen + 1] & 0xFF);
        int dstPort = ((packet[ipHeaderLen + 2] & 0xFF) << 8) | (packet[ipHeaderLen + 3] & 0xFF);

        int tcpFlags = packet[ipHeaderLen + 13] & 0xFF;
        boolean isSyn = (tcpFlags & 0x02) != 0;
        boolean isAck = (tcpFlags & 0x10) != 0;

        try {
            String destIpStr = InetAddress.getByAddress(dstIp).getHostAddress();
            String sessionKey = srcPort + "-" + destIpStr + ":" + dstPort;

            TcpSession session = tcpSessions.get(sessionKey);

            if (session == null && isSyn && !isAck) {
                session = new TcpSession(srcIp, srcPort, dstIp, dstPort);
                tcpSessions.put(sessionKey, session);
                session.connectAndForward();
                // Send SYN-ACK back
                injectTcpSynAck(srcIp, srcPort, dstIp, dstPort);
            } else if (session != null) {
                int tcpHeaderLen = ((packet[ipHeaderLen + 12] & 0xF0) >> 4) * 4;
                int payloadOffset = ipHeaderLen + tcpHeaderLen;
                int payloadLen = length - payloadOffset;
                if (payloadLen > 0) {
                    byte[] payload = new byte[payloadLen];
                    System.arraycopy(packet, payloadOffset, payload, 0, payloadLen);
                    session.sendData(payload);
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "TCP error", e);
        }
    }

    private void injectTcpSynAck(byte[] clientIp, int clientPort, byte[] serverIp, int serverPort) {
        // Simplified SYN-ACK (not full sequence handling)
        try {
            ByteBuffer packet = ByteBuffer.allocate(40);
            packet.put((byte) 0x45); packet.put((byte) 0x00);
            packet.putShort((short) 40);
            packet.putShort((short) 0);
            packet.putShort((short) 0);
            packet.put((byte) 64); packet.put((byte) 6);
            packet.putShort((short) 0); // IP checksum placeholder
            packet.put(serverIp); // source = server
            packet.put(clientIp); // dest = client
            packet.putShort((short) serverPort);
            packet.putShort((short) clientPort);
            packet.putInt(0); // SEQ
            packet.putInt(0); // ACK
            packet.put((byte) 0x60); // TCP offset 6
            packet.put((byte) 0x12); // SYN|ACK
            packet.putShort((short) 65535);
            packet.putShort((short) 0); // checksum
            packet.putShort((short) 0);

            byte[] array = packet.array();
            int ipChecksum = calculateIpChecksum(array, 0, 20);
            array[10] = (byte) (ipChecksum >> 8);
            array[11] = (byte) (ipChecksum & 0xFF);
            tunOut.write(array);
            tunOut.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class TcpSession {
        private SocketChannel socketChannel;
        private byte[] clientIp, serverIp;
        private int clientPort, serverPort;

        TcpSession(byte[] cIp, int cPort, byte[] sIp, int sPort) throws IOException {
            this.clientIp = cIp; this.clientPort = cPort;
            this.serverIp = sIp; this.serverPort = sPort;
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(true);
            protect(socketChannel.socket());
        }

        void connectAndForward() {
            new Thread(() -> {
                try {
                    InetAddress sAddr = InetAddress.getByAddress(serverIp);
                    socketChannel.connect(new InetSocketAddress(sAddr, serverPort));
                    ByteBuffer buffer = ByteBuffer.allocate(32767);
                    while (socketChannel.read(buffer) > 0) {
                        buffer.flip();
                        byte[] data = new byte[buffer.remaining()];
                        buffer.get(data);
                        // Not forwarding server->client in this simplified version
                        buffer.clear();
                    }
                } catch (Exception e) {
                    tcpSessions.remove(clientPort + "-" + serverPort);
                }
            }).start();
        }

        void sendData(byte[] data) throws IOException {
            if (socketChannel.isConnected()) {
                socketChannel.write(ByteBuffer.wrap(data));
            }
        }
    }

    // -------------------- Helpers --------------------
    private synchronized void injectUdpToTun(byte[] srcIp, int srcPort, byte[] dstIp, int dstPort, byte[] payload) throws IOException {
        int udpLen = 8 + payload.length;
        int totalLen = 20 + udpLen;
        ByteBuffer res = ByteBuffer.allocate(totalLen);

        res.put((byte) 0x45); res.put((byte) 0x00);
        res.putShort((short) totalLen);
        res.putShort((short) 0); res.putShort((short) 0);
        res.put((byte) 64); res.put((byte) 17);
        res.putShort((short) 0); // IP checksum placeholder
        res.put(srcIp); res.put(dstIp);

        res.putShort((short) srcPort); res.putShort((short) dstPort);
        res.putShort((short) udpLen); res.putShort((short) 0);

        res.put(payload);
        byte[] array = res.array();
        int ipChecksum = calculateIpChecksum(array, 0, 20);
        array[10] = (byte) (ipChecksum >> 8);
        array[11] = (byte) (ipChecksum & 0xFF);

        tunOut.write(array);
        tunOut.flush();
    }

    private String extractDomain(byte[] dnsPayload) {
        StringBuilder domain = new StringBuilder();
        int pos = 12;
        while (pos < dnsPayload.length && dnsPayload[pos] != 0) {
            int len = dnsPayload[pos++];
            for (int i = 0; i < len; i++) {
                domain.append((char) dnsPayload[pos++]);
            }
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

    private int calculateIpChecksum(byte[] buf, int offset, int length) {
        long sum = 0;
        for (int i = offset; i < offset + length; i += 2) {
            sum += ((buf[i] & 0xFF) << 8) | (buf[i + 1] & 0xFF);
        }
        while ((sum >> 16) > 0) {
            sum = (sum & 0xFFFF) + (sum >> 16);
        }
        return (int) (~sum & 0xFFFF);
    }

    private void stopVpn() {
        running = false;
        if (vpnThread != null) {
            vpnThread.interrupt();
            vpnThread = null;
        }
        try { if (tunIn != null) tunIn.close(); } catch (IOException e) {}
        try { if (tunOut != null) tunOut.close(); } catch (IOException e) {}
        try { if (vpnInterface != null) vpnInterface.close(); } catch (IOException e) {}
        for (UdpSession session : udpSessions.values()) {
            if (session.socket != null && !session.socket.isClosed()) session.socket.close();
        }
        udpSessions.clear();
        for (TcpSession session : tcpSessions.values()) {
            try { if (session.socketChannel != null) session.socketChannel.close(); } catch (Exception ignored) {}
        }
        tcpSessions.clear();
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

    private class UdpSession {
        private DatagramSocket socket;
        private byte[] vpnClientIp;
        private int vpnClientPort;
        private byte[] serverIp;
        private int serverPort;

        UdpSession(byte[] vpnClientIp, int vpnClientPort, byte[] serverIp, int serverPort) throws Exception {
            this.vpnClientIp = vpnClientIp;
            this.vpnClientPort = vpnClientPort;
            this.serverIp = serverIp;
            this.serverPort = serverPort;

            this.socket = new DatagramSocket();
            protect(this.socket);

            new Thread(() -> {
                try {
                    byte[] receiveData = new byte[65535];
                    while (!socket.isClosed()) {
                        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                        socket.receive(receivePacket);

                        byte[] payload = new byte[receivePacket.getLength()];
                        System.arraycopy(receiveData, 0, payload, 0, receivePacket.getLength());

                        injectUdpToTun(serverIp, serverPort, vpnClientIp, vpnClientPort, payload);
                    }
                } catch (Exception ignored) {}
            }).start();
        }

        void sendToServer(byte[] payload) throws Exception {
            InetAddress destAddr = InetAddress.getByAddress(serverIp);
            DatagramPacket packet = new DatagramPacket(payload, payload.length, destAddr, serverPort);
            socket.send(packet);
        }
    }
}
