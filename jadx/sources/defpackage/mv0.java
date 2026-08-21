package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class mv0 {
    public static final br1 a = new br1("UNDEFINED", 3);
    public static final br1 b = new br1("REUSABLE_CLAIMED", 3);

    /* JADX WARN: Removed duplicated region for block: B:32:0x008a A[Catch: all -> 0x0069, DONT_GENERATE, TryCatch #2 {all -> 0x0069, blocks: (B:16:0x0049, B:18:0x0057, B:20:0x005d, B:33:0x008d, B:23:0x006b, B:25:0x0079, B:30:0x0084, B:32:0x008a, B:38:0x009a, B:41:0x00a3, B:40:0x00a0, B:28:0x007f), top: B:54:0x0049, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(defpackage.ge0 r9, java.lang.Object r10) {
        /*
            boolean r0 = r9 instanceof defpackage.lv0
            if (r0 == 0) goto Lae
            lv0 r9 = (defpackage.lv0) r9
            ef0 r0 = r9.A
            ie0 r1 = r9.X
            java.lang.Throwable r2 = defpackage.uk3.a(r10)
            if (r2 != 0) goto L12
            r3 = r10
            goto L18
        L12:
            r80 r3 = new r80
            r4 = 0
            r3.<init>(r2, r4)
        L18:
            cf0 r2 = r1.j()
            boolean r2 = c(r0, r2)
            r4 = 1
            if (r2 == 0) goto L2f
            r9.Y = r3
            r9.z = r4
            cf0 r10 = r1.j()
            b(r0, r10, r9)
            return
        L2f:
            b61 r0 = defpackage.qd4.a()
            long r5 = r0.z
            r7 = 4294967296(0x100000000, double:2.121995791E-314)
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 < 0) goto L46
            r9.Y = r3
            r9.z = r4
            r0.z0(r9)
            goto La8
        L46:
            r0.F0(r4)
            cf0 r2 = r1.j()     // Catch: java.lang.Throwable -> L69
            pr1 r3 = defpackage.pr1.X     // Catch: java.lang.Throwable -> L69
            af0 r2 = r2.Z(r3)     // Catch: java.lang.Throwable -> L69
            v32 r2 = (defpackage.v32) r2     // Catch: java.lang.Throwable -> L69
            if (r2 == 0) goto L6b
            boolean r3 = r2.isActive()     // Catch: java.lang.Throwable -> L69
            if (r3 != 0) goto L6b
            java.util.concurrent.CancellationException r10 = r2.F()     // Catch: java.lang.Throwable -> L69
            tk3 r10 = defpackage.n12.r(r10)     // Catch: java.lang.Throwable -> L69
            r9.d(r10)     // Catch: java.lang.Throwable -> L69
            goto L8d
        L69:
            r10 = move-exception
            goto La4
        L6b:
            java.lang.Object r2 = r9.Z     // Catch: java.lang.Throwable -> L69
            cf0 r3 = r1.j()     // Catch: java.lang.Throwable -> L69
            java.lang.Object r2 = defpackage.nd4.c(r3, r2)     // Catch: java.lang.Throwable -> L69
            br1 r5 = defpackage.nd4.a     // Catch: java.lang.Throwable -> L69
            if (r2 == r5) goto L7e
            bl4 r5 = defpackage.co4.c0(r1, r3, r2)     // Catch: java.lang.Throwable -> L69
            goto L7f
        L7e:
            r5 = 0
        L7f:
            r1.d(r10)     // Catch: java.lang.Throwable -> L97
            if (r5 == 0) goto L8a
            boolean r10 = r5.n0()     // Catch: java.lang.Throwable -> L69
            if (r10 == 0) goto L8d
        L8a:
            defpackage.nd4.a(r3, r2)     // Catch: java.lang.Throwable -> L69
        L8d:
            boolean r10 = r0.H0()     // Catch: java.lang.Throwable -> L69
            if (r10 != 0) goto L8d
        L93:
            r0.x0(r4)
            goto La8
        L97:
            r10 = move-exception
            if (r5 == 0) goto La0
            boolean r1 = r5.n0()     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto La3
        La0:
            defpackage.nd4.a(r3, r2)     // Catch: java.lang.Throwable -> L69
        La3:
            throw r10     // Catch: java.lang.Throwable -> L69
        La4:
            r9.i(r10)     // Catch: java.lang.Throwable -> La9
            goto L93
        La8:
            return
        La9:
            r9 = move-exception
            r0.x0(r4)
            throw r9
        Lae:
            r9.d(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mv0.a(ge0, java.lang.Object):void");
    }

    public static final void b(ef0 ef0Var, cf0 cf0Var, Runnable runnable) {
        try {
            ef0Var.j0(cf0Var, runnable);
        } catch (Throwable th) {
            throw new kv0(th, ef0Var, cf0Var);
        }
    }

    public static final boolean c(ef0 ef0Var, cf0 cf0Var) throws kv0 {
        try {
            return ef0Var.q0(cf0Var);
        } catch (Throwable th) {
            throw new kv0(th, ef0Var, cf0Var);
        }
    }
}
