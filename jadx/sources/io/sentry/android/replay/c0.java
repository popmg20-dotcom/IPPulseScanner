package io.sentry.android.replay;

import android.graphics.Point;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import defpackage.d70;
import defpackage.r10;
import defpackage.vf2;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.n2;
import io.sentry.p5;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c0 implements e, Closeable {
    public final n2 A;
    public final io.sentry.util.a A0;
    public final io.sentry.util.a B0;
    public final io.sentry.util.a C0;
    public volatile z D0;
    public volatile HandlerThread E0;
    public volatile Handler F0;
    public final ScheduledExecutorService X;
    public final AtomicBoolean Y;
    public final ArrayList Z;
    public final SentryAndroidOptions b;
    public final ReplayIntegration f;
    public final Point y0;
    public final ReplayIntegration z;
    public final WeakHashMap z0;

    public c0(SentryAndroidOptions sentryAndroidOptions, ReplayIntegration replayIntegration, ReplayIntegration replayIntegration2, n2 n2Var, io.sentry.android.replay.util.i iVar) {
        n2Var.getClass();
        iVar.getClass();
        this.b = sentryAndroidOptions;
        this.f = replayIntegration;
        this.z = replayIntegration2;
        this.A = n2Var;
        this.X = iVar;
        this.Y = new AtomicBoolean(false);
        this.Z = new ArrayList();
        this.y0 = new Point();
        this.z0 = new WeakHashMap();
        this.A0 = new io.sentry.util.a();
        this.B0 = new io.sentry.util.a();
        this.C0 = new io.sentry.util.a();
    }

    public final void C() {
        View view;
        z zVar = this.D0;
        if (zVar != null) {
            n2 n2Var = zVar.f;
            SentryAndroidOptions sentryAndroidOptions = zVar.b;
            if (sentryAndroidOptions.getSessionReplay().m) {
                sentryAndroidOptions.getLogger().h(p5.DEBUG, "Resuming the capture runnable.", new Object[0]);
            }
            u uVar = zVar.z;
            if (uVar != null) {
                WeakReference weakReference = uVar.f;
                if (weakReference != null && (view = (View) weakReference.get()) != null && view.getViewTreeObserver() != null && view.getViewTreeObserver().isAlive()) {
                    try {
                        view.getViewTreeObserver().addOnDrawListener(uVar);
                    } catch (IllegalStateException unused) {
                    }
                }
                uVar.z.set(true);
            }
            zVar.X.getAndSet(true);
            ((Handler) n2Var.f).removeCallbacks(zVar);
            if (((Handler) n2Var.f).post(zVar)) {
                return;
            }
            sentryAndroidOptions.getLogger().h(p5.WARNING, "Failed to post the capture runnable, main looper is not ready.", new Object[0]);
        }
    }

    public final void F() {
        z zVar = this.D0;
        if (zVar != null) {
            u uVar = zVar.z;
            if (uVar != null) {
                uVar.z.set(false);
                WeakReference weakReference = uVar.f;
                uVar.c(weakReference != null ? (View) weakReference.get() : null);
                WeakReference weakReference2 = uVar.f;
                if (weakReference2 != null) {
                    weakReference2.clear();
                }
                uVar.X.close();
            }
            zVar.z = null;
            zVar.X.getAndSet(false);
        }
        io.sentry.util.a aVar = this.B0;
        aVar.g();
        try {
            this.D0 = null;
            vf2.e(aVar, null);
            this.Y.set(false);
        } finally {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        reset();
        n2 n2Var = this.A;
        z zVar = this.D0;
        Handler handler = (Handler) n2Var.f;
        if (zVar != null) {
            handler.removeCallbacks(zVar);
        }
        io.sentry.util.a aVar = this.C0;
        aVar.g();
        try {
            Handler handler2 = this.F0;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
            }
            HandlerThread handlerThread = this.E0;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
            vf2.e(aVar, null);
            F();
        } finally {
        }
    }

    @Override // io.sentry.android.replay.e
    public final void g(View view, boolean z) {
        u uVar;
        u uVar2;
        u uVar3;
        view.getClass();
        io.sentry.util.a aVar = this.A0;
        aVar.g();
        int i = 6;
        int i2 = 0;
        try {
            if (!z) {
                View.OnLayoutChangeListener onLayoutChangeListener = (View.OnLayoutChangeListener) this.z0.remove(view);
                if (onLayoutChangeListener != null) {
                    view.removeOnLayoutChangeListener(onLayoutChangeListener);
                }
                z zVar = this.D0;
                if (zVar != null && (uVar2 = zVar.z) != null) {
                    uVar2.c(view);
                }
                d70.o0(this.Z, new b0(view, i2));
                WeakReference weakReference = (WeakReference) d70.l0(this.Z);
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && !view.equals(view2)) {
                    z zVar2 = this.D0;
                    if (zVar2 != null && (uVar = zVar2.z) != null) {
                        uVar.a(view2);
                    }
                    n(view2);
                    WeakHashMap weakHashMap = this.z0;
                    if (!weakHashMap.containsKey(view2)) {
                        r10 r10Var = new r10(i, this);
                        weakHashMap.put(view2, r10Var);
                        view2.addOnLayoutChangeListener(r10Var);
                    }
                }
            } else {
                if (io.sentry.config.a.j(view) == null) {
                    this.b.getLogger().h(p5.WARNING, "Root view does not have a phone window, skipping.", new Object[0]);
                    vf2.e(aVar, null);
                    return;
                }
                this.Z.add(new WeakReference(view));
                z zVar3 = this.D0;
                if (zVar3 != null && (uVar3 = zVar3.z) != null) {
                    uVar3.a(view);
                }
                n(view);
                WeakHashMap weakHashMap2 = this.z0;
                if (!weakHashMap2.containsKey(view)) {
                    r10 r10Var2 = new r10(i, this);
                    weakHashMap2.put(view, r10Var2);
                    view.addOnLayoutChangeListener(r10Var2);
                }
            }
            vf2.e(aVar, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                vf2.e(aVar, th);
                throw th2;
            }
        }
    }

    public final void n(View view) {
        view.getClass();
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            a0 a0Var = new a0(this, view);
            if (view.getViewTreeObserver() == null || !view.getViewTreeObserver().isAlive()) {
                return;
            }
            try {
                view.getViewTreeObserver().addOnPreDrawListener(a0Var);
                return;
            } catch (IllegalStateException unused) {
                return;
            }
        }
        int width = view.getWidth();
        Point point = this.y0;
        if (width == point.x && view.getHeight() == point.y) {
            return;
        }
        point.set(view.getWidth(), view.getHeight());
        this.z.n0(view.getWidth(), view.getHeight());
    }

    public final void reset() {
        u uVar;
        this.y0.set(0, 0);
        io.sentry.util.a aVar = this.A0;
        aVar.g();
        try {
            Iterator it = this.Z.iterator();
            while (it.hasNext()) {
                View view = (View) ((WeakReference) it.next()).get();
                if (view != null) {
                    View.OnLayoutChangeListener onLayoutChangeListener = (View.OnLayoutChangeListener) this.z0.remove(view);
                    if (onLayoutChangeListener != null) {
                        view.removeOnLayoutChangeListener(onLayoutChangeListener);
                    }
                    z zVar = this.D0;
                    if (zVar != null && (uVar = zVar.z) != null) {
                        uVar.c(view);
                    }
                }
            }
            this.Z.clear();
            vf2.e(aVar, null);
        } finally {
        }
    }

    public final Handler s() {
        if (this.F0 == null) {
            io.sentry.util.a aVar = this.C0;
            aVar.g();
            try {
                if (this.F0 == null) {
                    this.E0 = new HandlerThread("SentryReplayBackgroundProcessing");
                    HandlerThread handlerThread = this.E0;
                    if (handlerThread != null) {
                        handlerThread.start();
                    }
                    HandlerThread handlerThread2 = this.E0;
                    handlerThread2.getClass();
                    this.F0 = new Handler(handlerThread2.getLooper());
                }
                vf2.e(aVar, null);
            } finally {
            }
        }
        Handler handler = this.F0;
        handler.getClass();
        return handler;
    }

    public final void x() {
        z zVar = this.D0;
        if (zVar != null) {
            u uVar = zVar.z;
            if (uVar != null) {
                uVar.z.set(false);
                WeakReference weakReference = uVar.f;
                uVar.c(weakReference != null ? (View) weakReference.get() : null);
            }
            zVar.X.getAndSet(false);
        }
    }
}
