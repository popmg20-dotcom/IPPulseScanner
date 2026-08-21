package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r23 extends p23 {
    public final am1 b;

    public r23(j50 j50Var, am1 am1Var) {
        super(j50Var);
        this.b = am1Var;
    }

    @Override // defpackage.p23
    public final boolean a(Object obj, Object obj2) {
        return ((Boolean) this.b.g(obj2)).booleanValue();
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return this.b.toString();
    }
}
