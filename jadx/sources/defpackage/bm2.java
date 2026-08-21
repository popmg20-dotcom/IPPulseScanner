package defpackage;

import android.util.Range;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bm2 implements mn4 {
    public final qn2 b;

    public bm2() {
        qn2 qn2VarC = qn2.c();
        qn2VarC.g(mn4.c0, new ux());
        qn2VarC.g(dy1.s, 34);
        qn2VarC.g(ta4.U, cm2.class);
        qn2VarC.g(ta4.T, cm2.class.getCanonicalName() + "-" + UUID.randomUUID());
        this.b = qn2VarC;
    }

    @Override // defpackage.ka0
    public final Object C(pg pgVar, ia0 ia0Var) {
        return this.b.C(pgVar, ia0Var);
    }

    @Override // defpackage.mn4
    public final tt3 E() {
        return (tt3) p(mn4.a0, null);
    }

    @Override // defpackage.ta4
    public final /* synthetic */ String F(String str) {
        return dw2.f(this, str);
    }

    @Override // defpackage.mn4
    public final /* synthetic */ d44 J() {
        return qe4.d(this);
    }

    @Override // defpackage.ka0
    public final boolean K(pg pgVar) {
        return this.b.b.containsKey(pgVar);
    }

    @Override // defpackage.mn4
    public final on4 M() {
        return on4.Y;
    }

    @Override // defpackage.mn4
    public final /* synthetic */ int N() {
        return qe4.g(this);
    }

    @Override // defpackage.mn4
    public final Range O(Range range) {
        return (Range) p(mn4.g0, range);
    }

    @Override // defpackage.ta4
    public final /* synthetic */ String Q() {
        return dw2.e(this);
    }

    @Override // defpackage.ka0
    public final ia0 S(pg pgVar) {
        return this.b.S(pgVar);
    }

    @Override // defpackage.mn4
    public final /* synthetic */ int W() {
        return qe4.b(this);
    }

    @Override // defpackage.mn4
    public final /* synthetic */ boolean X() {
        return qe4.i(this);
    }

    @Override // defpackage.mn4
    public final /* synthetic */ int b() {
        return qe4.c(this);
    }

    @Override // defpackage.mn4
    public final boolean b0() {
        return K(mn4.g0);
    }

    @Override // defpackage.dy1
    public final /* synthetic */ oz0 e() {
        return ha0.a(this);
    }

    @Override // defpackage.mn4
    public final /* synthetic */ boolean e0() {
        return qe4.j(this);
    }

    @Override // defpackage.ka0
    public final void l(ed edVar) {
        this.b.l(edVar);
    }

    @Override // defpackage.zd3
    public final ka0 m() {
        return this.b;
    }

    @Override // defpackage.dy1
    public final int n() {
        return ((Integer) u(dy1.s)).intValue();
    }

    @Override // defpackage.ka0
    public final Object p(pg pgVar, Object obj) {
        return this.b.p(pgVar, obj);
    }

    @Override // defpackage.mn4
    public final /* synthetic */ kn4 r() {
        return qe4.f(this);
    }

    @Override // defpackage.dy1
    public final boolean s() {
        return K(dy1.u);
    }

    @Override // defpackage.ka0
    public final Set t() {
        return this.b.t();
    }

    @Override // defpackage.ka0
    public final Object u(pg pgVar) {
        return this.b.u(pgVar);
    }

    @Override // defpackage.mn4
    public final tt3 v() {
        return (tt3) u(mn4.a0);
    }

    @Override // defpackage.mn4
    public final /* synthetic */ int w() {
        return qe4.e(this);
    }

    @Override // defpackage.mn4
    public final ux x() {
        return (ux) p(mn4.c0, null);
    }

    @Override // defpackage.ka0
    public final Set y(pg pgVar) {
        return this.b.y(pgVar);
    }

    @Override // defpackage.mn4
    public final /* synthetic */ boolean z() {
        return qe4.h(this);
    }
}
