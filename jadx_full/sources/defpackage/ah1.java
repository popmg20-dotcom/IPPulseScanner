package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ah1 implements ag1 {
    public final /* synthetic */ int b = 1;
    public final /* synthetic */ ag1 f;
    public final /* synthetic */ Function2 z;

    public ah1(ag1 ag1Var, Function2 function2) {
        this.f = ag1Var;
        this.z = function2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ba, code lost:
    
        if (r13.h(r12, r0) == r4) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    @Override // defpackage.ag1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(Object obj, ge0 ge0Var) {
        zg1 zg1Var;
        lh1 lh1Var;
        ag1 ag1Var;
        int i = this.b;
        xl4 xl4Var = xl4.a;
        Function2 function2 = this.z;
        mf0 mf0Var = mf0.b;
        boolean z = true;
        switch (i) {
            case 0:
                if (ge0Var instanceof zg1) {
                    zg1Var = (zg1) ge0Var;
                    int i2 = zg1Var.Y;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        zg1Var.Y = i2 - Integer.MIN_VALUE;
                    } else {
                        zg1Var = new zg1(this, ge0Var);
                    }
                }
                Object objK = zg1Var.X;
                int i3 = zg1Var.Y;
                if (i3 == 0) {
                    n12.S(objK);
                    zg1Var.A = this;
                    zg1Var.y0 = obj;
                    zg1Var.Y = 1;
                    objK = function2.k(obj, zg1Var);
                    if (objK != mf0Var) {
                    }
                    return mf0Var;
                }
                if (i3 != 1) {
                    if (i3 != 2) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    this = zg1Var.A;
                    n12.S(objK);
                    if (z) {
                        throw new u(this);
                    }
                    return xl4Var;
                }
                obj = zg1Var.y0;
                this = zg1Var.A;
                n12.S(objK);
                if (((Boolean) objK).booleanValue()) {
                    ag1 ag1Var2 = this.f;
                    zg1Var.A = this;
                    zg1Var.y0 = null;
                    zg1Var.Y = 2;
                } else {
                    z = false;
                }
                if (z) {
                }
                break;
            default:
                if (ge0Var instanceof lh1) {
                    lh1Var = (lh1) ge0Var;
                    int i4 = lh1Var.X;
                    if ((i4 & Integer.MIN_VALUE) != 0) {
                        lh1Var.X = i4 - Integer.MIN_VALUE;
                    } else {
                        lh1Var = new lh1(this, ge0Var);
                    }
                }
                Object obj2 = lh1Var.A;
                int i5 = lh1Var.X;
                if (i5 == 0) {
                    n12.S(obj2);
                    lh1Var.Z = obj;
                    ag1Var = this.f;
                    lh1Var.y0 = ag1Var;
                    lh1Var.X = 1;
                    if (function2.k(obj, lh1Var) != mf0Var) {
                    }
                    return mf0Var;
                }
                if (i5 != 1) {
                    if (i5 == 2) {
                        n12.S(obj2);
                        return xl4Var;
                    }
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ag1Var = lh1Var.y0;
                obj = lh1Var.Z;
                n12.S(obj2);
                lh1Var.Z = null;
                lh1Var.y0 = null;
                lh1Var.X = 2;
                if (ag1Var.h(obj, lh1Var) != mf0Var) {
                    return xl4Var;
                }
                return mf0Var;
        }
    }

    public ah1(Function2 function2, ag1 ag1Var) {
        this.z = function2;
        this.f = ag1Var;
    }
}
