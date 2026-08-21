package defpackage;

import com.google.android.material.progressindicator.LinearProgressIndicator;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w73 extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public final /* synthetic */ d83 Y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w73(d83 d83Var, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Y = d83Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
            case 0:
                ((w73) n(ge0Var, lf0Var)).p(xl4Var);
                break;
            default:
                ((w73) n(ge0Var, lf0Var)).p(xl4Var);
                break;
        }
        return xl4Var;
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        d83 d83Var = this.Y;
        switch (i) {
            case 0:
                return new w73(d83Var, ge0Var, 0);
            default:
                return new w73(d83Var, ge0Var, 1);
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        d83 d83Var = this.Y;
        switch (i) {
            case 0:
                n12.S(obj);
                y3 y3Var = d83Var.b;
                y3Var.getClass();
                ((LinearProgressIndicator) y3Var.g).e();
                break;
            default:
                n12.S(obj);
                y3 y3Var2 = d83Var.b;
                y3Var2.getClass();
                ((LinearProgressIndicator) y3Var2.g).b();
                break;
        }
        return xl4Var;
    }
}
