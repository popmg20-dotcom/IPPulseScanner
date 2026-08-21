package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class wq3 extends ek0 {
    public final /* synthetic */ int t;

    /* JADX WARN: Removed duplicated region for block: B:100:0x00ab A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00dc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00de A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0047 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0049 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00a9 A[SYNTHETIC] */
    @Override // defpackage.ek0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int D(mh2 mh2Var, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6) {
        int iV = i4;
        switch (this.t) {
            case 0:
                th3 th3Var = mh2Var.A;
                k0 k0Var = th3Var.p;
                byte[] bArr2 = th3Var.C;
                if (iV >= i3) {
                    iV = i3 - 1;
                }
                while (iV >= i) {
                    if (bArr2[bArr[iV] & 255] != 0) {
                        return iV;
                    }
                    iV = k0Var.v(i2, iV, i3, bArr);
                }
                return -1;
            case 1:
                byte[] bArr3 = mh2Var.A.C;
                for (int i7 = iV >= i3 ? i3 - 1 : iV; i7 >= i; i7--) {
                    if (bArr3[bArr[i7] & 255] != 0) {
                        return i7;
                    }
                }
                return -1;
            case 2:
                th3 th3Var2 = mh2Var.A;
                k0 k0Var2 = th3Var2.p;
                byte[] bArr4 = th3Var2.A;
                int i8 = th3Var2.B;
                int i9 = i3 - i8;
                if (i9 <= iV) {
                    iV = k0Var2.q(i2, i9, i3, bArr);
                }
                while (iV >= i) {
                    if (bArr[iV] == bArr4[0]) {
                        int i10 = iV + 1;
                        int i11 = 1;
                        while (i11 < i8) {
                            int i12 = i10 + 1;
                            if (bArr4[i11] == bArr[i10]) {
                                i11++;
                                i10 = i12;
                            } else if (i11 != i8) {
                                return iV;
                            }
                        }
                        if (i11 != i8) {
                        }
                    }
                    iV = k0Var2.v(i2, iV, i3, bArr);
                }
                return -1;
            case 3:
                th3 th3Var3 = mh2Var.A;
                byte[] bArr5 = th3Var3.A;
                int i13 = th3Var3.B;
                int i14 = i3 - i13;
                if (i14 <= iV) {
                    iV = i14;
                }
                while (iV >= i) {
                    if (bArr[iV] == bArr5[0]) {
                        int i15 = iV + 1;
                        int i16 = 1;
                        while (i16 < i13) {
                            int i17 = i15 + 1;
                            if (bArr5[i16] == bArr[i15]) {
                                i16++;
                                i15 = i17;
                            } else if (i16 != i13) {
                                return iV;
                            }
                        }
                        if (i16 != i13) {
                        }
                    }
                    iV--;
                }
                return -1;
            case 4:
                th3 th3Var4 = mh2Var.A;
                k0 k0Var3 = th3Var4.p;
                byte[] bArr6 = th3Var4.A;
                int i18 = th3Var4.B;
                int i19 = i3 - i18;
                if (i19 <= iV) {
                    iV = k0Var3.q(i2, i19, i3, bArr);
                }
                byte[] bArr7 = mh2Var.G0;
                if (bArr7 == null) {
                    bArr7 = new byte[18];
                    mh2Var.G0 = bArr7;
                }
                while (iV >= i) {
                    byte[] bArr8 = bArr6;
                    int i20 = iV;
                    int i21 = i18;
                    byte[] bArr9 = bArr7;
                    if (xq3.a(bArr8, i21, bArr, i20, i3, k0Var3, bArr9, th3Var4.r)) {
                        return i20;
                    }
                    bArr7 = bArr9;
                    i18 = i21;
                    iV = k0Var3.v(i2, i20, i3, bArr);
                    bArr6 = bArr8;
                }
                return -1;
            default:
                th3 th3Var5 = mh2Var.A;
                byte[] bArrB = th3Var5.p.B();
                byte[] bArr10 = th3Var5.A;
                int i22 = th3Var5.B;
                int i23 = i3 - i22;
                if (i23 <= iV) {
                    iV = i23;
                }
                while (iV >= i) {
                    if (bArr10[0] == bArrB[bArr[iV] & 255]) {
                        int i24 = iV + 1;
                        int i25 = 1;
                        while (i25 < i22) {
                            int i26 = i24 + 1;
                            if (bArr10[i25] == bArrB[bArr[i24] & 255]) {
                                i25++;
                                i24 = i26;
                            } else if (i25 != i22) {
                                return iV;
                            }
                        }
                        if (i25 != i22) {
                        }
                    }
                    iV--;
                }
                return -1;
        }
    }
}
