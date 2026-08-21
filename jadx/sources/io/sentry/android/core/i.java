package io.sentry.android.core;

import io.sentry.ILogger;
import io.sentry.a3;
import io.sentry.i7;
import io.sentry.p4;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.r3;
import io.sentry.u3;
import io.sentry.w4;
import io.sentry.x5;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i implements io.sentry.u0, io.sentry.transport.o {
    public final q A;
    public Future A0;
    public io.sentry.n B0;
    public io.sentry.protocol.w D0;
    public io.sentry.protocol.w E0;
    public final AtomicBoolean F0;
    public w4 G0;
    public volatile boolean H0;
    public boolean I0;
    public boolean J0;
    public int K0;
    public final io.sentry.util.a L0;
    public final io.sentry.util.a M0;
    public final io.sentry.android.core.internal.util.r Y;
    public final ILogger b;
    public final String f;
    public final int z;
    public io.sentry.f1 z0;
    public boolean X = false;
    public v Z = null;
    public boolean y0 = false;
    public final ArrayList C0 = new ArrayList();

    public i(q0 q0Var, io.sentry.android.core.internal.util.r rVar, ILogger iLogger, String str, int i, q qVar) {
        io.sentry.protocol.w wVar = io.sentry.protocol.w.f;
        this.D0 = wVar;
        this.E0 = wVar;
        this.F0 = new AtomicBoolean(false);
        this.G0 = new x5();
        this.H0 = true;
        this.I0 = false;
        this.J0 = false;
        this.K0 = 0;
        this.L0 = new io.sentry.util.a();
        this.M0 = new io.sentry.util.a();
        this.b = iLogger;
        this.Y = rVar;
        this.f = str;
        this.z = i;
        this.A = qVar;
    }

    @Override // io.sentry.transport.o
    public final void N(io.sentry.android.core.internal.tombstone.c cVar) {
        if (cVar.n(io.sentry.o.All) || cVar.n(io.sentry.o.ProfileChunkUi)) {
            this.b.h(p5.WARNING, "SDK is rate limited. Stopping profiler.", new Object[0]);
            h(false);
        }
    }

    @Override // io.sentry.u0
    public final void a(boolean z) {
        io.sentry.util.a aVar = this.L0;
        aVar.g();
        try {
            this.K0 = 0;
            this.I0 = true;
            if (z) {
                h(false);
                this.F0.set(true);
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

    @Override // io.sentry.u0
    public final void b(u3 u3Var) {
        io.sentry.util.a aVar = this.L0;
        aVar.g();
        try {
            int i = h.a[u3Var.ordinal()];
            if (i == 1) {
                int i2 = this.K0 - 1;
                this.K0 = i2;
                if (i2 > 0) {
                    aVar.close();
                    return;
                } else {
                    if (i2 < 0) {
                        this.K0 = 0;
                    }
                    this.I0 = true;
                }
            } else if (i == 2) {
                this.I0 = true;
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

    @Override // io.sentry.u0
    public final void c(u3 u3Var, i7 i7Var) {
        io.sentry.util.a aVar = this.L0;
        aVar.g();
        try {
            if (this.H0) {
                this.J0 = i7Var.b(io.sentry.util.n.a().c());
                this.H0 = false;
            }
            if (!this.J0) {
                this.b.h(p5.DEBUG, "Profiler was not started due to sampling decision.", new Object[0]);
                aVar.close();
                return;
            }
            int i = h.a[u3Var.ordinal()];
            if (i == 1) {
                int i2 = this.K0;
                if (i2 < 0) {
                    this.K0 = 0;
                    i2 = 0;
                }
                this.K0 = i2 + 1;
            } else if (i == 2 && this.y0) {
                this.b.h(p5.DEBUG, "Profiler is already running.", new Object[0]);
                aVar.close();
                return;
            }
            if (!this.y0) {
                this.b.h(p5.DEBUG, "Started Profiler.", new Object[0]);
                g();
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

    @Override // io.sentry.u0
    public final void d() {
        this.H0 = true;
    }

    @Override // io.sentry.u0
    public final io.sentry.protocol.w e() {
        return this.D0;
    }

    public final void f() {
        io.sentry.f1 f1Var = this.z0;
        if ((f1Var == null || f1Var == a3.b) && p4.c() != a3.b) {
            this.z0 = p4.c();
            this.B0 = p4.c().getOptions().getCompositePerformanceCollector();
            io.sentry.android.core.internal.tombstone.c cVarD = this.z0.d();
            if (cVarD != null) {
                ((CopyOnWriteArrayList) cVarD.A).add(this);
            }
        }
    }

    public final void g() {
        f();
        if (!this.X) {
            this.X = true;
            ILogger iLogger = this.b;
            String str = this.f;
            if (str == null) {
                iLogger.h(p5.WARNING, "Disabling profiling because no profiling traces dir path is defined in options.", new Object[0]);
            } else {
                int i = this.z;
                if (i <= 0) {
                    iLogger.h(p5.WARNING, "Disabling profiling because trace rate is set to %d", Integer.valueOf(i));
                } else {
                    this.Z = new v(str, 1000000 / i, this.Y, null, iLogger);
                }
            }
        }
        if (this.Z == null) {
            return;
        }
        io.sentry.f1 f1Var = this.z0;
        ILogger iLogger2 = this.b;
        if (f1Var != null) {
            io.sentry.android.core.internal.tombstone.c cVarD = f1Var.d();
            if (cVarD != null && (cVarD.n(io.sentry.o.All) || cVarD.n(io.sentry.o.ProfileChunkUi))) {
                iLogger2.h(p5.WARNING, "SDK is rate limited. Stopping profiler.", new Object[0]);
                h(false);
                return;
            } else {
                if (this.z0.getOptions().getConnectionStatusProvider().d0() == io.sentry.r0.DISCONNECTED) {
                    iLogger2.h(p5.WARNING, "Device is offline. Stopping profiler.", new Object[0]);
                    h(false);
                    return;
                }
                this.G0 = this.z0.getOptions().getDateProvider().a();
            }
        } else {
            this.G0 = new x5();
        }
        if (this.Z.c() == null) {
            return;
        }
        this.y0 = true;
        io.sentry.protocol.w wVar = this.D0;
        io.sentry.protocol.w wVar2 = io.sentry.protocol.w.f;
        if (wVar.equals(wVar2)) {
            this.D0 = new io.sentry.protocol.w();
        }
        if (this.E0.equals(wVar2)) {
            this.E0 = new io.sentry.protocol.w();
        }
        io.sentry.n nVar = this.B0;
        if (nVar != null) {
            nVar.a(this.E0.a());
        }
        try {
            this.A0 = this.A.f.getExecutorService().b(new g(0, this), 60000L);
        } catch (RejectedExecutionException e) {
            iLogger2.d(p5.ERROR, "Failed to schedule profiling chunk finish. Did you call Sentry.close()?", e);
            this.I0 = true;
        }
    }

    public final void h(boolean z) {
        f();
        io.sentry.util.a aVar = this.L0;
        aVar.g();
        try {
            Future future = this.A0;
            if (future != null) {
                future.cancel(true);
            }
            if (this.Z != null && this.y0) {
                io.sentry.n nVar = this.B0;
                u uVarA = this.Z.a(nVar != null ? nVar.c(this.E0.a()) : null, false);
                ILogger iLogger = this.b;
                if (uVarA == null) {
                    iLogger.h(p5.ERROR, "An error occurred while collecting a profile chunk, and it won't be sent.", new Object[0]);
                } else {
                    io.sentry.util.a aVar2 = this.M0;
                    aVar2.g();
                    try {
                        this.C0.add(new r3(this.D0, this.E0, (HashMap) uVarA.e, (File) uVarA.d, this.G0));
                        aVar2.close();
                    } finally {
                    }
                }
                this.y0 = false;
                this.E0 = io.sentry.protocol.w.f;
                io.sentry.f1 f1Var = this.z0;
                if (f1Var != null) {
                    p6 options = f1Var.getOptions();
                    try {
                        options.getExecutorService().submit(new p1(2, this, options, f1Var));
                    } catch (Throwable th) {
                        options.getLogger().d(p5.DEBUG, "Failed to send profile chunks.", th);
                    }
                }
                if (!z || this.I0) {
                    this.D0 = io.sentry.protocol.w.f;
                    iLogger.h(p5.DEBUG, "Profile chunk finished.", new Object[0]);
                } else {
                    iLogger.h(p5.DEBUG, "Profile chunk finished. Starting a new one.", new Object[0]);
                    g();
                }
                aVar.close();
                return;
            }
            io.sentry.protocol.w wVar = io.sentry.protocol.w.f;
            this.D0 = wVar;
            this.E0 = wVar;
            aVar.close();
        } finally {
        }
    }
}
