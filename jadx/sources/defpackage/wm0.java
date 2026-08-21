package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class wm0 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ j74 f;

    public /* synthetic */ wm0(j74 j74Var, int i) {
        this.b = i;
        this.f = j74Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        j74 j74Var = this.f;
        switch (i) {
            case 0:
                j74Var.c();
                break;
            default:
                j74Var.f.cancel(true);
                break;
        }
    }
}
