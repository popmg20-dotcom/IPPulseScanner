package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z64 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ dn0 f;

    public /* synthetic */ z64(dn0 dn0Var, int i) {
        this.b = i;
        this.f = dn0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        dn0 dn0Var = this.f;
        switch (i) {
            case 0:
                dn0Var.a();
                break;
            default:
                dn0Var.b();
                break;
        }
    }
}
