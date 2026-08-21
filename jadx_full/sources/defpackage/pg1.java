package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class pg1 implements zf1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ zf1 f;
    public final /* synthetic */ Function2 z;

    public pg1(Function2 function2, zf1 zf1Var) {
        this.b = 0;
        this.z = function2;
        this.f = zf1Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d5, code lost:
    
        if (r12.a(r13, r0) != r7) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0082  */
    @Override // defpackage.zf1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(ag1 ag1Var, ge0 ge0Var) throws Throwable {
        og1 og1Var;
        mo3 mo3Var;
        pg1 pg1Var;
        yg1 yg1Var;
        ah1 ah1Var;
        u e;
        int i = this.b;
        zf1 zf1Var = this.f;
        xl4 xl4Var = xl4.a;
        mf0 mf0Var = mf0.b;
        Function2 function2 = this.z;
        switch (i) {
            case 0:
                if (ge0Var instanceof og1) {
                    og1Var = (og1) ge0Var;
                    int i2 = og1Var.X;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        og1Var.X = i2 - Integer.MIN_VALUE;
                    } else {
                        og1Var = new og1(this, ge0Var);
                    }
                }
                Object obj = og1Var.A;
                int i3 = og1Var.X;
                if (i3 == 0) {
                    n12.S(obj);
                    cf0 cf0Var = og1Var.f;
                    cf0Var.getClass();
                    mo3 mo3Var2 = new mo3(ag1Var, cf0Var);
                    try {
                        og1Var.Z = this;
                        og1Var.y0 = ag1Var;
                        og1Var.z0 = mo3Var2;
                        og1Var.X = 1;
                        if (function2.k(mo3Var2, og1Var) != mf0Var) {
                            pg1Var = this;
                            mo3Var = mo3Var2;
                            mo3Var.q();
                            zf1 zf1Var2 = pg1Var.f;
                            og1Var.Z = null;
                            og1Var.y0 = null;
                            og1Var.z0 = null;
                            og1Var.X = 2;
                            break;
                        }
                        return mf0Var;
                    } catch (Throwable th) {
                        th = th;
                        mo3Var = mo3Var2;
                        mo3Var.q();
                        throw th;
                    }
                }
                if (i3 != 1) {
                    if (i3 == 2) {
                        n12.S(obj);
                        return xl4Var;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                mo3Var = og1Var.z0;
                ag1Var = og1Var.y0;
                pg1Var = og1Var.Z;
                try {
                    n12.S(obj);
                    mo3Var.q();
                    zf1 zf1Var22 = pg1Var.f;
                    og1Var.Z = null;
                    og1Var.y0 = null;
                    og1Var.z0 = null;
                    og1Var.X = 2;
                } catch (Throwable th2) {
                    th = th2;
                    mo3Var.q();
                    throw th;
                }
                break;
                break;
            case 1:
                if (ge0Var instanceof yg1) {
                    yg1Var = (yg1) ge0Var;
                    int i4 = yg1Var.X;
                    if ((i4 & Integer.MIN_VALUE) != 0) {
                        yg1Var.X = i4 - Integer.MIN_VALUE;
                    } else {
                        yg1Var = new yg1(this, ge0Var);
                    }
                }
                Object obj2 = yg1Var.A;
                int i5 = yg1Var.X;
                if (i5 != 0) {
                    if (i5 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ah1Var = yg1Var.Z;
                    try {
                        n12.S(obj2);
                    } catch (u e2) {
                        e = e2;
                        if (e.b == ah1Var) {
                            throw e;
                        }
                        cf0 cf0Var2 = yg1Var.f;
                        cf0Var2.getClass();
                        je.A(cf0Var2);
                    }
                    break;
                } else {
                    n12.S(obj2);
                    ah1 ah1Var2 = new ah1(function2, ag1Var);
                    try {
                        yg1Var.Z = ah1Var2;
                        yg1Var.X = 1;
                        if (zf1Var.a(ah1Var2, yg1Var) == mf0Var) {
                            return mf0Var;
                        }
                    } catch (u e3) {
                        ah1Var = ah1Var2;
                        e = e3;
                        if (e.b == ah1Var) {
                        }
                    }
                }
                return xl4Var;
            default:
                Object objA = zf1Var.a(new ah1(ag1Var, function2), ge0Var);
                return objA == mf0Var ? objA : xl4Var;
        }
    }

    public /* synthetic */ pg1(zf1 zf1Var, Function2 function2, int i) {
        this.b = i;
        this.f = zf1Var;
        this.z = function2;
    }
}
