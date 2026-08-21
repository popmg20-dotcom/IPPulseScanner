package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fb5 extends hb5 {
    public final int A;

    public fb5(byte[] bArr, int i) {
        super(bArr);
        hb5.e(0, i, bArr.length);
        this.A = i;
    }

    @Override // defpackage.hb5
    public final byte a(int i) {
        int i2 = this.A;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.f[i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 11);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(i).length() + 18 + String.valueOf(i2).length());
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(i2);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    @Override // defpackage.hb5
    public final byte b(int i) {
        return this.f[i];
    }

    @Override // defpackage.hb5
    public final int c() {
        return this.A;
    }
}
