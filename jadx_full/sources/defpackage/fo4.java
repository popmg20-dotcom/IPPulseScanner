package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fo4 extends p95 {
    public final Object n;
    public final String o;
    public final uo4 p;
    public final d7 q;

    public fo4(Object obj, String str, uo4 uo4Var, d7 d7Var) {
        this.n = obj;
        this.o = str;
        this.p = uo4Var;
        this.q = d7Var;
    }

    @Override // defpackage.p95
    public final p95 B(String str, am1 am1Var) {
        Object obj = this.n;
        if (((Boolean) am1Var.g(obj)).booleanValue()) {
            return this;
        }
        return new db1(obj, this.o, str, this.q, this.p);
    }

    @Override // defpackage.p95
    public final Object g() {
        return this.n;
    }
}
