package defpackage;

import io.netty.handler.codec.http.HttpConstants;
import j$.util.Map;
import java.lang.Character;
import java.math.BigInteger;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class tb4 {
    public static final boolean a;

    static {
        Logger.getLogger(tb4.class.getName());
        a = ((String) Map.EL.getOrDefault(System.getenv(), "SILENT_MARKER_INSERTION_ENABLED", "false")).equals("true");
        int i = xj4.b;
        xj4 xj4Var = wj4.a;
    }

    public static int a(byte b) {
        return (48 > b || b > 57) ? (97 > b || b > 122) ? b - 55 : b - 87 : b - 48;
    }

    public static boolean b(byte b) {
        if (48 <= b && b <= 57) {
            return true;
        }
        if (97 > b || b > 102) {
            return 65 <= b && b <= 70;
        }
        return true;
    }

    public static long c(String str, boolean z, boolean z2) {
        int i;
        int i2 = 0;
        if (str.startsWith("-", 0)) {
            if (!z) {
                throw new NumberFormatException("Number must be positive: ".concat(str));
            }
            i2 = 1;
        }
        int i3 = i2;
        if (str.startsWith("0x", i2)) {
            i2 += 2;
            i = 16;
        } else {
            i = str.startsWith("0", i2) ? 8 : 10;
        }
        String strSubstring = str.substring(i2);
        if (strSubstring.length() < 16) {
            long j = Long.parseLong(strSubstring, i);
            if (i3 != 0) {
                j = -j;
            }
            if (!z2) {
                if (z) {
                    if (j > 2147483647L || j < -2147483648L) {
                        throw new NumberFormatException("Number out of range for 32-bit signed integer: ".concat(str));
                    }
                } else if (j >= 4294967296L || j < 0) {
                    throw new NumberFormatException("Number out of range for 32-bit unsigned integer: ".concat(str));
                }
            }
            return j;
        }
        BigInteger bigInteger = new BigInteger(strSubstring, i);
        if (i3 != 0) {
            bigInteger = bigInteger.negate();
        }
        if (z2) {
            if (z) {
                if (bigInteger.bitLength() > 63) {
                    throw new NumberFormatException("Number out of range for 64-bit signed integer: ".concat(str));
                }
            } else if (bigInteger.bitLength() > 64) {
                throw new NumberFormatException("Number out of range for 64-bit unsigned integer: ".concat(str));
            }
        } else if (z) {
            if (bigInteger.bitLength() > 31) {
                throw new NumberFormatException("Number out of range for 32-bit signed integer: ".concat(str));
            }
        } else if (bigInteger.bitLength() > 32) {
            throw new NumberFormatException("Number out of range for 32-bit unsigned integer: ".concat(str));
        }
        return bigInteger.longValue();
    }

    public static zt d(String str) throws pb4 {
        int i;
        int i2;
        int length;
        int i3;
        byte b;
        byte b2;
        String string = str.toString();
        zt ztVar = zt.z;
        byte[] bytes = string.getBytes(i12.a);
        zt ztVar2 = new zt(bytes);
        int length2 = bytes.length;
        byte[] bArr = new byte[length2];
        int i4 = 0;
        int i5 = 0;
        while (i4 < bytes.length) {
            byte b3 = bytes[i4];
            if (b3 == 92) {
                int i6 = i4 + 1;
                if (i6 >= bytes.length) {
                    throw new pb4("Invalid escape sequence: '\\' at end of string.");
                }
                byte b4 = bytes[i6];
                if (48 > b4 || b4 > 55) {
                    if (b4 == 34) {
                        i = i5 + 1;
                        bArr[i5] = HttpConstants.DOUBLE_QUOTE;
                    } else if (b4 == 39) {
                        i = i5 + 1;
                        bArr[i5] = 39;
                    } else if (b4 != 63) {
                        if (b4 == 85) {
                            int i7 = i4 + 2;
                            i2 = i4 + 9;
                            if (i2 >= bytes.length) {
                                throw new pb4("Invalid escape sequence: '\\U' with too few hex chars");
                            }
                            int iA = 0;
                            int i8 = i7;
                            while (true) {
                                int i9 = i4 + 10;
                                if (i8 < i9) {
                                    byte b5 = bytes[i8];
                                    if (!b(b5)) {
                                        throw new pb4("Invalid escape sequence: '\\U' with too few hex chars");
                                    }
                                    iA = (iA << 4) | a(b5);
                                    i8++;
                                } else {
                                    if (!Character.isValidCodePoint(iA)) {
                                        throw new pb4("Invalid escape sequence: '\\U" + ztVar2.h(i7, i9).i() + "' is not a valid code point value");
                                    }
                                    Character.UnicodeBlock unicodeBlockOf = Character.UnicodeBlock.of(iA);
                                    if (unicodeBlockOf != null && (unicodeBlockOf.equals(Character.UnicodeBlock.LOW_SURROGATES) || unicodeBlockOf.equals(Character.UnicodeBlock.HIGH_SURROGATES) || unicodeBlockOf.equals(Character.UnicodeBlock.HIGH_PRIVATE_USE_SURROGATES))) {
                                        throw new pb4("Invalid escape sequence: '\\U" + ztVar2.h(i7, i9).i() + "' refers to a surrogate code unit");
                                    }
                                    byte[] bytes2 = new String(new int[]{iA}, 0, 1).getBytes(i12.a);
                                    System.arraycopy(bytes2, 0, bArr, i5, bytes2.length);
                                    length = bytes2.length;
                                }
                            }
                        } else if (b4 == 92) {
                            i = i5 + 1;
                            bArr[i5] = 92;
                        } else if (b4 == 102) {
                            i = i5 + 1;
                            bArr[i5] = 12;
                        } else if (b4 == 110) {
                            i = i5 + 1;
                            bArr[i5] = 10;
                        } else if (b4 == 114) {
                            i = i5 + 1;
                            bArr[i5] = HttpConstants.CR;
                        } else if (b4 == 120) {
                            int i10 = i4 + 2;
                            if (i10 >= bytes.length || !b(bytes[i10])) {
                                throw new pb4("Invalid escape sequence: '\\x' with no digits");
                            }
                            int iA2 = a(bytes[i10]);
                            i4 += 3;
                            if (i4 >= bytes.length || !b(bytes[i4])) {
                                i4 = i10;
                            } else {
                                iA2 = (iA2 * 16) + a(bytes[i4]);
                            }
                            i3 = i5 + 1;
                            bArr[i5] = (byte) iA2;
                        } else if (b4 == 97) {
                            i = i5 + 1;
                            bArr[i5] = 7;
                        } else if (b4 != 98) {
                            switch (b4) {
                                case 116:
                                    i = i5 + 1;
                                    bArr[i5] = 9;
                                    break;
                                case 117:
                                    int i11 = i4 + 2;
                                    i2 = i4 + 5;
                                    if (i2 < bytes.length && b(bytes[i11])) {
                                        int i12 = i4 + 3;
                                        if (b(bytes[i12])) {
                                            int i13 = i4 + 4;
                                            if (b(bytes[i13]) && b(bytes[i2])) {
                                                char cA = (char) ((a(bytes[i13]) << 4) | (a(bytes[i11]) << 12) | (a(bytes[i12]) << 8) | a(bytes[i2]));
                                                if (cA >= 55296 && cA <= 57343) {
                                                    throw new pb4("Invalid escape sequence: '\\u' refers to a surrogate");
                                                }
                                                byte[] bytes3 = Character.toString(cA).getBytes(i12.a);
                                                System.arraycopy(bytes3, 0, bArr, i5, bytes3.length);
                                                length = bytes3.length;
                                                break;
                                            }
                                        }
                                    }
                                    throw new pb4("Invalid escape sequence: '\\u' with too few hex chars");
                                case 118:
                                    i = i5 + 1;
                                    bArr[i5] = 11;
                                    break;
                                default:
                                    throw new pb4("Invalid escape sequence: '\\" + ((char) b4) + '\'');
                            }
                        } else {
                            i = i5 + 1;
                            bArr[i5] = 8;
                        }
                        i5 += length;
                        i4 = i2;
                    } else {
                        i = i5 + 1;
                        bArr[i5] = 63;
                    }
                    i5 = i;
                    i4 = i6;
                } else {
                    int iA3 = a(b4);
                    int i14 = i4 + 2;
                    if (i14 < bytes.length && 48 <= (b2 = bytes[i14]) && b2 <= 55) {
                        iA3 = (iA3 * 8) + a(b2);
                        i6 = i14;
                    }
                    i4 = i6 + 1;
                    if (i4 >= bytes.length || 48 > (b = bytes[i4]) || b > 55) {
                        i4 = i6;
                    } else {
                        iA3 = (iA3 * 8) + a(b);
                    }
                    i3 = i5 + 1;
                    bArr[i5] = (byte) iA3;
                }
                i5 = i3;
            } else {
                bArr[i5] = b3;
                i5++;
            }
            i4++;
        }
        return length2 == i5 ? new zt(bArr) : zt.c(0, i5, bArr);
    }
}
