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
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    private Set<String> routedIps = new HashSet<>();
    private Thread tunThread;
    private volatile boolean running = false;
    private ExecutorService udpExecutor;

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
            // فقط DNS محلی
            builder.addRoute(DNS_ADDRESS, 32);
            builder.addDnsServer(DNS_ADDRESS);

            // اضافه کردن مسیر IPهای مپ‌شده (فقط برای UDP)
            routedIps.clear();
            for (String ip : hostsMap.values()) {
                try {
                    builder.addRoute(ip, 32);
                    routedIps.add(ip);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            builder.setMtu(mtu);
            builder.setBlocking(true);
            vpnInterface = builder.establish();

            running = true;
            udpExecutor = Executors.newFixedThreadPool(10);
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

            byte[] srcIpBytes = new byte[4];
            buf.position(12);
            buf.get(srcIpBytes);
            InetAddress srcAddr = InetAddress.getByAddress(srcIpBytes);

            byte[] dstIpBytes = new byte[4];
            buf.get(dstIpBytes);
            InetAddress dstAddr = InetAddress.getByAddress(dstIpBytes);

            int srcPort = ((buf.get(headerLength) & 0xFF) << 8) | (buf.get(headerLength + 1) & 0xFF);
            int dstPort = ((buf.get(headerLength + 2) & 0xFF) << 8) | (buf.get(headerLength + 3) & 0xFF);

            // DNS به سمت DNS_ADDRESS
            if (protocol == 17 && dstAddr.getHostAddress().equals(DNS_ADDRESS) && dstPort == 53) {
                handleDns(packet, length, headerLength, srcAddr, srcPort, out);
            }
            // UDP به IPهای مپ‌شده
            else if (protocol == 17 && routedIps.contains(dstAddr.getHostAddress())) {
                handleUdp(packet, length, headerLength, srcAddr, srcPort, dstAddr, dstPort, out);
            }
            // بقیه ترافیک نادیده گرفته می‌شود
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleDns(byte[] packet, int length, int headerLength, InetAddress srcAddr, int srcPort, FileOutputStream out) {
        try {
            ByteBuffer buf = ByteBuffer.wrap(packet, headerLength, length - headerLength);
            int udpLength = buf.getShort(4) & 0xFFFF;
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
                // ارسال پاسخ با DatagramSocket به کلاینت
                DatagramSocket responseSocket = new DatagramSocket();
                protect(responseSocket);
                DatagramPacket responsePacket = new DatagramPacket(
                    dnsResponse, dnsResponse.length,
                    new InetSocketAddress(srcAddr, srcPort)
                );
                responseSocket.send(responsePacket);
                responseSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
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

    private void handleUdp(byte[] packet, int length, int headerLength, InetAddress srcAddr, int srcPort, InetAddress dstAddr, int dstPort, FileOutputStream out) {
        udpExecutor.execute(() -> {
            try {
                ByteBuffer udpBuf = ByteBuffer.wrap(packet, headerLength, length - headerLength);
                int udpLength = udpBuf.getShort(4) & 0xFFFF;
                int udpPayloadOffset = headerLength + 8;
                int udpPayloadLength = udpLength - 8;
                if (udpPayloadLength <= 0) return;

                byte[] udpPayload = new byte[udpPayloadLength];
                System.arraycopy(packet, udpPayloadOffset, udpPayload, 0, udpPayloadLength);

                DatagramSocket socket = new DatagramSocket();
                protect(socket);
                socket.setSoTimeout(10000);
                DatagramPacket request = new DatagramPacket(udpPayload, udpPayloadLength, dstAddr, dstPort);
                socket.send(request);

                byte[] responseBuffer = new byte[32767];
                DatagramPacket response = new DatagramPacket(responseBuffer, responseBuffer.length);
                socket.receive(response);

                byte[] responsePayload = new byte[response.getLength()];
                System.arraycopy(response.getData(), 0, responsePayload, 0, response.getLength());

                // ارسال پاسخ به کلاینت با DatagramSocket
                DatagramSocket responseSocket = new DatagramSocket();
                protect(responseSocket);
                DatagramPacket responsePacket = new DatagramPacket(
                    responsePayload, responsePayload.length,
                    new InetSocketAddress(srcAddr, srcPort)
                );
                responseSocket.send(responsePacket);
                responseSocket.close();
                socket.close();
            } catch (Exception e) {
                // timeout یا خطا
            }
        });
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
            while (pos < query.length && query[pos] != 0) response.put(query[pos++]);
            response.put((byte) 0);
            pos++;
            response.put(query[pos++]);
            response.put(query[pos++]);
            response.put(query[pos++]);
            response.put(query[pos++]);
            response.put((byte) 0xC0);
            response.put((byte) 0x0C);
            response.putShort((short) 1);
            response.putShort((short) 1);
            response.putInt(60);
            response.putShort((short) 4);
            String[] ipParts = ip.split("\\.");
            for (String part : ipParts) response.put((byte) Integer.parseInt(part));
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
        if (tunThread != null) { tunThread.interrupt(); tunThread = null; }
        if (udpExecutor != null) { udpExecutor.shutdownNow(); udpExecutor = null; }
        try { if (vpnInterface != null) { vpnInterface.close(); vpnInterface = null; } } catch (IOException e) { e.printStackTrace(); }
        stopForeground(true);
        stopSelf();
    }

    @Override
    public void onDestroy() { stopVpn(); super.onDestroy(); }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Gaming VPN", NotificationManager.IMPORTANCE_LOW);
            NotificationManager manager = getSystemService(NotificationManager.class);
            if (manager != null) manager.createNotificationChannel(channel);
        }
    }

    private Notification buildNotification(String text) {
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_IMMUTABLE);
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
        public SerializableHosts(HashMap<String, String> map) { this.map = map; }
    }
}
