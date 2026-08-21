package io.sentry.android.replay;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.getsurfboard.ui.SurfboardApp;
import defpackage.bh3;
import defpackage.d70;
import defpackage.ij0;
import defpackage.n12;
import defpackage.n84;
import defpackage.p44;
import defpackage.vf2;
import defpackage.w44;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.h0;
import io.sentry.f1;
import io.sentry.j1;
import io.sentry.l4;
import io.sentry.n2;
import io.sentry.n5;
import io.sentry.p2;
import io.sentry.p5;
import io.sentry.r0;
import io.sentry.s0;
import io.sentry.s6;
import io.sentry.t6;
import io.sentry.v1;
import io.sentry.y2;
import io.sentry.y3;
import io.sentry.z3;
import java.io.Closeable;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ReplayIntegration implements v1, Closeable, z3, s0, io.sentry.transport.o {
    public static final /* synthetic */ int J0 = 0;
    public SentryAndroidOptions A;
    public final n84 A0;
    public final n84 B0;
    public final AtomicBoolean C0;
    public final AtomicBoolean D0;
    public io.sentry.android.replay.capture.d E0;
    public y3 F0;
    public final n2 G0;
    public final io.sentry.util.a H0;
    public final p I0;
    public f1 X;
    public c0 Y;
    public io.sentry.android.replay.gestures.b Z;
    public final Context b;
    public final io.sentry.transport.d f;
    public final n84 y0;
    public volatile r0 z;
    public final n84 z0;

    static {
        n5.d().b("maven:io.sentry:sentry-android-replay", "8.51.0");
    }

    public ReplayIntegration(SurfboardApp surfboardApp) {
        io.sentry.transport.d dVar = io.sentry.transport.d.b;
        Context applicationContext = surfboardApp.getApplicationContext();
        this.b = applicationContext != null ? applicationContext : surfboardApp;
        this.f = dVar;
        this.z = r0.UNKNOWN;
        this.y0 = new n84(a.A);
        this.z0 = new n84(a.X);
        this.A0 = new n84(new m(this, 1));
        this.B0 = new n84(new m(this, 0));
        this.C0 = new AtomicBoolean(false);
        this.D0 = new AtomicBoolean(false);
        this.F0 = y2.a;
        this.G0 = new n2(4);
        this.H0 = new io.sentry.util.a();
        p pVar = new p();
        pVar.a = q.INITIAL;
        this.I0 = pVar;
    }

    @Override // io.sentry.z3
    public final void C(io.sentry.protocol.w wVar) {
        io.sentry.android.replay.capture.d dVar;
        wVar.getClass();
        if (!this.C0.get() || !i0() || (dVar = this.E0) == null || wVar.equals(io.sentry.protocol.w.f)) {
            return;
        }
        synchronized (dVar.r) {
            if (dVar.s.size() < 100) {
                dVar.s.add(wVar.a());
            }
        }
    }

    @Override // io.sentry.z3
    public final void F(b bVar) {
        this.F0 = bVar;
    }

    @Override // io.sentry.z3
    public final void I() {
        this.D0.set(true);
        q0();
    }

    @Override // io.sentry.v1
    public final void M(SentryAndroidOptions sentryAndroidOptions) {
        Double d;
        this.A = sentryAndroidOptions;
        if (Build.VERSION.SDK_INT < 26) {
            sentryAndroidOptions.getLogger().h(p5.INFO, "Session replay is only supported on API 26 and above", new Object[0]);
            return;
        }
        Double d2 = sentryAndroidOptions.getSessionReplay().d;
        if ((d2 == null || d2.doubleValue() <= 0.0d) && ((d = sentryAndroidOptions.getSessionReplay().e) == null || d.doubleValue() <= 0.0d)) {
            sentryAndroidOptions.getLogger().h(p5.INFO, "Session replay is disabled, no sample rate specified", new Object[0]);
            return;
        }
        l4 l4Var = l4.a;
        this.X = l4Var;
        this.Y = new c0(sentryAndroidOptions, this, this, this.G0, (io.sentry.android.replay.util.i) this.A0.getValue());
        this.Z = new io.sentry.android.replay.gestures.b(sentryAndroidOptions, this);
        this.C0.set(true);
        sentryAndroidOptions.getConnectionStatusProvider().h0(this);
        io.sentry.android.core.internal.tombstone.c cVarD = l4Var.d();
        if (cVarD != null) {
            ((CopyOnWriteArrayList) cVarD.A).add(this);
        }
        io.sentry.util.b.a("Replay");
        SentryAndroidOptions sentryAndroidOptions2 = this.A;
        if (sentryAndroidOptions2 == null) {
            n12.T("options");
            throw null;
        }
        j1 executorService = sentryAndroidOptions2.getExecutorService();
        executorService.getClass();
        SentryAndroidOptions sentryAndroidOptions3 = this.A;
        if (sentryAndroidOptions3 == null) {
            n12.T("options");
            throw null;
        }
        try {
            executorService.submit(new io.sentry.android.core.z(11, new io.sentry.android.core.g(12, this), sentryAndroidOptions3));
        } catch (Throwable th) {
            sentryAndroidOptions3.getLogger().d(p5.ERROR, "Failed to submit task ReplayIntegration.finalize_previous_replay to executor", th);
        }
    }

    @Override // io.sentry.transport.o
    public final void N(io.sentry.android.core.internal.tombstone.c cVar) {
        if (this.E0 instanceof io.sentry.android.replay.capture.o) {
            if (cVar.n(io.sentry.o.All) || cVar.n(io.sentry.o.Replay)) {
                q0();
            } else {
                r0();
            }
        }
    }

    @Override // io.sentry.z3
    public final void Q() {
        io.sentry.android.replay.capture.d gVar;
        p pVar = this.I0;
        io.sentry.util.a aVar = this.H0;
        aVar.g();
        try {
            if (!this.C0.get()) {
                vf2.e(aVar, null);
                return;
            }
            q qVar = q.STARTED;
            if (!pVar.a(qVar)) {
                SentryAndroidOptions sentryAndroidOptions = this.A;
                if (sentryAndroidOptions == null) {
                    n12.T("options");
                    throw null;
                }
                sentryAndroidOptions.getLogger().h(p5.DEBUG, "Session replay is already being recorded, not starting a new one", new Object[0]);
                vf2.e(aVar, null);
                return;
            }
            io.sentry.util.k kVar = (io.sentry.util.k) this.y0.getValue();
            SentryAndroidOptions sentryAndroidOptions2 = this.A;
            if (sentryAndroidOptions2 == null) {
                n12.T("options");
                throw null;
            }
            Double d = sentryAndroidOptions2.getSessionReplay().d;
            kVar.getClass();
            boolean z = d != null && d.doubleValue() >= kVar.c();
            if (!z) {
                SentryAndroidOptions sentryAndroidOptions3 = this.A;
                if (sentryAndroidOptions3 == null) {
                    n12.T("options");
                    throw null;
                }
                Double d2 = sentryAndroidOptions3.getSessionReplay().e;
                if (!(d2 != null && d2.doubleValue() > 0.0d)) {
                    SentryAndroidOptions sentryAndroidOptions4 = this.A;
                    if (sentryAndroidOptions4 == null) {
                        n12.T("options");
                        throw null;
                    }
                    sentryAndroidOptions4.getLogger().h(p5.INFO, "Session replay is not started, full session was not sampled and onErrorSampleRate is not specified", new Object[0]);
                    vf2.e(aVar, null);
                    return;
                }
            }
            pVar.a = qVar;
            if (z) {
                SentryAndroidOptions sentryAndroidOptions5 = this.A;
                if (sentryAndroidOptions5 == null) {
                    n12.T("options");
                    throw null;
                }
                gVar = new io.sentry.android.replay.capture.o(sentryAndroidOptions5, this.X, this.f, (io.sentry.android.replay.util.i) this.A0.getValue(), (io.sentry.android.replay.util.i) this.B0.getValue());
            } else {
                SentryAndroidOptions sentryAndroidOptions6 = this.A;
                if (sentryAndroidOptions6 == null) {
                    n12.T("options");
                    throw null;
                }
                gVar = new io.sentry.android.replay.capture.g(sentryAndroidOptions6, this.X, this.f, (io.sentry.util.k) this.y0.getValue(), (io.sentry.android.replay.util.i) this.A0.getValue(), (io.sentry.android.replay.util.i) this.B0.getValue());
            }
            this.E0 = gVar;
            c0 c0Var = this.Y;
            if (c0Var != null) {
                c0Var.Y.getAndSet(true);
            }
            io.sentry.android.replay.capture.d dVar = this.E0;
            if (dVar != null) {
                dVar.n(0, new io.sentry.protocol.w(), null);
            }
            if (this.Y != null) {
                h0 h0Var = ((s) this.z0.getValue()).z;
                c0 c0Var2 = this.Y;
                c0Var2.getClass();
                h0Var.add(c0Var2);
            }
            ((s) this.z0.getValue()).z.add(this.Z);
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

    @Override // io.sentry.z3
    public final void U(String str) {
        io.sentry.android.replay.capture.d dVar;
        if (!this.C0.get() || !i0() || (dVar = this.E0) == null || str.length() <= 0) {
            return;
        }
        synchronized (dVar.r) {
            if (dVar.t.size() < 100) {
                dVar.t.add(str);
            }
        }
    }

    @Override // io.sentry.z3
    public final y3 X() {
        return this.F0;
    }

    public final void Z() {
        f1 f1Var;
        f1 f1Var2;
        io.sentry.android.core.internal.tombstone.c cVarD;
        io.sentry.android.core.internal.tombstone.c cVarD2;
        if (this.E0 instanceof io.sentry.android.replay.capture.o) {
            if (this.z == r0.DISCONNECTED || !(((f1Var = this.X) == null || (cVarD2 = f1Var.d()) == null || !cVarD2.n(io.sentry.o.All)) && ((f1Var2 = this.X) == null || (cVarD = f1Var2.d()) == null || !cVarD.n(io.sentry.o.Replay)))) {
                q0();
            }
        }
    }

    public final void c0(String str) {
        File[] fileArrListFiles;
        SentryAndroidOptions sentryAndroidOptions = this.A;
        if (sentryAndroidOptions == null) {
            n12.T("options");
            throw null;
        }
        String cacheDirPath = sentryAndroidOptions.getCacheDirPath();
        if (cacheDirPath == null || (fileArrListFiles = new File(cacheDirPath).listFiles()) == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            String name = file.getName();
            name.getClass();
            if (w44.j0(name, "replay_", false) && !p44.o0(name, g().a(), false) && (p44.x0(str) || !p44.o0(name, str, false))) {
                io.sentry.util.b.g(file);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        io.sentry.android.core.internal.tombstone.c cVarD;
        p pVar = this.I0;
        io.sentry.util.a aVar = this.H0;
        aVar.g();
        try {
            if (this.C0.get()) {
                q qVar = q.CLOSED;
                if (pVar.a(qVar)) {
                    SentryAndroidOptions sentryAndroidOptions = this.A;
                    if (sentryAndroidOptions == null) {
                        n12.T("options");
                        throw null;
                    }
                    sentryAndroidOptions.getConnectionStatusProvider().s0(this);
                    f1 f1Var = this.X;
                    if (f1Var != null && (cVarD = f1Var.d()) != null) {
                        ((CopyOnWriteArrayList) cVarD.A).remove(this);
                    }
                    stop();
                    c0 c0Var = this.Y;
                    if (c0Var != null) {
                        c0Var.close();
                    }
                    this.Y = null;
                    ((s) this.z0.getValue()).close();
                    pVar.a = qVar;
                    vf2.e(aVar, null);
                    if (this.A0.c()) {
                        SentryAndroidOptions sentryAndroidOptions2 = this.A;
                        if (sentryAndroidOptions2 == null) {
                            n12.T("options");
                            throw null;
                        }
                        boolean zC = sentryAndroidOptions2.getThreadChecker().c();
                        n84 n84Var = this.A0;
                        if (zC) {
                            io.sentry.android.replay.util.i iVar = (io.sentry.android.replay.util.i) n84Var.getValue();
                            synchronized (iVar) {
                                if (!iVar.b.isShutdown()) {
                                    iVar.b.shutdown();
                                }
                            }
                        } else {
                            ((io.sentry.android.replay.util.i) n84Var.getValue()).shutdown();
                        }
                    }
                    if (this.B0.c()) {
                        SentryAndroidOptions sentryAndroidOptions3 = this.A;
                        if (sentryAndroidOptions3 == null) {
                            n12.T("options");
                            throw null;
                        }
                        boolean zC2 = sentryAndroidOptions3.getThreadChecker().c();
                        n84 n84Var2 = this.B0;
                        if (zC2) {
                            ((io.sentry.android.replay.util.i) n84Var2.getValue()).g();
                            return;
                        } else {
                            ((io.sentry.android.replay.util.i) n84Var2.getValue()).shutdown();
                            return;
                        }
                    }
                    return;
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

    @Override // io.sentry.z3
    public final io.sentry.protocol.w g() {
        io.sentry.protocol.w wVarD;
        io.sentry.android.replay.capture.d dVar = this.E0;
        if (dVar != null && (wVarD = dVar.d()) != null) {
            return wVarD;
        }
        io.sentry.protocol.w wVar = io.sentry.protocol.w.f;
        wVar.getClass();
        return wVar;
    }

    public final boolean i0() {
        return this.I0.a.compareTo(q.STARTED) >= 0 && this.I0.a.compareTo(q.STOPPED) < 0;
    }

    public final void j0(Bitmap bitmap) {
        bitmap.getClass();
        bh3 bh3Var = new bh3();
        f1 f1Var = this.X;
        int i = 1;
        if (f1Var != null) {
            f1Var.w(new io.sentry.android.fragment.c(bh3Var, 1));
        }
        io.sentry.android.replay.capture.d dVar = this.E0;
        if (dVar != null) {
            dVar.h(new n(this, bitmap, bh3Var));
        }
        if (n12.c(Looper.myLooper(), Looper.getMainLooper())) {
            Z();
            return;
        }
        p2 p2Var = new p2(i, this);
        n2 n2Var = this.G0;
        n2Var.getClass();
        ((Handler) n2Var.f).post(p2Var);
    }

    @Override // io.sentry.z3
    public final void n(Boolean bool) {
        if (this.C0.get() && i0()) {
            io.sentry.protocol.w wVar = io.sentry.protocol.w.f;
            io.sentry.android.replay.capture.d dVar = this.E0;
            if (wVar.equals(dVar != null ? dVar.d() : null)) {
                SentryAndroidOptions sentryAndroidOptions = this.A;
                if (sentryAndroidOptions != null) {
                    sentryAndroidOptions.getLogger().h(p5.DEBUG, "Replay id is not set, not capturing for event", new Object[0]);
                    return;
                } else {
                    n12.T("options");
                    throw null;
                }
            }
            io.sentry.android.replay.capture.d dVar2 = this.E0;
            if (dVar2 != null) {
                dVar2.a(bool.equals(Boolean.TRUE), new ij0(2, this));
            }
            io.sentry.android.replay.capture.d dVar3 = this.E0;
            this.E0 = dVar3 != null ? dVar3.b() : null;
        }
    }

    public final void n0(int i, int i2) {
        c0 c0Var;
        z zVar;
        u uVar;
        if (this.C0.get() && i0()) {
            SentryAndroidOptions sentryAndroidOptions = this.A;
            if (sentryAndroidOptions == null) {
                n12.T("options");
                throw null;
            }
            if (sentryAndroidOptions.getSessionReplay().k) {
                Context context = this.b;
                SentryAndroidOptions sentryAndroidOptions2 = this.A;
                if (sentryAndroidOptions2 == null) {
                    n12.T("options");
                    throw null;
                }
                t6 sessionReplay = sentryAndroidOptions2.getSessionReplay();
                sessionReplay.getClass();
                context.getClass();
                float f = i2;
                float f2 = f / context.getResources().getDisplayMetrics().density;
                s6 s6Var = sessionReplay.f;
                int iB = vf2.B(f2 * s6Var.sizeScale);
                int i3 = iB % 16;
                int iMax = i3 <= 8 ? Math.max(16, iB - i3) : iB + (16 - i3);
                float f3 = i;
                int iB2 = vf2.B((f3 / context.getResources().getDisplayMetrics().density) * s6Var.sizeScale);
                int i4 = iB2 % 16;
                int iMax2 = i4 <= 8 ? Math.max(16, iB2 - i4) : iB2 + (16 - i4);
                v vVar = new v(iMax2, iMax, iMax2 / f3, iMax / f, sessionReplay.g, s6Var.bitRate);
                if (this.C0.get() && i0()) {
                    io.sentry.android.replay.capture.d dVar = this.E0;
                    if (dVar != null) {
                        dVar.g(vVar);
                    }
                    c0 c0Var2 = this.Y;
                    if (c0Var2 != null && c0Var2.Y.get()) {
                        if (c0Var2.D0 == null) {
                            io.sentry.util.a aVar = c0Var2.B0;
                            aVar.g();
                            try {
                                if (c0Var2.D0 == null) {
                                    c0Var2.D0 = new z(c0Var2.b, c0Var2.A);
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
                        z zVar2 = c0Var2.D0;
                        if (zVar2 != null) {
                            zVar2.A = vVar;
                        }
                        z zVar3 = c0Var2.D0;
                        if (zVar3 != null) {
                            zVar3.z = new u(c0Var2.b, c0Var2.f, vVar, c0Var2);
                        }
                        WeakReference weakReference = (WeakReference) d70.l0(c0Var2.Z);
                        View view = weakReference != null ? (View) weakReference.get() : null;
                        if (view != null && (zVar = c0Var2.D0) != null && (uVar = zVar.z) != null) {
                            uVar.a(view);
                        }
                        n2 n2Var = c0Var2.A;
                        z zVar4 = c0Var2.D0;
                        Handler handler = (Handler) n2Var.f;
                        if (zVar4 != null) {
                            handler.removeCallbacks(zVar4);
                        }
                        n2 n2Var2 = c0Var2.A;
                        z zVar5 = c0Var2.D0;
                        if (!(zVar5 == null ? false : ((Handler) n2Var2.f).postDelayed(zVar5, 100L))) {
                            c0Var2.b.getLogger().h(p5.WARNING, "Failed to post the capture runnable, main looper is shutting down.", new Object[0]);
                        }
                    }
                    if (this.I0.a != q.PAUSED || (c0Var = this.Y) == null) {
                        return;
                    }
                    c0Var.x();
                }
            }
        }
    }

    public final void q0() {
        p pVar = this.I0;
        io.sentry.util.a aVar = this.H0;
        aVar.g();
        try {
            if (this.C0.get()) {
                q qVar = q.PAUSED;
                if (pVar.a(qVar)) {
                    c0 c0Var = this.Y;
                    if (c0Var != null) {
                        c0Var.x();
                    }
                    io.sentry.android.replay.capture.d dVar = this.E0;
                    if (dVar != null) {
                        dVar.j();
                    }
                    pVar.a = qVar;
                    vf2.e(aVar, null);
                    return;
                }
            }
            vf2.e(aVar, null);
        } finally {
        }
    }

    public final void r0() {
        f1 f1Var;
        f1 f1Var2;
        io.sentry.android.core.internal.tombstone.c cVarD;
        io.sentry.android.core.internal.tombstone.c cVarD2;
        io.sentry.util.a aVar = this.H0;
        aVar.g();
        try {
            if (this.C0.get()) {
                p pVar = this.I0;
                q qVar = q.RESUMED;
                if (pVar.a(qVar)) {
                    if (!this.D0.get() && this.z != r0.DISCONNECTED && (((f1Var = this.X) == null || (cVarD2 = f1Var.d()) == null || !cVarD2.n(io.sentry.o.All)) && ((f1Var2 = this.X) == null || (cVarD = f1Var2.d()) == null || !cVarD.n(io.sentry.o.Replay)))) {
                        p pVar2 = this.I0;
                        pVar2.getClass();
                        pVar2.a = qVar;
                        io.sentry.android.replay.capture.d dVar = this.E0;
                        if (dVar != null) {
                            dVar.m(new Date());
                        }
                        c0 c0Var = this.Y;
                        if (c0Var != null) {
                            c0Var.C();
                        }
                        vf2.e(aVar, null);
                        return;
                    }
                    vf2.e(aVar, null);
                    return;
                }
            }
            vf2.e(aVar, null);
        } finally {
        }
    }

    @Override // io.sentry.s0
    public final void s(r0 r0Var) {
        r0Var.getClass();
        this.z = r0Var;
        if (this.E0 instanceof io.sentry.android.replay.capture.o) {
            if (r0Var == r0.DISCONNECTED) {
                q0();
            } else {
                r0();
            }
        }
    }

    @Override // io.sentry.z3
    public final void stop() {
        p pVar = this.I0;
        io.sentry.util.a aVar = this.H0;
        aVar.g();
        try {
            if (this.C0.get()) {
                q qVar = q.STOPPED;
                if (pVar.a(qVar)) {
                    if (this.Y != null) {
                        h0 h0Var = ((s) this.z0.getValue()).z;
                        c0 c0Var = this.Y;
                        c0Var.getClass();
                        h0Var.remove(c0Var);
                    }
                    ((s) this.z0.getValue()).z.remove(this.Z);
                    c0 c0Var2 = this.Y;
                    if (c0Var2 != null) {
                        c0Var2.reset();
                    }
                    c0 c0Var3 = this.Y;
                    if (c0Var3 != null) {
                        c0Var3.F();
                    }
                    io.sentry.android.replay.gestures.b bVar = this.Z;
                    if (bVar != null) {
                        bVar.b();
                    }
                    io.sentry.android.replay.capture.d dVar = this.E0;
                    if (dVar != null) {
                        dVar.o();
                    }
                    this.E0 = null;
                    pVar.a = qVar;
                    vf2.e(aVar, null);
                    return;
                }
            }
            vf2.e(aVar, null);
        } finally {
        }
    }

    @Override // io.sentry.z3
    public final void x() {
        this.D0.set(false);
        r0();
    }
}
