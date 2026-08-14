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

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GamingVpnService extends VpnService {
    private static final String ACTION_START = "com.ippulse.scanner.START";
    private static final String ACTION_STOP = "com.ippulse.scanner.STOP";
    private static final String CHANNEL_ID = "gaming_vpn";
    private ParcelFileDescriptor vpnInterface;
    private String dns = "8.8.8.8";
    private int mtu = 1400;
    private HashMap<String, String> hostsMap = new HashMap<>();
    private ExecutorService dnsExecutor;
    private volatile boolean running = false;
    private DatagramSocket dnsSocket;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            if (ACTION_STOP.equals(intent.getAction())) {
                stopVpn();
                return START_NOT_STICKY;
            }
            dns = intent.getStringExtra("dns");
            mtu = intent.getIntExtra("mtu", 1400);
            // دریافت hosts map
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
            if (vpnInterface != null) {
                return;
            }
            Builder builder = new Builder();
            builder.setSession("Gaming VPN");
            builder.addAddress("10.0.0.2", 32);
            builder.addRoute("0.0.0.0", 0);
            // DNS server is set to 10.0.0.1 where our DNS proxy will listen
            builder.addDnsServer("10.0.0.1");
            builder.setMtu(mtu);
            builder.setBlocking(true);
            vpnInterface = builder.establish();

            // شروع DNS proxy
            running = true;
            startDnsProxy();
        } catch (Exception e) {
            e.printStackTrace();
            stopVpn();
        }
    }

    private void startDnsProxy() {
        dnsExecutor = Executors.newSingleThreadExecutor();
        dnsExecutor.execute(() -> {
            try {
                dnsSocket = new DatagramSocket(53, InetAddress.getByName("10.0.0.1"));
                byte[] buffer = new byte[1024];
                while (running && !dnsSocket.isClosed()) {
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    try {
                        dnsSocket.receive(packet);
                        handleDnsRequest(packet);
                    } catch (IOException e) {
                        if (running) e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void handleDnsRequest(DatagramPacket packet) {
        try {
            byte[] data = packet.getData();
            int length = packet.getLength();
            // استخراج دامنه از کوئری
            String domain = extractDomain(data, length);
            if (domain != null && hostsMap.containsKey(domain)) {
                String mappedIp = hostsMap.get(domain);
                byte[] response = buildDnsResponse(data, length, mappedIp);
                DatagramPacket responsePacket = new DatagramPacket(response, response.length,
                        packet.getAddress(), packet.getPort());
                dnsSocket.send(responsePacket);
            } else {
                // فوروارد به DNS بالا
                forwardDnsRequest(packet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void forwardDnsRequest(DatagramPacket packet) {
        try {
            DatagramSocket forwardSocket = new DatagramSocket();
            forwardSocket.setSoTimeout(5000);
            DatagramPacket request = new DatagramPacket(packet.getData(), packet.getLength(),
                    InetAddress.getByName(dns), 53);
            forwardSocket.send(request);
            byte[] responseBuffer = new byte[1024];
            DatagramPacket response = new DatagramPacket(responseBuffer, responseBuffer.length);
            forwardSocket.receive(response);
            DatagramPacket reply = new DatagramPacket(response.getData(), response.getLength(),
                    packet.getAddress(), packet.getPort());
            dnsSocket.send(reply);
            forwardSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String extractDomain(byte[] data, int length) {
        try {
            // skip header (12 bytes)
            int pos = 12;
            StringBuilder sb = new StringBuilder();
            while (pos < length) {
                int labelLength = data[pos] & 0xFF;
                if (labelLength == 0) break;
                if (labelLength > 63) {
                    // pointer to another location (simplify: ignore)
                    return null;
                }
                pos++;
                if (pos + labelLength > length) return null;
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

    private byte[] buildDnsResponse(byte[] query, int queryLength, String ip) {
        try {
            ByteBuffer response = ByteBuffer.allocate(1024);
            // کپی ID
            response.put(query[0]);
            response.put(query[1]);
            // Flags: response, recursion available
            response.put((byte) 0x81);
            response.put((byte) 0x80);
            // Questions: 1, Answers: 1
            response.putShort((short) 1);
            response.putShort((short) 1);
            response.putShort((short) 0);
            response.putShort((short) 0);

            // کپی بخش سوال از کوئری (شامل QNAME, QTYPE, QCLASS)
            int pos = 12;
            while (pos < queryLength && query[pos] != 0) {
                response.put(query[pos++]);
            }
            response.put((byte) 0); // null label
            response.put(query[++pos]); // QTYPE high
            response.put(query[++pos]); // QTYPE low
            response.put(query[++pos]); // QCLASS high
            response.put(query[++pos]); // QCLASS low

            // Answer: pointer to name, type A, class IN, TTL, RDLENGTH, RDATA
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
            return response.array();
        } catch (Exception e) {
            return null;
        }
    }

    private void stopVpn() {
        running = false;
        try {
            if (dnsSocket != null) {
                dnsSocket.close();
                dnsSocket = null;
            }
            if (dnsExecutor != null) {
                dnsExecutor.shutdownNow();
                dnsExecutor = null;
            }
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

    // کلاس قابل سریالایز برای ارسال HashMap
    public static class SerializableHosts implements java.io.Serializable {
        public HashMap<String, String> map;
        public SerializableHosts(HashMap<String, String> map) {
            this.map = map;
        }
    }
}
