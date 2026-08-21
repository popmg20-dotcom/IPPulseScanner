package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.k2;
import io.sentry.n3;
import io.sentry.q5;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a0 implements k2 {
    public String A;
    public String A0;
    public Boolean B0;
    public String C0;
    public Boolean D0;
    public String E0;
    public String F0;
    public String G0;
    public String H0;
    public String I0;
    public String J0;
    public ConcurrentHashMap K0;
    public String L0;
    public q5 M0;
    public String X;
    public String Y;
    public Integer Z;
    public List b;
    public List f;
    public Integer y0;
    public Map z;
    public String z0;

    public final boolean equals(Object obj) {
        if (obj == null || a0.class != obj.getClass()) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return Objects.equals(this.b, a0Var.b) && Objects.equals(this.f, a0Var.f) && Objects.equals(this.z, a0Var.z) && Objects.equals(this.A, a0Var.A) && Objects.equals(this.X, a0Var.X) && Objects.equals(this.Y, a0Var.Y) && Objects.equals(this.Z, a0Var.Z) && Objects.equals(this.y0, a0Var.y0) && Objects.equals(this.z0, a0Var.z0) && Objects.equals(this.A0, a0Var.A0) && Objects.equals(this.B0, a0Var.B0) && Objects.equals(this.C0, a0Var.C0) && Objects.equals(this.D0, a0Var.D0) && Objects.equals(this.E0, a0Var.E0) && Objects.equals(this.F0, a0Var.F0) && Objects.equals(this.G0, a0Var.G0) && Objects.equals(this.H0, a0Var.H0) && Objects.equals(this.I0, a0Var.I0) && Objects.equals(this.J0, a0Var.J0) && Objects.equals(this.K0, a0Var.K0) && Objects.equals(this.L0, a0Var.L0) && Objects.equals(this.M0, a0Var.M0);
    }

    public final int hashCode() {
        return Objects.hash(this.b, this.f, this.z, null, this.A, this.X, this.Y, this.Z, this.y0, this.z0, this.A0, this.B0, this.C0, this.D0, this.E0, this.F0, this.G0, this.H0, this.I0, this.J0, this.K0, this.L0, this.M0);
    }

    @Override // io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        io.sentry.internal.debugmeta.c cVar = (io.sentry.internal.debugmeta.c) n3Var;
        cVar.k();
        if (this.A != null) {
            cVar.p("filename");
            cVar.y(this.A);
        }
        if (this.X != null) {
            cVar.p("function");
            cVar.y(this.X);
        }
        if (this.Y != null) {
            cVar.p("module");
            cVar.y(this.Y);
        }
        if (this.Z != null) {
            cVar.p("lineno");
            cVar.x(this.Z);
        }
        if (this.y0 != null) {
            cVar.p("colno");
            cVar.x(this.y0);
        }
        if (this.z0 != null) {
            cVar.p("abs_path");
            cVar.y(this.z0);
        }
        if (this.A0 != null) {
            cVar.p("context_line");
            cVar.y(this.A0);
        }
        if (this.B0 != null) {
            cVar.p("in_app");
            cVar.w(this.B0);
        }
        if (this.C0 != null) {
            cVar.p("package");
            cVar.y(this.C0);
        }
        if (this.D0 != null) {
            cVar.p("native");
            cVar.w(this.D0);
        }
        if (this.E0 != null) {
            cVar.p("platform");
            cVar.y(this.E0);
        }
        if (this.F0 != null) {
            cVar.p("image_addr");
            cVar.y(this.F0);
        }
        if (this.G0 != null) {
            cVar.p("symbol_addr");
            cVar.y(this.G0);
        }
        if (this.H0 != null) {
            cVar.p("instruction_addr");
            cVar.y(this.H0);
        }
        if (this.I0 != null) {
            cVar.p("addr_mode");
            cVar.y(this.I0);
        }
        if (this.L0 != null) {
            cVar.p("raw_function");
            cVar.y(this.L0);
        }
        if (this.J0 != null) {
            cVar.p("symbol");
            cVar.y(this.J0);
        }
        if (this.M0 != null) {
            cVar.p("lock");
            cVar.v(iLogger, this.M0);
        }
        List list = this.b;
        if (list != null && !list.isEmpty()) {
            cVar.p("pre_context");
            cVar.v(iLogger, this.b);
        }
        List list2 = this.f;
        if (list2 != null && !list2.isEmpty()) {
            cVar.p("post_context");
            cVar.v(iLogger, this.f);
        }
        Map map = this.z;
        if (map != null && !map.isEmpty()) {
            cVar.p("vars");
            cVar.v(iLogger, this.z);
        }
        ConcurrentHashMap concurrentHashMap = this.K0;
        if (concurrentHashMap != null) {
            for (K k : concurrentHashMap.keySet()) {
                io.sentry.e.d(this.K0, k, cVar, k, iLogger);
            }
        }
        cVar.m();
    }
}
