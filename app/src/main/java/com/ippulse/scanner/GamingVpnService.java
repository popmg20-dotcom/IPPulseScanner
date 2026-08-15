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

import com.ippulse.scanner.localvpn.ByteBufferPool;
import com.ippulse.scanner.localvpn.Packet;
import com.ippulse.scanner.localvpn.TCPInput;
import com.ippulse.scanner.localvpn.TCPOutput;
import com.ippulse.scanner.localvpn.UDPInput;
import com.ippulse.scanner.localvpn.UDPOutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GamingVpnService extends VpnService {
    private static final String TAG = "GamingVpn";
    private static final String ACTION_START = "com.ippulse.scanner.START";
    private static final String ACTION_STOP = "com.ippulse.scanner.STOP";
    private static final String CHANNEL_ID = "gaming_vpn";
    private static final String VPN_ADDRESS = "10.0.0.2";
    private static final int VPN_MTU = 1400;

    private volatile boolean running = false;
    private ParcelFileDescriptor vpnInterface;
    private FileInputStream vpnInput;
    private FileOutputStream vpnOutput;

    private Selector udpSelector;
    private Selector tcpSelector;
    private ExecutorService executorService;

    private ConcurrentLinkedQueue<Packet> deviceToNetworkUDPQueue;
    private ConcurrentLinkedQueue<Packet> deviceToNetworkTCPQueue;
    private ConcurrentLinkedQueue<ByteBuffer> networkToDeviceQueue;

    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null && ACTION_STOP.equals(intent.getAction())) {
            stopVpn();
            return START_NOT_STICKY;
        }

        createNotificationChannel();
        startForegroundCompatible();
        if (!running) startVpn();
        return START_STICKY;
    }

    private synchronized void startVpn() {
        if (running) return;
        try {
            deviceToNetworkUDPQueue = new ConcurrentLinkedQueue<>();
            deviceToNetworkTCPQueue = new ConcurrentLinkedQueue<>();
            networkToDeviceQueue = new ConcurrentLinkedQueue<>();
            udpSelector = Selector.open();
            tcpSelector = Selector.open();

            Builder builder = new Builder();
            builder.setSession("Gaming VPN");
            builder.addAddress(VPN_ADDRESS, 32);
            builder.addRoute("0.0.0.0", 0);
            builder.setMtu(VPN_MTU);
            builder.setBlocking(true);
            try {
                builder.addDisallowedApplication(getPackageName());
            } catch (Exception ignored) {}

            vpnInterface = builder.establish();
            if (vpnInterface == null) throw new IOException("establish() returned null");

            vpnInput = new FileInputStream(vpnInterface.getFileDescriptor());
            vpnOutput = new FileOutputStream(vpnInterface.getFileDescriptor());

            executorService = Executors.newFixedThreadPool(5);
            executorService.submit(new UDPInput(networkToDeviceQueue, udpSelector));
            executorService.submit(new UDPOutput(deviceToNetworkUDPQueue, udpSelector, this));
            executorService.submit(new TCPInput(networkToDeviceQueue, tcpSelector));
            executorService.submit(new TCPOutput(deviceToNetworkTCPQueue, networkToDeviceQueue, tcpSelector, this));
            executorService.submit(new TunRunnable());

            running = true;
            Log.i(TAG, "VPN started. MTU=" + VPN_MTU);
        } catch (Throwable e) {
            Log.e(TAG, "Failed to start VPN", e);
            stopVpn();
        }
    }

    private final class TunRunnable implements Runnable {
        @Override
        public void run() {
            Log.i(TAG, "TUN reader started");
            ByteBuffer buffer = null;
            try {
                while (running && !Thread.currentThread().isInterrupted()) {
                    if (buffer == null) {
                        buffer = ByteBufferPool.acquire();
                    } else {
                        buffer.clear();
                    }
                    int readBytes = vpnInput.getChannel().read(buffer);
                    if (readBytes <= 0) {
                        ByteBufferPool.release(buffer);
                        buffer = null;
                        continue;
                    }
                    buffer.flip();
                    Packet packet;
                    try {
                        packet = new Packet(buffer);
                    } catch (Throwable parseError) {
                        Log.w(TAG, "Invalid packet", parseError);
                        ByteBufferPool.release(buffer);
                        buffer = null;
                        continue;
                    }

                    if (packet.isUDP()) {
                        deviceToNetworkUDPQueue.offer(packet);
                    } else if (packet.isTCP()) {
                        deviceToNetworkTCPQueue.offer(packet);
                    } else {
                        Log.d(TAG, "Ignoring non TCP/UDP packet");
                        ByteBufferPool.release(packet.backingBuffer);
                    }

                    drainNetworkToDevice();
                }
            } catch (Throwable e) {
                if (running) Log.e(TAG, "TUN loop failed", e);
            } finally {
                if (buffer != null) ByteBufferPool.release(buffer);
                Log.i(TAG, "TUN reader stopped");
            }
        }
    }

    private void drainNetworkToDevice() {
        ByteBuffer buffer;
        while ((buffer = networkToDeviceQueue.poll()) != null) {
            try {
                vpnOutput.getChannel().write(buffer);
            } catch (IOException e) {
                Log.e(TAG, "Failed to write to TUN", e);
                break;
            }
        }
    }

    private synchronized void stopVpn() {
        Log.i(TAG, "Stopping VPN");
        running = false;
        if (executorService != null) {
            executorService.shutdownNow();
            executorService = null;
        }
        try { if (vpnInput != null) vpnInput.close(); } catch (IOException ignored) {}
        try { if (vpnOutput != null) vpnOutput.close(); } catch (IOException ignored) {}
        try { if (vpnInterface != null) vpnInterface.close(); } catch (IOException ignored) {}
        vpnInput = null; vpnOutput = null; vpnInterface = null;
        stopForeground(true);
        stopSelf();
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
}
