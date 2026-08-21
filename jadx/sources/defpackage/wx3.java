package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wx3 {
    public static final wx3 c;
    public final p95 a;
    public final p95 b;

    static {
        ru0 ru0Var = ru0.n;
        c = new wx3(ru0Var, ru0Var);
    }

    public wx3(p95 p95Var, p95 p95Var2) {
        this.a = p95Var;
        this.b = p95Var2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof wx3)) {
            return false;
        }
        wx3 wx3Var = (wx3) obj;
        return this.a.equals(wx3Var.a) && this.b.equals(wx3Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "Size(width=" + this.a + ", height=" + this.b + ')';
    }
}
