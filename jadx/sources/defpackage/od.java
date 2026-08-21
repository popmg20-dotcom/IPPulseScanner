package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class od extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public int Y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ od(int i, ge0 ge0Var, int i2) {
        super(i, ge0Var);
        this.X = i2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                return ((od) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            case 1:
                return ((od) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            default:
                return ((od) n((ge0) obj2, Integer.valueOf(((Number) obj).intValue()))).p(xl4Var);
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = 2;
        switch (this.X) {
            case 0:
                return new od(i, ge0Var, 0);
            case 1:
                return new od(i, ge0Var, 1);
            default:
                od odVar = new od(i, ge0Var, i);
                odVar.Y = ((Number) obj).intValue();
                return odVar;
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        mf0 mf0Var = mf0.b;
        switch (i) {
            case 0:
                int i2 = this.Y;
                if (i2 == 0) {
                    n12.S(obj);
                    hv3 hv3Var = m70.a;
                    this.Y = 1;
                    if (hv3Var.h(xl4Var, this) == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (i2 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4Var;
            case 1:
                int i3 = this.Y;
                if (i3 == 0) {
                    n12.S(obj);
                    hv3 hv3Var2 = m70.a;
                    this.Y = 1;
                    if (hv3Var2.h(xl4Var, this) == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (i3 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4Var;
            default:
                n12.S(obj);
                return Boolean.valueOf(this.Y > 0);
        }
    }
}
