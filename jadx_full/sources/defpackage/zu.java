package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zu implements ag1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ ag1 f;

    public /* synthetic */ zu(ag1 ag1Var, int i) {
        this.b = i;
        this.f = ag1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    @Override // defpackage.ag1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(Object obj, ge0 ge0Var) throws Throwable {
        yu yuVar;
        qa0 qa0Var;
        gc0 gc0Var;
        yi0 yi0Var;
        kh1 kh1Var;
        int i = this.b;
        xl4 xl4Var = xl4.a;
        ag1 ag1Var = this.f;
        mf0 mf0Var = mf0.b;
        ge0 ge0Var2 = null;
        switch (i) {
            case 0:
                if (ge0Var instanceof yu) {
                    yuVar = (yu) ge0Var;
                    int i2 = yuVar.X;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        yuVar.X = i2 - Integer.MIN_VALUE;
                    } else {
                        yuVar = new yu(this, ge0Var);
                    }
                }
                Object obj2 = yuVar.A;
                int i3 = yuVar.X;
                if (i3 != 0) {
                    if (i3 == 1) {
                        n12.S(obj2);
                        return xl4Var;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj2);
                gn2 gn2Var = (gn2) obj;
                ng1 ng1Var = new ng1(new pg1(new gt(gn2Var, ge0Var2, 7), (av) gn2Var.b.X), new fn2(gn2Var, null));
                kz2 kz2Var = gn2Var.a;
                kz2 kz2Var2 = new kz2(ng1Var, kz2Var.b, kz2Var.c, new fn(11, gn2Var));
                yuVar.X = 1;
                return ag1Var.h(kz2Var2, yuVar) == mf0Var ? mf0Var : xl4Var;
            case 1:
                if (ge0Var instanceof qa0) {
                    qa0Var = (qa0) ge0Var;
                    int i4 = qa0Var.X;
                    if ((i4 & Integer.MIN_VALUE) != 0) {
                        qa0Var.X = i4 - Integer.MIN_VALUE;
                    } else {
                        qa0Var = new qa0(this, ge0Var);
                    }
                }
                Object obj3 = qa0Var.A;
                int i5 = qa0Var.X;
                if (i5 != 0) {
                    if (i5 == 1) {
                        n12.S(obj3);
                        return xl4Var;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj3);
                Object obj4 = ((e03) obj).f;
                if (obj4 == null) {
                    return xl4Var;
                }
                qa0Var.X = 1;
                return ag1Var.h(obj4, qa0Var) == mf0Var ? mf0Var : xl4Var;
            case 2:
                if (ge0Var instanceof gc0) {
                    gc0Var = (gc0) ge0Var;
                    int i6 = gc0Var.X;
                    if ((i6 & Integer.MIN_VALUE) != 0) {
                        gc0Var.X = i6 - Integer.MIN_VALUE;
                    } else {
                        gc0Var = new gc0(this, ge0Var);
                    }
                }
                Object obj5 = gc0Var.A;
                int i7 = gc0Var.X;
                if (i7 != 0) {
                    if (i7 == 1) {
                        n12.S(obj5);
                        return xl4Var;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj5);
                if (!(obj instanceof pc0)) {
                    return xl4Var;
                }
                gc0Var.X = 1;
                return ag1Var.h(obj, gc0Var) == mf0Var ? mf0Var : xl4Var;
            case 3:
                if (ge0Var instanceof yi0) {
                    yi0Var = (yi0) ge0Var;
                    int i8 = yi0Var.X;
                    if ((i8 & Integer.MIN_VALUE) != 0) {
                        yi0Var.X = i8 - Integer.MIN_VALUE;
                    } else {
                        yi0Var = new yi0(this, ge0Var);
                    }
                }
                Object obj6 = yi0Var.A;
                int i9 = yi0Var.X;
                if (i9 == 0) {
                    n12.S(obj6);
                    j24 j24Var = (j24) obj;
                    if (j24Var instanceof wd3) {
                        throw ((wd3) j24Var).b;
                    }
                    if (j24Var instanceof fi0) {
                        Object obj7 = ((fi0) j24Var).b;
                        yi0Var.X = 1;
                        return ag1Var.h(obj7, yi0Var) == mf0Var ? mf0Var : xl4Var;
                    }
                    if (j24Var instanceof qe1 ? true : j24Var instanceof yk4) {
                        xe.q("This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542");
                    } else {
                        g.d();
                    }
                } else {
                    if (i9 == 1) {
                        n12.S(obj6);
                        return xl4Var;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                }
                return null;
            default:
                if (ge0Var instanceof kh1) {
                    kh1Var = (kh1) ge0Var;
                    int i10 = kh1Var.X;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        kh1Var.X = i10 - Integer.MIN_VALUE;
                    } else {
                        kh1Var = new kh1(this, ge0Var);
                    }
                }
                Object obj8 = kh1Var.A;
                int i11 = kh1Var.X;
                if (i11 != 0) {
                    if (i11 == 1) {
                        n12.S(obj8);
                        return xl4Var;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                n12.S(obj8);
                if (obj == null) {
                    return xl4Var;
                }
                kh1Var.X = 1;
                return ag1Var.h(obj, kh1Var) == mf0Var ? mf0Var : xl4Var;
        }
    }
}
