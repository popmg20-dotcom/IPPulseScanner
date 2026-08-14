package com.ippulse.scanner;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
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

public class MainActivity extends Activity {
    
    private static final int FAST_FAIL_THRESHOLD = 2;

    // Tab 1
    private View tab1Container, tab2Container;
    private Button btnTab1, btnTab2, btnStart1, btnStop1;
    private EditText ipInput, inputPackets, inputInterval, inputTimeout;
    private TextView status1;
    private LinearLayout logLayout1;
    private ScrollView logScroll1;
    private TableLayout table1;

    // Tab 2
    private LinearLayout top5Container, logLayout2;
    private ScrollView logScroll2;
    private TextView status2;
    private TableLayout table2Live;
    private Button btnStop2;

    private ExecutorService executor;
    private Thread deepTestThread;
    private volatile boolean isCancelled = false;
    private List<ScanResult> allResults = new ArrayList<>();
    private List<String> top5IPs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init Tab 1
        tab1Container = findViewById(R.id.tab1Container);
        btnTab1 = findViewById(R.id.btnTab1);
        btnTab2 = findViewById(R.id.btnTab2);
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

        // Init Tab 2
        tab2Container = findViewById(R.id.tab2Container);
        top5Container = findViewById(R.id.top5Container);
        status2 = findViewById(R.id.status2);
        logLayout2 = findViewById(R.id.logLayout2);
        logScroll2 = findViewById(R.id.logScroll2);
        table2Live = findViewById(R.id.table2Live);
        btnStop2 = findViewById(R.id.btnStop2);

        // Tab Switching
        btnTab1.setOnClickListener(v -> switchTab(1));
        btnTab2.setOnClickListener(v -> switchTab(2));

        btnStart1.setOnClickListener(v -> startRangeScan());
        btnStop1.setOnClickListener(v -> stopAll());
        btnStop2.setOnClickListener(v -> stopAll());
    }

    private void switchTab(int tab) {
        if (tab == 1) {
            tab1Container.setVisibility(View.VISIBLE);
            tab2Container.setVisibility(View.GONE);
            btnTab1.setBackgroundColor(Color.parseColor("#2563EB")); btnTab1.setTextColor(Color.WHITE);
            btnTab2.setBackgroundColor(Color.parseColor("#1E293B")); btnTab2.setTextColor(Color.parseColor("#94A3B8"));
        } else {
            tab1Container.setVisibility(View.GONE);
            tab2Container.setVisibility(View.VISIBLE);
            btnTab2.setBackgroundColor(Color.parseColor("#2563EB")); btnTab2.setTextColor(Color.WHITE);
            btnTab1.setBackgroundColor(Color.parseColor("#1E293B")); btnTab1.setTextColor(Color.parseColor("#94A3B8"));
        }
    }

    private void stopAll() {
        isCancelled = true;
        if (executor != null) executor.shutdownNow();
        if (deepTestThread != null) deepTestThread.interrupt();
        status1.setText("Stopped by user.");
        status2.setText("Deep test stopped.");
        btnStart1.setEnabled(true);
    }

    private void startRangeScan() {
        String query = ipInput.getText().toString().trim();
        List<String> ips = parseIPList(query);
        if (ips.isEmpty()) return;

        int pkts = parseNum(inputPackets, 100);
        int interv = parseNum(inputInterval, 1);
        int timeo = parseNum(inputTimeout, 1000);

        allResults.clear();
        logLayout1.removeAllViews();
        table1.removeAllViews();
        addTableHeader(table1, false);
        btnStart1.setEnabled(false);
        isCancelled = false;
        
        executor = Executors.newFixedThreadPool(80); 
        final int[] completed = {0};
        status1.setText("Scanning " + ips.size() + " IPs concurrently...");

        for (String ip : ips) {
            executor.execute(() -> {
                if (isCancelled) return;
                ScanResult res = pingLogic(ip, pkts, interv, timeo, false, null);
                
                synchronized(allResults) { allResults.add(res); completed[0]++; }

                runOnUiThread(() -> {
                    appendMainLog(res);
                    status1.setText(completed[0] + " / " + ips.size() + " processed.");
                    if (completed[0] >= ips.size() && !isCancelled) finishRangeScan();
                });
            });
        }
    }

    private void finishRangeScan() {
        btnStart1.setEnabled(true);
        Collections.sort(allResults, (a, b) -> {
            if (a.loss != b.loss) return Float.compare(a.loss, b.loss);
            if (Math.abs(a.jitter - b.jitter) > 0.2f) return Float.compare(a.jitter, b.jitter);
            return Float.compare(a.avg, b.avg);
        });

        table1.removeAllViews();
        addTableHeader(table1, false);
        
        top5IPs.clear();
        for (ScanResult res : allResults) {
            if (res.alive && top5IPs.size() < 5) top5IPs.add(res.ip);
        }

        int rank = 1;
        for (ScanResult res : allResults) {
            boolean isTop5 = top5IPs.contains(res.ip);
            addTableRow(table1, res, rank, false, isTop5);
            rank++;
        }
        
        populateTab2();
        status1.setText("Scan complete. Top 5 transferred to Tab 2.");
    }

    private void populateTab2() {
        top5Container.removeAllViews();
        if (top5IPs.isEmpty()) {
            TextView tv = new TextView(this);
            tv.setText("No alive IPs found."); tv.setTextColor(Color.parseColor("#EF4444"));
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
        int interv = parseNum(inputInterval, 1);
        int timeo = parseNum(inputTimeout, 1000);

        status2.setText("Deep Testing: " + ip);

        deepTestThread = new Thread(() -> {
            pingLogic(ip, pkts, interv, timeo, true, table2Live);
            runOnUiThread(() -> {
                if (!isCancelled) status2.setText("Deep Test Finished: " + ip);
            });
        });
        deepTestThread.start();
    }

    // Core Ping Engine
    private ScanResult pingLogic(String ip, int totalPkts, int interv, int timeo, boolean isDeepLive, TableLayout liveTable) {
        List<Float> rttList = new ArrayList<>();
        int lost = 0;
        int consecutiveLost = 0;
        int attempted = 0;
        boolean fastFailTriggered = false;
        int tSec = Math.max(1, timeo / 1000);

        TableRow liveRow = null;
        TextView[] liveCells = new TextView[8];

        if (isDeepLive) {
            liveRow = new TableRow(this);
            liveRow.setBackgroundColor(Color.parseColor("#18181B"));
            for (int i = 0; i < 8; i++) {
                TextView tv = new TextView(this);
                tv.setPadding(10, 10, 10, 10); tv.setGravity(Gravity.CENTER); tv.setTextSize(11f); tv.setTextColor(Color.WHITE);
                liveCells[i] = tv;
                liveRow.addView(tv);
            }
            final TableRow rowToAdd = liveRow;
            runOnUiThread(() -> {
                liveTable.addView(rowToAdd);
                // Initialize cells
                liveCells[0].setText(ip);
                liveCells[1].setText("0");
                liveCells[2].setText("0");
                liveCells[3].setText("0");
                liveCells[4].setText("0");
                liveCells[5].setText("0");
                liveCells[6].setText("0%");
                liveCells[7].setText("ALIVE");
            });
        }

        for (int i = 1; i <= totalPkts; i++) {
            if (isCancelled) break;
            attempted = i;
            try {
                long startT = System.currentTimeMillis();
                Process process = new ProcessBuilder("ping", "-c", "1", "-W", String.valueOf(tSec), ip)
                    .redirectErrorStream(true)
                    .start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                float rtt = -1f;
                while ((line = reader.readLine()) != null) {
                    if (line.contains("time=")) {
                        String[] tokens = line.substring(line.indexOf("time=") + 5).split(" ");
                        if (tokens.length > 0) {
                            rtt = Float.parseFloat(tokens[0].trim());
                            break;
                        }
                    }
                }
                process.waitFor();

                if (rtt >= 0) {
                    rttList.add(rtt);
                    consecutiveLost = 0;
                } else {
                    lost++;
                    consecutiveLost++;
                    if (consecutiveLost >= FAST_FAIL_THRESHOLD) {
                        fastFailTriggered = true;
                        break;
                    }
                }
            } catch (Exception e) {
                lost++;
                consecutiveLost++;
                if (consecutiveLost >= FAST_FAIL_THRESHOLD) {
                    fastFailTriggered = true;
                    break;
                }
            }

            // Sleep interval between packets (real 1ms)
            if (i < totalPkts && !fastFailTriggered) {
                try { Thread.sleep(interv); } catch (InterruptedException e) { break; }
            }

            // Live update for Deep Test
            if (isDeepLive && liveRow != null) {
                int curAttempted = i;
                int curLost = lost;
                List<Float> curRtt = new ArrayList<>(rttList);
                float curAvg = avg(curRtt);
                float curMin = min(curRtt);
                float curMax = max(curRtt);
                float curJitter = jitter(curRtt);
                float curLoss = (curLost * 100f) / curAttempted;
                runOnUiThread(() -> {
                    liveCells[0].setText(ip);
                    liveCells[1].setText(String.valueOf(curAttempted));
                    liveCells[2].setText(String.format(Locale.US, "%.1f", curAvg));
                    liveCells[3].setText(String.format(Locale.US, "%.1f", curMin));
                    liveCells[4].setText(String.format(Locale.US, "%.1f", curMax));
                    liveCells[5].setText(String.format(Locale.US, "%.2f", curJitter));
                    liveCells[6].setText(String.format(Locale.US, "%.0f%%", curLoss));
                    liveCells[7].setText(curLoss < 100f ? "ALIVE" : "DEAD");
                });
            }
        }

        float lossPct = attempted == 0 ? 100f : (lost * 100f) / attempted;
        boolean alive = lossPct < 100f && !rttList.isEmpty();
        float avg = avg(rttList);
        float min = min(rttList);
        float max = max(rttList);
        float jit = jitter(rttList);
        return new ScanResult(ip, avg, min, max, jit, lossPct, alive, attempted);
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
        for (int i = 1; i < list.size(); i++) {
            sum += Math.abs(list.get(i) - list.get(i-1));
        }
        return sum / (list.size() - 1);
    }

    private void appendMainLog(ScanResult res) {
        TextView tv = new TextView(this);
        tv.setText(String.format(Locale.US, "%s | Avg:%.1f | Min:%.1f | Max:%.1f | Jit:%.2f | Loss:%.0f%%",
                res.ip, res.avg, res.min, res.max, res.jitter, res.loss));
        tv.setTextColor(res.alive ? Color.WHITE : Color.RED);
        tv.setTextSize(11f);
        tv.setPadding(0, 4, 0, 4);
        logLayout1.addView(tv);
        logScroll1.post(() -> logScroll1.fullScroll(View.FOCUS_DOWN));
    }

    private void addTableHeader(TableLayout table, boolean isLive) {
        TableRow header = new TableRow(this);
        header.setBackgroundColor(Color.parseColor("#334155"));
        String[] headers = isLive ? new String[]{"IP","Sent","Avg","Min","Max","Jitter","Loss","Status"} :
                                    new String[]{"Rank","IP","Sent","Avg","Min","Max","Jitter","Loss","Status"};
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
        if (isTop5) {
            row.setBackgroundColor(Color.parseColor("#FFD700")); // gold
        } else {
            row.setBackgroundColor(Color.parseColor("#18181B"));
        }
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

        // Fetch flag for IP column (index 0 for live, index 1 for range)
        int ipIndex = isLive ? 0 : 1;
        TextView ipCell = (TextView) row.getChildAt(ipIndex);
        fetchFlag(ipCell, res.ip);
    }

    private void fetchFlag(TextView textView, String ip) {
        new Thread(() -> {
            String flag = getCountryFlag(ip);
            runOnUiThread(() -> {
                textView.setText(flag + " " + ip);
            });
        }).start();
    }

    private String getCountryFlag(String ip) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL("http://ip-api.com/json/" + ip + "?fields=countryCode");
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(3000);
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) sb.append(line);
            reader.close();
            JSONObject json = new JSONObject(sb.toString());
            String code = json.optString("countryCode", "");
            if (!code.isEmpty()) return countryCodeToFlag(code);
        } catch (Exception e) {
            // ignore, fallback to globe
        } finally {
            if (conn != null) conn.disconnect();
        }
        return "🌐";
    }

    private String countryCodeToFlag(String code) {
        if (code.length() != 2) return "🌐";
        int base = 0x1F1E6;
        int first = base + (code.charAt(0) - 'A');
        int second = base + (code.charAt(1) - 'A');
        return new String(Character.toChars(first)) + new String(Character.toChars(second));
    }

    private int parseNum(EditText editText, int defaultVal) {
        try { return Integer.parseInt(editText.getText().toString().trim()); }
        catch (Exception e) { return defaultVal; }
    }

    // IP Range Parser (supports arbitrary ranges, CIDR, and single IP)
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
                for (long i = start; i <= end; i++) {
                    list.add(longToIp(i));
                }
            } else if (q.contains("-")) {
                String[] parts = q.split("-");
                String startStr = parts[0].trim();
                String endStr = parts[1].trim();
                long start = ipToLong(startStr);
                long end = ipToLong(endStr);
                if (start > end) { long tmp = start; start = end; end = tmp; }
                for (long i = start; i <= end; i++) {
                    list.add(longToIp(i));
                }
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

    // ScanResult class
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
}
