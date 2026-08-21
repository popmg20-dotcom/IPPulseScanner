package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ms1 implements am1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ os1 f;
    public final /* synthetic */ ls1 z;

    public /* synthetic */ ms1(os1 os1Var, ls1 ls1Var, int i) {
        this.b = i;
        this.f = os1Var;
        this.z = ls1Var;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        int i = this.b;
        xl4 xl4Var = xl4.a;
        ls1 ls1Var = this.z;
        os1 os1Var = this.f;
        go3 go3Var = (go3) obj;
        switch (i) {
            case 0:
                go3Var.getClass();
                os1Var.b.J(go3Var, ls1Var);
                break;
            default:
                go3Var.getClass();
                os1Var.c.A(go3Var, ls1Var);
                break;
        }
        return xl4Var;
    }
}
