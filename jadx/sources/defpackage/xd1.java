package defpackage;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class xd1 implements y50 {
    public final File a;
    public final AtomicBoolean b = new AtomicBoolean(false);

    public xd1(File file) {
        this.a = file;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9, types: [xd1] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object, xd1] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [xd1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object a(defpackage.xd1 r8, defpackage.ie0 r9) throws java.io.IOException {
        /*
            boolean r0 = r9 instanceof defpackage.wd1
            if (r0 == 0) goto L13
            r0 = r9
            wd1 r0 = (defpackage.wd1) r0
            int r1 = r0.y0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.y0 = r1
            goto L18
        L13:
            wd1 r0 = new wd1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.Y
            int r1 = r0.y0
            r2 = 2
            r3 = 1
            r4 = 0
            mf0 r5 = defpackage.mf0.b
            if (r1 == 0) goto L45
            if (r1 == r3) goto L39
            if (r1 != r2) goto L33
            java.lang.Object r8 = r0.A
            java.io.Closeable r8 = (java.io.Closeable) r8
            defpackage.n12.S(r9)     // Catch: java.lang.Throwable -> L30
            goto L98
        L30:
            r9 = move-exception
            goto La0
        L33:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.xe.q(r8)
            return r4
        L39:
            java.io.FileInputStream r8 = r0.X
            java.lang.Object r1 = r0.A
            xd1 r1 = (defpackage.xd1) r1
            defpackage.n12.S(r9)     // Catch: java.lang.Throwable -> L43
            goto L68
        L43:
            r9 = move-exception
            goto L73
        L45:
            defpackage.n12.S(r9)
            java.util.concurrent.atomic.AtomicBoolean r9 = r8.b
            boolean r9 = r9.get()
            if (r9 != 0) goto Lac
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L79
            java.io.File r1 = r8.a     // Catch: java.io.FileNotFoundException -> L79
            r9.<init>(r1)     // Catch: java.io.FileNotFoundException -> L79
            r0.A = r8     // Catch: java.lang.Throwable -> L6e
            r0.X = r9     // Catch: java.lang.Throwable -> L6e
            r0.y0 = r3     // Catch: java.lang.Throwable -> L6e
            rn2 r1 = defpackage.pr1.v(r9)     // Catch: java.lang.Throwable -> L6e
            if (r1 != r5) goto L64
            goto L94
        L64:
            r7 = r1
            r1 = r8
            r8 = r9
            r9 = r7
        L68:
            defpackage.ez4.l(r8, r4)     // Catch: java.io.FileNotFoundException -> L6c
            return r9
        L6c:
            r8 = r1
            goto L79
        L6e:
            r1 = move-exception
            r7 = r1
            r1 = r8
            r8 = r9
            r9 = r7
        L73:
            throw r9     // Catch: java.lang.Throwable -> L74
        L74:
            r6 = move-exception
            defpackage.ez4.l(r8, r9)     // Catch: java.io.FileNotFoundException -> L6c
            throw r6     // Catch: java.io.FileNotFoundException -> L6c
        L79:
            java.io.File r9 = r8.a
            boolean r9 = r9.exists()
            if (r9 == 0) goto La6
            java.io.FileInputStream r9 = new java.io.FileInputStream
            java.io.File r8 = r8.a
            r9.<init>(r8)
            r0.A = r9     // Catch: java.lang.Throwable -> L9c
            r0.X = r4     // Catch: java.lang.Throwable -> L9c
            r0.y0 = r2     // Catch: java.lang.Throwable -> L9c
            rn2 r8 = defpackage.pr1.v(r9)     // Catch: java.lang.Throwable -> L9c
            if (r8 != r5) goto L95
        L94:
            return r5
        L95:
            r7 = r9
            r9 = r8
            r8 = r7
        L98:
            defpackage.ez4.l(r8, r4)
            return r9
        L9c:
            r8 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
        La0:
            throw r9     // Catch: java.lang.Throwable -> La1
        La1:
            r0 = move-exception
            defpackage.ez4.l(r8, r9)
            throw r0
        La6:
            rn2 r8 = new rn2
            r8.<init>(r3)
            return r8
        Lac:
            java.lang.String r8 = "This scope has already been closed."
            defpackage.xe.q(r8)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xd1.a(xd1, ie0):java.lang.Object");
    }

    @Override // defpackage.y50
    public final void close() {
        this.b.set(true);
    }
}
