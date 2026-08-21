package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ck4 extends b72 implements ee0 {
    public final zj4 b;
    public final b72 f;

    public ck4(zj4 zj4Var, b72 b72Var) {
        this.b = zj4Var;
        this.f = b72Var;
    }

    @Override // defpackage.ee0
    public final b72 a(gt3 gt3Var, nm nmVar) {
        b72 b72Var = this.f;
        b72 b72VarV = b72Var instanceof ee0 ? gt3Var.v(b72Var, nmVar) : b72Var;
        return b72VarV == b72Var ? this : new ck4(this.b, b72VarV);
    }

    @Override // defpackage.b72
    public final Class b() {
        return Object.class;
    }

    @Override // defpackage.b72
    public final void e(Object obj, i52 i52Var, gt3 gt3Var) {
        this.f.f(obj, i52Var, gt3Var, this.b);
    }

    @Override // defpackage.b72
    public final void f(Object obj, i52 i52Var, gt3 gt3Var, zj4 zj4Var) {
        this.f.f(obj, i52Var, gt3Var, zj4Var);
    }
}
