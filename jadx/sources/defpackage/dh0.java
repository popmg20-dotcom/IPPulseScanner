package defpackage;

import java.util.List;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dh0 extends v74 implements Function2 {
    public final /* synthetic */ int X = 0;
    public int Y;
    public final /* synthetic */ boolean Z;
    public /* synthetic */ Object y0;
    public final /* synthetic */ Object z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dh0(ge0 ge0Var, am1 am1Var, pl3 pl3Var, boolean z) {
        super(2, ge0Var);
        this.y0 = pl3Var;
        this.Z = z;
        this.z0 = am1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        lf0 lf0Var = (lf0) obj;
        ge0 ge0Var = (ge0) obj2;
        switch (i) {
        }
        return ((dh0) n(ge0Var, lf0Var)).p(xl4Var);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        int i = this.X;
        boolean z = this.Z;
        Object obj2 = this.z0;
        switch (i) {
            case 0:
                return new dh0(ge0Var, (am1) obj2, (pl3) this.y0, z);
            case 1:
                return new dh0(z, (String) this.y0, (eg0) obj2, ge0Var);
            case 2:
                return new dh0((String) this.y0, (String) obj2, z, ge0Var);
            case 3:
                return new dh0((List) this.y0, z, (d83) obj2, ge0Var);
            default:
                dh0 dh0Var = new dh0(ge0Var, (d83) obj2, z);
                dh0Var.y0 = obj;
                return dh0Var;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x02c2, code lost:
    
        if (defpackage.ji0.b0(r1, r2, r18) == r12) goto L117;
     */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.Object r19) {
        /*
            Method dump skipped, instruction units count: 796
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dh0.p(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dh0(ge0 ge0Var, d83 d83Var, boolean z) {
        super(2, ge0Var);
        this.z0 = d83Var;
        this.Z = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dh0(String str, String str2, boolean z, ge0 ge0Var) {
        super(2, ge0Var);
        this.y0 = str;
        this.z0 = str2;
        this.Z = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dh0(List list, boolean z, d83 d83Var, ge0 ge0Var) {
        super(2, ge0Var);
        this.y0 = list;
        this.Z = z;
        this.z0 = d83Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dh0(boolean z, String str, eg0 eg0Var, ge0 ge0Var) {
        super(2, ge0Var);
        this.Z = z;
        this.y0 = str;
        this.z0 = eg0Var;
    }
}
