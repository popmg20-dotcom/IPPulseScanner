package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sx1 extends nx1 {
    public final Executor M0;
    public final Object N0 = new Object();
    public my1 O0;
    public rx1 P0;

    public sx1(Executor executor) {
        this.M0 = executor;
    }

    @Override // defpackage.nx1
    public final my1 a(oy1 oy1Var) {
        return oy1Var.i();
    }

    @Override // defpackage.nx1
    public final void c() {
        synchronized (this.N0) {
            try {
                my1 my1Var = this.O0;
                if (my1Var != null) {
                    my1Var.close();
                    this.O0 = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.nx1
    public final void e(my1 my1Var) {
        synchronized (this.N0) {
            try {
                if (!this.L0) {
                    my1Var.close();
                    return;
                }
                if (this.P0 != null) {
                    if (my1Var.g0().c() <= this.P0.f.g0().c()) {
                        my1Var.close();
                    } else {
                        my1 my1Var2 = this.O0;
                        if (my1Var2 != null) {
                            my1Var2.close();
                        }
                        this.O0 = my1Var;
                    }
                    return;
                }
                rx1 rx1Var = new rx1(my1Var, this);
                this.P0 = rx1Var;
                nc2 nc2VarB = b(rx1Var);
                ha1 ha1Var = new ha1(9, rx1Var);
                nc2VarB.a(new um1(0, nc2VarB, ha1Var), yu0.a());
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
