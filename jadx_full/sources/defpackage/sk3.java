package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class sk3 extends kk implements lm1 {
    public sk3(ge0 ge0Var) {
        super(ge0Var);
        if (ge0Var == null || ge0Var.j() == c41.b) {
            return;
        }
        xe.k("Coroutines with restricted suspension must have EmptyCoroutineContext");
        throw null;
    }

    @Override // defpackage.lm1
    public final int b() {
        return 2;
    }

    @Override // defpackage.ge0
    public final cf0 j() {
        return c41.b;
    }

    @Override // defpackage.kk
    public final String toString() {
        if (this.b != null) {
            return super.toString();
        }
        dh3.a.getClass();
        return eh3.a(this);
    }
}
