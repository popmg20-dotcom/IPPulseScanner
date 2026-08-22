package com.ippulse.scanner.wireguard;

import android.app.Service;
import android.content.Intent;
import android.net.VpnService;
import android.os.IBinder;
import com.wireguard.android.backend.GoBackend;
import com.wireguard.config.Config;

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

            // اجرای DNS محلی برای هاستینگ
            Map<String, String> hostMappings = parseHosts(hostsStr);
            dnsServer = new LocalDnsServer(hostMappings, dns);
            dnsServer.start();

            // ساخت کانفیگ به صورت متن و parse کردن آن
            String configText = "[Interface]\n"
                    + "PrivateKey = " + privateKey + "\n"
                    + "Address = " + address + "\n"
                    + "DNS = 127.0.0.1\n"
                    + "MTU = " + mtu + "\n\n"
                    + "[Peer]\n"
                    + "PublicKey = " + peerPublicKey + "\n"
                    + "Endpoint = " + endpoint + "\n"
                    + "AllowedIPs = " + allowedIPs + "\n";

            Config config = Config.parse(configText);
            backend.startTunnel(config);
        } catch (Exception e) {
            e.printStackTrace();
            if (dnsServer != null) dnsServer.stop();
            stopSelf();
        }
    }

    private void stopTunnel() {
        try {
            if (backend != null) backend.stopTunnel();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (dnsServer != null) dnsServer.stop();
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
