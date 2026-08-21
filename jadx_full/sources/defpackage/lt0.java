package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lt0 extends it0 {
    public final gt0 A;
    public final jt0[] X;
    public final es0 f;
    public final String z;

    public lt0(es0 es0Var, gt0 gt0Var) throws xs0 {
        this.f = es0Var;
        this.z = mt0.b(gt0Var, null, es0Var.H());
        this.A = gt0Var;
        this.X = new jt0[es0Var.Z.size()];
        for (int i = 0; i < es0Var.Z.size(); i++) {
            this.X[i] = new jt0((rr0) es0Var.Z.get(i), this);
        }
        gt0Var.z0.e(this);
    }

    @Override // defpackage.it0
    public final gt0 c() {
        return this.A;
    }

    @Override // defpackage.it0
    public final String d() {
        return this.z;
    }

    @Override // defpackage.it0
    public final it0 e() {
        return this.A;
    }

    @Override // defpackage.it0
    public final String getName() {
        return this.f.H();
    }

    @Override // defpackage.it0
    public final c1 h() {
        return this.f;
    }
}
