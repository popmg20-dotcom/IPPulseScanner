package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c0 implements k2 {
    public b0 A;
    public ConcurrentHashMap X;
    public List b;
    public AbstractMap f;
    public Boolean z;

    public c0(List list) {
        this.b = list;
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        if (this.b != null) {
            cVar.p("frames");
            cVar.v(iLogger, this.b);
        }
        if (this.f != null) {
            cVar.p("registers");
            cVar.v(iLogger, this.f);
        }
        if (this.z != null) {
            cVar.p("snapshot");
            cVar.w(this.z);
        }
        if (this.A != null) {
            cVar.p("instruction_addr_adjustment");
            cVar.v(iLogger, this.A);
        }
        ConcurrentHashMap concurrentHashMap = this.X;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                io.sentry.e.d(this.X, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }
}
