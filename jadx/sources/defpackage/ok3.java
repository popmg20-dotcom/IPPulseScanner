package defpackage;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ok3 implements Closeable {
    public static final nk3 f;
    public mk3 b;

    static {
        bu buVar = bu.A;
        buVar.getClass();
        hp hpVar = new hp();
        hpVar.I0(buVar);
        f = new nk3(null, buVar.b.length, hpVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013 A[Catch: all -> 0x0026, TryCatch #1 {all -> 0x0026, blocks: (B:3:0x0005, B:5:0x000b, B:8:0x0015, B:7:0x0013), top: B:24:0x0005 }] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String C() {
        /*
            r4 = this;
            cq r0 = r4.x()
            r1 = 0
            pj2 r4 = r4.s()     // Catch: java.lang.Throwable -> L26
            if (r4 == 0) goto L13
            uh3 r2 = defpackage.pj2.e     // Catch: java.lang.Throwable -> L26
            java.nio.charset.Charset r4 = r4.a(r1)     // Catch: java.lang.Throwable -> L26
            if (r4 != 0) goto L15
        L13:
            java.nio.charset.Charset r4 = defpackage.y30.a     // Catch: java.lang.Throwable -> L26
        L15:
            java.nio.charset.Charset r4 = defpackage.jz4.f(r0, r4)     // Catch: java.lang.Throwable -> L26
            java.lang.String r4 = r0.W(r4)     // Catch: java.lang.Throwable -> L26
            r0.close()     // Catch: java.lang.Throwable -> L21
            goto L22
        L21:
            r1 = move-exception
        L22:
            r3 = r1
            r1 = r4
            r4 = r3
            goto L31
        L26:
            r4 = move-exception
            if (r0 == 0) goto L31
            r0.close()     // Catch: java.lang.Throwable -> L2d
            goto L31
        L2d:
            r0 = move-exception
            defpackage.ek0.b(r4, r0)
        L31:
            if (r4 != 0) goto L34
            return r1
        L34:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ok3.C():java.lang.String");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        hz4.b(x());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final byte[] g() throws IOException {
        long jN = n();
        byte[] th = null;
        if (jN > 2147483647L) {
            vp1.i(ha0.j(jN, "Cannot buffer entire body for content length: "));
            return null;
        }
        cq cqVarX = x();
        try {
            byte[] bArrB = cqVarX.B();
            try {
                cqVarX.close();
            } catch (Throwable th2) {
                th = th2;
            }
            byte[] bArr = th;
            th = bArrB;
            th = bArr;
        } catch (Throwable th3) {
            th = th3;
            if (cqVarX != null) {
                try {
                    cqVarX.close();
                } catch (Throwable th4) {
                    ek0.b(th, th4);
                }
            }
        }
        if (th != 0) {
            throw th;
        }
        int length = th.length;
        if (jN == -1 || jN == length) {
            return th;
        }
        throw new IOException("Content-Length (" + jN + ") and stream length (" + length + ") disagree");
    }

    public abstract long n();

    public abstract pj2 s();

    public abstract cq x();
}
