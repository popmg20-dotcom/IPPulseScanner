package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ix4 implements am1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ jx4 f;
    public final /* synthetic */ gx4 z;

    public /* synthetic */ ix4(jx4 jx4Var, gx4 gx4Var, int i) {
        this.b = i;
        this.f = jx4Var;
        this.z = gx4Var;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        int i = this.b;
        xl4 xl4Var = xl4.a;
        gx4 gx4Var = this.z;
        jx4 jx4Var = this.f;
        go3 go3Var = (go3) obj;
        switch (i) {
            case 0:
                go3Var.getClass();
                jx4Var.b.J(go3Var, gx4Var);
                break;
            default:
                go3Var.getClass();
                jx4Var.c.A(go3Var, gx4Var);
                break;
        }
        return xl4Var;
    }
}
