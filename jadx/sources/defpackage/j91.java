package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j91 {
    public final ws0 a;
    public final int b;

    public j91(ws0 ws0Var, int i) {
        this.a = ws0Var;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j91)) {
            return false;
        }
        j91 j91Var = (j91) obj;
        return this.a == j91Var.a && this.b == j91Var.b;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 65535) + this.b;
    }
}
