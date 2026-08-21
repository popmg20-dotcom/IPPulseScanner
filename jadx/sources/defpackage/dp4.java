package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dp4 extends nt4 {
    public oo0 k;
    public tl l;

    @Override // defpackage.io0
    public final void a(io0 io0Var) {
        float f;
        float f2;
        float f3;
        int i;
        if (fw.G(this.j) == 3) {
            jc0 jc0Var = this.b;
            l(jc0Var.I, jc0Var.K, 1);
            return;
        }
        su0 su0Var = this.e;
        if (su0Var.c && !su0Var.j && this.d == 3) {
            jc0 jc0Var2 = this.b;
            int i2 = jc0Var2.s;
            if (i2 == 2) {
                kc0 kc0Var = jc0Var2.S;
                if (kc0Var != null) {
                    if (kc0Var.e.e.j) {
                        su0Var.d((int) ((r5.g * jc0Var2.z) + 0.5f));
                    }
                }
            } else if (i2 == 3) {
                su0 su0Var2 = jc0Var2.d.e;
                if (su0Var2.j) {
                    int i3 = jc0Var2.W;
                    if (i3 == -1) {
                        f = su0Var2.g;
                        f2 = jc0Var2.V;
                    } else if (i3 == 0) {
                        f3 = su0Var2.g * jc0Var2.V;
                        i = (int) (f3 + 0.5f);
                        su0Var.d(i);
                    } else if (i3 != 1) {
                        i = 0;
                        su0Var.d(i);
                    } else {
                        f = su0Var2.g;
                        f2 = jc0Var2.V;
                    }
                    f3 = f / f2;
                    i = (int) (f3 + 0.5f);
                    su0Var.d(i);
                }
            }
        }
        oo0 oo0Var = this.h;
        boolean z = oo0Var.c;
        ArrayList arrayList = oo0Var.l;
        if (z) {
            oo0 oo0Var2 = this.i;
            boolean z2 = oo0Var2.c;
            ArrayList arrayList2 = oo0Var2.l;
            if (z2) {
                if (oo0Var.j && oo0Var2.j && su0Var.j) {
                    return;
                }
                if (!su0Var.j && this.d == 3) {
                    jc0 jc0Var3 = this.b;
                    if (jc0Var3.r == 0 && !jc0Var3.w()) {
                        oo0 oo0Var3 = (oo0) arrayList.get(0);
                        oo0 oo0Var4 = (oo0) arrayList2.get(0);
                        int i4 = oo0Var3.g + oo0Var.f;
                        int i5 = oo0Var4.g + oo0Var2.f;
                        oo0Var.d(i4);
                        oo0Var2.d(i5);
                        su0Var.d(i5 - i4);
                        return;
                    }
                }
                if (!su0Var.j && this.d == 3 && this.a == 1 && arrayList.size() > 0 && arrayList2.size() > 0) {
                    oo0 oo0Var5 = (oo0) arrayList.get(0);
                    int i6 = (((oo0) arrayList2.get(0)).g + oo0Var2.f) - (oo0Var5.g + oo0Var.f);
                    int i7 = su0Var.m;
                    if (i6 < i7) {
                        su0Var.d(i6);
                    } else {
                        su0Var.d(i7);
                    }
                }
                if (su0Var.j && arrayList.size() > 0 && arrayList2.size() > 0) {
                    oo0 oo0Var6 = (oo0) arrayList.get(0);
                    oo0 oo0Var7 = (oo0) arrayList2.get(0);
                    int i8 = oo0Var6.g;
                    int i9 = oo0Var.f + i8;
                    int i10 = oo0Var7.g;
                    int i11 = oo0Var2.f + i10;
                    float f4 = this.b.d0;
                    if (oo0Var6 == oo0Var7) {
                        f4 = 0.5f;
                    } else {
                        i8 = i9;
                        i10 = i11;
                    }
                    oo0Var.d((int) ((((i10 - i8) - su0Var.g) * f4) + i8 + 0.5f));
                    oo0Var2.d(oo0Var.g + su0Var.g);
                }
            }
        }
    }

    @Override // defpackage.nt4
    public final void d() {
        jc0 jc0Var;
        kc0 kc0Var;
        kc0 kc0Var2;
        kc0 kc0Var3;
        oo0 oo0Var = this.k;
        jc0 jc0Var2 = this.b;
        boolean z = jc0Var2.a;
        su0 su0Var = this.e;
        if (z) {
            su0Var.d(jc0Var2.i());
        }
        boolean z2 = su0Var.j;
        ArrayList arrayList = su0Var.k;
        ArrayList arrayList2 = su0Var.l;
        oo0 oo0Var2 = this.i;
        oo0 oo0Var3 = this.h;
        if (!z2) {
            jc0 jc0Var3 = this.b;
            this.d = jc0Var3.o0[1];
            if (jc0Var3.E) {
                this.l = new tl(this);
            }
            int i = this.d;
            if (i != 3) {
                if (i == 4 && (kc0Var3 = this.b.S) != null && kc0Var3.o0[1] == 1) {
                    int i2 = (kc0Var3.i() - this.b.I.d()) - this.b.K.d();
                    nt4.b(oo0Var3, kc0Var3.e.h, this.b.I.d());
                    nt4.b(oo0Var2, kc0Var3.e.i, -this.b.K.d());
                    su0Var.d(i2);
                    return;
                }
                if (i == 1) {
                    su0Var.d(this.b.i());
                }
            }
        } else if (this.d == 4 && (kc0Var = (jc0Var = this.b).S) != null && kc0Var.o0[1] == 1) {
            nt4.b(oo0Var3, kc0Var.e.h, jc0Var.I.d());
            nt4.b(oo0Var2, kc0Var.e.i, -this.b.K.d());
            return;
        }
        boolean z3 = su0Var.j;
        if (z3) {
            jc0 jc0Var4 = this.b;
            if (jc0Var4.a) {
                lb0[] lb0VarArr = jc0Var4.P;
                lb0 lb0Var = lb0VarArr[2];
                lb0 lb0Var2 = lb0Var.f;
                if (lb0Var2 != null && lb0VarArr[3].f != null) {
                    boolean zW = jc0Var4.w();
                    jc0 jc0Var5 = this.b;
                    if (zW) {
                        oo0Var3.f = jc0Var5.P[2].d();
                        oo0Var2.f = -this.b.P[3].d();
                    } else {
                        oo0 oo0VarH = nt4.h(jc0Var5.P[2]);
                        if (oo0VarH != null) {
                            nt4.b(oo0Var3, oo0VarH, this.b.P[2].d());
                        }
                        oo0 oo0VarH2 = nt4.h(this.b.P[3]);
                        if (oo0VarH2 != null) {
                            nt4.b(oo0Var2, oo0VarH2, -this.b.P[3].d());
                        }
                        oo0Var3.b = true;
                        oo0Var2.b = true;
                    }
                    jc0 jc0Var6 = this.b;
                    if (jc0Var6.E) {
                        nt4.b(oo0Var, oo0Var3, jc0Var6.Z);
                        return;
                    }
                    return;
                }
                if (lb0Var2 != null) {
                    oo0 oo0VarH3 = nt4.h(lb0Var);
                    if (oo0VarH3 != null) {
                        nt4.b(oo0Var3, oo0VarH3, this.b.P[2].d());
                        nt4.b(oo0Var2, oo0Var3, su0Var.g);
                        jc0 jc0Var7 = this.b;
                        if (jc0Var7.E) {
                            nt4.b(oo0Var, oo0Var3, jc0Var7.Z);
                            return;
                        }
                        return;
                    }
                    return;
                }
                lb0 lb0Var3 = lb0VarArr[3];
                if (lb0Var3.f != null) {
                    oo0 oo0VarH4 = nt4.h(lb0Var3);
                    if (oo0VarH4 != null) {
                        nt4.b(oo0Var2, oo0VarH4, -this.b.P[3].d());
                        nt4.b(oo0Var3, oo0Var2, -su0Var.g);
                    }
                    jc0 jc0Var8 = this.b;
                    if (jc0Var8.E) {
                        nt4.b(oo0Var, oo0Var3, jc0Var8.Z);
                        return;
                    }
                    return;
                }
                lb0 lb0Var4 = lb0VarArr[4];
                if (lb0Var4.f != null) {
                    oo0 oo0VarH5 = nt4.h(lb0Var4);
                    if (oo0VarH5 != null) {
                        nt4.b(oo0Var, oo0VarH5, 0);
                        nt4.b(oo0Var3, oo0Var, -this.b.Z);
                        nt4.b(oo0Var2, oo0Var3, su0Var.g);
                        return;
                    }
                    return;
                }
                if ((jc0Var4 instanceof wj) || jc0Var4.S == null || jc0Var4.g(7).f != null) {
                    return;
                }
                jc0 jc0Var9 = this.b;
                nt4.b(oo0Var3, jc0Var9.S.e.h, jc0Var9.q());
                nt4.b(oo0Var2, oo0Var3, su0Var.g);
                jc0 jc0Var10 = this.b;
                if (jc0Var10.E) {
                    nt4.b(oo0Var, oo0Var3, jc0Var10.Z);
                    return;
                }
                return;
            }
        }
        if (z3 || this.d != 3) {
            su0Var.b(this);
        } else {
            jc0 jc0Var11 = this.b;
            int i3 = jc0Var11.s;
            if (i3 == 2) {
                kc0 kc0Var4 = jc0Var11.S;
                if (kc0Var4 != null) {
                    su0 su0Var2 = kc0Var4.e.e;
                    arrayList2.add(su0Var2);
                    su0Var2.k.add(su0Var);
                    su0Var.b = true;
                    arrayList.add(oo0Var3);
                    arrayList.add(oo0Var2);
                }
            } else if (i3 == 3 && !jc0Var11.w()) {
                jc0 jc0Var12 = this.b;
                if (jc0Var12.r != 3) {
                    su0 su0Var3 = jc0Var12.d.e;
                    arrayList2.add(su0Var3);
                    su0Var3.k.add(su0Var);
                    su0Var.b = true;
                    arrayList.add(oo0Var3);
                    arrayList.add(oo0Var2);
                }
            }
        }
        jc0 jc0Var13 = this.b;
        lb0[] lb0VarArr2 = jc0Var13.P;
        lb0 lb0Var5 = lb0VarArr2[2];
        lb0 lb0Var6 = lb0Var5.f;
        if (lb0Var6 != null && lb0VarArr2[3].f != null) {
            boolean zW2 = jc0Var13.w();
            jc0 jc0Var14 = this.b;
            if (zW2) {
                oo0Var3.f = jc0Var14.P[2].d();
                oo0Var2.f = -this.b.P[3].d();
            } else {
                oo0 oo0VarH6 = nt4.h(jc0Var14.P[2]);
                oo0 oo0VarH7 = nt4.h(this.b.P[3]);
                if (oo0VarH6 != null) {
                    oo0VarH6.b(this);
                }
                if (oo0VarH7 != null) {
                    oo0VarH7.b(this);
                }
                this.j = 4;
            }
            if (this.b.E) {
                c(oo0Var, oo0Var3, 1, this.l);
            }
        } else if (lb0Var6 != null) {
            oo0 oo0VarH8 = nt4.h(lb0Var5);
            if (oo0VarH8 != null) {
                nt4.b(oo0Var3, oo0VarH8, this.b.P[2].d());
                c(oo0Var2, oo0Var3, 1, su0Var);
                if (this.b.E) {
                    c(oo0Var, oo0Var3, 1, this.l);
                }
                if (this.d == 3) {
                    jc0 jc0Var15 = this.b;
                    if (jc0Var15.V > 0.0f) {
                        ks1 ks1Var = jc0Var15.d;
                        if (ks1Var.d == 3) {
                            ks1Var.e.k.add(su0Var);
                            arrayList2.add(this.b.d.e);
                            su0Var.a = this;
                        }
                    }
                }
            }
        } else {
            lb0 lb0Var7 = lb0VarArr2[3];
            if (lb0Var7.f != null) {
                oo0 oo0VarH9 = nt4.h(lb0Var7);
                if (oo0VarH9 != null) {
                    nt4.b(oo0Var2, oo0VarH9, -this.b.P[3].d());
                    c(oo0Var3, oo0Var2, -1, su0Var);
                    if (this.b.E) {
                        c(oo0Var, oo0Var3, 1, this.l);
                    }
                }
            } else {
                lb0 lb0Var8 = lb0VarArr2[4];
                if (lb0Var8.f != null) {
                    oo0 oo0VarH10 = nt4.h(lb0Var8);
                    if (oo0VarH10 != null) {
                        nt4.b(oo0Var, oo0VarH10, 0);
                        c(oo0Var3, oo0Var, -1, this.l);
                        c(oo0Var2, oo0Var3, 1, su0Var);
                    }
                } else if (!(jc0Var13 instanceof wj) && (kc0Var2 = jc0Var13.S) != null) {
                    nt4.b(oo0Var3, kc0Var2.e.h, jc0Var13.q());
                    c(oo0Var2, oo0Var3, 1, su0Var);
                    if (this.b.E) {
                        c(oo0Var, oo0Var3, 1, this.l);
                    }
                    if (this.d == 3) {
                        jc0 jc0Var16 = this.b;
                        if (jc0Var16.V > 0.0f) {
                            ks1 ks1Var2 = jc0Var16.d;
                            if (ks1Var2.d == 3) {
                                ks1Var2.e.k.add(su0Var);
                                arrayList2.add(this.b.d.e);
                                su0Var.a = this;
                            }
                        }
                    }
                }
            }
        }
        if (arrayList2.size() == 0) {
            su0Var.c = true;
        }
    }

    @Override // defpackage.nt4
    public final void e() {
        oo0 oo0Var = this.h;
        if (oo0Var.j) {
            this.b.Y = oo0Var.g;
        }
    }

    @Override // defpackage.nt4
    public final void f() {
        this.c = null;
        this.h.c();
        this.i.c();
        this.k.c();
        this.e.c();
        this.g = false;
    }

    @Override // defpackage.nt4
    public final boolean k() {
        return this.d != 3 || this.b.s == 0;
    }

    public final void m() {
        this.g = false;
        oo0 oo0Var = this.h;
        oo0Var.c();
        oo0Var.j = false;
        oo0 oo0Var2 = this.i;
        oo0Var2.c();
        oo0Var2.j = false;
        oo0 oo0Var3 = this.k;
        oo0Var3.c();
        oo0Var3.j = false;
        this.e.j = false;
    }

    public final String toString() {
        return "VerticalRun " + this.b.g0;
    }
}
