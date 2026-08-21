package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d implements k2 {
    public String b;
    public String f;
    public ConcurrentHashMap z;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            d dVar = (d) obj;
            if (io.sentry.util.b.i(this.b, dVar.b) && io.sentry.util.b.i(this.f, dVar.f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.f});
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        if (this.b != null) {
            cVar.p("name");
            cVar.y(this.b);
        }
        if (this.f != null) {
            cVar.p("version");
            cVar.y(this.f);
        }
        ConcurrentHashMap concurrentHashMap = this.z;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                io.sentry.e.d(this.z, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }
}
