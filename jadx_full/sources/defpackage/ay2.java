package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ay2 {
    public static final zf2 a = new zf2(21);

    /* JADX WARN: Removed duplicated region for block: B:83:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static xo a(pt0 pt0Var) {
        xo xoVar;
        int[] iArr;
        int i;
        int i2;
        xk3 xk3Var;
        xk3 xk3Var2;
        xk3 xk3Var3;
        xk3 xk3Var4;
        if (pt0Var == null) {
            return null;
        }
        boolean z = pt0Var.A;
        xo xoVar2 = (xo) pt0Var.f;
        xk3 xk3Var5 = xoVar2.e;
        xk3 xk3Var6 = xoVar2.c;
        xk3 xk3Var7 = xoVar2.d;
        xk3 xk3Var8 = xoVar2.b;
        tj[] tjVarArr = (tj[]) pt0Var.z;
        tj tjVarY = pt0Var.Y();
        if (tjVarY == null) {
            iArr = null;
            xoVar = null;
        } else {
            int i3 = tjVarY.f;
            xk3 xk3Var9 = z ? xk3Var8 : xk3Var7;
            xk3 xk3Var10 = z ? xk3Var6 : xk3Var5;
            int iL = pt0Var.L((int) xk3Var9.b);
            int iL2 = pt0Var.L((int) xk3Var10.b);
            int iMax = 1;
            int i4 = -1;
            int i5 = 0;
            xoVar = null;
            while (iL < iL2) {
                tj tjVar = tjVarArr[iL];
                if (tjVar == null) {
                    i2 = iL2;
                } else {
                    tjVar.c();
                    int i6 = tjVar.f;
                    int i7 = i6 - i4;
                    if (i7 == 0) {
                        i5++;
                        i2 = iL2;
                    } else {
                        i2 = iL2;
                        if (i7 == 1) {
                            iMax = Math.max(iMax, i5);
                            i4 = tjVar.f;
                        } else if (i6 >= i3) {
                            tjVarArr[iL] = null;
                        } else {
                            i4 = i6;
                        }
                        i5 = 1;
                    }
                }
                iL++;
                iL2 = i2;
            }
            iArr = new int[i3];
            for (tj tjVar2 : tjVarArr) {
                if (tjVar2 != null && (i = tjVar2.f) < i3) {
                    iArr[i] = iArr[i] + 1;
                }
            }
        }
        if (iArr == null) {
            return xoVar;
        }
        int iMax2 = -1;
        for (int i8 : iArr) {
            iMax2 = Math.max(iMax2, i8);
        }
        int i9 = 0;
        for (int i10 : iArr) {
            i9 += iMax2 - i10;
            if (i10 > 0) {
                break;
            }
        }
        for (int i11 = 0; i9 > 0 && tjVarArr[i11] == null; i11++) {
            i9--;
        }
        int i12 = 0;
        for (int length = iArr.length - 1; length >= 0; length--) {
            int i13 = iArr[length];
            i12 += iMax2 - i13;
            if (i13 > 0) {
                break;
            }
        }
        for (int length2 = tjVarArr.length - 1; i12 > 0 && tjVarArr[length2] == null; length2--) {
            i12--;
        }
        if (i9 > 0) {
            xk3 xk3Var11 = z ? xk3Var8 : xk3Var7;
            xk3 xk3Var12 = new xk3(xk3Var11.a, ((int) xk3Var11.b) - i9 < 0 ? 0 : r1);
            if (z) {
                xk3Var2 = xk3Var12;
                xk3Var = xk3Var7;
                if (i12 <= 0) {
                    xk3 xk3Var13 = z ? xk3Var6 : xk3Var5;
                    int i14 = ((int) xk3Var13.b) + i12;
                    int i15 = xoVar2.a.f;
                    if (i14 >= i15) {
                        i14 = i15 - 1;
                    }
                    xk3 xk3Var14 = new xk3(xk3Var13.a, i14);
                    if (z) {
                        xk3Var3 = xk3Var5;
                        xk3Var4 = xk3Var14;
                    } else {
                        xk3Var4 = xk3Var6;
                        xk3Var3 = xk3Var14;
                    }
                } else {
                    xk3Var3 = xk3Var5;
                    xk3Var4 = xk3Var6;
                }
                return new xo(xoVar2.a, xk3Var2, xk3Var4, xk3Var, xk3Var3);
            }
            xk3Var = xk3Var12;
        } else {
            xk3Var = xk3Var7;
        }
        xk3Var2 = xk3Var8;
        if (i12 <= 0) {
        }
        return new xo(xoVar2.a, xk3Var2, xk3Var4, xk3Var, xk3Var3);
    }

    /* JADX WARN: Removed duplicated region for block: B:260:0x048f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static pk0 b(int i, int[] iArr, int[] iArr2) throws d40, qi1 {
        int[] iArr3;
        byte[] bArr;
        int[] iArr4;
        int i2;
        int i3;
        int i4;
        om2 om2Var;
        v62 v62Var;
        v62 v62Var2;
        StringBuilder sb;
        boolean z;
        int i5;
        int i6;
        char c;
        int i7;
        int iA;
        int i8;
        if (iArr.length == 0) {
            throw qi1.a();
        }
        int i9 = 1;
        int i10 = 1 << (i + 1);
        if (iArr2.length > (i10 / 2) + 3 || i10 < 0 || i10 > 512) {
            throw d40.a();
        }
        om2 om2Var2 = (om2) a.f;
        if (iArr.length == 0) {
            s53.d();
            return null;
        }
        int length = iArr.length;
        int i11 = 0;
        if (length <= 1 || iArr[0] != 0) {
            iArr3 = iArr;
        } else {
            int i12 = 1;
            while (i12 < length && iArr[i12] == 0) {
                i12++;
            }
            if (i12 == length) {
                iArr3 = new int[]{0};
            } else {
                int i13 = length - i12;
                int[] iArr5 = new int[i13];
                System.arraycopy(iArr, i12, iArr5, 0, i13);
                iArr3 = iArr5;
            }
        }
        int[] iArr6 = new int[i10];
        boolean z2 = false;
        for (int i14 = i10; i14 > 0; i14--) {
            int i15 = om2Var2.a[i14];
            if (i15 == 0) {
                i8 = iArr3[iArr3.length - 1];
            } else {
                if (i15 == 1) {
                    iA = 0;
                    for (int i16 : iArr3) {
                        iA = om2Var2.a(iA, i16);
                    }
                } else {
                    iA = iArr3[0];
                    int length2 = iArr3.length;
                    for (int i17 = 1; i17 < length2; i17++) {
                        iA = om2Var2.a(om2Var2.c(i15, iA), iArr3[i17]);
                    }
                }
                i8 = iA;
            }
            iArr6[i10 - i14] = i8;
            if (i8 != 0) {
                z2 = true;
            }
        }
        if (z2) {
            v62 v62VarH = om2Var2.d;
            v62 v62Var3 = om2Var2.c;
            for (int i18 : iArr2) {
                v62VarH = v62VarH.H(new v62(om2Var2, new int[]{(929 - om2Var2.a[(iArr.length - 1) - i18]) % 929, 1}));
            }
            v62 v62Var4 = new v62(om2Var2, iArr6);
            if (i10 < 0) {
                s53.d();
                return null;
            }
            int[] iArr7 = new int[i10 + 1];
            iArr7[0] = 1;
            v62 v62Var5 = new v62(om2Var2, iArr7);
            if (v62Var5.A() >= v62Var4.A()) {
                v62Var5 = v62Var4;
                v62Var4 = v62Var5;
            }
            v62 v62Var6 = om2Var2.d;
            v62 v62Var7 = v62Var5;
            v62 v62VarP = v62Var4;
            v62 v62Var8 = v62Var7;
            v62 v62Var9 = v62Var3;
            while (v62Var8.A() >= i10 / 2) {
                if (v62Var8.F()) {
                    throw d40.a();
                }
                int iB = om2Var2.b(v62Var8.y(v62Var8.A()));
                v62 v62VarN = v62Var3;
                while (true) {
                    i4 = i9;
                    if (v62VarP.A() < v62Var8.A() || v62VarP.F()) {
                        break;
                    }
                    int iA2 = v62VarP.A() - v62Var8.A();
                    int iC = om2Var2.c(v62VarP.y(v62VarP.A()), iB);
                    if (iA2 < 0) {
                        s53.d();
                        return null;
                    }
                    if (iC == 0) {
                        v62Var = v62Var3;
                    } else {
                        int[] iArr8 = new int[iA2 + 1];
                        iArr8[i11] = iC;
                        v62Var = new v62(om2Var2, iArr8);
                    }
                    v62VarN = v62VarN.n(v62Var);
                    int[] iArr9 = (int[]) v62Var8.z;
                    om2 om2Var3 = (om2) v62Var8.f;
                    if (iA2 < 0) {
                        s53.d();
                        return null;
                    }
                    if (iC == 0) {
                        v62Var2 = om2Var3.c;
                    } else {
                        int length3 = iArr9.length;
                        int[] iArr10 = new int[iA2 + length3];
                        int i19 = 0;
                        while (i19 < length3) {
                            int i20 = i19;
                            iArr10[i20] = om2Var3.c(iArr9[i20], iC);
                            i19 = i20 + 1;
                        }
                        v62Var2 = new v62(om2Var3, iArr10);
                    }
                    v62VarP = v62VarP.P(v62Var2);
                    i9 = i4;
                    i11 = 0;
                }
                v62 v62VarP2 = v62VarN.H(v62Var6).P(v62Var9);
                int[] iArr11 = (int[]) v62VarP2.z;
                int length4 = iArr11.length;
                int[] iArr12 = new int[length4];
                int i21 = 0;
                while (true) {
                    om2Var = (om2) v62VarP2.f;
                    if (i21 < length4) {
                        int i22 = iArr11[i21];
                        om2Var.getClass();
                        iArr12[i21] = (929 - i22) % 929;
                        i21++;
                    }
                }
                v62 v62Var10 = new v62(om2Var, iArr12);
                v62 v62Var11 = v62VarP;
                v62VarP = v62Var8;
                v62Var8 = v62Var11;
                v62Var9 = v62Var6;
                i11 = 0;
                v62Var6 = v62Var10;
                i9 = i4;
            }
            int i23 = i9;
            int i24 = i11;
            bArr = null;
            int iY = v62Var6.y(i24);
            if (iY == 0) {
                throw d40.a();
            }
            int iB2 = om2Var2.b(iY);
            v62 v62VarG = v62Var6.G(iB2);
            v62 v62VarG2 = v62Var8.G(iB2);
            v62[] v62VarArr = new v62[2];
            v62VarArr[i24] = v62VarG;
            v62VarArr[i23] = v62VarG2;
            v62 v62Var12 = v62VarArr[i24];
            v62 v62Var13 = v62VarArr[i23];
            int iA3 = v62Var12.A();
            int[] iArr13 = new int[iA3];
            int i25 = 0;
            for (int i26 = i23; i26 < 929 && i25 < iA3; i26++) {
                if (v62Var12.v(i26) == 0) {
                    iArr13[i25] = om2Var2.b(i26);
                    i25++;
                }
            }
            if (i25 != iA3) {
                throw d40.a();
            }
            int iA4 = v62Var12.A();
            if (iA4 < i23) {
                iArr4 = new int[0];
            } else {
                int[] iArr14 = new int[iA4];
                for (int i27 = 1; i27 <= iA4; i27++) {
                    iArr14[iA4 - i27] = om2Var2.c(i27, v62Var12.y(i27));
                }
                if (iA4 == 0) {
                    s53.d();
                    return null;
                }
                if (iA4 > 1 && iArr14[0] == 0) {
                    int i28 = 1;
                    while (i28 < iA4 && iArr14[i28] == 0) {
                        i28++;
                    }
                    if (i28 == iA4) {
                        iArr14 = new int[]{0};
                    } else {
                        int i29 = iA4 - i28;
                        int[] iArr15 = new int[i29];
                        System.arraycopy(iArr14, i28, iArr15, 0, i29);
                        iArr14 = iArr15;
                    }
                }
                int[] iArr16 = new int[iA3];
                for (int i30 = 0; i30 < iA3; i30++) {
                    int iB3 = om2Var2.b(iArr13[i30]);
                    int iV = (929 - v62Var13.v(iB3)) % 929;
                    if (iB3 == 0) {
                        i2 = iArr14[iArr14.length - 1];
                    } else if (iB3 == 1) {
                        int iA5 = 0;
                        for (int i31 : iArr14) {
                            iA5 = om2Var2.a(iA5, i31);
                        }
                        i2 = iA5;
                    } else {
                        int iA6 = iArr14[0];
                        int length5 = iArr14.length;
                        for (int i32 = 1; i32 < length5; i32++) {
                            iA6 = om2Var2.a(om2Var2.c(iB3, iA6), iArr14[i32]);
                        }
                        i2 = iA6;
                    }
                    iArr16[i30] = om2Var2.c(iV, om2Var2.b(i2));
                }
                iArr4 = iArr16;
            }
            for (int i33 = 0; i33 < iA3; i33++) {
                int length6 = iArr.length - 1;
                int i34 = iArr13[i33];
                if (i34 == 0) {
                    s53.d();
                    return null;
                }
                int i35 = length6 - om2Var2.b[i34];
                if (i35 < 0) {
                    throw d40.a();
                }
                iArr[i35] = ((iArr[i35] + 929) - iArr4[i33]) % 929;
            }
            i3 = iA3;
        } else {
            i3 = 0;
            bArr = null;
        }
        if (iArr.length < 4) {
            throw qi1.a();
        }
        int i36 = iArr[0];
        if (i36 > iArr.length) {
            throw qi1.a();
        }
        if (i36 == 0) {
            if (i10 >= iArr.length) {
                throw qi1.a();
            }
            iArr[0] = iArr.length - i10;
        }
        String strValueOf = String.valueOf(i);
        char[] cArr = hk0.a;
        ed4 ed4Var = new ed4(iArr.length * 2);
        int iD = hk0.d(iArr, 1, ed4Var);
        zx2 zx2Var = new zx2();
        while (true) {
            char c2 = 0;
            while (true) {
                int i37 = iArr[c2];
                if (iD >= i37) {
                    if (((StringBuilder) ed4Var.f).length() == 0 && (((sb = (StringBuilder) ed4Var.z) == null || sb.length() == 0) && zx2Var.a == null)) {
                        throw qi1.a();
                    }
                    pk0 pk0Var = new pk0(ed4Var.toString(), strValueOf, bArr);
                    pk0Var.g = zx2Var;
                    pk0Var.e = Integer.valueOf(i3);
                    pk0Var.f = Integer.valueOf(iArr2.length);
                    return pk0Var;
                }
                int iC2 = iD + 1;
                int i38 = iArr[iD];
                if (i38 != 913) {
                    switch (i38) {
                        case 900:
                            c2 = 0;
                            iD = hk0.d(iArr, iC2, ed4Var);
                            break;
                        case 901:
                            z = false;
                            c2 = 0;
                            while (iC2 < iArr[c2] && !z) {
                                while (true) {
                                    i5 = iArr[c2];
                                    if (iC2 >= i5 && iArr[iC2] == 927) {
                                        ed4Var.k(iArr[iC2 + 1]);
                                        iC2 += 2;
                                        c2 = 0;
                                    }
                                }
                                if (iC2 < i5 || iArr[iC2] >= 900) {
                                    c2 = 0;
                                    z = true;
                                } else {
                                    long j = 0;
                                    int i39 = 0;
                                    while (true) {
                                        i6 = iC2 + 1;
                                        j = (j * 900) + ((long) iArr[iC2]);
                                        i39++;
                                        if (i39 < 5 && i6 < iArr[0] && iArr[i6] < 900) {
                                            iC2 = i6;
                                        }
                                    }
                                    if (i39 != 5 || (i38 != 924 && (i6 >= iArr[0] || iArr[i6] >= 900))) {
                                        i6 -= i39;
                                        c2 = 0;
                                        while (i6 < iArr[0] && !z) {
                                            int i40 = i6 + 1;
                                            int i41 = iArr[i6];
                                            if (i41 < 900) {
                                                ((StringBuilder) ed4Var.f).append((char) (((byte) i41) & 255));
                                                i6 = i40;
                                            } else if (i41 == 927) {
                                                i6 += 2;
                                                ed4Var.k(iArr[i40]);
                                            } else {
                                                z = true;
                                            }
                                        }
                                    } else {
                                        for (int i42 = 0; i42 < 6; i42++) {
                                            ((StringBuilder) ed4Var.f).append((char) (((byte) (j >> ((5 - i42) * 8))) & 255));
                                        }
                                        c2 = 0;
                                    }
                                    iC2 = i6;
                                }
                            }
                            iD = iC2;
                            break;
                        case 902:
                            iD = hk0.c(iArr, iC2, ed4Var);
                            break;
                        default:
                            switch (i38) {
                                case 922:
                                case 923:
                                    throw qi1.a();
                                case 924:
                                    z = false;
                                    c2 = 0;
                                    while (iC2 < iArr[c2]) {
                                        while (true) {
                                            i5 = iArr[c2];
                                            if (iC2 >= i5) {
                                            }
                                            if (iC2 < i5) {
                                                c2 = 0;
                                                z = true;
                                            }
                                            ed4Var.k(iArr[iC2 + 1]);
                                            iC2 += 2;
                                            c2 = 0;
                                        }
                                    }
                                    iD = iC2;
                                    break;
                                case 925:
                                    iD += 2;
                                    continue;
                                case 926:
                                    iD += 3;
                                    continue;
                                case 927:
                                    iD += 2;
                                    ed4Var.k(iArr[iC2]);
                                    continue;
                                case 928:
                                    if (iD + 3 > i37) {
                                        throw qi1.a();
                                    }
                                    int[] iArr17 = new int[2];
                                    int i43 = 0;
                                    while (i43 < 2) {
                                        iArr17[i43] = iArr[iC2];
                                        i43++;
                                        iC2++;
                                    }
                                    String strA = hk0.a(iArr17, 2);
                                    if (!strA.isEmpty()) {
                                        try {
                                            Integer.parseInt(strA);
                                        } catch (NumberFormatException unused) {
                                            throw qi1.a();
                                        }
                                    }
                                    StringBuilder sb2 = new StringBuilder();
                                    while (iC2 < iArr[0] && iC2 < iArr.length && (i7 = iArr[iC2]) != 922 && i7 != 923) {
                                        sb2.append(String.format("%03d", Integer.valueOf(i7)));
                                        iC2++;
                                    }
                                    if (sb2.length() == 0) {
                                        throw qi1.a();
                                    }
                                    zx2Var.a = sb2.toString();
                                    int i44 = iArr[iC2] == 923 ? iC2 + 1 : -1;
                                    while (true) {
                                        char c3 = 0;
                                        while (iC2 < iArr[c3]) {
                                            int i45 = iArr[iC2];
                                            if (i45 == 922) {
                                                iC2++;
                                                zx2Var.b = true;
                                            } else {
                                                if (i45 != 923) {
                                                    throw qi1.a();
                                                }
                                                switch (iArr[iC2 + 1]) {
                                                    case 0:
                                                        ed4 ed4Var2 = new ed4((byte) 0, 16);
                                                        iC2 = hk0.d(iArr, iC2 + 2, ed4Var2);
                                                        ed4Var2.toString();
                                                        break;
                                                    case 1:
                                                        ed4 ed4Var3 = new ed4((byte) 0, 16);
                                                        iC2 = hk0.c(iArr, iC2 + 2, ed4Var3);
                                                        try {
                                                            Integer.parseInt(ed4Var3.toString());
                                                        } catch (NumberFormatException unused2) {
                                                            throw qi1.a();
                                                        }
                                                        break;
                                                    case 2:
                                                        ed4 ed4Var4 = new ed4((byte) 0, 16);
                                                        iC2 = hk0.c(iArr, iC2 + 2, ed4Var4);
                                                        try {
                                                            Long.parseLong(ed4Var4.toString());
                                                        } catch (NumberFormatException unused3) {
                                                            throw qi1.a();
                                                        }
                                                        break;
                                                    case 3:
                                                        c = 0;
                                                        ed4 ed4Var5 = new ed4((byte) 0, 16);
                                                        iC2 = hk0.d(iArr, iC2 + 2, ed4Var5);
                                                        ed4Var5.toString();
                                                        c3 = c;
                                                        break;
                                                    case 4:
                                                        c = 0;
                                                        ed4 ed4Var6 = new ed4((byte) 0, 16);
                                                        iC2 = hk0.d(iArr, iC2 + 2, ed4Var6);
                                                        ed4Var6.toString();
                                                        c3 = c;
                                                        break;
                                                    case 5:
                                                        ed4 ed4Var7 = new ed4((byte) 0, 16);
                                                        iC2 = hk0.c(iArr, iC2 + 2, ed4Var7);
                                                        try {
                                                            Long.parseLong(ed4Var7.toString());
                                                        } catch (NumberFormatException unused4) {
                                                            throw qi1.a();
                                                        }
                                                        break;
                                                    case 6:
                                                        ed4 ed4Var8 = new ed4((byte) 0, 16);
                                                        iC2 = hk0.c(iArr, iC2 + 2, ed4Var8);
                                                        try {
                                                            Integer.parseInt(ed4Var8.toString());
                                                        } catch (NumberFormatException unused5) {
                                                            throw qi1.a();
                                                        }
                                                        break;
                                                    default:
                                                        throw qi1.a();
                                                }
                                            }
                                        }
                                        if (i44 != -1) {
                                            int i46 = iC2 - i44;
                                            if (zx2Var.b) {
                                                i46--;
                                            }
                                            if (i46 > 0) {
                                                Arrays.copyOfRange(iArr, i44, i46 + i44);
                                            }
                                        }
                                        iD = iC2;
                                        continue;
                                    }
                                    break;
                                default:
                                    iD = hk0.d(iArr, iD, ed4Var);
                                    continue;
                            }
                            break;
                    }
                } else {
                    c2 = 0;
                    iD += 2;
                    ed4Var.j((char) iArr[iC2]);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x0035, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0035, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0035, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static tj c(cn cnVar, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        char c;
        int i7;
        int i8 = i;
        int[] iArr = vo.F0;
        int[] iArr2 = vo.E0;
        int i9 = z ? -1 : 1;
        boolean z2 = z;
        int i10 = i3;
        int i11 = 0;
        loop0: while (true) {
            c = 2;
            if (i11 >= 2) {
                break;
            }
            while (true) {
                if (z2) {
                    if (i10 >= i8) {
                        if (z2 == cnVar.b(i10, i4)) {
                            if (Math.abs(i3 - i10) > 2) {
                                i10 = i3;
                                break loop0;
                            }
                            i10 += i9;
                        }
                    }
                } else if (i10 < i2) {
                }
            }
            i9 = -i9;
            z2 = !z2;
            i11++;
        }
        int[] iArr3 = new int[8];
        int i12 = z ? 1 : -1;
        boolean z3 = z;
        int i13 = i10;
        int i14 = 0;
        while (true) {
            if (!z) {
                if (i13 < i8) {
                    break;
                }
            } else {
                if (i13 >= i2) {
                    break;
                }
                if (i14 >= 8) {
                    break;
                }
                char c2 = c;
                if (cnVar.b(i13, i4) == z3) {
                    iArr3[i14] = iArr3[i14] + 1;
                    i13 += i12;
                } else {
                    i14++;
                    z3 = !z3;
                }
                c = c2;
            }
        }
        char c3 = c;
        if (i14 != 8) {
            if (z) {
                i8 = i2;
            }
            if (i13 != i8 || i14 != 7) {
                iArr3 = null;
            }
        }
        if (iArr3 != null) {
            int iB0 = gb4.b0(iArr3);
            if (z) {
                i7 = i10 + iB0;
            } else {
                for (int i15 = 0; i15 < iArr3.length / 2; i15++) {
                    int i16 = iArr3[i15];
                    iArr3[i15] = iArr3[(iArr3.length - 1) - i15];
                    iArr3[(iArr3.length - 1) - i15] = i16;
                }
                int i17 = i10;
                i10 -= iB0;
                i7 = i17;
            }
            if (i5 - 2 <= iB0 && iB0 <= i6 + 2) {
                float[][] fArr = xx2.a;
                float fB0 = gb4.b0(iArr3);
                int[] iArr4 = new int[8];
                int i18 = 0;
                int i19 = 0;
                for (int i20 = 0; i20 < 17; i20++) {
                    float f = ((i20 * fB0) / 17.0f) + (fB0 / 34.0f);
                    int i21 = iArr3[i19] + i18;
                    if (i21 <= f) {
                        i19++;
                        i18 = i21;
                    }
                    iArr4[i19] = iArr4[i19] + 1;
                }
                long j = 0;
                for (int i22 = 0; i22 < 8; i22++) {
                    for (int i23 = 0; i23 < iArr4[i22]; i23++) {
                        j = (j << 1) | ((long) (i22 % 2 == 0 ? 1 : 0));
                    }
                }
                int i24 = (int) j;
                int iBinarySearch = Arrays.binarySearch(iArr2, i24 & 262143);
                if ((iBinarySearch < 0 ? -1 : (iArr[iBinarySearch] - 1) % 929) == -1) {
                    i24 = -1;
                }
                if (i24 == -1) {
                    int iB02 = gb4.b0(iArr3);
                    float[] fArr2 = new float[8];
                    if (iB02 > 1) {
                        for (int i25 = 0; i25 < 8; i25++) {
                            fArr2[i25] = iArr3[i25] / iB02;
                        }
                    }
                    float f2 = Float.MAX_VALUE;
                    i24 = -1;
                    int i26 = 0;
                    while (true) {
                        float[][] fArr3 = xx2.a;
                        if (i26 >= fArr3.length) {
                            break;
                        }
                        float[] fArr4 = fArr3[i26];
                        float f3 = 0.0f;
                        for (int i27 = 0; i27 < 8; i27++) {
                            float f4 = fArr4[i27] - fArr2[i27];
                            f3 += f4 * f4;
                            if (f3 >= f2) {
                                break;
                            }
                        }
                        if (f3 < f2) {
                            i24 = iArr2[i26];
                            f2 = f3;
                        }
                        i26++;
                    }
                }
                int iBinarySearch2 = Arrays.binarySearch(iArr2, 262143 & i24);
                int i28 = iBinarySearch2 < 0 ? -1 : (iArr[iBinarySearch2] - 1) % 929;
                if (i28 == -1) {
                    return null;
                }
                int[] iArr5 = new int[8];
                int i29 = 0;
                int i30 = 7;
                while (true) {
                    int i31 = i24 & 1;
                    if (i31 != i29) {
                        i30--;
                        if (i30 < 0) {
                            return new tj(i10, i7, ((((iArr5[0] - iArr5[c3]) + iArr5[4]) - iArr5[6]) + 9) % 9, i28, 2);
                        }
                        i29 = i31;
                    }
                    iArr5[i30] = iArr5[i30] + 1;
                    i24 >>= 1;
                    tj tjVar = tjVar;
                    i28 = i28;
                }
            }
        }
        return null;
    }

    public static pt0 d(cn cnVar, xo xoVar, xk3 xk3Var, boolean z, int i, int i2) {
        boolean z2 = z;
        pt0 pt0Var = new pt0(xoVar, z);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = i3 == 0 ? 1 : -1;
            int i5 = (int) xk3Var.a;
            int i6 = (int) xk3Var.b;
            while (i6 <= xoVar.i && i6 >= xoVar.h) {
                tj tjVarC = c(cnVar, 0, cnVar.b, z2, i5, i6, i, i2);
                if (tjVarC != null) {
                    ((tj[]) pt0Var.z)[pt0Var.L(i6)] = tjVarC;
                    i5 = z ? tjVarC.b : tjVarC.c;
                }
                i6 += i4;
                z2 = z;
            }
            i3++;
            z2 = z;
        }
        return pt0Var;
    }
}
