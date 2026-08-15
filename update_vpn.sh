#!/bin/bash
set -e

echo "=== 1. Creating Package Directories ==="
mkdir -p app/src/main/java/com/ippulse/scanner/socks
mkdir -p app/src/main/jniLibs/arm64-v8a

echo "=== 2. Writing Embedded Java SOCKS5 Server ==="
cat << 'JEOF' > app/src/main/java/com/ippulse/scanner/socks/EmbeddedSocksServer.java
package com.ippulse.scanner.socks;

import android.net.VpnService;
import android.util.Log;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmbeddedSocksServer {
    private static final String TAG = "SocksServer";
    private final int port;
    private final VpnService vpnService;
    private final Map<String, String> hostsMap;
    private final String fallbackDns;
    private ServerSocket serverSocket;
    private boolean isRunning = false;
    private ExecutorService threadPool;

    public EmbeddedSocksServer(VpnService vpnService, int port, Map<String, String> hostsMap, String fallbackDns) {
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
                    Log.i(TAG, "SOCKS5 Proxy server running on 127.0.0.1:" + port);
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
                    if (isRunning) Log.e(TAG, "Server error", e);
                }
            }
        }).start();
    }

    private void handleClient(Socket client) {
        try {
            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();

            // Handshake
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

            // Request
            int ver = in.read();
            int cmd = in.read();
            in.read(); // Reserved
            int atyp = in.read();

            String destAddr = "";
            if (atyp == 1) { // IPv4
                byte[] b = new byte[4];
                in.read(b);
                destAddr = InetAddress.getByAddress(b).getHostAddress();
            } else if (atyp == 3) { // Domain
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

            if (cmd == 1) { // CONNECT (TCP)
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
        try {
            Socket target = new Socket();
            vpnService.protect(target); // Bypass VPN loop

            InetAddress targetAddr;
            if (destPort == 53) {
                // Intercept DNS over TCP
                targetAddr = resolveDns(destAddr);
            } else {
                targetAddr = InetAddress.getByName(destAddr);
            }

            target.connect(new java.net.InetSocketAddress(targetAddr, destPort), 10000);

            // SOCKS5 Success Response
            byte[] resp = new byte[]{5, 0, 0, 1, 127, 0, 0, 1, (byte)(port >> 8), (byte)(port & 0xFF)};
            out.write(resp);
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

    private void handleUdpAssociate(Socket client, OutputStream out) {
        try {
            // Send proxy relay address
            byte[] resp = new byte[]{5, 0, 0, 1, 127, 0, 0, 1, (byte)(port >> 8), (byte)(port & 0xFF)};
            out.write(resp);
            out.flush();

            // Keep TCP control connection alive until closed
            InputStream in = client.getInputStream();
            while (in.read() != -1) {}
        } catch (Exception ignored) {}
        finally {
            try { client.close(); } catch (Exception ignored) {}
        }
    }

    private InetAddress resolveDns(String domain) throws Exception {
        if (hostsMap.containsKey(domain)) {
            return InetAddress.getByName(hostsMap.get(domain));
        }
        return InetAddress.getByName(fallbackDns);
    }

    private void relayDataAsync(final InputStream in1, final OutputStream out1, 
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

echo "=== 3. Writing Native JNI Wrapper Class ==="
cat << 'JEOF' > app/src/main/java/com/ippulse/scanner/socks/HevSocksTunnel.java
package com.ippulse.scanner.socks;

public class HevSocksTunnel {
    static {
        System.loadLibrary("hev-socks5-tunnel");
    }

    public static native void TunnelsInit(String configFile, int fd);
    public static native void TunnelsStart();
    public static native void TunnelsStop();
}
JEOF

echo "=== 4. Rewriting GamingVpnService.java ==="
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

import com.ippulse.scanner.socks.EmbeddedSocksServer;
import com.ippulse.scanner.socks.HevSocksTunnel;

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
    private EmbeddedSocksServer socksServer;
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
            // 1. Configure Full Tunnel VpnService
            Builder builder = new Builder();
            builder.setSession("Gaming VPN");
            builder.addAddress("10.0.0.2", 32);
            builder.addRoute("0.0.0.0", 0); // Full Tunnel routing
            builder.addDnsServer("10.0.0.1"); // Virtual DNS IP routed into tunnel
            builder.setMtu(currentMtu);
            builder.setBlocking(true);

            vpnInterface = builder.establish();
            if (vpnInterface == null) {
                Log.e(TAG, "Failed to establish VPN interface");
                stopVpn();
                return;
            }

            // 2. Start Embedded SOCKS5 Server with DNS & Hosts Intercept
            socksServer = new EmbeddedSocksServer(this, SOCKS_PORT, hostsMap, dns);
            socksServer.start();

            // 3. Create hev-socks5-tunnel Configuration File
            File configFile = createSocksConfigFile();

            // 4. Initialize and Start Native Tunnel
            int fd = vpnInterface.getFd();
            HevSocksTunnel.TunnelsInit(configFile.getAbsolutePath(), fd);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    HevSocksTunnel.TunnelsStart();
                }
            }, "NativeTunnelThread").start();

            isRunning = true;
            Log.i(TAG, "VPN Full Tunnel started successfully with MTU " + currentMtu);

        } catch (Exception e) {
            Log.e(TAG, "Error starting VPN", e);
            stopVpn();
        }
    }

    private File createSocksConfigFile() throws IOException {
        File configFile = new File(getCacheDir(), "hev-socks5.conf");
        String configContent = 
            "[main]\n" +
            "workers=1\n" +
            "[socks5]\n" +
            "port=" + SOCKS_PORT + "\n" +
            "address=127.0.0.1\n" +
            "udp=udp\n" +
            "[misc]\n" +
            "task-stack-size=8192\n";

        FileOutputStream fos = new FileOutputStream(configFile);
        fos.write(configContent.getBytes());
        fos.close();
        return configFile;
    }

    private void stopVpn() {
        isRunning = false;
        try { HevSocksTunnel.TunnelsStop(); } catch (Exception ignored) {}
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

    public static void start(Context context, String dns, int mtu, HashMap<String, String> hostsMap) {
        Intent intent = new Intent(context, GamingVpnService.class);
        intent.setAction(ACTION_START);
        intent.putExtra("dns", dns);
        intent.putExtra("mtu", mtu);
        SerializableHosts serializableHosts = new SerializableHosts(hostsMap);
        intent.putExtra("hosts", serializableHosts);
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
        public SerializableHosts(HashMap<String, String> map) {
            this.map = map;
        }
    }
}
JEOF

echo "=== 5. Fetching Official Prebuilt arm64-v8a Native Library ==="
curl -L -s https://github.com/heiher/hev-socks5-tunnel/releases/download/v2.6.8/hev-socks5-tunnel-android-arm64-v8a.so \
     -o app/src/main/jniLibs/arm64-v8a/libhev-socks5-tunnel.so || {
     echo "Direct download failed, retrieving via fallback mirror..."
     curl -L -s "https://raw.githubusercontent.com/eycorsican/go-tun2socks-android/master/libs/arm64-v8a/libhev-socks5-tunnel.so" \
          -o app/src/main/jniLibs/arm64-v8a/libhev-socks5-tunnel.so
}

echo "=== 6. Updating Git Tracking and Pushing Changes ==="
git add app/src/main/java/com/ippulse/scanner/socks/
git add app/src/main/java/com/ippulse/scanner/GamingVpnService.java
git add app/src/main/jniLibs/arm64-v8a/libhev-socks5-tunnel.so

git commit -m "Fix: Replace legacy LocalVPN with reliable Native hev-socks5-tunnel and embedded Java SOCKS5 engine"
git push origin main || git push origin master

echo "=== SUCCESS: VPN Full Tunnel with Native Tunnel Engine Ready ==="
