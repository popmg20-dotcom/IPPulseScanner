package com.ippulse.scanner.wireguard;

import org.xbill.DNS.*;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Map;
import com.ippulse.scanner.utils.Logger;

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
        Logger.d("Local DNS server started on 127.0.0.1:53");
        running = true;
        thread = new Thread(this::runLoop);
        thread.start();
    }

    public void stop() {
        running = false;
        if (socket != null) socket.close();
        if (thread != null) thread.interrupt();
    }

    private void runLoop() {
        byte[] buf = new byte[512];
        while (running) {
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            try {
                socket.receive(packet);
                handlePacket(packet);
            } catch (IOException e) {
                if (running) e.printStackTrace();
            }
        }
    }

    private void handlePacket(DatagramPacket packet) {
        try {
            Message request = new Message(packet.getData());
            Message response = new Message(request.getHeader().getID());
            response.getHeader().setFlag(Flags.QR);
            response.addRecord(request.getQuestion(), Section.QUESTION);

            String domain = request.getQuestion().getName().toString().toLowerCase();
            if (hostMappings.containsKey(domain)) {
                String ip = hostMappings.get(domain);
                ARecord record = new ARecord(Name.fromString(domain), DClass.IN, 60, InetAddress.getByName(ip));
                response.addRecord(record, Section.ANSWER);
                Logger.d("Mapped domain: " + domain + " -> " + ip);
                byte[] respData = response.toWire();
                DatagramPacket respPacket = new DatagramPacket(respData, respData.length, packet.getAddress(), packet.getPort());
                socket.send(respPacket);
            } else {
                DatagramSocket upstreamSocket = new DatagramSocket();
                upstreamSocket.setSoTimeout(5000);
                DatagramPacket upstreamPacket = new DatagramPacket(packet.getData(), packet.getLength(), InetAddress.getByName(upstreamDns), 53);
                upstreamSocket.send(upstreamPacket);
                byte[] respBuf = new byte[512];
                DatagramPacket upstreamResponse = new DatagramPacket(respBuf, respBuf.length);
                upstreamSocket.receive(upstreamResponse);
                Logger.d("Forwarded DNS query for: " + domain);
                upstreamSocket.close();

                DatagramPacket respPacket = new DatagramPacket(upstreamResponse.getData(), upstreamResponse.getLength(), packet.getAddress(), packet.getPort());
                socket.send(respPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
