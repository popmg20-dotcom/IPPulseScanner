package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s implements k2 {
    public Long A;
    public Object X;
    public ConcurrentHashMap Y;
    public String b;
    public ConcurrentHashMap f;
    public Integer z;

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        if (this.b != null) {
            cVar.p("cookies");
            cVar.y(this.b);
        }
        if (this.f != null) {
            cVar.p("headers");
            cVar.v(iLogger, this.f);
        }
        if (this.z != null) {
            cVar.p("status_code");
            cVar.v(iLogger, this.z);
        }
        if (this.A != null) {
            cVar.p("body_size");
            cVar.v(iLogger, this.A);
        }
        if (this.X != null) {
            cVar.p("data");
            cVar.v(iLogger, this.X);
        }
        ConcurrentHashMap concurrentHashMap = this.Y;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                io.sentry.e.d(this.Y, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }
}
