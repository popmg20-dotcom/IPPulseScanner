package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zc2 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ n02 f;

    public /* synthetic */ zc2(n02 n02Var, int i) {
        this.b = i;
        this.f = n02Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        n02 n02Var = this.f;
        switch (i) {
            case 0:
                zn znVar = (zn) n02Var.A;
                if (znVar != null) {
                    ((on2) n02Var.f).j(znVar);
                }
                break;
            default:
                zn znVar2 = (zn) n02Var.A;
                if (znVar2 == null) {
                    znVar2 = new zn(3, n02Var);
                    n02Var.A = znVar2;
                }
                ((on2) n02Var.f).f(znVar2);
                break;
        }
    }
}
