package com.ippulse.scanner.wireguard;

import com.ippulse.scanner.utils.Logger;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class LocalDnsServer {
    private final Map<String, String> hostMappings;
    private final String upstreamDns;
    private DatagramSocket socket;
    private Thread thread;
    private volatile boolean running = false;

    public LocalDnsServer(Map<String, String> hostMappings, String upstreamDns) {
        this.hostMappings = hostMappings;
        this.upstreamDns = upstreamDns;
    }

    public void start() throws IOException {
        if (running) return;
        socket = new DatagramSocket(new InetSocketAddress("127.0.0.1", 53));
        running = true;
        thread = new Thread(this::runLoop);
        thread.start();
        Logger.d("Local DNS server started on 127.0.0.1:53");
    }

    public void stop() {
        running = false;
        if (socket != null) socket.close();
        if (thread != null) thread.interrupt();
        Logger.d("Local DNS server stopped");
    }

    private void runLoop() {
        byte[] buf = new byte[512];
        while (running) {
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            try {
                socket.receive(packet);
                handlePacket(packet);
            } catch (IOException e) {
                if (running) Logger.e("DNS receive error", e);
            }
        }
    }

    private void handlePacket(DatagramPacket packet) {
        try {
            byte[] requestData = packet.getData();
            int length = packet.getLength();
            // فقط به کوئری‌های A پاسخ می‌دهیم
            // ساختار DNS: header (12 bytes) + question
            if (length < 12) return;
            // تعداد سوالات
            int qdCount = ((requestData[4] & 0xFF) << 8) | (requestData[5] & 0xFF);
            if (qdCount != 1) return; // فقط یک سوال پشتیبانی می‌کنیم

            // استخراج نام دامنه
            int pos = 12;
            StringBuilder domainBuilder = new StringBuilder();
            while (pos < length) {
                int labelLen = requestData[pos] & 0xFF;
                if (labelLen == 0) break;
                pos++;
                if (pos + labelLen > length) return;
                domainBuilder.append(new String(requestData, pos, labelLen, StandardCharsets.US_ASCII));
                pos += labelLen;
                if (pos < length && requestData[pos] != 0) {
                    domainBuilder.append('.');
                }
            }
            String domain = domainBuilder.toString().toLowerCase();
            pos++; // skip null byte
            if (pos + 4 > length) return;
            int qtype = ((requestData[pos] & 0xFF) << 8) | (requestData[pos + 1] & 0xFF);
            int qclass = ((requestData[pos + 2] & 0xFF) << 8) | (requestData[pos + 3] & 0xFF);
            if (qtype != 1 && qtype != 28) { // فقط A و AAAA
                // برای سادگی فقط A را برمی‌گردانیم
                if (qtype != 1) return;
            }

            // ساخت پاسخ
            byte[] response = new byte[512];
            // Header
            System.arraycopy(requestData, 0, response, 0, 2); // ID
            // Flags: response, recursion available
            response[2] = (byte) 0x81;
            response[3] = (byte) 0x80;
            // QDCOUNT
            response[4] = requestData[4];
            response[5] = requestData[5];
            // ANCOUNT
            response[6] = 0x00;
            response[7] = 0x01;
            // NSCOUNT, ARCOUNT = 0
            response[8] = 0x00;
            response[9] = 0x00;
            response[10] = 0x00;
            response[11] = 0x00;
            // Copy question section
            int questionEnd = pos + 4;
            System.arraycopy(requestData, 12, response, 12, questionEnd - 12);
            // Answer section
            int answerPos = questionEnd;
            // Name pointer to question
            response[answerPos++] = (byte) 0xC0;
            response[answerPos++] = 0x0C;
            // Type A
            response[answerPos++] = 0x00;
            response[answerPos++] = 0x01;
            // Class IN
            response[answerPos++] = 0x00;
            response[answerPos++] = 0x01;
            // TTL = 60
            response[answerPos++] = 0x00;
            response[answerPos++] = 0x00;
            response[answerPos++] = 0x00;
            response[answerPos++] = 0x3C;
            // RDLENGTH = 4
            response[answerPos++] = 0x00;
            response[answerPos++] = 0x04;

            // IP address
            String mappedIp = hostMappings.get(domain);
            if (mappedIp == null) {
                // Forward to upstream
                DatagramSocket upstreamSocket = new DatagramSocket();
                upstreamSocket.setSoTimeout(5000);
                DatagramPacket upstreamPacket = new DatagramPacket(requestData, length,
                        InetAddress.getByName(upstreamDns), 53);
                upstreamSocket.send(upstreamPacket);
                byte[] upstreamBuf = new byte[512];
                DatagramPacket upstreamResponse = new DatagramPacket(upstreamBuf, upstreamBuf.length);
                upstreamSocket.receive(upstreamResponse);
                upstreamSocket.close();
                DatagramPacket respPacket = new DatagramPacket(upstreamResponse.getData(), upstreamResponse.getLength(),
                        packet.getAddress(), packet.getPort());
                socket.send(respPacket);
                Logger.d("Forwarded DNS query for: " + domain);
                return;
            } else {
                String[] ipParts = mappedIp.split("\.");
                if (ipParts.length != 4) return;
                for (int i = 0; i < 4; i++) {
                    response[answerPos++] = (byte) Integer.parseInt(ipParts[i]);
                }
                Logger.d("Mapped domain: " + domain + " -> " + mappedIp);
            }

            DatagramPacket respPacket = new DatagramPacket(response, answerPos, packet.getAddress(), packet.getPort());
            socket.send(respPacket);
        } catch (Exception e) {
            Logger.e("DNS handle error", e);
        }
    }
}
