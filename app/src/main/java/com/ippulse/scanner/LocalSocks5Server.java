package com.ippulse.scanner;

import android.util.Log;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Arrays;

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
                while (isRunning) {
                    Socket clientSocket = serverSocket.accept();
                    new Thread(() -> handleClient(clientSocket)).start();
                }
            } catch (Exception e) { if (isRunning) Log.e(TAG, "SOCKS error", e); }
        }, "SocksServerThread").start();
    }

    private void handleClient(Socket client) {
        try {
            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();

            in.read(); 
            int nMethods = in.read();
            in.read(new byte[nMethods]);
            out.write(new byte[]{0x05, 0x00});
            out.flush();

            in.read(); 
            int cmd = in.read();
            in.read(); 
            int atyp = in.read();

            String host = "";
            if (atyp == 0x01) {
                byte[] addr = new byte[4]; in.read(addr);
                host = InetAddress.getByAddress(addr).getHostAddress();
            } else if (atyp == 0x03) {
                int len = in.read(); byte[] addr = new byte[len]; in.read(addr);
                host = new String(addr);
            } else if (atyp == 0x04) {
                byte[] addr = new byte[16]; in.read(addr);
                host = InetAddress.getByAddress(addr).getHostAddress();
            } else { client.close(); return; }

            int port1 = in.read(); int port2 = in.read();
            int destPort = ((port1 & 0xFF) << 8) | (port2 & 0xFF);

            if (hostsMap != null && hostsMap.containsKey(host)) {
                host = hostsMap.get(host);
            }

            if (cmd == 0x01) {
                handleTcp(client, in, out, host, destPort);
            } else if (cmd == 0x03) {
                handleUdp(client, out);
            } else {
                client.close();
            }
        } catch (Exception e) { try { client.close(); } catch (Exception ignored) {} }
    }

    private void handleTcp(Socket client, InputStream in, OutputStream out, String host, int destPort) {
        try {
            Socket remote = new Socket();
            vpnService.protect(remote);
            remote.connect(new InetSocketAddress(host, destPort), 10000);

            out.write(new byte[]{0x05, 0x00, 0x00, 0x01, 0, 0, 0, 0, 0, 0});
            out.flush();

            Thread t1 = new Thread(() -> {
                try {
                    InputStream remoteIn = remote.getInputStream();
                    byte[] buffer = new byte[16384]; int read;
                    while (isRunning && (read = remoteIn.read(buffer)) != -1) out.write(buffer, 0, read);
                } catch (Exception ignored) {}
                closeSockets(client, remote);
            });

            Thread t2 = new Thread(() -> {
                try {
                    OutputStream remoteOut = remote.getOutputStream();
                    byte[] buffer = new byte[16384]; int read;
                    while (isRunning && (read = in.read(buffer)) != -1) remoteOut.write(buffer, 0, read);
                } catch (Exception ignored) {}
                closeSockets(client, remote);
            });

            t1.start(); t2.start();
        } catch (Exception e) { closeSockets(client, null); }
    }

    private void handleUdp(Socket client, OutputStream out) {
        try {
            DatagramSocket udpSocket = new DatagramSocket(0, InetAddress.getByName("127.0.0.1"));
            vpnService.protect(udpSocket);
            int udpPort = udpSocket.getLocalPort();

            out.write(new byte[]{0x05, 0x00, 0x00, 0x01, 127, 0, 0, 1, (byte)(udpPort >> 8), (byte)(udpPort & 0xFF)});
            out.flush();

            new Thread(() -> {
                try {
                    byte[] buffer = new byte[65535];
                    while (isRunning) {
                        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                        udpSocket.receive(packet);

                        if (buffer[2] != 0) continue; 
                        int atyp = buffer[3];
                        int headerLen = 4;
                        String targetHost = "";
                        
                        if (atyp == 0x01) {
                            targetHost = InetAddress.getByAddress(Arrays.copyOfRange(buffer, 4, 8)).getHostAddress();
                            headerLen += 4;
                        } else if (atyp == 0x03) {
                            int len = buffer[4]; targetHost = new String(buffer, 5, len); headerLen += 1 + len;
                        } else if (atyp == 0x04) {
                            targetHost = InetAddress.getByAddress(Arrays.copyOfRange(buffer, 4, 20)).getHostAddress();
                            headerLen += 16;
                        } else { continue; }

                        int targetPort = ((buffer[headerLen] & 0xFF) << 8) | (buffer[headerLen + 1] & 0xFF);
                        headerLen += 2;

                        if (hostsMap != null && hostsMap.containsKey(targetHost)) targetHost = hostsMap.get(targetHost);

                        byte[] data = Arrays.copyOfRange(buffer, headerLen, packet.getLength());
                        DatagramSocket outSocket = new DatagramSocket();
                        vpnService.protect(outSocket);
                        DatagramPacket outPacket = new DatagramPacket(data, data.length, new InetSocketAddress(targetHost, targetPort));
                        
                        new Thread(() -> {
                            try {
                                byte[] resBuffer = new byte[65535];
                                DatagramPacket resPacket = new DatagramPacket(resBuffer, resBuffer.length);
                                outSocket.setSoTimeout(10000); outSocket.receive(resPacket);
                                
                                byte[] socksHeader = Arrays.copyOfRange(buffer, 0, headerLen);
                                byte[] finalData = new byte[socksHeader.length + resPacket.getLength()];
                                System.arraycopy(socksHeader, 0, finalData, 0, socksHeader.length);
                                System.arraycopy(resPacket.getData(), 0, finalData, socksHeader.length, resPacket.getLength());
                                
                                udpSocket.send(new DatagramPacket(finalData, finalData.length, packet.getSocketAddress()));
                            } catch (Exception ignored) {}
                            outSocket.close();
                        }).start();

                        outSocket.send(outPacket);
                    }
                } catch (Exception ignored) {}
            }).start();

            new Thread(() -> {
                try { client.getInputStream().read(); } catch (Exception ignored) {}
                udpSocket.close();
                try { client.close(); } catch (Exception ignored) {}
            }).start();
        } catch (Exception e) { closeSockets(client, null); }
    }

    private void closeSockets(Socket s1, Socket s2) {
        try { if (s1 != null) s1.close(); } catch (Exception ignored) {}
        try { if (s2 != null) s2.close(); } catch (Exception ignored) {}
    }

    public void stop() {
        isRunning = false;
        try { if (serverSocket != null) serverSocket.close(); } catch (Exception ignored) {}
    }
}
