package com.ippulse.scanner;

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
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends Activity {

    private static final int FAST_FAIL_THRESHOLD = 3;
    private static final String PREFS_NAME = "ippulse_history";
    private static final String HISTORY_KEY = "history";
    private static final String VPN_PREFS = "vpn_settings";
    private static final int REQUEST_VPN = 1001;
    private static final int REQUEST_NOTIFICATION = 1002;
    private static final int MAX_LOG_ITEMS = 50;

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

    private EditText vpnDns, vpnMtu, vpnHosts, vpnMasterIp;
    private Button btnStartVpn, btnStopVpn, btnApplyIp;
    private TextView vpnStatus;

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

        tab1Container = findViewById(R.id.tab1Container);
        btnTab1 = findViewById(R.id.btnTab1);
        btnTab2 = findViewById(R.id.btnTab2);
        btnTab3 = findViewById(R.id.btnTab3);
        btnStart1 = findViewById(R.id.btnStart1);
        btnStop1 = findViewById(R.id.btnStop1);
        ipInput = findViewById(R.id.ipInput);
        inputPackets = findViewById(R.id.inputPackets);
        inputInterval = findViewById(R.id.inputInterval);
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

        tab3Container = findViewById(R.id.tab3Container);
        vpnDns = findViewById(R.id.vpnDns);
        vpnMtu = findViewById(R.id.vpnMtu);
        vpnHosts = findViewById(R.id.vpnHosts);
        vpnMasterIp = findViewById(R.id.vpnMasterIp);
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

        btnStartVpn.setOnClickListener(v -> startVpn());
        btnStopVpn.setOnClickListener(v -> stopVpn());
        btnApplyIp.setOnClickListener(v -> applyMasterIp());
        addLogButton();
        addLogButton();

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
        vpnMtu.setText(String.valueOf(prefs.getInt("mtu", 1400)));
        vpnHosts.setText(prefs.getString("hosts", ""));
        if (vpnHosts.getText().toString().trim().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (String domain : defaultDomains) {
                sb.append(domain).append("\n");
            }
            vpnHosts.setText(sb.toString().trim());
        }
    }

    private void saveVpnSettings() {
        SharedPreferences prefs = getSharedPreferences(VPN_PREFS, MODE_PRIVATE);
        prefs.edit()
            .putString("dns", vpnDns.getText().toString().trim())
            .putInt("mtu", parseIntSafe(vpnMtu.getText().toString().trim(), 1400))
            .putString("hosts", vpnHosts.getText().toString().trim())
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

    private void startVpn() {
        saveVpnSettings();
        String dns = vpnDns.getText().toString().trim();
        int mtu = parseIntSafe(vpnMtu.getText().toString().trim(), 1400);
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
            GamingVpnService.start(this, dns, mtu, hostsMap);

            vpnStatus.setText("VPN: Connected");
            Toast.makeText(this, "VPN started", Toast.LENGTH_SHORT).show();
        }
    }

    private void stopVpn() {
        GamingVpnService.stop(this);
            
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
            String dns = vpnDns.getText().toString().trim();
            int mtu = parseIntSafe(vpnMtu.getText().toString().trim(), 1400);
            HashMap<String, String> hostsMap = parseHosts(vpnHosts.getText().toString());
            GamingVpnService.start(this, dns, mtu, hostsMap);

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
        String query = ipInput.getText().toString().trim();
        if (query.isEmpty()) {
            Toast.makeText(this, "Please enter a range or IP", Toast.LENGTH_SHORT).show();
            return;
        }
        List<String> ips = parseIPList(query);
        if (ips.isEmpty()) {
            Toast.makeText(this, "Invalid range", Toast.LENGTH_SHORT).show();
            return;
        }

        int pkts = parseNum(inputPackets, 100);
        int timeo = parseNum(inputTimeout, 1000);

        allResults.clear();
        logLayout1.removeAllViews();
        table1.removeAllViews();
        addTableHeader(table1, false);
        btnStart1.setEnabled(false);
        isCancelled = false;
        rangeScanFinished = false;

        saveHistory(query);

        executor = Executors.newFixedThreadPool(3);
        final int[] completed = {0};
        status1.setText("Scanning " + ips.size() + " IPs concurrently...");

        for (String ip : ips) {
            executor.execute(() -> {
                if (isCancelled) return;
                ScanResult res = pingLogic(ip, pkts, timeo, false, null);
                synchronized (allResults) {
                    allResults.add(res);
                    completed[0]++;
                }
                runOnUiThread(() -> {
                    appendMainLog(res);
                    status1.setText(completed[0] + " / " + ips.size() + " processed.");
                    if (completed[0] >= ips.size() && !isCancelled && !rangeScanFinished) {
                        finishRangeScan();
                    }
                });
            });
        }
    }

    private void finishRangeScan() {
        rangeScanFinished = true;
        btnStart1.setEnabled(true);
        applySortAndRefreshTable();
    }

    private void applySortAndRefreshTable() {
        List<ScanResult> aliveResults = new ArrayList<>();
        for (ScanResult res : allResults) {
            if (res.alive) aliveResults.add(res);
        }

        if (aliveResults.size() > 100) {
            aliveResults = new ArrayList<>(aliveResults.subList(0, 100));
        }

        switch (currentSortIndex) {
            case 0:
                Collections.sort(aliveResults, (a, b) -> {
                    if (a.loss != b.loss) return Float.compare(a.loss, b.loss);
                    if (Math.abs(a.jitter - b.jitter) > 0.1f) return Float.compare(a.jitter, b.jitter);
                    if (a.avg != b.avg) return Float.compare(a.avg, b.avg);
                    return Float.compare(a.max, b.max);
                });
                break;
            case 1:
                Collections.sort(aliveResults, (a, b) -> Float.compare(a.loss, b.loss));
                break;
            case 2:
                Collections.sort(aliveResults, (a, b) -> Float.compare(a.jitter, b.jitter));
                break;
            case 3:
                Collections.sort(aliveResults, (a, b) -> Float.compare(a.avg, b.avg));
                break;
            case 4:
                Collections.sort(aliveResults, (a, b) -> Float.compare(a.min, b.min));
                break;
            case 5:
                Collections.sort(aliveResults, (a, b) -> Float.compare(a.max, b.max));
                break;
        }

        table1.removeAllViews();
        addTableHeader(table1, false);
        top5IPs.clear();
        for (int i = 0; i < Math.min(5, aliveResults.size()); i++) {
            top5IPs.add(aliveResults.get(i).ip);
        }

        int rank = 1;
        for (ScanResult res : aliveResults) {
            boolean isTop5 = top5IPs.contains(res.ip);
            addTableRow(table1, res, rank, false, isTop5);
            rank++;
        }

        populateTab2();
        status1.setText("Sorted by: " + sortOptions[currentSortIndex]);
    }

    private void populateTab2() {
        top5Container.removeAllViews();
        if (top5IPs.isEmpty()) {
            TextView tv = new TextView(this);
            tv.setText("No alive IPs found.");
            tv.setTextColor(Color.parseColor("#EF4444"));
            tv.setGravity(Gravity.CENTER);
            top5Container.addView(tv);
            return;
        }
        for (int i = 0; i < top5IPs.size(); i++) {
            String ip = top5IPs.get(i);
            Button btn = new Button(this);
            btn.setText("🥇 Start Deep Test: " + ip);
            btn.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#FFD700")));
            btn.setTextColor(Color.BLACK);
            btn.setAllCaps(false);
            btn.setPadding(0, 8, 0, 8);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 0, 0, 8);
            btn.setLayoutParams(params);
            btn.setOnClickListener(v -> startDeepTestOn(ip));
            top5Container.addView(btn);
        }
    }

    private void startDeepTestOn(String ip) {
        if (deepTestThread != null && deepTestThread.isAlive()) {
            isCancelled = true;
            deepTestThread.interrupt();
        }
        isCancelled = false;
        logLayout2.removeAllViews();
        table2Live.removeAllViews();
        addTableHeader(table2Live, true);
        int pkts = parseNum(inputPackets, 100);
        int timeo = parseNum(inputTimeout, 1000);
        status2.setText("Deep Testing: " + ip);
        deepTestThread = new Thread(() -> {
            pingLogic(ip, pkts, timeo, true, table2Live);
            runOnUiThread(() -> {
                if (!isCancelled) status2.setText("Deep Test Finished: " + ip);
            });
        });
        deepTestThread.start();
    }

    // ✅ موتور جدید: استفاده از ping پیوسته با یک فرآیند
    private ScanResult pingLogic(String ip, int totalPkts, int timeo, boolean isDeepLive, TableLayout liveTable) {
        List<Float> rttList = new ArrayList<>();
        int received = 0;
        int lost = 0;
        int sent = 0;
        int tSec = Math.max(1, timeo / 1000);

        TableRow liveRow = null;
        TextView[] liveCells = new TextView[8];

        if (isDeepLive) {
            liveRow = new TableRow(this);
            liveRow.setBackgroundColor(Color.parseColor("#18181B"));
            for (int i = 0; i < 8; i++) {
                TextView tv = new TextView(this);
                tv.setPadding(10, 10, 10, 10);
                tv.setGravity(Gravity.CENTER);
                tv.setTextSize(11f);
                tv.setTextColor(Color.WHITE);
                liveCells[i] = tv;
                liveRow.addView(tv);
            }
            final TableRow rowToAdd = liveRow;
            final TextView[] cells = liveCells;
            final String ipFinal = ip;
            runOnUiThread(() -> {
                liveTable.addView(rowToAdd);
                cells[0].setText(ipFinal);
                cells[1].setText("0");
                cells[2].setText("0");
                cells[3].setText("0");
                cells[4].setText("0");
                cells[5].setText("0");
                cells[6].setText("0%");
                cells[7].setText("TESTING");
            });
        }

        try {
            ProcessBuilder pb = new ProcessBuilder("ping", "-c", String.valueOf(totalPkts), "-i", "0.2", "-W", String.valueOf(tSec), ip);
            pb.redirectErrorStream(true);
            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null && !isCancelled) {
                if (line.contains("time=")) {
                    int idx = line.indexOf("time=");
                    if (idx != -1) {
                        String sub = line.substring(idx + 5).trim();
                        String[] parts = sub.split(" ");
                        if (parts.length > 0) {
                            float rtt = Float.parseFloat(parts[0].trim());
                            rttList.add(rtt);
                            received++;
                            sent++;
                            if (isDeepLive && liveRow != null && (received % 5 == 0 || received == totalPkts)) {
                                int curReceived = received;
                                float curAvg = avg(rttList);
                                float curMin = min(rttList);
                                float curMax = max(rttList);
                                float curJitter = jitter(rttList);
                                float curLoss = ((totalPkts - curReceived) * 100f) / totalPkts;
                                final int seq = received;
                                final float finalRtt = rtt;
                                runOnUiThread(() -> {
                                    liveCells[1].setText(String.valueOf(seq));
                                    liveCells[2].setText(String.format(Locale.US, "%.1f", curAvg));
                                    liveCells[3].setText(String.format(Locale.US, "%.1f", curMin));
                                    liveCells[4].setText(String.format(Locale.US, "%.1f", curMax));
                                    liveCells[5].setText(String.format(Locale.US, "%.2f", curJitter));
                                    liveCells[6].setText(String.format(Locale.US, "%.0f%%", curLoss));
                                    liveCells[7].setText("ALIVE");
                                });
                                appendDeepLog(ip + " seq=" + seq + "/" + totalPkts + " rtt=" + finalRtt + "ms");
                            }
                        }
                    }
                } else if (line.contains("icmp_seq")) {
                    // شماره سکانس را استخراج می‌کنیم (برای packet loss)
                    int seqIdx = line.indexOf("icmp_seq=");
                    if (seqIdx != -1) {
                        int start = seqIdx + "icmp_seq=".length();
                        int end = start;
                        while (end < line.length() && Character.isDigit(line.charAt(end))) end++;
                        if (end > start) {
                            try {
                                int seq = Integer.parseInt(line.substring(start, end));
                                sent = Math.max(sent, seq);
                                // اگر خط حاوی time= نبود، یعنی lost
                                if (!line.contains("time=")) {
                                    lost++;
                                    if (isDeepLive && liveRow != null && (sent % 5 == 0 || sent == totalPkts)) {
                                        int curSent = sent;
                                        int curReceived = received;
                                        float curAvg = avg(rttList);
                                        float curMin = min(rttList);
                                        float curMax = max(rttList);
                                        float curJitter = jitter(rttList);
                                        float curLoss = ((curSent - curReceived) * 100f) / curSent;
                                        runOnUiThread(() -> {
                                            liveCells[1].setText(String.valueOf(curSent));
                                            liveCells[2].setText(String.format(Locale.US, "%.1f", curAvg));
                                            liveCells[3].setText(String.format(Locale.US, "%.1f", curMin));
                                            liveCells[4].setText(String.format(Locale.US, "%.1f", curMax));
                                            liveCells[5].setText(String.format(Locale.US, "%.2f", curJitter));
                                            liveCells[6].setText(String.format(Locale.US, "%.0f%%", curLoss));
                                            liveCells[7].setText("ALIVE");
                                        });
                                        appendDeepLog(ip + " seq=" + curSent + "/" + totalPkts + " lost");
                                    }
                                }
                            } catch (Exception ignored) {}
                        }
                    }
                }
            }
            process.waitFor();
            if (sent == 0) sent = totalPkts;
            lost = sent - received;
            if (lost < 0) lost = 0;
        } catch (Exception e) {
            e.printStackTrace();
            lost = totalPkts;
        }

        float lossPct = sent == 0 ? 100f : (lost * 100f) / sent;
        boolean alive = received > 0 && lossPct < 100f;
        float avg = avg(rttList);
        float min = min(rttList);
        float max = max(rttList);
        float jit = jitter(rttList);
        return new ScanResult(ip, avg, min, max, jit, lossPct, alive, sent);
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
}            StringBuilder sb = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(logFile));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
            reader.close();
            new AlertDialog.Builder(this)
                .setTitle("VPN Log")
                .setMessage(sb.toString())
                .setPositiveButton("OK", null)
                .show();
        } catch (IOException e) {
            Toast.makeText(this, "Error reading log", Toast.LENGTH_SHORT).show();
        }
    
    private void showVpnLog() {
        try {
            java.io.File logFile = new java.io.File(getFilesDir(), "vpn_log.txt");
            if (!logFile.exists()) {
                Toast.makeText(this, "No VPN log yet", Toast.LENGTH_SHORT).show();
                return;
            }
            StringBuilder sb = new StringBuilder();
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(logFile));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
            reader.close();
            new AlertDialog.Builder(this)
                .setTitle("VPN Log")
                .setMessage(sb.toString())
                .setPositiveButton("OK", null)
                .show();
        } catch (Exception e) {
            Toast.makeText(this, "Error reading log", Toast.LENGTH_SHORT).show();
        }
    }


    private void addLogButton() {
        try {
            android.view.ViewGroup tab3Scroll = (android.view.ViewGroup) tab3Container;
            android.view.ViewGroup tab3Layout = (android.view.ViewGroup) tab3Scroll.getChildAt(0);

            Button btnLog = new Button(this);
            btnLog.setText("Show VPN Log");
            btnLog.setTextColor(Color.WHITE);
            btnLog.setBackgroundColor(Color.parseColor("#334155"));
            btnLog.setAllCaps(false);
            btnLog.setPadding(0, 8, 0, 8);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 12, 0, 0);
            btnLog.setLayoutParams(params);
            btnLog.setOnClickListener(v -> showVpnLog());
            tab3Layout.addView(btnLog);
        } catch (Exception ignored) {}
    }

}
