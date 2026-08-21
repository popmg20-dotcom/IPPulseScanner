package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n04 {
    public static final /* synthetic */ int e = 0;
    public final m04 a;
    public final k04 b;
    public final w21 c;
    public final kw0 d;

    public n04(m04 m04Var, k04 k04Var, w21 w21Var, kw0 kw0Var) {
        this.a = m04Var;
        this.b = k04Var;
        this.c = w21Var;
        this.d = kw0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n04)) {
            return false;
        }
        n04 n04Var = (n04) obj;
        return n12.c(this.a, n04Var.a) && n12.c(this.b, n04Var.b) && n12.c(this.c, n04Var.c) && n12.c(this.d, n04Var.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return n04.class.getSimpleName() + ":{splitType=" + this.a + ", layoutDir=" + this.b + ", animationParams=" + this.c + ", dividerAttributes=" + this.d + " }";
    }
}
