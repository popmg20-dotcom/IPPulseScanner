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
    private EditText ipInput, t1Packets, t1Interval, t1Timeout, t2Packets, t2Interval, t2Timeout;
    private Button btnTab1, btnTab2, btnStart1, btnStart2;
    private View tab1, tab2;
    private TextView t1Status, t2Status;
    private TableLayout t1Table, t2Table;
    
    private ExecutorService executor;
    private List<ScanResult> allResults = new ArrayList<>();
    private List<String> top5IPs = new ArrayList<>();
    private volatile boolean isCancelled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ipInput = findViewById(R.id.ipInput);
        t1Packets = findViewById(R.id.t1Packets);
        t1Interval = findViewById(R.id.t1Interval);
        t1Timeout = findViewById(R.id.t1Timeout);
        t2Packets = findViewById(R.id.t2Packets);
        t2Interval = findViewById(R.id.t2Interval);
        t2Timeout = findViewById(R.id.t2Timeout);
        
        btnTab1 = findViewById(R.id.btnTab1);
        btnTab2 = findViewById(R.id.btnTab2);
        btnStart1 = findViewById(R.id.btnStart1);
        btnStart2 = findViewById(R.id.btnStart2);
        
        tab1 = findViewById(R.id.tab1);
        tab2 = findViewById(R.id.tab2);
        t1Status = findViewById(R.id.t1Status);
        t2Status = findViewById(R.id.t2Status);
        t1Table = findViewById(R.id.t1Table);
        t2Table = findViewById(R.id.t2Table);

        btnTab1.setOnClickListener(v -> { 
            tab1.setVisibility(View.VISIBLE); tab2.setVisibility(View.GONE); 
            btnTab1.setBackgroundColor(Color.parseColor("#334155"));
            btnTab2.setBackgroundColor(Color.parseColor("#1E293B"));
        });
        btnTab2.setOnClickListener(v -> { 
            tab1.setVisibility(View.GONE); tab2.setVisibility(View.VISIBLE); 
            btnTab2.setBackgroundColor(Color.parseColor("#334155"));
            btnTab1.setBackgroundColor(Color.parseColor("#1E293B"));
        });
        
        btnStart1.setOnClickListener(v -> startRangeScan());
        btnStart2.setOnClickListener(v -> startDeepTest());
    }

    private void startRangeScan() {
        String query = ipInput.getText().toString().trim();
        List<String> ips = parseIPList(query);
        if (ips.isEmpty()) { Toast.makeText(this, "رنج نامعتبر", Toast.LENGTH_SHORT).show(); return; }

        int packets = parseNum(t1Packets, 50);
        int interval = parseNum(t1Interval, 1);
        int timeout = parseNum(t1Timeout, 1000);

        allResults.clear();
        t1Table.removeAllViews();
        addTableHeader(t1Table);
        btnStart1.setEnabled(false);

        executor = Executors.newFixedThreadPool(15);
        int total = ips.size();
        final int[] completed = {0};

        t1Status.setText("در حال اسکن " + total + " آی‌پی...");

        for (String ip : ips) {
            executor.execute(() -> {
                ScanResult res = performRealPing(ip, packets, interval, timeout);
                synchronized(allResults) { allResults.add(res); completed[0]++; }
                runOnUiThread(() -> {
                    t1Status.setText("پیشرفت: " + completed[0] + " / " + total);
                    if (completed[0] >= total) finishRangeScan();
                });
            });
        }
    }

    private void finishRangeScan() {
        Collections.sort(allResults, (a, b) -> {
            if (a.loss != b.loss) return Float.compare(a.loss, b.loss);
            if (Math.abs(a.jitter - b.jitter) > 0.2f) return Float.compare(a.jitter, b.jitter);
            return Float.compare(a.avg, b.avg);
        });

        int rank = 1;
        top5IPs.clear();
        for (ScanResult res : allResults) {
            addTableRow(t1Table, res, rank);
            if (res.loss < 100f && top5IPs.size() < 5) top5IPs.add(res.ip);
            rank++;
        }
        btnStart1.setEnabled(true);
        t1Status.setText("پایان اسکن. " + top5IPs.size() + " آی‌پی برتر به تب دوم منتقل شد.");
    }

    private void startDeepTest() {
        if (top5IPs.isEmpty()) { Toast.makeText(this, "رنج قبلی آی‌پی سالمی نداشت!", Toast.LENGTH_SHORT).show(); return; }
        
        int packets = parseNum(t2Packets, 300);
        int interval = parseNum(t2Interval, 1);
        int timeout = parseNum(t2Timeout, 500);

        t2Table.removeAllViews();
        addTableHeader(t2Table);
        btnStart2.setEnabled(false);
        t2Status.setText("تست تخصصی و دقیق در حال انجام...");

        new Thread(() -> {
            List<ScanResult> deepResults = new ArrayList<>();
            for (String ip : top5IPs) {
                deepResults.add(performRealPing(ip, packets, interval, timeout));
            }
            runOnUiThread(() -> {
                for (int i = 0; i < deepResults.size(); i++) {
                    addTableRow(t2Table, deepResults.get(i), i + 1);
                }
                btnStart2.setEnabled(true);
                t2Status.setText("تست تخصصی با دقت ۱۰۰٪ سیستم عامل کامل شد.");
            });
        }).start();
    }

    private ScanResult performRealPing(String ip, int totalPackets, int intervalMs, int timeoutMs) {
        List<Float> rttList = new ArrayList<>();
        int lost = 0;
        int consecutiveLost = 0;
        int timeoutSec = Math.max(1, timeoutMs / 1000);

        for (int i = 0; i < totalPackets; i++) {
            try {
                // استفاده از پینگ نیتیو لینوکس اندروید برای دقت ۱۰۰ درصد گیمینگ
                Process p = Runtime.getRuntime().exec("ping -c 1 -W " + timeoutSec + " " + ip);
                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                float rtt = -1f;
                while ((line = reader.readLine()) != null) {
                    if (line.contains("time=")) {
                        String sub = line.substring(line.indexOf("time=") + 5);
                        rtt = Float.parseFloat(sub.split(" ")[0].trim());
                        break;
                    }
                }
                p.waitFor();

                if (rtt >= 0) {
                    rttList.add(rtt);
                    consecutiveLost = 0; // ریست کردن شمارنده مرده
                } else {
                    lost++;
                    consecutiveLost++;
                    if (consecutiveLost >= 3) {
                        // دقیقاً خواسته شما: بعد از 3 پکت مرده رها شود
                        lost = totalPackets; 
                        break;
                    }
                }
                if (intervalMs > 0 && i < totalPackets - 1) Thread.sleep(intervalMs);
            } catch (Exception e) {
                lost = totalPackets;
                break;
            }
        }

        float lossPct = ((float) lost / totalPackets) * 100f;
        if (rttList.isEmpty()) return new ScanResult(ip, "💀", 999f, 999f, 999f, 999f, 100f);

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

    private String fetchFlag(String ip) {
        try {
            // دریافت پرچم دقیقاً از api با پشتیبانی ترافیک کلیرتکست
            URL url = new URL("http://ip-api.com/json/" + ip + "?fields=countryCode");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(2000);
            conn.setReadTimeout(2000);
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

    private void addTableHeader(TableLayout table) {
        TableRow header = new TableRow(this);
        header.setBackgroundColor(Color.parseColor("#334155"));
        String[] cols = {"#", "آی‌پی/پرچم", "میانگین", "لرزش", "مینیمم", "حداکثر", "پکت‌لاس"};
        for (String c : cols) {
            TextView tv = new TextView(this);
            tv.setText(c); tv.setTextColor(Color.parseColor("#38BDF8"));
            tv.setPadding(12, 12, 12, 12); tv.setGravity(Gravity.CENTER);
            tv.setTypeface(null, Typeface.BOLD); tv.setTextSize(12);
            header.addView(tv);
        }
        table.addView(header);
    }

    private void addTableRow(TableLayout table, ScanResult res, int rank) {
        TableRow row = new TableRow(this);
        row.setBackgroundColor(rank % 2 == 0 ? Color.parseColor("#0F172A") : Color.parseColor("#1E293B"));
        
        row.setOnClickListener(v -> {
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            clipboard.setPrimaryClip(ClipData.newPlainText("IP", res.ip));
            Toast.makeText(this, "آی‌پی کپی شد: " + res.ip, Toast.LENGTH_SHORT).show();
        });

        String[] vals = {
            String.valueOf(rank), res.flag + " " + res.ip, 
            String.format(Locale.US, "%.1f", res.avg), String.format(Locale.US, "%.1f", res.jitter),
            String.format(Locale.US, "%.1f", res.min), String.format(Locale.US, "%.1f", res.max),
            String.format(Locale.US, "%.0f%%", res.loss)
        };

        for (int i = 0; i < vals.length; i++) {
            TextView tv = new TextView(this);
            tv.setText(vals[i]);
            tv.setTextColor(res.loss >= 100 ? Color.parseColor("#F87171") : Color.WHITE);
            if (i == 1 && rank <= 5) tv.setTextColor(Color.parseColor("#FBBF24"));
            tv.setPadding(12, 12, 12, 12); tv.setGravity(Gravity.CENTER); tv.setTextSize(12);
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
