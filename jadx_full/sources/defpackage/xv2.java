package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class xv2 extends zv2 {
    public int[] f;
    public final int g;

    public xv2(String str, byte[] bArr) {
        super(str, bArr);
        this.g = str.length() - 1;
    }

    @Override // defpackage.zv2
    public final int a(int i) {
        int i2 = this.g;
        if (i == i2 + 1) {
            return this.b;
        }
        if (i < 0 || i > i2) {
            d(i, i2, "Char");
            throw null;
        }
        if (i == 0) {
            return 0;
        }
        int[] iArrE = e();
        int iBinarySearch = Arrays.binarySearch(iArrE, i);
        while (iBinarySearch > 0 && iArrE[iBinarySearch - 1] == i) {
            iBinarySearch--;
        }
        return iBinarySearch;
    }

    @Override // defpackage.zv2
    public final int b(int i) {
        int i2 = this.b;
        if (i == i2) {
            return this.g + 1;
        }
        if (i < 0 || i >= i2) {
            d(i, i2 - 1, "Byte");
            throw null;
        }
        if (i == 0) {
            return 0;
        }
        return e()[i];
    }

    public final int[] e() {
        int[] iArr = this.f;
        if (iArr != null) {
            return iArr;
        }
        int i = this.b;
        int[] iArr2 = new int[i];
        int i2 = i - 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 <= i2) {
            int iR = tk4.F0.r(i3, i, this.c) + i3;
            while (i3 < iR) {
                iArr2[i3] = i4;
                i3++;
            }
            i4++;
        }
        this.f = iArr2;
        return iArr2;
    }
}
