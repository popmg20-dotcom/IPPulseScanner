package io.sentry.rrweb;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h implements k2 {
    public long A;
    public HashMap X;
    public int b;
    public float f;
    public float z;

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        cVar.p("id");
        cVar.u(this.b);
        cVar.p("x");
        cVar.t(this.f);
        cVar.p("y");
        cVar.t(this.z);
        cVar.p("timeOffset");
        cVar.u(this.A);
        HashMap map = this.X;
        if (map != null) {
            for (String str : map.keySet()) {
                io.sentry.e.c(this.X, str, cVar, str, iLogger);
            }
        }
        cVar.m();
    }
}
