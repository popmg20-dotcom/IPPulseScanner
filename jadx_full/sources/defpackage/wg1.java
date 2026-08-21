package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class wg1 implements ag1 {
    public final /* synthetic */ zg3 b;
    public final /* synthetic */ int f;
    public final /* synthetic */ ag1 z;

    public wg1(zg3 zg3Var, int i, ag1 ag1Var) {
        this.b = zg3Var;
        this.f = i;
        this.z = ag1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // defpackage.ag1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(Object obj, ge0 ge0Var) {
        vg1 vg1Var;
        if (ge0Var instanceof vg1) {
            vg1Var = (vg1) ge0Var;
            int i = vg1Var.Y;
            if ((i & Integer.MIN_VALUE) != 0) {
                vg1Var.Y = i - Integer.MIN_VALUE;
            } else {
                vg1Var = new vg1(this, ge0Var);
            }
        }
        Object obj2 = vg1Var.A;
        int i2 = vg1Var.Y;
        xl4 xl4Var = xl4.a;
        if (i2 != 0) {
            if (i2 == 1) {
                n12.S(obj2);
                return xl4Var;
            }
            xe.q("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        n12.S(obj2);
        zg3 zg3Var = this.b;
        int i3 = zg3Var.b;
        if (i3 < this.f) {
            zg3Var.b = i3 + 1;
            return xl4Var;
        }
        vg1Var.Y = 1;
        Object objH = this.z.h(obj, vg1Var);
        mf0 mf0Var = mf0.b;
        return objH == mf0Var ? mf0Var : xl4Var;
    }
}
