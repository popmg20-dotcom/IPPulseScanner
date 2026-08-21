package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y64 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ b74 f;

    public /* synthetic */ y64(b74 b74Var, int i) {
        this.b = i;
        this.f = b74Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        b74 b74Var = this.f;
        switch (i) {
            case 0:
                b74Var.a();
                break;
            case 1:
                b74Var.b();
                break;
            default:
                d74 d74Var = b74Var.r;
                if (d74Var != null) {
                    d74Var.s();
                }
                if (b74Var.q == null) {
                    b74Var.p.c();
                }
                b74Var.q = null;
                break;
        }
    }
}
