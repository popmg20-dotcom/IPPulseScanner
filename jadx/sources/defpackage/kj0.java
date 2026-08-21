package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kj0 extends v74 implements Function2 {
    public /* synthetic */ Object A0;
    public final /* synthetic */ Object B0;
    public final /* synthetic */ Object C0;
    public final /* synthetic */ int X = 1;
    public int Y;
    public final /* synthetic */ boolean Z;
    public Object y0;
    public final /* synthetic */ Object z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kj0(aa1 aa1Var, ma1 ma1Var, boolean z, String str, String str2, ge0 ge0Var) {
        super(2, ge0Var);
        this.z0 = aa1Var;
        this.A0 = ma1Var;
        this.Z = z;
        this.B0 = str;
        this.C0 = str2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                return ((kj0) n((ge0) obj2, (je1) obj)).p(xl4Var);
            case 1:
                return ((kj0) n((ge0) obj2, (lf0) obj)).p(xl4Var);
            default:
                return ((kj0) n((ge0) obj2, (lf0) obj)).p(xl4Var);
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        Object obj2 = this.B0;
        Object obj3 = this.C0;
        Object obj4 = this.z0;
        switch (i) {
            case 0:
                kj0 kj0Var = new kj0((zg3) obj4, (lj0) obj3, this.B0, this.Z, ge0Var);
                kj0Var.A0 = obj;
                return kj0Var;
            case 1:
                return new kj0((aa1) obj4, (ma1) this.A0, this.Z, (String) obj2, (String) obj3, ge0Var);
            default:
                kj0 kj0Var2 = new kj0((ma1) this.y0, (aa1) obj4, this.Z, (String) obj2, (String) obj3, ge0Var);
                kj0Var2.A0 = obj;
                return kj0Var2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0175, code lost:
    
        if (r8.b(r4, r21) == r9) goto L53;
     */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [cf0, ge0, of0] */
    /* JADX WARN: Type inference failed for: r3v7 */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.Object r22) {
        /*
            Method dump skipped, instruction units count: 408
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kj0.p(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kj0(ma1 ma1Var, aa1 aa1Var, boolean z, String str, String str2, ge0 ge0Var) {
        super(2, ge0Var);
        this.y0 = ma1Var;
        this.z0 = aa1Var;
        this.Z = z;
        this.B0 = str;
        this.C0 = str2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kj0(zg3 zg3Var, lj0 lj0Var, Object obj, boolean z, ge0 ge0Var) {
        super(2, ge0Var);
        this.z0 = zg3Var;
        this.C0 = lj0Var;
        this.B0 = obj;
        this.Z = z;
    }
}
