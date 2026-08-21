package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import javax.crypto.Mac;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class j6 extends u40 {
    public int A0;
    public int B0;
    public int C0;
    public byte[] X;
    public byte[] Y;
    public int Z;
    public int y0;
    public int z0;

    @Override // defpackage.u40
    public final void g(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[10];
        if (yr2.f0(inputStream, bArr) != 10) {
            st4.j("Invalid AES Mac bytes. Could not read sufficient data");
            return;
        }
        qt qtVar = ((k) this.f).f;
        if (((ByteArrayOutputStream) qtVar.d).size() > 0) {
            qtVar.g(i);
        }
        byte[] bArr2 = new byte[10];
        System.arraycopy(((Mac) qtVar.c).doFinal(), 0, bArr2, 0, 10);
        if (Arrays.equals(bArr, bArr2)) {
            return;
        }
        vp1.i("Reached end of data for this entry, but aes verification failed");
    }

    @Override // defpackage.u40
    public final sk0 n(qd2 qd2Var, char[] cArr, boolean z) throws IOException {
        n nVar = qd2Var.r;
        if (nVar == null) {
            vp1.i("invalid aes extra data record");
            return null;
        }
        int i = nVar.g;
        if (i == 0) {
            vp1.i("Invalid aes key strength in aes extra data record");
            return null;
        }
        byte[] bArr = new byte[fw.m(i)];
        s(bArr);
        byte[] bArr2 = new byte[2];
        s(bArr2);
        k kVar = new k();
        kVar.z = 1;
        kVar.A = new byte[16];
        kVar.X = new byte[16];
        if (cArr == null || cArr.length <= 0) {
            throw new qy4("empty or null password provided for AES decryption", 1);
        }
        int i2 = nVar.g;
        byte[] bArrN = co4.n(bArr, cArr, i2, z);
        byte[] bArr3 = new byte[2];
        System.arraycopy(bArrN, fw.j(i2) + fw.i(i2), bArr3, 0, 2);
        if (!Arrays.equals(bArr2, bArr3)) {
            throw new qy4("Wrong Password", 1);
        }
        kVar.b = co4.r(i2, bArrN);
        int iJ = fw.j(i2);
        byte[] bArr4 = new byte[iJ];
        System.arraycopy(bArrN, fw.i(i2), bArr4, 0, iJ);
        qt qtVar = new qt((byte) 0, 11);
        qtVar.k(bArr4);
        kVar.f = qtVar;
        return kVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
    @Override // defpackage.u40, java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int read(byte[] r4, int r5, int r6) {
        /*
            r3 = this;
            r3.z0 = r6
            r3.A0 = r5
            r0 = 0
            r3.B0 = r0
            int r1 = r3.y0
            if (r1 == 0) goto L13
            r3.x(r5, r4)
            int r5 = r3.B0
            if (r5 != r6) goto L13
            return r5
        L13:
            int r5 = r3.z0
            r1 = 16
            r2 = -1
            if (r5 >= r1) goto L38
            byte[] r5 = r3.Y
            int r1 = r5.length
            int r5 = super.read(r5, r0, r1)
            r3.Z = r0
            if (r5 != r2) goto L2c
            r3.y0 = r0
            int r3 = r3.B0
            if (r3 <= 0) goto L4a
            return r3
        L2c:
            r3.y0 = r5
            int r5 = r3.A0
            r3.x(r5, r4)
            int r5 = r3.B0
            if (r5 != r6) goto L38
            return r5
        L38:
            int r5 = r3.A0
            int r6 = r3.z0
            int r0 = r6 % 16
            int r6 = r6 - r0
            int r4 = super.read(r4, r5, r6)
            int r3 = r3.B0
            if (r4 != r2) goto L4b
            if (r3 <= 0) goto L4a
            return r3
        L4a:
            return r2
        L4b:
            int r4 = r4 + r3
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.j6.read(byte[], int, int):int");
    }

    public final void x(int i, byte[] bArr) {
        int i2 = this.z0;
        int i3 = this.y0;
        if (i2 >= i3) {
            i2 = i3;
        }
        this.C0 = i2;
        System.arraycopy(this.Y, this.Z, bArr, i, i2);
        int i4 = this.C0;
        int i5 = this.Z + i4;
        this.Z = i5;
        if (i5 >= 15) {
            this.Z = 15;
        }
        int i6 = this.y0 - i4;
        this.y0 = i6;
        if (i6 <= 0) {
            this.y0 = 0;
        }
        this.B0 += i4;
        this.z0 -= i4;
        this.A0 += i4;
    }

    @Override // defpackage.u40, java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // defpackage.u40, java.io.InputStream
    public final int read() {
        byte[] bArr = this.X;
        if (read(bArr, 0, bArr.length) == -1) {
            return -1;
        }
        return bArr[0];
    }
}
