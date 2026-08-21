package io.sentry;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f5 extends t4 implements k2 {
    public Date G0;
    public io.sentry.protocol.p H0;
    public String I0;
    public g2 J0;
    public g2 K0;
    public p5 L0;
    public String M0;
    public List N0;
    public ConcurrentHashMap O0;
    public AbstractMap P0;

    public f5() {
        io.sentry.protocol.w wVar = new io.sentry.protocol.w();
        Date date = new Date();
        super(wVar);
        this.G0 = date;
    }

    public final ArrayList d() {
        g2 g2Var = this.K0;
        if (g2Var == null) {
            return null;
        }
        return g2Var.a;
    }

    public final ArrayList e() {
        g2 g2Var = this.J0;
        if (g2Var != null) {
            return g2Var.a;
        }
        return null;
    }

    public final io.sentry.protocol.v f() {
        Boolean bool;
        g2 g2Var = this.K0;
        if (g2Var == null) {
            return null;
        }
        for (io.sentry.protocol.v vVar : g2Var.a) {
            io.sentry.protocol.o oVar = vVar.Y;
            if (oVar != null && (bool = oVar.A) != null && !bool.booleanValue()) {
                return vVar;
            }
        }
        return null;
    }

    public final boolean g() {
        g2 g2Var = this.K0;
        return (g2Var == null || g2Var.a.isEmpty()) ? false : true;
    }

    public final void h(ArrayList arrayList) {
        this.K0 = new g2(arrayList);
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        cVar.p("timestamp");
        cVar.v(iLogger, this.G0);
        if (this.H0 != null) {
            cVar.p("message");
            cVar.v(iLogger, this.H0);
        }
        if (this.I0 != null) {
            cVar.p("logger");
            cVar.y(this.I0);
        }
        g2 g2Var = this.J0;
        if (g2Var != null && !g2Var.a.isEmpty()) {
            cVar.p("threads");
            cVar.k();
            cVar.p("values");
            cVar.v(iLogger, this.J0.a);
            cVar.m();
        }
        g2 g2Var2 = this.K0;
        if (g2Var2 != null && !g2Var2.a.isEmpty()) {
            cVar.p("exception");
            cVar.k();
            cVar.p("values");
            cVar.v(iLogger, this.K0.a);
            cVar.m();
        }
        if (this.L0 != null) {
            cVar.p("level");
            cVar.v(iLogger, this.L0);
        }
        if (this.M0 != null) {
            cVar.p("transaction");
            cVar.y(this.M0);
        }
        if (this.N0 != null) {
            cVar.p("fingerprint");
            cVar.v(iLogger, this.N0);
        }
        if (this.P0 != null) {
            cVar.p("modules");
            cVar.v(iLogger, this.P0);
        }
        io.sentry.config.a.p(this, cVar, iLogger);
        ConcurrentHashMap concurrentHashMap = this.O0;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                e.d(this.O0, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }

    public f5(Throwable th) {
        this();
        this.A0 = th;
    }
}
