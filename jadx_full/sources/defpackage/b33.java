package defpackage;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b33 extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public int Y;
    public /* synthetic */ Object Z;
    public final /* synthetic */ Function2 y0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b33(Function2 function2, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.y0 = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                return ((b33) n((ge0) obj2, (rn2) obj)).p(xl4Var);
            default:
                return ((b33) n((ge0) obj2, (ag1) obj)).p(xl4Var);
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        Function2 function2 = this.y0;
        switch (i) {
            case 0:
                b33 b33Var = new b33(function2, ge0Var, 0);
                b33Var.Z = obj;
                return b33Var;
            default:
                b33 b33Var2 = new b33(function2, ge0Var, 1);
                b33Var2.Z = obj;
                return b33Var2;
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        int i = this.X;
        Function2 function2 = this.y0;
        mf0 mf0Var = mf0.b;
        ge0 ge0Var = null;
        switch (i) {
            case 0:
                int i2 = this.Y;
                if (i2 == 0) {
                    n12.S(obj);
                    rn2 rn2Var = (rn2) this.Z;
                    this.Y = 1;
                    obj = function2.k(rn2Var, this);
                    if (obj == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (i2 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                rn2 rn2Var2 = (rn2) obj;
                rn2Var2.getClass();
                ((AtomicBoolean) rn2Var2.b.f).set(true);
                return rn2Var2;
            default:
                int i3 = this.Y;
                if (i3 == 0) {
                    n12.S(obj);
                    hd hdVar = new hd((ag1) this.Z, function2, ge0Var, 13);
                    this.Y = 1;
                    if (p95.h(hdVar, this) == mf0Var) {
                        return mf0Var;
                    }
                } else {
                    if (i3 != 1) {
                        xe.q("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    n12.S(obj);
                }
                return xl4.a;
        }
    }
}
