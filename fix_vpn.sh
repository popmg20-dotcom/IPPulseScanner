#!/data/data/com.termux/files/usr/bin/bash

set -euo pipefail

ROOT="$(pwd)"
APP="$ROOT/app"
PKG="$APP/src/main/java/com/ippulse/scanner"
LOCALVPN="$PKG/localvpn"

SERVICE="$PKG/GamingVpnService.java"
TCP="$LOCALVPN/TCPOutput.java"
UDP="$LOCALVPN/UDPOutput.java"

BACKUP="$ROOT/.ippulse_backup_$(date +%Y%m%d_%H%M%S)"

echo "=============================================="
echo " IPPulseScanner VPN FIX"
echo "=============================================="

[ -d "$APP" ] || {
    echo "ERROR: app directory not found"
    exit 1
}

[ -d "$LOCALVPN" ] || {
    echo "ERROR: localvpn directory not found"
    exit 1
}

for f in \
    ByteBufferPool.java \
    LRUCache.java \
    Packet.java \
    TCB.java \
    TCPInput.java \
    TCPOutput.java \
    UDPInput.java \
    UDPOutput.java
do
    [ -f "$LOCALVPN/$f" ] || {
        echo "ERROR: missing $LOCALVPN/$f"
        exit 1
    }
done

echo "[1] Backup..."
mkdir -p "$BACKUP"

cp -f "$SERVICE" "$BACKUP/" 2>/dev/null || true
cp -f "$TCP" "$BACKUP/" 2>/dev/null || true
cp -f "$UDP" "$BACKUP/" 2>/dev/null || true

echo "Backup: $BACKUP"

echo "[2] Fix LocalVPN package..."

for f in "$LOCALVPN"/*.java; do
    sed -i \
        's/^package[[:space:]].*;/package com.ippulse.scanner.localvpn;/' \
        "$f"
done

echo "[3] Fix TCPOutput / UDPOutput..."

sed -i '/import .*LocalVPNService;/d' "$TCP"
sed -i '/import .*LocalVPNService;/d' "$UDP"

grep -q '^import android.net.VpnService;' "$TCP" || \
sed -i \
'/^package com\.ippulse\.scanner\.localvpn;/a import android.net.VpnService;' \
"$TCP"

grep -q '^import android.net.VpnService;' "$UDP" || \
sed -i \
'/^package com\.ippulse\.scanner\.localvpn;/a import android.net.VpnService;' \
"$UDP"

sed -i 's/\bLocalVPNService\b/VpnService/g' "$TCP"
sed -i 's/\bLocalVPNService\b/VpnService/g' "$UDP"

if grep -R -n --include='*.java' 'LocalVPNService' "$LOCALVPN" 2>/dev/null; then
    echo "ERROR: LocalVPNService reference remains"
    exit 1
fi

echo "[4] Writing GamingVpnService..."

cat > "$SERVICE" <<'JAVA'
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
import com.ippulse.scanner.localvpn.TCB;
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

    private static final String ACTION_START =
            "com.ippulse.scanner.START";

    private static final String ACTION_STOP =
            "com.ippulse.scanner.STOP";

    private static final String CHANNEL_ID =
            "gaming_vpn";

    private static final String VPN_ADDRESS =
            "10.0.0.2";

    private static final String VPN_DNS =
            "10.0.0.1";

    private static final String DEFAULT_DNS =
            "8.8.8.8";

    private static final int DNS_PORT = 53;

    private volatile boolean running = false;

    private int currentMtu = 1400;

    private String upstreamDns =
            DEFAULT_DNS;

    private ParcelFileDescriptor vpnInterface;

    private Selector udpSelector;
    private Selector tcpSelector;

    private ExecutorService executorService;

    private ConcurrentLinkedQueue<Packet>
            deviceToNetworkUDPQueue;

    private ConcurrentLinkedQueue<Packet>
            deviceToNetworkTCPQueue;

    private ConcurrentLinkedQueue<ByteBuffer>
            networkToDeviceQueue;

    private final HashMap<String, String>
            hostsMap = new HashMap<>();

    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public int onStartCommand(
            Intent intent,
            int flags,
            int startId
    ) {

        if (intent != null) {

            if (ACTION_STOP.equals(
                    intent.getAction()
            )) {

                stopVpn();

                return START_NOT_STICKY;
            }

            currentMtu =
                    intent.getIntExtra(
                            "mtu",
                            1400
                    );

            if (currentMtu < 1280 ||
                    currentMtu > 32767) {

                currentMtu = 1400;
            }

            String dns =
                    intent.getStringExtra(
                            "dns"
                    );

            if (dns != null &&
                    !dns.trim().isEmpty()) {

                upstreamDns =
                        dns.trim();

            } else {

                upstreamDns =
                        DEFAULT_DNS;
            }

            try {

                SerializableHosts h =
                        (SerializableHosts)
                                intent.getSerializableExtra(
                                        "hosts"
                                );

                synchronized (hostsMap) {

                    hostsMap.clear();

                    if (h != null &&
                            h.map != null) {

                        for (
                                Map.Entry<String, String> e :
                                h.map.entrySet()
                        ) {

                            String key =
                                    normalizeHost(
                                            e.getKey()
                                    );

                            String value =
                                    e.getValue();

                            if (key != null &&
                                    value != null &&
                                    !value.trim().isEmpty()) {

                                hostsMap.put(
                                        key,
                                        value.trim()
                                );
                            }
                        }
                    }
                }

            } catch (Throwable e) {

                Log.e(
                        TAG,
                        "hostsMap load failed",
                        e
                );
            }
        }

        createNotificationChannel();
        startForegroundCompatible();

        if (!running) {
            startVpn();
        }

        return START_STICKY;
    }

    private synchronized void startVpn() {

        if (running) {
            return;
        }

        try {

            deviceToNetworkUDPQueue =
                    new ConcurrentLinkedQueue<>();

            deviceToNetworkTCPQueue =
                    new ConcurrentLinkedQueue<>();

            networkToDeviceQueue =
                    new ConcurrentLinkedQueue<>();

            udpSelector =
                    Selector.open();

            tcpSelector =
                    Selector.open();

            Builder builder =
                    new Builder();

            builder.setSession(
                    "IPPulseScanner"
            );

            /*
             * VPN ADDRESS
             */
            builder.addAddress(
                    VPN_ADDRESS,
                    32
            );

            /*
             * FULL TUNNEL
             */
            builder.addRoute(
                    "0.0.0.0",
                    0
            );

            /*
             * DNS endpoint inside VPN
             */
            builder.addDnsServer(
                    VPN_DNS
            );

            /*
             * MTU
             */
            builder.setMtu(
                    currentMtu
            );

            /*
             * Required by the project
             */
            builder.setBlocking(
                    true
            );

            /*
             * Don't capture the VPN app itself.
             */
            try {

                builder.addDisallowedApplication(
                        getPackageName()
                );

            } catch (Exception e) {

                Log.w(
                        TAG,
                        "Could not exclude own package",
                        e
                );
            }

            vpnInterface =
                    builder.establish();

            if (vpnInterface == null) {

                throw new IOException(
                        "VpnService.establish() returned null"
                );
            }

            /*
             * IMPORTANT:
             *
             * TUN reader and TUN writer are separate.
             */
            executorService =
                    Executors.newFixedThreadPool(6);

            /*
             * Network -> VPN
             */
            executorService.submit(
                    new UDPInput(
                            networkToDeviceQueue,
                            udpSelector
                    )
            );

            executorService.submit(
                    new TCPInput(
                            networkToDeviceQueue,
                            tcpSelector
                    )
            );

            /*
             * VPN -> Network
             */
            executorService.submit(
                    new UDPOutput(
                            deviceToNetworkUDPQueue,
                            udpSelector,
                            this
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
             * TUN reader
             */
            executorService.submit(
                    new TunReader(
                            vpnInterface.getFileDescriptor()
                    )
            );

            /*
             * TUN writer
             */
            executorService.submit(
                    new TunWriter(
                            vpnInterface.getFileDescriptor()
                    )
            );

            /*
             * Start only after everything is ready.
             */
            running = true;

            Log.i(
                    TAG,
                    "VPN STARTED"
            );

            Log.i(
                    TAG,
                    "MTU=" +
                            currentMtu
            );

            Log.i(
                    TAG,
                    "DNS=" +
                            upstreamDns
            );

        } catch (Throwable e) {

            Log.e(
                    TAG,
                    "VPN START FAILED",
                    e
            );

            stopVpn();
        }
    }

    /*
     * Reads packets from TUN.
     */
    private final class TunReader
            implements Runnable {

        private final FileDescriptor fd;

        TunReader(
                FileDescriptor fd
        ) {

            this.fd = fd;
        }

        @Override
        public void run() {

            Log.i(
                    TAG,
                    "TunReader started"
            );

            FileChannel input = null;

            try {

                input =
                        new FileInputStream(
                                fd
                        ).getChannel();

                while (
                        running &&
                        !Thread.currentThread()
                                .isInterrupted()
                ) {

                    ByteBuffer buffer =
                            ByteBufferPool.acquire();

                    boolean handedOff = false;

                    try {

                        int n =
                                input.read(
                                        buffer
                                );

                        if (n <= 0) {

                            continue;
                        }

                        buffer.flip();

                        DnsRequest dnsRequest =
                                parseDnsRequest(
                                        buffer
                                );

                        if (dnsRequest != null) {

                            byte[] dnsPayload =
                                    extractPayload(
                                            buffer,
                                            dnsRequest.payloadOffset
                                    );

                            handleDns(
                                    dnsRequest,
                                    dnsPayload
                            );

                            continue;
                        }

                        buffer.position(0);

                        Packet packet =
                                new Packet(
                                        buffer
                                );

                        if (packet.isUDP()) {

                            deviceToNetworkUDPQueue.offer(
                                    packet
                            );

                            handedOff = true;

                        } else if (packet.isTCP()) {

                            deviceToNetworkTCPQueue.offer(
                                    packet
                            );

                            handedOff = true;

                        } else {

                            Log.d(
                                    TAG,
                                    "Unsupported IP protocol"
                            );
                        }

                    } catch (Throwable e) {

                        Log.e(
                                TAG,
                                "Packet processing failed",
                                e
                        );

                    } finally {

                        if (!handedOff) {

                            try {
                                ByteBufferPool.release(
                                        buffer
                                );
                            } catch (Throwable ignored) {
                            }
                        }
                    }
                }

            } catch (Throwable e) {

                if (running) {

                    Log.e(
                            TAG,
                            "TunReader failed",
                            e
                    );
                }

            } finally {

                try {

                    if (input != null) {
                        input.close();
                    }

                } catch (Throwable ignored) {
                }
            }
        }
    }

    /*
     * Writes packets coming back from TCPInput/UDPInput/DNS.
     */
    private final class TunWriter
            implements Runnable {

        private final FileDescriptor fd;

        TunWriter(
                FileDescriptor fd
        ) {

            this.fd = fd;
        }

        @Override
        public void run() {

            Log.i(
                    TAG,
                    "TunWriter started"
            );

            FileChannel output = null;

            try {

                output =
                        new FileOutputStream(
                                fd
                        ).getChannel();

                while (
                        running &&
                        !Thread.currentThread()
                                .isInterrupted()
                ) {

                    ByteBuffer buffer =
                            networkToDeviceQueue.poll();

                    if (buffer == null) {

                        try {

                            Thread.sleep(5);

                        } catch (
                                InterruptedException e
                        ) {

                            Thread.currentThread()
                                    .interrupt();

                            break;
                        }

                        continue;
                    }

                    try {

                        /*
                         * LocalVPN workers leave position
                         * after their generated packet.
                         */
                        buffer.flip();

                        while (
                                buffer.hasRemaining()
                        ) {

                            output.write(
                                    buffer
                            );
                        }

                    } finally {

                        ByteBufferPool.release(
                                buffer
                        );
                    }
                }

            } catch (Throwable e) {

                if (running) {

                    Log.e(
                            TAG,
                            "TunWriter failed",
                            e
                    );
                }

            } finally {

                try {

                    if (output != null) {
                        output.close();
                    }

                } catch (Throwable ignored) {
                }
            }
        }
    }

    /*
     * Detect:
     *
     * IPv4
     * UDP
     * destination = 10.0.0.1
     * destination port = 53
     */
    private DnsRequest parseDnsRequest(
            ByteBuffer buffer
    ) {

        try {

            if (buffer.remaining() < 28) {
                return null;
            }

            int start =
                    buffer.position();

            int vihl =
                    buffer.get(start) & 0xff;

            if ((vihl >>> 4) != 4) {
                return null;
            }

            int ihl =
                    (vihl & 0x0f) * 4;

            if (ihl < 20) {
                return null;
            }

            if (buffer.remaining() <
                    ihl + 8) {

                return null;
            }

            int protocol =
                    buffer.get(
                            start + 9
                    ) & 0xff;

            if (protocol != 17) {
                return null;
            }

            byte[] srcIp =
                    new byte[4];

            byte[] dstIp =
                    new byte[4];

            for (int i = 0; i < 4; i++) {

                srcIp[i] =
                        buffer.get(
                                start + 12 + i
                        );

                dstIp[i] =
                        buffer.get(
                                start + 16 + i
                        );
            }

            /*
             * 10.0.0.1
             */
            if ((dstIp[0] & 0xff) != 10 ||
                    (dstIp[1] & 0xff) != 0 ||
                    (dstIp[2] & 0xff) != 0 ||
                    (dstIp[3] & 0xff) != 1) {

                return null;
            }

            int udpOffset =
                    start + ihl;

            int srcPort =
                    ((buffer.get(
                            udpOffset
                    ) & 0xff) << 8)
                    |
                    (buffer.get(
                            udpOffset + 1
                    ) & 0xff);

            int dstPort =
                    ((buffer.get(
                            udpOffset + 2
                    ) & 0xff) << 8)
                    |
                    (buffer.get(
                            udpOffset + 3
                    ) & 0xff);

            if (dstPort != DNS_PORT) {
                return null;
            }

            return new DnsRequest(
                    srcIp,
                    dstIp,
                    srcPort,
                    dstPort,
                    udpOffset + 8
            );

        } catch (Throwable e) {

            return null;
        }
    }

    private byte[] extractPayload(
            ByteBuffer buffer,
            int payloadOffset
    ) {

        int base =
                buffer.position();

        int relative =
                payloadOffset - base;

        if (relative < 0 ||
                relative > buffer.limit()) {

            return new byte[0];
        }

        ByteBuffer duplicate =
                buffer.duplicate();

        duplicate.position(
                relative
        );

        byte[] result =
                new byte[
                        duplicate.remaining()
                ];

        duplicate.get(result);

        return result;
    }

    /*
     * DNS:
     *
     * hostsMap -> direct response
     * otherwise -> 8.8.8.8
     */
    private void handleDns(
            DnsRequest request,
            byte[] query
    ) {

        String domain =
                extractDnsDomain(
                        query
                );

        String mapped = null;

        if (domain != null) {

            synchronized (hostsMap) {

                mapped =
                        hostsMap.get(
                                normalizeHost(domain)
                        );
            }
        }

        if (mapped != null &&
                isValidIpv4(mapped)) {

            try {

                byte[] response =
                        buildDnsAResponse(
                                query,
                                mapped
                        );

                enqueueDnsResponse(
                        request,
                        response
                );

                Log.d(
                        TAG,
                        "hostsMap: " +
                                domain +
                                " -> " +
                                mapped
                );

                return;

            } catch (Throwable e) {

                Log.e(
                        TAG,
                        "Mapped DNS failed",
                        e
                );
            }
        }

        forwardDns(
                request,
                query
        );
    }

    private void forwardDns(
            DnsRequest request,
            byte[] query
    ) {

        new Thread(
                () -> {

                    DatagramSocket socket =
                            null;

                    try {

                        socket =
                                new DatagramSocket();

                        if (!protect(socket)) {

                            throw new IOException(
                                    "DNS socket protect failed"
                            );
                        }

                        socket.setSoTimeout(
                                5000
                        );

                        DatagramPacket out =
                                new DatagramPacket(
                                        query,
                                        query.length,
                                        InetAddress.getByName(
                                                upstreamDns
                                        ),
                                        DNS_PORT
                                );

                        socket.send(out);

                        byte[] recv =
                                new byte[4096];

                        DatagramPacket in =
                                new DatagramPacket(
                                        recv,
                                        recv.length
                                );

                        socket.receive(in);

                        byte[] dnsResponse =
                                new byte[
                                        in.getLength()
                                ];

                        System.arraycopy(
                                in.getData(),
                                in.getOffset(),
                                dnsResponse,
                                0,
                                in.getLength()
                        );

                        enqueueDnsResponse(
                                request,
                                dnsResponse
                        );

                    } catch (Throwable e) {

                        Log.e(
                                TAG,
                                "DNS forward failed",
                                e
                        );

                    } finally {

                        if (socket != null) {

                            try {
                                socket.close();
                            } catch (Throwable ignored) {
                            }
                        }
                    }

                },
                "IPPulse-DNS"
        ).start();
    }

    private void enqueueDnsResponse(
            DnsRequest request,
            byte[] dnsPayload
    ) {

        ByteBuffer buffer = null;

        try {

            int udpLength =
                    8 +
                    dnsPayload.length;

            int totalLength =
                    20 +
                    udpLength;

            buffer =
                    ByteBufferPool.acquire();

            if (totalLength >
                    buffer.capacity()) {

                throw new IOException(
                        "DNS response too large"
                );
            }

            buffer.clear();

            /*
             * IPv4 header.
             */
            buffer.put(
                    (byte) 0x45
            );

            buffer.put(
                    (byte) 0
            );

            buffer.putShort(
                    (short) totalLength
            );

            buffer.putShort(
                    (short) 0
            );

            buffer.putShort(
                    (short) 0
            );

            buffer.put(
                    (byte) 64
            );

            buffer.put(
                    (byte) 17
            );

            buffer.putShort(
                    (short) 0
            );

            /*
             * 10.0.0.1
             */
            buffer.put(
                    request.destinationIp
            );

            /*
             * Original app IP
             */
            buffer.put(
                    request.sourceIp
            );

            /*
             * UDP
             */
            buffer.putShort(
                    (short)
                            request.destinationPort
            );

            buffer.putShort(
                    (short)
                            request.sourcePort
            );

            buffer.putShort(
                    (short) udpLength
            );

            /*
             * IPv4 UDP checksum 0 = allowed.
             */
            buffer.putShort(
                    (short) 0
            );

            buffer.put(
                    dnsPayload
            );

            /*
             * IP checksum.
             */
            byte[] raw =
                    new byte[
                            buffer.position()
                    ];

            buffer.flip();
            buffer.get(raw);

            int checksum =
                    calculateChecksum(
                            raw,
                            0,
                            20
                    );

            raw[10] =
                    (byte)
                            (checksum >>> 8);

            raw[11] =
                    (byte)
                            checksum;

            buffer.clear();
            buffer.put(raw);

            /*
             * TunWriter will flip().
             */
            networkToDeviceQueue.offer(
                    buffer
            );

            buffer = null;

        } catch (Throwable e) {

            Log.e(
                    TAG,
                    "DNS response build failed",
                    e
            );

        } finally {

            if (buffer != null) {

                try {
                    ByteBufferPool.release(
                            buffer
                    );
                } catch (Throwable ignored) {
                }
            }
        }
    }

    private String extractDnsDomain(
            byte[] query
    ) {

        if (query == null ||
                query.length < 17) {

            return null;
        }

        try {

            int pos = 12;

            StringBuilder domain =
                    new StringBuilder();

            while (
                    pos < query.length
            ) {

                int len =
                        query[pos++] & 0xff;

                if (len == 0) {
                    break;
                }

                if (len > 63 ||
                        pos + len >
                                query.length) {

                    return null;
                }

                if (domain.length() > 0) {
                    domain.append('.');
                }

                for (
                        int i = 0;
                        i < len;
                        i++
                ) {

                    domain.append(
                            (char)
                                    (query[pos++] &
                                            0xff)
                    );
                }
            }

            if (domain.length() == 0) {
                return null;
            }

            return normalizeHost(
                    domain.toString()
            );

        } catch (Throwable e) {

            return null;
        }
    }

    private byte[] buildDnsAResponse(
            byte[] query,
            String ip
    ) {

        int questionEnd =
                findQuestionEnd(
                        query
                );

        if (questionEnd < 0 ||
                questionEnd + 4 >
                        query.length) {

            throw new IllegalArgumentException(
                    "Invalid DNS query"
            );
        }

        int questionLength =
                questionEnd +
                4 -
                12;

        byte[] response =
                new byte[
                        12 +
                        questionLength +
                        16
                ];

        /*
         * Transaction ID
         */
        response[0] =
                query[0];

        response[1] =
                query[1];

        /*
         * QR + RD + RA
         */
        response[2] =
                (byte) 0x81;

        response[3] =
                (byte) 0x80;

        /*
         * QDCOUNT
         */
        response[4] = 0;
        response[5] = 1;

        /*
         * ANCOUNT
         */
        response[6] = 0;
        response[7] = 1;

        /*
         * no NS/Additional
         */
        response[8] = 0;
        response[9] = 0;
        response[10] = 0;
        response[11] = 0;

        System.arraycopy(
                query,
                12,
                response,
                12,
                questionLength
        );

        int p =
                12 +
                questionLength;

        /*
         * NAME pointer
         */
        response[p++] =
                (byte) 0xC0;

        response[p++] =
                0x0C;

        /*
         * TYPE A
         */
        response[p++] = 0;
        response[p++] = 1;

        /*
         * CLASS IN
         */
        response[p++] = 0;
        response[p++] = 1;

        /*
         * TTL = 60
         */
        response[p++] = 0;
        response[p++] = 0;
        response[p++] = 0;
        response[p++] = 60;

        /*
         * RDLENGTH
         */
        response[p++] = 0;
        response[p++] = 4;

        String[] parts =
                ip.split("\\.");

        for (
                String part :
                parts
        ) {

            response[p++] =
                    (byte)
                            Integer.parseInt(
                                    part
                            );
        }

        return response;
    }

    private int findQuestionEnd(
            byte[] query
    ) {

        int pos = 12;

        while (
                pos < query.length
        ) {

            int len =
                    query[pos++] & 0xff;

            if (len == 0) {

                return pos;
            }

            if (len > 63 ||
                    pos + len >
                            query.length) {

                return -1;
            }

            pos += len;
        }

        return -1;
    }

    private boolean isValidIpv4(
            String ip
    ) {

        if (ip == null) {
            return false;
        }

        String[] parts =
                ip.trim().split("\\.");

        if (parts.length != 4) {
            return false;
        }

        try {

            for (
                    String part :
                    parts
            ) {

                int n =
                        Integer.parseInt(
                                part
                        );

                if (n < 0 ||
                        n > 255) {

                    return false;
                }
            }

            return true;

        } catch (NumberFormatException e) {

            return false;
        }
    }

    private String normalizeHost(
            String host
    ) {

        if (host == null) {
            return null;
        }

        host =
                host.trim()
                        .toLowerCase(
                                Locale.US
                        );

        while (
                host.endsWith(".")
        ) {

            host =
                    host.substring(
                            0,
                            host.length() - 1
                    );
        }

        return host;
    }

    private int calculateChecksum(
            byte[] data,
            int offset,
            int length
    ) {

        long sum = 0;

        int end =
                offset + length;

        for (
                int i = offset;
                i + 1 < end;
                i += 2
        ) {

            sum +=
                    ((data[i] & 0xff) << 8)
                    |
                    (data[i + 1] & 0xff);
        }

        if ((length & 1) != 0) {

            sum +=
                    (data[end - 1] & 0xff)
                    << 8;
        }

        while (
                (sum >>> 16) != 0
        ) {

            sum =
                    (sum & 0xffff)
                    +
                    (sum >>> 16);
        }

        return (int)
                (~sum & 0xffff);
    }

    private synchronized void stopVpn() {

        Log.i(
                TAG,
                "Stopping VPN"
        );

        running = false;

        try {

            if (udpSelector != null) {
                udpSelector.wakeup();
            }

        } catch (Throwable ignored) {
        }

        try {

            if (tcpSelector != null) {
                tcpSelector.wakeup();
            }

        } catch (Throwable ignored) {
        }

        try {

            TCB.closeAll();

        } catch (Throwable ignored) {
        }

        if (executorService != null) {

            executorService.shutdownNow();
            executorService = null;
        }

        try {

            if (udpSelector != null) {
                udpSelector.close();
            }

        } catch (Throwable ignored) {
        }

        try {

            if (tcpSelector != null) {
                tcpSelector.close();
            }

        } catch (Throwable ignored) {
        }

        udpSelector = null;
        tcpSelector = null;

        try {

            if (vpnInterface != null) {
                vpnInterface.close();
            }

        } catch (Throwable ignored) {
        }

        vpnInterface = null;

        if (deviceToNetworkUDPQueue != null) {
            deviceToNetworkUDPQueue.clear();
        }

        if (deviceToNetworkTCPQueue != null) {
            deviceToNetworkTCPQueue.clear();
        }

        if (networkToDeviceQueue != null) {
            networkToDeviceQueue.clear();
        }

        deviceToNetworkUDPQueue = null;
        deviceToNetworkTCPQueue = null;
        networkToDeviceQueue = null;

        try {
            ByteBufferPool.clear();
        } catch (Throwable ignored) {
        }

        stopForeground(true);

        try {
            stopSelf();
        } catch (Throwable ignored) {
        }
    }

    @Override
    public void onDestroy() {

        stopVpn();

        super.onDestroy();
    }

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >=
                Build.VERSION_CODES.O) {

            NotificationChannel channel =
                    new NotificationChannel(
                            CHANNEL_ID,
                            "IPPulseScanner VPN",
                            NotificationManager
                                    .IMPORTANCE_LOW
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

    private void startForegroundCompatible() {

        Notification notification =
                buildNotification(
                        "VPN Active"
                );

        try {

            if (Build.VERSION.SDK_INT >=
                    Build.VERSION_CODES.Q) {

                startForeground(
                        1,
                        notification,
                        ServiceInfo
                                .FOREGROUND_SERVICE_TYPE_SPECIAL_USE
                );

            } else {

                startForeground(
                        1,
                        notification
                );
            }

        } catch (Throwable e) {

            Log.e(
                    TAG,
                    "startForeground failed",
                    e
            );
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
                Build.VERSION.SDK_INT >=
                        Build.VERSION_CODES.O
                ? new Notification.Builder(
                        this,
                        CHANNEL_ID
                )
                : new Notification.Builder(
                        this
                );

        return builder
                .setContentTitle(
                        "IPPulseScanner"
                )
                .setContentText(
                        text
                )
                .setSmallIcon(
                        android.R.drawable
                                .ic_dialog_info
                )
                .setContentIntent(
                        pendingIntent
                )
                .build();
    }

    public static void start(
            Context context,
            String dns,
            int mtu,
            HashMap<String, String> hostsMap
    ) {

        Intent intent =
                new Intent(
                        context,
                        GamingVpnService.class
                );

        intent.setAction(
                ACTION_START
        );

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

        if (Build.VERSION.SDK_INT >=
                Build.VERSION_CODES.O) {

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

        context.startService(
                intent
        );
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

    private static final class DnsRequest {

        final byte[] sourceIp;
        final byte[] destinationIp;

        final int sourcePort;
        final int destinationPort;

        final int payloadOffset;

        DnsRequest(
                byte[] sourceIp,
                byte[] destinationIp,
                int sourcePort,
                int destinationPort,
                int payloadOffset
        ) {

            this.sourceIp = sourceIp;
            this.destinationIp = destinationIp;
            this.sourcePort = sourcePort;
            this.destinationPort = destinationPort;
            this.payloadOffset = payloadOffset;
        }
    }
}
JAVA

echo "[5] Build..."

if [ -x "$ROOT/gradlew" ]; then

    chmod +x "$ROOT/gradlew"

    "$ROOT/gradlew" \
        clean \
        assembleDebug \
        --no-daemon \
        --stacktrace

else

    if ! command -v gradle >/dev/null 2>&1; then
        echo "ERROR: gradle/gradlew not found"
        exit 1
    fi

    gradle \
        clean \
        assembleDebug \
        --no-daemon \
        --stacktrace
fi

APK="$APP/build/outputs/apk/debug/app-debug.apk"

if [ ! -f "$APK" ]; then
    echo
    echo "BUILD FAILED: APK not found"
    exit 1
fi

echo
echo "=============================================="
echo " BUILD SUCCESS"
echo "=============================================="
echo
echo "APK:"
echo "$APK"
echo
echo "Backup:"
echo "$BACKUP"
echo

if command -v adb >/dev/null 2>&1; then

    COUNT=$(
        adb devices 2>/dev/null |
        awk 'NR>1 && $2=="device"{c++} END{print c+0}'
    )

    if [ "$COUNT" -gt 0 ]; then

        echo "ADB device detected."

        read -r -p \
            "Install APK now? [Y/n] " ANSWER

        ANSWER="${ANSWER:-Y}"

        if [[ "$ANSWER" =~ ^[Yy]$ ]]; then

            adb install -r "$APK"

            echo
            echo "APK installed."

        fi
    fi
fi

echo
echo "DONE."
