package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class hq1 extends ct3 {
    public hi4 a = null;

    @Override // defpackage.hi4
    public final Object b(r62 r62Var) {
        hi4 hi4Var = this.a;
        if (hi4Var != null) {
            return hi4Var.b(r62Var);
        }
        xe.q("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        return null;
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) {
        hi4 hi4Var = this.a;
        if (hi4Var != null) {
            hi4Var.c(v72Var, obj);
        } else {
            xe.q("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }
    }

    @Override // defpackage.ct3
    public final hi4 d() {
        hi4 hi4Var = this.a;
        if (hi4Var != null) {
            return hi4Var;
        }
        xe.q("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        return null;
    }
}
