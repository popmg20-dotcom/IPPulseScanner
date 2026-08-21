package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ms2 implements ug4 {
    public final ty1 a;
    public final sy1 b;

    public ms2(ty1 ty1Var, sy1 sy1Var) {
        this.a = ty1Var;
        this.b = sy1Var;
    }

    @Override // defpackage.ug4
    public final void a() {
        sy1 sy1Var = this.b;
        boolean z = sy1Var instanceof l54;
        ty1 ty1Var = this.a;
        if (z) {
            ty1Var.b(((l54) sy1Var).a);
        } else if (sy1Var instanceof w51) {
            ty1Var.b(((w51) sy1Var).a);
        } else {
            g.d();
        }
    }
}
