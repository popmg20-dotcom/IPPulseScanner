package defpackage;

import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class pe1 {
    public static final uj0 a = new uj0(2);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0171 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0177  */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v26 */
    /* JADX WARN: Type inference failed for: r17v27 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final vm1 a(String str, String str2, int i, String str3, String str4, wm1 wm1Var) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z;
        boolean z2;
        int i9;
        boolean z3;
        int i10;
        int i11;
        boolean z4;
        char cCharAt;
        char c;
        int i12;
        String str5 = str;
        int i13 = i;
        str2.getClass();
        str4.getClass();
        int length = str5.length() > 32 ? 32 : str5.length();
        int length2 = str3.length() <= 31 ? str3.length() : 31;
        if (i13 >= length || length2 <= 0 || length - i13 > length2) {
            return null;
        }
        jq3 jq3Var = (jq3) a.get();
        if (jq3Var == null) {
            xe.q("Not Found Scratch");
            return null;
        }
        int[] iArr = jq3Var.b;
        int[] iArr2 = jq3Var.a;
        int[][] iArr3 = jq3Var.e;
        int[][] iArr4 = jq3Var.d;
        int[][] iArr5 = jq3Var.c;
        boolean z5 = false;
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        Arrays.fill(iArr, 0, iArr.length, 0);
        for (int i14 = 0; i14 < 32; i14++) {
            qe.j0(iArr5[i14]);
            qe.j0(iArr4[i14]);
            qe.j0(iArr3[i14]);
        }
        int i15 = i13;
        int i16 = 0;
        while (i15 < length && i16 < length2) {
            boolean z6 = z5;
            if (str2.charAt(i15) == str4.charAt(i16)) {
                iArr2[i15] = i16;
                i15++;
            }
            i16++;
            z5 = z6;
        }
        boolean z7 = z5;
        if (i15 != length) {
            return null;
        }
        int i17 = length - 1;
        for (int i18 = length2 - 1; i17 >= i13 && i18 >= 0; i18--) {
            if (str2.charAt(i17) == str4.charAt(i18)) {
                iArr[i17] = i18;
                i17--;
            }
        }
        boolean[] zArr = new boolean[1];
        zArr[z7 ? 1 : 0] = z7;
        int i19 = i13;
        int i20 = 1;
        int i21 = 1;
        while (true) {
            int i22 = 3;
            if (i19 >= length) {
                int[][] iArr6 = iArr5;
                int i23 = 2;
                if (!zArr[z7 ? 1 : 0] && !wm1Var.a) {
                    return null;
                }
                int i24 = i20 - 1;
                int i25 = i21 - 1;
                vm1 vm1Var = new vm1(iArr4[i24][i25]);
                int i26 = z7 ? 1 : 0;
                int i27 = i25;
                int i28 = 1;
                ?? r17 = z7;
                while (i24 >= i28) {
                    int i29 = i27;
                    while (true) {
                        int i30 = iArr3[i24][i29];
                        i2 = i22;
                        if (i30 != i2) {
                            if (i30 != i23) {
                                i3 = 1;
                                break;
                            }
                            i29--;
                        } else {
                            i29 -= 2;
                        }
                        i3 = 1;
                        if (i29 < 1) {
                            break;
                        }
                        i22 = i2;
                        i23 = 2;
                    }
                    if (i26 > i3 && str2.charAt((i + i24) - i3) == str4.charAt(i27 - 1) && !d(str3, i29 - 1, str4) && i26 + 1 > iArr6[i24][i29]) {
                        i29 = i27;
                    }
                    i26 = i29 == i27 ? i26 + 1 : i3;
                    if (r17 == 0) {
                        r17 = i29;
                    }
                    i24--;
                    i27 = i29 - 1;
                    vm1Var.b.add(Integer.valueOf(i27));
                    i28 = i3;
                    i22 = i2;
                    i23 = 2;
                    r17 = r17;
                }
                if (length2 == length) {
                    vm1Var.a += 2;
                }
                vm1Var.a -= (r17 == true ? 1 : 0) - length;
                return vm1Var;
            }
            int i31 = iArr2[i19];
            boolean[] zArr2 = zArr;
            int i32 = iArr[i19];
            int[][] iArr7 = iArr5;
            int i33 = i19 + 1;
            if (i33 < length) {
                i4 = i33;
                i5 = iArr[i33];
            } else {
                i4 = i33;
                i5 = length2;
            }
            int i34 = i31 + 1;
            int[] iArr8 = iArr;
            int i35 = i31;
            while (i35 < i5) {
                int i36 = i5;
                if (i35 <= i32) {
                    boolean z8 = iArr7[i20 + (-1)][i34 + (-1)] == 0 ? true : z7 ? 1 : 0;
                    i6 = i32;
                    if (str2.charAt(i19) != str4.charAt(i35)) {
                        i7 = Integer.MIN_VALUE;
                    } else {
                        if (i35 == i19 - i13) {
                            int i37 = str5.charAt(i19) != str3.charAt(i35) ? 5 : 7;
                            i11 = z7 ? 1 : 0;
                            i7 = i37;
                        } else {
                            if (d(str3, i35, str4) && (i35 == 0 || !d(str3, i35 - 1, str4))) {
                                i7 = str5.charAt(i19) != str3.charAt(i35) ? 5 : 7;
                            } else if (!c(i35, str4) || (i35 != 0 && c(i35 - 1, str4))) {
                                int i38 = i35 - 1;
                                if (c(i38, str4) || (i38 >= 0 && i38 < str4.length() && ((cCharAt = str4.charAt(i38)) == '\t' || cCharAt == ' '))) {
                                    i7 = 5;
                                } else {
                                    i11 = z7 ? 1 : 0;
                                    z4 = 1;
                                    i7 = 1;
                                    if (i7 > z4 && i19 == i13) {
                                        zArr2[z7 ? 1 : 0] = z4;
                                    }
                                    if (i11 == 0) {
                                        if (!d(str3, i35, str4)) {
                                            int i39 = i35 - 1;
                                            if (c(i39, str4)) {
                                                c = ' ';
                                                i12 = 1;
                                                i11 = i12;
                                            } else {
                                                if (i39 < 0 || i39 >= str4.length()) {
                                                    c = ' ';
                                                } else {
                                                    char cCharAt2 = str4.charAt(i39);
                                                    if (cCharAt2 != '\t') {
                                                        c = ' ';
                                                        if (cCharAt2 != ' ') {
                                                        }
                                                        i11 = i12;
                                                    }
                                                    i12 = 1;
                                                    i11 = i12;
                                                }
                                                i12 = z7 ? 1 : 0;
                                                i11 = i12;
                                            }
                                        }
                                    }
                                    if (i19 != i13) {
                                        i7 += z8 ? i11 != 0 ? 2 : z7 ? 1 : 0 : i11 ^ 1;
                                    } else if (i35 > 0) {
                                        i7 -= i11 != 0 ? 3 : 5;
                                    }
                                    if (i35 + 1 == length2) {
                                        i7 -= i11 != 0 ? 3 : 5;
                                    }
                                }
                            } else {
                                i11 = z7 ? 1 : 0;
                                i7 = 5;
                            }
                            z4 = 1;
                            i11 = 1;
                            if (i7 > z4) {
                                zArr2[z7 ? 1 : 0] = z4;
                            }
                            if (i11 == 0) {
                            }
                            if (i19 != i13) {
                            }
                            if (i35 + 1 == length2) {
                            }
                        }
                        z4 = 1;
                        if (i7 > z4) {
                        }
                        if (i11 == 0) {
                        }
                        if (i19 != i13) {
                        }
                        if (i35 + 1 == length2) {
                        }
                    }
                } else {
                    i6 = i32;
                    i7 = Integer.MIN_VALUE;
                }
                if (i7 != Integer.MIN_VALUE) {
                    i8 = i7 + iArr4[i20 - 1][i34 - 1];
                    z = true;
                } else {
                    boolean z9 = z7 ? 1 : 0;
                    i8 = z9 ? 1 : 0;
                    z = z9;
                }
                boolean z10 = i35 > i31 ? true : z7 ? 1 : 0;
                if (z10) {
                    int i40 = i34 - 1;
                    z2 = z;
                    i9 = iArr4[i20][i40] + (iArr7[i20][i40] > 0 ? -5 : z7 ? 1 : 0);
                } else {
                    z2 = z;
                    i9 = z7 ? 1 : 0;
                }
                boolean z11 = (i35 <= i31 + 1 || iArr7[i20][i34 + (-1)] <= 0) ? z7 ? 1 : 0 : true;
                if (z11) {
                    int i41 = i34 - 2;
                    z3 = z11;
                    i10 = iArr4[i20][i41] + (iArr7[i20][i41] <= 0 ? z7 ? 1 : 0 : -5);
                } else {
                    z3 = z11;
                    i10 = z7 ? 1 : 0;
                }
                if (z3 && ((!z10 || i10 >= i9) && (!z2 || i10 >= i8))) {
                    iArr4[i20][i34] = i10;
                    iArr3[i20][i34] = 3;
                    iArr7[i20][i34] = z7 ? 1 : 0;
                } else if (z10 && (!z2 || i9 >= i8)) {
                    iArr4[i20][i34] = i9;
                    iArr3[i20][i34] = 2;
                    iArr7[i20][i34] = z7 ? 1 : 0;
                } else {
                    if (!z2) {
                        xe.q("not possible");
                        return null;
                    }
                    iArr4[i20][i34] = i8;
                    iArr3[i20][i34] = 1;
                    iArr7[i20][i34] = iArr7[i20 - 1][i34 - 1] + 1;
                }
                i34++;
                i35++;
                str5 = str;
                i13 = i;
                i5 = i36;
                i32 = i6;
            }
            i20++;
            str5 = str;
            i13 = i;
            i19 = i4;
            zArr = zArr2;
            iArr5 = iArr7;
            i21 = i34;
            iArr = iArr8;
        }
    }

    public static final vm1 b(int i, String str, String str2, String str3, String str4) {
        char cCharAt;
        char cCharAt2;
        str2.getClass();
        str4.getClass();
        wm1 wm1Var = wm1.b;
        vm1 vm1VarA = a(str, str2, i, str3, str4, wm1Var);
        if (str.length() >= 3) {
            int length = str.length() - 1;
            if (7 <= length) {
                length = 7;
            }
            int i2 = i + 1;
            while (i2 < length) {
                int i3 = i2 + 1;
                String str5 = null;
                if (i3 < str.length() && (cCharAt = str.charAt(i2)) != (cCharAt2 = str.charAt(i3))) {
                    str5 = p44.T0(i2, str) + cCharAt2 + cCharAt + str.substring(i2 + 2);
                }
                String str6 = str5;
                if (str6 != null) {
                    String lowerCase = str6.toLowerCase(Locale.ROOT);
                    lowerCase.getClass();
                    vm1 vm1VarA2 = a(str6, lowerCase, i, str3, str4, wm1Var);
                    if (vm1VarA2 != null) {
                        int i4 = vm1VarA2.a - 3;
                        vm1VarA2.a = i4;
                        if (vm1VarA == null || i4 > vm1VarA.a) {
                            vm1VarA = vm1VarA2;
                        }
                    }
                }
                i2 = i3;
            }
        }
        return vm1VarA;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x004d A[FALL_THROUGH, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean c(int i, String str) {
        str.getClass();
        if (i < 0 || i >= str.length()) {
            return false;
        }
        int iCodePointAt = str.codePointAt(i);
        if (iCodePointAt != 32 && iCodePointAt != 34 && iCodePointAt != 36 && iCodePointAt != 58 && iCodePointAt != 60 && iCodePointAt != 62 && iCodePointAt != 95 && iCodePointAt != 123 && iCodePointAt != 125) {
            switch (iCodePointAt) {
                default:
                    switch (iCodePointAt) {
                        default:
                            switch (iCodePointAt) {
                                case 91:
                                case 92:
                                case 93:
                                    break;
                                default:
                                    int[] iArr = ao2.a;
                                    return iCodePointAt >= 126976 && iCodePointAt <= 129791;
                            }
                        case 45:
                        case 46:
                        case 47:
                            return true;
                    }
                case 39:
                case 40:
                case 41:
                    break;
            }
        }
        return true;
    }

    public static final boolean d(String str, int i, String str2) {
        str2.getClass();
        return str.charAt(i) != str2.charAt(i);
    }
}
