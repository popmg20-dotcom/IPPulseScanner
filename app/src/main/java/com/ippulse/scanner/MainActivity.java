package com.ippulse.scanner;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.VpnService;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.github.xfalcon.vhosts.vservice.VhostsService;

import java.util.HashMap;
import java.util.Map;

import com.ippulse.scanner.VpnEvidenceLogger;

public class MainActivity extends Activity {

    private static final String VPN_PREFS = "vpn_settings";
    private static final int REQUEST_VPN = 1001;
    private static final int REQUEST_NOTIFICATION = 1002;

    private View tab3Container;
    private Button btnStartVpn, btnStopVpn, btnApplyIp;
    private TextView vpnStatus;
    private EditText vpnDns, vpnHosts, vpnMasterIp, vpnMtu;
private String[] defaultDomains = {
        "west-tdm.codmwest.com",
        "west-cschannel.codm.activision.com",
        "gcloud.codm.activision.com"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VpnEvidenceLogger.init(getApplicationContext());

        tab3Container = findViewById(R.id.tab3Container);
        vpnDns = findViewById(R.id.vpnDns);
        vpnHosts = findViewById(R.id.vpnHosts);
        vpnMasterIp = findViewById(R.id.vpnMasterIp);
        vpnMtu = findViewById(R.id.vpnMtu);
        btnStartVpn = findViewById(R.id.btnStartVpn);
        btnStopVpn = findViewById(R.id.btnStopVpn);
        btnApplyIp = findViewById(R.id.btnApplyIp);
        vpnStatus = findViewById(R.id.vpnStatus);

        loadVpnSettings();

        btnStartVpn.setOnClickListener(v -> startVpn());
        btnStopVpn.setOnClickListener(v -> stopVpn());
        btnApplyIp.setOnClickListener(v -> applyMasterIp());
    }

    private void loadVpnSettings() {
        SharedPreferences prefs = getSharedPreferences(VPN_PREFS, MODE_PRIVATE);
        vpnDns.setText(prefs.getString("dns", "8.8.8.8"));
        vpnMtu.setText(prefs.getString("mtu", "247"));
        vpnMasterIp.setText(prefs.getString("masterIp", "109.61.42.251"));
        vpnHosts.setText(prefs.getString("hosts", ""));
                                                                if (vpnHosts.getText().toString().trim().isEmpty()) {
            String defaultIp = vpnMasterIp.getText().toString().trim();
            StringBuilder sb = new StringBuilder();
            for (String domain : defaultDomains) {
                sb.append(defaultIp).append(" ").append(domain).append("\n");
            }
            vpnHosts.setText(sb.toString().trim());
        }
    }

    private void saveVpnSettings() {
        SharedPreferences prefs = getSharedPreferences(VPN_PREFS, MODE_PRIVATE);
        prefs.edit()
            .putString("dns", vpnDns.getText().toString().trim())
            .putString("hosts", vpnHosts.getText().toString().trim())
            .putString("mtu", vpnMtu.getText().toString().trim())
            .putString("masterIp", vpnMasterIp.getText().toString().trim())
                                                                        .apply();
    }

    private HashMap<String, String> parseHosts(String text) {
        HashMap<String, String> map = new HashMap<>();
        if (text == null || text.trim().isEmpty()) return map;
        String[] lines = text.split("\\n");
        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty() || line.startsWith("#")) continue;
            String[] parts = line.split("\\s+");
            if (parts.length >= 2) {
                String ip = parts[0];
                String domain = parts[1].toLowerCase();
                map.put(domain, ip);
            }
        }
        return map;
    }

    private int parseIntSafe(String s, int defaultVal) {
        try { return Integer.parseInt(s); } catch (Exception e) { return defaultVal; }
    }

    private String hostsMapToString(HashMap<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getValue()).append(" ").append(entry.getKey()).append("\n");
        }
        return sb.toString();
    }

    private void applyMasterIp() {
        String masterIp = vpnMasterIp.getText().toString().trim();
        if (masterIp.isEmpty()) {
            Toast.makeText(this, "لطفاً یک IP وارد کنید", Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String domain : defaultDomains) {
            sb.append(masterIp).append(" ").append(domain).append("\n");
        }
        vpnHosts.setText(sb.toString().trim());
        saveVpnSettings();
        Toast.makeText(this, "IP به همه دامنه‌ها اعمال شد", Toast.LENGTH_SHORT).show();
    }

    private void startVpn() {
        saveVpnSettings();
        String dns = vpnDns.getText().toString().trim();
        HashMap<String, String> hostsMap = parseHosts(vpnHosts.getText().toString());

        if (Build.VERSION.SDK_INT >= 33) {
            if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, REQUEST_NOTIFICATION);
                return;
            }
        }

        Intent intent = VpnService.prepare(this);
        if (intent != null) {
            startActivityForResult(intent, REQUEST_VPN);
        } else {
            int mtu = parseIntSafe(vpnMtu.getText().toString().trim(), 247);
            startVhostsService(mtu, hostsMap);
            vpnStatus.setText("VPN: Connected");
            Toast.makeText(this, "VPN started", Toast.LENGTH_SHORT).show();
        }
    }

    private void stopVpn() {
        vpnStatus.setText("VPN: Stopping");

        Intent intent =
                new Intent(this, VhostsService.class)
                        .setAction(VhostsService.ACTION_DISCONNECT);

        startService(intent);

        vpnStatus.setText("VPN: Stopped");
        Toast.makeText(this, "VPN stopped", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_NOTIFICATION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startVpn();
            } else {
                Toast.makeText(this, "Notification permission required for VPN", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_VPN && resultCode == RESULT_OK) {
            HashMap<String, String> hostsMap = parseHosts(vpnHosts.getText().toString());
            int mtu = parseIntSafe(vpnMtu.getText().toString().trim(), 247);
            startVhostsService(mtu, hostsMap);
            vpnStatus.setText("VPN: Connected");
            Toast.makeText(this, "VPN started", Toast.LENGTH_SHORT).show();
        } else if (requestCode == REQUEST_VPN) {
            Toast.makeText(this, "VPN permission denied", Toast.LENGTH_SHORT).show();
        }
    }

    private void startVhostsService(
        int mtu,
        HashMap<String, String> hostsMap
) {
    Intent serviceIntent = new Intent(this, VhostsService.class);

    serviceIntent.setAction(VhostsService.ACTION_CONNECT);

    serviceIntent.putExtra("mtu", mtu);

    serviceIntent.putExtra(
        "dns",
        vpnDns.getText().toString().trim()
    );

    StringBuilder hostsText = new StringBuilder();

    for (Map.Entry<String, String> entry : hostsMap.entrySet()) {
        hostsText
            .append(entry.getValue())
            .append(" ")
            .append(entry.getKey())
            .append("\n");
    }

    serviceIntent.putExtra(
        "hosts",
        hostsText.toString()
    );

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        startForegroundService(serviceIntent);
    } else {
        startService(serviceIntent);
    }
}

}
