package defpackage;

import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vn4 extends ye {
    public final /* synthetic */ int g;

    public /* synthetic */ vn4(int i) {
        this.g = i;
    }

    public static int X(int i, long j, int i2, byte[] bArr) {
        if (i2 == 0) {
            ye yeVar = zn4.a;
            if (i > -12) {
                return -1;
            }
            return i;
        }
        if (i2 == 1) {
            return zn4.b(i, wm4.e(bArr, j));
        }
        if (i2 == 2) {
            return zn4.c(i, wm4.e(bArr, j), wm4.e(bArr, j + 1));
        }
        throw new AssertionError();
    }

    @Override // defpackage.ye
    public final int G(int i, int i2, byte[] bArr) {
        byte b;
        int i3;
        long j;
        int i4 = i;
        switch (this.g) {
            case 0:
                while (i4 < i2 && bArr[i4] >= 0) {
                    i4++;
                }
                if (i4 < i2) {
                    while (i4 < i2) {
                        int i5 = i4 + 1;
                        byte b2 = bArr[i4];
                        if (b2 >= 0) {
                            i4 = i5;
                        } else if (b2 < -32) {
                            if (i5 >= i2) {
                                return b2;
                            }
                            if (b2 < -62) {
                                return -1;
                            }
                            i4 += 2;
                            if (bArr[i5] > -65) {
                                return -1;
                            }
                        } else if (b2 < -16) {
                            if (i5 >= i2 - 1) {
                                return zn4.d(i5, i2, bArr);
                            }
                            int i6 = i4 + 2;
                            byte b3 = bArr[i5];
                            if (b3 > -65) {
                                return -1;
                            }
                            if (b2 == -32 && b3 < -96) {
                                return -1;
                            }
                            if (b2 == -19 && b3 >= -96) {
                                return -1;
                            }
                            i4 += 3;
                            if (bArr[i6] > -65) {
                                return -1;
                            }
                        } else {
                            if (i5 >= i2 - 2) {
                                return zn4.d(i5, i2, bArr);
                            }
                            int i7 = i4 + 2;
                            byte b4 = bArr[i5];
                            if (b4 > -65 || (((b4 + 112) + (b2 << 28)) >> 30) != 0) {
                                return -1;
                            }
                            int i8 = i4 + 3;
                            if (bArr[i7] > -65) {
                                return -1;
                            }
                            i4 += 4;
                            if (bArr[i8] > -65) {
                                return -1;
                            }
                        }
                    }
                }
                return 0;
            default:
                if ((i4 | i2 | (bArr.length - i2)) < 0) {
                    throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i4), Integer.valueOf(i2)));
                }
                long j2 = i4;
                int i9 = (int) (((long) i2) - j2);
                if (i9 < 16) {
                    j = j2;
                    b = 0;
                    i3 = 0;
                } else {
                    int i10 = 8 - (((int) j2) & 7);
                    long j3 = j2;
                    b = 0;
                    i3 = 0;
                    while (true) {
                        if (i3 < i10) {
                            long j4 = j3 + 1;
                            if (wm4.e(bArr, j3) < 0) {
                                j = j2;
                            } else {
                                i3++;
                                j3 = j4;
                            }
                        } else {
                            while (true) {
                                int i11 = i3 + 8;
                                if (i11 <= i9) {
                                    j = j2;
                                    if ((wm4.b.b.getLong(bArr, wm4.e + j3) & (-9187201950435737472L)) == 0) {
                                        j3 += 8;
                                        i3 = i11;
                                        j2 = j;
                                    }
                                } else {
                                    j = j2;
                                }
                            }
                            while (true) {
                                if (i3 < i9) {
                                    long j5 = j3 + 1;
                                    if (wm4.e(bArr, j3) >= 0) {
                                        i3++;
                                        j3 = j5;
                                    }
                                } else {
                                    i3 = i9;
                                }
                            }
                        }
                    }
                }
                int i12 = i9 - i3;
                long j6 = j + ((long) i3);
                while (true) {
                    byte b5 = b;
                    while (true) {
                        if (i12 > 0) {
                            long j7 = j6 + 1;
                            byte bE = wm4.e(bArr, j6);
                            if (bE >= 0) {
                                i12--;
                                j6 = j7;
                                b5 = bE;
                            } else {
                                j6 = j7;
                                b5 = bE;
                            }
                        }
                    }
                    if (i12 == 0) {
                        return b;
                    }
                    int i13 = i12 - 1;
                    if (b5 < -32) {
                        if (i13 == 0) {
                            return b5;
                        }
                        i12 -= 2;
                        if (b5 < -62) {
                            return -1;
                        }
                        long j8 = j6 + 1;
                        if (wm4.e(bArr, j6) > -65) {
                            return -1;
                        }
                        j6 = j8;
                    } else if (b5 < -16) {
                        if (i13 < 2) {
                            return X(b5, j6, i13, bArr);
                        }
                        i12 -= 3;
                        long j9 = j6 + 1;
                        byte bE2 = wm4.e(bArr, j6);
                        if (bE2 > -65) {
                            return -1;
                        }
                        if (b5 == -32 && bE2 < -96) {
                            return -1;
                        }
                        if (b5 == -19 && bE2 >= -96) {
                            return -1;
                        }
                        j6 += 2;
                        if (wm4.e(bArr, j9) > -65) {
                            return -1;
                        }
                    } else {
                        if (i13 < 3) {
                            return X(b5, j6, i13, bArr);
                        }
                        i12 -= 4;
                        long j10 = j6 + 1;
                        byte bE3 = wm4.e(bArr, j6);
                        if (bE3 > -65 || (((bE3 + 112) + (b5 << 28)) >> 30) != 0) {
                            return -1;
                        }
                        long j11 = j6 + 2;
                        if (wm4.e(bArr, j10) > -65) {
                            return -1;
                        }
                        j6 += 3;
                        if (wm4.e(bArr, j11) > -65) {
                            return -1;
                        }
                    }
                }
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    @Override // defpackage.ye
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String h(int i, int i2, byte[] bArr) throws s12 {
        switch (this.g) {
            case 0:
                if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
                    throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
                }
                int i3 = i + i2;
                char[] cArr = new char[i2];
                int i4 = 0;
                while (i < i3) {
                    byte b = bArr[i];
                    if (b < 0) {
                        while (i < i3) {
                            int i5 = i + 1;
                            byte b2 = bArr[i];
                            if (b2 >= 0) {
                                int i6 = i4 + 1;
                                cArr[i4] = (char) b2;
                                while (i5 < i3) {
                                    byte b3 = bArr[i5];
                                    if (b3 >= 0) {
                                        i5++;
                                        cArr[i6] = (char) b3;
                                        i6++;
                                    } else {
                                        i4 = i6;
                                        i = i5;
                                    }
                                }
                                i4 = i6;
                                i = i5;
                            } else if (b2 < -32) {
                                if (i5 >= i3) {
                                    throw s12.a();
                                }
                                i += 2;
                                byte b4 = bArr[i5];
                                int i7 = i4 + 1;
                                if (b2 < -62 || xb5.E(b4)) {
                                    throw s12.a();
                                }
                                cArr[i4] = (char) ((b4 & 63) | ((b2 & 31) << 6));
                                i4 = i7;
                            } else if (b2 < -16) {
                                if (i5 >= i3 - 1) {
                                    throw s12.a();
                                }
                                int i8 = i + 2;
                                byte b5 = bArr[i5];
                                i += 3;
                                byte b6 = bArr[i8];
                                int i9 = i4 + 1;
                                if (xb5.E(b5) || ((b2 == -32 && b5 < -96) || ((b2 == -19 && b5 >= -96) || xb5.E(b6)))) {
                                    throw s12.a();
                                }
                                cArr[i4] = (char) (((b5 & 63) << 6) | ((b2 & 15) << 12) | (b6 & 63));
                                i4 = i9;
                            } else {
                                if (i5 >= i3 - 2) {
                                    throw s12.a();
                                }
                                byte b7 = bArr[i5];
                                int i10 = i + 3;
                                byte b8 = bArr[i + 2];
                                i += 4;
                                byte b9 = bArr[i10];
                                int i11 = i4 + 1;
                                if (xb5.E(b7) || (((b7 + 112) + (b2 << 28)) >> 30) != 0 || xb5.E(b8) || xb5.E(b9)) {
                                    throw s12.a();
                                }
                                int i12 = ((b7 & 63) << 12) | ((b2 & 7) << 18) | ((b8 & 63) << 6) | (b9 & 63);
                                cArr[i4] = (char) ((i12 >>> 10) + 55232);
                                cArr[i11] = (char) ((i12 & 1023) + 56320);
                                i4 += 2;
                            }
                        }
                        return new String(cArr, 0, i4);
                    }
                    i++;
                    cArr[i4] = (char) b;
                    i4++;
                }
                while (i < i3) {
                }
                return new String(cArr, 0, i4);
            default:
                Charset charset = i12.a;
                String str = new String(bArr, i, i2, charset);
                if (str.indexOf(65533) >= 0 && !Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i, i2 + i))) {
                    throw s12.a();
                }
                return str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0164  */
    @Override // defpackage.ye
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int l(String str, byte[] bArr, int i, int i2) {
        int i3;
        char cCharAt;
        long j;
        long j2;
        String str2;
        int i4;
        int i5;
        char cCharAt2;
        char c = 2048;
        int i6 = 0;
        char c2 = 55296;
        char c3 = 57343;
        String str3 = "Not enough space in output buffer to encode UTF-8 string";
        switch (this.g) {
            case 0:
                int length = str.length();
                int i7 = i2 + i;
                while (i6 < length) {
                    int i8 = i6 + i;
                    if (i8 >= i7 || (cCharAt = str.charAt(i6)) >= 128) {
                        if (i6 != length) {
                            return i + length;
                        }
                        int i9 = i + i6;
                        while (i6 < length) {
                            char cCharAt3 = str.charAt(i6);
                            if (cCharAt3 < 128 && i9 < i7) {
                                bArr[i9] = (byte) cCharAt3;
                                i9++;
                            } else if (cCharAt3 < 2048 && i9 <= i7 - 2) {
                                int i10 = i9 + 1;
                                bArr[i9] = (byte) ((cCharAt3 >>> 6) | 960);
                                i9 += 2;
                                bArr[i10] = (byte) ((cCharAt3 & '?') | 128);
                            } else {
                                if ((cCharAt3 >= 55296 && 57343 >= cCharAt3) || i9 > i7 - 3) {
                                    if (i9 > i7 - 4) {
                                        if (55296 > cCharAt3 || cCharAt3 > 57343 || ((i3 = i6 + 1) != str.length() && Character.isSurrogatePair(cCharAt3, str.charAt(i3)))) {
                                            throw new ArrayIndexOutOfBoundsException("Not enough space in output buffer to encode UTF-8 string");
                                        }
                                        throw new xn4(i6, length);
                                    }
                                    int i11 = i6 + 1;
                                    if (i11 != str.length()) {
                                        char cCharAt4 = str.charAt(i11);
                                        if (Character.isSurrogatePair(cCharAt3, cCharAt4)) {
                                            int codePoint = Character.toCodePoint(cCharAt3, cCharAt4);
                                            bArr[i9] = (byte) ((codePoint >>> 18) | 240);
                                            bArr[i9 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                            int i12 = i9 + 3;
                                            bArr[i9 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                            i9 += 4;
                                            bArr[i12] = (byte) ((codePoint & 63) | 128);
                                            i6 = i11;
                                        } else {
                                            i6 = i11;
                                        }
                                    }
                                    throw new xn4(i6 - 1, length);
                                }
                                bArr[i9] = (byte) ((cCharAt3 >>> '\f') | 480);
                                int i13 = i9 + 2;
                                bArr[i9 + 1] = (byte) (((cCharAt3 >>> 6) & 63) | 128);
                                i9 += 3;
                                bArr[i13] = (byte) ((cCharAt3 & '?') | 128);
                            }
                            i6++;
                        }
                        return i9;
                    }
                    bArr[i8] = (byte) cCharAt;
                    i6++;
                }
                if (i6 != length) {
                }
                break;
            default:
                long j3 = i;
                long j4 = ((long) i2) + j3;
                int length2 = str.length();
                if (length2 > i2 || bArr.length - i2 < i) {
                    throw new ArrayIndexOutOfBoundsException("Not enough space in output buffer to encode UTF-8 string");
                }
                while (true) {
                    j = 1;
                    if (i6 < length2 && (cCharAt2 = str.charAt(i6)) < 128) {
                        wm4.g(bArr, j3, (byte) cCharAt2);
                        i6++;
                        j3 = 1 + j3;
                    }
                }
                if (i6 != length2) {
                    while (i6 < length2) {
                        char cCharAt5 = str.charAt(i6);
                        if (cCharAt5 < 128 && j3 < j4) {
                            wm4.g(bArr, j3, (byte) cCharAt5);
                            j2 = j;
                            j3 += j;
                        } else if (cCharAt5 >= c || j3 > j4 - 2) {
                            int i14 = i6;
                            j2 = j;
                            if ((cCharAt5 >= c2 && c3 >= cCharAt5) || j3 > j4 - 3) {
                                str2 = str3;
                                if (j3 > j4 - 4) {
                                    if (c2 > cCharAt5 || cCharAt5 > 57343 || ((i4 = i14 + 1) != length2 && Character.isSurrogatePair(cCharAt5, str.charAt(i4)))) {
                                        throw new ArrayIndexOutOfBoundsException(str2);
                                    }
                                    throw new xn4(i14, length2);
                                }
                                int i15 = i14 + 1;
                                if (i15 != length2) {
                                    char cCharAt6 = str.charAt(i15);
                                    if (Character.isSurrogatePair(cCharAt5, cCharAt6)) {
                                        int codePoint2 = Character.toCodePoint(cCharAt5, cCharAt6);
                                        wm4.g(bArr, j3, (byte) ((codePoint2 >>> 18) | 240));
                                        wm4.g(bArr, j3 + j2, (byte) (((codePoint2 >>> 12) & 63) | 128));
                                        long j5 = j3 + 3;
                                        wm4.g(bArr, j3 + 2, (byte) (((codePoint2 >>> 6) & 63) | 128));
                                        j3 += 4;
                                        wm4.g(bArr, j5, (byte) ((codePoint2 & 63) | 128));
                                        i6 = i15;
                                    } else {
                                        i5 = i15;
                                    }
                                } else {
                                    i5 = i14;
                                }
                                throw new xn4(i5 - 1, length2);
                            }
                            wm4.g(bArr, j3, (byte) ((cCharAt5 >>> '\f') | 480));
                            str2 = str3;
                            long j6 = j3 + 2;
                            wm4.g(bArr, j3 + j2, (byte) (((cCharAt5 >>> 6) & 63) | 128));
                            j3 += 3;
                            wm4.g(bArr, j6, (byte) ((cCharAt5 & '?') | 128));
                            i6 = i14;
                            i6++;
                            str3 = str2;
                            c = 2048;
                            c2 = 55296;
                            c3 = 57343;
                            j = j2;
                        } else {
                            long j7 = j3 + j;
                            j2 = j;
                            wm4.g(bArr, j3, (byte) ((cCharAt5 >>> 6) | 960));
                            j3 += 2;
                            wm4.g(bArr, j7, (byte) ((cCharAt5 & '?') | 128));
                            i6 = i6;
                        }
                        str2 = str3;
                        i6++;
                        str3 = str2;
                        c = 2048;
                        c2 = 55296;
                        c3 = 57343;
                        j = j2;
                    }
                }
                return (int) j3;
        }
    }
}
