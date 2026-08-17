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
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import hev.sockstun.TProxyService;

public class GamingVpnService extends VpnService {

    private static final String TAG =
            "GamingVpn";

    public static final String ACTION_START =
            "com.ippulse.scanner.START";

    public static final String ACTION_STOP =
            "com.ippulse.scanner.STOP";

    private static final int NOTIFICATION_ID =
            7001;

    private static final String CHANNEL_ID =
            "gaming_vpn";

    private ParcelFileDescriptor vpnInterface;

    private Socks5ProxyServer socksServer;

    private Thread hevThread;

    private boolean running;

    private String dns = "8.8.8.8";

    private int mtu = 1400;

    private HashMap<String, String> hostsMap =
            new HashMap<>();

    public static void start(
            Context context,
            String dns,
            int mtu,
            Map<String, String> hosts
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
                serializeHosts(hosts)
        );

        if (Build.VERSION.SDK_INT >= 26) {
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

    @Override
    public int onStartCommand(
            Intent intent,
            int flags,
            int startId
    ) {

        try {

            if (intent != null
                    && ACTION_STOP.equals(
                            intent.getAction()
                    )) {

                stopVpn();

                stopSelf();

                return START_NOT_STICKY;
            }

            if (intent != null) {

                dns =
                        normalizeDns(
                                intent.getStringExtra(
                                        "dns"
                                )
                        );

                mtu =
                        normalizeMtu(
                                intent.getIntExtra(
                                        "mtu",
                                        1400
                                )
                        );

                hostsMap =
                        parseHosts(
                                intent.getStringExtra(
                                        "hosts"
                                )
                        );
            }

            startForegroundCompat();

            if (!running) {
                startVpn();
            }

        } catch (Throwable e) {

            Log.e(
                    TAG,
                    "VPN START ERROR",
                    e
            );

            stopVpn();
            stopSelf();
        }

        return START_STICKY;
    }

    private synchronized void startVpn()
            throws Exception {

        Log.i(
                TAG,
                "Starting Full Tunnel"
        );

        /*
         * SOCKS5
         */
        socksServer =
                new Socks5ProxyServer(
                        this,
                        dns,
                        hostsMap
                );

        if (!socksServer.start()) {

            throw new Exception(
                    "SOCKS5 failed"
            );
        }

        /*
         * VPN
         */
        Builder builder =
                new Builder();

        builder.setSession(
                "IPPulseScanner"
        );

        builder.addAddress(
                "198.18.0.1",
                32
        );

        builder.addRoute(
                "0.0.0.0",
                0
        );

        builder.setMtu(
                mtu
        );

        builder.addDnsServer(
                dns
        );

        /*
         * Prevent own application traffic
         * from entering its own VPN.
         */
        builder.addDisallowedApplication(
                getPackageName()
        );

        if (Build.VERSION.SDK_INT >= 29) {
            builder.setMetered(false);
        }

        vpnInterface =
                builder.establish();

        if (vpnInterface == null) {

            throw new Exception(
                    "VPN establish returned null"
            );
        }

        final int tunFd =
                vpnInterface.getFd();

        Log.i(
                TAG,
                "TUN FD = "
                        + tunFd
        );

        /*
         * HEV config
         */
        final File config =
                new File(
                        getFilesDir(),
                        "hev.yml"
                );

        writeConfig(config);

        final String configPath =
                config.getAbsolutePath();

        running = true;

        hevThread =
                new Thread(
                        () -> {

                            try {

                                Log.i(
                                        TAG,
                                        "Starting HEV JNI"
                                );

                                boolean ok =
                                        TProxyService.start(
                                                configPath,
                                                tunFd
                                        );

                                Log.i(
                                        TAG,
                                        "HEV result="
                                                + ok
                                );

                            } catch (
                                    Throwable e
                            ) {

                                Log.e(
                                        TAG,
                                        "HEV ERROR",
                                        e
                                );

                                stopVpn();
                            }
                        },
                        "IPPulse-HEV"
                );

        hevThread.start();

        Log.i(
                TAG,
                "VPN STARTED"
        );
    }

    private void startForegroundCompat() {

        createChannel();

        Intent intent =
                new Intent(
                        this,
                        MainActivity.class
                );

        PendingIntent pi =
                PendingIntent.getActivity(
                        this,
                        0,
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                                | PendingIntent.FLAG_IMMUTABLE
                );

        Notification notification =
                new Notification.Builder(
                        this,
                        CHANNEL_ID
                )
                        .setContentTitle(
                                "IPPulseScanner"
                        )
                        .setContentText(
                                "Full Tunnel VPN Active"
                        )
                        .setSmallIcon(
                                android.R.drawable
                                        .stat_sys_warning
                        )
                        .setOngoing(true)
                        .setContentIntent(pi)
                        .build();

        if (Build.VERSION.SDK_INT >= 34) {

            startForeground(
                    NOTIFICATION_ID,
                    notification,
                    ServiceInfo
                            .FOREGROUND_SERVICE_TYPE_SPECIAL_USE
            );

        } else {

            startForeground(
                    NOTIFICATION_ID,
                    notification
            );
        }
    }

    private void createChannel() {

        if (Build.VERSION.SDK_INT < 26) {
            return;
        }

        NotificationManager manager =
                (NotificationManager)
                        getSystemService(
                                NOTIFICATION_SERVICE
                        );

        if (manager == null) return;

        NotificationChannel channel =
                new NotificationChannel(
                        CHANNEL_ID,
                        "IPPulse VPN",
                        NotificationManager
                                .IMPORTANCE_LOW
                );

        manager.createNotificationChannel(
                channel
        );
    }

    private synchronized void stopVpn() {

        running = false;

        try {
            TProxyService.stop();
        } catch (Throwable ignored) {}

        if (hevThread != null) {

            try {
                hevThread.interrupt();
            } catch (Throwable ignored) {}

            hevThread = null;
        }

        if (socksServer != null) {

            try {
                socksServer.stop();
            } catch (Throwable ignored) {}

            socksServer = null;
        }

        if (vpnInterface != null) {

            try {
                vpnInterface.close();
            } catch (Throwable ignored) {}

            vpnInterface = null;
        }

        try {
            stopForeground(true);
        } catch (Throwable ignored) {}
    }

    private void writeConfig(
            File file
    ) throws Exception {

        FileWriter writer =
                new FileWriter(file);

        writer.write(
                "tunnel:\n"
                        + "  name: tun0\n"
                        + "  mtu: "
                        + mtu
                        + "\n"
                        + "  multi-queue: false\n"
                        + "  ipv4: 198.18.0.1\n"
                        + "  icmp: 'off'\n"
                        + "\n"
                        + "socks5:\n"
                        + "  address: 127.0.0.1\n"
                        + "  port: 1080\n"
                        + "  udp: 'udp'\n"
                        + "\n"
                        + "misc:\n"
                        + "  connect-timeout: 12000\n"
                        + "  tcp-read-write-timeout: 300000\n"
                        + "  udp-read-write-timeout: 60000\n"
                        + "  log-level: debug\n"
                        + "  log-file: "
                        + new File(
                                getFilesDir(),
                                "hev.log"
                        ).getAbsolutePath()
                        + "\n"
        );

        writer.flush();
        writer.close();
    }

    private static String normalizeDns(
            String value
    ) {

        if (value == null
                || value.trim().isEmpty()) {
            return "8.8.8.8";
        }

        return value.trim();
    }

    private static int normalizeMtu(
            int value
    ) {

        if (value < 1280) return 1280;
        if (value > 20000) return 20000;

        return value;
    }

    private static String serializeHosts(
            Map<String, String> map
    ) {

        if (map == null
                || map.isEmpty()) {
            return "";
        }

        StringBuilder out =
                new StringBuilder();

        for (Map.Entry<String, String> item
                : map.entrySet()) {

            if (item.getKey() == null
                    || item.getValue() == null) {
                continue;
            }

            out.append(
                    item.getKey()
                            .trim()
                            .toLowerCase(
                                    Locale.US
                            )
            );

            out.append("=");

            out.append(
                    item.getValue()
                            .trim()
            );

            out.append("\n");
        }

        return out.toString();
    }

    private static HashMap<String, String>
    parseHosts(
            String data
    ) {

        HashMap<String, String> result =
                new HashMap<>();

        if (data == null
                || data.trim().isEmpty()) {
            return result;
        }

        String[] lines =
                data.split(
                        "[\\r\\n,;]+"
                );

        for (String line : lines) {

            if (line == null) continue;

            line =
                    line.trim();

            if (line.isEmpty()
                    || line.startsWith("#")) {
                continue;
            }

            String[] pair =
                    line.split(
                            "[:=\\s]+",
                            2
                    );

            if (pair.length != 2) continue;

            String domain =
                    DnsProxyServer
                            .normalizeDomain(
                                    pair[0]
                            );

            String ip =
                    pair[1].trim();

            if (!domain.isEmpty()
                    && !ip.isEmpty()) {

                result.put(
                        domain,
                        ip
                );
            }
        }

        return result;
    }

    @Override
    public void onDestroy() {
        stopVpn();
        super.onDestroy();
    }

    @Override
    public void onRevoke() {
        stopVpn();
        super.onRevoke();
    }

    @Override
    public IBinder onBind(
            Intent intent
    ) {
        return super.onBind(intent);
    }
}
