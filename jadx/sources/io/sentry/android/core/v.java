package io.sentry.android.core;

import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import defpackage.bx;
import io.sentry.ILogger;
import io.sentry.p3;
import io.sentry.p5;
import java.io.File;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v {
    public final File b;
    public final int c;
    public String f;
    public final io.sentry.android.core.internal.util.r g;
    public final io.sentry.util.e l;
    public final ILogger m;
    public long a = 0;
    public Future d = null;
    public File e = null;
    public final ArrayDeque h = new ArrayDeque();
    public final ArrayDeque i = new ArrayDeque();
    public final ArrayDeque j = new ArrayDeque();
    public final HashMap k = new HashMap();
    public volatile boolean n = false;
    public final io.sentry.util.a o = new io.sentry.util.a();

    public v(String str, int i, io.sentry.android.core.internal.util.r rVar, q qVar, ILogger iLogger) {
        io.sentry.util.b.r(str, "TracesFilesDirPath is required");
        this.b = new File(str);
        this.c = i;
        io.sentry.util.b.r(iLogger, "Logger is required");
        this.m = iLogger;
        this.l = qVar;
        this.g = rVar;
    }

    public final u a(List list, boolean z) {
        io.sentry.util.a aVar = this.o;
        aVar.g();
        try {
            if (!this.n) {
                this.m.h(p5.WARNING, "Profiler not running", new Object[0]);
                aVar.close();
                return null;
            }
            try {
                Debug.stopMethodTracing();
            } finally {
                try {
                } catch (Throwable th) {
                }
            }
            this.n = false;
            this.g.c(this.f);
            long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            long elapsedCpuTime = Process.getElapsedCpuTime();
            if (this.e == null) {
                this.m.h(p5.ERROR, "Trace file does not exists", new Object[0]);
                aVar.close();
                return null;
            }
            if (!this.i.isEmpty()) {
                this.k.put("slow_frame_renders", new io.sentry.profilemeasurements.a("nanosecond", this.i));
            }
            if (!this.j.isEmpty()) {
                this.k.put("frozen_frame_renders", new io.sentry.profilemeasurements.a("nanosecond", this.j));
            }
            if (!this.h.isEmpty()) {
                this.k.put("screen_frame_rates", new io.sentry.profilemeasurements.a("hz", this.h));
            }
            b(list);
            Future future = this.d;
            if (future != null) {
                future.cancel(true);
                this.d = null;
            }
            u uVar = new u(jElapsedRealtimeNanos, elapsedCpuTime, z, this.e, this.k);
            aVar.close();
            return uVar;
        } finally {
        }
    }

    public final void b(List list) {
        long jElapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() - this.a) - TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
        if (list != null) {
            ArrayDeque arrayDeque = new ArrayDeque(list.size());
            ArrayDeque arrayDeque2 = new ArrayDeque(list.size());
            ArrayDeque arrayDeque3 = new ArrayDeque(list.size());
            synchronized (list) {
                try {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        p3 p3Var = (p3) it.next();
                        long j = p3Var.d;
                        long j2 = j + jElapsedRealtimeNanos;
                        Double d = p3Var.a;
                        Long l = p3Var.b;
                        Long l2 = p3Var.c;
                        if (d != null) {
                            arrayDeque3.add(new io.sentry.profilemeasurements.b(Long.valueOf(j2), d, j));
                        }
                        if (l != null) {
                            arrayDeque.add(new io.sentry.profilemeasurements.b(Long.valueOf(j2), l, j));
                        }
                        if (l2 != null) {
                            arrayDeque2.add(new io.sentry.profilemeasurements.b(Long.valueOf(j2), l2, j));
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!arrayDeque3.isEmpty()) {
                this.k.put("cpu_usage", new io.sentry.profilemeasurements.a("percent", arrayDeque3));
            }
            if (!arrayDeque.isEmpty()) {
                this.k.put("memory_footprint", new io.sentry.profilemeasurements.a("byte", arrayDeque));
            }
            if (arrayDeque2.isEmpty()) {
                return;
            }
            this.k.put("memory_native_footprint", new io.sentry.profilemeasurements.a("byte", arrayDeque2));
        }
    }

    public final bx c() {
        io.sentry.util.a aVar = this.o;
        aVar.g();
        try {
            int i = this.c;
            if (i == 0) {
                this.m.h(p5.WARNING, "Disabling profiling because intervaUs is set to %d", Integer.valueOf(i));
                aVar.close();
                return null;
            }
            if (this.n) {
                this.m.h(p5.WARNING, "Profiling has already started...", new Object[0]);
                aVar.close();
                return null;
            }
            this.e = new File(this.b, io.sentry.config.a.f().concat(".trace"));
            this.k.clear();
            this.h.clear();
            this.i.clear();
            this.j.clear();
            this.f = this.g.b(new t(0, this));
            try {
                io.sentry.util.e eVar = this.l;
                if (eVar != null) {
                    this.d = ((io.sentry.j1) eVar.e()).b(new g(1, this), 30000L);
                }
            } catch (RejectedExecutionException e) {
                this.m.d(p5.ERROR, "Failed to call the executor. Profiling will not be automatically finished. Did you call Sentry.close()?", e);
            }
            this.a = SystemClock.elapsedRealtimeNanos();
            Date date = new Date();
            long elapsedCpuTime = Process.getElapsedCpuTime();
            try {
                Debug.startMethodTracingSampling(this.e.getPath(), 3000000, this.c);
                this.n = true;
                bx bxVar = new bx(this.a, elapsedCpuTime, date);
                aVar.close();
                return bxVar;
            } catch (Throwable th) {
                a(null, false);
                this.m.d(p5.ERROR, "Unable to start a profile: ", th);
                this.n = false;
                aVar.close();
                return null;
            }
        } finally {
        }
    }
}
