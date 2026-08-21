package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class xn2 implements y00, xs4 {
    public final z00 b;
    public final /* synthetic */ yn2 f;

    public xn2(yn2 yn2Var, z00 z00Var) {
        this.f = yn2Var;
        this.b = z00Var;
    }

    @Override // defpackage.xs4
    public final void a(sr3 sr3Var, int i) {
        this.b.a(sr3Var, i);
    }

    @Override // defpackage.ge0
    public final void d(Object obj) {
        this.b.d(obj);
    }

    @Override // defpackage.y00
    public final br1 f(Object obj, em1 em1Var) {
        yn2 yn2Var = this.f;
        op opVar = new op(yn2Var, this);
        br1 br1VarH = this.b.H((xl4) obj, opVar);
        if (br1VarH != null) {
            yn2.z0.set(yn2Var, null);
        }
        return br1VarH;
    }

    @Override // defpackage.ge0
    public final cf0 j() {
        return this.b.X;
    }

    @Override // defpackage.y00
    public final void l(Object obj, em1 em1Var) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = yn2.z0;
        yn2 yn2Var = this.f;
        atomicReferenceFieldUpdater.set(yn2Var, null);
        f0 f0Var = new f0(yn2Var, this);
        z00 z00Var = this.b;
        z00Var.E(xl4.a, z00Var.z, new op(1, f0Var));
    }

    @Override // defpackage.y00
    public final void m(Object obj) {
        this.b.m(obj);
    }
}
