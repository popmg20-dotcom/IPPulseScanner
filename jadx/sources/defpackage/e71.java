package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e71 {
    public final int a;
    public final int b;
    public final long c;
    public final byte[] d;

    public e71(int i, long j, int i2, byte[] bArr) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = bArr;
    }

    public static e71 a(String str) {
        byte[] bytes = str.concat(WebViewProviderFactoryBoundaryInterface.MULTI_COOKIE_VALUE_SEPARATOR).getBytes(i71.O);
        return new e71(2, bytes.length, bytes);
    }

    public static e71 b(long j, ByteOrder byteOrder) {
        long[] jArr = {j};
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[i71.F[4] * jArr.length]);
        byteBufferWrap.order(byteOrder);
        for (long j2 : jArr) {
            byteBufferWrap.putInt((int) j2);
        }
        return new e71(4, jArr.length, byteBufferWrap.array());
    }

    public static e71 c(g71[] g71VarArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[i71.F[5] * g71VarArr.length]);
        byteBufferWrap.order(byteOrder);
        for (g71 g71Var : g71VarArr) {
            byteBufferWrap.putInt((int) g71Var.a);
            byteBufferWrap.putInt((int) g71Var.b);
        }
        return new e71(5, g71VarArr.length, byteBufferWrap.array());
    }

    public static e71 d(int i, ByteOrder byteOrder) {
        int[] iArr = {i};
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[i71.F[3] * iArr.length]);
        byteBufferWrap.order(byteOrder);
        for (int i2 : iArr) {
            byteBufferWrap.putShort((short) i2);
        }
        return new e71(3, iArr.length, byteBufferWrap.array());
    }

    public final double e(ByteOrder byteOrder) throws Throwable {
        Object objH = h(byteOrder);
        if (objH == null) {
            throw new NumberFormatException("NULL can't be converted to a double value");
        }
        if (objH instanceof String) {
            return Double.parseDouble((String) objH);
        }
        if (objH instanceof long[]) {
            if (((long[]) objH).length == 1) {
                return r3[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (objH instanceof int[]) {
            if (((int[]) objH).length == 1) {
                return r3[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (objH instanceof double[]) {
            double[] dArr = (double[]) objH;
            if (dArr.length == 1) {
                return dArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(objH instanceof g71[])) {
            throw new NumberFormatException("Couldn't find a double value");
        }
        g71[] g71VarArr = (g71[]) objH;
        if (g71VarArr.length != 1) {
            throw new NumberFormatException("There are more than one component");
        }
        g71 g71Var = g71VarArr[0];
        return g71Var.a / g71Var.b;
    }

    public final int f(ByteOrder byteOrder) {
        Object objH = h(byteOrder);
        if (objH == null) {
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }
        if (objH instanceof String) {
            return Integer.parseInt((String) objH);
        }
        if (objH instanceof long[]) {
            long[] jArr = (long[]) objH;
            if (jArr.length == 1) {
                return (int) jArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(objH instanceof int[])) {
            throw new NumberFormatException("Couldn't find a integer value");
        }
        int[] iArr = (int[]) objH;
        if (iArr.length == 1) {
            return iArr[0];
        }
        throw new NumberFormatException("There are more than one component");
    }

    public final String g(ByteOrder byteOrder) throws Throwable {
        Object objH = h(byteOrder);
        if (objH == null) {
            return null;
        }
        if (objH instanceof String) {
            return (String) objH;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (objH instanceof long[]) {
            long[] jArr = (long[]) objH;
            while (i < jArr.length) {
                sb.append(jArr[i]);
                i++;
                if (i != jArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (objH instanceof int[]) {
            int[] iArr = (int[]) objH;
            while (i < iArr.length) {
                sb.append(iArr[i]);
                i++;
                if (i != iArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (objH instanceof double[]) {
            double[] dArr = (double[]) objH;
            while (i < dArr.length) {
                sb.append(dArr[i]);
                i++;
                if (i != dArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (!(objH instanceof g71[])) {
            return null;
        }
        g71[] g71VarArr = (g71[]) objH;
        while (i < g71VarArr.length) {
            sb.append(g71VarArr[i].a);
            sb.append('/');
            sb.append(g71VarArr[i].b);
            i++;
            if (i != g71VarArr.length) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0032: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:51), block:B:17:0x0032 */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0134 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v14, types: [int[]] */
    /* JADX WARN: Type inference failed for: r13v15, types: [long[]] */
    /* JADX WARN: Type inference failed for: r13v16, types: [g71[]] */
    /* JADX WARN: Type inference failed for: r13v17, types: [int[]] */
    /* JADX WARN: Type inference failed for: r13v18, types: [int[]] */
    /* JADX WARN: Type inference failed for: r13v19, types: [g71[]] */
    /* JADX WARN: Type inference failed for: r13v20, types: [double[]] */
    /* JADX WARN: Type inference failed for: r13v21, types: [java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r13v22, types: [double[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.Serializable h(java.nio.ByteOrder r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e71.h(java.nio.ByteOrder):java.io.Serializable");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(i71.E[this.a]);
        sb.append(", data length:");
        return fw.w(")", sb, this.d.length);
    }

    public e71(int i, int i2, byte[] bArr) {
        this(i, -1L, i2, bArr);
    }
}
