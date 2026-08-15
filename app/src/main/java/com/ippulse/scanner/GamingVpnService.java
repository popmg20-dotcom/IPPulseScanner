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

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GamingVpnService extends VpnService {
    private static final String TAG = "GamingVpn";
    private static final String ACTION_START = "com.ippulse.scanner.START";
    private static final String ACTION_STOP = "com.ippulse.scanner.STOP";
    private static final String CHANNEL_ID = "gaming_vpn";
    private static final String VPN_ADDRESS = "10.0.0.2";
    private static final String DNS_ADDRESS = "10.0.0.1";
    private static final int SOCKS_PORT = 1080;

    private ParcelFileDescriptor vpnInterface;
    private LocalSocks5Server socksServer;
    private volatile boolean running;
    private int currentMtu = 1400;
    private String upstreamDns = "8.8.8.8";
    private HashMap<String, String> hostsMap = new HashMap<>();

    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            String action = intent.getAction();
            if (ACTION_STOP.equals(action)) {
                stopVpn();
                return START_NOT_STICKY;
            }
            if (intent.hasExtra("dns")) {
                String value = intent.getStringExtra("dns");
                if (value != null && !value.trim().isEmpty()) {
                    upstreamDns = value.trim();
                }
            }
            if (intent.hasExtra("mtu")) {
                currentMtu = intent.getIntExtra("mtu", 1400);
            }
            SerializableHosts serializedHosts = (SerializableHosts) intent.getSerializableExtra("hosts");
            if (serializedHosts != null && serializedHosts.map != null) {
                hostsMap = new HashMap<>(serializedHosts.map);
            }
        }

        createNotificationChannel();
        startForegroundCompatible();
        startVpn();
        return START_STICKY;
    }

    private synchronized void startVpn() {
        if (running) return;
        ParcelFileDescriptor interfaceFd = null;
        try {
            socksServer = new LocalSocks5Server(this, SOCKS_PORT, hostsMap);
            socksServer.start();

            Builder builder = new Builder();
            builder.setSession("Gaming VPN");
            builder.addAddress(VPN_ADDRESS, 32);
            builder.addRoute("0.0.0.0", 0);
            builder.addDnsServer(DNS_ADDRESS);
            builder.setMtu(currentMtu);
            builder.setBlocking(true);
            builder.addDisallowedApplication(getPackageName());

            interfaceFd = builder.establish();
            if (interfaceFd == null) {
                throw new IOException("establish() returned null");
            }
            vpnInterface = interfaceFd;
            int fd = vpnInterface.getFd();

            String configPath = writeHevConfigFile();
            running = true;
            final int nativeFd = fd;
            final String nativeConfig = configPath;
            Thread nativeThread = new Thread(() -> {
                try {
                    Log.i(TAG, "Starting HEV");
                    boolean started = TProxyService.TProxyStartService(configPath, nativeFd);
                    Log.i(TAG, "HEV start result=" + started);
                    if (!started) {
                        Log.e(TAG, "HEV failed to start");
                    }
                } catch (Throwable t) {
                    Log.e(TAG, "HEV native error", t);
                } finally {
                    running = false;
                }
            }, "HEV-Tun2Socks");
            nativeThread.start();
            Log.i(TAG, "VPN started MTU=" + currentMtu + " DNS=" + upstreamDns);
        } catch (Throwable e) {
            Log.e(TAG, "startVpn() failed", e);
            if (interfaceFd != null) {
                try { interfaceFd.close(); } catch (Exception ignored) { }
            }
            vpnInterface = null;
            if (socksServer != null) {
                socksServer.close();
                socksServer = null;
            }
            stopForeground(true);
            stopSelf();
        }
    }

    private String buildHevConfig() {
        StringBuilder config = new StringBuilder();
        config.append("tunnel:\n");
        config.append("  name: tun0\n");
        config.append("  mtu: ").append(currentMtu).append("\n");
        config.append("  multi-queue: false\n");
        config.append("  ipv4: ").append(VPN_ADDRESS).append("\n\n");
        config.append("socks5:\n");
        config.append("  address: 127.0.0.1\n");
        config.append("  port: ").append(SOCKS_PORT).append("\n");
        config.append("  udp: udp\n");
        config.append("  pipeline: false\n\n");
        // config.append("mapdns:\n");
        config.append("  address: ").append(DNS_ADDRESS).append("\n");
        config.append("  port: 53\n");
        config.append("  network: 100.64.0.0\n");
        config.append("  netmask: 255.192.0.0\n");
        config.append("  cache-size: 10000\n\n");
        config.append("misc:\n");
        config.append("  connect-timeout: 10000\n");
        config.append("  tcp-read-write-timeout: 300000\n");
        config.append("  udp-read-write-timeout: 60000\n");
        config.append("  max-session-count: 0\n");
        config.append("  log-level: warn\n");
        return config.toString();
    }

    private synchronized void stopVpn() {
        Log.i(TAG, "Stopping VPN");
        running = false;
        try {
            if (TProxyService.TProxyIsRunning()) {
                TProxyService.TProxyStopService();
            }
        } catch (Throwable e) {
            Log.e(TAG, "HEV stop failed", e);
        }
        if (socksServer != null) {
            try { socksServer.close(); } catch (Exception ignored) { }
            socksServer = null;
        }
        if (vpnInterface != null) {
            try { vpnInterface.close(); } catch (IOException ignored) { }
            vpnInterface = null;
        }
        stopForeground(true);
        stopSelf();
    }

    @Override
    public void onDestroy() {
        stopVpn();
        super.onDestroy();
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
            Log.e(TAG, "startForeground failed", e);
        }
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

    private String writeHevConfigFile() throws IOException {
        String config = buildHevConfig();
        String configPath = writeHevConfigFile();
        File dir = new File(getFilesDir(), "hev");
        if (!dir.exists() && !dir.mkdirs()) {
            throw new IOException("Cannot create HEV config directory");
        }
        File configFile = new File(dir, "hev.yml");
        FileOutputStream fos = new FileOutputStream(configFile, false);
        try {
            fos.write(config.getBytes(java.nio.charset.StandardCharsets.UTF_8));
            fos.flush();
        } finally {
            fos.close();
        }
        Log.i(TAG, "HEV config path: " + configFile.getAbsolutePath());
        Log.i(TAG, "HEV config:\n" + config);
        return configFile.getAbsolutePath();
    }
}
