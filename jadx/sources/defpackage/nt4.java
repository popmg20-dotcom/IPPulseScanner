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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(defpackage.lb0 r12, defpackage.lb0 r13, int r14) {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nt4.l(lb0, lb0, int):void");
    }
}
