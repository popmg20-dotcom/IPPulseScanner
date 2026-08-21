package defpackage;

import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class k81 {
    public final hi0 a;
    public final hi0 b;
    public final se1 c;

    public k81(hi0 hi0Var, hi0 hi0Var2, se1 se1Var) {
        this.a = hi0Var;
        this.b = hi0Var2;
        this.c = se1Var;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof k81)) {
            return false;
        }
        k81 k81Var = (k81) obj;
        return Objects.equals(this.a, k81Var.a) && Objects.equals(this.b, k81Var.b) && Objects.equals(this.c, k81Var.c);
    }

    public final int hashCode() {
        return Objects.hashCode(this.c) ^ (Objects.hashCode(this.a) ^ Objects.hashCode(this.b));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.a);
        sb.append(" , ");
        sb.append(this.b);
        sb.append(" : ");
        se1 se1Var = this.c;
        sb.append(se1Var == null ? "null" : Integer.valueOf(se1Var.a));
        sb.append(" ]");
        return sb.toString();
    }
}
