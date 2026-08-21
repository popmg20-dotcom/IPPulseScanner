package net.i2p.crypto.eddsa.math.ed25519;

import net.i2p.crypto.eddsa.math.Encoding;
import net.i2p.crypto.eddsa.math.FieldElement;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class Ed25519LittleEndianEncoding extends Encoding {
    public static int d(int i, byte[] bArr) {
        int i2 = bArr[i] & 255;
        return ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8) | i2;
    }

    public static long e(int i, byte[] bArr) {
        int i2 = ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
        return ((long) ((bArr[i + 3] << 24) | i2 | ((bArr[i + 2] & 255) << 16))) & 4294967295L;
    }

    public final FieldElement b(byte[] bArr) {
        long jE = e(0, bArr);
        long jD = d(4, bArr) << 6;
        long jD2 = d(7, bArr) << 5;
        long jD3 = d(10, bArr) << 3;
        long jD4 = d(13, bArr) << 2;
        long jE2 = e(16, bArr);
        long jD5 = d(20, bArr) << 7;
        long jD6 = d(23, bArr) << 5;
        long jD7 = d(26, bArr) << 4;
        long jD8 = (d(29, bArr) & 8388607) << 2;
        long j = (jD8 + 16777216) >> 25;
        long j2 = (19 * j) + jE;
        long j3 = (jD + 16777216) >> 25;
        long j4 = jD2 + j3;
        long j5 = jD - (j3 << 25);
        long j6 = (jD3 + 16777216) >> 25;
        long j7 = jD4 + j6;
        long j8 = jD3 - (j6 << 25);
        long j9 = (jE2 + 16777216) >> 25;
        long j10 = jD5 + j9;
        long j11 = jE2 - (j9 << 25);
        long j12 = (jD6 + 16777216) >> 25;
        long j13 = jD7 + j12;
        long j14 = (j2 + 33554432) >> 26;
        long j15 = (j4 + 33554432) >> 26;
        long j16 = j8 + j15;
        long j17 = j4 - (j15 << 26);
        long j18 = (j7 + 33554432) >> 26;
        long j19 = j11 + j18;
        long j20 = j7 - (j18 << 26);
        long j21 = (j10 + 33554432) >> 26;
        long j22 = (jD6 - (j12 << 25)) + j21;
        long j23 = j10 - (j21 << 26);
        long j24 = (j13 + 33554432) >> 26;
        return new Ed25519FieldElement(this.b, new int[]{(int) (j2 - (j14 << 26)), (int) (j5 + j14), (int) j17, (int) j16, (int) j20, (int) j19, (int) j23, (int) j22, (int) (j13 - (j24 << 26)), (int) ((jD8 - (j << 25)) + j24)});
    }

    public final byte[] c(FieldElement fieldElement) {
        int[] iArr = ((Ed25519FieldElement) fieldElement).f;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = iArr[8];
        int i10 = iArr[9];
        int i11 = (((i10 + ((i9 + ((i8 + ((i7 + ((i6 + ((i5 + ((i4 + ((i3 + ((i2 + ((i + (((i10 * 19) + 16777216) >> 25)) >> 26)) >> 25)) >> 26)) >> 25)) >> 26)) >> 25)) >> 26)) >> 25)) >> 26)) >> 25) * 19) + i;
        int i12 = i11 >> 26;
        int i13 = i2 + i12;
        int i14 = i11 - (i12 << 26);
        int i15 = i13 >> 25;
        int i16 = i3 + i15;
        int i17 = i13 - (i15 << 25);
        int i18 = i16 >> 26;
        int i19 = i4 + i18;
        int i20 = i16 - (i18 << 26);
        int i21 = i19 >> 25;
        int i22 = i5 + i21;
        int i23 = i19 - (i21 << 25);
        int i24 = i22 >> 26;
        int i25 = i6 + i24;
        int i26 = i22 - (i24 << 26);
        int i27 = i25 >> 25;
        int i28 = i7 + i27;
        int i29 = i25 - (i27 << 25);
        int i30 = i28 >> 26;
        int i31 = i8 + i30;
        int i32 = i28 - (i30 << 26);
        int i33 = i31 >> 25;
        int i34 = i9 + i33;
        int i35 = i31 - (i33 << 25);
        int i36 = i34 >> 26;
        int i37 = i10 + i36;
        int i38 = i34 - (i36 << 26);
        int i39 = i37 - ((i37 >> 25) << 25);
        return new byte[]{(byte) i14, (byte) (i14 >> 8), (byte) (i14 >> 16), (byte) ((i14 >> 24) | (i17 << 2)), (byte) (i17 >> 6), (byte) (i17 >> 14), (byte) ((i17 >> 22) | (i20 << 3)), (byte) (i20 >> 5), (byte) (i20 >> 13), (byte) ((i20 >> 21) | (i23 << 5)), (byte) (i23 >> 3), (byte) (i23 >> 11), (byte) ((i23 >> 19) | (i26 << 6)), (byte) (i26 >> 2), (byte) (i26 >> 10), (byte) (i26 >> 18), (byte) i29, (byte) (i29 >> 8), (byte) (i29 >> 16), (byte) ((i29 >> 24) | (i32 << 1)), (byte) (i32 >> 7), (byte) (i32 >> 15), (byte) ((i32 >> 23) | (i35 << 3)), (byte) (i35 >> 5), (byte) (i35 >> 13), (byte) ((i35 >> 21) | (i38 << 4)), (byte) (i38 >> 4), (byte) (i38 >> 12), (byte) ((i38 >> 20) | (i39 << 6)), (byte) (i39 >> 2), (byte) (i39 >> 10), (byte) (i39 >> 18)};
    }
}
