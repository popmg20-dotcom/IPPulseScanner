package defpackage;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ju0 {
    public final ArrayList a;
    public final int[] b;
    public final int[] c;
    public final ez4 d;
    public final int e;
    public final int f;
    public final boolean g;

    public ju0(ez4 ez4Var, ArrayList arrayList, int[] iArr, int[] iArr2) {
        int i;
        iu0 iu0Var;
        int i2;
        this.a = arrayList;
        this.b = iArr;
        this.c = iArr2;
        Arrays.fill(iArr, 0);
        Arrays.fill(iArr2, 0);
        this.d = ez4Var;
        int iA = ez4Var.A();
        this.e = iA;
        int iZ = ez4Var.z();
        this.f = iZ;
        this.g = true;
        iu0 iu0Var2 = arrayList.isEmpty() ? null : (iu0) arrayList.get(0);
        if (iu0Var2 == null || iu0Var2.a != 0 || iu0Var2.b != 0) {
            arrayList.add(0, new iu0(0, 0, 0));
        }
        arrayList.add(new iu0(iA, iZ, 0));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            iu0 iu0Var3 = (iu0) it.next();
            for (int i3 = 0; i3 < iu0Var3.c; i3++) {
                int i4 = iu0Var3.a + i3;
                int i5 = iu0Var3.b + i3;
                int i6 = ez4Var.b(i4, i5) ? 1 : 2;
                iArr[i4] = (i5 << 4) | i6;
                iArr2[i5] = (i4 << 4) | i6;
            }
        }
        if (this.g) {
            Iterator it2 = arrayList.iterator();
            int i7 = 0;
            while (it2.hasNext()) {
                iu0 iu0Var4 = (iu0) it2.next();
                while (true) {
                    i = iu0Var4.a;
                    if (i7 < i) {
                        if (iArr[i7] == 0) {
                            int size = arrayList.size();
                            int i8 = 0;
                            int i9 = 0;
                            while (true) {
                                if (i8 < size) {
                                    iu0Var = (iu0) arrayList.get(i8);
                                    while (true) {
                                        i2 = iu0Var.b;
                                        if (i9 < i2) {
                                            if (iArr2[i9] == 0 && ez4Var.c(i7, i9)) {
                                                int i10 = ez4Var.b(i7, i9) ? 8 : 4;
                                                iArr[i7] = (i9 << 4) | i10;
                                                iArr2[i9] = i10 | (i7 << 4);
                                            } else {
                                                i9++;
                                            }
                                        }
                                    }
                                }
                                i9 = iu0Var.c + i2;
                                i8++;
                            }
                        }
                        i7++;
                    }
                }
                i7 = iu0Var4.c + i;
            }
        }
    }

    public static ku0 c(ArrayDeque arrayDeque, int i, boolean z) {
        ku0 ku0Var;
        Iterator it = arrayDeque.iterator();
        while (true) {
            if (!it.hasNext()) {
                ku0Var = null;
                break;
            }
            ku0Var = (ku0) it.next();
            if (ku0Var.a == i && ku0Var.c == z) {
                it.remove();
                break;
            }
        }
        while (it.hasNext()) {
            ku0 ku0Var2 = (ku0) it.next();
            if (z) {
                ku0Var2.b--;
            } else {
                ku0Var2.b++;
            }
        }
        return ku0Var;
    }

    public final int a(int i) {
        int i2 = this.e;
        if (i < 0 || i >= i2) {
            s53.k(fw.s(i, i2, "Index out of bounds - passed position = ", ", old list size = "));
            return 0;
        }
        int i3 = this.b[i];
        if ((i3 & 15) == 0) {
            return -1;
        }
        return i3 >> 4;
    }

    public final void b(lc2 lc2Var) {
        int[] iArr;
        ez4 ez4Var;
        int i;
        int i2;
        ArrayList arrayList;
        ju0 ju0Var = this;
        hm hmVar = lc2Var instanceof hm ? (hm) lc2Var : new hm(lc2Var);
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList2 = ju0Var.a;
        boolean z = true;
        int size = arrayList2.size() - 1;
        int i3 = ju0Var.e;
        int i4 = ju0Var.f;
        int i5 = i3;
        while (size >= 0) {
            iu0 iu0Var = (iu0) arrayList2.get(size);
            int i6 = iu0Var.a;
            int i7 = iu0Var.c;
            int i8 = i6 + i7;
            int i9 = iu0Var.b;
            int i10 = i9 + i7;
            while (true) {
                iArr = ju0Var.b;
                ez4Var = ju0Var.d;
                boolean z2 = z;
                i = 0;
                if (i5 <= i8) {
                    break;
                }
                i5--;
                int i11 = iArr[i5];
                if ((i11 & 12) != 0) {
                    arrayList = arrayList2;
                    int i12 = i11 >> 4;
                    ku0 ku0VarC = c(arrayDeque, i12, false);
                    if (ku0VarC != null) {
                        int i13 = (i3 - ku0VarC.b) - 1;
                        hmVar.g(i5, i13);
                        if ((i11 & 4) != 0) {
                            hmVar.d0(i13, z2 ? 1 : 0, ez4Var.w(i5, i12));
                        }
                    } else {
                        arrayDeque.add(new ku0(i5, (i3 - i5) - (z2 ? 1 : 0), z2));
                    }
                } else {
                    arrayList = arrayList2;
                    hmVar.P(i5, z2 ? 1 : 0);
                    i3--;
                }
                arrayList2 = arrayList;
                z = true;
            }
            ArrayList arrayList3 = arrayList2;
            while (i4 > i10) {
                i4--;
                int i14 = ju0Var.c[i4];
                if ((i14 & 12) != 0) {
                    int i15 = i14 >> 4;
                    ku0 ku0VarC2 = c(arrayDeque, i15, true);
                    if (ku0VarC2 == null) {
                        arrayDeque.add(new ku0(i4, i3 - i5, false));
                        i2 = 0;
                    } else {
                        i2 = 0;
                        hmVar.g((i3 - ku0VarC2.b) - 1, i5);
                        if ((i14 & 4) != 0) {
                            hmVar.d0(i5, 1, ez4Var.w(i15, i4));
                        }
                    }
                } else {
                    i2 = i;
                    hmVar.D(i5, 1);
                    i3++;
                }
                ju0Var = this;
                i = i2;
            }
            int i16 = i9;
            int i17 = i6;
            while (i < i7) {
                if ((iArr[i17] & 15) == 2) {
                    hmVar.d0(i17, 1, ez4Var.w(i17, i16));
                }
                i17++;
                i16++;
                i++;
            }
            size--;
            ju0Var = this;
            z = true;
            i4 = i9;
            i5 = i6;
            arrayList2 = arrayList3;
        }
        hmVar.a();
    }
}
