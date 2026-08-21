package io.sentry.protocol.profiling;

import io.sentry.ILogger;
import io.sentry.e;
import io.sentry.k2;
import io.sentry.n3;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c implements k2 {
    public String b;
    public int f;
    public HashMap z;

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        if (this.b != null) {
            cVar.p("name");
            cVar.v(iLogger, this.b);
        }
        cVar.p("priority");
        cVar.v(iLogger, Integer.valueOf(this.f));
        HashMap map = this.z;
        if (map != null) {
            for (String str : map.keySet()) {
                e.c(this.z, str, cVar, str, iLogger);
            }
        }
        cVar.m();
    }
}
