package defpackage;

import io.netty.channel.unix.Socket;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f60 extends ov2 {
    public static final int[][] a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0137 A[FALL_THROUGH, PHI: r20 r25
      0x0137: PHI (r20v9 int) = (r20v1 int), (r20v6 int), (r20v6 int), (r20v6 int), (r20v1 int), (r20v12 int), (r20v12 int), (r20v12 int) binds: [B:102:0x01a3, B:110:0x01b9, B:114:0x01c5, B:113:0x01c1, B:69:0x0134, B:77:0x014c, B:81:0x0158, B:80:0x0154] A[DONT_GENERATE, DONT_INLINE]
      0x0137: PHI (r25v13 int) = (r25v5 int), (r25v5 int), (r25v5 int), (r25v5 int), (r25v15 int), (r25v15 int), (r25v15 int), (r25v15 int) binds: [B:102:0x01a3, B:110:0x01b9, B:114:0x01c5, B:113:0x01c1, B:69:0x0134, B:77:0x014c, B:81:0x0158, B:80:0x0154] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x016b A[PHI: r25
      0x016b: PHI (r25v11 int) = (r25v5 int), (r25v15 int) binds: [B:121:0x01d8, B:86:0x0169] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0170 A[PHI: r25
      0x0170: PHI (r25v10 int) = (r25v5 int), (r25v5 int), (r25v15 int), (r25v15 int) binds: [B:120:0x01d6, B:121:0x01d8, B:85:0x0167, B:86:0x0169] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0179 A[PHI: r25
      0x0179: PHI (r25v9 int) = (r25v5 int), (r25v15 int) binds: [B:102:0x01a3, B:69:0x0134] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0180 A[PHI: r25
      0x0180: PHI (r25v8 int) = (r25v5 int), (r25v15 int) binds: [B:102:0x01a3, B:69:0x0134] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0185 A[PHI: r25
      0x0185: PHI (r25v7 int) = (r25v5 int), (r25v15 int) binds: [B:101:0x01a1, B:68:0x0132] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.ov2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final vk3 b(int i, bn bnVar, Map map) throws qs2, d40, qi1 {
        int i2;
        int i3;
        float f;
        int[][] iArr;
        char c;
        char c2;
        int i4;
        int i5 = 1;
        int i6 = 0;
        boolean z = map != null && map.containsKey(fk0.z);
        int i7 = bnVar.f;
        int iE = bnVar.e(0);
        int i8 = 6;
        int[] iArr2 = new int[6];
        boolean z2 = false;
        int i9 = 0;
        int i10 = iE;
        while (iE < i7) {
            if (bnVar.d(iE) != z2) {
                iArr2[i9] = iArr2[i9] + i5;
                i3 = i5;
                i2 = i6;
            } else {
                if (i9 == 5) {
                    int i11 = 103;
                    int i12 = -1;
                    float f2 = 0.25f;
                    while (true) {
                        f = 0.7f;
                        iArr = a;
                        if (i11 > 105) {
                            break;
                        }
                        float fC = ov2.c(iArr2, iArr[i11], 0.7f);
                        if (fC < f2) {
                            f2 = fC;
                            i12 = i11;
                        }
                        i11++;
                    }
                    if (i12 >= 0 && bnVar.h(Math.max(i6, i10 - ((iE - i10) / 2)), i10)) {
                        int[] iArr3 = {i10, iE, i12};
                        int i13 = iArr3[2];
                        ArrayList arrayList = new ArrayList(20);
                        arrayList.add(Byte.valueOf((byte) i13));
                        switch (i13) {
                            case 103:
                                c = 'e';
                                break;
                            case 104:
                                c = 'd';
                                break;
                            case 105:
                                c = 'c';
                                break;
                            default:
                                throw qi1.a();
                        }
                        StringBuilder sb = new StringBuilder(20);
                        int i14 = iArr3[i6];
                        int i15 = i6;
                        int[] iArr4 = new int[i8];
                        char c3 = c;
                        int i16 = i14;
                        int i17 = iArr3[i5];
                        char c4 = c3;
                        int i18 = i5;
                        int i19 = i15;
                        int i20 = i19;
                        int i21 = i20;
                        int i22 = i21;
                        int i23 = i22;
                        int i24 = i23;
                        int i25 = i24;
                        int i26 = i25;
                        while (i23 == 0) {
                            ov2.d(i17, bnVar, iArr4);
                            int i27 = -1;
                            float f3 = 0.25f;
                            for (int i28 = i15; i28 < 107; i28++) {
                                float fC2 = ov2.c(iArr4, iArr[i28], f);
                                if (fC2 < f3) {
                                    f3 = fC2;
                                    i27 = i28;
                                }
                            }
                            if (i27 < 0) {
                                throw qs2.a();
                            }
                            arrayList.add(Byte.valueOf((byte) i27));
                            if (i27 != 106) {
                                i18 = 1;
                            }
                            if (i27 != 106) {
                                i26++;
                                i13 = (i26 * i27) + i13;
                            }
                            int i29 = i17;
                            for (int i30 = i15; i30 < i8; i30++) {
                                i29 += iArr4[i30];
                            }
                            switch (i27) {
                                case 103:
                                case 104:
                                case 105:
                                    throw qi1.a();
                                default:
                                    switch (c4) {
                                        case 'c':
                                            c2 = 'd';
                                            if (i27 >= 100) {
                                                if (i27 != 106) {
                                                    i18 = i15;
                                                }
                                                if (i27 == 106) {
                                                    i4 = i15;
                                                    i23 = 1;
                                                    break;
                                                } else {
                                                    switch (i27) {
                                                        case Socket.UDS_SUN_PATH_SIZE /* 100 */:
                                                            c4 = 'd';
                                                            break;
                                                        case 101:
                                                            i4 = i15;
                                                            c4 = 'e';
                                                            break;
                                                        case 102:
                                                            if (sb.length() == 0) {
                                                                i22 = 1;
                                                            } else if (sb.length() == 1) {
                                                                i22 = 2;
                                                            }
                                                            if (z) {
                                                                if (sb.length() == 0) {
                                                                    sb.append("]C1");
                                                                } else {
                                                                    sb.append((char) 29);
                                                                }
                                                            }
                                                            break;
                                                    }
                                                }
                                            } else {
                                                if (i27 < 10) {
                                                    sb.append('0');
                                                }
                                                sb.append(i27);
                                            }
                                            i4 = i15;
                                            break;
                                        case Socket.UDS_SUN_PATH_SIZE /* 100 */:
                                            if (i27 < 96) {
                                                if (i20 == i21) {
                                                    sb.append((char) (i27 + 32));
                                                } else {
                                                    sb.append((char) (i27 + 160));
                                                }
                                                i4 = i15;
                                                i20 = i4;
                                                c2 = 'd';
                                            } else {
                                                if (i27 != 106) {
                                                    i18 = i15;
                                                }
                                                if (i27 != 106) {
                                                    switch (i27) {
                                                        case 97:
                                                            i4 = i15;
                                                            i22 = 4;
                                                            break;
                                                        case 98:
                                                            i4 = 1;
                                                            c4 = 'e';
                                                            break;
                                                        case 99:
                                                            i4 = i15;
                                                            c4 = 'c';
                                                            break;
                                                        case Socket.UDS_SUN_PATH_SIZE /* 100 */:
                                                            if (i21 != 0 || i20 == 0) {
                                                                if (i21 == 0 || i20 == 0) {
                                                                    i4 = i15;
                                                                    i20 = 1;
                                                                } else {
                                                                    i4 = i15;
                                                                    i20 = i4;
                                                                    i21 = i20;
                                                                }
                                                            }
                                                            i4 = i15;
                                                            i20 = i4;
                                                            i21 = 1;
                                                            break;
                                                        case 101:
                                                            i4 = i15;
                                                            c4 = 'e';
                                                            break;
                                                        case 102:
                                                            if (sb.length() == 0) {
                                                                i22 = 1;
                                                            } else if (sb.length() == 1) {
                                                                i22 = 2;
                                                            }
                                                            if (z) {
                                                                if (sb.length() == 0) {
                                                                    sb.append("]C1");
                                                                } else {
                                                                    sb.append((char) 29);
                                                                }
                                                                break;
                                                            }
                                                        default:
                                                            i4 = i15;
                                                            break;
                                                    }
                                                } else {
                                                    i4 = i15;
                                                    i23 = 1;
                                                }
                                                c2 = 'd';
                                            }
                                            break;
                                        case 'e':
                                            if (i27 >= 64) {
                                                if (i27 >= 96) {
                                                    if (i27 != 106) {
                                                        i18 = i15;
                                                    }
                                                    if (i27 != 106) {
                                                        switch (i27) {
                                                            case 98:
                                                                i4 = 1;
                                                                c4 = 'd';
                                                                break;
                                                            case Socket.UDS_SUN_PATH_SIZE /* 100 */:
                                                                i4 = i15;
                                                                c4 = 'd';
                                                                break;
                                                            case 101:
                                                                if (i21 != 0 || i20 == 0) {
                                                                    if (i21 == 0 || i20 == 0) {
                                                                    }
                                                                }
                                                                i4 = i15;
                                                                i20 = i4;
                                                                i21 = 1;
                                                                break;
                                                            case 102:
                                                                if (sb.length() == 0) {
                                                                    i22 = 1;
                                                                } else if (sb.length() == 1) {
                                                                    i22 = 2;
                                                                }
                                                                if (z) {
                                                                    if (sb.length() == 0) {
                                                                        sb.append("]C1");
                                                                    } else {
                                                                        sb.append((char) 29);
                                                                    }
                                                                    break;
                                                                }
                                                        }
                                                    }
                                                    c2 = 'd';
                                                    break;
                                                } else if (i20 == i21) {
                                                    sb.append((char) (i27 - 64));
                                                } else {
                                                    sb.append((char) (i27 + 64));
                                                }
                                            } else if (i20 == i21) {
                                                sb.append((char) (i27 + 32));
                                            } else {
                                                sb.append((char) (i27 + 160));
                                            }
                                            i4 = i15;
                                            i20 = i4;
                                            c2 = 'd';
                                            break;
                                        default:
                                            c2 = 'd';
                                            i4 = i15;
                                            break;
                                    }
                                    if (i24 != 0) {
                                        c4 = c4 == 'e' ? c2 : 'e';
                                    }
                                    i24 = i4;
                                    i19 = i25;
                                    i8 = 6;
                                    f = 0.7f;
                                    i25 = i27;
                                    i16 = i17;
                                    i17 = i29;
                                    break;
                            }
                            while (i23 == 0) {
                            }
                        }
                        int i31 = i17 - i16;
                        int iF = bnVar.f(i17);
                        if (!bnVar.h(iF, Math.min(bnVar.f, ((iF - i16) / 2) + iF))) {
                            throw qs2.a();
                        }
                        if ((i13 - (i26 * i19)) % 103 != i19) {
                            throw d40.a();
                        }
                        int length = sb.length();
                        if (length == 0) {
                            throw qs2.a();
                        }
                        if (length > 0 && i18 != 0) {
                            if (c4 == 'c') {
                                sb.delete(length - 2, length);
                            } else {
                                sb.delete(length - 1, length);
                            }
                        }
                        float f4 = (iArr3[1] + iArr3[i15]) / 2.0f;
                        float f5 = (i31 / 2.0f) + i16;
                        int size = arrayList.size();
                        byte[] bArr = new byte[size];
                        for (int i32 = i15; i32 < size; i32++) {
                            bArr[i32] = ((Byte) arrayList.get(i32)).byteValue();
                        }
                        String string = sb.toString();
                        float f6 = i;
                        xk3 xk3Var = new xk3(f4, f6);
                        xk3 xk3Var2 = new xk3(f5, f6);
                        xk3[] xk3VarArr = new xk3[2];
                        xk3VarArr[i15] = xk3Var;
                        xk3VarArr[1] = xk3Var2;
                        vk3 vk3Var = new vk3(string, bArr, xk3VarArr, sj.X);
                        vk3Var.b(wk3.D0, "]C" + i22);
                        return vk3Var;
                    }
                    int i33 = i6;
                    i10 += iArr2[i33] + iArr2[1];
                    int i34 = i9 - 1;
                    i2 = i33;
                    System.arraycopy(iArr2, 2, iArr2, i2, i34);
                    iArr2[i34] = i2;
                    iArr2[i9] = i2;
                    i9--;
                } else {
                    i2 = i6;
                    i9++;
                }
                i3 = 1;
                iArr2[i9] = 1;
                z2 = !z2;
            }
            iE++;
            i6 = i2;
            i5 = i3;
            i8 = 6;
        }
        throw qs2.a();
    }
}
