package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gi0 {
    public final /* synthetic */ int a;
    public int b;
    public final byte[] c;

    public gi0(int i) {
        this.a = i;
        switch (i) {
            case 3:
                this.c = new byte[15];
                break;
            default:
                this.c = new byte[24];
                break;
        }
    }

    public static int f(long j, long j2) {
        long jK = ez4.K(j, j2);
        return (int) ((((jK & 4294967295L) + 4294967295L) >>> 32) | (jK >>> 31));
    }

    public static long g(long j, long j2, long j3) {
        long jK = ez4.K(j2, j3);
        long j4 = j * j3;
        long jK2 = ez4.K(j, j3);
        long j5 = (j4 >>> 1) + jK;
        return (jK2 + (j5 >>> 63)) | (((j5 & Long.MAX_VALUE) + Long.MAX_VALUE) >>> 63);
    }

    public void a(int i) {
        int i2 = this.a;
        byte[] bArr = this.c;
        switch (i2) {
            case 2:
                int i3 = this.b + 1;
                this.b = i3;
                bArr[i3] = (byte) i;
                break;
            default:
                int i4 = this.b + 1;
                this.b = i4;
                bArr[i4] = (byte) i;
                break;
        }
    }

    public void b(int i) {
        switch (this.a) {
            case 2:
                int iK = ((int) (ez4.K(((long) (i + 1)) << 28, 193428131138340668L) >>> 20)) - 1;
                for (int i2 = 0; i2 < 8; i2++) {
                    int i3 = iK * 10;
                    c(i3 >>> 28);
                    iK = i3 & 268435455;
                }
                break;
            default:
                int iK2 = ((int) (ez4.K(((long) (i + 1)) << 28, 193428131138340668L) >>> 20)) - 1;
                for (int i4 = 0; i4 < 8; i4++) {
                    int i5 = iK2 * 10;
                    c(i5 >>> 28);
                    iK2 = i5 & 268435455;
                }
                break;
        }
    }

    public void c(int i) {
        int i2 = this.a;
        byte[] bArr = this.c;
        switch (i2) {
            case 2:
                int i3 = this.b + 1;
                this.b = i3;
                bArr[i3] = (byte) (i + 48);
                break;
            default:
                int i4 = this.b + 1;
                this.b = i4;
                bArr[i4] = (byte) (i + 48);
                break;
        }
    }

    public void d(int i) {
        int i2;
        byte b;
        if (i != 0) {
            b(i);
        }
        while (true) {
            i2 = this.b;
            b = this.c[i2];
            if (b != 48) {
                break;
            } else {
                this.b = i2 - 1;
            }
        }
        if (b == 46) {
            this.b = i2 + 1;
        }
    }

    public void e() {
        int i;
        byte b;
        while (true) {
            i = this.b;
            b = this.c[i];
            if (b != 48) {
                break;
            } else {
                this.b = i - 1;
            }
        }
        if (b == 46) {
            this.b = i + 1;
        }
    }

    public void h(int i, int i2) {
        int iNumberOfLeadingZeros = (int) ((((long) (32 - Integer.numberOfLeadingZeros(i))) * 661971961083L) >> 41);
        long j = i;
        long[] jArr = ez4.g;
        if (j >= jArr[iNumberOfLeadingZeros]) {
            iNumberOfLeadingZeros++;
        }
        int i3 = (int) (j * jArr[9 - iNumberOfLeadingZeros]);
        int i4 = i2 + iNumberOfLeadingZeros;
        int i5 = (int) ((((long) i3) * 1441151881) >>> 57);
        int i6 = i3 - (100000000 * i5);
        int i7 = 1;
        if (i4 > 0 && i4 <= 7) {
            c(i5);
            int iK = ((int) (ez4.K(((long) (i6 + 1)) << 28, 193428131138340668L) >>> 20)) - 1;
            while (i7 < i4) {
                int i8 = iK * 10;
                c(i8 >>> 28);
                iK = i8 & 268435455;
                i7++;
            }
            a(46);
            while (i7 <= 8) {
                int i9 = iK * 10;
                c(i9 >>> 28);
                iK = i9 & 268435455;
                i7++;
            }
            e();
            return;
        }
        if (-3 < i4 && i4 <= 0) {
            c(0);
            a(46);
            while (i4 < 0) {
                c(0);
                i4++;
            }
            c(i5);
            b(i6);
            e();
            return;
        }
        c(i5);
        a(46);
        b(i6);
        e();
        int i10 = i4 - 1;
        a(69);
        if (i10 < 0) {
            a(45);
            i10 = -i10;
        }
        if (i10 < 10) {
            c(i10);
            return;
        }
        int i11 = (i10 * 103) >>> 10;
        c(i11);
        c(i10 - (i11 * 10));
    }

    public void i(int i, long j) {
        int iNumberOfLeadingZeros = (int) ((((long) (64 - Long.numberOfLeadingZeros(j))) * 661971961083L) >> 41);
        long[] jArr = ez4.g;
        if (j >= jArr[iNumberOfLeadingZeros]) {
            iNumberOfLeadingZeros++;
        }
        long j2 = j * jArr[17 - iNumberOfLeadingZeros];
        int i2 = i + iNumberOfLeadingZeros;
        long jK = ez4.K(j2, 193428131138340668L) >>> 20;
        int i3 = (int) (j2 - (100000000 * jK));
        int i4 = (int) ((1441151881 * jK) >>> 57);
        int i5 = (int) (jK - ((long) (100000000 * i4)));
        int i6 = 1;
        if (i2 > 0 && i2 <= 7) {
            c(i4);
            int iK = ((int) (ez4.K(((long) (i5 + 1)) << 28, 193428131138340668L) >>> 20)) - 1;
            while (i6 < i2) {
                int i7 = iK * 10;
                c(i7 >>> 28);
                iK = i7 & 268435455;
                i6++;
            }
            a(46);
            while (i6 <= 8) {
                int i8 = iK * 10;
                c(i8 >>> 28);
                iK = i8 & 268435455;
                i6++;
            }
            d(i3);
            return;
        }
        if (-3 < i2 && i2 <= 0) {
            c(0);
            a(46);
            while (i2 < 0) {
                c(0);
                i2++;
            }
            c(i4);
            b(i5);
            d(i3);
            return;
        }
        c(i4);
        a(46);
        b(i5);
        d(i3);
        int i9 = i2 - 1;
        a(69);
        if (i9 < 0) {
            a(45);
            i9 = -i9;
        }
        if (i9 < 10) {
            c(i9);
            return;
        }
        if (i9 >= 100) {
            int i10 = (i9 * 1311) >>> 17;
            c(i10);
            i9 -= i10 * 100;
        }
        int i11 = (i9 * 103) >>> 10;
        c(i11);
        c(i9 - (i11 * 10));
    }

    public void j(int i, int i2, int i3) {
        char c;
        long j;
        long j2;
        int i4 = i2 & 1;
        long j3 = i2 << 2;
        long j4 = j3 + 2;
        if ((i2 != 8388608) || (i == -149)) {
            j = j3 - 2;
            c = ')';
            j2 = ((long) i) * 661971961083L;
        } else {
            c = ')';
            j = j3 - 1;
            j2 = (((long) i) * 661971961083L) - 274743187321L;
        }
        int i5 = (int) (j2 >> c);
        int i6 = ((int) ((((long) (-i5)) * 913124641741L) >> 38)) + i + 33;
        long j5 = ez4.h[(i5 + 324) << 1] + 1;
        int iF = f(j5, j3 << i6);
        int iF2 = f(j5, j << i6);
        int iF3 = f(j5, j4 << i6);
        int i7 = iF >> 2;
        if (i7 >= 100) {
            int i8 = ((int) ((((long) i7) * 1717986919) >>> 34)) * 10;
            int i9 = i8 + 10;
            boolean z = iF2 + i4 <= (i8 << 2);
            if (z != ((i9 << 2) + i4 <= iF3)) {
                if (!z) {
                    i8 = i9;
                }
                h(i8, i5);
                return;
            }
        }
        int i10 = i7 + 1;
        boolean z2 = iF2 + i4 <= (i7 << 2);
        if (z2 != ((i10 << 2) + i4 <= iF3)) {
            if (!z2) {
                i7 = i10;
            }
            h(i7, i5 + i3);
        } else {
            int i11 = iF - ((i7 + i10) << 1);
            if (i11 >= 0 && (i11 != 0 || (i7 & 1) != 0)) {
                i7 = i10;
            }
            h(i7, i5 + i3);
        }
    }

    public void k(int i, long j, int i2) {
        int i3;
        char c;
        long j2;
        long j3;
        int i4 = ((int) j) & 1;
        long j4 = j << 2;
        long j5 = j4 + 2;
        if ((j != 4503599627370496L) || (i == -1074)) {
            j2 = j4 - 2;
            i3 = 1;
            c = 2;
            j3 = ((long) i) * 661971961083L;
        } else {
            i3 = 1;
            c = 2;
            j2 = j4 - 1;
            j3 = (((long) i) * 661971961083L) - 274743187321L;
        }
        int i5 = (int) (j3 >> 41);
        int i6 = ((int) ((((long) (-i5)) * 913124641741L) >> 38)) + i + 2;
        long[] jArr = ez4.h;
        int i7 = (i5 + 324) << i3;
        long j6 = jArr[i7];
        long j7 = jArr[i7 | i3];
        long jG = g(j6, j7, j4 << i6);
        long jG2 = g(j6, j7, j2 << i6);
        long jG3 = g(j6, j7, j5 << i6);
        long j8 = jG >> c;
        int i8 = i3;
        if (j8 >= 100) {
            long jK = ez4.K(j8, 1844674407370955168L) * 10;
            long j9 = jK + 10;
            long j10 = i4;
            int i9 = jG2 + j10 <= (jK << c) ? i8 : 0;
            if (i9 != ((j9 << c) + j10 <= jG3 ? i8 : 0)) {
                i(i5, i9 != 0 ? jK : j9);
                return;
            }
        }
        long j11 = j8 + 1;
        long j12 = i4;
        int i10 = jG2 + j12 <= (j8 << c) ? i8 : 0;
        if (i10 != ((j11 << c) + j12 <= jG3 ? i8 : 0)) {
            if (i10 == 0) {
                j8 = j11;
            }
            i(i5 + i2, j8);
        } else {
            long j13 = jG - ((j8 + j11) << i8);
            if (j13 >= 0 && (j13 != 0 || (j8 & 1) != 0)) {
                j8 = j11;
            }
            i(i5 + i2, j8);
        }
    }

    public /* synthetic */ gi0(int i, int i2, byte[] bArr) {
        this.a = i2;
        this.b = i;
        this.c = bArr;
    }
}
