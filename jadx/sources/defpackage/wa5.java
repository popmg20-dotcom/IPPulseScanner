package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wa5 implements Runnable {
    public final /* synthetic */ boolean A;
    public final /* synthetic */ ib5 X;
    public final /* synthetic */ int b;
    public final /* synthetic */ t95 f;
    public final /* synthetic */ long z;

    public /* synthetic */ wa5(ib5 ib5Var, t95 t95Var, long j, boolean z, int i) {
        this.b = i;
        this.f = t95Var;
        this.z = j;
        this.A = z;
        this.X = ib5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        long j = this.z;
        boolean z = this.A;
        t95 t95Var = this.f;
        ib5 ib5Var = this.X;
        switch (i) {
            case 0:
                ib5Var.Z0(t95Var);
                ib5Var.l1(t95Var, j, z);
                break;
            default:
                ib5Var.Z0(t95Var);
                ib5Var.l1(t95Var, j, z);
                break;
        }
    }
}
