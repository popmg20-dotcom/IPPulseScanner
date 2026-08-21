package defpackage;

import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lk0 {
    public static final String[] b = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    public static final String[] c = {"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    public static final String[] d = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    public static final String[] e = {"FLG(n)", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD, "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};
    public static final String[] f = {"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};
    public static final Charset g = StandardCharsets.ISO_8859_1;
    public wh a;

    public static int b(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x0178  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final pk0 a(wh whVar) throws qi1 {
        int i;
        int i2;
        ho1 ho1Var;
        pk0 pk0Var;
        String str;
        int i3;
        int i4;
        char c2;
        char c3;
        int i5;
        this.a = whVar;
        cn cnVar = whVar.a;
        boolean z = whVar.c;
        int i6 = whVar.e;
        int i7 = (i6 * 4) + (z ? 11 : 14);
        int[] iArr = new int[i7];
        int iP = fw.p(i6, 16, z ? 88 : 112, i6);
        boolean[] zArr = new boolean[iP];
        int i8 = 2;
        int i9 = 1;
        if (z) {
            for (int i10 = 0; i10 < i7; i10++) {
                iArr[i10] = i10;
            }
        } else {
            int i11 = i7 / 2;
            int i12 = ((((i11 - 1) / 15) * 2) + (i7 + 1)) / 2;
            for (int i13 = 0; i13 < i11; i13++) {
                iArr[(i11 - i13) - 1] = (i12 - r15) - 1;
                iArr[i11 + i13] = (i13 / 15) + i13 + i12 + 1;
            }
        }
        int i14 = 0;
        int i15 = 0;
        while (true) {
            i2 = 4;
            if (i14 >= i6) {
                break;
            }
            int i16 = ((i6 - i14) * 4) + (z ? 9 : 12);
            int i17 = i14 * 2;
            int i18 = (i7 - 1) - i17;
            int i19 = 0;
            while (i19 < i16) {
                int i20 = i19 * 2;
                int i21 = 0;
                while (i21 < i8) {
                    int i22 = i17 + i21;
                    int i23 = i9;
                    int i24 = i17 + i19;
                    zArr[i15 + i20 + i21] = cnVar.b(iArr[i22], iArr[i24]);
                    int i25 = i18 - i21;
                    zArr[(i16 * 2) + i15 + i20 + i21] = cnVar.b(iArr[i24], iArr[i25]);
                    int i26 = i18 - i19;
                    zArr[(i16 * 4) + i15 + i20 + i21] = cnVar.b(iArr[i25], iArr[i26]);
                    zArr[(i16 * 6) + i15 + i20 + i21] = cnVar.b(iArr[i26], iArr[i22]);
                    i21++;
                    i9 = i23;
                    i6 = i6;
                    i8 = 2;
                }
                i19++;
                i8 = 2;
            }
            i15 += i16 * 8;
            i14++;
            i8 = 2;
        }
        int i27 = i9;
        wh whVar2 = this.a;
        int i28 = whVar2.e;
        int i29 = 6;
        int i30 = 8;
        if (i28 <= 2) {
            ho1Var = ho1.j;
            i = 6;
        } else if (i28 <= 8) {
            ho1Var = ho1.n;
            i = 8;
        } else if (i28 <= 22) {
            ho1Var = ho1.i;
            i = 10;
        } else {
            ho1Var = ho1.h;
        }
        int i31 = whVar2.d;
        int i32 = iP / i;
        if (i32 < i31) {
            throw qi1.a();
        }
        int i33 = iP % i;
        int[] iArr2 = new int[i32];
        int i34 = 0;
        while (i34 < i32) {
            iArr2[i34] = b(zArr, i33, i);
            i34++;
            i33 += i;
        }
        try {
            ha1 ha1Var = new ha1(21, ho1Var);
            int i35 = i32 - i31;
            int iW = ha1Var.w(iArr2, i35);
            int i36 = i27 << i;
            int i37 = i36 - 1;
            int i38 = 0;
            int i39 = 0;
            while (i38 < i31) {
                int i40 = iArr2[i38];
                if (i40 == 0 || i40 == i37) {
                    throw qi1.a();
                }
                if (i40 == i27 || i40 == i36 - 2) {
                    i39++;
                }
                i38++;
                i27 = 1;
            }
            int i41 = (i31 * i) - i39;
            boolean[] zArr2 = new boolean[i41];
            int i42 = 0;
            int i43 = 0;
            while (i42 < i31) {
                int i44 = iArr2[i42];
                if (i44 != 1) {
                    int i45 = 1;
                    if (i44 == i36 - 2) {
                        i5 = i2;
                        Arrays.fill(zArr2, i43, (i43 + i) - 1, i44 > 1);
                        i43 = (i - 1) + i43;
                    } else {
                        int i46 = i - 1;
                        while (i46 >= 0) {
                            int i47 = i43 + 1;
                            zArr2[i43] = (i44 & (i45 << i46)) != 0;
                            i46--;
                            i43 = i47;
                            i45 = 1;
                        }
                        i5 = i2;
                    }
                }
                i42++;
                i2 = i5;
            }
            int i48 = i2;
            int i49 = (i35 * 100) / i32;
            int i50 = (i41 + 7) / 8;
            byte[] bArr = new byte[i50];
            for (int i51 = 0; i51 < i50; i51++) {
                int i52 = i51 * 8;
                int i53 = i41 - i52;
                bArr[i51] = (byte) (i53 >= 8 ? b(zArr2, i52, 8) : b(zArr2, i52, i53) << (8 - i53));
            }
            StringBuilder sb = new StringBuilder((i41 - 5) / 4);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Charset charsetForName = g;
            int i54 = 0;
            int i55 = 1;
            int i56 = 1;
            try {
                loop9: while (i54 < i41) {
                    int i57 = 5;
                    if (i56 != i29) {
                        int i58 = i56 == i48 ? 4 : 5;
                        if (i41 - i54 < i58) {
                            break;
                        }
                        int iB = b(zArr2, i54, i58);
                        i54 += i58;
                        int iG = fw.G(i56);
                        pk0Var = null;
                        if (iG == 0) {
                            str = b[iB];
                        } else if (iG == 1) {
                            str = c[iB];
                        } else if (iG == 2) {
                            str = d[iB];
                        } else if (iG == 3) {
                            str = f[iB];
                        } else {
                            if (iG != 4) {
                                xe.q("Bad table");
                                return null;
                            }
                            str = e[iB];
                        }
                        if (!"FLG(n)".equals(str)) {
                            i3 = 4;
                            if (str.startsWith("CTRL_")) {
                                char cCharAt = str.charAt(5);
                                if (cCharAt != 'B') {
                                    if (cCharAt == 'D') {
                                        i57 = 4;
                                    } else if (cCharAt != 'P') {
                                        if (cCharAt == 'L') {
                                            i57 = 2;
                                        } else if (cCharAt != 'M') {
                                            i4 = 6;
                                            i57 = 1;
                                        } else {
                                            i4 = 6;
                                            i57 = 3;
                                        }
                                    }
                                    i4 = 6;
                                } else {
                                    i4 = 6;
                                    i57 = 6;
                                }
                                if (str.charAt(i4) == 'L') {
                                    i55 = i57;
                                } else {
                                    i55 = i56;
                                    i56 = i57;
                                    i29 = i4;
                                    i48 = i3;
                                    i30 = 8;
                                }
                            } else {
                                i4 = 6;
                                byte[] bytes = str.getBytes(StandardCharsets.US_ASCII);
                                byteArrayOutputStream.write(bytes, 0, bytes.length);
                            }
                        } else if (i41 - i54 >= 3) {
                            int iB2 = b(zArr2, i54, 3);
                            i54 += 3;
                            try {
                                sb.append(byteArrayOutputStream.toString(charsetForName.name()));
                                byteArrayOutputStream.reset();
                                if (iB2 == 0) {
                                    c2 = 2;
                                    c3 = 11;
                                    i3 = 4;
                                    sb.append((char) 29);
                                } else {
                                    if (iB2 == 7) {
                                        throw qi1.a();
                                    }
                                    if (i41 - i54 >= iB2 * 4) {
                                        int i59 = iB2;
                                        int i60 = 0;
                                        while (true) {
                                            int i61 = i59 - 1;
                                            if (i59 > 0) {
                                                int iB3 = b(zArr2, i54, 4);
                                                i54 += 4;
                                                if (iB3 < 2 || iB3 > 11) {
                                                    break loop9;
                                                }
                                                i60 = (i60 * 10) + (iB3 - 2);
                                                i59 = i61;
                                            } else {
                                                c2 = 2;
                                                c3 = 11;
                                                i3 = 4;
                                                x30 x30VarA = x30.a(i60);
                                                if (x30VarA == null) {
                                                    throw qi1.a();
                                                }
                                                charsetForName = Charset.forName(x30VarA.name());
                                            }
                                        }
                                        throw qi1.a();
                                    }
                                    c2 = 2;
                                    c3 = 11;
                                    i3 = 4;
                                }
                                i4 = 6;
                            } catch (UnsupportedEncodingException e2) {
                                zo2.q(e2);
                                return null;
                            }
                        }
                        i56 = i55;
                        i29 = i4;
                        i48 = i3;
                        i30 = 8;
                    } else {
                        if (i41 - i54 < 5) {
                            break;
                        }
                        int iB4 = b(zArr2, i54, 5);
                        int i62 = i54 + 5;
                        if (iB4 == 0) {
                            if (i41 - i62 < 11) {
                                break;
                            }
                            iB4 = b(zArr2, i62, 11) + 31;
                            i62 = i54 + 16;
                        }
                        int i63 = 0;
                        while (true) {
                            if (i63 >= iB4) {
                                i54 = i62;
                                break;
                            }
                            if (i41 - i62 < i30) {
                                i54 = i41;
                                break;
                            }
                            byteArrayOutputStream.write((byte) b(zArr2, i62, i30));
                            i62 += 8;
                            i63++;
                        }
                        i56 = i55;
                    }
                    sb.append(byteArrayOutputStream.toString(charsetForName.name()));
                    pk0 pk0Var2 = new pk0(sb.toString(), String.format("%d%%", Integer.valueOf(i49)), bArr);
                    pk0Var2.e = Integer.valueOf(iW);
                    return pk0Var2;
                }
                sb.append(byteArrayOutputStream.toString(charsetForName.name()));
                pk0 pk0Var22 = new pk0(sb.toString(), String.format("%d%%", Integer.valueOf(i49)), bArr);
                pk0Var22.e = Integer.valueOf(iW);
                return pk0Var22;
            } catch (UnsupportedEncodingException e3) {
                zo2.q(e3);
                return pk0Var;
            }
            pk0Var = null;
        } catch (wg3 e4) {
            qi1 qi1Var = qi1.z;
            if (de3.b) {
                throw new qi1(e4);
            }
            throw qi1.z;
        }
    }
}
