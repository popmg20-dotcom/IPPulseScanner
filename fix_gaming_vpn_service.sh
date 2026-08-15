#!/usr/bin/env bash
set -e

echo "Updating GamingVpnService with robust routing and configuration setup..."

FILE="app/src/main/java/com/ippulse/scanner/GamingVpnService.java"

cat << 'JAVA_EOF' > "$FILE"
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
    private ParcelFileDescriptor vpnInterface = null;
    private LocalSocks5Server socksServer;
    private static final int SOCKS_PORT = 10808;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startVpn();
        return START_STICKY;
    }

    private void startVpn() {
        try {
            // 1. Start local SOCKS5 server first
            HashMap<String, String> hostsMap = new HashMap<>();
            socksServer = new LocalSocks5Server(this, SOCKS_PORT, hostsMap, "8.8.8.8");
            socksServer.start();
            Log.i(TAG, "LocalSocks5Server started successfully.");

            // 2. Generate configuration file for hev-socks5-tunnel
            File configFile = writeConfigFile();

            // 3. Configure VPN Builder to intercept all traffic and DNS
            Builder builder = new Builder();
            builder.setSession("IPPulseScanner");
            builder.addAddress("198.18.0.1", 32);
            builder.addRoute("0.0.0.0", 0);
            builder.addDnsServer("8.8.8.8");
            builder.setMtu(1500);

            vpnInterface = builder.establish();
            if (vpnInterface == null) {
                Log.e(TAG, "Failed to establish VPN interface.");
                stopSelf();
                return;
            }

            int tunFd = vpnInterface.getFd();
            Log.i(TAG, "VPN interface established with FD: " + tunFd);

            // 4. Start hev-socks5-tunnel native core in background thread
            new Thread(() -> {
                try {
                    hev.socks5.tunnel.Tunnel.getInstance().start(configFile.getAbsolutePath(), tunFd);
                } catch (Exception e) {
                    Log.e(TAG, "hev-socks5-tunnel runtime error", e);
                }
            }, "HevTunnelThread").start();

        } catch (Exception e) {
            Log.e(TAG, "Error starting VPN service", e);
            stopSelf();
        }
    }

    private File writeConfigFile() throws IOException {
        File file = new File(getFilesDir(), "hev-socks5.yml");
        String configContent = 
            "tunnel:\n" +
            "  name: tun0\n" +
            "  mtu: 1500\n" +
            "  ipv4: 198.18.0.1\n" +
            "socks5:\n" +
            "  address: 127.0.0.1\n" +
            "  port: " + SOCKS_PORT + "\n" +
            "  udp: 'udp'\n" +
            "misc:\n" +
            "  log-level: debug\n";
        
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(configContent.getBytes());
        fos.close();
        return file;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            hev.socks5.tunnel.Tunnel.getInstance().stop();
        } catch (Exception ignored) {}
        
        if (socksServer != null) {
            socksServer.stop();
        }
        
        if (vpnInterface != null) {
            try {
                vpnInterface.close();
            } catch (IOException ignored) {}
        }
        Log.i(TAG, "GamingVpnService destroyed and cleaned up.");
    }
}
JAVA_EOF

git add .
git commit -m "Fix: Standardize GamingVpnService routing, config generation, and tunnel startup"
git push origin main

echo "Pushed GamingVpnService fix successfully!"
