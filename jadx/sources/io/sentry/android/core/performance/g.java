package io.sentry.android.core.performance;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.app.ApplicationStartInfo;
import android.content.ContentProvider;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.getsurfboard.ui.SurfboardApp;
import defpackage.o73;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.q0;
import io.sentry.hints.j;
import io.sentry.protocol.w;
import io.sentry.w2;
import io.sentry.w4;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g extends a {
    public static volatile g N0;
    public volatile o73 F0;
    public w G0;
    public String H0;
    public String I0;
    public w4 J0;
    public ApplicationStartInfo K0;
    public static long M0 = SystemClock.uptimeMillis();
    public static final io.sentry.util.a O0 = new io.sentry.util.a();
    public f b = f.UNKNOWN;
    public final io.sentry.util.f f = new io.sentry.util.f(new j());
    public volatile long z = -1;
    public boolean z0 = false;
    public volatile boolean A0 = true;
    public final AtomicInteger B0 = new AtomicInteger();
    public final AtomicBoolean C0 = new AtomicBoolean(false);
    public final AtomicBoolean D0 = new AtomicBoolean(false);
    public final AtomicBoolean E0 = new AtomicBoolean(false);
    public final q0 L0 = new q0(2);
    public final h A = new h();
    public final h X = new h();
    public final h Y = new h();
    public final HashMap Z = new HashMap();
    public final ArrayList y0 = new ArrayList();

    public static g c() {
        if (N0 == null) {
            io.sentry.util.a aVar = O0;
            aVar.g();
            try {
                if (N0 == null) {
                    N0 = new g();
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
        return N0;
    }

    public static void e(SurfboardApp surfboardApp) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        h hVar = c().Y;
        if (hVar.c()) {
            hVar.b = SurfboardApp.class.getName().concat(".onCreate");
            hVar.A = jUptimeMillis;
        }
    }

    public static void f(ContentProvider contentProvider) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        h hVar = new h();
        hVar.f(jUptimeMillis);
        c().Z.put(contentProvider, hVar);
    }

    public static void g(ContentProvider contentProvider) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        h hVar = (h) c().Z.get(contentProvider);
        if (hVar == null || !hVar.c()) {
            return;
        }
        hVar.b = contentProvider.getClass().getName().concat(".onCreate");
        hVar.A = jUptimeMillis;
    }

    public final String a() {
        ApplicationStartInfo applicationStartInfo = this.K0;
        if (applicationStartInfo == null || Build.VERSION.SDK_INT < 35) {
            return null;
        }
        switch (applicationStartInfo.getReason()) {
        }
        return null;
    }

    public final h b(SentryAndroidOptions sentryAndroidOptions) {
        if (this.b != f.UNKNOWN && ((Boolean) this.f.a()).booleanValue()) {
            if (sentryAndroidOptions.isEnablePerformanceV2()) {
                h hVar = this.A;
                if (hVar.d() && hVar.a() <= 60000) {
                    return hVar;
                }
            }
            h hVar2 = this.X;
            if (hVar2.d() && hVar2.a() <= 60000) {
                return hVar2;
            }
        }
        return new h();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            Method dump skipped, instruction units count: 323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.performance.g.d():void");
    }

    public final synchronized void h() {
        if (!this.C0.getAndSet(true)) {
            g gVarC = c();
            h hVar = gVarC.X;
            hVar.getClass();
            hVar.A = SystemClock.uptimeMillis();
            h hVar2 = gVarC.A;
            hVar2.getClass();
            hVar2.A = SystemClock.uptimeMillis();
        }
    }

    public final void i(Application application) {
        ActivityManager activityManager;
        if (this.z0) {
            return;
        }
        this.z0 = true;
        io.sentry.util.f fVar = this.f;
        io.sentry.util.a aVar = fVar.c;
        aVar.g();
        try {
            fVar.a = null;
            aVar.close();
            application.registerActivityLifecycleCallbacks(N0);
            if (Build.VERSION.SDK_INT >= 35 && (activityManager = (ActivityManager) application.getSystemService("activity")) != null) {
                try {
                    List historicalProcessStartReasons = activityManager.getHistoricalProcessStartReasons(1);
                    if (!historicalProcessStartReasons.isEmpty()) {
                        ApplicationStartInfo applicationStartInfo = (ApplicationStartInfo) historicalProcessStartReasons.get(0);
                        this.K0 = applicationStartInfo;
                        if (applicationStartInfo.getStartupState() == 0) {
                            if (applicationStartInfo.getStartType() == 1) {
                                this.b = f.COLD;
                            } else {
                                this.b = f.WARM;
                            }
                        }
                    }
                } catch (RuntimeException e) {
                    Log.w("AppStartMetrics", e);
                }
            }
            if ((this.b == f.UNKNOWN || this.F0 != null) && this.D0.compareAndSet(false, true)) {
                Looper.getMainLooper().getQueue().addIdleHandler(new e(this));
            }
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void j(long j) {
        h hVar = this.A;
        if (hVar.d()) {
            if (hVar.c()) {
                hVar.A = j;
            }
        } else {
            h hVar2 = this.X;
            if (hVar2.d() && hVar2.c()) {
                hVar2.A = j;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        q0.f.b(activity);
        if (this.B0.incrementAndGet() == 1 && !this.C0.get()) {
            long jUptimeMillis2 = SystemClock.uptimeMillis() - this.A.z;
            if (!((Boolean) this.f.a()).booleanValue() || jUptimeMillis2 > 60000) {
                io.sentry.util.a aVar = (io.sentry.util.a) this.L0.b;
                aVar.g();
                aVar.close();
                this.b = f.WARM;
                this.A0 = true;
                h hVar = this.A;
                hVar.b = null;
                hVar.z = 0L;
                hVar.A = 0L;
                hVar.f = 0L;
                hVar.f(jUptimeMillis);
                M0 = jUptimeMillis;
                this.Z.clear();
                h hVar2 = this.Y;
                hVar2.b = null;
                hVar2.z = 0L;
                hVar2.A = 0L;
                hVar2.f = 0L;
            } else if (this.b == f.UNKNOWN) {
                if (bundle != null) {
                    this.b = f.WARM;
                } else if (this.z == -1 || jUptimeMillis <= this.z) {
                    this.b = f.COLD;
                } else {
                    this.b = f.WARM;
                }
            }
        }
        this.f.b(Boolean.TRUE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        q0 q0Var = q0.f;
        WeakReference weakReference = (WeakReference) q0Var.b;
        if (weakReference == null || weakReference.get() == activity) {
            q0Var.b = null;
        }
        int iDecrementAndGet = this.B0.decrementAndGet();
        if (iDecrementAndGet < 0) {
            this.B0.set(0);
            iDecrementAndGet = 0;
        }
        if (iDecrementAndGet != 0 || activity.isChangingConfigurations()) {
            return;
        }
        this.b = f.WARM;
        this.f.b(Boolean.TRUE);
        this.A0 = true;
        this.C0.set(false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        q0 q0Var = q0.f;
        WeakReference weakReference = (WeakReference) q0Var.b;
        if (weakReference == null || weakReference.get() == activity) {
            q0Var.b = null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        q0.f.b(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        q0.f.b(activity);
        if (this.C0.get()) {
            return;
        }
        if (activity.getWindow() != null) {
            final int i = 0;
            io.sentry.android.core.internal.util.i.a(activity, new Runnable(this) { // from class: io.sentry.android.core.performance.d
                public final /* synthetic */ g f;

                {
                    this.f = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    int i2 = i;
                    g gVar = this.f;
                    switch (i2) {
                        case 0:
                            gVar.h();
                            break;
                        default:
                            gVar.h();
                            break;
                    }
                }
            }, new q0(w2.b));
        } else {
            final int i2 = 1;
            new Handler(Looper.getMainLooper()).post(new Runnable(this) { // from class: io.sentry.android.core.performance.d
                public final /* synthetic */ g f;

                {
                    this.f = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    int i22 = i2;
                    g gVar = this.f;
                    switch (i22) {
                        case 0:
                            gVar.h();
                            break;
                        default:
                            gVar.h();
                            break;
                    }
                }
            });
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        q0 q0Var = q0.f;
        WeakReference weakReference = (WeakReference) q0Var.b;
        if (weakReference == null || weakReference.get() == activity) {
            q0Var.b = null;
        }
    }
}
