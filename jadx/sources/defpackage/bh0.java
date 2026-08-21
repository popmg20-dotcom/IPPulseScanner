package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bh0 extends v74 implements Function2 {
    public final /* synthetic */ pl3 A0;
    public final /* synthetic */ am1 B0;
    public ig4 X;
    public int Y;
    public /* synthetic */ Object Z;
    public final /* synthetic */ boolean y0;
    public final /* synthetic */ boolean z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bh0(ge0 ge0Var, am1 am1Var, pl3 pl3Var, boolean z, boolean z2) {
        super(2, ge0Var);
        this.y0 = z;
        this.z0 = z2;
        this.A0 = pl3Var;
        this.B0 = am1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((bh0) n((ge0) obj2, (jg4) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        bh0 bh0Var = new bh0(ge0Var, this.B0, this.A0, this.y0, this.z0);
        bh0Var.Z = obj;
        return bh0Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009d A[PHI: r0 r12
      0x009d: PHI (r0v11 jg4) = (r0v8 jg4), (r0v16 jg4) binds: [B:34:0x009a, B:11:0x0026] A[DONT_GENERATE, DONT_INLINE]
      0x009d: PHI (r12v15 java.lang.Object) = (r12v13 java.lang.Object), (r12v0 java.lang.Object) binds: [B:34:0x009a, B:11:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c3 A[RETURN] */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.Object r12) {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bh0.p(java.lang.Object):java.lang.Object");
    }
}
