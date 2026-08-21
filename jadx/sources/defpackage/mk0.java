package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mk0 {
    public static final Charset g = StandardCharsets.UTF_8;
    public static final int[] h = {0, 0, 2048, 526336, 0};
    public final t60 a;
    public final long b;
    public final ByteBuffer d;
    public final ConcurrentHashMap e;
    public final CharsetDecoder c = g.newDecoder();
    public final jd f = new jd(6, this);

    public mk0(t60 t60Var, ByteBuffer byteBuffer, long j, ConcurrentHashMap concurrentHashMap) {
        this.a = t60Var;
        this.b = j;
        this.d = byteBuffer;
        this.e = concurrentHashMap;
    }

    public static int c(ByteBuffer byteBuffer, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            i = (i << 8) | (byteBuffer.get() & 255);
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x020b, code lost:
    
        r8.put(((defpackage.gj2) r19).name(), java.lang.Integer.valueOf(r15));
        r15 = r15 + 1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011c  */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v33, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r0v50 */
    /* JADX WARN: Type inference failed for: r0v51 */
    /* JADX WARN: Type inference failed for: r0v52 */
    /* JADX WARN: Type inference failed for: r0v53 */
    /* JADX WARN: Type inference failed for: r1v23, types: [java.math.BigInteger] */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v26, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.o2 a(java.lang.Class r22, java.lang.reflect.Type r23) throws defpackage.a60 {
        /*
            Method dump skipped, instruction units count: 962
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mk0.a(java.lang.Class, java.lang.reflect.Type):o2");
    }

    public final int b(int i) {
        return c(this.d, 0, i);
    }

    public final int d(int i, int i2) throws a60 {
        if (i2 == 0) {
            return i;
        }
        ByteBuffer byteBuffer = this.d;
        if (i >= byteBuffer.capacity()) {
            throw new a60("The MaxMind DB file's data section contains bad data: pointer larger than the database.");
        }
        byteBuffer.position(i);
        byte b = byteBuffer.get();
        int i3 = b & 255;
        int i4 = i + 1;
        int i5 = ((byte) ((b & 255) >>> 5)) & 255;
        ei4[] ei4VarArr = ei4.z;
        if (i5 >= ei4VarArr.length) {
            throw new a60("The MaxMind DB file's data section contains bad data");
        }
        ei4 ei4Var = ei4VarArr[i5];
        if (ei4Var.equals(ei4.b)) {
            int i6 = byteBuffer.get() + 7;
            if (i6 < 8) {
                throw new a60(ha0.k("Something went horribly wrong in the decoder. An extended type resolved to a type number < 8 (", i6, ")"));
            }
            if (i6 >= ei4VarArr.length) {
                throw new a60("The MaxMind DB file's data section contains bad data");
            }
            ei4Var = ei4VarArr[i6];
            i4 = i + 2;
        }
        int iB = b & 31;
        if (iB >= 29) {
            i4 += iB - 28;
            iB = iB != 29 ? iB != 30 ? 65821 + b(3) : b(2) + 285 : (byteBuffer.get() & 255) + 29;
        }
        int iOrdinal = ei4Var.ordinal();
        if (iOrdinal == 1) {
            i4 += ((i3 >>> 3) & 3) + 1;
        } else if (iOrdinal == 7) {
            i2 += iB * 2;
        } else if (iOrdinal == 11) {
            i2 += iB;
        } else if (iOrdinal != 14) {
            i4 += iB;
        }
        return d(i4, i2 - 1);
    }
}
