package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w21 {
    public final u21 a;
    public final v21 b;
    public final v21 c;
    public final v21 d;

    public w21(u21 u21Var, v21 v21Var, v21 v21Var2, v21 v21Var3) {
        this.a = u21Var;
        this.b = v21Var;
        this.c = v21Var2;
        this.d = v21Var3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w21)) {
            return false;
        }
        w21 w21Var = (w21) obj;
        return this.a.equals(w21Var.a) && this.b.equals(w21Var.b) && this.c.equals(w21Var.c) && this.d.equals(w21Var.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return w21.class.getSimpleName() + ":{animationBackground=" + this.a + ", openAnimation=" + this.b + ", closeAnimation=" + this.c + ", changeAnimation=" + this.d + " }";
    }
}
