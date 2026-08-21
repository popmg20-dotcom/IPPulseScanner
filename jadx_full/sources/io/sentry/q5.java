package io.sentry;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q5 implements k2 {
    public String A;
    public Long X;
    public ConcurrentHashMap Y;
    public int b;
    public String f;
    public String z;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q5.class != obj.getClass()) {
            return false;
        }
        return io.sentry.util.b.i(this.f, ((q5) obj).f);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f});
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        cVar.p("type");
        cVar.u(this.b);
        if (this.f != null) {
            cVar.p("address");
            cVar.y(this.f);
        }
        if (this.z != null) {
            cVar.p("package_name");
            cVar.y(this.z);
        }
        if (this.A != null) {
            cVar.p("class_name");
            cVar.y(this.A);
        }
        if (this.X != null) {
            cVar.p("thread_id");
            cVar.x(this.X);
        }
        ConcurrentHashMap concurrentHashMap = this.Y;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                e.d(this.Y, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }
}
