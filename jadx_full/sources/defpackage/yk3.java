package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class yk3 extends y32 {
    public final a42 X;

    public yk3(a42 a42Var) {
        this.X = a42Var;
    }

    @Override // defpackage.y32
    public final boolean l() {
        return false;
    }

    @Override // defpackage.y32
    public final void m(Throwable th) {
        Object objH = k().H();
        boolean z = objH instanceof r80;
        a42 a42Var = this.X;
        if (z) {
            a42Var.d(n12.r(((r80) objH).a));
        } else {
            a42Var.d(f42.a(objH));
        }
    }
}
