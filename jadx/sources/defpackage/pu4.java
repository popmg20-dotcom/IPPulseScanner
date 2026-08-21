package defpackage;

import android.graphics.Rect;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class pu4 {
    public final bv4 a;
    public t02[] b;
    public final Rect[][] c;
    public final Rect[][] d;

    public pu4(bv4 bv4Var) {
        this.c = new Rect[10][];
        this.d = new Rect[10][];
        this.a = bv4Var;
        c(bv4Var);
    }

    public final void a() {
        t02[] t02VarArr = this.b;
        if (t02VarArr != null) {
            t02 t02VarH = t02VarArr[0];
            t02 t02VarH2 = t02VarArr[1];
            bv4 bv4Var = this.a;
            if (t02VarH2 == null) {
                t02VarH2 = bv4Var.a.h(2);
            }
            if (t02VarH == null) {
                t02VarH = bv4Var.a.h(1);
            }
            h(t02.a(t02VarH, t02VarH2));
            t02 t02Var = this.b[ye.C(16)];
            if (t02Var != null) {
                g(t02Var);
            }
            t02 t02Var2 = this.b[ye.C(32)];
            if (t02Var2 != null) {
                e(t02Var2);
            }
            t02 t02Var3 = this.b[ye.C(64)];
            if (t02Var3 != null) {
                i(t02Var3);
            }
        }
    }

    public abstract bv4 b();

    public void c(bv4 bv4Var) {
        for (int i = 1; i <= 512; i <<= 1) {
            List<Rect> listE = bv4Var.a.e(i);
            int iC = ye.C(i);
            this.c[iC] = (Rect[]) listE.toArray(new Rect[listE.size()]);
            if (i != 8) {
                List<Rect> listF = bv4Var.a.f(i);
                this.d[iC] = (Rect[]) listF.toArray(new Rect[listF.size()]);
            }
        }
    }

    public void d(int i, t02 t02Var) {
        if (this.b == null) {
            this.b = new t02[10];
        }
        for (int i2 = 1; i2 <= 512; i2 <<= 1) {
            if ((i & i2) != 0) {
                this.b[ye.C(i2)] = t02Var;
            }
        }
    }

    public abstract void f(t02 t02Var);

    public abstract void h(t02 t02Var);

    public pu4() {
        this(new bv4());
    }

    public void e(t02 t02Var) {
    }

    public void g(t02 t02Var) {
    }

    public void i(t02 t02Var) {
    }
}
