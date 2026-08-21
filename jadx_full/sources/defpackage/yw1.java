package defpackage;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.ProxyInfo;
import android.net.VpnService;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.SystemClock;
import android.system.OsConstants;
import android.util.Log;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.service.SurfboardVpn;
import com.getsurfboard.vpn.Jni;
import com.getsurfboard.vpn.JniKt;
import com.getsurfboard.xray.XRay;
import com.tencent.mars.xlog.Xlog;
import io.sentry.android.core.a1;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class yw1 extends VpnService {
    public static boolean G0;
    public ParcelFileDescriptor A;
    public on3 A0;
    public String C0;
    public String D0;
    public xw1 X;
    public Handler Y;
    public boolean Z;
    public us2 b;
    public Jni f;
    public t53 z;
    public rs4 y0 = new rs4();
    public final ww1 z0 = new ww1(this, 0);
    public List B0 = g41.b;
    public final vw1 E0 = new vw1(0);
    public final ww1 F0 = new ww1(this, 1);

    public final void a(VpnService.Builder builder, Set set, boolean z) {
        String str;
        String str2;
        try {
            if (set.isEmpty()) {
                builder.addDisallowedApplication("com.android.shell");
                builder.addDisallowedApplication("com.oplus.ocar");
                return;
            }
            if (z) {
                builder.addAllowedApplication(getPackageName());
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    String str3 = (String) it.next();
                    builder.addAllowedApplication(str3);
                    String str4 = "addAllowedApplication: " + str3;
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str4);
                        str2 = str4;
                    } else {
                        str2 = str4;
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("IVpnService", str2, null);
                    }
                }
                return;
            }
            Iterator it2 = set.iterator();
            while (it2.hasNext()) {
                String str5 = (String) it2.next();
                builder.addDisallowedApplication(str5);
                String str6 = "addDisallowedApplication: " + str5;
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str6);
                    str = str6;
                } else {
                    str = str6;
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("IVpnService", str, null);
                }
            }
            builder.addDisallowedApplication("com.android.shell");
            builder.addDisallowedApplication("com.oplus.ocar").getClass();
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public final void b() {
        l(null);
        m(g41.b);
        n(null);
        k(null);
    }

    public final void c(Intent intent, t53 t53Var) {
        boolean z;
        String str;
        String str2;
        us2 us2Var;
        i94 i94VarO;
        this.z = t53Var;
        rs4 rs4Var = (rs4) r25.A(intent, "vpn_config", rs4.class);
        if (rs4Var == null) {
            rs4Var = new rs4();
        }
        this.y0 = rs4Var;
        this.f = new Jni(this);
        v9.r(this, this.z0, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), 2);
        v9.r(this, this.F0, new IntentFilter("android.net.wifi.STATE_CHANGE"), 2);
        String strConcat = "vpn establishing: ".concat(ContextUtilsKt.j());
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("IVpnService", strConcat, null);
        }
        String str3 = "VpnConfig: " + this.y0;
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str3);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("IVpnService", str3, null);
        }
        try {
            int iOrdinal = this.y0.D0.ordinal();
            if (iOrdinal != 0) {
                z = true;
                if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        throw new t80();
                    }
                    z = false;
                }
            } else {
                z = t53Var.A;
            }
            String str4 = "IPv6 override: " + this.y0.D0 + ", effective: " + z;
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str4);
                str = str4;
            } else {
                str = str4;
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("IVpnService", str, null);
            }
            VpnService.Builder builder = new VpnService.Builder(this);
            builder.setSession(j().b);
            builder.setConfigureIntent(d());
            builder.addAddress(JniKt.getTunAddress(), 32);
            builder.addAddress(JniKt.getXRayAddress(), 32);
            if (z) {
                builder.addAddress(JniKt.getTun6Address(), 32);
            }
            if (j().D0.isEmpty()) {
                builder.addDnsServer(JniKt.getDnsPlaceholder0());
                builder.addDnsServer(JniKt.getDnsPlaceholder1()).getClass();
            } else {
                for (InetSocketAddress inetSocketAddress : j().D0) {
                    if (inetSocketAddress.isUnresolved() && n12.c(inetSocketAddress.getHostName(), "system")) {
                        builder.addDnsServer(JniKt.getDnsPlaceholder0());
                        builder.addDnsServer(JniKt.getDnsPlaceholder1());
                    } else {
                        builder.addDnsServer(inetSocketAddress.getAddress());
                    }
                }
            }
            if (this.y0.X) {
                for (Map.Entry entry : zw1.a.entrySet()) {
                    builder.addRoute((String) entry.getKey(), ((Number) entry.getValue()).intValue());
                }
                if (z) {
                    for (Map.Entry entry2 : zw1.b.entrySet()) {
                        builder.addRoute((String) entry2.getKey(), ((Number) entry2.getValue()).intValue());
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 33) {
                for (Map.Entry entry3 : zw1.a.entrySet()) {
                    builder.addRoute((String) entry3.getKey(), ((Number) entry3.getValue()).intValue());
                }
                for (e03 e03Var : zw1.e) {
                    ha0.s();
                    builder.excludeRoute(f11.a((InetAddress) e03Var.b, ((Number) e03Var.f).intValue()));
                }
                if (z) {
                    for (Map.Entry entry4 : zw1.b.entrySet()) {
                        builder.addRoute((String) entry4.getKey(), ((Number) entry4.getValue()).intValue());
                    }
                    for (e03 e03Var2 : zw1.f) {
                        ha0.s();
                        builder.excludeRoute(f11.a((InetAddress) e03Var2.b, ((Number) e03Var2.f).intValue()));
                    }
                }
            } else {
                for (Map.Entry entry5 : zw1.d.entrySet()) {
                    builder.addRoute((String) entry5.getKey(), ((Number) entry5.getValue()).intValue());
                }
                if (z) {
                    for (Map.Entry entry6 : zw1.c.entrySet()) {
                        builder.addRoute((String) entry6.getKey(), ((Number) entry6.getValue()).intValue());
                    }
                }
            }
            if (!t53Var.A) {
                builder.allowFamily(OsConstants.AF_INET);
            }
            rs4 rs4Var2 = this.y0;
            a(builder, rs4Var2.A, rs4Var2.z);
            builder.setMtu(this.y0.I0);
            if (Build.VERSION.SDK_INT >= 29) {
                builder.setMetered(false);
                if (this.y0.K0 && (i94VarO = e().o()) != null) {
                    while (true) {
                        InetSocketAddress inetSocketAddress2 = i94VarO.l;
                        if ((inetSocketAddress2 != null ? inetSocketAddress2.getPort() : 0) != 0) {
                            break;
                        } else {
                            Thread.sleep(10L);
                        }
                    }
                    InetSocketAddress inetSocketAddress3 = i94VarO.l;
                    int port = inetSocketAddress3 != null ? inetSocketAddress3.getPort() : 0;
                    ArrayList<e03> arrayListM0 = d70.m0(zw1.e, zw1.f);
                    ArrayList arrayList = new ArrayList(f70.Q(10, arrayListM0));
                    for (e03 e03Var3 : arrayListM0) {
                        arrayList.add(((InetAddress) e03Var3.b).getHostAddress() + "/" + e03Var3.f);
                    }
                    builder.setHttpProxy(ProxyInfo.buildDirectProxy("127.0.0.1", port, arrayList));
                }
            }
            if (this.y0.E0) {
                builder.allowBypass();
            }
            ParcelFileDescriptor parcelFileDescriptorEstablish = builder.establish();
            this.A = parcelFileDescriptorEstablish;
            String str5 = "vpn established: " + parcelFileDescriptorEstablish;
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str5);
                str2 = str5;
            } else {
                str2 = str5;
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("IVpnService", str2, null);
            }
            tj4.n();
            if (this.A != null) {
                while (this.X == null) {
                    Thread.sleep(500L);
                }
                zw1.g = SystemClock.elapsedRealtime();
                if (G0 && (us2Var = this.b) != null) {
                    f(us2Var, j().b);
                    this.b = us2Var;
                    if (Build.VERSION.SDK_INT >= 34) {
                        startForeground(R.id.vpn_notification, us2Var.a(), 1024);
                    } else {
                        startForeground(R.id.vpn_notification, us2Var.a());
                    }
                }
                Jni jniE = e();
                ParcelFileDescriptor parcelFileDescriptor = this.A;
                parcelFileDescriptor.getClass();
                jniE.n(parcelFileDescriptor.getFd(), Build.VERSION.SDK_INT, this.y0.Z, z);
                ParcelFileDescriptor parcelFileDescriptor2 = this.A;
                if (parcelFileDescriptor2 != null) {
                    parcelFileDescriptor2.close();
                }
                this.A = null;
                this.z = null;
            }
        } catch (Exception e) {
            g(e);
        }
    }

    public abstract PendingIntent d();

    public final Jni e() {
        Jni jni = this.f;
        if (jni != null) {
            return jni;
        }
        n12.T("jni");
        throw null;
    }

    public abstract us2 f(us2 us2Var, String str);

    public final void g(Exception exc) {
        exc.printStackTrace();
        new Handler(Looper.getMainLooper()).post(new ga1(7, exc));
        on2 on2Var = ws4.d;
        Boolean bool = Boolean.FALSE;
        on2Var.i(bool);
        stopSelf();
        ws4.c.i(new vs4());
        ws4.b.i(bool);
    }

    public final void h(eg4 eg4Var) {
        us2 us2Var;
        if (!G0 || (us2Var = this.b) == null) {
            return;
        }
        SurfboardVpn surfboardVpn = (SurfboardVpn) this;
        Notification notification = us2Var.s;
        long j = eg4Var.h;
        long j2 = eg4Var.g;
        long j3 = eg4Var.d;
        long j4 = eg4Var.c;
        if (!t23.c(R.string.setting_display_network_speed_in_status_bar_key, true)) {
            notification.icon = R.drawable.ic_stat_vpn;
        } else if (t23.E()) {
            notification.icon = kr2.a(j4 + j3);
        } else {
            notification.icon = kr2.a(j2 + j);
        }
        if (!t23.c(R.string.setting_accessibility_mode_key, false)) {
            if (t23.E()) {
                eu euVarQ = ji0.q(j4, true);
                String strConcat = euVarQ.a.concat(euVarQ.b);
                eu euVarQ2 = ji0.q(j3, true);
                us2Var.c(surfboardVpn.getString(R.string.speed_template, strConcat, euVarQ2.a.concat(euVarQ2.b)));
                eu euVarQ3 = ji0.q(eg4Var.a, true);
                String strConcat2 = euVarQ3.a.concat(euVarQ3.b);
                eu euVarQ4 = ji0.q(eg4Var.b, true);
                us2Var.l = us2.b(surfboardVpn.getString(R.string.traffic_template, strConcat2, euVarQ4.a.concat(euVarQ4.b)));
            } else {
                eu euVarQ5 = ji0.q(j2, true);
                String strConcat3 = euVarQ5.a.concat(euVarQ5.b);
                eu euVarQ6 = ji0.q(j, true);
                us2Var.c(surfboardVpn.getString(R.string.speed_template, strConcat3, euVarQ6.a.concat(euVarQ6.b)));
                eu euVarQ7 = ji0.q(eg4Var.e, true);
                String strConcat4 = euVarQ7.a.concat(euVarQ7.b);
                eu euVarQ8 = ji0.q(eg4Var.f, true);
                us2Var.l = us2.b(surfboardVpn.getString(R.string.traffic_template, strConcat4, euVarQ8.a.concat(euVarQ8.b)));
            }
        }
        this.b = us2Var;
        try {
            if (Build.VERSION.SDK_INT >= 34) {
                startForeground(R.id.vpn_notification, us2Var.a(), 1024);
            } else {
                startForeground(R.id.vpn_notification, us2Var.a());
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public final void i() {
        Object systemService = getApplicationContext().getSystemService("wifi");
        systemService.getClass();
        WifiInfo connectionInfo = ((WifiManager) systemService).getConnectionInfo();
        if (connectionInfo == null) {
            return;
        }
        String ssid = connectionInfo.getSSID();
        ssid.getClass();
        String strG0 = p44.G0("\"", p44.F0(ssid, "\""));
        if (strG0.equals("<unknown ssid>")) {
            strG0 = null;
        }
        n(strG0);
        k(n12.c(connectionInfo.getBSSID(), "02:00:00:00:00:00") ? null : connectionInfo.getBSSID());
    }

    public final t53 j() {
        t53 t53Var = this.z;
        if (t53Var != null) {
            return t53Var;
        }
        xe.q("profile is null");
        return null;
    }

    public final void k(String str) {
        if (n12.c(this.D0, str)) {
            return;
        }
        this.D0 = str;
        String strN = ha0.n("bssid changed to ", str);
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN);
        }
        if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
            return;
        }
        Log.d("IVpnService", strN, null);
    }

    public final void l(on3 on3Var) {
        this.A0 = on3Var;
        String str = "networkType changed to " + on3Var;
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
        }
        if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
            return;
        }
        Log.d("IVpnService", str, null);
    }

    public final void m(List list) {
        this.B0 = list;
        String str = "routerIP changed to " + list;
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
        }
        if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
            return;
        }
        Log.d("IVpnService", str, null);
    }

    public final void n(String str) {
        if (n12.c(this.C0, str)) {
            return;
        }
        this.C0 = str;
        String strN = ha0.n("ssid changed to ", str);
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN);
        }
        if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
            return;
        }
        Log.d("IVpnService", strN, null);
    }

    public final void o() {
        us2 us2Var = this.b;
        if (us2Var == null) {
            SurfboardVpn surfboardVpn = (SurfboardVpn) this;
            us2 us2Var2 = new us2(surfboardVpn, "vpn");
            boolean zC = t23.c(R.string.setting_display_network_speed_in_status_bar_key, true);
            Notification notification = us2Var2.s;
            if (zC) {
                notification.icon = kr2.a(0L);
            } else {
                notification.icon = R.drawable.ic_stat_vpn;
            }
            us2Var2.e = us2.b(surfboardVpn.getString(R.string.starting_vpn));
            us2Var2.j = t23.d(ContextUtilsKt.k(R.string.setting_notification_chronometer), true);
            us2Var2.n = "service";
            us2Var2.m = true;
            us2Var2.p = -1;
            us2Var2.t = true;
            us2Var2.g = surfboardVpn.d();
            this.b = us2Var2;
            us2Var = us2Var2;
        }
        try {
            if (Build.VERSION.SDK_INT >= 34) {
                startForeground(R.id.vpn_notification, us2Var.a(), 1024);
            } else {
                startForeground(R.id.vpn_notification, us2Var.a());
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "onCreate() called");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("IVpnService", "onCreate() called", null);
        }
        super.onCreate();
        v9.r(this, this.E0, new IntentFilter("android.os.action.DEVICE_IDLE_MODE_CHANGED"), 4);
        ws4.a.l(Boolean.TRUE);
        if (G0) {
            o();
        }
        xw1 xw1Var = new xw1(this);
        xw1Var.start();
        this.X = xw1Var;
    }

    @Override // android.app.Service
    public void onDestroy() {
        tk3 tk3Var;
        List listK;
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "onDestroy() called");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("IVpnService", "onDestroy() called", null);
        }
        ws4.a.l(Boolean.FALSE);
        try {
            unregisterReceiver(this.z0);
            unregisterReceiver(this.F0);
            unregisterReceiver(this.E0);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        Handler handler = this.Y;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.Y = null;
        xw1 xw1Var = this.X;
        if (xw1Var != null) {
            xw1Var.quit();
        }
        super.onDestroy();
        if (this.Z) {
            this.Z = false;
            SurfboardVpn surfboardVpn = (SurfboardVpn) this;
            t53 t53Var = (t53) d73.c.d();
            if (t53Var == null) {
                if (fy4.b) {
                    Xlog.logWrite2(0L, 3, "SurfboardVpn", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "onAlwaysOnVpnTurnedOn: selected profile is null");
                }
                if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
                    return;
                }
                a1.o("SurfboardVpn", "onAlwaysOnVpnTurnedOn: selected profile is null", null);
                return;
            }
            try {
                HashMap mapW = ji0.w(t53Var);
                if (t23.c(R.string.setting_override_lan_share_key, false)) {
                    String str = n12.c(t23.u(), t23.b[0]) ? "0.0.0.0" : "127.0.0.1";
                    listK = e70.K(new InetSocketAddress(str, t23.s()), new InetSocketAddress(str, t23.v()));
                } else {
                    listK = null;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (ls1 ls1Var : oj0.a.s().a()) {
                    try {
                        String str2 = ls1Var.f;
                        List listL0 = p44.L0(ls1Var.z, new String[]{","}, 6);
                        ArrayList arrayList = new ArrayList(f70.Q(10, listL0));
                        Iterator it = listL0.iterator();
                        while (it.hasNext()) {
                            arrayList.add(p44.U0((String) it.next()).toString());
                        }
                        String[] strArr = (String[]) arrayList.toArray(new String[0]);
                        e03 e03VarG = ye.g(str2, (String[]) Arrays.copyOf(strArr, strArr.length), null, null, null);
                        linkedHashMap.put(e03VarG.b, e03VarG.f);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                boolean zH = t23.q() ? t23.H() : false;
                Set setE = t23.q() ? t23.e(zH) : k41.b;
                Object objD = t23.d.d();
                objD.getClass();
                rs4 rs4Var = new rs4((xw2) objD, mapW, zH, setE, t23.c(R.string.setting_allow_lan_key, false), t23.c(R.string.setting_auto_fix_dns_poisoning_key, true), t23.i(), t23.c(R.string.setting_bypass_tls_verify_key, false), t23.c(R.string.setting_force_udp_relay_key, false), t23.c(R.string.setting_force_remote_dns_key, true), listK, t23.r(), t23.t(), t23.c(R.string.setting_allow_bypass_key, true), t23.a(), t23.G(), t23.c(R.string.setting_tcp_keep_alive_key, false), t23.j(), linkedHashMap, t23.b());
                Intent intent = new Intent(surfboardVpn, (Class<?>) SurfboardVpn.class);
                k2.l(new FileOutputStream(zw1.b()), t53Var);
                intent.putExtra("start", true);
                intent.putExtra("vpn_config", rs4Var);
                if (G0) {
                    try {
                        v9.z(surfboardVpn, intent);
                        return;
                    } catch (SecurityException e3) {
                        tk3Var = new tk3(e3);
                    }
                } else {
                    try {
                        surfboardVpn.startService(intent);
                        return;
                    } catch (Exception e4) {
                        tk3Var = new tk3(e4);
                    }
                }
            } catch (Exception e5) {
                tk3Var = new tk3(e5);
            }
            Throwable thA = uk3.a(tk3Var);
            thA.getClass();
            p95.D(r25.D(thA));
        }
    }

    @Override // android.net.VpnService
    public final void onRevoke() {
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "onRevoke() called");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("IVpnService", "onRevoke() called", null);
        }
        String strConcat = "vpn revoked: ".concat(ContextUtilsKt.j());
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("IVpnService", strConcat, null);
        }
        if (this.f != null) {
            e().p();
        } else {
            stopSelf();
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        String str = "onStartCommand() called with: intent = " + intent + ", flags = " + i + ", startId = " + i2;
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("IVpnService", str, null);
        }
        if (G0) {
            o();
        }
        int i3 = 1;
        boolean z = this.f != null;
        if (intent != null && intent.getBooleanExtra("stop", false) && z) {
            e().p();
            return 2;
        }
        if (intent != null && intent.getBooleanExtra("change_proxy_group", false) && z) {
            String str2 = "changeProxyGroup() called with: intent = " + intent + ", flags = " + i + ", startId = " + i2;
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str2);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("IVpnService", str2, null);
            }
            String stringExtra = intent.getStringExtra("profile_name");
            if (stringExtra == null) {
                xe.q("profile_name not found");
                return 0;
            }
            String stringExtra2 = intent.getStringExtra("group_name");
            if (stringExtra2 == null) {
                xe.q("group_name not found");
                return 0;
            }
            String stringExtra3 = intent.getStringExtra("proxy_name");
            if (stringExtra3 == null) {
                xe.q("proxy_name not found");
                return 0;
            }
            boolean booleanExtra = intent.getBooleanExtra("manually", false);
            t53 t53Var = this.z;
            if (t53Var == null || !n12.c(t53Var.b, stringExtra)) {
                String strU = fw.u("change proxy group failed: profile ", stringExtra, " group ", stringExtra2);
                if (fy4.b) {
                    Xlog.logWrite2(0L, 4, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strU);
                }
                if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
                    return 2;
                }
                a1.e("IVpnService", strU, null);
                return 2;
            }
            if ((!t53Var.H0.containsKey(stringExtra2) && !n12.c(t53Var.I0.b, stringExtra2)) || !this.y0.f.keySet().contains(stringExtra2)) {
                return 2;
            }
            this.y0.f.put(stringExtra2, stringExtra3);
            String str3 = booleanExtra ? " manually" : "";
            StringBuilder sbE = fw.E(stringExtra, " group ", stringExtra2, " change to ", stringExtra3);
            sbE.append(str3);
            String string = sbE.toString();
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, string);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("IVpnService", string, null);
            }
            Collection collectionValues = t53Var.G0.values();
            collectionValues.getClass();
            if (!collectionValues.isEmpty()) {
                Iterator it = collectionValues.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (n12.c(((ea3) it.next()).q(), stringExtra2)) {
                        String strO = ha0.o("Group '", stringExtra2, "' is used as underlying-proxy, triggering XRay hot restart");
                        if (fy4.b) {
                            Xlog.logWrite2(0L, 1, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strO);
                        }
                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                            Log.d("IVpnService", strO, null);
                        }
                        Jni jniE = e();
                        if (fy4.b) {
                            Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "restartXRay() called");
                        }
                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                            Log.d("Jni", "restartXRay() called", null);
                        }
                        int iOrdinal = jniE.a.y0.D0.ordinal();
                        if (iOrdinal == 0) {
                            jniE.a.j();
                        } else if (iOrdinal != 1 && iOrdinal != 2) {
                            g.d();
                            return 0;
                        }
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        jniE.e.b();
                        XRay xRay = jniE.e;
                        String xRayAddress = JniKt.getXRayAddress();
                        LinkedHashSet linkedHashSetN = t53.n(jniE.a.j());
                        yw1 yw1Var = jniE.a;
                        rs4 rs4Var = yw1Var.y0;
                        String strA = xRay.a(xRayAddress, linkedHashSetN, rs4Var.y0, rs4Var.z0, rs4Var.G0, rs4Var.H0, yw1Var.j(), jniE.a.y0.f);
                        if (strA == null) {
                            String str4 = "XRay hot restart completed in " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms";
                            if (fy4.b) {
                                Xlog.logWrite2(0L, 1, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str4);
                            }
                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                Log.d("Jni", str4, null);
                            }
                        } else {
                            String strConcat = "XRay hot restart failed: ".concat(strA);
                            if (fy4.b) {
                                Xlog.logWrite2(0L, 4, "Jni", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
                            }
                            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                                a1.e("Jni", strConcat, null);
                            }
                            p95.D(strA);
                            jniE.p();
                        }
                    }
                }
            }
            if (!booleanExtra) {
                return 2;
            }
            e().resetAllTCPConnections();
            return 2;
        }
        if (intent != null && intent.getBooleanExtra("start_speedometer", false) && z) {
            String str5 = "startSpeedometer() called with: intent = " + intent + ", flags = " + i + ", startId = " + i2;
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str5);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("IVpnService", str5, null);
            }
            String stringExtra4 = intent.getStringExtra("profile_name");
            if (stringExtra4 == null) {
                xe.q("profile_name not found");
                return 0;
            }
            String stringExtra5 = intent.getStringExtra("group_name");
            if (stringExtra5 == null) {
                xe.q("group_name not found");
                return 0;
            }
            String stringExtra6 = intent.getStringExtra("session_id");
            if (stringExtra6 == null) {
                xe.q("session_id not found");
                return 0;
            }
            if (this.z == null || !n12.c(j().b, stringExtra4) || (!j().H0.containsKey(stringExtra5) && !n12.c(j().I0.b, stringExtra5))) {
                String strU2 = fw.u("start speedometer failed: profile ", stringExtra4, " group ", stringExtra5);
                if (fy4.b) {
                    Xlog.logWrite2(0L, 4, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strU2);
                }
                if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
                    return 2;
                }
                a1.e("IVpnService", strU2, null);
                return 2;
            }
            String strU3 = fw.u("start speedometer: profile ", stringExtra4, " group ", stringExtra5);
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strU3);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("IVpnService", strU3, null);
            }
            na3 na3Var = (na3) j().H0.get(stringExtra5);
            if (na3Var == null) {
                if (!n12.c(j().I0.b, stringExtra5)) {
                    throw new IllegalStateException(("ProxyGroup " + stringExtra5 + " not found").toString());
                }
                na3Var = j().I0;
            }
            na3 na3Var2 = na3Var;
            Jni jniE2 = e();
            na3Var2.getClass();
            yw1 yw1Var2 = jniE2.a;
            if (new zz3(stringExtra6, yw1Var2.j(), na3Var2, yw1Var2.y0.f, new el1(i3, stringExtra6), true).d()) {
                return 2;
            }
            String name = na3Var2.getName();
            name.getClass();
            p95.C(R.string.speedometer_task_repeated_template, name);
            return 2;
        }
        if (intent != null && intent.getBooleanExtra("print_tcp_info", false) && z) {
            String str6 = "printTCPInfo() called with: intent = " + intent + ", flags = " + i + ", startId = " + i2;
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str6);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("IVpnService", str6, null);
            }
            e().printAllTCPConnectionsInfo();
            return 2;
        }
        if (intent == null || !intent.getBooleanExtra("change_outbound_mode", false) || !z) {
            if (intent != null && intent.getBooleanExtra("start", false)) {
                ez4.X("Jni.startVPN", new uw1(this, intent));
                return 3;
            }
            if (intent != null && intent.getExtras() == null) {
                this.Z = true;
                ws4.d.i(Boolean.FALSE);
                stopSelf();
                ws4.c.i(new vs4());
                return 2;
            }
            on2 on2Var = ws4.d;
            Boolean bool = Boolean.FALSE;
            on2Var.i(bool);
            stopSelf();
            ws4.c.i(new vs4());
            ws4.b.i(bool);
            return 2;
        }
        String str7 = "changeOutboundMode() called with: intent = " + intent + ", flags = " + i + ", startId = " + i2;
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str7);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("IVpnService", str7, null);
        }
        rs4 rs4Var2 = this.y0;
        xw2 xw2Var = ((xw2[]) xw2.X.toArray(new xw2[0]))[intent.getIntExtra("outbound_mode", 0)];
        rs4Var2.getClass();
        xw2Var.getClass();
        rs4Var2.b = xw2Var;
        tj4.n();
        e().resetAllTCPConnections();
        String str8 = "Outbound Mode change to " + this.y0.b;
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "IVpnService", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str8);
        }
        if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
            return 2;
        }
        Log.d("IVpnService", str8, null);
        return 2;
    }
}
