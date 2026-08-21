package io.sentry;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class y4 implements k2 {
    public Date A;
    public HashMap X;
    public final io.sentry.protocol.w b;
    public final io.sentry.protocol.u f;
    public final h7 z;

    public y4(io.sentry.protocol.w wVar, io.sentry.protocol.u uVar, h7 h7Var) {
        this.b = wVar;
        this.f = uVar;
        this.z = h7Var;
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        io.sentry.protocol.w wVar = this.b;
        if (wVar != null) {
            cVar.p("event_id");
            cVar.v(iLogger, wVar);
        }
        io.sentry.protocol.u uVar = this.f;
        if (uVar != null) {
            cVar.p("sdk");
            cVar.v(iLogger, uVar);
        }
        h7 h7Var = this.z;
        if (h7Var != null) {
            cVar.p("trace");
            cVar.v(iLogger, h7Var);
        }
        if (this.A != null) {
            cVar.p("sent_at");
            cVar.v(iLogger, io.sentry.vendor.a.f(this.A.getTime()));
        }
        HashMap map = this.X;
        if (map != null) {
            for (String str : map.keySet()) {
                e.c(this.X, str, cVar, str, iLogger);
            }
        }
        cVar.m();
    }
}
