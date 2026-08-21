package io.sentry;

import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.IOException;
import java.util.AbstractMap;
import org.conscrypt.BuildConfig;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s3 implements k2 {
    public io.sentry.protocol.u A;
    public double A0;
    public String B0;
    public final File C0;
    public io.sentry.protocol.profiling.a E0;
    public ConcurrentHashMap F0;
    public final AbstractMap X;
    public String Y;
    public String Z;
    public io.sentry.protocol.w f;
    public String y0;
    public io.sentry.protocol.w z;
    public String z0;
    public String D0 = null;
    public io.sentry.protocol.f b = null;

    public s3(io.sentry.protocol.w wVar, io.sentry.protocol.w wVar2, File file, AbstractMap abstractMap, Double d, p6 p6Var) {
        this.f = wVar;
        this.z = wVar2;
        this.C0 = file;
        this.X = abstractMap;
        this.A = p6Var.getSdkVersion();
        this.Z = p6Var.getRelease() != null ? p6Var.getRelease() : "";
        this.y0 = p6Var.getEnvironment();
        this.Y = "android";
        this.z0 = "2";
        this.A0 = d.doubleValue();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s3)) {
            return false;
        }
        s3 s3Var = (s3) obj;
        return this.b == s3Var.b && Objects.equals(this.f, s3Var.f) && Objects.equals(this.z, s3Var.z) && Objects.equals(this.A, s3Var.A) && this.X.equals(s3Var.X) && Objects.equals(this.Y, s3Var.Y) && Objects.equals(this.Z, s3Var.Z) && Objects.equals(this.y0, s3Var.y0) && Objects.equals(this.z0, s3Var.z0) && Objects.equals(this.D0, s3Var.D0) && Objects.equals(this.F0, s3Var.F0) && this.E0 == s3Var.E0;
    }

    public final int hashCode() {
        return Objects.hash(this.b, this.f, this.z, this.A, this.X, this.Y, this.Z, this.y0, this.z0, this.D0, this.E0, this.F0);
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        if (this.b != null) {
            cVar.p("debug_meta");
            cVar.v(iLogger, this.b);
        }
        cVar.p("profiler_id");
        cVar.v(iLogger, this.f);
        cVar.p("chunk_id");
        cVar.v(iLogger, this.z);
        if (this.A != null) {
            cVar.p("client_sdk");
            cVar.v(iLogger, this.A);
        }
        AbstractMap abstractMap = this.X;
        if (!abstractMap.isEmpty()) {
            String str = ((io.sentry.vendor.gson.stream.c) cVar.f).A;
            cVar.s("");
            cVar.p("measurements");
            cVar.v(iLogger, abstractMap);
            cVar.s(str);
        }
        cVar.p("platform");
        cVar.v(iLogger, this.Y);
        cVar.p(BuildConfig.BUILD_TYPE);
        cVar.v(iLogger, this.Z);
        if (this.y0 != null) {
            cVar.p("environment");
            cVar.v(iLogger, this.y0);
        }
        cVar.p("version");
        cVar.v(iLogger, this.z0);
        if (this.B0 != null) {
            cVar.p("content_type");
            cVar.v(iLogger, this.B0);
        }
        if (this.D0 != null) {
            cVar.p("sampled_profile");
            cVar.v(iLogger, this.D0);
        }
        cVar.p("timestamp");
        cVar.v(iLogger, io.sentry.config.a.c(this.A0));
        if (this.E0 != null) {
            cVar.p("profile");
            cVar.v(iLogger, this.E0);
        }
        ConcurrentHashMap concurrentHashMap = this.F0;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                e.d(this.F0, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }
}
