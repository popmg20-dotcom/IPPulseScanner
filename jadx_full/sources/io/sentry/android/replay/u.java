package io.sentry.android.replay;

import android.view.View;
import android.view.ViewTreeObserver;
import defpackage.v10;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.p5;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u implements ViewTreeObserver.OnDrawListener {
    public final AtomicBoolean A;
    public final io.sentry.android.replay.screenshot.j X;
    public final SentryAndroidOptions b;
    public WeakReference f;
    public final AtomicBoolean z;

    public u(SentryAndroidOptions sentryAndroidOptions, ReplayIntegration replayIntegration, v vVar, c0 c0Var) {
        io.sentry.android.replay.screenshot.j bVar;
        c0Var.getClass();
        this.b = sentryAndroidOptions;
        this.z = new AtomicBoolean(true);
        io.sentry.android.replay.util.c cVar = new io.sentry.android.replay.util.c();
        this.A = new AtomicBoolean(false);
        int i = t.a[sentryAndroidOptions.getSessionReplay().n.ordinal()];
        if (i == 1) {
            bVar = new io.sentry.android.replay.screenshot.b(sentryAndroidOptions, replayIntegration, vVar, c0Var);
        } else {
            if (i != 2) {
                defpackage.g.d();
                throw null;
            }
            bVar = new io.sentry.android.replay.screenshot.i(c0Var, replayIntegration, sentryAndroidOptions, vVar, cVar, new v10(7, this));
        }
        this.X = bVar;
    }

    public final void a(View view) {
        view.getClass();
        WeakReference weakReference = this.f;
        c(weakReference != null ? (View) weakReference.get() : null);
        WeakReference weakReference2 = this.f;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        this.f = new WeakReference(view);
        if (view.getViewTreeObserver() != null && view.getViewTreeObserver().isAlive()) {
            try {
                view.getViewTreeObserver().addOnDrawListener(this);
            } catch (IllegalStateException unused) {
            }
        }
        this.A.set(true);
        this.X.onContentChanged();
    }

    public final void b() {
        SentryAndroidOptions sentryAndroidOptions = this.b;
        boolean z = sentryAndroidOptions.getSessionReplay().m;
        AtomicBoolean atomicBoolean = this.z;
        if (z) {
            sentryAndroidOptions.getLogger().h(p5.DEBUG, "Capturing screenshot, isCapturing: %s", Boolean.valueOf(atomicBoolean.get()));
        }
        if (!atomicBoolean.get()) {
            if (sentryAndroidOptions.getSessionReplay().m) {
                sentryAndroidOptions.getLogger().h(p5.DEBUG, "ScreenshotRecorder is paused, not capturing screenshot", new Object[0]);
                return;
            }
            return;
        }
        boolean z2 = sentryAndroidOptions.getSessionReplay().m;
        io.sentry.android.replay.screenshot.j jVar = this.X;
        AtomicBoolean atomicBoolean2 = this.A;
        if (z2) {
            sentryAndroidOptions.getLogger().h(p5.DEBUG, "Capturing screenshot, contentChanged: %s, lastCaptureSuccessful: %s", Boolean.valueOf(atomicBoolean2.get()), Boolean.valueOf(jVar.a()));
        }
        if (!atomicBoolean2.get()) {
            jVar.c();
            return;
        }
        WeakReference weakReference = this.f;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (view == null || view.getWidth() <= 0 || view.getHeight() <= 0 || !view.isShown()) {
            sentryAndroidOptions.getLogger().h(p5.DEBUG, "Root view is invalid, not capturing screenshot", new Object[0]);
            return;
        }
        if (io.sentry.config.a.j(view) == null) {
            sentryAndroidOptions.getLogger().h(p5.DEBUG, "Window is invalid, not capturing screenshot", new Object[0]);
            return;
        }
        try {
            atomicBoolean2.set(false);
            jVar.b(view);
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().d(p5.WARNING, "Failed to capture replay recording", th);
        }
    }

    public final void c(View view) {
        this.b.getReplayController().getClass();
        if (view == null || view.getViewTreeObserver() == null || !view.getViewTreeObserver().isAlive()) {
            return;
        }
        try {
            view.getViewTreeObserver().removeOnDrawListener(this);
        } catch (IllegalStateException unused) {
        }
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        if (this.z.get()) {
            WeakReference weakReference = this.f;
            View view = weakReference != null ? (View) weakReference.get() : null;
            if (view == null || view.getWidth() <= 0 || view.getHeight() <= 0 || !view.isShown()) {
                this.b.getLogger().h(p5.DEBUG, "Root view is invalid, not capturing screenshot", new Object[0]);
            } else {
                this.A.set(true);
                this.X.onContentChanged();
            }
        }
    }
}
