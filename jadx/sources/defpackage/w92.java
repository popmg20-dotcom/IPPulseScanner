package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w92 implements aa2, lf0 {
    public final r92 b;
    public final cf0 f;

    public w92(r92 r92Var, cf0 cf0Var) {
        v32 v32Var;
        cf0Var.getClass();
        this.b = r92Var;
        this.f = cf0Var;
        if (r92Var.b() != q92.b || (v32Var = (v32) cf0Var.Z(pr1.X)) == null) {
            return;
        }
        v32Var.g(null);
    }

    @Override // defpackage.lf0
    public final cf0 I() {
        return this.f;
    }

    @Override // defpackage.aa2
    public final void n(da2 da2Var, p92 p92Var) {
        r92 r92Var = this.b;
        if (r92Var.b().compareTo(q92.b) <= 0) {
            r92Var.c(this);
            v32 v32Var = (v32) this.f.Z(pr1.X);
            if (v32Var != null) {
                v32Var.g(null);
            }
        }
    }
}
