package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jc5 extends n25 {
    public final /* synthetic */ int e;
    public final /* synthetic */ dd5 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ jc5(dd5 dd5Var, m95 m95Var, int i) {
        super(m95Var);
        this.e = i;
        this.f = dd5Var;
    }

    @Override // defpackage.n25
    public final void a() {
        int i = this.e;
        dd5 dd5Var = this.f;
        switch (i) {
            case 0:
                dd5Var.V0();
                if (dd5Var.m1()) {
                    t65 t65Var = ((k85) dd5Var.f).Y;
                    k85.h(t65Var);
                    t65Var.H0.a("Inactivity, disconnecting from the service");
                    dd5Var.d1();
                    break;
                }
                break;
            default:
                t65 t65Var2 = ((k85) dd5Var.f).Y;
                k85.h(t65Var2);
                t65Var2.C0.a("Tasks have been queued for a long time");
                break;
        }
    }
}
