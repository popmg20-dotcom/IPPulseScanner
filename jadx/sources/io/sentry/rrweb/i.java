package io.sentry.rrweb;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i extends e implements k2 {
    public int A;
    public List X;
    public HashMap Y;
    public HashMap Z;

    public i() {
        super(d.TouchMove);
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        cVar.p("type");
        cVar.v(iLogger, this.b);
        cVar.p("timestamp");
        cVar.u(this.f);
        cVar.p("data");
        cVar.k();
        cVar.p("source");
        cVar.v(iLogger, this.z);
        List list = this.X;
        if (list != null && !list.isEmpty()) {
            cVar.p("positions");
            cVar.v(iLogger, this.X);
        }
        cVar.p("pointerId");
        cVar.u(this.A);
        HashMap map = this.Z;
        if (map != null) {
            for (String str : map.keySet()) {
                io.sentry.e.c(this.Z, str, cVar, str, iLogger);
            }
        }
        cVar.m();
        HashMap map2 = this.Y;
        if (map2 != null) {
            for (String str2 : map2.keySet()) {
                io.sentry.e.c(this.Y, str2, cVar, str2, iLogger);
            }
        }
        cVar.m();
    }
}
