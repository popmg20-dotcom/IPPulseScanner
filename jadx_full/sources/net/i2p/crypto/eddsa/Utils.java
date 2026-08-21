package net.i2p.crypto.eddsa;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class Utils {
    public static int a(int i, int i2) {
        int i3 = i ^ i2;
        int i4 = 0;
        for (int i5 = 0; i5 < 8; i5++) {
            i4 |= i3 >> i5;
        }
        return (i4 ^ 1) & 1;
    }

    public static byte[] b(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) (Character.digit(str.charAt(i + 1), 16) + (Character.digit(str.charAt(i), 16) << 4));
        }
        return bArr;
    }
}
