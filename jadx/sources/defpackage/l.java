package defpackage;

import java.security.SecureRandom;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements s41 {
    public boolean A;
    public final byte[] A0;
    public final byte[] Z;
    public final m b;
    public final qt f;
    public final byte[] y0;
    public final byte[] z0;
    public final SecureRandom z = new SecureRandom();
    public int X = 1;
    public int Y = 0;

    public l(char[] cArr, int i, boolean z) throws qy4 {
        if (cArr == null || cArr.length == 0) {
            st4.j("input password is empty or null");
            throw null;
        }
        if (i != 1 && i != 3) {
            st4.j("Invalid AES key strength");
            throw null;
        }
        this.A = false;
        this.y0 = new byte[16];
        this.Z = new byte[16];
        int iM = fw.m(i);
        if (iM != 8 && iM != 16) {
            st4.j("invalid salt size, cannot generate salt");
            throw null;
        }
        int i2 = iM == 8 ? 2 : 4;
        byte[] bArr = new byte[iM];
        for (int i3 = 0; i3 < i2; i3++) {
            int iNextInt = this.z.nextInt();
            int i4 = i3 * 4;
            bArr[i4] = (byte) (iNextInt >> 24);
            bArr[i4 + 1] = (byte) (iNextInt >> 16);
            bArr[i4 + 2] = (byte) (iNextInt >> 8);
            bArr[i4 + 3] = (byte) iNextInt;
        }
        this.A0 = bArr;
        byte[] bArrN = co4.n(bArr, cArr, i, z);
        byte[] bArr2 = new byte[2];
        System.arraycopy(bArrN, fw.j(i) + fw.i(i), bArr2, 0, 2);
        this.z0 = bArr2;
        this.b = co4.r(i, bArrN);
        int iJ = fw.j(i);
        byte[] bArr3 = new byte[iJ];
        System.arraycopy(bArrN, fw.i(i), bArr3, 0, iJ);
        qt qtVar = new qt((byte) 0, 11);
        qtVar.k(bArr3);
        this.f = qtVar;
    }

    @Override // defpackage.s41
    public final int b(int i, int i2, byte[] bArr) throws qy4 {
        int i3;
        if (this.A) {
            st4.j("AES Encrypter is in finished state (A non 16 byte block has already been passed to encrypter)");
            return 0;
        }
        if (i2 % 16 != 0) {
            this.A = true;
        }
        int i4 = i;
        while (true) {
            int i5 = i + i2;
            if (i4 >= i5) {
                return i2;
            }
            int i6 = i4 + 16;
            this.Y = i6 <= i5 ? 16 : i5 - i4;
            int i7 = this.X;
            byte[] bArr2 = this.Z;
            co4.N(i7, bArr2);
            m mVar = this.b;
            byte[] bArr3 = this.y0;
            mVar.a(bArr2, bArr3);
            int i8 = 0;
            while (true) {
                i3 = this.Y;
                if (i8 < i3) {
                    int i9 = i4 + i8;
                    bArr[i9] = (byte) (bArr[i9] ^ bArr3[i8]);
                    i8++;
                }
            }
            this.f.w(bArr, i4, i3);
            this.X++;
            i4 = i6;
        }
    }
}
