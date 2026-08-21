package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cr1 {
    public final yo a;
    public final br1 b;
    public final th1 c;

    public cr1(yo yoVar, br1 br1Var, th1 th1Var) {
        this.a = yoVar;
        this.b = br1Var;
        this.c = th1Var;
        if (yoVar.b() == 0 && yoVar.a() == 0) {
            xe.k("Bounds must be non zero");
            throw null;
        }
        if (yoVar.a == 0 || yoVar.b == 0) {
            return;
        }
        xe.k("Bounding rectangle must start at the top or left window edge for folding features");
        throw null;
    }

    public final boolean a() {
        br1 br1Var = br1.A;
        br1 br1Var2 = this.b;
        return br1Var2 == br1Var || (br1Var2 == br1.z && this.c == th1.A);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (cr1.class.equals(obj != null ? obj.getClass() : null)) {
            obj.getClass();
            cr1 cr1Var = (cr1) obj;
            return this.a.equals(cr1Var.a) && this.b == cr1Var.b && this.c == cr1Var.c;
        }
        return false;
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return cr1.class.getSimpleName() + " { " + this.a + ", type=" + this.b + ", state=" + this.c + " }";
    }
}
