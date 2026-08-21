package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class h30 extends c30 {
    public final em1 X;

    public h30(em1 em1Var, zf1 zf1Var, cf0 cf0Var, int i, jp jpVar) {
        super(i, jpVar, cf0Var, zf1Var);
        this.X = em1Var;
    }

    @Override // defpackage.b30
    public final b30 e(cf0 cf0Var, int i, jp jpVar) {
        return new h30(this.X, this.A, cf0Var, i, jpVar);
    }

    @Override // defpackage.c30
    public final Object h(ag1 ag1Var, ge0 ge0Var) {
        Object objH = p95.h(new e30(this, ag1Var, null), ge0Var);
        return objH == mf0.b ? objH : xl4.a;
    }
}
