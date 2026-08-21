package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class eg1 implements ag1 {
    public final Object A;
    public final /* synthetic */ int b;
    public final Object f;
    public final Object z;

    public eg1(ag1 ag1Var, cf0 cf0Var) {
        this.b = 4;
        this.f = cf0Var;
        this.A = nd4.b(cf0Var);
        this.z = new w53(ag1Var, null, 12);
    }

    /* JADX WARN: Code restructure failed: missing block: B:96:0x0198, code lost:
    
        if (r0 == r9) goto L100;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0164  */
    @Override // defpackage.ag1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(Object obj, ge0 ge0Var) throws Throwable {
        dg1 dg1Var;
        bh3 bh3Var;
        gg1 gg1Var;
        bh3 bh3Var2;
        xg1 xg1Var;
        oh1 oh1Var;
        ag1 ag1Var;
        eg1 eg1Var = this;
        Object obj2 = obj;
        int i = eg1Var.b;
        xl4 xl4Var = xl4.a;
        mf0 mf0Var = mf0.b;
        Object obj3 = eg1Var.z;
        Object obj4 = eg1Var.A;
        Object obj5 = eg1Var.f;
        switch (i) {
            case 0:
                bh3 bh3Var3 = (bh3) obj5;
                if (ge0Var instanceof dg1) {
                    dg1Var = (dg1) ge0Var;
                    int i2 = dg1Var.Z;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        dg1Var.Z = i2 - Integer.MIN_VALUE;
                    } else {
                        dg1Var = new dg1(eg1Var, ge0Var);
                    }
                }
                Object objE = dg1Var.X;
                int i3 = dg1Var.Z;
                if (i3 == 0) {
                    n12.S(objE);
                    Object obj6 = bh3Var3.b;
                    if (obj6 != ke0.b) {
                        dg1Var.A = bh3Var3;
                        dg1Var.Z = 1;
                        objE = ((em1) obj4).e(obj6, obj2, dg1Var);
                    } else {
                        objE = obj2;
                    }
                    bh3Var = bh3Var3;
                    break;
                } else {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            n12.S(objE);
                            return xl4Var;
                        }
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    bh3Var = dg1Var.A;
                    n12.S(objE);
                }
                bh3Var.b = objE;
                Object obj7 = bh3Var3.b;
                dg1Var.A = null;
                dg1Var.Z = 2;
                if (((ag1) obj3).h(obj7, dg1Var) != mf0Var) {
                    return xl4Var;
                }
                return mf0Var;
            case 1:
                bh3 bh3Var4 = (bh3) obj5;
                if (ge0Var instanceof gg1) {
                    gg1Var = (gg1) ge0Var;
                    int i4 = gg1Var.Z;
                    if ((i4 & Integer.MIN_VALUE) != 0) {
                        gg1Var.Z = i4 - Integer.MIN_VALUE;
                    } else {
                        gg1Var = new gg1(eg1Var, ge0Var);
                    }
                }
                Object objE2 = gg1Var.X;
                int i5 = gg1Var.Z;
                if (i5 == 0) {
                    n12.S(objE2);
                    Object obj8 = bh3Var4.b;
                    gg1Var.A = bh3Var4;
                    gg1Var.Z = 1;
                    objE2 = ((bv) obj4).e(obj8, obj2, gg1Var);
                    if (objE2 != mf0Var) {
                        bh3Var2 = bh3Var4;
                    }
                    return mf0Var;
                }
                if (i5 != 1) {
                    if (i5 == 2) {
                        n12.S(objE2);
                        return xl4Var;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bh3Var2 = gg1Var.A;
                n12.S(objE2);
                bh3Var2.b = objE2;
                Object obj9 = bh3Var4.b;
                gg1Var.A = null;
                gg1Var.Z = 2;
                if (((ag1) obj3).h(obj9, gg1Var) != mf0Var) {
                    return xl4Var;
                }
                return mf0Var;
            case 2:
                if (ge0Var instanceof xg1) {
                    xg1Var = (xg1) ge0Var;
                    int i6 = xg1Var.y0;
                    if ((i6 & Integer.MIN_VALUE) != 0) {
                        xg1Var.y0 = i6 - Integer.MIN_VALUE;
                    } else {
                        xg1Var = new xg1(eg1Var, ge0Var);
                    }
                }
                Object objK = xg1Var.Y;
                int i7 = xg1Var.y0;
                if (i7 == 0) {
                    n12.S(objK);
                    if (((xg3) obj5).b) {
                        xg1Var.y0 = 1;
                        if (((ag1) obj3).h(obj2, xg1Var) != mf0Var) {
                            return xl4Var;
                        }
                    } else {
                        xg1Var.A = eg1Var;
                        xg1Var.X = obj2;
                        xg1Var.y0 = 2;
                        objK = ((gd) obj4).k(obj2, xg1Var);
                        if (objK != mf0Var) {
                        }
                    }
                    return mf0Var;
                }
                if (i7 != 1) {
                    if (i7 == 2) {
                        Object obj10 = xg1Var.X;
                        eg1 eg1Var2 = xg1Var.A;
                        n12.S(objK);
                        obj2 = obj10;
                        eg1Var = eg1Var2;
                    } else if (i7 != 3) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                }
                n12.S(objK);
                return xl4Var;
                if (((Boolean) objK).booleanValue()) {
                    return xl4Var;
                }
                ((xg3) eg1Var.f).b = true;
                ag1 ag1Var2 = (ag1) eg1Var.z;
                xg1Var.A = null;
                xg1Var.X = null;
                xg1Var.y0 = 3;
                if (ag1Var2.h(obj2, xg1Var) != mf0Var) {
                    return xl4Var;
                }
                return mf0Var;
            case 3:
                if (ge0Var instanceof oh1) {
                    oh1Var = (oh1) ge0Var;
                    int i8 = oh1Var.X;
                    if ((i8 & Integer.MIN_VALUE) != 0) {
                        oh1Var.X = i8 - Integer.MIN_VALUE;
                    } else {
                        oh1Var = new oh1(eg1Var, ge0Var);
                    }
                }
                Object obj11 = oh1Var.A;
                int i9 = oh1Var.X;
                if (i9 == 0) {
                    n12.S(obj11);
                    ag1 ag1Var3 = (ag1) obj3;
                    oh1Var.Y = ag1Var3;
                    oh1Var.X = 1;
                    Object objS = ke0.s(oh1Var, (q74) obj4, (pl3) obj5, true);
                    if (objS != mf0Var) {
                        ag1Var = ag1Var3;
                        obj11 = objS;
                    }
                    return mf0Var;
                }
                if (i9 != 1) {
                    if (i9 == 2) {
                        n12.S(obj11);
                        return xl4Var;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ag1Var = oh1Var.Y;
                n12.S(obj11);
                oh1Var.Y = null;
                oh1Var.X = 2;
                if (ag1Var.h(obj11, oh1Var) != mf0Var) {
                    return xl4Var;
                }
                return mf0Var;
            default:
                Object objB0 = l72.b0((cf0) obj5, obj2, obj4, (w53) obj3, ge0Var);
                return objB0 == mf0Var ? objB0 : xl4Var;
        }
    }

    public eg1(xg3 xg3Var, ag1 ag1Var, gd gdVar) {
        this.b = 2;
        this.f = xg3Var;
        this.z = ag1Var;
        this.A = gdVar;
    }

    public /* synthetic */ eg1(bh3 bh3Var, em1 em1Var, ag1 ag1Var, int i) {
        this.b = i;
        this.f = bh3Var;
        this.A = em1Var;
        this.z = ag1Var;
    }

    public eg1(ag1 ag1Var, pl3 pl3Var, q74 q74Var) {
        this.b = 3;
        this.z = ag1Var;
        this.f = pl3Var;
        this.A = q74Var;
    }
}
