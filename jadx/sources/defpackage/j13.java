package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j13 extends kf2 {
    public final byte[] c;
    public final int d;
    public final int e;

    public j13(int i, int i2, int i3, int i4, byte[] bArr) {
        super(i3, i4);
        if (i3 > i || i4 > i2) {
            xe.k("Crop rectangle does not fit within image data.");
            throw null;
        }
        this.c = bArr;
        this.d = i;
        this.e = i2;
    }

    @Override // defpackage.kf2
    public final byte[] a() {
        byte[] bArr = this.c;
        int i = this.a;
        int i2 = this.b;
        int i3 = this.d;
        if (i == i3 && i2 == this.e) {
            return bArr;
        }
        int i4 = i * i2;
        byte[] bArr2 = new byte[i4];
        if (i == i3) {
            System.arraycopy(bArr, 0, bArr2, 0, i4);
            return bArr2;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            System.arraycopy(bArr, i5, bArr2, i6 * i, i);
            i5 += i3;
        }
        return bArr2;
    }

    @Override // defpackage.kf2
    public final byte[] b(int i, byte[] bArr) {
        if (i < 0 || i >= this.b) {
            xe.k(dw2.A(i, "Requested row is outside the image: "));
            return null;
        }
        int i2 = this.a;
        if (bArr == null || bArr.length < i2) {
            bArr = new byte[i2];
        }
        System.arraycopy(this.c, i * this.d, bArr, 0, i2);
        return bArr;
    }
}
