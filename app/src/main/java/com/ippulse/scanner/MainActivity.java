package com.ippulse.scanner;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.*;

public class MainActivity extends Activity {
    
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
        
        // Massive ThreadPool for concurrent blasting
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
        int rank = 1;
        for (ScanResult res : allResults) {
            addTableRow(table1, res, rank, false);
            if (res.loss < 100f && top5IPs.size() < 5) top5IPs.add(res.ip);
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
            btn.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#047857")));
            btn.setTextColor(Color.WHITE);
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
        addTableHeader(table2Live, true); // True means Live mode

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

    // Core Ping Engine (Used for both Range & Deep Test)
    private ScanResult pingLogic(String ip, int totalPkts, int interv, int timeo, boolean isDeepLive, TableLayout liveTable) {
        List<Float> rttList = new ArrayList<>();
        int lost = 0;
        int consecutiveLost = 0;
        int tSec = Math.max(1, timeo / 1000);

        TableRow liveRow = null;
        TextView[] liveCells = new TextView[8];

        if (isDeepLive) {
            runOnUiThread(() -> {
                TableRow r = new TableRow(this);
                r.setBackgroundColor(Color.parseColor("#18181B"));
                for (int i = 0; i < 8; i++) {
                    TextView tv = new TextView(this);
                    tv.setPadding(10, 10, 10, 10); tv.setGravity(Gravity.CENTER); tv.setTextSize(11f); tv.setTextColor(Color.WHITE);
                    liveCells[i] = tv;
                    r.addView(tv);
                }
                liveTable.addView(r);
            });
        }

        for (int i = 1; i <= totalPkts; i++) {
            if (isCancelled) break;
            try {
                long startT = System.currentTimeMillis();
                Process p = Runtime.getRuntime().exec("ping -c 1 -W " + tSec + " " + ip);
                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                float rtt = -1f;
                while ((line = reader.readLine()) != null) {
                    if (line.contains("time=")) {
                        rtt = Float.parseFloat(line.substring(line.indexOf("time=") + 5).split(" ")[0].trim());
                        break;
                    }
                }
                p.waitFor();

                if (rtt >= 0) {
                    rttList.add(rtt);
                    consecutiveLost = 0;
                } else {
                    lost++;
                    consecutiveLost++;
                    // FAST FAIL for Range Scan: Drop dead IP after 3 consecutive fails
                    if (!isDeepLive && consecutiveLost >= 3) {
                        lost = totalPkts; 
                        break; 
                    }
                }

                // UI Updates for Deep Live Test
                if (isDeepLive) {
                    final int curPkt = i;
                    final float cRtt = rtt;
                    final int cLost = lost;
                    
                    runOnUiThread(() -> {
                        float cMin = rttList.isEmpty() ? 0 : Collections.min(rttList);
                        float cMax = rttList.isEmpty() ? 0 : Collections.max(rttList);
                        float cAvg = 0; float cJit = 0;
                        if (!rttList.isEmpty()) {
                            float s = 0; for(float v: rttList) s+=v; cAvg = s/rttList.size();
                        }
                        if (rttList.size() > 1) {
                            float js = 0; for(int j=1; j<rttList.size(); j++) js += Math.abs(rttList.get(j)-rttList.get(j-1));
                            cJit = js / (rttList.size()-1);
                        }
                        float cLossP = ((float)cLost / curPkt) * 100f;

                        // Update Live Log Box
                        TextView tv = new TextView(this);
                        tv.setTextSize(11f); tv.setTypeface(Typeface.MONOSPACE);
                        if (cRtt < 0) {
                            tv.setText(String.format(Locale.US, "-> %s | Pkt: %d | Timeout", ip, curPkt));
                            tv.setTextColor(Color.parseColor("#EF4444")); // RED
                        } else {
                            tv.setText(String.format(Locale.US, "-> %s | Pkts: %d/%d | Jit: %.1f | Avg: %.1f | Min: %.1f | Max: %.1f | Loss: %.0f%%",
                                    ip, curPkt, totalPkts, cJit, cAvg, cMin, cMax, cLossP));
                            tv.setTextColor(Color.parseColor("#10B981")); // GREEN
                        }
                        logLayout2.addView(tv);
                        logScroll2.post(() -> logScroll2.fullScroll(View.FOCUS_DOWN));

                        // Update Live Table
                        liveCells[0].setText(ip);
                        liveCells[1].setText(curPkt + "/" + totalPkts);
                        liveCells[2].setText(String.format(Locale.US, "%.1f", cAvg));
                        liveCells[3].setText(String.format(Locale.US, "%.1f", cMin));
                        liveCells[4].setText(String.format(Locale.US, "%.1f", cMax));
                        liveCells[5].setText(String.format(Locale.US, "%.1f", cJit));
                        liveCells[6].setText(String.format(Locale.US, "%.0f%%", cLossP));
                        liveCells[7].setText(cRtt < 0 ? "DEAD" : "ALIVE");
                        liveCells[7].setTextColor(cRtt < 0 ? Color.RED : Color.GREEN);
                    });
                }

                // Real 1ms interval Logic calculation
                long elapsed = System.currentTimeMillis() - startT;
                long sleepTime = interv - elapsed;
                if (sleepTime > 0) Thread.sleep(sleepTime);

            } catch (Exception e) {
                if (!isDeepLive) lost = totalPkts;
                break;
            }
        }

        float lossPct = ((float) lost / totalPkts) * 100f;
        if (rttList.isEmpty()) return new ScanResult(ip, 0, 999f, 999f, 999f, 999f, 100f);

        float min = Collections.min(rttList);
        float max = Collections.max(rttList);
        float sum = 0; for (float v : rttList) sum += v;
        float avg = sum / rttList.size();
        float jitter = 0;
        if (rttList.size() > 1) {
            float jSum = 0; for (int j = 1; j < rttList.size(); j++) jSum += Math.abs(rttList.get(j) - rttList.get(j - 1));
            jitter = jSum / (rttList.size() - 1);
        }

        return new ScanResult(ip, rttList.size(), avg, min, max, jitter, lossPct);
    }

    private void appendMainLog(ScanResult res) {
        TextView tv = new TextView(this);
        tv.setTextSize(11f); tv.setTypeface(Typeface.MONOSPACE);
        if (res.loss >= 100) {
            tv.setText(String.format(Locale.US, "-> %s | DEAD (Dropped)", res.ip));
            tv.setTextColor(Color.parseColor("#EF4444")); // RED
        } else {
            tv.setText(String.format(Locale.US, "-> %s | Pkts Sent: %d | Avg: %.1f | Min: %.1f | Max: %.1f | Jit: %.1f | Loss: %.0f%%", 
                res.ip, res.pktsSent, res.avg, res.min, res.max, res.jitter, res.loss));
            tv.setTextColor(Color.parseColor("#10B981")); // GREEN
        }
        logLayout1.addView(tv);
        logScroll1.post(() -> logScroll1.fullScroll(View.FOCUS_DOWN));
    }

    private void addTableHeader(TableLayout table, boolean isLive) {
        TableRow header = new TableRow(this);
        header.setBackgroundColor(Color.parseColor("#27272A"));
        String[] cols = isLive ? new String[]{"IP", "Sent", "Avg", "Min", "Max", "Jitter", "Loss", "Status"} : new String[]{"#", "IP", "Sent", "Avg", "Min", "Max", "Jitter", "Loss"};
        for (String c : cols) {
            TextView tv = new TextView(this);
            tv.setText(c); tv.setTextColor(Color.parseColor("#38BDF8"));
            tv.setPadding(10, 10, 10, 10); tv.setGravity(Gravity.CENTER);
            tv.setTypeface(null, Typeface.BOLD); tv.setTextSize(11f);
            header.addView(tv);
        }
        table.addView(header);
    }

    private void addTableRow(TableLayout table, ScanResult res, int rank, boolean isLive) {
        TableRow row = new TableRow(this);
        row.setBackgroundColor(rank % 2 == 0 ? Color.parseColor("#09090B") : Color.parseColor("#18181B"));
        
        String[] vals = {
            String.valueOf(rank), res.ip, String.valueOf(res.pktsSent),
            String.format(Locale.US, "%.1f", res.avg), String.format(Locale.US, "%.1f", res.min),
            String.format(Locale.US, "%.1f", res.max), String.format(Locale.US, "%.1f", res.jitter),
            String.format(Locale.US, "%.0f%%", res.loss)
        };

        for (int i = 0; i < vals.length; i++) {
            TextView tv = new TextView(this);
            tv.setText(vals[i]); tv.setPadding(10, 10, 10, 10); tv.setGravity(Gravity.CENTER); tv.setTextSize(11f);
            tv.setTextColor(res.loss >= 100 ? Color.parseColor("#EF4444") : Color.WHITE);
            row.addView(tv);
        }
        table.addView(row);
    }

    private List<String> parseIPList(String input) {
        List<String> list = new ArrayList<>();
        for (String line : input.split("\n")) {
            line = line.trim();
            if (line.contains("-")) {
                String[] parts = line.split("-");
                if (parts.length == 2) {
                    long start = ipToLong(parts[0].trim()), end = ipToLong(parts[1].trim());
                    if (start > 0 && end >= start) { for (long i = start; i <= end; i++) list.add(longToIP(i)); }
                }
            } else if (!line.isEmpty()) list.add(line);
        }
        return list;
    }

    private long ipToLong(String ip) {
        try {
            String[] parts = ip.split("\\."); long res = 0;
            for (int i = 0; i < 4; i++) res |= (Long.parseLong(parts[i]) << (24 - (8 * i)));
            return res;
        } catch (Exception e) { return -1; }
    }
    private String longToIP(long ip) { return ((ip >> 24) & 0xFF) + "." + ((ip >> 16) & 0xFF) + "." + ((ip >> 8) & 0xFF) + "." + (ip & 0xFF); }
    private int parseNum(EditText et, int def) { try { return Integer.parseInt(et.getText().toString().trim()); } catch (Exception e) { return def; } }

    private static class ScanResult {
        String ip; int pktsSent; float avg, min, max, jitter, loss;
        ScanResult(String ip, int pktsSent, float avg, float min, float max, float jitter, float loss) {
            this.ip = ip; this.pktsSent = pktsSent; this.avg = avg; this.min = min; this.max = max; this.jitter = jitter; this.loss = loss;
        }
    }
}
