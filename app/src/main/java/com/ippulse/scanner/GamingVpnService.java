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

import hev.sockstun.TProxyService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class GamingVpnService extends VpnService {
    private static final String TAG = "GamingVpn";
    private static final String ACTION_START = "com.ippulse.scanner.START";
    private static final String ACTION_STOP = "com.ippulse.scanner.STOP";
    private static final String CHANNEL_ID = "gaming_vpn";
    private static final int SOCKS_PORT = 1080;

    private ParcelFileDescriptor vpnInterface;
    private Socks5ProxyServer socksServer;
    private HashMap<String, String> hostsMap = new HashMap<>();
    private String dns = "9.9.9.9";
    private int mtu = 1400;
    private boolean running = false;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            if (ACTION_STOP.equals(intent.getAction())) {
                stopVpn();
                return START_NOT_STICKY;
            }
            if (intent.hasExtra("dns")) dns = intent.getStringExtra("dns");
            if (intent.hasExtra("mtu")) mtu = intent.getIntExtra("mtu", 1400);
            SerializableHosts s = (SerializableHosts) intent.getSerializableExtra("hosts");
            if (s != null && s.map != null) hostsMap = s.map;
        }

        createNotificationChannel();
        startForegroundCompatible();
        if (!running) startVpn();
        return START_STICKY;
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
            startForeground(1, notification);
        }
    }

    private void startVpn() {
        if (running) return;
        try {
            Builder builder = new Builder();
            builder.setSession("Gaming VPN");
            builder.addAddress("10.0.0.2", 32);
            builder.addRoute("0.0.0.0", 0);
            builder.addDnsServer("10.0.0.1");
            builder.setMtu(mtu);
            builder.setBlocking(false);
            builder.addDisallowedApplication(getPackageName());

            vpnInterface = builder.establish();
            if (vpnInterface == null) throw new IOException("establish() failed");

            socksServer = new Socks5ProxyServer(this, dns, hostsMap);
            socksServer.start();

            File configFile = writeConfigFile();
            int fd = vpnInterface.getFd();

            new Thread(() -> {
                boolean started = TProxyService.TProxyStartService(configFile.getAbsolutePath(), fd);
                if (!started) {
                    Log.e(TAG, "HEV start failed");
                    stopVpn();
                }
            }).start();

            running = true;
        } catch (Exception e) {
            Log.e(TAG, "Error starting VPN", e);
            stopVpn();
        }
    }

    private File writeConfigFile() throws IOException {
        File configFile = new File(getFilesDir(), "hev-socks5.yml");
        String config = "tunnel:\n  name: tun0\n  mtu: " + mtu + "\n  ipv4: 10.0.0.2\nsocks5:\n  address: 127.0.0.1\n  port: " + SOCKS_PORT + "\n  udp: udp\nmisc:\n  log-level: warn\n";
        FileOutputStream fos = new FileOutputStream(configFile);
        fos.write(config.getBytes());
        fos.close();
        return configFile;
    }

    private void stopVpn() {
        running = false;
        try { if (TProxyService.TProxyIsRunning()) TProxyService.TProxyStopService(); } catch (Exception ignored) {}
        if (socksServer != null) { socksServer.stop(); socksServer = null; }
        if (vpnInterface != null) { try { vpnInterface.close(); } catch (IOException ignored) {} vpnInterface = null; }
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
}
