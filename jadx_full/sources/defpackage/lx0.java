package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lx0 {
    public final kn2 a;
    public final kn2 b;

    static {
        Float fValueOf = Float.valueOf(0.0f);
        e03 e03Var = new e03(fValueOf, fValueOf);
        Float fValueOf2 = Float.valueOf(0.5f);
        new lx0(e03Var, new e03(fValueOf2, fValueOf2));
    }

    public lx0(e03... e03VarArr) {
        this.a = new kn2(e03VarArr.length);
        this.b = new kn2(e03VarArr.length);
        int length = e03VarArr.length;
        int i = 0;
        while (true) {
            kn2 kn2Var = this.a;
            if (i >= length) {
                tj4.l0(kn2Var);
                tj4.l0(this.b);
                return;
            } else {
                kn2Var.a(((Number) e03VarArr[i].b).floatValue());
                this.b.a(((Number) e03VarArr[i].f).floatValue());
                i++;
            }
        }
    }
}
