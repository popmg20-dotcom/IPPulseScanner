package io.sentry.android.replay.capture;

import defpackage.d70;
import defpackage.d82;
import defpackage.ij0;
import defpackage.n12;
import defpackage.sn2;
import io.sentry.android.replay.v;
import io.sentry.f1;
import io.sentry.p2;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.protocol.w;
import io.sentry.q6;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {
    public static final /* synthetic */ d82[] u = {new sn2("recorderConfig", "getRecorderConfig$sentry_android_replay_release()Lio/sentry/android/replay/ScreenshotRecorderConfig;"), new sn2("segmentTimestamp", "getSegmentTimestamp()Ljava/util/Date;"), new sn2("screenAtStart", "getScreenAtStart()Ljava/lang/String;"), new sn2("currentReplayId", "getCurrentReplayId()Lio/sentry/protocol/SentryId;"), new sn2("currentSegment", "getCurrentSegment()I"), new sn2("replayType", "getReplayType()Lio/sentry/SentryReplayEvent$ReplayType;"), new sn2("isFlushed", "isFlushed()Z")};
    public final p6 a;
    public final f1 b;
    public final io.sentry.transport.f c;
    public final ScheduledExecutorService d;
    public final ScheduledExecutorService e;
    public final io.sentry.android.core.internal.tombstone.b f;
    public final AtomicBoolean g;
    public io.sentry.android.replay.j h;
    public final b i;
    public final b j;
    public final AtomicLong k;
    public final b l;
    public final b m;
    public final b n;
    public final b o;
    public final b p;
    public final ConcurrentLinkedDeque q;
    public final Object r;
    public final LinkedHashSet s;
    public final LinkedHashSet t;

    public d(p6 p6Var, f1 f1Var, io.sentry.transport.f fVar, ScheduledExecutorService scheduledExecutorService, ScheduledExecutorService scheduledExecutorService2) {
        p6Var.getClass();
        scheduledExecutorService.getClass();
        scheduledExecutorService2.getClass();
        this.a = p6Var;
        this.b = f1Var;
        this.c = fVar;
        this.d = scheduledExecutorService;
        this.e = scheduledExecutorService2;
        io.sentry.android.core.internal.tombstone.b bVar = new io.sentry.android.core.internal.tombstone.b();
        bVar.c = fVar;
        bVar.d = new LinkedHashMap(10);
        this.f = bVar;
        this.g = new AtomicBoolean(false);
        this.i = new b(this, this, 4);
        this.j = new b(this, this, 5);
        this.k = new AtomicLong();
        this.l = new b(this, this, 6);
        this.m = new b(w.f, this, this);
        this.n = new b(this, this, 1);
        this.o = new b(this, this, 2);
        this.p = new b(this, this, 3);
        this.q = new ConcurrentLinkedDeque();
        this.r = new Object();
        this.s = new LinkedHashSet();
        this.t = new LinkedHashSet();
    }

    public static l c(d dVar, long j, Date date, w wVar, int i, int i2, int i3, int i4, int i5) {
        List listY0;
        List listY02;
        b bVar = dVar.o;
        d82[] d82VarArr = u;
        q6 q6Var = (q6) bVar.a(dVar, d82VarArr[5]);
        io.sentry.android.replay.j jVar = dVar.h;
        String str = (String) dVar.l.a(dVar, d82VarArr[2]);
        ConcurrentLinkedDeque concurrentLinkedDeque = dVar.q;
        wVar.getClass();
        q6Var.getClass();
        concurrentLinkedDeque.getClass();
        synchronized (dVar.r) {
            listY0 = d70.y0(dVar.s);
            listY02 = d70.y0(dVar.t);
            dVar.s.clear();
            dVar.t.clear();
        }
        return i.a(dVar.b, dVar.a, j, date, wVar, i, i2, i3, q6Var, jVar, i4, i5, str, null, concurrentLinkedDeque, listY0, listY02);
    }

    public abstract void a(boolean z, ij0 ij0Var);

    public abstract d b();

    public final w d() {
        return (w) this.m.a(this, u[3]);
    }

    public final int e() {
        return ((Number) this.n.a(this, u[4])).intValue();
    }

    public final v f() {
        return (v) this.i.a(this, u[0]);
    }

    public abstract void g(v vVar);

    public abstract void h(io.sentry.android.replay.n nVar);

    /* JADX WARN: Removed duplicated region for block: B:16:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i(android.view.MotionEvent r20) {
        /*
            Method dump skipped, instruction units count: 493
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.replay.capture.d.i(android.view.MotionEvent):void");
    }

    public abstract void j();

    public final void k(int i) {
        d82 d82Var = u[4];
        Integer numValueOf = Integer.valueOf(i);
        b bVar = this.n;
        bVar.getClass();
        d82Var.getClass();
        Object andSet = bVar.b.getAndSet(numValueOf);
        if (n12.c(andSet, numValueOf)) {
            return;
        }
        a aVar = new a(andSet, numValueOf, bVar.d, 1);
        d dVar = bVar.c;
        p6 p6Var = dVar.a;
        if (p6Var.getThreadChecker().c()) {
            dVar.e.submit(new io.sentry.android.replay.util.j(new p2(3, aVar), "CaptureStrategy.runInBackground"));
            return;
        }
        try {
            aVar.a();
        } catch (Throwable th) {
            p6Var.getLogger().d(p5.ERROR, "Failed to execute task CaptureStrategy.runInBackground", th);
        }
    }

    public final void l(v vVar) {
        int i = 0;
        d82 d82Var = u[0];
        b bVar = this.i;
        bVar.getClass();
        d82Var.getClass();
        Object andSet = bVar.b.getAndSet(vVar);
        if (n12.c(andSet, vVar)) {
            return;
        }
        c cVar = new c(andSet, vVar, bVar.d, i);
        d dVar = bVar.c;
        p6 p6Var = dVar.a;
        if (p6Var.getThreadChecker().c()) {
            dVar.e.submit(new io.sentry.android.replay.util.j(new p2(6, cVar), "CaptureStrategy.runInBackground"));
            return;
        }
        try {
            cVar.a();
        } catch (Throwable th) {
            p6Var.getLogger().d(p5.ERROR, "Failed to execute task CaptureStrategy.runInBackground", th);
        }
    }

    public final void m(Date date) {
        int i = 1;
        d82 d82Var = u[1];
        b bVar = this.j;
        bVar.getClass();
        d82Var.getClass();
        Object andSet = bVar.b.getAndSet(date);
        if (n12.c(andSet, date)) {
            return;
        }
        c cVar = new c(andSet, date, bVar.d, i);
        d dVar = bVar.c;
        p6 p6Var = dVar.a;
        if (p6Var.getThreadChecker().c()) {
            dVar.e.submit(new io.sentry.android.replay.util.j(new p2(7, cVar), "CaptureStrategy.runInBackground"));
            return;
        }
        try {
            cVar.a();
        } catch (Throwable th) {
            p6Var.getLogger().d(p5.ERROR, "Failed to execute task CaptureStrategy.runInBackground", th);
        }
    }

    public void n(int i, w wVar, q6 q6Var) {
        wVar.getClass();
        this.h = new io.sentry.android.replay.j(this.a, wVar);
        d82[] d82VarArr = u;
        d82 d82Var = d82VarArr[3];
        b bVar = this.m;
        bVar.getClass();
        d82Var.getClass();
        Object andSet = bVar.b.getAndSet(wVar);
        int i2 = 2;
        if (!n12.c(andSet, wVar)) {
            a aVar = new a(andSet, wVar, bVar.d, 0);
            d dVar = bVar.c;
            p6 p6Var = dVar.a;
            if (p6Var.getThreadChecker().c()) {
                dVar.e.submit(new io.sentry.android.replay.util.j(new p2(i2, aVar), "CaptureStrategy.runInBackground"));
            } else {
                try {
                    aVar.a();
                } catch (Throwable th) {
                    p6Var.getLogger().d(p5.ERROR, "Failed to execute task CaptureStrategy.runInBackground", th);
                }
            }
        }
        k(i);
        if (q6Var == null) {
            q6Var = this instanceof o ? q6.SESSION : q6.BUFFER;
        }
        q6Var.getClass();
        d82 d82Var2 = d82VarArr[5];
        b bVar2 = this.o;
        bVar2.getClass();
        d82Var2.getClass();
        Object andSet2 = bVar2.b.getAndSet(q6Var);
        if (!n12.c(andSet2, q6Var)) {
            a aVar2 = new a(andSet2, q6Var, bVar2.d, i2);
            d dVar2 = bVar2.c;
            p6 p6Var2 = dVar2.a;
            if (p6Var2.getThreadChecker().c()) {
                dVar2.e.submit(new io.sentry.android.replay.util.j(new p2(4, aVar2), "CaptureStrategy.runInBackground"));
            } else {
                try {
                    aVar2.a();
                } catch (Throwable th2) {
                    p6Var2.getLogger().d(p5.ERROR, "Failed to execute task CaptureStrategy.runInBackground", th2);
                }
            }
        }
        m(new Date());
        this.k.set(this.c.c());
    }

    public abstract void o();
}
