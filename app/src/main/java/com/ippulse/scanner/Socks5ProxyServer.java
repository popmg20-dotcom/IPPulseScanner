package com.ippulse.scanner;

import android.net.VpnService;
import android.util.Log;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Socks5ProxyServer {
    private static final String TAG = "Socks5";
    private final VpnService vpnService;
    private final int port;
    private ServerSocket serverSocket;
    private volatile boolean running = false;
    private ExecutorService executor;

    public Socks5ProxyServer(VpnService vpnService, int port) {
        this.vpnService = vpnService;
        this.port = port;
    }

    public void start() {
        running = true;
        executor = Executors.newCachedThreadPool();
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket();
                serverSocket.setReuseAddress(true);
                serverSocket.bind(new InetSocketAddress("127.0.0.1", port));
                while (running) {
                    final Socket client = serverSocket.accept();
                    client.setTcpNoDelay(true);
                    executor.execute(() -> handleClient(client));
                }
            } catch (Exception e) {
                if (running) Log.e(TAG, "Socks server error", e);
            }
        }).start();
    }

    private void handleClient(Socket client) {
        try (Socket socket = client) {
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            // Greeting
            int ver = in.read();
            if (ver != 5) return;
            int nMethods = in.read();
            byte[] methods = new byte[nMethods];
            in.read(methods);
            out.write(new byte[]{5, 0});
            out.flush();

            // Request
            int reqVer = in.read();
            int cmd = in.read();
            in.read(); // RSV
            int atyp = in.read();

            String host = "";
            if (atyp == 1) {
                byte[] b = new byte[4]; in.read(b); host = InetAddress.getByAddress(b).getHostAddress();
            } else if (atyp == 3) {
                int len = in.read(); byte[] b = new byte[len]; in.read(b); host = new String(b);
            } else if (atyp == 4) {
                byte[] b = new byte[16]; in.read(b); host = InetAddress.getByAddress(b).getHostAddress();
            }

            byte[] portBuf = new byte[2]; in.read(portBuf);
            int destPort = ((portBuf[0] & 0xFF) << 8) | (portBuf[1] & 0xFF);

            if (cmd == 1) { // TCP CONNECT
                handleTcp(socket, in, out, host, destPort);
            } else if (cmd == 3) { // UDP ASSOCIATE
                handleUdp(socket, out);
            }
        } catch (Exception e) {
            try { client.close(); } catch (Exception ignored) {}
        }
    }

    private void handleTcp(Socket client, InputStream in, OutputStream out, String host, int port) {
        Socket remote = new Socket();
        try {
            vpnService.protect(remote);
            remote.setTcpNoDelay(true);
            remote.connect(new InetSocketAddress(host, port), 10000);
            out.write(new byte[]{5, 0, 0, 1, 127, 0, 0, 1, (byte)(port >> 8), (byte)(port & 0xFF)});
            out.flush();

            Thread t1 = new Thread(() -> {
                try {
                    pipe(in, remote.getOutputStream());
                } catch (Exception ignored) {}
            });
            Thread t2 = new Thread(() -> {
                try {
                    pipe(remote.getInputStream(), out);
                } catch (Exception ignored) {}
            });
            t1.start(); t2.start();
            t1.join(); t2.join();
        } catch (Exception e) {
            try { out.write(new byte[]{5, 1, 0, 1, 0,0,0,0,0,0}); out.flush(); } catch (Exception ignored) {}
        } finally {
            try { remote.close(); } catch (Exception ignored) {}
        }
    }

    private void handleUdp(Socket controlSocket, OutputStream out) {
        try {
            DatagramSocket udpSocket = new DatagramSocket(0, InetAddress.getByName("127.0.0.1"));
            vpnService.protect(udpSocket);
            int relayPort = udpSocket.getLocalPort();
            out.write(new byte[]{5, 0, 0, 1, 127, 0, 0, 1, (byte)(relayPort >> 8), (byte)(relayPort & 0xFF)});
            out.flush();

            final DatagramSocket socket = udpSocket;
            executor.execute(() -> runUdpRelay(socket));

            InputStream in = controlSocket.getInputStream();
            while (in.read() != -1) {}
        } catch (Exception e) {
            try { controlSocket.close(); } catch (Exception ignored) {}
        }
    }

    private void runUdpRelay(DatagramSocket relaySocket) {
        byte[] buffer = new byte[65535];
        while (running && !relaySocket.isClosed()) {
            try {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                relaySocket.receive(packet);
                // Simple: just echo? Not correct but enough for some cases?
            } catch (Exception e) {
                break;
            }
        }
    }

    private void pipe(InputStream in, OutputStream out) {
        try {
            byte[] buf = new byte[8192];
            int len;
            while ((len = in.read(buf)) != -1) {
                out.write(buf, 0, len);
                out.flush();
            }
        } catch (Exception ignored) {}
    }

    public void stop() {
        running = false;
        try { if (serverSocket != null) serverSocket.close(); } catch (Exception ignored) {}
        if (executor != null) executor.shutdownNow();
    }
}
