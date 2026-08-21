package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bv extends v74 implements em1 {
    public final /* synthetic */ int X;
    public int Y;
    public Object Z;
    public /* synthetic */ Object y0;
    public final /* synthetic */ Object z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ bv(ge0 ge0Var, Object obj, int i) {
        super(3, ge0Var);
        this.X = i;
        this.z0 = obj;
    }

    @Override // defpackage.em1
    public final Object e(Object obj, Object obj2, Object obj3) {
        int i = this.X;
        xl4 xl4Var = xl4.a;
        Object obj4 = this.z0;
        switch (i) {
            case 0:
                bv bvVar = new bv((ge0) obj3, (z50) obj4, 0);
                bvVar.Z = (ag1) obj;
                bvVar.y0 = obj2;
                return bvVar.p(xl4Var);
            case 1:
                bv bvVar2 = new bv((Function2) obj4, (ge0) obj3, 1);
                bvVar2.Z = (ag1) obj;
                bvVar2.y0 = obj2;
                return bvVar2.p(xl4Var);
            case 2:
                ((Boolean) obj2).getClass();
                bv bvVar3 = new bv((oy2) obj4, (ge0) obj3, 2);
                bvVar3.y0 = (ky2) obj;
                return bvVar3.p(xl4Var);
            case 3:
                bv bvVar4 = new bv((ge0) obj3, (oy2) obj4, 3);
                bvVar4.Z = (ag1) obj;
                bvVar4.y0 = obj2;
                return bvVar4.p(xl4Var);
            default:
                bv bvVar5 = new bv((ge0) obj3, (pj3) obj4, 4);
                bvVar5.Z = (ag1) obj;
                bvVar5.y0 = obj2;
                return bvVar5.p(xl4Var);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x02b2, code lost:
    
        if (r2.h(r3, r18) == r1) goto L119;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01cf A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01f9  */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.Object r19) {
        /*
            Method dump skipped, instruction units count: 760
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bv.p(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ bv(Object obj, ge0 ge0Var, int i) {
        super(3, ge0Var);
        this.X = i;
        this.z0 = obj;
    }
}
