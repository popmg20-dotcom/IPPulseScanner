package io.sentry.android.core;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.getsurfboard.ui.SurfboardApp;
import defpackage.ed;
import defpackage.o73;
import defpackage.zo2;
import io.sentry.android.fragment.FragmentLifecycleIntegration;
import io.sentry.android.timber.SentryTimberIntegration;
import io.sentry.j4;
import io.sentry.p4;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.y5;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class q1 {
    public static final long a = SystemClock.uptimeMillis();
    public static final io.sentry.util.a b = new io.sentry.util.a();

    public static void a(p6 p6Var, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (io.sentry.v1 v1Var : p6Var.getIntegrations()) {
            if (z && (v1Var instanceof FragmentLifecycleIntegration)) {
                arrayList2.add(v1Var);
            }
            if (z2 && (v1Var instanceof SentryTimberIntegration)) {
                arrayList.add(v1Var);
            }
            if (v1Var instanceof SystemEventsBreadcrumbsIntegration) {
                arrayList3.add(v1Var);
            }
        }
        if (arrayList2.size() > 1) {
            for (int i = 0; i < arrayList2.size() - 1; i++) {
                p6Var.getIntegrations().remove((io.sentry.v1) arrayList2.get(i));
            }
        }
        if (arrayList.size() > 1) {
            for (int i2 = 0; i2 < arrayList.size() - 1; i2++) {
                p6Var.getIntegrations().remove((io.sentry.v1) arrayList.get(i2));
            }
        }
        if (arrayList3.size() > 1) {
            for (int i3 = 0; i3 < arrayList3.size() - 1; i3++) {
                p6Var.getIntegrations().remove((io.sentry.v1) arrayList3.get(i3));
            }
        }
    }

    public static void b(SurfboardApp surfboardApp, ed edVar) {
        w wVar = new w(3);
        try {
            io.sentry.util.a aVar = b;
            aVar.g();
            try {
                p4.d(new w(6), new e(wVar, surfboardApp, edVar));
                io.sentry.f1 f1VarC = p4.c();
                if (p0.f()) {
                    if (f1VarC.getOptions().isEnableAutoSessionTracking()) {
                        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                        f1VarC.w(new o73(22, atomicBoolean));
                        if (!atomicBoolean.get()) {
                            f1VarC.l();
                        }
                    }
                    f1VarC.getOptions().getReplayController().Q();
                }
                aVar.close();
            } catch (Throwable th) {
                try {
                    aVar.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IllegalAccessException e) {
            wVar.d(p5.FATAL, "Fatal error during SentryAndroid.init(...)", e);
            zo2.o("Failed to initialize Sentry's SDK", e);
        } catch (InstantiationException e2) {
            wVar.d(p5.FATAL, "Fatal error during SentryAndroid.init(...)", e2);
            zo2.o("Failed to initialize Sentry's SDK", e2);
        } catch (NoSuchMethodException e3) {
            wVar.d(p5.FATAL, "Fatal error during SentryAndroid.init(...)", e3);
            zo2.o("Failed to initialize Sentry's SDK", e3);
        } catch (InvocationTargetException e4) {
            wVar.d(p5.FATAL, "Fatal error during SentryAndroid.init(...)", e4);
            zo2.o("Failed to initialize Sentry's SDK", e4);
        }
    }

    public static void c(w wVar, SurfboardApp surfboardApp, ed edVar, SentryAndroidOptions sentryAndroidOptions) {
        boolean zB = io.sentry.util.g.b(sentryAndroidOptions, "timber.log.Timber");
        boolean z = io.sentry.util.g.b(sentryAndroidOptions, "androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks") && io.sentry.util.g.b(sentryAndroidOptions, "io.sentry.android.fragment.FragmentLifecycleIntegration");
        boolean z2 = zB && io.sentry.util.g.b(sentryAndroidOptions, "io.sentry.android.timber.SentryTimberIntegration");
        boolean zB2 = io.sentry.util.g.b(sentryAndroidOptions, "io.sentry.android.replay.ReplayIntegration");
        boolean zB3 = io.sentry.util.g.b(sentryAndroidOptions, "io.sentry.android.distribution.DistributionIntegration");
        q0 q0Var = new q0(wVar);
        io.sentry.util.g gVar = new io.sentry.util.g();
        d dVar = new d(gVar, sentryAndroidOptions);
        Context applicationContext = surfboardApp.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = surfboardApp;
        }
        sentryAndroidOptions.setLogger(wVar);
        sentryAndroidOptions.setFatalLogger(new w(2));
        sentryAndroidOptions.setDefaultScopeType(j4.CURRENT);
        sentryAndroidOptions.setOpenTelemetryMode(y5.OFF);
        sentryAndroidOptions.setDateProvider(new r1());
        sentryAndroidOptions.getLogs().b = new w(4);
        sentryAndroidOptions.getMetrics().b = new w(5);
        sentryAndroidOptions.setFlushTimeoutMillis(4000L);
        sentryAndroidOptions.setFrameMetricsCollector(new io.sentry.android.core.internal.util.r(applicationContext, wVar, q0Var));
        a1.c(applicationContext, sentryAndroidOptions, q0Var);
        sentryAndroidOptions.setCacheDirPath(new File(applicationContext.getCacheDir(), "sentry").getAbsolutePath());
        io.sentry.android.core.anr.e.a.set(true);
        PackageInfo packageInfoD = p0.d(applicationContext, q0Var);
        if (packageInfoD != null) {
            if (sentryAndroidOptions.getRelease() == null) {
                sentryAndroidOptions.setRelease(packageInfoD.packageName + "@" + packageInfoD.versionName + "+" + p0.e(packageInfoD, q0Var));
            }
            String str = packageInfoD.packageName;
            if (str != null && !str.startsWith("android.")) {
                sentryAndroidOptions.addInAppInclude(str);
            }
        }
        if (sentryAndroidOptions.getDistinctId() == null) {
            try {
                sentryAndroidOptions.setDistinctId(y0.a(applicationContext));
            } catch (RuntimeException e) {
                sentryAndroidOptions.getLogger().d(p5.ERROR, "Could not generate distinct Id.", e);
            }
        }
        j0 j0Var = j0.X;
        if (j0Var.f == null) {
            io.sentry.util.a aVar = j0Var.b;
            aVar.g();
            try {
                j0Var.s(sentryAndroidOptions.getLogger());
                aVar.close();
            } finally {
            }
        }
        sentryAndroidOptions.activate();
        s.b(surfboardApp, sentryAndroidOptions, q0Var, gVar, dVar, z, z2, zB2, zB3);
        boolean z3 = z;
        try {
            edVar.p(sentryAndroidOptions);
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().d(p5.ERROR, "Error in the 'OptionsConfiguration.configure' callback.", th);
        }
        io.sentry.android.core.performance.g gVarC = io.sentry.android.core.performance.g.c();
        if (sentryAndroidOptions.isEnablePerformanceV2() && Build.VERSION.SDK_INT >= 24) {
            io.sentry.android.core.performance.h hVar = gVarC.A;
            if (hVar.z == 0) {
                hVar.f(Process.getStartUptimeMillis());
            }
        }
        if (surfboardApp.getApplicationContext() instanceof Application) {
            gVarC.i((Application) surfboardApp.getApplicationContext());
        }
        io.sentry.android.core.performance.h hVar2 = gVarC.X;
        if (hVar2.z == 0) {
            hVar2.f(a);
        }
        s.a(sentryAndroidOptions, surfboardApp, q0Var, gVar, dVar, zB2);
        a(sentryAndroidOptions, z3, z2);
    }
}
