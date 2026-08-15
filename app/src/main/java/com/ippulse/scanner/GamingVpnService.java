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

import com.ippulse.scanner.localvpn.ByteBufferPool;
import com.ippulse.scanner.localvpn.Packet;
import com.ippulse.scanner.localvpn.TCPInput;
import com.ippulse.scanner.localvpn.TCPOutput;
import com.ippulse.scanner.localvpn.UDPInput;
import com.ippulse.scanner.localvpn.UDPOutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GamingVpnService extends VpnService implements Runnable {
    private static final String TAG = "GamingVpn";
    private static final String ACTION_START = "com.ippulse.scanner.START";
    private static final String ACTION_STOP = "com.ippulse.scanner.STOP";
    private static final String CHANNEL_ID = "gaming_vpn";

    private ParcelFileDescriptor vpnInterface;
    private FileInputStream tunIn;
    private FileOutputStream tunOut;

    private HashMap<String, String> hostsMap = new HashMap<>();
    private String dns = "8.8.8.8";
    private int currentMtu = 1400;
    private volatile boolean running = false;

    private ConcurrentLinkedQueue<Packet> deviceToNetworkUDPQueue;
    private ConcurrentLinkedQueue<Packet> deviceToNetworkTCPQueue;
    private ConcurrentLinkedQueue<ByteBuffer> networkToDeviceQueue;

    private ExecutorService executorService;
    private Selector udpSelector;
    private Selector tcpSelector;
    private Thread tunWriterThread;

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
            startForeground(1, notification);
        }
    }

    private void startVpn() {
        try {
            if (vpnInterface != null) return;
            running = true;

            // 1. Establish Full Tunnel VPN
            Builder builder = new Builder();
            builder.setSession("Gaming VPN");
            builder.addAddress("10.0.0.2", 32);
            builder.addRoute("0.0.0.0", 0); // Full Tunnel
            builder.addDnsServer("10.0.0.1"); // Virtual DNS IP
            builder.setMtu(currentMtu);
            builder.setBlocking(true);

            vpnInterface = builder.establish();
            tunIn = new FileInputStream(vpnInterface.getFileDescriptor());
            tunOut = new FileOutputStream(vpnInterface.getFileDescriptor());

            // 2. Initialize LocalVPN Queues and Selectors
            deviceToNetworkUDPQueue = new ConcurrentLinkedQueue<>();
            deviceToNetworkTCPQueue = new ConcurrentLinkedQueue<>();
            networkToDeviceQueue = new ConcurrentLinkedQueue<>();

            udpSelector = Selector.open();
            tcpSelector = Selector.open();

            // 3. Start LocalVPN Core Threads
            executorService = Executors.newFixedThreadPool(5);
            executorService.submit(new UDPInput(networkToDeviceQueue, udpSelector));
            // اصلاح شده: constructor صحیح UDPOutput
            executorService.submit(new UDPOutput(deviceToNetworkUDPQueue, udpSelector, this));
            executorService.submit(new TCPInput(networkToDeviceQueue, tcpSelector));
            // اصلاح شده: constructor صحیح TCPOutput
            executorService.submit(new TCPOutput(deviceToNetworkTCPQueue, networkToDeviceQueue, tcpSelector, this));

            // 4. Start TUN Reader (this class) and Writer Threads
            executorService.submit(this);
            startTunWriter();

        } catch (Exception e) {
            Log.e(TAG, "Error starting VPN", e);
            stopVpn();
        }
    }

    // =====================================
    // TUN READER (Reads from Android OS)
    // =====================================
    @Override
    public void run() {
        FileChannel tunChannel = tunIn.getChannel();
        while (running && !Thread.interrupted()) {
            ByteBuffer buffer = ByteBufferPool.acquire();
            try {
                int read = tunChannel.read(buffer);
                if (read > 0) {
                    buffer.limit(read);
                    byte[] packetBytes = buffer.array();
                    int ipHeaderLen = (packetBytes[0] & 0x0F) * 4;
                    int protocol = packetBytes[9] & 0xFF;

                    if (protocol == 1) {
                        // Fast Path: ICMP Pings
                        handleIcmpPacket(buffer, read, ipHeaderLen);
                    } else if (protocol == 17) {
                        // Fast Path: DNS Intercept
                        int dstPort = ((packetBytes[ipHeaderLen + 2] & 0xFF) << 8) | (packetBytes[ipHeaderLen + 3] & 0xFF);
                        if (dstPort == 53) {
                            handleDnsRequest(packetBytes, read, ipHeaderLen);
                            ByteBufferPool.release(buffer);
                        } else {
                            // Standard UDP -> LocalVPN
                            buffer.position(0);
                            Packet packet = new Packet(buffer);
                            deviceToNetworkUDPQueue.offer(packet);
                            udpSelector.wakeup();
                        }
                    } else if (protocol == 6) {
                        // Standard TCP -> LocalVPN
                        buffer.position(0);
                        Packet packet = new Packet(buffer);
                        deviceToNetworkTCPQueue.offer(packet);
                        tcpSelector.wakeup();
                    } else {
                        ByteBufferPool.release(buffer);
                    }
                } else {
                    ByteBufferPool.release(buffer);
                }
            } catch (Exception e) {
                ByteBufferPool.release(buffer);
                if (running) Log.e(TAG, "TUN Read error", e);
                break;
            }
        }
    }

    // =====================================
    // TUN WRITER (Writes to Android OS)
    // =====================================
    private void startTunWriter() {
        tunWriterThread = new Thread(() -> {
            FileChannel tunChannel = tunOut.getChannel();
            while (running && !Thread.interrupted()) {
                ByteBuffer buffer = networkToDeviceQueue.poll();
                if (buffer != null) {
                    try {
                        buffer.position(0); // Ensure cursor is at start
                        while (buffer.hasRemaining()) {
                            tunChannel.write(buffer);
                        }
                    } catch (Exception e) {
                        Log.e(TAG, "TUN Write error", e);
                    } finally {
                        ByteBufferPool.release(buffer);
                    }
                } else {
                    try { Thread.sleep(10); } catch (InterruptedException e) { break; }
                }
            }
        }, "TunWriterThread");
        tunWriterThread.start();
    }

    // =====================================
    // FAST PATH: ICMP (Ping) Responder
    // =====================================
    private void handleIcmpPacket(ByteBuffer buffer, int length, int ipHeaderLen) {
        byte[] packet = buffer.array();
        int icmpType = packet[ipHeaderLen] & 0xFF;

        if (icmpType == 8) { // Echo Request
            // Swap Source & Dest IP
            for (int i = 0; i < 4; i++) {
                byte tmp = packet[12 + i];
                packet[12 + i] = packet[16 + i];
                packet[16 + i] = tmp;
            }

            // Change Type to 0 (Echo Reply) and clear checksum
            packet[ipHeaderLen] = 0;
            packet[ipHeaderLen + 2] = 0;
            packet[ipHeaderLen + 3] = 0;

            // Recalculate ICMP Checksum
            int icmpLen = length - ipHeaderLen;
            int checksum = calculateChecksum(packet, ipHeaderLen, icmpLen);
            packet[ipHeaderLen + 2] = (byte) (checksum >> 8);
            packet[ipHeaderLen + 3] = (byte) (checksum & 0xFF);

            // Send back to device
            buffer.position(0);
            buffer.limit(length);
            networkToDeviceQueue.offer(buffer);
        } else {
            ByteBufferPool.release(buffer);
        }
    }

    // =====================================
    // FAST PATH: DNS Proxy
    // =====================================
    private void handleDnsRequest(byte[] rawPacket, int length, int ipHeaderLen) {
        int srcPort = ((rawPacket[ipHeaderLen] & 0xFF) << 8) | (rawPacket[ipHeaderLen + 1] & 0xFF);
        int dstPort = ((rawPacket[ipHeaderLen + 2] & 0xFF) << 8) | (rawPacket[ipHeaderLen + 3] & 0xFF);

        byte[] srcIp = new byte[4], dstIp = new byte[4];
        System.arraycopy(rawPacket, 12, srcIp, 0, 4);
        System.arraycopy(rawPacket, 16, dstIp, 0, 4);

        int payloadLen = length - ipHeaderLen - 8;
        if (payloadLen <= 0) return;
        byte[] dnsPayload = new byte[payloadLen];
        System.arraycopy(rawPacket, ipHeaderLen + 8, dnsPayload, 0, payloadLen);

        new Thread(() -> {
            try {
                String domain = extractDomain(dnsPayload);
                if (hostsMap.containsKey(domain)) {
                    byte[] responsePayload = buildDnsResponse(dnsPayload, hostsMap.get(domain));
                    injectUdpToTun(dstIp, dstPort, srcIp, srcPort, responsePayload);
                } else {
                    DatagramSocket dnsSocket = new DatagramSocket();
                    protect(dnsSocket); // CRITICAL: Exclude socket from VPN loop

                    DatagramPacket outPacket = new DatagramPacket(dnsPayload, dnsPayload.length, InetAddress.getByName(dns), 53);
                    dnsSocket.send(outPacket);

                    byte[] recvBuf = new byte[1024];
                    DatagramPacket inPacket = new DatagramPacket(recvBuf, recvBuf.length);
                    dnsSocket.setSoTimeout(3000);
                    dnsSocket.receive(inPacket);

                    byte[] actualResponse = new byte[inPacket.getLength()];
                    System.arraycopy(recvBuf, 0, actualResponse, 0, inPacket.getLength());

                    // Notice IPs/Ports are swapped to send reply back to the OS client
                    injectUdpToTun(dstIp, dstPort, srcIp, srcPort, actualResponse);
                    dnsSocket.close();
                }
            } catch (Exception e) {
                Log.e(TAG, "DNS error", e);
            }
        }).start();
    }

    private void injectUdpToTun(byte[] srcIp, int srcPort, byte[] dstIp, int dstPort, byte[] payload) {
        try {
            int udpLen = 8 + payload.length;
            int totalLen = 20 + udpLen;

            ByteBuffer res = ByteBufferPool.acquire();
            res.position(0);
            res.limit(totalLen);

            // IPv4 Header
            res.put((byte) 0x45); res.put((byte) 0x00);
            res.putShort((short) totalLen);
            res.putShort((short) 0); res.putShort((short) 0);
            res.put((byte) 64); res.put((byte) 17); // TTL 64, Proto UDP
            res.putShort((short) 0); // Clear Checksum
            res.put(srcIp); res.put(dstIp);

            // UDP Header
            res.putShort((short) srcPort); res.putShort((short) dstPort);
            res.putShort((short) udpLen); res.putShort((short) 0);

            // Payload
            res.put(payload);

            // Calculate IPv4 Checksum
            byte[] array = res.array();
            int ipChecksum = calculateChecksum(array, 0, 20);
            array[10] = (byte) (ipChecksum >> 8);
            array[11] = (byte) (ipChecksum & 0xFF);

            res.position(0);
            res.limit(totalLen);
            networkToDeviceQueue.offer(res); // Hand off to TunWriterThread
        } catch (Exception e) {
            Log.e(TAG, "Failed to inject UDP", e);
        }
    }

    // =====================================
    // UTILS & LIFECYCLE
    // =====================================
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
        if (executorService != null) {
            executorService.shutdownNow();
            executorService = null;
        }
        if (tunWriterThread != null) {
            tunWriterThread.interrupt();
            tunWriterThread = null;
        }
        try { if (udpSelector != null) udpSelector.close(); } catch (Exception ignored) {}
        try { if (tcpSelector != null) tcpSelector.close(); } catch (Exception ignored) {}
        try { if (tunIn != null) tunIn.close(); } catch (Exception ignored) {}
        try { if (tunOut != null) tunOut.close(); } catch (Exception ignored) {}
        try { if (vpnInterface != null) vpnInterface.close(); } catch (Exception ignored) {}

        ByteBufferPool.clear();
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
