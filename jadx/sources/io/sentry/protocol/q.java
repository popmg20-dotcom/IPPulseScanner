package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q implements k2 {
    public String A;
    public String X;
    public Boolean Y;
    public ConcurrentHashMap Z;
    public String b;
    public String f;
    public String z;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && q.class == obj.getClass()) {
            q qVar = (q) obj;
            if (io.sentry.util.b.i(this.b, qVar.b) && io.sentry.util.b.i(this.f, qVar.f) && io.sentry.util.b.i(this.z, qVar.z) && io.sentry.util.b.i(this.A, qVar.A) && io.sentry.util.b.i(this.X, qVar.X) && io.sentry.util.b.i(this.Y, qVar.Y)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.f, this.z, this.A, this.X, this.Y});
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
        if (this.z != null) {
            cVar.p("raw_description");
            cVar.y(this.z);
        }
        if (this.A != null) {
            cVar.p("build");
            cVar.y(this.A);
        }
        if (this.X != null) {
            cVar.p("kernel_version");
            cVar.y(this.X);
        }
        if (this.Y != null) {
            cVar.p("rooted");
            cVar.w(this.Y);
        }
        ConcurrentHashMap concurrentHashMap = this.Z;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                io.sentry.e.d(this.Z, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }
}
