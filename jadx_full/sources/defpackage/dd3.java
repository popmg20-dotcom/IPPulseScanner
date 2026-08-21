package defpackage;

import io.netty.handler.codec.dns.DnsRecord;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dd3 extends kf2 {
    public final byte[] c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dd3(int i, int i2, int[] iArr) {
        super(i, i2);
        int i3 = i * i2;
        if (iArr.length < i3) {
            xe.k("Pixel array length is less than width * height");
            throw null;
        }
        byte[] bArr = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = iArr[i4];
            bArr[i4] = (byte) (((((i5 >> 16) & DnsRecord.CLASS_ANY) + ((i5 >> 7) & 510)) + (i5 & DnsRecord.CLASS_ANY)) / 4);
        }
        this.c = bArr;
        this.d = i;
        this.e = i2;
        this.f = 0;
        this.g = 0;
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
        int i5 = (this.g * i3) + this.f;
        if (i == i3) {
            System.arraycopy(bArr, i5, bArr2, 0, i4);
            return bArr2;
        }
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
        System.arraycopy(this.c, ((i + this.g) * this.d) + this.f, bArr, 0, i2);
        return bArr;
    }
}
