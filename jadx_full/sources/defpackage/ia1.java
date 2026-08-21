package defpackage;

import java.util.ArrayList;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ia1 extends v74 implements Function2 {
    public final /* synthetic */ int X = 1;
    public ArrayList Y;
    public int Z;
    public final /* synthetic */ ma1 y0;
    public final /* synthetic */ fa1 z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ia1(ma1 ma1Var, fa1 fa1Var, ArrayList arrayList, ge0 ge0Var) {
        super(2, ge0Var);
        this.y0 = ma1Var;
        this.z0 = fa1Var;
        this.Y = arrayList;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
        }
        return ((ia1) n(ge0Var, lf0Var)).p(xl4Var);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        fa1 fa1Var = this.z0;
        ma1 ma1Var = this.y0;
        switch (i) {
            case 0:
                return new ia1(ma1Var, fa1Var, this.Y, ge0Var);
            default:
                return new ia1(ma1Var, fa1Var, ge0Var);
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        ArrayList arrayList;
        int i = this.X;
        xl4 xl4Var = xl4.a;
        fa1 fa1Var = this.z0;
        mf0 mf0Var = mf0.b;
        int i2 = 2;
        ma1 ma1Var = this.y0;
        ge0 ge0Var = null;
        switch (i) {
            case 0:
                int i3 = this.Z;
                if (i3 == 0) {
                    n12.S(obj);
                    ArrayList arrayList2 = this.Y;
                    r92 lifecycle = ma1Var.getLifecycle();
                    gm0 gm0Var = qv0.a;
                    tq1 tq1Var = qf2.a.X;
                    cf0 cf0Var = this.f;
                    cf0Var.getClass();
                    boolean zQ0 = tq1Var.q0(cf0Var);
                    q92 q92Var = q92.X;
                    if (!zQ0) {
                        if (lifecycle.b() == q92.b) {
                            vp1.m();
                        } else if (lifecycle.b().compareTo(q92Var) >= 0) {
                            fa1Var.g(arrayList2);
                        }
                    }
                    kt ktVar = new kt(i2, fa1Var, arrayList2);
                    this.Z = 1;
                    if (ji0.V(lifecycle, q92Var, zQ0, tq1Var, ktVar, this) == mf0Var) {
                    }
                    break;
                } else if (i3 == 1) {
                    n12.S(obj);
                } else {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                }
                break;
            default:
                int i4 = this.Z;
                if (i4 == 0) {
                    n12.S(obj);
                    arrayList = new ArrayList();
                    gm0 gm0Var2 = qv0.a;
                    pl0 pl0Var = pl0.z;
                    gd gdVar = new gd(ma1Var, arrayList, ge0Var, 5);
                    this.Y = arrayList;
                    this.Z = 1;
                    if (ji0.b0(pl0Var, gdVar, this) != mf0Var) {
                    }
                } else if (i4 == 1) {
                    arrayList = this.Y;
                    n12.S(obj);
                } else if (i4 != 2) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                } else {
                    n12.S(obj);
                }
                gm0 gm0Var3 = qv0.a;
                tq1 tq1Var2 = qf2.a;
                ia1 ia1Var = new ia1(ma1Var, fa1Var, arrayList, null);
                this.Y = null;
                this.Z = 2;
                if (ji0.b0(tq1Var2, ia1Var, this) != mf0Var) {
                }
                break;
        }
        return mf0Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ia1(ma1 ma1Var, fa1 fa1Var, ge0 ge0Var) {
        super(2, ge0Var);
        this.y0 = ma1Var;
        this.z0 = fa1Var;
    }
}
