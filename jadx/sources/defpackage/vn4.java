package defpackage;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String h(int r10, int r11, byte[] r12) throws defpackage.s12 {
        /*
            Method dump skipped, instruction units count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vn4.h(int, int, byte[]):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0164  */
    @Override // defpackage.ye
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int l(java.lang.String r24, byte[] r25, int r26, int r27) {
        /*
            Method dump skipped, instruction units count: 570
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vn4.l(java.lang.String, byte[], int, int):int");
    }
}
