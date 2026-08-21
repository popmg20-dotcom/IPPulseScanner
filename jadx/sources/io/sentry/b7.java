package io.sentry;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class b7 implements k2 {
    public transient x3 A;
    public Map A0;
    public ConcurrentHashMap B0;
    public u1 C0;
    public c D0;
    public final n2 E0;
    public final io.sentry.protocol.w F0;
    public String X;
    public String Y;
    public f7 Z;
    public final io.sentry.protocol.w b;
    public final d7 f;
    public ConcurrentHashMap y0;
    public final d7 z;
    public String z0;

    public b7(io.sentry.protocol.w wVar, d7 d7Var, d7 d7Var2, String str, String str2, x3 x3Var, f7 f7Var, String str3) {
        this.y0 = new ConcurrentHashMap();
        this.z0 = "manual";
        this.A0 = new ConcurrentHashMap();
        this.C0 = u1.SENTRY;
        this.E0 = new n2(7);
        this.F0 = io.sentry.protocol.w.f;
        io.sentry.util.b.r(wVar, "traceId is required");
        this.b = wVar;
        io.sentry.util.b.r(d7Var, "spanId is required");
        this.f = d7Var;
        io.sentry.util.b.r(str, "operation is required");
        this.X = str;
        this.z = d7Var2;
        this.Y = str2;
        this.Z = f7Var;
        this.z0 = str3;
        a(x3Var);
        io.sentry.util.thread.a threadChecker = p4.c().getOptions().getThreadChecker();
        this.A0.put("thread.id", String.valueOf(threadChecker.b()));
        this.A0.put("thread.name", threadChecker.a());
    }

    public final void a(x3 x3Var) {
        this.A = x3Var;
        c cVar = this.D0;
        if (cVar == null || x3Var == null) {
            return;
        }
        Boolean bool = (Boolean) x3Var.a;
        Charset charset = io.sentry.util.p.a;
        cVar.d("sentry-sampled", bool == null ? null : bool.toString());
        Double d = (Double) x3Var.c;
        if (d != null && cVar.f) {
            cVar.d = d;
        }
        Double d2 = (Double) x3Var.b;
        if (d2 != null) {
            cVar.c = d2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b7)) {
            return false;
        }
        b7 b7Var = (b7) obj;
        return this.b.equals(b7Var.b) && this.f.equals(b7Var.f) && io.sentry.util.b.i(this.z, b7Var.z) && this.X.equals(b7Var.X) && io.sentry.util.b.i(this.Y, b7Var.Y) && this.Z == b7Var.Z;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.f, this.z, this.X, this.Y, this.Z});
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        cVar.p("trace_id");
        this.b.serialize(cVar, iLogger);
        cVar.p("span_id");
        this.f.serialize(cVar, iLogger);
        d7 d7Var = this.z;
        if (d7Var != null) {
            cVar.p("parent_span_id");
            d7Var.serialize(cVar, iLogger);
        }
        cVar.p("op");
        cVar.y(this.X);
        if (this.Y != null) {
            cVar.p("description");
            cVar.y(this.Y);
        }
        if (this.Z != null) {
            cVar.p("status");
            cVar.v(iLogger, this.Z);
        }
        if (this.z0 != null) {
            cVar.p("origin");
            cVar.v(iLogger, this.z0);
        }
        if (!this.y0.isEmpty()) {
            cVar.p("tags");
            cVar.v(iLogger, this.y0);
        }
        if (!this.A0.isEmpty()) {
            cVar.p("data");
            cVar.v(iLogger, this.A0);
        }
        ConcurrentHashMap concurrentHashMap = this.B0;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                e.d(this.B0, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }

    public b7(io.sentry.protocol.w wVar, d7 d7Var, String str, d7 d7Var2) {
        this(wVar, d7Var, d7Var2, str, null, null, null, "manual");
    }

    public b7(b7 b7Var) {
        this.y0 = new ConcurrentHashMap();
        this.z0 = "manual";
        this.A0 = new ConcurrentHashMap();
        this.C0 = u1.SENTRY;
        this.E0 = new n2(7);
        this.F0 = io.sentry.protocol.w.f;
        this.b = b7Var.b;
        this.f = b7Var.f;
        this.z = b7Var.z;
        a(b7Var.A);
        this.X = b7Var.X;
        this.Y = b7Var.Y;
        this.Z = b7Var.Z;
        ConcurrentHashMap concurrentHashMapO = io.sentry.util.b.o(b7Var.y0);
        if (concurrentHashMapO != null) {
            this.y0 = concurrentHashMapO;
        }
        ConcurrentHashMap concurrentHashMapO2 = io.sentry.util.b.o(b7Var.B0);
        if (concurrentHashMapO2 != null) {
            this.B0 = concurrentHashMapO2;
        }
        this.D0 = b7Var.D0;
        ConcurrentHashMap concurrentHashMapO3 = io.sentry.util.b.o(b7Var.A0);
        if (concurrentHashMapO3 != null) {
            this.A0 = concurrentHashMapO3;
        }
    }
}
