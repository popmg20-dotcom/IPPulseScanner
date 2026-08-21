package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r00 extends um2 {
    public final boolean[] B0;

    public r00(String str, int[] iArr, int[][] iArr2, short[] sArr, boolean[] zArr) {
        super(str, 1, 2, iArr, iArr2, sArr);
        this.B0 = zArr;
    }

    @Override // defpackage.um2, defpackage.k0
    public int f(int i, int i2, byte[] bArr) {
        return E(i, i2, bArr);
    }

    @Override // defpackage.k0
    public final boolean n(byte[] bArr) {
        return !this.B0[bArr[0] & 255];
    }

    @Override // defpackage.k0
    public final int q(int i, int i2, int i3, byte[] bArr) {
        int i4;
        if (i2 <= i) {
            return i2;
        }
        if (this.B0[bArr[i2] & 255]) {
            i4 = i2;
            while (i4 > i) {
                int i5 = i4 - 1;
                if (this.y0[bArr[i5] & 255] <= 1) {
                    break;
                }
                i4 = i5;
            }
        } else {
            i4 = i2;
        }
        int iR = r(i4, i3, bArr) + i4;
        return iR > i2 ? i4 : iR + ((i2 - iR) & (-2));
    }

    @Override // defpackage.um2, defpackage.k0
    public int r(int i, int i2, byte[] bArr) {
        return L(i, i2, bArr);
    }
}
