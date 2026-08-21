package io.sentry;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w3 implements k2 {
    public Long A;
    public Long X;
    public Long Y;
    public Long Z;
    public String b;
    public String f;
    public ConcurrentHashMap y0;
    public String z;

    public w3(p1 p1Var, Long l, Long l2) {
        this.b = p1Var.n().a();
        this.f = p1Var.r().b.a();
        this.z = p1Var.getName().isEmpty() ? "unknown" : p1Var.getName();
        this.A = l;
        this.Y = l2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || w3.class != obj.getClass()) {
            return false;
        }
        w3 w3Var = (w3) obj;
        return this.b.equals(w3Var.b) && this.f.equals(w3Var.f) && this.z.equals(w3Var.z) && this.A.equals(w3Var.A) && this.Y.equals(w3Var.Y) && io.sentry.util.b.i(this.Z, w3Var.Z) && io.sentry.util.b.i(this.X, w3Var.X) && io.sentry.util.b.i(this.y0, w3Var.y0);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.f, this.z, this.A, this.X, this.Y, this.Z, this.y0});
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        cVar.p("id");
        cVar.v(iLogger, this.b);
        cVar.p("trace_id");
        cVar.v(iLogger, this.f);
        cVar.p("name");
        cVar.v(iLogger, this.z);
        cVar.p("relative_start_ns");
        cVar.v(iLogger, this.A);
        cVar.p("relative_end_ns");
        cVar.v(iLogger, this.X);
        cVar.p("relative_cpu_start_ms");
        cVar.v(iLogger, this.Y);
        cVar.p("relative_cpu_end_ms");
        cVar.v(iLogger, this.Z);
        ConcurrentHashMap concurrentHashMap = this.y0;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                e.d(this.y0, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }
}
