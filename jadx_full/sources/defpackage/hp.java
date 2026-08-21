package defpackage;

import io.netty.handler.codec.dns.DnsRecord;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class hp implements cq, bq, Cloneable, ByteChannel {
    public rr3 b;
    public long f;

    @Override // defpackage.bq
    public final long A(lz3 lz3Var) {
        lz3Var.getClass();
        long j = 0;
        while (true) {
            long jT0 = lz3Var.t0(this, 8192L);
            if (jT0 == -1) {
                return j;
            }
            j += jT0;
        }
    }

    @Override // defpackage.bq
    public final /* bridge */ /* synthetic */ bq A0(bu buVar) {
        I0(buVar);
        return this;
    }

    @Override // defpackage.cq
    public final byte[] B() {
        return X(this.f);
    }

    public final byte C(long j) {
        l72.f(this.f, j, 1L);
        rr3 rr3Var = this.b;
        rr3Var.getClass();
        long j2 = this.f;
        if (j2 - j < j) {
            while (j2 > j) {
                rr3Var = rr3Var.g;
                rr3Var.getClass();
                j2 -= (long) (rr3Var.c - rr3Var.b);
            }
            return rr3Var.a[(int) ((((long) rr3Var.b) + j) - j2)];
        }
        long j3 = 0;
        while (true) {
            int i = rr3Var.c;
            int i2 = rr3Var.b;
            long j4 = ((long) (i - i2)) + j3;
            if (j4 > j) {
                return rr3Var.a[(int) ((((long) i2) + j) - j3)];
            }
            rr3Var = rr3Var.f;
            rr3Var.getClass();
            j3 = j4;
        }
    }

    @Override // defpackage.cq
    public final int D(qw2 qw2Var) throws EOFException {
        qw2Var.getClass();
        int iC = b.c(this, qw2Var, false);
        if (iC == -1) {
            return -1;
        }
        z0(qw2Var.b[iC].d());
        return iC;
    }

    @Override // defpackage.cq
    public final InputStream E0() {
        return new gp(this, 0);
    }

    public final bu F0(int i) {
        if (i == 0) {
            return bu.A;
        }
        l72.f(this.f, 0L, i);
        rr3 rr3Var = this.b;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            rr3Var.getClass();
            int i5 = rr3Var.c;
            int i6 = rr3Var.b;
            if (i5 == i6) {
                xe.i("s.limit == s.pos");
                return null;
            }
            i3 += i5 - i6;
            i4++;
            rr3Var = rr3Var.f;
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[i4 * 2];
        rr3 rr3Var2 = this.b;
        int i7 = 0;
        while (i2 < i) {
            rr3Var2.getClass();
            bArr[i7] = rr3Var2.a;
            i2 += rr3Var2.c - rr3Var2.b;
            iArr[i7] = Math.min(i2, i);
            iArr[i7 + i4] = rr3Var2.b;
            rr3Var2.d = true;
            i7++;
            rr3Var2 = rr3Var2.f;
        }
        return new ur3(bArr, iArr);
    }

    public final rr3 G0(int i) {
        if (i < 1 || i > 8192) {
            xe.k("unexpected capacity");
            return null;
        }
        rr3 rr3Var = this.b;
        if (rr3Var == null) {
            rr3 rr3VarB = tr3.b();
            this.b = rr3VarB;
            rr3VarB.g = rr3VarB;
            rr3VarB.f = rr3VarB;
            return rr3VarB;
        }
        rr3 rr3Var2 = rr3Var.g;
        rr3Var2.getClass();
        if (rr3Var2.c + i <= 8192 && rr3Var2.e) {
            return rr3Var2;
        }
        rr3 rr3VarB2 = tr3.b();
        rr3Var2.b(rr3VarB2);
        return rr3VarB2;
    }

    public final void H0(int i, byte[] bArr) {
        bArr.getClass();
        long j = i;
        l72.f(bArr.length, 0L, j);
        int i2 = 0;
        while (i2 < i) {
            rr3 rr3VarG0 = G0(1);
            int iMin = Math.min(i - i2, 8192 - rr3VarG0.c);
            int i3 = i2 + iMin;
            qe.d0(bArr, rr3VarG0.c, i2, rr3VarG0.a, i3);
            rr3VarG0.c += iMin;
            i2 = i3;
        }
        this.f += j;
    }

    public final void I0(bu buVar) {
        buVar.getClass();
        buVar.s(this, buVar.d());
    }

    public final void J0(int i) {
        rr3 rr3VarG0 = G0(1);
        byte[] bArr = rr3VarG0.a;
        int i2 = rr3VarG0.c;
        rr3VarG0.c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f++;
    }

    public final void K0(long j) {
        boolean z;
        if (j == 0) {
            J0(48);
            return;
        }
        if (j < 0) {
            j = -j;
            if (j < 0) {
                Q0("-9223372036854775808");
                return;
            }
            z = true;
        } else {
            z = false;
        }
        byte[] bArr = b.a;
        int iNumberOfLeadingZeros = ((64 - Long.numberOfLeadingZeros(j)) * 10) >>> 5;
        int i = iNumberOfLeadingZeros + (j > b.b[iNumberOfLeadingZeros] ? 1 : 0);
        if (z) {
            i++;
        }
        rr3 rr3VarG0 = G0(i);
        byte[] bArr2 = rr3VarG0.a;
        int i2 = rr3VarG0.c + i;
        while (j != 0) {
            i2--;
            bArr2[i2] = b.a[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr2[i2 - 1] = 45;
        }
        rr3VarG0.c += i;
        this.f += (long) i;
    }

    public final void L0(long j) {
        if (j == 0) {
            J0(48);
            return;
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + 3) / 4);
        rr3 rr3VarG0 = G0(i);
        byte[] bArr = rr3VarG0.a;
        int i2 = rr3VarG0.c;
        for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = b.a[(int) (15 & j)];
            j >>>= 4;
        }
        rr3VarG0.c += i;
        this.f += (long) i;
    }

    public final void M0(int i) {
        rr3 rr3VarG0 = G0(4);
        byte[] bArr = rr3VarG0.a;
        int i2 = rr3VarG0.c;
        bArr[i2] = (byte) ((i >>> 24) & DnsRecord.CLASS_ANY);
        bArr[i2 + 1] = (byte) ((i >>> 16) & DnsRecord.CLASS_ANY);
        bArr[i2 + 2] = (byte) ((i >>> 8) & DnsRecord.CLASS_ANY);
        bArr[i2 + 3] = (byte) (i & DnsRecord.CLASS_ANY);
        rr3VarG0.c = i2 + 4;
        this.f += 4;
    }

    public final long N(bu buVar) {
        int i;
        int i2;
        buVar.getClass();
        rr3 rr3Var = this.b;
        if (rr3Var == null) {
            return -1L;
        }
        long j = this.f;
        long j2 = 0;
        if (j < 0) {
            while (j > 0) {
                rr3Var = rr3Var.g;
                rr3Var.getClass();
                j -= (long) (rr3Var.c - rr3Var.b);
            }
            if (buVar.d() == 2) {
                byte bI = buVar.i(0);
                byte bI2 = buVar.i(1);
                while (j < this.f) {
                    byte[] bArr = rr3Var.a;
                    i = (int) ((((long) rr3Var.b) + j2) - j);
                    int i3 = rr3Var.c;
                    while (i < i3) {
                        byte b = bArr[i];
                        if (b == bI || b == bI2) {
                            i2 = rr3Var.b;
                        } else {
                            i++;
                        }
                    }
                    j2 = ((long) (rr3Var.c - rr3Var.b)) + j;
                    rr3Var = rr3Var.f;
                    rr3Var.getClass();
                    j = j2;
                }
                return -1L;
            }
            byte[] bArrH = buVar.h();
            while (j < this.f) {
                byte[] bArr2 = rr3Var.a;
                i = (int) ((((long) rr3Var.b) + j2) - j);
                int i4 = rr3Var.c;
                while (i < i4) {
                    byte b2 = bArr2[i];
                    for (byte b3 : bArrH) {
                        if (b2 == b3) {
                            i2 = rr3Var.b;
                        }
                    }
                    i++;
                }
                j2 = ((long) (rr3Var.c - rr3Var.b)) + j;
                rr3Var = rr3Var.f;
                rr3Var.getClass();
                j = j2;
            }
            return -1L;
        }
        j = 0;
        while (true) {
            long j3 = ((long) (rr3Var.c - rr3Var.b)) + j;
            if (j3 > 0) {
                break;
            }
            rr3Var = rr3Var.f;
            rr3Var.getClass();
            j = j3;
        }
        if (buVar.d() == 2) {
            byte bI3 = buVar.i(0);
            byte bI4 = buVar.i(1);
            while (j < this.f) {
                byte[] bArr3 = rr3Var.a;
                i = (int) ((((long) rr3Var.b) + j2) - j);
                int i5 = rr3Var.c;
                while (i < i5) {
                    byte b4 = bArr3[i];
                    if (b4 == bI3 || b4 == bI4) {
                        i2 = rr3Var.b;
                    } else {
                        i++;
                    }
                }
                j2 = ((long) (rr3Var.c - rr3Var.b)) + j;
                rr3Var = rr3Var.f;
                rr3Var.getClass();
                j = j2;
            }
            return -1L;
        }
        byte[] bArrH2 = buVar.h();
        while (j < this.f) {
            byte[] bArr4 = rr3Var.a;
            i = (int) ((((long) rr3Var.b) + j2) - j);
            int i6 = rr3Var.c;
            while (i < i6) {
                byte b5 = bArr4[i];
                for (byte b6 : bArrH2) {
                    if (b5 == b6) {
                        i2 = rr3Var.b;
                    }
                }
                i++;
            }
            j2 = ((long) (rr3Var.c - rr3Var.b)) + j;
            rr3Var = rr3Var.f;
            rr3Var.getClass();
            j = j2;
        }
        return -1L;
        return ((long) (i - i2)) + j;
    }

    public final void N0(int i) {
        rr3 rr3VarG0 = G0(2);
        byte[] bArr = rr3VarG0.a;
        int i2 = rr3VarG0.c;
        bArr[i2] = (byte) ((i >>> 8) & DnsRecord.CLASS_ANY);
        bArr[i2 + 1] = (byte) (i & DnsRecord.CLASS_ANY);
        rr3VarG0.c = i2 + 2;
        this.f += 2;
    }

    public final void O0(OutputStream outputStream, long j) {
        l72.f(this.f, 0L, j);
        rr3 rr3Var = this.b;
        long j2 = j;
        while (j2 > 0) {
            rr3Var.getClass();
            int iMin = (int) Math.min(j2, rr3Var.c - rr3Var.b);
            outputStream.write(rr3Var.a, rr3Var.b, iMin);
            int i = rr3Var.b + iMin;
            rr3Var.b = i;
            long j3 = iMin;
            this.f -= j3;
            j2 -= j3;
            if (i == rr3Var.c) {
                rr3 rr3VarA = rr3Var.a();
                this.b = rr3VarA;
                tr3.a(rr3Var);
                rr3Var = rr3VarA;
            }
        }
    }

    @Override // defpackage.bq
    public final /* bridge */ /* synthetic */ bq P(int i, byte[] bArr) {
        H0(i, bArr);
        return this;
    }

    public final void P0(int i, int i2, String str) {
        char cCharAt;
        str.getClass();
        if (i < 0) {
            e04.f(dw2.A(i, "beginIndex < 0: "));
            return;
        }
        if (i2 < i) {
            e04.f(fw.s(i2, i, "endIndex < beginIndex: ", " < "));
            return;
        }
        if (i2 > str.length()) {
            StringBuilder sbD = dw2.D("endIndex > string.length: ", i2, " > ");
            sbD.append(str.length());
            throw new IllegalArgumentException(sbD.toString().toString());
        }
        while (i < i2) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 128) {
                rr3 rr3VarG0 = G0(1);
                byte[] bArr = rr3VarG0.a;
                int i3 = rr3VarG0.c - i;
                int iMin = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) cCharAt2;
                while (true) {
                    i = i4;
                    if (i >= iMin || (cCharAt = str.charAt(i)) >= 128) {
                        break;
                    }
                    i4 = i + 1;
                    bArr[i + i3] = (byte) cCharAt;
                }
                int i5 = rr3VarG0.c;
                int i6 = (i3 + i) - i5;
                rr3VarG0.c = i5 + i6;
                this.f += (long) i6;
            } else {
                if (cCharAt2 < 2048) {
                    rr3 rr3VarG02 = G0(2);
                    byte[] bArr2 = rr3VarG02.a;
                    int i7 = rr3VarG02.c;
                    bArr2[i7] = (byte) ((cCharAt2 >> 6) | 192);
                    bArr2[i7 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    rr3VarG02.c = i7 + 2;
                    this.f += 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    rr3 rr3VarG03 = G0(3);
                    byte[] bArr3 = rr3VarG03.a;
                    int i8 = rr3VarG03.c;
                    bArr3[i8] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i8 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i8 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    rr3VarG03.c = i8 + 3;
                    this.f += 3;
                } else {
                    int i9 = i + 1;
                    char cCharAt3 = i9 < i2 ? str.charAt(i9) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        J0(63);
                        i = i9;
                    } else {
                        int i10 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        rr3 rr3VarG04 = G0(4);
                        byte[] bArr4 = rr3VarG04.a;
                        int i11 = rr3VarG04.c;
                        bArr4[i11] = (byte) ((i10 >> 18) | 240);
                        bArr4[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                        bArr4[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                        bArr4[i11 + 3] = (byte) ((i10 & 63) | 128);
                        rr3VarG04.c = i11 + 4;
                        this.f += 4;
                        i += 2;
                    }
                }
                i++;
            }
        }
    }

    public final boolean Q(bu buVar) {
        rr3 rr3Var;
        boolean z;
        long j;
        long j2;
        long j3;
        buVar.getClass();
        int iD = buVar.d();
        if (iD >= 0) {
            long j4 = iD;
            if (j4 <= this.f && iD <= buVar.d()) {
                if (iD != 0) {
                    byte[] bArr = b.a;
                    l72.f(buVar.d(), 0L, j4);
                    if (iD <= 0) {
                        xe.k("byteCount == 0");
                        return false;
                    }
                    long j5 = this.f;
                    long j6 = 1;
                    long j7 = 1 > j5 ? j5 : 1L;
                    if (0 == j7 || (rr3Var = this.b) == null) {
                        j3 = -1;
                        z = false;
                    } else if (j5 < 0) {
                        while (j5 > 0) {
                            rr3Var = rr3Var.g;
                            rr3Var.getClass();
                            j5 -= (long) (rr3Var.c - rr3Var.b);
                            j6 = j6;
                        }
                        long j8 = j6;
                        z = false;
                        byte[] bArrH = buVar.h();
                        byte b = bArrH[0];
                        long jMin = Math.min(j7, (this.f - j4) + j8);
                        long j9 = 0;
                        loop1: while (j5 < jMin) {
                            byte[] bArr2 = rr3Var.a;
                            j = j5;
                            int iMin = (int) Math.min(rr3Var.c, (((long) rr3Var.b) + jMin) - j5);
                            for (int i = (int) ((((long) rr3Var.b) + j9) - j); i < iMin; i++) {
                                if (bArr2[i] == b && b.a(rr3Var, i + 1, bArrH, 1, iD)) {
                                    j2 = i - rr3Var.b;
                                    j3 = j2 + j;
                                    break loop1;
                                }
                            }
                            j9 = j + ((long) (rr3Var.c - rr3Var.b));
                            rr3Var = rr3Var.f;
                            rr3Var.getClass();
                            j5 = j9;
                        }
                        j3 = -1;
                    } else {
                        z = false;
                        long j10 = 0;
                        while (true) {
                            long j11 = ((long) (rr3Var.c - rr3Var.b)) + j10;
                            if (j11 > 0) {
                                break;
                            }
                            rr3Var = rr3Var.f;
                            rr3Var.getClass();
                            j10 = j11;
                        }
                        byte[] bArrH2 = buVar.h();
                        byte b2 = bArrH2[0];
                        long jMin2 = Math.min(j7, (this.f - j4) + 1);
                        long j12 = 0;
                        loop4: while (j10 < jMin2) {
                            byte[] bArr3 = rr3Var.a;
                            j = j10;
                            int iMin2 = (int) Math.min(rr3Var.c, (((long) rr3Var.b) + jMin2) - j10);
                            for (int i2 = (int) ((((long) rr3Var.b) + j12) - j); i2 < iMin2; i2++) {
                                if (bArr3[i2] == b2 && b.a(rr3Var, i2 + 1, bArrH2, 1, iD)) {
                                    j2 = i2 - rr3Var.b;
                                    j3 = j2 + j;
                                    break loop1;
                                }
                            }
                            j12 = j + ((long) (rr3Var.c - rr3Var.b));
                            rr3Var = rr3Var.f;
                            rr3Var.getClass();
                            j10 = j12;
                        }
                        j3 = -1;
                    }
                    if (j3 == -1) {
                        return z;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void Q0(String str) {
        str.getClass();
        P0(0, str.length(), str);
    }

    public final void R0(int i) {
        if (i < 128) {
            J0(i);
            return;
        }
        if (i < 2048) {
            rr3 rr3VarG0 = G0(2);
            byte[] bArr = rr3VarG0.a;
            int i2 = rr3VarG0.c;
            bArr[i2] = (byte) ((i >> 6) | 192);
            bArr[i2 + 1] = (byte) ((i & 63) | 128);
            rr3VarG0.c = i2 + 2;
            this.f += 2;
            return;
        }
        if (55296 <= i && i < 57344) {
            J0(63);
            return;
        }
        if (i < 65536) {
            rr3 rr3VarG02 = G0(3);
            byte[] bArr2 = rr3VarG02.a;
            int i3 = rr3VarG02.c;
            bArr2[i3] = (byte) ((i >> 12) | 224);
            bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i3 + 2] = (byte) ((i & 63) | 128);
            rr3VarG02.c = i3 + 3;
            this.f += 3;
            return;
        }
        if (i > 1114111) {
            xe.k("Unexpected code point: 0x".concat(l72.Z(i)));
            return;
        }
        rr3 rr3VarG03 = G0(4);
        byte[] bArr3 = rr3VarG03.a;
        int i4 = rr3VarG03.c;
        bArr3[i4] = (byte) ((i >> 18) | 240);
        bArr3[i4 + 1] = (byte) (((i >> 12) & 63) | 128);
        bArr3[i4 + 2] = (byte) (((i >> 6) & 63) | 128);
        bArr3[i4 + 3] = (byte) ((i & 63) | 128);
        rr3VarG03.c = i4 + 4;
        this.f += 4;
    }

    @Override // defpackage.bq
    public final /* bridge */ /* synthetic */ bq S(String str) {
        Q0(str);
        return this;
    }

    public final byte U() {
        if (this.f == 0) {
            throw new EOFException();
        }
        rr3 rr3Var = this.b;
        rr3Var.getClass();
        int i = rr3Var.b;
        int i2 = rr3Var.c;
        int i3 = i + 1;
        byte b = rr3Var.a[i];
        this.f--;
        if (i3 != i2) {
            rr3Var.b = i3;
            return b;
        }
        this.b = rr3Var.a();
        tr3.a(rr3Var);
        return b;
    }

    @Override // defpackage.cq
    public final String W(Charset charset) {
        charset.getClass();
        return r0(this.f, charset);
    }

    public final byte[] X(long j) throws EOFException {
        if (j < 0 || j > 2147483647L) {
            e04.f(ha0.j(j, "byteCount: "));
            return null;
        }
        if (this.f < j) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j];
        c0(bArr);
        return bArr;
    }

    public final bu Z(long j) {
        if (j < 0 || j > 2147483647L) {
            e04.f(ha0.j(j, "byteCount: "));
            return null;
        }
        if (this.f < j) {
            throw new EOFException();
        }
        if (j < 4096) {
            return new bu(X(j));
        }
        bu buVarF0 = F0((int) j);
        z0(j);
        return buVarF0;
    }

    @Override // defpackage.vx3
    public final void a0(hp hpVar, long j) {
        rr3 rr3VarB;
        hpVar.getClass();
        if (hpVar == this) {
            xe.k("source == this");
            return;
        }
        l72.f(hpVar.f, 0L, j);
        while (j > 0) {
            rr3 rr3Var = hpVar.b;
            rr3Var.getClass();
            int i = rr3Var.c;
            rr3 rr3Var2 = hpVar.b;
            rr3Var2.getClass();
            long j2 = i - rr3Var2.b;
            int i2 = 0;
            if (j < j2) {
                rr3 rr3Var3 = this.b;
                rr3 rr3Var4 = rr3Var3 != null ? rr3Var3.g : null;
                if (rr3Var4 != null && rr3Var4.e) {
                    if ((((long) rr3Var4.c) + j) - ((long) (rr3Var4.d ? 0 : rr3Var4.b)) <= 8192) {
                        rr3 rr3Var5 = hpVar.b;
                        rr3Var5.getClass();
                        rr3Var5.d(rr3Var4, (int) j);
                        hpVar.f -= j;
                        this.f += j;
                        return;
                    }
                }
                rr3 rr3Var6 = hpVar.b;
                rr3Var6.getClass();
                int i3 = (int) j;
                if (i3 <= 0 || i3 > rr3Var6.c - rr3Var6.b) {
                    xe.k("byteCount out of range");
                    return;
                }
                if (i3 >= 1024) {
                    rr3VarB = rr3Var6.c();
                } else {
                    rr3VarB = tr3.b();
                    byte[] bArr = rr3Var6.a;
                    byte[] bArr2 = rr3VarB.a;
                    int i4 = rr3Var6.b;
                    qe.d0(bArr, 0, i4, bArr2, i4 + i3);
                }
                rr3VarB.c = rr3VarB.b + i3;
                rr3Var6.b += i3;
                rr3 rr3Var7 = rr3Var6.g;
                rr3Var7.getClass();
                rr3Var7.b(rr3VarB);
                hpVar.b = rr3VarB;
            }
            rr3 rr3Var8 = hpVar.b;
            rr3Var8.getClass();
            long j3 = rr3Var8.c - rr3Var8.b;
            hpVar.b = rr3Var8.a();
            rr3 rr3Var9 = this.b;
            if (rr3Var9 == null) {
                this.b = rr3Var8;
                rr3Var8.g = rr3Var8;
                rr3Var8.f = rr3Var8;
            } else {
                rr3 rr3Var10 = rr3Var9.g;
                rr3Var10.getClass();
                rr3Var10.b(rr3Var8);
                rr3 rr3Var11 = rr3Var8.g;
                if (rr3Var11 == rr3Var8) {
                    xe.q("cannot compact");
                    return;
                }
                rr3Var11.getClass();
                if (rr3Var11.e) {
                    int i5 = rr3Var8.c - rr3Var8.b;
                    rr3 rr3Var12 = rr3Var8.g;
                    rr3Var12.getClass();
                    int i6 = 8192 - rr3Var12.c;
                    rr3 rr3Var13 = rr3Var8.g;
                    rr3Var13.getClass();
                    if (!rr3Var13.d) {
                        rr3 rr3Var14 = rr3Var8.g;
                        rr3Var14.getClass();
                        i2 = rr3Var14.b;
                    }
                    if (i5 <= i6 + i2) {
                        rr3 rr3Var15 = rr3Var8.g;
                        rr3Var15.getClass();
                        rr3Var8.d(rr3Var15, i5);
                        rr3Var8.a();
                        tr3.a(rr3Var8);
                    }
                }
            }
            hpVar.f -= j3;
            this.f += j3;
            j -= j3;
        }
    }

    public final void c0(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int i2 = read(bArr, i, bArr.length - i);
            if (i2 == -1) {
                throw new EOFException();
            }
            i += i2;
        }
    }

    public final Object clone() {
        hp hpVar = new hp();
        if (this.f == 0) {
            return hpVar;
        }
        rr3 rr3Var = this.b;
        rr3Var.getClass();
        rr3 rr3VarC = rr3Var.c();
        hpVar.b = rr3VarC;
        rr3VarC.g = rr3VarC;
        rr3VarC.f = rr3VarC;
        for (rr3 rr3Var2 = rr3Var.f; rr3Var2 != rr3Var; rr3Var2 = rr3Var2.f) {
            rr3 rr3Var3 = rr3VarC.g;
            rr3Var3.getClass();
            rr3Var2.getClass();
            rr3Var3.b(rr3Var2.c());
        }
        hpVar.f = this.f;
        return hpVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hp)) {
            return false;
        }
        long j = this.f;
        hp hpVar = (hp) obj;
        if (j != hpVar.f) {
            return false;
        }
        if (j == 0) {
            return true;
        }
        rr3 rr3Var = this.b;
        rr3Var.getClass();
        rr3 rr3Var2 = hpVar.b;
        rr3Var2.getClass();
        int i = rr3Var.b;
        int i2 = rr3Var2.b;
        long j2 = 0;
        while (j2 < this.f) {
            long jMin = Math.min(rr3Var.c - i, rr3Var2.c - i2);
            long j3 = 0;
            while (j3 < jMin) {
                int i3 = i + 1;
                int i4 = i2 + 1;
                if (rr3Var.a[i] != rr3Var2.a[i2]) {
                    return false;
                }
                j3++;
                i = i3;
                i2 = i4;
            }
            if (i == rr3Var.c) {
                rr3Var = rr3Var.f;
                rr3Var.getClass();
                i = rr3Var.b;
            }
            if (i2 == rr3Var2.c) {
                rr3Var2 = rr3Var2.f;
                rr3Var2.getClass();
                i2 = rr3Var2.b;
            }
            j2 += jMin;
        }
        return true;
    }

    @Override // defpackage.cq
    public final bu f0() {
        return Z(this.f);
    }

    public final long g() {
        long j = this.f;
        if (j == 0) {
            return 0L;
        }
        rr3 rr3Var = this.b;
        rr3Var.getClass();
        rr3 rr3Var2 = rr3Var.g;
        rr3Var2.getClass();
        int i = rr3Var2.c;
        return (i >= 8192 || !rr3Var2.e) ? j : j - ((long) (i - rr3Var2.b));
    }

    public final int hashCode() {
        rr3 rr3Var = this.b;
        if (rr3Var == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = rr3Var.c;
            for (int i3 = rr3Var.b; i3 < i2; i3++) {
                i = (i * 31) + rr3Var.a[i3];
            }
            rr3Var = rr3Var.f;
            rr3Var.getClass();
        } while (rr3Var != this.b);
        return i;
    }

    @Override // defpackage.lz3
    public final de4 i() {
        return de4.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a2 A[EDGE_INSN: B:44:0x00a2->B:38:0x00a2 BREAK  A[LOOP:0: B:5:0x000c->B:46:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long i0() throws EOFException {
        int i;
        if (this.f == 0) {
            throw new EOFException();
        }
        int i2 = 0;
        boolean z = false;
        long j = 0;
        do {
            rr3 rr3Var = this.b;
            rr3Var.getClass();
            byte[] bArr = rr3Var.a;
            int i3 = rr3Var.b;
            int i4 = rr3Var.c;
            while (i3 < i4) {
                byte b = bArr[i3];
                if (b >= 48 && b <= 57) {
                    i = b - 48;
                } else if (b >= 97 && b <= 102) {
                    i = b - 87;
                } else if (b < 65 || b > 70) {
                    z = true;
                    if (i2 == 0) {
                        char[] cArr = je.b;
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(new String(new char[]{cArr[(b >> 4) & 15], cArr[b & 15]})));
                    }
                    if (i3 != i4) {
                        this.b = rr3Var.a();
                        tr3.a(rr3Var);
                    } else {
                        rr3Var.b = i3;
                    }
                    if (!z) {
                        break;
                    }
                } else {
                    i = b - 55;
                }
                if (((-1152921504606846976L) & j) != 0) {
                    hp hpVar = new hp();
                    hpVar.L0(j);
                    hpVar.J0(b);
                    throw new NumberFormatException("Number too large: ".concat(hpVar.x0()));
                }
                j = (j << 4) | ((long) i);
                i3++;
                i2++;
            }
            if (i3 != i4) {
            }
            if (!z) {
            }
        } while (this.b != null);
        this.f -= (long) i2;
        return j;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    public final int j0() throws EOFException {
        if (this.f < 4) {
            throw new EOFException();
        }
        rr3 rr3Var = this.b;
        rr3Var.getClass();
        int i = rr3Var.b;
        int i2 = rr3Var.c;
        if (i2 - i < 4) {
            return (U() & 255) | ((U() & 255) << 24) | ((U() & 255) << 16) | ((U() & 255) << 8);
        }
        byte[] bArr = rr3Var.a;
        int i3 = i + 3;
        int i4 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        int i5 = i + 4;
        int i6 = (bArr[i3] & 255) | i4;
        this.f -= 4;
        if (i5 != i2) {
            rr3Var.b = i5;
            return i6;
        }
        this.b = rr3Var.a();
        tr3.a(rr3Var);
        return i6;
    }

    public final void n(hp hpVar, long j, long j2) {
        hpVar.getClass();
        long j3 = j;
        l72.f(this.f, j3, j2);
        if (j2 == 0) {
            return;
        }
        hpVar.f += j2;
        rr3 rr3Var = this.b;
        while (true) {
            rr3Var.getClass();
            long j4 = rr3Var.c - rr3Var.b;
            if (j3 < j4) {
                break;
            }
            j3 -= j4;
            rr3Var = rr3Var.f;
        }
        long j5 = j2;
        while (j5 > 0) {
            rr3Var.getClass();
            rr3 rr3VarC = rr3Var.c();
            int i = rr3VarC.b + ((int) j3);
            rr3VarC.b = i;
            rr3VarC.c = Math.min(i + ((int) j5), rr3VarC.c);
            rr3 rr3Var2 = hpVar.b;
            if (rr3Var2 == null) {
                rr3VarC.g = rr3VarC;
                rr3VarC.f = rr3VarC;
                hpVar.b = rr3VarC;
            } else {
                rr3 rr3Var3 = rr3Var2.g;
                rr3Var3.getClass();
                rr3Var3.b(rr3VarC);
            }
            j5 -= (long) (rr3VarC.c - rr3VarC.b);
            rr3Var = rr3Var.f;
            j3 = 0;
        }
    }

    public final short n0() throws EOFException {
        if (this.f < 2) {
            throw new EOFException();
        }
        rr3 rr3Var = this.b;
        rr3Var.getClass();
        int i = rr3Var.b;
        int i2 = rr3Var.c;
        if (i2 - i < 2) {
            return (short) ((U() & 255) | ((U() & 255) << 8));
        }
        byte[] bArr = rr3Var.a;
        int i3 = i + 1;
        int i4 = (bArr[i] & 255) << 8;
        int i5 = i + 2;
        int i6 = (bArr[i3] & 255) | i4;
        this.f -= 2;
        if (i5 == i2) {
            this.b = rr3Var.a();
            tr3.a(rr3Var);
        } else {
            rr3Var.b = i5;
        }
        return (short) i6;
    }

    @Override // defpackage.cq
    public final he3 peek() {
        return new he3(new a13(this));
    }

    public final short q0() throws EOFException {
        short sN0 = n0();
        return (short) (((sN0 & 255) << 8) | ((65280 & sN0) >>> 8));
    }

    public final String r0(long j, Charset charset) throws EOFException {
        charset.getClass();
        if (j < 0 || j > 2147483647L) {
            e04.f(ha0.j(j, "byteCount: "));
            return null;
        }
        if (this.f < j) {
            throw new EOFException();
        }
        if (j == 0) {
            return "";
        }
        rr3 rr3Var = this.b;
        rr3Var.getClass();
        int i = rr3Var.b;
        if (((long) i) + j > rr3Var.c) {
            return new String(X(j), charset);
        }
        int i2 = (int) j;
        String str = new String(rr3Var.a, i, i2, charset);
        int i3 = rr3Var.b + i2;
        rr3Var.b = i3;
        this.f -= j;
        if (i3 == rr3Var.c) {
            this.b = rr3Var.a();
            tr3.a(rr3Var);
        }
        return str;
    }

    public final int read(byte[] bArr, int i, int i2) {
        l72.f(bArr.length, i, i2);
        rr3 rr3Var = this.b;
        if (rr3Var == null) {
            return -1;
        }
        int iMin = Math.min(i2, rr3Var.c - rr3Var.b);
        byte[] bArr2 = rr3Var.a;
        int i3 = rr3Var.b;
        qe.d0(bArr2, i, i3, bArr, i3 + iMin);
        int i4 = rr3Var.b + iMin;
        rr3Var.b = i4;
        this.f -= (long) iMin;
        if (i4 == rr3Var.c) {
            this.b = rr3Var.a();
            tr3.a(rr3Var);
        }
        return iMin;
    }

    @Override // defpackage.cq
    public final boolean request(long j) {
        return this.f >= j;
    }

    @Override // defpackage.lz3
    public final long t0(hp hpVar, long j) {
        hpVar.getClass();
        if (j < 0) {
            e04.f(ha0.j(j, "byteCount < 0: "));
            return 0L;
        }
        long j2 = this.f;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        hpVar.a0(this, j);
        return j;
    }

    public final String toString() {
        long j = this.f;
        if (j <= 2147483647L) {
            return F0((int) j).toString();
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.f).toString());
    }

    @Override // defpackage.cq
    public final long u0(ge3 ge3Var) {
        long j = this.f;
        if (j > 0) {
            ge3Var.a0(this, j);
        }
        return j;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            rr3 rr3VarG0 = G0(1);
            int iMin = Math.min(i, 8192 - rr3VarG0.c);
            byteBuffer.get(rr3VarG0.a, rr3VarG0.c, iMin);
            i -= iMin;
            rr3VarG0.c += iMin;
        }
        this.f += (long) iRemaining;
        return iRemaining;
    }

    @Override // defpackage.bq
    public final /* bridge */ /* synthetic */ bq writeByte(int i) {
        J0(i);
        return this;
    }

    public final boolean x() {
        return this.f == 0;
    }

    public final String x0() {
        return r0(this.f, y30.a);
    }

    public final void z0(long j) throws EOFException {
        while (j > 0) {
            rr3 rr3Var = this.b;
            if (rr3Var == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, rr3Var.c - rr3Var.b);
            long j2 = iMin;
            this.f -= j2;
            j -= j2;
            int i = rr3Var.b + iMin;
            rr3Var.b = i;
            if (i == rr3Var.c) {
                this.b = rr3Var.a();
                tr3.a(rr3Var);
            }
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        rr3 rr3Var = this.b;
        if (rr3Var == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), rr3Var.c - rr3Var.b);
        byteBuffer.put(rr3Var.a, rr3Var.b, iMin);
        int i = rr3Var.b + iMin;
        rr3Var.b = i;
        this.f -= (long) iMin;
        if (i == rr3Var.c) {
            this.b = rr3Var.a();
            tr3.a(rr3Var);
        }
        return iMin;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, defpackage.vx3
    public final void close() {
    }

    @Override // defpackage.vx3, java.io.Flushable
    public final void flush() {
    }

    @Override // defpackage.cq
    public final hp h() {
        return this;
    }
}
