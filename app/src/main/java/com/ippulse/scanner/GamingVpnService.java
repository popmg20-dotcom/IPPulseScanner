package com.ippulse.scanner;

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

    public static GamingVpnService getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    @Override
    int onStartCommand(Intent intent, int flags, int startId) {
        instance = this;
        try {
            String dns = "8.8.8.8";
            int mtu = 1500;
            HashMap<String, String> hostsMap = new HashMap<>();

            if (intent != null) {
                if (intent.getStringExtra("dns") != null) {
                    dns = intent.getStringExtra("dns");
                }
                mtu = intent.getIntExtra("mtu", 1500);
            }

            startVpn(dns, mtu, hostsMap);
        } catch (Throwable t) {
            Log.e(TAG, "Error in onStartCommand", t);
        }
        return START_NOT_STICKY;
    }

    private void startVpn(String dns, int mtu, HashMap<String, String> hostsMap) {
        try {
            // توقف نمونه قبلی اگر وجود داشته باشد
            if (socksServer != null) {
                socksServer.stop();
            }

            socksServer = new LocalSocks5Server(this, SOCKS_PORT, hostsMap, dns);
            socksServer.start();

            File configFile = writeConfigFile(dns, mtu);

            Builder builder = new Builder();
            builder.setSession("IPPulseScanner")
                   .addAddress("198.18.0.1", 32)
                   .addRoute("0.0.0.0", 0)
                   .addDnsServer(dns)
                   .setMtu(mtu);

            mInterface = builder.establish();
            if (mInterface == null) {
                Log.e(TAG, "Failed to establish VPN interface.");
                stopSelf();
                return;
            }

            int tunFd = mInterface.getFd();
            Log.i(TAG, "VPN established with FD: " + tunFd);

            new Thread(() -> {
                try {
                    System.loadLibrary("hev-socks5-tunnel");
                    startNativeTunnel(configFile.getAbsolutePath(), tunFd);
                } catch (Throwable t) {
                    Log.e(TAG, "Native tunnel thread error", t);
                }
            }, "NativeTunnelThread").start();

        } catch (Throwable t) {
            Log.e(TAG, "Error starting VPN", t);
            stopSelf();
        }
    }

    private native void startNativeTunnel(String configPath, int fd);
    private native void stopNativeTunnel();

    private File writeConfigFile(String dns, int mtu) throws IOException {
        File file = new File(getFilesDir(), "tunnel.yml");
        String content = 
            "tunnel:\n" +
            "  name: tun0\n" +
            "  mtu: " + mtu + "\n" +
            "  ipv4: 198.18.0.1\n" +
            "socks5:\n" +
            "  address: 127.0.0.1\n" +
            "  port: " + SOCKS_PORT + "\n" +
            "  udp: 'udp'\n" +
            "misc:\n" +
            "  log-level: debug\n";
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(content.getBytes());
        fos.close();
        return file;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy called - Stopping VPN completely");
        
        try {
            stopNativeTunnel();
        } catch (Throwable ignored) {}

        if (socksServer != null) {
            try {
                socksServer.stop();
            } catch (Throwable ignored) {}
        }

        if (mInterface != null) {
            try {
                mInterface.close();
            } catch (IOException ignored) {}
            mInterface = null;
        }

        instance = null;
        Log.i(TAG, "VPN stopped completely.");
    }
}
