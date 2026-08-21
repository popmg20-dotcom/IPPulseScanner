package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class lb2 extends p95 {
    public final j50 n;
    public final Object o;
    public final p95 p;

    public lb2(j50 j50Var, Object obj, p95 p95Var) {
        obj.getClass();
        p95Var.getClass();
        this.n = j50Var;
        this.o = obj;
        this.p = p95Var;
    }

    @Override // defpackage.p95
    public final p95 A(j50 j50Var, Object obj) {
        j50 j50Var2 = this.n;
        boolean zEquals = j50Var.equals(j50Var2);
        p95 p95Var = this.p;
        if (!zEquals) {
            p95 p95VarA = p95Var.A(j50Var, null);
            if (p95VarA != p95Var) {
                this = new lb2(j50Var2, this.o, p95VarA);
            }
            p95Var = this;
        }
        return obj != null ? new lb2(j50Var, obj, p95Var) : p95Var;
    }

    public final String toString() {
        return d70.j0(d70.s0(ws3.V(new go1(new fn(23, this), new ji(17), 0))), null, "{", "}", new ji(18), 25);
    }
}
