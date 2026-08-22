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
import android.system.Os;
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
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.Selector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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

    /*
     * 247 PROFESSIONAL EVIDENCE LOGGER
     *
     * Does not alter VPN/TUN/TCP/UDP behavior.
     * It only controls what debug() records.
     */
    private final HashMap<String, Long> evidenceLastSeen = new HashMap<>();
    private static final long EVIDENCE_REPEAT_MS = 1500L;
    private static final String EVIDENCE_TAG = "VPN247";

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

    private boolean evidenceImportant(String msg) {

        if (msg == null || msg.trim().isEmpty()) {
            return false;
        }

        String m = msg.toUpperCase(Locale.US);

        return
                m.contains("ERROR") ||
                m.contains("FAILED") ||
                m.contains("EXCEPTION") ||
                m.contains("THROW") ||
                m.contains("TIMEOUT") ||
                m.contains("TIMED OUT") ||
                m.contains("REFUSED") ||
                m.contains("RESET") ||
                m.contains("RST") ||
                m.contains("SYN") ||
                m.contains("SYN-ACK") ||
                m.contains("ACK") ||
                m.contains("CONNECT") ||
                m.contains("CONNECTED") ||
                m.contains("CLOSE") ||
                m.contains("CLOSED") ||
                m.contains("SOCKET") ||
                m.contains("PROTECT") ||
                m.contains("DNS") ||
                m.contains("UDP") ||
                m.contains("TCP") ||
                m.contains("TUN") ||
                m.contains("QUEUE") ||
                m.contains("VPN") ||
                m.contains("MTU") ||
                m.contains("ROUTE") ||
                m.contains("BLOCK") ||
                m.contains("EOF") ||
                m.contains("SELECTOR") ||
                m.contains("TCB");
    }

    private String evidenceCategory(String msg) {

        String m = msg.toUpperCase(Locale.US);

        if (m.contains("EXCEPTION") ||
                m.contains("ERROR") ||
                m.contains("FAILED") ||
                m.contains("TIMEOUT") ||
                m.contains("REFUSED") ||
                m.contains("RESET") ||
                m.contains("RST")) {
            return "ERROR";
        }

        if (m.contains("DNS")) return "DNS";
        if (m.contains("UDP")) return "UDP";
        if (m.contains("TCP") ||
                m.contains("SYN") ||
                m.contains("ACK") ||
                m.contains("TCB")) return "TCP";
        if (m.contains("TUN")) return "TUN";
        if (m.contains("SOCKET") ||
                m.contains("CONNECT") ||
                m.contains("PROTECT")) return "NET";
        if (m.contains("QUEUE")) return "QUEUE";
        if (m.contains("VPN")) return "VPN";

        return "OTHER";
    }

    private boolean evidenceRateAllowed(String msg) {

        String key = evidenceCategory(msg) + "|" + msg.trim();
        long now = System.currentTimeMillis();

        synchronized (evidenceLastSeen) {

            Long last = evidenceLastSeen.get(key);

            if (last != null &&
                    now - last < EVIDENCE_REPEAT_MS) {
                return false;
            }

            evidenceLastSeen.put(key, now);

            /*
             * Prevent the map itself from growing forever.
             */
            if (evidenceLastSeen.size() > 500) {
                evidenceLastSeen.clear();
                evidenceLastSeen.put(key, now);
            }

            return true;
        }
    }

    public void debug(String msg) {

        if (!evidenceImportant(msg)) {
            return;
        }

        if (!evidenceRateAllowed(msg)) {
            return;
        }

        String category = evidenceCategory(msg);

        String line =
                System.currentTimeMillis()
                + " | "
                + Thread.currentThread().getName()
                + " | "
                + category
                + " | "
                + msg;

        /*
         * Dedicated Logcat tag.
         *
         * This is the important part:
         *
         *   logcat -s VPN247:*
         *
         * gives ONLY evidence events.
         */
        Log.i(EVIDENCE_TAG, line);

        synchronized (debugLock) {

            try {

                if (debugFile == null) {
                    initDebugLog();
                }

                if (debugFile != null) {

                    FileOutputStream fos =
                            new FileOutputStream(
                                    debugFile,
                                    true
                            );

                    fos.write(
                            (line + "\n")
                                    .getBytes("UTF-8")
                    );

                    fos.flush();
                    fos.close();
                }

            } catch (Exception ignored) {

                /*
                 * Logging is never allowed to break VPN.
                 */
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
             * Blocking TUN.
             *
             * Reader and writer are separate executor tasks, so a
             * blocking read cannot prevent network->TUN writes.
             * This avoids using FileChannel.write() against a
             * non-blocking VPN descriptor.
             */
            builder.setBlocking(true);

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

            executorService = Executors.newFixedThreadPool(6);

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

            /*
             * TUN reader and writer are deliberately separate.
             */
            executorService.submit(new TunPacketReaderRunnable());
            executorService.submit(new TunWriterRunnable());

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


    /*
     * Real implementation using FileInputStream.read(byte[]).
     *
     * Kept separate from writer so a blocking read can never stall
     * the network->device direction.
     */
    private final class TunPacketReaderRunnable implements Runnable {

        private static final int MAX_IP_PACKET = 65535;
        private static final int READ_CHUNK = 32768;
        private static final int ACCUMULATOR_SIZE = 131072;
        private static final int LOCALVPN_BUFFER_SIZE = 16384;

        @Override
        public void run() {

            /*
             * We deliberately use a plain byte[] accumulator here.
             *
             * A TUN read is already a packet-oriented read on Android's
             * VPN interface, but we still support partial/multiple frames
             * safely without relying on ByteBuffer compact/flip state.
             */
            final byte[] readBuffer =
                    new byte[READ_CHUNK];

            final byte[] pending =
                    new byte[ACCUMULATOR_SIZE];

            int pendingLength = 0;

            debug("TUN PACKET READER START");

            while (running
                    && !Thread.currentThread().isInterrupted()) {

                try {

                    int count =
                            tunIn.read(readBuffer);

                    if (count < 0) {

                        debug("TUN READER EOF");
                        break;
                    }

                    if (count == 0) {
                        continue;
                    }

                    /*
                     * Append the new bytes to the accumulator.
                     */
                    if (pendingLength + count > pending.length) {

                        debug(
                                "TUN ACCUMULATOR OVERFLOW pending="
                                        + pendingLength
                                        + " count="
                                        + count
                        );

                        /*
                         * Reset framing rather than parsing corrupted data.
                         */
                        pendingLength = 0;
                        continue;
                    }

                    System.arraycopy(
                            readBuffer,
                            0,
                            pending,
                            pendingLength,
                            count
                    );

                    pendingLength += count;

                    int offset = 0;

                    /*
                     * Extract as many complete IP packets as possible.
                     */
                    while (true) {

                        int available =
                                pendingLength - offset;

                        if (available < 20) {
                            break;
                        }

                        int first =
                                pending[offset] & 0xFF;

                        int version =
                                (first >>> 4) & 0x0F;

                        int ihlWords =
                                first & 0x0F;

                        /*
                         * -------------------------------------------------
                         * IPv6
                         * -------------------------------------------------
                         */
                        if (version == 6) {

                            if (available < 40) {
                                break;
                            }

                            int payloadLength =
                                    ((pending[offset + 4] & 0xFF) << 8)
                                            | (pending[offset + 5] & 0xFF);

                            int totalLength =
                                    40 + payloadLength;

                            if (totalLength < 40
                                    || totalLength > MAX_IP_PACKET) {

                                debug(
                                        "TUN INVALID IPV6 LENGTH "
                                                + totalLength
                                );

                                offset += 1;
                                continue;
                            }

                            if (available < totalLength) {
                                break;
                            }

                            debug(
                                    "TUN IPV6 DROPPED len="
                                            + totalLength
                            );

                            offset += totalLength;
                            continue;
                        }

                        /*
                         * -------------------------------------------------
                         * Invalid/non-IPv4
                         * -------------------------------------------------
                         */
                        if (version != 4
                                || ihlWords < 5) {

                            debug(
                                    "TUN INVALID IP HEADER "
                                            + "version="
                                            + version
                                            + " ihl="
                                            + ihlWords
                            );

                            offset += 1;
                            continue;
                        }

                        int headerLength =
                                ihlWords * 4;

                        if (available < headerLength) {
                            break;
                        }

                        int totalLength =
                                ((pending[offset + 2] & 0xFF) << 8)
                                        | (pending[offset + 3] & 0xFF);

                        if (totalLength < headerLength
                                || totalLength > MAX_IP_PACKET) {

                            debug(
                                    "TUN INVALID IP LENGTH "
                                            + totalLength
                                            + " header="
                                            + headerLength
                            );

                            offset += 1;
                            continue;
                        }

                        /*
                         * Complete packet has not arrived yet.
                         */
                        if (available < totalLength) {
                            break;
                        }

                        /*
                         * LocalVPN's pool buffers are 16KB.
                         * Current VPN MTU is 1400, so ordinary packets
                         * are safely below this limit.
                         */
                        if (totalLength > LOCALVPN_BUFFER_SIZE) {

                            debug(
                                    "TUN PACKET TOO LARGE "
                                            + totalLength
                            );

                            offset += totalLength;
                            continue;
                        }

                        ByteBuffer packetBuffer =
                                ByteBufferPool.acquire();

                        if (packetBuffer.capacity()
                                < LOCALVPN_BUFFER_SIZE) {

                            debug(
                                    "TUN BAD POOL BUFFER capacity="
                                            + packetBuffer.capacity()
                            );

                            offset += totalLength;
                            ByteBufferPool.release(
                                    packetBuffer
                            );
                            continue;
                        }

                        packetBuffer.clear();

                        packetBuffer.put(
                                pending,
                                offset,
                                totalLength
                        );

                        packetBuffer.flip();

                        /*
                         * IMPORTANT:
                         * packetBuffer must remain owned by Packet/worker
                         * after processTunPacket() when consumed=true.
                         */
                        processTunPacket(
                                packetBuffer
                        );

                        offset += totalLength;
                    }

                    /*
                     * Preserve incomplete trailing bytes.
                     */
                    if (offset > 0) {

                        int remaining =
                                pendingLength - offset;

                        if (remaining > 0) {

                            System.arraycopy(
                                    pending,
                                    offset,
                                    pending,
                                    0,
                                    remaining
                            );
                        }

                        pendingLength = remaining;
                    }

                } catch (IOException e) {

                    if (!running) {
                        break;
                    }

                    debug(
                            "TUN READER IO ERROR "
                                    + e.getClass().getName()
                                    + ": "
                                    + String.valueOf(
                                            e.getMessage()
                                    )
                    );

                } catch (Exception e) {

                    if (!running) {
                        break;
                    }

                    debug(
                            "TUN READER ERROR "
                                    + Log.getStackTraceString(e)
                    );
                }
            }

            debug("TUN PACKET READER STOP");
        }

        private void processTunPacket(
                ByteBuffer packetBuffer) {

            boolean consumed =
                    false;

            try {

                Packet packet =
                        new Packet(packetBuffer);

                if (isBlocked(packet)) {

                    debug(
                            "BLOCK "
                                    + packet.ip4Header.destinationAddress
                                    .getHostAddress()
                    );

                    return;
                }

                if (
                        packet.isUDP()
                                && isDnsPacket(packet)
                ) {

                    handleDns(packet);
                    return;
                }

                if (packet.isUDP()) {

                    deviceToNetworkUDPQueue.offer(
                            packet
                    );

                    consumed = true;
                    return;
                }

                if (packet.isTCP()) {

                    deviceToNetworkTCPQueue.offer(
                            packet
                    );

                    consumed = true;
                    return;
                }

                if (packet.isICMP()) {

                    debug(
                            "ICMP ECHO REQUEST "
                                    + packet.ip4Header
                                            .destinationAddress
                                            .getHostAddress()
                    );

                    handleIcmpEcho(
                            packet
                    );

                    consumed = true;
                    return;
                }

                debug(
                        "TUN UNSUPPORTED PROTOCOL "
                                + packet.ip4Header.protocol
                );

            } catch (Exception e) {

                debug(
                        "PACKET PARSE ERROR: "
                                + Log.getStackTraceString(e)
                );

            } finally {

                if (!consumed) {

                    ByteBufferPool.release(
                            packetBuffer
                    );
                }
            }
        }
    }

    private final class TunWriterRunnable implements Runnable {

        @Override
        public void run() {

            debug("TUN WRITER START");

            while (running
                    && !Thread.currentThread().isInterrupted()) {

                ByteBuffer buffer =
                        networkToDeviceQueue.poll();

                if (buffer == null) {

                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }

                    continue;
                }

                try {

                    /*
                     * Never trust buffer.limit() as the IP packet length.
                     *
                     * The buffer may be a pooled 16KB buffer while the
                     * actual IPv4 packet is much smaller.
                     *
                     * The authoritative packet length is IPv4 bytes 2..3.
                     */
                    if (buffer.capacity() < 20) {

                        debug(
                                "TUN WRITE INVALID RAW BUFFER capacity="
                                        + buffer.capacity()
                        );

                        continue;
                    }

                    ByteBuffer duplicate =
                            buffer.duplicate();

                    duplicate.position(0);

                    int versionIhl =
                            duplicate.get(0) & 0xFF;

                    int version =
                            (versionIhl >>> 4) & 0x0F;

                    int ihlWords =
                            versionIhl & 0x0F;

                    if (version != 4
                            || ihlWords < 5) {

                        debug(
                                "TUN WRITE INVALID IPV4 version="
                                        + version
                                        + " ihl="
                                        + ihlWords
                        );

                        continue;
                    }

                    int headerLength =
                            ihlWords * 4;

                    if (buffer.capacity() < headerLength) {

                        debug(
                                "TUN WRITE INVALID HEADER len="
                                        + headerLength
                                        + " capacity="
                                        + buffer.capacity()
                        );

                        continue;
                    }

                    int ipTotalLength =
                            ((duplicate.get(2) & 0xFF) << 8)
                                    | (duplicate.get(3) & 0xFF);

                    if (ipTotalLength < headerLength
                            || ipTotalLength > buffer.capacity()) {

                        debug(
                                "TUN WRITE INVALID IPV4 TOTAL="
                                        + ipTotalLength
                                        + " header="
                                        + headerLength
                                        + " capacity="
                                        + buffer.capacity()
                        );

                        continue;
                    }

                    /*
                     * Full tunnel MTU is currentMtu.
                     * Do not inject oversized packets into TUN.
                     */
                    if (ipTotalLength > currentMtu) {

                        debug(
                                "TUN WRITE OVERSIZE IPV4 total="
                                        + ipTotalLength
                                        + " mtu="
                                        + currentMtu
                        );

                        continue;
                    }

                    byte[] packet =
                            new byte[ipTotalLength];

                    duplicate.position(0);
                    duplicate.limit(ipTotalLength);
                    duplicate.get(packet);

                    tunOut.write(
                            packet,
                            0,
                            packet.length
                    );

                    tunOut.flush();

                    debug(
                            "TUN WRITE OK len="
                                    + ipTotalLength
                    );

                } catch (IOException e) {

                    debug(
                            "TUN WRITE ERROR: "
                                    + e.getClass().getName()
                                    + ": "
                                    + String.valueOf(
                                            e.getMessage()
                                    )
                    );

                } catch (Exception e) {

                    debug(
                            "TUN WRITER ERROR: "
                                    + Log.getStackTraceString(e)
                    );

                } finally {

                    ByteBufferPool.release(
                            buffer
                    );
                }
            }

            debug("TUN WRITER STOP");
        }
    }


    /*
     * DNS target is the virtual VPN DNS address.
     */

    /*
     * ============================================================
     * ICMP ECHO TEST
     * ============================================================
     *
     * Purpose:
     *
     *   TUN ICMP Echo Request
     *       -> protected ICMP socket
     *       -> physical network
     *       -> Echo Reply
     *       -> TUN
     *
     * This is only for connectivity/hosting verification.
     */
    private void handleIcmpEcho(Packet packet) {

        if (packet == null
                || packet.ip4Header == null
                || !packet.isICMP()) {
            return;
        }

        final ByteBuffer input =
                packet.backingBuffer.duplicate();

        input.position(0);

        final int ipHeaderLength =
                packet.ip4Header.headerLength;

        final int totalLength =
                packet.ip4Header.totalLength;

        if (totalLength < ipHeaderLength + 8
                || totalLength > input.capacity()) {

            debug(
                    "ICMP INVALID total="
                            + totalLength
                            + " header="
                            + ipHeaderLength
            );

            return;
        }

        final int icmpOffset =
                ipHeaderLength;

        final int type =
                input.get(icmpOffset) & 0xFF;

        final int code =
                input.get(icmpOffset + 1) & 0xFF;

        /*
         * Only IPv4 Echo Request.
         */
        if (type != 8 || code != 0) {

            debug(
                    "ICMP UNSUPPORTED type="
                            + type
                            + " code="
                            + code
            );

            return;
        }

        final int identifier =
                input.getShort(
                        icmpOffset + 4
                ) & 0xFFFF;

        final int sequence =
                input.getShort(
                        icmpOffset + 6
                ) & 0xFFFF;

        final byte[] payload =
                new byte[
                        totalLength
                                - icmpOffset
                                - 8
                ];

        input.position(
                icmpOffset + 8
        );

        input.get(payload);

        final InetAddress destination =
                packet.ip4Header.destinationAddress;

        final InetAddress source =
                packet.ip4Header.sourceAddress;

        new Thread(
                new Runnable() {

                    @Override
                    public void run() {

                        FileDescriptor fd = null;

                        try {

                            fd =
                                    Os.socket(
                                            android.system.OsConstants.AF_INET,
                                            android.system.OsConstants.SOCK_DGRAM,
                                            android.system.OsConstants.IPPROTO_ICMP
                                    );

                            /*
                             * Critical:
                             * prevent recursive entry into our VPN.
                             */
                            ParcelFileDescriptor protectedPfd =
                                    ParcelFileDescriptor.dup(fd);

                            if (!protect(
                                    protectedPfd.getFd()
                            )) {

                                debug(
                                        "ICMP PROTECT FAILED"
                                                + " "
                                                + destination
                                                        .getHostAddress()
                                );

                                try {
                                    protectedPfd.close();
                                } catch (Exception ignored) {
                                }

                                return;
                            }

                            try {
                                protectedPfd.close();
                            } catch (Exception ignored) {
                            }


                            byte[] request =
                                    new byte[
                                            8 + payload.length
                                    ];

                            request[0] = 8;
                            request[1] = 0;

                            request[4] =
                                    (byte)
                                            (identifier >>> 8);

                            request[5] =
                                    (byte)
                                            identifier;

                            request[6] =
                                    (byte)
                                            (sequence >>> 8);

                            request[7] =
                                    (byte)
                                            sequence;

                            System.arraycopy(
                                    payload,
                                    0,
                                    request,
                                    8,
                                    payload.length
                            );

                            int checksum =
                                    icmpChecksum(
                                            request
                                    );

                            request[2] =
                                    (byte)
                                            (checksum >>> 8);

                            request[3] =
                                    (byte)
                                            checksum;

                            Os.sendto(
                                    fd,
                                    request,
                                    0,
                                    request.length,
                                    0,
                                    new InetSocketAddress(
                                            destination,
                                            0
                                    )
                            );

                            debug(
                                    "ICMP SENT "
                                            + destination
                                                    .getHostAddress()
                                            + " id="
                                            + identifier
                                            + " seq="
                                            + sequence
                            );

                            /*
                             * Receive with a bounded worker lifetime.
                             * The socket itself is closed in finally.
                             */
                            byte[] reply =
                                    new byte[4096];

                            int received =
                                    Os.recvfrom(
                                            fd,
                                            reply,
                                            0,
                                            reply.length,
                                            0,
                                            null
                                    );

                            if (received < 8) {

                                debug(
                                        "ICMP REPLY TOO SHORT "
                                                + received
                                );

                                return;
                            }

                            int offset = 0;

                            /*
                             * Accept either:
                             *
                             *   ICMP payload
                             *
                             * or:
                             *
                             *   IPv4 + ICMP
                             */
                            if ((reply[0] & 0xFF) == 0x45) {

                                int ihl =
                                        (reply[0] & 0x0F)
                                                * 4;

                                if (ihl >= 20
                                        && received >= ihl + 8) {

                                    offset = ihl;
                                }
                            }

                            int replyType =
                                    reply[offset]
                                            & 0xFF;

                            int replyCode =
                                    reply[offset + 1]
                                            & 0xFF;

                            if (replyType != 0
                                    || replyCode != 0) {

                                debug(
                                        "ICMP NOT ECHO REPLY "
                                                + "type="
                                                + replyType
                                                + " code="
                                                + replyCode
                                );

                                return;
                            }

                            byte[] icmp =
                                    new byte[
                                            8 + payload.length
                                    ];

                            icmp[0] = 0;
                            icmp[1] = 0;

                            icmp[4] =
                                    (byte)
                                            (identifier >>> 8);

                            icmp[5] =
                                    (byte)
                                            identifier;

                            icmp[6] =
                                    (byte)
                                            (sequence >>> 8);

                            icmp[7] =
                                    (byte)
                                            sequence;

                            System.arraycopy(
                                    payload,
                                    0,
                                    icmp,
                                    8,
                                    payload.length
                            );

                            int replyChecksum =
                                    icmpChecksum(
                                            icmp
                                    );

                            icmp[2] =
                                    (byte)
                                            (replyChecksum >>> 8);

                            icmp[3] =
                                    (byte)
                                            replyChecksum;

                            ByteBuffer output =
                                    ByteBufferPool.acquire();

                            output.clear();

                            /*
                             * Reply goes back to the original
                             * application:
                             *
                             * source = target IP
                             * destination = app's original IP
                             */
                            output.put(
                                    (byte) 0x45
                            );

                            output.put((byte) 0);

                            output.putShort(
                                    (short)
                                            (
                                                    20
                                                            + icmp.length
                                            )
                            );

                            output.putShort(
                                    (short) 0
                            );

                            output.putShort(
                                    (short) 0
                            );

                            output.put(
                                    (byte) 64
                            );

                            output.put(
                                    (byte) 1
                            );

                            output.putShort(
                                    (short) 0
                            );

                            output.put(
                                    destination
                                            .getAddress(),
                                    0,
                                    4
                            );

                            output.put(
                                    source
                                            .getAddress(),
                                    0,
                                    4
                            );

                            output.put(
                                    icmp
                            );

                            fixIpv4Checksum(
                                    output
                            );

                            int resultLength =
                                    20 + icmp.length;

                            output.position(
                                    resultLength
                            );

                            output.limit(
                                    resultLength
                            );

                            networkToDeviceQueue.offer(
                                    output
                            );

                            debug(
                                    "ICMP REPLY "
                                            + destination
                                                    .getHostAddress()
                                            + " id="
                                            + identifier
                                            + " seq="
                                            + sequence
                            );

                        } catch (Exception e) {

                            debug(
                                    "ICMP ERROR "
                                            + Log.getStackTraceString(
                                            e
                                    )
                            );

                        } finally {

                            if (fd != null) {

                                try {
                                    Os.close(fd);
                                } catch (Exception ignored) {
                                }
                            }
                        }
                    }
                },
                "icmp-upstream"
        ).start();
    }

    private int icmpChecksum(
            byte[] data) {

        long sum = 0;

        int i = 0;

        while (i + 1 < data.length) {

            sum +=
                    ((data[i] & 0xFF) << 8)
                            | (data[i + 1] & 0xFF);

            i += 2;
        }

        if (i < data.length) {
            sum +=
                    (data[i] & 0xFF) << 8;
        }

        while ((sum >>> 16) != 0) {

            sum =
                    (sum & 0xFFFF)
                            + (sum >>> 16);
        }

        return (int) ((~sum) & 0xFFFF);
    }

    private void fixIpv4Checksum(
            ByteBuffer buffer) {

        ByteBuffer b =
                buffer.duplicate();

        b.position(0);

        b.putShort(
                10,
                (short) 0
        );

        int sum = 0;

        for (int i = 0; i < 20; i += 2) {

            sum +=
                    ((b.get(i) & 0xFF) << 8)
                            | (b.get(i + 1) & 0xFF);
        }

        while ((sum >>> 16) != 0) {

            sum =
                    (sum & 0xFFFF)
                            + (sum >>> 16);
        }

        b.putShort(
                10,
                (short)
                        ((~sum) & 0xFFFF)
        );
    }

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

        if (!running
                && executorService == null
                && vpnInterface == null) {
            return;
        }

        debug("VPN STOP BEGIN");

        running = false;

        stopUpstreamNetworkMonitor();

        /*
         * Wake both selectors before interrupting worker threads.
         */
        try {
            if (udpSelector != null) {
                udpSelector.wakeup();
            }
        } catch (Exception ignored) {
        }

        try {
            if (tcpSelector != null) {
                tcpSelector.wakeup();
            }
        } catch (Exception ignored) {
        }

        /*
         * Stop worker tasks first.
         *
         * Do NOT close selectors before workers have had a chance
         * to leave select()/register()/read().
         */
        if (executorService != null) {

            executorService.shutdownNow();

            try {
                executorService.awaitTermination(
                        1000,
                        TimeUnit.MILLISECONDS
                );
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (Exception ignored) {
            }

            executorService = null;
        }

        /*
         * Close TUN streams after worker shutdown.
         */
        try {
            if (tunIn != null) {
                tunIn.close();
            }
        } catch (IOException ignored) {
        }

        try {
            if (tunOut != null) {
                tunOut.close();
            }
        } catch (IOException ignored) {
        }

        tunIn = null;
        tunOut = null;

        /*
         * Only now close selectors.
         */
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

        udpSelector = null;
        tcpSelector = null;

        try {
            if (vpnInterface != null) {
                vpnInterface.close();
            }
        } catch (IOException ignored) {
        }

        vpnInterface = null;

        try {
            stopForeground(true);
        } catch (Exception ignored) {
        }

        try {
            stopSelf();
        } catch (Exception ignored) {
        }

        debug("VPN STOP COMPLETE");
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
