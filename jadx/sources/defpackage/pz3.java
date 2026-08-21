package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pz3 extends dd1 {
    public final j62 a;
    public final String b;
    public final pi0 c;

    public pz3(j62 j62Var, String str, pi0 pi0Var) {
        this.a = j62Var;
        this.b = str;
        this.c = pi0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof pz3)) {
            return false;
        }
        pz3 pz3Var = (pz3) obj;
        return this.a.equals(pz3Var.a) && n12.c(this.b, pz3Var.b) && this.c == pz3Var.c;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        return this.c.hashCode() + ((iHashCode + (str != null ? str.hashCode() : 0)) * 31);
    }
}
