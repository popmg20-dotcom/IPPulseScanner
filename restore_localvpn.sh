#!/usr/bin/env bash
# Switches GamingVpnService from the broken hev-socks5-tunnel native build
# (its .so exports zero JNI symbols - unfixable without NDK) to a pure-Java
# full-tunnel implementation based on hexene/LocalVPN, with the blocking-mode
# deadlock and synchronous-DNS-stall bugs already fixed in the version below.
#
# No NDK, no native code, no AndroidX. Requires network (Termux has it) only
# to git clone the reference source - nothing is guessed or hand-written from
# memory for the TCP/UDP core.

set -e

PROJECT_DIR="$HOME/IPPulseScanner"
cd "$PROJECT_DIR" || { echo "ERROR: $PROJECT_DIR not found."; exit 1; }

PKG_DIR="app/src/main/java/com/ippulse/scanner"
LV_DIR="$PKG_DIR/localvpn"
mkdir -p "$LV_DIR"

echo "=== Cloning hexene/LocalVPN (reference TCP/UDP core) ==="
rm -rf /data/data/com.termux/files/home/_lv_clone
git clone --depth 1 https://github.com/hexene/LocalVPN.git /data/data/com.termux/files/home/_lv_clone
SRC="/data/data/com.termux/files/home/_lv_clone/app/src/main/java/xyz/hexene/localvpn"
if [ ! -d "$SRC" ]; then
  echo "ERROR: expected source folder not found at $SRC"
  find /data/data/com.termux/files/home/_lv_clone -iname "*.java"
  exit 1
fi

echo "=== Copying and repackaging core files ==="
for f in ByteBufferPool Packet TCB TCPInput TCPOutput UDPInput UDPOutput LRUCache; do
  if [ -f "$SRC/$f.java" ]; then
    cp "$SRC/$f.java" "$LV_DIR/$f.java"
    sed -i 's/xyz\.hexene\.localvpn/com.ippulse.scanner.localvpn/g' "$LV_DIR/$f.java"
    sed -i 's/LocalVPNService/GamingVpnService/g' "$LV_DIR/$f.java"
    echo "  copied $f.java"
  else
    echo "  WARNING: $f.java not found upstream - skipping"
  fi
done

echo "=== Removing dead hev/socks5 files ==="
rm -f "$PKG_DIR/Socks5ProxyServer.java"
rm -f "$PKG_DIR/DnsProxyServer.java"
rm -rf "app/src/main/java/hev"
rm -rf "app/src/main/jniLibs"
echo "  done"

echo "=== Writing corrected GamingVpnService.java ==="
cat << 'JAVA_EOF' > "$PKG_DIR/GamingVpnService.java"
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
import java.io.IOException;
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

    private void startVpn() {
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

            vpnInterface = builder.establish();
            if (vpnInterface == null) throw new IOException("establish() failed");

            tunIn = new FileInputStream(vpnInterface.getFileDescriptor());
            tunOut = new FileOutputStream(vpnInterface.getFileDescriptor());

            executorService = Executors.newFixedThreadPool(5);
            executorService.submit(new UDPInput(networkToDeviceQueue, udpSelector));
            executorService.submit(new UDPOutput(deviceToNetworkUDPQueue, udpSelector, this));
            executorService.submit(new TCPInput(networkToDeviceQueue, tcpSelector));
            executorService.submit(new TCPOutput(deviceToNetworkTCPQueue, networkToDeviceQueue, tcpSelector, this));
            executorService.submit(new TunRunnable());

            running = true;
            Log.i(TAG, "VPN started with full tunnel, MTU=" + currentMtu);
        } catch (Exception e) {
            Log.e(TAG, "Error starting VPN", e);
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

            while (running && !Thread.interrupted()) {
                try {
                    if (dataSent) {
                        buffer.clear();
                    } else {
                        dataSent = true;
                    }
                    int read = inputChannel.read(buffer);
                    if (read > 0) {
                        buffer.flip();
                        boolean bufferConsumed = false;
                        try {
                            Packet packet = new Packet(buffer);
                            if (packet.isUDP() && isDnsPacket(packet)) {
                                handleDns(packet);
                            } else if (packet.isUDP()) {
                                deviceToNetworkUDPQueue.offer(packet);
                                bufferConsumed = true;
                            } else if (packet.isTCP()) {
                                deviceToNetworkTCPQueue.offer(packet);
                                bufferConsumed = true;
                            }
                        } catch (Exception parseErr) {
                            Log.w(TAG, "Skipped unparseable packet", parseErr);
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
                        outBuffer.flip();
                        while (outBuffer.hasRemaining()) {
                            outputChannel.write(outBuffer);
                        }
                        ByteBufferPool.release(outBuffer);
                    }

                    if (!dataSent && networkToDeviceQueue.isEmpty()) {
                        Thread.sleep(10);
                    }
                } catch (Exception e) {
                    if (running) Log.e(TAG, "TUN loop error", e);
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
        running = false;
        if (executorService != null) executorService.shutdownNow();
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
JAVA_EOF

echo "=== Verifying no leftover references ==="
grep -rn "hev\.sockstun\|Socks5ProxyServer\|DnsProxyServer\|TProxyService" app/src/main/java/ 2>/dev/null && echo "WARNING: leftover references found above" || echo "  clean"

echo ""
echo "=== git status ==="
git status --short

echo ""
echo "Review looks OK? Then run:"
echo "  git add -A && git commit -m 'Switch to pure-Java full-tunnel VPN (hexene/LocalVPN based)' && git push"
