package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j0 implements k2 {
    public String A;
    public String X;
    public l Y;
    public ConcurrentHashMap Z;
    public String b;
    public String f;
    public ConcurrentHashMap y0;
    public String z;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && j0.class == obj.getClass()) {
            j0 j0Var = (j0) obj;
            if (io.sentry.util.b.i(this.b, j0Var.b) && io.sentry.util.b.i(this.f, j0Var.f) && io.sentry.util.b.i(this.z, j0Var.z) && io.sentry.util.b.i(this.A, j0Var.A)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.f, this.z, this.A});
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        if (this.b != null) {
            cVar.p("email");
            cVar.y(this.b);
        }
        if (this.f != null) {
            cVar.p("id");
            cVar.y(this.f);
        }
        if (this.z != null) {
            cVar.p("username");
            cVar.y(this.z);
        }
        if (this.A != null) {
            cVar.p("ip_address");
            cVar.y(this.A);
        }
        if (this.X != null) {
            cVar.p("name");
            cVar.y(this.X);
        }
        if (this.Y != null) {
            cVar.p("geo");
            this.Y.serialize(cVar, iLogger);
        }
        if (this.Z != null) {
            cVar.p("data");
            cVar.v(iLogger, this.Z);
        }
        ConcurrentHashMap concurrentHashMap = this.y0;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                io.sentry.e.d(this.y0, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }
}
