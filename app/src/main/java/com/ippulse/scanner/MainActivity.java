package com.ippulse.scanner;

import com.github.xfalcon.vhosts.vservice.VhostsService;
import android.content.pm.PackageManager;
import android.net.VpnService;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;
import com.ippulse.scanner.VpnEvidenceLogger;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import com.ippulse.scanner.MainActivity;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class MainActivity extends Activity {

    private View tab1Container, tab2Container, tab3Container;
    private Button btnTab1, btnTab2, btnTab3, btnStart1, btnStop1, btnHistory, btnClearHistory;
    private Button btnStartVpn, btnStopVpn, btnApplyIp;
    private TextView vpnStatus;
    private EditText vpnDns, vpnHosts, vpnMasterIp, vpnMtu;

    private static final int FAST_FAIL_THRESHOLD = 3;
    private static final String HISTORY_KEY = "history";
    private static final String VPN_PREFS = "vpn_settings";
    private static final int REQUEST_VPN = 1001;
    private static final int REQUEST_NOTIFICATION = 1002;
    private static final String PREFS_NAME = "ippulse_history";
    private Button btnHistory;
    private Button btnStart1;
    private Button btnStop1;
    private Button btnStop2;
    private Button btnTab1;
    private Button btnTab2;
    private Thread deepTestThread;
    private ExecutorService executor;
    private EditText inputInterval;
    private EditText inputPackets;
    private EditText inputTimeout;
    private EditText ipInput;
    private LinearLayout logLayout1;
    private LinearLayout logLayout2;
    private ScrollView logScroll1;
    private ScrollView logScroll2;
    private Spinner spinnerSort;
    private TextView status1;
    private TextView status2;
    private View tab1Container;
    private View tab2Container;
    private TableLayout table1;
    private TableLayout table2Live;
    private LinearLayout top5Container;
    private volatile boolean isCancelled = false;
    private List<ScanResult> allResults = new ArrayList();
    private List<String> top5IPs = new ArrayList();
    private boolean rangeScanFinished = true;
    private String[] sortOptions = {"Default", "Loss", "Jitter", "Average (Avg)", "Min (Low Ping)", "Max (High Ping)"};
    private int currentSortIndex = 0;

    private String[] defaultDomains = {
        "west-tdm.codmwest.com",
        "west-cschannel.codm.activision.com",
        "gcloud.codm.activision.com"
    };


    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VpnEvidenceLogger.init(getApplicationContext());
        btnTab3 = findViewById(R.id.btnTab3);
        tab3Container = findViewById(R.id.tab3Container);
        vpnDns = findViewById(R.id.vpnDns);
        vpnHosts = findViewById(R.id.vpnHosts);
        vpnMasterIp = findViewById(R.id.vpnMasterIp);
        vpnMtu = findViewById(R.id.vpnMtu);
        btnStartVpn = findViewById(R.id.btnStartVpn);
        btnStopVpn = findViewById(R.id.btnStopVpn);
        btnApplyIp = findViewById(R.id.btnApplyIp);
        vpnStatus = findViewById(R.id.vpnStatus);
        loadVpnSettings();
        btnStartVpn.setOnClickListener(v -> startVpn());
        btnStopVpn.setOnClickListener(v -> stopVpn());
        btnApplyIp.setOnClickListener(v -> applyMasterIp());
        this.tab1Container = findViewById(R.id.tab1Container);
        this.btnTab1 = (Button) findViewById(R.id.btnTab1);
        this.btnTab2 = (Button) findViewById(R.id.btnTab2);
        this.btnStart1 = (Button) findViewById(R.id.btnStart1);
        this.btnStop1 = (Button) findViewById(R.id.btnStop1);
        this.ipInput = (EditText) findViewById(R.id.ipInput);
        this.inputPackets = (EditText) findViewById(R.id.inputPackets);
        this.inputInterval = (EditText) findViewById(R.id.inputInterval);
        this.inputTimeout = (EditText) findViewById(R.id.inputTimeout);
        this.status1 = (TextView) findViewById(R.id.status1);
        this.logLayout1 = (LinearLayout) findViewById(R.id.logLayout1);
        this.logScroll1 = (ScrollView) findViewById(R.id.logScroll1);
        this.table1 = (TableLayout) findViewById(R.id.table1);
        this.spinnerSort = (Spinner) findViewById(R.id.spinnerSort);
        this.tab2Container = findViewById(R.id.tab2Container);
        this.top5Container = (LinearLayout) findViewById(R.id.top5Container);
        this.status2 = (TextView) findViewById(R.id.status2);
        this.logLayout2 = (LinearLayout) findViewById(R.id.logLayout2);
        this.logScroll2 = (ScrollView) findViewById(R.id.logScroll2);
        this.table2Live = (TableLayout) findViewById(R.id.table2Live);
        this.btnStop2 = (Button) findViewById(R.id.btnStop2);
        this.btnHistory = (Button) findViewById(R.id.btnHistory);
        this.btnClearHistory = (Button) findViewById(R.id.btnClearHistory);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, this.sortOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinnerSort.setAdapter((SpinnerAdapter) adapter);
        this.spinnerSort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.ippulse.scanner.MainActivity.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.this.currentSortIndex = position;
                if (MainActivity.this.rangeScanFinished && !MainActivity.this.allResults.isEmpty()) {
                    MainActivity.this.applySortAndRefreshTable();
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        this.btnTab1.setOnClickListener(new View.OnClickListener() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda26
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.m5lambda$onCreate$0$comippulsescannerMainActivity(view);
            }
        });
        this.btnTab2.setOnClickListener(new View.OnClickListener() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda27
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.m6lambda$onCreate$1$comippulsescannerMainActivity(view);
            }
        });
        this.btnStart1.setOnClickListener(new View.OnClickListener() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.m7lambda$onCreate$2$comippulsescannerMainActivity(view);
            }
        });
        this.btnStop1.setOnClickListener(new View.OnClickListener() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.m8lambda$onCreate$3$comippulsescannerMainActivity(view);
            }
        });
        this.btnStop2.setOnClickListener(new View.OnClickListener() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.m9lambda$onCreate$4$comippulsescannerMainActivity(view);
            }
        });
        this.btnHistory.setOnClickListener(new View.OnClickListener() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.m10lambda$onCreate$5$comippulsescannerMainActivity(view);
            }
        });
        this.btnClearHistory.setOnClickListener(new View.OnClickListener() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.m11lambda$onCreate$6$comippulsescannerMainActivity(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-ippulse-scanner-MainActivity, reason: not valid java name */
    /* synthetic */ void m5lambda$onCreate$0$comippulsescannerMainActivity(View v) {
        switchTab(1);
    }

    /* JADX INFO: renamed from: lambda$onCreate$1$com-ippulse-scanner-MainActivity, reason: not valid java name */
    /* synthetic */ void m6lambda$onCreate$1$comippulsescannerMainActivity(View v) {
        switchTab(2);
    }

    /* JADX INFO: renamed from: lambda$onCreate$2$com-ippulse-scanner-MainActivity, reason: not valid java name */
    /* synthetic */ void m7lambda$onCreate$2$comippulsescannerMainActivity(View v) {
        startRangeScan();
    }

    /* JADX INFO: renamed from: lambda$onCreate$3$com-ippulse-scanner-MainActivity, reason: not valid java name */
    /* synthetic */ void m8lambda$onCreate$3$comippulsescannerMainActivity(View v) {
        stopRangeScan();
    }

    /* JADX INFO: renamed from: lambda$onCreate$4$com-ippulse-scanner-MainActivity, reason: not valid java name */
    /* synthetic */ void m9lambda$onCreate$4$comippulsescannerMainActivity(View v) {
        stopDeepTest();
    }

    /* JADX INFO: renamed from: lambda$onCreate$5$com-ippulse-scanner-MainActivity, reason: not valid java name */
    /* synthetic */ void m10lambda$onCreate$5$comippulsescannerMainActivity(View v) {
        showHistoryDialog();
    }

    /* JADX INFO: renamed from: lambda$onCreate$6$com-ippulse-scanner-MainActivity, reason: not valid java name */
    /* synthetic */ void m11lambda$onCreate$6$comippulsescannerMainActivity(View v) {
        clearHistory();
    }

private void switchTab(int tab) {
        tab1Container.setVisibility(tab == 1 ? View.VISIBLE : View.GONE);
        tab2Container.setVisibility(tab == 2 ? View.VISIBLE : View.GONE);
        tab3Container.setVisibility(tab == 3 ? View.VISIBLE : View.GONE);
        btnTab1.setBackgroundColor(tab == 1 ? Color.parseColor("#2563EB") : Color.parseColor("#1E293B"));
        btnTab1.setTextColor(tab == 1 ? Color.WHITE : Color.parseColor("#94A3B8"));
        btnTab2.setBackgroundColor(tab == 2 ? Color.parseColor("#2563EB") : Color.parseColor("#1E293B"));
        btnTab2.setTextColor(tab == 2 ? Color.WHITE : Color.parseColor("#94A3B8"));
        btnTab3.setBackgroundColor(tab == 3 ? Color.parseColor("#2563EB") : Color.parseColor("#1E293B"));
        btnTab3.setTextColor(tab == 3 ? Color.WHITE : Color.parseColor("#94A3B8"));
    }

    private void stopRangeScan() {
        this.isCancelled = true;
        if (this.executor != null) {
            this.executor.shutdownNow();
        }
        runOnUiThread(new Runnable() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.this.m18lambda$stopRangeScan$7$comippulsescannerMainActivity();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$stopRangeScan$7$com-ippulse-scanner-MainActivity, reason: not valid java name */
    /* synthetic */ void m18lambda$stopRangeScan$7$comippulsescannerMainActivity() {
        if (!this.rangeScanFinished && !this.allResults.isEmpty()) {
            finishRangeScan();
        } else {
            this.status1.setText("Scan stopped.");
            this.btnStart1.setEnabled(true);
        }
    }

    private void stopDeepTest() {
        this.isCancelled = true;
        if (this.deepTestThread != null) {
            this.deepTestThread.interrupt();
        }
        this.status2.setText("Deep test stopped.");
    }

    private void startRangeScan() {
        String query = this.ipInput.getText().toString().trim();
        if (query.isEmpty()) {
            Toast.makeText(this, "Please enter a range or IP", 0).show();
            return;
        }
        final List<String> ips = parseIPList(query);
        if (ips.isEmpty()) {
            Toast.makeText(this, "Invalid range", 0).show();
            return;
        }
        final int pkts = parseNum(this.inputPackets, 100);
        final int timeo = parseNum(this.inputTimeout, 1000);
        this.allResults.clear();
        this.logLayout1.removeAllViews();
        this.table1.removeAllViews();
        addTableHeader(this.table1, false);
        this.btnStart1.setEnabled(false);
        this.isCancelled = false;
        this.rangeScanFinished = false;
        saveHistory(query);
        this.executor = Executors.newFixedThreadPool(80);
        final int[] completed = {0};
        this.status1.setText("Scanning " + ips.size() + " IPs concurrently...");
        for (final String ip : ips) {
            this.executor.execute(new Runnable() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda19
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.this.m17lambda$startRangeScan$9$comippulsescannerMainActivity(ip, pkts, timeo, completed, ips);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$startRangeScan$9$com-ippulse-scanner-MainActivity, reason: not valid java name */
    /* synthetic */ void m17lambda$startRangeScan$9$comippulsescannerMainActivity(String ip, int pkts, int timeo, final int[] completed, final List ips) {
        if (this.isCancelled) {
            return;
        }
        final ScanResult res = pingLogic(ip, pkts, timeo, false, null);
        synchronized (this.allResults) {
            this.allResults.add(res);
            completed[0] = completed[0] + 1;
        }
        runOnUiThread(new Runnable() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.this.m16lambda$startRangeScan$8$comippulsescannerMainActivity(res, completed, ips);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$startRangeScan$8$com-ippulse-scanner-MainActivity, reason: not valid java name */
    /* synthetic */ void m16lambda$startRangeScan$8$comippulsescannerMainActivity(ScanResult res, int[] completed, List ips) {
        appendMainLog(res);
        this.status1.setText(completed[0] + " / " + ips.size() + " processed.");
        if (completed[0] >= ips.size() && !this.isCancelled && !this.rangeScanFinished) {
            finishRangeScan();
        }
    }

    private void finishRangeScan() {
        this.rangeScanFinished = true;
        this.btnStart1.setEnabled(true);
        applySortAndRefreshTable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applySortAndRefreshTable() {
        List<ScanResult> aliveResults = new ArrayList<>();
        for (ScanResult res : this.allResults) {
            if (res.alive) {
                aliveResults.add(res);
            }
        }
        switch (this.currentSortIndex) {
            case 0:
                Collections.sort(aliveResults, new Comparator() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda7
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return MainActivity.lambda$applySortAndRefreshTable$10((MainActivity.ScanResult) obj, (MainActivity.ScanResult) obj2);
                    }
                });
                break;
            case 1:
                Collections.sort(aliveResults, new Comparator() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda8
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return Float.compare(((MainActivity.ScanResult) obj).loss, ((MainActivity.ScanResult) obj2).loss);
                    }
                });
                break;
            case 2:
                Collections.sort(aliveResults, new Comparator() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda9
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return Float.compare(((MainActivity.ScanResult) obj).jitter, ((MainActivity.ScanResult) obj2).jitter);
                    }
                });
                break;
            case FAST_FAIL_THRESHOLD /* 3 */:
                Collections.sort(aliveResults, new Comparator() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda10
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return Float.compare(((MainActivity.ScanResult) obj).avg, ((MainActivity.ScanResult) obj2).avg);
                    }
                });
                break;
            case 4:
                Collections.sort(aliveResults, new Comparator() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda12
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return Float.compare(((MainActivity.ScanResult) obj).min, ((MainActivity.ScanResult) obj2).min);
                    }
                });
                break;
            case 5:
                Collections.sort(aliveResults, new Comparator() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda13
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return Float.compare(((MainActivity.ScanResult) obj).max, ((MainActivity.ScanResult) obj2).max);
                    }
                });
                break;
        }
        this.table1.removeAllViews();
        addTableHeader(this.table1, false);
        this.top5IPs.clear();
        for (int i = 0; i < Math.min(5, aliveResults.size()); i++) {
            this.top5IPs.add(aliveResults.get(i).f0ip);
        }
        int rank = 1;
        for (ScanResult res2 : aliveResults) {
            boolean isTop5 = this.top5IPs.contains(res2.f0ip);
            addTableRow(this.table1, res2, rank, false, isTop5);
            rank++;
        }
        populateTab2();
        this.status1.setText("Sorted by: " + this.sortOptions[this.currentSortIndex]);
    }

    static /* synthetic */ int lambda$applySortAndRefreshTable$10(ScanResult a, ScanResult b) {
        return a.loss != b.loss ? Float.compare(a.loss, b.loss) : Math.abs(a.jitter - b.jitter) > 0.1f ? Float.compare(a.jitter, b.jitter) : a.avg != b.avg ? Float.compare(a.avg, b.avg) : Float.compare(a.max, b.max);
    }

    private void populateTab2() {
        this.top5Container.removeAllViews();
        if (this.top5IPs.isEmpty()) {
            TextView tv = new TextView(this);
            tv.setText("No alive IPs found.");
            tv.setTextColor(Color.parseColor("#EF4444"));
            tv.setGravity(17);
            this.top5Container.addView(tv);
            return;
        }
        for (int i = 0; i < this.top5IPs.size(); i++) {
            final String ip = this.top5IPs.get(i);
            Button btn = new Button(this);
            btn.setText("🥇 Start Deep Test: " + ip);
            btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFD700")));
            btn.setTextColor(-16777216);
            btn.setAllCaps(false);
            btn.setPadding(0, 8, 0, 8);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-1, -2);
            params.setMargins(0, 0, 0, 8);
            btn.setLayoutParams(params);
            btn.setOnClickListener(new View.OnClickListener() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.this.m12lambda$populateTab2$16$comippulsescannerMainActivity(ip, view);
                }
            });
            this.top5Container.addView(btn);
        }
    }

    /* JADX INFO: renamed from: lambda$populateTab2$16$com-ippulse-scanner-MainActivity, reason: not valid java name */
    /* synthetic */ void m12lambda$populateTab2$16$comippulsescannerMainActivity(String ip, View v) {
        startDeepTestOn(ip);
    }

    private void startDeepTestOn(final String ip) {
        if (this.deepTestThread != null && this.deepTestThread.isAlive()) {
            this.isCancelled = true;
            this.deepTestThread.interrupt();
        }
        this.isCancelled = false;
        this.logLayout2.removeAllViews();
        this.table2Live.removeAllViews();
        addTableHeader(this.table2Live, true);
        final int pkts = parseNum(this.inputPackets, 100);
        final int timeo = parseNum(this.inputTimeout, 1000);
        this.status2.setText("Deep Testing: " + ip);
        this.deepTestThread = new Thread(new Runnable() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.this.m15lambda$startDeepTestOn$18$comippulsescannerMainActivity(ip, pkts, timeo);
            }
        });
        this.deepTestThread.start();
    }

    /* JADX INFO: renamed from: lambda$startDeepTestOn$18$com-ippulse-scanner-MainActivity, reason: not valid java name */
    /* synthetic */ void m15lambda$startDeepTestOn$18$comippulsescannerMainActivity(final String ip, int pkts, int timeo) {
        pingLogic(ip, pkts, timeo, true, this.table2Live);
        runOnUiThread(new Runnable() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.this.m14lambda$startDeepTestOn$17$comippulsescannerMainActivity(ip);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$startDeepTestOn$17$com-ippulse-scanner-MainActivity, reason: not valid java name */
    /* synthetic */ void m14lambda$startDeepTestOn$17$comippulsescannerMainActivity(String ip) {
        if (!this.isCancelled) {
            this.status2.setText("Deep Test Finished: " + ip);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ec, code lost:

        r9 = java.lang.Float.parseFloat(r6[0].trim());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ScanResult pingLogic(final String ip, int totalPkts, int timeo, boolean isDeepLive, final TableLayout liveTable) {
        TableRow liveRow;
        int lost;
        float f;
        float f2;
        String str;
        int attempted;
        int lost2;
        String str2 = "time=";
        List<Float> rttList = new ArrayList<>();
        int tSec = Math.max(1, timeo / 1000);
        final TextView[] liveCells = new TextView[8];
        if (isDeepLive) {
            final TableRow liveRow2 = new TableRow(this);
            liveRow2.setBackgroundColor(Color.parseColor("#18181B"));
            int i = 0;
            for (int i2 = 8; i < i2; i2 = 8) {
                TextView tv = new TextView(this);
                tv.setPadding(10, 10, 10, 10);
                tv.setGravity(17);
                tv.setTextSize(11.0f);
                tv.setTextColor(-1);
                liveCells[i] = tv;
                liveRow2.addView(tv);
                i++;
            }
            runOnUiThread(new Runnable() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda23
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.lambda$pingLogic$19(liveTable, liveRow2, liveCells, ip);
                }
            });
            liveRow = liveRow2;
        } else {
            liveRow = null;
        }
        int i3 = 1;
        int consecutiveLost = 0;
        int attempted2 = 0;
        int consecutiveLost2 = 0;
        while (i3 <= totalPkts && !this.isCancelled) {
            int attempted3 = i3;
            float rtt = -1.0f;
            try {
                Process p = new ProcessBuilder("ping", "-c", "1", "-W", String.valueOf(tSec), ip).redirectErrorStream(true).start();
                try {
                    attempted = attempted3;
                    try {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                        while (true) {
                            String line = reader.readLine();
                            if (line == null) {
                                str = str2;
                                break;
                            }
                            if (!line.contains(str2)) {
                                str2 = str2;
                            } else {
                                int idx = line.indexOf(str2);
                                str = str2;
                                try {
                                    String sub = line.substring(idx + 5).trim();
                                    BufferedReader reader2 = reader;
                                    String[] parts = sub.split(" ");
                                    if (parts.length > 0) {
                                        break;
                                    }
                                    reader = reader2;
                                    str2 = str;
                                } catch (Exception e) {
                                    rtt = -1.0f;
                                }
                            }
                        }
                        p.waitFor();
                        p.destroy();
                    } catch (Exception e2) {
                        str = str2;
                    }
                } catch (Exception e3) {
                    str = str2;
                    attempted = attempted3;
                }
            } catch (Exception e4) {
                str = str2;
                attempted = attempted3;
            }
            if (rtt >= 0.0f) {
                rttList.add(Float.valueOf(rtt));
                consecutiveLost2 = 0;
            } else {
                consecutiveLost++;
                consecutiveLost2++;
                if (consecutiveLost2 >= FAST_FAIL_THRESHOLD) {
                    lost = consecutiveLost;
                    attempted2 = attempted;
                    break;
                }
            }
            if (!isDeepLive || liveRow == null) {
                lost2 = consecutiveLost;
            } else {
                final int curReceived = rttList.size();
                final float curAvg = avg(rttList);
                final float curMin = min(rttList);
                final float curMax = max(rttList);
                final float curJitter = jitter(rttList);
                final float curLoss = ((i3 - curReceived) * 100.0f) / i3;
                final int seq = i3;
                float finalRtt = rtt;
                lost2 = consecutiveLost;
                runOnUiThread(new Runnable() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda24
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainActivity.lambda$pingLogic$20(liveCells, seq, curAvg, curMin, curMax, curJitter, curLoss, curReceived);
                    }
                });
                appendDeepLog(ip + " seq=" + seq + "/" + totalPkts + " rtt=" + (finalRtt >= 0.0f ? finalRtt + "ms" : "lost"));
            }
            if (i3 < totalPkts && !this.isCancelled && consecutiveLost2 < FAST_FAIL_THRESHOLD) {
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e5) {
                    attempted2 = attempted;
                    lost = lost2;
                }
            }
            i3++;
            attempted2 = attempted;
            str2 = str;
            consecutiveLost = lost2;
        }
        lost = consecutiveLost;
        if (attempted2 == 0) {
            f = 100.0f;
            f2 = 100.0f;
        } else {
            f = 100.0f;
            f2 = (lost * 100.0f) / attempted2;
        }
        float lossPct = f2;
        boolean alive = rttList.size() > 0 && lossPct < f;
        return new ScanResult(ip, avg(rttList), min(rttList), max(rttList), jitter(rttList), lossPct, alive, attempted2);
    }

    static /* synthetic */ void lambda$pingLogic$19(TableLayout liveTable, TableRow rowToAdd, TextView[] cells, String ipFinal) {
        liveTable.addView(rowToAdd);
        cells[0].setText(ipFinal);
        cells[1].setText("0");
        cells[2].setText("0");
        cells[FAST_FAIL_THRESHOLD].setText("0");
        cells[4].setText("0");
        cells[5].setText("0");
        cells[6].setText("0%");
        cells[7].setText("TESTING");
    }

    static /* synthetic */ void lambda$pingLogic$20(TextView[] liveCells, int seq, float curAvg, float curMin, float curMax, float curJitter, float curLoss, int curReceived) {
        liveCells[1].setText(String.valueOf(seq));
        liveCells[2].setText(String.format(Locale.US, "%.1f", Float.valueOf(curAvg)));
        liveCells[FAST_FAIL_THRESHOLD].setText(String.format(Locale.US, "%.1f", Float.valueOf(curMin)));
        liveCells[4].setText(String.format(Locale.US, "%.1f", Float.valueOf(curMax)));
        liveCells[5].setText(String.format(Locale.US, "%.2f", Float.valueOf(curJitter)));
        liveCells[6].setText(String.format(Locale.US, "%.0f%%", Float.valueOf(curLoss)));
        liveCells[7].setText(curReceived > 0 ? "ALIVE" : "DEAD");
    }

    private float avg(List<Float> list) {
        if (list == null || list.isEmpty()) {
            return 0.0f;
        }
        float sum = 0.0f;
        Iterator<Float> it = list.iterator();
        while (it.hasNext()) {
            float f = it.next().floatValue();
            sum += f;
        }
        return sum / list.size();
    }

    private float min(List<Float> list) {
        if (list == null || list.isEmpty()) {
            return 0.0f;
        }
        float m = list.get(0).floatValue();
        Iterator<Float> it = list.iterator();
        while (it.hasNext()) {
            float f = it.next().floatValue();
            if (f < m) {
                m = f;
            }
        }
        return m;
    }

    private float max(List<Float> list) {
        if (list == null || list.isEmpty()) {
            return 0.0f;
        }
        float m = list.get(0).floatValue();
        Iterator<Float> it = list.iterator();
        while (it.hasNext()) {
            float f = it.next().floatValue();
            if (f > m) {
                m = f;
            }
        }
        return m;
    }

    private float jitter(List<Float> list) {
        if (list == null || list.size() < 2) {
            return 0.0f;
        }
        float sum = 0.0f;
        for (int i = 1; i < list.size(); i++) {
            sum += Math.abs(list.get(i).floatValue() - list.get(i - 1).floatValue());
        }
        int i2 = list.size();
        return sum / (i2 - 1);
    }

    private void appendMainLog(ScanResult res) {
        TextView tv = new TextView(this);
        tv.setText(String.format(Locale.US, "%s | Sent:%d | Avg:%.1f | Min:%.1f | Max:%.1f | Jit:%.2f | Loss:%.0f%%", res.f0ip, Integer.valueOf(res.sent), Float.valueOf(res.avg), Float.valueOf(res.min), Float.valueOf(res.max), Float.valueOf(res.jitter), Float.valueOf(res.loss)));
        tv.setTextColor(res.alive ? -16711936 : -65536);
        tv.setTextSize(11.0f);
        tv.setPadding(0, 4, 0, 4);
        this.logLayout1.addView(tv);
        this.logScroll1.post(new Runnable() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.this.m3lambda$appendMainLog$21$comippulsescannerMainActivity();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$appendMainLog$21$com-ippulse-scanner-MainActivity, reason: not valid java name */
    /* synthetic */ void m3lambda$appendMainLog$21$comippulsescannerMainActivity() {
        this.logScroll1.fullScroll(130);
    }

    private void appendDeepLog(final String msg) {
        runOnUiThread(new Runnable() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.this.m2lambda$appendDeepLog$23$comippulsescannerMainActivity(msg);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$appendDeepLog$23$com-ippulse-scanner-MainActivity, reason: not valid java name */
    /* synthetic */ void m2lambda$appendDeepLog$23$comippulsescannerMainActivity(String msg) {
        TextView tv = new TextView(this);
        tv.setText(msg);
        tv.setTextColor(-16711936);
        tv.setTextSize(11.0f);
        tv.setPadding(0, 2, 0, 2);
        this.logLayout2.addView(tv);
        this.logScroll2.post(new Runnable() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.this.m1lambda$appendDeepLog$22$comippulsescannerMainActivity();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$appendDeepLog$22$com-ippulse-scanner-MainActivity, reason: not valid java name */
    /* synthetic */ void m1lambda$appendDeepLog$22$comippulsescannerMainActivity() {
        this.logScroll2.fullScroll(130);
    }

    private void addTableHeader(TableLayout tableLayout, boolean isLive) {
        TableRow header = new TableRow(this);
        header.setBackgroundColor(Color.parseColor("#334155"));
        String[] headers = isLive ? new String[]{"IP", "Sent", "Avg", "Min", "Max", "Jitter", "Loss", "Status"} : new String[]{"Rank", "IP", "Sent", "Avg", "Min", "Max", "Jitter", "Loss", "Status"};
        for (String h : headers) {
            TextView tv = new TextView(this);
            tv.setText(h);
            tv.setTextColor(-1);
            tv.setGravity(17);
            tv.setPadding(10, 10, 10, 10);
            tv.setTextSize(11.0f);
            tv.setTypeface(null, 1);
            header.addView(tv);
        }
        tableLayout.addView(header);
    }

    private void addTableRow(TableLayout tableLayout, final ScanResult scanResult, int i, boolean z, boolean z2) {
        String[] strArr;
        TableRow tableRow = new TableRow(this);
        tableRow.setBackgroundColor(Color.parseColor(z2 ? "#FFD700" : "#18181B"));
        tableRow.setClickable(true);
        tableRow.setOnClickListener(new View.OnClickListener() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.m0lambda$addTableRow$24$comippulsescannerMainActivity(scanResult, view);
            }
        });
        if (z) {
            String[] strArr2 = new String[8];
            strArr2[0] = scanResult.f0ip;
            strArr2[1] = String.valueOf(scanResult.sent);
            strArr2[2] = String.format(Locale.US, "%.1f", Float.valueOf(scanResult.avg));
            strArr2[FAST_FAIL_THRESHOLD] = String.format(Locale.US, "%.1f", Float.valueOf(scanResult.min));
            strArr2[4] = String.format(Locale.US, "%.1f", Float.valueOf(scanResult.max));
            strArr2[5] = String.format(Locale.US, "%.2f", Float.valueOf(scanResult.jitter));
            strArr2[6] = String.format(Locale.US, "%.0f%%", Float.valueOf(scanResult.loss));
            strArr2[7] = scanResult.alive ? "ALIVE" : "DEAD";
            strArr = strArr2;
        } else {
            String[] strArr3 = new String[9];
            strArr3[0] = String.valueOf(i);
            strArr3[1] = scanResult.f0ip;
            strArr3[2] = String.valueOf(scanResult.sent);
            strArr3[FAST_FAIL_THRESHOLD] = String.format(Locale.US, "%.1f", Float.valueOf(scanResult.avg));
            strArr3[4] = String.format(Locale.US, "%.1f", Float.valueOf(scanResult.min));
            strArr3[5] = String.format(Locale.US, "%.1f", Float.valueOf(scanResult.max));
            strArr3[6] = String.format(Locale.US, "%.2f", Float.valueOf(scanResult.jitter));
            strArr3[7] = String.format(Locale.US, "%.0f%%", Float.valueOf(scanResult.loss));
            strArr3[8] = scanResult.alive ? "ALIVE" : "DEAD";
            strArr = strArr3;
        }
        for (String str : strArr) {
            TextView textView = new TextView(this);
            textView.setText(str);
            textView.setTextColor(z2 ? -16777216 : -1);
            textView.setGravity(17);
            textView.setPadding(10, 10, 10, 10);
            textView.setTextSize(11.0f);
            tableRow.addView(textView);
        }
        tableLayout.addView(tableRow);
        fetchFlag((TextView) tableRow.getChildAt(!z ? 1 : 0), scanResult.f0ip);
    }

    /* JADX INFO: renamed from: lambda$addTableRow$24$com-ippulse-scanner-MainActivity, reason: not valid java name */
    /* synthetic */ void m0lambda$addTableRow$24$comippulsescannerMainActivity(ScanResult res, View v) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService("clipboard");
        ClipData clip = ClipData.newPlainText("IP", res.f0ip);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(this, "IP Copied: " + res.f0ip, 0).show();
    }

    private void fetchFlag(final TextView textView, final String ip) {
        new Thread(new Runnable() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.this.m4lambda$fetchFlag$26$comippulsescannerMainActivity(ip, textView);
            }
        }).start();
    }

    /* JADX INFO: renamed from: lambda$fetchFlag$26$com-ippulse-scanner-MainActivity, reason: not valid java name */
    /* synthetic */ void m4lambda$fetchFlag$26$comippulsescannerMainActivity(final String ip, final TextView textView) {
        final String flag = getCountryFlag(ip);
        runOnUiThread(new Runnable() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                textView.setText(flag + " " + ip);
            }
        });
    }

    private String getCountryFlag(String ip) {
        String[] urls = {"http://ip-api.com/json/" + ip + "?fields=countryCode", "http://ipwho.is/" + ip, "https://ipinfo.io/" + ip + "/json"};
        int length = urls.length;
        for (int i = 0; i < length; i++) {
            String urlStr = urls[i];
            try {
                String code = queryCountryCode(urlStr);
                if (!code.isEmpty()) {
                    return countryCodeToFlag(code);
                }
                continue;
            } catch (Exception e) {
            }
        }
        return "🌐";
    }

    private String queryCountryCode(String urlStr) throws Exception {
        HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
        conn.setConnectTimeout(3000);
        conn.setReadTimeout(3000);
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            sb.append(line);
        }
        reader.close();
        conn.disconnect();
        JSONObject json = new JSONObject(sb.toString());
        String code = json.optString("countryCode", "");
        if (code.isEmpty()) {
            code = json.optString("country_code", "");
        }
        if (code.isEmpty()) {
            code = json.optString("country", "");
        }
        if (code.length() != 2) {
            String countryName = code.toLowerCase();
            return countryName.contains("united arab") ? "AE" : countryName.contains("germany") ? "DE" : countryName.contains("iran") ? "IR" : countryName.contains("netherlands") ? "NL" : countryName.contains("france") ? "FR" : countryName.contains("singapore") ? "SG" : countryName.contains("united states") ? "US" : countryName.contains("united kingdom") ? "GB" : countryName.contains("russia") ? "RU" : countryName.contains("china") ? "CN" : countryName.contains("japan") ? "JP" : countryName.contains("south korea") ? "KR" : countryName.contains("taiwan") ? "TW" : countryName.contains("hong kong") ? "HK" : countryName.contains("india") ? "IN" : countryName.contains("brazil") ? "BR" : countryName.contains("canada") ? "CA" : countryName.contains("australia") ? "AU" : countryName.contains("italy") ? "IT" : countryName.contains("spain") ? "ES" : countryName.contains("portugal") ? "PT" : countryName.contains("sweden") ? "SE" : countryName.contains("norway") ? "NO" : countryName.contains("denmark") ? "DK" : countryName.contains("finland") ? "FI" : countryName.contains("poland") ? "PL" : countryName.contains("turkey") ? "TR" : countryName.contains("saudi") ? "SA" : countryName.contains("qatar") ? "QA" : countryName.contains("kuwait") ? "KW" : countryName.contains("bahrain") ? "BH" : countryName.contains("oman") ? "OM" : "";
        }
        return code;
    }

    private String countryCodeToFlag(String code) {
        if (code == null || code.length() != 2) {
            return "🌐";
        }
        int first = (code.charAt(0) - 'A') + 127462;
        int second = (code.charAt(1) - 'A') + 127462;
        return new String(Character.toChars(first)) + new String(Character.toChars(second));
    }

    private int parseNum(EditText editText, int defaultVal) {
        try {
            return Integer.parseInt(editText.getText().toString().trim());
        } catch (Exception e) {
            return defaultVal;
        }
    }

    private List<String> parseIPList(String query) {
        List<String> list = new ArrayList<>();
        String q = query.replace("تا", "-").trim();
        try {
            if (q.contains("/")) {
                String[] parts = q.split("/");
                String base = parts[0].trim();
                int prefix = Integer.parseInt(parts[1].trim());
                long ip = ipToLong(base);
                int hostBits = 32 - prefix;
                long mask = hostBits == 32 ? 4294967295L : (1 << hostBits) - 1;
                long end = ip | mask;
                long i = (~mask) & ip;
                while (i <= end) {
                    list.add(longToIp(i));
                    i++;
                    parts = parts;
                }
            } else if (q.contains("-")) {
                String[] parts2 = q.split("-");
                long start = ipToLong(parts2[0].trim());
                long end2 = ipToLong(parts2[1].trim());
                if (start > end2) {
                    start = end2;
                    end2 = start;
                }
                for (long i2 = start; i2 <= end2; i2++) {
                    list.add(longToIp(i2));
                }
            } else {
                list.add(q);
            }
        } catch (Exception e) {
            list.clear();
            list.add(q);
        }
        return list;
    }

    private long ipToLong(String ip) {
        String[] octets = ip.trim().split("\\.");
        if (octets.length != 4) {
            throw new IllegalArgumentException("Invalid IP");
        }
        long result = 0;
        for (String octet : octets) {
            int val = Integer.parseInt(octet.trim());
            if (val < 0 || val > 255) {
                throw new IllegalArgumentException("Invalid octet");
            }
            result = (result << 8) | ((long) val);
        }
        return 4294967295L & result;
    }

    private String longToIp(long ip) {
        return String.format(Locale.US, "%d.%d.%d.%d", Long.valueOf((ip >> 24) & 255), Long.valueOf((ip >> 16) & 255), Long.valueOf((ip >> 8) & 255), Long.valueOf(255 & ip));
    }

    private void saveHistory(String entry) {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, 0);
        Set<String> history = new LinkedHashSet<>(prefs.getStringSet(HISTORY_KEY, new LinkedHashSet()));
        history.add(entry);
        prefs.edit().putStringSet(HISTORY_KEY, history).apply();
    }

    private Set<String> loadHistory() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, 0);
        return new LinkedHashSet(prefs.getStringSet(HISTORY_KEY, new LinkedHashSet()));
    }

    private void clearHistory() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, 0);
        prefs.edit().remove(HISTORY_KEY).apply();
        Toast.makeText(this, "History cleared", 0).show();
    }

    private void showHistoryDialog() {
        List<String> items = new ArrayList<>(loadHistory());
        if (items.isEmpty()) {
            Toast.makeText(this, "No history yet", 0).show();
        } else {
            final String[] arr = (String[]) items.toArray(new String[0]);
            new AlertDialog.Builder(this).setTitle("History").setItems(arr, new DialogInterface.OnClickListener() { // from class: com.ippulse.scanner.MainActivity$$ExternalSyntheticLambda20
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    MainActivity.this.m13lambda$showHistoryDialog$27$comippulsescannerMainActivity(arr, dialogInterface, i);
                }
            }).show();
        }
    }

    /* JADX INFO: renamed from: lambda$showHistoryDialog$27$com-ippulse-scanner-MainActivity, reason: not valid java name */
    /* synthetic */ void m13lambda$showHistoryDialog$27$comippulsescannerMainActivity(String[] arr, DialogInterface dialog, int which) {
        this.ipInput.setText(arr[which]);
        startRangeScan();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class ScanResult {
        boolean alive;
        float avg;

        /* JADX INFO: renamed from: ip */
        String f0ip;
        float jitter;
        float loss;
        float max;
        float min;
        int sent;

        ScanResult(String ip, float avg, float min, float max, float jitter, float loss, boolean alive, int sent) {
            this.f0ip = ip;
            this.avg = avg;
            this.min = min;
            this.max = max;
            this.jitter = jitter;
            this.loss = loss;
            this.sent = sent;
            this.alive = alive;
        }
    }
    private void loadVpnSettings() {
        SharedPreferences prefs = getSharedPreferences(VPN_PREFS, MODE_PRIVATE);
        vpnDns.setText(prefs.getString("dns", "8.8.8.8"));
        vpnMtu.setText(prefs.getString("mtu", "247"));
        vpnMasterIp.setText(prefs.getString("masterIp", "109.61.42.251"));
        vpnHosts.setText(prefs.getString("hosts", ""));
                                                                if (vpnHosts.getText().toString().trim().isEmpty()) {
            String defaultIp = vpnMasterIp.getText().toString().trim();
            StringBuilder sb = new StringBuilder();
            for (String domain : defaultDomains) {
                sb.append(defaultIp).append(" ").append(domain).append("\n");
            }
            vpnHosts.setText(sb.toString().trim());
        }
    }
    private void saveVpnSettings() {
        SharedPreferences prefs = getSharedPreferences(VPN_PREFS, MODE_PRIVATE);
        prefs.edit()
            .putString("dns", vpnDns.getText().toString().trim())
            .putString("hosts", vpnHosts.getText().toString().trim())
            .putString("mtu", vpnMtu.getText().toString().trim())
            .putString("masterIp", vpnMasterIp.getText().toString().trim())
                                                                        .apply();
    }
    private void applyMasterIp() {
        String masterIp = vpnMasterIp.getText().toString().trim();
        if (masterIp.isEmpty()) {
            Toast.makeText(this, "لطفاً یک IP وارد کنید", Toast.LENGTH_SHORT).show();
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String domain : defaultDomains) {
            sb.append(masterIp).append(" ").append(domain).append("\n");
        }
        vpnHosts.setText(sb.toString().trim());
        saveVpnSettings();
        Toast.makeText(this, "IP به همه دامنه‌ها اعمال شد", Toast.LENGTH_SHORT).show();
    }
    private String hostsMapToString(HashMap<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getValue()).append(" ").append(entry.getKey()).append("\n");
        }
        return sb.toString();
    }
    private void stopVpn() {
        vpnStatus.setText("VPN: Stopping");

        Intent intent =
                new Intent(this, VhostsService.class)
                        .setAction(VhostsService.ACTION_DISCONNECT);

        startService(intent);

        vpnStatus.setText("VPN: Stopped");
        Toast.makeText(this, "VPN stopped", Toast.LENGTH_SHORT).show();
    }
    private void startVpn() {
        saveVpnSettings();
        String dns = vpnDns.getText().toString().trim();
        HashMap<String, String> hostsMap = parseHosts(vpnHosts.getText().toString());

        if (Build.VERSION.SDK_INT >= 33) {
            if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, REQUEST_NOTIFICATION);
                return;
            }
        }

        Intent intent = VpnService.prepare(this);
        if (intent != null) {
            startActivityForResult(intent, REQUEST_VPN);
        } else {
            int mtu = parseIntSafe(vpnMtu.getText().toString().trim(), 247);
            startVhostsService(mtu, hostsMap);
            vpnStatus.setText("VPN: Connected");
            Toast.makeText(this, "VPN started", Toast.LENGTH_SHORT).show();
        }
    }
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_NOTIFICATION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startVpn();
            } else {
                Toast.makeText(this, "Notification permission required for VPN", Toast.LENGTH_SHORT).show();
            }
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_VPN && resultCode == RESULT_OK) {
            HashMap<String, String> hostsMap = parseHosts(vpnHosts.getText().toString());
            int mtu = parseIntSafe(vpnMtu.getText().toString().trim(), 247);
            startVhostsService(mtu, hostsMap);
            vpnStatus.setText("VPN: Connected");
            Toast.makeText(this, "VPN started", Toast.LENGTH_SHORT).show();
        } else if (requestCode == REQUEST_VPN) {
            Toast.makeText(this, "VPN permission denied", Toast.LENGTH_SHORT).show();
        }
    }
    private HashMap<String, String> parseHosts(String text) {
        HashMap<String, String> map = new HashMap<>();
        if (text == null || text.trim().isEmpty()) return map;
        String[] lines = text.split("\\n");
        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty() || line.startsWith("#")) continue;
            String[] parts = line.split("\\s+");
            if (parts.length >= 2) {
                String ip = parts[0];
                String domain = parts[1].toLowerCase();
                map.put(domain, ip);
            }
        }
        return map;
    }
    private int parseIntSafe(String s, int defaultVal) {
        try { return Integer.parseInt(s); } catch (Exception e) { return defaultVal; }
    }
    private void startVhostsService(
        int mtu,
        HashMap<String, String> hostsMap
) {
    Intent serviceIntent = new Intent(this, VhostsService.class);

    serviceIntent.setAction(VhostsService.ACTION_CONNECT);

    serviceIntent.putExtra("mtu", mtu);

    serviceIntent.putExtra(
        "dns",
        vpnDns.getText().toString().trim()
    );

    StringBuilder hostsText = new StringBuilder();

    for (Map.Entry<String, String> entry : hostsMap.entrySet()) {
        hostsText
            .append(entry.getValue())
            .append(" ")
            .append(entry.getKey())
            .append("\n");
    }

    serviceIntent.putExtra(
        "hosts",
        hostsText.toString()
    );

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        startForegroundService(serviceIntent);
    } else {
        startService(serviceIntent);
    }
}
}
