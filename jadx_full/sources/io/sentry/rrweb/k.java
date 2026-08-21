package io.sentry.rrweb;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k extends b implements k2 {
    public HashMap A;
    public String z;

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
        cVar.p("tag");
        cVar.y(this.z);
        cVar.p("payload");
        cVar.k();
        HashMap map = this.A;
        if (map != null) {
            for (String str : map.keySet()) {
                Object obj = map.get(str);
                cVar.p(str);
                cVar.v(iLogger, obj);
            }
        }
        cVar.m();
        cVar.m();
        cVar.m();
    }
}
