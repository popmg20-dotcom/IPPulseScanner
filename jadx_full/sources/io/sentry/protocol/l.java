package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import j$.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class l implements k2 {
    public ConcurrentHashMap A;
    public String b;
    public String f;
    public String z;

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        if (this.b != null) {
            cVar.p("city");
            cVar.y(this.b);
        }
        if (this.f != null) {
            cVar.p("country_code");
            cVar.y(this.f);
        }
        if (this.z != null) {
            cVar.p("region");
            cVar.y(this.z);
        }
        ConcurrentHashMap concurrentHashMap = this.A;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                io.sentry.e.d(this.A, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }
}
