package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class je1 extends xd1 {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.Object r6, defpackage.ie0 r7) throws java.io.IOException {
        /*
            r5 = this;
            boolean r0 = r7 instanceof defpackage.ie1
            if (r0 == 0) goto L13
            r0 = r7
            ie1 r0 = (defpackage.ie1) r0
            int r1 = r0.y0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.y0 = r1
            goto L18
        L13:
            ie1 r0 = new ie1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.Y
            int r1 = r0.y0
            xl4 r2 = defpackage.xl4.a
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L34
            if (r1 != r3) goto L2e
            java.io.FileOutputStream r5 = r0.X
            java.io.FileOutputStream r6 = r0.A
            defpackage.n12.S(r7)     // Catch: java.lang.Throwable -> L2c
            goto L5b
        L2c:
            r5 = move-exception
            goto L68
        L2e:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r5)
            return r4
        L34:
            defpackage.n12.S(r7)
            java.util.concurrent.atomic.AtomicBoolean r7 = r5.b
            boolean r7 = r7.get()
            if (r7 != 0) goto L6e
            java.io.FileOutputStream r7 = new java.io.FileOutputStream
            java.io.File r5 = r5.a
            r7.<init>(r5)
            zk4 r5 = new zk4     // Catch: java.lang.Throwable -> L66
            r5.<init>(r7)     // Catch: java.lang.Throwable -> L66
            r0.A = r7     // Catch: java.lang.Throwable -> L66
            r0.X = r7     // Catch: java.lang.Throwable -> L66
            r0.y0 = r3     // Catch: java.lang.Throwable -> L66
            defpackage.pr1.w(r6, r5)     // Catch: java.lang.Throwable -> L66
            mf0 r5 = defpackage.mf0.b
            if (r2 != r5) goto L59
            return r5
        L59:
            r5 = r7
            r6 = r5
        L5b:
            java.io.FileDescriptor r5 = r5.getFD()     // Catch: java.lang.Throwable -> L2c
            r5.sync()     // Catch: java.lang.Throwable -> L2c
            defpackage.ez4.l(r6, r4)
            return r2
        L66:
            r5 = move-exception
            r6 = r7
        L68:
            throw r5     // Catch: java.lang.Throwable -> L69
        L69:
            r7 = move-exception
            defpackage.ez4.l(r6, r5)
            throw r7
        L6e:
            java.lang.String r5 = "This scope has already been closed."
            defpackage.xe.q(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.je1.b(java.lang.Object, ie0):java.lang.Object");
    }
}
