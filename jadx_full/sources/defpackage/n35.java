package defpackage;

import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n35 implements Runnable {
    public final /* synthetic */ int b = 0;
    public final /* synthetic */ long f;
    public final /* synthetic */ z45 z;

    public n35(d45 d45Var, long j) {
        this.f = j;
        Objects.requireNonNull(d45Var);
        this.z = d45Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        long j = this.f;
        z45 z45Var = this.z;
        switch (i) {
            case 0:
                ((d45) z45Var).b1(j);
                break;
            default:
                yb5 yb5Var = (yb5) z45Var;
                d45 d45Var = ((k85) yb5Var.f).E0;
                k85.e(d45Var);
                d45Var.Y0(j);
                yb5Var.y0 = null;
                break;
        }
    }

    public n35(yb5 yb5Var, long j) {
        this.f = j;
        Objects.requireNonNull(yb5Var);
        this.z = yb5Var;
    }
}
