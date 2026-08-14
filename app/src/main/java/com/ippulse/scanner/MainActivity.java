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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.*;
import org.json.JSONObject;

public class MainActivity extends Activity {
    private EditText ipInput, inputPackets, inputInterval, inputTimeout;
    private Button btnStart, btnStop;
    private TextView status1, status2;
    private LinearLayout logLayout1, logLayout2;
    private ScrollView logScroll1, logScroll2;
    private TableLayout resultsTable;

    private ExecutorService executor;
    private List<ScanResult> allResults = new ArrayList<>();
    private List<String> top5IPs = new ArrayList<>();
    private volatile boolean isCancelled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ipInput = findViewById(R.id.ipInput);
        inputPackets = findViewById(R.id.inputPackets);
        inputInterval = findViewById(R.id.inputInterval);
        inputTimeout = findViewById(R.id.inputTimeout);

        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);

        status1 = findViewById(R.id.status1);
        status2 = findViewById(R.id.status2);
        logLayout1 = findViewById(R.id.logLayout1);
        logLayout2 = findViewById(R.id.logLayout2);
        logScroll1 = findViewById(R.id.logScroll1);
        logScroll2 = findViewById(R.id.logScroll2);
        resultsTable = findViewById(R.id.resultsTable);

        btnStart.setOnClickListener(v -> startWorkflow());
        btnStop.setOnClickListener(v -> stopWorkflow());
    }

    private void stopWorkflow() {
        isCancelled = true;
        if (executor != null) executor.shutdownNow();
        status1.setText("اسکن متوقف شد.");
        status2.setText("عملیات لغو شد.");
        btnStart.setEnabled(true);
    }

    private void startWorkflow() {
        String query = ipInput.getText().toString().trim();
        List<String> ips = parseIPList(query);
        if (ips.isEmpty()) { Toast.makeText(this, "آی‌پی نامعتبر است!", Toast.LENGTH_SHORT).show(); return; }

        int packets = parseNum(inputPackets, 100);
        int interval = parseNum(inputInterval, 1);
        int timeout = parseNum(inputTimeout, 1000);

        allResults.clear();
        top5IPs.clear();
        resultsTable.removeAllViews();
        logLayout1.removeAllViews();
        logLayout2.removeAllViews();
        addTableHeader();
        btnStart.setEnabled(false);
        isCancelled = false;

        status1.setText("در حال اسکن سریع رنج (" + ips.size() + " آی‌پی)...");
        executor = Executors.newFixedThreadPool(15);
        final int[] completed = {0};

        for (String ip : ips) {
            executor.execute(() -> {
                if (isCancelled) return;
                
                ScanResult res = performRealPingFast(ip, packets, interval, timeout);
                synchronized(allResults) { allResults.add(res); completed[0]++; }

                runOnUiThread(() -> {
                    appendSimpleLog(logLayout1, logScroll1, res);
                    status1.setText("پیشرفت اسکن: " + completed[0] + " از " + ips.size());
                    
                    if (completed[0] >= ips.size() && !isCancelled) {
                        extractTop5AndStartDeepTest(packets, interval, timeout);
                    }
                });
            });
        }
    }

    private void extractTop5AndStartDeepTest(int packets, int interval, int timeout) {
        Collections.sort(allResults, (a, b) -> {
            if (a.loss != b.loss) return Float.compare(a.loss, b.loss);
            if (Math.abs(a.jitter - b.jitter) > 0.2f) return Float.compare(a.jitter, b.jitter);
            return Float.compare(a.avg, b.avg);
        });

        for (ScanResult r : allResults) {
            if (r.loss < 100f && top5IPs.size() < 5) top5IPs.add(r.ip);
        }

        if (top5IPs.isEmpty()) {
            status2.setText("هیچ آی‌پی زنده‌ای برای تست تخصصی یافت نشد!");
            renderFinalTable();
            btnStart.setEnabled(true);
            return;
        }

        status2.setText("اسکن رنج کامل شد! در حال اجرای تست تخصصی ۵ آی‌پی برتر بصورت تکی...");
        
        new Thread(() -> {
            for (int i = 0; i < top5IPs.size(); i++) {
                if (isCancelled) break;
                String currentIP = top5IPs.get(i);
                performDeepPingLive(currentIP, packets, interval, timeout, i + 1);
            }
            
            runOnUiThread(() -> {
                if (!isCancelled) {
                    status2.setText("تست تخصصی با موفقیت به پایان رسید.");
                    renderFinalTable();
                }
                btnStart.setEnabled(true);
            });
        }).start();
    }

    // Fast ping for Range Scan
    private ScanResult performRealPingFast(String ip, int totalPackets, int intervalMs, int timeoutMs) {
        List<Float> rttList = new ArrayList<>();
        int lost = 0;
        int consecutiveLost = 0;
        int timeoutSec = Math.max(1, timeoutMs / 1000);

        for (int i = 0; i < totalPackets; i++) {
            if (isCancelled) break;
            try {
                long startT = System.currentTimeMillis();
                Process p = Runtime.getRuntime().exec("ping -c 1 -W " + timeoutSec + " " + ip);
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
                    if (consecutiveLost >= 3) { lost = totalPackets; break; }
                }
                
                long elapsed = System.currentTimeMillis() - startT;
                long sleepTime = intervalMs - elapsed;
                if (sleepTime > 0) Thread.sleep(sleepTime);
                
            } catch (Exception e) {
                lost = totalPackets;
                break;
            }
        }

        float lossPct = ((float) lost / totalPackets) * 100f;
        if (rttList.isEmpty()) return new ScanResult(ip, fetchFlag(ip), 999f, 999f, 999f, 999f, 100f);

        float min = Collections.min(rttList);
        float max = Collections.max(rttList);
        float sum = 0; for (float v : rttList) sum += v;
        float avg = sum / rttList.size();

        float jitter = 0;
        if (rttList.size() > 1) {
            float jSum = 0;
            for (int j = 1; j < rttList.size(); j++) {
                jSum += Math.abs(rttList.get(j) - rttList.get(j - 1));
            }
            jitter = jSum / (rttList.size() - 1);
        }

        return new ScanResult(ip, fetchFlag(ip), avg, min, max, jitter, lossPct);
    }

    // Deep ping for Top 5 (One by One with Live Packet Tracking)
    private void performDeepPingLive(String ip, int totalPackets, int intervalMs, int timeoutMs, int rank) {
        List<Float> rttList = new ArrayList<>();
        int lost = 0;
        int timeoutSec = Math.max(1, timeoutMs / 1000);
        
        final TextView liveTv = new TextView(this);
        liveTv.setTextSize(11f); // FIX: using float '11f' instead of '11sp'
        liveTv.setTypeface(Typeface.MONOSPACE);
        liveTv.setTextColor(Color.parseColor("#38BDF8"));
        
        runOnUiThread(() -> {
            logLayout2.addView(liveTv);
            logScroll2.post(() -> logScroll2.fullScroll(View.FOCUS_DOWN));
        });

        for (int i = 1; i <= totalPackets; i++) {
            if (isCancelled) break;
            try {
                long startT = System.currentTimeMillis();
                Process p = Runtime.getRuntime().exec("ping -c 1 -W " + timeoutSec + " " + ip);
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
                } else {
                    lost++;
                }

                final int currentPacket = i;
                final float currentAvg = rttList.isEmpty() ? 0 : rttList.get(rttList.size()-1);
                final float currentLoss = ((float) lost / currentPacket) * 100f;
                
                runOnUiThread(() -> {
                    liveTv.setText(String.format(Locale.US, "[Rank %d] IP: %s | Pkts: %d/%d | Cur: %.1fms | Loss: %.0f%%", 
                        rank, ip, currentPacket, totalPackets, currentAvg, currentLoss));
                    if (currentPacket % 5 == 0) { // scroll every 5 packets to save UI thread
                        logScroll2.post(() -> logScroll2.fullScroll(View.FOCUS_DOWN));
                    }
                });

                long elapsed = System.currentTimeMillis() - startT;
                long sleepTime = intervalMs - elapsed;
                if (sleepTime > 0) Thread.sleep(sleepTime);
                
            } catch (Exception ignored) {}
        }
        
        // Update the final result in the list for the table rendering
        float finalLoss = ((float) lost / totalPackets) * 100f;
        if (!rttList.isEmpty()) {
            float min = Collections.min(rttList);
            float max = Collections.max(rttList);
            float sum = 0; for (float v : rttList) sum += v;
            float avg = sum / rttList.size();
            float jitter = 0;
            if (rttList.size() > 1) {
                float jSum = 0;
                for (int j = 1; j < rttList.size(); j++) jSum += Math.abs(rttList.get(j) - rttList.get(j - 1));
                jitter = jSum / (rttList.size() - 1);
            }
            
            // Replace old range scan result with this deep test result
            for (int k = 0; k < allResults.size(); k++) {
                if (allResults.get(k).ip.equals(ip)) {
                    allResults.set(k, new ScanResult(ip, allResults.get(k).flag, avg, min, max, jitter, finalLoss));
                    break;
                }
            }
            
            runOnUiThread(() -> {
                liveTv.setTextColor(Color.parseColor("#10B981"));
                liveTv.setText(String.format(Locale.US, "✅ IP: %s | Final Avg: %.1fms | Loss: %.0f%%", ip, avg, finalLoss));
            });
        }
    }

    private void appendSimpleLog(LinearLayout layout, ScrollView scroll, ScanResult res) {
        TextView tv = new TextView(this);
        tv.setTextSize(11f); // FIX
        tv.setTypeface(Typeface.MONOSPACE);
        if (res.loss >= 100) {
            tv.setText("-> " + res.ip + " | Timeout / Dead");
            tv.setTextColor(Color.parseColor("#EF4444"));
        } else {
            tv.setText(String.format(Locale.US, "-> %s | Avg: %.1fms | Loss: %.0f%%", res.ip, res.avg, res.loss));
            tv.setTextColor(Color.parseColor("#94A3B8"));
        }
        layout.addView(tv);
        scroll.post(() -> scroll.fullScroll(View.FOCUS_DOWN));
    }

    private void renderFinalTable() {
        resultsTable.removeAllViews();
        addTableHeader();
        
        // Sort again after deep test might have changed values
        Collections.sort(allResults, (a, b) -> {
            if (a.loss != b.loss) return Float.compare(a.loss, b.loss);
            if (Math.abs(a.jitter - b.jitter) > 0.2f) return Float.compare(a.jitter, b.jitter);
            return Float.compare(a.avg, b.avg);
        });

        int rank = 1;
        for (ScanResult res : allResults) {
            addTableRow(res, rank);
            rank++;
        }
    }

    private String fetchFlag(String ip) {
        try {
            URL url = new URL("http://ip-api.com/json/" + ip + "?fields=countryCode");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(1500);
            conn.setReadTimeout(1500);
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) sb.append(line);
            JSONObject obj = new JSONObject(sb.toString());
            String code = obj.optString("countryCode", "").toUpperCase();
            if (code.length() == 2) {
                int first = Character.codePointAt(code, 0) - 0x41 + 0x1F1E6;
                int second = Character.codePointAt(code, 1) - 0x41 + 0x1F1E6;
                return new String(Character.toChars(first)) + new String(Character.toChars(second));
            }
        } catch (Exception ignored) {}
        return "🌐";
    }

    private void addTableHeader() {
        TableRow header = new TableRow(this);
        header.setBackgroundColor(Color.parseColor("#334155"));
        String[] cols = {"#", "IP / Country", "Avg", "Min", "Max", "Jitter", "Loss"};
        for (String c : cols) {
            TextView tv = new TextView(this);
            tv.setText(c); tv.setTextColor(Color.parseColor("#38BDF8"));
            tv.setPadding(14, 12, 14, 12); tv.setGravity(Gravity.CENTER);
            tv.setTypeface(null, Typeface.BOLD); tv.setTextSize(12f);
            header.addView(tv);
        }
        resultsTable.addView(header);
    }

    private void addTableRow(ScanResult res, int rank) {
        TableRow row = new TableRow(this);
        row.setBackgroundColor(rank % 2 == 0 ? Color.parseColor("#0F172A") : Color.parseColor("#1E293B"));

        row.setOnClickListener(v -> {
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            clipboard.setPrimaryClip(ClipData.newPlainText("IP", res.ip));
            Toast.makeText(this, "آی‌پی کپی شد: " + res.ip, Toast.LENGTH_SHORT).show();
        });

        String[] vals = {
            String.valueOf(rank), res.flag + " " + res.ip,
            String.format(Locale.US, "%.1f", res.avg), String.format(Locale.US, "%.1f", res.min),
            String.format(Locale.US, "%.1f", res.max), String.format(Locale.US, "%.1f", res.jitter),
            String.format(Locale.US, "%.0f%%", res.loss)
        };

        for (int i = 0; i < vals.length; i++) {
            TextView tv = new TextView(this);
            tv.setText(vals[i]);
            tv.setPadding(14, 12, 14, 12); tv.setGravity(Gravity.CENTER); tv.setTextSize(12f);
            if (rank <= 5) {
                tv.setTextColor(Color.parseColor("#FBBF24")); // Gold for top 5
            } else {
                tv.setTextColor(res.loss >= 100 ? Color.parseColor("#EF4444") : Color.WHITE);
            }
            row.addView(tv);
        }
        resultsTable.addView(row);
    }

    private List<String> parseIPList(String input) {
        List<String> list = new ArrayList<>();
        for (String line : input.split("\n")) {
            line = line.trim();
            if (line.contains("-")) {
                String[] parts = line.split("-");
                if (parts.length == 2) {
                    long start = ipToLong(parts[0].trim()), end = ipToLong(parts[1].trim());
                    if (start > 0 && end >= start) {
                        for (long i = start; i <= end; i++) list.add(longToIP(i));
                    }
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
        String ip, flag; float avg, min, max, jitter, loss;
        ScanResult(String ip, String flag, float avg, float min, float max, float jitter, float loss) {
            this.ip = ip; this.flag = flag; this.avg = avg; this.min = min; this.max = max; this.jitter = jitter; this.loss = loss;
        }
    }
}
