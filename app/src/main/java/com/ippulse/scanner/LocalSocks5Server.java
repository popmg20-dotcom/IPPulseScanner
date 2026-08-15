package com.ippulse.scanner;

import android.util.Log;
import java.io.DataInputStream;
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
    private final HashMap<String, DatagramSocket> udpSessions = new HashMap<>();

    public LocalSocks5Server(GamingVpnService context, int port, HashMap<String, String> hostsMap, String dns) {
        this.vpnService = context;
        this.port = port;
        this.hostsMap = hostsMap;
    }

    public void start() {
        isRunning = true;
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket();
                serverSocket.setReuseAddress(true); // جلوگیری از خطای اشغال بودن پورت در صورت استارت مجدد
                serverSocket.bind(new InetSocketAddress("127.0.0.1", port));
                
                while (isRunning) {
                    Socket clientSocket = serverSocket.accept();
                    clientSocket.setTcpNoDelay(true); // مناسب برای کاهش پینگ گیمینگ
                    new Thread(() -> handleClient(clientSocket)).start();
                }
            } catch (Exception e) { if (isRunning) Log.e(TAG, "SOCKS error", e); }
        }, "SocksServerThread").start();
    }

    private void handleClient(Socket client) {
        try {
            DataInputStream in = new DataInputStream(client.getInputStream());
            OutputStream out = client.getOutputStream();

            in.readByte(); 
            int nMethods = in.readUnsignedByte();
            byte[] methods = new byte[nMethods];
            in.readFully(methods); // جایگزینی skipBytes برای جلوگیری از باگ‌های بافر

            out.write(new byte[]{0x05, 0x00});
            out.flush();

            in.readByte(); 
            int cmd = in.readUnsignedByte();
            in.readByte(); 
            int atyp = in.readUnsignedByte();

            String host = "";
            if (atyp == 0x01) {
                byte[] addr = new byte[4]; in.readFully(addr);
                host = InetAddress.getByAddress(addr).getHostAddress();
            } else if (atyp == 0x03) {
                int len = in.readUnsignedByte(); byte[] addr = new byte[len]; in.readFully(addr);
                host = new String(addr);
            } else if (atyp == 0x04) {
                byte[] addr = new byte[16]; in.readFully(addr);
                host = InetAddress.getByAddress(addr).getHostAddress();
            } else { client.close(); return; }

            int destPort = in.readUnsignedShort();

            if (hostsMap != null && hostsMap.containsKey(host)) host = hostsMap.get(host);

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
        Socket remote = new Socket();
        try {
            vpnService.protect(remote);
            remote.setTcpNoDelay(true);
            remote.connect(new InetSocketAddress(host, destPort), 10000);

            out.write(new byte[]{0x05, 0x00, 0x00, 0x01, 127, 0, 0, 1, (byte)(port >> 8), (byte)(port & 0xFF)});
            out.flush();

            Thread t1 = new Thread(() -> {
                try {
                    InputStream remoteIn = remote.getInputStream();
                    byte[] buffer = new byte[16384]; int read;
                    while (isRunning && (read = remoteIn.read(buffer)) != -1) {
                        out.write(buffer, 0, read); out.flush();
                    }
                } catch (Exception ignored) {}
                try { client.shutdownOutput(); } catch (Exception ignored) {}
                try { remote.shutdownInput(); } catch (Exception ignored) {}
            });

            Thread t2 = new Thread(() -> {
                try {
                    OutputStream remoteOut = remote.getOutputStream();
                    byte[] buffer = new byte[16384]; int read;
                    while (isRunning && (read = in.read(buffer)) != -1) {
                        remoteOut.write(buffer, 0, read); remoteOut.flush();
                    }
                } catch (Exception ignored) {}
                try { remote.shutdownOutput(); } catch (Exception ignored) {}
                try { client.shutdownInput(); } catch (Exception ignored) {}
            });

            t1.start(); t2.start();
        } catch (Exception e) { closeSockets(client, remote); }
    }

    private void handleUdp(Socket client, OutputStream out) {
        try {
            DatagramSocket udpSocket = new DatagramSocket(null);
            udpSocket.setReuseAddress(true);
            udpSocket.bind(new InetSocketAddress("127.0.0.1", 0));
            vpnService.protect(udpSocket);
            int udpPort = udpSocket.getLocalPort();

            out.write(new byte[]{0x05, 0x00, 0x00, 0x01, 127, 0, 0, 1, (byte)(udpPort >> 8), (byte)(udpPort & 0xFF)});
            out.flush();

            new Thread(() -> {
                try {
                    byte[] buffer = new byte[65535];
                    while (isRunning && !udpSocket.isClosed()) {
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
                        
                        if (packet.getLength() <= headerLen) continue;

                        if (hostsMap != null && hostsMap.containsKey(targetHost)) targetHost = hostsMap.get(targetHost);

                        byte[] data = Arrays.copyOfRange(buffer, headerLen, packet.getLength());
                        String sessionKey = targetHost + ":" + targetPort;
                        DatagramSocket outSocket;

                        synchronized (udpSessions) {
                            outSocket = udpSessions.get(sessionKey);
                            if (outSocket == null || outSocket.isClosed()) {
                                outSocket = new DatagramSocket();
                                vpnService.protect(outSocket);
                                udpSessions.put(sessionKey, outSocket);

                                final DatagramSocket currentOutSocket = outSocket;
                                final byte[] finalSocksHeader = Arrays.copyOfRange(buffer, 0, headerLen);
                                
                                new Thread(() -> {
                                    try {
                                        byte[] resBuffer = new byte[65535];
                                        while (isRunning && !currentOutSocket.isClosed()) {
                                            DatagramPacket resPacket = new DatagramPacket(resBuffer, resBuffer.length);
                                            currentOutSocket.setSoTimeout(45000); 
                                            currentOutSocket.receive(resPacket);
                                            
                                            byte[] finalData = new byte[finalSocksHeader.length + resPacket.getLength()];
                                            System.arraycopy(finalSocksHeader, 0, finalData, 0, finalSocksHeader.length);
                                            System.arraycopy(resPacket.getData(), 0, finalData, finalSocksHeader.length, resPacket.getLength());
                                            
                                            udpSocket.send(new DatagramPacket(finalData, finalData.length, packet.getSocketAddress()));
                                        }
                                    } catch (Exception ignored) {}
                                    currentOutSocket.close();
                                    synchronized (udpSessions) { udpSessions.remove(sessionKey); }
                                }).start();
                            }
                        }
                        outSocket.send(new DatagramPacket(data, data.length, new InetSocketAddress(targetHost, targetPort)));
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
        synchronized (udpSessions) {
            for (DatagramSocket socket : udpSessions.values()) {
                if (socket != null && !socket.isClosed()) socket.close();
            }
            udpSessions.clear();
        }
    }
}
