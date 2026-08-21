package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class eh1 implements ag1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Function2 f;
    public final /* synthetic */ bh3 z;

    public /* synthetic */ eh1(Function2 function2, bh3 bh3Var, int i) {
        this.b = i;
        this.f = function2;
        this.z = bh3Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    @Override // defpackage.ag1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(Object obj, ge0 ge0Var) {
        dh1 dh1Var;
        hh1 hh1Var;
        int i = this.b;
        xl4 xl4Var = xl4.a;
        Function2 function2 = this.f;
        mf0 mf0Var = mf0.b;
        switch (i) {
            case 0:
                if (ge0Var instanceof dh1) {
                    dh1Var = (dh1) ge0Var;
                    int i2 = dh1Var.Y;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        dh1Var.Y = i2 - Integer.MIN_VALUE;
                    } else {
                        dh1Var = new dh1(this, ge0Var);
                    }
                }
                Object objK = dh1Var.X;
                int i3 = dh1Var.Y;
                if (i3 == 0) {
                    n12.S(objK);
                    dh1Var.A = this;
                    dh1Var.y0 = obj;
                    dh1Var.Y = 1;
                    objK = function2.k(obj, dh1Var);
                    if (objK == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (i3 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    obj = dh1Var.y0;
                    this = dh1Var.A;
                    n12.S(objK);
                }
                if (!((Boolean) objK).booleanValue()) {
                    return xl4Var;
                }
                this.z.b = obj;
                throw new u(this);
            default:
                if (ge0Var instanceof hh1) {
                    hh1Var = (hh1) ge0Var;
                    int i4 = hh1Var.Y;
                    if ((i4 & Integer.MIN_VALUE) != 0) {
                        hh1Var.Y = i4 - Integer.MIN_VALUE;
                    } else {
                        hh1Var = new hh1(this, ge0Var);
                    }
                }
                Object objK2 = hh1Var.X;
                int i5 = hh1Var.Y;
                if (i5 == 0) {
                    n12.S(objK2);
                    hh1Var.A = this;
                    hh1Var.y0 = obj;
                    hh1Var.Y = 1;
                    objK2 = function2.k(obj, hh1Var);
                    if (objK2 == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (i5 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    obj = hh1Var.y0;
                    this = hh1Var.A;
                    n12.S(objK2);
                }
                if (!((Boolean) objK2).booleanValue()) {
                    return xl4Var;
                }
                this.z.b = obj;
                throw new u(this);
        }
    }
}
