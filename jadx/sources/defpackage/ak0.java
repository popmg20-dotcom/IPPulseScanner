package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ak0 extends r82 implements pl1 {
    public final /* synthetic */ int f;
    public final /* synthetic */ ck0 z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ak0(ck0 ck0Var, int i) {
        super(0);
        this.f = i;
        this.z = ck0Var;
    }

    @Override // defpackage.pl1
    public final Object a() {
        int i = this.f;
        ck0 ck0Var = this.z;
        switch (i) {
            case 0:
                v92 v92Var = new v92(15);
                v92Var.m("DELETE", ej3.a);
                v92Var.b = ck0Var.c;
                return new le3(ck0Var.a, new cm2(v92Var)).e();
            default:
                v92 v92Var2 = new v92(15);
                v92Var2.m("GET", null);
                v92Var2.b = ck0Var.c;
                v92Var2.l("Accept", "*/*");
                return new le3(ck0Var.a, new cm2(v92Var2)).e();
        }
    }
}
