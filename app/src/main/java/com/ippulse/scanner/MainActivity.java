package com.ippulse.scanner;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.*;

public class MainActivity extends Activity {
    private EditText ipInput, packetInput, intervalInput, timeoutInput;
    private Button btnStart, btnStop;
    private TextView statusText;
    private TableLayout resultTable;
    private LinearLayout topListLayout;
    
    private ExecutorService executor;
    private volatile boolean isCancelled = false;
    private List<ScanResult> allResults = new ArrayList<>();
    private int totalIPs = 0;
    private int completedIPs = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ipInput = findViewById(R.id.ipInput);
        packetInput = findViewById(R.id.packetInput);
        intervalInput = findViewById(R.id.intervalInput);
        timeoutInput = findViewById(R.id.timeoutInput);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        statusText = findViewById(R.id.statusText);
        resultTable = findViewById(R.id.resultTable);
        topListLayout = findViewById(R.id.topListLayout);

        btnStart.setOnClickListener(v -> startScanning());
        btnStop.setOnClickListener(v -> stopScanning());
    }

    private void startScanning() {
        String inputStr = ipInput.getText().toString().trim();
        if (inputStr.isEmpty()) {
            Toast.makeText(this, "لطفاً آی‌پی یا رنج وارد کنید", Toast.LENGTH_SHORT).show();
            return;
        }

        List<String> ipList = parseIPList(inputStr);
        if (ipList.isEmpty()) {
            Toast.makeText(this, "فرمت آی‌پی نامعتبر است", Toast.LENGTH_SHORT).show();
            return;
        }

        int packets = parseNum(packetInput, 200);
        int interval = parseNum(intervalInput, 200);
        int timeout = parseNum(timeoutInput, 1000);

        isCancelled = false;
        btnStart.setEnabled(false);
        btnStop.setEnabled(true);
        allResults.clear();
        resultTable.removeAllViews();
        if (topListLayout != null) topListLayout.removeAllViews();

        totalIPs = ipList.size();
        completedIPs = 0;
        statusText.setText("در حال اسکن... 0 / " + totalIPs);

        executor = Executors.newFixedThreadPool(10);

        for (String ip : ipList) {
            if (isCancelled) break;
            executor.execute(() -> {
                if (isCancelled) return;
                ScanResult result = benchmarkIP(ip, packets, interval, timeout);
                synchronized (this) {
                    allResults.add(result);
                    completedIPs++;
                }
                runOnUiThread(() -> {
                    statusText.setText("در حال اسکن... " + completedIPs + " / " + totalIPs);
                    if (completedIPs >= totalIPs) {
                        finishScanning();
                    }
                });
            });
        }
    }

    private ScanResult benchmarkIP(String ip, int totalPackets, int intervalMs, int timeoutMs) {
        List<Float> rttList = new ArrayList<>();
        int lost = 0;
        int timeoutSec = Math.max(1, timeoutMs / 1000);

        for (int i = 0; i < totalPackets; i++) {
            if (isCancelled) break;
            try {
                Process p = Runtime.getRuntime().exec("ping -c 1 -W " + timeoutSec + " " + ip);
                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                float rtt = -1;
                while ((line = reader.readLine()) != null) {
                    if (line.contains("time=")) {
                        int idx = line.indexOf("time=");
                        String sub = line.substring(idx + 5);
                        String valStr = sub.split(" ")[0].replace("ms", "").trim();
                        rtt = Float.parseFloat(valStr);
                        break;
                    }
                }
                p.waitFor();

                if (rtt >= 0) {
                    rttList.add(rtt);
                } else {
                    lost++;
                }

                if (intervalMs > 0 && i < totalPackets - 1) {
                    Thread.sleep(intervalMs);
                }
            } catch (Exception e) {
                lost++;
            }
        }

        float lossPct = ((float) lost / totalPackets) * 100f;
        if (rttList.isEmpty()) {
            return new ScanResult(ip, 999f, 999f, 999f, 999f, 100f);
        }

        float min = Collections.min(rttList);
        float max = Collections.max(rttList);
        float sum = 0;
        for (float v : rttList) sum += v;
        float avg = sum / rttList.size();

        float jitter = 0;
        if (rttList.size() > 1) {
            float jSum = 0;
            for (int j = 1; j < rttList.size(); j++) {
                jSum += Math.abs(rttList.get(j) - rttList.get(j - 1));
            }
            jitter = jSum / (rttList.size() - 1);
        }

        return new ScanResult(ip, avg, min, max, jitter, lossPct);
    }

    private void finishScanning() {
        btnStart.setEnabled(true);
        btnStop.setEnabled(false);
        statusText.setText("اسکن کامل شد! در حال مرتب‌سازی...");

        Collections.sort(allResults, new Comparator<ScanResult>() {
            @Override
            public int compare(ScanResult a, ScanResult b) {
                if (a.loss != b.loss) return Float.compare(a.loss, b.loss);
                if (a.avg != b.avg) return Float.compare(a.avg, b.avg);
                return Float.compare(a.jitter, b.jitter);
            }
        });

        if (topListLayout != null) {
            topListLayout.removeAllViews();
            int topCount = Math.min(5, allResults.size());
            for (int i = 0; i < topCount; i++) {
                ScanResult res = allResults.get(i);
                TextView tv = new TextView(this);
                tv.setText(String.format(Locale.US, "🏆 #%d -> %s | Avg: %.1fms | Jitter: %.1f | Loss: %.0f%%", 
                        (i + 1), res.ip, res.avg, res.jitter, res.loss));
                tv.setTextColor(Color.parseColor("#FBBF24"));
                tv.setTextSize(12);
                tv.setPadding(4, 4, 4, 4);
                topListLayout.addView(tv);
            }
        }

        resultTable.removeAllViews();
        addTableHeader();
        for (int i = 0; i < allResults.size(); i++) {
            addTableRow(allResults.get(i), i + 1);
        }

        statusText.setText("نتایج از بهترین به بدترین مرتب شدند.");
    }

    private void addTableHeader() {
        TableRow header = new TableRow(this);
        header.setBackgroundColor(Color.parseColor("#334155"));
        String[] cols = {"#", "IP Address", "Avg", "Min", "Max", "Jitter", "Loss"};
        for (String c : cols) {
            TextView tv = new TextView(this);
            tv.setText(c);
            tv.setTextColor(Color.parseColor("#38BDF8"));
            tv.setPadding(10, 8, 10, 8);
            tv.setGravity(Gravity.CENTER);
            tv.setTypeface(null, Typeface.BOLD);
            tv.setTextSize(11);
            header.addView(tv);
        }
        resultTable.addView(header);
    }

    private void addTableRow(ScanResult res, int rank) {
        TableRow row = new TableRow(this);
        row.setBackgroundColor(rank <= 5 ? Color.parseColor("#332200") : Color.parseColor("#1E293B"));
        
        String[] vals = {
            String.valueOf(rank),
            res.ip,
            String.format(Locale.US, "%.1f", res.avg),
            String.format(Locale.US, "%.1f", res.min),
            String.format(Locale.US, "%.1f", res.max),
            String.format(Locale.US, "%.1f", res.jitter),
            String.format(Locale.US, "%.0f%%", res.loss)
        };

        for (int i = 0; i < vals.length; i++) {
            TextView tv = new TextView(this);
            tv.setText(vals[i]);
            tv.setTextColor(i == 1 && rank <= 5 ? Color.parseColor("#FBBF24") : Color.parseColor("#F8FAFC"));
            tv.setPadding(10, 8, 10, 8);
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(11);
            row.addView(tv);
        }
        resultTable.addView(row);
    }

    private void stopScanning() {
        isCancelled = true;
        if (executor != null) executor.shutdownNow();
        btnStart.setEnabled(true);
        btnStop.setEnabled(false);
        statusText.setText("عملیات متوقف شد.");
    }

    private List<String> parseIPList(String input) {
        List<String> list = new ArrayList<>();
        String[] lines = input.split("\n");
        for (String line : lines) {
            line = line.trim();
            if (line.contains("-")) {
                String[] parts = line.split("-");
                if (parts.length == 2) {
                    long start = ipToLong(parts[0].trim());
                    long end = ipToLong(parts[1].trim());
                    if (start > 0 && end >= start) {
                        for (long i = start; i <= end; i++) {
                            list.add(longToIP(i));
                        }
                        continue;
                    }
                }
            }
            if (!line.isEmpty()) {
                list.add(line);
            }
        }
        return list;
    }

    private long ipToLong(String ip) {
        try {
            String[] parts = ip.split("\\.");
            long res = 0;
            for (int i = 0; i < 4; i++) {
                res |= (Long.parseLong(parts[i]) << (24 - (8 * i)));
            }
            return res;
        } catch (Exception e) {
            return -1;
        }
    }

    private String longToIP(long ip) {
        return ((ip >> 24) & 0xFF) + "." + ((ip >> 16) & 0xFF) + "." + ((ip >> 8) & 0xFF) + "." + (ip & 0xFF);
    }

    private int parseNum(EditText et, int def) {
        try {
            return Integer.parseInt(et.getText().toString().trim());
        } catch (Exception e) {
            return def;
        }
    }

    private static class ScanResult {
        String ip;
        float avg, min, max, jitter, loss;
        ScanResult(String ip, float avg, float min, float max, float jitter, float loss) {
            this.ip = ip;
            this.avg = avg;
            this.min = min;
            this.max = max;
            this.jitter = jitter;
            this.loss = loss;
        }
    }
}
