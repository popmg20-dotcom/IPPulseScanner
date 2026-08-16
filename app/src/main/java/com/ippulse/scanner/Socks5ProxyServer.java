package com.ippulse.scanner;

import android.net.VpnService;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class Socks5ProxyServer {

    private static final String TAG = "IPPulseSocks5";
    private final VpnService vpnService;
    private final String dnsServer;
    private volatile Map<String, String> hostsMap;
    private volatile boolean running;
    private ServerSocket tcpServer;
    private final ExecutorService pool = Executors.newCachedThreadPool();

    public Socks5ProxyServer(VpnService vpnService, String dnsServer, Map<String, String> hostsMap) {
        this.vpnService = vpnService;
        this.dnsServer = dnsServer;
        this.hostsMap = hostsMap;
    }

    public synchronized boolean start() {
        if (running) return true;
        try {
            tcpServer = new ServerSocket(1080, 64, InetAddress.getByName("127.0.0.1"));
            running = true;
            pool.execute(this::acceptLoop);
            Log.i(TAG, "SOCKS5 listening on 127.0.0.1:1080");
            return true;
        } catch (Exception e) {
            Log.e(TAG, "SOCKS5 start failed", e);
            stop();
            return false;
        }
    }

    public synchronized void stop() {
        running = false;
        if (tcpServer != null) try { tcpServer.close(); } catch (Exception ignored) {}
        pool.shutdownNow();
    }

    public void updateHostsMap(Map<String, String> map) { hostsMap = map; }

    private void acceptLoop() {
        while (running) {
            try {
                Socket client = tcpServer.accept();
                pool.execute(() -> handleClient(client));
            } catch (SocketException e) {
                if (running) Log.e(TAG, "accept()", e);
                break;
            } catch (Exception e) {
                if (running) Log.e(TAG, "accept failed", e);
            }
        }
    }

    private void handleClient(Socket client) {
        try (Socket socket = client) {
            socket.setTcpNoDelay(true);
            InputStream in = new BufferedInputStream(socket.getInputStream());
            OutputStream out = new BufferedOutputStream(socket.getOutputStream());

            int version = in.read();
            if (version != 5) return;
            int nMethods = in.read();
            if (nMethods < 0 || nMethods > 255) return;
            byte[] methods = new byte[nMethods];
            readFully(in, methods);
            out.write(5); out.write(0); out.flush();

            int reqVersion = in.read();
            int cmd = in.read();
            in.read(); // reserved
            int atyp = in.read();
            if (reqVersion != 5) return;

            HostPort hp = readHostPort(in, atyp);
            if (hp == null) { sendFailure(out); return; }

            if (cmd == 1) {
                handleConnect(socket, in, out, hp);
            } else if (cmd == 3) {
                handleUdpAssociate(socket, out, hp);
            } else {
                sendCommandFailure(out, 0x07);
            }
        } catch (Exception e) {
            Log.d(TAG, "client closed");
        }
    }

    private void handleConnect(Socket client, InputStream in, OutputStream out, HostPort hp) {
        Socket remote = null;
        try {
            remote = new Socket();
            if (!vpnService.protect(remote)) throw new IOException("protect failed");
            remote.setTcpNoDelay(true);
            remote.connect(new InetSocketAddress(resolveForConnect(hp.host), hp.port), 12000);
            sendSuccess(out, remote);

            if (hp.port == 53) {
                if (tryHandleTcpDns(client, in, out, remote)) return;
            }

            relayBidirectional(client, remote);
        } catch (Exception e) {
            try { sendCommandFailure(out, 0x05); } catch (Exception ignored) {}
        } finally {
            closeQuietly(remote);
        }
    }

    private void handleUdpAssociate(Socket controlSocket, OutputStream out, HostPort hp) {
        DatagramSocket udpRelay = null;
        DatagramSocket outboundUdp = null;
        try {
            udpRelay = new DatagramSocket(0, InetAddress.getByName("127.0.0.1"));
            if (!vpnService.protect(udpRelay)) throw new IOException("protect UDP failed");

            outboundUdp = new DatagramSocket();
            if (!vpnService.protect(outboundUdp)) throw new IOException("protect outbound UDP failed");

            int relayPort = udpRelay.getLocalPort();
            byte[] resp = new byte[]{5, 0, 0, 1, 127, 0, 0, 1, (byte)(relayPort >> 8), (byte)(relayPort & 0xFF)};
            out.write(resp); out.flush();

            final DatagramSocket udpRelayFinal = udpRelay;
            final DatagramSocket outboundUdpFinal = outboundUdp;

            pool.execute(() -> runUdpRelay(udpRelayFinal, outboundUdpFinal));

            InputStream in = controlSocket.getInputStream();
            while (in.read() != -1) {}
        } catch (Exception e) {
            Log.d(TAG, "UDP associate failed: " + e.getMessage());
        } finally {
            closeQuietly(udpRelay);
            closeQuietly(outboundUdp);
        }
    }

    private void runUdpRelay(DatagramSocket relaySocket, DatagramSocket outboundSocket) {
        byte[] buffer = new byte[65535];
        while (running && !relaySocket.isClosed() && !outboundSocket.isClosed()) {
            try {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                relaySocket.receive(packet);

                byte[] data = packet.getData();
                int length = packet.getLength();
                if (length < 10) continue;
                if (data[0] != 0 || data[1] != 0 || data[2] != 0) continue;

                int atyp = data[3] & 0xFF;
                int headerLen = 4;
                String targetHost = "";
                if (atyp == 1) {
                    targetHost = InetAddress.getByAddress(new byte[]{data[4], data[5], data[6], data[7]}).getHostAddress();
                    headerLen = 10;
                } else if (atyp == 3) {
                    int dlen = data[4] & 0xFF;
                    targetHost = new String(data, 5, dlen);
                    headerLen = 7 + dlen;
                } else continue;

                int targetPort = ((data[headerLen - 2] & 0xFF) << 8) | (data[headerLen - 1] & 0xFF);
                int payloadLen = length - headerLen;
                if (payloadLen <= 0) continue;

                String mapped = hostsMap != null ? hostsMap.get(DnsProxyServer.normalizeDomain(targetHost)) : null;
                if (mapped != null) targetHost = mapped;

                DatagramPacket outbound = new DatagramPacket(data, headerLen, payloadLen, InetAddress.getByName(targetHost), targetPort);
                outboundSocket.send(outbound);

                // Wait for response in separate thread (simplified: echo response not implemented)
            } catch (Exception e) {
                if (running) Log.d(TAG, "UDP relay error");
                break;
            }
        }
    }

    private boolean tryHandleTcpDns(Socket client, InputStream in, OutputStream out, Socket remote) {
        // Simplified: not full DNS over TCP handling, just close and return false to use normal relay
        return false;
    }

    private InetAddress resolveForConnect(String host) throws Exception {
        String mapped = hostsMap != null ? hostsMap.get(DnsProxyServer.normalizeDomain(host)) : null;
        if (mapped != null) return InetAddress.getByName(mapped);
        return InetAddress.getByName(host);
    }

    private void relayBidirectional(Socket client, Socket remote) {
        pool.execute(() -> pipe(client, remote));
        pool.execute(() -> pipe(remote, client));
    }

    private void pipe(Socket source, Socket dest) {
        try {
            InputStream in = source.getInputStream();
            OutputStream out = dest.getOutputStream();
            byte[] buffer = new byte[8192];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
                out.flush();
            }
        } catch (Exception ignored) {}
        finally {
            closeQuietly(source);
            closeQuietly(dest);
        }
    }

    private void sendSuccess(OutputStream out, Socket remote) throws IOException {
        byte[] ip = remote.getLocalAddress().getAddress();
        out.write(new byte[]{5, 0, 0, 1, ip[0], ip[1], ip[2], ip[3], (byte)(remote.getLocalPort() >> 8), (byte)(remote.getLocalPort() & 0xFF)});
        out.flush();
    }

    private void sendFailure(OutputStream out) { try { out.write(new byte[]{5, 1, 0, 1, 0,0,0,0,0,0}); out.flush(); } catch (Exception ignored) {} }

    private void sendCommandFailure(OutputStream out, int status) { try { out.write(new byte[]{5, (byte)status, 0, 1, 0,0,0,0,0,0}); out.flush(); } catch (Exception ignored) {} }

    private HostPort readHostPort(InputStream in, int atyp) throws IOException {
        String host = "";
        if (atyp == 1) {
            byte[] b = new byte[4]; readFully(in, b); host = InetAddress.getByAddress(b).getHostAddress();
        } else if (atyp == 3) {
            int len = in.read(); byte[] b = new byte[len]; readFully(in, b); host = new String(b);
        } else if (atyp == 4) {
            byte[] b = new byte[16]; readFully(in, b); host = InetAddress.getByAddress(b).getHostAddress();
        } else {
            return null;
        }
        int port = (in.read() << 8) | in.read();
        return new HostPort(host, port);
    }

    private void readFully(InputStream in, byte[] buf) throws IOException {
        int offset = 0;
        while (offset < buf.length) {
            int read = in.read(buf, offset, buf.length - offset);
            if (read < 0) throw new IOException("EOF");
            offset += read;
        }
    }

    private void closeQuietly(Closeable closeable) {
        if (closeable != null) try { closeable.close(); } catch (Exception ignored) {}
    }

    private static class HostPort {
        String host;
        int port;
        HostPort(String host, int port) { this.host = host; this.port = port; }
    }
}
