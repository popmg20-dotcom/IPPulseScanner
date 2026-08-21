package io.sentry.protocol;

import io.netty.handler.codec.rtsp.RtspHeaders;
import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r implements k2 {
    public Object A;
    public String A0;
    public String B0;
    public ConcurrentHashMap C0;
    public String X;
    public ConcurrentHashMap Y;
    public ConcurrentHashMap Z;
    public String b;
    public String f;
    public Long y0;
    public String z;
    public ConcurrentHashMap z0;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        return io.sentry.util.b.i(this.b, rVar.b) && io.sentry.util.b.i(this.f, rVar.f) && io.sentry.util.b.i(this.z, rVar.z) && io.sentry.util.b.i(this.X, rVar.X) && io.sentry.util.b.i(this.Y, rVar.Y) && io.sentry.util.b.i(this.Z, rVar.Z) && io.sentry.util.b.i(this.y0, rVar.y0) && io.sentry.util.b.i(this.A0, rVar.A0) && io.sentry.util.b.i(this.B0, rVar.B0);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.f, this.z, this.X, this.Y, this.Z, this.y0, this.A0, this.B0});
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        if (this.b != null) {
            cVar.p(RtspHeaders.Values.URL);
            cVar.y(this.b);
        }
        if (this.f != null) {
            cVar.p("method");
            cVar.y(this.f);
        }
        if (this.z != null) {
            cVar.p("query_string");
            cVar.y(this.z);
        }
        if (this.A != null) {
            cVar.p("data");
            cVar.v(iLogger, this.A);
        }
        if (this.X != null) {
            cVar.p("cookies");
            cVar.y(this.X);
        }
        if (this.Y != null) {
            cVar.p("headers");
            cVar.v(iLogger, this.Y);
        }
        if (this.Z != null) {
            cVar.p("env");
            cVar.v(iLogger, this.Z);
        }
        if (this.z0 != null) {
            cVar.p("other");
            cVar.v(iLogger, this.z0);
        }
        if (this.A0 != null) {
            cVar.p("fragment");
            cVar.v(iLogger, this.A0);
        }
        if (this.y0 != null) {
            cVar.p("body_size");
            cVar.v(iLogger, this.y0);
        }
        if (this.B0 != null) {
            cVar.p("api_target");
            cVar.v(iLogger, this.B0);
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
