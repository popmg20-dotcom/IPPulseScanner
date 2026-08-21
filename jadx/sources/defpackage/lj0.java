package defpackage;

import java.util.List;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lj0 implements qi0 {
    public final av A;
    public final n84 B0;
    public final iv1 C0;
    public int Y;
    public z14 Z;
    public final be1 b;
    public final wn1 f;
    public final lf0 z;
    public final iv1 z0;
    public final yn2 X = new yn2();
    public final w7 y0 = new w7(20);
    public final n84 A0 = new n84(new vi0(this, 1));

    public lj0(be1 be1Var, List list, wn1 wn1Var, lf0 lf0Var) {
        this.b = be1Var;
        this.f = wn1Var;
        this.z = lf0Var;
        ge0 ge0Var = null;
        this.A = new av(7, new uf(this, ge0Var, 5));
        this.z0 = new iv1(this, list);
        int i = 0;
        this.B0 = new n84(new vi0(this, i));
        this.C0 = new iv1(lf0Var, new ij0(i, this), new hj(this, ge0Var, 12));
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(defpackage.ie0 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof defpackage.zi0
            if (r0 == 0) goto L13
            r0 = r5
            zi0 r0 = (defpackage.zi0) r0
            int r1 = r0.y0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.y0 = r1
            goto L18
        L13:
            zi0 r0 = new zi0
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.Y
            int r1 = r0.y0
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2c
            yn2 r4 = r0.X
            lj0 r0 = r0.A
            defpackage.n12.S(r5)
            r5 = r4
            r4 = r0
            goto L46
        L2c:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r4)
            return r3
        L32:
            defpackage.n12.S(r5)
            r0.A = r4
            yn2 r5 = r4.X
            r0.X = r5
            r0.y0 = r2
            java.lang.Object r0 = r5.g(r0)
            mf0 r1 = defpackage.mf0.b
            if (r0 != r1) goto L46
            return r1
        L46:
            int r0 = r4.Y     // Catch: java.lang.Throwable -> L56
            int r0 = r0 + (-1)
            r4.Y = r0     // Catch: java.lang.Throwable -> L56
            if (r0 != 0) goto L5a
            z14 r0 = r4.Z     // Catch: java.lang.Throwable -> L56
            if (r0 == 0) goto L58
            r0.g(r3)     // Catch: java.lang.Throwable -> L56
            goto L58
        L56:
            r4 = move-exception
            goto L60
        L58:
            r4.Z = r3     // Catch: java.lang.Throwable -> L56
        L5a:
            r5.n(r3)
            xl4 r4 = defpackage.xl4.a
            return r4
        L60:
            r5.n(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lj0.a(ie0):java.lang.Object");
    }

    @Override // defpackage.qi0
    public final Object b(Function2 function2, hj hjVar) {
        cf0 cf0Var = hjVar.f;
        cf0Var.getClass();
        cn4 cn4Var = (cn4) cf0Var.Z(wl3.z0);
        if (cn4Var != null) {
            cn4Var.a(this);
        }
        return ji0.b0(new cn4(cn4Var, this), new uf(this, function2, null, 6), hjVar);
    }

    public final nx3 c() {
        return (nx3) this.B0.getValue();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(2:4|(1:6)(1:7))(0)|8|(8:68|(1:(1:(2:18|19))(3:20|21|22))|13|14|62|(1:64)(1:65)|66|67)(5:23|73|24|(3:26|71|27)(3:37|(1:39)(1:40)|(2:42|(2:44|(1:46))(2:53|54))(2:55|(2:57|58)(2:59|60)))|50)|47|69|48) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006f, code lost:
    
        if (r9 == r6) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0072, code lost:
    
        r8 = r11;
        r11 = r9;
        r9 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b3, code lost:
    
        if (r9 == r6) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b6, code lost:
    
        r9 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r9v0, types: [lj0] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v12, types: [e42, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v6, types: [lj0] */
    /* JADX WARN: Type inference failed for: r9v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(defpackage.kl2 r10, defpackage.ie0 r11) {
        /*
            Method dump skipped, instruction units count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lj0.d(kl2, ie0):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(defpackage.ie0 r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof defpackage.bj0
            if (r0 == 0) goto L13
            r0 = r5
            bj0 r0 = (defpackage.bj0) r0
            int r1 = r0.y0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.y0 = r1
            goto L18
        L13:
            bj0 r0 = new bj0
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.Y
            int r1 = r0.y0
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2c
            yn2 r4 = r0.X
            lj0 r0 = r0.A
            defpackage.n12.S(r5)
            r5 = r4
            r4 = r0
            goto L46
        L2c:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r4)
            return r3
        L32:
            defpackage.n12.S(r5)
            r0.A = r4
            yn2 r5 = r4.X
            r0.X = r5
            r0.y0 = r2
            java.lang.Object r0 = r5.g(r0)
            mf0 r1 = defpackage.mf0.b
            if (r0 != r1) goto L46
            return r1
        L46:
            int r0 = r4.Y     // Catch: java.lang.Throwable -> L5c
            int r0 = r0 + r2
            r4.Y = r0     // Catch: java.lang.Throwable -> L5c
            if (r0 != r2) goto L5e
            lf0 r0 = r4.z     // Catch: java.lang.Throwable -> L5c
            wi0 r1 = new wi0     // Catch: java.lang.Throwable -> L5c
            r1.<init>(r4, r3, r2)     // Catch: java.lang.Throwable -> L5c
            r2 = 3
            z14 r0 = defpackage.ji0.B(r0, r3, r3, r1, r2)     // Catch: java.lang.Throwable -> L5c
            r4.Z = r0     // Catch: java.lang.Throwable -> L5c
            goto L5e
        L5c:
            r4 = move-exception
            goto L64
        L5e:
            r5.n(r3)
            xl4 r4 = defpackage.xl4.a
            return r4
        L64:
            r5.n(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lj0.e(ie0):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0061, code lost:
    
        if (r1.B(r0) == r4) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(defpackage.ie0 r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof defpackage.cj0
            if (r0 == 0) goto L13
            r0 = r7
            cj0 r0 = (defpackage.cj0) r0
            int r1 = r0.y0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.y0 = r1
            goto L18
        L13:
            cj0 r0 = new cj0
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.Y
            int r1 = r0.y0
            r2 = 2
            r3 = 1
            mf0 r4 = defpackage.mf0.b
            if (r1 == 0) goto L3d
            if (r1 == r3) goto L37
            if (r1 != r2) goto L30
            int r6 = r0.X
            lj0 r0 = r0.A
            defpackage.n12.S(r7)     // Catch: java.lang.Throwable -> L2e
            goto L64
        L2e:
            r7 = move-exception
            goto L6c
        L30:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r6)
            r6 = 0
            return r6
        L37:
            lj0 r6 = r0.A
            defpackage.n12.S(r7)
            goto L4f
        L3d:
            defpackage.n12.S(r7)
            nx3 r7 = r6.c()
            r0.A = r6
            r0.y0 = r3
            java.lang.Integer r7 = r7.a()
            if (r7 != r4) goto L4f
            goto L63
        L4f:
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            iv1 r1 = r6.z0     // Catch: java.lang.Throwable -> L67
            r0.A = r6     // Catch: java.lang.Throwable -> L67
            r0.X = r7     // Catch: java.lang.Throwable -> L67
            r0.y0 = r2     // Catch: java.lang.Throwable -> L67
            java.lang.Object r6 = r1.B(r0)     // Catch: java.lang.Throwable -> L67
            if (r6 != r4) goto L64
        L63:
            return r4
        L64:
            xl4 r6 = defpackage.xl4.a
            return r6
        L67:
            r0 = move-exception
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
        L6c:
            w7 r0 = r0.y0
            wd3 r1 = new wd3
            r1.<init>(r7, r6)
            r0.x(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lj0.f(ie0):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(boolean r10, defpackage.ge0 r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lj0.g(boolean, ge0):java.lang.Object");
    }

    @Override // defpackage.qi0
    public final zf1 getData() {
        return this.A;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ab A[Catch: sf0 -> 0x005e, TryCatch #1 {sf0 -> 0x005e, blocks: (B:19:0x0059, B:54:0x0108, B:24:0x0067, B:51:0x00eb, B:32:0x0084, B:40:0x00ab, B:42:0x00b1, B:36:0x008e, B:48:0x00d9), top: B:79:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0149 A[Catch: all -> 0x0175, TryCatch #0 {all -> 0x0175, blocks: (B:61:0x0137, B:63:0x0149, B:64:0x0151), top: B:78:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0151 A[Catch: all -> 0x0175, TRY_LEAVE, TryCatch #0 {all -> 0x0175, blocks: (B:61:0x0137, B:63:0x0149, B:64:0x0151), top: B:78:0x0137 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(boolean r11, defpackage.ie0 r12) {
        /*
            Method dump skipped, instruction units count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lj0.h(boolean, ie0):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(java.lang.Object r10, boolean r11, defpackage.ie0 r12) throws java.io.IOException {
        /*
            r9 = this;
            boolean r0 = r12 instanceof defpackage.jj0
            if (r0 == 0) goto L13
            r0 = r12
            jj0 r0 = (defpackage.jj0) r0
            int r1 = r0.Z
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.Z = r1
            goto L18
        L13:
            jj0 r0 = new jj0
            r0.<init>(r9, r12)
        L18:
            java.lang.Object r12 = r0.X
            int r1 = r0.Z
            r2 = 1
            if (r1 == 0) goto L2e
            if (r1 != r2) goto L27
            zg3 r9 = r0.A
            defpackage.n12.S(r12)
            goto L55
        L27:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r9)
            r9 = 0
            return r9
        L2e:
            defpackage.n12.S(r12)
            zg3 r4 = new zg3
            r4.<init>()
            n84 r12 = r9.A0
            java.lang.Object r12 = r12.getValue()
            ee1 r12 = (defpackage.ee1) r12
            kj0 r3 = new kj0
            r8 = 0
            r5 = r9
            r6 = r10
            r7 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            r0.A = r4
            r0.Z = r2
            java.lang.Object r9 = r12.b(r3, r0)
            mf0 r10 = defpackage.mf0.b
            if (r9 != r10) goto L54
            return r10
        L54:
            r9 = r4
        L55:
            int r9 = r9.b
            java.lang.Integer r10 = new java.lang.Integer
            r10.<init>(r9)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lj0.i(java.lang.Object, boolean, ie0):java.lang.Object");
    }
}
