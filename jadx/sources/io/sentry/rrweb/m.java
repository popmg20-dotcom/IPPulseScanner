package io.sentry.rrweb;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m extends b implements k2 {
    public int A;
    public int A0;
    public int B0;
    public String C0;
    public int D0;
    public int E0;
    public int F0;
    public HashMap G0;
    public ConcurrentHashMap H0;
    public ConcurrentHashMap I0;
    public long X;
    public long Y;
    public String Z;
    public String y0;
    public String z;
    public int z0;

    public m() {
        super(c.Custom);
        this.Z = "h264";
        this.y0 = "mp4";
        this.C0 = "constant";
        this.z = "video";
    }

    @Override // io.sentry.rrweb.b
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        m mVar = (m) obj;
        return this.A == mVar.A && this.X == mVar.X && this.Y == mVar.Y && this.z0 == mVar.z0 && this.A0 == mVar.A0 && this.B0 == mVar.B0 && this.D0 == mVar.D0 && this.E0 == mVar.E0 && this.F0 == mVar.F0 && io.sentry.util.b.i(this.z, mVar.z) && io.sentry.util.b.i(this.Z, mVar.Z) && io.sentry.util.b.i(this.y0, mVar.y0) && io.sentry.util.b.i(this.C0, mVar.C0);
    }

    @Override // io.sentry.rrweb.b
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(super.hashCode()), this.z, Integer.valueOf(this.A), Long.valueOf(this.X), Long.valueOf(this.Y), this.Z, this.y0, Integer.valueOf(this.z0), Integer.valueOf(this.A0), Integer.valueOf(this.B0), this.C0, Integer.valueOf(this.D0), Integer.valueOf(this.E0), Integer.valueOf(this.F0)});
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        cVar.p("type");
        cVar.v(iLogger, this.b);
        cVar.p("timestamp");
        cVar.u(this.f);
        cVar.p("data");
        cVar.k();
        cVar.p("tag");
        cVar.y(this.z);
        cVar.p("payload");
        cVar.k();
        cVar.p("segmentId");
        cVar.u(this.A);
        cVar.p("size");
        cVar.u(this.X);
        cVar.p("duration");
        cVar.u(this.Y);
        cVar.p("encoding");
        cVar.y(this.Z);
        cVar.p("container");
        cVar.y(this.y0);
        cVar.p("height");
        cVar.u(this.z0);
        cVar.p("width");
        cVar.u(this.A0);
        cVar.p("frameCount");
        cVar.u(this.B0);
        cVar.p("frameRate");
        cVar.u(this.D0);
        cVar.p("frameRateType");
        cVar.y(this.C0);
        cVar.p("left");
        cVar.u(this.E0);
        cVar.p("top");
        cVar.u(this.F0);
        ConcurrentHashMap concurrentHashMap = this.H0;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                io.sentry.e.d(this.H0, k, cVar, k, iLogger);
            }
        }
        cVar.m();
        ConcurrentHashMap concurrentHashMap2 = this.I0;
        if (concurrentHashMap2 != null) {
            for (K k2 : concurrentHashMap2.keySet()) {
                io.sentry.e.d(this.I0, k2, cVar, k2, iLogger);
            }
        }
        cVar.m();
        HashMap map = this.G0;
        if (map != null) {
            for (String str : map.keySet()) {
                io.sentry.e.c(this.G0, str, cVar, str, iLogger);
            }
        }
        cVar.m();
    }
}
