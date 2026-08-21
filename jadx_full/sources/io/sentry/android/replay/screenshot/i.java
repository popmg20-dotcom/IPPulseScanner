package io.sentry.android.replay.screenshot;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.view.PixelCopy;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
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
import java.util.ArrayList;
import java.util.Iterator;
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
            */
            public final void run() {
                int i3;
                int i4;
                int i5;
                i iVar2 = this.b;
                int i6 = i;
                int i7 = i2;
                View view2 = view;
                io.sentry.android.replay.viewhierarchy.h hVar2 = hVar;
                boolean z2 = z;
                try {
                    boolean z3 = iVar2.m.get();
                    tt[] ttVarArr2 = ttVarArr;
                    if (!z3 && !iVar2.g.isRecycled()) {
                        int length = ttVarArr2.length;
                        int i8 = 0;
                        while (i8 < length) {
                            tt ttVar = ttVarArr2[i8];
                            if (ttVar != null) {
                                Bitmap bitmap = (Bitmap) ttVar.d;
                                if (bitmap.isRecycled()) {
                                    i3 = i6;
                                    i4 = i7;
                                    i5 = length;
                                } else {
                                    Canvas canvas = (Canvas) iVar2.p.getValue();
                                    Paint paint = (Paint) iVar2.o.getValue();
                                    Rect rect = iVar2.q;
                                    RectF rectF = iVar2.r;
                                    int i9 = ttVar.b;
                                    int i10 = ttVar.c;
                                    i3 = i6;
                                    v vVar = iVar2.c;
                                    i4 = i7;
                                    float f = vVar.c;
                                    float f2 = vVar.d;
                                    canvas.getClass();
                                    paint.getClass();
                                    rect.getClass();
                                    rectF.getClass();
                                    float f3 = (i9 - i3) * f;
                                    float f4 = (i10 - i4) * f2;
                                    i5 = length;
                                    rect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
                                    rectF.set(f3, f4, (bitmap.getWidth() * f) + f3, (bitmap.getHeight() * f2) + f4);
                                    canvas.drawBitmap(bitmap, rect, rectF, paint);
                                    bitmap.recycle();
                                }
                            }
                            i8++;
                            i6 = i3;
                            i7 = i4;
                            length = i5;
                        }
                        iVar2.d(view2, hVar2, z2);
                        iVar2.h();
                        return;
                    }
                    iVar2.b.getLogger().h(p5.DEBUG, "PixelCopyStrategy is closed, skipping compositing", new Object[0]);
                    for (tt ttVar2 : ttVarArr2) {
                        if (ttVar2 != null) {
                            Bitmap bitmap2 = (Bitmap) ttVar2.d;
                            if (!bitmap2.isRecycled()) {
                                bitmap2.recycle();
                            }
                        }
                    }
                    iVar2.h();
                } catch (Throwable th) {
                    iVar2.h();
                    throw th;
                }
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
    */
    public final void e(final View view, ArrayList arrayList, final io.sentry.android.replay.viewhierarchy.h hVar, final boolean z) {
        tt[] ttVarArr;
        AtomicInteger atomicInteger;
        final i iVar;
        final int i;
        final int i2;
        SurfaceHolder holder;
        i iVar2 = this;
        int[] iArr = iVar2.t;
        int[] iArr2 = iVar2.s;
        view.getLocationOnScreen(iArr2);
        char c = 0;
        int i3 = iArr2[0];
        int i4 = iArr2[1];
        tt[] ttVarArr2 = new tt[arrayList.size()];
        AtomicInteger atomicInteger2 = new AtomicInteger(arrayList.size());
        Iterator it = arrayList.iterator();
        final tt[] ttVarArr3 = ttVarArr2;
        final int i5 = 0;
        while (it.hasNext()) {
            int i6 = i5 + 1;
            SurfaceView surfaceView = (SurfaceView) ((io.sentry.android.replay.viewhierarchy.f) it.next()).h.get();
            final Bitmap bitmapCreateBitmap = null;
            Surface surface = (surfaceView == null || (holder = surfaceView.getHolder()) == null) ? null : holder.getSurface();
            if (surfaceView == null || surface == null) {
                iVar2 = this;
            } else {
                if (surface.isValid()) {
                    try {
                        bitmapCreateBitmap = Bitmap.createBitmap(surfaceView.getWidth(), surfaceView.getHeight(), Bitmap.Config.ARGB_8888);
                        try {
                            surfaceView.getLocationOnScreen(iArr);
                            try {
                                i = iArr[c];
                                i2 = i3;
                            } catch (Throwable th) {
                                th = th;
                                atomicInteger = atomicInteger2;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            atomicInteger = atomicInteger2;
                            iVar = iVar2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        atomicInteger = atomicInteger2;
                        iVar = iVar2;
                    }
                    try {
                        final int i7 = iArr[1];
                        final int i8 = i4;
                        final AtomicInteger atomicInteger3 = atomicInteger2;
                        iVar = this;
                        try {
                            PixelCopy.OnPixelCopyFinishedListener onPixelCopyFinishedListener = new PixelCopy.OnPixelCopyFinishedListener() { // from class: io.sentry.android.replay.screenshot.e
                                @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                                public final void onPixelCopyFinished(int i9) {
                                    i iVar3 = this.a;
                                    Bitmap bitmap = bitmapCreateBitmap;
                                    tt[] ttVarArr4 = ttVarArr3;
                                    int i10 = i5;
                                    int i11 = i;
                                    int i12 = i7;
                                    AtomicInteger atomicInteger4 = atomicInteger3;
                                    View view2 = view;
                                    io.sentry.android.replay.viewhierarchy.h hVar2 = hVar;
                                    int i13 = i2;
                                    int i14 = i8;
                                    boolean z2 = z;
                                    if (iVar3.m.get()) {
                                        bitmap.recycle();
                                        i.f(atomicInteger4, iVar3, view2, ttVarArr4, hVar2, i13, i14, z2);
                                        return;
                                    }
                                    if (i9 == 0) {
                                        ttVarArr4[i10] = new tt(bitmap, i11, i12);
                                    } else {
                                        bitmap.recycle();
                                        iVar3.b.getLogger().h(p5.INFO, "Failed to capture SurfaceView: %d", Integer.valueOf(i9));
                                    }
                                    i.f(atomicInteger4, iVar3, view2, ttVarArr4, hVar2, i13, i14, z2);
                                }
                            };
                            atomicInteger = atomicInteger3;
                            i3 = i2;
                            i4 = i8;
                            try {
                                PixelCopy.request(surfaceView, bitmapCreateBitmap, onPixelCopyFinishedListener, (Handler) iVar.f.f);
                                atomicInteger2 = atomicInteger;
                            } catch (Throwable th4) {
                                th = th4;
                                bitmapCreateBitmap = bitmapCreateBitmap;
                                iVar.b.getLogger().d(p5.WARNING, "Failed to capture SurfaceView", th);
                                if (bitmapCreateBitmap != null) {
                                    bitmapCreateBitmap.recycle();
                                }
                                i iVar3 = iVar;
                                atomicInteger2 = atomicInteger;
                                ttVarArr = ttVarArr3;
                                f(atomicInteger2, iVar3, view, ttVarArr, hVar, i3, i4, z);
                                ttVarArr3 = ttVarArr;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            atomicInteger = atomicInteger3;
                            i3 = i2;
                            i4 = i8;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        atomicInteger = atomicInteger2;
                        i3 = i2;
                        iVar = this;
                        bitmapCreateBitmap = bitmapCreateBitmap;
                        iVar.b.getLogger().d(p5.WARNING, "Failed to capture SurfaceView", th);
                        if (bitmapCreateBitmap != null) {
                        }
                        i iVar32 = iVar;
                        atomicInteger2 = atomicInteger;
                        ttVarArr = ttVarArr3;
                        f(atomicInteger2, iVar32, view, ttVarArr, hVar, i3, i4, z);
                        ttVarArr3 = ttVarArr;
                        c = 0;
                        iVar2 = this;
                        i5 = i6;
                    }
                    c = 0;
                    iVar2 = this;
                    i5 = i6;
                }
                ttVarArr3 = ttVarArr;
                c = 0;
                iVar2 = this;
                i5 = i6;
            }
            ttVarArr = ttVarArr3;
            f(atomicInteger2, iVar2, view, ttVarArr, hVar, i3, i4, z);
            ttVarArr3 = ttVarArr;
            c = 0;
            iVar2 = this;
            i5 = i6;
        }
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
