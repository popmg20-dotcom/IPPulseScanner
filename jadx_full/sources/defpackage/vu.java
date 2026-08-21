package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vu implements ag1 {
    public final /* synthetic */ int b = 1;
    public final /* synthetic */ ag1 f;
    public final /* synthetic */ zg3 z;

    public vu(ag1 ag1Var, zg3 zg3Var) {
        this.f = ag1Var;
        this.z = zg3Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(tz1 tz1Var, ge0 ge0Var) {
        uu uuVar;
        if (ge0Var instanceof uu) {
            uuVar = (uu) ge0Var;
            int i = uuVar.Z;
            if ((i & Integer.MIN_VALUE) != 0) {
                uuVar.Z = i - Integer.MIN_VALUE;
            } else {
                uuVar = new uu(this, ge0Var);
            }
        }
        Object obj = uuVar.X;
        int i2 = uuVar.Z;
        zg3 zg3Var = this.z;
        if (i2 == 0) {
            n12.S(obj);
            tz1Var.getClass();
            if (tz1Var.a > zg3Var.b) {
                Object obj2 = tz1Var.b;
                uuVar.A = tz1Var;
                uuVar.Z = 1;
                Object objH = this.f.h(obj2, uuVar);
                mf0 mf0Var = mf0.b;
                if (objH == mf0Var) {
                    return mf0Var;
                }
            }
            return xl4.a;
        }
        if (i2 != 1) {
            xe.q("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        tz1Var = uuVar.A;
        n12.S(obj);
        zg3Var.b = tz1Var.a;
        return xl4.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    @Override // defpackage.ag1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(Object obj, ge0 ge0Var) {
        mh1 mh1Var;
        switch (this.b) {
            case 0:
                return a((tz1) obj, ge0Var);
            default:
                if (ge0Var instanceof mh1) {
                    mh1Var = (mh1) ge0Var;
                    int i = mh1Var.Y;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        mh1Var.Y = i - Integer.MIN_VALUE;
                    } else {
                        mh1Var = new mh1(this, ge0Var);
                    }
                }
                Object obj2 = mh1Var.A;
                int i2 = mh1Var.Y;
                if (i2 == 0) {
                    n12.S(obj2);
                    zg3 zg3Var = this.z;
                    int i3 = zg3Var.b;
                    zg3Var.b = i3 + 1;
                    if (i3 < 0) {
                        throw new ArithmeticException("Index overflow has happened");
                    }
                    tz1 tz1Var = new tz1(i3, obj);
                    mh1Var.Y = 1;
                    Object objH = this.f.h(tz1Var, mh1Var);
                    mf0 mf0Var = mf0.b;
                    if (objH == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (i2 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj2);
                }
                return xl4.a;
        }
    }

    public vu(zg3 zg3Var, ag1 ag1Var) {
        this.z = zg3Var;
        this.f = ag1Var;
    }
}
