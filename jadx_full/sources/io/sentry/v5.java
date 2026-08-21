package io.sentry;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v5 implements k2 {
    public String A;
    public String X;
    public String Y;
    public Double Z;
    public io.sentry.protocol.w b;
    public d7 f;
    public Map y0;
    public Double z;
    public HashMap z0;

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        cVar.p("timestamp");
        cVar.v(iLogger, io.sentry.config.a.c(this.z.doubleValue()));
        cVar.p("type");
        cVar.y(this.Y);
        cVar.p("name");
        cVar.y(this.A);
        cVar.p("value");
        cVar.x(this.Z);
        cVar.p("trace_id");
        cVar.v(iLogger, this.b);
        if (this.f != null) {
            cVar.p("span_id");
            cVar.v(iLogger, this.f);
        }
        if (this.X != null) {
            cVar.p("unit");
            cVar.v(iLogger, this.X);
        }
        if (this.y0 != null) {
            cVar.p("attributes");
            cVar.v(iLogger, this.y0);
        }
        HashMap map = this.z0;
        if (map != null) {
            for (String str : map.keySet()) {
                e.c(this.z0, str, cVar, str, iLogger);
            }
        }
        cVar.m();
    }
}
