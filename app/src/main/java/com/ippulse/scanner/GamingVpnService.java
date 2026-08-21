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

import com.getsurfboard.vpn.Jni;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class GamingVpnService extends VpnService {

    private static final String TAG = "GamingVpn";

    private static final String ACTION_START =
            "com.ippulse.scanner.START";

    private static final String ACTION_STOP =
            "com.ippulse.scanner.STOP";

    private static final String CHANNEL_ID =
            "gaming_vpn";

    private static final int NOTIFICATION_ID = 1001;

    private ParcelFileDescriptor vpnInterface;

    private volatile boolean running;

    private int currentMtu = 1400;

    private String dns = "8.8.8.8";

    private final HashMap<String, String> hostsMap =
            new HashMap<>();

    private Jni surfboardJni;

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannel();

        surfboardJni = new Jni(this);

        Log.i(TAG, "Surfboard native engine initialized");
    }

    @Override
    public int onStartCommand(
            Intent intent,
            int flags,
            int startId
    ) {
        try {
            if (intent != null) {

                if (ACTION_STOP.equals(intent.getAction())) {
                    stopVpn();
                    return START_NOT_STICKY;
                }

                if (intent.hasExtra("dns")) {
                    String value =
                            intent.getStringExtra("dns");

                    if (value != null &&
                            !value.trim().isEmpty()) {
                        dns = value.trim();
                    }
                }

                if (intent.hasExtra("mtu")) {
                    currentMtu =
                            intent.getIntExtra("mtu", 1400);

                    if (currentMtu < 1280) {
                        currentMtu = 1280;
                    }

                    if (currentMtu > 1500) {
                        currentMtu = 1500;
                    }
                }

                SerializableHosts serializableHosts =
                        (SerializableHosts)
                                intent.getSerializableExtra("hosts");

                if (serializableHosts != null &&
                        serializableHosts.map != null) {

                    synchronized (hostsMap) {
                        hostsMap.clear();
                        hostsMap.putAll(
                                serializableHosts.map);
                    }
                }
            }

            startForegroundCompatible();

            if (!running) {
                startVpn();
            }

            return START_STICKY;

        } catch (Throwable t) {

            Log.e(TAG,
                    "onStartCommand failed",
                    t);

            stopVpn();

            return START_NOT_STICKY;
        }
    }

    private void startForegroundCompatible() {

        Notification notification =
                buildNotification(
                        "Surfboard VPN active");

        try {

            if (Build.VERSION.SDK_INT >= 29) {

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

        } catch (Throwable t) {

            startForeground(
                    NOTIFICATION_ID,
                    notification
            );
        }
    }

    private void startVpn() {

        if (running) {
            return;
        }

        try {

            final boolean ipv6 =
                    Build.VERSION.SDK_INT >= 23;

            VpnService.Builder builder =
                    new VpnService.Builder();

            builder.setSession(
                    "IPPulseScanner Surfboard");

            /*
             * Native Surfboard addresses are embedded
             * inside libsurfboard.so.
             */
            builder.addAddress(
                    Jni.getTunAddress(),
                    32
            );

            /*
             * Full IPv4 tunnel.
             */
            builder.addRoute(
                    "0.0.0.0",
                    0
            );

            /*
             * MTU requested by the third tab.
             */
            builder.setMtu(currentMtu);

            /*
             * DNS is routed through the VPN engine.
             */
            builder.addDnsServer(
                    Jni.getDnsAddress()
            );

            /*
             * Do not capture our own VPN process.
             */
            builder.addDisallowedApplication(
                    getPackageName()
            );

            /*
             * Non-blocking matches the native engine's
             * asynchronous TUN processing.
             */
            builder.setBlocking(false);

            vpnInterface =
                    builder.establish();

            if (vpnInterface == null) {
                throw new IOException(
                        "VpnService.Builder.establish() returned null"
                );
            }

            int tunFd =
                    vpnInterface
                            .getFd();

            Jni.attachService(this);

            running = true;

            /*
             * Exact native Surfboard call.
             *
             * tunFd
             * SDK level
             * log mode
             * logging enabled
             * SSH dump disabled
             * IPv6 enabled
             */
            surfboardJni.startVPN(
                    tunFd,
                    Build.VERSION.SDK_INT,
                    1,
                    true,
                    false,
                    ipv6
            );

            Log.i(
                    TAG,
                    "Surfboard VPN started; fd=" +
                            tunFd +
                            " mtu=" +
                            currentMtu +
                            " dns=" +
                            dns
            );

        } catch (Throwable t) {

            Log.e(
                    TAG,
                    "Surfboard VPN start failed",
                    t
            );

            running = false;

            closeVpnInterface();
        }
    }

    private void stopVpn() {

        if (!running &&
                vpnInterface == null) {
            return;
        }

        running = false;

        try {

            if (surfboardJni != null) {
                surfboardJni.stopVPN();
            }

        } catch (Throwable t) {

            Log.w(
                    TAG,
                    "Surfboard stop failed",
                    t
            );
        }

        closeVpnInterface();

        Jni.detachService(this);

        Log.i(
                TAG,
                "VPN stopped"
        );
    }

    private void closeVpnInterface() {

        if (vpnInterface != null) {

            try {
                vpnInterface.close();
            } catch (Throwable ignored) {
            }

            vpnInterface = null;
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

    public String getConfiguredDns() {
        return dns;
    }

    public void onNativeVpnStarted() {

        Log.i(
                TAG,
                "Native callback: onVpnStarted"
        );
    }

    public void onNativeVpnStopped() {

        Log.i(
                TAG,
                "Native callback: onVpnStopped"
        );
    }

    public void onNativeConnectionCount(
            int count
    ) {

        Log.d(
                TAG,
                "Native active connections=" +
                        count
        );
    }

    public void onNativeTraffic(
            int uid,
            boolean upload,
            long bytes,
            boolean metered
    ) {
        /*
         * Intentionally lightweight.
         * Native Surfboard remains responsible
         * for actual packet transport.
         */
    }

    /*
     * Called by the native Surfboard engine.
     *
     * The engine gives us a complete DNS question.
     *
     * hostsMap:
     *     hostname -> forced IPv4
     *
     * Any non-mapped query is sent to the configured
     * upstream DNS outside the VPN using protect().
     */
    public byte[] handleNativeDnsQuery(
            byte[] query
    ) {

        try {

            String host =
                    extractDnsQuestionName(query);

            if (host == null) {
                return forwardDns(query);
            }

            String normalized =
                    host.toLowerCase(
                            Locale.US
                    );

            String mapped;

            synchronized (hostsMap) {
                mapped =
                        hostsMap.get(normalized);
            }

            if (mapped != null &&
                    isIpv4(mapped)) {

                return buildDnsAResponse(
                        query,
                        mapped
                );
            }

            return forwardDns(query);

        } catch (Throwable t) {

            Log.e(
                    TAG,
                    "DNS query failed",
                    t
            );

            return new byte[0];
        }
    }

    private byte[] forwardDns(
            byte[] query
    ) throws Exception {

        InetAddress dnsServer =
                InetAddress.getByName(dns);

        DatagramSocket socket =
                new DatagramSocket();

        try {

            if (!protect(socket)) {
                throw new IOException(
                        "VpnService.protect(DNS) failed"
                );
            }

            socket.setSoTimeout(5000);

            DatagramPacket out =
                    new DatagramPacket(
                            query,
                            query.length,
                            dnsServer,
                            53
                    );

            socket.send(out);

            byte[] buf =
                    new byte[4096];

            DatagramPacket in =
                    new DatagramPacket(
                            buf,
                            buf.length
                    );

            socket.receive(in);

            byte[] response =
                    new byte[in.getLength()];

            System.arraycopy(
                    in.getData(),
                    in.getOffset(),
                    response,
                    0,
                    in.getLength()
            );

            return response;

        } finally {

            socket.close();
        }
    }

    private String extractDnsQuestionName(
            byte[] packet
    ) {

        if (packet == null ||
                packet.length < 13) {
            return null;
        }

        int pos = 12;

        StringBuilder name =
                new StringBuilder();

        while (pos < packet.length) {

            int len =
                    packet[pos++] & 0xff;

            if (len == 0) {
                break;
            }

            if (len > 63 ||
                    pos + len > packet.length) {
                return null;
            }

            if (name.length() > 0) {
                name.append('.');
            }

            String label =
                    new String(
                            packet,
                            pos,
                            len
                    );

            name.append(label);

            pos += len;
        }

        return name.toString();
    }

    private boolean isIpv4(String value) {

        String[] parts =
                value.trim().split(
                        "\\."
                );

        if (parts.length != 4) {
            return false;
        }

        try {

            for (String p : parts) {

                int x =
                        Integer.parseInt(p);

                if (x < 0 ||
                        x > 255) {
                    return false;
                }
            }

            return true;

        } catch (Throwable ignored) {
            return false;
        }
    }

    private byte[] buildDnsAResponse(
            byte[] query,
            String ipv4
    ) throws Exception {

        if (query.length < 12) {
            return new byte[0];
        }

        int questionEnd =
                12;

        while (
                questionEnd < query.length
        ) {

            int len =
                    query[questionEnd]
                            & 0xff;

            questionEnd++;

            if (len == 0) {
                break;
            }

            questionEnd += len;

            if (questionEnd >= query.length) {
                return new byte[0];
            }
        }

        questionEnd += 4;

        if (questionEnd > query.length) {
            return new byte[0];
        }

        ByteArrayOutputStream out =
                new ByteArrayOutputStream();

        /*
         * Transaction ID
         */
        out.write(query[0]);
        out.write(query[1]);

        /*
         * Flags: response + recursion available
         */
        out.write(0x81);
        out.write(0x80);

        /*
         * QDCOUNT = 1
         */
        out.write(0);
        out.write(1);

        /*
         * ANCOUNT = 1
         */
        out.write(0);
        out.write(1);

        /*
         * NSCOUNT = 0
         * ARCOUNT = 0
         */
        out.write(0);
        out.write(0);
        out.write(0);
        out.write(0);

        /*
         * Original question
         */
        out.write(
                query,
                12,
                questionEnd - 12
        );

        /*
         * NAME = pointer to question
         */
        out.write(0xc0);
        out.write(0x0c);

        /*
         * TYPE A
         */
        out.write(0);
        out.write(1);

        /*
         * CLASS IN
         */
        out.write(0);
        out.write(1);

        /*
         * TTL = 60 seconds
         */
        out.write(0);
        out.write(0);
        out.write(0);
        out.write(60);

        /*
         * RDLENGTH = 4
         */
        out.write(0);
        out.write(4);

        String[] p =
                ipv4.trim().split(
                        "\\."
                );

        for (String s : p) {
            out.write(
                    Integer.parseInt(s)
            );
        }

        return out.toByteArray();
    }

    private Notification buildNotification(
            String text
    ) {

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
                        Build.VERSION.SDK_INT >= 23
                                ? PendingIntent.FLAG_UPDATE_CURRENT |
                                  PendingIntent.FLAG_IMMUTABLE
                                : PendingIntent.FLAG_UPDATE_CURRENT
                );

        Notification.Builder builder;

        if (Build.VERSION.SDK_INT >= 26) {

            builder =
                    new Notification.Builder(
                            this,
                            CHANNEL_ID
                    );

        } else {

            builder =
                    new Notification.Builder(
                            this
                    );
        }

        return builder
                .setContentTitle(
                        "IPPulseScanner"
                )
                .setContentText(
                        text
                )
                .setSmallIcon(
                        android.R.drawable.stat_sys_warning
                )
                .setContentIntent(pi)
                .setOngoing(true)
                .build();
    }

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT < 26) {
            return;
        }

        NotificationManager nm =
                (NotificationManager)
                        getSystemService(
                                Context.NOTIFICATION_SERVICE
                        );

        if (nm == null) {
            return;
        }

        NotificationChannel channel =
                new NotificationChannel(
                        CHANNEL_ID,
                        "Gaming VPN",
                        NotificationManager
                                .IMPORTANCE_LOW
                );

        channel.setDescription(
                "Surfboard native VPN engine"
        );

        nm.createNotificationChannel(
                channel
        );
    }
}
