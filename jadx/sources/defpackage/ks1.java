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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(defpackage.io0 r24) {
        /*
            Method dump skipped, instruction units count: 901
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ks1.a(io0):void");
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
