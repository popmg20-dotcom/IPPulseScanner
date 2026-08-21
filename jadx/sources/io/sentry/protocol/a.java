package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a implements k2 {
    public String A;
    public String A0;
    public Boolean B0;
    public Boolean C0;
    public List D0;
    public ConcurrentHashMap E0;
    public String X;
    public String Y;
    public String Z;
    public String b;
    public Date f;
    public AbstractMap y0;
    public String z;
    public List z0;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return io.sentry.util.b.i(this.b, aVar.b) && io.sentry.util.b.i(this.f, aVar.f) && io.sentry.util.b.i(this.z, aVar.z) && io.sentry.util.b.i(this.A, aVar.A) && io.sentry.util.b.i(this.X, aVar.X) && io.sentry.util.b.i(this.Y, aVar.Y) && io.sentry.util.b.i(this.Z, aVar.Z) && io.sentry.util.b.i(this.y0, aVar.y0) && io.sentry.util.b.i(this.B0, aVar.B0) && io.sentry.util.b.i(this.z0, aVar.z0) && io.sentry.util.b.i(this.A0, aVar.A0) && io.sentry.util.b.i(this.C0, aVar.C0) && io.sentry.util.b.i(this.D0, aVar.D0);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.f, this.z, this.A, this.X, this.Y, this.Z, this.y0, this.B0, this.z0, this.A0, this.C0, this.D0});
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        if (this.b != null) {
            cVar.p("app_identifier");
            cVar.y(this.b);
        }
        if (this.f != null) {
            cVar.p("app_start_time");
            cVar.v(iLogger, this.f);
        }
        if (this.z != null) {
            cVar.p("device_app_hash");
            cVar.y(this.z);
        }
        if (this.A != null) {
            cVar.p("build_type");
            cVar.y(this.A);
        }
        if (this.X != null) {
            cVar.p("app_name");
            cVar.y(this.X);
        }
        if (this.Y != null) {
            cVar.p("app_version");
            cVar.y(this.Y);
        }
        if (this.Z != null) {
            cVar.p("app_build");
            cVar.y(this.Z);
        }
        AbstractMap abstractMap = this.y0;
        if (abstractMap != null && !abstractMap.isEmpty()) {
            cVar.p("permissions");
            cVar.v(iLogger, this.y0);
        }
        if (this.B0 != null) {
            cVar.p("in_foreground");
            cVar.w(this.B0);
        }
        if (this.z0 != null) {
            cVar.p("view_names");
            cVar.v(iLogger, this.z0);
        }
        if (this.A0 != null) {
            cVar.p("start_type");
            cVar.y(this.A0);
        }
        if (this.C0 != null) {
            cVar.p("is_split_apks");
            cVar.w(this.C0);
        }
        List list = this.D0;
        if (list != null && !list.isEmpty()) {
            cVar.p("split_names");
            cVar.v(iLogger, this.D0);
        }
        ConcurrentHashMap concurrentHashMap = this.E0;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                io.sentry.e.d(this.E0, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }
}
