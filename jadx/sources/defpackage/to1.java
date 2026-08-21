package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class to1 implements l83 {
    public static final k83 b = new k83("DAV:", "getcontenttype");
    public final pj2 a;

    public to1(pj2 pj2Var) {
        this.a = pj2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof to1) && n12.c(this.a, ((to1) obj).a);
    }

    public final int hashCode() {
        pj2 pj2Var = this.a;
        if (pj2Var == null) {
            return 0;
        }
        return pj2Var.a.hashCode();
    }

    public final String toString() {
        return "GetContentType(type=" + this.a + ')';
    }
}
