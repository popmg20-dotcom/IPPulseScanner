package com.ippulse.scanner;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Socks5Server {
    private ServerSocket serverSocket;
    private ExecutorService executor;
    private volatile boolean running = false;
    private int port = 1080;

    public void start() {
        executor = Executors.newCachedThreadPool();
        running = true;
        try {
            serverSocket = new ServerSocket(port, 50, InetAddress.getByName("127.0.0.1"));
            executor.execute(this::acceptLoop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void acceptLoop() {
        while (running && !serverSocket.isClosed()) {
            try {
                Socket client = serverSocket.accept();
                executor.execute(() -> handleClient(client));
            } catch (IOException e) {
                if (running) e.printStackTrace();
            }
        }
    }

    private void handleClient(Socket client) {
        try {
            client.setSoTimeout(30000);
            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();

            // Greeting
            int ver = in.read();
            int nmethods = in.read();
            byte[] methods = new byte[nmethods];
            in.read(methods);
            out.write(new byte[]{5, 0}); // no auth
            out.flush();

            // Request
            ver = in.read();
            int cmd = in.read();
            in.read(); // RSV
            int atyp = in.read();
            String host = null;
            int port = 0;
            if (atyp == 1) {
                byte[] addr = new byte[4];
                in.read(addr);
                host = InetAddress.getByAddress(addr).getHostAddress();
            } else if (atyp == 3) {
                int len = in.read();
                byte[] addr = new byte[len];
                in.read(addr);
                host = new String(addr);
            } else if (atyp == 4) {
                byte[] addr = new byte[16];
                in.read(addr);
                host = InetAddress.getByAddress(addr).getHostAddress();
            }
            port = (in.read() << 8) | in.read();

            if (cmd == 1) { // CONNECT
                Socket remote = new Socket(host, port);
                out.write(new byte[]{5, 0, 0, 1, 0, 0, 0, 0, 0, 0});
                out.flush();
                pipe(client, remote);
            } else if (cmd == 3) { // UDP ASSOCIATE
                // Simplified UDP relay: not full, but compiles
                DatagramSocket udpSocket = new DatagramSocket();
                int localPort = udpSocket.getLocalPort();
                byte[] bindAddr = {127,0,0,1};
                out.write(new byte[]{5,0,0,1, bindAddr[0], bindAddr[1], bindAddr[2], bindAddr[3], (byte)(localPort>>8), (byte)localPort});
                out.flush();
                udpRelay(client, udpSocket);
            } else {
                out.write(new byte[]{5, 7, 0, 1, 0, 0, 0, 0, 0, 0}); // command not supported
                out.flush();
            }
        } catch (Exception e) {
            // ignore
        } finally {
            try { client.close(); } catch (IOException e) {}
        }
    }

    private void pipe(Socket a, Socket b) {
        Thread t1 = new Thread(() -> {
            try {
                byte[] buf = new byte[8192];
                int len;
                while ((len = a.getInputStream().read(buf)) > 0) {
                    b.getOutputStream().write(buf, 0, len);
                    b.getOutputStream().flush();
                }
            } catch (Exception e) {}
        });
        Thread t2 = new Thread(() -> {
            try {
                byte[] buf = new byte[8192];
                int len;
                while ((len = b.getInputStream().read(buf)) > 0) {
                    a.getOutputStream().write(buf, 0, len);
                    a.getOutputStream().flush();
                }
            } catch (Exception e) {}
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {}
    }

    private void udpRelay(Socket client, DatagramSocket udpSocket) {
        // Placeholder
        try { udpSocket.close(); } catch (Exception e) {}
    }

    public void stop() {
        running = false;
        try { if (serverSocket != null) serverSocket.close(); } catch (IOException e) {}
        if (executor != null) executor.shutdownNow();
    }
}
