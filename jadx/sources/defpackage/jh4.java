package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jh4 implements ii4 {
    public final bk4 b;
    public final boolean f;
    public final t82 z;

    public jh4(t82 t82Var, bk4 bk4Var, boolean z) {
        this.z = t82Var;
        this.b = bk4Var;
        this.f = z;
    }

    @Override // defpackage.ii4
    public final hi4 a(iq1 iq1Var, bk4 bk4Var) {
        bk4 bk4Var2 = this.b;
        if (bk4Var2.equals(bk4Var) || (this.f && bk4Var2.b == bk4Var.a)) {
            return new kh4(this.z, iq1Var, bk4Var, this, true);
        }
        return null;
    }
}
