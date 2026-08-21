package io.sentry;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k extends io.sentry.protocol.e {
    public final io.sentry.protocol.e A;
    public final io.sentry.protocol.e X;
    public final j4 Y;
    public final io.sentry.protocol.e z;

    public k(io.sentry.protocol.e eVar, io.sentry.protocol.e eVar2, io.sentry.protocol.e eVar3, j4 j4Var) {
        this.z = eVar;
        this.A = eVar2;
        this.X = eVar3;
        this.Y = j4Var;
    }

    @Override // io.sentry.protocol.e
    public final boolean a(Object obj) {
        throw null;
    }

    @Override // io.sentry.protocol.e
    public final Set b() {
        return y().b.entrySet();
    }

    @Override // io.sentry.protocol.e
    public final Object c(Object obj) {
        Object objC = this.X.c(obj);
        if (objC != null) {
            return objC;
        }
        Object objC2 = this.A.c(obj);
        return objC2 != null ? objC2 : this.z.c(obj);
    }

    @Override // io.sentry.protocol.e
    public final io.sentry.protocol.a d() {
        io.sentry.protocol.a aVarD = this.X.d();
        if (aVarD != null) {
            return aVarD;
        }
        io.sentry.protocol.a aVarD2 = this.A.d();
        return aVarD2 != null ? aVarD2 : this.z.d();
    }

    @Override // io.sentry.protocol.e
    public final io.sentry.protocol.h e() {
        io.sentry.protocol.h hVarE = this.X.e();
        if (hVarE != null) {
            return hVarE;
        }
        io.sentry.protocol.h hVarE2 = this.A.e();
        return hVarE2 != null ? hVarE2 : this.z.e();
    }

    @Override // io.sentry.protocol.e
    public final io.sentry.protocol.j f() {
        io.sentry.protocol.j jVarF = this.X.f();
        if (jVarF != null) {
            return jVarF;
        }
        io.sentry.protocol.j jVarF2 = this.A.f();
        return jVarF2 != null ? jVarF2 : this.z.f();
    }

    @Override // io.sentry.protocol.e
    public final io.sentry.protocol.q g() {
        io.sentry.protocol.q qVarG = this.X.g();
        if (qVarG != null) {
            return qVarG;
        }
        io.sentry.protocol.q qVarG2 = this.A.g();
        return qVarG2 != null ? qVarG2 : this.z.g();
    }

    @Override // io.sentry.protocol.e
    public final io.sentry.protocol.y h() {
        io.sentry.protocol.y yVarH = this.X.h();
        if (yVarH != null) {
            return yVarH;
        }
        io.sentry.protocol.y yVarH2 = this.A.h();
        return yVarH2 != null ? yVarH2 : this.z.h();
    }

    @Override // io.sentry.protocol.e
    public final b7 i() {
        b7 b7VarI = this.X.i();
        if (b7VarI != null) {
            return b7VarI;
        }
        b7 b7VarI2 = this.A.i();
        return b7VarI2 != null ? b7VarI2 : this.z.i();
    }

    @Override // io.sentry.protocol.e
    public final Enumeration j() {
        return y().b.keys();
    }

    @Override // io.sentry.protocol.e
    public final Object k(Object obj, String str) {
        return x().k(obj, str);
    }

    @Override // io.sentry.protocol.e
    public final void l(io.sentry.protocol.e eVar) {
        throw null;
    }

    @Override // io.sentry.protocol.e
    public final void m(io.sentry.protocol.a aVar) {
        x().m(aVar);
    }

    @Override // io.sentry.protocol.e
    public final void n(io.sentry.protocol.d dVar) {
        x().n(dVar);
    }

    @Override // io.sentry.protocol.e
    public final void o(io.sentry.protocol.h hVar) {
        x().o(hVar);
    }

    @Override // io.sentry.protocol.e
    public final void p(io.sentry.protocol.j jVar) {
        throw null;
    }

    @Override // io.sentry.protocol.e
    public final void q(io.sentry.protocol.m mVar) {
        x().q(mVar);
    }

    @Override // io.sentry.protocol.e
    public final void r(io.sentry.protocol.q qVar) {
        x().r(qVar);
    }

    @Override // io.sentry.protocol.e
    public final void s(io.sentry.protocol.s sVar) {
        x().s(sVar);
    }

    @Override // io.sentry.protocol.e, io.sentry.k2
    public final void serialize(n3 n3Var, ILogger iLogger) throws IOException {
        y().serialize(n3Var, iLogger);
    }

    @Override // io.sentry.protocol.e
    public final void t(io.sentry.protocol.y yVar) {
        x().t(yVar);
    }

    @Override // io.sentry.protocol.e
    public final void u(io.sentry.protocol.g0 g0Var) {
        x().u(g0Var);
    }

    @Override // io.sentry.protocol.e
    public final void v(b7 b7Var) {
        x().v(b7Var);
    }

    public final io.sentry.protocol.e x() {
        int i = j.a[this.Y.ordinal()];
        io.sentry.protocol.e eVar = this.X;
        return i != 1 ? i != 2 ? i != 3 ? eVar : this.z : this.A : eVar;
    }

    public final io.sentry.protocol.e y() {
        io.sentry.protocol.e eVar = new io.sentry.protocol.e();
        eVar.l(this.z);
        eVar.l(this.A);
        eVar.l(this.X);
        return eVar;
    }
}
