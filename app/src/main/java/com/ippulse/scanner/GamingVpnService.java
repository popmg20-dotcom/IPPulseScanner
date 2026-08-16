
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
import android.widget.Toast;

import net.typeblog.socks.system;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;

public class GamingVpnService extends VpnService {
    private static final String TAG = "GamingVpn";
    private static final String ACTION_START = "com.ippulse.scanner.START";
    private static final String ACTION_STOP = "com.ippulse.scanner.STOP";
    private static final String CHANNEL_ID = "gaming_vpn";
    private static final int SOCKS_PORT = 1080;
    private static final int DNS_PORT = 8091;

    private ParcelFileDescriptor vpnInterface;
    private Process tun2socksProcess;
    private Socks5ProxyServer socks5;
    private DnsProxyServer dnsProxy;
    private HashMap<String, String> hostsMap = new HashMap<>();
    private String dns = "8.8.8.8";
    private int mtu = 1400;
    private boolean running = false;
    private String sockPath;

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
            // ۱. ساخت VPN
            Builder builder = new Builder();
            builder.setSession("Gaming VPN");
            builder.addAddress("26.26.26.1", 24);
            builder.addRoute("0.0.0.0", 0);
            builder.addDnsServer("26.26.26.1");
            builder.setMtu(mtu);
            builder.setBlocking(false);

            vpnInterface = builder.establish();
            if (vpnInterface == null) {
                Toast.makeText(this, "VPN establish failed", Toast.LENGTH_SHORT).show();
                stopVpn();
                return;
            }

            // ۲. کپی کتابخانه‌ها از assets به filesDir
            copyNativeLibs();

            // ۳. شروع SOCKS5 و DNS
            socks5 = new Socks5ProxyServer(this, SOCKS_PORT);
            socks5.start();
            dnsProxy = new DnsProxyServer(DNS_PORT, dns, hostsMap);
            dnsProxy.start();

            // ۴. اجرای tun2socks
            int fd = vpnInterface.getFd();
            sockPath = getApplicationInfo().dataDir + "/sock_path";
            String pidPath = getFilesDir() + "/tun2socks.pid";
            String nativeLibDir = getFilesDir().getAbsolutePath();

            String command = nativeLibDir + "/libtun2socks.so"
                    + " --netif-ipaddr 26.26.26.2"
                    + " --netif-netmask 255.255.255.0"
                    + " --socks-server-addr 127.0.0.1:" + SOCKS_PORT
                    + " --tunfd " + fd
                    + " --tunmtu " + mtu
                    + " --loglevel 1"
                    + " --dnsgw 26.26.26.1:" + DNS_PORT
                    + " --pid " + pidPath
                    + " --sock " + sockPath;

            tun2socksProcess = Runtime.getRuntime().exec(command);

            // ۵. ارسال fd از طریق سوکت
            int attempts = 0;
            int sent = -1;
            while (attempts < 5) {
                sent = system.sendfd(fd, sockPath);
                if (sent != -1) break;
                attempts++;
                Thread.sleep(1000L * attempts);
            }
            if (sent == -1) {
                Toast.makeText(this, "sendfd failed", Toast.LENGTH_SHORT).show();
                stopVpn();
                return;
            }

            running = true;
            Toast.makeText(this, "VPN started", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "VPN Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
            stopVpn();
        }
    }

    private void copyNativeLibs() {
        try {
            File destDir = getFilesDir();
            String[] libs = {"libtun2socks.so", "libsystem.so"};
            for (String lib : libs) {
                File dest = new File(destDir, lib);
                if (!dest.exists()) {
                    InputStream in = getAssets().open(lib);
                    FileOutputStream out = new FileOutputStream(dest);
                    byte[] buf = new byte[8192];
                    int len;
                    while ((len = in.read(buf)) > 0) {
                        out.write(buf, 0, len);
                    }
                    out.close();
                    in.close();
                    dest.setExecutable(true);
                }
            }
        } catch (Exception e) {
            Toast.makeText(this, "copyNativeLibs failed: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void stopVpn() {
        running = false;
        if (tun2socksProcess != null) {
            tun2socksProcess.destroy();
            tun2socksProcess = null;
        }
        if (socks5 != null) { socks5.stop(); socks5 = null; }
        if (dnsProxy != null) { dnsProxy.stop(); dnsProxy = null; }
        if (vpnInterface != null) {
            try { vpnInterface.close(); } catch (Exception ignored) {}
            vpnInterface = null;
        }
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
