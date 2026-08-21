package com.ippulse.scanner;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.VpnService;
import android.os.Build;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;

import com.getsurfboard.vpn.Jni;

public class GamingVpnService extends VpnService {

    public static final String ACTION_START =
            "com.ippulse.scanner.START";

    public static final String ACTION_STOP =
            "com.ippulse.scanner.STOP";

    private static final String CHANNEL_ID = "surfboard_vpn";

    private static final String VPN_ADDRESS = "10.0.0.2";

    private static final String DNS_ADDRESS = "10.0.0.1";

    private static final int DEFAULT_MTU = 1400;

    private ParcelFileDescriptor vpnInterface;
    private Jni jni;

    private volatile boolean running;

    public static void start(Context context) {
        Intent intent = new Intent(context, GamingVpnService.class);
        intent.setAction(ACTION_START);

        if (Build.VERSION.SDK_INT >= 26) {
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

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }

    @Override
    public int onStartCommand(Intent intent,
                              int flags,
                              int startId) {

        String action = intent != null ? intent.getAction() : null;

        if (ACTION_STOP.equals(action)) {
            stopVpn();
            return START_NOT_STICKY;
        }

        if (ACTION_START.equals(action)) {
            startVpn();
        }

        return START_STICKY;
    }

    private synchronized void startVpn() {

        if (running) {
            return;
        }

        try {

            startForeground(
                    1001,
                    buildNotification()
            );

            Intent prepareIntent =
                    VpnService.prepare(this);

            if (prepareIntent != null) {
                throw new IllegalStateException(
                        "VPN permission has not been granted"
                );
            }

            Builder builder = new Builder();

            /*
             * Full tunnel.
             */
            builder.addAddress(
                    VPN_ADDRESS,
                    32
            );

            builder.addRoute(
                    "0.0.0.0",
                    0
            );

            /*
             * IPv6 route is intentionally omitted here.
             *
             * The native engine can run IPv4 cleanly first.
             */
            builder.addDnsServer(
                    DNS_ADDRESS
            );

            builder.setMtu(
                    DEFAULT_MTU
            );

            builder.setSession(
                    "IPPulse Surfboard Engine"
            );

            vpnInterface = builder.establish();

            if (vpnInterface == null) {
                throw new IOException("establish() failed");
            }

            Jni.start(
                    this,
                    activeNetwork,
                    vpnInterface.getFd(),
                    true
            );

            if (vpnInterface == null) {
                throw new IllegalStateException(
                        "VpnService.Builder.establish() returned null"
                );
            }

            jni = new Jni(this);

            /*
             * IMPORTANT:
             *
             * No Java packet parser.
             * No Java TCP NAT.
             * No Java UDP NAT.
             * No SOCKS server.
             * No FileInputStream/FileOutputStream loop.
             *
             * The complete TUN FD is handed to libsurfboard.so.
             */
            jni.start(
                    vpnInterface,
                    false,
                    true
            );

            running = true;

        } catch (Throwable t) {

            android.util.Log.e(
                    "GamingVpn",
                    "Surfboard VPN start failed",
                    t
            );

            stopVpn();
        }
    }

    private synchronized void stopVpn() {

        running = false;

        try {
            if (jni != null) {
                try {
                    jni.stop();
                } catch (Throwable ignored) {
                }
            }
        } finally {

            jni = null;

            try {
                if (vpnInterface != null) {
                    try {
                    Jni.stop();
                } catch (Throwable ignored) {
                }

                vpnInterface.close();
                }
            } catch (Throwable ignored) {
            }

            vpnInterface = null;

            stopForeground(STOP_FOREGROUND_REMOVE);

            stopSelf();
        }
    }

    private Notification buildNotification() {

        return new Notification.Builder(
                this,
                CHANNEL_ID
        )
                .setContentTitle(
                        "IPPulseScanner"
                )
                .setContentText(
                        "Surfboard engine is running"
                )
                .setSmallIcon(
                        android.R.drawable.stat_sys_warning
                )
                .setOngoing(true)
                .build();
    }

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT < 26) {
            return;
        }

        NotificationChannel channel =
                new NotificationChannel(
                        CHANNEL_ID,
                        "Surfboard VPN",
                        NotificationManager.IMPORTANCE_LOW
                );

        NotificationManager manager =
                (NotificationManager)
                        getSystemService(
                                Context.NOTIFICATION_SERVICE
                        );

        if (manager != null) {
            manager.createNotificationChannel(channel);
        }
    }

    @Override
    public void onDestroy() {
        stopVpn();
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }
}
