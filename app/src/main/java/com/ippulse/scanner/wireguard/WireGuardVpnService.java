package com.ippulse.scanner.wireguard;

import android.app.Service;
import android.content.Intent;
import android.net.VpnService;
import android.os.IBinder;
import com.ippulse.scanner.utils.Logger;
import com.wireguard.android.backend.GoBackend;
import com.wireguard.config.Config;
import com.wireguard.config.Interface;
import com.wireguard.config.Peer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WireGuardVpnService extends VpnService {
    public static final String ACTION_START = "com.ippulse.scanner.wireguard.START";
    public static final String ACTION_STOP = "com.ippulse.scanner.wireguard.STOP";

    private GoBackend backend;
    private LocalDnsServer dnsServer;

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init(this);
        backend = new GoBackend(this);
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
            ifaceBuilder.parseMtu(mtu);
            configBuilder.setInterface(ifaceBuilder.build());

            Peer.Builder peerBuilder = new Peer.Builder();
            peerBuilder.parsePublicKey(peerPublicKey);
            peerBuilder.parseEndpoint(endpoint);
            peerBuilder.parseAllowedIPs(allowedIPs);
            configBuilder.addPeer(peerBuilder.build());

            Logger.d("Starting WireGuard tunnel...");
            backend.startTunnel(configBuilder.build());
            Logger.d("Tunnel started successfully.");
        } catch (Exception e) {
            Logger.e("Failed to start tunnel", e);
            e.printStackTrace();
            if (dnsServer != null) dnsServer.stop();
        Logger.d("Tunnel stopped.");
            stopSelf();
        }
    }

    private void stopTunnel() {
        try {
            if (backend != null) backend.stopTunnel();
        } catch (Exception e) {
            Logger.e("Failed to start tunnel", e);
            e.printStackTrace();
        }
        if (dnsServer != null) dnsServer.stop();
        Logger.d("Tunnel stopped.");
        stopSelf();
    }

    private Map<String, String> parseHosts(String hostsStr) {
        Map<String, String> map = new HashMap<>();
        if (hostsStr != null) {
            String[] lines = hostsStr.split("\n");
            for (String line : lines) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                String[] parts = line.split("\s+");
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
