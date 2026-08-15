package com.ippulse.scanner;

import android.util.Log;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class LocalSocks5Server {
    private static final String TAG = "LocalSocks5Server";
    private int port;
    private ServerSocket serverSocket;
    private boolean isRunning = false;
    private HashMap<String, String> hostsMap;
    private GamingVpnService vpnService;

    public LocalSocks5Server(GamingVpnService context, int port, HashMap<String, String> hostsMap, String dns) {
        this.vpnService = context;
        this.port = port;
        this.hostsMap = hostsMap;
    }

    public void start() {
        isRunning = true;
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(port);
                Log.i(TAG, "SOCKS5 Server started on port " + port);
                while (isRunning) {
                    Socket clientSocket = serverSocket.accept();
                    new Thread(() -> handleClient(clientSocket)).start();
                }
            } catch (Exception e) {
                if (isRunning) {
                    Log.e(TAG, "SOCKS5 Server error", e);
                }
            }
        }, "SocksServerThread").start();
    }

    private void handleClient(Socket client) {
        try {
            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();

            int ver = in.read();
            int nMethods = in.read();
            byte[] methods = new byte[nMethods];
            in.read(methods);

            out.write(new byte[]{0x05, 0x00});
            out.flush();

            int version = in.read();
            int cmd = in.read();
            int reserved = in.read();
            int atyp = in.read();

            if (cmd != 0x01) { 
                client.close();
                return;
            }

            String host = "";
            if (atyp == 0x01) { 
                byte[] addr = new byte[4];
                in.read(addr);
                host = InetAddress.getByAddress(addr).getHostAddress();
            } else if (atyp == 0x03) { 
                int len = in.read();
                byte[] addr = new byte[len];
                in.read(addr);
                host = new String(addr);
            } else if (atyp == 0x04) { 
                byte[] addr = new byte[16];
                in.read(addr);
                host = InetAddress.getByAddress(addr).getHostAddress();
            }

            int port1 = in.read();
            int port2 = in.read();
            int destPort = ((port1 & 0xFF) << 8) | (port2 & 0xFF);

            if (hostsMap != null && hostsMap.containsKey(host)) {
                host = hostsMap.get(host);
            }

            Socket remote = new Socket();
            vpnService.protect(remote); // حیاتی برای جلوگیری از لوپ و وصل شدن به اینترنت
            remote.connect(new InetSocketAddress(host, destPort), 10000);

            byte[] response = new byte[]{0x05, 0x00, 0x00, 0x01, 0, 0, 0, 0, 0, 0};
            out.write(response);
            out.flush();

            Thread t1 = new Thread(() -> {
                try {
                    InputStream clientIn = client.getInputStream();
                    OutputStream remoteOut = remote.getOutputStream();
                    byte[] buffer = new byte[8192];
                    int read;
                    while (isRunning && (read = clientIn.read(buffer)) != -1) {
                        remoteOut.write(buffer, 0, read);
                    }
                } catch (Exception ignored) {}
                try { client.close(); } catch (Exception ignored) {}
                try { remote.close(); } catch (Exception ignored) {}
            });

            Thread t2 = new Thread(() -> {
                try {
                    InputStream remoteIn = remote.getInputStream();
                    OutputStream clientOut = client.getOutputStream();
                    byte[] buffer = new byte[8192];
                    int read;
                    while (isRunning && (read = remoteIn.read(buffer)) != -1) {
                        clientOut.write(buffer, 0, read);
                    }
                } catch (Exception ignored) {}
                try { client.close(); } catch (Exception ignored) {}
                try { remote.close(); } catch (Exception ignored) {}
            });

            t1.start();
            t2.start();

        } catch (Exception e) {
            try { client.close(); } catch (Exception ignored) {}
        }
    }

    public void stop() {
        isRunning = false;
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (Exception ignored) {}
    }
}
