package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b21 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ d21 f;

    public /* synthetic */ b21(d21 d21Var, int i) {
        this.b = i;
        this.f = d21Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        d21 d21Var = this.f;
        switch (i) {
            case 0:
                if (System.currentTimeMillis() - d21Var.p >= 3500) {
                    d21Var.a.invalidate();
                }
                break;
            default:
                if (System.currentTimeMillis() - d21Var.o >= 3000) {
                    d21Var.a.invalidate();
                }
                break;
        }
    }
}
