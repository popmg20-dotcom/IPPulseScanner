package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v63 extends v74 implements Function2 {
    public int X;
    public final /* synthetic */ long Y;
    public final /* synthetic */ String Z;
    public final /* synthetic */ String y0;
    public final /* synthetic */ String z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v63(long j, String str, String str2, String str3, ge0 ge0Var) {
        super(2, ge0Var);
        this.Y = j;
        this.Z = str;
        this.y0 = str2;
        this.z0 = str3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((v63) n((ge0) obj2, (lf0) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        return new v63(this.Y, this.Z, this.y0, this.z0, ge0Var);
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
        uf ufVar = new uf(this.Z, this.y0, this.z0, (ge0) null, 18);
        this.X = 1;
        Object objX = r25.X(this.Y, ufVar, this);
        mf0 mf0Var = mf0.b;
        return objX == mf0Var ? mf0Var : objX;
    }
}
