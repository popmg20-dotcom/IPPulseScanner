package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zj4 {
    public abstract zj4 a(nm nmVar);

    public abstract String b();

    public abstract j72 c();

    public final e10 d(Object obj, g72 g72Var) {
        e10 e10Var = new e10(obj, g72Var);
        int iOrdinal = c().ordinal();
        if (iOrdinal == 0) {
            e10Var.b = 3;
            e10Var.Y = b();
            return e10Var;
        }
        if (iOrdinal == 1) {
            e10Var.b = 2;
            return e10Var;
        }
        if (iOrdinal == 2) {
            e10Var.b = 1;
            return e10Var;
        }
        if (iOrdinal == 3) {
            e10Var.b = 5;
            e10Var.Y = b();
            return e10Var;
        }
        if (iOrdinal == 4) {
            e10Var.b = 4;
            e10Var.Y = b();
            return e10Var;
        }
        int i = zo4.a;
        zo2.w("Internal error: this code path should never get executed");
        return null;
    }

    public abstract e10 e(i52 i52Var, e10 e10Var);

    public abstract e10 f(i52 i52Var, e10 e10Var);
}
