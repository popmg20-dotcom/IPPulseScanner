package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class i20 extends fr1 {
    public final byte[] f;
    public final int g;

    public i20() {
        this.f = null;
        this.g = 0;
    }

    public final boolean a(int i, int i2, byte[] bArr) {
        if (i2 - i == this.g) {
            byte[] bArr2 = this.f;
            if (bArr == bArr2) {
                return true;
            }
            int i3 = 0;
            while (i < i2) {
                byte[] bArr3 = ek0.b;
                int i4 = i + 1;
                int i5 = i3 + 1;
                if (bArr3[bArr[i] & 255] == bArr3[bArr2[i3] & 255]) {
                    i = i4;
                    i3 = i5;
                }
            }
            return true;
        }
        return false;
    }

    public i20(int i, fr1 fr1Var, Object obj, byte[] bArr, int i2, fr1 fr1Var2) {
        super(i, fr1Var, obj, fr1Var2);
        this.f = bArr;
        this.g = i2;
    }
}
