#!/usr/bin/env bash
set -e

echo "Updating GamingVpnService.java..."

FILE="app/src/main/java/com/ippulse/scanner/GamingVpnService.java"
mkdir -p "$(dirname "$FILE")"

cat << 'JAVA_EOF' > "$FILE"
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

    public static void start(Context context, String dns, int mtu, HashMap<String, String> hostsMap) {
        Intent intent = new Intent(context, GamingVpnService.class);
        intent.putExtra("dns", dns);
        intent.putExtra("mtu", mtu);
        intent.putExtra("hostsMap", hostsMap);
        context.startService(intent);
    }

    public static void stop(Context context) {
        Intent intent = new Intent(context, GamingVpnService.class);
        context.stopService(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            String dns = intent.getStringExtra("dns");
            int mtu = intent.getIntExtra("mtu", 1500);
            HashMap<String, String> hostsMap = (HashMap<String, String>) intent.getSerializableExtra("hostsMap");
            startVpn(dns, mtu, hostsMap);
        }
        return START_STICKY;
    }

    private void startVpn(String dns, int mtu, HashMap<String, String> hostsMap) {
        try {
            if (hostsMap == null) hostsMap = new HashMap<>();
            String targetDns = (dns != null && !dns.isEmpty()) ? dns : "8.8.8.8";

            socksServer = new LocalSocks5Server(this, SOCKS_PORT, hostsMap, targetDns);
            socksServer.start();
            Log.i(TAG, "LocalSocks5Server started.");

            File configFile = writeConfigFile(targetDns, mtu);

            Builder builder = new Builder();
            builder.setSession("IPPulseScanner")
                   .addAddress("198.18.0.1", 32)
                   .addRoute("0.0.0.0", 0)
                   .addDnsServer(targetDns)
                   .setMtu(mtu);

            mInterface = builder.establish();
            if (mInterface == null) {
                Log.e(TAG, "Failed to establish VPN interface.");
                stopSelf();
                return;
            }

            int tunFd = mInterface.getFd();
            new Thread(() -> {
                try {
                    TProxyService.TProxyStartService(configFile.getAbsolutePath(), tunFd);
                } catch (Exception e) {
                    Log.e(TAG, "TProxy start error", e);
                }
            }, "TProxyThread").start();

        } catch (Exception e) {
            Log.e(TAG, "Error starting VPN", e);
            stopSelf();
        }
    }

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
        try {
            TProxyService.TProxyStopService();
        } catch (Exception ignored) {}

        if (socksServer != null) {
            socksServer.stop();
        }

        if (mInterface != null) {
            try {
                mInterface.close();
            } catch (IOException ignored) {}
        }
        Log.i(TAG, "GamingVpnService destroyed.");
    }

    public static class TProxyService {
        static {
            System.loadLibrary("hev-socks5-tunnel");
        }
        public static native void TProxyStartService(String configPath, int fd);
        public static native void TProxyStopService();
    }
}
JAVA_EOF

echo "Building project with Gradle..."
./gradlew --no-daemon assembleDebug

echo "Build complete successfully!"
