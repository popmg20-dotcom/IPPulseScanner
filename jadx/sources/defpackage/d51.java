package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d51 extends v74 implements Function2 {
    public final /* synthetic */ Object A0;
    public Object B0;
    public Object C0;
    public final /* synthetic */ Object D0;
    public final /* synthetic */ int X = 0;
    public int Y;
    public Object Z;
    public final /* synthetic */ Object y0;
    public Object z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d51(g51 g51Var, ry1 ry1Var, Object obj, rw2 rw2Var, z51 z51Var, tj2 tj2Var, e10 e10Var, ge0 ge0Var) {
        super(2, ge0Var);
        this.Z = g51Var;
        this.y0 = ry1Var;
        this.z0 = obj;
        this.B0 = rw2Var;
        this.A0 = z51Var;
        this.C0 = tj2Var;
        this.D0 = e10Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
        }
        return ((d51) n(ge0Var, lf0Var)).p(xl4Var);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        Object obj2 = this.A0;
        Object obj3 = this.y0;
        Object obj4 = this.D0;
        switch (i) {
            case 0:
                return new d51((g51) this.Z, (bh3) this.B0, (bh3) this.C0, (ry1) obj3, this.z0, (bh3) obj4, (z51) obj2, ge0Var);
            case 1:
                return new d51((g51) this.Z, (ry1) obj3, this.z0, (rw2) this.B0, (z51) obj2, (tj2) this.C0, (e10) obj4, ge0Var);
            default:
                return new d51((lz1) obj4, (String) obj3, (String) obj2, ge0Var);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0088, code lost:
    
        if (defpackage.d73.j(r4, r5) == r13) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f8 A[Catch: Exception -> 0x002d, TryCatch #0 {Exception -> 0x002d, blocks: (B:9:0x0029, B:28:0x008d, B:30:0x00b3, B:32:0x00d5, B:34:0x00e3, B:36:0x00e7, B:37:0x00ea, B:39:0x00f8, B:42:0x0100, B:44:0x0120, B:46:0x0142, B:48:0x0150, B:50:0x0154, B:14:0x0037, B:23:0x0063, B:25:0x0071, B:17:0x0045), top: B:128:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0224  */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.Object r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 770
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.d51.p(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d51(g51 g51Var, bh3 bh3Var, bh3 bh3Var2, ry1 ry1Var, Object obj, bh3 bh3Var3, z51 z51Var, ge0 ge0Var) {
        super(2, ge0Var);
        this.Z = g51Var;
        this.B0 = bh3Var;
        this.C0 = bh3Var2;
        this.y0 = ry1Var;
        this.z0 = obj;
        this.D0 = bh3Var3;
        this.A0 = z51Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d51(lz1 lz1Var, String str, String str2, ge0 ge0Var) {
        super(2, ge0Var);
        this.D0 = lz1Var;
        this.y0 = str;
        this.A0 = str2;
    }
}
