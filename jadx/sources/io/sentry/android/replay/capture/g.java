package io.sentry.android.replay.capture;

import android.view.MotionEvent;
import defpackage.d82;
import defpackage.ij0;
import defpackage.n12;
import defpackage.o73;
import defpackage.ze0;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.e0;
import io.sentry.android.core.z;
import io.sentry.android.replay.v;
import io.sentry.f1;
import io.sentry.p2;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.protocol.w;
import io.sentry.q6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g extends d {
    public final p6 v;
    public final f1 w;
    public final io.sentry.transport.f x;
    public final io.sentry.util.k y;
    public final ArrayList z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(SentryAndroidOptions sentryAndroidOptions, f1 f1Var, io.sentry.transport.d dVar, io.sentry.util.k kVar, io.sentry.android.replay.util.i iVar, io.sentry.android.replay.util.i iVar2) {
        super(sentryAndroidOptions, f1Var, dVar, iVar, iVar2);
        sentryAndroidOptions.getClass();
        dVar.getClass();
        kVar.getClass();
        iVar.getClass();
        iVar2.getClass();
        this.v = sentryAndroidOptions;
        this.w = f1Var;
        this.x = dVar;
        this.y = kVar;
        this.z = new ArrayList();
    }

    @Override // io.sentry.android.replay.capture.d
    public final void a(boolean z, ij0 ij0Var) {
        io.sentry.android.core.internal.tombstone.c cVarD;
        p6 p6Var = this.v;
        Double d = p6Var.getSessionReplay().e;
        io.sentry.util.k kVar = this.y;
        kVar.getClass();
        if (d == null || d.doubleValue() < kVar.c()) {
            p6Var.getLogger().h(p5.INFO, "Replay wasn't sampled by onErrorSampleRate, not capturing for event", new Object[0]);
            return;
        }
        f1 f1Var = this.w;
        if (f1Var != null) {
            f1Var.w(new o73(25, this));
        }
        if (z) {
            this.g.set(true);
            p6Var.getLogger().h(p5.DEBUG, "Not capturing replay for crashed event, will be captured on next launch", new Object[0]);
        } else if (f1Var == null || (cVarD = f1Var.d()) == null || !(cVarD.n(io.sentry.o.All) || cVarD.n(io.sentry.o.Replay))) {
            p("capture_replay", new ze0(2, this, ij0Var));
        } else {
            p6Var.getLogger().h(p5.INFO, "Replay is rate-limited, not capturing for event", new Object[0]);
            p6Var.getClientReportRecorder().a(io.sentry.clientreport.d.RATELIMIT_BACKOFF, io.sentry.o.Replay);
        }
    }

    @Override // io.sentry.android.replay.capture.d
    public final d b() {
        io.sentry.android.core.internal.tombstone.c cVarD;
        if (this.g.get()) {
            this.v.getLogger().h(p5.DEBUG, "Not converting to session mode, because the process is about to terminate", new Object[0]);
            return this;
        }
        f1 f1Var = this.w;
        boolean z = (f1Var == null || (cVarD = f1Var.d()) == null || (!cVarD.n(io.sentry.o.All) && !cVarD.n(io.sentry.o.Replay))) ? false : true;
        p6 p6Var = this.v;
        if (z) {
            p6Var.getLogger().h(p5.DEBUG, "Not converting to session mode, because replay is rate-limited", new Object[0]);
            return this;
        }
        o oVar = new o(p6Var, this.w, this.x, this.d, this.e);
        oVar.l(f());
        oVar.n(e(), d(), q6.BUFFER);
        return oVar;
    }

    @Override // io.sentry.android.replay.capture.d
    public final void g(v vVar) {
        p("configuration_changed", new f(this, 0));
        l(vVar);
    }

    @Override // io.sentry.android.replay.capture.d
    public final void h(io.sentry.android.replay.n nVar) {
        this.d.submit(new io.sentry.android.replay.util.j(new e0(this, nVar, this.x.c()), "BufferCaptureStrategy.add_frame"));
    }

    @Override // io.sentry.android.replay.capture.d
    public final void i(MotionEvent motionEvent) {
        super.i(motionEvent);
        long jC = this.x.c() - this.v.getSessionReplay().h;
        ConcurrentLinkedDeque concurrentLinkedDeque = this.q;
        concurrentLinkedDeque.getClass();
        Iterator it = concurrentLinkedDeque.iterator();
        it.getClass();
        while (it.hasNext()) {
            if (((io.sentry.rrweb.b) it.next()).f < jC) {
                it.remove();
            }
        }
    }

    @Override // io.sentry.android.replay.capture.d
    public final void j() {
        p("pause", new f(this, 1));
    }

    @Override // io.sentry.android.replay.capture.d
    public final void o() {
        io.sentry.android.replay.j jVar = this.h;
        this.d.submit(new io.sentry.android.replay.util.j(new z(10, jVar != null ? jVar.s() : null, this), "BufferCaptureStrategy.stop"));
        io.sentry.android.replay.j jVar2 = this.h;
        if (jVar2 != null) {
            jVar2.close();
        }
        this.k.set(0L);
        m(null);
        w wVar = w.f;
        wVar.getClass();
        d82 d82Var = d.u[3];
        b bVar = this.m;
        bVar.getClass();
        d82Var.getClass();
        Object andSet = bVar.b.getAndSet(wVar);
        if (n12.c(andSet, wVar)) {
            return;
        }
        a aVar = new a(andSet, wVar, bVar.d, 0);
        d dVar = bVar.c;
        p6 p6Var = dVar.a;
        if (p6Var.getThreadChecker().c()) {
            dVar.e.submit(new io.sentry.android.replay.util.j(new p2(2, aVar), "CaptureStrategy.runInBackground"));
            return;
        }
        try {
            aVar.a();
        } catch (Throwable th) {
            p6Var.getLogger().d(p5.ERROR, "Failed to execute task CaptureStrategy.runInBackground", th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(java.lang.String r11, defpackage.am1 r12) {
        /*
            r10 = this;
            io.sentry.android.replay.v r6 = r10.f()
            io.sentry.p6 r0 = r10.v
            if (r6 != 0) goto L1b
            io.sentry.ILogger r10 = r0.getLogger()
            io.sentry.p5 r12 = io.sentry.p5.DEBUG
            java.lang.String r0 = "Recorder config is not set, not creating segment for task: "
            java.lang.String r11 = r0.concat(r11)
            r0 = 0
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r10.h(r12, r11, r0)
            return
        L1b:
            io.sentry.t6 r0 = r0.getSessionReplay()
            long r0 = r0.h
            io.sentry.transport.f r2 = r10.x
            long r2 = r2.c()
            io.sentry.android.replay.j r4 = r10.h
            if (r4 == 0) goto L5c
            io.sentry.util.a r5 = r4.Y
            r5.g()
            java.util.ArrayList r4 = r4.z0     // Catch: java.lang.Throwable -> L42
            java.lang.Object r4 = defpackage.d70.e0(r4)     // Catch: java.lang.Throwable -> L42
            io.sentry.android.replay.k r4 = (io.sentry.android.replay.k) r4     // Catch: java.lang.Throwable -> L42
            r7 = 0
            if (r4 == 0) goto L45
            long r8 = r4.b     // Catch: java.lang.Throwable -> L42
            java.lang.Long r4 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Throwable -> L42
            goto L46
        L42:
            r0 = move-exception
            r10 = r0
            goto L55
        L45:
            r4 = r7
        L46:
            defpackage.vf2.e(r5, r7)
            if (r4 == 0) goto L5c
            long r0 = r4.longValue()
            java.util.Date r4 = new java.util.Date
            r4.<init>(r0)
            goto L63
        L55:
            throw r10     // Catch: java.lang.Throwable -> L56
        L56:
            r0 = move-exception
            r11 = r0
            defpackage.vf2.e(r5, r10)
            throw r11
        L5c:
            long r0 = r2 - r0
            java.util.Date r4 = new java.util.Date
            r4.<init>(r0)
        L63:
            long r0 = r4.getTime()
            long r2 = r2 - r0
            io.sentry.protocol.w r5 = r10.d()
            io.sentry.android.replay.util.j r9 = new io.sentry.android.replay.util.j
            java.lang.String r0 = "BufferCaptureStrategy."
            java.lang.String r11 = r0.concat(r11)
            io.sentry.android.replay.capture.e r0 = new io.sentry.android.replay.capture.e
            r8 = 0
            r1 = r10
            r7 = r12
            r0.<init>(r1, r2, r4, r5, r6, r7, r8)
            r9.<init>(r0, r11)
            java.util.concurrent.ScheduledExecutorService r10 = r1.d
            r10.submit(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.replay.capture.g.p(java.lang.String, am1):void");
    }
}
