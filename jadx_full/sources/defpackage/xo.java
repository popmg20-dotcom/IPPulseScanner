package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xo {
    public final cn a;
    public final xk3 b;
    public final xk3 c;
    public final xk3 d;
    public final xk3 e;
    public final int f;
    public final int g;
    public final int h;
    public final int i;

    public xo(cn cnVar, xk3 xk3Var, xk3 xk3Var2, xk3 xk3Var3, xk3 xk3Var4) throws qs2 {
        boolean z = xk3Var == null || xk3Var2 == null;
        boolean z2 = xk3Var3 == null || xk3Var4 == null;
        if (z && z2) {
            throw qs2.a();
        }
        if (z) {
            xk3Var = new xk3(0.0f, xk3Var3.b);
            xk3Var2 = new xk3(0.0f, xk3Var4.b);
        } else if (z2) {
            int i = cnVar.b;
            xk3Var3 = new xk3(i - 1, xk3Var.b);
            xk3Var4 = new xk3(i - 1, xk3Var2.b);
        }
        this.a = cnVar;
        this.b = xk3Var;
        this.c = xk3Var2;
        this.d = xk3Var3;
        this.e = xk3Var4;
        this.f = (int) Math.min(xk3Var.a, xk3Var2.a);
        this.g = (int) Math.max(xk3Var3.a, xk3Var4.a);
        this.h = (int) Math.min(xk3Var.b, xk3Var3.b);
        this.i = (int) Math.max(xk3Var2.b, xk3Var4.b);
    }

    public xo(xo xoVar) {
        this.a = xoVar.a;
        this.b = xoVar.b;
        this.c = xoVar.c;
        this.d = xoVar.d;
        this.e = xoVar.e;
        this.f = xoVar.f;
        this.g = xoVar.g;
        this.h = xoVar.h;
        this.i = xoVar.i;
    }
}
