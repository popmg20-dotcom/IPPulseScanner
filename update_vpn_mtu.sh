#!/usr/bin/env bash
set -e

TMP_DIR="./tmp_bin"
rm -rf "$TMP_DIR"
mkdir -p "$TMP_DIR"

echo "[1/6] Creating package directories..."
mkdir -p app/src/main/java/com/hev/socks5
mkdir -p app/src/main/java/com/ippulse/scanner
mkdir -p app/src/main/jniLibs/arm64-v8a
mkdir -p app/src/main/jniLibs/armeabi-v7a
mkdir -p app/src/main/jniLibs/x86_64

echo "[2/6] Fetching binary release links..."
RELEASE_JSON=$(curl -sSL -H "User-Agent: Mozilla/5.0" "https://api.github.com/repos/heiher/hev-socks5-tunnel/releases/latest" || true)

ARM64_URL=$(echo "$RELEASE_JSON" | grep -o 'https://[^"]*arm64-v8a[^"]*' | head -n 1)
ARMV7_URL=$(echo "$RELEASE_JSON" | grep -o 'https://[^"]*armeabi-v7a[^"]*' | head -n 1)
X86_64_URL=$(echo "$RELEASE_JSON" | grep -o 'https://[^"]*x86_64[^"]*' | head -n 1)

if [ -z "$ARM64_URL" ]; then
    echo "API limit reached. Scraping GitHub release page..."
    RELEASE_HTML=$(curl -sSL -H "User-Agent: Mozilla/5.0" "https://github.com/heiher/hev-socks5-tunnel/releases/latest" || true)
    ARM64_URL=$(echo "$RELEASE_HTML" | grep -o '/heiher/hev-socks5-tunnel/releases/download/[^"]*arm64-v8a[^"]*' | head -n 1 | sed 's|^|https://github.com|')
    ARMV7_URL=$(echo "$RELEASE_HTML" | grep -o '/heiher/hev-socks5-tunnel/releases/download/[^"]*armeabi-v7a[^"]*' | head -n 1 | sed 's|^|https://github.com|')
    X86_64_URL=$(echo "$RELEASE_HTML" | grep -o '/heiher/hev-socks5-tunnel/releases/download/[^"]*x86_64[^"]*' | head -n 1 | sed 's|^|https://github.com|')
fi

if [ -z "$ARM64_URL" ]; then
    echo "Scraping failed. Using direct fallback version..."
    TAG="2.17.1"
    ARM64_URL="https://github.com/heiher/hev-socks5-tunnel/releases/download/${TAG}/hev-socks5-tunnel-android-arm64-v8a"
    ARMV7_URL="https://github.com/heiher/hev-socks5-tunnel/releases/download/${TAG}/hev-socks5-tunnel-android-armeabi-v7a"
    X86_64_URL="https://github.com/heiher/hev-socks5-tunnel/releases/download/${TAG}/hev-socks5-tunnel-android-x86_64"
fi

download_and_extract() {
    local url="$1"
    local arch="$2"
    local target_dir="$TMP_DIR/$arch"
    mkdir -p "$target_dir"

    echo "Downloading $arch from: $url"
    local filename
    filename=$(basename "$url" | cut -d'?' -f1)
    curl -sSL -f -H "User-Agent: Mozilla/5.0" -L "$url" -o "$TMP_DIR/$filename"

    if [[ "$filename" == *.zip ]]; then
        unzip -o "$TMP_DIR/$filename" -d "$target_dir" || true
    elif [[ "$filename" == *.tar.xz ]] || [[ "$filename" == *.tar.gz ]] || [[ "$filename" == *.tgz ]]; then
        tar -xf "$TMP_DIR/$filename" -C "$target_dir" || true
    else
        unzip -o "$TMP_DIR/$filename" -d "$target_dir" 2>/dev/null || tar -xf "$TMP_DIR/$filename" -C "$target_dir" 2>/dev/null || true
    fi

    local so_file
    so_file=$(find "$target_dir" -name "*.so" -o -name "libhev-socks5-tunnel.so" | head -n 1)

    if [ -n "$so_file" ]; then
        cp "$so_file" "app/src/main/jniLibs/$arch/libhev-socks5-tunnel.so"
        echo "Installed libhev-socks5-tunnel.so for $arch"
    elif [ -s "$TMP_DIR/$filename" ]; then
        cp "$TMP_DIR/$filename" "app/src/main/jniLibs/$arch/libhev-socks5-tunnel.so"
        echo "Installed libhev-socks5-tunnel.so for $arch (direct binary)"
    else
        echo "Error: Failed to process binary for $arch"
        exit 1
    fi
}

download_and_extract "$ARM64_URL" "arm64-v8a"
download_and_extract "$ARMV7_URL" "armeabi-v7a"
download_and_extract "$X86_64_URL" "x86_64"

rm -rf "$TMP_DIR"

echo "[3/6] Writing JNI Wrapper: HevSocks5Tunnel.java..."
cat << 'JNI_EOF' > app/src/main/java/com/hev/socks5/HevSocks5Tunnel.java
package com.hev.socks5;

public class HevSocks5Tunnel {
    static {
        try {
            System.loadLibrary("hev-socks5-tunnel");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }

    public static native void HevSocks5TunnelStart(String config_path, int fd);
    public static native void HevSocks5TunnelStop();
    public static native boolean HevSocks5TunnelTProxy();
}
JNI_EOF

echo "[4/6] Writing Helper: LocalSocks5Server.java..."
cat << 'SOCKS_EOF' > app/src/main/java/com/ippulse/scanner/LocalSocks5Server.java
package com.ippulse.scanner;

import android.net.VpnService;
import android.util.Log;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LocalSocks5Server {
    private static final String TAG = "LocalSocks5Server";
    private final VpnService vpnService;
    private final HashMap<String, String> hostsMap;
    private final String upstreamDns;
    private final int port;

    private ServerSocket serverSocket;
    private DatagramSocket relayUdpSocket;
    private volatile boolean running = false;
    private ExecutorService executor;

    public LocalSocks5Server(VpnService vpnService, int port, HashMap<String, String> hostsMap, String upstreamDns) {
        this.vpnService = vpnService;
        this.port = port;
        this.hostsMap = hostsMap != null ? hostsMap : new HashMap<>();
        this.upstreamDns = upstreamDns != null ? upstreamDns : "8.8.8.8";
    }

    public void start() throws Exception {
        running = true;
        executor = Executors.newCachedThreadPool();
        serverSocket = new ServerSocket(port, 50, InetAddress.getByName("127.0.0.1"));
        
        executor.execute(this::acceptTcpLoop);
        
        relayUdpSocket = new DatagramSocket(0, InetAddress.getByName("127.0.0.1"));
        executor.execute(this::acceptUdpLoop);

        Log.i(TAG, "Local SOCKS5 running on 127.0.0.1:" + port);
    }

    public int getUdpRelayPort() {
        return relayUdpSocket != null ? relayUdpSocket.getLocalPort() : 0;
    }

    private void acceptTcpLoop() {
        while (running && !serverSocket.isClosed()) {
            try {
                Socket client = serverSocket.accept();
                executor.execute(() -> handleTcpClient(client));
            } catch (Exception e) {
                if (!running) break;
            }
        }
    }

    private void handleTcpClient(Socket client) {
        try {
            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();

            int ver = in.read();
            if (ver != 5) { client.close(); return; }
            int nmethods = in.read();
            byte[] methods = new byte[nmethods];
            in.read(methods);
            out.write(new byte[]{0x05, 0x00});
            out.flush();

            in.read();
            int cmd = in.read();
            in.read();
            int atyp = in.read();

            String host = "";
            if (atyp == 1) {
                byte[] ipBytes = new byte[4];
                in.read(ipBytes);
                host = InetAddress.getByAddress(ipBytes).getHostAddress();
            } else if (atyp == 3) {
                int len = in.read();
                byte[] domainBytes = new byte[len];
                in.read(domainBytes);
                host = new String(domainBytes);
            } else if (atyp == 4) {
                byte[] ip6Bytes = new byte[16];
                in.read(ip6Bytes);
                host = InetAddress.getByAddress(ip6Bytes).getHostAddress();
            }

            int portHi = in.read();
            int portLo = in.read();
            int dstPort = ((portHi & 0xFF) << 8) | (portLo & 0xFF);

            if (cmd == 1) {
                if (hostsMap.containsKey(host)) {
                    host = hostsMap.get(host);
                }

                Socket targetSocket = new Socket();
                vpnService.protect(targetSocket);
                targetSocket.connect(new InetSocketAddress(host, dstPort), 10000);

                out.write(new byte[]{0x05, 0x00, 0x00, 0x01, 127, 0, 0, 1, 0, 0});
                out.flush();

                executor.execute(() -> pipe(in, targetSocket.getOutputStream()));
                pipe(targetSocket.getInputStream(), out);

                targetSocket.close();
                client.close();
            } else if (cmd == 3) {
                int uPort = getUdpRelayPort();
                out.write(new byte[]{0x05, 0x00, 0x00, 0x01, 127, 0, 0, 1,
                        (byte) ((uPort >> 8) & 0xFF),
                        (byte) (uPort & 0xFF)});
                out.flush();
                while (running && client.getInputStream().read() != -1) {}
                client.close();
            } else {
                client.close();
            }
        } catch (Exception ignored) {}
    }

    private void pipe(InputStream in, OutputStream out) {
        byte[] buf = new byte[16384];
        int len;
        try {
            while ((len = in.read(buf)) != -1) {
                out.write(buf, 0, len);
                out.flush();
            }
        } catch (Exception ignored) {}
    }

    private void acceptUdpLoop() {
        byte[] buffer = new byte[65535];
        while (running && !relayUdpSocket.isClosed()) {
            try {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                relayUdpSocket.receive(packet);
                executor.execute(() -> handleUdpPacket(packet));
            } catch (Exception e) {
                if (!running) break;
            }
        }
    }

    private void handleUdpPacket(DatagramPacket packet) {
        try {
            byte[] data = packet.getData();
            int len = packet.getLength();
            if (len < 10) return;

            int atyp = data[3] & 0xFF;
            int headerLen = 4;
            String dstAddr = "";

            if (atyp == 1) {
                byte[] ip = new byte[4];
                System.arraycopy(data, 4, ip, 0, 4);
                dstAddr = InetAddress.getByAddress(ip).getHostAddress();
                headerLen += 4;
            } else if (atyp == 3) {
                int domainLen = data[4] & 0xFF;
                dstAddr = new String(data, 5, domainLen);
                headerLen += 1 + domainLen;
            } else if (atyp == 4) {
                byte[] ip6 = new byte[16];
                System.arraycopy(data, 4, ip6, 0, 16);
                dstAddr = InetAddress.getByAddress(ip6).getHostAddress();
                headerLen += 16;
            }

            int dstPort = ((data[headerLen] & 0xFF) << 8) | (data[headerLen + 1] & 0xFF);
            headerLen += 2;

            int payloadLen = len - headerLen;
            byte[] payload = new byte[payloadLen];
            System.arraycopy(data, headerLen, payload, 0, payloadLen);

            byte[] responsePayload = null;
            if ("10.0.0.1".equals(dstAddr) && dstPort == 53) {
                String domain = extractDomain(payload);
                if (domain != null && hostsMap.containsKey(domain)) {
                    responsePayload = buildDnsResponse(payload, hostsMap.get(domain));
                } else {
                    responsePayload = forwardDns(payload, upstreamDns);
                }
            } else {
                responsePayload = forwardGenericUdp(dstAddr, dstPort, payload);
            }

            if (responsePayload != null) {
                byte[] socksResp = new byte[headerLen + responsePayload.length];
                System.arraycopy(data, 0, socksResp, 0, headerLen);
                System.arraycopy(responsePayload, 0, socksResp, headerLen, responsePayload.length);

                DatagramPacket outPacket = new DatagramPacket(
                        socksResp, socksResp.length, packet.getAddress(), packet.getPort());
                relayUdpSocket.send(outPacket);
            }
        } catch (Exception e) {
            Log.e(TAG, "UDP handling error", e);
        }
    }

    private byte[] forwardGenericUdp(String dstAddr, int dstPort, byte[] payload) {
        try {
            DatagramSocket socket = new DatagramSocket();
            vpnService.protect(socket);
            socket.setSoTimeout(3000);
            DatagramPacket req = new DatagramPacket(payload, payload.length, InetAddress.getByName(dstAddr), dstPort);
            socket.send(req);

            byte[] resBuf = new byte[65535];
            DatagramPacket res = new DatagramPacket(resBuf, resBuf.length);
            socket.receive(res);
            socket.close();

            byte[] resp = new byte[res.getLength()];
            System.arraycopy(res.getData(), 0, resp, 0, res.getLength());
            return resp;
        } catch (Exception e) {
            return null;
        }
    }

    private byte[] forwardDns(byte[] query, String dnsServer) {
        try {
            DatagramSocket socket = new DatagramSocket();
            vpnService.protect(socket);
            socket.setSoTimeout(2500);
            DatagramPacket req = new DatagramPacket(query, query.length, InetAddress.getByName(dnsServer), 53);
            socket.send(req);

            byte[] resBuf = new byte[2048];
            DatagramPacket res = new DatagramPacket(resBuf, resBuf.length);
            socket.receive(res);
            socket.close();

            byte[] resp = new byte[res.getLength()];
            System.arraycopy(res.getData(), 0, resp, 0, res.getLength());
            return resp;
        } catch (Exception e) {
            return null;
        }
    }

    private String extractDomain(byte[] data) {
        try {
            int pos = 12;
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            while (pos < data.length) {
                int labelLength = data[pos] & 0xFF;
                if (labelLength == 0) break;
                if ((labelLength & 0xC0) == 0xC0) {
                    if (pos + 1 >= data.length) return null;
                    int pointer = ((labelLength & 0x3F) << 8) | (data[pos + 1] & 0xFF);
                    return extractDomainFromOffset(data, pointer);
                }
                if (labelLength > 63) return null;
                pos++;
                if (pos + labelLength > data.length) return null;
                if (!first) sb.append('.');
                for (int i = 0; i < labelLength; i++) sb.append((char) (data[pos + i] & 0xFF));
                first = false;
                pos += labelLength;
            }
            return sb.toString().toLowerCase();
        } catch (Exception e) {
            return null;
        }
    }

    private String extractDomainFromOffset(byte[] data, int offset) {
        try {
            int pos = offset;
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            while (pos < data.length) {
                int labelLength = data[pos] & 0xFF;
                if (labelLength == 0) break;
                if ((labelLength & 0xC0) == 0xC0) {
                    if (pos + 1 >= data.length) return null;
                    int pointer = ((labelLength & 0x3F) << 8) | (data[pos + 1] & 0xFF);
                    return extractDomainFromOffset(data, pointer);
                }
                if (labelLength > 63) return null;
                pos++;
                if (pos + labelLength > data.length) return null;
                if (!first) sb.append('.');
                for (int i = 0; i < labelLength; i++) sb.append((char) (data[pos + i] & 0xFF));
                first = false;
                pos += labelLength;
            }
            return sb.toString().toLowerCase();
        } catch (Exception e) {
            return null;
        }
    }

    private byte[] buildDnsResponse(byte[] query, String ip) {
        try {
            ByteBuffer response = ByteBuffer.allocate(1024);
            response.put(query[0]);
            response.put(query[1]);
            response.put((byte) 0x81);
            response.put((byte) 0x80);
            response.putShort((short) 1);
            response.putShort((short) 1);
            response.putShort((short) 0);
            response.putShort((short) 0);

            int pos = 12;
            while (pos < query.length && query[pos] != 0) {
                response.put(query[pos++]);
            }
            response.put((byte) 0);
            pos++;
            response.put(query[pos++]);
            response.put(query[pos++]);
            response.put(query[pos++]);
            response.put(query[pos++]);

            response.put((byte) 0xC0);
            response.put((byte) 0x0C);
            response.putShort((short) 1);
            response.putShort((short) 1);
            response.putInt(60);
            response.putShort((short) 4);
            String[] ipParts = ip.split("\\.");
            for (String part : ipParts) {
                response.put((byte) Integer.parseInt(part));
            }

            byte[] result = new byte[response.position()];
            System.arraycopy(response.array(), 0, result, 0, response.position());
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public void stop() {
        running = false;
        try { if (serverSocket != null) serverSocket.close(); } catch (Exception ignored) {}
        try { if (relayUdpSocket != null) relayUdpSocket.close(); } catch (Exception ignored) {}
        if (executor != null) executor.shutdownNow();
    }
}
SOCKS_EOF

echo "[5/6] Writing updated Service: GamingVpnService.java..."
cat << 'VPN_EOF' > app/src/main/java/com/ippulse/scanner/GamingVpnService.java
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

import com.hev.socks5.HevSocks5Tunnel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class GamingVpnService extends VpnService {

    private static final String TAG = "GamingVpn";
    private static final String ACTION_START = "com.ippulse.scanner.START";
    private static final String ACTION_STOP = "com.ippulse.scanner.STOP";
    private static final String CHANNEL_ID = "gaming_vpn";
    private static final String VPN_ADDRESS = "10.0.0.2";
    private static final String DNS_ADDRESS = "10.0.0.1";
    private static final int SOCKS_PORT = 10808;

    private ParcelFileDescriptor vpnInterface;
    private LocalSocks5Server socksServer;

    private HashMap<String, String> hostsMap = new HashMap<>();
    private String dns = "8.8.8.8";
    private int currentMtu = 1400;

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
        startVpn();
        return START_STICKY;
    }

    private void startForegroundCompatible() {
        Notification notification = buildNotification("VPN Active (Full Tunnel, MTU=" + currentMtu + ")");
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

            socksServer = new LocalSocks5Server(this, SOCKS_PORT, hostsMap, dns);
            socksServer.start();

            Builder builder = new Builder();
            builder.setSession("Gaming VPN");
            builder.addAddress(VPN_ADDRESS, 32);
            builder.addRoute("0.0.0.0", 0);
            builder.addDnsServer(DNS_ADDRESS);
            builder.setMtu(currentMtu);
            builder.setBlocking(true);

            vpnInterface = builder.establish();
            if (vpnInterface == null) {
                Log.e(TAG, "Failed to establish VPN interface");
                stopVpn();
                return;
            }

            File configFile = new File(getFilesDir(), "hev-socks5.conf");
            writeSocksConfigFile(configFile, currentMtu, SOCKS_PORT);

            int fd = vpnInterface.getFd();
            new Thread(() -> {
                try {
                    HevSocks5Tunnel.HevSocks5TunnelStart(configFile.getAbsolutePath(), fd);
                } catch (Exception e) {
                    Log.e(TAG, "Error in native tun2socks thread", e);
                }
            }, "HevSocks5TunnelThread").start();

            Log.i(TAG, "Full-tunnel VPN started successfully. MTU=" + currentMtu);
        } catch (Exception e) {
            Log.e(TAG, "Error starting VPN", e);
            stopVpn();
        }
    }

    private void writeSocksConfigFile(File file, int mtu, int socksPort) throws IOException {
        String configContent = "tunnel:\n" +
                "  mtu: " + mtu + "\n" +
                "socks5:\n" +
                "  port: " + socksPort + "\n" +
                "  address: 127.0.0.1\n" +
                "  udp: 'udp'\n";
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(configContent);
        }
    }

    private void stopVpn() {
        try {
            HevSocks5Tunnel.HevSocks5TunnelStop();
        } catch (Throwable ignored) {}

        if (socksServer != null) {
            socksServer.stop();
            socksServer = null;
        }

        try {
            if (vpnInterface != null) vpnInterface.close();
        } catch (IOException ignored) {}
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
VPN_EOF

echo "[6/6] Committing and pushing to repository..."
git add .
git commit -m "Fix: Handle raw binary files alongside archive extraction"
git push origin main

echo "All tasks completed successfully!"
