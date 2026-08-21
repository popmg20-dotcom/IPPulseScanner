package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class x64 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ c74 f;

    public /* synthetic */ x64(c74 c74Var, int i) {
        this.b = i;
        this.f = c74Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        c74 c74Var = this.f;
        switch (i) {
            case 0:
                ((xq1) vf2.q()).execute(new x64(c74Var, 1));
                break;
            default:
                if (!c74Var.n) {
                    c74Var.d();
                }
                break;
        }
    }
}
