package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class e30 extends v74 implements Function2 {
    public final /* synthetic */ int X = 1;
    public int Y;
    public /* synthetic */ Object Z;
    public final /* synthetic */ h30 y0;
    public final /* synthetic */ ag1 z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e30(h30 h30Var, ag1 ag1Var, Object obj, ge0 ge0Var) {
        super(2, ge0Var);
        this.y0 = h30Var;
        this.z0 = ag1Var;
        this.Z = obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
        }
        return ((e30) n(ge0Var, lf0Var)).p(xl4Var);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        ag1 ag1Var = this.z0;
        h30 h30Var = this.y0;
        switch (i) {
            case 0:
                return new e30(h30Var, ag1Var, this.Z, ge0Var);
            default:
                e30 e30Var = new e30(h30Var, ag1Var, ge0Var);
                e30Var.Z = obj;
                return e30Var;
        }
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        ag1 ag1Var = this.z0;
        h30 h30Var = this.y0;
        mf0 mf0Var = mf0.b;
        switch (i) {
            case 0:
                int i2 = this.Y;
                if (i2 == 0) {
                    n12.S(obj);
                    em1 em1Var = h30Var.X;
                    Object obj2 = this.Z;
                    this.Y = 1;
                    if (em1Var.e(ag1Var, obj2, this) == mf0Var) {
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
                    lf0 lf0Var = (lf0) this.Z;
                    bh3 bh3Var = new bh3();
                    zf1 zf1Var = h30Var.A;
                    g30 g30Var = new g30(bh3Var, lf0Var, h30Var, ag1Var);
                    this.Y = 1;
                    if (zf1Var.a(g30Var, this) == mf0Var) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e30(h30 h30Var, ag1 ag1Var, ge0 ge0Var) {
        super(2, ge0Var);
        this.y0 = h30Var;
        this.z0 = ag1Var;
    }
}
