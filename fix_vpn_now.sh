#!/bin/bash
set -e

# ===================== تنظیمات =====================
PKG="com.ippulse.scanner"
PKG_DIR="app/src/main/java/$(echo $PKG | tr '.' '/')"
JNI_DIR="app/src/main/jniLibs/arm64-v8a"

# ===================== ۱. پاک‌سازی =====================
rm -rf app/src/main/java/com/ippulse/scanner/localvpn
rm -f app/src/main/java/com/ippulse/scanner/TProxyService.java
rm -f app/src/main/java/com/ippulse/scanner/LocalSocks5Server.java
rm -f app/src/main/java/com/ippulse/scanner/GamingVpnService.java
rm -f app/src/main/jniLibs/arm64-v8a/libhev-socks5-tunnel.so
rm -f update_vpn.sh fix_hev_final.sh

# ===================== ۲. Gradle =====================
cat > settings.gradle <<'GRADLE'
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
rootProject.name = "IPPulseScanner"
include ':app'
GRADLE

cat > app/build.gradle <<'BUILD'
plugins {
    id 'com.android.application'
}

android {
    namespace 'com.ippulse.scanner'
    compileSdk 35

    defaultConfig {
        applicationId 'com.ippulse.scanner'
        minSdk 26
        targetSdk 35
        versionCode 1
        versionName '1.0'
    }

    buildTypes {
        release {
            minifyEnabled false
        }
    }
}

dependencies {
    implementation 'com.github.heiher:hev-socks5-tunnel:2.17.1'
}
BUILD

# ===================== ۳. ساخت پوشه‌ها =====================
mkdir -p "$PKG_DIR"
mkdir -p "$JNI_DIR"

# ===================== ۴. TProxyService.java =====================
cat > "$PKG_DIR/TProxyService.java" <<JAVA
package $PKG;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import hev.socks5.tunnel.Tunnel;

public class TProxyService {
    private final Context context;
    private Tunnel tunnel;

    public TProxyService(Context context) {
        this.context = context;
        this.tunnel = new Tunnel();
    }

    public void start(int fd, int mtu) {
        File configFile = new File(context.getCacheDir(), "tun.yml");
        String config =
                "tunnel:\n" +
                "  mtu: " + mtu + "\n" +
                "  ipv4: '10.0.0.2'\n" +
                "socks5:\n" +
                "  address: '127.0.0.1'\n" +
                "  port: 1080\n" +
                "  udp: 'udp'\n";

        try (FileOutputStream fos = new FileOutputStream(configFile)) {
            fos.write(config.getBytes());
            tunnel.StartService(configFile.getAbsolutePath(), fd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if (tunnel != null) tunnel.StopService();
    }
}
JAVA

# ===================== ۵. LocalSocks5Server.java (نسخه کامل و واقعی) =====================
cat > "$PKG_DIR/LocalSocks5Server.java" <<'JAVA'
package com.ippulse.scanner;

import android.net.VpnService;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LocalSocks5Server {
    private static final String TAG = "LocalSocks5";
    private final VpnService vpnService;
    private final int port;
    private final Map<String, String> hostsMap;
    private final String fallbackDns;
    private ServerSocket serverSocket;
    private boolean running = false;
    private ExecutorService executor;

    public LocalSocks5Server(VpnService vpnService, int port, Map<String, String> hostsMap, String fallbackDns) {
        this.vpnService = vpnService;
        this.port = port;
        this.hostsMap = hostsMap != null ? hostsMap : new HashMap<>();
        this.fallbackDns = fallbackDns != null ? fallbackDns : "8.8.8.8";
    }

    public void start() {
        running = true;
        executor = Executors.newCachedThreadPool();
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(port, 50, InetAddress.getByName("127.0.0.1"));
                Log.i(TAG, "SOCKS5 listening on 127.0.0.1:" + port);
                while (running) {
                    final Socket client = serverSocket.accept();
                    executor.execute(() -> handleClient(client));
                }
            } catch (Exception e) {
                if (running) Log.e(TAG, "Server error", e);
            }
        }).start();
    }

    private void handleClient(Socket client) {
        try (Socket socket = client) {
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            // Greeting
            int version = in.read();
            if (version != 5) return;
            int nmethods = in.read();
            byte[] methods = new byte[nmethods];
            in.read(methods);
            out.write(new byte[]{5, 0}); // NO AUTH
            out.flush();

            // Request
            int ver = in.read();
            int cmd = in.read();
            in.read(); // RSV
            int atyp = in.read();

            String destHost = "";
            if (atyp == 1) {
                byte[] b = new byte[4]; in.read(b); destHost = InetAddress.getByAddress(b).getHostAddress();
            } else if (atyp == 3) {
                int len = in.read(); byte[] b = new byte[len]; in.read(b); destHost = new String(b, StandardCharsets.UTF_8);
            } else if (atyp == 4) {
                byte[] b = new byte[16]; in.read(b); destHost = InetAddress.getByAddress(b).getHostAddress();
            }

            byte[] portBuf = new byte[2]; in.read(portBuf);
            int destPort = ((portBuf[0] & 0xFF) << 8) | (portBuf[1] & 0xFF);

            if (cmd == 1) {
                handleTcpConnect(socket, in, out, destHost, destPort);
            } else if (cmd == 3) {
                handleUdpAssociate(socket, out);
            }
        } catch (Exception e) {
            try { client.close(); } catch (Exception ignored) {}
        }
    }

    private void handleTcpConnect(Socket client, InputStream in, OutputStream out, String destHost, int destPort) {
        try {
            Socket target = new Socket();
            vpnService.protect(target); // Critical: bypass VPN

            InetAddress address;
            if (destPort == 53) {
                address = InetAddress.getByName(hostsMap.getOrDefault(destHost, fallbackDns));
            } else {
                address = InetAddress.getByName(destHost);
            }

            target.connect(new InetSocketAddress(address, destPort), 10000);

            // SOCKS success
            out.write(new byte[]{5, 0, 0, 1, 127, 0, 0, 1, (byte)(port >> 8), (byte)(port & 0xFF)});
            out.flush();

            // Relay
            relayDataAsync(in, target.getOutputStream(), target.getInputStream(), out, client, target);
        } catch (Exception e) {
            try {
                out.write(new byte[]{5, 1, 0, 1, 0, 0, 0, 0, 0, 0});
                out.flush();
                client.close();
            } catch (Exception ignored) {}
        }
    }

    private void handleUdpAssociate(Socket controlSocket, OutputStream out) {
        try {
            DatagramSocket udpSocket = new DatagramSocket(new InetSocketAddress("127.0.0.1", 0));
            vpnService.protect(udpSocket);
            int relayPort = udpSocket.getLocalPort();
            out.write(new byte[]{5, 0, 0, 1, 127, 0, 0, 1, (byte)(relayPort >> 8), (byte)(relayPort & 0xFF)});
            out.flush();

            final DatagramSocket socket = udpSocket;
            executor.execute(() -> runUdpRelay(socket));

            InputStream in = controlSocket.getInputStream();
            while (in.read() != -1) {}
        } catch (Exception ignored) {}
        finally {
            try { controlSocket.close(); } catch (Exception ignored) {}
        }
    }

    private void runUdpRelay(DatagramSocket relaySocket) {
        byte[] buffer = new byte[65535];
        while (running && !relaySocket.isClosed()) {
            try {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                relaySocket.receive(packet);

                // Parse SOCKS5 UDP header (RSV + FRAG + ATYP + ADDR + PORT)
                byte[] data = packet.getData();
                int offset = packet.getOffset();
                int length = packet.getLength();

                if (length < 10) continue;
                if (data[offset] != 0 || data[offset+1] != 0 || data[offset+2] != 0) continue;

                int atyp = data[offset+3] & 0xFF;
                int pos = offset + 4;
                String host;
                if (atyp == 1) {
                    byte[] ip = new byte[4];
                    System.arraycopy(data, pos, ip, 0, 4);
                    pos += 4;
                    host = InetAddress.getByAddress(ip).getHostAddress();
                } else if (atyp == 3) {
                    int len = data[pos++] & 0xFF;
                    host = new String(data, pos, len, StandardCharsets.UTF_8);
                    pos += len;
                } else continue;

                int destPort = ((data[pos] & 0xFF) << 8) | (data[pos+1] & 0xFF);
                pos += 2;
                byte[] payload = new byte[length - (pos - offset)];
                System.arraycopy(data, pos, payload, 0, payload.length);

                // Forward to destination
                DatagramSocket outbound = new DatagramSocket();
                vpnService.protect(outbound);
                outbound.setSoTimeout(5000);

                InetAddress targetAddr;
                if (destPort == 53) {
                    targetAddr = InetAddress.getByName(hostsMap.getOrDefault(host, fallbackDns));
                } else {
                    targetAddr = InetAddress.getByName(host);
                }

                DatagramPacket outPacket = new DatagramPacket(payload, payload.length, targetAddr, destPort);
                outbound.send(outPacket);

                // Wait for response
                byte[] respBuf = new byte[65535];
                DatagramPacket respPacket = new DatagramPacket(respBuf, respBuf.length);
                outbound.receive(respPacket);

                // Wrap response in SOCKS5 UDP header
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                baos.write(new byte[]{0,0,0}); // RSV+FRAG
                baos.write(1); // ATYP IPv4
                byte[] respIp = respPacket.getAddress().getAddress();
                baos.write(respIp);
                baos.write((respPacket.getPort() >> 8) & 0xFF);
                baos.write(respPacket.getPort() & 0xFF);
                baos.write(respPacket.getData(), respPacket.getOffset(), respPacket.getLength());
                byte[] wrapped = baos.toByteArray();

                // Send back to HEV via relay socket
                DatagramPacket response = new DatagramPacket(wrapped, wrapped.length,
                        InetAddress.getByName("127.0.0.1"), relaySocket.getLocalPort());
                relaySocket.send(response);

                outbound.close();
            } catch (Exception e) {
                // ignore
            }
        }
    }

    private void relayDataAsync(final InputStream in1, final OutputStream out1,
                                final InputStream in2, final OutputStream out2,
                                final Socket s1, final Socket s2) {
        executor.execute(() -> {
            try {
                byte[] buf = new byte[8192];
                int len;
                while ((len = in1.read(buf)) != -1) {
                    out1.write(buf, 0, len);
                    out1.flush();
                }
            } catch (Exception ignored) {}
            finally {
                try { s1.close(); } catch (Exception ignored) {}
                try { s2.close(); } catch (Exception ignored) {}
            }
        });

        executor.execute(() -> {
            try {
                byte[] buf = new byte[8192];
                int len;
                while ((len = in2.read(buf)) != -1) {
                    out2.write(buf, 0, len);
                    out2.flush();
                }
            } catch (Exception ignored) {}
            finally {
                try { s1.close(); } catch (Exception ignored) {}
                try { s2.close(); } catch (Exception ignored) {}
            }
        });
    }

    public void stop() {
        running = false;
        try { if (serverSocket != null) serverSocket.close(); } catch (Exception ignored) {}
        if (executor != null) executor.shutdownNow();
    }
}
JAVA

# ===================== ۶. GamingVpnService.java =====================
cat > "$PKG_DIR/GamingVpnService.java" <<JAVA
package $PKG;

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

import java.util.HashMap;

public class GamingVpnService extends VpnService {
    private static final String TAG = "GamingVpn";
    private static final String ACTION_START = "com.ippulse.scanner.START";
    private static final String ACTION_STOP = "com.ippulse.scanner.STOP";
    private static final String CHANNEL_ID = "gaming_vpn";
    private static final int SOCKS_PORT = 1080;

    private ParcelFileDescriptor vpnInterface;
    private LocalSocks5Server socksServer;
    private TProxyService tProxyService;
    private HashMap<String, String> hostsMap = new HashMap<>();
    private String dns = "8.8.8.8";
    private int currentMtu = 1400;
    private boolean isRunning = false;

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
        new Thread(this::startVpn, "GamingVpnStarter").start();
        return START_STICKY;
    }

    private void startForegroundCompatible() {
        Notification notification = buildNotification("Gaming VPN Active");
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
        if (isRunning) return;
        try {
            socksServer = new LocalSocks5Server(this, SOCKS_PORT, hostsMap, dns);
            socksServer.start();

            Builder builder = new Builder();
            builder.setSession("Gaming VPN");
            builder.addAddress("10.0.0.2", 24);
            builder.addDnsServer(dns);
            builder.addRoute("0.0.0.0", 0);
            builder.setMtu(currentMtu);
            builder.setBlocking(true);

            vpnInterface = builder.establish();
            if (vpnInterface == null) throw new IllegalStateException("establish() failed");

            int fd = vpnInterface.getFd();
            tProxyService = new TProxyService(this);
            tProxyService.start(fd, currentMtu);

            isRunning = true;
            Log.i(TAG, "VPN started with MTU " + currentMtu);
        } catch (Exception e) {
            Log.e(TAG, "Failed to start VPN", e);
            stopVpn();
        }
    }

    private void stopVpn() {
        isRunning = false;
        if (tProxyService != null) {
            tProxyService.stop();
            tProxyService = null;
        }
        if (socksServer != null) {
            socksServer.stop();
            socksServer = null;
        }
        try { if (vpnInterface != null) vpnInterface.close(); } catch (Exception ignored) {}
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
JAVA

# ===================== ۷. پاک‌سازی فایل‌های قدیمی =====================
rm -f update_vpn.sh fix_hev_final.sh

# ===================== ۸. کامیت و push =====================
git add .
git commit -m "Fix nested heredoc and add complete SOCKS5 server"
git push origin main

echo "✅ اسکریپت با موفقیت اجرا شد."
