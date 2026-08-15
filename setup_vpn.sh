#!/bin/bash
set -e

echo "=== 1. Creating Directory Structures ==="
mkdir -p app/src/main/java/hev/socks5/tunnel
mkdir -p app/src/main/java/com/ippulse/scanner/socks
mkdir -p app/src/main/jniLibs/arm64-v8a

echo "=== 2. Creating Native JNI Bridge (hev.socks5.tunnel.TProxyService) ==="
cat << 'JEOF' > app/src/main/java/hev/socks5/tunnel/TProxyService.java
package hev.socks5.tunnel;

public class TProxyService {
    static {
        System.loadLibrary("hev-socks5-tunnel");
    }

    public static native void TProxyStartService(String configPath, int fd);
    public static native void TProxyStopService();
    public static native void TProxyGetStats(long[] stats);
}
JEOF

echo "=== 3. Writing LocalSocks5Server.java (SOCKS5 TCP/UDP + DNS Mapping) ==="
cat << 'JEOF' > app/src/main/java/com/ippulse/scanner/socks/LocalSocks5Server.java
package com.ippulse.scanner.socks;

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
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LocalSocks5Server {
    private static final String TAG = "LocalSocks5";
    private final int port;
    private final VpnService vpnService;
    private final Map<String, String> hostsMap;
    private final String fallbackDns;
    private ServerSocket serverSocket;
    private boolean isRunning = false;
    private ExecutorService threadPool;

    public LocalSocks5Server(VpnService vpnService, int port, Map<String, String> hostsMap, String fallbackDns) {
        this.vpnService = vpnService;
        this.port = port;
        this.hostsMap = hostsMap != null ? hostsMap : new HashMap<String, String>();
        this.fallbackDns = fallbackDns != null ? fallbackDns : "8.8.8.8";
    }

    public void start() {
        isRunning = true;
        threadPool = Executors.newCachedThreadPool();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    serverSocket = new ServerSocket(port, 50, InetAddress.getByName("127.0.0.1"));
                    Log.i(TAG, "SOCKS5 server bound on 127.0.0.1:" + port);
                    while (isRunning) {
                        final Socket client = serverSocket.accept();
                        threadPool.execute(new Runnable() {
                            @Override
                            public void run() {
                                handleClient(client);
                            }
                        });
                    }
                } catch (Exception e) {
                    if (isRunning) Log.e(TAG, "SOCKS5 Accept Error", e);
                }
            }
        }).start();
    }

    private void handleClient(Socket client) {
        try {
            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();

            int version = in.read();
            if (version != 5) {
                client.close();
                return;
            }
            int nmethods = in.read();
            byte[] methods = new byte[nmethods];
            in.read(methods);
            out.write(new byte[]{5, 0}); // NO AUTH
            out.flush();

            int ver = in.read();
            int cmd = in.read();
            in.read(); // Reserved
            int atyp = in.read();

            String destAddr = "";
            if (atyp == 1) { // IPv4
                byte[] b = new byte[4];
                in.read(b);
                destAddr = InetAddress.getByAddress(b).getHostAddress();
            } else if (atyp == 3) { // Domain Name
                int len = in.read();
                byte[] b = new byte[len];
                in.read(b);
                destAddr = new String(b);
            } else if (atyp == 4) { // IPv6
                byte[] b = new byte[16];
                in.read(b);
                destAddr = InetAddress.getByAddress(b).getHostAddress();
            }

            byte[] portBuf = new byte[2];
            in.read(portBuf);
            int destPort = ((portBuf[0] & 0xFF) << 8) | (portBuf[1] & 0xFF);

            if (cmd == 1) { // TCP CONNECT
                handleTcpConnect(client, in, out, destAddr, destPort);
            } else if (cmd == 3) { // UDP ASSOCIATE
                handleUdpAssociate(client, out);
            } else {
                client.close();
            }
        } catch (Exception e) {
            try { client.close(); } catch (Exception ignored) {}
        }
    }

    private void handleTcpConnect(Socket client, InputStream in, OutputStream out, String destAddr, int destPort) {
        final Socket target = new Socket();
        try {
            vpnService.protect(target); // Prevent infinite VPN loop

            InetAddress targetAddr;
            if (destPort == 53 || hostsMap.containsKey(destAddr)) {
                targetAddr = resolveDns(destAddr);
            } else {
                targetAddr = InetAddress.getByName(destAddr);
            }

            target.connect(new InetSocketAddress(targetAddr, destPort), 10000);

            out.write(new byte[]{5, 0, 0, 1, 127, 0, 0, 1, (byte)(port >> 8), (byte)(port & 0xFF)});
            out.flush();

            relayTcpData(in, target.getOutputStream(), target.getInputStream(), out, client, target);
        } catch (Exception e) {
            try {
                out.write(new byte[]{5, 1, 0, 1, 0, 0, 0, 0, 0, 0});
                out.flush();
                client.close();
                target.close();
            } catch (Exception ignored) {}
        }
    }

    private void handleUdpAssociate(Socket client, OutputStream out) {
        try {
            final DatagramSocket udpRelay = new DatagramSocket(0, InetAddress.getByName("127.0.0.1"));
            final DatagramSocket outboundUdp = new DatagramSocket();
            vpnService.protect(outboundUdp); // Protect outbound real UDP traffic

            int boundPort = udpRelay.getLocalPort();
            byte[] resp = new byte[]{5, 0, 0, 1, 127, 0, 0, 1, (byte)(boundPort >> 8), (byte)(boundPort & 0xFF)};
            out.write(resp);
            out.flush();

            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        byte[] buffer = new byte[4096];
                        while (isRunning && !client.isClosed()) {
                            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                            udpRelay.receive(packet);

                            byte[] data = packet.getData();
                            int length = packet.getLength();
                            if (length < 10) continue;

                            int atyp = data[3] & 0xFF;
                            int headerLen = 6;
                            String destHost = "";
                            if (atyp == 1) { // IPv4
                                byte[] ip = new byte[4];
                                System.arraycopy(data, 4, ip, 0, 4);
                                destHost = InetAddress.getByAddress(ip).getHostAddress();
                                headerLen = 10;
                            } else if (atyp == 3) { // Domain
                                int dlen = data[4] & 0xFF;
                                destHost = new String(data, 5, dlen);
                                headerLen = 7 + dlen;
                            }

                            int destPort = ((data[headerLen - 2] & 0xFF) << 8) | (data[headerLen - 1] & 0xFF);
                            InetAddress targetAddr = (destPort == 53 || hostsMap.containsKey(destHost)) 
                                    ? resolveDns(destHost) : InetAddress.getByName(destHost);

                            int payloadLen = length - headerLen;
                            DatagramPacket outboundPacket = new DatagramPacket(data, headerLen, payloadLen, targetAddr, destPort);
                            outboundUdp.send(outboundPacket);
                        }
                    } catch (Exception ignored) {}
                    finally {
                        udpRelay.close();
                        outboundUdp.close();
                    }
                }
            });

            InputStream in = client.getInputStream();
            while (in.read() != -1) {}
        } catch (Exception e) {
            try { client.close(); } catch (Exception ignored) {}
        }
    }

    private InetAddress resolveDns(String domain) throws Exception {
        if (hostsMap.containsKey(domain)) {
            return InetAddress.getByName(hostsMap.get(domain));
        }
        return InetAddress.getByName(fallbackDns);
    }

    private void relayTcpData(final InputStream in1, final OutputStream out1,
                              final InputStream in2, final OutputStream out2,
                              final Socket s1, final Socket s2) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
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
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
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
            }
        });
    }

    public void stop() {
        isRunning = false;
        try { if (serverSocket != null) serverSocket.close(); } catch (Exception ignored) {}
        if (threadPool != null) threadPool.shutdownNow();
    }
}
JEOF

echo "=== 4. Writing GamingVpnService.java ==="
cat << 'JEOF' > app/src/main/java/com/ippulse/scanner/GamingVpnService.java
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

import com.ippulse.scanner.socks.LocalSocks5Server;
import hev.socks5.tunnel.TProxyService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class GamingVpnService extends VpnService {
    private static final String TAG = "GamingVpn";
    private static final String ACTION_START = "com.ippulse.scanner.START";
    private static final String ACTION_STOP = "com.ippulse.scanner.STOP";
    private static final String CHANNEL_ID = "gaming_vpn";
    private static final int SOCKS_PORT = 10800;

    private ParcelFileDescriptor vpnInterface;
    private LocalSocks5Server socksServer;
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
        startVpn();
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
            Builder builder = new Builder();
            builder.setSession("Gaming VPN");
            builder.addAddress("10.0.0.2", 32);
            builder.addRoute("0.0.0.0", 0);
            builder.addDnsServer("10.0.0.1");
            builder.setMtu(currentMtu);
            builder.setBlocking(true);

            vpnInterface = builder.establish();
            if (vpnInterface == null) {
                Log.e(TAG, "VPN establishment failed");
                stopVpn();
                return;
            }

            socksServer = new LocalSocks5Server(this, SOCKS_PORT, hostsMap, dns);
            socksServer.start();

            final File configFile = writeConfigFile();

            final int fd = vpnInterface.getFd();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    TProxyService.TProxyStartService(configFile.getAbsolutePath(), fd);
                }
            }, "NativeTunnelThread").start();

            isRunning = true;
            Log.i(TAG, "VPN Tunnel Started with MTU " + currentMtu);

        } catch (Exception e) {
            Log.e(TAG, "Error starting VPN", e);
            stopVpn();
        }
    }

    private File writeConfigFile() throws IOException {
        File configFile = new File(getCacheDir(), "hev-socks5.conf");
        String configContent = 
            "[main]\n" +
            "workers=1\n" +
            "[socks5]\n" +
            "port=" + SOCKS_PORT + "\n" +
            "address=127.0.0.1\n" +
            "udp=udp\n" +
            "[misc]\n" +
            "task-stack-size=20480\n";

        FileOutputStream fos = new FileOutputStream(configFile);
        fos.write(configContent.getBytes());
        fos.close();
        return configFile;
    }

    private void stopVpn() {
        isRunning = false;
        try {
            TProxyService.TProxyStopService();
        } catch (Exception ignored) {}

        if (socksServer != null) {
            socksServer.stop();
            socksServer = null;
        }

        try {
            if (vpnInterface != null) {
                vpnInterface.close();
                vpnInterface = null;
            }
        } catch (Exception ignored) {}

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

    public static class SerializableHosts implements java.io.Serializable {
        public HashMap<String, String> map;
        public SerializableHosts(HashMap<String, String> map) {
            this.map = map;
        }
    }
}
JEOF

echo "=== 5. Downloading Native Shared Library ==="
curl -L -s https://github.com/heiher/hev-socks5-tunnel/releases/download/2.17.1/hev-socks5-tunnel-android-arm64-v8a \
     -o app/src/main/jniLibs/arm64-v8a/libhev-socks5-tunnel.so

echo "=== 6. Updating Project Settings and Pushing Changes ==="
git add app/src/main/java/hev/socks5/tunnel/TProxyService.java
git add app/src/main/java/com/ippulse/scanner/socks/LocalSocks5Server.java
git add app/src/main/java/com/ippulse/scanner/GamingVpnService.java
git add app/src/main/jniLibs/arm64-v8a/libhev-socks5-tunnel.so

git commit -m "Fix: Add JNI package mapping for hev-socks5-tunnel with full TCP/UDP proxy support"
git push origin main || git push origin master

echo "=== SUCCESS: VPN Full Tunnel Setup Complete ==="
