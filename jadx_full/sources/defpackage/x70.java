package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class x70 implements ag1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ int f;
    public final /* synthetic */ Object z;

    public /* synthetic */ x70(int i, int i2, Object obj) {
        this.b = i2;
        this.z = obj;
        this.f = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    @Override // defpackage.ag1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(Object obj, ge0 ge0Var) {
        w70 w70Var;
        sy2 sy2Var;
        int i = this.b;
        xl4 xl4Var = xl4.a;
        int i2 = this.f;
        Object obj2 = this.z;
        mf0 mf0Var = mf0.b;
        switch (i) {
            case 0:
                if (ge0Var instanceof w70) {
                    w70Var = (w70) ge0Var;
                    int i3 = w70Var.Y;
                    if ((i3 & Integer.MIN_VALUE) != 0) {
                        w70Var.Y = i3 - Integer.MIN_VALUE;
                    } else {
                        w70Var = new w70(this, ge0Var);
                    }
                }
                Object obj3 = w70Var.A;
                int i4 = w70Var.Y;
                if (i4 == 0) {
                    n12.S(obj3);
                    tz1 tz1Var = new tz1(i2, obj);
                    w70Var.Y = 1;
                    if (((xp) obj2).a(w70Var, tz1Var) != mf0Var) {
                    }
                } else if (i4 == 1) {
                    n12.S(obj3);
                } else if (i4 != 2) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                } else {
                    n12.S(obj3);
                }
                w70Var.Y = 2;
                if (vf2.E(w70Var) != mf0Var) {
                }
                break;
            default:
                if (ge0Var instanceof sy2) {
                    sy2Var = (sy2) ge0Var;
                    int i5 = sy2Var.X;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        sy2Var.X = i5 - Integer.MIN_VALUE;
                    } else {
                        sy2Var = new sy2(this, ge0Var);
                    }
                }
                Object obj4 = sy2Var.A;
                int i6 = sy2Var.X;
                if (i6 == 0) {
                    n12.S(obj4);
                    do1 do1Var = new do1(i2, (as4) obj);
                    sy2Var.X = 1;
                    if (((ag1) obj2).h(do1Var, sy2Var) == mf0Var) {
                    }
                } else if (i6 != 1) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                } else {
                    n12.S(obj4);
                }
                break;
        }
        return mf0Var;
    }
}
