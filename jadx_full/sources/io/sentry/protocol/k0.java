package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k0 implements k2 {
    public final String b;
    public final List f;
    public HashMap z;

    public k0(String str, List list) {
        this.b = str;
        this.f = list;
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        String str = this.b;
        if (str != null) {
            cVar.p("rendering_system");
            cVar.y(str);
        }
        List list = this.f;
        if (list != null) {
            cVar.p("windows");
            cVar.v(iLogger, list);
        }
        HashMap map = this.z;
        if (map != null) {
            for (String str2 : map.keySet()) {
                io.sentry.e.c(this.z, str2, cVar, str2, iLogger);
            }
        }
        cVar.m();
    }
}
