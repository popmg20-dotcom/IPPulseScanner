package defpackage;

import java.util.Map;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r63 extends v74 implements Function2 {
    public final /* synthetic */ cd1 A0;
    public final /* synthetic */ ad1 B0;
    public /* synthetic */ Object X;
    public final /* synthetic */ String Y;
    public final /* synthetic */ String Z;
    public final /* synthetic */ Map y0;
    public final /* synthetic */ ed1 z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r63(String str, String str2, Map map, ed1 ed1Var, cd1 cd1Var, ad1 ad1Var, ge0 ge0Var) {
        super(2, ge0Var);
        this.Y = str;
        this.Z = str2;
        this.y0 = map;
        this.z0 = ed1Var;
        this.A0 = cd1Var;
        this.B0 = ad1Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((r63) n((ge0) obj2, (lf0) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        r63 r63Var = new r63(this.Y, this.Z, this.y0, this.z0, this.A0, this.B0, ge0Var);
        r63Var.X = obj;
        return r63Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x0385 A[PHI: r1
      0x0385: PHI (r1v37 java.lang.String) = (r1v27 java.lang.String), (r1v45 java.lang.String) binds: [B:101:0x0443, B:74:0x037b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.Object r32) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.r63.p(java.lang.Object):java.lang.Object");
    }
}
