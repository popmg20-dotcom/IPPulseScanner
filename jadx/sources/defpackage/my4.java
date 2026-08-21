package defpackage;

import io.netty.handler.codec.dns.DnsRecord;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class my4 {
    public static final int[] b = new int[256];
    public final int[] a = new int[3];

    static {
        for (int i = 0; i < 256; i++) {
            int i2 = i;
            for (int i3 = 0; i3 < 8; i3++) {
                i2 = (i2 & 1) == 1 ? (i2 >>> 1) ^ (-306674912) : i2 >>> 1;
            }
            b[i] = i2;
        }
    }

    public final byte a() {
        int i = this.a[2] | 2;
        return (byte) ((i * (i ^ 1)) >>> 8);
    }

    public final void b(char[] cArr, boolean z) {
        int[] iArr = this.a;
        iArr[0] = 305419896;
        iArr[1] = 591751049;
        iArr[2] = 878082192;
        for (byte b2 : yr2.k(cArr, z)) {
            c((byte) (b2 & 255));
        }
    }

    public final void c(byte b2) {
        int[] iArr = this.a;
        int i = iArr[0];
        int i2 = i >>> 8;
        int i3 = (b2 ^ i) & DnsRecord.CLASS_ANY;
        int[] iArr2 = b;
        int i4 = iArr2[i3] ^ i2;
        iArr[0] = i4;
        int i5 = iArr[1] + (i4 & DnsRecord.CLASS_ANY);
        iArr[1] = i5;
        int i6 = (i5 * 134775813) + 1;
        iArr[1] = i6;
        int i7 = iArr[2];
        iArr[2] = iArr2[(i7 ^ ((byte) (i6 >> 24))) & DnsRecord.CLASS_ANY] ^ (i7 >>> 8);
    }
}
