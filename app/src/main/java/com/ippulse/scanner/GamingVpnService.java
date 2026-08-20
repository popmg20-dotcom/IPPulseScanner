package com.ippulse.scanner;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.net.VpnService;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Environment;
import android.provider.MediaStore;
import android.content.ContentValues;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import com.ippulse.scanner.localvpn.ByteBufferPool;
import com.ippulse.scanner.localvpn.Packet;
import com.ippulse.scanner.localvpn.TCPInput;
import com.ippulse.scanner.localvpn.TCPOutput;
import com.ippulse.scanner.localvpn.UDPInput;
import com.ippulse.scanner.localvpn.UDPOutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
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

    private final Object debugLock = new Object();
    private java.io.File debugFile;

    private void initDebugLog() {
        try {
            java.io.File dir = getExternalFilesDir(null);
            if (dir == null) {
                dir = getFilesDir();
            }
            debugFile = new java.io.File(dir, "vpn_debug.log");

            synchronized (debugLock) {
                java.io.FileOutputStream fos =
                        new java.io.FileOutputStream(debugFile, false);
                fos.write(("=== IPPulseScanner VPN DEBUG ===\n").getBytes("UTF-8"));
                fos.flush();
                fos.close();
            }

            debug("DEBUG LOG INITIALIZED: " + debugFile.getAbsolutePath());
        } catch (Exception e) {
            Log.e(TAG, "debug init failed", e);
        }
    }

    public void debug(String msg) {
        String line = System.currentTimeMillis()
                + " | " + Thread.currentThread().getName()
                + " | " + msg + "\n";

        Log.i(TAG, line.trim());

        synchronized (debugLock) {
            try {
                if (debugFile == null) {
                    initDebugLog();
                }

                if (debugFile != null) {
                    java.io.FileOutputStream fos =
                            new java.io.FileOutputStream(debugFile, true);
                    fos.write(line.getBytes("UTF-8"));
                    fos.flush();
                    fos.close();
                }
            } catch (Exception e) {
                Log.e(TAG, "debug write failed", e);
            }
        }
    }

    private void copyDebugLogToDownloads() {
        if (debugFile == null || !debugFile.exists()) {
            return;
        }

        try {
            if (Build.VERSION.SDK_INT >= 29) {
                ContentValues values = new ContentValues();
                values.put(MediaStore.Downloads.DISPLAY_NAME,
                        "IPPulseScanner_vpn_debug.txt");
                values.put(MediaStore.Downloads.MIME_TYPE,
                        "text/plain");
                values.put(MediaStore.Downloads.RELATIVE_PATH,
                        Environment.DIRECTORY_DOWNLOADS
                                + "/IPPulseScanner");

                ContentResolver resolver = getContentResolver();

                Uri uri = resolver.insert(
                        MediaStore.Downloads.EXTERNAL_CONTENT_URI,
                        values);

                if (uri != null) {
                    java.io.OutputStream out =
                            resolver.openOutputStream(uri);

                    java.io.FileInputStream in =
                            new java.io.FileInputStream(debugFile);

                    byte[] buf = new byte[8192];
                    int n;

                    while ((n = in.read(buf)) != -1) {
                        out.write(buf, 0, n);
                    }

                    out.flush();
                    out.close();
                    in.close();

                    debug("DEBUG LOG COPIED TO DOWNLOADS: " + uri);
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "copy debug log failed", e);
            debug("COPY DEBUG LOG FAILED: " + e);
        }
    }


    private volatile Network upstreamNetwork;
    private ConnectivityManager connectivityManager;
    private ConnectivityManager.NetworkCallback networkCallback;


    private ConcurrentLinkedQueue<Packet> deviceToNetworkUDPQueue;
    private ConcurrentLinkedQueue<Packet> deviceToNetworkTCPQueue;
    private ConcurrentLinkedQueue<ByteBuffer> networkToDeviceQueue;

    private Selector udpSelector;
    private Selector tcpSelector;
    private ExecutorService executorService;

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
        if (!running) startVpn();
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

    private void startUpstreamNetworkMonitor() {
        connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager == null) {
            Log.w(TAG, "ConnectivityManager unavailable");
            return;
        }

        try {
            Network active = connectivityManager.getActiveNetwork();
            if (active != null) {
                NetworkCapabilities caps =
                        connectivityManager.getNetworkCapabilities(active);

                if (isUsablePhysicalNetwork(caps)) {
                    upstreamNetwork = active;
                    Log.i(TAG, "Initial upstream network: " + active);
                }
            }
        } catch (Exception e) {
            Log.w(TAG, "Initial network lookup failed", e);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            NetworkRequest request = new NetworkRequest.Builder()
                    .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                    .addCapability(NetworkCapabilities.NET_CAPABILITY_NOT_VPN)
                    .build();

            networkCallback = new ConnectivityManager.NetworkCallback() {
                @Override
                public void onAvailable(Network network) {
                    try {
                        NetworkCapabilities caps =
                                connectivityManager.getNetworkCapabilities(network);

                        if (isUsablePhysicalNetwork(caps)) {
                            upstreamNetwork = network;
                            Log.i(TAG, "Upstream network available: " + network);
                        }
                    } catch (Exception e) {
                        Log.w(TAG, "Network callback error", e);
                    }
                }

                @Override
                public void onLost(Network network) {
                    if (network.equals(upstreamNetwork)) {
                        upstreamNetwork = null;
                        Log.w(TAG, "Upstream network lost: " + network);
                    }
                }
            };

            try {
                connectivityManager.registerNetworkCallback(
                        request, networkCallback);
            } catch (Exception e) {
                Log.w(TAG, "registerNetworkCallback failed", e);
            }
        }
    }

    private boolean isUsablePhysicalNetwork(NetworkCapabilities caps) {
        if (caps == null) return false;

        if (!caps.hasCapability(
                NetworkCapabilities.NET_CAPABILITY_INTERNET)) {
            return false;
        }

        if (!caps.hasCapability(
                NetworkCapabilities.NET_CAPABILITY_NOT_VPN)) {
            return false;
        }

        return caps.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                || caps.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                || caps.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
                || caps.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH);
    }

    public boolean protectOrBind(Socket socket) {
        if (socket == null) return false;

        Network network = upstreamNetwork;

        if (network != null) {
            try {
                network.bindSocket(socket);
                debug("NETWORK.bindSocket(TCP) SUCCESS");
                return true;
            } catch (IOException e) {
                Log.w(TAG, "bindSocket(TCP) failed; fallback to protect()", e);
            }
        }

        boolean result = protect(socket);
        debug("VpnService.protect(TCP)=" + result);
        return result;
    }

    public boolean protectOrBind(DatagramSocket socket) {
        if (socket == null) return false;

        Network network = upstreamNetwork;

        if (network != null) {
            try {
                network.bindSocket(socket);
                return true;
            } catch (IOException e) {
                Log.w(TAG, "bindSocket(UDP) failed; fallback to protect()", e);
            }
        }

        return protect(socket);
    }

    private void stopUpstreamNetworkMonitor() {
        if (connectivityManager != null && networkCallback != null) {
            try {
                connectivityManager.unregisterNetworkCallback(networkCallback);
            } catch (Exception ignored) {
            }
        }

        networkCallback = null;
        upstreamNetwork = null;
    }

    private void startVpn() {
        initDebugLog();
        debug("startVpn() ENTER");
        if (running) return;
        try {
            deviceToNetworkUDPQueue = new ConcurrentLinkedQueue<>();
            deviceToNetworkTCPQueue = new ConcurrentLinkedQueue<>();
            networkToDeviceQueue = new ConcurrentLinkedQueue<>();
            udpSelector = Selector.open();
            tcpSelector = Selector.open();

            Builder builder = new Builder();
            builder.setSession("Gaming VPN");
            builder.addAddress(VPN_ADDRESS, 32);
            builder.addRoute("0.0.0.0", 0); // Full Tunnel
            builder.addDnsServer(DNS_ADDRESS);
            builder.setMtu(currentMtu);
            // IMPORTANT: keep this non-blocking (it's also the platform default).
            // TunRunnable below does read() -> dispatch -> drain networkToDeviceQueue -> write()
            // on a single thread. If the fd is blocking, read() sits forever waiting for the
            // app to send more data, while replies already queued in networkToDeviceQueue
            // (e.g. a TCP SYN-ACK) never get flushed back - every connection deadlocks.
            builder.setBlocking(false);
            builder.addDisallowedApplication(getPackageName());

            debug("START UPSTREAM NETWORK MONITOR");
            startUpstreamNetworkMonitor();

            debug("ABOUT TO ESTABLISH VPN");
            vpnInterface = builder.establish();
            debug("VPN ESTABLISHED: " + (vpnInterface != null));
            if (vpnInterface == null) throw new IOException("establish() failed");

            tunIn = new FileInputStream(vpnInterface.getFileDescriptor());
            tunOut = new FileOutputStream(vpnInterface.getFileDescriptor());

            executorService = Executors.newFixedThreadPool(5);
            debug("WORKER EXECUTOR CREATED");
            executorService.submit(new UDPInput(networkToDeviceQueue, udpSelector));
            executorService.submit(new UDPOutput(deviceToNetworkUDPQueue, udpSelector, this));
            executorService.submit(new TCPInput(networkToDeviceQueue, tcpSelector, currentMtu));
            executorService.submit(new TCPOutput(deviceToNetworkTCPQueue, networkToDeviceQueue, tcpSelector, this));
            executorService.submit(new TunRunnable());

            running = true;
            debug("VPN RUNNING: MTU=" + currentMtu);
            Log.i(TAG, "VPN started with full tunnel, MTU=" + currentMtu);
        } catch (Exception e) {
            Log.e(TAG, "Error starting VPN", e);
            Toast.makeText(getApplicationContext(), "VPN error: " + e.getClass().getSimpleName() + ": " + e.getMessage(), Toast.LENGTH_LONG).show();
            stopVpn();
        }
    }

    private final class TunRunnable implements Runnable {
        @Override
        public void run() {
            FileChannel inputChannel = tunIn.getChannel();
            FileChannel outputChannel = tunOut.getChannel();
            ByteBuffer buffer = ByteBufferPool.acquire();
            boolean dataSent = true;
            boolean[] firstRead = {false};
            boolean[] firstWrite = {false};

            while (running && !Thread.interrupted()) {
                try {
                    if (dataSent) {
                        buffer.clear();
                    } else {
                        dataSent = true;
                    }
                    int read = inputChannel.read(buffer);
                    if (read > 0) {
                        debug("TUN READ bytes=" + read);
                        if (!firstRead[0]) {
                            firstRead[0] = true;
                            final int rlen = read;
                            new android.os.Handler(getMainLooper()).post(() -> Toast.makeText(getApplicationContext(), "TUN alive: first packet " + rlen + " bytes", Toast.LENGTH_LONG).show());
                        }
                        buffer.flip();
                        boolean bufferConsumed = false;
                        try {
                            Packet packet = new Packet(buffer);
                            if (packet.isUDP() && isDnsPacket(packet)) {
                                debug("TUN PACKET UDP DNS");
                                handleDns(packet);
                            } else if (packet.isUDP()) {
                                debug("TUN PACKET UDP -> QUEUE");
                                deviceToNetworkUDPQueue.offer(packet);
                                bufferConsumed = true;
                            } else if (packet.isTCP()) {
                                debug("TUN PACKET TCP -> QUEUE");
                                deviceToNetworkTCPQueue.offer(packet);
                                bufferConsumed = true;
                            }
                        } catch (Exception parseErr) {
                            Log.w(TAG, "Skipped unparseable packet", parseErr);
                            debug("PACKET PARSE ERROR: " + parseErr);
                        }
                        if (!bufferConsumed) {
                            ByteBufferPool.release(buffer);
                        }
                        buffer = ByteBufferPool.acquire();
                    } else {
                        dataSent = false;
                    }

                    ByteBuffer outBuffer;
                    while ((outBuffer = networkToDeviceQueue.poll()) != null) {
                        debug("TUN WRITE RESPONSE bytes=" + outBuffer.limit());
                        if (!firstWrite[0]) {
                            firstWrite[0] = true;
                            new android.os.Handler(getMainLooper()).post(() -> Toast.makeText(getApplicationContext(), "TUN alive: first response written back", Toast.LENGTH_LONG).show());
                        }
                        outBuffer.flip();
                        try {
                            while (outBuffer.hasRemaining()) {
                                outputChannel.write(outBuffer);
                            }
                        } catch (IOException writeErr) {
                            Log.w(TAG, "Dropped oversized/invalid outgoing packet", writeErr);
                        }
                        ByteBufferPool.release(outBuffer);
                    }

                    if (!dataSent && networkToDeviceQueue.isEmpty()) {
                        Thread.sleep(10);
                    }
                } catch (Exception e) {
                    if (running) {
                        Log.e(TAG, "TUN loop error", e);
                        final String msg = "TUN error: " + e.getClass().getSimpleName() + ": " + e.getMessage();
                        new android.os.Handler(getMainLooper()).post(() -> Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show());
                    }
                    break;
                }
            }
            ByteBufferPool.release(buffer);
        }
    }

    private boolean isDnsPacket(Packet packet) {
        return packet.udpHeader != null && packet.ip4Header != null &&
                packet.udpHeader.destinationPort == 53 &&
                packet.ip4Header.destinationAddress.getHostAddress().equals(DNS_ADDRESS);
    }

    private void handleDns(final Packet packet) {
        try {
            ByteBuffer duplicate = packet.backingBuffer.duplicate();
            int payloadLen = packet.backingBuffer.limit() - packet.backingBuffer.position();
            if (payloadLen <= 0) return;
            final byte[] dnsQuery = new byte[payloadLen];
            duplicate.get(dnsQuery);

            String domain = extractDomain(dnsQuery);
            final InetAddress srcAddr = packet.ip4Header.sourceAddress;
            final int srcPort = packet.udpHeader.sourcePort;

            if (domain != null && hostsMap.containsKey(domain)) {
                byte[] response = buildDnsResponse(dnsQuery, hostsMap.get(domain));
                if (response != null) {
                    ByteBuffer output = buildUdpPacket(DNS_ADDRESS, 53, srcAddr, srcPort, response);
                    networkToDeviceQueue.offer(output);
                }
            } else {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        byte[] response = forwardDns(dnsQuery);
                        if (response != null) {
                            try {
                                ByteBuffer output = buildUdpPacket(DNS_ADDRESS, 53, srcAddr, srcPort, response);
                                networkToDeviceQueue.offer(output);
                            } catch (Exception e) {
                                Log.e(TAG, "Async DNS build error", e);
                            }
                        }
                    }
                }, "dns-forward").start();
            }
        } catch (Exception e) {
            Log.e(TAG, "DNS handling error", e);
        }
    }

    private byte[] forwardDns(byte[] query) {
        try {
            DatagramSocket socket = new DatagramSocket();
            protect(socket);
            socket.setSoTimeout(3000);
            DatagramPacket request = new DatagramPacket(query, query.length, InetAddress.getByName(dns), 53);
            socket.send(request);
            byte[] buffer = new byte[1024];
            DatagramPacket response = new DatagramPacket(buffer, buffer.length);
            socket.receive(response);
            byte[] data = new byte[response.getLength()];
            System.arraycopy(response.getData(), 0, data, 0, data.length);
            socket.close();
            return data;
        } catch (Exception e) {
            return null;
        }
    }

    private ByteBuffer buildUdpPacket(String srcIp, int srcPort, InetAddress dstAddr, int dstPort, byte[] payload) throws Exception {
        int udpLength = 8 + payload.length;
        int totalLength = 20 + udpLength;
        ByteBuffer packet = ByteBuffer.allocate(totalLength);
        packet.put((byte) 0x45);
        packet.put((byte) 0x00);
        packet.putShort((short) totalLength);
        packet.putShort((short) 0);
        packet.putShort((short) 0);
        packet.put((byte) 64);
        packet.put((byte) 17);
        packet.putShort((short) 0);
        packet.put(InetAddress.getByName(srcIp).getAddress());
        packet.put(dstAddr.getAddress());
        packet.putShort((short) srcPort);
        packet.putShort((short) dstPort);
        packet.putShort((short) udpLength);
        packet.putShort((short) 0);
        packet.put(payload);
        byte[] array = packet.array();
        int ipChecksum = calculateIpChecksum(array, 0, 20);
        array[10] = (byte) (ipChecksum >> 8);
        array[11] = (byte) (ipChecksum & 0xFF);
        return ByteBuffer.wrap(array);
    }

    private int calculateIpChecksum(byte[] data, int offset, int length) {
        long sum = 0;
        for (int i = offset; i < offset + length; i += 2) {
            int word = ((data[i] & 0xFF) << 8);
            if (i + 1 < offset + length) word |= (data[i + 1] & 0xFF);
            sum += word;
        }
        while ((sum >> 16) > 0) sum = (sum & 0xFFFF) + (sum >> 16);
        return (int) (~sum & 0xFFFF);
    }

    private String extractDomain(byte[] dnsPayload) {
        StringBuilder domain = new StringBuilder();
        int pos = 12;
        while (pos < dnsPayload.length && dnsPayload[pos] != 0) {
            int len = dnsPayload[pos++] & 0xFF;
            if (len == 0) break;
            if (domain.length() > 0) domain.append('.');
            domain.append(new String(dnsPayload, pos, len));
            pos += len;
        }
        return domain.toString().toLowerCase();
    }

    private byte[] buildDnsResponse(byte[] query, String ip) {
        java.nio.ByteBuffer res = java.nio.ByteBuffer.allocate(512);
        res.put(query[0]); res.put(query[1]);
        res.put((byte) 0x81); res.put((byte) 0x80);
        res.putShort((short) 1);
        res.putShort((short) 1);
        res.putShort((short) 0);
        res.putShort((short) 0);
        int pos = 12;
        while (pos < query.length && query[pos] != 0) res.put(query[pos++]);
        res.put((byte) 0); pos++;
        res.put(query[pos++]); res.put(query[pos++]);
        res.put(query[pos++]); res.put(query[pos++]);
        res.put((byte) 0xC0); res.put((byte) 0x0C);
        res.putShort((short) 1);
        res.putShort((short) 1);
        res.putInt(60);
        res.putShort((short) 4);
        for (String part : ip.split("\\.")) res.put((byte) Integer.parseInt(part));
        byte[] result = new byte[res.position()];
        System.arraycopy(res.array(), 0, result, 0, result.length);
        return result;
    }

    private void stopVpn() {
        debug("STOP VPN");

        stopUpstreamNetworkMonitor();
        running = false;
        if (executorService != null) executorService.shutdownNow();
        try { if (tunIn != null) tunIn.close(); } catch (IOException ignored) {}
        try { if (tunOut != null) tunOut.close(); } catch (IOException ignored) {}
        try { if (vpnInterface != null) vpnInterface.close(); } catch (IOException ignored) {}
        vpnInterface = null;
        stopForeground(true);
        copyDebugLogToDownloads();
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
