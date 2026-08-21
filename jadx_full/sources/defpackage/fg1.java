package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fg1 extends v74 implements Function2 {
    public final /* synthetic */ int X;
    public int Y;
    public /* synthetic */ Object Z;
    public final /* synthetic */ zf1 y0;
    public final /* synthetic */ em1 z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ fg1(zf1 zf1Var, em1 em1Var, ge0 ge0Var, int i) {
        super(2, ge0Var);
        this.X = i;
        this.y0 = zf1Var;
        this.z0 = em1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                return ((fg1) n((ge0) obj2, (ag1) obj)).p(xl4Var);
            default:
                return ((fg1) n((ge0) obj2, (hx3) obj)).p(xl4Var);
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        em1 em1Var = this.z0;
        zf1 zf1Var = this.y0;
        switch (i) {
            case 0:
                fg1 fg1Var = new fg1(zf1Var, em1Var, ge0Var, 0);
                fg1Var.Z = obj;
                return fg1Var;
            default:
                fg1 fg1Var2 = new fg1(zf1Var, em1Var, ge0Var, 1);
                fg1Var2.Z = obj;
                return fg1Var2;
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        em1 em1Var = this.z0;
        zf1 zf1Var = this.y0;
        mf0 mf0Var = mf0.b;
        ge0 ge0Var = null;
        switch (i) {
            case 0:
                int i2 = this.Y;
                if (i2 == 0) {
                    n12.S(obj);
                    ag1 ag1Var = (ag1) this.Z;
                    bh3 bh3Var = new bh3();
                    bh3Var.b = ke0.b;
                    eg1 eg1Var = new eg1(bh3Var, em1Var, ag1Var, 0);
                    this.Y = 1;
                    if (zf1Var.a(eg1Var, this) == mf0Var) {
                    }
                } else if (i2 != 1) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                } else {
                    n12.S(obj);
                }
                break;
            default:
                int i3 = this.Y;
                if (i3 == 0) {
                    n12.S(obj);
                    uf ufVar = new uf(em1Var, new xu((hx3) this.Z), ge0Var, 10);
                    this.Y = 1;
                    if (r25.k(zf1Var, ufVar, this) == mf0Var) {
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
