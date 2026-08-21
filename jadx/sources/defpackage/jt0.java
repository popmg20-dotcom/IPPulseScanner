package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jt0 extends it0 {
    public final lt0 A;
    public final rr0 f;
    public final String z;

    public jt0(rr0 rr0Var, lt0 lt0Var) throws xs0 {
        this.f = rr0Var;
        this.A = lt0Var;
        this.z = lt0Var.z + '.' + rr0Var.J();
        lt0Var.A.z0.e(this);
    }

    @Override // defpackage.it0
    public final gt0 c() {
        return this.A.A;
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
        return this.f.J();
    }

    @Override // defpackage.it0
    public final c1 h() {
        return this.f;
    }
}
