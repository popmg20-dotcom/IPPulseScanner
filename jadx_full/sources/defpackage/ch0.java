package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ch0 extends v74 implements Function2 {
    public int X;
    public final /* synthetic */ pl3 Y;
    public final /* synthetic */ boolean Z;
    public final /* synthetic */ boolean y0;
    public final /* synthetic */ am1 z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ch0(ge0 ge0Var, am1 am1Var, pl3 pl3Var, boolean z, boolean z2) {
        super(2, ge0Var);
        this.Y = pl3Var;
        this.Z = z;
        this.y0 = z2;
        this.z0 = am1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((ch0) n((ge0) obj2, (lf0) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        return new ch0(ge0Var, this.z0, this.Y, this.Z, this.y0);
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        int i = this.X;
        if (i != 0) {
            if (i == 1) {
                n12.S(obj);
                return obj;
            }
            xe.q("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        n12.S(obj);
        pl3 pl3Var = this.Y;
        boolean z = !(pl3Var.k() && pl3Var.l()) && this.Z;
        am1 am1Var = this.z0;
        pl3 pl3Var2 = this.Y;
        boolean z2 = this.y0;
        bh0 bh0Var = new bh0(null, am1Var, pl3Var2, z, z2);
        this.X = 1;
        Object objR = pl3Var2.r(z2, bh0Var, this);
        mf0 mf0Var = mf0.b;
        return objR == mf0Var ? mf0Var : objR;
    }
}
