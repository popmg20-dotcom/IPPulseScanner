package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class d30 extends c30 {
    public d30(zf1 zf1Var, cf0 cf0Var, int i, jp jpVar, int i2) {
        super((i2 & 4) != 0 ? -3 : i, (i2 & 8) != 0 ? jp.b : jpVar, (i2 & 2) != 0 ? c41.b : cf0Var, zf1Var);
    }

    @Override // defpackage.b30
    public final b30 e(cf0 cf0Var, int i, jp jpVar) {
        return new d30(i, jpVar, cf0Var, this.A);
    }

    @Override // defpackage.b30
    public final zf1 f() {
        return this.A;
    }

    @Override // defpackage.c30
    public final Object h(ag1 ag1Var, ge0 ge0Var) {
        Object objA = this.A.a(ag1Var, ge0Var);
        return objA == mf0.b ? objA : xl4.a;
    }
}
