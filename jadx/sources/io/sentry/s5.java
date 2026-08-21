package io.sentry;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s5 implements k2 {
    public final List b;
    public HashMap f;

    public s5(List list) {
        this.b = list;
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        cVar.p("items");
        cVar.v(iLogger, this.b);
        HashMap map = this.f;
        if (map != null) {
            for (String str : map.keySet()) {
                e.c(this.f, str, cVar, str, iLogger);
            }
        }
        cVar.m();
    }
}
