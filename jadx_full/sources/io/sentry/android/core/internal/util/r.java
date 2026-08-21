package io.sentry.android.core.internal.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Choreographer;
import android.view.FrameMetrics;
import android.view.Window;
import android.view.Window$OnFrameMetricsAvailableListener;
import io.sentry.android.core.q0;
import io.sentry.android.core.w;
import io.sentry.android.core.z;
import io.sentry.p5;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r implements Application.ActivityLifecycleCallbacks {
    public volatile Handler A;
    public final m A0;
    public Choreographer B0;
    public final Field C0;
    public long D0;
    public long E0;
    public final ConcurrentSkipListSet F0;
    public final io.sentry.util.a X;
    public WeakReference Y;
    public final ConcurrentHashMap Z;
    public final q0 b;
    public final CopyOnWriteArraySet f;
    public final boolean y0;
    public final w z;
    public final c z0;

    /* JADX WARN: Type inference failed for: r4v5, types: [io.sentry.android.core.internal.util.m] */
    public r(Context context, w wVar, final q0 q0Var) {
        c cVar = new c();
        this.f = new CopyOnWriteArraySet();
        this.X = new io.sentry.util.a();
        this.Z = new ConcurrentHashMap();
        this.y0 = false;
        this.D0 = 0L;
        this.E0 = 0L;
        this.F0 = new ConcurrentSkipListSet();
        Context applicationContext = context.getApplicationContext();
        context = applicationContext != null ? applicationContext : context;
        this.z = wVar;
        this.b = q0Var;
        this.z0 = cVar;
        if ((context instanceof Application) && Build.VERSION.SDK_INT >= 24) {
            this.y0 = true;
            ((Application) context).registerActivityLifecycleCallbacks(this);
            new Handler(Looper.getMainLooper()).post(new z(7, this, wVar));
            try {
                Field declaredField = Choreographer.class.getDeclaredField("mLastFrameTimeNanos");
                this.C0 = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                wVar.d(p5.ERROR, "Unable to get the frame timestamp from the choreographer: ", e);
            }
            this.A0 = new Window$OnFrameMetricsAvailableListener() { // from class: io.sentry.android.core.internal.util.m
                public final void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
                    this.a.a(q0Var, window, frameMetrics);
                }
            };
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(q0 q0Var, Window window, FrameMetrics frameMetrics) {
        long jLongValue;
        Field field;
        long jNanoTime = System.nanoTime();
        int i = Build.VERSION.SDK_INT;
        float refreshRate = i >= 30 ? window.getContext().getDisplay().getRefreshRate() : window.getWindowManager().getDefaultDisplay().getRefreshRate();
        long metric = frameMetrics.getMetric(5) + frameMetrics.getMetric(4) + frameMetrics.getMetric(3) + frameMetrics.getMetric(2) + frameMetrics.getMetric(1) + frameMetrics.getMetric(0);
        long jMax = Math.max(0L, metric - ((long) (1.0E9f / refreshRate)));
        this.b.getClass();
        if (i >= 26) {
            jLongValue = frameMetrics.getMetric(10);
        } else {
            Choreographer choreographer = this.B0;
            if (choreographer == null || (field = this.C0) == null) {
                jLongValue = -1;
            } else {
                try {
                    Long l = (Long) field.get(choreographer);
                    if (l != null) {
                        jLongValue = l.longValue();
                    }
                } catch (IllegalAccessException unused) {
                }
            }
        }
        if (jLongValue < 0) {
            jLongValue = jNanoTime - metric;
        }
        long jMax2 = Math.max(jLongValue, this.E0);
        if (jMax2 == this.D0) {
            return;
        }
        this.D0 = jMax2;
        long j = jMax2 + metric;
        this.E0 = j;
        boolean z = metric > ((long) (1.0E9f / (refreshRate - 1.0f)));
        boolean z2 = z && metric > 700000000;
        if (jMax > 0) {
            long j2 = j - 300000000000L;
            o oVar = new o(j2, j2);
            ConcurrentSkipListSet concurrentSkipListSet = this.F0;
            concurrentSkipListSet.headSet(oVar).clear();
            if (concurrentSkipListSet.size() < 3600) {
                concurrentSkipListSet.add(new o(jMax2, this.E0));
            }
        }
        Iterator it = this.Z.values().iterator();
        while (it.hasNext()) {
            long j3 = metric;
            long j4 = jMax;
            ((p) it.next()).b(jMax2, this.E0, j3, j4, z, z2, refreshRate);
            jMax = j4;
            metric = j3;
        }
    }

    public final String b(p pVar) {
        if (!this.y0) {
            return null;
        }
        if (this.A == null) {
            io.sentry.util.a aVar = this.X;
            aVar.g();
            try {
                if (this.A == null) {
                    HandlerThread handlerThread = new HandlerThread("io.sentry.android.core.internal.util.SentryFrameMetricsCollector");
                    handlerThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: io.sentry.android.core.internal.util.n
                        @Override // java.lang.Thread.UncaughtExceptionHandler
                        public final void uncaughtException(Thread thread, Throwable th) {
                            this.b.z.d(p5.ERROR, "Error during frames measurements.", th);
                        }
                    });
                    handlerThread.start();
                    this.A = new Handler(handlerThread.getLooper());
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
        String strF = io.sentry.config.a.f();
        this.Z.put(strF, pVar);
        d();
        return strF;
    }

    public final void c(String str) {
        if (this.y0) {
            ConcurrentHashMap concurrentHashMap = this.Z;
            if (str != null) {
                concurrentHashMap.remove(str);
            }
            WeakReference weakReference = this.Y;
            Window window = weakReference != null ? (Window) weakReference.get() : null;
            if (window == null || !concurrentHashMap.isEmpty()) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new l(this, window, 1));
        }
    }

    public final void d() {
        WeakReference weakReference = this.Y;
        Window window = weakReference != null ? (Window) weakReference.get() : null;
        if (window == null || !this.y0 || this.Z.isEmpty() || this.A == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new l(this, window, 0));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        Window window = activity.getWindow();
        WeakReference weakReference = this.Y;
        if (weakReference == null || weakReference.get() != window) {
            this.Y = new WeakReference(window);
            d();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        new Handler(Looper.getMainLooper()).post(new l(this, activity.getWindow(), 1));
        WeakReference weakReference = this.Y;
        if (weakReference == null || weakReference.get() != activity.getWindow()) {
            return;
        }
        this.Y = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
