package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gw4 implements aa2 {
    public final /* synthetic */ pl1 A;
    public final /* synthetic */ q92 b;
    public final /* synthetic */ r92 f;
    public final /* synthetic */ z00 z;

    public gw4(q92 q92Var, r92 r92Var, z00 z00Var, pl1 pl1Var) {
        this.b = q92Var;
        this.f = r92Var;
        this.z = z00Var;
        this.A = pl1Var;
    }

    @Override // defpackage.aa2
    public final void n(da2 da2Var, p92 p92Var) {
        Object tk3Var;
        p92.Companion.getClass();
        int iOrdinal = this.b.ordinal();
        p92 p92Var2 = iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? null : p92.ON_RESUME : p92.ON_START : p92.ON_CREATE;
        z00 z00Var = this.z;
        r92 r92Var = this.f;
        if (p92Var != p92Var2) {
            if (p92Var == p92.ON_DESTROY) {
                r92Var.c(this);
                z00Var.d(new tk3(new x92(null)));
                return;
            }
            return;
        }
        r92Var.c(this);
        try {
            tk3Var = this.A.a();
        } catch (Throwable th) {
            tk3Var = new tk3(th);
        }
        z00Var.d(tk3Var);
    }
}
