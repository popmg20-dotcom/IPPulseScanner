package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fh0 extends v74 implements Function2 {
    public final /* synthetic */ Object A0;
    public final /* synthetic */ Object B0;
    public final /* synthetic */ int X = 0;
    public int Y;
    public /* synthetic */ Object Z;
    public final /* synthetic */ boolean y0;
    public Object z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fh0(vh4 vh4Var, int[] iArr, boolean z, String[] strArr, ge0 ge0Var) {
        super(2, ge0Var);
        this.z0 = vh4Var;
        this.A0 = iArr;
        this.y0 = z;
        this.B0 = strArr;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        switch (i) {
            case 0:
                return ((fh0) n((ge0) obj2, (jg4) obj)).p(xl4Var);
            default:
                ((fh0) n((ge0) obj2, (ag1) obj)).p(xl4Var);
                return mf0.b;
        }
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        Object obj2 = this.B0;
        Object obj3 = this.A0;
        switch (i) {
            case 0:
                fh0 fh0Var = new fh0(ge0Var, (am1) obj2, (pl3) obj3, this.y0);
                fh0Var.Z = obj;
                return fh0Var;
            default:
                fh0 fh0Var2 = new fh0((vh4) this.z0, (int[]) obj3, this.y0, (String[]) obj2, ge0Var);
                fh0Var2.Z = obj;
                return fh0Var2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.Object r18) {
        /*
            Method dump skipped, instruction units count: 334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fh0.p(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fh0(ge0 ge0Var, am1 am1Var, pl3 pl3Var, boolean z) {
        super(2, ge0Var);
        this.y0 = z;
        this.A0 = pl3Var;
        this.B0 = am1Var;
    }
}
