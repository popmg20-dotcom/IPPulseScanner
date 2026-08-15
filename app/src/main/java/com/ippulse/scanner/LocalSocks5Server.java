package com.ippulse.scanner;

import android.net.VpnService;
import android.util.Log;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LocalSocks5Server {
    private static final String TAG = "LocalSocks5";
    private final VpnService vpnService;
    private final int port;
    private final Map<String, String> hostsMap;
    private final String fallbackDns;
    private ServerSocket serverSocket;
    private boolean running = false;
    private ExecutorService executor;

    public LocalSocks5Server(VpnService vpnService, int port, Map<String, String> hostsMap, String fallbackDns) {
        this.vpnService = vpnService;
        this.port = port;
        this.hostsMap = hostsMap != null ? hostsMap : new HashMap<String, String>();
        this.fallbackDns = fallbackDns != null ? fallbackDns : "8.8.8.8";
    }

    public void start() {
        running = true;
        executor = Executors.newCachedThreadPool();
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(port, 50, InetAddress.getByName("127.0.0.1"));
                Log.i(TAG, "SOCKS5 listening on 127.0.0.1:" + port);
                while (running) {
                    final Socket client = serverSocket.accept();
                    executor.execute(() -> handleClient(client));
                }
            } catch (Exception e) {
                if (running) Log.e(TAG, "Server error", e);
            }
        }).start();
    }

    private void handleClient(Socket client) {
        try {
            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();

            // Greeting
            int version = in.read();
            if (version != 5) { client.close(); return; }
            int nmethods = in.read();
            byte[] methods = new byte[nmethods];
            in.read(methods);
            out.write(new byte[]{5, 0}); // NO AUTH
            out.flush();

            // Request
            int ver = in.read();
            int cmd = in.read();
            in.read(); // Reserved
            int atyp = in.read();

            String destAddr = "";
            if (atyp == 1) {
                byte[] b = new byte[4]; in.read(b); destAddr = InetAddress.getByAddress(b).getHostAddress();
            } else if (atyp == 3) {
                int len = in.read(); byte[] b = new byte[len]; in.read(b); destAddr = new String(b);
            } else if (atyp == 4) {
                byte[] b = new byte[16]; in.read(b); destAddr = InetAddress.getByAddress(b).getHostAddress();
            }

            byte[] portBuf = new byte[2]; in.read(portBuf);
            int destPort = ((portBuf[0] & 0xFF) << 8) | (portBuf[1] & 0xFF);

            if (cmd == 1) { // CONNECT (TCP)
                handleTcpConnect(client, in, out, destAddr, destPort);
            } else if (cmd == 3) { // UDP ASSOCIATE
                handleUdpAssociate(client, out);
            } else {
                client.close();
            }
        } catch (Exception e) {
            try { client.close(); } catch (Exception ignored) {}
        }
    }

    private void handleTcpConnect(Socket client, InputStream in, OutputStream out, String destAddr, int destPort) {
        try {
            Socket target = new Socket();
            vpnService.protect(target); // Critical: bypass VPN loop

            InetAddress targetAddr;
            if (destPort == 53) {
                if (hostsMap.containsKey(destAddr)) {
                    targetAddr = InetAddress.getByName(hostsMap.get(destAddr));
                } else {
                    targetAddr = InetAddress.getByName(fallbackDns);
                }
            } else {
                targetAddr = InetAddress.getByName(destAddr);
            }

            target.connect(new java.net.InetSocketAddress(targetAddr, destPort), 10000);

            // SOCKS5 Success Response
            byte[] resp = new byte[]{5, 0, 0, 1, 127, 0, 0, 1, (byte)(port >> 8), (byte)(port & 0xFF)};
            out.write(resp);
            out.flush();

            // Relay
            relayDataAsync(in, target.getOutputStream(), target.getInputStream(), out, client, target);
        } catch (Exception e) {
            try {
                out.write(new byte[]{5, 1, 0, 1, 0, 0, 0, 0, 0, 0});
                out.flush();
                client.close();
            } catch (Exception ignored) {}
        }
    }

    private void handleUdpAssociate(Socket client, OutputStream out) {
        try {
            byte[] resp = new byte[]{5, 0, 0, 1, 127, 0, 0, 1, (byte)(port >> 8), (byte)(port & 0xFF)};
            out.write(resp);
            out.flush();
            InputStream in = client.getInputStream();
            while (in.read() != -1) {}
        } catch (Exception ignored) {}
        finally {
            try { client.close(); } catch (Exception ignored) {}
        }
    }

    private void relayDataAsync(final InputStream in1, final OutputStream out1, 
                                final InputStream in2, final OutputStream out2, 
                                final Socket s1, final Socket s2) {
        executor.execute(() -> {
            try {
                byte[] buf = new byte[8192];
                int len;
                while ((len = in1.read(buf)) != -1) {
                    out1.write(buf, 0, len); out1.flush();
                }
            } catch (Exception ignored) {}
            finally {
                try { s1.close(); } catch (Exception ignored) {}
                try { s2.close(); } catch (Exception ignored) {}
            }
        });

        executor.execute(() -> {
            try {
                byte[] buf = new byte[8192];
                int len;
                while ((len = in2.read(buf)) != -1) {
                    out2.write(buf, 0, len); out2.flush();
                }
            } catch (Exception ignored) {}
            finally {
                try { s1.close(); } catch (Exception ignored) {}
                try { s2.close(); } catch (Exception ignored) {}
            }
        });
    }

    public void stop() {
        running = false;
        try { if (serverSocket != null) serverSocket.close(); } catch (Exception ignored) {}
        if (executor != null) executor.shutdownNow();
    }
}
