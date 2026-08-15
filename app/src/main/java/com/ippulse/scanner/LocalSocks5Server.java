package com.ippulse.scanner;

import android.net.VpnService;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LocalSocks5Server implements Closeable {
    private static final String TAG = "LocalSocks5";
    private static final int SOCKS_VERSION = 5;
    private static final int NO_AUTH = 0x00;
    private static final int CMD_CONNECT = 0x01;
    private static final int CMD_UDP_ASSOCIATE = 0x03;
    private static final int ATYP_IPV4 = 0x01;
    private static final int ATYP_DOMAIN = 0x03;
    private static final int ATYP_IPV6 = 0x04;

    private final VpnService vpnService;
    private final int port;
    private final Map<String, String> hostsMap;
    private final ExecutorService executor = Executors.newCachedThreadPool();
    private volatile boolean running;
    private ServerSocket serverSocket;

    public LocalSocks5Server(VpnService vpnService, int port, Map<String, String> hostsMap) {
        this.vpnService = vpnService;
        this.port = port;
        this.hostsMap = new HashMap<>();
        if (hostsMap != null) {
            for (Map.Entry<String, String> entry : hostsMap.entrySet()) {
                String key = normalizeHost(entry.getKey());
                String value = entry.getValue();
                if (key != null && value != null && !value.isEmpty()) {
                    this.hostsMap.put(key, value);
                }
            }
        }
    }

    public synchronized void start() throws IOException {
        if (running) return;
        serverSocket = new ServerSocket();
        serverSocket.setReuseAddress(true);
        serverSocket.bind(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), port));
        running = true;
        executor.execute(() -> {
            while (running) {
                try {
                    Socket client = serverSocket.accept();
                    configureSocket(client);
                    executor.execute(() -> handleClient(client));
                } catch (IOException e) {
                    if (running) Log.e(TAG, "accept()", e);
                }
            }
        });
        Log.i(TAG, "SOCKS5 listening on 127.0.0.1:" + port);
    }

    private void configureSocket(Socket socket) throws SocketException {
        socket.setTcpNoDelay(true);
        socket.setKeepAlive(true);
        socket.setReceiveBufferSize(256 * 1024);
        socket.setSendBufferSize(256 * 1024);
    }

    private void handleClient(Socket client) {
        try (Socket socket = client) {
            DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            if (!negotiate(in, out)) return;

            int version = in.readUnsignedByte();
            if (version != SOCKS_VERSION) return;
            int command = in.readUnsignedByte();
            in.readUnsignedByte(); // RSV
            int atyp = in.readUnsignedByte();
            SocksAddress destination = readAddress(in, atyp);
            if (destination == null) {
                sendReply(out, 0x08, InetAddress.getLoopbackAddress(), 0);
                return;
            }

            if (command == CMD_CONNECT) {
                handleConnect(socket, out, destination);
            } else if (command == CMD_UDP_ASSOCIATE) {
                handleUdpAssociate(socket, in, out);
            } else {
                sendReply(out, 0x07, InetAddress.getLoopbackAddress(), 0);
            }
        } catch (Exception e) {
            Log.d(TAG, "SOCKS client closed: " + e.getMessage());
        }
    }

    private boolean negotiate(DataInputStream in, DataOutputStream out) throws IOException {
        int version = in.readUnsignedByte();
        if (version != SOCKS_VERSION) return false;
        int methodCount = in.readUnsignedByte();
        boolean noAuth = false;
        for (int i = 0; i < methodCount; i++) {
            if (in.readUnsignedByte() == NO_AUTH) noAuth = true;
        }
        if (!noAuth) {
            out.writeByte(SOCKS_VERSION);
            out.writeByte(0xFF);
            out.flush();
            return false;
        }
        out.writeByte(SOCKS_VERSION);
        out.writeByte(NO_AUTH);
        out.flush();
        return true;
    }

    private void handleConnect(Socket client, DataOutputStream out, SocksAddress destination) {
        Socket remote = null;
        try {
            String host;
            if (destination.type == ATYP_DOMAIN) {
                host = normalizeHost(destination.host);
                String mapped = hostsMap.get(host);
                if (mapped != null) host = mapped;
            } else {
                host = destination.host;
            }
            remote = new Socket();
            remote.setTcpNoDelay(true);
            remote.setKeepAlive(true);
            remote.setReceiveBufferSize(256 * 1024);
            remote.setSendBufferSize(256 * 1024);
            if (!vpnService.protect(remote)) {
                sendReply(out, 0x01, InetAddress.getLoopbackAddress(), 0);
                return;
            }
            remote.connect(new InetSocketAddress(host, destination.port), 10000);
            sendReply(out, 0x00, InetAddress.getLoopbackAddress(), 0);
            out.flush();
            SocketRelay.relay(client, remote);
        } catch (Exception e) {
            try {
                sendReply(out, 0x05, InetAddress.getLoopbackAddress(), 0);
                out.flush();
            } catch (Exception ignored) { }
            try { if (remote != null) remote.close(); } catch (Exception ignored) { }
        }
    }

    private void handleUdpAssociate(Socket clientTcp, DataInputStream in, DataOutputStream out) throws IOException {
        DatagramSocket udpSocket = null;
        try {
            udpSocket = new DatagramSocket(new InetSocketAddress("127.0.0.1", 0));
            udpSocket.setReuseAddress(true);
            udpSocket.setReceiveBufferSize(512 * 1024);
            udpSocket.setSendBufferSize(512 * 1024);
            if (!vpnService.protect(udpSocket)) {
                sendReply(out, 0x01, InetAddress.getLoopbackAddress(), 0);
                return;
            }
            sendReply(out, 0x00, InetAddress.getLoopbackAddress(), udpSocket.getLocalPort());
            out.flush();
            DatagramSocket finalUdpSocket = udpSocket;
            executor.execute(() -> udpRelayLoop(finalUdpSocket));

            while (running && !clientTcp.isClosed()) {
                int value;
                try {
                    value = in.read();
                } catch (IOException e) {
                    break;
                }
                if (value < 0) break;
            }
        } finally {
            closeQuietly(udpSocket);
        }
    }

    private void udpRelayLoop(DatagramSocket relaySocket) {
        byte[] buffer = new byte[65535];
        InetSocketAddress clientEndpoint = null;
        while (running && !relaySocket.isClosed()) {
            try {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                relaySocket.receive(packet);
                if (packet.getLength() < 10) continue;
                SocksUdpPacket udp = parseUdpPacket(packet.getData(), packet.getOffset(), packet.getLength());
                if (udp == null) continue;
                clientEndpoint = new InetSocketAddress(packet.getAddress(), packet.getPort());

                InetAddress destinationAddress;
                String destinationHost;
                if (udp.atyp == ATYP_DOMAIN) {
                    String normalized = normalizeHost(udp.host);
                    String mapped = hostsMap.get(normalized);
                    destinationHost = mapped != null ? mapped : normalized;
                    destinationAddress = InetAddress.getByName(destinationHost);
                } else {
                    destinationAddress = InetAddress.getByName(udp.host);
                }
                DatagramPacket outgoing = new DatagramPacket(udp.payload, udp.payload.length, destinationAddress, udp.port);
                relaySocket.send(outgoing);

                if (clientEndpoint != null) {
                    startUdpResponseLoop(relaySocket, clientEndpoint);
                }
            } catch (Exception e) {
                if (running) Log.d(TAG, "UDP relay error: " + e.getMessage());
                break;
            }
        }
    }

    private void startUdpResponseLoop(DatagramSocket relaySocket, InetSocketAddress client) {
        executor.execute(() -> {
            byte[] receiveBuffer = new byte[65535];
            while (running && !relaySocket.isClosed()) {
                try {
                    DatagramPacket packet = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                    relaySocket.receive(packet);
                    byte[] wrapped = buildUdpResponse(packet);
                    DatagramPacket response = new DatagramPacket(wrapped, wrapped.length, client.getAddress(), client.getPort());
                    relaySocket.send(response);
                } catch (Exception e) {
                    break;
                }
            }
        });
    }

    private byte[] buildUdpResponse(DatagramPacket packet) throws IOException {
        InetAddress address = packet.getAddress();
        byte[] ip = address.getAddress();
        int atyp;
        if (ip.length == 4) atyp = ATYP_IPV4;
        else if (ip.length == 16) atyp = ATYP_IPV6;
        else atyp = ATYP_IPV4;
        int addressLength = atyp == ATYP_IPV4 ? 4 : 16;
        int length = 3 + 1 + addressLength + 2 + packet.getLength();
        byte[] result = new byte[length];
        int pos = 0;
        result[pos++] = 0;
        result[pos++] = 0;
        result[pos++] = 0;
        result[pos++] = (byte) atyp;
        System.arraycopy(ip, 0, result, pos, addressLength);
        pos += addressLength;
        result[pos++] = (byte) ((packet.getPort() >> 8) & 0xFF);
        result[pos++] = (byte) (packet.getPort() & 0xFF);
        System.arraycopy(packet.getData(), packet.getOffset(), result, pos, packet.getLength());
        return result;
    }

    private SocksUdpPacket parseUdpPacket(byte[] data, int offset, int length) {
        try {
            int pos = offset;
            if (length < 4) return null;
            int rsv1 = data[pos++] & 0xFF;
            int rsv2 = data[pos++] & 0xFF;
            int frag = data[pos++] & 0xFF;
            int atyp = data[pos++] & 0xFF;
            if (rsv1 != 0 || rsv2 != 0 || frag != 0) return null;
            String host;
            if (atyp == ATYP_IPV4) {
                if (pos + 4 > offset + length) return null;
                host = (data[pos] & 0xFF) + "." + (data[pos + 1] & 0xFF) + "." + (data[pos + 2] & 0xFF) + "." + (data[pos + 3] & 0xFF);
                pos += 4;
            } else if (atyp == ATYP_IPV6) {
                if (pos + 16 > offset + length) return null;
                byte[] ipv6 = new byte[16];
                System.arraycopy(data, pos, ipv6, 0, 16);
                host = InetAddress.getByAddress(ipv6).getHostAddress();
                pos += 16;
            } else if (atyp == ATYP_DOMAIN) {
                int domainLength = data[pos++] & 0xFF;
                if (pos + domainLength > offset + length) return null;
                host = new String(data, pos, domainLength, StandardCharsets.UTF_8);
                pos += domainLength;
            } else {
                return null;
            }
            if (pos + 2 > offset + length) return null;
            int port = ((data[pos] & 0xFF) << 8) | (data[pos + 1] & 0xFF);
            pos += 2;
            int payloadLength = offset + length - pos;
            byte[] payload = new byte[payloadLength];
            System.arraycopy(data, pos, payload, 0, payloadLength);
            SocksUdpPacket result = new SocksUdpPacket();
            result.atyp = atyp;
            result.host = host;
            result.port = port;
            result.payload = payload;
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    private SocksAddress readAddress(DataInputStream in, int atyp) throws IOException {
        SocksAddress result = new SocksAddress();
        result.type = atyp;
        if (atyp == ATYP_IPV4) {
            byte[] address = new byte[4];
            in.readFully(address);
            result.host = InetAddress.getByAddress(address).getHostAddress();
        } else if (atyp == ATYP_IPV6) {
            byte[] address = new byte[16];
            in.readFully(address);
            result.host = InetAddress.getByAddress(address).getHostAddress();
        } else if (atyp == ATYP_DOMAIN) {
            int len = in.readUnsignedByte();
            if (len == 0) return null;
            byte[] domain = new byte[len];
            in.readFully(domain);
            result.host = new String(domain, StandardCharsets.UTF_8);
        } else {
            return null;
        }
        result.port = in.readUnsignedShort();
        return result;
    }

    private void sendReply(DataOutputStream out, int status, InetAddress address, int port) throws IOException {
        byte[] ip = address.getAddress();
        int atyp;
        if (ip.length == 16) atyp = ATYP_IPV6;
        else atyp = ATYP_IPV4;
        out.writeByte(SOCKS_VERSION);
        out.writeByte(status);
        out.writeByte(0);
        out.writeByte(atyp);
        out.write(ip);
        out.writeShort(port);
    }

    private static String normalizeHost(String host) {
        if (host == null) return null;
        host = host.trim().toLowerCase(Locale.US);
        while (host.endsWith(".")) {
            host = host.substring(0, host.length() - 1);
        }
        return host;
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try { closeable.close(); } catch (Exception ignored) { }
        }
    }

    private static void closeQuietly(Socket socket) {
        if (socket != null) {
            try { socket.close(); } catch (Exception ignored) { }
        }
    }

    private static void closeQuietly(DatagramSocket socket) {
        if (socket != null) {
            try { socket.close(); } catch (Exception ignored) { }
        }
    }

    @Override
    public synchronized void close() {
        running = false;
        closeQuietly(serverSocket);
        executor.shutdownNow();
    }

    private static final class SocksAddress {
        int type;
        String host;
        int port;
    }

    private static final class SocksUdpPacket {
        int atyp;
        String host;
        int port;
        byte[] payload;
    }
}
