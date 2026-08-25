/*
 ** Copyright 2015, Mohamed Naufal
 **
 ** Licensed under the Apache License, Version 2.0 (the "License");
 ** you may not use this file except in compliance with the License.
 ** You may obtain a copy of the License at
 **
 **     http://www.apache.org/licenses/LICENSE-2.0
 **
 ** Unless required by applicable law or agreed to in writing, software
 ** distributed under the License is distributed on an "AS IS" BASIS,
 ** WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 ** See the License for the specific language governing permissions and
 ** limitations under the License.
 */

package com.github.xfalcon.vhosts.vservice;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.VpnService;
import android.os.Build;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.widget.Toast;
import com.github.xfalcon.vhosts.util.LogUtils;
import org.xbill.DNS.Address;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;


public class VhostsService extends VpnService {
    private static final String TAG = VhostsService.class.getSimpleName();
    private static final String VPN_ADDRESS = "192.0.2.111";
    private static final String VPN_ADDRESS6 = "fe80:49b1:7e4f:def2:e91f:95bf:fbb6:1111";
    private static final String VPN_ROUTE = "0.0.0.0"; // Intercept everything
    private static final String VPN_ROUTE6 = "::"; // Intercept everything
    private static String VPN_DNS4 = "8.8.8.8";
    private static String VPN_DNS6 = "2001:4860:4860::8888";

    public static final String BROADCAST_VPN_STATE = VhostsService.class.getName() + ".VPN_STATE";
    public static final String ACTION_CONNECT = VhostsService.class.getName() + ".START";
    public static final String ACTION_DISCONNECT = VhostsService.class.getName() + ".STOP";

    private static boolean isRunning = false;
    private static Thread threadHandleHosts = null;
    private ParcelFileDescriptor vpnInterface = null;

    private PendingIntent pendingIntent;

    private ConcurrentLinkedQueue<Packet> deviceToNetworkUDPQueue;
    private ConcurrentLinkedQueue<Packet> deviceToNetworkTCPQueue;
    private ConcurrentLinkedQueue<ByteBuffer> networkToDeviceQueue;
    private ExecutorService executorService;

    private Selector udpSelector;
    private Selector tcpSelector;
    private ReentrantLock udpSelectorLock;
    private ReentrantLock tcpSelectorLock;
    private static boolean isOAndBoot = false;
    private int mtu = 247;
    private String configuredDns = "8.8.8.8";
    private String configuredHosts = "";


    @Override
    public void onCreate() {
//        registerNetReceiver();
        super.onCreate();
        if (isOAndBoot) {
            //android 8.0 boot
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel("vhosts_channel_id", "System", NotificationManager.IMPORTANCE_NONE);
                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.createNotificationChannel(channel);
                Notification notification = new Notification.Builder(this, "vhosts_channel_id")
                        .setSmallIcon(android.R.drawable.stat_sys_warning)
                        .setContentTitle("Virtual Hosts Running")
                        .build();
                startForeground(1, notification);
            }
            isOAndBoot = false;
        }
        try {
            udpSelector = Selector.open();
            tcpSelector = Selector.open();
            deviceToNetworkUDPQueue = new ConcurrentLinkedQueue<>();
            deviceToNetworkTCPQueue = new ConcurrentLinkedQueue<>();
            networkToDeviceQueue = new ConcurrentLinkedQueue<>();
            udpSelectorLock = new ReentrantLock();
            tcpSelectorLock = new ReentrantLock();
            executorService = Executors.newFixedThreadPool(5);
            executorService.submit(new UDPInput(networkToDeviceQueue, udpSelector, udpSelectorLock));
            executorService.submit(new UDPOutput(deviceToNetworkUDPQueue, networkToDeviceQueue, udpSelector, udpSelectorLock, this));
            executorService.submit(new TCPInput(networkToDeviceQueue, tcpSelector, tcpSelectorLock));
            executorService.submit(new TCPOutput(deviceToNetworkTCPQueue, networkToDeviceQueue, tcpSelector, tcpSelectorLock, this));
            executorService.submit(new VPNRunnable(vpnInterface.getFileDescriptor(),
                    deviceToNetworkUDPQueue, deviceToNetworkTCPQueue, networkToDeviceQueue));
            LogUtils.i(TAG, "VPN TRACE: workers OK");
                LogUtils.i(TAG, "Started");
        } catch (Exception e) {
            // TODO: Here and elsewhere, we should explicitly notify the user of any errors
            // and suggest that they stop the service, since we can't do it ourselves
            LogUtils.e(TAG, "Error starting service", e);
            stopVService();
        }
    }



    private void ensureForeground() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager manager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            NotificationChannel channel = new NotificationChannel(
                    "ippulse_vpn_channel",
                    "IPPulseScanner VPN",
                    NotificationManager.IMPORTANCE_LOW
            );

            manager.createNotificationChannel(channel);

            Notification notification =
                    new Notification.Builder(this, "ippulse_vpn_channel")
                            .setSmallIcon(android.R.drawable.stat_sys_warning)
                            .setContentTitle("IPPulseScanner VPN")
                            .setContentText("Falcon VPN is running")
                            .setOngoing(true)
                            .build();

            startForeground(1, notification);
        }
    }

    private void setupHostFile() {
        // IPPulseScanner supplies hosts directly through Intent.
        // Falcon's UI/settings storage is intentionally not imported.
        if (configuredHosts == null || configuredHosts.trim().isEmpty()) {
            return;
        }

        try {
            DnsChange.handle_hosts(
                new ByteArrayInputStream(
                    configuredHosts.getBytes("UTF-8")
                )
            );
        } catch (Exception e) {
            LogUtils.e(TAG, "HOSTS load failed", e);
        }
    }

    private void setupVPN() {
        LogUtils.i(TAG, "FALCON_DIAG:setupVPN:BEGIN mtu=" + mtu + " dns=" + configuredDns);
        if (vpnInterface != null) {
            LogUtils.i(TAG, "FALCON_DIAG:setupVPN:ALREADY_ESTABLISHED");
            return;
        }

        Builder builder = new Builder();

        builder.addAddress(VPN_ADDRESS, 32);
        builder.addAddress(VPN_ADDRESS6, 128);

        String dns4 = configuredDns;

        if (dns4 == null || dns4.trim().isEmpty()) {
            dns4 = "8.8.8.8";
        }

        try {
            Address.getByAddress(dns4);
        } catch (Exception e) {
            LogUtils.e(TAG, "Invalid DNS: " + dns4, e);
            dns4 = "8.8.8.8";
        }

        LogUtils.i(TAG, "VPN DNS=" + dns4);
        LogUtils.i(TAG, "VPN MTU=" + mtu);

        LogUtils.i(TAG, "FALCON_DIAG:route4:BEGIN " + dns4 + "/32");
        LogUtils.i(TAG, "VPN TRACE: route4 BEGIN " + dns4 + "/32");
        builder.addRoute(dns4, 32);
        LogUtils.i(TAG, "VPN TRACE: route4 OK");
        LogUtils.i(TAG, "FALCON_DIAG:route4:OK");
        LogUtils.i(TAG, "FALCON_DIAG:route6:BEGIN " + VPN_DNS6 + "/128");
        LogUtils.i(TAG, "VPN TRACE: route6 BEGIN " + VPN_DNS6 + "/128");
        builder.addRoute(VPN_DNS6, 128);
        LogUtils.i(TAG, "VPN TRACE: route6 OK");
        LogUtils.i(TAG, "FALCON_DIAG:route6:OK");

        LogUtils.i(TAG, "FALCON_DIAG:dns4:BEGIN " + dns4);
        LogUtils.i(TAG, "VPN TRACE: dns4 BEGIN " + dns4);
        builder.addDnsServer(dns4);
        LogUtils.i(TAG, "VPN TRACE: dns4 OK");
        LogUtils.i(TAG, "FALCON_DIAG:dns4:OK");
        LogUtils.i(TAG, "FALCON_DIAG:dns6:BEGIN " + VPN_DNS6);
        LogUtils.i(TAG, "VPN TRACE: dns6 BEGIN " + VPN_DNS6);
        builder.addDnsServer(VPN_DNS6);
        LogUtils.i(TAG, "VPN TRACE: dns6 OK");
        LogUtils.i(TAG, "FALCON_DIAG:dns6:OK");

        LogUtils.i(TAG, "FALCON_DIAG:mtu:BEGIN " + mtu);
        LogUtils.i(TAG, "VPN TRACE: mtu BEGIN " + mtu);
        builder.setMtu(mtu);
        LogUtils.i(TAG, "VPN TRACE: mtu OK " + mtu);
        LogUtils.i(TAG, "FALCON_DIAG:mtu:OK " + mtu);

        LogUtils.i(TAG, "FALCON_DIAG:disallowed:BEGIN");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String[] whiteList = {
                "com.android.vending",
                "com.google.android.apps.docs",
                "com.google.android.apps.photos",
                "com.google.android.gm",
                "com.google.android.apps.translate"
            };

            for (String white : whiteList) {
                try {
                    builder.addDisallowedApplication(white);
                } catch (PackageManager.NameNotFoundException e) {
                    // Optional application; ignore when absent.
                }
            }
        }

        LogUtils.i(TAG, "FALCON_DIAG:disallowed:OK");
        LogUtils.i(TAG, "FALCON_DIAG:establish:BEGIN");

        LogUtils.i(TAG, "VPN TRACE: establish BEGIN");
        vpnInterface = builder
            .setSession(getApplicationInfo().loadLabel(getPackageManager()).toString())
            .establish();
        LogUtils.i(TAG, "VPN TRACE: establish RETURN " + (vpnInterface != null));

        if (vpnInterface != null) {
            LogUtils.i(TAG, "FALCON_DIAG:establish:SUCCESS");
        }

        if (vpnInterface == null) {
            LogUtils.e(TAG, "FALCON_DIAG:establish:RETURNED_NULL");
            throw new IllegalStateException("VpnService.Builder.establish() returned null");
        }

        LogUtils.i(TAG, "FALCON_DIAG:setupVPN:SUCCESS");
    }

    private void registerNetReceiver() {
        // Network receiver intentionally disabled in integration.
//        IntentFilter filter = new IntentFilter();
//        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
//        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
//        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
//        registerReceiver(netStateReceiver, filter);

    }

    private void unregisterNetReceiver() {
//        if (netStateReceiver != null) {
//            unregisterReceiver(netStateReceiver);
//            netStateReceiver = null;
//        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ensureForeground();
        if (intent != null) {
            if (ACTION_DISCONNECT.equals(intent.getAction())) {
                stopVService();
                return START_NOT_STICKY;
            }

            int requestedMtu = intent.getIntExtra("mtu", 247);

            if (requestedMtu >= 128 && requestedMtu <= 65535) {
                mtu = requestedMtu;
            } else {
                mtu = 247;
            }

            String dns = intent.getStringExtra("dns");
            if (dns != null && !dns.trim().isEmpty()) {
                configuredDns = dns.trim();
            }

            String hostsText = intent.getStringExtra("hosts");
            if (hostsText != null) {
                configuredHosts = hostsText;
            }

            LogUtils.i(
                TAG,
                "START request: mtu=" + mtu +
                " dns=" + configuredDns +
                " hostsBytes=" +
                configuredHosts.length()
            );
        }

        try {
            if (vpnInterface == null) {
                setupHostFile();
                setupVPN();
            }

            if (!isRunning) {
                LogUtils.i(TAG, "VPN TRACE: workers BEGIN");
                LogUtils.i(TAG, "FALCON_DIAG:workers:BEGIN");
                isRunning = true;

                udpSelector = Selector.open();
                tcpSelector = Selector.open();

                deviceToNetworkUDPQueue = new ConcurrentLinkedQueue<>();
                deviceToNetworkTCPQueue = new ConcurrentLinkedQueue<>();
                networkToDeviceQueue = new ConcurrentLinkedQueue<>();

                udpSelectorLock = new ReentrantLock();
                tcpSelectorLock = new ReentrantLock();

                executorService = Executors.newFixedThreadPool(5);

                executorService.submit(
                    new UDPInput(
                        networkToDeviceQueue,
                        udpSelector,
                        udpSelectorLock
                    )
                );

                executorService.submit(
                    new UDPOutput(
                        deviceToNetworkUDPQueue,
                        networkToDeviceQueue,
                        udpSelector,
                        udpSelectorLock,
                        this
                    )
                );

                executorService.submit(
                    new TCPInput(
                        networkToDeviceQueue,
                        tcpSelector,
                        tcpSelectorLock
                    )
                );

                executorService.submit(
                    new TCPOutput(
                        deviceToNetworkTCPQueue,
                        networkToDeviceQueue,
                        tcpSelector,
                        tcpSelectorLock,
                        this
                    )
                );

                executorService.submit(
                    new VPNRunnable(
                        vpnInterface.getFileDescriptor(),
                        deviceToNetworkUDPQueue,
                        deviceToNetworkTCPQueue,
                        networkToDeviceQueue
                    )
                );

                LogUtils.i(TAG, "FALCON_DIAG:workers:SUCCESS");
                LogUtils.i(TAG, "Started");
            }

        } catch (Throwable e) {
            LogUtils.e(TAG, "FALCON_DIAG:START_FAILURE", e);
            LogUtils.e(TAG, "Error starting service", e);
            stopVService();
        }

        return START_STICKY;
    }

    public static boolean isRunning() {

        return isRunning;
    }

    public static void startVService(Context context, int method) {
        Intent intent = VhostsService.prepare(context);
        if (intent != null) {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
            LogUtils.e(TAG, "Run Fail On Boot");
        }
        try {
            if (method == 2 && Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                isOAndBoot = true;
                context.startForegroundService(new Intent(context, VhostsService.class).setAction(ACTION_CONNECT));
            } else {
                isOAndBoot = false;
                context.startService(new Intent(context, VhostsService.class).setAction(ACTION_CONNECT));
            }
        } catch (RuntimeException e) {
            LogUtils.e(TAG, "Not allowed to start service Intent", e);
        }
    }

    public static void stopVService(Context context) {
        context.startService(new Intent(context, VhostsService.class).setAction(VhostsService.ACTION_DISCONNECT));
    }

    private void stopVService() {
        if (threadHandleHosts != null) threadHandleHosts.interrupt();
//        unregisterNetReceiver();
        if (executorService != null) executorService.shutdownNow();
        isRunning = false;
        cleanup();
        stopSelf();
        LogUtils.d(TAG, "Stopping");
    }

    @Override
    public void onRevoke() {
        stopVService();
        super.onRevoke();
    }

    @Override
    public void onDestroy() {
        stopVService();
        super.onDestroy();
    }

    private void cleanup() {
        udpSelectorLock = null;
        tcpSelectorLock = null;
        deviceToNetworkTCPQueue = null;
        deviceToNetworkUDPQueue = null;
        networkToDeviceQueue = null;
        ByteBufferPool.clear();
        closeResources(udpSelector, tcpSelector, vpnInterface);
    }

    // TODO: Move this to a "utils" class for reuse
    private static void closeResources(Closeable... resources) {
        for (Closeable resource : resources) {
            if (resource == null) {
                continue;
            }

            try {
                resource.close();
            } catch (Exception e) {
                LogUtils.e(TAG, e.toString(), e);
            }
        }
    }

    private static class VPNRunnable implements Runnable {
        private static final String TAG = VPNRunnable.class.getSimpleName();

        private FileDescriptor vpnFileDescriptor;

        private ConcurrentLinkedQueue<Packet> deviceToNetworkUDPQueue;
        private ConcurrentLinkedQueue<Packet> deviceToNetworkTCPQueue;
        private ConcurrentLinkedQueue<ByteBuffer> networkToDeviceQueue;

        public VPNRunnable(FileDescriptor vpnFileDescriptor,
                           ConcurrentLinkedQueue<Packet> deviceToNetworkUDPQueue,
                           ConcurrentLinkedQueue<Packet> deviceToNetworkTCPQueue,
                           ConcurrentLinkedQueue<ByteBuffer> networkToDeviceQueue) {
            this.vpnFileDescriptor = vpnFileDescriptor;
            this.deviceToNetworkUDPQueue = deviceToNetworkUDPQueue;
            this.deviceToNetworkTCPQueue = deviceToNetworkTCPQueue;
            this.networkToDeviceQueue = networkToDeviceQueue;
        }

        @Override
        public void run() {
            LogUtils.i(TAG, "Started");

            FileChannel vpnInput = new FileInputStream(vpnFileDescriptor).getChannel();
            FileChannel vpnOutput = new FileOutputStream(vpnFileDescriptor).getChannel();
            try {
                ByteBuffer bufferToNetwork = null;
                boolean dataSent = true;
                boolean dataReceived;
                while (!Thread.interrupted()) {
                    if (dataSent)
                        bufferToNetwork = ByteBufferPool.acquire();
                    else
                        bufferToNetwork.clear();

                    // TODO: Block when not connected
                    int readBytes = vpnInput.read(bufferToNetwork);
                    if (readBytes > 0) {
                        dataSent = true;
                        bufferToNetwork.flip();
                        Packet packet = new Packet(bufferToNetwork);
                        if (packet.isUDP()) {
                            deviceToNetworkUDPQueue.offer(packet);
                        } else if (packet.isTCP()) {
                            deviceToNetworkTCPQueue.offer(packet);
                        } else {
                            LogUtils.w(TAG, "Unknown packet type");
                            dataSent = false;
                        }
                    } else {
                        dataSent = false;
                    }
                    ByteBuffer bufferFromNetwork = networkToDeviceQueue.poll();
                    if (bufferFromNetwork != null) {
                        bufferFromNetwork.flip();
                        while (bufferFromNetwork.hasRemaining())
                            try {
                                vpnOutput.write(bufferFromNetwork);
                            } catch (Exception e) {
                                LogUtils.e(TAG, e.toString(), e);
                                break;
                            }
                        dataReceived = true;
                        ByteBufferPool.release(bufferFromNetwork);
                    } else {
                        dataReceived = false;
                    }

                    // TODO: Sleep-looping is not very battery-friendly, consider blocking instead
                    // Confirm if throughput with ConcurrentQueue is really higher compared to BlockingQueue
                    if (!dataSent && !dataReceived)
                        Thread.sleep(11);
                }
            } catch (InterruptedException e) {
                LogUtils.i(TAG, "Stopping");
            } catch (IOException e) {
                LogUtils.w(TAG, e.toString(), e);
            } finally {
                closeResources(vpnInput, vpnOutput);
            }
        }
    }

}
