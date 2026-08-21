package io.sentry.android.core;

import android.os.SystemClock;
import io.sentry.ILogger;
import io.sentry.a3;
import io.sentry.i7;
import io.sentry.p3;
import io.sentry.p4;
import io.sentry.p5;
import io.sentry.p6;
import io.sentry.u3;
import io.sentry.w4;
import io.sentry.x5;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k1 implements io.sentry.u0, io.sentry.transport.o {
    public io.sentry.protocol.w A0;
    public io.sentry.protocol.w B0;
    public final AtomicBoolean C0;
    public w4 D0;
    public boolean E0;
    public boolean F0;
    public boolean G0;
    public int H0;
    public final io.sentry.util.a I0;
    public final j1 X;
    public io.sentry.f1 Z;
    public final ILogger b;
    public final q f;
    public io.sentry.n y0;
    public final r z;
    public Future z0;
    public m1 A = null;
    public boolean Y = false;

    public k1(ILogger iLogger, io.sentry.android.core.internal.util.r rVar, q qVar, r rVar2) {
        io.sentry.protocol.w wVar = io.sentry.protocol.w.f;
        this.A0 = wVar;
        this.B0 = wVar;
        this.C0 = new AtomicBoolean(false);
        this.D0 = new x5();
        this.E0 = true;
        this.F0 = false;
        this.G0 = false;
        this.H0 = 0;
        this.I0 = new io.sentry.util.a();
        this.b = iLogger;
        this.X = new j1(rVar);
        this.f = qVar;
        this.z = rVar2;
    }

    @Override // io.sentry.transport.o
    public final void N(io.sentry.android.core.internal.tombstone.c cVar) {
        if (cVar.n(io.sentry.o.All) || cVar.n(io.sentry.o.ProfileChunkUi)) {
            io.sentry.util.a aVar = this.I0;
            aVar.g();
            try {
                this.b.h(p5.WARNING, "SDK is rate limited. Stopping profiler.", new Object[0]);
                i(false);
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
    }

    @Override // io.sentry.u0
    public final void a(boolean z) {
        io.sentry.util.a aVar = this.I0;
        aVar.g();
        try {
            this.H0 = 0;
            this.F0 = true;
            if (z) {
                i(false);
                this.C0.set(true);
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
        io.sentry.util.a aVar = this.I0;
        aVar.g();
        try {
            int i = i1.a[u3Var.ordinal()];
            if (i == 1) {
                int i2 = this.H0 - 1;
                this.H0 = i2;
                int iMax = Math.max(0, i2);
                this.H0 = iMax;
                if (iMax > 0) {
                    aVar.close();
                    return;
                }
                this.F0 = true;
            } else if (i == 2) {
                this.F0 = true;
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
        io.sentry.util.a aVar = this.I0;
        aVar.g();
        try {
            if (this.E0) {
                this.G0 = i7Var.b(io.sentry.util.n.a().c());
                this.E0 = false;
            }
            boolean z = this.G0;
            ILogger iLogger = this.b;
            if (!z) {
                iLogger.h(p5.DEBUG, "Profiler was not started due to sampling decision.", new Object[0]);
                aVar.close();
                return;
            }
            int i = i1.a[u3Var.ordinal()];
            if (i == 1) {
                this.H0 = Math.max(0, this.H0) + 1;
            } else if (i == 2 && f()) {
                iLogger.h(p5.WARNING, "Unexpected call to startProfiler(MANUAL) while profiler already running. Skipping.", new Object[0]);
                aVar.close();
                return;
            }
            if (!f()) {
                iLogger.h(p5.DEBUG, "Started Profiler.", new Object[0]);
                this.F0 = false;
                h();
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
        io.sentry.util.a aVar = this.I0;
        aVar.g();
        try {
            this.E0 = true;
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
    public final io.sentry.protocol.w e() {
        io.sentry.util.a aVar = this.I0;
        aVar.g();
        try {
            io.sentry.protocol.w wVar = this.A0;
            aVar.close();
            return wVar;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final boolean f() {
        io.sentry.util.a aVar = this.I0;
        aVar.g();
        try {
            boolean z = this.Y;
            aVar.close();
            return z;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final io.sentry.f1 g() {
        io.sentry.f1 f1Var = this.Z;
        if (f1Var != null && f1Var != a3.b) {
            return f1Var;
        }
        io.sentry.f1 f1VarC = p4.c();
        if (f1VarC == a3.b) {
            this.b.h(p5.ERROR, "PerfettoContinuousProfiler: scopes not available. This is unexpected.", new Object[0]);
            return f1VarC;
        }
        this.Z = f1VarC;
        this.y0 = f1VarC.getOptions().getCompositePerformanceCollector();
        io.sentry.android.core.internal.tombstone.c cVarD = f1VarC.d();
        if (cVarD != null) {
            ((CopyOnWriteArrayList) cVarD.A).add(this);
        }
        return this.Z;
    }

    public final void h() {
        io.sentry.f1 f1VarG = g();
        io.sentry.android.core.internal.tombstone.c cVarD = f1VarG.d();
        ILogger iLogger = this.b;
        if (cVarD != null && (cVarD.n(io.sentry.o.All) || cVarD.n(io.sentry.o.ProfileChunkUi))) {
            iLogger.h(p5.WARNING, "SDK is rate limited. Stopping profiler.", new Object[0]);
            i(false);
            return;
        }
        if (f1VarG.getOptions().getConnectionStatusProvider().d0() == io.sentry.r0.DISCONNECTED) {
            iLogger.h(p5.WARNING, "Device is offline. Stopping profiler.", new Object[0]);
            i(false);
            return;
        }
        this.D0 = f1VarG.getOptions().getDateProvider().a();
        m1 m1Var = (m1) this.z.get();
        this.A = m1Var;
        if (!m1Var.d()) {
            iLogger.h(p5.ERROR, "Failed to start Perfetto profiling. PerfettoProfiler.start() returned false.", new Object[0]);
            return;
        }
        this.Y = true;
        io.sentry.protocol.w wVar = this.A0;
        io.sentry.protocol.w wVar2 = io.sentry.protocol.w.f;
        if (wVar.equals(wVar2)) {
            this.A0 = new io.sentry.protocol.w();
        }
        if (this.B0.equals(wVar2)) {
            this.B0 = new io.sentry.protocol.w();
        }
        io.sentry.n nVar = this.y0;
        String strA = this.B0.a();
        j1 j1Var = this.X;
        j1Var.c = nVar;
        j1Var.d = strA;
        j1Var.h = SystemClock.elapsedRealtimeNanos();
        j1Var.e.clear();
        j1Var.f.clear();
        j1Var.g.clear();
        j1Var.b = j1Var.a.b(new t(1, j1Var));
        if (nVar != null) {
            nVar.a(strA);
        }
        try {
            this.z0 = this.f.f.getExecutorService().b(new g(4, this), 60000L);
        } catch (RejectedExecutionException e) {
            iLogger.d(p5.ERROR, "Failed to schedule profiling chunk finish. Did you call Sentry.close()?", e);
            this.F0 = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009d  */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [io.sentry.android.core.m1, io.sentry.n, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i(boolean z) {
        io.sentry.f1 f1Var;
        p6 p6Var;
        ?? r2;
        String str;
        long j;
        m1 m1Var = this.A;
        Future future = this.z0;
        if (future != null) {
            future.cancel(false);
        }
        if (m1Var == null || !this.Y) {
            io.sentry.protocol.w wVar = io.sentry.protocol.w.f;
            this.A0 = wVar;
            this.B0 = wVar;
            return;
        }
        io.sentry.f1 f1VarG = g();
        p6 options = f1VarG.getOptions();
        j1 j1Var = this.X;
        HashMap map = new HashMap();
        j1Var.a.c(j1Var.b);
        j1Var.b = null;
        ConcurrentLinkedDeque concurrentLinkedDeque = j1Var.g;
        ConcurrentLinkedDeque concurrentLinkedDeque2 = j1Var.f;
        ConcurrentLinkedDeque concurrentLinkedDeque3 = j1Var.e;
        if (!concurrentLinkedDeque3.isEmpty()) {
            map.put("slow_frame_renders", new io.sentry.profilemeasurements.a("nanosecond", new ArrayList(concurrentLinkedDeque3)));
        }
        if (!concurrentLinkedDeque2.isEmpty()) {
            map.put("frozen_frame_renders", new io.sentry.profilemeasurements.a("nanosecond", new ArrayList(concurrentLinkedDeque2)));
        }
        if (!concurrentLinkedDeque.isEmpty()) {
            map.put("screen_frame_rates", new io.sentry.profilemeasurements.a("hz", new ArrayList(concurrentLinkedDeque)));
        }
        io.sentry.n nVar = j1Var.c;
        if (nVar == null || (str = j1Var.d) == null) {
            f1Var = f1VarG;
            p6Var = options;
            r2 = 0;
        } else {
            List listC = nVar.c(str);
            long nanos = TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
            long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            long j2 = j1Var.h;
            if (listC != null) {
                ArrayList arrayList = (ArrayList) listC;
                if (arrayList.isEmpty()) {
                    f1Var = f1VarG;
                    p6Var = options;
                } else {
                    ArrayDeque arrayDeque = new ArrayDeque(arrayList.size());
                    ArrayDeque arrayDeque2 = new ArrayDeque(arrayList.size());
                    f1Var = f1VarG;
                    ArrayDeque arrayDeque3 = new ArrayDeque(arrayList.size());
                    synchronized (listC) {
                        try {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                Iterator it2 = it;
                                p3 p3Var = (p3) it.next();
                                long j3 = nanos;
                                long j4 = p3Var.d;
                                long j5 = (jElapsedRealtimeNanos - (j3 - j4)) - j2;
                                p6 p6Var2 = options;
                                Double d = p3Var.a;
                                long j6 = jElapsedRealtimeNanos;
                                Long l = p3Var.b;
                                Long l2 = p3Var.c;
                                if (d != null) {
                                    j = j2;
                                    arrayDeque.addLast(new io.sentry.profilemeasurements.b(Long.valueOf(j5), d, j4));
                                } else {
                                    j = j2;
                                }
                                if (l != null) {
                                    arrayDeque2.addLast(new io.sentry.profilemeasurements.b(Long.valueOf(j5), l, j4));
                                }
                                if (l2 != null) {
                                    arrayDeque3.addLast(new io.sentry.profilemeasurements.b(Long.valueOf(j5), l2, j4));
                                }
                                options = p6Var2;
                                it = it2;
                                nanos = j3;
                                jElapsedRealtimeNanos = j6;
                                j2 = j;
                            }
                            p6Var = options;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (!arrayDeque.isEmpty()) {
                        map.put("cpu_usage", new io.sentry.profilemeasurements.a("percent", arrayDeque));
                    }
                    if (!arrayDeque2.isEmpty()) {
                        map.put("memory_footprint", new io.sentry.profilemeasurements.a("byte", arrayDeque2));
                    }
                    if (!arrayDeque3.isEmpty()) {
                        map.put("memory_native_footprint", new io.sentry.profilemeasurements.a("byte", arrayDeque3));
                    }
                }
                r2 = 0;
            }
        }
        j1Var.c = r2;
        j1Var.d = r2;
        io.sentry.protocol.w wVar2 = this.A0;
        io.sentry.protocol.w wVar3 = this.B0;
        w4 w4Var = this.D0;
        boolean z2 = false;
        this.Y = false;
        this.A = r2;
        io.sentry.protocol.w wVar4 = io.sentry.protocol.w.f;
        this.B0 = wVar4;
        if (!z || this.F0) {
            this.A0 = wVar4;
        }
        if (z && !this.F0) {
            z2 = true;
        }
        m1Var.a(new h1(this, wVar2, wVar3, map, w4Var, z2, f1Var, p6Var));
    }
}
