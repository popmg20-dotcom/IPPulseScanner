package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class cu extends fr1 {
    public final byte[] f;
    public final int g;
    public final int h;

    public cu() {
        this.f = null;
        this.h = 0;
        this.g = 0;
    }

    public final boolean a(int i, int i2, byte[] bArr) {
        int i3 = this.h;
        int i4 = this.g;
        if (i3 - i4 != i2 - i) {
            return false;
        }
        byte[] bArr2 = this.f;
        if (bArr2 == bArr) {
            return true;
        }
        while (i4 < i3) {
            int i5 = i4 + 1;
            int i6 = i + 1;
            if (bArr2[i4] != bArr[i]) {
                return false;
            }
            i4 = i5;
            i = i6;
        }
        return true;
    }

    public cu(int i, fr1 fr1Var, Object obj, byte[] bArr, int i2, int i3, fr1 fr1Var2) {
        super(i, fr1Var, obj, fr1Var2);
        this.f = bArr;
        this.g = i2;
        this.h = i3;
    }
}
