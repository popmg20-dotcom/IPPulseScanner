package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ic0 {
    public static final String a = ue2.i("ConstraintTrkngWrkr");

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object a(m20 m20Var, gx4 gx4Var, ie0 ie0Var) {
        hc0 hc0Var;
        if (ie0Var instanceof hc0) {
            hc0Var = (hc0) ie0Var;
            int i = hc0Var.X;
            if ((i & Integer.MIN_VALUE) != 0) {
                hc0Var.X = i - Integer.MIN_VALUE;
            } else {
                hc0Var = new hc0(ie0Var);
            }
        }
        Object objO = hc0Var.A;
        int i2 = hc0Var.X;
        ge0 ge0Var = null;
        int i3 = 1;
        if (i2 == 0) {
            n12.S(objO);
            av avVar = new av(2, new pg1(m20Var.b(gx4Var), new gt(gx4Var, ge0Var, i3), 2));
            hc0Var.X = 1;
            objO = ye.o(avVar, hc0Var);
            mf0 mf0Var = mf0.b;
            if (objO == mf0Var) {
                return mf0Var;
            }
        } else {
            if (i2 != 1) {
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            n12.S(objO);
        }
        return new Integer(((pc0) objO).a);
    }
}
