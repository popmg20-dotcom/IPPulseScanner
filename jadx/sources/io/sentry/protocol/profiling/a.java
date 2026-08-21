package io.sentry.protocol.profiling;

import io.sentry.ILogger;
import io.sentry.e;
import io.sentry.k2;
import io.sentry.n3;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a implements k2 {
    public ConcurrentHashMap X;
    public List b = new ArrayList();
    public List f = new ArrayList();
    public List z = new ArrayList();
    public Map A = new HashMap();

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        cVar.p("samples");
        cVar.v(iLogger, this.b);
        cVar.p("stacks");
        cVar.v(iLogger, this.f);
        cVar.p("frames");
        cVar.v(iLogger, this.z);
        cVar.p("thread_metadata");
        cVar.v(iLogger, this.A);
        ConcurrentHashMap concurrentHashMap = this.X;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                e.d(this.X, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }
}
