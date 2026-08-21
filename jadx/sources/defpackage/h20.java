package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h20 extends kx3 {
    public static final int[] B0 = {115, 115};
    public final boolean A0;
    public final int[][] z0;

    public h20(String str, short[] sArr, byte[] bArr, int[][] iArr, boolean z) {
        super(str, sArr, bArr);
        this.z0 = iArr;
        this.A0 = z;
    }

    public static void C(int i, int[][] iArr, boolean z, v92 v92Var) {
        k0.b(v92Var);
        int[] iArr2 = {0};
        for (int i2 = 0; i2 < i; i2++) {
            int[] iArr3 = iArr[i2];
            iArr2[0] = iArr3[1];
            k01.j(iArr3[0], iArr2, 1, v92Var);
            int[] iArr4 = iArr[i2];
            iArr2[0] = iArr4[0];
            k01.j(iArr4[1], iArr2, 1, v92Var);
        }
        if (z) {
            k01.j(223, B0, 2, v92Var);
        }
    }

    @Override // defpackage.k0
    public void a(int i, v92 v92Var) {
        int[][] iArr = this.z0;
        C(iArr.length, iArr, this.A0, v92Var);
    }

    @Override // defpackage.k0
    public g20[] e(int i, byte[] bArr, int i2, int i3) {
        int i4;
        byte b;
        int i5;
        byte b2;
        int[][] iArr = this.z0;
        int i6 = bArr[i2] & 255;
        boolean z = this.A0;
        if (65 <= i6 && i6 <= 90) {
            g20 g20VarG = g20.g(1, i6 + 32);
            return (i6 == 83 && z && i3 > (i5 = i2 + 1) && ((b2 = bArr[i5]) == 83 || b2 == 115)) ? new g20[]{g20VarG, g20.g(2, 223)} : new g20[]{g20VarG};
        }
        if (97 <= i6 && i6 <= 122) {
            g20 g20VarG2 = g20.g(1, i6 - 32);
            return (i6 == 115 && z && i3 > (i4 = i2 + 1) && ((b = bArr[i4]) == 115 || b == 83)) ? new g20[]{g20VarG2, g20.g(2, 223)} : new g20[]{g20VarG2};
        }
        if (i6 == 223 && z) {
            return new g20[]{g20.h(1, 115, 115), g20.h(1, 83, 83), g20.h(1, 115, 83), g20.h(1, 83, 115)};
        }
        for (int[] iArr2 : iArr) {
            int i7 = iArr2[0];
            if (i6 == i7) {
                return new g20[]{g20.g(1, iArr2[1])};
            }
            if (i6 == iArr2[1]) {
                return new g20[]{g20.g(1, i7)};
            }
        }
        return g20.A;
    }
}
