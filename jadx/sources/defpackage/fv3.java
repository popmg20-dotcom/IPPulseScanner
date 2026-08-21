package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class fv3 implements zv0 {
    public final z00 A;
    public final hv3 b;
    public final long f;
    public final Object z;

    public fv3(hv3 hv3Var, long j, Object obj, z00 z00Var) {
        this.b = hv3Var;
        this.f = j;
        this.z = obj;
        this.A = z00Var;
    }

    @Override // defpackage.zv0
    public final void c() {
        hv3 hv3Var = this.b;
        synchronized (hv3Var) {
            if (this.f < hv3Var.n()) {
                return;
            }
            Object[] objArr = hv3Var.y0;
            objArr.getClass();
            long j = this.f;
            if (objArr[((int) j) & (objArr.length - 1)] != this) {
                return;
            }
            iv3.d(objArr, j, iv3.a);
            hv3Var.i();
        }
    }
}
