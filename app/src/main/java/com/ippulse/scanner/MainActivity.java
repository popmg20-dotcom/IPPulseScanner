package com.ippulse.scanner;

import com.ippulse.scanner.VpnEvidenceLogger;
import java.util.Map;
import com.github.xfalcon.vhosts.vservice.VhostsService;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.VpnService;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.*;
import java.io.IOException;
import java.io.File;

public class MainActivity extends Activity {

    private static final int FAST_FAIL_THRESHOLD = 2;
    private static final String PREFS_NAME = "ippulse_history";
    private static final String HISTORY_KEY = "history";
    private static final String VPN_PREFS = "vpn_settings";
    private static final int REQUEST_VPN = 1001;
    private static final int REQUEST_NOTIFICATION = 1002;
    private static final int MAX_LOG_ITEMS = 50;
    private static final int TAB1_BATCH_SIZE = 80;
    private static final int TAB1_MAX_PACKETS = 500;
    private static final int TAB1_DEFAULT_INTERVAL_MS = 50;

    private View tab1Container, tab2Container, tab3Container;
    private Button btnTab1, btnTab2, btnTab3, btnStart1, btnStop1, btnHistory, btnClearHistory;
    private EditText ipInput, inputPackets, inputInterval, inputTimeout;
    private TextView status1;
    private LinearLayout logLayout1;
    private ScrollView logScroll1;
    private TableLayout table1;
    private Spinner spinnerSort;

    private LinearLayout top5Container, logLayout2;
    private ScrollView logScroll2;
    private TextView status2;
    private TableLayout table2Live;
    private Button btnStop2;
    private EditText manualIpInput;
    private Button btnManualDeepTest;

    private Button btnStartVpn, btnStopVpn, btnApplyIp;
    private TextView vpnStatus;
    private EditText vpnDns, vpnHosts, vpnMasterIp, vpnMtu;

    private ExecutorService executor;
    private Thread deepTestThread;
    private volatile boolean isCancelled = false;
    private List<ScanResult> allResults = new ArrayList<>();
    private List<String> top5IPs = new ArrayList<>();
    private boolean rangeScanFinished = true;

    private String[] sortOptions = {"Default", "Loss", "Jitter", "Average (Avg)", "Min (Low Ping)", "Max (High Ping)"};
    private int currentSortIndex = 0;

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


        tab1Container = findViewById(R.id.tab1Container);
        btnTab1 = findViewById(R.id.btnTab1);
        btnTab2 = findViewById(R.id.btnTab2);
        btnTab3 = findViewById(R.id.btnTab3);
        btnStart1 = findViewById(R.id.btnStart1);
        btnStop1 = findViewById(R.id.btnStop1);
        ipInput = findViewById(R.id.ipInput);
        inputPackets = findViewById(R.id.inputPackets);
        inputInterval = findViewById(R.id.inputInterval);
        inputInterval.setText("50");
        inputTimeout = findViewById(R.id.inputTimeout);
        status1 = findViewById(R.id.status1);
        logLayout1 = findViewById(R.id.logLayout1);
        logScroll1 = findViewById(R.id.logScroll1);
        table1 = findViewById(R.id.table1);
        spinnerSort = findViewById(R.id.spinnerSort);

        tab2Container = findViewById(R.id.tab2Container);
        top5Container = findViewById(R.id.top5Container);
        status2 = findViewById(R.id.status2);
        logLayout2 = findViewById(R.id.logLayout2);
        logScroll2 = findViewById(R.id.logScroll2);
        table2Live = findViewById(R.id.table2Live);
        btnStop2 = findViewById(R.id.btnStop2);
        manualIpInput = findViewById(R.id.manualIpInput);
        btnManualDeepTest = findViewById(R.id.btnManualDeepTest);

        tab3Container = findViewById(R.id.tab3Container);
        vpnDns = findViewById(R.id.vpnDns);
        vpnHosts = findViewById(R.id.vpnHosts);
        vpnMasterIp = findViewById(R.id.vpnMasterIp);
        vpnMtu = findViewById(R.id.vpnMtu);
        btnStartVpn = findViewById(R.id.btnStartVpn);
        btnStopVpn = findViewById(R.id.btnStopVpn);
        btnApplyIp = findViewById(R.id.btnApplyIp);
        vpnStatus = findViewById(R.id.vpnStatus);

        btnHistory = findViewById(R.id.btnHistory);
        btnClearHistory = findViewById(R.id.btnClearHistory);

        loadVpnSettings();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sortOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSort.setAdapter(adapter);
        spinnerSort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentSortIndex = position;
                if (rangeScanFinished && !allResults.isEmpty()) {
                    applySortAndRefreshTable();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        btnTab1.setOnClickListener(v -> switchTab(1));
        btnTab2.setOnClickListener(v -> switchTab(2));
        btnTab3.setOnClickListener(v -> switchTab(3));

        btnStart1.setOnClickListener(v -> startRangeScan());
        btnStop1.setOnClickListener(v -> stopRangeScan());
        btnStop2.setOnClickListener(v -> stopDeepTest());
        btnManualDeepTest.setOnClickListener(v -> manualDeepTest());

        btnStartVpn.setOnClickListener(v -> startVpn());
        btnStopVpn.setOnClickListener(v -> stopVpn());
        btnApplyIp.setOnClickListener(v -> applyMasterIp());

        btnHistory.setOnClickListener(v -> showHistoryDialog());
        btnClearHistory.setOnClickListener(v -> clearHistory());
    }

    private void switchTab(int tab) {
        tab1Container.setVisibility(tab == 1 ? View.VISIBLE : View.GONE);
        tab2Container.setVisibility(tab == 2 ? View.VISIBLE : View.GONE);
        tab3Container.setVisibility(tab == 3 ? View.VISIBLE : View.GONE);
        btnTab1.setBackgroundColor(tab == 1 ? Color.parseColor("#2563EB") : Color.parseColor("#1E293B"));
        btnTab1.setTextColor(tab == 1 ? Color.WHITE : Color.parseColor("#94A3B8"));
        btnTab2.setBackgroundColor(tab == 2 ? Color.parseColor("#2563EB") : Color.parseColor("#1E293B"));
        btnTab2.setTextColor(tab == 2 ? Color.WHITE : Color.parseColor("#94A3B8"));
        btnTab3.setBackgroundColor(tab == 3 ? Color.parseColor("#2563EB") : Color.parseColor("#1E293B"));
        btnTab3.setTextColor(tab == 3 ? Color.WHITE : Color.parseColor("#94A3B8"));
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

    private void stopRangeScan() {
        isCancelled = true;
        if (executor != null) executor.shutdownNow();
        runOnUiThread(() -> {
            if (!rangeScanFinished && !allResults.isEmpty()) {
                finishRangeScan();
            } else {
                status1.setText("Scan stopped.");
                btnStart1.setEnabled(true);
            }
        });
    }

    private void stopDeepTest() {
        isCancelled = true;
        if (deepTestThread != null) deepTestThread.interrupt();
        status2.setText("Deep test stopped.");
    }

    private void startRangeScan() {
        String query = this.ipInput.getText().toString().trim();
        if (query.isEmpty()) {
            Toast.makeText(this, "Please enter a range or IP", 0).show();
            return;
        }
        final List<String> ips = parseIPList(query);
        if (ips.isEmpty()) {
            Toast.makeText(this, "Invalid range", 0).show();
            return;
        }
        final int pkts = parseNum(this.inputPackets, 100);
        final int timeo = parseNum(this.inputTimeout, 1000);
        this.allResults.clear();
        this.logLayout1.removeAllViews();
        this.table1.removeAllViews();
        addTableHeader(this.table1, false);
        this.btnStart1.setEnabled(false);
        this.isCancelled = false;
        this.rangeScanFinished = false;
        saveHistory(query);
        this.executor = Executors.newFixedThreadPool(80);
        final int[] completed = {0};
        this.status1.setText("Scanning " + ips.size() + " IPs concurrently...");
        for (final String ip : ips) {
            this.executor.execute(new Runnable() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda19
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m17lambda$startRangeScan$9$comippulsescannerMainActivity(ip, pkts, timeo, completed, ips);
                }
            });
        }
    }

    private void finishRangeScan() {
        this.rangeScanFinished = true;
        this.btnStart1.setEnabled(true);
        applySortAndRefreshTable();
    }

    public void applySortAndRefreshTable() {
        List<ScanResult> aliveResults = new ArrayList<>();
        for (ScanResult res : this.allResults) {
            if (res.alive) {
                aliveResults.add(res);
            }
        }
        switch (this.currentSortIndex) {
            case 0:
                Collections.sort(aliveResults, new Comparator() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda7
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return MainActivity.lambda$applySortAndRefreshTable$10((MainActivity.ScanResult) obj, (MainActivity.ScanResult) obj2);
                    }
                });
                break;
            case 1:
                Collections.sort(aliveResults, new Comparator() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda8
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return Float.compare(((MainActivity.ScanResult) obj).loss, ((MainActivity.ScanResult) obj2).loss);
                    }
                });
                break;
            case 2:
                Collections.sort(aliveResults, new Comparator() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda9
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return Float.compare(((MainActivity.ScanResult) obj).jitter, ((MainActivity.ScanResult) obj2).jitter);
                    }
                });
                break;
            case FAST_FAIL_THRESHOLD /* 3 */:
                Collections.sort(aliveResults, new Comparator() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda10
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return Float.compare(((MainActivity.ScanResult) obj).avg, ((MainActivity.ScanResult) obj2).avg);
                    }
                });
                break;
            case 4:
                Collections.sort(aliveResults, new Comparator() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda12
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return Float.compare(((MainActivity.ScanResult) obj).min, ((MainActivity.ScanResult) obj2).min);
                    }
                });
                break;
            case 5:
                Collections.sort(aliveResults, new Comparator() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda13
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return Float.compare(((MainActivity.ScanResult) obj).max, ((MainActivity.ScanResult) obj2).max);
                    }
                });
                break;
        }
        this.table1.removeAllViews();
        addTableHeader(this.table1, false);
        this.top5IPs.clear();
        for (int i = 0; i < Math.min(5, aliveResults.size()); i++) {
            this.top5IPs.add(aliveResults.get(i).f0ip);
        }
        int rank = 1;
        for (ScanResult res2 : aliveResults) {
            boolean isTop5 = this.top5IPs.contains(res2.f0ip);
            addTableRow(this.table1, res2, rank, false, isTop5);
            rank++;
        }
        populateTab2();
        this.status1.setText("Sorted by: " + this.sortOptions[this.currentSortIndex]);
    }

    private void populateTab2() {
        this.top5Container.removeAllViews();
        if (this.top5IPs.isEmpty()) {
            TextView tv = new TextView(this);
            tv.setText("No alive IPs found.");
            tv.setTextColor(Color.parseColor("#EF4444"));
            tv.setGravity(17);
            this.top5Container.addView(tv);
            return;
        }
        for (int i = 0; i < this.top5IPs.size(); i++) {
            final String ip = this.top5IPs.get(i);
            Button btn = new Button(this);
            btn.setText("🥇 Start Deep Test: " + ip);
            btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFD700")));
            btn.setTextColor(-16777216);
            btn.setAllCaps(false);
            btn.setPadding(0, 8, 0, 8);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-1, -2);
            params.setMargins(0, 0, 0, 8);
            btn.setLayoutParams(params);
            btn.setOnClickListener(new View.OnClickListener() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m12lambda$populateTab2$16$comippulsescannerMainActivity(ip, view);
                }
            });
            this.top5Container.addView(btn);
        }
    }

    private void startDeepTestOn(final String ip) {
        if (this.deepTestThread != null && this.deepTestThread.isAlive()) {
            this.isCancelled = true;
            this.deepTestThread.interrupt();
        }
        this.isCancelled = false;
        this.logLayout2.removeAllViews();
        this.table2Live.removeAllViews();
        addTableHeader(this.table2Live, true);
        final int pkts = parseNum(this.inputPackets, 100);
        final int timeo = parseNum(this.inputTimeout, 1000);
        this.status2.setText("Deep Testing: " + ip);
        this.deepTestThread = new Thread(new Runnable() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m15lambda$startDeepTestOn$18$comippulsescannerMainActivity(ip, pkts, timeo);
            }
        });
        this.deepTestThread.start();
    }

    // ✅ موتور جدید: استفاده از ping پیوسته با یک فرآیند
    private ScanResult pingLogic(final String ip, int totalPkts, int timeo, boolean isDeepLive, final TableLayout liveTable) {
        TableRow liveRow;
        int lost;
        float f;
        float f2;
        String str;
        int attempted;
        int lost2;
        String str2 = "time=";
        List<Float> rttList = new ArrayList<>();
        int tSec = Math.max(1, timeo / 1000);
        final TextView[] liveCells = new TextView[8];
        if (isDeepLive) {
            final TableRow liveRow2 = new TableRow(this);
            liveRow2.setBackgroundColor(Color.parseColor("#18181B"));
            int i = 0;
            for (int i2 = 8; i < i2; i2 = 8) {
                TextView tv = new TextView(this);
                tv.setPadding(10, 10, 10, 10);
                tv.setGravity(17);
                tv.setTextSize(11.0f);
                tv.setTextColor(-1);
                liveCells[i] = tv;
                liveRow2.addView(tv);
                i++;
            }
            runOnUiThread(new Runnable() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda23
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.lambda$pingLogic$19(liveTable, liveRow2, liveCells, ip);
                }
            });
            liveRow = liveRow2;
        } else {
            liveRow = null;
        }
        int i3 = 1;
        int consecutiveLost = 0;
        int attempted2 = 0;
        int consecutiveLost2 = 0;
        while (i3 <= totalPkts && !this.isCancelled) {
            int attempted3 = i3;
            float rtt = -1.0f;
            try {
                Process p = new ProcessBuilder("ping", "-c", "1", "-W", String.valueOf(tSec), ip).redirectErrorStream(true).start();
                try {
                    attempted = attempted3;
                    try {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                        while (true) {
                            String line = reader.readLine();
                            if (line == null) {
                                str = str2;
                                break;
                            }
                            if (!line.contains(str2)) {
                                str2 = str2;
                            } else {
                                int idx = line.indexOf(str2);
                                str = str2;
                                try {
                                    String sub = line.substring(idx + 5).trim();
                                    BufferedReader reader2 = reader;
                                    String[] parts = sub.split(" ");
                                    if (parts.length > 0) {
                                        break;
                                    }
                                    reader = reader2;
                                    str2 = str;
                                } catch (Exception e) {
                                    rtt = -1.0f;
                                }
                            }
                        }
                        p.waitFor();
                        p.destroy();
                    } catch (Exception e2) {
                        str = str2;
                    }
                } catch (Exception e3) {
                    str = str2;
                    attempted = attempted3;
                }
            } catch (Exception e4) {
                str = str2;
                attempted = attempted3;
            }
            if (rtt >= 0.0f) {
                rttList.add(Float.valueOf(rtt));
                consecutiveLost2 = 0;
            } else {
                consecutiveLost++;
                consecutiveLost2++;
                if (consecutiveLost2 >= FAST_FAIL_THRESHOLD) {
                    lost = consecutiveLost;
                    attempted2 = attempted;
                    break;
                }
            }
            if (!isDeepLive || liveRow == null) {
                lost2 = consecutiveLost;
            } else {
                final int curReceived = rttList.size();
                final float curAvg = avg(rttList);
                final float curMin = min(rttList);
                final float curMax = max(rttList);
                final float curJitter = jitter(rttList);
                final float curLoss = ((i3 - curReceived) * 100.0f) / i3;
                final int seq = i3;
                float finalRtt = rtt;
                lost2 = consecutiveLost;
                runOnUiThread(new Runnable() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda24
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainActivity.lambda$pingLogic$20(liveCells, seq, curAvg, curMin, curMax, curJitter, curLoss, curReceived);
                    }
                });
                appendDeepLog(ip + " seq=" + seq + "/" + totalPkts + " rtt=" + (finalRtt >= 0.0f ? finalRtt + "ms" : "lost"));
            }
            if (i3 < totalPkts && !this.isCancelled && consecutiveLost2 < FAST_FAIL_THRESHOLD) {
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e5) {
                    attempted2 = attempted;
                    lost = lost2;
                }
            }
            i3++;
            attempted2 = attempted;
            str2 = str;
            consecutiveLost = lost2;
        }
        lost = consecutiveLost;
        if (attempted2 == 0) {
            f = 100.0f;
            f2 = 100.0f;
        } else {
            f = 100.0f;
            f2 = (lost * 100.0f) / attempted2;
        }
        float lossPct = f2;
        boolean alive = rttList.size() > 0 && lossPct < f;
        return new ScanResult(ip, avg(rttList), min(rttList), max(rttList), jitter(rttList), lossPct, alive, attempted2);
    }

    private float avg(List<Float> list) {
        if (list == null || list.isEmpty()) return 0;
        float sum = 0;
        for (float f : list) sum += f;
        return sum / list.size();
    }

    private float min(List<Float> list) {
        if (list == null || list.isEmpty()) return 0;
        float m = list.get(0);
        for (float f : list) if (f < m) m = f;
        return m;
    }

    private float max(List<Float> list) {
        if (list == null || list.isEmpty()) return 0;
        float m = list.get(0);
        for (float f : list) if (f > m) m = f;
        return m;
    }

    private float jitter(List<Float> list) {
        if (list == null || list.size() < 2) return 0;
        float sum = 0;
        for (int i = 1; i < list.size(); i++) sum += Math.abs(list.get(i) - list.get(i - 1));
        return sum / (list.size() - 1);
    }

    private void appendMainLog(ScanResult res) {
        if (logLayout1.getChildCount() >= MAX_LOG_ITEMS) {
            logLayout1.removeViewAt(0);
        }
        TextView tv = new TextView(this);
        tv.setText(String.format(Locale.US, "%s | Sent:%d | Avg:%.1f | Min:%.1f | Max:%.1f | Jit:%.2f | Loss:%.0f%%",
                res.ip, res.sent, res.avg, res.min, res.max, res.jitter, res.loss));
        tv.setTextColor(res.alive ? Color.GREEN : Color.RED);
        tv.setTextSize(11f);
        tv.setPadding(0, 4, 0, 4);
        logLayout1.addView(tv);
        logScroll1.post(() -> logScroll1.fullScroll(View.FOCUS_DOWN));
    }

    private void appendDeepLog(String msg) {
        runOnUiThread(() -> {
            if (logLayout2.getChildCount() >= MAX_LOG_ITEMS) {
                logLayout2.removeViewAt(0);
            }
            TextView tv = new TextView(this);
            tv.setText(msg);
            tv.setTextColor(Color.GREEN);
            tv.setTextSize(11f);
            tv.setPadding(0, 2, 0, 2);
            logLayout2.addView(tv);
            logScroll2.post(() -> logScroll2.fullScroll(View.FOCUS_DOWN));
        });
    }

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

    private int parseNum(EditText editText, int defaultVal) {
        try { return Integer.parseInt(editText.getText().toString().trim()); }
        catch (Exception e) { return defaultVal; }
    }

    private List<String> parseIPList(String query) {
        List<String> list = new ArrayList<>();
        String q = query.replace("تا", "-").trim();
        try {
            if (q.contains("/")) {
                String[] parts = q.split("/");
                String base = parts[0].trim();
                int prefix = Integer.parseInt(parts[1].trim());
                long ip = ipToLong(base);
                int hostBits = 32 - prefix;
                long mask = hostBits == 32 ? 0xFFFFFFFFL : (1L << hostBits) - 1;
                long start = ip & ~mask;
                long end = ip | mask;
                for (long i = start; i <= end; i++) list.add(longToIp(i));
            } else if (q.contains("-")) {
                String[] parts = q.split("-");
                long start = ipToLong(parts[0].trim());
                long end = ipToLong(parts[1].trim());
                if (start > end) { long tmp = start; start = end; end = tmp; }
                for (long i = start; i <= end; i++) list.add(longToIp(i));
            } else {
                list.add(q);
            }
        } catch (Exception e) {
            list.clear();
            list.add(q);
        }
        return list;
    }

    private long ipToLong(String ip) {
        String[] octets = ip.trim().split("\\.");
        if (octets.length != 4) throw new IllegalArgumentException("Invalid IP");
        long result = 0;
        for (String octet : octets) {
            int val = Integer.parseInt(octet.trim());
            if (val < 0 || val > 255) throw new IllegalArgumentException("Invalid octet");
            result = (result << 8) | val;
        }
        return result & 0xFFFFFFFFL;
    }

    private String longToIp(long ip) {
        return String.format(Locale.US, "%d.%d.%d.%d",
                (ip >> 24) & 0xFF, (ip >> 16) & 0xFF, (ip >> 8) & 0xFF, ip & 0xFF);
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

    private void clearHistory() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        prefs.edit().remove(HISTORY_KEY).apply();
        Toast.makeText(this, "History cleared", Toast.LENGTH_SHORT).show();
    }

    private void showHistoryDialog() {
        List<String> items = new ArrayList<>(loadHistory());
        if (items.isEmpty()) {
            Toast.makeText(this, "No history yet", Toast.LENGTH_SHORT).show();
            return;
        }
        String[] arr = items.toArray(new String[0]);
        new AlertDialog.Builder(this)
                .setTitle("History")
                .setItems(arr, (dialog, which) -> {
                    ipInput.setText(arr[which]);
                    startRangeScan();
                })
                .show();
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

    private void manualDeepTest() {
        String ip = manualIpInput.getText().toString().trim();
        if (ip.isEmpty()) {
            Toast.makeText(this, "لطفاً یک IP وارد کنید", Toast.LENGTH_SHORT).show();
            return;
        }
        startDeepTestOn(ip);
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
