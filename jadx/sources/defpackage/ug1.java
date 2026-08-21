package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ug1 implements zf1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ int f;
    public final /* synthetic */ zf1 z;

    public /* synthetic */ ug1(zf1 zf1Var, int i, int i2) {
        this.b = i2;
        this.z = zf1Var;
        this.f = i;
    }

    @Override // defpackage.zf1
    public final Object a(ag1 ag1Var, ge0 ge0Var) {
        int i = this.b;
        xl4 xl4Var = xl4.a;
        mf0 mf0Var = mf0.b;
        int i2 = this.f;
        zf1 zf1Var = this.z;
        switch (i) {
            case 0:
                Object objA = zf1Var.a(new wg1(new zg3(), i2, ag1Var), ge0Var);
                return objA == mf0Var ? objA : xl4Var;
            default:
                Object objA2 = ((ug1) zf1Var).a(new x70(i2, 1, ag1Var), ge0Var);
                return objA2 == mf0Var ? objA2 : xl4Var;
        }
    }
}
