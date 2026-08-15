#!/data/data/com.termux/files/usr/bin/bash

set -e

ROOT="/sdcard/IPPulseScanner_PocoX7Pro_final-1/IPPulseScannerApp"

cd "$ROOT"

echo "=============================================="
echo " IPPulseScanner FINAL VPN UPDATE"
echo "=============================================="
echo

# ============================================================
# 1) Backup
# ============================================================

BACKUP=".backup_$(date +%Y%m%d_%H%M%S)"

mkdir -p "$BACKUP"

cp -f \
  app/src/main/java/com/ippulse/scanner/GamingVpnService.java \
  "$BACKUP/" 2>/dev/null || true

cp -f \
  app/src/main/java/com/ippulse/scanner/localvpn/TCPOutput.java \
  "$BACKUP/" 2>/dev/null || true

cp -f \
  app/src/main/java/com/ippulse/scanner/localvpn/UDPOutput.java \
  "$BACKUP/" 2>/dev/null || true

echo "[OK] Backup: $BACKUP"

# ============================================================
# 2) Remove only obsolete native/alternative implementation
# ============================================================

rm -f \
  app/src/main/java/com/ippulse/scanner/TProxyService.java

rm -f \
  app/src/main/java/com/ippulse/scanner/SocketRelay.java

rm -f \
  app/src/main/java/com/ippulse/scanner/LocalSocks5Server.java

rm -rf \
  app/src/main/jniLibs

rm -rf \
  app/src/main/java/com/ippulse/scanner/netguard

rm -rf \
  app/src/main/java/com/getsurfboard

# NOTE:
# Socks5Server.java is NOT deleted.

# ============================================================
# 3) Fix LocalVPN packages
# ============================================================

LOCALVPN="app/src/main/java/com/ippulse/scanner/localvpn"

for f in "$LOCALVPN"/*.java; do
    [ -f "$f" ] || continue

    sed -i \
      's/^package[[:space:]].*;/package com.ippulse.scanner.localvpn;/' \
      "$f"
done

# ============================================================
# 4) Fix TCPOutput
# ============================================================

TCP="$LOCALVPN/TCPOutput.java"

if [ -f "$TCP" ]; then

    sed -i \
      '/import .*LocalVPNService;/d' \
      "$TCP"

    if ! grep -q \
      '^import android.net.VpnService;' \
      "$TCP"; then

        sed -i \
          '/^package com\.ippulse\.scanner\.localvpn;/a import android.net.VpnService;' \
          "$TCP"
    fi

    sed -i \
      's/\bLocalVPNService\b/VpnService/g' \
      "$TCP"
fi

# ============================================================
# 5) Fix UDPOutput
# ============================================================

UDP="$LOCALVPN/UDPOutput.java"

if [ -f "$UDP" ]; then

    sed -i \
      '/import .*LocalVPNService;/d' \
      "$UDP"

    if ! grep -q \
      '^import android.net.VpnService;' \
      "$UDP"; then

        sed -i \
          '/^package com\.ippulse\.scanner\.localvpn;/a import android.net.VpnService;' \
          "$UDP"
    fi

    sed -i \
      's/\bLocalVPNService\b/VpnService/g' \
      "$UDP"
fi

# ============================================================
# 6) Write FINAL GamingVpnService.java
# ============================================================

cat > app/src/main/java/com/ippulse/scanner/GamingVpnService.java <<'JAVA'
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

    private static final String TAG =
            "GamingVpn";

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

    private int mtu = 1400;

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

            mtu =
                    intent.getIntExtra(
                            "mtu",
                            1400
                    );

            if (mtu < 1280 ||
                    mtu > 32767) {

                mtu = 1400;
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

                            String host =
                                    normalizeHost(
                                            e.getKey()
                                    );

                            String ip =
                                    e.getValue();

                            if (host != null &&
                                    ip != null &&
                                    !ip.trim().isEmpty()) {

                                hostsMap.put(
                                        host,
                                        ip.trim()
                                );
                            }
                        }
                    }
                }

            } catch (Throwable e) {

                Log.e(
                        TAG,
                        "hostsMap load error",
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
             * VPN address
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
                    mtu
            );

            /*
             * Required by the project.
             */
            builder.setBlocking(
                    true
            );

            /*
             * Don't capture this app itself.
             */
            try {

                builder.addDisallowedApplication(
                        getPackageName()
                );

            } catch (Exception e) {

                Log.w(
                        TAG,
                        "Cannot exclude own package",
                        e
                );
            }

            vpnInterface =
                    builder.establish();

            if (vpnInterface == null) {

                throw new IOException(
                        "VPN establish returned null"
                );
            }

            /*
             * Six workers:
             *
             * UDPInput
             * UDPOutput
             * TCPInput
             * TCPOutput
             * TUN Reader
             * TUN Writer
             */
            executorService =
                    Executors.newFixedThreadPool(6);

            /*
             * Network -> TUN queue
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
             * TUN -> Internet
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
             * TUN Reader
             */
            executorService.submit(
                    new TunReader(
                            vpnInterface.getFileDescriptor()
                    )
            );

            /*
             * TUN Writer
             */
            executorService.submit(
                    new TunWriter(
                            vpnInterface.getFileDescriptor()
                    )
            );

            /*
             * IMPORTANT:
             * Start flag after all workers exist.
             */
            running = true;

            Log.i(
                    TAG,
                    "VPN STARTED"
            );

            Log.i(
                    TAG,
                    "MTU=" + mtu
            );

            Log.i(
                    TAG,
                    "DNS=" + upstreamDns
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
     * Reads raw IP packets from TUN.
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
                    "TunReader START"
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

                    boolean transferred =
                            false;

                    try {

                        int read =
                                input.read(
                                        buffer
                                );

                        if (read <= 0) {
                            continue;
                        }

                        buffer.flip();

                        /*
                         * DNS is detected from raw IPv4/UDP.
                         * This avoids relying on Packet field names.
                         */
                        DnsRequest dns =
                                parseDnsRequest(
                                        buffer
                                );

                        if (dns != null) {

                            byte[] payload =
                                    extractPayload(
                                            buffer,
                                            dns.payloadOffset
                                    );

                            ByteBufferPool.release(
                                    buffer
                            );

                            buffer = null;

                            handleDns(
                                    dns,
                                    payload
                            );

                            continue;
                        }

                        /*
                         * Return to beginning before Packet parser.
                         */
                        buffer.position(0);

                        Packet packet =
                                new Packet(
                                        buffer
                                );

                        if (packet.isUDP()) {

                            deviceToNetworkUDPQueue.offer(
                                    packet
                            );

                            transferred = true;

                        } else if (packet.isTCP()) {

                            deviceToNetworkTCPQueue.offer(
                                    packet
                            );

                            transferred = true;

                        } else {

                            Log.d(
                                    TAG,
                                    "Unsupported IP protocol"
                            );
                        }

                    } catch (Throwable e) {

                        Log.e(
                                TAG,
                                "TUN packet processing error",
                                e
                        );

                    } finally {

                        /*
                         * Do not release if ownership went
                         * to UDPOutput/TCPOutput.
                         */
                        if (!transferred &&
                                buffer != null) {

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

                Log.i(
                        TAG,
                        "TunReader STOP"
                );
            }
        }
    }

    /*
     * Writes packets returned by TCPInput/UDPInput/DNS.
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
                    "TunWriter START"
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
                         * Worker-generated packet is positioned
                         * at its end.
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

                Log.i(
                        TAG,
                        "TunWriter STOP"
                );
            }
        }
    }

    /*
     * Detect DNS:
     *
     * IPv4
     * UDP
     * destination 10.0.0.1
     * destination port 53
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

            int versionIhl =
                    buffer.get(start) & 0xff;

            int version =
                    versionIhl >>> 4;

            if (version != 4) {
                return null;
            }

            int ihl =
                    (versionIhl & 0x0f) * 4;

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

            byte[] sourceIp =
                    new byte[4];

            byte[] destinationIp =
                    new byte[4];

            for (int i = 0; i < 4; i++) {

                sourceIp[i] =
                        buffer.get(
                                start + 12 + i
                        );

                destinationIp[i] =
                        buffer.get(
                                start + 16 + i
                        );
            }

            /*
             * 10.0.0.1
             */
            if ((destinationIp[0] & 0xff) != 10 ||
                    (destinationIp[1] & 0xff) != 0 ||
                    (destinationIp[2] & 0xff) != 0 ||
                    (destinationIp[3] & 0xff) != 1) {

                return null;
            }

            int udpOffset =
                    start + ihl;

            int sourcePort =
                    ((buffer.get(
                            udpOffset
                    ) & 0xff) << 8)
                    |
                    (buffer.get(
                            udpOffset + 1
                    ) & 0xff);

            int destinationPort =
                    ((buffer.get(
                            udpOffset + 2
                    ) & 0xff) << 8)
                    |
                    (buffer.get(
                            udpOffset + 3
                    ) & 0xff);

            if (destinationPort != DNS_PORT) {
                return null;
            }

            return new DnsRequest(
                    sourceIp,
                    destinationIp,
                    sourcePort,
                    destinationPort,
                    udpOffset + 8
            );

        } catch (Throwable e) {

            return null;
        }
    }

    private byte[] extractPayload(
            ByteBuffer buffer,
            int absoluteOffset
    ) {

        int base =
                buffer.position();

        int relative =
                absoluteOffset - base;

        if (relative < 0 ||
                relative > buffer.limit()) {

            return new byte[0];
        }

        ByteBuffer copy =
                buffer.duplicate();

        copy.position(
                relative
        );

        byte[] payload =
                new byte[
                        copy.remaining()
                ];

        copy.get(payload);

        return payload;
    }

    /*
     * DNS proxy.
     */
    private void handleDns(
            DnsRequest request,
            byte[] query
    ) {

        String domain =
                extractDnsDomain(
                        query
                );

        String mappedIp =
                null;

        if (domain != null) {

            synchronized (hostsMap) {

                mappedIp =
                        hostsMap.get(
                                normalizeHost(domain)
                        );
            }
        }

        /*
         * hostsMap match.
         */
        if (mappedIp != null &&
                isValidIpv4(mappedIp)) {

            try {

                byte[] response =
                        buildDnsAResponse(
                                query,
                                mappedIp
                        );

                enqueueDnsResponse(
                        request,
                        response
                );

                Log.d(
                        TAG,
                        "DNS MAP: " +
                                domain +
                                " -> " +
                                mappedIp
                );

                return;

            } catch (Throwable e) {

                Log.e(
                        TAG,
                        "Mapped DNS error",
                        e
                );
            }
        }

        /*
         * Otherwise:
         * 8.8.8.8
         */
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

                        /*
                         * DNS socket must bypass VPN.
                         */
                        if (!protect(socket)) {

                            throw new IOException(
                                    "protect(DNS socket) failed"
                            );
                        }

                        socket.setSoTimeout(
                                5000
                        );

                        InetAddress dnsServer =
                                InetAddress.getByName(
                                        upstreamDns
                                );

                        DatagramPacket outgoing =
                                new DatagramPacket(
                                        query,
                                        query.length,
                                        dnsServer,
                                        DNS_PORT
                                );

                        socket.send(
                                outgoing
                        );

                        byte[] receive =
                                new byte[4096];

                        DatagramPacket incoming =
                                new DatagramPacket(
                                        receive,
                                        receive.length
                                );

                        socket.receive(
                                incoming
                        );

                        byte[] response =
                                new byte[
                                        incoming.getLength()
                                ];

                        System.arraycopy(
                                incoming.getData(),
                                incoming.getOffset(),
                                response,
                                0,
                                incoming.getLength()
                        );

                        enqueueDnsResponse(
                                request,
                                response
                        );

                    } catch (Throwable e) {

                        Log.e(
                                TAG,
                                "DNS upstream error",
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
             * IPv4 header
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
             * Source = original DNS destination.
             */
            buffer.put(
                    request.destinationIp
            );

            /*
             * Destination = application.
             */
            buffer.put(
                    request.sourceIp
            );

            /*
             * UDP header
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
             * UDP checksum zero is valid for IPv4.
             */
            buffer.putShort(
                    (short) 0
           
cat > apply_final_vpn.sh <<'EOF'
#!/data/data/com.termux/files/usr/bin/bash

set -e

ROOT="/sdcard/IPPulseScanner_PocoX7Pro_final-1/IPPulseScannerApp"

cd "$ROOT"

echo "=============================================="
echo " IPPulseScanner FINAL VPN UPDATE"
echo "=============================================="
echo

# ============================================================
# 1) Backup
# ============================================================

BACKUP=".backup_$(date +%Y%m%d_%H%M%S)"

mkdir -p "$BACKUP"

cp -f \
  app/src/main/java/com/ippulse/scanner/GamingVpnService.java \
  "$BACKUP/" 2>/dev/null || true

cp -f \
  app/src/main/java/com/ippulse/scanner/localvpn/TCPOutput.java \
  "$BACKUP/" 2>/dev/null || true

cp -f \
  app/src/main/java/com/ippulse/scanner/localvpn/UDPOutput.java \
  "$BACKUP/" 2>/dev/null || true

echo "[OK] Backup: $BACKUP"

# ============================================================
# 2) Remove only obsolete native/alternative implementation
# ============================================================

rm -f \
  app/src/main/java/com/ippulse/scanner/TProxyService.java

rm -f \
  app/src/main/java/com/ippulse/scanner/SocketRelay.java

rm -f \
  app/src/main/java/com/ippulse/scanner/LocalSocks5Server.java

rm -rf \
  app/src/main/jniLibs

rm -rf \
  app/src/main/java/com/ippulse/scanner/netguard

rm -rf \
  app/src/main/java/com/getsurfboard

# NOTE:
# Socks5Server.java is NOT deleted.

# ============================================================
# 3) Fix LocalVPN packages
# ============================================================

LOCALVPN="app/src/main/java/com/ippulse/scanner/localvpn"

for f in "$LOCALVPN"/*.java; do
    [ -f "$f" ] || continue

    sed -i \
      's/^package[[:space:]].*;/package com.ippulse.scanner.localvpn;/' \
      "$f"
done

# ============================================================
# 4) Fix TCPOutput
# ============================================================

TCP="$LOCALVPN/TCPOutput.java"

if [ -f "$TCP" ]; then

    sed -i \
      '/import .*LocalVPNService;/d' \
      "$TCP"

    if ! grep -q \
      '^import android.net.VpnService;' \
      "$TCP"; then

        sed -i \
          '/^package com\.ippulse\.scanner\.localvpn;/a import android.net.VpnService;' \
          "$TCP"
    fi

    sed -i \
      's/\bLocalVPNService\b/VpnService/g' \
      "$TCP"
fi

# ============================================================
# 5) Fix UDPOutput
# ============================================================

UDP="$LOCALVPN/UDPOutput.java"

if [ -f "$UDP" ]; then

    sed -i \
      '/import .*LocalVPNService;/d' \
      "$UDP"

    if ! grep -q \
      '^import android.net.VpnService;' \
      "$UDP"; then

        sed -i \
          '/^package com\.ippulse\.scanner\.localvpn;/a import android.net.VpnService;' \
          "$UDP"
    fi

    sed -i \
      's/\bLocalVPNService\b/VpnService/g' \
      "$UDP"
fi

# ============================================================
# 6) Write FINAL GamingVpnService.java
# ============================================================

cat > app/src/main/java/com/ippulse/scanner/GamingVpnService.java <<'JAVA'
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

    private static final String TAG =
            "GamingVpn";

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

    private int mtu = 1400;

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

            mtu =
                    intent.getIntExtra(
                            "mtu",
                            1400
                    );

            if (mtu < 1280 ||
                    mtu > 32767) {

                mtu = 1400;
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

                            String host =
                                    normalizeHost(
                                            e.getKey()
                                    );

                            String ip =
                                    e.getValue();

                            if (host != null &&
                                    ip != null &&
                                    !ip.trim().isEmpty()) {

                                hostsMap.put(
                                        host,
                                        ip.trim()
                                );
                            }
                        }
                    }
                }

            } catch (Throwable e) {

                Log.e(
                        TAG,
                        "hostsMap load error",
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
             * VPN address
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
                    mtu
            );

            /*
             * Required by the project.
             */
            builder.setBlocking(
                    true
            );

            /*
             * Don't capture this app itself.
             */
            try {

                builder.addDisallowedApplication(
                        getPackageName()
                );

            } catch (Exception e) {

                Log.w(
                        TAG,
                        "Cannot exclude own package",
                        e
                );
            }

            vpnInterface =
                    builder.establish();

            if (vpnInterface == null) {

                throw new IOException(
                        "VPN establish returned null"
                );
            }

            /*
             * Six workers:
             *
             * UDPInput
             * UDPOutput
             * TCPInput
             * TCPOutput
             * TUN Reader
             * TUN Writer
             */
            executorService =
                    Executors.newFixedThreadPool(6);

            /*
             * Network -> TUN queue
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
             * TUN -> Internet
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
             * TUN Reader
             */
            executorService.submit(
                    new TunReader(
                            vpnInterface.getFileDescriptor()
                    )
            );

            /*
             * TUN Writer
             */
            executorService.submit(
                    new TunWriter(
                            vpnInterface.getFileDescriptor()
                    )
            );

            /*
             * IMPORTANT:
             * Start flag after all workers exist.
             */
            running = true;

            Log.i(
                    TAG,
                    "VPN STARTED"
            );

            Log.i(
                    TAG,
                    "MTU=" + mtu
            );

            Log.i(
                    TAG,
                    "DNS=" + upstreamDns
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
     * Reads raw IP packets from TUN.
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
                    "TunReader START"
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

                    boolean transferred =
                            false;

                    try {

                        int read =
                                input.read(
                                        buffer
                                );

                        if (read <= 0) {
                            continue;
                        }

                        buffer.flip();

                        /*
                         * DNS is detected from raw IPv4/UDP.
                         * This avoids relying on Packet field names.
                         */
                        DnsRequest dns =
                                parseDnsRequest(
                                        buffer
                                );

                        if (dns != null) {

                            byte[] payload =
                                    extractPayload(
                                            buffer,
                                            dns.payloadOffset
                                    );

                            ByteBufferPool.release(
                                    buffer
                            );

                            buffer = null;

                            handleDns(
                                    dns,
                                    payload
                            );

                            continue;
                        }

                        /*
                         * Return to beginning before Packet parser.
                         */
                        buffer.position(0);

                        Packet packet =
                                new Packet(
                                        buffer
                                );

                        if (packet.isUDP()) {

                            deviceToNetworkUDPQueue.offer(
                                    packet
                            );

                            transferred = true;

                        } else if (packet.isTCP()) {

                            deviceToNetworkTCPQueue.offer(
                                    packet
                            );

                            transferred = true;

                        } else {

                            Log.d(
                                    TAG,
                                    "Unsupported IP protocol"
                            );
                        }

                    } catch (Throwable e) {

                        Log.e(
                                TAG,
                                "TUN packet processing error",
                                e
                        );

                    } finally {

                        /*
                         * Do not release if ownership went
                         * to UDPOutput/TCPOutput.
                         */
                        if (!transferred &&
                                buffer != null) {

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

                Log.i(
                        TAG,
                        "TunReader STOP"
                );
            }
        }
    }

    /*
     * Writes packets returned by TCPInput/UDPInput/DNS.
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
                    "TunWriter START"
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
                         * Worker-generated packet is positioned
                         * at its end.
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

                Log.i(
                        TAG,
                        "TunWriter STOP"
                );
            }
        }
    }

    /*
     * Detect DNS:
     *
     * IPv4
     * UDP
     * destination 10.0.0.1
     * destination port 53
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

            int versionIhl =
                    buffer.get(start) & 0xff;

            int version =
                    versionIhl >>> 4;

            if (version != 4) {
                return null;
            }

            int ihl =
                    (versionIhl & 0x0f) * 4;

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

            byte[] sourceIp =
                    new byte[4];

            byte[] destinationIp =
                    new byte[4];

            for (int i = 0; i < 4; i++) {

                sourceIp[i] =
                        buffer.get(
                                start + 12 + i
                        );

                destinationIp[i] =
                        buffer.get(
                                start + 16 + i
                        );
            }

            /*
             * 10.0.0.1
             */
            if ((destinationIp[0] & 0xff) != 10 ||
                    (destinationIp[1] & 0xff) != 0 ||
                    (destinationIp[2] & 0xff) != 0 ||
                    (destinationIp[3] & 0xff) != 1) {

                return null;
            }

            int udpOffset =
                    start + ihl;

            int sourcePort =
                    ((buffer.get(
                            udpOffset
                    ) & 0xff) << 8)
                    |
                    (buffer.get(
                            udpOffset + 1
                    ) & 0xff);

            int destinationPort =
                    ((buffer.get(
                            udpOffset + 2
                    ) & 0xff) << 8)
                    |
                    (buffer.get(
                            udpOffset + 3
                    ) & 0xff);

            if (destinationPort != DNS_PORT) {
                return null;
            }

            return new DnsRequest(
                    sourceIp,
                    destinationIp,
                    sourcePort,
                    destinationPort,
                    udpOffset + 8
            );

        } catch (Throwable e) {

            return null;
        }
    }

    private byte[] extractPayload(
            ByteBuffer buffer,
            int absoluteOffset
    ) {

        int base =
                buffer.position();

        int relative =
                absoluteOffset - base;

        if (relative < 0 ||
                relative > buffer.limit()) {

            return new byte[0];
        }

        ByteBuffer copy =
                buffer.duplicate();

        copy.position(
                relative
        );

        byte[] payload =
                new byte[
                        copy.remaining()
                ];

        copy.get(payload);

        return payload;
    }

    /*
     * DNS proxy.
     */
    private void handleDns(
            DnsRequest request,
            byte[] query
    ) {

        String domain =
                extractDnsDomain(
                        query
                );

        String mappedIp =
                null;

        if (domain != null) {

            synchronized (hostsMap) {

                mappedIp =
                        hostsMap.get(
                                normalizeHost(domain)
                        );
            }
        }

        /*
         * hostsMap match.
         */
        if (mappedIp != null &&
                isValidIpv4(mappedIp)) {

            try {

                byte[] response =
                        buildDnsAResponse(
                                query,
                                mappedIp
                        );

                enqueueDnsResponse(
                        request,
                        response
                );

                Log.d(
                        TAG,
                        "DNS MAP: " +
                                domain +
                                " -> " +
                                mappedIp
                );

                return;

            } catch (Throwable e) {

                Log.e(
                        TAG,
                        "Mapped DNS error",
                        e
                );
            }
        }

        /*
         * Otherwise:
         * 8.8.8.8
         */
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

                        /*
                         * DNS socket must bypass VPN.
                         */
                        if (!protect(socket)) {

                            throw new IOException(
                                    "protect(DNS socket) failed"
                            );
                        }

                        socket.setSoTimeout(
                                5000
                        );

                        InetAddress dnsServer =
                                InetAddress.getByName(
                                        upstreamDns
                                );

                        DatagramPacket outgoing =
                                new DatagramPacket(
                                        query,
                                        query.length,
                                        dnsServer,
                                        DNS_PORT
                                );

                        socket.send(
                                outgoing
                        );

                        byte[] receive =
                                new byte[4096];

                        DatagramPacket incoming =
                                new DatagramPacket(
                                        receive,
                                        receive.length
                                );

                        socket.receive(
                                incoming
                        );

                        byte[] response =
                                new byte[
                                        incoming.getLength()
                                ];

                        System.arraycopy(
                                incoming.getData(),
                                incoming.getOffset(),
                                response,
                                0,
                                incoming.getLength()
                        );

                        enqueueDnsResponse(
                                request,
                                response
                        );

                    } catch (Throwable e) {

                        Log.e(
                                TAG,
                                "DNS upstream error",
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
             * IPv4 header
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
             * Source = original DNS destination.
             */
            buffer.put(
                    request.destinationIp
            );

            /*
             * Destination = application.
             */
            buffer.put(
                    request.sourceIp
            );

            /*
             * UDP header
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
             * UDP checksum zero is valid for IPv4.
             */
            buffer.putShort(
                    (short) 0
            );

            buffer.put(
                    dnsPayload
            );

            /*
             * IPv4 header checksum.
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
             * TunWriter performs flip().
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
                    "Invalid DNS question"
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
        response[0] = query[0];
        response[1] = query[1];

        /*
         * QR + RD + RA
         */
        response[2] = (byte) 0x81;
        response[3] = (byte) 0x80;

        /*
         * QDCOUNT = 1
         */
        response[4] = 0;
        response[5] = 1;

        /*
         * ANCOUNT = 1
         */
        response[6] = 0;
        response[7] = 1;

        /*
         * NSCOUNT / ARCOUNT
         */
        response[8] = 0;
        response[9] = 0;
        response[10] = 0;
        response[11] = 0;

        /*
         * Question section.
         */
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
        response[p++] = (byte) 0xC0;
        response[p++] = 0x0C;

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
         * TTL 60 seconds
         */
        response[p++] = 0;
        response[p++] = 0;
        response[p++] = 0;
        response[p++] = 60;

        /*
         * IPv4 length
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

    private static boolean isValidIpv4(
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

                int value =
                        Integer.parseInt(
                                part
                        );

                if (value < 0 ||
                        value > 255) {

                    return false;
                }
            }

            return true;

        } catch (
                NumberFormatException e
        ) {

            return false;
        }
    }

    private static int calculateChecksum(
            byte[] data,
            int offset,
            int length
    ) {

        long sum = 0;

        int end =
                offset +
                length;

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

    private static String normalizeHost(
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

    private synchronized void stopVpn() {

        Log.i(
                TAG,
                "VPN STOP"
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

        if (vpnInterface != null) {

            try {
                vpnInterface.close();
            } catch (Throwable ignored) {
            }

            vpnInterface = null;
        }

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
                    "Foreground error",
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
                        android.R.drawable.ic_dialog_info
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

            this.sourceIp =
                    sourceIp;

            this.destinationIp =
                    destinationIp;

            this.sourcePort =
                    sourcePort;

            this.destinationPort =
                    destinationPort;

            this.payloadOffset =
                    payloadOffset;
        }
    }
}
JAVA

# ============================================================
# 7) Verify critical LocalVPN pieces
# ============================================================

echo
echo "[CHECK] LocalVPN files..."

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

    if [ ! -f "$LOCALVPN/$f" ]; then

        echo "ERROR: Missing $LOCALVPN/$f"
        exit 1

    fi

done

if grep -R \
   -n \
   --include='*.java' \
   'LocalVPNService' \
   "$LOCALVPN" 2>/dev/null
then

    echo
    echo "ERROR: LocalVPNService references remain."
    exit 1

fi

grep -q \
  'addRoute("0.0.0.0", 0)' \
  "$SERVICE" || {
    echo "ERROR: Full tunnel route missing."
    exit 1
}

grep -q \
  'setMtu(' \
  "$SERVICE" || {
    echo "ERROR: setMtu missing."
    exit 1
}

grep -q \
  'addDnsServer(' \
  "$SERVICE" || {
    echo "ERROR: DNS missing."
    exit 1
}

echo "[OK] Critical checks passed."

# ============================================================
# 8) Build
# ============================================================

echo
echo "[BUILD] Starting Gradle..."

if [ -f "$ROOT/gradlew" ]; then

    chmod +x "$ROOT/gradlew" 2>/dev/null || true

    bash "$ROOT/gradlew" \
        clean \
        assembleDebug \
        --no-daemon \
        --stacktrace

else

    echo "[INFO] gradlew not found, using gradle..."

    gradle \
        clean \
        assembleDebug \
        --no-daemon \
        --stacktrace
fi

APK="$ROOT/app/build/outputs/apk/debug/app-debug.apk"

if [ ! -f "$APK" ]; then

    echo
    echo "ERROR: APK was not created."
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

# ============================================================
# 9) Git commit + push
# ============================================================

echo "[GIT] Adding changes..."

git add \
    app/src/main/java/com/ippulse/scanner/GamingVpnService.java \
    app/src/main/java/com/ippulse/scanner/localvpn/TCPOutput.java \
    app/src/main/java/com/ippulse/scanner/localvpn/UDPOutput.java \
    app/src/main/java/com/ippulse/scanner/TProxyService.java \
    app/src/main/java/com/ippulse/scanner/SocketRelay.java \
    app/src/main/java/com/ippulse/scanner/LocalSocks5Server.java \
    2>/dev/null || true

git add -A

if git diff --cached --quiet; then

    echo "[GIT] No changes to commit."

else

    git commit \
        -m "Final VPN: LocalVPN TCP UDP DNS hostsMap MTU"

fi

echo
echo "[GIT] Pushing to GitHub..."

git push origin main

echo
echo "=============================================="
echo " EVERYTHING DONE"
echo "=============================================="
echo
echo "GitHub:"
git remote get-url origin
echo
echo "APK:"
echo "$APK"
echo
echo "Backup:"
echo "$BACKUP"
echo
echo "=============================================="
