package defpackage;

import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qu2 {
    public final su2 a;
    public boolean b;
    public iv1 c;
    public final ru2 d;
    public boolean e;

    public qu2(ru2 ru2Var, su2 su2Var) {
        boolean z = ru2Var.b;
        this.a = su2Var;
        this.b = z;
        this.d = ru2Var;
        this.e = true;
    }

    public final void a() {
        iv1 iv1Var = this.c;
        if (iv1Var == null || !((LinkedHashSet) iv1Var.A).remove(this)) {
            return;
        }
        yp2 yp2Var = (yp2) iv1Var.z;
        if (this == yp2Var.f) {
            if (yp2Var.g == -1) {
                this.d.a();
            }
            yp2Var.f = null;
            yp2Var.g = 0;
            yp2Var.h = null;
        }
        yp2Var.d.remove(this);
        yp2Var.e.remove(this);
        this.c = null;
        yp2Var.b();
    }

    public final void b(boolean z) {
        if (this.b == z) {
            return;
        }
        this.b = z;
        iv1 iv1Var = this.c;
        if (iv1Var != null) {
            ((yp2) iv1Var.z).b();
        }
    }

    public final void c(boolean z) {
        this.e = z;
        b(z && this.d.b);
    }
}
