package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v1 extends yr2 {
    @Override // defpackage.yr2
    public final boolean d(x1 x1Var, s1 s1Var, s1 s1Var2) {
        synchronized (x1Var) {
            try {
                if (x1Var.f != s1Var) {
                    return false;
                }
                x1Var.f = s1Var2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.yr2
    public final void d0(w1 w1Var, w1 w1Var2) {
        w1Var.b = w1Var2;
    }

    @Override // defpackage.yr2
    public final boolean e(x1 x1Var, Object obj, Object obj2) {
        synchronized (x1Var) {
            try {
                if (x1Var.b != obj) {
                    return false;
                }
                x1Var.b = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.yr2
    public final void e0(w1 w1Var, Thread thread) {
        w1Var.a = thread;
    }

    @Override // defpackage.yr2
    public final boolean f(x1 x1Var, w1 w1Var, w1 w1Var2) {
        synchronized (x1Var) {
            try {
                if (x1Var.z != w1Var) {
                    return false;
                }
                x1Var.z = w1Var2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
