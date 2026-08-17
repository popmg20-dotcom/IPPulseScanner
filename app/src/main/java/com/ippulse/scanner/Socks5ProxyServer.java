package com.ippulse.scanner;

import android.net.VpnService;
import android.util.Log;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class Socks5ProxyServer {

    private static final String TAG =
            "IPPulseSocks5";

    private final VpnService vpn;
    private final String dnsServer;
    private volatile Map<String, String> hosts;
    private volatile boolean running;
    private ServerSocket server;

    private final ExecutorService pool =
            Executors.newCachedThreadPool();

    public Socks5ProxyServer(
            VpnService vpn,
            String dnsServer,
            Map<String, String> hosts
    ) {
        this.vpn = vpn;
        this.dnsServer = dnsServer;
        this.hosts = hosts;
    }

    public synchronized boolean start() {

        if (running) return true;

        try {

            server = new ServerSocket();
            server.setReuseAddress(true);

            server.bind(
                    new InetSocketAddress(
                            "127.0.0.1",
                            1080
                    )
            );

            running = true;

            pool.execute(
                    this::acceptLoop
            );

            Log.i(
                    TAG,
                    "SOCKS5 127.0.0.1:1080"
            );

            return true;

        } catch (Throwable e) {

            Log.e(
                    TAG,
                    "SOCKS start failed",
                    e
            );

            stop();
            return false;
        }
    }

    public synchronized void stop() {

        running = false;

        try {
            if (server != null) {
                server.close();
            }
        } catch (Throwable ignored) {}

        server = null;
        pool.shutdownNow();
    }

    private void acceptLoop() {

        while (running) {

            try {

                final Socket client =
                        server.accept();

                pool.execute(
                        () -> handleClient(
                                client
                        )
                );

            } catch (Throwable e) {

                if (running) {
                    Log.e(
                            TAG,
                            "accept failed",
                            e
                    );
                }
            }
        }
    }

    private void handleClient(
            Socket client
    ) {

        Socket remote = null;

        try {

            InputStream in =
                    client.getInputStream();

            OutputStream out =
                    client.getOutputStream();

            if (in.read() != 5) {
                close(client);
                return;
            }

            int methods =
                    in.read();

            if (methods < 0) {
                close(client);
                return;
            }

            byte[] buffer =
                    new byte[methods];

            readFully(
                    in,
                    buffer
            );

            out.write(5);
            out.write(0);
            out.flush();

            int version =
                    in.read();

            int command =
                    in.read();

            in.read();

            int atyp =
                    in.read();

            if (version != 5) {
                close(client);
                return;
            }

            HostPort target =
                    readTarget(
                            in,
                            atyp
                    );

            if (target == null) {
                sendFailure(out, 8);
                close(client);
                return;
            }

            /*
             * TCP CONNECT
             */
            if (command == 1) {

                remote =
                        new Socket();

                if (!vpn.protect(remote)) {
                    throw new Exception(
                            "protect() failed"
                    );
                }

                remote.setTcpNoDelay(true);

                InetAddress destination =
                        resolveHost(
                                target.host
                        );

                remote.connect(
                        new InetSocketAddress(
                                destination,
                                target.port
                        ),
                        12000
                );

                sendSuccess(
                        out,
                        remote
                );

                relay(
                        client,
                        remote
                );

                return;
            }

            /*
             * UDP ASSOCIATE is intentionally handled by
             * HEV/Java side later; TCP must work first.
             */
            sendFailure(
                    out,
                    7
            );

        } catch (Throwable e) {

            Log.d(
                    TAG,
                    "client error: "
                            + e.getMessage()
            );

            try {
                sendFailure(
                        client.getOutputStream(),
                        5
                );
            } catch (Throwable ignored) {}

        } finally {

            close(remote);
            close(client);
        }
    }

    private InetAddress resolveHost(
            String host
    ) throws Exception {

        String normalized =
                DnsProxyServer
                        .normalizeDomain(
                                host
                        );

        String mapped =
                hosts == null
                        ? null
                        : hosts.get(
                                normalized
                        );

        if (mapped != null) {

            return InetAddress.getByName(
                    mapped
            );
        }

        return InetAddress.getByName(
                host
        );
    }

    private void relay(
            final Socket client,
            final Socket remote
    ) throws Exception {

        Thread a =
                new Thread(
                        () -> copy(
                                client,
                                remote
                        ),
                        "IPPulse-C2R"
                );

        Thread b =
                new Thread(
                        () -> copy(
                                remote,
                                client
                        ),
                        "IPPulse-R2C"
                );

        a.start();
        b.start();

        a.join();
        b.join();
    }

    private void copy(
            Socket from,
            Socket to
    ) {

        try {

            InputStream in =
                    from.getInputStream();

            OutputStream out =
                    to.getOutputStream();

            byte[] buffer =
                    new byte[16384];

            int n;

            while ((n =
                    in.read(buffer)) != -1) {

                if (n > 0) {

                    out.write(
                            buffer,
                            0,
                            n
                    );

                    out.flush();
                }
            }

        } catch (Throwable ignored) {}
    }

    private HostPort readTarget(
            InputStream in,
            int atyp
    ) throws Exception {

        HostPort result =
                new HostPort();

        if (atyp == 1) {

            byte[] ip = new byte[4];

            readFully(in, ip);

            result.host =
                    InetAddress
                            .getByAddress(ip)
                            .getHostAddress();

        } else if (atyp == 3) {

            int len =
                    in.read();

            if (len <= 0) {
                return null;
            }

            byte[] domain =
                    new byte[len];

            readFully(
                    in,
                    domain
            );

            result.host =
                    new String(
                            domain,
                            StandardCharsets.UTF_8
                    );

        } else if (atyp == 4) {

            byte[] ip = new byte[16];

            readFully(in, ip);

            result.host =
                    InetAddress
                            .getByAddress(ip)
                            .getHostAddress();

        } else {

            return null;
        }

        int hi =
                in.read();

        int lo =
                in.read();

        result.port =
                ((hi & 0xff) << 8)
                        | (lo & 0xff);

        return result;
    }

    private void sendSuccess(
            OutputStream out,
            Socket remote
    ) throws Exception {

        byte[] ip =
                remote
                        .getLocalAddress()
                        .getAddress();

        out.write(5);
        out.write(0);
        out.write(0);

        out.write(
                ip.length == 4
                        ? 1
                        : 4
        );

        out.write(ip);

        int port =
                remote.getLocalPort();

        out.write(
                (port >> 8) & 0xff
        );

        out.write(
                port & 0xff
        );

        out.flush();
    }

    private void sendFailure(
            OutputStream out,
            int code
    ) {

        try {

            out.write(5);
            out.write(code);
            out.write(0);
            out.write(1);

            out.write(0);
            out.write(0);
            out.write(0);
            out.write(0);

            out.write(0);
            out.write(0);

            out.flush();

        } catch (Throwable ignored) {}
    }

    private void readFully(
            InputStream in,
            byte[] data
    ) throws Exception {

        int offset = 0;

        while (offset < data.length) {

            int count =
                    in.read(
                            data,
                            offset,
                            data.length - offset
                    );

            if (count < 0) {
                throw new Exception("EOF");
            }

            offset += count;
        }
    }

    private void close(
            Closeable c
    ) {

        if (c == null) return;

        try {
            c.close();
        } catch (Throwable ignored) {}
    }

    private static final class HostPort {
        String host;
        int port;
    }
}
