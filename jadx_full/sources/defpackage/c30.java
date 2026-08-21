package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c30 extends b30 {
    public final zf1 A;

    public c30(int i, jp jpVar, cf0 cf0Var, zf1 zf1Var) {
        super(cf0Var, i, jpVar);
        this.A = zf1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006d  */
    @Override // defpackage.b30, defpackage.zf1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(ag1 ag1Var, ge0 ge0Var) {
        int i = this.f;
        mf0 mf0Var = mf0.b;
        if (i == -3) {
            cf0 cf0VarJ = ge0Var.j();
            Boolean bool = Boolean.FALSE;
            dt dtVar = new dt(3);
            cf0 cf0Var = this.b;
            cf0 cf0VarX = !((Boolean) cf0Var.c0(bool, dtVar)).booleanValue() ? cf0VarJ.X(cf0Var) : co4.p(cf0VarJ, cf0Var, false);
            if (n12.c(cf0VarX, cf0VarJ)) {
                Object objH = h(ag1Var, ge0Var);
                if (objH == mf0Var) {
                    return objH;
                }
            } else {
                pr1 pr1Var = pr1.f;
                if (n12.c(cf0VarX.Z(pr1Var), cf0VarJ.Z(pr1Var))) {
                    cf0 cf0VarJ2 = ge0Var.j();
                    if (!(ag1Var instanceof rs3) && !(ag1Var instanceof os2)) {
                        ag1Var = new eg1(ag1Var, cf0VarJ2);
                    }
                    Object objB0 = l72.b0(cf0VarX, ag1Var, nd4.b(cf0VarX), new hj(this, null, 6), ge0Var);
                    if (objB0 == mf0Var) {
                        return objB0;
                    }
                } else {
                    Object objA = super.a(ag1Var, ge0Var);
                    if (objA == mf0Var) {
                        return objA;
                    }
                }
            }
        }
        return xl4.a;
    }

    @Override // defpackage.b30
    public final Object d(q53 q53Var, ge0 ge0Var) {
        Object objH = h(new rs3(q53Var), ge0Var);
        return objH == mf0.b ? objH : xl4.a;
    }

    public abstract Object h(ag1 ag1Var, ge0 ge0Var);

    @Override // defpackage.b30
    public final String toString() {
        return this.A + " -> " + super.toString();
    }
}
