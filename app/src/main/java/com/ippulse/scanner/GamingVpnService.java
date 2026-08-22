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
        private static final int LOCALVPN_BUFFER_SIZE = 16384;

        @Override
        public void run() {

            byte[] readBytes =
                    new byte[READ_CHUNK];

            ByteBuffer pending =
                    ByteBuffer.allocate(MAX_IP_PACKET * 2);

            debug("TUN PACKET READER START");

            while (running
                    && !Thread.currentThread().isInterrupted()) {

                try {

                    int count =
                            tunIn.read(readBytes);

                    if (count < 0) {

                        debug("TUN READER EOF");
                        break;
                    }

                    if (count == 0) {
                        continue;
                    }

                    pending.compact();

                    if (pending.remaining() < count) {

                        debug(
                                "TUN PENDING OVERFLOW count="
                                        + count
                                        + " remaining="
                                        + pending.remaining()
                        );

                        pending.clear();
                        continue;
                    }

                    pending.put(
                            readBytes,
                            0,
                            count
                    );

                    pending.flip();

                    while (true) {

                        int available =
                                pending.remaining();

                        if (available < 20) {
                            break;
                        }

                        int startPos =
                                pending.position();

                        int versionIhl =
                                pending.get(startPos) & 0xFF;

                        int version =
                                (versionIhl >>> 4) & 0x0F;

                        int ihlWords =
                                versionIhl & 0x0F;

                        /*
                         * IPv6 is intentionally dropped, but the
                         * ENTIRE IPv6 frame is consumed so framing
                         * stays aligned.
                         */
                        if (version == 6) {

                            if (available < 40) {
                                break;
                            }

                            int payloadLength =
                                    ((pending.get(startPos + 4) & 0xFF) << 8)
                                            | (pending.get(startPos + 5) & 0xFF);

                            int total =
                                    40 + payloadLength;

                            if (total < 40
                                    || total > MAX_IP_PACKET) {

                                debug(
                                        "TUN INVALID IPV6 LENGTH "
                                                + total
                                );

                                pending.position(
                                        startPos + 1
                                );

                                continue;
                            }

                            if (available < total) {
                                break;
                            }

                            debug(
                                    "TUN IPV6 DROPPED len="
                                            + total
                            );

                            pending.position(
                                    startPos + total
                            );

                            continue;
                        }

                        if (version != 4
                                || ihlWords < 5) {

                            debug(
                                    "TUN INVALID IP HEADER "
                                            + "version="
                                            + version
                                            + " ihl="
                                            + ihlWords
                            );

                            pending.position(
                                    startPos + 1
                            );

                            continue;
                        }

                        int headerLength =
                                ihlWords * 4;

                        if (available < headerLength) {
                            break;
                        }

                        int totalLength =
                                ((pending.get(startPos + 2) & 0xFF) << 8)
                                        | (pending.get(startPos + 3) & 0xFF);

                        if (totalLength < headerLength
                                || totalLength > MAX_IP_PACKET) {

                            debug(
                                    "TUN INVALID IP LENGTH "
                                            + totalLength
                                            + " header="
                                            + headerLength
                            );

                            pending.position(
                                    startPos + 1
                            );

                            continue;
                        }

                        if (available < totalLength) {
                            break;
                        }

                        /*
                         * LocalVPN works with 16KB direct buffers.
                         * currentMtu=1400 means normal packets fit.
                         */
                        if (totalLength > LOCALVPN_BUFFER_SIZE) {

                            debug(
                                    "TUN PACKET TOO LARGE "
                                            + totalLength
                            );

                            pending.position(
                                    startPos + totalLength
                            );

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

                            pending.position(
                                    startPos + totalLength
                            );

                            continue;
                        }

                        ByteBuffer slice =
                                pending.slice();

                        slice.limit(totalLength);

                        packetBuffer.put(slice);
                        packetBuffer.flip();
                        packetBuffer.limit(totalLength);

                        pending.position(
                                startPos + totalLength
                        );

                        processTunPacket(
                                packetBuffer
                        );
                    }

                    pending.compact();

                } catch (Exception e) {

                    if (!running) {
                        break;
                    }

                    Log.e(
                            TAG,
                            "TUN reader error",
                            e
                    );

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
                     * Every producer leaves the buffer positioned at
                     * packet end and limit at packet end.
                     */
                    int packetLength =
                            buffer.limit();

                    if (packetLength <= 0
                            || packetLength > 16384) {

                        debug(
                                "TUN WRITE INVALID PACKET len="
                                        + packetLength
                        );

                        continue;
                    }

                    /*
                     * Convert [0..packetLength] into the exact byte[]
                     * consumed by FileOutputStream.
                     */
                    byte[] packet =
                            new byte[packetLength];

                    ByteBuffer duplicate =
                            buffer.duplicate();

                    duplicate.position(0);
                    duplicate.limit(packetLength);

                    duplicate.get(packet);

                    /*
                     * Blocking FileOutputStream write.
                     */
                    tunOut.write(
                            packet,
                            0,
                            packet.length
                    );

                    tunOut.flush();

                    debug(
                            "TUN WRITE OK len="
                                    + packetLength
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
