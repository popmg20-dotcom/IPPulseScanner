package defpackage;

import io.netty.handler.codec.dns.DnsRecord;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class um2 extends k0 {
    public final int[] A0;
    public final int[] y0;
    public final int[][] z0;

    public um2(String str, int i, int i2, int[] iArr, int[][] iArr2, short[] sArr) {
        super(str, i, i2, sArr);
        this.y0 = iArr;
        this.z0 = iArr2;
        this.A0 = iArr2 != null ? iArr2[0] : null;
    }

    public static boolean C(int i, int i2, int i3) {
        return i - i2 >= 0 && i3 - i >= 0;
    }

    public final int D(int i, int i2, int i3, int i4, byte[] bArr) {
        int i5 = i + 1;
        if (i5 == i2) {
            return J(i3, 1);
        }
        int[][] iArr = this.z0;
        int i6 = iArr[i4][bArr[i5] & 255];
        if (i6 < 0) {
            return i6 == -1 ? 2 : -1;
        }
        int i7 = i + 2;
        if (i7 == i2) {
            return J(i3, 2);
        }
        int i8 = iArr[i6][bArr[i7] & 255];
        if (i8 >= 0) {
            int i9 = i + 3;
            if (i9 == i2) {
                return J(i3, 3);
            }
            if (iArr[i8][bArr[i9] & 255] == -1) {
                return 4;
            }
        } else if (i8 == -1) {
            return 3;
        }
        return -1;
    }

    public final int E(int i, int i2, byte[] bArr) {
        int i3;
        if ((65280 & i) != 0) {
            i3 = i2 + 1;
            bArr[i2] = (byte) ((i >>> 8) & DnsRecord.CLASS_ANY);
        } else {
            i3 = i2;
        }
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i & DnsRecord.CLASS_ANY);
        int iR = r(i2, i4, bArr);
        int i5 = i4 - i2;
        if (iR != i5) {
            return -400;
        }
        return i5;
    }

    public final int G(byte[] bArr, ue2 ue2Var, int i, byte[] bArr2) {
        int i2 = ue2Var.b;
        int i3 = 0;
        if (k0.i(bArr[i2] & 255)) {
            bArr2[0] = ek0.b[bArr[i2] & 255];
            ue2Var.b++;
            return 1;
        }
        int iR = r(i2, i, bArr);
        int i4 = 0;
        while (i3 < iR) {
            bArr2[i4] = bArr[i2];
            i3++;
            i4++;
            i2++;
        }
        ue2Var.b += iR;
        return iR;
    }

    public final int H(int i, int i2, byte[] bArr) {
        int iR = r(i, i2, bArr);
        int i3 = bArr[i] & 255;
        int i4 = 1;
        if (iR == 1) {
            return i3;
        }
        for (int i5 = i + 1; i4 < iR && i5 < i2; i5++) {
            i3 = (i3 << 8) + (bArr[i5] & 255);
            i4++;
        }
        return i3;
    }

    public final int J(int i, int i2) {
        return (-1) - (this.y0[i] - i2);
    }

    public final int K(int i, int i2, byte[] bArr) {
        int i3 = bArr[i] & 255;
        int i4 = this.A0[i3];
        return i4 < 0 ? i4 == -1 ? 1 : -1 : D(i, i2, i3, i4, bArr);
    }

    public final int L(int i, int i2, byte[] bArr) {
        int i3 = bArr[i] & 255;
        int i4 = this.A0[i3];
        if (i4 >= 0) {
            int i5 = i + 1;
            if (i5 == i2) {
                return J(i3, 1);
            }
            if (this.z0[i4][bArr[i5] & 255] == -1) {
                return 2;
            }
        } else if (i4 == -1) {
            return 1;
        }
        return -1;
    }

    @Override // defpackage.k0
    public int f(int i, int i2, byte[] bArr) {
        int i3;
        if (((-16777216) & i) != 0) {
            i3 = i2 + 1;
            bArr[i2] = (byte) ((i >>> 24) & DnsRecord.CLASS_ANY);
        } else {
            i3 = i2;
        }
        if ((16711680 & i) != 0 || i3 != i2) {
            bArr[i3] = (byte) ((i >>> 16) & DnsRecord.CLASS_ANY);
            i3++;
        }
        if ((65280 & i) != 0 || i3 != i2) {
            bArr[i3] = (byte) ((i >>> 8) & DnsRecord.CLASS_ANY);
            i3++;
        }
        int i4 = i3 + 1;
        bArr[i3] = (byte) (i & DnsRecord.CLASS_ANY);
        int iR = r(i2, i4, bArr);
        int i5 = i4 - i2;
        if (iR != i5) {
            return -400;
        }
        return i5;
    }

    @Override // defpackage.k0
    public boolean j(int i, int i2) {
        return (((long) i) & 4294967295L) < 128 ? k(i, i2) : k0.p(i2) && g(i) > 1;
    }

    @Override // defpackage.k0
    public int r(int i, int i2, byte[] bArr) {
        return K(i, i2, bArr);
    }

    @Override // defpackage.k0
    public int u(int i, int i2, byte[] bArr) {
        return H(i, i2, bArr);
    }

    @Override // defpackage.k0
    public int z(int i, int i2, byte[] bArr) {
        int i3 = 0;
        while (i < i2) {
            i += r(i, i2, bArr);
            i3++;
        }
        return i3;
    }
}
