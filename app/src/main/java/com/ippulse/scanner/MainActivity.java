package com.ippulse.scanner;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.*;
import org.json.JSONObject;

public class MainActivity extends Activity {
    private EditText ipInput, packetInput, intervalInput, timeoutInput;
    private Button btnStart, btnStop;
    private TextView statusText;
    private TableLayout resultTable, top5Table;
    private LinearLayout topListLayout, historyContainer;
    private ScrollView logScrollView;
    
    private ExecutorService executor;
    private volatile boolean isCancelled = false;
    private List<ScanResult> allResults = new ArrayList<>();
    private List<String> searchHistory = new ArrayList<>();
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
        top5Table = findViewById(R.id.top5Table);
        topListLayout = findViewById(R.id.topListLayout);
        historyContainer = findViewById(R.id.historyContainer);
        logScrollView = findViewById(R.id.logScrollView);

        btnStart.setOnClickListener(v -> startScanning());
        btnStop.setOnClickListener(v -> stopScanning());
    }

    private void updateHistoryUI() {
        historyContainer.removeAllViews();
        for (String item : searchHistory) {
            LinearLayout chip = new LinearLayout(this);
            chip.setOrientation(LinearLayout.HORIZONTAL);
            chip.setBackgroundColor(Color.parseColor("#334155"));
            chip.setPadding(8, 4, 8, 4);
            chip.setGravity(Gravity.CENTER_VERTICAL);

            TextView tv = new TextView(this);
            tv.setText(item);
            tv.setTextColor(Color.parseColor("#F8FAFC"));
            tv.setTextSize(11);
            tv.setPadding(4, 2, 8, 2);
            tv.setOnClickListener(v -> ipInput.setText(item));

            Button delBtn = new Button(this);
            delBtn.setText("✕");
            delBtn.setTextSize(10);
            delBtn.setTextColor(Color.parseColor("#F87171"));
            delBtn.setBackgroundColor(Color.TRANSPARENT);
            delBtn.setMinWidth(0);
            delBtn.setMinHeight(0);
            delBtn.setMinimumWidth(0);
            delBtn.setMinimumHeight(0);
            delBtn.setPadding(4, 2, 4, 2);
            delBtn.setOnClickListener(v -> {
                searchHistory.remove(item);
                updateHistoryUI();
            });

            chip.addView(tv);
            chip.addView(delBtn);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(4, 2, 4, 2);
            chip.setLayoutParams(params);

            historyContainer.addView(chip);
        }
    }

    private void startScanning() {
        String inputStr = ipInput.getText().toString().trim();
        if (inputStr.isEmpty()) {
            Toast.makeText(this, "لطفاً آی‌پی یا رنج وارد کنید", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!searchHistory.contains(inputStr)) {
            searchHistory.add(inputStr);
            updateHistoryUI();
        }

        List<String> ipList = parseIPList(inputStr);
        if (ipList.isEmpty()) {
            Toast.makeText(this, "فرمت آی‌پی نامعتبر است", Toast.LENGTH_SHORT).show();
            return;
        }

        int packets = parseNum(packetInput, 100);
        int interval = parseNum(intervalInput, 1);
        int timeout = parseNum(timeoutInput, 1000);

        isCancelled = false;
        btnStart.setEnabled(false);
        btnStop.setEnabled(true);
        allResults.clear();
        resultTable.removeAllViews();
        top5Table.removeAllViews();
        if (topListLayout != null) topListLayout.removeAllViews();

        totalIPs = ipList.size();
        completedIPs = 0;
        statusText.setText("شروع اسکن همزمان رنج... 0 / " + totalIPs);

        executor = Executors.newCachedThreadPool();

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
                    statusText.setText("در حال پردازش: " + completedIPs + " / " + totalIPs);
                    if (topListLayout != null) {
                        TextView logTv = new TextView(MainActivity.this);
                        logTv.setText(String.format(Locale.US, "IP: %s | Packets: %d/%d | Avg: %.1fms | Loss: %.0f%%", 
                                result.ip, result.testedPackets, packets, result.avg, result.loss));
                        logTv.setTextColor(result.loss < 50f ? Color.parseColor("#34D399") : Color.parseColor("#F87171"));
                        logTv.setTextSize(11);
                        topListLayout.addView(logTv);
                        logScrollView.post(() -> logScrollView.fullScroll(View.FOCUS_DOWN));
                    }
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
        int currentTested = 0;

        for (int i = 0; i < totalPackets; i++) {
            if (isCancelled) break;
            currentTested++;
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

                if (i == 19 && rttList.isEmpty() && totalPackets > 20) {
                    lost = totalPackets;
                    break;
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
            return new ScanResult(ip, "Unknown", "🌐", 999f, 999f, 999f, 999f, 100f, currentTested);
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

        String country = "Unknown";
        String flag = "🌐";
        try {
            URL url = new URL("http://ip-api.com/json/" + ip + "?fields=country,countryCode");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(1200);
            conn.setReadTimeout(1200);
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) sb.append(line);
            JSONObject obj = new JSONObject(sb.toString());
            country = obj.optString("country", "Unknown");
            String code = obj.optString("countryCode", "").toUpperCase();
            if (code.length() == 2) {
                int first = Character.codePointAt(code, 0) - 0x41 + 0x1F1E6;
                int second = Character.codePointAt(code, 1) - 0x41 + 0x1F1E6;
                flag = new String(Character.toChars(first)) + new String(Character.toChars(second));
            }
        } catch (Exception ignored) {}

        return new ScanResult(ip, country, flag, avg, min, max, jitter, lossPct, currentTested);
    }

    private void finishScanning() {
        btnStart.setEnabled(true);
        btnStop.setEnabled(false);
        statusText.setText("اسکن رنج کامل شد! در حال اجرای تست تخصصی ۵ آی‌پی برتر...");

        Collections.sort(allResults, new Comparator<ScanResult>() {
            @Override
            public int compare(ScanResult a, ScanResult b) {
                if (a.loss >= 99f && b.loss < 99f) return 1;
                if (b.loss >= 99f && a.loss < 99f) return -1;

                if (a.loss != b.loss) return Float.compare(a.loss, b.loss);
                if (Math.abs(a.jitter - b.jitter) > 0.2f) return Float.compare(a.jitter, b.jitter);
                return Float.compare(a.avg, b.avg);
            }
        });

        // نمایش جدول کل نتایج
        resultTable.removeAllViews();
        addTableHeader(resultTable, true);
        int rank = 1;
        List<ScanResult> validResults = new ArrayList<>();
        for (ScanResult res : allResults) {
            if (res.loss < 99f) {
                validResults.add(res);
                addTableRow(resultTable, res, rank++);
            }
        }

        // مرحله دوم: تست تخصصی و فوق‌العاده دقیق ۵ آی‌پی برتر با پکت بالاتر
        new Thread(() -> {
            List<ScanResult> top5Deep = new ArrayList<>();
            int count = Math.min(5, validResults.size());
            for (int i = 0; i < count; i++) {
                ScanResult best = validResults.get(i);
                // تست تخصصی با ۳۰۰ پکت برای دقت نهایت گیمینگ
                ScanResult deepRes = benchmarkIP(best.ip, 300, 1, 1000);
                top5Deep.add(deepRes);
            }

            runOnUiThread(() -> {
                top5Table.removeAllViews();
                addTableHeader(top5Table, false);
                for (int i = 0; i < top5Deep.size(); i++) {
                    addTableRow(top5Table, top5Deep.get(i), i + 1);
                }
                statusText.setText("تست تخصصی ۵ آی‌پی برتر گیمینگ با موفقیت انجام شد.");
            });
        }).start();
    }

    private void addTableHeader(TableLayout table, bool isRange) {
        TableRow header = new TableRow(this);
        header.setBackgroundColor(Color.parseColor("#334155"));
        String[] cols = {"#", "IP / Country", "Avg", "Min", "Max", "Jitter", "Loss"};
        for (String c : cols) {
            TextView tv = new TextView(this);
            tv.setText(c);
            tv.setTextColor(Color.parseColor("#38BDF8"));
            tv.setPadding(8, 8, 8, 8);
            tv.setGravity(Gravity.CENTER);
            tv.setTypeface(null, Typeface.BOLD);
            tv.setTextSize(11);
            header.addView(tv);
        }
        table.addView(header);
    }
    
    // نسخه سازگار متد هدر
    private void addTableHeader(TableLayout table, boolean isMain) {
        addTableHeader(table, (bool) true);
    }

    private void addTableRow(TableLayout table, ScanResult res, int rank) {
        TableRow row = new TableRow(this);
        row.setBackgroundColor(rank <= 5 ? Color.parseColor("#332200") : Color.parseColor("#1E293B"));
        
        row.setOnClickListener(v -> {
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("IP Address", res.ip);
            clipboard.setPrimaryClip(clip);
            Toast.makeText(MainActivity.this, "آی‌پی کپی شد: " + res.ip, Toast.LENGTH_SHORT).show();
        });
        
        String[] vals = {
            String.valueOf(rank),
            res.flag + " " + res.ip,
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
            tv.setPadding(8, 8, 8, 8);
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(11);
            row.addView(tv);
        }
        table.addView(row);
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
        String ip, country, flag;
        float avg, min, max, jitter, loss;
        int testedPackets;
        ScanResult(String ip, String country, String flag, float avg, float min, float max, float jitter, float loss, int testedPackets) {
            this.ip = ip;
            this.country = country;
            this.flag = flag;
            this.avg = avg;
            this.min = min;
            this.max = max;
            this.jitter = jitter;
            this.loss = loss;
            this.testedPackets = testedPackets;
        }
    }
}
