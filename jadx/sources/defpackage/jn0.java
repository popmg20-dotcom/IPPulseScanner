package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jn0 {
    public final qg4 a;

    public jn0(qg4 qg4Var) {
        this.a = qg4Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof jn0) && n12.c(this.a, ((jn0) obj).a);
    }

    public final int hashCode() {
        qg4 qg4Var = this.a;
        return (qg4Var != null ? qg4Var.hashCode() : 0) * 1742810335;
    }
}
