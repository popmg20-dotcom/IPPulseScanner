package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ds4 implements mz {
    public final es4 A;
    public final mz b;
    public final fs4 f;
    public final gs4 z;

    public ds4(mz mzVar, es4 es4Var, e04 e04Var) {
        this.b = mzVar;
        this.A = es4Var;
        this.f = new fs4(6, mzVar.h());
        this.z = new gs4(mzVar.r());
    }

    @Override // defpackage.mz
    public final eu2 a() {
        return this.b.a();
    }

    @Override // defpackage.mz, defpackage.wx
    public final kz b() {
        return this.z;
    }

    @Override // defpackage.wx
    public final xy d() {
        return this.f;
    }

    @Override // defpackage.hn4
    public final void e(in4 in4Var) {
        co4.h();
        this.A.e(in4Var);
    }

    @Override // defpackage.mz
    public final boolean f() {
        return ((ui1) b()).i() == 0;
    }

    @Override // defpackage.hn4
    public final void g(in4 in4Var) {
        co4.h();
        this.A.g(in4Var);
    }

    @Override // defpackage.mz
    public final xy h() {
        return this.f;
    }

    @Override // defpackage.mz
    public final uy i() {
        return wy.a;
    }

    @Override // defpackage.hn4
    public final void j(in4 in4Var) {
        co4.h();
        this.A.j(in4Var);
    }

    @Override // defpackage.mz
    public final void l(ArrayList arrayList) {
        throw new UnsupportedOperationException("Operation not supported by VirtualCamera.");
    }

    @Override // defpackage.mz
    public final void m(ArrayList arrayList) {
        throw new UnsupportedOperationException("Operation not supported by VirtualCamera.");
    }

    @Override // defpackage.hn4
    public final void n(in4 in4Var) {
        co4.h();
        this.A.n(in4Var);
    }

    @Override // defpackage.mz
    public final boolean p() {
        return false;
    }

    @Override // defpackage.mz
    public final kz r() {
        return this.z;
    }

    @Override // defpackage.mz
    public final nc2 release() {
        throw new UnsupportedOperationException("Operation not supported by VirtualCamera.");
    }

    @Override // defpackage.mz
    public final void o() {
    }

    @Override // defpackage.mz
    public final void c(uy uyVar) {
    }

    @Override // defpackage.mz
    public final void k(boolean z) {
    }

    @Override // defpackage.mz
    public final void q(boolean z) {
    }
}
