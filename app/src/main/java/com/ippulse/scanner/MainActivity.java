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
    private EditText ipInput, packetInput1, intervalInput1, timeoutInput1, packetInput2, intervalInput2, timeoutInput2;
    private Button btnStart1, btnStart2, tab1Btn, tab2Btn;
    private TextView statusText1, statusText2;
    private TableLayout resultTable, top5Table;
    private LinearLayout logLayout, tab1Container, tab2Container;
    private ScrollView logScrollView;
    
    private ExecutorService executor;
    private List<ScanResult> allResults = new ArrayList<>();
    private List<ScanResult> top5Candidates = new ArrayList<>();
    private volatile boolean isCancelled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ipInput = findViewById(R.id.ipInput);
        packetInput1 = findViewById(R.id.packetInput1);
        intervalInput1 = findViewById(R.id.intervalInput1);
        timeoutInput1 = findViewById(R.id.timeoutInput1);
        packetInput2 = findViewById(R.id.packetInput2);
        intervalInput2 = findViewById(R.id.intervalInput2);
        timeoutInput2 = findViewById(R.id.timeoutInput2);

        btnStart1 = findViewById(R.id.btnStart1);
        btnStart2 = findViewById(R.id.btnStart2);
        tab1Btn = findViewById(R.id.tab1Btn);
        tab2Btn = findViewById(R.id.tab2Btn);
        statusText1 = findViewById(R.id.statusText1);
        statusText2 = findViewById(R.id.statusText2);
        resultTable = findViewById(R.id.resultTable);
        top5Table = findViewById(R.id.top5Table);
        logLayout = findViewById(R.id.logLayout);
        tab1Container = findViewById(R.id.tab1Container);
        tab2Container = findViewById(R.id.tab2Container);
        logScrollView = findViewById(R.id.logScrollView);

        tab1Btn.setOnClickListener(v -> { tab1Container.setVisibility(View.VISIBLE); tab2Container.setVisibility(View.GONE); });
        tab2Btn.setOnClickListener(v -> { tab1Container.setVisibility(View.GONE); tab2Container.setVisibility(View.VISIBLE); });
        
        btnStart1.setOnClickListener(v -> startRangeScan());
        btnStart2.setOnClickListener(v -> startDeepTest());
    }

    private void startRangeScan() {
        String query = ipInput.getText().toString().trim();
        List<String> ips = parseIPList(query);
        if (ips.isEmpty()) {
            Toast.makeText(this, "فرمت رنج یا آی‌پی نامعتبر است", Toast.LENGTH_SHORT).show();
            return;
        }

        int packets = parseNum(packetInput1, 50);
        int interval = parseNum(intervalInput1, 1);
        int timeout = parseNum(timeoutInput1, 1000);

        allResults.clear();
        resultTable.removeAllViews();
        logLayout.removeAllViews();
        isCancelled = false;
        btnStart1.setEnabled(false);

        executor = Executors.newFixedThreadPool(4);
        int total = ips.size();
        final int[] completed = {0};

        addTableHeader(resultTable);

        for (String ip : ips) {
            executor.execute(() -> {
                if (isCancelled) return;
                ScanResult res = benchmarkIP(ip, packets, interval, timeout);
                synchronized(allResults) {
                    allResults.add(res);
                    completed[0]++;
                }

                runOnUiThread(() -> {
                    statusText1.setText("اسکن پیشرفت: " + completed[0] + " / " + total);
                    TextView tv = new TextView(this);
                    tv.setText(String.format(Locale.US, "IP: %s | Avg: %s | Loss: %.0f%%", ip, res.loss >= 100 ? "DEAD" : String.format("%.1fms", res.avg), res.loss));
                    tv.setTextColor(res.loss < 50 ? Color.parseColor("#34D399") : Color.parseColor("#F87171"));
                    tv.setTextSize(11);
                    logLayout.addView(tv);
                    logScrollView.fullScroll(View.FOCUS_DOWN);

                    if (completed[0] >= total) {
                        btnStart1.setEnabled(true);
                        finishRangeScan();
                    }
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
        top5Candidates.clear();
        for (ScanResult res : allResults) {
            if (res.loss < 100f) {
                if (top5Candidates.size() < 5) {
                    top5Candidates.add(res);
                }
                addTableRow(resultTable, res, rank++);
            }
        }
        statusText1.setText("اسکن رنج کامل شد! ۵ آی‌پی برتر به تب دوم منتقل شدند.");
    }

    private void startDeepTest() {
        if (top5Candidates.isEmpty()) {
            Toast.makeText(this, "ابتدا باید اسکن رنج را کامل انجام دهید", Toast.LENGTH_SHORT).show();
            return;
        }

        int packets = parseNum(packetInput2, 300);
        int interval = parseNum(intervalInput2, 1);
        int timeout = parseNum(timeoutInput2, 1000);

        top5Table.removeAllViews();
        addTableHeader(top5Table);
        btnStart2.setEnabled(false);
        statusText2.setText("در حال تست تخصصی ۵ آی‌پی برتر...");

        new Thread(() -> {
            List<ScanResult> deepResults = new ArrayList<>();
            for (ScanResult candidate : top5Candidates) {
                ScanResult res = benchmarkIP(candidate.ip, packets, interval, timeout);
                deepResults.add(res);
            }

            runOnUiThread(() -> {
                top5Table.removeAllViews();
                addTableHeader(top5Table);
                for (int i = 0; i < deepResults.size(); i++) {
                    addTableRow(top5Table, deepResults.get(i), i + 1);
                }
                btnStart2.setEnabled(true);
                statusText2.setText("تست تخصصی گیمینگ کامل شد.");
            });
        }).start();
    }

    private ScanResult benchmarkIP(String ip, int totalPackets, int intervalMs, int timeoutMs) {
        List<Float> rttList = new ArrayList<>();
        int lost = 0;
        int consecutiveLost = 0;
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
                        rtt = Float.parseFloat(sub.split(" ")[0].replace("ms", "").trim());
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
                    if (consecutiveLost >= 3) { // قطع سریع بعد از ۳ پکت ناموفق متوالی برای آی‌پی مرده
                        lost = totalPackets;
                        break;
                    }
                }

                if (intervalMs > 0 && i < totalPackets - 1) {
                    Thread.sleep(intervalMs);
                }
            } catch (Exception e) {
                lost++;
                consecutiveLost++;
                if (consecutiveLost >= 3) {
                    lost = totalPackets;
                    break;
                }
            }
        }

        float lossPct = ((float) lost / totalPackets) * 100f;
        if (rttList.isEmpty()) {
            return new ScanResult(ip, "🌐", 999f, 999f, 999f, 999f, 100f);
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

        String flag = "🌐";
        try {
            URL url = new URL("http://ip-api.com/json/" + ip + "?fields=countryCode");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(1000);
            conn.setReadTimeout(1000);
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) sb.append(line);
            JSONObject obj = new JSONObject(sb.toString());
            String code = obj.optString("countryCode", "").toUpperCase();
            if (code.length() == 2) {
                int first = Character.codePointAt(code, 0) - 0x41 + 0x1F1E6;
                int second = Character.codePointAt(code, 1) - 0x41 + 0x1F1E6;
                flag = new String(Character.toChars(first)) + new String(Character.toChars(second));
            }
        } catch (Exception ignored) {}

        return new ScanResult(ip, flag, avg, min, max, jitter, lossPct);
    }

    private void addTableHeader(TableLayout table) {
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

    private void addTableRow(TableLayout table, ScanResult res, int rank) {
        TableRow row = new TableRow(this);
        row.setBackgroundColor(rank <= 5 ? Color.parseColor("#332200") : Color.parseColor("#1E293B"));
        
        row.setOnClickListener(v -> {
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("IP", res.ip);
            clipboard.setPrimaryClip(clip);
            Toast.makeText(this, "کپی شد: " + res.ip, Toast.LENGTH_SHORT).show();
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
        String ip, flag;
        float avg, min, max, jitter, loss;
        ScanResult(String ip, String flag, float avg, float min, float max, float jitter, float loss) {
            this.ip = ip;
            this.flag = flag;
            this.avg = avg;
            this.min = min;
            this.max = max;
            this.jitter = jitter;
            this.loss = loss;
        }
    }
}
