package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o34 implements Runnable {
    public final int A;
    public final n53 b;
    public final h24 f;
    public final boolean z;

    public o34(n53 n53Var, h24 h24Var, boolean z, int i) {
        n53Var.getClass();
        h24Var.getClass();
        this.b = n53Var;
        this.f = h24Var;
        this.z = z;
        this.A = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zH;
        yx4 yx4VarB;
        boolean z = this.z;
        n53 n53Var = this.b;
        h24 h24Var = this.f;
        if (z) {
            int i = this.A;
            n53Var.getClass();
            String str = h24Var.a.a;
            synchronized (n53Var.k) {
                yx4VarB = n53Var.b(str);
            }
            zH = n53.e(str, yx4VarB, i);
        } else {
            zH = n53Var.h(h24Var, this.A);
        }
        ue2.g().a(ue2.i("StopWorkRunnable"), "StopWorkRunnable for " + this.f.a.a + "; Processor.stopWork = " + zH);
    }
}
