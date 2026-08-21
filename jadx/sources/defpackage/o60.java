package defpackage;

import io.netty.channel.internal.ChannelUtils;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o60 extends p60 {
    public final FileInputStream c;
    public final byte[] d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;

    public o60(FileInputStream fileInputStream) {
        Charset charset = j12.a;
        this.c = fileInputStream;
        this.d = new byte[4096];
        this.e = 0;
        this.g = 0;
        this.i = 0;
    }

    public final byte[] A(int i) throws IOException {
        if (i == 0) {
            return j12.b;
        }
        if (i < 0) {
            throw t12.d();
        }
        int i2 = this.i;
        int i3 = this.g;
        int i4 = i2 + i3 + i;
        if (i4 - ChannelUtils.WRITE_STATUS_SNDBUF_FULL > 0) {
            throw new t12("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        }
        int i5 = this.j;
        if (i4 > i5) {
            J((i5 - i2) - i3);
            throw t12.e();
        }
        int i6 = this.e - i3;
        int i7 = i - i6;
        FileInputStream fileInputStream = this.c;
        if (i7 >= 4096) {
            try {
                if (i7 > fileInputStream.available()) {
                    return null;
                }
            } catch (t12 e) {
                e.b = true;
                throw e;
            }
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.d, this.g, bArr, 0, i6);
        this.i += this.e;
        this.g = 0;
        this.e = 0;
        while (i6 < i) {
            try {
                int i8 = fileInputStream.read(bArr, i6, i - i6);
                if (i8 == -1) {
                    throw t12.e();
                }
                this.i += i8;
                i6 += i8;
            } catch (t12 e2) {
                e2.b = true;
                throw e2;
            }
        }
        return bArr;
    }

    public final ArrayList B(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int iMin = Math.min(i, 4096);
            byte[] bArr = new byte[iMin];
            int i2 = 0;
            while (i2 < iMin) {
                int i3 = this.c.read(bArr, i2, iMin - i2);
                if (i3 == -1) {
                    throw t12.e();
                }
                this.i += i3;
                i2 += i3;
            }
            i -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    public final int C() throws t12 {
        int i = this.g;
        if (this.e - i < 4) {
            I(4);
            i = this.g;
        }
        this.g = i + 4;
        byte[] bArr = this.d;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public final long D() throws t12 {
        int i = this.g;
        if (this.e - i < 8) {
            I(8);
            i = this.g;
        }
        this.g = i + 8;
        byte[] bArr = this.d;
        return ((((long) bArr[i + 1]) & 255) << 8) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    public final int E() {
        int i;
        int i2 = this.g;
        int i3 = this.e;
        if (i3 != i2) {
            int i4 = i2 + 1;
            byte[] bArr = this.d;
            byte b = bArr[i2];
            if (b >= 0) {
                this.g = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b;
                if (i6 < 0) {
                    i = i6 ^ (-128);
                } else {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << 14) ^ i6;
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        int i9 = i2 + 4;
                        int i10 = i8 ^ (bArr[i7] << 21);
                        if (i10 < 0) {
                            i = (-2080896) ^ i10;
                        } else {
                            i7 = i2 + 5;
                            byte b2 = bArr[i9];
                            int i11 = (i10 ^ (b2 << 28)) ^ 266354560;
                            if (b2 < 0) {
                                i9 = i2 + 6;
                                if (bArr[i7] < 0) {
                                    i7 = i2 + 7;
                                    if (bArr[i9] < 0) {
                                        i9 = i2 + 8;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 9;
                                            if (bArr[i9] < 0) {
                                                int i12 = i2 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i5 = i12;
                                                    i = i11;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i11;
                            }
                            i = i11;
                        }
                        i5 = i9;
                    }
                    i5 = i7;
                }
                this.g = i5;
                return i;
            }
        }
        return (int) G();
    }

    public final long F() {
        long j;
        long j2;
        long j3;
        long j4;
        int i = this.g;
        int i2 = this.e;
        if (i2 != i) {
            int i3 = i + 1;
            byte[] bArr = this.d;
            byte b = bArr[i];
            if (b >= 0) {
                this.g = i3;
                return b;
            }
            if (i2 - i3 >= 9) {
                int i4 = i + 2;
                int i5 = (bArr[i3] << 7) ^ b;
                if (i5 < 0) {
                    j = i5 ^ (-128);
                } else {
                    int i6 = i + 3;
                    int i7 = (bArr[i4] << 14) ^ i5;
                    if (i7 >= 0) {
                        j = i7 ^ 16256;
                        i4 = i6;
                    } else {
                        int i8 = i + 4;
                        int i9 = i7 ^ (bArr[i6] << 21);
                        if (i9 < 0) {
                            j4 = (-2080896) ^ i9;
                        } else {
                            long j5 = i9;
                            i4 = i + 5;
                            long j6 = j5 ^ (((long) bArr[i8]) << 28);
                            if (j6 >= 0) {
                                j3 = 266354560;
                            } else {
                                i8 = i + 6;
                                long j7 = j6 ^ (((long) bArr[i4]) << 35);
                                if (j7 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    i4 = i + 7;
                                    j6 = j7 ^ (((long) bArr[i8]) << 42);
                                    if (j6 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i8 = i + 8;
                                        j7 = j6 ^ (((long) bArr[i4]) << 49);
                                        if (j7 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            i4 = i + 9;
                                            long j8 = (j7 ^ (((long) bArr[i8]) << 56)) ^ 71499008037633920L;
                                            if (j8 < 0) {
                                                int i10 = i + 10;
                                                if (bArr[i4] >= 0) {
                                                    i4 = i10;
                                                }
                                            }
                                            j = j8;
                                        }
                                    }
                                }
                                j4 = j2 ^ j7;
                            }
                            j = j3 ^ j6;
                        }
                        i4 = i8;
                        j = j4;
                    }
                }
                this.g = i4;
                return j;
            }
        }
        return G();
    }

    public final long G() throws t12 {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            if (this.g == this.e) {
                I(1);
            }
            int i2 = this.g;
            this.g = i2 + 1;
            byte b = this.d[i2];
            j |= ((long) (b & 127)) << i;
            if ((b & 128) == 0) {
                return j;
            }
        }
        throw t12.c();
    }

    public final void H() {
        int i = this.e + this.f;
        this.e = i;
        int i2 = this.i + i;
        int i3 = this.j;
        if (i2 <= i3) {
            this.f = 0;
            return;
        }
        int i4 = i2 - i3;
        this.f = i4;
        this.e = i - i4;
    }

    public final void I(int i) throws t12 {
        if (K(i)) {
            return;
        }
        if (i <= (ChannelUtils.WRITE_STATUS_SNDBUF_FULL - this.i) - this.g) {
            throw t12.e();
        }
        throw new t12("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public final void J(int i) throws t12 {
        int i2 = this.e;
        int i3 = this.g;
        int i4 = i2 - i3;
        if (i <= i4 && i >= 0) {
            this.g = i3 + i;
            return;
        }
        FileInputStream fileInputStream = this.c;
        if (i < 0) {
            throw t12.d();
        }
        int i5 = this.i;
        int i6 = i5 + i3;
        int i7 = i6 + i;
        int i8 = this.j;
        if (i7 > i8) {
            J((i8 - i5) - i3);
            throw t12.e();
        }
        this.i = i6;
        this.e = 0;
        this.g = 0;
        while (i4 < i) {
            long j = i - i4;
            try {
                try {
                    long jSkip = fileInputStream.skip(j);
                    if (jSkip < 0 || jSkip > j) {
                        throw new IllegalStateException(fileInputStream.getClass() + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                    }
                    if (jSkip == 0) {
                        break;
                    } else {
                        i4 += (int) jSkip;
                    }
                } catch (t12 e) {
                    e.b = true;
                    throw e;
                }
            } catch (Throwable th) {
                this.i += i4;
                H();
                throw th;
            }
        }
        this.i += i4;
        H();
        if (i4 >= i) {
            return;
        }
        int i9 = this.e;
        int i10 = i9 - this.g;
        this.g = i9;
        I(1);
        while (true) {
            int i11 = i - i10;
            int i12 = this.e;
            if (i11 <= i12) {
                this.g = i11;
                return;
            } else {
                i10 += i12;
                this.g = i12;
                I(1);
            }
        }
    }

    public final boolean K(int i) throws IOException {
        FileInputStream fileInputStream = this.c;
        int i2 = this.g;
        int i3 = i2 + i;
        int i4 = this.e;
        if (i3 <= i4) {
            xe.q(ha0.k("refillBuffer() called when ", i, " bytes were already available in buffer"));
            return false;
        }
        int i5 = this.i;
        if (i <= (ChannelUtils.WRITE_STATUS_SNDBUF_FULL - i5) - i2 && i5 + i2 + i <= this.j) {
            byte[] bArr = this.d;
            if (i2 > 0) {
                if (i4 > i2) {
                    System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
                }
                i5 = this.i + i2;
                this.i = i5;
                i4 = this.e - i2;
                this.e = i4;
                this.g = 0;
            }
            try {
                int i6 = fileInputStream.read(bArr, i4, Math.min(bArr.length - i4, (ChannelUtils.WRITE_STATUS_SNDBUF_FULL - i5) - i4));
                if (i6 == 0 || i6 < -1 || i6 > bArr.length) {
                    throw new IllegalStateException(fileInputStream.getClass() + "#read(byte[]) returned invalid result: " + i6 + "\nThe InputStream implementation is buggy.");
                }
                if (i6 > 0) {
                    this.e += i6;
                    H();
                    if (this.e >= i) {
                        return true;
                    }
                    return K(i);
                }
            } catch (t12 e) {
                e.b = true;
                throw e;
            }
        }
        return false;
    }

    @Override // defpackage.p60
    public final void a(int i) throws t12 {
        if (this.h != i) {
            throw new t12("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // defpackage.p60
    public final int b() {
        return this.i + this.g;
    }

    @Override // defpackage.p60
    public final boolean c() {
        return this.g == this.e && !K(1);
    }

    @Override // defpackage.p60
    public final void d(int i) {
        this.j = i;
        H();
    }

    @Override // defpackage.p60
    public final int e(int i) throws t12 {
        if (i < 0) {
            throw t12.d();
        }
        int i2 = this.i + this.g + i;
        if (i2 < 0) {
            throw new t12("Failed to parse the message.");
        }
        int i3 = this.j;
        if (i2 > i3) {
            throw t12.e();
        }
        this.j = i2;
        H();
        return i3;
    }

    @Override // defpackage.p60
    public final boolean f() {
        return F() != 0;
    }

    @Override // defpackage.p60
    public final au g() throws IOException {
        int iE = E();
        int i = this.e;
        int i2 = this.g;
        int i3 = i - i2;
        byte[] bArr = this.d;
        if (iE <= i3 && iE > 0) {
            au auVarC = au.c(i2, iE, bArr);
            this.g += iE;
            return auVarC;
        }
        if (iE == 0) {
            return au.z;
        }
        if (iE < 0) {
            throw t12.d();
        }
        byte[] bArrA = A(iE);
        if (bArrA != null) {
            return au.c(0, bArrA.length, bArrA);
        }
        int i4 = this.g;
        int i5 = this.e;
        int length = i5 - i4;
        this.i += i5;
        this.g = 0;
        this.e = 0;
        ArrayList<byte[]> arrayListB = B(iE - length);
        byte[] bArr2 = new byte[iE];
        System.arraycopy(bArr, i4, bArr2, 0, length);
        for (byte[] bArr3 : arrayListB) {
            System.arraycopy(bArr3, 0, bArr2, length, bArr3.length);
            length += bArr3.length;
        }
        au auVar = au.z;
        return new au(bArr2);
    }

    @Override // defpackage.p60
    public final double h() {
        return Double.longBitsToDouble(D());
    }

    @Override // defpackage.p60
    public final int i() {
        return E();
    }

    @Override // defpackage.p60
    public final int j() {
        return C();
    }

    @Override // defpackage.p60
    public final long k() {
        return D();
    }

    @Override // defpackage.p60
    public final float l() {
        return Float.intBitsToFloat(C());
    }

    @Override // defpackage.p60
    public final int m() {
        return E();
    }

    @Override // defpackage.p60
    public final long n() {
        return F();
    }

    @Override // defpackage.p60
    public final int o() {
        return C();
    }

    @Override // defpackage.p60
    public final long p() {
        return D();
    }

    @Override // defpackage.p60
    public final int q() {
        int iE = E();
        return (-(iE & 1)) ^ (iE >>> 1);
    }

    @Override // defpackage.p60
    public final long r() {
        long jF = F();
        return (-(jF & 1)) ^ (jF >>> 1);
    }

    @Override // defpackage.p60
    public final String s() throws t12 {
        int iE = E();
        byte[] bArr = this.d;
        if (iE > 0) {
            int i = this.e;
            int i2 = this.g;
            if (iE <= i - i2) {
                String str = new String(bArr, i2, iE, j12.a);
                this.g += iE;
                return str;
            }
        }
        if (iE == 0) {
            return "";
        }
        if (iE < 0) {
            throw t12.d();
        }
        if (iE > this.e) {
            return new String(z(iE), j12.a);
        }
        I(iE);
        String str2 = new String(bArr, this.g, iE, j12.a);
        this.g += iE;
        return str2;
    }

    @Override // defpackage.p60
    public final String t() throws IOException {
        int iE = E();
        int i = this.g;
        int i2 = this.e;
        int i3 = i2 - i;
        byte[] bArrZ = this.d;
        if (iE <= i3 && iE > 0) {
            this.g = i + iE;
        } else {
            if (iE == 0) {
                return "";
            }
            if (iE < 0) {
                throw t12.d();
            }
            i = 0;
            if (iE <= i2) {
                I(iE);
                this.g = iE;
            } else {
                bArrZ = z(iE);
            }
        }
        return ao4.a.l(i, iE, bArrZ);
    }

    @Override // defpackage.p60
    public final int u() throws t12 {
        if (c()) {
            this.h = 0;
            return 0;
        }
        int iE = E();
        this.h = iE;
        if ((iE >>> 3) != 0) {
            return iE;
        }
        throw new t12("Protocol message contained an invalid tag (zero).");
    }

    @Override // defpackage.p60
    public final int v() {
        return E();
    }

    @Override // defpackage.p60
    public final long w() {
        return F();
    }

    @Override // defpackage.p60
    public final boolean x(int i) throws t12 {
        int i2 = i & 7;
        int i3 = 0;
        if (i2 != 0) {
            if (i2 == 1) {
                J(8);
                return true;
            }
            if (i2 == 2) {
                J(E());
                return true;
            }
            if (i2 == 3) {
                y();
                a(((i >>> 3) << 3) | 4);
                return true;
            }
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw t12.b();
            }
            J(4);
            return true;
        }
        int i4 = this.e - this.g;
        byte[] bArr = this.d;
        if (i4 >= 10) {
            while (i3 < 10) {
                int i5 = this.g;
                this.g = i5 + 1;
                if (bArr[i5] < 0) {
                    i3++;
                }
            }
            throw t12.c();
        }
        while (i3 < 10) {
            if (this.g == this.e) {
                I(1);
            }
            int i6 = this.g;
            this.g = i6 + 1;
            if (bArr[i6] < 0) {
                i3++;
            }
        }
        throw t12.c();
        return true;
    }

    public final byte[] z(int i) throws IOException {
        byte[] bArrA = A(i);
        if (bArrA != null) {
            return bArrA;
        }
        int i2 = this.g;
        int i3 = this.e;
        int length = i3 - i2;
        this.i += i3;
        this.g = 0;
        this.e = 0;
        ArrayList<byte[]> arrayListB = B(i - length);
        byte[] bArr = new byte[i];
        System.arraycopy(this.d, i2, bArr, 0, length);
        for (byte[] bArr2 : arrayListB) {
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        return bArr;
    }
}
