package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u71 extends v74 implements Function2 {
    public int X;
    public /* synthetic */ Object Y;
    public final /* synthetic */ v71 Z;
    public final /* synthetic */ long y0;
    public final /* synthetic */ int z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u71(v71 v71Var, long j, int i, ge0 ge0Var) {
        super(2, ge0Var);
        this.Z = v71Var;
        this.y0 = j;
        this.z0 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((u71) n((ge0) obj2, (lf0) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        u71 u71Var = new u71(this.Z, this.y0, this.z0, ge0Var);
        u71Var.Y = obj;
        return u71Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0200 A[RETURN] */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.Object r14) {
        /*
            Method dump skipped, instruction units count: 513
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u71.p(java.lang.Object):java.lang.Object");
    }
}
