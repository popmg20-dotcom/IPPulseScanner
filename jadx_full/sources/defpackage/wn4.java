package defpackage;

import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wn4 extends vo {
    public final /* synthetic */ int L0;

    public /* synthetic */ wn4(int i) {
        this.L0 = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    @Override // defpackage.vo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String l(int i, int i2, byte[] bArr) throws t12 {
        switch (this.L0) {
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
                                    throw t12.a();
                                }
                                i += 2;
                                byte b4 = bArr[i5];
                                int i7 = i4 + 1;
                                if (b2 < -62 || je.P(b4)) {
                                    throw t12.a();
                                }
                                cArr[i4] = (char) ((b4 & 63) | ((b2 & 31) << 6));
                                i4 = i7;
                            } else if (b2 < -16) {
                                if (i5 >= i3 - 1) {
                                    throw t12.a();
                                }
                                int i8 = i + 2;
                                byte b5 = bArr[i5];
                                i += 3;
                                byte b6 = bArr[i8];
                                int i9 = i4 + 1;
                                if (je.P(b5) || ((b2 == -32 && b5 < -96) || ((b2 == -19 && b5 >= -96) || je.P(b6)))) {
                                    throw t12.a();
                                }
                                cArr[i4] = (char) (((b5 & 63) << 6) | ((b2 & 15) << 12) | (b6 & 63));
                                i4 = i9;
                            } else {
                                if (i5 >= i3 - 2) {
                                    throw t12.a();
                                }
                                byte b7 = bArr[i5];
                                int i10 = i + 3;
                                byte b8 = bArr[i + 2];
                                i += 4;
                                byte b9 = bArr[i10];
                                int i11 = i4 + 1;
                                if (je.P(b7) || (((b7 + 112) + (b2 << 28)) >> 30) != 0 || je.P(b8) || je.P(b9)) {
                                    throw t12.a();
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
                Charset charset = j12.a;
                String str = new String(bArr, i, i2, charset);
                if (str.indexOf(65533) >= 0 && !Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i, i2 + i))) {
                    throw t12.a();
                }
                return str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0184  */
    @Override // defpackage.vo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int n(String str, byte[] bArr, int i, int i2) {
        int i3;
        char cCharAt;
        int i4;
        char cCharAt2;
        char c = 2048;
        char c2 = 55296;
        switch (this.L0) {
            case 0:
                int length = str.length();
                int i5 = i2 + i;
                int i6 = 0;
                while (i6 < length) {
                    int i7 = i6 + i;
                    if (i7 >= i5 || (cCharAt = str.charAt(i6)) >= 128) {
                        if (i6 != length) {
                            return i + length;
                        }
                        int i8 = i + i6;
                        while (i6 < length) {
                            char cCharAt3 = str.charAt(i6);
                            if (cCharAt3 < 128 && i8 < i5) {
                                bArr[i8] = (byte) cCharAt3;
                                i8++;
                            } else if (cCharAt3 < 2048 && i8 <= i5 - 2) {
                                int i9 = i8 + 1;
                                bArr[i8] = (byte) ((cCharAt3 >>> 6) | 960);
                                i8 += 2;
                                bArr[i9] = (byte) ((cCharAt3 & '?') | 128);
                            } else {
                                if ((cCharAt3 >= 55296 && 57343 >= cCharAt3) || i8 > i5 - 3) {
                                    if (i8 > i5 - 4) {
                                        if (55296 <= cCharAt3 && cCharAt3 <= 57343 && ((i3 = i6 + 1) == str.length() || !Character.isSurrogatePair(cCharAt3, str.charAt(i3)))) {
                                            throw new yn4(i6, length);
                                        }
                                        throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt3 + " at index " + i8);
                                    }
                                    int i10 = i6 + 1;
                                    if (i10 != str.length()) {
                                        char cCharAt4 = str.charAt(i10);
                                        if (Character.isSurrogatePair(cCharAt3, cCharAt4)) {
                                            int codePoint = Character.toCodePoint(cCharAt3, cCharAt4);
                                            bArr[i8] = (byte) ((codePoint >>> 18) | 240);
                                            bArr[i8 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                            int i11 = i8 + 3;
                                            bArr[i8 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                            i8 += 4;
                                            bArr[i11] = (byte) ((codePoint & 63) | 128);
                                            i6 = i10;
                                        } else {
                                            i6 = i10;
                                        }
                                    }
                                    throw new yn4(i6 - 1, length);
                                }
                                bArr[i8] = (byte) ((cCharAt3 >>> '\f') | 480);
                                int i12 = i8 + 2;
                                bArr[i8 + 1] = (byte) (((cCharAt3 >>> 6) & 63) | 128);
                                i8 += 3;
                                bArr[i12] = (byte) ((cCharAt3 & '?') | 128);
                            }
                            i6++;
                        }
                        return i8;
                    }
                    bArr[i7] = (byte) cCharAt;
                    i6++;
                }
                if (i6 != length) {
                }
                break;
            default:
                long j = i;
                long j2 = ((long) i2) + j;
                int length2 = str.length();
                if (length2 > i2 || bArr.length - i2 < i) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + str.charAt(length2 - 1) + " at index " + (i + i2));
                }
                int i13 = 0;
                while (i13 < length2 && (cCharAt2 = str.charAt(i13)) < 128) {
                    xm4.j(bArr, j, (byte) cCharAt2);
                    i13++;
                    j++;
                }
                if (i13 != length2) {
                    while (i13 < length2) {
                        char cCharAt5 = str.charAt(i13);
                        if (cCharAt5 < 128 && j < j2) {
                            xm4.j(bArr, j, (byte) cCharAt5);
                            j++;
                        } else if (cCharAt5 >= c || j > j2 - 2) {
                            int i14 = i13;
                            if ((cCharAt5 >= c2 && 57343 >= cCharAt5) || j > j2 - 3) {
                                if (j > j2 - 4) {
                                    if (55296 <= cCharAt5 && cCharAt5 <= 57343 && ((i4 = i14 + 1) == length2 || !Character.isSurrogatePair(cCharAt5, str.charAt(i4)))) {
                                        throw new yn4(i14, length2);
                                    }
                                    throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt5 + " at index " + j);
                                }
                                i13 = i14 + 1;
                                if (i13 != length2) {
                                    char cCharAt6 = str.charAt(i13);
                                    if (Character.isSurrogatePair(cCharAt5, cCharAt6)) {
                                        int codePoint2 = Character.toCodePoint(cCharAt5, cCharAt6);
                                        xm4.j(bArr, j, (byte) ((codePoint2 >>> 18) | 240));
                                        xm4.j(bArr, j + 1, (byte) (((codePoint2 >>> 12) & 63) | 128));
                                        long j3 = j + 3;
                                        xm4.j(bArr, j + 2, (byte) (((codePoint2 >>> 6) & 63) | 128));
                                        j += 4;
                                        xm4.j(bArr, j3, (byte) ((codePoint2 & 63) | 128));
                                    }
                                } else {
                                    i13 = i14;
                                }
                                throw new yn4(i13 - 1, length2);
                            }
                            xm4.j(bArr, j, (byte) ((cCharAt5 >>> '\f') | 480));
                            long j4 = j + 2;
                            xm4.j(bArr, j + 1, (byte) (((cCharAt5 >>> 6) & 63) | 128));
                            j += 3;
                            xm4.j(bArr, j4, (byte) ((cCharAt5 & '?') | 128));
                            i13 = i14;
                        } else {
                            long j5 = j + 1;
                            xm4.j(bArr, j, (byte) ((cCharAt5 >>> 6) | 960));
                            j += 2;
                            xm4.j(bArr, j5, (byte) ((cCharAt5 & '?') | 128));
                            i13 = i13;
                        }
                        i13++;
                        c = 2048;
                        c2 = 55296;
                    }
                }
                return (int) j;
        }
    }
}
