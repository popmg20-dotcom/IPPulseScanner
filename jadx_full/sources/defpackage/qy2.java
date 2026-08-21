package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qy2 extends v74 implements em1 {
    public yn2 A0;
    public int B0;
    public int X;
    public /* synthetic */ ag1 Y;
    public /* synthetic */ Object Z;
    public final /* synthetic */ az2 y0;
    public final /* synthetic */ hd2 z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qy2(ge0 ge0Var, az2 az2Var, hd2 hd2Var) {
        super(3, ge0Var);
        this.y0 = az2Var;
        this.z0 = hd2Var;
    }

    @Override // defpackage.em1
    public final Object e(Object obj, Object obj2, Object obj3) {
        qy2 qy2Var = new qy2((ge0) obj3, this.y0, this.z0);
        qy2Var.Y = (ag1) obj;
        qy2Var.Z = obj2;
        return qy2Var.p(xl4.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bd, code lost:
    
        if (defpackage.r25.v(r9, r0, r11) == r6) goto L34;
     */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Object obj) {
        ag1 ag1Var;
        int iIntValue;
        bz2 bz2Var;
        yn2 yn2Var;
        hv3 hv3Var;
        zf1 ug1Var;
        hd2 hd2Var = this.z0;
        int i = this.X;
        az2 az2Var = this.y0;
        mf0 mf0Var = mf0.b;
        try {
            if (i == 0) {
                n12.S(obj);
                ag1Var = this.Y;
                iIntValue = ((Number) this.Z).intValue();
                bz2Var = az2Var.h;
                yn2Var = bz2Var.a;
                this.Y = ag1Var;
                this.Z = bz2Var;
                this.A0 = yn2Var;
                this.B0 = iIntValue;
                this.X = 1;
                if (yn2Var.g(this) != mf0Var) {
                }
                return mf0Var;
            }
            if (i != 1) {
                if (i == 2) {
                    n12.S(obj);
                    return xl4.a;
                }
                xe.q("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            iIntValue = this.B0;
            yn2Var = this.A0;
            bz2Var = (bz2) this.Z;
            ag1Var = this.Y;
            n12.S(obj);
            n02 n02Var = bz2Var.b.j;
            if (n02Var.k(hd2Var).equals(ed2.b)) {
                ug1Var = new av(5, new do1[0]);
            } else {
                if (!(n02Var.k(hd2Var) instanceof cd2)) {
                    n02Var.N(hd2Var, ed2.c);
                }
                yn2Var.n(null);
                iv1 iv1Var = (iv1) az2Var.e.f;
                int iOrdinal = hd2Var.ordinal();
                if (iOrdinal == 1) {
                    hv3Var = (hv3) ((eg0) iv1Var.f).z;
                } else if (iOrdinal == 2) {
                    hv3Var = (hv3) ((eg0) iv1Var.z).z;
                } else {
                    xe.k("invalid load type for hints");
                    hv3Var = null;
                }
                ug1Var = new ug1(new ug1(hv3Var, iIntValue == 0 ? 0 : 1, 0), iIntValue, 1);
            }
            this.Y = null;
            this.Z = null;
            this.A0 = null;
            this.X = 2;
        } finally {
            yn2Var.n(null);
        }
    }
}
