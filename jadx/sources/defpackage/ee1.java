package defpackage;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ee1 implements y50 {
    public final File a;
    public final nx3 b;
    public final v10 c;
    public final AtomicBoolean d;
    public final yn2 e;

    public ee1(File file, nx3 nx3Var, v10 v10Var) {
        nx3Var.getClass();
        this.a = file;
        this.b = nx3Var;
        this.c = v10Var;
        this.d = new AtomicBoolean(false);
        this.e = new yn2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r7v0, types: [xi0] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(defpackage.xi0 r7, defpackage.ie0 r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof defpackage.ce1
            if (r0 == 0) goto L13
            r0 = r8
            ce1 r0 = (defpackage.ce1) r0
            int r1 = r0.z0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.z0 = r1
            goto L18
        L13:
            ce1 r0 = new ce1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.Z
            int r1 = r0.z0
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L38
            if (r1 != r2) goto L32
            boolean r6 = r0.Y
            xd1 r7 = r0.X
            ee1 r0 = r0.A
            defpackage.n12.S(r8)     // Catch: java.lang.Throwable -> L2c
            goto L69
        L2c:
            r8 = move-exception
            r5 = r8
            r8 = r6
            r6 = r0
            r0 = r5
            goto L81
        L32:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r6)
            return r3
        L38:
            defpackage.n12.S(r8)
            java.util.concurrent.atomic.AtomicBoolean r8 = r6.d
            boolean r8 = r8.get()
            if (r8 != 0) goto L93
            yn2 r8 = r6.e
            boolean r8 = r8.d()
            xd1 r1 = new xd1     // Catch: java.lang.Throwable -> L8a
            java.io.File r4 = r6.a     // Catch: java.lang.Throwable -> L8a
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L8a
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r8)     // Catch: java.lang.Throwable -> L7e
            r0.A = r6     // Catch: java.lang.Throwable -> L7e
            r0.X = r1     // Catch: java.lang.Throwable -> L7e
            r0.Y = r8     // Catch: java.lang.Throwable -> L7e
            r0.z0 = r2     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r7 = r7.e(r1, r4, r0)     // Catch: java.lang.Throwable -> L7e
            mf0 r0 = defpackage.mf0.b
            if (r7 != r0) goto L65
            return r0
        L65:
            r0 = r6
            r6 = r8
            r8 = r7
            r7 = r1
        L69:
            r7.close()     // Catch: java.lang.Throwable -> L6e
            r7 = r3
            goto L6f
        L6e:
            r7 = move-exception
        L6f:
            if (r7 != 0) goto L79
            if (r6 == 0) goto L78
            yn2 r6 = r0.e
            r6.n(r3)
        L78:
            return r8
        L79:
            throw r7     // Catch: java.lang.Throwable -> L7a
        L7a:
            r7 = move-exception
            r8 = r6
            r6 = r0
            goto L8b
        L7e:
            r7 = move-exception
            r0 = r7
            r7 = r1
        L81:
            r7.close()     // Catch: java.lang.Throwable -> L85
            goto L89
        L85:
            r7 = move-exception
            defpackage.ek0.b(r0, r7)     // Catch: java.lang.Throwable -> L8a
        L89:
            throw r0     // Catch: java.lang.Throwable -> L8a
        L8a:
            r7 = move-exception
        L8b:
            if (r8 == 0) goto L92
            yn2 r6 = r6.e
            r6.n(r3)
        L92:
            throw r7
        L93:
            java.lang.String r6 = "StorageConnection has already been disposed."
            defpackage.xe.q(r6)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ee1.a(xi0, ie0):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ca A[Catch: all -> 0x0105, IOException -> 0x0107, TRY_ENTER, TryCatch #1 {IOException -> 0x0107, blocks: (B:43:0x00ca, B:45:0x00d0, B:47:0x00d8, B:51:0x00e4, B:52:0x0104, B:48:0x00dd, B:59:0x0110, B:66:0x011d, B:65:0x011a), top: B:78:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0110 A[Catch: all -> 0x0105, IOException -> 0x0107, TRY_ENTER, TRY_LEAVE, TryCatch #1 {IOException -> 0x0107, blocks: (B:43:0x00ca, B:45:0x00d0, B:47:0x00d8, B:51:0x00e4, B:52:0x0104, B:48:0x00dd, B:59:0x0110, B:66:0x011d, B:65:0x011a), top: B:78:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int, wn2] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(defpackage.kj0 r10, defpackage.ie0 r11) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ee1.b(kj0, ie0):java.lang.Object");
    }

    @Override // defpackage.y50
    public final void close() {
        this.d.set(true);
        this.c.a();
    }
}
