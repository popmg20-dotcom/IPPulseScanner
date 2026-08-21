package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class nt4 implements io0 {
    public int a;
    public jc0 b;
    public yn3 c;
    public int d;
    public final su0 e = new su0(this);
    public int f = 0;
    public boolean g = false;
    public final oo0 h = new oo0(this);
    public final oo0 i = new oo0(this);
    public int j = 1;

    public nt4(jc0 jc0Var) {
        this.b = jc0Var;
    }

    public static void b(oo0 oo0Var, oo0 oo0Var2, int i) {
        oo0Var.l.add(oo0Var2);
        oo0Var.f = i;
        oo0Var2.k.add(oo0Var);
    }

    public static oo0 h(lb0 lb0Var) {
        lb0 lb0Var2 = lb0Var.f;
        if (lb0Var2 == null) {
            return null;
        }
        jc0 jc0Var = lb0Var2.d;
        int iG = fw.G(lb0Var2.e);
        if (iG == 1) {
            return jc0Var.d.h;
        }
        if (iG == 2) {
            return jc0Var.e.h;
        }
        if (iG == 3) {
            return jc0Var.d.i;
        }
        if (iG == 4) {
            return jc0Var.e.i;
        }
        if (iG != 5) {
            return null;
        }
        return jc0Var.e.k;
    }

    public static oo0 i(lb0 lb0Var, int i) {
        lb0 lb0Var2 = lb0Var.f;
        if (lb0Var2 == null) {
            return null;
        }
        jc0 jc0Var = lb0Var2.d;
        nt4 nt4Var = i == 0 ? jc0Var.d : jc0Var.e;
        int iG = fw.G(lb0Var2.e);
        if (iG == 1 || iG == 2) {
            return nt4Var.h;
        }
        if (iG == 3 || iG == 4) {
            return nt4Var.i;
        }
        return null;
    }

    public final void c(oo0 oo0Var, oo0 oo0Var2, int i, su0 su0Var) {
        oo0Var.l.add(oo0Var2);
        oo0Var.l.add(this.e);
        oo0Var.h = i;
        oo0Var.i = su0Var;
        oo0Var2.k.add(oo0Var);
        su0Var.k.add(oo0Var);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i, int i2) {
        jc0 jc0Var = this.b;
        if (i2 == 0) {
            int i3 = jc0Var.v;
            int iMax = Math.max(jc0Var.u, i);
            if (i3 > 0) {
                iMax = Math.min(i3, i);
            }
            if (iMax != i) {
                return iMax;
            }
        } else {
            int i4 = jc0Var.y;
            int iMax2 = Math.max(jc0Var.x, i);
            if (i4 > 0) {
                iMax2 = Math.min(i4, i);
            }
            if (iMax2 != i) {
                return iMax2;
            }
        }
        return i;
    }

    public long j() {
        if (this.e.j) {
            return r2.g;
        }
        return 0L;
    }

    public abstract boolean k();

    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l(lb0 lb0Var, lb0 lb0Var2, int i) {
        oo0 oo0VarH = h(lb0Var);
        oo0 oo0VarH2 = h(lb0Var2);
        if (oo0VarH.j && oo0VarH2.j) {
            int iD = lb0Var.d() + oo0VarH.g;
            int iD2 = oo0VarH2.g - lb0Var2.d();
            int i2 = iD2 - iD;
            su0 su0Var = this.e;
            if (!su0Var.j && this.d == 3) {
                int i3 = this.a;
                if (i3 == 0) {
                    su0Var.d(g(i2, i));
                } else if (i3 == 1) {
                    su0Var.d(Math.min(g(su0Var.m, i), i2));
                } else if (i3 == 2) {
                    jc0 jc0Var = this.b;
                    kc0 kc0Var = jc0Var.S;
                    if (kc0Var != null) {
                        if ((i == 0 ? kc0Var.d : kc0Var.e).e.j) {
                            su0Var.d(g((int) ((r6.g * (i == 0 ? jc0Var.w : jc0Var.z)) + 0.5f), i));
                        }
                    }
                } else if (i3 == 3) {
                    jc0 jc0Var2 = this.b;
                    nt4 nt4Var = jc0Var2.d;
                    if (nt4Var.d == 3 && nt4Var.a == 3) {
                        dp4 dp4Var = jc0Var2.e;
                        if (dp4Var.d != 3 || dp4Var.a != 3) {
                        }
                    } else {
                        if (i == 0) {
                            nt4Var = jc0Var2.e;
                        }
                        su0 su0Var2 = nt4Var.e;
                        if (su0Var2.j) {
                            float f = jc0Var2.V;
                            int i4 = su0Var2.g;
                            su0Var.d(i == 1 ? (int) ((i4 / f) + 0.5f) : (int) ((f * i4) + 0.5f));
                        }
                    }
                }
            }
            if (su0Var.j) {
                int i5 = su0Var.g;
                oo0 oo0Var = this.i;
                oo0 oo0Var2 = this.h;
                if (i5 == i2) {
                    oo0Var2.d(iD);
                    oo0Var.d(iD2);
                    return;
                }
                jc0 jc0Var3 = this.b;
                float f2 = i == 0 ? jc0Var3.c0 : jc0Var3.d0;
                if (oo0VarH == oo0VarH2) {
                    iD = oo0VarH.g;
                    iD2 = oo0VarH2.g;
                    f2 = 0.5f;
                }
                oo0Var2.d((int) ((((iD2 - iD) - i5) * f2) + iD + 0.5f));
                oo0Var.d(oo0Var2.g + su0Var.g);
            }
        }
    }
}
