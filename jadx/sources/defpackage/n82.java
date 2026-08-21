package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n82 implements Comparable {
    public static final n82 f = new n82();
    public final int b = 131850;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        n82 n82Var = (n82) obj;
        n82Var.getClass();
        return this.b - n82Var.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        n82 n82Var = obj instanceof n82 ? (n82) obj : null;
        return n82Var != null && this.b == n82Var.b;
    }

    public final int hashCode() {
        return this.b;
    }

    public final String toString() {
        return "2.3.10";
    }
}
