#!/data/data/com.termux/files/usr/bin/bash
set -e

ROOT="$HOME/IPPulseScanner"
cd "$ROOT"

echo "=============================================="
echo " IPPulseScanner - Network Lab final patch"
echo " MTU + DNS + IP BLOCK + HOSTING + INTERNET"
echo "=============================================="

STAMP="$(date +%Y%m%d_%H%M%S)"
BACKUP="backup_network_lab_${STAMP}"

mkdir -p "$BACKUP"

echo "[1/8] Backup..."
cp -a app/src/main app/src/main.bak_${STAMP} 2>/dev/null || true
cp -f app/src/main/AndroidManifest.xml "$BACKUP/AndroidManifest.xml" 2>/dev/null || true
cp -f app/build.gradle "$BACKUP/app-build.gradle" 2>/dev/null || true
cp -f app/src/main/java/com/ippulse/scanner/MainActivity.java \
   "$BACKUP/MainActivity.java" 2>/dev/null || true
cp -f app/src/main/java/com/ippulse/scanner/GamingVpnService.java \
   "$BACKUP/GamingVpnService.java" 2>/dev/null || true

JAVA_DIR="app/src/main/java/com/ippulse/scanner"
mkdir -p "$JAVA_DIR"

echo "[2/8] Check LocalVPN core..."
for f in \
  ByteBufferPool.java \
  Packet.java \
  TCPInput.java \
  TCPOutput.java \
  UDPInput.java \
  UDPOutput.java
do
  if [ ! -f "$JAVA_DIR/localvpn/$f" ]; then
    echo "ERROR: missing localvpn/$f"
    echo "The old TCP/UDP engine is required for full internet."
    exit 1
  fi
done

echo "[3/8] Write GamingVpnService.java..."

cat > "$JAVA_DIR/GamingVpnService.java" <<'JAVA'
package com.ippulse.scanner;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.ContentValues;
import android.content.pm.ServiceInfo;
import android.net.VpnService;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import com.ippulse.scanner.localvpn.ByteBufferPool;
import com.ippulse.scanner.localvpn.Packet;
import com.ippulse.scanner.localvpn.TCPInput;
import com.ippulse.scanner.localvpn.TCPOutput;
import com.ippulse.scanner.localvpn.UDPInput;
import com.ippulse.scanner.localvpn.UDPOutput;

import java.io.File;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GamingVpnService extends VpnService {

    private static final String TAG = "GamingVpn";
    private static final String ACTION_START = "com.ippulse.scanner.START";
    private static final String ACTION_STOP  = "com.ippulse.scanner.STOP";
    private static final String CHANNEL_ID  = "gaming_vpn";

    /*
     * VPN interface itself.
     * This is NOT the block list.
     */
    private static final String VPN_ADDRESS = "10.0.0.2";

    /*
     * DNS address visible to Android applications.
     * DNS packets are intercepted from TUN.
     */
    private static final String DNS_ADDRESS = "10.0.0.1";

    private ParcelFileDescriptor vpnInterface;
    private FileInputStream tunIn;
    private FileOutputStream tunOut;

    private final HashMap<String, String> hostsMap = new HashMap<>();
    private final List<CidrBlock> blockedNetworks = new ArrayList<>();

    private String dns = "8.8.8.8";
    private int currentMtu = 1400;

    private volatile boolean running = false;

    private ConcurrentLinkedQueue<Packet> deviceToNetworkUDPQueue;
    private ConcurrentLinkedQueue<Packet> deviceToNetworkTCPQueue;
    private ConcurrentLinkedQueue<ByteBuffer> networkToDeviceQueue;

    private Selector udpSelector;
    private Selector tcpSelector;
    private ExecutorService executorService;

    private final Object debugLock = new Object();
    private File debugFile;

    private ConnectivityManager connectivityManager;
    private ConnectivityManager.NetworkCallback networkCallback;
    private volatile Network upstreamNetwork;

    private void initDebugLog() {
        try {
            File dir = getExternalFilesDir(null);
            if (dir == null) dir = getFilesDir();

            debugFile = new File(dir, "vpn_debug.log");

            synchronized (debugLock) {
                FileOutputStream fos = new FileOutputStream(debugFile, false);
                fos.write(("=== IPPulseScanner VPN DEBUG ===\n").getBytes("UTF-8"));
                fos.flush();
                fos.close();
            }
        } catch (Exception e) {
            Log.e(TAG, "debug init failed", e);
        }
    }

    public void debug(String msg) {
        String line = System.currentTimeMillis()
                + " | "
                + Thread.currentThread().getName()
                + " | "
                + msg
                + "\n";

        Log.i(TAG, line.trim());

        synchronized (debugLock) {
            try {
                if (debugFile == null) initDebugLog();

                if (debugFile != null) {
                    FileOutputStream fos =
                            new FileOutputStream(debugFile, true);
                    fos.write(line.getBytes("UTF-8"));
                    fos.flush();
                    fos.close();
                }
            } catch (Exception e) {
                Log.e(TAG, "debug write failed", e);
            }
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (intent != null) {

            if (ACTION_STOP.equals(intent.getAction())) {
                stopVpn();
                return START_NOT_STICKY;
            }

            if (intent.hasExtra("dns")) {
                String d = intent.getStringExtra("dns");
                if (d != null && !d.trim().isEmpty()) {
                    dns = d.trim();
                }
            }

            if (intent.hasExtra("mtu")) {
                currentMtu = intent.getIntExtra("mtu", 1400);
            }

            SerializableHosts serializableHosts =
                    (SerializableHosts) intent.getSerializableExtra("hosts");

            if (serializableHosts != null && serializableHosts.map != null) {
                hostsMap.clear();
                hostsMap.putAll(serializableHosts.map);
            }

            /*
             * New block list.
             */
            String blockText = intent.getStringExtra("blockAddresses");

            /*
             * Fallback:
             * the old UI contains wgAddress and some versions save it
             * inside SharedPreferences. We inspect app preference XMLs.
             */
            if (blockText == null || blockText.trim().isEmpty()) {
                blockText = readSavedWgAddress();
            }

            loadBlockedNetworks(blockText);
        }

        if (currentMtu < 576) currentMtu = 576;
        if (currentMtu > 65535) currentMtu = 65535;

        createNotificationChannel();
        startForegroundCompatible();

        if (!running) {
            startVpn();
        }

        return START_STICKY;
    }

    private void startForegroundCompatible() {
        Notification notification = buildNotification("VPN Active");

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                startForeground(
                        1,
                        notification,
                        ServiceInfo.FOREGROUND_SERVICE_TYPE_SPECIAL_USE
                );
            } else {
                startForeground(1, notification);
            }
        } catch (Exception e) {
            try {
                startForeground(1, notification);
            } catch (Exception ignored) {
            }
        }
    }

    private void startVpn() {

        initDebugLog();

        if (running) return;

        try {

            deviceToNetworkUDPQueue = new ConcurrentLinkedQueue<>();
            deviceToNetworkTCPQueue = new ConcurrentLinkedQueue<>();
            networkToDeviceQueue = new ConcurrentLinkedQueue<>();

            udpSelector = Selector.open();
            tcpSelector = Selector.open();

            Builder builder = new Builder();

            builder.setSession("IPPulseScanner Network Lab");

            /*
             * Local VPN interface address.
             */
            builder.addAddress(VPN_ADDRESS, 32);

            /*
             * Full IPv4 route.
             * This makes MTU apply to traffic routed through this VPN.
             */
            builder.addRoute("0.0.0.0", 0);

            /*
             * DNS sent to applications.
             * We intercept packets destined for this virtual address.
             */
            builder.addDnsServer(DNS_ADDRESS);

            /*
             * User selected MTU.
             */
            builder.setMtu(currentMtu);

            /*
             * Non-blocking TUN:
             * required because the same loop also flushes queued replies.
             */
            builder.setBlocking(false);

            /*
             * Do not send this app's own sockets into its VPN.
             */
            try {
                builder.addDisallowedApplication(getPackageName());
            } catch (Exception ignored) {
            }

            startUpstreamNetworkMonitor();

            vpnInterface = builder.establish();

            if (vpnInterface == null) {
                throw new IOException("VpnService.Builder.establish() returned null");
            }

            tunIn = new FileInputStream(
                    vpnInterface.getFileDescriptor()
            );

            tunOut = new FileOutputStream(
                    vpnInterface.getFileDescriptor()
            );

            executorService = Executors.newFixedThreadPool(5);

            running = true;

            /*
             * Existing LocalVPN engine:
             * TCP + UDP real internet forwarding.
             */
            executorService.submit(
                    new UDPInput(networkToDeviceQueue, udpSelector)
            );

            executorService.submit(
                    new UDPOutput(
                            deviceToNetworkUDPQueue,
                            udpSelector,
                            this
                    )
            );

            executorService.submit(
                    new TCPInput(
                            networkToDeviceQueue,
                            tcpSelector,
                            currentMtu
                    )
            );

            executorService.submit(
                    new TCPOutput(
                            deviceToNetworkTCPQueue,
                            networkToDeviceQueue,
                            tcpSelector,
                            this
                    )
            );

            executorService.submit(new TunRunnable());

            debug("VPN RUNNING");
            debug("MTU=" + currentMtu);
            debug("DNS=" + dns);
            debug("HOSTS=" + hostsMap.size());
            debug("BLOCKS=" + blockedNetworks.size());

            Log.i(
                    TAG,
                    "VPN started MTU=" + currentMtu
                            + " blocks=" + blockedNetworks.size()
                            + " hosts=" + hostsMap.size()
            );

        } catch (Exception e) {

            Log.e(TAG, "VPN start failed", e);
            debug("VPN START FAILED: " + Log.getStackTraceString(e));

            Toast.makeText(
                    getApplicationContext(),
                    "VPN error: " + e.getClass().getSimpleName()
                            + ": " + e.getMessage(),
                    Toast.LENGTH_LONG
            ).show();

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

                            /*
                             * FIRST:
                             * IP BLOCK.
                             */
                            if (isBlocked(packet)) {

                                debug(
                                        "BLOCK "
                                                + packet.ip4Header.destinationAddress
                                                        .getHostAddress()
                                );

                                bufferConsumed = false;
                            }

                            /*
                             * SECOND:
                             * DNS interception.
                             */
                            else if (
                                    packet.isUDP()
                                            && isDnsPacket(packet)
                            ) {

                                handleDns(packet);

                            }

                            /*
                             * THIRD:
                             * Normal UDP internet traffic.
                             */
                            else if (packet.isUDP()) {

                                deviceToNetworkUDPQueue.offer(packet);
                                bufferConsumed = true;

                            }

                            /*
                             * FOURTH:
                             * Normal TCP internet traffic.
                             */
                            else if (packet.isTCP()) {

                                deviceToNetworkTCPQueue.offer(packet);
                                bufferConsumed = true;
                            }

                        } catch (Exception parseErr) {

                            Log.w(
                                    TAG,
                                    "Skipped unparseable packet",
                                    parseErr
                            );

                            debug(
                                    "PACKET PARSE ERROR: "
                                            + Log.getStackTraceString(parseErr)
                            );
                        }

                        if (!bufferConsumed) {
                            ByteBufferPool.release(buffer);
                        }

                        buffer = ByteBufferPool.acquire();

                    } else {

                        dataSent = false;
                    }

                    /*
                     * Write packets returned by TCP/UDP/DNS workers.
                     */
                    ByteBuffer outBuffer;

                    while (
                            (outBuffer = networkToDeviceQueue.poll())
                                    != null
                    ) {

                        outBuffer.flip();

                        try {
                            while (outBuffer.hasRemaining()) {
                                outputChannel.write(outBuffer);
                            }
                        } catch (IOException e) {
                            debug(
                                    "TUN WRITE ERROR: "
                                            + e.getMessage()
                            );
                        }

                        ByteBufferPool.release(outBuffer);
                    }

                    if (
                            !dataSent
                                    && networkToDeviceQueue.isEmpty()
                    ) {
                        Thread.sleep(5);
                    }

                } catch (Exception e) {

                    if (running) {

                        Log.e(TAG, "TUN loop error", e);

                        debug(
                                "TUN LOOP ERROR: "
                                        + Log.getStackTraceString(e)
                        );
                    }

                    break;
                }
            }

            ByteBufferPool.release(buffer);
        }
    }

    /*
     * DNS target is the virtual VPN DNS address.
     */
    private boolean isDnsPacket(Packet packet) {

        return packet.udpHeader != null
                && packet.ip4Header != null
                && packet.udpHeader.destinationPort == 53
                && DNS_ADDRESS.equals(
                packet.ip4Header.destinationAddress.getHostAddress()
        );
    }

    private void handleDns(final Packet packet) {

        try {

            ByteBuffer duplicate =
                    packet.backingBuffer.duplicate();

            int payloadLen =
                    packet.backingBuffer.limit()
                            - packet.backingBuffer.position();

            if (payloadLen <= 0) return;

            final byte[] dnsQuery =
                    new byte[payloadLen];

            duplicate.get(dnsQuery);

            final String domain =
                    extractDomain(dnsQuery);

            final InetAddress srcAddr =
                    packet.ip4Header.sourceAddress;

            final int srcPort =
                    packet.udpHeader.sourcePort;

            /*
             * HOSTING
             */
            String mappedIp = null;

            if (domain != null) {
                mappedIp = hostsMap.get(
                        domain.toLowerCase(Locale.US)
                );
            }

            if (mappedIp != null && isIPv4(mappedIp)) {

                debug(
                        "HOST "
                                + domain
                                + " -> "
                                + mappedIp
                );

                byte[] response =
                        buildDnsResponse(
                                dnsQuery,
                                mappedIp
                        );

                if (response != null) {

                    ByteBuffer output =
                            buildUdpPacket(
                                    DNS_ADDRESS,
                                    53,
                                    srcAddr,
                                    srcPort,
                                    response
                            );

                    networkToDeviceQueue.offer(output);
                }

                return;
            }

            /*
             * NON-MAPPED DNS:
             * forward to selected upstream.
             */
            final String upstream = dns;

            new Thread(() -> {

                byte[] response =
                        forwardDns(
                                dnsQuery,
                                upstream
                        );

                if (response != null) {

                    try {

                        ByteBuffer output =
                                buildUdpPacket(
                                        DNS_ADDRESS,
                                        53,
                                        srcAddr,
                                        srcPort,
                                        response
                                );

                        networkToDeviceQueue.offer(output);

                    } catch (Exception e) {

                        debug(
                                "DNS RESPONSE BUILD ERROR: "
                                        + Log.getStackTraceString(e)
                        );
                    }
                }

            }, "dns-forward").start();

        } catch (Exception e) {

            Log.e(TAG, "DNS handling error", e);

            debug(
                    "DNS ERROR: "
                            + Log.getStackTraceString(e)
            );
        }
    }

    private byte[] forwardDns(
            byte[] query,
            String upstream
    ) {

        DatagramSocket socket = null;

        try {

            socket = new DatagramSocket();

            /*
             * Do NOT let DNS forwarding loop back into our VPN.
             */
            protect(socket);

            socket.setSoTimeout(3000);

            InetAddress server =
                    InetAddress.getByName(upstream);

            DatagramPacket request =
                    new DatagramPacket(
                            query,
                            query.length,
                            server,
                            53
                    );

            socket.send(request);

            byte[] buffer = new byte[4096];

            DatagramPacket response =
                    new DatagramPacket(
                            buffer,
                            buffer.length
                    );

            socket.receive(response);

            byte[] result =
                    new byte[response.getLength()];

            System.arraycopy(
                    response.getData(),
                    0,
                    result,
                    0,
                    response.getLength()
            );

            return result;

        } catch (Exception e) {

            debug(
                    "UPSTREAM DNS ERROR: "
                            + Log.getStackTraceString(e)
            );

            return null;

        } finally {

            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception ignored) {
                }
            }
        }
    }

    private String extractDomain(byte[] dnsPayload) {

        if (dnsPayload == null || dnsPayload.length < 13) {
            return null;
        }

        try {

            StringBuilder domain =
                    new StringBuilder();

            int pos = 12;

            while (
                    pos < dnsPayload.length
                            && dnsPayload[pos] != 0
            ) {

                int len =
                        dnsPayload[pos++] & 0xFF;

                /*
                 * DNS compression in question section
                 * is unusual for queries. Abort safely.
                 */
                if ((len & 0xC0) != 0) {
                    return null;
                }

                if (len == 0) break;

                if (pos + len > dnsPayload.length) {
                    return null;
                }

                if (domain.length() > 0) {
                    domain.append('.');
                }

                domain.append(
                        new String(
                                dnsPayload,
                                pos,
                                len,
                                "UTF-8"
                        )
                );

                pos += len;
            }

            return domain
                    .toString()
                    .trim()
                    .toLowerCase(Locale.US);

        } catch (Exception e) {

            return null;
        }
    }

    private byte[] buildDnsResponse(
            byte[] query,
            String ip
    ) {

        try {

            String[] parts = ip.split("\\.");

            if (parts.length != 4) return null;

            ByteBuffer res =
                    ByteBuffer.allocate(
                            Math.min(
                                    4096,
                                    query.length + 64
                            )
                    );

            res.put(query[0]);
            res.put(query[1]);

            /*
             * Standard successful response.
             */
            res.put((byte) 0x81);
            res.put((byte) 0x80);

            res.putShort((short) 1); // QD
            res.putShort((short) 1); // AN
            res.putShort((short) 0); // NS
            res.putShort((short) 0); // AR

            int pos = 12;

            while (
                    pos < query.length
                            && query[pos] != 0
            ) {
                res.put(query[pos++]);
            }

            if (pos >= query.length) return null;

            res.put((byte) 0);
            pos++;

            if (pos + 4 > query.length) {
                return null;
            }

            res.put(query[pos++]);
            res.put(query[pos++]);

            res.put(query[pos++]);
            res.put(query[pos++]);

            /*
             * Answer name = pointer to question name.
             */
            res.put((byte) 0xC0);
            res.put((byte) 0x0C);

            res.putShort((short) 1); // A
            res.putShort((short) 1); // IN
            res.putInt(60);          // TTL
            res.putShort((short) 4); // IPv4 length

            for (String part : parts) {

                int value =
                        Integer.parseInt(part);

                if (value < 0 || value > 255) {
                    return null;
                }

                res.put(
                        (byte) value
                );
            }

            byte[] result =
                    new byte[res.position()];

            System.arraycopy(
                    res.array(),
                    0,
                    result,
                    0,
                    result.length
            );

            return result;

        } catch (Exception e) {

            debug(
                    "DNS RESPONSE ERROR: "
                            + Log.getStackTraceString(e)
            );

            return null;
        }
    }

    private ByteBuffer buildUdpPacket(
            String srcIp,
            int srcPort,
            InetAddress dstAddr,
            int dstPort,
            byte[] payload
    ) throws Exception {

        int udpLength =
                8 + payload.length;

        int totalLength =
                20 + udpLength;

        ByteBuffer packet =
                ByteBuffer.allocate(totalLength);

        packet.put((byte) 0x45);
        packet.put((byte) 0x00);

        packet.putShort(
                (short) totalLength
        );

        packet.putShort((short) 0);
        packet.putShort((short) 0);

        packet.put((byte) 64);
        packet.put((byte) 17);

        packet.putShort((short) 0);

        packet.put(
                InetAddress.getByName(srcIp)
                        .getAddress()
        );

        packet.put(
                dstAddr.getAddress()
        );

        packet.putShort(
                (short) srcPort
        );

        packet.putShort(
                (short) dstPort
        );

        packet.putShort(
                (short) udpLength
        );

        /*
         * IPv4 UDP checksum may be zero.
         */
        packet.putShort((short) 0);

        packet.put(payload);

        byte[] array =
                packet.array();

        int checksum =
                calculateIpChecksum(
                        array,
                        0,
                        20
                );

        array[10] =
                (byte) (checksum >> 8);

        array[11] =
                (byte) checksum;

        return ByteBuffer.wrap(array);
    }

    private int calculateIpChecksum(
            byte[] data,
            int offset,
            int length
    ) {

        long sum = 0;

        for (
                int i = offset;
                i < offset + length;
                i += 2
        ) {

            int word =
                    ((data[i] & 0xFF) << 8);

            if (i + 1 <
                    offset + length) {

                word |=
                        (data[i + 1] & 0xFF);
            }

            sum += word;
        }

        while ((sum >> 16) > 0) {
            sum =
                    (sum & 0xFFFF)
                            + (sum >> 16);
        }

        return (int)
                (~sum & 0xFFFF);
    }

    /*
     * -----------------------------
     * IP BLOCK
     * -----------------------------
     */

    private void loadBlockedNetworks(String text) {

        synchronized (blockedNetworks) {

            blockedNetworks.clear();

            if (text == null) return;

            String normalized =
                    text.replace('\n', ',');

            for (String raw :
                    normalized.split(",")) {

                String value =
                        raw.trim();

                if (value.isEmpty()) continue;

                CidrBlock block =
                        parseCidr(value);

                if (block != null) {

                    blockedNetworks.add(block);

                    debug(
                            "BLOCK RULE: "
                                    + value
                    );
                }
            }
        }
    }

    private boolean isBlocked(Packet packet) {

        if (packet == null
                || packet.ip4Header == null
                || packet.ip4Header.destinationAddress == null) {
            return false;
        }

        String dst =
                packet.ip4Header.destinationAddress
                        .getHostAddress();

        int ip =
                ipv4ToInt(dst);

        if (ip < 0) return false;

        synchronized (blockedNetworks) {

            for (CidrBlock block :
                    blockedNetworks) {

                if (
                        (ip & block.mask)
                                == block.network
                ) {
                    return true;
                }
            }
        }

        return false;
    }

    private CidrBlock parseCidr(String text) {

        try {

            String ip = text;
            int prefix = 32;

            int slash =
                    text.indexOf('/');

            if (slash >= 0) {

                ip =
                        text.substring(
                                0,
                                slash
                        ).trim();

                prefix =
                        Integer.parseInt(
                                text.substring(
                                        slash + 1
                                ).trim()
                        );
            }

            if (prefix < 0 || prefix > 32) {
                return null;
            }

            int addr =
                    ipv4ToInt(ip);

            if (addr < 0) return null;

            int mask;

            if (prefix == 0) {
                mask = 0;
            } else {
                mask =
                        (int)
                                (0xFFFFFFFFL
                                        << (32 - prefix));
            }

            int network =
                    addr & mask;

            return new CidrBlock(
                    network,
                    mask
            );

        } catch (Exception e) {

            return null;
        }
    }

    private int ipv4ToInt(String value) {

        try {

            String[] p =
                    value.trim()
                            .split("\\.");

            if (p.length != 4) {
                return -1;
            }

            int result = 0;

            for (String part : p) {

                int n =
                        Integer.parseInt(part);

                if (n < 0 || n > 255) {
                    return -1;
                }

                result =
                        (result << 8)
                                | n;
            }

            return result;

        } catch (Exception e) {

            return -1;
        }
    }

    private boolean isIPv4(String value) {
        return ipv4ToInt(value) >= 0;
    }

    private static final class CidrBlock {

        final int network;
        final int mask;

        CidrBlock(
                int network,
                int mask
        ) {
            this.network = network;
            this.mask = mask;
        }
    }

    /*
     * Read saved wgAddress from SharedPreferences XMLs.
     * This lets the existing Network Lab field act as
     * the block list without adding a new UI control.
     */
    private String readSavedWgAddress() {

        try {

            File prefsDir =
                    new File(
                            getApplicationInfo().dataDir,
                            "shared_prefs"
                    );

            if (!prefsDir.isDirectory()) {
                return null;
            }

            File[] files =
                    prefsDir.listFiles();

            if (files == null) {
                return null;
            }

            for (File file : files) {

                if (!file.getName()
                        .endsWith(".xml")) {
                    continue;
                }

                String text =
                        readTextFile(file);

                if (text == null) continue;

                String value =
                        extractPreferenceValue(
                                text,
                                "wgAddress"
                        );

                if (value == null) {

                    value =
                            extractPreferenceValue(
                                    text,
                                    "vpnAddress"
                            );
                }

                if (value != null
                        && !value.trim().isEmpty()) {

                    debug(
                            "BLOCKS FROM PREFS: "
                                    + value
                    );

                    return value;
                }
            }

        } catch (Exception e) {

            debug(
                    "PREF BLOCK READ ERROR: "
                            + Log.getStackTraceString(e)
            );
        }

        return null;
    }

    private String readTextFile(File file) {

        FileInputStream in = null;

        try {

            in =
                    new FileInputStream(file);

            byte[] data =
                    new byte[(int) file.length()];

            int total = 0;
            int read;

            while (
                    total < data.length
                            && (read = in.read(
                            data,
                            total,
                            data.length - total
                    )) > 0
            ) {
                total += read;
            }

            return new String(
                    data,
                    0,
                    total,
                    "UTF-8"
            );

        } catch (Exception e) {

            return null;

        } finally {

            if (in != null) {
                try {
                    in.close();
                } catch (Exception ignored) {
                }
            }
        }
    }

    private String extractPreferenceValue(
            String xml,
            String key
    ) {

        String marker =
                "name=\"" + key + "\"";

        int namePos =
                xml.indexOf(marker);

        if (namePos < 0) return null;

        int start =
                xml.indexOf('>', namePos);

        if (start < 0) return null;

        start++;

        int end =
                xml.indexOf(
                        '<',
                        start
                );

        if (end < 0) return null;

        return xml
                .substring(start, end)
                .replace("&amp;", "&")
                .replace("&lt;", "<")
                .replace("&gt;", ">")
                .replace("&quot;", "\"")
                .trim();
    }

    /*
     * -----------------------------
     * Physical upstream network
     * -----------------------------
     */

    private void startUpstreamNetworkMonitor() {

        connectivityManager =
                (ConnectivityManager)
                        getSystemService(
                                Context.CONNECTIVITY_SERVICE
                        );

        if (connectivityManager == null) {
            return;
        }

        try {

            Network active =
                    connectivityManager
                            .getActiveNetwork();

            if (active != null) {

                NetworkCapabilities caps =
                        connectivityManager
                                .getNetworkCapabilities(
                                        active
                                );

                if (isUsablePhysicalNetwork(caps)) {
                    upstreamNetwork = active;
                }
            }

        } catch (Exception ignored) {
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

            try {

                NetworkRequest request =
                        new NetworkRequest.Builder()
                                .addCapability(
                                        NetworkCapabilities
                                                .NET_CAPABILITY_INTERNET
                                )
                                .addCapability(
                                        NetworkCapabilities
                                                .NET_CAPABILITY_NOT_VPN
                                )
                                .build();

                networkCallback =
                        new ConnectivityManager.NetworkCallback() {

                            @Override
                            public void onAvailable(
                                    Network network
                            ) {

                                try {

                                    NetworkCapabilities caps =
                                            connectivityManager
                                                    .getNetworkCapabilities(
                                                            network
                                                    );

                                    if (isUsablePhysicalNetwork(caps)) {
                                        upstreamNetwork =
                                                network;
                                    }

                                } catch (Exception ignored) {
                                }
                            }

                            @Override
                            public void onLost(
                                    Network network
                            ) {

                                if (network.equals(
                                        upstreamNetwork
                                )) {
                                    upstreamNetwork = null;
                                }
                            }
                        };

                connectivityManager
                        .registerNetworkCallback(
                                request,
                                networkCallback
                        );

            } catch (Exception ignored) {
            }
        }
    }

    private boolean isUsablePhysicalNetwork(
            NetworkCapabilities caps
    ) {

        if (caps == null) return false;

        if (!caps.hasCapability(
                NetworkCapabilities
                        .NET_CAPABILITY_INTERNET
        )) {
            return false;
        }

        if (!caps.hasCapability(
                NetworkCapabilities
                        .NET_CAPABILITY_NOT_VPN
        )) {
            return false;
        }

        return caps.hasTransport(
                NetworkCapabilities.TRANSPORT_WIFI
        ) || caps.hasTransport(
                NetworkCapabilities.TRANSPORT_CELLULAR
        ) || caps.hasTransport(
                NetworkCapabilities.TRANSPORT_ETHERNET
        ) || caps.hasTransport(
                NetworkCapabilities.TRANSPORT_BLUETOOTH
        );
    }

    public boolean protectOrBind(Socket socket) {

        return socket != null
                && protect(socket);
    }

    public boolean protectOrBind(DatagramSocket socket) {

        return socket != null
                && protect(socket);
    }

    private void stopUpstreamNetworkMonitor() {

        if (
                connectivityManager != null
                        && networkCallback != null
        ) {

            try {
                connectivityManager
                        .unregisterNetworkCallback(
                                networkCallback
                        );
            } catch (Exception ignored) {
            }
        }

        networkCallback = null;
        upstreamNetwork = null;
    }

    private void stopVpn() {

        running = false;

        stopUpstreamNetworkMonitor();

        if (executorService != null) {
            executorService.shutdownNow();
            executorService = null;
        }

        try {
            if (udpSelector != null) {
                udpSelector.close();
            }
        } catch (Exception ignored) {
        }

        try {
            if (tcpSelector != null) {
                tcpSelector.close();
            }
        } catch (Exception ignored) {
        }

        try {
            if (tunIn != null) tunIn.close();
        } catch (IOException ignored) {
        }

        try {
            if (tunOut != null) tunOut.close();
        } catch (IOException ignored) {
        }

        try {
            if (vpnInterface != null) vpnInterface.close();
        } catch (IOException ignored) {
        }

        vpnInterface = null;

        stopForeground(true);
        stopSelf();
    }

    @Override
    public void onRevoke() {
        stopVpn();
        super.onRevoke();
    }

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel =
                    new NotificationChannel(
                            CHANNEL_ID,
                            "IPPulseScanner VPN",
                            NotificationManager.IMPORTANCE_LOW
                    );

            NotificationManager manager =
                    getSystemService(
                            NotificationManager.class
                    );

            if (manager != null) {
                manager.createNotificationChannel(
                        channel
                );
            }
        }
    }

    private Notification buildNotification(
            String text
    ) {

        Intent intent =
                new Intent(
                        this,
                        MainActivity.class
                );

        PendingIntent pendingIntent =
                PendingIntent.getActivity(
                        this,
                        0,
                        intent,
                        PendingIntent.FLAG_IMMUTABLE
                );

        Notification.Builder builder =
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
                        ? new Notification.Builder(
                                this,
                                CHANNEL_ID
                        )
                        : new Notification.Builder(
                                this
                        );

        return builder
                .setContentTitle(
                        "IPPulseScanner VPN"
                )
                .setContentText(text)
                .setSmallIcon(
                        android.R.drawable.ic_dialog_info
                )
                .setContentIntent(
                        pendingIntent
                )
                .build();
    }

    /*
     * Existing 4-argument launcher.
     */
    public static void start(
            Context context,
            String dns,
            int mtu,
            HashMap<String, String> hostsMap
    ) {

        start(
                context,
                dns,
                mtu,
                hostsMap,
                null
        );
    }

    /*
     * New launcher with explicit block list.
     */
    public static void start(
            Context context,
            String dns,
            int mtu,
            HashMap<String, String> hostsMap,
            String blockAddresses
    ) {

        Intent intent =
                new Intent(
                        context,
                        GamingVpnService.class
                );

        intent.setAction(ACTION_START);

        intent.putExtra(
                "dns",
                dns
        );

        intent.putExtra(
                "mtu",
                mtu
        );

        intent.putExtra(
                "hosts",
                new SerializableHosts(
                        hostsMap
                )
        );

        if (blockAddresses != null) {

            intent.putExtra(
                    "blockAddresses",
                    blockAddresses
            );
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            context.startForegroundService(
                    intent
            );

        } else {

            context.startService(
                    intent
            );
        }
    }

    public static void stop(
            Context context
    ) {

        Intent intent =
                new Intent(
                        context,
                        GamingVpnService.class
                );

        intent.setAction(
                ACTION_STOP
        );

        context.startService(intent);
    }

    public static class SerializableHosts
            implements java.io.Serializable {

        public HashMap<String, String> map;

        public SerializableHosts(
                HashMap<String, String> map
        ) {
            this.map = map;
        }
    }
}
JAVA

echo "[4/8] Patch Network Lab launcher if possible..."

python3 - <<'PY'
from pathlib import Path
import re

p = Path("app/src/main/java/com/ippulse/scanner/MainActivity.java")

if not p.exists():
    print("WARNING: MainActivity.java not found; service was still installed.")
    raise SystemExit(0)

s = p.read_text(encoding="utf-8", errors="ignore")

# Case 1: existing 4-argument GamingVpnService.start(...)
pattern = re.compile(
    r'GamingVpnService\.start\s*\(\s*'
    r'([^;]*?)'
    r'\s*\)\s*;',
    re.S
)

changed = False

def repl(m):
    global changed
    body = m.group(1)

    # Don't touch calls already containing the explicit block argument.
    if "wgAddress" in body and body.count(",") >= 4:
        return m.group(0)

    parts = [x.strip() for x in body.split(",")]

    # We only transform a simple 4-argument call.
    if len(parts) == 4:
        changed = True
        return (
            "GamingVpnService.start("
            + body
            + ", "
              "((android.widget.EditText)findViewById(R.id.wgAddress))"
              ".getText().toString()"
              ");"
        )

    return m.group(0)

new_s = pattern.sub(repl, s)

if changed:
    p.write_text(new_s, encoding="utf-8")
    print("MainActivity: GamingVpnService.start(...) patched with wgAddress block list.")
else:
    print("MainActivity: no safe 4-argument GamingVpnService.start(...) call found.")
    print("The service has a fallback reader for a saved wgAddress preference.")

PY

echo "[5/8] Ensure VPN service declaration exists..."

python3 - <<'PY'
from pathlib import Path
import re

p = Path("app/src/main/AndroidManifest.xml")

if not p.exists():
    print("ERROR: AndroidManifest.xml not found.")
    raise SystemExit(1)

s = p.read_text(encoding="utf-8", errors="ignore")

# Remove the official GoBackend service declaration if present.
s = re.sub(
    r'\s*<service\b[^>]*GoBackend\$VpnService[^>]*/>',
    '',
    s
)

# Also remove expanded GoBackend service blocks if present.
s = re.sub(
    r'\s*<service\b[^>]*GoBackend\$VpnService[^>]*>.*?</service>',
    '',
    s,
    flags=re.S
)

service = '''
        <service
            android:name=".GamingVpnService"
            android:permission="android.permission.BIND_VPN_SERVICE"
            android:exported="false"
            android:foregroundServiceType="specialUse">
            <intent-filter>
                <action android:name="android.net.VpnService"/>
            </intent-filter>
            <property
                android:name="android.app.PROPERTY_SPECIAL_USE_FGS_SUBTYPE"
                android:value="network_vpn"/>
        </service>
'''

if "android:name=\".GamingVpnService\"" not in s:
    idx = s.rfind("</application>")
    if idx < 0:
        print("ERROR: </application> not found.")
        raise SystemExit(1)
    s = s[:idx] + service + "\n" + s[idx:]

p.write_text(s, encoding="utf-8")
print("Manifest: GamingVpnService declared.")
PY

echo "[6/8] Keep WireGuard dependency harmless..."
echo "The library is not used by the new VPN service."
echo "We intentionally leave the dependency in place so MainActivity/build does not break if old imports remain."

echo "[7/8] Build..."
chmod +x ./gradlew

./gradlew clean assembleDebug --no-daemon

APK="app/build/outputs/apk/debug/app-debug.apk"

if [ ! -f "$APK" ]; then
    echo "ERROR: APK was not produced."
    exit 1
fi

echo ""
echo "BUILD OK:"
ls -lh "$APK"

echo "[8/8] Commit + push..."

git add \
    app/src/main/java/com/ippulse/scanner/GamingVpnService.java \
    app/src/main/java/com/ippulse/scanner/MainActivity.java \
    app/src/main/AndroidManifest.xml

git status --short

git commit -m "Network Lab: MTU DNS IP blocking and local hosting"

CURRENT_BRANCH="$(git branch --show-current)"

if [ -z "$CURRENT_BRANCH" ]; then
    CURRENT_BRANCH="main"
fi

git push origin "$CURRENT_BRANCH"

echo ""
echo "=============================================="
echo " DONE"
echo "=============================================="
echo "APK:"
echo "$ROOT/$APK"
echo ""
echo "Features:"
echo "  MTU          = VPN interface MTU"
echo "  DNS          = local intercepted DNS"
echo "  Hosting      = domain -> custom IPv4"
echo "  IP blocking  = wgAddress entries"
echo "  Internet     = existing LocalVPN TCP/UDP NAT"
echo ""
echo "Example wgAddress:"
echo "193.239.118.200/32,172.16.140.5/32,172.16.2.209/32"
echo ""
echo "The old WireGuard GoBackend service is no longer the active VPN."
echo "=============================================="
