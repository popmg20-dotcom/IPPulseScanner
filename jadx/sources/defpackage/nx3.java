package defpackage;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nx3 {
    public final yn2 a = new yn2();
    public final cp1 b = new cp1(7);
    public final av c = new av(7, new lt(2, null, 9));

    public nx3(String str) {
    }

    public final Integer a() {
        return new Integer(((AtomicInteger) this.b.f).get());
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005d, code lost:
    
        if (r8 == r5) goto L25;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r6v0, types: [nx3] */
    /* JADX WARN: Type inference failed for: r6v1, types: [wn2] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v4, types: [wn2] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(defpackage.am1 r7, defpackage.ie0 r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof defpackage.lx3
            if (r0 == 0) goto L13
            r0 = r8
            lx3 r0 = (defpackage.lx3) r0
            int r1 = r0.y0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.y0 = r1
            goto L18
        L13:
            lx3 r0 = new lx3
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.Y
            int r1 = r0.y0
            r2 = 2
            r3 = 1
            r4 = 0
            mf0 r5 = defpackage.mf0.b
            if (r1 == 0) goto L41
            if (r1 == r3) goto L37
            if (r1 != r2) goto L31
            java.lang.Object r6 = r0.A
            wn2 r6 = (defpackage.wn2) r6
            defpackage.n12.S(r8)     // Catch: java.lang.Throwable -> L2f
            goto L60
        L2f:
            r7 = move-exception
            goto L64
        L31:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r6)
            return r4
        L37:
            yn2 r6 = r0.X
            java.lang.Object r7 = r0.A
            am1 r7 = (defpackage.am1) r7
            defpackage.n12.S(r8)
            goto L53
        L41:
            defpackage.n12.S(r8)
            r0.A = r7
            yn2 r6 = r6.a
            r0.X = r6
            r0.y0 = r3
            java.lang.Object r8 = r6.g(r0)
            if (r8 != r5) goto L53
            goto L5f
        L53:
            r0.A = r6     // Catch: java.lang.Throwable -> L2f
            r0.X = r4     // Catch: java.lang.Throwable -> L2f
            r0.y0 = r2     // Catch: java.lang.Throwable -> L2f
            java.lang.Object r8 = r7.g(r0)     // Catch: java.lang.Throwable -> L2f
            if (r8 != r5) goto L60
        L5f:
            return r5
        L60:
            r6.n(r4)
            return r8
        L64:
            r6.n(r4)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nx3.b(am1, ie0):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(kotlin.jvm.functions.Function2 r6, defpackage.ie0 r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof defpackage.mx3
            if (r0 == 0) goto L13
            r0 = r7
            mx3 r0 = (defpackage.mx3) r0
            int r1 = r0.y0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.y0 = r1
            goto L18
        L13:
            mx3 r0 = new mx3
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.Y
            int r1 = r0.y0
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2c
            boolean r5 = r0.X
            yn2 r6 = r0.A
            defpackage.n12.S(r7)     // Catch: java.lang.Throwable -> L2a
            goto L52
        L2a:
            r7 = move-exception
            goto L5d
        L2c:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r5)
            return r3
        L32:
            defpackage.n12.S(r7)
            yn2 r5 = r5.a
            boolean r7 = r5.d()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r7)     // Catch: java.lang.Throwable -> L58
            r0.A = r5     // Catch: java.lang.Throwable -> L58
            r0.X = r7     // Catch: java.lang.Throwable -> L58
            r0.y0 = r2     // Catch: java.lang.Throwable -> L58
            java.lang.Object r6 = r6.k(r1, r0)     // Catch: java.lang.Throwable -> L58
            mf0 r0 = defpackage.mf0.b
            if (r6 != r0) goto L4e
            return r0
        L4e:
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
        L52:
            if (r5 == 0) goto L57
            r6.n(r3)
        L57:
            return r7
        L58:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
        L5d:
            if (r5 == 0) goto L62
            r6.n(r3)
        L62:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nx3.c(kotlin.jvm.functions.Function2, ie0):java.lang.Object");
    }
}
