package defpackage;

import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class dn4 {
    public static final CharsetDecoder a = StandardCharsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT);
    public static final b13 b = new b13();

    public static String a(String str) {
        int i;
        char[] cArr;
        boolean[] zArr = b.b;
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (cCharAt >= zArr.length || !zArr[cCharAt]) {
                int length2 = str.length();
                char[] cArr2 = (char[]) ul4.a.get();
                int i3 = 0;
                int length3 = 0;
                while (i2 < length2) {
                    if (i2 >= length2) {
                        s53.k("Index exceeds specified range");
                        return null;
                    }
                    int i4 = i2 + 1;
                    char cCharAt2 = str.charAt(i2);
                    int codePoint = cCharAt2;
                    if (cCharAt2 >= 55296) {
                        codePoint = cCharAt2;
                        if (cCharAt2 <= 57343) {
                            if (cCharAt2 > 56319) {
                                throw new IllegalArgumentException("Unexpected low surrogate character '" + cCharAt2 + "' with value " + ((int) cCharAt2) + " at index " + i2);
                            }
                            if (i4 == length2) {
                                codePoint = -cCharAt2;
                            } else {
                                char cCharAt3 = str.charAt(i4);
                                if (!Character.isLowSurrogate(cCharAt3)) {
                                    throw new IllegalArgumentException("Expected low surrogate but got char '" + cCharAt3 + "' with value " + ((int) cCharAt3) + " at index " + i4);
                                }
                                codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            }
                        }
                    }
                    if (codePoint < 0) {
                        xe.k("Trailing high surrogate at end of input");
                        return null;
                    }
                    char[] cArr3 = b13.c;
                    if (codePoint < zArr.length && zArr[codePoint]) {
                        i = 1;
                        cArr = null;
                    } else if (codePoint <= 127) {
                        cArr = new char[]{'%', cArr3[codePoint >>> 4], cArr3[codePoint & 15]};
                        i = 1;
                    } else {
                        i = 1;
                        if (codePoint <= 2047) {
                            cArr = new char[]{'%', cArr3[12 | (codePoint >>> 10)], cArr3[(codePoint >>> 6) & 15], '%', cArr3[((codePoint >>> 4) & 3) | 8], cArr3[codePoint & 15]};
                        } else if (codePoint <= 65535) {
                            cArr = new char[]{'%', 'E', cArr3[codePoint >>> 12], '%', cArr3[((codePoint >>> 10) & 3) | 8], cArr3[(codePoint >>> 6) & 15], '%', cArr3[((codePoint >>> 4) & 3) | 8], cArr3[codePoint & 15]};
                        } else {
                            if (codePoint > 1114111) {
                                xe.k(dw2.A(codePoint, "Invalid unicode character value "));
                                return null;
                            }
                            cArr = new char[]{'%', 'F', cArr3[(codePoint >>> 18) & 7], '%', cArr3[((codePoint >>> 16) & 3) | 8], cArr3[(codePoint >>> 12) & 15], '%', cArr3[((codePoint >>> 10) & 3) | 8], cArr3[(codePoint >>> 6) & 15], '%', cArr3[((codePoint >>> 4) & 3) | 8], cArr3[codePoint & 15]};
                        }
                    }
                    if (cArr != null) {
                        int i5 = i2 - i3;
                        int i6 = length3 + i5;
                        int length4 = cArr.length + i6;
                        if (cArr2.length < length4) {
                            char[] cArr4 = new char[(length2 - i2) + length4 + 32];
                            if (length3 > 0) {
                                System.arraycopy(cArr2, 0, cArr4, 0, length3);
                            }
                            cArr2 = cArr4;
                        }
                        if (i5 > 0) {
                            str.getChars(i3, i2, cArr2, length3);
                            length3 = i6;
                        }
                        if (cArr.length > 0) {
                            System.arraycopy(cArr, 0, cArr2, length3, cArr.length);
                            length3 += cArr.length;
                        }
                    }
                    i3 = i2 + (Character.isSupplementaryCodePoint(codePoint) ? 2 : i);
                    i2 = i3;
                    while (i2 < length2) {
                        char cCharAt4 = str.charAt(i2);
                        if (cCharAt4 >= zArr.length || !zArr[cCharAt4]) {
                            break;
                        }
                        i2++;
                    }
                }
                int i7 = length2 - i3;
                if (i7 > 0) {
                    int i8 = i7 + length3;
                    if (cArr2.length < i8) {
                        char[] cArr5 = new char[i8];
                        if (length3 > 0) {
                            System.arraycopy(cArr2, 0, cArr5, 0, length3);
                        }
                        cArr2 = cArr5;
                    }
                    str.getChars(i3, length2, cArr2, length3);
                    length3 = i8;
                }
                return new String(cArr2, 0, length3);
            }
            i2++;
        }
        return str;
    }
}
