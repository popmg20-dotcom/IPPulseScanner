package com.github.xfalcon.vhosts.vservice;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.VpnService;
import android.os.ParcelFileDescriptor;

import com.github.xfalcon.vhosts.util.LogUtils;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VhostsService extends VpnService {
    private static final String TAG = "VhostsService";

    private static final String VPN_ADDRESS = "192.0.2.111";
    private static final String VPN_ADDRESS6 = "fe80:49b1:7e4f:def2:e91f:95bf:fbb6:1111";
    private static final String VPN_ROUTE = "0.0.0.0";
    private static final String VPN_ROUTE6 = "::";
    private static final String VPN_DNS4 = "8.8.8.8";
    private static final String VPN_DNS6 = "2001:4860:4860::8888";

    private static boolean isRunning = false;
    private ParcelFileDescriptor vpnInterface = null;

    private ConcurrentLinkedQueue<Packet> deviceToNetworkUDPQueue;
    private ConcurrentLinkedQueue<Packet> deviceToNetworkTCPQueue;
    private ConcurrentLinkedQueue<ByteBuffer> networkToDeviceQueue;
    private ExecutorService executorService;

    private Selector udpSelector;
    private Selector tcpSelector;

    private int mtu = 247;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            mtu = intent.getIntExtra("mtu", 247);
            String hostsText = intent.getStringExtra("hosts");
            if (hostsText != null) {
                try {
                    InputStream is = new ByteArrayInputStream(hostsText.getBytes("UTF-8"));
                    DnsChange.handle_hosts(is);
                } catch (Exception e) {
                    LogUtils.e(TAG, "Hosts parsing error", e);
                }
            }
        }
        startVpn();
        return START_STICKY;
    }

    private void startVpn() {
        if (isRunning) return;
        try {
            setupVPN();
            if (vpnInterface == null) {
                LogUtils.e(TAG, "Failed to establish VPN interface");
                return;
            }

            deviceToNetworkUDPQueue = new ConcurrentLinkedQueue<>();
            deviceToNetworkTCPQueue = new ConcurrentLinkedQueue<>();
            networkToDeviceQueue = new ConcurrentLinkedQueue<>();

            udpSelector = Selector.open();
            tcpSelector = Selector.open();
            java.util.concurrent.locks.ReentrantLock udpSelectorLock = new java.util.concurrent.locks.ReentrantLock();
            java.util.concurrent.locks.ReentrantLock tcpSelectorLock = new java.util.concurrent.locks.ReentrantLock();

            executorService = Executors.newFixedThreadPool(5);
            executorService.submit(new UDPInput(networkToDeviceQueue, udpSelector, udpSelectorLock));
            executorService.submit(new UDPOutput(deviceToNetworkUDPQueue, networkToDeviceQueue, udpSelector, udpSelectorLock, this));
            executorService.submit(new TCPInput(networkToDeviceQueue, tcpSelector, tcpSelectorLock));
            executorService.submit(new TCPOutput(deviceToNetworkTCPQueue, networkToDeviceQueue, tcpSelector, tcpSelectorLock, this));
            executorService.submit(new VPNRunnable(vpnInterface.getFileDescriptor(), deviceToNetworkUDPQueue, deviceToNetworkTCPQueue, networkToDeviceQueue));

            isRunning = true;
            LogUtils.i(TAG, "VPN started successfully");
        } catch (Exception e) {
            LogUtils.e(TAG, "Error starting VPN", e);
            stopVpn();
        }
    }

    private void setupVPN() {
        try {
            if (vpnInterface == null) {
                Builder builder = new Builder();
                builder.addAddress(VPN_ADDRESS, 32);
                builder.addAddress(VPN_ADDRESS6, 128);
                builder.addRoute(VPN_ROUTE, 0);
                builder.addRoute(VPN_ROUTE6, 0);
                builder.addDnsServer(VPN_DNS4);
                builder.addDnsServer(VPN_DNS6);
                builder.setMtu(mtu);
                builder.setSession("IPPulseScanner VPN");
                Intent intent = new Intent(this, VhostsService.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
                builder.setConfigureIntent(pendingIntent);
                vpnInterface = builder.establish();
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "Error establishing VPN interface", e);
            vpnInterface = null;
        }
    }

    private void stopVpn() {
        isRunning = false;
        if (executorService != null) {
            executorService.shutdownNow();
            executorService = null;
        }
        if (vpnInterface != null) {
            try {
                vpnInterface.close();
            } catch (IOException e) {
                LogUtils.w(TAG, "Error closing VPN interface", e);
            }
            vpnInterface = null;
        }
        LogUtils.i(TAG, "VPN stopped");
        stopSelf();
    }

    @Override
    public void onDestroy() {
        stopVpn();
        super.onDestroy();
    }

    public static boolean isRunning() {
        return isRunning;
    }

    private static class VPNRunnable implements Runnable {
        private static final String TAG = VPNRunnable.class.getSimpleName();
        private final FileDescriptor vpnFileDescriptor;
        private final ConcurrentLinkedQueue<Packet> deviceToNetworkUDPQueue;
        private final ConcurrentLinkedQueue<Packet> deviceToNetworkTCPQueue;
        private final ConcurrentLinkedQueue<ByteBuffer> networkToDeviceQueue;

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
            LogUtils.i(TAG, "VPNRunnable started");
            try {
                FileChannel vpnInput = new FileInputStream(vpnFileDescriptor).getChannel();
                FileChannel vpnOutput = new FileOutputStream(vpnFileDescriptor).getChannel();

                ByteBuffer bufferToNetwork = ByteBuffer.allocate(32767);
                boolean dataSent = false;
                boolean dataReceived = false;

                while (!Thread.currentThread().isInterrupted()) {
                    if (bufferToNetwork == null) {
                        bufferToNetwork = ByteBuffer.allocate(32767);
                    } else {
                        bufferToNetwork.clear();
                    }

                    int readBytes = vpnInput.read(bufferToNetwork);
                    if (readBytes > 0) {
                        bufferToNetwork.flip();
                        Packet packet = new Packet(bufferToNetwork);
                        if (packet.isUDP()) {
                            deviceToNetworkUDPQueue.offer(packet);
                            dataReceived = true;
                        } else if (packet.isTCP()) {
                            deviceToNetworkTCPQueue.offer(packet);
                            dataReceived = true;
                        }
                        bufferToNetwork = null;
                    } else {
                        dataReceived = false;
                    }

                    ByteBuffer bufferFromNetwork = networkToDeviceQueue.poll();
                    if (bufferFromNetwork != null) {
                        bufferFromNetwork.flip();
                        while (bufferFromNetwork.hasRemaining()) {
                            vpnOutput.write(bufferFromNetwork);
                        }
                        dataSent = true;
                    } else {
                        dataSent = false;
                    }

                    if (!dataReceived && !dataSent) {
                        Thread.sleep(11);
                    }
                }
                vpnInput.close();
                vpnOutput.close();
            } catch (InterruptedException e) {
                LogUtils.i(TAG, "VPNRunnable interrupted");
            } catch (IOException e) {
                LogUtils.e(TAG, "VPNRunnable error", e);
            }
            LogUtils.i(TAG, "VPNRunnable stopped");
        }
    }
}
