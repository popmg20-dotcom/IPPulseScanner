package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w12 extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public int Y;
    public final /* synthetic */ y12 Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w12(y12 y12Var, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Z = y12Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
        }
        return ((w12) n(ge0Var, lf0Var)).p(xl4Var);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        y12 y12Var = this.Z;
        switch (i) {
            case 0:
                return new w12(y12Var, ge0Var, 0);
            case 1:
                return new w12(y12Var, ge0Var, 1);
            default:
                return new w12(y12Var, ge0Var, 2);
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        y12 y12Var = this.Z;
        mf0 mf0Var = mf0.b;
        switch (i) {
            case 0:
                int i2 = this.Y;
                if (i2 == 0) {
                    n12.S(obj);
                    vh4 vh4Var = y12Var.b;
                    this.Y = 1;
                    if (vh4Var.g(this) == mf0Var) {
                    }
                } else if (i2 != 1) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                } else {
                    n12.S(obj);
                }
                break;
            case 1:
                int i3 = this.Y;
                if (i3 == 0) {
                    n12.S(obj);
                    vh4 vh4Var2 = y12Var.b;
                    this.Y = 1;
                    if (vh4Var2.g(this) == mf0Var) {
                    }
                } else if (i3 != 1) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                } else {
                    n12.S(obj);
                }
                break;
            default:
                int i4 = this.Y;
                if (i4 == 0) {
                    n12.S(obj);
                    this.Y = 1;
                    if (y12Var.c(this) == mf0Var) {
                    }
                } else if (i4 != 1) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                } else {
                    n12.S(obj);
                }
                break;
        }
        return mf0Var;
    }
}
