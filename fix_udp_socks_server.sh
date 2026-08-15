#!/usr/bin/env bash
set -e

echo "Updating LocalSocks5Server to fully support UDP Associate and DNS resolution..."

FILE="app/src/main/java/com/ippulse/scanner/LocalSocks5Server.java"

cat << 'JAVA_EOF' > "$FILE"
package com.ippulse.scanner;

import android.net.VpnService;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
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
    private DatagramSocket udpRelaySocket;
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
        
        // Start TCP Server
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket();
                serverSocket.bind(new InetSocketAddress("127.0.0.1", port));
                Log.i(TAG, "Local SOCKS5 TCP server started on port " + port);
                while (isRunning) {
                    Socket clientSocket = serverSocket.accept();
                    executor.execute(() -> handleClient(clientSocket));
                }
            } catch (IOException e) {
                if (isRunning) {
                    Log.e(TAG, "SOCKS5 TCP server error", e);
                }
            }
        }, "Socks5TcpThread").start();

        // Start UDP Relay Server for UDP Associate
        new Thread(() -> {
            try {
                udpRelaySocket = new DatagramSocket(new InetSocketAddress("127.0.0.1", port));
                if (vpnService != null) {
                    vpnService.protect(udpRelaySocket);
                }
                Log.i(TAG, "Local SOCKS5 UDP relay started on port " + port);
                byte[] buffer = new byte[65535];
                while (isRunning) {
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    udpRelaySocket.receive(packet);
                    executor.execute(() -> handleUdpPacket(packet));
                }
            } catch (IOException e) {
                if (isRunning) {
                    Log.e(TAG, "SOCKS5 UDP server error", e);
                }
            }
        }, "Socks5UdpThread").start();
    }

    private void handleClient(Socket client) {
        try {
            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();

            int version = in.read();
            int nMethods = in.read();
            byte[] methods = new byte[nMethods];
            in.read(methods);

            // Response: version 5, no auth
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

            if (cmd == 0x01) { // CONNECT
                String finalHost = targetHost;
                if (hostsMap != null && hostsMap.containsKey(targetHost)) {
                    finalHost = hostsMap.get(targetHost);
                }

                Socket target = new Socket();
                try {
                    if (vpnService != null) vpnService.protect(target);
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
            } else if (cmd == 0x03) { // UDP ASSOCIATE
                // Reply with bound address/port for UDP relay
                out.write(new byte[]{0x05, 0x00, 0x00, 0x01, 127, 0, 0, 1, (byte)(port >> 8), (byte)(port & 0xFF)});
                out.flush();
                // Keep TCP connection alive for UDP associate session
                while (in.read() != -1) {}
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

    private void handleUdpPacket(DatagramPacket packet) {
        try {
            byte[] data = packet.getData();
            int length = packet.getLength();
            if (length < 10) return;

            // SOCKS5 UDP Header: RSV(2) + FRAG(1) + ATYP(1) + DST.ADDR(var) + DST.PORT(2) + DATA
            int atyp = data[3] & 0xFF;
            int headerLength = 0;
            String targetHost = "";
            int targetPort = 0;

            if (atyp == 0x01) { // IPv4
                targetHost = (data[4] & 0xFF) + "." + (data[5] & 0xFF) + "." + (data[6] & 0xFF) + "." + (data[7] & 0xFF);
                targetPort = ((data[8] & 0xFF) << 8) | (data[9] & 0xFF);
                headerLength = 10;
            } else if (atyp == 0x03) { // Domain
                int domainLen = data[4] & 0xFF;
                targetHost = new String(data, 5, domainLen);
                targetPort = ((data[5 + domainLen] & 0xFF) << 8) | (data[5 + domainLen + 1] & 0xFF);
                headerLength = 5 + domainLen + 2;
            } else {
                return;
            }

            int payloadLen = length - headerLength;
            if (payloadLen <= 0) return;

            byte[] payload = new byte[payloadLen];
            System.arraycopy(data, headerLength, payload, 0, payloadLen);

            // If target is DNS or external, resolve/forward via protected socket
            String finalHost = targetHost;
            if (hostsMap != null && hostsMap.containsKey(targetHost)) {
                finalHost = hostsMap.get(targetHost);
            }
            if ("10.0.0.1".equals(finalHost) || finalHost.isEmpty()) {
                finalHost = dns; // Forward DNS queries to public DNS
            }

            DatagramSocket outSocket = new DatagramSocket();
            if (vpnService != null) vpnService.protect(outSocket);

            InetAddress targetAddr = InetAddress.getByName(finalHost);
            DatagramPacket outPacket = new DatagramPacket(payload, payload.length, targetAddr, targetPort);
            outSocket.send(outPacket);

            // Receive response
            byte[] resBuffer = new byte[65535];
            DatagramPacket resPacket = new DatagramPacket(resBuffer, resBuffer.length);
            outSocket.setSoTimeout(5000);
            outSocket.receive(resPacket);
            outSocket.close();

            // Wrap back in SOCKS5 UDP header and send to client
            int resLen = resPacket.getLength();
            int resTotalLen = headerLength + resLen;
            byte[] resFullData = new byte[resTotalLen];
            System.arraycopy(data, 0, resFullData, 0, headerLength); // Copy original SOCKS header back
            System.arraycopy(resPacket.getData(), 0, resFullData, headerLength, resLen);

            DatagramPacket clientResponse = new DatagramPacket(resFullData, resFullData.length, packet.getAddress(), packet.getPort());
            udpRelaySocket.send(clientResponse);

        } catch (Exception e) {
            Log.e(TAG, "Error handling UDP packet", e);
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
        try {
            if (udpRelaySocket != null) udpRelaySocket.close();
        } catch (Exception ignored) {}
        if (executor != null) executor.shutdownNow();
    }
}
JAVA_EOF

git add .
git commit -m "Fix: Add full UDP Associate and DNS relay support to LocalSocks5Server"
git push origin main

echo "Pushed full UDP and DNS support fix successfully!"
