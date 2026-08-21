package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fd3 extends m1 {
    public static final int[] i = {1, 10, 34, 70, 126};
    public static final int[] j = {4, 20, 48, 81};
    public static final int[] k = {0, 161, 961, 2015, 2715};
    public static final int[] l = {0, 336, 1036, 1516};
    public static final int[] m = {8, 6, 4, 3, 1};
    public static final int[] n = {2, 4, 6, 8};
    public static final int[][] o = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    public final ArrayList g = new ArrayList();
    public final ArrayList h = new ArrayList();

    public static void i(ArrayList arrayList, d03 d03Var) {
        if (d03Var == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d03 d03Var2 = (d03) it.next();
            if (d03Var2.a == d03Var.a) {
                d03Var2.d++;
                return;
            }
        }
        arrayList.add(d03Var);
    }

    @Override // defpackage.ov2
    public final vk3 b(int i2, bn bnVar, Map map) throws qs2 {
        d03 d03VarK = k(bnVar, false, i2, map);
        ArrayList<d03> arrayList = this.g;
        i(arrayList, d03VarK);
        bnVar.i();
        d03 d03VarK2 = k(bnVar, true, i2, map);
        ArrayList<d03> arrayList2 = this.h;
        i(arrayList2, d03VarK2);
        bnVar.i();
        for (d03 d03Var : arrayList) {
            int i3 = d03Var.d;
            se1 se1Var = d03Var.c;
            if (i3 > 1) {
                for (d03 d03Var2 : arrayList2) {
                    int i4 = d03Var2.d;
                    se1 se1Var2 = d03Var2.c;
                    if (i4 > 1) {
                        int i5 = ((d03Var2.b * 16) + d03Var.b) % 79;
                        int i6 = (se1Var.a * 9) + se1Var2.a;
                        if (i6 > 72) {
                            i6--;
                        }
                        if (i6 > 8) {
                            i6--;
                        }
                        if (i5 == i6) {
                            String strValueOf = String.valueOf((((long) d03Var.a) * 4537077) + ((long) d03Var2.a));
                            StringBuilder sb = new StringBuilder(14);
                            for (int length = 13 - strValueOf.length(); length > 0; length--) {
                                sb.append('0');
                            }
                            sb.append(strValueOf);
                            int i7 = 0;
                            for (int i8 = 0; i8 < 13; i8++) {
                                int iCharAt = sb.charAt(i8) - '0';
                                if ((i8 & 1) == 0) {
                                    iCharAt *= 3;
                                }
                                i7 += iCharAt;
                            }
                            int i9 = 10 - (i7 % 10);
                            if (i9 == 10) {
                                i9 = 0;
                            }
                            sb.append(i9);
                            xk3[] xk3VarArr = se1Var.c;
                            xk3[] xk3VarArr2 = se1Var2.c;
                            vk3 vk3Var = new vk3(sb.toString(), null, new xk3[]{xk3VarArr[0], xk3VarArr[1], xk3VarArr2[0], xk3VarArr2[1]}, sj.D0);
                            vk3Var.b(wk3.D0, "]e0");
                            return vk3Var;
                        }
                    }
                }
            }
        }
        throw qs2.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0094 A[PHI: r13 r14
      0x0094: PHI (r13v7 boolean) = (r13v4 boolean), (r13v15 boolean) binds: [B:46:0x00ae, B:34:0x0092] A[DONT_GENERATE, DONT_INLINE]
      0x0094: PHI (r14v5 boolean) = (r14v2 boolean), (r14v13 boolean) binds: [B:46:0x00ae, B:34:0x0092] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0098 A[PHI: r13 r14
      0x0098: PHI (r13v6 boolean) = (r13v4 boolean), (r13v15 boolean) binds: [B:46:0x00ae, B:34:0x0092] A[DONT_GENERATE, DONT_INLINE]
      0x0098: PHI (r14v4 boolean) = (r14v2 boolean), (r14v13 boolean) binds: [B:46:0x00ae, B:34:0x0092] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final hi0 j(bn bnVar, se1 se1Var, boolean z) throws qs2 {
        float[] fArr;
        float[] fArr2;
        int[] iArr;
        int[] iArr2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int[] iArr3 = this.b;
        Arrays.fill(iArr3, 0);
        int[] iArr4 = se1Var.b;
        if (z) {
            ov2.e(iArr4[0], bnVar, iArr3);
        } else {
            ov2.d(iArr4[1], bnVar, iArr3);
            int i2 = 0;
            for (int length = iArr3.length - 1; i2 < length; length--) {
                int i3 = iArr3[i2];
                iArr3[i2] = iArr3[length];
                iArr3[length] = i3;
                i2++;
            }
        }
        int i4 = z ? 16 : 15;
        float fB0 = gb4.b0(iArr3) / i4;
        int i5 = 0;
        while (true) {
            int length2 = iArr3.length;
            fArr = this.d;
            fArr2 = this.c;
            iArr = this.f;
            iArr2 = this.e;
            if (i5 >= length2) {
                break;
            }
            float f = iArr3[i5] / fB0;
            int i6 = (int) (0.5f + f);
            if (i6 < 1) {
                i6 = 1;
            } else if (i6 > 8) {
                i6 = 8;
            }
            int i7 = i5 / 2;
            if ((i5 & 1) == 0) {
                iArr2[i7] = i6;
                fArr2[i7] = f - i6;
            } else {
                iArr[i7] = i6;
                fArr[i7] = f - i6;
            }
            i5++;
        }
        int iB0 = gb4.b0(iArr2);
        int iB02 = gb4.b0(iArr);
        if (z) {
            if (iB0 > 12) {
                z2 = false;
                z3 = true;
            } else if (iB0 < 4) {
                z3 = false;
                z2 = true;
            } else {
                z2 = false;
                z3 = false;
            }
            if (iB02 <= 12) {
                if (iB02 < 4) {
                    z5 = false;
                    z4 = true;
                } else {
                    z4 = false;
                    z5 = false;
                }
            }
            z4 = false;
            z5 = true;
        } else {
            if (iB0 > 11) {
                z2 = false;
                z3 = true;
            } else if (iB0 < 5) {
                z3 = false;
                z2 = true;
            } else {
                z2 = false;
                z3 = false;
            }
            if (iB02 <= 10) {
                if (iB02 < 4) {
                }
            }
            z4 = false;
            z5 = true;
        }
        int i8 = (iB0 + iB02) - i4;
        boolean z6 = (iB0 & 1) == z;
        boolean z7 = (iB02 & 1) == 1;
        if (i8 != -1) {
            if (i8 != 0) {
                if (i8 != 1) {
                    throw qs2.a();
                }
                if (z6) {
                    if (z7) {
                        throw qs2.a();
                    }
                    z3 = true;
                } else {
                    if (!z7) {
                        throw qs2.a();
                    }
                    z5 = true;
                }
            } else if (z6) {
                if (!z7) {
                    throw qs2.a();
                }
                if (iB0 < iB02) {
                    z2 = true;
                    z5 = true;
                } else {
                    z3 = true;
                    z4 = true;
                }
            } else if (z7) {
                throw qs2.a();
            }
        } else if (z6) {
            if (z7) {
                throw qs2.a();
            }
            z2 = true;
        } else {
            if (!z7) {
                throw qs2.a();
            }
            z4 = true;
        }
        if (z2) {
            if (z3) {
                throw qs2.a();
            }
            m1.g(iArr2, fArr2);
        }
        if (z3) {
            m1.f(iArr2, fArr2);
        }
        if (z4) {
            if (z5) {
                throw qs2.a();
            }
            m1.g(iArr, fArr2);
        }
        if (z5) {
            m1.f(iArr, fArr);
        }
        int i9 = 0;
        int i10 = 0;
        for (int length3 = iArr2.length - 1; length3 >= 0; length3--) {
            int i11 = iArr2[length3];
            i9 = (i9 * 9) + i11;
            i10 += i11;
        }
        int i12 = 0;
        int i13 = 0;
        for (int length4 = iArr.length - 1; length4 >= 0; length4--) {
            int i14 = iArr[length4];
            i12 = (i12 * 9) + i14;
            i13 += i14;
        }
        int i15 = (i12 * 3) + i9;
        if (!z) {
            if ((i13 & 1) != 0 || i13 > 10 || i13 < 4) {
                throw qs2.a();
            }
            int i16 = (10 - i13) / 2;
            int i17 = n[i16];
            return new hi0((fx3.p(iArr, 9 - i17, false) * j[i16]) + fx3.p(iArr2, i17, true) + l[i16], i15);
        }
        if ((i10 & 1) != 0 || i10 > 12 || i10 < 4) {
            throw qs2.a();
        }
        int i18 = (12 - i10) / 2;
        int i19 = m[i18];
        return new hi0((fx3.p(iArr2, i19, false) * i[i18]) + fx3.p(iArr, 9 - i19, true) + k[i18], i15);
    }

    public final d03 k(bn bnVar, boolean z, int i2, Map map) {
        try {
            se1 se1VarM = m(bnVar, i2, z, l(bnVar, z));
            if (map != null && map.get(fk0.X) != null) {
                throw new ClassCastException();
            }
            hi0 hi0VarJ = j(bnVar, se1VarM, true);
            hi0 hi0VarJ2 = j(bnVar, se1VarM, false);
            return new d03((hi0VarJ.a * 1597) + hi0VarJ2.a, (hi0VarJ2.b * 4) + hi0VarJ.b, se1VarM);
        } catch (qs2 unused) {
            return null;
        }
    }

    public final int[] l(bn bnVar, boolean z) throws qs2 {
        int[] iArr = this.a;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        int i2 = bnVar.f;
        int i3 = 0;
        boolean z2 = false;
        while (i3 < i2) {
            z2 = !bnVar.d(i3);
            if (z == z2) {
                break;
            }
            i3++;
        }
        int i4 = 0;
        int i5 = i3;
        while (i3 < i2) {
            if (bnVar.d(i3) != z2) {
                iArr[i4] = iArr[i4] + 1;
            } else {
                if (i4 != 3) {
                    i4++;
                } else {
                    if (m1.h(iArr)) {
                        return new int[]{i5, i3};
                    }
                    i5 += iArr[0] + iArr[1];
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = 0;
                    iArr[3] = 0;
                    i4--;
                }
                iArr[i4] = 1;
                z2 = !z2;
            }
            i3++;
        }
        throw qs2.a();
    }

    public final se1 m(bn bnVar, int i2, boolean z, int[] iArr) throws qs2 {
        int i3;
        int i4;
        boolean zD = bnVar.d(iArr[0]);
        int i5 = iArr[0] - 1;
        while (i5 >= 0 && zD != bnVar.d(i5)) {
            i5--;
        }
        int i6 = i5 + 1;
        int i7 = iArr[0] - i6;
        int[] iArr2 = this.a;
        System.arraycopy(iArr2, 0, iArr2, 1, iArr2.length - 1);
        iArr2[0] = i7;
        for (int i8 = 0; i8 < 9; i8++) {
            if (ov2.c(iArr2, o[i8], 0.45f) < 0.2f) {
                int i9 = iArr[1];
                if (z) {
                    int i10 = bnVar.f - 1;
                    i3 = i10 - i9;
                    i4 = i10 - i6;
                } else {
                    i3 = i9;
                    i4 = i6;
                }
                return new se1(i8, i4, i3, i2, new int[]{i6, i9});
            }
        }
        throw qs2.a();
    }

    @Override // defpackage.ov2, defpackage.be3
    public final void reset() {
        this.g.clear();
        this.h.clear();
    }
}
