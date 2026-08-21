package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class hd3 extends id3 implements Serializable {
    public final byte[] a(byte[] bArr) {
        j1 j1Var = id3.f;
        j1Var.getClass();
        int i = 8;
        if (8 > bArr.length || 20 > bArr.length) {
            e04.f(ha0.p(new StringBuilder("fromIndex (8) or toIndex (20) are out of range: 0.."), bArr.length, '.'));
            return null;
        }
        for (int i2 = 0; i2 < 3; i2++) {
            int iNextInt = j1Var.a().nextInt();
            bArr[i] = (byte) iNextInt;
            bArr[i + 1] = (byte) (iNextInt >>> 8);
            bArr[i + 2] = (byte) (iNextInt >>> 16);
            bArr[i + 3] = (byte) (iNextInt >>> 24);
            i += 4;
        }
        int i3 = 20 - i;
        int i4 = i3 * 8;
        int iNextInt2 = (j1Var.a().nextInt() >>> (32 - i4)) & ((-i4) >> 31);
        for (int i5 = 0; i5 < i3; i5++) {
            bArr[i + i5] = (byte) (iNextInt2 >>> (i5 * 8));
        }
        return bArr;
    }
}
