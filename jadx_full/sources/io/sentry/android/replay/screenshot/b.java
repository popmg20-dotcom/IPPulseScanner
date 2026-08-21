package io.sentry.android.replay.screenshot;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.View;
import defpackage.ek0;
import defpackage.m74;
import defpackage.v10;
import defpackage.vf2;
import defpackage.z82;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.replay.ReplayIntegration;
import io.sentry.android.replay.c0;
import io.sentry.android.replay.v;
import io.sentry.p5;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b implements j {
    public final c0 a;
    public final ReplayIntegration b;
    public final SentryAndroidOptions c;
    public final v d;
    public volatile Bitmap e;
    public final AtomicReference f;
    public final io.sentry.util.a g;
    public final z82 h;
    public final AtomicBoolean i;
    public final k j;
    public final AtomicBoolean k;
    public final SurfaceTexture l;
    public final Surface m;
    public final a n;

    public b(SentryAndroidOptions sentryAndroidOptions, ReplayIntegration replayIntegration, v vVar, c0 c0Var) {
        c0Var.getClass();
        this.a = c0Var;
        this.b = replayIntegration;
        this.c = sentryAndroidOptions;
        this.d = vVar;
        this.f = new AtomicReference(null);
        this.g = new io.sentry.util.a();
        this.h = ek0.v(new v10(8, this));
        this.i = new AtomicBoolean(false);
        this.j = new k();
        this.k = new AtomicBoolean(false);
        SurfaceTexture surfaceTexture = new SurfaceTexture(false);
        surfaceTexture.setDefaultBufferSize(vVar.a, vVar.b);
        this.l = surfaceTexture;
        this.m = new Surface(surfaceTexture);
        io.sentry.util.b.a("ReplayCanvasStrategy");
        this.n = new a(this, 0);
    }

    public static final void d(b bVar) {
        if (bVar.k.get()) {
            bVar.c.getLogger().h(p5.DEBUG, "Canvas Strategy already closed, skipping picture render", new Object[0]);
            return;
        }
        Picture picture = (Picture) bVar.f.getAndSet(null);
        if (picture == null) {
            return;
        }
        try {
            Canvas canvasLockHardwareCanvas = bVar.m.lockHardwareCanvas();
            try {
                canvasLockHardwareCanvas.drawColor(-16777216, PorterDuff.Mode.CLEAR);
                picture.draw(canvasLockHardwareCanvas);
                bVar.m.unlockCanvasAndPost(canvasLockHardwareCanvas);
                if (bVar.e == null) {
                    io.sentry.util.a aVar = bVar.g;
                    aVar.g();
                    try {
                        if (bVar.e == null) {
                            v vVar = bVar.d;
                            bVar.e = Bitmap.createBitmap(vVar.a, vVar.b, Bitmap.Config.ARGB_8888);
                        }
                        vf2.e(aVar, null);
                    } finally {
                    }
                }
                if (bVar.k.get()) {
                    bVar.c.getLogger().h(p5.DEBUG, "Canvas Strategy already closed, skipping pixel copy request", new Object[0]);
                    return;
                }
                Surface surface = bVar.m;
                Bitmap bitmap = bVar.e;
                bitmap.getClass();
                PixelCopy.request(surface, bitmap, new m74(1, bVar), bVar.a.s());
            } catch (Throwable th) {
                bVar.m.unlockCanvasAndPost(canvasLockHardwareCanvas);
                throw th;
            }
        } catch (Throwable th2) {
            bVar.c.getLogger().d(p5.ERROR, "Canvas Strategy: picture render failed", th2);
            bVar.i.set(false);
        }
    }

    @Override // io.sentry.android.replay.screenshot.j
    public final boolean a() {
        return this.i.get();
    }

    @Override // io.sentry.android.replay.screenshot.j
    public final void b(View view) {
        AtomicBoolean atomicBoolean = this.k;
        if (atomicBoolean.get()) {
            return;
        }
        Picture picture = new Picture();
        v vVar = this.d;
        Canvas canvasBeginRecording = picture.beginRecording(vVar.a, vVar.b);
        canvasBeginRecording.getClass();
        k kVar = this.j;
        kVar.getClass();
        kVar.a = canvasBeginRecording;
        kVar.setMatrix((Matrix) this.h.getValue());
        view.draw(kVar);
        picture.endRecording();
        if (atomicBoolean.get()) {
            return;
        }
        this.f.set(picture);
        e(this.a.s(), new io.sentry.android.replay.util.j(this.n, "screenshot_recorder.canvas"));
    }

    @Override // io.sentry.android.replay.screenshot.j
    public final void c() {
        Bitmap bitmap;
        if (!this.i.get() || (bitmap = this.e) == null || bitmap.isRecycled()) {
            return;
        }
        this.b.j0(bitmap);
    }

    @Override // io.sentry.android.replay.screenshot.j
    public final void close() {
        this.k.set(true);
        e(this.a.s(), new io.sentry.android.replay.util.j(new a(this, 1), "CanvasStrategy.close"));
        this.f.getAndSet(null);
    }

    public final void e(Handler handler, io.sentry.android.replay.util.j jVar) {
        try {
            handler.post(jVar);
        } catch (Throwable th) {
            this.c.getLogger().d(p5.ERROR, "Canvas Strategy: failed to post runnable ".concat(jVar.b), th);
        }
    }

    @Override // io.sentry.android.replay.screenshot.j
    public final void onContentChanged() {
    }
}
