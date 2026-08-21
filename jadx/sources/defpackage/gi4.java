package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gi4 extends hi4 {
    public final /* synthetic */ hi4 a;

    public gi4(hi4 hi4Var) {
        this.a = hi4Var;
    }

    @Override // defpackage.hi4
    public final Object b(r62 r62Var) {
        if (r62Var.X() != 9) {
            return this.a.b(r62Var);
        }
        r62Var.N();
        return null;
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) {
        if (obj == null) {
            v72Var.C();
        } else {
            this.a.c(v72Var, obj);
        }
    }

    public final String toString() {
        return "NullSafeTypeAdapter[" + this.a + "]";
    }
}
