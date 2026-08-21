package defpackage;

import android.content.Context;
import android.os.Build;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xx4 extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public int Y;
    public final /* synthetic */ Object Z;
    public final /* synthetic */ Object y0;
    public final /* synthetic */ Object z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ xx4(Object obj, Object obj2, Object obj3, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Z = obj;
        this.y0 = obj2;
        this.z0 = obj3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
        }
        return ((xx4) n(ge0Var, lf0Var)).p(xl4Var);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        Object obj2 = this.z0;
        Object obj3 = this.y0;
        Object obj4 = this.Z;
        switch (i) {
            case 0:
                return new xx4((yx4) obj4, (tc2) obj3, (uw4) obj2, ge0Var, 0);
            default:
                return new xx4((m20) obj4, (gx4) obj3, (zu2) obj2, ge0Var, 1);
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        int i = this.X;
        Object obj2 = xl4.a;
        Object obj3 = this.z0;
        Object obj4 = this.Z;
        mf0 mf0Var = mf0.b;
        Object obj5 = this.y0;
        switch (i) {
            case 0:
                tc2 tc2Var = (tc2) obj5;
                yx4 yx4Var = (yx4) obj4;
                gx4 gx4Var = yx4Var.a;
                int i2 = this.Y;
                if (i2 == 0) {
                    n12.S(obj);
                    Context context = yx4Var.b;
                    uw4 uw4Var = (uw4) obj3;
                    ih4 ih4Var = yx4Var.d;
                    this.Y = 1;
                    String str = sw4.a;
                    if (gx4Var.q && Build.VERSION.SDK_INT < 31) {
                        fs1 fs1Var = (fs1) ih4Var.d;
                        fs1Var.getClass();
                        Object objB0 = ji0.b0(n12.x(fs1Var), new hd(tc2Var, gx4Var, uw4Var, context, null, 16), this);
                        if (objB0 == mf0Var) {
                            obj2 = objB0;
                        }
                    }
                    if (obj2 != mf0Var) {
                    }
                } else if (i2 == 1) {
                    n12.S(obj);
                } else if (i2 != 2) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                } else {
                    n12.S(obj);
                }
                String str2 = zx4.a;
                ue2.g().a(str2, "Starting work for " + gx4Var.c);
                yv yvVarB = tc2Var.b();
                this.Y = 2;
                Object objA = zx4.a(yvVarB, tc2Var, this);
                if (objA != mf0Var) {
                }
                break;
            default:
                gx4 gx4Var2 = (gx4) obj5;
                int i3 = this.Y;
                if (i3 == 0) {
                    n12.S(obj);
                    zf1 zf1VarB = ((m20) obj4).b(gx4Var2);
                    tf tfVar = new tf(6, (zu2) obj3, gx4Var2);
                    this.Y = 1;
                    if (zf1VarB.a(tfVar, this) == mf0Var) {
                    }
                } else if (i3 != 1) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                } else {
                    n12.S(obj);
                }
                break;
        }
        return mf0Var;
    }
}
