package defpackage;

import com.tencent.mars.xlog.Xlog;
import io.sentry.android.core.a1;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.conscrypt.FileClientSessionCache;

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
    */
    public final Serializable h(ByteOrder byteOrder) throws Throwable {
        d71 d71Var;
        InputStream inputStream;
        String str;
        byte b;
        ?? r13;
        byte[] bArr = this.d;
        InputStream inputStream2 = null;
        try {
            try {
                d71Var = new d71(bArr);
                try {
                    d71Var.z = byteOrder;
                    int i = this.a;
                    int length = 0;
                    int i2 = this.b;
                    switch (i) {
                        case 1:
                        case 6:
                            if (bArr.length != 1 || (b = bArr[0]) < 0 || b > 1) {
                                str = new String(bArr, i71.O);
                                try {
                                    d71Var.close();
                                    return str;
                                } catch (IOException e) {
                                    a1.e("ExifInterface", "IOException occurred while closing InputStream", e);
                                    return str;
                                }
                            }
                            String str2 = new String(new char[]{(char) (b + 48)});
                            try {
                                d71Var.close();
                                return str2;
                            } catch (IOException e2) {
                                a1.e("ExifInterface", "IOException occurred while closing InputStream", e2);
                                return str2;
                            }
                        case 2:
                        case 7:
                            if (i2 >= i71.G.length) {
                                int i3 = 0;
                                while (true) {
                                    byte[] bArr2 = i71.G;
                                    if (i3 >= bArr2.length) {
                                        length = bArr2.length;
                                    } else if (bArr[i3] == bArr2[i3]) {
                                        i3++;
                                    }
                                }
                            }
                            StringBuilder sb = new StringBuilder();
                            while (length < i2) {
                                byte b2 = bArr[length];
                                if (b2 == 0) {
                                    str = sb.toString();
                                    d71Var.close();
                                    return str;
                                }
                                if (b2 >= 32) {
                                    sb.append((char) b2);
                                } else {
                                    sb.append('?');
                                }
                                length++;
                            }
                            str = sb.toString();
                            d71Var.close();
                            return str;
                        case 3:
                            r13 = new int[i2];
                            while (length < i2) {
                                r13[length] = d71Var.readUnsignedShort();
                                length++;
                            }
                            try {
                                d71Var.close();
                                return r13;
                            } catch (IOException e3) {
                                a1.e("ExifInterface", "IOException occurred while closing InputStream", e3);
                                return r13;
                            }
                        case 4:
                            r13 = new long[i2];
                            while (length < i2) {
                                r13[length] = ((long) d71Var.readInt()) & 4294967295L;
                                length++;
                            }
                            d71Var.close();
                            return r13;
                        case 5:
                            r13 = new g71[i2];
                            while (length < i2) {
                                r13[length] = new g71(((long) d71Var.readInt()) & 4294967295L, ((long) d71Var.readInt()) & 4294967295L);
                                length++;
                            }
                            d71Var.close();
                            return r13;
                        case 8:
                            r13 = new int[i2];
                            while (length < i2) {
                                r13[length] = d71Var.readShort();
                                length++;
                            }
                            d71Var.close();
                            return r13;
                        case Xlog.COMPRESS_LEVEL9 /* 9 */:
                            r13 = new int[i2];
                            while (length < i2) {
                                r13[length] = d71Var.readInt();
                                length++;
                            }
                            d71Var.close();
                            return r13;
                        case 10:
                            r13 = new g71[i2];
                            while (length < i2) {
                                r13[length] = new g71(d71Var.readInt(), d71Var.readInt());
                                length++;
                            }
                            d71Var.close();
                            return r13;
                        case 11:
                            r13 = new double[i2];
                            while (length < i2) {
                                r13[length] = d71Var.readFloat();
                                length++;
                            }
                            d71Var.close();
                            return r13;
                        case FileClientSessionCache.MAX_SIZE /* 12 */:
                            r13 = new double[i2];
                            while (length < i2) {
                                r13[length] = d71Var.readDouble();
                                length++;
                            }
                            d71Var.close();
                            return r13;
                        default:
                            try {
                                d71Var.close();
                                return null;
                            } catch (IOException e4) {
                                a1.e("ExifInterface", "IOException occurred while closing InputStream", e4);
                                return null;
                            }
                    }
                } catch (IOException e5) {
                    e = e5;
                    a1.o("ExifInterface", "IOException occurred during reading a value", e);
                    if (d71Var != null) {
                        try {
                            d71Var.close();
                        } catch (IOException e6) {
                            a1.e("ExifInterface", "IOException occurred while closing InputStream", e6);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e7) {
                        a1.e("ExifInterface", "IOException occurred while closing InputStream", e7);
                    }
                }
                throw th;
            }
        } catch (IOException e8) {
            e = e8;
            d71Var = null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream2 != null) {
            }
            throw th;
        }
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
