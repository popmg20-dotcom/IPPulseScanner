package io.sentry.android.replay.screenshot;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.view.PixelCopy;
import android.view.View;
import android.view.Window;
import defpackage.ek0;
import defpackage.mf2;
import defpackage.tt;
import defpackage.v10;
import defpackage.z82;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.replay.ReplayIntegration;
import io.sentry.android.replay.c0;
import io.sentry.android.replay.v;
import io.sentry.n2;
import io.sentry.p5;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i implements j {
    public final ReplayIntegration a;
    public final SentryAndroidOptions b;
    public final v c;
    public final v10 d;
    public final ScheduledExecutorService e;
    public final n2 f;
    public final Bitmap g;
    public final z82 h;
    public final AtomicBoolean i;
    public final io.sentry.android.replay.util.g j;
    public final AtomicBoolean k;
    public final AtomicInteger l;
    public final AtomicBoolean m;
    public final AtomicBoolean n;
    public final z82 o;
    public final z82 p;
    public final Rect q;
    public final RectF r;
    public final int[] s;
    public final int[] t;

    public i(c0 c0Var, ReplayIntegration replayIntegration, SentryAndroidOptions sentryAndroidOptions, v vVar, io.sentry.android.replay.util.c cVar, v10 v10Var) {
        c0Var.getClass();
        this.a = replayIntegration;
        this.b = sentryAndroidOptions;
        this.c = vVar;
        this.d = v10Var;
        this.e = c0Var.X;
        this.f = c0Var.A;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(vVar.a, vVar.b, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.getClass();
        this.g = bitmapCreateBitmap;
        this.h = ek0.v(new h(this, 0));
        this.i = new AtomicBoolean(false);
        this.j = new io.sentry.android.replay.util.g();
        this.k = new AtomicBoolean(false);
        this.l = new AtomicInteger(0);
        this.m = new AtomicBoolean(false);
        this.n = new AtomicBoolean(false);
        this.o = ek0.v(g.f);
        this.p = ek0.v(new h(this, 1));
        this.q = new Rect();
        this.r = new RectF();
        this.s = new int[2];
        this.t = new int[2];
    }

    public static final void f(AtomicInteger atomicInteger, final i iVar, final View view, final tt[] ttVarArr, final io.sentry.android.replay.viewhierarchy.h hVar, final int i, final int i2, final boolean z) {
        if (atomicInteger.decrementAndGet() == 0 && iVar.e.submit(new io.sentry.android.replay.util.j(new Runnable() { // from class: io.sentry.android.replay.screenshot.f
            /* JADX WARN: Removed duplicated region for block: B:18:0x0098  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void run() {
                /*
                    Method dump skipped, instruction units count: 223
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.replay.screenshot.f.run():void");
            }
        }, "screenshot_recorder.composite")) == null) {
            for (tt ttVar : ttVarArr) {
                if (ttVar != null) {
                    Bitmap bitmap = (Bitmap) ttVar.d;
                    if (!bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                }
            }
            iVar.h();
        }
    }

    @Override // io.sentry.android.replay.screenshot.j
    public final boolean a() {
        return this.i.get();
    }

    @Override // io.sentry.android.replay.screenshot.j
    public final void b(View view) throws IllegalAccessException {
        Window windowJ = io.sentry.config.a.j(view);
        SentryAndroidOptions sentryAndroidOptions = this.b;
        if (windowJ == null) {
            sentryAndroidOptions.getLogger().h(p5.DEBUG, "Window is invalid, not capturing screenshot", new Object[0]);
            return;
        }
        if (!this.n.compareAndSet(false, true)) {
            sentryAndroidOptions.getLogger().h(p5.DEBUG, "PixelCopyStrategy capture is already in flight, skipping", new Object[0]);
            this.d.a();
            return;
        }
        if (this.m.get()) {
            sentryAndroidOptions.getLogger().h(p5.DEBUG, "PixelCopyStrategy is closed, not capturing screenshot", new Object[0]);
            h();
            return;
        }
        try {
            this.k.set(false);
            PixelCopy.request(windowJ, this.g, new mf2(2, this, view), (Handler) this.f.f);
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().d(p5.WARNING, "Failed to capture replay recording", th);
            this.l.set(0);
            this.i.set(false);
            h();
        }
    }

    @Override // io.sentry.android.replay.screenshot.j
    public final void c() {
        if (this.n.compareAndSet(false, true)) {
            if (!this.i.get() || this.g.isRecycled()) {
                h();
                return;
            }
            if (this.e.submit(new io.sentry.android.replay.util.j(new c(this, 1), "PixelCopyStrategy.emit")) == null) {
                h();
            }
        }
    }

    @Override // io.sentry.android.replay.screenshot.j
    public final void close() {
        this.m.set(true);
        this.l.set(0);
        g();
    }

    public final void d(View view, io.sentry.android.replay.viewhierarchy.h hVar, boolean z) {
        boolean z2 = this.m.get();
        SentryAndroidOptions sentryAndroidOptions = this.b;
        if (!z2) {
            Bitmap bitmap = this.g;
            if (!bitmap.isRecycled()) {
                this.j.g(bitmap, hVar, (Matrix) this.h.getValue());
                sentryAndroidOptions.getReplayController().getClass();
                this.a.j0(bitmap);
                this.i.set(true);
                this.k.set(false);
                if (z) {
                    this.l.set(0);
                    return;
                }
                return;
            }
        }
        sentryAndroidOptions.getLogger().h(p5.DEBUG, "PixelCopyStrategy is closed, skipping masking", new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(final android.view.View r19, java.util.ArrayList r20, final io.sentry.android.replay.viewhierarchy.h r21, final boolean r22) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.replay.screenshot.i.e(android.view.View, java.util.ArrayList, io.sentry.android.replay.viewhierarchy.h, boolean):void");
    }

    public final void g() {
        if (this.n.compareAndSet(false, true)) {
            io.sentry.android.replay.util.j jVar = new io.sentry.android.replay.util.j(new c(this, 0), "PixelCopyStrategy.close");
            if (this.e.submit(jVar) == null) {
                jVar.run();
            }
        }
    }

    public final void h() {
        this.n.set(false);
        if (this.m.get()) {
            g();
        }
    }

    @Override // io.sentry.android.replay.screenshot.j
    public final void onContentChanged() {
        this.k.set(true);
    }
}
