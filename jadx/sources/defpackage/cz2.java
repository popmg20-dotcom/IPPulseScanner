package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cz2 extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public final /* synthetic */ dz2 Y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ cz2(dz2 dz2Var, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.Y = dz2Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        ag1 ag1Var = (ag1) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
            case 0:
                ((cz2) n(ge0Var, ag1Var)).p(xl4Var);
                break;
            default:
                ((cz2) n(ge0Var, ag1Var)).p(xl4Var);
                break;
        }
        return xl4Var;
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        dz2 dz2Var = this.Y;
        switch (i) {
            case 0:
                return new cz2(dz2Var, ge0Var, 0);
            default:
                return new cz2(dz2Var, ge0Var, 1);
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        dz2 dz2Var = this.Y;
        switch (i) {
            case 0:
                n12.S(obj);
                dz2Var.h.e(new Integer(0));
                break;
            default:
                n12.S(obj);
                dz2Var.g.e(new Integer(0));
                break;
        }
        return xl4Var;
    }
}
