package com.ippulse.scanner;

import com.ippulse.scanner.VpnEvidenceLogger;
import java.util.Map;
import com.github.xfalcon.vhosts.vservice.VhostsService;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.VpnService;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.*;


import java.util.*;
import java.io.IOException;
import java.io.File;

public class MainActivity extends Activity {

    private static final String VPN_PREFS = "vpn_settings";
    private static final int REQUEST_VPN = 1001;
    private static final int REQUEST_NOTIFICATION = 1002;

    private View tab3Container;
    private Button btnTab3;















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
        tab3Container.setVisibility(View.VISIBLE);
        VpnEvidenceLogger.init(getApplicationContext());


        btnTab3 = findViewById(R.id.btnTab3);


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

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sortOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentSortIndex = position;
                if (rangeScanFinished && !allResults.isEmpty()) {
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });



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








    private String hostsMapToString(HashMap<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getValue()).append(" ").append(entry.getKey()).append("\n");
        }
        return sb.toString();
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















    // ✅ موتور جدید: استفاده از ping پیوسته با یک فرآیند














    private void addTableHeader(TableLayout table, boolean isLive) {
        TableRow header = new TableRow(this);
        header.setBackgroundColor(Color.parseColor("#334155"));
        String[] headers = isLive ? new String[]{"IP", "Sent", "Avg", "Min", "Max", "Jitter", "Loss", "Status"} :
                new String[]{"Rank", "IP", "Sent", "Avg", "Min", "Max", "Jitter", "Loss", "Status"};
        for (String h : headers) {
            TextView tv = new TextView(this);
            tv.setText(h);
            tv.setTextColor(Color.WHITE);
            tv.setGravity(Gravity.CENTER);
            tv.setPadding(10, 10, 10, 10);
            tv.setTextSize(11f);
            tv.setTypeface(null, Typeface.BOLD);
            header.addView(tv);
        }
        table.addView(header);
    }

    private void addTableRow(TableLayout table, ScanResult res, int rank, boolean isLive, boolean isTop5) {
        TableRow row = new TableRow(this);
        row.setBackgroundColor(isTop5 ? Color.parseColor("#FFD700") : Color.parseColor("#18181B"));
        row.setClickable(true);
        row.setOnClickListener(v -> {
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("IP", res.ip);
            clipboard.setPrimaryClip(clip);
            Toast.makeText(this, "IP Copied: " + res.ip, Toast.LENGTH_SHORT).show();
        });

        String[] values;
        if (isLive) {
            values = new String[]{res.ip, String.valueOf(res.sent), String.format(Locale.US, "%.1f", res.avg),
                    String.format(Locale.US, "%.1f", res.min), String.format(Locale.US, "%.1f", res.max),
                    String.format(Locale.US, "%.2f", res.jitter), String.format(Locale.US, "%.0f%%", res.loss),
                    res.alive ? "ALIVE" : "DEAD"};
        } else {
            values = new String[]{String.valueOf(rank), res.ip, String.valueOf(res.sent), String.format(Locale.US, "%.1f", res.avg),
                    String.format(Locale.US, "%.1f", res.min), String.format(Locale.US, "%.1f", res.max),
                    String.format(Locale.US, "%.2f", res.jitter), String.format(Locale.US, "%.0f%%", res.loss),
                    res.alive ? "ALIVE" : "DEAD"};
        }

        for (int i = 0; i < values.length; i++) {
            TextView tv = new TextView(this);
            tv.setText(values[i]);
            tv.setTextColor(isTop5 ? Color.BLACK : Color.WHITE);
            tv.setGravity(Gravity.CENTER);
            tv.setPadding(10, 10, 10, 10);
            tv.setTextSize(11f);
            row.addView(tv);
        }
        table.addView(row);

        int ipIndex = isLive ? 0 : 1;
        TextView ipCell = (TextView) row.getChildAt(ipIndex);
        fetchFlag(ipCell, res.ip);
    }

    private void fetchFlag(TextView textView, String ip) {
        new Thread(() -> {
            String flag = getCountryFlag(ip);
            runOnUiThread(() -> textView.setText(flag + " " + ip));
        }).start();
    }

    private String getCountryFlag(String ip) {
        String[] urls = {
            "http://ip-api.com/json/" + ip + "?fields=countryCode",
            "http://ipwho.is/" + ip,
            "https://ipinfo.io/" + ip + "/json"
        };
        for (String urlStr : urls) {
            try {
                String code = queryCountryCode(urlStr);
                if (!code.isEmpty()) return countryCodeToFlag(code);
            } catch (Exception ignored) {}
        }
        return "🌐";
    }

    private String queryCountryCode(String urlStr) throws Exception {
        HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
        conn.setConnectTimeout(3000);
        conn.setReadTimeout(3000);
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) sb.append(line);
        reader.close();
        conn.disconnect();
        JSONObject json = new JSONObject(sb.toString());
        String code = json.optString("countryCode", "");
        if (code.isEmpty()) code = json.optString("country_code", "");
        if (code.isEmpty()) code = json.optString("country", "");
        if (code.length() != 2) {
            String countryName = code.toLowerCase();
            if (countryName.contains("united arab")) return "AE";
            if (countryName.contains("germany")) return "DE";
            if (countryName.contains("iran")) return "IR";
            if (countryName.contains("netherlands")) return "NL";
            if (countryName.contains("france")) return "FR";
            if (countryName.contains("singapore")) return "SG";
            if (countryName.contains("united states")) return "US";
            if (countryName.contains("united kingdom")) return "GB";
            if (countryName.contains("russia")) return "RU";
            if (countryName.contains("china")) return "CN";
            if (countryName.contains("japan")) return "JP";
            if (countryName.contains("south korea")) return "KR";
            if (countryName.contains("taiwan")) return "TW";
            if (countryName.contains("hong kong")) return "HK";
            if (countryName.contains("india")) return "IN";
            if (countryName.contains("brazil")) return "BR";
            if (countryName.contains("canada")) return "CA";
            if (countryName.contains("australia")) return "AU";
            if (countryName.contains("italy")) return "IT";
            if (countryName.contains("spain")) return "ES";
            if (countryName.contains("portugal")) return "PT";
            if (countryName.contains("sweden")) return "SE";
            if (countryName.contains("norway")) return "NO";
            if (countryName.contains("denmark")) return "DK";
            if (countryName.contains("finland")) return "FI";
            if (countryName.contains("poland")) return "PL";
            if (countryName.contains("turkey")) return "TR";
            if (countryName.contains("saudi")) return "SA";
            if (countryName.contains("qatar")) return "QA";
            if (countryName.contains("kuwait")) return "KW";
            if (countryName.contains("bahrain")) return "BH";
            if (countryName.contains("oman")) return "OM";
            return "";
        }
        return code;
    }

    private String countryCodeToFlag(String code) {
        if (code == null || code.length() != 2) return "🌐";
        int base = 0x1F1E6;
        int first = base + (code.charAt(0) - 'A');
        int second = base + (code.charAt(1) - 'A');
        return new String(Character.toChars(first)) + new String(Character.toChars(second));
    }









    private void saveHistory(String entry) {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        Set<String> history = new LinkedHashSet<>(prefs.getStringSet(HISTORY_KEY, new LinkedHashSet<>()));
        history.add(entry);
        prefs.edit().putStringSet(HISTORY_KEY, history).apply();
    }

    private Set<String> loadHistory() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        return new LinkedHashSet<>(prefs.getStringSet(HISTORY_KEY, new LinkedHashSet<>()));
    }





    private static class ScanResult {
        String ip;
        float avg, min, max, jitter, loss;
        int sent;
        boolean alive;
        ScanResult(String ip, float avg, float min, float max, float jitter, float loss, boolean alive, int sent) {
            this.ip = ip;
            this.avg = avg;
            this.min = min;
            this.max = max;
            this.jitter = jitter;
            this.loss = loss;
            this.sent = sent;
            this.alive = alive;
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


}// debug trigger
