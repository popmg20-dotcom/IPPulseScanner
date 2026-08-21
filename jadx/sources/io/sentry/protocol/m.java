package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m implements k2 {
    public String A;
    public ConcurrentHashMap A0;
    public Integer X;
    public String Y;
    public Boolean Z;
    public String b;
    public Integer f;
    public String y0;
    public String z;
    public String z0;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && m.class == obj.getClass()) {
            m mVar = (m) obj;
            if (io.sentry.util.b.i(this.b, mVar.b) && io.sentry.util.b.i(this.f, mVar.f) && io.sentry.util.b.i(this.z, mVar.z) && io.sentry.util.b.i(this.A, mVar.A) && io.sentry.util.b.i(this.X, mVar.X) && io.sentry.util.b.i(this.Y, mVar.Y) && io.sentry.util.b.i(this.Z, mVar.Z) && io.sentry.util.b.i(this.y0, mVar.y0) && io.sentry.util.b.i(this.z0, mVar.z0)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.f, this.z, this.A, this.X, this.Y, this.Z, this.y0, this.z0});
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
            cVar.p("id");
            cVar.x(this.f);
        }
        if (this.z != null) {
            cVar.p("vendor_id");
            cVar.y(this.z);
        }
        if (this.A != null) {
            cVar.p("vendor_name");
            cVar.y(this.A);
        }
        if (this.X != null) {
            cVar.p("memory_size");
            cVar.x(this.X);
        }
        if (this.Y != null) {
            cVar.p("api_type");
            cVar.y(this.Y);
        }
        if (this.Z != null) {
            cVar.p("multi_threaded_rendering");
            cVar.w(this.Z);
        }
        if (this.y0 != null) {
            cVar.p("version");
            cVar.y(this.y0);
        }
        if (this.z0 != null) {
            cVar.p("npot_support");
            cVar.y(this.z0);
        }
        ConcurrentHashMap concurrentHashMap = this.A0;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                io.sentry.e.d(this.A0, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }
}
