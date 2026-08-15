package com.ippulse.scanner.socks;

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
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LocalSocks5Server {
    private static final String TAG = "LocalSocks5";
    private final int port;
    private final VpnService vpnService;
    private final Map<String, String> hostsMap;
    private final String fallbackDns;
    private ServerSocket serverSocket;
    private boolean isRunning = false;
    private ExecutorService threadPool;

    public LocalSocks5Server(VpnService vpnService, int port, Map<String, String> hostsMap, String fallbackDns) {
        this.vpnService = vpnService;
        this.port = port;
        this.hostsMap = hostsMap != null ? hostsMap : new HashMap<String, String>();
        this.fallbackDns = fallbackDns != null ? fallbackDns : "8.8.8.8";
    }

    public void start() {
        isRunning = true;
        threadPool = Executors.newCachedThreadPool();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    serverSocket = new ServerSocket(port, 50, InetAddress.getByName("127.0.0.1"));
                    Log.i(TAG, "SOCKS5 server bound on 127.0.0.1:" + port);
                    while (isRunning) {
                        final Socket client = serverSocket.accept();
                        threadPool.execute(new Runnable() {
                            @Override
                            public void run() {
                                handleClient(client);
                            }
                        });
                    }
                } catch (Exception e) {
                    if (isRunning) Log.e(TAG, "SOCKS5 Accept Error", e);
                }
            }
        }).start();
    }

    private void handleClient(Socket client) {
        try {
            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();

            int version = in.read();
            if (version != 5) {
                client.close();
                return;
            }
            int nmethods = in.read();
            byte[] methods = new byte[nmethods];
            in.read(methods);
            out.write(new byte[]{5, 0}); // NO AUTH
            out.flush();

            int ver = in.read();
            int cmd = in.read();
            in.read(); // Reserved
            int atyp = in.read();

            String destAddr = "";
            if (atyp == 1) { // IPv4
                byte[] b = new byte[4];
                in.read(b);
                destAddr = InetAddress.getByAddress(b).getHostAddress();
            } else if (atyp == 3) { // Domain Name
                int len = in.read();
                byte[] b = new byte[len];
                in.read(b);
                destAddr = new String(b);
            } else if (atyp == 4) { // IPv6
                byte[] b = new byte[16];
                in.read(b);
                destAddr = InetAddress.getByAddress(b).getHostAddress();
            }

            byte[] portBuf = new byte[2];
            in.read(portBuf);
            int destPort = ((portBuf[0] & 0xFF) << 8) | (portBuf[1] & 0xFF);

            if (cmd == 1) { // TCP CONNECT
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
        final Socket target = new Socket();
        try {
            vpnService.protect(target); // Prevent infinite VPN loop

            InetAddress targetAddr;
            if (destPort == 53 || hostsMap.containsKey(destAddr)) {
                targetAddr = resolveDns(destAddr);
            } else {
                targetAddr = InetAddress.getByName(destAddr);
            }

            target.connect(new InetSocketAddress(targetAddr, destPort), 10000);

            out.write(new byte[]{5, 0, 0, 1, 127, 0, 0, 1, (byte)(port >> 8), (byte)(port & 0xFF)});
            out.flush();

            relayTcpData(in, target.getOutputStream(), target.getInputStream(), out, client, target);
        } catch (Exception e) {
            try {
                out.write(new byte[]{5, 1, 0, 1, 0, 0, 0, 0, 0, 0});
                out.flush();
                client.close();
                target.close();
            } catch (Exception ignored) {}
        }
    }

    private void handleUdpAssociate(Socket client, OutputStream out) {
        try {
            final DatagramSocket udpRelay = new DatagramSocket(0, InetAddress.getByName("127.0.0.1"));
            final DatagramSocket outboundUdp = new DatagramSocket();
            vpnService.protect(outboundUdp); // Protect outbound real UDP traffic

            int boundPort = udpRelay.getLocalPort();
            byte[] resp = new byte[]{5, 0, 0, 1, 127, 0, 0, 1, (byte)(boundPort >> 8), (byte)(boundPort & 0xFF)};
            out.write(resp);
            out.flush();

            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        byte[] buffer = new byte[4096];
                        while (isRunning && !client.isClosed()) {
                            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                            udpRelay.receive(packet);

                            byte[] data = packet.getData();
                            int length = packet.getLength();
                            if (length < 10) continue;

                            int atyp = data[3] & 0xFF;
                            int headerLen = 6;
                            String destHost = "";
                            if (atyp == 1) { // IPv4
                                byte[] ip = new byte[4];
                                System.arraycopy(data, 4, ip, 0, 4);
                                destHost = InetAddress.getByAddress(ip).getHostAddress();
                                headerLen = 10;
                            } else if (atyp == 3) { // Domain
                                int dlen = data[4] & 0xFF;
                                destHost = new String(data, 5, dlen);
                                headerLen = 7 + dlen;
                            }

                            int destPort = ((data[headerLen - 2] & 0xFF) << 8) | (data[headerLen - 1] & 0xFF);
                            InetAddress targetAddr = (destPort == 53 || hostsMap.containsKey(destHost)) 
                                    ? resolveDns(destHost) : InetAddress.getByName(destHost);

                            int payloadLen = length - headerLen;
                            DatagramPacket outboundPacket = new DatagramPacket(data, headerLen, payloadLen, targetAddr, destPort);
                            outboundUdp.send(outboundPacket);
                        }
                    } catch (Exception ignored) {}
                    finally {
                        udpRelay.close();
                        outboundUdp.close();
                    }
                }
            });

            InputStream in = client.getInputStream();
            while (in.read() != -1) {}
        } catch (Exception e) {
            try { client.close(); } catch (Exception ignored) {}
        }
    }

    private InetAddress resolveDns(String domain) throws Exception {
        if (hostsMap.containsKey(domain)) {
            return InetAddress.getByName(hostsMap.get(domain));
        }
        return InetAddress.getByName(fallbackDns);
    }

    private void relayTcpData(final InputStream in1, final OutputStream out1,
                              final InputStream in2, final OutputStream out2,
                              final Socket s1, final Socket s2) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    byte[] buf = new byte[8192];
                    int len;
                    while ((len = in1.read(buf)) != -1) {
                        out1.write(buf, 0, len);
                        out1.flush();
                    }
                } catch (Exception ignored) {}
                finally {
                    try { s1.close(); } catch (Exception ignored) {}
                    try { s2.close(); } catch (Exception ignored) {}
                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    byte[] buf = new byte[8192];
                    int len;
                    while ((len = in2.read(buf)) != -1) {
                        out2.write(buf, 0, len);
                        out2.flush();
                    }
                } catch (Exception ignored) {}
                finally {
                    try { s1.close(); } catch (Exception ignored) {}
                    try { s2.close(); } catch (Exception ignored) {}
                }
            }
        });
    }

    public void stop() {
        isRunning = false;
        try { if (serverSocket != null) serverSocket.close(); } catch (Exception ignored) {}
        if (threadPool != null) threadPool.shutdownNow();
    }
}
