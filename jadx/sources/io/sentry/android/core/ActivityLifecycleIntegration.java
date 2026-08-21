package io.sentry.android.core;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.core.app.FrameMetricsAggregator;
import com.getsurfboard.ui.SurfboardApp;
import defpackage.bd0;
import defpackage.ed;
import defpackage.ga1;
import defpackage.o73;
import defpackage.st4;
import defpackage.uj0;
import defpackage.xy0;
import io.sentry.ILogger;
import io.sentry.d7;
import io.sentry.e7;
import io.sentry.f7;
import io.sentry.g4;
import io.sentry.j3;
import io.sentry.j7;
import io.sentry.k7;
import io.sentry.l4;
import io.sentry.o2;
import io.sentry.p5;
import io.sentry.u5;
import io.sentry.u6;
import io.sentry.w4;
import io.sentry.x3;
import io.sentry.x5;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityLifecycleIntegration implements io.sentry.v1, Closeable, Application.ActivityLifecycleCallbacks {
    public SentryAndroidOptions A;
    public io.sentry.n1 A0;
    public io.sentry.p1 B0;
    public final d I0;
    public final boolean Z;
    public final SurfboardApp b;
    public final q0 f;
    public io.sentry.f1 z;
    public boolean X = false;
    public boolean Y = false;
    public boolean y0 = false;
    public io.sentry.k0 z0 = null;
    public final WeakHashMap C0 = new WeakHashMap();
    public final WeakHashMap D0 = new WeakHashMap();
    public final WeakHashMap E0 = new WeakHashMap();
    public w4 F0 = new x5(0, 0);
    public Future G0 = null;
    public final WeakHashMap H0 = new WeakHashMap();
    public final io.sentry.util.a J0 = new io.sentry.util.a();
    public final io.sentry.util.a K0 = new io.sentry.util.a();

    public ActivityLifecycleIntegration(SurfboardApp surfboardApp, q0 q0Var, d dVar) {
        this.b = surfboardApp;
        this.f = q0Var;
        this.I0 = dVar;
        if (Build.VERSION.SDK_INT >= 29) {
            this.Z = true;
        }
    }

    public static void n(io.sentry.n1 n1Var, io.sentry.n1 n1Var2) {
        if (n1Var == null || n1Var.isFinished()) {
            return;
        }
        String description = n1Var.getDescription();
        if (description == null || !description.endsWith(" - Deadline Exceeded")) {
            description = n1Var.getDescription() + " - Deadline Exceeded";
        }
        n1Var.m(description);
        w4 w4VarS = n1Var2 != null ? n1Var2.s() : null;
        if (w4VarS == null) {
            w4VarS = n1Var.u();
        }
        s(n1Var, w4VarS, f7.DEADLINE_EXCEEDED);
    }

    public static void s(io.sentry.n1 n1Var, w4 w4Var, f7 f7Var) {
        if (n1Var == null || n1Var.isFinished()) {
            return;
        }
        if (f7Var == null) {
            f7Var = n1Var.getStatus() != null ? n1Var.getStatus() : f7.OK;
        }
        n1Var.t(f7Var, w4Var);
    }

    public final void C(io.sentry.n1 n1Var, io.sentry.n1 n1Var2) {
        io.sentry.android.core.performance.g gVarC = io.sentry.android.core.performance.g.c();
        io.sentry.android.core.performance.h hVar = gVarC.A;
        io.sentry.android.core.performance.h hVar2 = gVarC.X;
        SentryAndroidOptions sentryAndroidOptions = this.A;
        w4 w4VarA = sentryAndroidOptions != null ? sentryAndroidOptions.getDateProvider().a() : null;
        if (hVar.d() && hVar.c()) {
            u5 u5VarB = hVar.b();
            if (w4VarA == null || u5VarB == null) {
                hVar.A = SystemClock.uptimeMillis();
            } else {
                hVar.A = hVar.z + (w4VarA.b(u5VarB) / 1000000);
            }
        }
        if (hVar2.d() && hVar2.c()) {
            u5 u5VarB2 = hVar2.b();
            if (w4VarA == null || u5VarB2 == null) {
                hVar2.A = SystemClock.uptimeMillis();
            } else {
                hVar2.A = hVar2.z + (w4VarA.b(u5VarB2) / 1000000);
            }
        }
        g(w4VarA);
        io.sentry.util.a aVar = this.K0;
        aVar.g();
        try {
            if (this.A != null && n1Var2 != null && w4VarA != null) {
                n1Var2.q("time_to_initial_display", Long.valueOf(w4VarA.b(n1Var2.u()) / 1000000), o2.MILLISECOND);
                s(n1Var2, w4VarA, null);
            } else if (n1Var2 != null && !n1Var2.isFinished()) {
                n1Var2.g();
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
    }

    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6, types: [io.sentry.protocol.w, java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v9 */
    public final void F(Activity activity) {
        WeakHashMap weakHashMap;
        WeakHashMap weakHashMap2;
        Boolean boolValueOf;
        u5 u5Var;
        w4 w4Var;
        Boolean bool;
        boolean z;
        u5 u5Var2;
        String strA;
        w4 w4Var2;
        String str;
        SentryAndroidOptions sentryAndroidOptions;
        x3 x3Var;
        x3 x3Var2;
        j7 j7Var;
        io.sentry.c cVarA;
        ?? r15;
        io.sentry.p1 p1VarM;
        e7 e7Var;
        io.sentry.p1 p1Var;
        w4 w4Var3;
        io.sentry.p1 p1Var2;
        WeakReference weakReference = new WeakReference(activity);
        if (this.z != null) {
            WeakHashMap weakHashMap3 = this.H0;
            if (weakHashMap3.containsKey(activity)) {
                return;
            }
            if (!this.X) {
                weakHashMap3.put(activity, j3.a);
                if (this.A.isEnableAutoTraceIdGeneration()) {
                    this.z.w(new io.sentry.android.core.cache.a(7));
                    return;
                }
                return;
            }
            Iterator it = weakHashMap3.entrySet().iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                weakHashMap = this.D0;
                weakHashMap2 = this.C0;
                if (!zHasNext) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                x((io.sentry.p1) entry.getValue(), (io.sentry.n1) weakHashMap2.get(entry.getKey()), (io.sentry.n1) weakHashMap.get(entry.getKey()));
            }
            String simpleName = activity.getClass().getSimpleName();
            io.sentry.android.core.performance.h hVarB = io.sentry.android.core.performance.g.c().b(this.A);
            if (p0.f() && hVarB.d()) {
                u5 u5VarB = hVarB.b();
                boolValueOf = Boolean.valueOf(io.sentry.android.core.performance.g.c().b == io.sentry.android.core.performance.f.COLD);
                u5Var = u5VarB;
            } else {
                boolValueOf = null;
                u5Var = null;
            }
            k7 k7Var = new k7();
            long deadlineTimeout = this.A.getDeadlineTimeout();
            k7Var.h = deadlineTimeout <= 0 ? null : Long.valueOf(deadlineTimeout);
            if (this.A.isEnableActivityLifecycleTracingAutoFinish()) {
                k7Var.g = this.A.getIdleTimeout();
                k7Var.c = true;
            }
            k7Var.f = true;
            k7Var.i = new e(this, weakReference, simpleName);
            if (this.y0 || u5Var == null || boolValueOf == null) {
                w4Var = this.F0;
            } else {
                io.sentry.android.core.performance.g.c().getClass();
                io.sentry.android.core.performance.g.c().getClass();
                w4Var = u5Var;
            }
            k7Var.a = w4Var;
            k7Var.e = false;
            k7Var.d = "auto.ui.activity";
            io.sentry.util.a aVar = (io.sentry.util.a) io.sentry.android.core.performance.g.c().L0.b;
            aVar.g();
            aVar.close();
            boolean z2 = io.sentry.android.core.performance.g.c().G0 != null;
            boolean z3 = (this.y0 || u5Var == null || boolValueOf == null) ? false : true;
            boolean z4 = z3 && this.A.isEnableStandaloneAppStartTracing() && !z2;
            if (z4) {
                k7 k7Var2 = new k7();
                k7Var2.b = g4.OFF;
                k7Var2.a = u5Var;
                k7Var2.e = false;
                k7Var2.d = "auto.app.start";
                bool = boolValueOf;
                z = z2;
                u5Var2 = u5Var;
                io.sentry.p1 p1VarM2 = this.z.m(new j7("App Start", io.sentry.protocol.i0.COMPONENT, "app.start", null), k7Var2);
                this.B0 = p1VarM2;
                p1VarM2.h(simpleName, "app.vitals.start.screen");
                String strA2 = io.sentry.android.core.performance.g.c().a();
                if (strA2 != null) {
                    this.B0.h(strA2, "app.vitals.start.reason");
                }
            } else {
                bool = boolValueOf;
                z = z2;
                u5Var2 = u5Var;
            }
            if (z4) {
                strA = this.B0.b().a();
                io.sentry.d dVarI = this.B0.i();
                str = dVarI == null ? null : dVarI.a;
            } else if (!z || ((w4Var2 = io.sentry.android.core.performance.g.c().J0) != null && w4Var.b(w4Var2) > 60000000000L)) {
                strA = null;
            } else {
                strA = io.sentry.android.core.performance.g.c().H0;
                str = io.sentry.android.core.performance.g.c().I0;
            }
            if (strA == null || (sentryAndroidOptions = this.A) == null || !sentryAndroidOptions.isTracingEnabled()) {
                j7Var = null;
            } else {
                ILogger logger = this.A.getLogger();
                List listSingletonList = str == null ? null : Collections.singletonList(str);
                SentryAndroidOptions sentryAndroidOptions2 = this.A;
                try {
                    u6 u6Var = new u6(strA);
                    if (listSingletonList != null) {
                        try {
                            uj0 uj0Var = io.sentry.c.i;
                            cVarA = io.sentry.c.a(logger, io.sentry.util.p.b(listSingletonList), false);
                        } catch (io.sentry.exception.b e) {
                            e = e;
                            logger.b(p5.DEBUG, e, "Failed to parse Sentry trace header: %s", e.getMessage());
                            x3Var = new x3();
                        }
                    } else {
                        cVarA = io.sentry.c.a(logger, null, false);
                    }
                    x3Var = x3.a(u6Var, cVarA, sentryAndroidOptions2);
                } catch (io.sentry.exception.b e2) {
                    e = e2;
                }
                Boolean bool2 = (Boolean) x3Var.a;
                io.sentry.c cVar = (io.sentry.c) x3Var.e;
                if (bool2 == null) {
                    x3Var2 = null;
                } else {
                    Double d = cVar.c;
                    Double d2 = cVar.d;
                    x3Var2 = new x3(bool2, d, Double.valueOf(d2 == null ? 0.0d : d2.doubleValue()));
                }
                j7Var = new j7((io.sentry.protocol.w) x3Var.b, (d7) x3Var.c, null, x3Var2, cVar);
                j7Var.G0 = simpleName;
                j7Var.H0 = io.sentry.protocol.i0.COMPONENT;
                j7Var.X = "ui.load";
            }
            io.sentry.f1 f1Var = this.z;
            if (j7Var != null) {
                p1VarM = f1Var.m(j7Var, k7Var);
                r15 = 0;
            } else {
                r15 = 0;
                p1VarM = f1Var.m(new j7(simpleName, io.sentry.protocol.i0.COMPONENT, "ui.load", null), k7Var);
            }
            io.sentry.p1 p1Var3 = p1VarM;
            if (z) {
                io.sentry.android.core.performance.g.c().G0 = r15;
                io.sentry.android.core.performance.g.c().H0 = r15;
                io.sentry.android.core.performance.g.c().I0 = r15;
            }
            e7 e7Var2 = new e7();
            e7Var2.d = "auto.ui.activity";
            if (!z3 || z4 || this.A.isEnableStandaloneAppStartTracing()) {
                e7Var = e7Var2;
                p1Var = p1Var3;
                w4Var3 = w4Var;
            } else {
                String str2 = bool.booleanValue() ? "app.start.cold" : "app.start.warm";
                String str3 = bool.booleanValue() ? "Cold Start" : "Warm Start";
                w4Var3 = w4Var;
                p1Var = p1Var3;
                e7Var = e7Var2;
                this.A0 = p1Var3.l(str2, str3, u5Var2, io.sentry.u1.SENTRY, e7Var2);
                g(null);
            }
            String strConcat = simpleName.concat(" initial display");
            io.sentry.u1 u1Var = io.sentry.u1.SENTRY;
            io.sentry.n1 n1VarL = p1Var.l("ui.load.initial_display", strConcat, w4Var3, u1Var, e7Var);
            weakHashMap2.put(activity, n1VarL);
            if (!this.Y || this.z0 == null || this.A == null) {
                p1Var2 = p1Var;
            } else {
                io.sentry.n1 n1VarL2 = p1Var.l("ui.load.full_display", simpleName.concat(" full display"), w4Var3, u1Var, e7Var);
                p1Var2 = p1Var;
                try {
                    weakHashMap.put(activity, n1VarL2);
                    this.G0 = this.A.getExecutorService().b(new xy0(this, n1VarL2, n1VarL), 25000L);
                } catch (RejectedExecutionException e3) {
                    this.A.getLogger().d(p5.ERROR, "Failed to call the executor. Time to full display span will not be finished automatically. Did you call Sentry.close()?", e3);
                }
            }
            this.z.w(new ed(24, this, p1Var2));
            weakHashMap3.put(activity, p1Var2);
        }
    }

    @Override // io.sentry.v1
    public final void M(SentryAndroidOptions sentryAndroidOptions) {
        l4 l4Var = l4.a;
        this.A = sentryAndroidOptions;
        this.z = l4Var;
        this.X = sentryAndroidOptions.isTracingEnabled() && sentryAndroidOptions.isEnableAutoActivityLifecycleTracing();
        this.z0 = this.A.getFullyDisplayedReporter();
        this.Y = this.A.isEnableTimeToFullDisplayTracing();
        this.b.registerActivityLifecycleCallbacks(this);
        if (this.X && this.A.isEnableStandaloneAppStartTracing()) {
            io.sentry.android.core.performance.g gVarC = io.sentry.android.core.performance.g.c();
            gVarC.F0 = new o73(18, this);
            if (gVarC.z0 && gVarC.B0.get() == 0 && !gVarC.C0.get() && gVarC.D0.compareAndSet(false, true)) {
                Looper.getMainLooper().getQueue().addIdleHandler(new io.sentry.android.core.performance.e(gVarC));
            }
            io.sentry.util.a aVar = (io.sentry.util.a) gVarC.L0.b;
            aVar.g();
            aVar.close();
            io.sentry.util.b.a("StandaloneAppStart");
        }
        this.A.getLogger().h(p5.DEBUG, "ActivityLifecycleIntegration installed.", new Object[0]);
        io.sentry.util.b.a("ActivityLifecycle");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.b.unregisterActivityLifecycleCallbacks(this);
        io.sentry.android.core.performance.g gVarC = io.sentry.android.core.performance.g.c();
        gVarC.F0 = null;
        io.sentry.util.a aVar = (io.sentry.util.a) gVarC.L0.b;
        aVar.g();
        aVar.close();
        SentryAndroidOptions sentryAndroidOptions = this.A;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().h(p5.DEBUG, "ActivityLifecycleIntegration removed.", new Object[0]);
        }
        d dVar = this.I0;
        io.sentry.util.a aVar2 = (io.sentry.util.a) dVar.g;
        aVar2.g();
        try {
            if (dVar.e()) {
                dVar.g(new ga1(29, dVar), "FrameMetricsAggregator.stop");
                ((FrameMetricsAggregator) ((io.sentry.util.f) dVar.a).a()).a.u();
            }
            ((ConcurrentHashMap) dVar.d).clear();
            aVar2.close();
        } catch (Throwable th) {
            try {
                aVar2.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void g(w4 w4Var) {
        long jA;
        if (w4Var == null) {
            io.sentry.android.core.performance.h hVarB = io.sentry.android.core.performance.g.c().b(this.A);
            if (hVarB.e()) {
                if (hVarB.d()) {
                    jA = hVarB.a() + hVarB.f;
                } else {
                    jA = 0;
                }
                w4Var = new u5(jA * 1000000);
            } else {
                w4Var = null;
            }
        }
        if (!this.X || w4Var == null) {
            return;
        }
        s(this.A0, w4Var, null);
        io.sentry.p1 p1Var = this.B0;
        if (p1Var != null && !p1Var.isFinished()) {
            this.B0.t(f7.OK, w4Var);
        }
        io.sentry.util.a aVar = (io.sentry.util.a) io.sentry.android.core.performance.g.c().L0.b;
        aVar.g();
        aVar.close();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        io.sentry.k0 k0Var;
        SentryAndroidOptions sentryAndroidOptions;
        if (!this.Z) {
            onActivityPreCreated(activity, bundle);
        }
        io.sentry.util.a aVar = this.J0;
        aVar.g();
        try {
            if (this.z != null && (sentryAndroidOptions = this.A) != null && sentryAndroidOptions.isEnableScreenTracking()) {
                this.z.w(new bd0(io.sentry.config.a.g(activity), 4));
            }
            F(activity);
            io.sentry.n1 n1Var = (io.sentry.n1) this.C0.get(activity);
            io.sentry.n1 n1Var2 = (io.sentry.n1) this.D0.get(activity);
            this.y0 = true;
            if (this.X && n1Var != null && n1Var2 != null && (k0Var = this.z0) != null) {
                k0Var.a.add(new st4(21));
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
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        WeakHashMap weakHashMap = this.D0;
        WeakHashMap weakHashMap2 = this.C0;
        WeakHashMap weakHashMap3 = this.E0;
        io.sentry.util.a aVar = this.J0;
        aVar.g();
        try {
            io.sentry.android.core.performance.b bVar = (io.sentry.android.core.performance.b) weakHashMap3.remove(activity);
            if (bVar != null) {
                io.sentry.n1 n1Var = bVar.d;
                if (n1Var != null && !n1Var.isFinished()) {
                    bVar.d.f(f7.CANCELLED);
                }
                bVar.d = null;
                io.sentry.n1 n1Var2 = bVar.e;
                if (n1Var2 != null && !n1Var2.isFinished()) {
                    bVar.e.f(f7.CANCELLED);
                }
                bVar.e = null;
            }
            boolean z = this.X;
            WeakHashMap weakHashMap4 = this.H0;
            if (z) {
                io.sentry.n1 n1Var3 = this.A0;
                f7 f7Var = f7.CANCELLED;
                if (n1Var3 != null && !n1Var3.isFinished()) {
                    n1Var3.f(f7Var);
                }
                io.sentry.p1 p1Var = this.B0;
                if (p1Var != null && !p1Var.isFinished()) {
                    this.B0.f(f7Var);
                }
                io.sentry.n1 n1Var4 = (io.sentry.n1) weakHashMap2.get(activity);
                io.sentry.n1 n1Var5 = (io.sentry.n1) weakHashMap.get(activity);
                f7 f7Var2 = f7.DEADLINE_EXCEEDED;
                if (n1Var4 != null && !n1Var4.isFinished()) {
                    n1Var4.f(f7Var2);
                }
                n(n1Var5, n1Var4);
                Future future = this.G0;
                if (future != null) {
                    future.cancel(false);
                    this.G0 = null;
                }
                if (this.X) {
                    x((io.sentry.p1) weakHashMap4.get(activity), null, null);
                }
                this.A0 = null;
                this.B0 = null;
                weakHashMap2.remove(activity);
                weakHashMap.remove(activity);
            }
            weakHashMap4.remove(activity);
            if (weakHashMap4.isEmpty() && !activity.isChangingConfigurations()) {
                this.y0 = false;
                this.F0 = new x5(0L, 0L);
                weakHashMap3.clear();
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
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        io.sentry.util.a aVar = this.J0;
        aVar.g();
        try {
            if (!this.Z) {
                onActivityPrePaused(activity);
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
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostCreated(Activity activity, Bundle bundle) {
        io.sentry.android.core.performance.b bVar = (io.sentry.android.core.performance.b) this.E0.get(activity);
        if (bVar != null) {
            io.sentry.n1 n1Var = this.B0;
            if (n1Var == null && (n1Var = this.A0) == null) {
                n1Var = (io.sentry.n1) this.H0.get(activity);
            }
            if (bVar.b == null || n1Var == null) {
                return;
            }
            io.sentry.n1 n1VarA = io.sentry.android.core.performance.b.a(n1Var, bVar.a.concat(".onCreate"), bVar.b);
            bVar.d = n1VarA;
            n1VarA.g();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostStarted(Activity activity) {
        io.sentry.android.core.performance.b bVar = (io.sentry.android.core.performance.b) this.E0.get(activity);
        if (bVar != null) {
            io.sentry.n1 n1Var = this.B0;
            if (n1Var == null && (n1Var = this.A0) == null) {
                n1Var = (io.sentry.n1) this.H0.get(activity);
            }
            if (bVar.c != null && n1Var != null) {
                io.sentry.n1 n1VarA = io.sentry.android.core.performance.b.a(n1Var, bVar.a.concat(".onStart"), bVar.c);
                bVar.e = n1VarA;
                n1VarA.g();
            }
            io.sentry.n1 n1Var2 = bVar.d;
            if (n1Var2 != null && bVar.e != null) {
                w4 w4VarS = n1Var2.s();
                w4 w4VarS2 = bVar.e.s();
                if (w4VarS != null && w4VarS2 != null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    k.a.getClass();
                    x5 x5Var = new x5();
                    long jB = x5Var.b(bVar.d.u()) / 1000000;
                    long jB2 = x5Var.b(w4VarS) / 1000000;
                    long jB3 = x5Var.b(bVar.e.u()) / 1000000;
                    long jB4 = x5Var.b(w4VarS2) / 1000000;
                    io.sentry.android.core.performance.c cVar = new io.sentry.android.core.performance.c();
                    String description = bVar.d.getDescription();
                    long jD = bVar.d.u().d() / 1000000;
                    io.sentry.android.core.performance.h hVar = cVar.b;
                    hVar.b = description;
                    hVar.f = jD;
                    hVar.z = jUptimeMillis - jB;
                    hVar.A = jUptimeMillis - jB2;
                    String description2 = bVar.e.getDescription();
                    long jD2 = bVar.e.u().d() / 1000000;
                    io.sentry.android.core.performance.h hVar2 = cVar.f;
                    hVar2.b = description2;
                    hVar2.f = jD2;
                    hVar2.z = jUptimeMillis - jB3;
                    hVar2.A = jUptimeMillis - jB4;
                    io.sentry.android.core.performance.g.c().y0.add(cVar);
                }
            }
        }
        g(null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreCreated(Activity activity, Bundle bundle) {
        w4 x5Var;
        io.sentry.android.core.performance.b bVar = new io.sentry.android.core.performance.b(activity.getClass().getName());
        this.E0.put(activity, bVar);
        if (this.y0) {
            return;
        }
        io.sentry.f1 f1Var = this.z;
        if (f1Var != null) {
            x5Var = f1Var.getOptions().getDateProvider().a();
        } else {
            k.a.getClass();
            x5Var = new x5();
        }
        this.F0 = x5Var;
        bVar.b = x5Var;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPrePaused(Activity activity) {
        w4 x5Var;
        this.y0 = true;
        io.sentry.f1 f1Var = this.z;
        if (f1Var != null) {
            x5Var = f1Var.getOptions().getDateProvider().a();
        } else {
            k.a.getClass();
            x5Var = new x5();
        }
        this.F0 = x5Var;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreStarted(Activity activity) {
        w4 x5Var;
        io.sentry.android.core.performance.b bVar = (io.sentry.android.core.performance.b) this.E0.get(activity);
        if (bVar != null) {
            SentryAndroidOptions sentryAndroidOptions = this.A;
            if (sentryAndroidOptions != null) {
                x5Var = sentryAndroidOptions.getDateProvider().a();
            } else {
                k.a.getClass();
                x5Var = new x5();
            }
            bVar.c = x5Var;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        io.sentry.util.a aVar = this.J0;
        aVar.g();
        try {
            if (!this.Z) {
                onActivityPostStarted(activity);
            }
            if (this.X) {
                final io.sentry.n1 n1Var = (io.sentry.n1) this.C0.get(activity);
                final io.sentry.n1 n1Var2 = (io.sentry.n1) this.D0.get(activity);
                if (activity.getWindow() != null) {
                    final int i = 0;
                    io.sentry.android.core.internal.util.i.a(activity, new Runnable(this) { // from class: io.sentry.android.core.f
                        public final /* synthetic */ ActivityLifecycleIntegration f;

                        {
                            this.f = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            int i2 = i;
                            io.sentry.n1 n1Var3 = n1Var;
                            io.sentry.n1 n1Var4 = n1Var2;
                            ActivityLifecycleIntegration activityLifecycleIntegration = this.f;
                            switch (i2) {
                                case 0:
                                    activityLifecycleIntegration.C(n1Var4, n1Var3);
                                    break;
                                default:
                                    activityLifecycleIntegration.C(n1Var4, n1Var3);
                                    break;
                            }
                        }
                    }, this.f);
                } else {
                    final int i2 = 1;
                    new Handler(Looper.getMainLooper()).post(new Runnable(this) { // from class: io.sentry.android.core.f
                        public final /* synthetic */ ActivityLifecycleIntegration f;

                        {
                            this.f = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            int i22 = i2;
                            io.sentry.n1 n1Var3 = n1Var;
                            io.sentry.n1 n1Var4 = n1Var2;
                            ActivityLifecycleIntegration activityLifecycleIntegration = this.f;
                            switch (i22) {
                                case 0:
                                    activityLifecycleIntegration.C(n1Var4, n1Var3);
                                    break;
                                default:
                                    activityLifecycleIntegration.C(n1Var4, n1Var3);
                                    break;
                            }
                        }
                    });
                }
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
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        io.sentry.util.a aVar = this.J0;
        aVar.g();
        try {
            if (!this.Z) {
                onActivityPostCreated(activity, null);
                onActivityPreStarted(activity);
            }
            if (this.X) {
                this.I0.a(activity);
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
    }

    public final void x(io.sentry.p1 p1Var, io.sentry.n1 n1Var, io.sentry.n1 n1Var2) {
        if (p1Var == null || p1Var.isFinished()) {
            return;
        }
        f7 f7Var = f7.DEADLINE_EXCEEDED;
        if (n1Var != null && !n1Var.isFinished()) {
            n1Var.f(f7Var);
        }
        n(n1Var2, n1Var);
        Future future = this.G0;
        if (future != null) {
            future.cancel(false);
            this.G0 = null;
        }
        f7 status = p1Var.getStatus();
        if (status == null) {
            status = f7.OK;
        }
        p1Var.f(status);
        io.sentry.f1 f1Var = this.z;
        if (f1Var != null) {
            f1Var.w(new o73(19, this, p1Var));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
