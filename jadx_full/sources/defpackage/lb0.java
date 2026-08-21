package defpackage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lb0 {
    public int b;
    public boolean c;
    public final jc0 d;
    public final int e;
    public lb0 f;
    public jz3 i;
    public HashSet a = null;
    public int g = 0;
    public int h = Integer.MIN_VALUE;

    public lb0(jc0 jc0Var, int i) {
        this.d = jc0Var;
        this.e = i;
    }

    public final void a(lb0 lb0Var, int i, int i2) {
        if (lb0Var == null) {
            g();
            return;
        }
        this.f = lb0Var;
        if (lb0Var.a == null) {
            lb0Var.a = new HashSet();
        }
        HashSet hashSet = this.f.a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.g = i;
        this.h = i2;
    }

    public final void b(int i, mt4 mt4Var, ArrayList arrayList) {
        HashSet hashSet = this.a;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                vf2.m(((lb0) it.next()).d, i, arrayList, mt4Var);
            }
        }
    }

    public final int c() {
        if (this.c) {
            return this.b;
        }
        return 0;
    }

    public final int d() {
        lb0 lb0Var;
        if (this.d.f0 == 8) {
            return 0;
        }
        int i = this.h;
        return (i == Integer.MIN_VALUE || (lb0Var = this.f) == null || lb0Var.d.f0 != 8) ? this.g : i;
    }

    public final boolean e() {
        lb0 lb0Var;
        HashSet<lb0> hashSet = this.a;
        if (hashSet != null) {
            for (lb0 lb0Var2 : hashSet) {
                jc0 jc0Var = lb0Var2.d;
                int i = lb0Var2.e;
                switch (fw.G(i)) {
                    case 0:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        lb0Var = null;
                        break;
                    case 1:
                        lb0Var = jc0Var.J;
                        break;
                    case 2:
                        lb0Var = jc0Var.K;
                        break;
                    case 3:
                        lb0Var = jc0Var.H;
                        break;
                    case 4:
                        lb0Var = jc0Var.I;
                        break;
                    default:
                        xe.i(ha0.A(i));
                        return false;
                }
                if (lb0Var.f()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean f() {
        return this.f != null;
    }

    public final void g() {
        HashSet hashSet;
        lb0 lb0Var = this.f;
        if (lb0Var != null && (hashSet = lb0Var.a) != null) {
            hashSet.remove(this);
            if (this.f.a.size() == 0) {
                this.f.a = null;
            }
        }
        this.a = null;
        this.f = null;
        this.g = 0;
        this.h = Integer.MIN_VALUE;
        this.c = false;
        this.b = 0;
    }

    public final void h() {
        jz3 jz3Var = this.i;
        if (jz3Var == null) {
            this.i = new jz3(1);
        } else {
            jz3Var.c();
        }
    }

    public final void i(int i) {
        this.b = i;
        this.c = true;
    }

    public final String toString() {
        return this.d.g0 + ":" + ha0.A(this.e);
    }
}
