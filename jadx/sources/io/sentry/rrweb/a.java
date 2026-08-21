package io.sentry.rrweb;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import io.sentry.p5;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a extends b implements k2 {
    public double A;
    public HashMap A0;
    public ConcurrentHashMap B0;
    public ConcurrentHashMap C0;
    public String X;
    public String Y;
    public String Z;
    public p5 y0;
    public String z;
    public ConcurrentHashMap z0;

    public a() {
        super(c.Custom);
        this.z = "breadcrumb";
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
        if (this.X != null) {
            cVar.p("type");
            cVar.y(this.X);
        }
        cVar.p("timestamp");
        cVar.v(iLogger, BigDecimal.valueOf(this.A));
        if (this.Y != null) {
            cVar.p("category");
            cVar.y(this.Y);
        }
        if (this.Z != null) {
            cVar.p("message");
            cVar.y(this.Z);
        }
        if (this.y0 != null) {
            cVar.p("level");
            cVar.v(iLogger, this.y0);
        }
        if (this.z0 != null) {
            cVar.p("data");
            cVar.v(iLogger, this.z0);
        }
        ConcurrentHashMap concurrentHashMap = this.B0;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                io.sentry.e.d(this.B0, k, cVar, k, iLogger);
            }
        }
        cVar.m();
        ConcurrentHashMap concurrentHashMap2 = this.C0;
        if (concurrentHashMap2 != null) {
            for (K k2 : concurrentHashMap2.keySet()) {
                io.sentry.e.d(this.C0, k2, cVar, k2, iLogger);
            }
        }
        cVar.m();
        HashMap map = this.A0;
        if (map != null) {
            for (String str : map.keySet()) {
                io.sentry.e.c(this.A0, str, cVar, str, iLogger);
            }
        }
        cVar.m();
    }
}
