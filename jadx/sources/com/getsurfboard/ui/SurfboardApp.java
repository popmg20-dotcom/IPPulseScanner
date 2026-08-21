package com.getsurfboard.ui;

import android.app.Application;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.receiver.appwidget.WidgetRetryReceiver;
import com.tencent.mars.xlog.Xlog;
import defpackage.ad0;
import defpackage.cr2;
import defpackage.d70;
import defpackage.d73;
import defpackage.e03;
import defpackage.e7;
import defpackage.e70;
import defpackage.ed;
import defpackage.ez4;
import defpackage.f0;
import defpackage.fn;
import defpackage.fy4;
import defpackage.gj;
import defpackage.ha1;
import defpackage.ih0;
import defpackage.iv1;
import defpackage.k2;
import defpackage.ke0;
import defpackage.km2;
import defpackage.le2;
import defpackage.ma;
import defpackage.nj3;
import defpackage.o90;
import defpackage.oj0;
import defpackage.p44;
import defpackage.p74;
import defpackage.p95;
import defpackage.q74;
import defpackage.r74;
import defpackage.s74;
import defpackage.sh2;
import defpackage.t23;
import defpackage.t4;
import defpackage.t60;
import defpackage.t74;
import defpackage.te3;
import defpackage.uh2;
import defpackage.uh3;
import defpackage.v02;
import defpackage.v9;
import defpackage.vw1;
import defpackage.w44;
import defpackage.ws4;
import defpackage.xb5;
import defpackage.xc;
import defpackage.xg3;
import defpackage.xw4;
import defpackage.yh0;
import defpackage.yw1;
import defpackage.zc;
import io.sentry.android.core.a1;
import io.sentry.android.core.performance.g;
import io.sentry.android.core.performance.h;
import io.sentry.android.core.q1;
import io.sentry.f5;
import io.sentry.p4;
import io.sentry.p5;
import io.sentry.protocol.a0;
import io.sentry.protocol.c0;
import io.sentry.protocol.v;
import java.io.File;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import org.conscrypt.BuildConfig;
import org.conscrypt.Conscrypt;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class SurfboardApp extends Application {
    public static final /* synthetic */ int A = 0;
    public final vw1 b = new vw1(1);
    public final WidgetRetryReceiver f = new WidgetRetryReceiver();
    public final p74 z = new p74();

    public static f5 a(String str) {
        String str2;
        uh2 uh2VarA;
        a0 a0Var;
        ArrayList arrayList = new ArrayList();
        String strF0 = "xray crashed";
        boolean z = false;
        boolean z2 = false;
        for (String str3 : p44.B0(str)) {
            if (w44.j0(str3, "panic: ", false)) {
                strF0 = p44.F0(str3, "panic: ");
            } else if (w44.j0(str3, "fatal error: ", false)) {
                strF0 = p44.F0(str3, "fatal error: ");
            } else if (w44.j0(str3, "goroutine ", false)) {
                if (z) {
                    break;
                }
                z2 = false;
                z = true;
            } else if (z) {
                if (!p44.x0(str3) && !w44.j0(str3, "[signal ", false)) {
                    if (w44.j0(str3, "created by ", false)) {
                        z2 = true;
                    } else if (!w44.j0(str3, "\t", false)) {
                        a0 a0Var2 = new a0();
                        uh2 uh2VarA2 = uh3.a(t74.b, str3);
                        if (uh2VarA2 != null && (str2 = (String) ((sh2) uh2VarA2.a()).get(1)) != null) {
                            str3 = str2;
                        }
                        a0Var2.Y = str3;
                        a0Var2.E0 = "go";
                        arrayList.add(a0Var2);
                    } else if (!z2 && (uh2VarA = uh3.a(t74.a, str3)) != null && (a0Var = (a0) d70.l0(arrayList)) != null) {
                        a0Var.A = (String) ((sh2) uh2VarA.a()).get(1);
                        a0Var.Z = w44.m0((String) ((sh2) uh2VarA.a()).get(2));
                    }
                }
                z2 = false;
            }
        }
        v vVar = new v();
        vVar.b = "GoPanic";
        vVar.f = strF0;
        a0 a0Var3 = (a0) d70.e0(arrayList);
        vVar.z = a0Var3 != null ? a0Var3.Y : null;
        if (!arrayList.isEmpty()) {
            c0 c0Var = new c0();
            c0Var.b = new ArrayList(arrayList);
            vVar.X = c0Var;
        }
        f5 f5Var = new f5();
        f5Var.h(e70.L(vVar));
        f5Var.L0 = p5.FATAL;
        f5Var.b("source", "xray-core");
        f5Var.Y = "mobile-2.34.1 (Build 286)";
        f5Var.Z = BuildConfig.BUILD_TYPE;
        return f5Var;
    }

    public static final void d() {
        if (Build.VERSION.SDK_INT >= 30) {
            if (fy4.b) {
                Xlog.logWrite2(0L, 1, "SurfboardApp", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "print last exit reasons");
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                Log.d("SurfboardApp", "print last exit reasons", null);
            }
            try {
                List<ApplicationExitInfo> historicalProcessExitReasons = ContextUtilsKt.a().getHistoricalProcessExitReasons(null, 0, 0);
                historicalProcessExitReasons.getClass();
                for (ApplicationExitInfo applicationExitInfo : historicalProcessExitReasons) {
                    String string = applicationExitInfo.toString();
                    string.getClass();
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "SurfboardApp", "", "", 0, Process.myPid(), Process.myTid(), le2.b, string);
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("SurfboardApp", string, null);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("reason", applicationExitInfo.getReason());
                    bundle.putString("description", applicationExitInfo.getDescription());
                    e7.a(bundle, "app_exit_info");
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    public final void b() {
        iv1 iv1Var = new iv1(this);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        arrayList3.add(new e03(new zc(0), PackageInfo.class));
        arrayList4.add(new e03(new xc(ContextUtilsKt.e(R.dimen.app_icon_size), this), PackageInfo.class));
        iv1Var.A = new o90(ke0.H(arrayList), ke0.H(arrayList2), ke0.H(arrayList3), ke0.H(arrayList4), ke0.H(arrayList5));
        te3 te3VarE = iv1Var.e();
        synchronized (t60.class) {
            t60.f = te3VarE;
        }
    }

    public final void c() {
        xw4 xw4VarC = xw4.c(this);
        xw4VarC.a();
        xg3 xg3Var = new xg3();
        xg3Var.b = true;
        d73.b.f(new yh0(8, new gj(20, xg3Var, xw4VarC)));
        ws4.c.f(new yh0(8, new f0(27, xw4VarC)));
    }

    @Override // android.app.Application
    public final void onCreate() throws Throwable {
        boolean zExists;
        g gVar = g.N0;
        long jUptimeMillis = SystemClock.uptimeMillis();
        g gVarC = g.c();
        h hVar = gVarC.Y;
        if (hVar.z == 0) {
            hVar.f(jUptimeMillis);
            gVarC.i(this);
        }
        SystemClock.elapsedRealtime();
        System.setProperty("io.netty.selectorAutoRebuildThreshold", "0");
        int i = 1;
        Security.insertProviderAt(Conscrypt.newProvider(), 1);
        boolean z = nj3.a;
        int i2 = 0;
        nj3.a = t23.c(R.string.setting_bypass_tls_verify_key, false);
        nj3.b = new t4(22);
        le2.a = new t4(23);
        try {
            Context context = ContextUtilsKt.getContext();
            ha1 ha1Var = new ha1();
            if (context == null) {
                throw new IllegalArgumentException("Given context is null");
            }
            ha1.A("Beginning load of %s...", "surfboard");
            ha1Var.z(context);
            fy4 fy4Var = fy4.a;
            if (!fy4.b) {
                synchronized (fy4Var) {
                    if (!fy4.b) {
                        System.loadLibrary("xlog");
                        Xlog.XLogConfig xLogConfig = new Xlog.XLogConfig();
                        xLogConfig.level = 0;
                        xLogConfig.mode = 0;
                        xLogConfig.logdir = new File(getFilesDir(), "logs").getAbsolutePath();
                        xLogConfig.nameprefix = "surfboard_".concat(fy4.a(this));
                        xLogConfig.pubkey = "538611d37cfce423af0bb9174408ddfda7ae8d4a8e2238246ad0a37d1554059c73377c296549691bf8a780777075bfbbd3b0502e28c6fb9e33d954e1b042b805";
                        xLogConfig.compressmode = 1;
                        xLogConfig.compresslevel = 3;
                        xLogConfig.cachedir = new File(getCacheDir(), "xlog").getAbsolutePath();
                        xLogConfig.cachedays = 0;
                        xLogConfig.maxfilecount = 5;
                        Xlog.appenderOpen(xLogConfig);
                        Xlog xlog = new Xlog();
                        xlog.setMaxFileSize(0L, 3145728L);
                        xlog.setConsoleLogOpen(0L, ((Boolean) le2.a.a()).booleanValue());
                        fy4.b = true;
                    }
                }
            }
            super.onCreate();
            try {
                oj0.a.t().a();
                zExists = false;
            } catch (IllegalStateException unused) {
                zExists = getDatabasePath("webview").exists();
            }
            if (zExists) {
                if (fy4.b) {
                    Xlog.logWrite2(0L, 3, "SurfboardApp", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "upgrade from V1 version");
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    a1.o("SurfboardApp", "upgrade from V1 version", null);
                }
                p95.C(R.string.pls_restart_app, new Object[0]);
                ContextUtilsKt.a().clearApplicationUserData();
                g.e(this);
                return;
            }
            int i3 = 24;
            ez4.X("getExitReasons", new t4(i3));
            try {
                try {
                    PackageManager packageManagerH = ContextUtilsKt.h();
                    String packageName = ContextUtilsKt.getContext().getPackageName();
                    packageName.getClass();
                    String str = k2.e(packageManagerH, packageName, 0).versionName;
                    if (str == null) {
                        str = "unknown";
                    }
                    q1.b(this, new ed(4, str, this));
                } catch (Throwable unused2) {
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            p4.c().o(new ad0(6));
            ez4.X("xray_crash_upload", new fn(i3, this));
            v02.p();
            b();
            String string = t23.l().getString("dark_mode", "AUTO");
            string.getClass();
            int iOrdinal = ih0.valueOf(string).ordinal();
            int i4 = 2;
            if (iOrdinal == 0) {
                ma.n(-1);
            } else if (iOrdinal == 1) {
                ma.n(1);
            } else {
                if (iOrdinal != 2) {
                    defpackage.g.d();
                    return;
                }
                ma.n(2);
            }
            registerActivityLifecycleCallbacks(new r74());
            v9.r(this, this.b, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), 2);
            v9.r(this, this.f, new IntentFilter("com.getsurfboard.ACTION_WIDGET_RETRY"), 2);
            try {
                c();
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                xb5.L(e2);
            }
            boolean z2 = yw1.G0;
            yw1.G0 = !t23.c(R.string.setting_hide_status_bar_icon_and_notification_key, false);
            t23.d.f(this.z);
            cr2.a.f(new yh0(8, new q74(i2)));
            cr2.c.f(new yh0(8, new q74(i)));
            cr2.b.f(new yh0(8, new q74(i4)));
            ProcessLifecycleOwner.z0.Y.a(new s74());
            g.e(this);
        } catch (km2 e3) {
            e3.printStackTrace();
            t74.c = true;
            g.e(this);
        }
    }

    @Override // android.app.Application
    public final void onTerminate() {
        unregisterReceiver(this.b);
        unregisterReceiver(this.f);
        t23.d.j(this.z);
        super.onTerminate();
    }
}
