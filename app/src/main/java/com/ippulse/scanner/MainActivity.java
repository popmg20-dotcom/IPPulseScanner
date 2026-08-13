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

    private EditText ipInput, packetInput, intervalInput, timeoutInput;
    private Button btnStart, btnStop;
    private TextView statusText;
    private TableLayout resultTable;

    private ExecutorService executor;
    private volatile boolean isStopped = false;
    private int totalIPs = 0;
    private int scannedCount = 0;
    private List<ScanResult> allResults = new ArrayList<>();

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

        btnStart.setOnClickListener(v -> startScanning());
        btnStop.setOnClickListener(v -> stopScanning());
    }

    private void startScanning() {
        String inputStr = ipInput.getText().toString().trim();
        if (inputStr.isEmpty()) return;

        List<String> ipList = parseIPList(inputStr);
        if (ipList.isEmpty()) return;

        int packets = parseNumber(packetInput, 300);
        int interval = parseNumber(intervalInput, 1);
        int timeout = parseNumber(timeoutInput, 1000);

        isStopped = false;
        btnStart.setEnabled(false);
        btnStop.setEnabled(true);
        resultTable.removeAllViews();
        addTableHeader();
        allResults.clear();

        totalIPs = ipList.size();
        scannedCount = 0;
        statusText.setText("در حال اسکن... 0 / " + totalIPs);

        // استفاده از ۲۰ رشته همزمان برای سرعت وحشتناک اسکن
        executor = Executors.newFixedThreadPool(20);

        final int fPackets = packets;
        final int fInterval = interval;
        final int fTimeout = timeout;

        new Thread(() -> {
            for (String ip : ipList) {
                if (isStopped) break;
                executor.submit(() -> {
                    if (isStopped) return;
                    ScanResult res = runCustomEngine(ip, fPackets, fInterval, fTimeout);
                    runOnUiThread(() -> {
                        if (!isStopped && res != null) {
                            allResults.add(res);
                            scannedCount++;
                            statusText.setText("اسکن شده: " + scannedCount + " / " + totalIPs);
                            
                            // نمایش لایو در انتهای لیست هنگام اسکن
                            addTableRow(res, allResults.size(), false);

                            if (scannedCount >= totalIPs) {
                                finishScanning();
                            }
                        }
                    });
                });
            }
        }).start();
    }

    private void stopScanning() {
        isStopped = true;
        if (executor != null) executor.shutdownNow();
        finishScanning();
    }

    private void finishScanning() {
        runOnUiThread(() -> {
            btnStart.setEnabled(true);
            btnStop.setEnabled(false);
            
            if (allResults.isEmpty()) {
                statusText.setText("متوقف شد.");
                return;
            }
            
            statusText.setText("در حال مرتب‌سازی و رتبه‌بندی نتایج...");

            // سورت کردن فوق‌دقیق: اول پکت‌لاس، بعد پینگ، بعد جیتر
            Collections.sort(allResults, (a, b) -> {
                if (a.loss != b.loss) return Float.compare(a.loss, b.loss);
                if (a.avg != b.avg) return Float.compare(a.avg, b.avg);
                return Float.compare(a.jitter, b.jitter);
            });

            resultTable.removeAllViews();
            addTableHeader();
            
            // بازسازی جدول با هایلایت 55 برنده برتر
            for (int i = 0; i < allResults.size(); i++) {
                boolean isWinner = i < 55 && allResults.get(i).loss < 100;
                addTableRow(allResults.get(i), i + 1, isWinner);
            }

            statusText.setText("لیدربورد کامل شد! (۵۵ آی‌پی برتر مشخص شدند)");
        });
    }

    // موتور کاستوم برای دور زدن لیمیت روت و اعمال دقیق Interval
    private ScanResult runCustomEngine(String ip, int packets, int intervalMs, int timeoutMs) {
        List<Float> rttList = new ArrayList<>();
        int lost = 0;

        for (int i = 0; i < packets; i++) {
            if (isStopped) break;
            try {
                Process proc = Runtime.getRuntime().exec("ping -c 1 -W 1 " + ip);
                BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                String line;
                float rtt = -1;
                
                while ((line = reader.readLine()) != null) {
                    if (line.contains("time=")) {
                        String timeStr = line.substring(line.indexOf("time=") + 5).replace(" ms", "").trim();
                        String[] parts = timeStr.split(" ");
                        rtt = Float.parseFloat(parts[0]);
                        break;
                    }
                }
                proc.waitFor();

                if (rtt != -1) {
                    rttList.add(rtt);
                } else {
                    lost++;
                }

                // توقف دقیق میلی‌ثانیه‌ای (بدون کرش کردن پروسه پینگ)
                if (intervalMs > 0 && i < packets - 1) {
                    Thread.sleep(intervalMs);
                }
            } catch (Exception e) {
                lost++;
            }
        }

        if (rttList.isEmpty()) {
            return new ScanResult(ip, 0, 0, 0, 0, 100f);
        }

        float min = Collections.min(rttList);
        float max = Collections.max(rttList);
        float sum = 0;
        for (float f : rttList) sum += f;
        float avg = sum / rttList.size();

        float jitter = 0;
        if (rttList.size() > 1) {
            float jSum = 0;
            for (int i = 1; i < rttList.size(); i++) {
                jSum += Math.abs(rttList.get(i) - rttList.get(i - 1));
            }
            jitter = jSum / (rttList.size() - 1);
        }

        float lossPct = (lost / (float) packets) * 100f;
        return new ScanResult(ip, avg, min, max, jitter, lossPct);
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
            long result = 0;
            for (int i = 0; i < 4; i++) {
                result |= (Long.parseLong(parts[i]) << (24 - (8 * i)));
            }
            return result;
        } catch (Exception e) {
            return -1;
        }
    }

    private String longToIP(long ip) {
        return ((ip >> 24) & 0xFF) + "." + ((ip >> 16) & 0xFF) + "." + ((ip >> 8) & 0xFF) + "." + (ip & 0xFF);
    }

    private int parseNumber(EditText et, int def) {
        try {
            return Integer.parseInt(et.getText().toString().trim());
        } catch (Exception e) {
            return def;
        }
    }

    private void addTableHeader() {
        TableRow header = new TableRow(this);
        header.setBackgroundColor(Color.parseColor("#334155"));
        header.setPadding(4, 8, 4, 8);

        String[] cols = {"IP Address", "Avg", "Min", "Max", "Jitter", "Loss"};
        for (String col : cols) {
            TextView tv = createCell(col, true, Color.parseColor("#38BDF8"));
            header.addView(tv);
        }
        resultTable.addView(header);
    }

    private void addTableRow(ScanResult res, int rank, boolean isWinner) {
        TableRow row = new TableRow(this);
        row.setPadding(4, 6, 4, 6);

        // رنگ‌بندی طلایی برای 55 نفر اول
        if (isWinner) {
            row.setBackgroundColor(Color.parseColor("#451A03")); 
        } else {
            row.setBackgroundColor(Color.parseColor("#1E293B"));
        }

        int pingColor = res.loss == 100 ? Color.parseColor("#EF4444") : (res.avg < 80 ? Color.parseColor("#4ADE80") : Color.parseColor("#FACC15"));

        String ipText = rank + ". " + res.ip;
        row.addView(createCell(ipText, false, isWinner ? Color.parseColor("#FBBF24") : Color.parseColor("#F8FAFC")));
        row.addView(createCell(String.format(Locale.US, "%.1f", res.avg), false, pingColor));
        row.addView(createCell(String.format(Locale.US, "%.1f", res.min), false, Color.parseColor("#94A3B8")));
        row.addView(createCell(String.format(Locale.US, "%.1f", res.max), false, Color.parseColor("#94A3B8")));
        row.addView(createCell(String.format(Locale.US, "%.1f", res.jitter), false, Color.parseColor("#38BDF8")));
        row.addView(createCell(String.format(Locale.US, "%.0f%%", res.loss), false, res.loss > 0 ? Color.parseColor("#EF4444") : Color.parseColor("#4ADE80")));

        resultTable.addView(row);
    }

    private TextView createCell(String text, boolean isHeader, int textColor) {
        TextView tv = new TextView(this);
        tv.setText(text);
        tv.setTextColor(textColor);
        tv.setPadding(16, 8, 16, 8);
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(isHeader ? 12 : 11);
        if (isHeader) tv.setTypeface(null, Typeface.BOLD);
        return tv;
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
