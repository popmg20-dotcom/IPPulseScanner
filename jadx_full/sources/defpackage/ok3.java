package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;

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
    */
    public final String C() {
        cq cqVarX = x();
        String th = null;
        try {
            pj2 pj2VarS = s();
            if (pj2VarS != null) {
                uh3 uh3Var = pj2.e;
                Charset charsetA = pj2VarS.a(null);
                if (charsetA == null) {
                    charsetA = y30.a;
                }
                String strW = cqVarX.W(jz4.f(cqVarX, charsetA));
                try {
                    cqVarX.close();
                } catch (Throwable th2) {
                    th = th2;
                }
                String str = th;
                th = strW;
                th = str;
            }
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
        if (th == 0) {
            return th;
        }
        throw th;
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
