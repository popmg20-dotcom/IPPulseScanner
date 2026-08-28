package com.github.xfalcon.vhosts.vservice;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.VpnService;
import android.os.ParcelFileDescriptor;
import com.github.xfalcon.vhosts.util.LogUtils;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import org.xbill.DNS.Address;

/* JADX INFO: loaded from: classes5.dex */
public class VhostsService extends VpnService {
    private static final String VPN_ADDRESS = "192.0.2.111";
    private static final String VPN_ADDRESS6 = "fe80:49b1:7e4f:def2:e91f:95bf:fbb6:1111";
    private static final String VPN_ROUTE = "0.0.0.0";
    private static final String VPN_ROUTE6 = "::";
    private ConcurrentLinkedQueue<Packet> deviceToNetworkTCPQueue;
    private ConcurrentLinkedQueue<Packet> deviceToNetworkUDPQueue;
    private ExecutorService executorService;
    private ConcurrentLinkedQueue<ByteBuffer> networkToDeviceQueue;
    private PendingIntent pendingIntent;
    private Selector tcpSelector;
    private ReentrantLock tcpSelectorLock;
    private Selector udpSelector;
    private ReentrantLock udpSelectorLock;
    private static final String TAG = VhostsService.class.getSimpleName();
    private static String VPN_DNS4 = "8.8.8.8";
    private static String VPN_DNS6 = "2001:4860:4860::8888";
    public static final String BROADCAST_VPN_STATE = VhostsService.class.getName() + ".VPN_STATE";
    public static final String ACTION_CONNECT = VhostsService.class.getName() + ".START";
    public static final String ACTION_DISCONNECT = VhostsService.class.getName() + ".STOP";
    private static boolean isRunning = false;
    private static Thread threadHandleHosts = null;
    private static boolean isOAndBoot = false;
    private ParcelFileDescriptor vpnInterface = null;
    private int mtu = 247;
    private String configuredDns = "8.8.8.8";
    private String configuredHosts = "";

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    private void ensureForeground() {
        NotificationManager manager = (NotificationManager) getSystemService("notification");
        NotificationChannel channel = new NotificationChannel("ippulse_vpn_channel", "IPPulseScanner VPN", 2);
        manager.createNotificationChannel(channel);
        Notification notification = new Notification.Builder(this, "ippulse_vpn_channel").setSmallIcon(R.drawable.stat_sys_warning).setContentTitle("IPPulseScanner VPN").setContentText("Falcon VPN is running").setOngoing(true).build();
        startForeground(1, notification);
    }

    private void setupHostFile() {
        if (this.configuredHosts == null || this.configuredHosts.trim().isEmpty()) {
            return;
        }
        try {
            DnsChange.handle_hosts(new ByteArrayInputStream(this.configuredHosts.getBytes("UTF-8")));
        } catch (Exception e) {
            LogUtils.e(TAG, "HOSTS load failed", e);
        }
    }

    private void setupVPN() {
        if (this.vpnInterface != null) {
            return;
        }
        VpnService.Builder builder = new VpnService.Builder(this);
        builder.addAddress(VPN_ADDRESS, 32);
        String dns4 = this.configuredDns;
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
        LogUtils.i(TAG, "VPN MTU=" + this.mtu);
        builder.addRoute(dns4, 32);
        builder.addRoute(VPN_DNS6, 128);
        builder.addDnsServer(dns4);
        builder.addDnsServer(VPN_DNS6);
        builder.setMtu(this.mtu);
        String[] whiteList = {"com.android.vending", "com.google.android.apps.docs", "com.google.android.apps.photos", "com.google.android.gm", "com.google.android.apps.translate"};
        for (String white : whiteList) {
            try {
                builder.addDisallowedApplication(white);
            } catch (PackageManager.NameNotFoundException e2) {
            }
        }
        this.vpnInterface = builder.setSession(getApplicationInfo().loadLabel(getPackageManager()).toString()).establish();
        if (this.vpnInterface == null) {
            throw new IllegalStateException("VpnService.Builder.establish() returned null");
        }
    }

    private void registerNetReceiver() {
    }

    private void unregisterNetReceiver() {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        ensureForeground();
        if (intent != null) {
            if (ACTION_DISCONNECT.equals(intent.getAction())) {
                stopVService();
                return 2;
            }
            int requestedMtu = intent.getIntExtra("mtu", 247);
            if (requestedMtu >= 128 && requestedMtu <= 65535) {
                this.mtu = requestedMtu;
            } else {
                this.mtu = 247;
            }
            String dns = intent.getStringExtra("dns");
            if (dns != null && !dns.trim().isEmpty()) {
                this.configuredDns = dns.trim();
            }
            String hostsText = intent.getStringExtra("hosts");
            if (hostsText != null) {
                this.configuredHosts = hostsText;
            }
        }
        try {
            if (this.vpnInterface == null) {
                setupHostFile();
                setupVPN();
            }
            if (!isRunning) {
                isRunning = true;
                this.udpSelector = Selector.open();
                this.tcpSelector = Selector.open();
                this.deviceToNetworkUDPQueue = new ConcurrentLinkedQueue<>();
                this.deviceToNetworkTCPQueue = new ConcurrentLinkedQueue<>();
                this.networkToDeviceQueue = new ConcurrentLinkedQueue<>();
                this.udpSelectorLock = new ReentrantLock();
                this.tcpSelectorLock = new ReentrantLock();
                this.executorService = Executors.newFixedThreadPool(5);
                this.executorService.submit(new UDPInput(this.networkToDeviceQueue, this.udpSelector, this.udpSelectorLock));
                this.executorService.submit(new UDPOutput(this.deviceToNetworkUDPQueue, this.networkToDeviceQueue, this.udpSelector, this.udpSelectorLock, this));
                this.executorService.submit(new TCPInput(this.networkToDeviceQueue, this.tcpSelector, this.tcpSelectorLock));
                this.executorService.submit(new TCPOutput(this.deviceToNetworkTCPQueue, this.networkToDeviceQueue, this.tcpSelector, this.tcpSelectorLock, this));
                this.executorService.submit(new VPNRunnable(this.vpnInterface.getFileDescriptor(), this.deviceToNetworkUDPQueue, this.deviceToNetworkTCPQueue, this.networkToDeviceQueue));
                LogUtils.i(TAG, "Started");
            }
        } catch (Throwable e) {
            LogUtils.e(TAG, "Error starting service", e);
            stopVService();
        }
        return 1;
    }

    public static boolean isRunning() {
        return isRunning;
    }

    public static void startVService(Context context, int method) {
        Intent intent = prepare(context);
        if (intent != null) {
            intent.setFlags(268435456);
            context.startActivity(intent);
            LogUtils.e(TAG, "Run Fail On Boot");
        }
        try {
            if (method == 2) {
                isOAndBoot = true;
                context.startForegroundService(new Intent(context, (Class<?>) VhostsService.class).setAction(ACTION_CONNECT));
            } else {
                isOAndBoot = false;
                context.startService(new Intent(context, (Class<?>) VhostsService.class).setAction(ACTION_CONNECT));
            }
        } catch (RuntimeException e) {
            LogUtils.e(TAG, "Not allowed to start service Intent", e);
        }
    }

    public static void stopVService(Context context) {
        context.startService(new Intent(context, (Class<?>) VhostsService.class).setAction(ACTION_DISCONNECT));
    }

    private void stopVService() {
        if (threadHandleHosts != null) {
            threadHandleHosts.interrupt();
        }
        if (this.executorService != null) {
            this.executorService.shutdownNow();
        }
        isRunning = false;
        cleanup();
        stopSelf();
        LogUtils.d(TAG, "Stopping");
    }

    @Override // android.net.VpnService
    public void onRevoke() {
        stopVService();
        super.onRevoke();
    }

    @Override // android.app.Service
    public void onDestroy() {
        stopVService();
        super.onDestroy();
    }

    private void cleanup() {
        this.udpSelectorLock = null;
        this.tcpSelectorLock = null;
        this.deviceToNetworkTCPQueue = null;
        this.deviceToNetworkUDPQueue = null;
        this.networkToDeviceQueue = null;
        ByteBufferPool.clear();
        closeResources(this.udpSelector, this.tcpSelector, this.vpnInterface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void closeResources(Closeable... resources) {
        for (Closeable resource : resources) {
            if (resource != null) {
                try {
                    resource.close();
                } catch (Exception e) {
                    LogUtils.e(TAG, e.toString(), e);
                }
            }
        }
    }

    private static class VPNRunnable implements Runnable {
        private static final String TAG = VPNRunnable.class.getSimpleName();
        private ConcurrentLinkedQueue<Packet> deviceToNetworkTCPQueue;
        private ConcurrentLinkedQueue<Packet> deviceToNetworkUDPQueue;
        private ConcurrentLinkedQueue<ByteBuffer> networkToDeviceQueue;
        private FileDescriptor vpnFileDescriptor;

        public VPNRunnable(FileDescriptor vpnFileDescriptor, ConcurrentLinkedQueue<Packet> deviceToNetworkUDPQueue, ConcurrentLinkedQueue<Packet> deviceToNetworkTCPQueue, ConcurrentLinkedQueue<ByteBuffer> networkToDeviceQueue) {
            this.vpnFileDescriptor = vpnFileDescriptor;
            this.deviceToNetworkUDPQueue = deviceToNetworkUDPQueue;
            this.deviceToNetworkTCPQueue = deviceToNetworkTCPQueue;
            this.networkToDeviceQueue = networkToDeviceQueue;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean dataReceived;
            LogUtils.i(TAG, "Started");
            FileChannel vpnInput = new FileInputStream(this.vpnFileDescriptor).getChannel();
            FileChannel vpnOutput = new FileOutputStream(this.vpnFileDescriptor).getChannel();
            ByteBuffer bufferToNetwork = null;
            boolean dataSent = true;
            while (!Thread.interrupted()) {
                try {
                    try {
                        if (dataSent) {
                            bufferToNetwork = ByteBufferPool.acquire();
                        } else {
                            bufferToNetwork.clear();
                        }
                        int readBytes = vpnInput.read(bufferToNetwork);
                        if (readBytes > 0) {
                            dataSent = true;
                            bufferToNetwork.flip();
                            Packet packet = new Packet(bufferToNetwork);
                            if (packet.isUDP()) {
                                this.deviceToNetworkUDPQueue.offer(packet);
                            } else if (packet.isTCP()) {
                                this.deviceToNetworkTCPQueue.offer(packet);
                            } else {
                                LogUtils.w(TAG, "Unknown packet type");
                                dataSent = false;
                            }
                        } else {
                            dataSent = false;
                        }
                        ByteBuffer bufferFromNetwork = this.networkToDeviceQueue.poll();
                        if (bufferFromNetwork != null) {
                            bufferFromNetwork.flip();
                            while (bufferFromNetwork.hasRemaining()) {
                                try {
                                    vpnOutput.write(bufferFromNetwork);
                                } catch (Exception e) {
                                    LogUtils.e(TAG, e.toString(), e);
                                }
                            }
                            dataReceived = true;
                            ByteBufferPool.release(bufferFromNetwork);
                        } else {
                            dataReceived = false;
                        }
                        if (!dataSent && !dataReceived) {
                            Thread.sleep(11L);
                        }
                    } catch (Throwable th) {
                        VhostsService.closeResources(vpnInput, vpnOutput);
                        throw th;
                    }
                } catch (IOException e2) {
                    LogUtils.w(TAG, e2.toString(), e2);
                    VhostsService.closeResources(vpnInput, vpnOutput);
                    return;
                } catch (InterruptedException e3) {
                    LogUtils.i(TAG, "Stopping");
                    VhostsService.closeResources(vpnInput, vpnOutput);
                    return;
                }
            }
            VhostsService.closeResources(vpnInput, vpnOutput);
        }
    }
}
