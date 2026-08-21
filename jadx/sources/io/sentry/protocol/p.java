package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p implements k2 {
    public ConcurrentHashMap A;
    public String b;
    public String f;
    public List z;

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        if (this.b != null) {
            cVar.p("formatted");
            cVar.y(this.b);
        }
        if (this.f != null) {
            cVar.p("message");
            cVar.y(this.f);
        }
        List list = this.z;
        if (list != null && !list.isEmpty()) {
            cVar.p("params");
            cVar.v(iLogger, this.z);
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
