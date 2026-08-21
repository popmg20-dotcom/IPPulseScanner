package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wc2 extends xc2 implements aa2 {
    public final da2 X;
    public final /* synthetic */ yc2 Y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wc2(yc2 yc2Var, da2 da2Var, hu2 hu2Var) {
        super(yc2Var, hu2Var);
        this.Y = yc2Var;
        this.X = da2Var;
    }

    @Override // defpackage.xc2
    public final void b() {
        this.X.getLifecycle().c(this);
    }

    @Override // defpackage.xc2
    public final boolean c(da2 da2Var) {
        return this.X == da2Var;
    }

    @Override // defpackage.xc2
    public final boolean d() {
        return this.X.getLifecycle().b().compareTo(q92.A) >= 0;
    }

    @Override // defpackage.aa2
    public final void n(da2 da2Var, p92 p92Var) {
        da2 da2Var2 = this.X;
        q92 q92VarB = da2Var2.getLifecycle().b();
        if (q92VarB == q92.b) {
            this.Y.j(this.b);
            return;
        }
        q92 q92Var = null;
        while (q92Var != q92VarB) {
            a(d());
            q92Var = q92VarB;
            q92VarB = da2Var2.getLifecycle().b();
        }
    }
}
