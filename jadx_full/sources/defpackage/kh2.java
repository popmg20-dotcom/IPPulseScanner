package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class kh2 {
    public final String a;
    public final b12 b;

    public kh2(String str, b12 b12Var) {
        this.a = str;
        this.b = b12Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kh2)) {
            return false;
        }
        kh2 kh2Var = (kh2) obj;
        return this.a.equals(kh2Var.a) && this.b.equals(kh2Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "MatchGroup(value=" + this.a + ", range=" + this.b + ')';
    }
}
