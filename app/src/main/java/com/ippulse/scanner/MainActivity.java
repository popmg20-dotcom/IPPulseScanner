package com.ippulse.scanner;

import android.app.Activity;
import android.graphics.Color;
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
    private EditText ipInput, pInput2, tInput2;
    private Button btnStart1, btnStart2, tab1Btn, tab2Btn;
    private TextView statusText1;
    private TableLayout resultTable, top5Table;
    private LinearLayout logLayout, tab1Container, tab2Container;
    private ScrollView logScrollView;
    
    private ExecutorService executor;
    private List<ScanResult> allResults = new ArrayList<>();
    private List<ScanResult> top5List = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ipInput = findViewById(R.id.ipInput);
        pInput2 = findViewById(R.id.pInput2);
        tInput2 = findViewById(R.id.tInput2);
        btnStart1 = findViewById(R.id.btnStart1);
        btnStart2 = findViewById(R.id.btnStart2);
        tab1Btn = findViewById(R.id.tab1Btn);
        tab2Btn = findViewById(R.id.tab2Btn);
        statusText1 = findViewById(R.id.statusText1);
        resultTable = findViewById(R.id.resultTable);
        top5Table = findViewById(R.id.top5Table);
        logLayout = findViewById(R.id.logLayout);
        tab1Container = findViewById(R.id.tab1Container);
        tab2Container = findViewById(R.id.tab2Container);
        logScrollView = findViewById(R.id.logScrollView);

        tab1Btn.setOnClickListener(v -> { tab1Container.setVisibility(View.VISIBLE); tab2Container.setVisibility(View.GONE); });
        tab2Btn.setOnClickListener(v -> { tab1Container.setVisibility(View.GONE); tab2Container.setVisibility(View.VISIBLE); });
        
        btnStart1.setOnClickListener(v -> scanRange());
        btnStart2.setOnClickListener(v -> scanTop5());
    }

    private void scanRange() {
        allResults.clear();
        resultTable.removeAllViews();
        logLayout.removeAllViews();
        List<String> ips = parseIPList(ipInput.getText().toString());
        executor = Executors.newFixedThreadPool(4);
        
        for (String ip : ips) {
            executor.execute(() -> {
                ScanResult res = benchmark(ip, 20, 1000);
                synchronized(allResults) { allResults.add(res); }
                runOnUiThread(() -> {
                    TextView tv = new TextView(this);
                    tv.setText(ip + " -> Avg: " + (res.loss >= 100 ? "DEAD" : String.format("%.1fms", res.avg)));
                    tv.setTextColor(res.loss < 50 ? Color.GREEN : Color.RED);
                    logLayout.addView(tv);
                    logScrollView.fullScroll(View.FOCUS_DOWN);
                });
            });
        }
    }

    private void scanTop5() {
        top5Table.removeAllViews();
        Collections.sort(allResults, (a, b) -> Float.compare(a.avg, b.avg));
        int limit = Math.min(5, allResults.size());
        
        executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            for (int i = 0; i < limit; i++) {
                ScanResult res = benchmark(allResults.get(i).ip, Integer.parseInt(pInput2.getText().toString()), Integer.parseInt(tInput2.getText().toString()));
                runOnUiThread(() -> addRow(top5Table, res, i+1));
            }
        });
    }

    private ScanResult benchmark(String ip, int packets, int timeout) {
        List<Float> times = new ArrayList<>();
        int lost = 0;
        int consecutiveLost = 0;

        for (int i = 0; i < packets; i++) {
            try {
                Process p = Runtime.getRuntime().exec("ping -c 1 -W " + (timeout/1000) + " " + ip);
                BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line;
                float rtt = -1;
                while((line = r.readLine()) != null) {
                    if(line.contains("time=")) {
                        rtt = Float.parseFloat(line.split("time=")[1].split(" ")[0]);
                        break;
                    }
                }
                if(rtt != -1) {
                    times.add(rtt);
                    consecutiveLost = 0;
                } else {
                    lost++;
                    consecutiveLost++;
                    if(consecutiveLost >= 3) break;
                }
            } catch(Exception e) { lost++; }
        }

        float avg = times.isEmpty() ? 999 : 0;
        if(!times.isEmpty()) {
            for(float t : times) avg += t;
            avg /= times.size();
        }
        
        return new ScanResult(ip, avg, ((float)lost/packets)*100);
    }

    private void addRow(TableLayout table, ScanResult res, int rank) {
        TableRow row = new TableRow(this);
        TextView tv = new TextView(this);
        tv.setText(rank + " | " + res.ip + " | " + String.format("%.1f", res.avg) + "ms | " + String.format("%.0f", res.loss) + "%");
        tv.setTextColor(Color.WHITE);
        tv.setPadding(10, 10, 10, 10);
        row.addView(tv);
        table.addView(row);
    }

    private List<String> parseIPList(String in) {
        // ساده‌ترین حالت برای تست - رنج اولیه‌
        return Arrays.asList("3.122.114.1", "3.122.114.2", "3.122.114.3"); // برای تست خودت گسترش بده
    }

    private static class ScanResult {
        String ip; float avg, loss;
        ScanResult(String ip, float avg, float loss) { this.ip = ip; this.avg = avg; this.loss = loss; }
    }
}
