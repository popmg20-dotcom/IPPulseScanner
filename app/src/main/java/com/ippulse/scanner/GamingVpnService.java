package com.ippulse.scanner;

import android.content.Context;
import android.content.Intent;
import android.net.VpnService;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class GamingVpnService extends VpnService {
    private static final String TAG = "GamingVpnService";
    private ParcelFileDescriptor mInterface;
    private LocalSocks5Server socksServer;
    private static final int SOCKS_PORT = 10808;
    private static GamingVpnService instance;

    public static GamingVpnService getInstance() { return instance; }

    public static void start(Context context, String dns, int mtu, HashMap<String, String> hostsMap) {
        try {
            Intent intent = new Intent(context, GamingVpnService.class);
            intent.putExtra("dns", dns);
            intent.putExtra("mtu", mtu);
            intent.putExtra("hostsMap", hostsMap);
            context.startService(intent);
        } catch (Exception e) { Log.e(TAG, "Error starting service", e); }
    }

    public static void stop(Context context) {
        try {
            Intent intent = new Intent(context, GamingVpnService.class);
            context.stopService(intent);
        } catch (Exception e) { Log.e(TAG, "Error stopping service", e); }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        instance = this;
        try {
            String dns = "1.1.1.1";
            int mtu = 1400;
            HashMap<String, String> hostsMap = new HashMap<>();

            if (intent != null) {
                if (intent.getStringExtra("dns") != null && !intent.getStringExtra("dns").isEmpty()) {
                    dns = intent.getStringExtra("dns");
                }
                if (intent.getIntExtra("mtu", 1400) > 0) mtu = intent.getIntExtra("mtu", 1400);
                try {
                    HashMap<?, ?> tempMap = (HashMap<?, ?>) intent.getSerializableExtra("hostsMap");
                    if (tempMap != null) {
                        for (java.util.Map.Entry<?, ?> entry : tempMap.entrySet()) {
                            if (entry.getKey() instanceof String && entry.getValue() instanceof String) {
                                hostsMap.put((String) entry.getKey(), (String) entry.getValue());
                            }
                        }
                    }
                } catch (Exception ignored) {}
            }
            startVpn(dns, mtu, hostsMap);
        } catch (Throwable t) { Log.e(TAG, "Error in onStartCommand", t); }
        return START_NOT_STICKY;
    }

    private void startVpn(String dns, int mtu, HashMap<String, String> hostsMap) {
        try {
            if (socksServer != null) socksServer.stop();
            socksServer = new LocalSocks5Server(this, SOCKS_PORT, hostsMap, dns);
            socksServer.start();

            File configFile = writeConfigFile(dns, mtu);

            Builder builder = new Builder();
            builder.setSession("IPPulseScanner")
                   .addAddress("172.16.0.2", 24)
                   .addRoute("0.0.0.0", 0)
                   .addDnsServer(dns)
                   .addDnsServer("8.8.8.8")
                   .setMtu(mtu);

            try { builder.addDisallowedApplication(getPackageName()); } catch (Exception ignored) {}

            mInterface = builder.establish();
            if (mInterface == null) { stopSelf(); return; }

            int tunFd = mInterface.getFd();
            new Thread(() -> {
                try {
                    System.loadLibrary("hev-socks5-tunnel");
                    startNativeTunnel(configFile.getAbsolutePath(), tunFd);
                } catch (Throwable t) { Log.e(TAG, "Native tunnel error", t); }
            }, "NativeTunnelThread").start();

        } catch (Throwable t) { stopSelf(); }
    }

    private native void startNativeTunnel(String configPath, int fd);
    private native void stopNativeTunnel();

    private File writeConfigFile(String dns, int mtu) throws IOException {
        File file = new File(getFilesDir(), "tunnel.yml");
        String content = "tunnel:\n  name: tun0\n  mtu: " + mtu + "\n  ipv4: 172.16.0.2\nsocks5:\n  address: 127.0.0.1\n  port: " + SOCKS_PORT + "\n  udp: 'udp'\nmisc:\n  log-level: error\n";
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(content.getBytes());
        fos.close();
        return file;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try { stopNativeTunnel(); } catch (Throwable ignored) {}
        if (socksServer != null) { try { socksServer.stop(); } catch (Throwable ignored) {} }
        if (mInterface != null) { try { mInterface.close(); } catch (IOException ignored) {} mInterface = null; }
        instance = null;
    }
}
