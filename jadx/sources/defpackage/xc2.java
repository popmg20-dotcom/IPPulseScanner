package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class xc2 {
    public final /* synthetic */ yc2 A;
    public final hu2 b;
    public boolean f;
    public int z = -1;

    public xc2(yc2 yc2Var, hu2 hu2Var) {
        this.A = yc2Var;
        this.b = hu2Var;
    }

    public final void a(boolean z) {
        if (z == this.f) {
            return;
        }
        this.f = z;
        int i = z ? 1 : -1;
        yc2 yc2Var = this.A;
        int i2 = yc2Var.c;
        yc2Var.c = i + i2;
        if (!yc2Var.d) {
            yc2Var.d = true;
            while (true) {
                try {
                    int i3 = yc2Var.c;
                    if (i2 == i3) {
                        break;
                    }
                    boolean z2 = i2 == 0 && i3 > 0;
                    boolean z3 = i2 > 0 && i3 == 0;
                    if (z2) {
                        yc2Var.g();
                    } else if (z3) {
                        yc2Var.h();
                    }
                    i2 = i3;
                } catch (Throwable th) {
                    yc2Var.d = false;
                    throw th;
                }
            }
            yc2Var.d = false;
        }
        if (this.f) {
            yc2Var.c(this);
        }
    }

    public boolean c(da2 da2Var) {
        return false;
    }

    public abstract boolean d();

    public void b() {
    }
}
