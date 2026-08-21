package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z50 implements AutoCloseable, lf0 {
    public final cf0 b;

    public z50(cf0 cf0Var) {
        cf0Var.getClass();
        this.b = cf0Var;
    }

    @Override // defpackage.lf0
    public final cf0 I() {
        return this.b;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        v32 v32Var = (v32) this.b.Z(pr1.X);
        if (v32Var != null) {
            v32Var.g(null);
        }
    }
}
