package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i implements k2 {
    public final String b;
    public final boolean f;
    public ConcurrentHashMap z;

    public i(String str, boolean z) {
        this.b = str;
        this.f = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && i.class == obj.getClass()) {
            i iVar = (i) obj;
            if (io.sentry.util.b.i(this.b, iVar.b) && io.sentry.util.b.i(Boolean.valueOf(this.f), Boolean.valueOf(iVar.f))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, Boolean.valueOf(this.f)});
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        cVar.p("flag");
        cVar.y(this.b);
        cVar.p("result");
        cVar.z(this.f);
        ConcurrentHashMap concurrentHashMap = this.z;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                io.sentry.e.d(this.z, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }
}
