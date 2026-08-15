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
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.util.Log;

import com.ippulse.scanner.localvpn.ByteBufferPool;
import com.ippulse.scanner.localvpn.Packet;
import com.ippulse.scanner.localvpn.TCPInput;
import com.ippulse.scanner.localvpn.TCPOutput;
import com.ippulse.scanner.localvpn.UDPInput;
import com.ippulse.scanner.localvpn.UDPOutput;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GamingVpnService extends VpnService {

    private static final String TAG = "GamingVpn";
    private static final String ACTION_START = "com.ippulse.scanner.START";
    private static final String ACTION_STOP = "com.ippulse.scanner.STOP";
    private static final String CHANNEL_ID = "gaming_vpn";
    private static final String VPN_ADDRESS = "10.0.0.2";
    private static final String VPN_DNS = "10.0.0.1";
    private static final String DEFAULT_UPSTREAM_DNS = "8.8.8.8";
    private static final int DNS_PORT = 53;

    private volatile boolean running;
    private int mtu = 1400;
    private String upstreamDns = DEFAULT_UPSTREAM_DNS;
    private ParcelFileDescriptor vpnInterface;

    private ConcurrentLinkedQueue<Packet> deviceToNetworkUDPQueue;
    private ConcurrentLinkedQueue<Packet> deviceToNetworkTCPQueue;
    private ConcurrentLinkedQueue<ByteBuffer> networkToDeviceQueue;

    private ExecutorService executorService;
    private Selector udpSelector;
    private Selector tcpSelector;

    private final HashMap<String, String> hostsMap = new HashMap<>();

    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            if (ACTION_STOP.equals(intent.getAction())) {
                stopVpn();
                return START_NOT_STICKY;
            }
            mtu = intent.getIntExtra("mtu", 1400);
            if (mtu < 1280 || mtu > 32767) mtu = 1400;

            String dnsValue = intent.getStringExtra("dns");
            if (dnsValue != null && !dnsValue.trim().isEmpty()) {
                upstreamDns = dnsValue.trim();
            }

            try {
                SerializableHosts serializedHosts = (SerializableHosts) intent.getSerializableExtra("hosts");
                synchronized (hostsMap) {
                    hostsMap.clear();
                    if (serializedHosts != null && serializedHosts.map != null) {
                        for (Map.Entry<String, String> entry : serializedHosts.map.entrySet()) {
                            String key = normalizeHost(entry.getKey());
                            String value = entry.getValue();
                            if (key != null && value != null && !value.trim().isEmpty()) {
                                hostsMap.put(key, value.trim());
                            }
                        }
                    }
                }
            } catch (Throwable e) {
                Log.e(TAG, "Failed loading hostsMap", e);
            }
        }

        createNotificationChannel();
        startForegroundCompatible();
        if (!running) startVpn();
        return START_STICKY;
    }

    private synchronized void startVpn() {
        if (running) return;

        try {
            // مهم: running را قبل از شروع workerها true کن
            running = true;

            deviceToNetworkUDPQueue = new ConcurrentLinkedQueue<>();
            deviceToNetworkTCPQueue = new ConcurrentLinkedQueue<>();
            networkToDeviceQueue = new ConcurrentLinkedQueue<>();

            udpSelector = Selector.open();
            tcpSelector = Selector.open();

            Builder builder = new Builder();
            builder.setSession("IPPulseScanner");
            builder.addAddress(VPN_ADDRESS, 32);
            builder.addRoute("0.0.0.0", 0);
            builder.addDnsServer(VPN_DNS);
            builder.setMtu(mtu);
            builder.setBlocking(true);
            try {
                builder.addDisallowedApplication(getPackageName());
            } catch (Exception e) {
                Log.w(TAG, "Could not exclude own package", e);
            }

            vpnInterface = builder.establish();
            if (vpnInterface == null) throw new IOException("establish() returned null");

            executorService = Executors.newFixedThreadPool(5);
            executorService.submit(new UDPInput(networkToDeviceQueue, udpSelector));
            executorService.submit(new UDPOutput(deviceToNetworkUDPQueue, udpSelector, this));
            executorService.submit(new TCPInput(networkToDeviceQueue, tcpSelector));
            executorService.submit(new TCPOutput(deviceToNetworkTCPQueue, networkToDeviceQueue, tcpSelector, this));
            executorService.submit(new VPNRunnable(vpnInterface.getFileDescriptor(),
                    deviceToNetworkUDPQueue, deviceToNetworkTCPQueue, networkToDeviceQueue));

            Log.i(TAG, "VPN started. MTU=" + mtu + " DNS=" + upstreamDns);
        } catch (Throwable e) {
            Log.e(TAG, "Error starting VPN", e);
            stopVpn();
        }
    }

    private final class VPNRunnable implements Runnable {
        private final FileDescriptor vpnFileDescriptor;
        private final ConcurrentLinkedQueue<Packet> udpQueue;
        private final ConcurrentLinkedQueue<Packet> tcpQueue;
        private final ConcurrentLinkedQueue<ByteBuffer> outputQueue;

        VPNRunnable(FileDescriptor vpnFileDescriptor,
                    ConcurrentLinkedQueue<Packet> udpQueue,
                    ConcurrentLinkedQueue<Packet> tcpQueue,
                    ConcurrentLinkedQueue<ByteBuffer> outputQueue) {
            this.vpnFileDescriptor = vpnFileDescriptor;
            this.udpQueue = udpQueue;
            this.tcpQueue = tcpQueue;
            this.outputQueue = outputQueue;
        }

        @Override
        public void run() {
            Log.i(TAG, "VPNRunnable started");

            FileChannel vpnInput = null;
            FileChannel vpnOutput = null;

            try {
                vpnInput = new FileInputStream(vpnFileDescriptor).getChannel();
                vpnOutput = new FileOutputStream(vpnFileDescriptor).getChannel();
            } catch (IOException e) {
                Log.e(TAG, "Could not open TUN channels", e);
                stopVpn();
                return;
            }

            ByteBuffer bufferToNetwork = null;
            boolean dataSent = true;

            try {
                while (!Thread.interrupted() && running) {
                    if (dataSent) {
                        bufferToNetwork = ByteBufferPool.acquire();
                    } else {
                        if (bufferToNetwork != null) {
                            bufferToNetwork.clear();
                        } else {
                            bufferToNetwork = ByteBufferPool.acquire();
                        }
                    }

                    int readBytes = vpnInput.read(bufferToNetwork);
                    if (readBytes > 0) {
                        dataSent = true;
                        bufferToNetwork.flip();

                        Packet packet;
                        try {
                            packet = new Packet(bufferToNetwork);
                        } catch (Throwable e) {
                            Log.e(TAG, "Packet parsing failed", e);
                            ByteBufferPool.release(bufferToNetwork);
                            bufferToNetwork = null;
                            continue;
                        }

                        if (packet.isUDP() && isDnsPacket(packet)) {
                            byte[] dnsPayload = extractCurrentPayload(packet.backingBuffer);
                            ByteBufferPool.release(packet.backingBuffer);
                            bufferToNetwork = null;
                            handleDns(packet, dnsPayload);
                        } else if (packet.isUDP()) {
                            udpQueue.offer(packet);
                            bufferToNetwork = null;
                        } else if (packet.isTCP()) {
                            tcpQueue.offer(packet);
                            bufferToNetwork = null;
                        } else {
                            Log.w(TAG, "Unknown IP protocol");
                            dataSent = false;
                        }
                    } else {
                        dataSent = false;
                    }

                    // Drain responses from workers to TUN
                    ByteBuffer bufferFromNetwork;
                    while ((bufferFromNetwork = outputQueue.poll()) != null) {
                        try {
                            bufferFromNetwork.flip();
                            while (bufferFromNetwork.hasRemaining()) {
                                vpnOutput.write(bufferFromNetwork);
                            }
                        } finally {
                            ByteBufferPool.release(bufferFromNetwork);
                        }
                    }

                    if (!dataSent && outputQueue.isEmpty()) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            break;
                        }
                    }
                }
            } catch (IOException e) {
                if (running) Log.e(TAG, "VPN I/O error", e);
            } finally {
                if (bufferToNetwork != null) {
                    try { ByteBufferPool.release(bufferToNetwork); } catch (Throwable ignored) {}
                }
                try { vpnInput.close(); } catch (Exception ignored) {}
                try { vpnOutput.close(); } catch (Exception ignored) {}
                Log.i(TAG, "VPNRunnable stopped");
            }
        }
    }

    private boolean isDnsPacket(Packet packet) {
        try {
            return packet.ip4Header != null &&
                    packet.udpHeader != null &&
                    DNS_PORT == packet.udpHeader.destinationPort &&
                    VPN_DNS.equals(packet.ip4Header.destinationAddress.getHostAddress());
        } catch (Throwable e) {
            return false;
        }
    }

    private byte[] extractCurrentPayload(ByteBuffer buffer) {
        ByteBuffer duplicate = buffer.duplicate();
        int length = duplicate.remaining();
        byte[] payload = new byte[length];
        duplicate.get(payload);
        return payload;
    }

    private void handleDns(Packet request, byte[] query) {
        new Thread(() -> {
            try {
                String domain = extractDnsQuestionName(query);
                if (domain == null) {
                    forwardDns(request, query);
                    return;
                }
                String mappedIp = hostsMap.get(normalizeHost(domain));
                if (mappedIp != null && isIpv4(mappedIp)) {
                    byte[] dnsResponse = buildMappedDnsResponse(query, mappedIp);
                    enqueueDnsResponse(request, dnsResponse);
                    Log.d(TAG, "DNS mapped: " + domain + " -> " + mappedIp);
                } else {
                    forwardDns(request, query);
                }
            } catch (Throwable e) {
                Log.e(TAG, "DNS handling error", e);
            }
        }).start();
    }

    private void forwardDns(Packet request, byte[] query) {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            protect(socket);
            socket.setSoTimeout(3000);
            InetAddress upstream = InetAddress.getByName(upstreamDns);
            DatagramPacket outPacket = new DatagramPacket(query, query.length, upstream, DNS_PORT);
            socket.send(outPacket);
            byte[] responseBuffer = new byte[1024];
            DatagramPacket inPacket = new DatagramPacket(responseBuffer, responseBuffer.length);
            socket.receive(inPacket);
            byte[] dnsResponse = new byte[inPacket.getLength()];
            System.arraycopy(responseBuffer, 0, dnsResponse, 0, inPacket.getLength());
            enqueueDnsResponse(request, dnsResponse);
        } catch (Exception e) {
            Log.e(TAG, "DNS forward failed", e);
        } finally {
            if (socket != null) socket.close();
        }
    }

    private void enqueueDnsResponse(Packet requestPacket, byte[] dnsPayload) {
        try {
            ByteBuffer response = buildUdpPacket(
                requestPacket.ip4Header.destinationAddress.getHostAddress(), DNS_PORT,
                requestPacket.ip4Header.sourceAddress.getHostAddress(), requestPacket.udpHeader.sourcePort,
                dnsPayload);
            synchronized (networkToDeviceQueue) {
                networkToDeviceQueue.offer(response);
            }
        } catch (Exception e) {
            Log.e(TAG, "enqueueDnsResponse failed", e);
        }
    }

    private ByteBuffer buildUdpPacket(String srcIp, int srcPort, String dstIp, int dstPort, byte[] payload) throws Exception {
        int udpLen = 8 + payload.length;
        int totalLen = 20 + udpLen;
        ByteBuffer res = ByteBuffer.allocate(totalLen);
        res.put((byte) 0x45);
        res.put((byte) 0x00);
        res.putShort((short) totalLen);
        res.putShort((short) 0);
        res.putShort((short) 0);
        res.put((byte) 64);
        res.put((byte) 17);
        res.putShort((short) 0);
        res.put(InetAddress.getByName(srcIp).getAddress());
        res.put(InetAddress.getByName(dstIp).getAddress());
        res.putShort((short) srcPort);
        res.putShort((short) dstPort);
        res.putShort((short) udpLen);
        res.putShort((short) 0);
        res.put(payload);
        byte[] array = res.array();
        int ipChecksum = calculateChecksum(array, 0, 20);
        array[10] = (byte) (ipChecksum >> 8);
        array[11] = (byte) (ipChecksum & 0xFF);
        return ByteBuffer.wrap(array);
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

    private String extractDnsQuestionName(byte[] dnsPayload) {
        try {
            StringBuilder domain = new StringBuilder();
            int pos = 12;
            while (pos < dnsPayload.length && dnsPayload[pos] != 0) {
                int len = dnsPayload[pos++];
                if (len > 63 || pos + len > dnsPayload.length) return null;
                if (domain.length() > 0) domain.append('.');
                domain.append(new String(dnsPayload, pos, len, java.nio.charset.StandardCharsets.UTF_8));
                pos += len;
            }
            return domain.length() > 0 ? domain.toString() : null;
        } catch (Exception e) {
            return null;
        }
    }

    private byte[] buildMappedDnsResponse(byte[] query, String ip) {
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

    private boolean isIpv4(String ip) {
        return ip.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
    }

    private String normalizeHost(String host) {
        if (host == null) return null;
        host = host.trim().toLowerCase(Locale.US);
        while (host.endsWith(".")) host = host.substring(0, host.length() - 1);
        return host;
    }

    private synchronized void stopVpn() {
        Log.i(TAG, "Stopping VPN");
        running = false;
        if (executorService != null) {
            executorService.shutdownNow();
            executorService = null;
        }
        try { if (vpnInterface != null) vpnInterface.close(); } catch (IOException ignored) {}
        vpnInterface = null;
        deviceToNetworkUDPQueue = null;
        deviceToNetworkTCPQueue = null;
        networkToDeviceQueue = null;
        stopForeground(true);
        stopSelf();
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
            Log.e(TAG, "startForeground failed", e);
        }
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
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
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
