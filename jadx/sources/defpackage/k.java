package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class k implements sk0 {
    public byte[] A;
    public byte[] X;
    public m b;
    public qt f;
    public int z;

    @Override // defpackage.sk0
    public final int r(int i, int i2, byte[] bArr) throws qy4 {
        byte[] bArr2 = this.X;
        byte[] bArr3 = this.A;
        int i3 = i;
        while (true) {
            int i4 = i + i2;
            if (i3 >= i4) {
                return i2;
            }
            int i5 = i3 + 16;
            int i6 = i5 <= i4 ? 16 : i4 - i3;
            this.f.w(bArr, i3, i6);
            co4.N(this.z, bArr3);
            this.b.a(bArr3, bArr2);
            for (int i7 = 0; i7 < i6; i7++) {
                int i8 = i3 + i7;
                bArr[i8] = (byte) (bArr[i8] ^ bArr2[i7]);
            }
            this.z++;
            i3 = i5;
        }
    }
}
