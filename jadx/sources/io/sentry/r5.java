package io.sentry;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r5 implements k2 {
    public final String A;
    public final t5 X;
    public Integer Y;
    public Map Z;
    public final io.sentry.protocol.w b;
    public d7 f;
    public HashMap y0;
    public final Double z;

    public r5(io.sentry.protocol.w wVar, Double d, String str, t5 t5Var) {
        this.b = wVar;
        this.z = d;
        this.A = str;
        this.X = t5Var;
    }

    public final void a(String str, io.sentry.protocol.n nVar) {
        Map map = this.Z;
        if (map == null) {
            map = new HashMap();
            this.Z = map;
        }
        map.put(str, nVar);
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        cVar.p("timestamp");
        cVar.v(iLogger, io.sentry.config.a.c(this.z.doubleValue()));
        cVar.p("trace_id");
        cVar.v(iLogger, this.b);
        if (this.f != null) {
            cVar.p("span_id");
            cVar.v(iLogger, this.f);
        }
        cVar.p("body");
        cVar.y(this.A);
        cVar.p("level");
        cVar.v(iLogger, this.X);
        if (this.Y != null) {
            cVar.p("severity_number");
            cVar.v(iLogger, this.Y);
        }
        if (this.Z != null) {
            cVar.p("attributes");
            cVar.v(iLogger, this.Z);
        }
        HashMap map = this.y0;
        if (map != null) {
            for (String str : map.keySet()) {
                e.c(this.y0, str, cVar, str, iLogger);
            }
        }
        cVar.m();
    }
}
