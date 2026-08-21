package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c implements k2 {
    public Double A;
    public Long A0;
    public Long B0;
    public ConcurrentHashMap C0;
    public Long X;
    public Double Y;
    public Long Z;
    public Long b;
    public Double f;
    public Long y0;
    public Long z;
    public Long z0;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && c.class == obj.getClass()) {
            c cVar = (c) obj;
            if (io.sentry.util.b.i(this.b, cVar.b) && io.sentry.util.b.i(this.f, cVar.f) && io.sentry.util.b.i(this.z, cVar.z) && io.sentry.util.b.i(this.A, cVar.A) && io.sentry.util.b.i(this.X, cVar.X) && io.sentry.util.b.i(this.Y, cVar.Y) && io.sentry.util.b.i(this.Z, cVar.Z) && io.sentry.util.b.i(this.y0, cVar.y0) && io.sentry.util.b.i(this.z0, cVar.z0) && io.sentry.util.b.i(this.A0, cVar.A0) && io.sentry.util.b.i(this.B0, cVar.B0)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.f, this.z, this.A, this.X, this.Y, this.Z, this.y0, this.z0, this.A0, this.B0});
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        if (this.b != null) {
            cVar.p("gc.total_count");
            cVar.x(this.b);
        }
        if (this.f != null) {
            cVar.p("gc.total_time");
            cVar.x(this.f);
        }
        if (this.z != null) {
            cVar.p("gc.blocking_count");
            cVar.x(this.z);
        }
        if (this.A != null) {
            cVar.p("gc.blocking_time");
            cVar.x(this.A);
        }
        if (this.X != null) {
            cVar.p("gc.pre_oome_count");
            cVar.x(this.X);
        }
        if (this.Y != null) {
            cVar.p("gc.waiting_time");
            cVar.x(this.Y);
        }
        if (this.Z != null) {
            cVar.p("memory.free");
            cVar.x(this.Z);
        }
        if (this.y0 != null) {
            cVar.p("memory.free_until_gc");
            cVar.x(this.y0);
        }
        if (this.z0 != null) {
            cVar.p("memory.free_until_oome");
            cVar.x(this.z0);
        }
        if (this.A0 != null) {
            cVar.p("memory.total");
            cVar.x(this.A0);
        }
        if (this.B0 != null) {
            cVar.p("memory.max");
            cVar.x(this.B0);
        }
        ConcurrentHashMap concurrentHashMap = this.C0;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                io.sentry.e.d(this.C0, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }
}
