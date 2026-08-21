package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class uh4 extends v74 implements Function2 {
    public int A0;
    public int B0;
    public final /* synthetic */ fu2[] C0;
    public final /* synthetic */ vh4 D0;
    public final /* synthetic */ jg4 E0;
    public fu2[] X;
    public vh4 Y;
    public jg4 Z;
    public int y0;
    public int z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uh4(fu2[] fu2VarArr, vh4 vh4Var, jg4 jg4Var, ge0 ge0Var) {
        super(2, ge0Var);
        this.C0 = fu2VarArr;
        this.D0 = vh4Var;
        this.E0 = jg4Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((uh4) n((ge0) obj2, (t13) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        return new uh4(this.C0, this.D0, this.E0, ge0Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006f, code lost:
    
        if (r7.e(r6, r12, r11) == r10) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
    
        r5 = r9;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0075  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0072 -> B:27:0x0073). Please report as a decompilation issue!!! */
    @Override // defpackage.kk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.Object r12) {
        /*
            r11 = this;
            int r0 = r11.B0
            r1 = 0
            r2 = 2
            r3 = 1
            if (r0 == 0) goto L21
            if (r0 == r3) goto Lb
            if (r0 != r2) goto L1b
        Lb:
            int r0 = r11.A0
            int r4 = r11.z0
            int r5 = r11.y0
            jg4 r6 = r11.Z
            vh4 r7 = r11.Y
            fu2[] r8 = r11.X
            defpackage.n12.S(r12)
            goto L57
        L1b:
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r11)
            return r1
        L21:
            defpackage.n12.S(r12)
            fu2[] r12 = r11.C0
            int r0 = r12.length
            r4 = 0
            vh4 r5 = r11.D0
            jg4 r6 = r11.E0
            r8 = r12
            r12 = r4
            r7 = r5
        L2f:
            if (r4 >= r0) goto L75
            r5 = r8[r4]
            int r9 = r12 + 1
            int r5 = r5.ordinal()
            if (r5 == 0) goto L72
            mf0 r10 = defpackage.mf0.b
            if (r5 == r3) goto L5d
            if (r5 != r2) goto L59
            r11.X = r8
            r11.Y = r7
            r11.Z = r6
            r11.y0 = r9
            r11.z0 = r4
            r11.A0 = r0
            r11.B0 = r2
            java.lang.Object r12 = r7.f(r6, r12, r11)
            if (r12 != r10) goto L56
            goto L71
        L56:
            r5 = r9
        L57:
            r12 = r5
            goto L73
        L59:
            defpackage.g.d()
            return r1
        L5d:
            r11.X = r8
            r11.Y = r7
            r11.Z = r6
            r11.y0 = r9
            r11.z0 = r4
            r11.A0 = r0
            r11.B0 = r3
            java.lang.Object r12 = r7.e(r6, r12, r11)
            if (r12 != r10) goto L56
        L71:
            return r10
        L72:
            r12 = r9
        L73:
            int r4 = r4 + r3
            goto L2f
        L75:
            xl4 r11 = defpackage.xl4.a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uh4.p(java.lang.Object):java.lang.Object");
    }
}
