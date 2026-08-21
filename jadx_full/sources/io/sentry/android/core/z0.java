package io.sentry.android.core;

import defpackage.o73;
import io.sentry.p4;
import io.sentry.p5;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z0 implements g0 {
    public final boolean X;
    public final boolean Y;
    public final long f;
    public Future z;
    public final AtomicLong b = new AtomicLong(0);
    public final io.sentry.util.a A = new io.sentry.util.a();

    public z0(long j, boolean z, boolean z2) {
        this.f = j;
        this.X = z;
        this.Y = z2;
    }

    public final void a(String str) {
        if (this.Y) {
            io.sentry.g gVar = new io.sentry.g();
            gVar.X = "navigation";
            gVar.d(str, "state");
            gVar.Z = "app.lifecycle";
            gVar.z0 = p5.INFO;
            p4.c().c(gVar, new io.sentry.l0());
        }
    }

    public final void b() {
        io.sentry.util.a aVar = this.A;
        aVar.g();
        try {
            Future future = this.z;
            if (future != null) {
                future.cancel(false);
                this.z = null;
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

    @Override // io.sentry.android.core.g0
    public final void g() {
        b();
        long jCurrentTimeMillis = System.currentTimeMillis();
        p4.c().o(new o73(21, this));
        AtomicLong atomicLong = this.b;
        long j = atomicLong.get();
        if (j == 0 || j + this.f <= jCurrentTimeMillis) {
            if (this.X) {
                p4.c().l();
            }
            p4.c().getOptions().getReplayController().Q();
        }
        p4.c().getOptions().getReplayController().x();
        atomicLong.set(jCurrentTimeMillis);
        a("foreground");
    }

    @Override // io.sentry.android.core.g0
    public final void n() {
        this.b.set(System.currentTimeMillis());
        p4.c().getOptions().getReplayController().I();
        io.sentry.util.a aVar = this.A;
        aVar.g();
        try {
            b();
            g gVar = new g(3, this);
            try {
                this.z = p4.c().getOptions().getTimerExecutorService().b(gVar, this.f);
            } catch (Throwable th) {
                p4.c().getOptions().getLogger().d(p5.WARNING, "Failed to schedule end of session. Ending it now.", th);
                gVar.run();
            }
            aVar.close();
            a("background");
        } catch (Throwable th2) {
            try {
                aVar.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }
}
