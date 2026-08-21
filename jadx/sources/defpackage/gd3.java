package defpackage;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gd3 extends m1 {
    public static final int[] k = {7, 5, 4, 3, 1};
    public static final int[] l = {4, 20, 52, 104, 204};
    public static final int[] m = {0, 348, 1388, 2948, 3988};
    public static final int[][] n = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    public static final int[][] o = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, 203, 187, 139, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, ModuleDescriptor.MODULE_VERSION}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, 184, 130, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};
    public static final int[][] p = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    public final ArrayList g = new ArrayList(11);
    public final ArrayList h = new ArrayList();
    public final int[] i = new int[2];
    public boolean j;

    public static vk3 l(List list) {
        m0 oVar;
        int i = 2;
        int size = list.size() * 2;
        int i2 = size - 1;
        int i3 = 1;
        if (((k81) list.get(list.size() - 1)).b == null) {
            i2 = size - 2;
        }
        bn bnVar = new bn(i2 * 12);
        int i4 = 0;
        int i5 = ((k81) list.get(0)).b.a;
        int i6 = 0;
        for (int i7 = 11; i7 >= 0; i7--) {
            if (((1 << i7) & i5) != 0) {
                bnVar.j(i6);
            }
            i6++;
        }
        for (int i8 = 1; i8 < list.size(); i8++) {
            k81 k81Var = (k81) list.get(i8);
            int i9 = k81Var.a.a;
            for (int i10 = 11; i10 >= 0; i10--) {
                if (((1 << i10) & i9) != 0) {
                    bnVar.j(i6);
                }
                i6++;
            }
            hi0 hi0Var = k81Var.b;
            if (hi0Var != null) {
                int i11 = hi0Var.a;
                for (int i12 = 11; i12 >= 0; i12--) {
                    if (((1 << i12) & i11) != 0) {
                        bnVar.j(i6);
                    }
                    i6++;
                }
            }
        }
        if (bnVar.d(1)) {
            oVar = new p(bnVar, i);
        } else if (bnVar.d(2)) {
            int iY = ed4.y(1, 4, bnVar);
            if (iY == 4) {
                oVar = new o(bnVar, 0);
            } else if (iY != 5) {
                int iY2 = ed4.y(1, 5, bnVar);
                if (iY2 == 12) {
                    oVar = new p(bnVar, i4);
                } else if (iY2 != 13) {
                    switch (ed4.y(1, 7, bnVar)) {
                        case 56:
                            oVar = new q(bnVar, "310", "11");
                            break;
                        case 57:
                            oVar = new q(bnVar, "320", "11");
                            break;
                        case 58:
                            oVar = new q(bnVar, "310", "13");
                            break;
                        case 59:
                            oVar = new q(bnVar, "320", "13");
                            break;
                        case 60:
                            oVar = new q(bnVar, "310", "15");
                            break;
                        case 61:
                            oVar = new q(bnVar, "320", "15");
                            break;
                        case 62:
                            oVar = new q(bnVar, "310", "17");
                            break;
                        case 63:
                            oVar = new q(bnVar, "320", "17");
                            break;
                        default:
                            s53.j(bnVar, "unknown decoder: ");
                            return null;
                    }
                } else {
                    oVar = new p(bnVar, i3);
                }
            } else {
                oVar = new o(bnVar, 1);
            }
        } else {
            oVar = new p9(bnVar);
        }
        String strP = oVar.p();
        xk3[] xk3VarArr = ((k81) list.get(0)).c.c;
        xk3[] xk3VarArr2 = ((k81) list.get(list.size() - 1)).c.c;
        vk3 vk3Var = new vk3(strP, null, new xk3[]{xk3VarArr[0], xk3VarArr[1], xk3VarArr2[0], xk3VarArr2[1]}, sj.E0);
        vk3Var.b(wk3.D0, "]e0");
        return vk3Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean o(java.util.ArrayList r6, boolean r7) {
        /*
            r0 = 0
            r1 = r0
        L2:
            r2 = 10
            if (r1 >= r2) goto L34
            int[][] r2 = defpackage.gd3.p
            r2 = r2[r1]
            int r3 = r6.size()
            int r4 = r2.length
            if (r7 == 0) goto L14
            if (r3 != r4) goto L31
            goto L16
        L14:
            if (r3 > r4) goto L31
        L16:
            r3 = r0
        L17:
            int r4 = r6.size()
            if (r3 >= r4) goto L2f
            java.lang.Object r4 = r6.get(r3)
            k81 r4 = (defpackage.k81) r4
            se1 r4 = r4.c
            int r4 = r4.a
            r5 = r2[r3]
            if (r4 == r5) goto L2c
            goto L31
        L2c:
            int r3 = r3 + 1
            goto L17
        L2f:
            r6 = 1
            return r6
        L31:
            int r1 = r1 + 1
            goto L2
        L34:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gd3.o(java.util.ArrayList, boolean):boolean");
    }

    @Override // defpackage.ov2
    public final vk3 b(int i, bn bnVar, Map map) {
        this.j = false;
        try {
            return l(n(bnVar, i));
        } catch (qs2 unused) {
            this.j = true;
            return l(this.n(bnVar, i));
        }
    }

    public final boolean i() {
        ArrayList arrayList = this.g;
        k81 k81Var = (k81) arrayList.get(0);
        hi0 hi0Var = k81Var.a;
        hi0 hi0Var2 = k81Var.b;
        if (hi0Var2 != null) {
            int i = hi0Var2.b;
            int i2 = 2;
            for (int i3 = 1; i3 < arrayList.size(); i3++) {
                k81 k81Var2 = (k81) arrayList.get(i3);
                i += k81Var2.a.b;
                int i4 = i2 + 1;
                hi0 hi0Var3 = k81Var2.b;
                if (hi0Var3 != null) {
                    i += hi0Var3.b;
                    i2 += 2;
                } else {
                    i2 = i4;
                }
            }
            if (((i2 - 4) * 211) + (i % 211) == hi0Var.a) {
                return true;
            }
        }
        return false;
    }

    public final List j(ArrayList arrayList, int i) throws qs2 {
        while (true) {
            ArrayList arrayList2 = this.h;
            if (i >= arrayList2.size()) {
                throw qs2.a();
            }
            l81 l81Var = (l81) arrayList2.get(i);
            ArrayList arrayList3 = l81Var.a;
            ArrayList arrayList4 = this.g;
            arrayList4.addAll(arrayList3);
            int size = l81Var.a.size();
            if (!o(arrayList4, false)) {
                arrayList4.subList(arrayList4.size() - size, arrayList4.size()).clear();
            } else {
                if (this.i()) {
                    return arrayList4;
                }
                arrayList.add(l81Var);
                try {
                    return this.j(arrayList, i + 1);
                } catch (qs2 unused) {
                    arrayList.remove(arrayList.size() - 1);
                    arrayList4.subList(arrayList4.size() - size, arrayList4.size()).clear();
                }
            }
            i++;
        }
    }

    public final List k(boolean z) {
        ArrayList arrayList = this.h;
        List listJ = null;
        if (arrayList.size() > 25) {
            arrayList.clear();
            return null;
        }
        this.g.clear();
        if (z) {
            Collections.reverse(arrayList);
        }
        try {
            listJ = j(new ArrayList(), 0);
        } catch (qs2 unused) {
        }
        if (z) {
            Collections.reverse(arrayList);
        }
        return listJ;
    }

    public final hi0 m(bn bnVar, se1 se1Var, boolean z, boolean z2) throws qs2 {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int[][] iArr;
        int[] iArr2 = this.b;
        Arrays.fill(iArr2, 0);
        if (z2) {
            ov2.e(se1Var.b[0], bnVar, iArr2);
        } else {
            ov2.d(se1Var.b[1], bnVar, iArr2);
            int i = 0;
            for (int length = iArr2.length - 1; i < length; length--) {
                int i2 = iArr2[i];
                iArr2[i] = iArr2[length];
                iArr2[length] = i2;
                i++;
            }
        }
        float fB0 = gb4.b0(iArr2) / 17.0f;
        int[] iArr3 = se1Var.b;
        int i3 = se1Var.a;
        float f = (iArr3[1] - iArr3[0]) / 15.0f;
        if (Math.abs(fB0 - f) / f > 0.3f) {
            throw qs2.a();
        }
        int i4 = 0;
        while (true) {
            int length2 = iArr2.length;
            float[] fArr = this.d;
            float[] fArr2 = this.c;
            int[] iArr4 = this.f;
            int[] iArr5 = this.e;
            if (i4 >= length2) {
                int iB0 = gb4.b0(iArr5);
                int iB02 = gb4.b0(iArr4);
                if (iB0 > 13) {
                    z3 = false;
                    z4 = true;
                } else if (iB0 < 4) {
                    z4 = false;
                    z3 = true;
                } else {
                    z3 = false;
                    z4 = false;
                }
                if (iB02 > 13) {
                    z5 = false;
                    z6 = true;
                } else if (iB02 < 4) {
                    z6 = false;
                    z5 = true;
                } else {
                    z5 = false;
                    z6 = false;
                }
                int i5 = (iB0 + iB02) - 17;
                boolean z7 = (iB0 & 1) == 1;
                boolean z8 = (iB02 & 1) == 0;
                boolean z9 = z3;
                boolean z10 = z4;
                boolean z11 = z5;
                boolean z12 = z6;
                if (i5 != -1) {
                    if (i5 != 0) {
                        if (i5 != 1) {
                            throw qs2.a();
                        }
                        if (z7) {
                            if (z8) {
                                throw qs2.a();
                            }
                            z10 = true;
                            z9 = z3;
                            z11 = z5;
                            z12 = z6;
                        } else {
                            if (!z8) {
                                throw qs2.a();
                            }
                            z12 = true;
                            z9 = z3;
                            z10 = z4;
                            z11 = z5;
                        }
                    } else if (z7) {
                        if (!z8) {
                            throw qs2.a();
                        }
                        if (iB0 < iB02) {
                            z9 = true;
                            z12 = true;
                            z10 = z4;
                            z11 = z5;
                        } else {
                            z10 = true;
                            z11 = true;
                            z9 = z3;
                            z12 = z6;
                        }
                    } else if (z8) {
                        throw qs2.a();
                    }
                } else if (z7) {
                    if (z8) {
                        throw qs2.a();
                    }
                    z9 = true;
                    z10 = z4;
                    z11 = z5;
                    z12 = z6;
                } else {
                    if (!z8) {
                        throw qs2.a();
                    }
                    z11 = true;
                    z9 = z3;
                    z10 = z4;
                    z12 = z6;
                }
                if (z9) {
                    if (z10) {
                        throw qs2.a();
                    }
                    m1.g(iArr5, fArr2);
                }
                if (z10) {
                    m1.f(iArr5, fArr2);
                }
                if (z11) {
                    if (z12) {
                        throw qs2.a();
                    }
                    m1.g(iArr4, fArr2);
                }
                if (z12) {
                    m1.f(iArr4, fArr);
                }
                int i6 = (((i3 * 4) + (z ? 0 : 2)) + (!z2 ? 1 : 0)) - 1;
                int length3 = iArr5.length - 1;
                int i7 = 0;
                int i8 = 0;
                while (true) {
                    iArr = o;
                    if (length3 < 0) {
                        break;
                    }
                    if (i3 != 0 || !z || !z2) {
                        i7 += iArr5[length3] * iArr[i6][length3 * 2];
                    }
                    i8 += iArr5[length3];
                    length3--;
                }
                int i9 = 0;
                for (int length4 = iArr4.length - 1; length4 >= 0; length4--) {
                    if (i3 != 0 || !z || !z2) {
                        i9 += iArr4[length4] * iArr[i6][(length4 * 2) + 1];
                    }
                }
                int i10 = i7 + i9;
                if ((i8 & 1) != 0 || i8 > 13 || i8 < 4) {
                    throw qs2.a();
                }
                int i11 = (13 - i8) / 2;
                int i12 = k[i11];
                return new hi0((fx3.p(iArr5, i12, true) * l[i11]) + fx3.p(iArr4, 9 - i12, false) + m[i11], i10);
            }
            float f2 = (iArr2[i4] * 1.0f) / fB0;
            int i13 = (int) (0.5f + f2);
            if (i13 < 1) {
                if (f2 < 0.3f) {
                    throw qs2.a();
                }
                i13 = 1;
            } else if (i13 > 8) {
                if (f2 > 8.7f) {
                    throw qs2.a();
                }
                i13 = 8;
            }
            int i14 = i4 / 2;
            if ((i4 & 1) == 0) {
                iArr5[i14] = i13;
                fArr2[i14] = f2 - i13;
            } else {
                iArr4[i14] = i13;
                fArr[i14] = f2 - i13;
            }
            i4++;
        }
    }

    public final List n(bn bnVar, int i) throws qs2 {
        boolean zEquals;
        ArrayList<k81> arrayList = this.g;
        arrayList.clear();
        boolean z = false;
        while (!z) {
            try {
                arrayList.add(p(bnVar, arrayList, i));
            } catch (qs2 e) {
                if (arrayList.isEmpty()) {
                    throw e;
                }
                z = true;
            }
        }
        if (i() && o(arrayList, true)) {
            return arrayList;
        }
        ArrayList arrayList2 = this.h;
        boolean zIsEmpty = arrayList2.isEmpty();
        int i2 = 0;
        boolean zEquals2 = false;
        while (true) {
            if (i2 >= arrayList2.size()) {
                zEquals = false;
                break;
            }
            l81 l81Var = (l81) arrayList2.get(i2);
            int i3 = l81Var.b;
            ArrayList arrayList3 = l81Var.a;
            if (i3 > i) {
                zEquals = arrayList3.equals(arrayList);
                break;
            }
            zEquals2 = arrayList3.equals(arrayList);
            i2++;
        }
        if (!zEquals && !zEquals2) {
            Iterator it = arrayList2.iterator();
            loop2: while (true) {
                if (it.hasNext()) {
                    l81 l81Var2 = (l81) it.next();
                    for (k81 k81Var : arrayList) {
                        Iterator it2 = l81Var2.a.iterator();
                        while (it2.hasNext()) {
                            if (k81Var.equals((k81) it2.next())) {
                                break;
                            }
                        }
                    }
                    break loop2;
                }
                arrayList2.add(i2, new l81(arrayList, i));
                Iterator it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    l81 l81Var3 = (l81) it3.next();
                    if (l81Var3.a.size() != arrayList.size()) {
                        Iterator it4 = l81Var3.a.iterator();
                        while (true) {
                            if (!it4.hasNext()) {
                                it3.remove();
                                break;
                            }
                            if (!arrayList.contains((k81) it4.next())) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (!zIsEmpty) {
            List listK = k(false);
            if (listK != null) {
                return listK;
            }
            List listK2 = k(true);
            if (listK2 != null) {
                return listK2;
            }
        }
        throw qs2.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x023f A[LOOP:0: B:10:0x001c->B:124:0x023f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x021b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.k81 p(defpackage.bn r28, java.util.ArrayList r29, int r30) throws defpackage.qs2 {
        /*
            Method dump skipped, instruction units count: 657
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gd3.p(bn, java.util.ArrayList, int):k81");
    }

    @Override // defpackage.ov2, defpackage.be3
    public final void reset() {
        this.g.clear();
        this.h.clear();
    }
}
