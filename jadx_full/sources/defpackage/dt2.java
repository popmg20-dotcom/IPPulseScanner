package defpackage;

import io.netty.handler.codec.dns.DnsRecord;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class dt2 {
    public static final String a = String.valueOf(Integer.MIN_VALUE);
    public static final String b = String.valueOf(Long.MIN_VALUE);
    public static final int[] c = new int[1000];

    static {
        int i = 0;
        for (int i2 = 0; i2 < 10; i2++) {
            for (int i3 = 0; i3 < 10; i3++) {
                int i4 = 0;
                while (i4 < 10) {
                    c[i] = ((i2 + 48) << 16) | ((i3 + 48) << 8) | (i4 + 48);
                    i4++;
                    i++;
                }
            }
        }
    }

    public static int a(char[] cArr, int i, int i2) {
        int i3 = c[i];
        cArr[i2] = (char) (i3 >> 16);
        int i4 = i2 + 2;
        cArr[i2 + 1] = (char) ((i3 >> 8) & 127);
        int i5 = i2 + 3;
        cArr[i4] = (char) (i3 & 127);
        return i5;
    }

    public static int b(char[] cArr, int i, int i2) {
        int i3 = c[i];
        if (i > 9) {
            if (i > 99) {
                cArr[i2] = (char) (i3 >> 16);
                i2++;
            }
            cArr[i2] = (char) ((i3 >> 8) & 127);
            i2++;
        }
        int i4 = i2 + 1;
        cArr[i2] = (char) (i3 & 127);
        return i4;
    }

    public static int c(char[] cArr, int i, int i2) {
        int iD = d(i);
        int i3 = i - (iD * 1000);
        int iD2 = d(iD);
        int[] iArr = c;
        int i4 = iArr[iD2];
        cArr[i2] = (char) (i4 >> 16);
        cArr[i2 + 1] = (char) ((i4 >> 8) & 127);
        cArr[i2 + 2] = (char) (i4 & 127);
        int i5 = iArr[iD - (iD2 * 1000)];
        cArr[i2 + 3] = (char) (i5 >> 16);
        cArr[i2 + 4] = (char) ((i5 >> 8) & 127);
        cArr[i2 + 5] = (char) (i5 & 127);
        int i6 = iArr[i3];
        cArr[i2 + 6] = (char) (i6 >> 16);
        int i7 = i2 + 8;
        cArr[i2 + 7] = (char) ((i6 >> 8) & 127);
        int i8 = i2 + 9;
        cArr[i7] = (char) (i6 & 127);
        return i8;
    }

    public static int d(int i) {
        return (int) ((((long) i) * 274877907) >>> 38);
    }

    public static int e(char[] cArr, int i, int i2) {
        int i3;
        if (i < 0) {
            if (i == Integer.MIN_VALUE) {
                String str = a;
                int length = str.length();
                str.getChars(0, length, cArr, i2);
                return length + i2;
            }
            cArr[i2] = '-';
            i = -i;
            i2++;
        }
        if (i < 1000000) {
            if (i >= 1000) {
                int iD = d(i);
                return a(cArr, i - (iD * 1000), b(cArr, iD, i2));
            }
            if (i >= 10) {
                return b(cArr, i, i2);
            }
            cArr[i2] = (char) (i + 48);
            return i2 + 1;
        }
        if (i < 1000000000) {
            int iD2 = d(i);
            int i4 = i - (iD2 * 1000);
            int iD3 = d(iD2);
            return a(cArr, i4, a(cArr, iD2 - (iD3 * 1000), b(cArr, iD3, i2)));
        }
        int i5 = i - 1000000000;
        if (i5 >= 1000000000) {
            i5 = i - 2000000000;
            i3 = i2 + 1;
            cArr[i2] = '2';
        } else {
            i3 = i2 + 1;
            cArr[i2] = '1';
        }
        return c(cArr, i5, i3);
    }

    public static int f(long j, char[] cArr, int i) {
        int iC;
        if (j < 0) {
            if (j > -2147483648L) {
                return e(cArr, (int) j, i);
            }
            if (j == Long.MIN_VALUE) {
                String str = b;
                int length = str.length();
                str.getChars(0, length, cArr, i);
                return length + i;
            }
            cArr[i] = '-';
            j = -j;
            i++;
        } else if (j <= 2147483647L) {
            return e(cArr, (int) j, i);
        }
        long j2 = j / 1000000000;
        long j3 = j - (j2 * 1000000000);
        if (j2 < 1000000000) {
            int i2 = (int) j2;
            int[] iArr = c;
            if (i2 >= 1000000) {
                int iD = d(i2);
                int i3 = i2 - (iD * 1000);
                int iD2 = d(iD);
                int iB = b(cArr, iD2, i);
                int i4 = iArr[iD - (iD2 * 1000)];
                cArr[iB] = (char) (i4 >> 16);
                cArr[iB + 1] = (char) ((i4 >> 8) & 127);
                cArr[iB + 2] = (char) (i4 & 127);
                int i5 = iArr[i3];
                cArr[iB + 3] = (char) (i5 >> 16);
                int i6 = iB + 5;
                cArr[iB + 4] = (char) ((i5 >> 8) & 127);
                iC = iB + 6;
                cArr[i6] = (char) (i5 & 127);
            } else if (i2 < 1000) {
                iC = b(cArr, i2, i);
            } else {
                int iD3 = d(i2);
                int i7 = i2 - (iD3 * 1000);
                int i8 = iArr[iD3];
                if (iD3 > 9) {
                    if (iD3 > 99) {
                        cArr[i] = (char) (i8 >> 16);
                        i++;
                    }
                    cArr[i] = (char) ((i8 >> 8) & 127);
                    i++;
                }
                cArr[i] = (char) (i8 & 127);
                int i9 = iArr[i7];
                cArr[i + 1] = (char) (i9 >> 16);
                int i10 = i + 3;
                cArr[i + 2] = (char) ((i9 >> 8) & 127);
                iC = i + 4;
                cArr[i10] = (char) (i9 & 127);
            }
        } else {
            long j4 = j2 / 1000000000;
            int iB2 = b(cArr, (int) j4, i);
            iC = c(cArr, (int) (j2 - (1000000000 * j4)), iB2);
        }
        return c(cArr, (int) j3, iC);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String g(double d, boolean z) {
        if (!z) {
            return Double.toString(d);
        }
        gi0 gi0Var = new gi0(2);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d);
        long j = 4503599627370495L & jDoubleToRawLongBits;
        int i = ((int) (jDoubleToRawLongBits >>> 52)) & 2047;
        if (i >= 2047) {
            return j != 0 ? "NaN" : jDoubleToRawLongBits > 0 ? "Infinity" : "-Infinity";
        }
        gi0Var.b = -1;
        if (jDoubleToRawLongBits < 0) {
            gi0Var.a(45);
        }
        if (i != 0) {
            int i2 = 1075 - i;
            long j2 = j | 4503599627370496L;
            if ((i2 > 0) & (i2 < 53)) {
                long j3 = j2 >> i2;
                if ((j3 << i2) == j2) {
                    gi0Var.i(0, j3);
                } else {
                    gi0Var.k(-i2, j2, 0);
                }
            }
        } else {
            if (j == 0) {
                return jDoubleToRawLongBits == 0 ? "0.0" : "-0.0";
            }
            if (j < 3) {
                gi0Var.k(-1074, j * 10, -1);
            } else {
                gi0Var.k(-1074, j, 0);
            }
        }
        return new String(gi0Var.c, 0, 0, gi0Var.b + 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String h(float f, boolean z) {
        if (!z) {
            return Float.toString(f);
        }
        gi0 gi0Var = new gi0(3);
        int iFloatToRawIntBits = Float.floatToRawIntBits(f);
        int i = 8388607 & iFloatToRawIntBits;
        int i2 = (iFloatToRawIntBits >>> 23) & DnsRecord.CLASS_ANY;
        if (i2 >= 255) {
            return i != 0 ? "NaN" : iFloatToRawIntBits > 0 ? "Infinity" : "-Infinity";
        }
        gi0Var.b = -1;
        if (iFloatToRawIntBits < 0) {
            gi0Var.a(45);
        }
        if (i2 != 0) {
            int i3 = 150 - i2;
            int i4 = i | 8388608;
            if ((i3 > 0) & (i3 < 24)) {
                int i5 = i4 >> i3;
                if ((i5 << i3) == i4) {
                    gi0Var.h(i5, 0);
                } else {
                    gi0Var.j(-i3, i4, 0);
                }
            }
        } else {
            if (i == 0) {
                return iFloatToRawIntBits == 0 ? "0.0" : "-0.0";
            }
            if (i < 8) {
                gi0Var.j(-149, i * 10, -1);
            } else {
                gi0Var.j(-149, i, 0);
            }
        }
        return new String(gi0Var.c, 0, 0, gi0Var.b + 1);
    }
}
