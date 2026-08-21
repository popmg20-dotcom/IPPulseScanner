package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ks1 extends nt4 {
    public static final int[] k = new int[2];

    public static void m(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 != -1) {
            if (i5 == 0) {
                iArr[0] = (int) ((i7 * f) + 0.5f);
                iArr[1] = i7;
                return;
            } else {
                if (i5 != 1) {
                    return;
                }
                iArr[0] = i6;
                iArr[1] = (int) ((i6 * f) + 0.5f);
                return;
            }
        }
        int i8 = (int) ((i7 * f) + 0.5f);
        int i9 = (int) ((i6 / f) + 0.5f);
        if (i8 <= i6) {
            iArr[0] = i8;
            iArr[1] = i7;
        } else if (i9 <= i7) {
            iArr[0] = i6;
            iArr[1] = i9;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
    @Override // defpackage.io0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(io0 io0Var) {
        float f;
        float f2;
        float f3;
        float f4;
        int i;
        if (fw.G(this.j) == 3) {
            jc0 jc0Var = this.b;
            l(jc0Var.H, jc0Var.J, 0);
            return;
        }
        su0 su0Var = this.e;
        boolean z = su0Var.j;
        oo0 oo0Var = this.h;
        oo0 oo0Var2 = this.i;
        if (z || this.d != 3) {
            f = 0.5f;
        } else {
            jc0 jc0Var2 = this.b;
            int i2 = jc0Var2.r;
            if (i2 == 2) {
                f = 0.5f;
                kc0 kc0Var = jc0Var2.S;
                if (kc0Var != null) {
                    if (kc0Var.d.e.j) {
                        su0Var.d((int) ((r5.g * jc0Var2.w) + 0.5f));
                    }
                }
            } else if (i2 == 3) {
                int i3 = jc0Var2.s;
                if (i3 == 0 || i3 == 3) {
                    dp4 dp4Var = jc0Var2.e;
                    oo0 oo0Var3 = dp4Var.h;
                    oo0 oo0Var4 = dp4Var.i;
                    boolean z2 = jc0Var2.H.f != null;
                    boolean z3 = jc0Var2.I.f != null;
                    boolean z4 = jc0Var2.J.f != null;
                    boolean z5 = jc0Var2.K.f != null;
                    f = 0.5f;
                    int i4 = jc0Var2.W;
                    if (z2 && z3 && z4 && z5) {
                        float f5 = jc0Var2.V;
                        boolean z6 = oo0Var3.j;
                        ArrayList arrayList = oo0Var3.l;
                        int[] iArr = k;
                        if (z6 && oo0Var4.j) {
                            if (oo0Var.c && oo0Var2.c) {
                                m(iArr, ((oo0) oo0Var.l.get(0)).g + oo0Var.f, ((oo0) oo0Var2.l.get(0)).g - oo0Var2.f, oo0Var3.g + oo0Var3.f, oo0Var4.g - oo0Var4.f, f5, i4);
                                su0Var.d(iArr[0]);
                                this.b.e.e.d(iArr[1]);
                                return;
                            }
                            return;
                        }
                        if (oo0Var.j && oo0Var2.j) {
                            if (!oo0Var3.c || !oo0Var4.c) {
                                return;
                            }
                            m(iArr, oo0Var.g + oo0Var.f, oo0Var2.g - oo0Var2.f, ((oo0) arrayList.get(0)).g + oo0Var3.f, ((oo0) oo0Var4.l.get(0)).g - oo0Var4.f, f5, i4);
                            su0Var.d(iArr[0]);
                            this.b.e.e.d(iArr[1]);
                        }
                        if (!oo0Var.c || !oo0Var2.c || !oo0Var3.c || !oo0Var4.c) {
                            return;
                        }
                        m(iArr, ((oo0) oo0Var.l.get(0)).g + oo0Var.f, ((oo0) oo0Var2.l.get(0)).g - oo0Var2.f, ((oo0) arrayList.get(0)).g + oo0Var3.f, ((oo0) oo0Var4.l.get(0)).g - oo0Var4.f, f5, i4);
                        su0Var.d(iArr[0]);
                        this.b.e.e.d(iArr[1]);
                    } else if (z2 && z4) {
                        if (!oo0Var.c || !oo0Var2.c) {
                            return;
                        }
                        float f6 = jc0Var2.V;
                        int i5 = ((oo0) oo0Var.l.get(0)).g + oo0Var.f;
                        int i6 = ((oo0) oo0Var2.l.get(0)).g - oo0Var2.f;
                        if (i4 == -1 || i4 == 0) {
                            int iG = g(i6 - i5, 0);
                            int i7 = (int) ((iG * f6) + 0.5f);
                            int iG2 = g(i7, 1);
                            if (i7 != iG2) {
                                iG = (int) ((iG2 / f6) + 0.5f);
                            }
                            su0Var.d(iG);
                            this.b.e.e.d(iG2);
                        } else if (i4 == 1) {
                            int iG3 = g(i6 - i5, 0);
                            int i8 = (int) ((iG3 / f6) + 0.5f);
                            int iG4 = g(i8, 1);
                            if (i8 != iG4) {
                                iG3 = (int) ((iG4 * f6) + 0.5f);
                            }
                            su0Var.d(iG3);
                            this.b.e.e.d(iG4);
                        }
                    } else if (z3 && z5) {
                        if (!oo0Var3.c || !oo0Var4.c) {
                            return;
                        }
                        float f7 = jc0Var2.V;
                        int i9 = ((oo0) oo0Var3.l.get(0)).g + oo0Var3.f;
                        int i10 = ((oo0) oo0Var4.l.get(0)).g - oo0Var4.f;
                        if (i4 == -1) {
                            int iG5 = g(i10 - i9, 1);
                            int i11 = (int) ((iG5 / f7) + 0.5f);
                            int iG6 = g(i11, 0);
                            if (i11 != iG6) {
                                iG5 = (int) ((iG6 * f7) + 0.5f);
                            }
                            su0Var.d(iG6);
                            this.b.e.e.d(iG5);
                        } else if (i4 == 0) {
                            int iG7 = g(i10 - i9, 1);
                            int i12 = (int) ((iG7 * f7) + 0.5f);
                            int iG8 = g(i12, 0);
                            if (i12 != iG8) {
                                iG7 = (int) ((iG8 / f7) + 0.5f);
                            }
                            su0Var.d(iG8);
                            this.b.e.e.d(iG7);
                        } else if (i4 == 1) {
                        }
                    }
                } else {
                    int i13 = jc0Var2.W;
                    if (i13 == -1) {
                        f2 = jc0Var2.e.e.g;
                        f3 = jc0Var2.V;
                    } else if (i13 == 0) {
                        f4 = jc0Var2.e.e.g / jc0Var2.V;
                        i = (int) (f4 + 0.5f);
                        su0Var.d(i);
                        f = 0.5f;
                    } else if (i13 != 1) {
                        i = 0;
                        su0Var.d(i);
                        f = 0.5f;
                    } else {
                        f2 = jc0Var2.e.e.g;
                        f3 = jc0Var2.V;
                    }
                    f4 = f2 * f3;
                    i = (int) (f4 + 0.5f);
                    su0Var.d(i);
                    f = 0.5f;
                }
            }
        }
        boolean z7 = oo0Var.c;
        ArrayList arrayList2 = oo0Var.l;
        if (z7) {
            boolean z8 = oo0Var2.c;
            ArrayList arrayList3 = oo0Var2.l;
            if (z8) {
                if (oo0Var.j && oo0Var2.j && su0Var.j) {
                    return;
                }
                if (!su0Var.j && this.d == 3) {
                    jc0 jc0Var3 = this.b;
                    if (jc0Var3.r == 0 && !jc0Var3.v()) {
                        oo0 oo0Var5 = (oo0) arrayList2.get(0);
                        oo0 oo0Var6 = (oo0) arrayList3.get(0);
                        int i14 = oo0Var5.g + oo0Var.f;
                        int i15 = oo0Var6.g + oo0Var2.f;
                        oo0Var.d(i14);
                        oo0Var2.d(i15);
                        su0Var.d(i15 - i14);
                        return;
                    }
                }
                if (!su0Var.j && this.d == 3 && this.a == 1 && arrayList2.size() > 0 && arrayList3.size() > 0) {
                    int iMin = Math.min((((oo0) arrayList3.get(0)).g + oo0Var2.f) - (((oo0) arrayList2.get(0)).g + oo0Var.f), su0Var.m);
                    jc0 jc0Var4 = this.b;
                    int i16 = jc0Var4.v;
                    int iMax = Math.max(jc0Var4.u, iMin);
                    if (i16 > 0) {
                        iMax = Math.min(i16, iMax);
                    }
                    su0Var.d(iMax);
                }
                if (su0Var.j) {
                    oo0 oo0Var7 = (oo0) arrayList2.get(0);
                    oo0 oo0Var8 = (oo0) arrayList3.get(0);
                    int i17 = oo0Var7.g;
                    int i18 = oo0Var.f + i17;
                    int i19 = oo0Var8.g;
                    int i20 = oo0Var2.f + i19;
                    float f8 = this.b.c0;
                    if (oo0Var7 == oo0Var8) {
                        f8 = f;
                    } else {
                        i17 = i18;
                        i19 = i20;
                    }
                    oo0Var.d((int) ((((i19 - i17) - su0Var.g) * f8) + i17 + f));
                    oo0Var2.d(oo0Var.g + su0Var.g);
                }
            }
        }
    }

    @Override // defpackage.nt4
    public final void d() {
        jc0 jc0Var;
        kc0 kc0Var;
        int i;
        kc0 kc0Var2;
        kc0 kc0Var3;
        int i2;
        jc0 jc0Var2 = this.b;
        boolean z = jc0Var2.a;
        su0 su0Var = this.e;
        if (z) {
            su0Var.d(jc0Var2.o());
        }
        boolean z2 = su0Var.j;
        ArrayList arrayList = su0Var.k;
        ArrayList arrayList2 = su0Var.l;
        oo0 oo0Var = this.i;
        oo0 oo0Var2 = this.h;
        if (!z2) {
            jc0 jc0Var3 = this.b;
            int i3 = jc0Var3.o0[0];
            this.d = i3;
            if (i3 != 3) {
                if (i3 == 4 && (kc0Var3 = jc0Var3.S) != null && ((i2 = kc0Var3.o0[0]) == 1 || i2 == 4)) {
                    int iO = (kc0Var3.o() - this.b.H.d()) - this.b.J.d();
                    nt4.b(oo0Var2, kc0Var3.d.h, this.b.H.d());
                    nt4.b(oo0Var, kc0Var3.d.i, -this.b.J.d());
                    su0Var.d(iO);
                    return;
                }
                if (i3 == 1) {
                    su0Var.d(jc0Var3.o());
                }
            }
        } else if (this.d == 4 && (kc0Var = (jc0Var = this.b).S) != null && ((i = kc0Var.o0[0]) == 1 || i == 4)) {
            nt4.b(oo0Var2, kc0Var.d.h, jc0Var.H.d());
            nt4.b(oo0Var, kc0Var.d.i, -this.b.J.d());
            return;
        }
        if (su0Var.j) {
            jc0 jc0Var4 = this.b;
            if (jc0Var4.a) {
                lb0[] lb0VarArr = jc0Var4.P;
                lb0 lb0Var = lb0VarArr[0];
                lb0 lb0Var2 = lb0Var.f;
                if (lb0Var2 != null && lb0VarArr[1].f != null) {
                    boolean zV = jc0Var4.v();
                    jc0 jc0Var5 = this.b;
                    if (zV) {
                        oo0Var2.f = jc0Var5.P[0].d();
                        oo0Var.f = -this.b.P[1].d();
                        return;
                    }
                    oo0 oo0VarH = nt4.h(jc0Var5.P[0]);
                    if (oo0VarH != null) {
                        nt4.b(oo0Var2, oo0VarH, this.b.P[0].d());
                    }
                    oo0 oo0VarH2 = nt4.h(this.b.P[1]);
                    if (oo0VarH2 != null) {
                        nt4.b(oo0Var, oo0VarH2, -this.b.P[1].d());
                    }
                    oo0Var2.b = true;
                    oo0Var.b = true;
                    return;
                }
                if (lb0Var2 != null) {
                    oo0 oo0VarH3 = nt4.h(lb0Var);
                    if (oo0VarH3 != null) {
                        nt4.b(oo0Var2, oo0VarH3, this.b.P[0].d());
                        nt4.b(oo0Var, oo0Var2, su0Var.g);
                        return;
                    }
                    return;
                }
                lb0 lb0Var3 = lb0VarArr[1];
                if (lb0Var3.f != null) {
                    oo0 oo0VarH4 = nt4.h(lb0Var3);
                    if (oo0VarH4 != null) {
                        nt4.b(oo0Var, oo0VarH4, -this.b.P[1].d());
                        nt4.b(oo0Var2, oo0Var, -su0Var.g);
                        return;
                    }
                    return;
                }
                if ((jc0Var4 instanceof wj) || jc0Var4.S == null || jc0Var4.g(7).f != null) {
                    return;
                }
                jc0 jc0Var6 = this.b;
                nt4.b(oo0Var2, jc0Var6.S.d.h, jc0Var6.p());
                nt4.b(oo0Var, oo0Var2, su0Var.g);
                return;
            }
        }
        if (this.d == 3) {
            jc0 jc0Var7 = this.b;
            int i4 = jc0Var7.r;
            if (i4 == 2) {
                kc0 kc0Var4 = jc0Var7.S;
                if (kc0Var4 != null) {
                    su0 su0Var2 = kc0Var4.e.e;
                    arrayList2.add(su0Var2);
                    su0Var2.k.add(su0Var);
                    su0Var.b = true;
                    arrayList.add(oo0Var2);
                    arrayList.add(oo0Var);
                }
            } else if (i4 == 3) {
                if (jc0Var7.s == 3) {
                    oo0Var2.a = this;
                    oo0Var.a = this;
                    dp4 dp4Var = jc0Var7.e;
                    dp4Var.h.a = this;
                    dp4Var.i.a = this;
                    su0Var.a = this;
                    if (jc0Var7.w()) {
                        arrayList2.add(this.b.e.e);
                        this.b.e.e.k.add(su0Var);
                        dp4 dp4Var2 = this.b.e;
                        dp4Var2.e.a = this;
                        arrayList2.add(dp4Var2.h);
                        arrayList2.add(this.b.e.i);
                        this.b.e.h.k.add(su0Var);
                        this.b.e.i.k.add(su0Var);
                    } else {
                        boolean zV2 = this.b.v();
                        jc0 jc0Var8 = this.b;
                        if (zV2) {
                            jc0Var8.e.e.l.add(su0Var);
                            arrayList.add(this.b.e.e);
                        } else {
                            jc0Var8.e.e.l.add(su0Var);
                        }
                    }
                } else {
                    su0 su0Var3 = jc0Var7.e.e;
                    arrayList2.add(su0Var3);
                    su0Var3.k.add(su0Var);
                    this.b.e.h.k.add(su0Var);
                    this.b.e.i.k.add(su0Var);
                    su0Var.b = true;
                    arrayList.add(oo0Var2);
                    arrayList.add(oo0Var);
                    oo0Var2.l.add(su0Var);
                    oo0Var.l.add(su0Var);
                }
            }
        }
        jc0 jc0Var9 = this.b;
        lb0[] lb0VarArr2 = jc0Var9.P;
        lb0 lb0Var4 = lb0VarArr2[0];
        lb0 lb0Var5 = lb0Var4.f;
        if (lb0Var5 != null && lb0VarArr2[1].f != null) {
            boolean zV3 = jc0Var9.v();
            jc0 jc0Var10 = this.b;
            if (zV3) {
                oo0Var2.f = jc0Var10.P[0].d();
                oo0Var.f = -this.b.P[1].d();
                return;
            }
            oo0 oo0VarH5 = nt4.h(jc0Var10.P[0]);
            oo0 oo0VarH6 = nt4.h(this.b.P[1]);
            if (oo0VarH5 != null) {
                oo0VarH5.b(this);
            }
            if (oo0VarH6 != null) {
                oo0VarH6.b(this);
            }
            this.j = 4;
            return;
        }
        if (lb0Var5 != null) {
            oo0 oo0VarH7 = nt4.h(lb0Var4);
            if (oo0VarH7 != null) {
                nt4.b(oo0Var2, oo0VarH7, this.b.P[0].d());
                c(oo0Var, oo0Var2, 1, su0Var);
                return;
            }
            return;
        }
        lb0 lb0Var6 = lb0VarArr2[1];
        if (lb0Var6.f != null) {
            oo0 oo0VarH8 = nt4.h(lb0Var6);
            if (oo0VarH8 != null) {
                nt4.b(oo0Var, oo0VarH8, -this.b.P[1].d());
                c(oo0Var2, oo0Var, -1, su0Var);
                return;
            }
            return;
        }
        if ((jc0Var9 instanceof wj) || (kc0Var2 = jc0Var9.S) == null) {
            return;
        }
        nt4.b(oo0Var2, kc0Var2.d.h, jc0Var9.p());
        c(oo0Var, oo0Var2, 1, su0Var);
    }

    @Override // defpackage.nt4
    public final void e() {
        oo0 oo0Var = this.h;
        if (oo0Var.j) {
            this.b.X = oo0Var.g;
        }
    }

    @Override // defpackage.nt4
    public final void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.e.c();
        this.g = false;
    }

    @Override // defpackage.nt4
    public final boolean k() {
        return this.d != 3 || this.b.r == 0;
    }

    public final void n() {
        this.g = false;
        oo0 oo0Var = this.h;
        oo0Var.c();
        oo0Var.j = false;
        oo0 oo0Var2 = this.i;
        oo0Var2.c();
        oo0Var2.j = false;
        this.e.j = false;
    }

    public final String toString() {
        return "HorizontalRun " + this.b.g0;
    }
}
