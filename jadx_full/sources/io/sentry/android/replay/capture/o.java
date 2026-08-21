package io.sentry.android.replay.capture;

import defpackage.am1;
import defpackage.d82;
import defpackage.ij0;
import defpackage.n12;
import defpackage.o73;
import defpackage.ze0;
import io.sentry.android.replay.v;
import io.sentry.f1;
import io.sentry.p2;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.protocol.w;
import io.sentry.q6;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o extends d {
    public final p6 v;
    public final f1 w;
    public final io.sentry.transport.f x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(p6 p6Var, f1 f1Var, io.sentry.transport.f fVar, ScheduledExecutorService scheduledExecutorService, ScheduledExecutorService scheduledExecutorService2) {
        super(p6Var, f1Var, fVar, scheduledExecutorService, scheduledExecutorService2);
        p6Var.getClass();
        fVar.getClass();
        scheduledExecutorService.getClass();
        scheduledExecutorService2.getClass();
        this.v = p6Var;
        this.w = f1Var;
        this.x = fVar;
    }

    @Override // io.sentry.android.replay.capture.d
    public final void a(boolean z, ij0 ij0Var) {
        p6 p6Var = this.v;
        if (p6Var.getSessionReplay().m) {
            p6Var.getLogger().h(p5.DEBUG, "Replay is already running in 'session' mode, not capturing for event", new Object[0]);
        }
        this.g.set(z);
    }

    @Override // io.sentry.android.replay.capture.d
    public final void g(v vVar) {
        p("onConfigurationChanged", new n(this, 0));
        l(vVar);
    }

    @Override // io.sentry.android.replay.capture.d
    public final void h(final io.sentry.android.replay.n nVar) {
        final v vVarF = f();
        final long jC = this.x.c();
        this.d.submit(new io.sentry.android.replay.util.j(new Runnable() { // from class: io.sentry.android.replay.capture.m
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                o oVar = this.b;
                io.sentry.android.replay.j jVar = oVar.h;
                p6 p6Var = oVar.v;
                if (jVar != null) {
                    nVar.k(jVar, Long.valueOf(jC));
                }
                Date date = (Date) oVar.j.a(oVar, d.u[1]);
                if (date == null) {
                    p6Var.getLogger().h(p5.DEBUG, "Segment timestamp is not set, not recording frame", new Object[0]);
                    return;
                }
                if (oVar.g.get()) {
                    p6Var.getLogger().h(p5.DEBUG, "Not capturing segment, because the app is terminating, will be captured on next launch", new Object[0]);
                    return;
                }
                v vVar = vVarF;
                if (vVar == null) {
                    p6Var.getLogger().h(p5.DEBUG, "Recorder config is not set, not capturing a segment", new Object[0]);
                    return;
                }
                long jC2 = oVar.x.c();
                if (jC2 - date.getTime() >= p6Var.getSessionReplay().i) {
                    l lVarC = d.c(oVar, p6Var.getSessionReplay().i, date, oVar.d(), oVar.e(), vVar.b, vVar.a, vVar.e, vVar.f);
                    if (lVarC instanceof j) {
                        j jVar2 = (j) lVarC;
                        j.a(jVar2, oVar.w);
                        oVar.k(oVar.e() + 1);
                        oVar.m(jVar2.a.L0);
                    }
                }
                if (jC2 - oVar.k.get() >= p6Var.getSessionReplay().j) {
                    p6Var.getReplayController().stop();
                    p6Var.getLogger().h(p5.INFO, "Session replay deadline exceeded (1h), stopping recording", new Object[0]);
                }
            }
        }, "SessionCaptureStrategy.add_frame"));
    }

    @Override // io.sentry.android.replay.capture.d
    public final void j() {
        p("pause", new n(this, 1));
    }

    @Override // io.sentry.android.replay.capture.d
    public final void n(int i, w wVar, q6 q6Var) {
        wVar.getClass();
        super.n(i, wVar, q6Var);
        f1 f1Var = this.w;
        if (f1Var != null) {
            f1Var.w(new o73(26, this));
        }
    }

    @Override // io.sentry.android.replay.capture.d
    public final void o() {
        io.sentry.android.replay.j jVar = this.h;
        p("stop", new ze0(3, this, jVar != null ? jVar.s() : null));
        f1 f1Var = this.w;
        if (f1Var != null) {
            f1Var.w(new io.sentry.android.core.cache.a(3));
        }
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

    public final void p(String str, am1 am1Var) {
        v vVarF = f();
        if (vVarF == null) {
            this.v.getLogger().h(p5.DEBUG, "Recorder config is not set, not creating segment for task: ".concat(str), new Object[0]);
            return;
        }
        long jC = this.x.c();
        Date date = (Date) this.j.a(this, d.u[1]);
        if (date == null) {
            return;
        }
        long time = jC - date.getTime();
        w wVarD = d();
        this.d.submit(new io.sentry.android.replay.util.j(new e(this, time, date, wVarD, vVarF, am1Var, 1), "SessionCaptureStrategy.".concat(str)));
    }

    @Override // io.sentry.android.replay.capture.d
    public final d b() {
        return this;
    }
}
