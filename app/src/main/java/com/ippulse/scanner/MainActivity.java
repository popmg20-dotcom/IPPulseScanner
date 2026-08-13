package com.ippulse.scanner;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.*;
import android.app.Activity;

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
        if (inputStr.isEmpty()) {
            Toast.makeText(this, "لطفاً آی‌پی یا رنج وارد کنید", Toast.LENGTH_SHORT).show();
            return;
        }

        List<String> ipList = parseIPList(inputStr);
        if (ipList.isEmpty()) {
            Toast.makeText(this, "فرمت آی‌پی نامعتبر است", Toast.LENGTH_SHORT).show();
            return;
        }

        int packets = parseNumber(packetInput, 300);
        int interval = parseNumber(intervalInput, 1);
        int timeout = parseNumber(timeoutInput, 1000);

        isStopped = false;
        btnStart.setEnabled(false);
        btnStop.setEnabled(true);
        resultTable.removeAllViews();
        addTableHeader();

        totalIPs = ipList.size();
        scannedCount = 0;
        statusText.setText("در حال اسکن... 0 / " + totalIPs);

        executor = Executors.newFixedThreadPool(10);

        final int fPackets = packets;
        final int fInterval = interval;
        final int fTimeout = timeout;

        new Thread(() -> {
            for (String ip : ipList) {
                if (isStopped) break;
                executor.submit(() -> {
                    if (isStopped) return;
                    ScanResult res = pingIP(ip, fPackets, fInterval, fTimeout);
                    runOnUiThread(() -> {
                        if (!isStopped && res != null) {
                            addTableRow(res);
                            scannedCount++;
                            statusText.setText("اسکن شده: " + scannedCount + " / " + totalIPs);
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
            statusText.setText("اسکن کامل شد (" + scannedCount + " آی‌پی)");
        });
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
        return ((ip >> 24) & 0xFF) + "." +
               ((ip >> 16) & 0xFF) + "." +
               ((ip >> 8) & 0xFF) + "." +
               (ip & 0xFF);
    }

    private int parseNumber(EditText et, int def) {
        try {
            return Integer.parseInt(et.getText().toString().trim());
        } catch (Exception e) {
            return def;
        }
    }

    private ScanResult pingIP(String ip, int packets, int intervalMs, int timeoutMs) {
        try {
            float secInterval = intervalMs / 1000.0f;
            float secTimeout = timeoutMs / 1000.0f;

            Process proc = Runtime.getRuntime().exec(
                String.format(Locale.US, "ping -c %d -i %.3f -W %.3f %s", packets, secInterval, secTimeout, ip)
            );

            BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line;
            float loss = 100f, min = 0, avg = 0, max = 0, jitter = 0;

            while ((line = reader.readLine()) != null) {
                if (line.contains("packet loss")) {
                    String[] parts = line.split(",");
                    for (String p : parts) {
                        if (p.contains("packet loss")) {
                            String lStr = p.replace("% packet loss", "").trim();
                            loss = Float.parseFloat(lStr.substring(lStr.lastIndexOf(" ") + 1));
                        }
                    }
                } else if (line.contains("rtt min/avg/max/mdev") || line.contains("round-trip")) {
                    String stats = line.split("=")[1].trim().split(" ")[0];
                    String[] val = stats.split("/");
                    min = Float.parseFloat(val[0]);
                    avg = Float.parseFloat(val[1]);
                    max = Float.parseFloat(val[2]);
                    jitter = Float.parseFloat(val[3]);
                }
            }
            proc.waitFor();
            return new ScanResult(ip, avg, min, max, jitter, loss);
        } catch (Exception e) {
            return new ScanResult(ip, 0, 0, 0, 0, 100f);
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

    private void addTableRow(ScanResult res) {
        TableRow row = new TableRow(this);
        row.setPadding(4, 6, 4, 6);
        row.setBackgroundColor(Color.parseColor("#1E293B"));

        int pingColor = res.loss == 100 ? Color.parseColor("#EF4444") : (res.avg < 80 ? Color.parseColor("#4ADE80") : Color.parseColor("#FACC15"));

        row.addView(createCell(res.ip, false, Color.parseColor("#F8FAFC")));
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
