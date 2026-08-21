package defpackage;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String g(double r7, boolean r9) {
        /*
            if (r9 == 0) goto L8d
            gi0 r9 = new gi0
            r0 = 2
            r9.<init>(r0)
            long r7 = java.lang.Double.doubleToRawLongBits(r7)
            r0 = 4503599627370495(0xfffffffffffff, double:2.225073858507201E-308)
            long r0 = r0 & r7
            r2 = 52
            long r2 = r7 >>> r2
            int r2 = (int) r2
            r3 = 2047(0x7ff, float:2.868E-42)
            r2 = r2 & r3
            r4 = 0
            if (r2 >= r3) goto L7c
            r3 = -1
            r9.b = r3
            int r7 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r7 >= 0) goto L2a
            r8 = 45
            r9.a(r8)
        L2a:
            r8 = 1
            r6 = 0
            if (r2 == 0) goto L53
            int r7 = 1075 - r2
            r2 = 4503599627370496(0x10000000000000, double:2.2250738585072014E-308)
            long r0 = r0 | r2
            if (r7 <= 0) goto L37
            r2 = r8
            goto L38
        L37:
            r2 = r6
        L38:
            r3 = 53
            if (r7 >= r3) goto L3e
            r3 = r8
            goto L3f
        L3e:
            r3 = r6
        L3f:
            r2 = r2 & r3
            if (r2 == 0) goto L4e
            long r2 = r0 >> r7
            long r4 = r2 << r7
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 != 0) goto L4e
            r9.i(r6, r2)
            goto L69
        L4e:
            int r7 = -r7
            r9.k(r7, r0, r6)
            goto L69
        L53:
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 == 0) goto L74
            r4 = 3
            int r7 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            r2 = -1074(0xfffffffffffffbce, float:NaN)
            if (r7 >= 0) goto L66
            r4 = 10
            long r0 = r0 * r4
            r9.k(r2, r0, r3)
            goto L69
        L66:
            r9.k(r2, r0, r6)
        L69:
            java.lang.String r7 = new java.lang.String
            int r0 = r9.b
            int r0 = r0 + r8
            byte[] r8 = r9.c
            r7.<init>(r8, r6, r6, r0)
            return r7
        L74:
            if (r7 != 0) goto L79
            java.lang.String r7 = "0.0"
            return r7
        L79:
            java.lang.String r7 = "-0.0"
            return r7
        L7c:
            int r9 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r9 == 0) goto L83
            java.lang.String r7 = "NaN"
            return r7
        L83:
            int r7 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r7 <= 0) goto L8a
            java.lang.String r7 = "Infinity"
            return r7
        L8a:
            java.lang.String r7 = "-Infinity"
            return r7
        L8d:
            java.lang.String r7 = java.lang.Double.toString(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dt2.g(double, boolean):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String h(float r5, boolean r6) {
        /*
            if (r6 == 0) goto L79
            gi0 r6 = new gi0
            r0 = 3
            r6.<init>(r0)
            int r5 = java.lang.Float.floatToRawIntBits(r5)
            r0 = 8388607(0x7fffff, float:1.1754942E-38)
            r0 = r0 & r5
            int r1 = r5 >>> 23
            r2 = 255(0xff, float:3.57E-43)
            r1 = r1 & r2
            if (r1 >= r2) goto L6c
            r2 = -1
            r6.b = r2
            if (r5 >= 0) goto L21
            r3 = 45
            r6.a(r3)
        L21:
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L48
            int r5 = 150 - r1
            r1 = 8388608(0x800000, float:1.1754944E-38)
            r0 = r0 | r1
            if (r5 <= 0) goto L2e
            r1 = r3
            goto L2f
        L2e:
            r1 = r4
        L2f:
            r2 = 24
            if (r5 >= r2) goto L35
            r2 = r3
            goto L36
        L35:
            r2 = r4
        L36:
            r1 = r1 & r2
            if (r1 == 0) goto L43
            int r1 = r0 >> r5
            int r2 = r1 << r5
            if (r2 != r0) goto L43
            r6.h(r1, r4)
            goto L59
        L43:
            int r5 = -r5
            r6.j(r5, r0, r4)
            goto L59
        L48:
            if (r0 == 0) goto L64
            r5 = 8
            r1 = -149(0xffffffffffffff6b, float:NaN)
            if (r0 >= r5) goto L56
            int r0 = r0 * 10
            r6.j(r1, r0, r2)
            goto L59
        L56:
            r6.j(r1, r0, r4)
        L59:
            java.lang.String r5 = new java.lang.String
            int r0 = r6.b
            int r0 = r0 + r3
            byte[] r6 = r6.c
            r5.<init>(r6, r4, r4, r0)
            return r5
        L64:
            if (r5 != 0) goto L69
            java.lang.String r5 = "0.0"
            return r5
        L69:
            java.lang.String r5 = "-0.0"
            return r5
        L6c:
            if (r0 == 0) goto L71
            java.lang.String r5 = "NaN"
            return r5
        L71:
            if (r5 <= 0) goto L76
            java.lang.String r5 = "Infinity"
            return r5
        L76:
            java.lang.String r5 = "-Infinity"
            return r5
        L79:
            java.lang.String r5 = java.lang.Float.toString(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dt2.h(float, boolean):java.lang.String");
    }
}
