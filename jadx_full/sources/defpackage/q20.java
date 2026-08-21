package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q20 extends nt4 {
    public final ArrayList k;
    public int l;

    public q20(jc0 jc0Var, int i) {
        jc0 jc0Var2;
        super(jc0Var);
        ArrayList<nt4> arrayList = new ArrayList();
        this.k = arrayList;
        this.f = i;
        jc0 jc0Var3 = this.b;
        jc0 jc0VarK = jc0Var3.k(i);
        while (true) {
            jc0Var2 = jc0Var3;
            jc0Var3 = jc0VarK;
            if (jc0Var3 == null) {
                break;
            } else {
                jc0VarK = jc0Var3.k(this.f);
            }
        }
        this.b = jc0Var2;
        int i2 = this.f;
        arrayList.add(i2 == 0 ? jc0Var2.d : i2 == 1 ? jc0Var2.e : null);
        jc0 jc0VarJ = jc0Var2.j(this.f);
        while (jc0VarJ != null) {
            int i3 = this.f;
            arrayList.add(i3 == 0 ? jc0VarJ.d : i3 == 1 ? jc0VarJ.e : null);
            jc0VarJ = jc0VarJ.j(this.f);
        }
        for (nt4 nt4Var : arrayList) {
            int i4 = this.f;
            if (i4 == 0) {
                nt4Var.b.b = this;
            } else if (i4 == 1) {
                nt4Var.b.c = this;
            }
        }
        if (this.f == 0 && this.b.S.u0 && arrayList.size() > 1) {
            this.b = ((nt4) fw.r(arrayList, 1)).b;
        }
        int i5 = this.f;
        jc0 jc0Var4 = this.b;
        this.l = i5 == 0 ? jc0Var4.h0 : jc0Var4.i0;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d9  */
    @Override // defpackage.io0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(io0 io0Var) {
        int i;
        int i2;
        boolean z;
        float f;
        int i3;
        int i4;
        int i5;
        int i6;
        float f2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z2;
        int i13;
        oo0 oo0Var = this.h;
        if (oo0Var.j) {
            oo0 oo0Var2 = this.i;
            if (oo0Var2.j) {
                kc0 kc0Var = this.b.S;
                boolean z3 = kc0Var != null ? kc0Var.u0 : false;
                int i14 = oo0Var2.g - oo0Var.g;
                ArrayList arrayList = this.k;
                int size = arrayList.size();
                int i15 = 0;
                while (true) {
                    i = -1;
                    i2 = 8;
                    if (i15 >= size) {
                        i15 = -1;
                        break;
                    } else if (((nt4) arrayList.get(i15)).b.f0 != 8) {
                        break;
                    } else {
                        i15++;
                    }
                }
                int i16 = size - 1;
                int i17 = i16;
                while (true) {
                    if (i17 < 0) {
                        break;
                    }
                    if (((nt4) arrayList.get(i17)).b.f0 != 8) {
                        i = i17;
                        break;
                    }
                    i17--;
                }
                int i18 = 0;
                while (i18 < 2) {
                    f = 0.0f;
                    int i19 = 0;
                    i5 = 0;
                    int i20 = 0;
                    int i21 = 0;
                    while (i19 < size) {
                        nt4 nt4Var = (nt4) arrayList.get(i19);
                        jc0 jc0Var = nt4Var.b;
                        boolean z4 = z3;
                        if (jc0Var.f0 == i2) {
                            i12 = i18;
                        } else {
                            i21++;
                            if (i19 > 0 && i19 >= i15) {
                                i5 += nt4Var.h.f;
                            }
                            su0 su0Var = nt4Var.e;
                            int i22 = su0Var.g;
                            i12 = i18;
                            boolean z5 = nt4Var.d != 3;
                            if (z5) {
                                int i23 = this.f;
                                if (i23 == 0 && !jc0Var.d.e.j) {
                                    return;
                                }
                                if (i23 == 1 && !jc0Var.e.e.j) {
                                    return;
                                } else {
                                    z2 = z5;
                                }
                            } else {
                                z2 = z5;
                                if (nt4Var.a == 1 && i12 == 0) {
                                    i13 = su0Var.m;
                                    i20++;
                                } else if (su0Var.j) {
                                    i13 = i22;
                                }
                                z2 = true;
                                if (z2) {
                                    i20++;
                                    float f3 = jc0Var.j0[this.f];
                                    if (f3 >= 0.0f) {
                                        f += f3;
                                    }
                                } else {
                                    i5 += i13;
                                }
                                if (i19 >= i16 && i19 < i) {
                                    i5 += -nt4Var.i.f;
                                }
                            }
                            i13 = i22;
                            if (z2) {
                            }
                            if (i19 >= i16) {
                            }
                        }
                        i19++;
                        z3 = z4;
                        i18 = i12;
                        i2 = 8;
                    }
                    z = z3;
                    int i24 = i18;
                    if (i5 < i14 || i20 == 0) {
                        i3 = i20;
                        i4 = i21;
                        break;
                    } else {
                        i18 = i24 + 1;
                        z3 = z;
                        i2 = 8;
                    }
                }
                z = z3;
                f = 0.0f;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                int i25 = oo0Var.g;
                if (z) {
                    i25 = oo0Var2.g;
                }
                float f4 = 0.5f;
                if (i5 > i14) {
                    i25 = z ? i25 + ((int) (((i5 - i14) / 2.0f) + 0.5f)) : i25 - ((int) (((i5 - i14) / 2.0f) + 0.5f));
                }
                if (i3 > 0) {
                    float f5 = i14 - i5;
                    int i26 = (int) ((f5 / i3) + 0.5f);
                    int i27 = 0;
                    int i28 = 0;
                    while (i27 < size) {
                        float f6 = f4;
                        nt4 nt4Var2 = (nt4) arrayList.get(i27);
                        int i29 = i25;
                        jc0 jc0Var2 = nt4Var2.b;
                        int i30 = i3;
                        su0 su0Var2 = nt4Var2.e;
                        float f7 = f5;
                        int i31 = i26;
                        if (jc0Var2.f0 == 8 || nt4Var2.d != 3 || su0Var2.j) {
                            i11 = i27;
                        } else {
                            int i32 = f > 0.0f ? (int) (((jc0Var2.j0[this.f] * f7) / f) + f6) : i31;
                            if (this.f == 0) {
                                i9 = jc0Var2.v;
                                i10 = jc0Var2.u;
                            } else {
                                i9 = jc0Var2.y;
                                i10 = jc0Var2.x;
                            }
                            i11 = i27;
                            int iMax = Math.max(i10, nt4Var2.a == 1 ? Math.min(i32, su0Var2.m) : i32);
                            if (i9 > 0) {
                                iMax = Math.min(i9, iMax);
                            }
                            if (iMax != i32) {
                                i28++;
                                i32 = iMax;
                            }
                            su0Var2.d(i32);
                        }
                        i27 = i11 + 1;
                        i25 = i29;
                        f4 = f6;
                        i3 = i30;
                        f5 = f7;
                        i26 = i31;
                    }
                    i6 = i25;
                    f2 = f4;
                    int i33 = i3;
                    if (i28 > 0) {
                        i3 = i33 - i28;
                        i5 = 0;
                        for (int i34 = 0; i34 < size; i34++) {
                            nt4 nt4Var3 = (nt4) arrayList.get(i34);
                            if (nt4Var3.b.f0 != 8) {
                                if (i34 > 0 && i34 >= i15) {
                                    i5 += nt4Var3.h.f;
                                }
                                i5 += nt4Var3.e.g;
                                if (i34 < i16 && i34 < i) {
                                    i5 += -nt4Var3.i.f;
                                }
                            }
                        }
                    } else {
                        i3 = i33;
                    }
                    i8 = 2;
                    if (this.l == 2 && i28 == 0) {
                        i7 = 0;
                        this.l = 0;
                    } else {
                        i7 = 0;
                    }
                } else {
                    i6 = i25;
                    f2 = 0.5f;
                    i7 = 0;
                    i8 = 2;
                }
                if (i5 > i14) {
                    this.l = i8;
                }
                if (i4 > 0 && i3 == 0 && i15 == i) {
                    this.l = i8;
                }
                int i35 = this.l;
                if (i35 == 1) {
                    int i36 = i4 > 1 ? (i14 - i5) / (i4 - 1) : i4 == 1 ? (i14 - i5) / 2 : i7;
                    if (i3 > 0) {
                        i36 = i7;
                    }
                    int i37 = i6;
                    for (int i38 = i7; i38 < size; i38++) {
                        nt4 nt4Var4 = (nt4) arrayList.get(z ? size - (i38 + 1) : i38);
                        jc0 jc0Var3 = nt4Var4.b;
                        oo0 oo0Var3 = nt4Var4.i;
                        oo0 oo0Var4 = nt4Var4.h;
                        if (jc0Var3.f0 == 8) {
                            oo0Var4.d(i37);
                            oo0Var3.d(i37);
                        } else {
                            if (i38 > 0) {
                                i37 = z ? i37 - i36 : i37 + i36;
                            }
                            if (i38 > 0 && i38 >= i15) {
                                i37 = z ? i37 - oo0Var4.f : i37 + oo0Var4.f;
                            }
                            if (z) {
                                oo0Var3.d(i37);
                            } else {
                                oo0Var4.d(i37);
                            }
                            su0 su0Var3 = nt4Var4.e;
                            int i39 = su0Var3.g;
                            if (nt4Var4.d == 3 && nt4Var4.a == 1) {
                                i39 = su0Var3.m;
                            }
                            i37 = z ? i37 - i39 : i37 + i39;
                            if (z) {
                                oo0Var4.d(i37);
                            } else {
                                oo0Var3.d(i37);
                            }
                            nt4Var4.g = true;
                            if (i38 < i16 && i38 < i) {
                                i37 = z ? i37 - (-oo0Var3.f) : i37 + (-oo0Var3.f);
                            }
                        }
                    }
                    return;
                }
                if (i35 == 0) {
                    int i40 = (i14 - i5) / (i4 + 1);
                    if (i3 > 0) {
                        i40 = i7;
                    }
                    int i41 = i6;
                    for (int i42 = i7; i42 < size; i42++) {
                        nt4 nt4Var5 = (nt4) arrayList.get(z ? size - (i42 + 1) : i42);
                        jc0 jc0Var4 = nt4Var5.b;
                        oo0 oo0Var5 = nt4Var5.i;
                        oo0 oo0Var6 = nt4Var5.h;
                        if (jc0Var4.f0 == 8) {
                            oo0Var6.d(i41);
                            oo0Var5.d(i41);
                        } else {
                            int i43 = z ? i41 - i40 : i41 + i40;
                            if (i42 > 0 && i42 >= i15) {
                                i43 = z ? i43 - oo0Var6.f : i43 + oo0Var6.f;
                            }
                            if (z) {
                                oo0Var5.d(i43);
                            } else {
                                oo0Var6.d(i43);
                            }
                            su0 su0Var4 = nt4Var5.e;
                            int iMin = su0Var4.g;
                            if (nt4Var5.d == 3 && nt4Var5.a == 1) {
                                iMin = Math.min(iMin, su0Var4.m);
                            }
                            i41 = z ? i43 - iMin : i43 + iMin;
                            if (z) {
                                oo0Var6.d(i41);
                            } else {
                                oo0Var5.d(i41);
                            }
                            if (i42 < i16 && i42 < i) {
                                i41 = z ? i41 - (-oo0Var5.f) : i41 + (-oo0Var5.f);
                            }
                        }
                    }
                    return;
                }
                if (i35 == 2) {
                    int i44 = this.f;
                    jc0 jc0Var5 = this.b;
                    float f8 = i44 == 0 ? jc0Var5.c0 : jc0Var5.d0;
                    if (z) {
                        f8 = 1.0f - f8;
                    }
                    int i45 = (int) (((i14 - i5) * f8) + f2);
                    if (i45 < 0 || i3 > 0) {
                        i45 = i7;
                    }
                    int i46 = z ? i6 - i45 : i6 + i45;
                    for (int i47 = i7; i47 < size; i47++) {
                        nt4 nt4Var6 = (nt4) arrayList.get(z ? size - (i47 + 1) : i47);
                        jc0 jc0Var6 = nt4Var6.b;
                        oo0 oo0Var7 = nt4Var6.i;
                        oo0 oo0Var8 = nt4Var6.h;
                        if (jc0Var6.f0 == 8) {
                            oo0Var8.d(i46);
                            oo0Var7.d(i46);
                        } else {
                            if (i47 > 0 && i47 >= i15) {
                                i46 = z ? i46 - oo0Var8.f : i46 + oo0Var8.f;
                            }
                            if (z) {
                                oo0Var7.d(i46);
                            } else {
                                oo0Var8.d(i46);
                            }
                            su0 su0Var5 = nt4Var6.e;
                            int i48 = su0Var5.g;
                            if (nt4Var6.d == 3 && nt4Var6.a == 1) {
                                i48 = su0Var5.m;
                            }
                            i46 = z ? i46 - i48 : i46 + i48;
                            if (z) {
                                oo0Var8.d(i46);
                            } else {
                                oo0Var7.d(i46);
                            }
                            if (i47 < i16 && i47 < i) {
                                i46 = z ? i46 - (-oo0Var7.f) : i46 + (-oo0Var7.f);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // defpackage.nt4
    public final void d() {
        ArrayList arrayList = this.k;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((nt4) it.next()).d();
        }
        int size = arrayList.size();
        if (size < 1) {
            return;
        }
        jc0 jc0Var = ((nt4) arrayList.get(0)).b;
        jc0 jc0Var2 = ((nt4) arrayList.get(size - 1)).b;
        int i = this.f;
        oo0 oo0Var = this.i;
        oo0 oo0Var2 = this.h;
        if (i == 0) {
            lb0 lb0Var = jc0Var.H;
            lb0 lb0Var2 = jc0Var2.J;
            oo0 oo0VarI = nt4.i(lb0Var, 0);
            int iD = lb0Var.d();
            jc0 jc0VarM = m();
            if (jc0VarM != null) {
                iD = jc0VarM.H.d();
            }
            if (oo0VarI != null) {
                nt4.b(oo0Var2, oo0VarI, iD);
            }
            oo0 oo0VarI2 = nt4.i(lb0Var2, 0);
            int iD2 = lb0Var2.d();
            jc0 jc0VarN = n();
            if (jc0VarN != null) {
                iD2 = jc0VarN.J.d();
            }
            if (oo0VarI2 != null) {
                nt4.b(oo0Var, oo0VarI2, -iD2);
            }
        } else {
            lb0 lb0Var3 = jc0Var.I;
            lb0 lb0Var4 = jc0Var2.K;
            oo0 oo0VarI3 = nt4.i(lb0Var3, 1);
            int iD3 = lb0Var3.d();
            jc0 jc0VarM2 = m();
            if (jc0VarM2 != null) {
                iD3 = jc0VarM2.I.d();
            }
            if (oo0VarI3 != null) {
                nt4.b(oo0Var2, oo0VarI3, iD3);
            }
            oo0 oo0VarI4 = nt4.i(lb0Var4, 1);
            int iD4 = lb0Var4.d();
            jc0 jc0VarN2 = n();
            if (jc0VarN2 != null) {
                iD4 = jc0VarN2.K.d();
            }
            if (oo0VarI4 != null) {
                nt4.b(oo0Var, oo0VarI4, -iD4);
            }
        }
        oo0Var2.a = this;
        oo0Var.a = this;
    }

    @Override // defpackage.nt4
    public final void e() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.k;
            if (i >= arrayList.size()) {
                return;
            }
            ((nt4) arrayList.get(i)).e();
            i++;
        }
    }

    @Override // defpackage.nt4
    public final void f() {
        this.c = null;
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            ((nt4) it.next()).f();
        }
    }

    @Override // defpackage.nt4
    public final long j() {
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            nt4 nt4Var = (nt4) arrayList.get(i);
            j = ((long) nt4Var.i.f) + nt4Var.j() + j + ((long) nt4Var.h.f);
        }
        return j;
    }

    @Override // defpackage.nt4
    public final boolean k() {
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (!((nt4) arrayList.get(i)).k()) {
                return false;
            }
        }
        return true;
    }

    public final jc0 m() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.k;
            if (i >= arrayList.size()) {
                return null;
            }
            jc0 jc0Var = ((nt4) arrayList.get(i)).b;
            if (jc0Var.f0 != 8) {
                return jc0Var;
            }
            i++;
        }
    }

    public final jc0 n() {
        ArrayList arrayList = this.k;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            jc0 jc0Var = ((nt4) arrayList.get(size)).b;
            if (jc0Var.f0 != 8) {
                return jc0Var;
            }
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.f == 0 ? "horizontal : " : "vertical : ");
        for (nt4 nt4Var : this.k) {
            sb.append("<");
            sb.append(nt4Var);
            sb.append("> ");
        }
        return sb.toString();
    }
}
