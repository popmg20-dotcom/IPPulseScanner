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
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LocalSocks5Server {
    private static final String TAG = "LocalSocks5Server";
    private final VpnService vpnService;
    private final HashMap<String, String> hostsMap;
    private final String upstreamDns;
    private final int port;

    private ServerSocket serverSocket;
    private DatagramSocket relayUdpSocket;
    private volatile boolean running = false;
    private ExecutorService executor;

    public LocalSocks5Server(VpnService vpnService, int port, HashMap<String, String> hostsMap, String upstreamDns) {
        this.vpnService = vpnService;
        this.port = port;
        this.hostsMap = hostsMap != null ? hostsMap : new HashMap<>();
        this.upstreamDns = upstreamDns != null ? upstreamDns : "8.8.8.8";
    }

    public void start() throws Exception {
        running = true;
        executor = Executors.newCachedThreadPool();
        serverSocket = new ServerSocket(port, 50, InetAddress.getByName("127.0.0.1"));
        
        executor.execute(this::acceptTcpLoop);
        
        relayUdpSocket = new DatagramSocket(0, InetAddress.getByName("127.0.0.1"));
        executor.execute(this::acceptUdpLoop);

        Log.i(TAG, "Local SOCKS5 running on 127.0.0.1:" + port);
    }

    public int getUdpRelayPort() {
        return relayUdpSocket != null ? relayUdpSocket.getLocalPort() : 0;
    }

    private void acceptTcpLoop() {
        while (running && !serverSocket.isClosed()) {
            try {
                Socket client = serverSocket.accept();
                executor.execute(() -> handleTcpClient(client));
            } catch (Exception e) {
                if (!running) break;
            }
        }
    }

    private void handleTcpClient(Socket client) {
        try {
            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();

            int ver = in.read();
            if (ver != 5) { client.close(); return; }
            int nmethods = in.read();
            byte[] methods = new byte[nmethods];
            in.read(methods);
            out.write(new byte[]{0x05, 0x00});
            out.flush();

            in.read();
            int cmd = in.read();
            in.read();
            int atyp = in.read();

            String host = "";
            if (atyp == 1) {
                byte[] ipBytes = new byte[4];
                in.read(ipBytes);
                host = InetAddress.getByAddress(ipBytes).getHostAddress();
            } else if (atyp == 3) {
                int len = in.read();
                byte[] domainBytes = new byte[len];
                in.read(domainBytes);
                host = new String(domainBytes);
            } else if (atyp == 4) {
                byte[] ip6Bytes = new byte[16];
                in.read(ip6Bytes);
                host = InetAddress.getByAddress(ip6Bytes).getHostAddress();
            }

            int portHi = in.read();
            int portLo = in.read();
            int dstPort = ((portHi & 0xFF) << 8) | (portLo & 0xFF);

            if (cmd == 1) {
                if (hostsMap.containsKey(host)) {
                    host = hostsMap.get(host);
                }

                Socket targetSocket = new Socket();
                vpnService.protect(targetSocket);
                targetSocket.connect(new InetSocketAddress(host, dstPort), 10000);

                out.write(new byte[]{0x05, 0x00, 0x00, 0x01, 127, 0, 0, 1, 0, 0});
                out.flush();

                executor.execute(() -> { try { pipe(in, targetSocket.getOutputStream()); } catch (Exception ignored) {} });
                try { pipe(targetSocket.getInputStream(), out); } catch (Exception ignored) {}

                targetSocket.close();
                client.close();
            } else if (cmd == 3) {
                int uPort = getUdpRelayPort();
                out.write(new byte[]{0x05, 0x00, 0x00, 0x01, 127, 0, 0, 1,
                        (byte) ((uPort >> 8) & 0xFF),
                        (byte) (uPort & 0xFF)});
                out.flush();
                while (running && client.getInputStream().read() != -1) {}
                client.close();
            } else {
                client.close();
            }
        } catch (Exception ignored) {}
    }

    private void pipe(InputStream in, OutputStream out) {
        byte[] buf = new byte[16384];
        int len;
        try {
            while ((len = in.read(buf)) != -1) {
                out.write(buf, 0, len);
                out.flush();
            }
        } catch (Exception ignored) {}
    }

    private void acceptUdpLoop() {
        byte[] buffer = new byte[65535];
        while (running && !relayUdpSocket.isClosed()) {
            try {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                relayUdpSocket.receive(packet);
                executor.execute(() -> handleUdpPacket(packet));
            } catch (Exception e) {
                if (!running) break;
            }
        }
    }

    private void handleUdpPacket(DatagramPacket packet) {
        try {
            byte[] data = packet.getData();
            int len = packet.getLength();
            if (len < 10) return;

            int atyp = data[3] & 0xFF;
            int headerLen = 4;
            String dstAddr = "";

            if (atyp == 1) {
                byte[] ip = new byte[4];
                System.arraycopy(data, 4, ip, 0, 4);
                dstAddr = InetAddress.getByAddress(ip).getHostAddress();
                headerLen += 4;
            } else if (atyp == 3) {
                int domainLen = data[4] & 0xFF;
                dstAddr = new String(data, 5, domainLen);
                headerLen += 1 + domainLen;
            } else if (atyp == 4) {
                byte[] ip6 = new byte[16];
                System.arraycopy(data, 4, ip6, 0, 16);
                dstAddr = InetAddress.getByAddress(ip6).getHostAddress();
                headerLen += 16;
            }

            int dstPort = ((data[headerLen] & 0xFF) << 8) | (data[headerLen + 1] & 0xFF);
            headerLen += 2;

            int payloadLen = len - headerLen;
            byte[] payload = new byte[payloadLen];
            System.arraycopy(data, headerLen, payload, 0, payloadLen);

            byte[] responsePayload = null;
            if ("10.0.0.1".equals(dstAddr) && dstPort == 53) {
                String domain = extractDomain(payload);
                if (domain != null && hostsMap.containsKey(domain)) {
                    responsePayload = buildDnsResponse(payload, hostsMap.get(domain));
                } else {
                    responsePayload = forwardDns(payload, upstreamDns);
                }
            } else {
                responsePayload = forwardGenericUdp(dstAddr, dstPort, payload);
            }

            if (responsePayload != null) {
                byte[] socksResp = new byte[headerLen + responsePayload.length];
                System.arraycopy(data, 0, socksResp, 0, headerLen);
                System.arraycopy(responsePayload, 0, socksResp, headerLen, responsePayload.length);

                DatagramPacket outPacket = new DatagramPacket(
                        socksResp, socksResp.length, packet.getAddress(), packet.getPort());
                relayUdpSocket.send(outPacket);
            }
        } catch (Exception e) {
            Log.e(TAG, "UDP handling error", e);
        }
    }

    private byte[] forwardGenericUdp(String dstAddr, int dstPort, byte[] payload) {
        try {
            DatagramSocket socket = new DatagramSocket();
            vpnService.protect(socket);
            socket.setSoTimeout(3000);
            DatagramPacket req = new DatagramPacket(payload, payload.length, InetAddress.getByName(dstAddr), dstPort);
            socket.send(req);

            byte[] resBuf = new byte[65535];
            DatagramPacket res = new DatagramPacket(resBuf, resBuf.length);
            socket.receive(res);
            socket.close();

            byte[] resp = new byte[res.getLength()];
            System.arraycopy(res.getData(), 0, resp, 0, res.getLength());
            return resp;
        } catch (Exception e) {
            return null;
        }
    }

    private byte[] forwardDns(byte[] query, String dnsServer) {
        try {
            DatagramSocket socket = new DatagramSocket();
            vpnService.protect(socket);
            socket.setSoTimeout(2500);
            DatagramPacket req = new DatagramPacket(query, query.length, InetAddress.getByName(dnsServer), 53);
            socket.send(req);

            byte[] resBuf = new byte[2048];
            DatagramPacket res = new DatagramPacket(resBuf, resBuf.length);
            socket.receive(res);
            socket.close();

            byte[] resp = new byte[res.getLength()];
            System.arraycopy(res.getData(), 0, resp, 0, res.getLength());
            return resp;
        } catch (Exception e) {
            return null;
        }
    }

    private String extractDomain(byte[] data) {
        try {
            int pos = 12;
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            while (pos < data.length) {
                int labelLength = data[pos] & 0xFF;
                if (labelLength == 0) break;
                if ((labelLength & 0xC0) == 0xC0) {
                    if (pos + 1 >= data.length) return null;
                    int pointer = ((labelLength & 0x3F) << 8) | (data[pos + 1] & 0xFF);
                    return extractDomainFromOffset(data, pointer);
                }
                if (labelLength > 63) return null;
                pos++;
                if (pos + labelLength > data.length) return null;
                if (!first) sb.append('.');
                for (int i = 0; i < labelLength; i++) sb.append((char) (data[pos + i] & 0xFF));
                first = false;
                pos += labelLength;
            }
            return sb.toString().toLowerCase();
        } catch (Exception e) {
            return null;
        }
    }

    private String extractDomainFromOffset(byte[] data, int offset) {
        try {
            int pos = offset;
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            while (pos < data.length) {
                int labelLength = data[pos] & 0xFF;
                if (labelLength == 0) break;
                if ((labelLength & 0xC0) == 0xC0) {
                    if (pos + 1 >= data.length) return null;
                    int pointer = ((labelLength & 0x3F) << 8) | (data[pos + 1] & 0xFF);
                    return extractDomainFromOffset(data, pointer);
                }
                if (labelLength > 63) return null;
                pos++;
                if (pos + labelLength > data.length) return null;
                if (!first) sb.append('.');
                for (int i = 0; i < labelLength; i++) sb.append((char) (data[pos + i] & 0xFF));
                first = false;
                pos += labelLength;
            }
            return sb.toString().toLowerCase();
        } catch (Exception e) {
            return null;
        }
    }

    private byte[] buildDnsResponse(byte[] query, String ip) {
        try {
            ByteBuffer response = ByteBuffer.allocate(1024);
            response.put(query[0]);
            response.put(query[1]);
            response.put((byte) 0x81);
            response.put((byte) 0x80);
            response.putShort((short) 1);
            response.putShort((short) 1);
            response.putShort((short) 0);
            response.putShort((short) 0);

            int pos = 12;
            while (pos < query.length && query[pos] != 0) {
                response.put(query[pos++]);
            }
            response.put((byte) 0);
            pos++;
            response.put(query[pos++]);
            response.put(query[pos++]);
            response.put(query[pos++]);
            response.put(query[pos++]);

            response.put((byte) 0xC0);
            response.put((byte) 0x0C);
            response.putShort((short) 1);
            response.putShort((short) 1);
            response.putInt(60);
            response.putShort((short) 4);
            String[] ipParts = ip.split("\\.");
            for (String part : ipParts) {
                response.put((byte) Integer.parseInt(part));
            }

            byte[] result = new byte[response.position()];
            System.arraycopy(response.array(), 0, result, 0, response.position());
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public void stop() {
        running = false;
        try { if (serverSocket != null) serverSocket.close(); } catch (Exception ignored) {}
        try { if (relayUdpSocket != null) relayUdpSocket.close(); } catch (Exception ignored) {}
        if (executor != null) executor.shutdownNow();
    }
}
