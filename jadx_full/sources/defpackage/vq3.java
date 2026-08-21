package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class vq3 extends n12 {
    public final /* synthetic */ int d;

    @Override // defpackage.n12
    public final String D() {
        switch (this.d) {
            case 0:
                return "EXACT_BM_NOT_REV_FORWARD";
            case 1:
                return "EXACT_BM_NOT_REV_IC_FORWARD";
            case 2:
                return "MAP_FORWARD";
            case 3:
                return "MAP_SB_FORWARD";
            case 4:
                return "EXACT_FORWARD";
            case 5:
                return "EXACT_SB_FORWARD";
            case 6:
                return "EXACT_IC_FORWARD";
            case 7:
                return "EXACT_IC_SB_FORWARD";
            default:
                return "EXACT_BM_FORWARD";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:246:0x00c0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x00c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0129 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:257:0x012b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x015f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0161 A[SYNTHETIC] */
    @Override // defpackage.n12
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int Q(int i, int i2, int i3, mh2 mh2Var, byte[] bArr) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = i2;
        int i10 = i3;
        switch (this.d) {
            case 0:
                th3 th3Var = mh2Var.A;
                k0 k0Var = th3Var.p;
                byte[] bArr2 = th3Var.A;
                int i11 = th3Var.B - 1;
                int i12 = i3 + i11 > i9 ? i9 - i11 : i3;
                if (ja0.t || th3Var.D == null) {
                    i4 = i;
                    while (i4 < i12) {
                        int i13 = i4 + i11;
                        int i14 = i13;
                        for (int i15 = i11; bArr[i14] == bArr2[i15]; i15--) {
                            if (i15 != 0) {
                                i14--;
                            }
                        }
                        boolean z = ja0.r;
                        if (z && i4 + 1 >= i12) {
                            return -1;
                        }
                        byte[] bArr3 = th3Var.C;
                        if (z) {
                            i13++;
                        }
                        byte b = bArr3[bArr[i13] & 255];
                        int iR = i4;
                        do {
                            iR += k0Var.r(iR, i9, bArr);
                            if (iR - i4 < b) {
                            }
                            i4 = iR;
                        } while (iR < i12);
                        i4 = iR;
                    }
                    return -1;
                }
                i4 = i;
                while (i4 < i12) {
                    int i16 = i4 + i11;
                    int i17 = i16;
                    for (int i18 = i11; bArr[i17] == bArr2[i18]; i18--) {
                        if (i18 != 0) {
                            i17--;
                        }
                    }
                    boolean z2 = ja0.r;
                    if (z2 && i4 + 1 >= i12) {
                        return -1;
                    }
                    int[] iArr = th3Var.D;
                    if (z2) {
                        i16++;
                    }
                    int i19 = iArr[bArr[i16] & 255];
                    int iR2 = i4;
                    do {
                        iR2 += k0Var.r(iR2, i9, bArr);
                        if (iR2 - i4 < i19) {
                        }
                        i4 = iR2;
                    } while (iR2 < i12);
                    i4 = iR2;
                }
                return -1;
                return i4;
            case 1:
                th3 th3Var2 = mh2Var.A;
                k0 k0Var2 = th3Var2.p;
                byte[] bArr4 = mh2Var.G0;
                if (bArr4 == null) {
                    bArr4 = new byte[18];
                    mh2Var.G0 = bArr4;
                }
                byte[] bArr5 = bArr4;
                byte[] bArr6 = th3Var2.A;
                int i20 = th3Var2.B;
                int i21 = i20 - 1;
                int i22 = i3 + i21 > i9 ? i9 - i21 : i3;
                if (ja0.t || th3Var2.D == null) {
                    i5 = i;
                    while (i5 < i22) {
                        int i23 = i5 + i21;
                        int i24 = i23 + 1;
                        if (!xq3.a(bArr6, i20, bArr, i5, i24, k0Var2, bArr5, th3Var2.r)) {
                            boolean z3 = ja0.r;
                            if (z3 && i5 + 1 >= i22) {
                                return -1;
                            }
                            byte[] bArr7 = th3Var2.C;
                            if (z3) {
                                i23 = i24;
                            }
                            byte b2 = bArr7[bArr[i23] & 255];
                            int iR3 = i5;
                            do {
                                iR3 += k0Var2.r(iR3, i9, bArr);
                                if (iR3 - i5 < b2) {
                                }
                                i5 = iR3;
                            } while (iR3 < i22);
                            i5 = iR3;
                        }
                    }
                    return -1;
                }
                i5 = i;
                while (i5 < i22) {
                    int i25 = i5 + i21;
                    int i26 = i25 + 1;
                    if (!xq3.a(bArr6, i20, bArr, i5, i26, k0Var2, bArr5, th3Var2.r)) {
                        boolean z4 = ja0.r;
                        if (z4 && i5 + 1 >= i22) {
                            return -1;
                        }
                        int[] iArr2 = th3Var2.D;
                        if (z4) {
                            i25 = i26;
                        }
                        int i27 = iArr2[bArr[i25] & 255];
                        int iR4 = i5;
                        do {
                            iR4 += k0Var2.r(iR4, i9, bArr);
                            if (iR4 - i5 < i27) {
                            }
                            i5 = iR4;
                        } while (iR4 < i22);
                        i5 = iR4;
                    }
                }
                return -1;
                return i5;
            case 2:
                th3 th3Var3 = mh2Var.A;
                k0 k0Var3 = th3Var3.p;
                byte[] bArr8 = th3Var3.C;
                int iR5 = i;
                while (iR5 < i10) {
                    if (bArr8[bArr[iR5] & 255] != 0) {
                        return iR5;
                    }
                    iR5 += k0Var3.r(iR5, i9, bArr);
                }
                return -1;
            case 3:
                byte[] bArr9 = mh2Var.A.C;
                for (int i28 = i; i28 < i10; i28++) {
                    if (bArr9[bArr[i28] & 255] != 0) {
                        return i28;
                    }
                }
                return -1;
            case 4:
                th3 th3Var4 = mh2Var.A;
                k0 k0Var4 = th3Var4.p;
                byte[] bArr10 = th3Var4.A;
                int i29 = th3Var4.B;
                int i30 = i9 - (i29 - 1);
                if (i30 <= i10) {
                    i10 = i30;
                }
                int iR6 = i;
                while (iR6 < i10) {
                    if (bArr[iR6] == bArr10[0]) {
                        int i31 = iR6 + 1;
                        int i32 = 1;
                        while (i32 < i29) {
                            int i33 = i31 + 1;
                            if (bArr10[i32] == bArr[i31]) {
                                i32++;
                                i31 = i33;
                            } else if (i32 != i29) {
                                return iR6;
                            }
                        }
                        if (i32 != i29) {
                        }
                    }
                    iR6 += k0Var4.r(iR6, i9, bArr);
                }
                return -1;
            case 5:
                th3 th3Var5 = mh2Var.A;
                byte[] bArr11 = th3Var5.A;
                int i34 = th3Var5.B;
                int i35 = i9 - (i34 - 1);
                if (i35 <= i10) {
                    i10 = i35;
                }
                for (int i36 = i; i36 < i10; i36++) {
                    if (bArr[i36] == bArr11[0]) {
                        int i37 = i36 + 1;
                        int i38 = 1;
                        while (i38 < i34) {
                            int i39 = i37 + 1;
                            if (bArr11[i38] == bArr[i37]) {
                                i38++;
                                i37 = i39;
                            } else if (i38 != i34) {
                                return i36;
                            }
                        }
                        if (i38 != i34) {
                        }
                    }
                }
                return -1;
            case 6:
                th3 th3Var6 = mh2Var.A;
                k0 k0Var5 = th3Var6.p;
                byte[] bArr12 = th3Var6.A;
                int i40 = th3Var6.B;
                int i41 = i9 - (i40 - 1);
                int i42 = i41 > i10 ? i10 : i41;
                byte[] bArr13 = mh2Var.G0;
                if (bArr13 == null) {
                    bArr13 = new byte[18];
                    mh2Var.G0 = bArr13;
                }
                byte[] bArr14 = bArr13;
                int iR7 = i;
                while (iR7 < i42) {
                    int i43 = i9;
                    if (xq3.a(bArr12, i40, bArr, iR7, i9, k0Var5, bArr14, th3Var6.r)) {
                        return iR7;
                    }
                    iR7 += k0Var5.r(iR7, i43, bArr);
                    i9 = i43;
                }
                return -1;
            case 7:
                th3 th3Var7 = mh2Var.A;
                byte[] bArrB = th3Var7.p.B();
                byte[] bArr15 = th3Var7.A;
                int i44 = th3Var7.B;
                int i45 = i9 - (i44 - 1);
                if (i45 <= i10) {
                    i10 = i45;
                }
                for (int i46 = i; i46 < i10; i46++) {
                    if (bArr15[0] == bArrB[bArr[i46] & 255]) {
                        int i47 = i46 + 1;
                        int i48 = 1;
                        while (i48 < i44) {
                            int i49 = i47 + 1;
                            if (bArr15[i48] == bArrB[bArr[i47] & 255]) {
                                i48++;
                                i47 = i49;
                            } else if (i48 != i44) {
                                return i46;
                            }
                        }
                        if (i48 != i44) {
                        }
                    }
                }
                return -1;
            default:
                th3 th3Var8 = mh2Var.A;
                byte[] bArr16 = th3Var8.A;
                int i50 = th3Var8.B;
                int i51 = i50 - 1;
                if (ja0.r) {
                    i6 = i10 + i51;
                    i7 = i + i51;
                } else {
                    i6 = (i10 + i50) - 1;
                    i7 = (i50 + i) - 1;
                }
                if (i6 > i9) {
                    i6 = i9;
                }
                if (ja0.t || th3Var8.D == null) {
                    while (i7 < i6) {
                        i8 = i7;
                        for (int i52 = i51; bArr[i8] == bArr16[i52]; i52--) {
                            if (i52 != 0) {
                                i8--;
                            }
                        }
                        boolean z5 = ja0.r;
                        if (z5 && i7 + 1 >= i6) {
                            return -1;
                        }
                        i7 += th3Var8.C[bArr[z5 ? i7 + 1 : i7] & 255];
                    }
                    return -1;
                }
                while (i7 < i6) {
                    i8 = i7;
                    for (int i53 = i51; bArr[i8] == bArr16[i53]; i53--) {
                        if (i53 != 0) {
                            i8--;
                        }
                    }
                    boolean z6 = ja0.r;
                    if (z6 && i7 + 1 >= i6) {
                        return -1;
                    }
                    i7 += th3Var8.D[bArr[z6 ? i7 + 1 : i7] & 255];
                }
                return -1;
                return i8;
        }
    }
}
