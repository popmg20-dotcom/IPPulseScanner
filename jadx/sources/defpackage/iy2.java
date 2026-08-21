package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class iy2 extends jy2 {
    public final gd2 a;
    public final gd2 b;

    public iy2(gd2 gd2Var, gd2 gd2Var2) {
        this.a = gd2Var;
        this.b = gd2Var2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof iy2)) {
            return false;
        }
        iy2 iy2Var = (iy2) obj;
        return this.a.equals(iy2Var.a) && n12.c(this.b, iy2Var.b);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        gd2 gd2Var = this.b;
        return iHashCode + (gd2Var == null ? 0 : gd2Var.hashCode());
    }

    public final String toString() {
        String str = "PageEvent.LoadStateUpdate (\n                    |   sourceLoadStates: " + this.a + "\n                    ";
        gd2 gd2Var = this.b;
        if (gd2Var != null) {
            str = str + "|   mediatorLoadStates: " + gd2Var + '\n';
        }
        return q44.c0(str.concat("|)"));
    }
}
