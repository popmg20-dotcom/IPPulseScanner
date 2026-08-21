package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class jv3 extends b2 {
    public long a;
    public z00 b;

    @Override // defpackage.b2
    public final boolean a(a2 a2Var) {
        hv3 hv3Var = (hv3) a2Var;
        if (this.a >= 0) {
            return false;
        }
        long j = hv3Var.z0;
        if (j < hv3Var.A0) {
            hv3Var.A0 = j;
        }
        this.a = j;
        return true;
    }

    @Override // defpackage.b2
    public final ge0[] b(a2 a2Var) {
        long j = this.a;
        this.a = -1L;
        this.b = null;
        return ((hv3) a2Var).u(j);
    }
}
