#!/usr/bin/env bash
set -e

echo "Updating LocalSocks5Server to protect sockets from VPN loop..."

FILE="app/src/main/java/com/ippulse/scanner/LocalSocks5Server.java"

cat << 'JAVA_EOF' > "$FILE"
package com.ippulse.scanner;

import android.net.VpnService;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LocalSocks5Server {
    private static final String TAG = "LocalSocks5Server";
    private final VpnService vpnService;
    private final int port;
    private final HashMap<String, String> hostsMap;
    private final String dns;
    private ServerSocket serverSocket;
    private volatile boolean isRunning = false;
    private ExecutorService executor;

    public LocalSocks5Server(VpnService vpnService, int port, HashMap<String, String> hostsMap, String dns) {
        this.vpnService = vpnService;
        this.port = port;
        this.hostsMap = hostsMap;
        this.dns = dns;
    }

    public void start() {
        if (isRunning) return;
        isRunning = true;
        executor = Executors.newCachedThreadPool();
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket();
                serverSocket.bind(new InetSocketAddress("127.0.0.1", port));
                Log.i(TAG, "Local SOCKS5 server started on port " + port);
                while (isRunning) {
                    Socket clientSocket = serverSocket.accept();
                    executor.execute(() -> handleClient(clientSocket));
                }
            } catch (IOException e) {
                if (isRunning) {
                    Log.e(TAG, "SOCKS5 server error", e);
                }
            }
        }, "Socks5ServerThread").start();
    }

    private void handleClient(Socket client) {
        try {
            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();

            int version = in.read();
            int nMethods = in.read();
            byte[] methods = new byte[nMethods];
            in.read(methods);

            out.write(new byte[]{0x05, 0x00});
            out.flush();

            int ver = in.read();
            int cmd = in.read();
            int rsv = in.read();
            int atyp = in.read();

            String targetHost = "";
            int targetPort = 0;

            if (atyp == 0x01) {
                byte[] addr = new byte[4];
                in.read(addr);
                targetHost = (addr[0] & 0xFF) + "." + (addr[1] & 0xFF) + "." + (addr[2] & 0xFF) + "." + (addr[3] & 0xFF);
            } else if (atyp == 0x03) {
                int len = in.read();
                byte[] addr = new byte[len];
                in.read(addr);
                targetHost = new String(addr);
            } else if (atyp == 0x04) {
                byte[] addr = new byte[16];
                in.read(addr);
                targetHost = "ipv6_target";
            }

            int port1 = in.read();
            int port2 = in.read();
            targetPort = ((port1 & 0xFF) << 8) | (port2 & 0xFF);

            String finalHost = targetHost;
            if (hostsMap != null && hostsMap.containsKey(targetHost)) {
                finalHost = hostsMap.get(targetHost);
            }

            if (cmd == 0x01) {
                Socket target = new Socket();
                try {
                    // CRITICAL: Protect socket from VPN routing loop
                    vpnService.protect(target);

                    target.connect(new InetSocketAddress(finalHost, targetPort), 15000);
                    
                    out.write(new byte[]{0x05, 0x00, 0x00, 0x01, 0, 0, 0, 0, 0, 0});
                    out.flush();

                    executor.execute(() -> {
                        try {
                            pipe(client.getInputStream(), target.getOutputStream());
                        } catch (Exception ignored) {}
                    });
                    pipe(target.getInputStream(), client.getOutputStream());
                } catch (Exception e) {
                    try {
                        out.write(new byte[]{0x05, 0x04, 0x00, 0x01, 0, 0, 0, 0, 0, 0});
                        out.flush();
                    } catch (Exception ignored) {}
                } finally {
                    try { target.close(); } catch (Exception ignored) {}
                }
            } else {
                out.write(new byte[]{0x05, 0x07, 0x00, 0x01, 0, 0, 0, 0, 0, 0});
                out.flush();
            }
        } catch (Exception e) {
            Log.e(TAG, "Error handling SOCKS client", e);
        } finally {
            try { client.close(); } catch (Exception ignored) {}
        }
    }

    private void pipe(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[16384];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
            out.flush();
        }
    }

    public void stop() {
        isRunning = false;
        try {
            if (serverSocket != null) serverSocket.close();
        } catch (IOException ignored) {}
        if (executor != null) executor.shutdownNow();
    }
}
JAVA_EOF

# Update GamingVpnService to pass 'this' to LocalSocks5Server
VPN_FILE="app/src/main/java/com/ippulse/scanner/GamingVpnService.java"
if [ -f "$VPN_FILE" ]; then
    sed -i 's/socksServer = new LocalSocks5Server(this, SOCKS_PORT, hostsMap, dns);/socksServer = new LocalSocks5Server(this, SOCKS_PORT, hostsMap, dns);/g' "$VPN_FILE"
fi

git add .
git commit -m "Fix: Protect sockets in LocalSocks5Server using vpnService.protect to prevent routing loop"
git push origin main

echo "Pushed socket protection fix successfully!"
