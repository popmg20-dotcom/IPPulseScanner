package com.ippulse.scanner;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.*;

public class MainActivity extends Activity {
    private EditText ipInput, packetInput, intervalInput;
    private Button btnStart, btnStop;
    private TextView statusText;
    private TableLayout resultTable;
    private ExecutorService executor = Executors.newFixedThreadPool(5);
    private volatile boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ipInput = findViewById(R.id.ipInput);
        packetInput = findViewById(R.id.packetInput);
        intervalInput = findViewById(R.id.intervalInput);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        statusText = findViewById(R.id.statusText);
        resultTable = findViewById(R.id.resultTable);

        btnStart.setOnClickListener(v -> startScanning());
        btnStop.setOnClickListener(v -> stopScanning());
    }

    private void startScanning() {
        isRunning = true;
        btnStart.setEnabled(false);
        resultTable.removeAllViews();
        statusText.setText("شروع عملیات...");
        
        String[] ips = ipInput.getText().toString().split("\n");
        for (String ip : ips) {
            if (!ip.trim().isEmpty()) {
                executor.execute(() -> performPing(ip.trim()));
            }
        }
    }

    private void performPing(String ip) {
        try {
            Process p = Runtime.getRuntime().exec("ping -c 5 " + ip);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("time=")) {
                    final String res = line;
                    runOnUiThread(() -> {
                        TextView tv = new TextView(this);
                        tv.setText(ip + " -> " + res);
                        tv.setTextColor(Color.WHITE);
                        resultTable.addView(tv);
                    });
                }
            }
        } catch (Exception e) {
            runOnUiThread(() -> statusText.setText("خطا در پینگ: " + ip));
        }
    }

    private void stopScanning() {
        isRunning = false;
        btnStart.setEnabled(true);
        statusText.setText("متوقف شد");
    }
}
