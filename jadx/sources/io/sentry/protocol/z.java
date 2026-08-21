package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.a7;
import io.sentry.b7;
import io.sentry.d7;
import io.sentry.f7;
import io.sentry.k2;
import io.sentry.n3;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z implements k2 {
    public final d7 A;
    public final Map A0;
    public Map B0;
    public final Map C0;
    public ConcurrentHashMap D0;
    public final d7 X;
    public final String Y;
    public final String Z;
    public final Double b;
    public final Double f;
    public final f7 y0;
    public final w z;
    public final String z0;

    public z(a7 a7Var) {
        ConcurrentHashMap concurrentHashMap = a7Var.j;
        b7 b7Var = a7Var.c;
        this.Z = b7Var.Y;
        this.Y = b7Var.X;
        this.A = b7Var.f;
        this.X = b7Var.z;
        this.z = b7Var.b;
        this.y0 = b7Var.Z;
        this.z0 = b7Var.z0;
        ConcurrentHashMap concurrentHashMapO = io.sentry.util.b.o(b7Var.y0);
        this.A0 = concurrentHashMapO == null ? new ConcurrentHashMap() : concurrentHashMapO;
        ConcurrentHashMap concurrentHashMapO2 = io.sentry.util.b.o(a7Var.k);
        this.C0 = concurrentHashMapO2 == null ? new ConcurrentHashMap() : concurrentHashMapO2;
        this.f = a7Var.b == null ? null : Double.valueOf(a7Var.a.c(r2) / 1.0E9d);
        this.b = Double.valueOf(a7Var.a.d() / 1.0E9d);
        this.B0 = concurrentHashMap;
        b7Var.E0.d();
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        cVar.p("start_timestamp");
        cVar.v(iLogger, io.sentry.config.a.c(this.b.doubleValue()));
        Double d = this.f;
        if (d != null) {
            cVar.p("timestamp");
            cVar.v(iLogger, io.sentry.config.a.c(d.doubleValue()));
        }
        cVar.p("trace_id");
        cVar.v(iLogger, this.z);
        cVar.p("span_id");
        cVar.v(iLogger, this.A);
        d7 d7Var = this.X;
        if (d7Var != null) {
            cVar.p("parent_span_id");
            cVar.v(iLogger, d7Var);
        }
        cVar.p("op");
        cVar.y(this.Y);
        String str = this.Z;
        if (str != null) {
            cVar.p("description");
            cVar.y(str);
        }
        f7 f7Var = this.y0;
        if (f7Var != null) {
            cVar.p("status");
            cVar.v(iLogger, f7Var);
        }
        String str2 = this.z0;
        if (str2 != null) {
            cVar.p("origin");
            cVar.v(iLogger, str2);
        }
        Map map = this.A0;
        if (!map.isEmpty()) {
            cVar.p("tags");
            cVar.v(iLogger, map);
        }
        if (this.B0 != null) {
            cVar.p("data");
            cVar.v(iLogger, this.B0);
        }
        Map map2 = this.C0;
        if (!map2.isEmpty()) {
            cVar.p("measurements");
            cVar.v(iLogger, map2);
        }
        ConcurrentHashMap concurrentHashMap = this.D0;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                io.sentry.e.d(this.D0, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }

    public z(Double d, Double d2, w wVar, d7 d7Var, d7 d7Var2, String str, String str2, f7 f7Var, String str3, Map map, Map map2, Map map3) {
        this.b = d;
        this.f = d2;
        this.z = wVar;
        this.A = d7Var;
        this.X = d7Var2;
        this.Y = str;
        this.Z = str2;
        this.y0 = f7Var;
        this.z0 = str3;
        this.A0 = map;
        this.C0 = map2;
        this.B0 = map3;
    }
}
