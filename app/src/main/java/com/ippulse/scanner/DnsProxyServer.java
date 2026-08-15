package com.ippulse.scanner;

import android.util.Log;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class DnsProxyServer {
    private static final String TAG = "DnsProxy";
    private final int port;
    private final String dns;
    private final HashMap<String, String> hostsMap;
    private DatagramSocket socket;
    private volatile boolean running = false;

    public DnsProxyServer(int port, String dns, HashMap<String, String> hostsMap) {
        this.port = port;
        this.dns = dns;
        this.hostsMap = hostsMap;
    }

    public void start() {
        running = true;
        new Thread(() -> {
            try {
                socket = new DatagramSocket(port, InetAddress.getByName("26.26.26.1"));
                socket.setSoTimeout(0);
                byte[] buffer = new byte[1024];
                while (running) {
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    socket.receive(packet);
                    new Thread(() -> handleRequest(packet)).start();
                }
            } catch (Exception e) {
                if (running) Log.e(TAG, "DNS server error", e);
            }
        }).start();
    }

    private void handleRequest(DatagramPacket packet) {
        try {
            byte[] query = packet.getData();
            int len = packet.getLength();
            byte[] response = resolve(query, len);
            if (response != null) {
                DatagramPacket responsePacket = new DatagramPacket(response, response.length,
                        packet.getAddress(), packet.getPort());
                socket.send(responsePacket);
            }
        } catch (Exception e) {
            Log.e(TAG, "DNS handle error", e);
        }
    }

    private byte[] resolve(byte[] query, int len) {
        try {
            String domain = extractDomain(query, len);
            if (domain != null && hostsMap.containsKey(domain)) {
                return buildDnsResponse(query, len, hostsMap.get(domain));
            }
            // forward to upstream
            DatagramSocket upstream = new DatagramSocket();
            InetAddress upstreamAddr = InetAddress.getByName(dns);
            DatagramPacket req = new DatagramPacket(query, len, upstreamAddr, 53);
            upstream.send(req);
            byte[] buf = new byte[1024];
            DatagramPacket resp = new DatagramPacket(buf, buf.length);
            upstream.setSoTimeout(3000);
            upstream.receive(resp);
            byte[] result = new byte[resp.getLength()];
            System.arraycopy(resp.getData(), 0, result, 0, result.length);
            upstream.close();
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    private String extractDomain(byte[] data, int len) {
        StringBuilder sb = new StringBuilder();
        int pos = 12;
        while (pos < len && data[pos] != 0) {
            int labelLen = data[pos++] & 0xFF;
            if (sb.length() > 0) sb.append('.');
            sb.append(new String(data, pos, labelLen));
            pos += labelLen;
        }
        return sb.toString().toLowerCase();
    }

    private byte[] buildDnsResponse(byte[] query, int len, String ip) {
        ByteBuffer response = ByteBuffer.allocate(512);
        response.put(query, 0, 2); // ID
        response.put((byte) 0x81); response.put((byte) 0x80);
        response.putShort((short) 1); // QDCOUNT
        response.putShort((short) 1); // ANCOUNT
        response.putShort((short) 0); response.putShort((short) 0);

        // Copy question section
        int pos = 12;
        while (pos < len && query[pos] != 0) {
            response.put(query[pos++]);
        }
        response.put((byte) 0);
        pos++;
        response.put(query, pos, 4); // QTYPE + QCLASS

        // Answer
        response.put((byte) 0xC0); response.put((byte) 0x0C);
        response.putShort((short) 1); // A
        response.putShort((short) 1); // IN
        response.putInt(60); // TTL
        response.putShort((short) 4); // RDLENGTH
        String[] parts = ip.split("\\.");
        for (String p : parts) response.put((byte) Integer.parseInt(p));

        byte[] result = new byte[response.position()];
        System.arraycopy(response.array(), 0, result, 0, result.length);
        return result;
    }

    public void stop() {
        running = false;
        if (socket != null) socket.close();
    }
}
