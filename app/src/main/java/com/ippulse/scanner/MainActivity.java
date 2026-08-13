package com.ippulse.scanner;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends Activity {

    private EditText ipInput, packetInput, intervalInput, timeoutInput;
    private Button btnStart, btnStop;
    private TextView statusText, top3Text, processText;
    private TableLayout resultTable;
    private ProgressBar progressBar;

    private ExecutorService executor =
            Executors.newFixedThreadPool(5);

    private volatile boolean isRunning = false;

    private final Set<Process> activeProcesses =
            ConcurrentHashMap.newKeySet();

    private final List<Result> results =
            Collections.synchronizedList(new ArrayList<>());

    private final AtomicInteger completed =
            new AtomicInteger(0);

    private final Pattern TIME_PATTERN =
            Pattern.compile(
                    "time[=<]\\s*([0-9]+(?:[.,][0-9]+)?)\\s*ms",
                    Pattern.CASE_INSENSITIVE
            );

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
        top3Text = findViewById(R.id.top3Text);
        processText = findViewById(R.id.processText);

        resultTable = findViewById(R.id.resultTable);
        progressBar = findViewById(R.id.progressBar);

        btnStart.setOnClickListener(v -> startScanning());
        btnStop.setOnClickListener(v -> stopScanning());

        btnStop.setEnabled(false);

        statusText.setText("آماده تست");
        processText.setText("Engine: Android system ping");
    }

    private void startScanning() {

        if (isRunning) {
            return;
        }

        String raw = ipInput.getText().toString().trim();

        if (raw.isEmpty()) {
            Toast.makeText(
                    this,
                    "حداقل یک IP وارد کنید",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }

        int packets = readInt(packetInput, 300);
        int interval = readInt(intervalInput, 20);
        int timeout = readInt(timeoutInput, 1000);

        packets = Math.max(1, Math.min(300, packets));
        interval = Math.max(20, Math.min(5000, interval));
        timeout = Math.max(100, Math.min(10000, timeout));

        List<String> ips = new ArrayList<>();

        for (String line : raw.split("\\r?\\n")) {

            String ip = line.trim();

            if (!ip.isEmpty() && isValidIPv4(ip)) {

                if (!ips.contains(ip)) {
                    ips.add(ip);
                }
            }
        }

        if (ips.isEmpty()) {

            Toast.makeText(
                    this,
                    "هیچ IP معتبر پیدا نشد",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        isRunning = true;

        btnStart.setEnabled(false);
        btnStop.setEnabled(true);

        results.clear();
        completed.set(0);

        resultTable.removeViews(
                1,
                Math.max(0, resultTable.getChildCount() - 1)
        );

        top3Text.setText("هنوز نتیجه‌ای ثبت نشده");
        statusText.setText(
                "شروع تست " +
                        ips.size() +
                        " مقصد × " +
                        packets +
                        " پکت"
        );

        processText.setText(
                "Interval: " + interval +
                        " ms   |   Timeout: " +
                        timeout +
                        " ms"
        );

        progressBar.setMax(ips.size());
        progressBar.setProgress(0);

        if (executor.isShutdown() ||
                executor.isTerminated()) {

            executor = Executors.newFixedThreadPool(5);
        }

        for (String ip : ips) {

            executor.execute(() -> {

                if (!isRunning) {
                    return;
                }

                updateProcess(
                        "در حال تست: " + ip
                );

                Result result =
                        performPing(
                                ip,
                                packets,
                                interval,
                                timeout
                        );

                if (result != null) {

                    results.add(result);

                    int done =
                            completed.incrementAndGet();

                    runOnUiThread(() -> {

                        renderResults();

                        progressBar.setProgress(done);

                        statusText.setText(
                                "پردازش: " +
                                        done +
                                        "/" +
                                        ips.size()
                        );

                        if (done >= ips.size()) {

                            isRunning = false;

                            btnStart.setEnabled(true);
                            btnStop.setEnabled(false);

                            processText.setText(
                                    "✅ تمام تست‌ها تکمیل شد"
                            );
                        }
                    });
                }
            });
        }
    }

    private Result performPing(
            String ip,
            int packets,
            int intervalMs,
            int timeoutMs
    ) {

        List<Double> rtts =
                new ArrayList<>();

        Process process = null;

        try {

            double intervalSeconds =
                    intervalMs / 1000.0;

            int timeoutSeconds =
                    Math.max(
                            1,
                            (int) Math.ceil(
                                    timeoutMs / 1000.0
                            )
                    );

            ProcessBuilder builder =
                    new ProcessBuilder(
                            "/system/bin/ping",
                            "-c",
                            String.valueOf(packets),
                            "-i",
                            String.format(
                                    Locale.US,
                                    "%.3f",
                                    intervalSeconds
                            ),
                            "-W",
                            String.valueOf(timeoutSeconds),
                            ip
                    );

            builder.redirectErrorStream(true);

            process = builder.start();

            activeProcesses.add(process);

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    process.getInputStream()
                            )
                    );

            String line;

            while (
                    (line = reader.readLine()) != null
            ) {

                if (!isRunning) {
                    break;
                }

                Matcher matcher =
                        TIME_PATTERN.matcher(line);

                if (matcher.find()) {

                    try {

                        double value =
                                Double.parseDouble(
                                        matcher
                                                .group(1)
                                                .replace(',', '.')
                                );

                        rtts.add(value);

                        final int received =
                                rtts.size();

                        runOnUiThread(() ->
                                processText.setText(
                                        "IP: " + ip +
                                                "  |  Rx: " +
                                                received +
                                                "/" +
                                                packets +
                                                "  | آخرین: " +
                                                String.format(
                                                        Locale.US,
                                                        "%.2f ms",
                                                        value
                                                )
                                )
                        );

                    } catch (Exception ignored) {
                    }
                }
            }

            try {
                process.waitFor();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        } catch (Exception e) {

            runOnUiThread(() ->
                    processText.setText(
                            "خطا در تست " +
                                    ip +
                                    ": " +
                                    e.getClass().getSimpleName()
                    )
            );

        } finally {

            if (process != null) {

                activeProcesses.remove(process);

                try {
                    process.destroy();
                } catch (Exception ignored) {
                }
            }
        }

        return buildResult(
                ip,
                packets,
                rtts
        );
    }

    private Result buildResult(
            String ip,
            int sent,
            List<Double> values
    ) {

        int received =
                values.size();

        double loss =
                sent == 0
                        ? 100.0
                        : ((sent - received) * 100.0 / sent);

        if (received == 0) {

            return new Result(
                    ip,
                    Double.NaN,
                    Double.NaN,
                    Double.NaN,
                    Double.NaN,
                    Double.NaN,
                    loss,
                    sent,
                    received
            );
        }

        double min =
                Collections.min(values);

        double max =
                Collections.max(values);

        double sum = 0;

        for (double v : values) {
            sum += v;
        }

        double avg =
                sum / received;

        double jitter = 0;

        if (values.size() > 1) {

            double total = 0;

            for (int i = 1;
                 i < values.size();
                 i++) {

                total += Math.abs(
                        values.get(i) -
                                values.get(i - 1)
                );
            }

            jitter =
                    total /
                            (values.size() - 1);
        }

        double variance = 0;

        for (double v : values) {

            variance +=
                    Math.pow(
                            v - avg,
                            2
                    );
        }

        double stdDev =
                Math.sqrt(
                        variance / received
                );

        return new Result(
                ip,
                min,
                avg,
                max,
                jitter,
                stdDev,
                loss,
                sent,
                received
        );
    }

    private void renderResults() {

        List<Result> sorted;

        synchronized (results) {
            sorted =
                    new ArrayList<>(results);
        }

        sorted.sort(
                Comparator.comparingDouble(
                        MainActivity::score
                )
        );

        showTop3(sorted);
        fillTable(sorted);
    }

    private static double score(Result r) {

        if (Double.isNaN(r.avg)) {
            return Double.MAX_VALUE;
        }

        return
                (r.loss * 100000.0) +
                (r.avg * 10.0) +
                (r.jitter * 3.0) +
                r.stdDev;
    }

    private void showTop3(
            List<Result> sorted
    ) {

        StringBuilder sb =
                new StringBuilder();

        int top =
                Math.min(3, sorted.size());

        for (int i = 0; i < top; i++) {

            Result r =
                    sorted.get(i);

            String medal;

            if (i == 0) {
                medal = "🥇";
            } else if (i == 1) {
                medal = "🥈";
            } else {
                medal = "🥉";
            }

            sb.append(medal)
                    .append(" #")
                    .append(i + 1)
                    .append("  ")
                    .append(r.ip)
                    .append("\n")
                    .append("Avg ")
                    .append(format(r.avg))
                    .append(" ms   ")
                    .append("Jitter ")
                    .append(format(r.jitter))
                    .append(" ms   ")
                    .append("Loss ")
                    .append(format(r.loss))
                    .append("%\n\n");
        }

        top3Text.setText(
                sb.length() == 0
                        ? "هنوز نتیجه‌ای نیست"
                        : sb.toString()
        );
    }

    private void fillTable(
            List<Result> sorted
    ) {

        resultTable.removeViews(
                1,
                Math.max(
                        0,
                        resultTable.getChildCount() - 1
                )
        );

        for (int i = 0;
             i < sorted.size();
             i++) {

            Result r =
                    sorted.get(i);

            TableRow row =
                    new TableRow(this);

            String[] data = {

                    String.valueOf(i + 1),

                    r.ip,

                    format(r.avg),

                    format(r.jitter),

                    format(r.min),

                    format(r.max),

                    format(r.stdDev),

                    format(r.loss) + "%",

                    r.received +
                            "/" +
                            r.sent
            };

            for (String value : data) {

                TextView tv =
                        new TextView(this);

                tv.setText(value);
                tv.setTextColor(Color.WHITE);
                tv.setTextSize(12);
                tv.setPadding(
                        12,
                        10,
                        12,
                        10
                );

                tv.setTypeface(
                        Typeface.MONOSPACE
                );

                tv.setGravity(
                        Gravity.CENTER
                );

                row.addView(tv);
            }

            if (i == 0) {

                for (int j = 0;
                     j < row.getChildCount();
                     j++) {

                    ((TextView)
                            row.getChildAt(j))
                            .setTextColor(
                                    Color.rgb(
                                            255,
                                            193,
                                            7
                                    )
                            );
                }

            } else if (i == 1) {

                for (int j = 0;
                     j < row.getChildCount();
                     j++) {

                    ((TextView)
                            row.getChildAt(j))
                            .setTextColor(
                                    Color.rgb(
                                            80,
                                            170,
                                            255
                                    )
                            );
                }

            } else if (i == 2) {

                for (int j = 0;
                     j < row.getChildCount();
                     j++) {

                    ((TextView)
                            row.getChildAt(j))
                            .setTextColor(
                                    Color.rgb(
                                            45,
                                            210,
                                            110
                                    )
                            );
                }
            }

            resultTable.addView(row);
        }
    }

    private void stopScanning() {

        isRunning = false;

        for (Process process :
                activeProcesses) {

            try {
                process.destroy();
            } catch (Exception ignored) {
            }
        }

        activeProcesses.clear();

        if (executor != null) {
            executor.shutdownNow();
        }

        btnStart.setEnabled(true);
        btnStop.setEnabled(false);

        statusText.setText(
                "⛔ تست متوقف شد"
        );

        processText.setText(
                "تمام Processهای فعال متوقف شدند"
        );
    }

    private void updateProcess(
            String text
    ) {

        runOnUiThread(() ->
                processText.setText(text)
        );
    }

    private int readInt(
            EditText field,
            int fallback
    ) {

        try {

            return Integer.parseInt(
                    field.getText()
                            .toString()
                            .trim()
            );

        } catch (Exception e) {

            return fallback;
        }
    }

    private boolean isValidIPv4(
            String value
    ) {

        try {

            String[] parts =
                    value.split("\\.");

            if (parts.length != 4) {
                return false;
            }

            for (String part : parts) {

                int n =
                        Integer.parseInt(part);

                if (n < 0 || n > 255) {
                    return false;
                }
            }

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    private String format(
            double value
    ) {

        if (Double.isNaN(value)) {
            return "—";
        }

        return String.format(
                Locale.US,
                "%.2f",
                value
        );
    }

    @Override
    protected void onDestroy() {

        stopScanning();

        super.onDestroy();
    }

    private static class Result {

        String ip;

        double min;
        double avg;
        double max;
        double jitter;
        double stdDev;
        double loss;

        int sent;
        int received;

        Result(
                String ip,
                double min,
                double avg,
                double max,
                double jitter,
                double stdDev,
                double loss,
                int sent,
                int received
        ) {

            this.ip = ip;
            this.min = min;
            this.avg = avg;
            this.max = max;
            this.jitter = jitter;
            this.stdDev = stdDev;
            this.loss = loss;
            this.sent = sent;
            this.received = received;
        }
    }
}
