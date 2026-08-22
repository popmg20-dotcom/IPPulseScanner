package com.ippulse.scanner.wireguard;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.wireguard.android.backend.GoBackend;
import com.wireguard.android.backend.Tunnel;
import com.wireguard.config.Config;
import com.wireguard.config.Interface;
import com.wireguard.config.Peer;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Map;

public class WireGuardVpnService extends Service {
    public static final String ACTION_START = "com.ippulse.scanner.wireguard.START";
    public static final String ACTION_STOP = "com.ippulse.scanner.wireguard.STOP";

    private GoBackend backend;
    private LocalDnsServer dnsServer;
    private Tunnel currentTunnel;
    private ExecutorService executor;
    private Config currentConfig;

    // Simple implementation of Tunnel interface for handling by GoBackend
    private static class SimpleTunnel implements Tunnel {
        private final String name;
        SimpleTunnel(String name) { this.name = name; }
        @Override public String getName() { return name; }
        @Override public void onStateChange(Tunnel.State state) { }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        backend = new GoBackend(this);
        executor = Executors.newSingleThreadExecutor();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null) return START_NOT_STICKY;
        String action = intent.getAction();
        if (ACTION_START.equals(action)) {
            startTunnel(intent);
        } else if (ACTION_STOP.equals(action)) {
            stopTunnel();
        }
        return START_NOT_STICKY;
    }

    private void startTunnel(Intent intent) {
        try {
            String privateKey = intent.getStringExtra("private_key");
            String address = intent.getStringExtra("address");
            String dns = intent.getStringExtra("dns");
            int mtu = intent.getIntExtra("mtu", 1488);
            String peerPublicKey = intent.getStringExtra("peer_public_key");
            String endpoint = intent.getStringExtra("endpoint");
            String allowedIPs = intent.getStringExtra("allowed_ips");
            String hostsStr = intent.getStringExtra("hosts");

            Map<String, String> hostMappings = parseHosts(hostsStr);
            dnsServer = new LocalDnsServer(hostMappings, dns);
            dnsServer.start();

            Config.Builder configBuilder = new Config.Builder();
            Interface.Builder ifaceBuilder = new Interface.Builder();
            ifaceBuilder.parsePrivateKey(privateKey);
            ifaceBuilder.parseAddresses(address);
            ifaceBuilder.parseDnsServers("127.0.0.1");
            ifaceBuilder.parseMtu(String.valueOf(mtu));
            configBuilder.setInterface(ifaceBuilder.build());

            Peer.Builder peerBuilder = new Peer.Builder();
            peerBuilder.parsePublicKey(peerPublicKey);
            peerBuilder.parseEndpoint(endpoint);
            peerBuilder.parseAllowedIPs(allowedIPs);
            configBuilder.addPeer(peerBuilder.build());

            currentConfig = configBuilder.build();
            currentTunnel = new SimpleTunnel("wg0");

            executor.execute(() -> {
                try {
                    backend.setState(currentTunnel, Tunnel.State.UP, currentConfig);
                } catch (Exception e) {
                    e.printStackTrace();
                    if (dnsServer != null) dnsServer.stop();
                    stopSelf();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            if (dnsServer != null) dnsServer.stop();
            stopSelf();
        }
    }

    private void stopTunnel() {
        try {
            if (currentTunnel != null && currentConfig != null) {
                executor.execute(() -> {
                    try {
                        backend.setState(currentTunnel, Tunnel.State.DOWN, currentConfig);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                currentTunnel = null;
                currentConfig = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (dnsServer != null) dnsServer.stop();
        if (executor != null) executor.shutdown();
        stopSelf();
    }

    private Map<String, String> parseHosts(String hostsStr) {
        Map<String, String> map = new HashMap<>();
        if (hostsStr != null) {
            String[] lines = hostsStr.split("\\n");
            for (String line : lines) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                String[] parts = line.split("\\s+");
                if (parts.length >= 2) {
                    map.put(parts[1].toLowerCase(), parts[0]);
                }
            }
        }
        return map;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
