package defpackage;

import com.getsurfboard.ui.activity.NATDetectActivity;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class eo2 extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public int Y;
    public final /* synthetic */ NATDetectActivity Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ eo2(NATDetectActivity nATDetectActivity, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Z = nATDetectActivity;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
        }
        return ((eo2) n(ge0Var, lf0Var)).p(xl4Var);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        NATDetectActivity nATDetectActivity = this.Z;
        switch (i) {
            case 0:
                return new eo2(nATDetectActivity, ge0Var, 0);
            default:
                return new eo2(nATDetectActivity, ge0Var, 1);
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        NATDetectActivity nATDetectActivity = this.Z;
        mf0 mf0Var = mf0.b;
        int i2 = 1;
        ge0 ge0Var = null;
        switch (i) {
            case 0:
                int i3 = this.Y;
                if (i3 == 0) {
                    n12.S(obj);
                    gm0 gm0Var = qv0.a;
                    tq1 tq1Var = qf2.a;
                    do2 do2Var = new do2(nATDetectActivity, ge0Var, 0);
                    this.Y = 1;
                    if (ji0.b0(tq1Var, do2Var, this) == mf0Var) {
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
                    gm0 gm0Var2 = qv0.a;
                    tq1 tq1Var2 = qf2.a;
                    do2 do2Var2 = new do2(nATDetectActivity, ge0Var, i2);
                    this.Y = 1;
                    if (ji0.b0(tq1Var2, do2Var2, this) == mf0Var) {
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
