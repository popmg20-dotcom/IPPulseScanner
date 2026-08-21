package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ir4 implements jj3 {
    public final r92 A;
    public final v32 X;
    public final te3 b;
    public final ry1 f;
    public final ty1 z;

    public ir4(te3 te3Var, ry1 ry1Var, ty1 ty1Var, r92 r92Var, v32 v32Var) {
        this.b = te3Var;
        this.f = ry1Var;
        this.z = ty1Var;
        this.A = r92Var;
        this.X = v32Var;
    }

    @Override // defpackage.jj3
    public final void g() {
        ty1 ty1Var = this.z;
        if (ty1Var.f.isAttachedToWindow()) {
            return;
        }
        jr4 jr4VarC = j.c(ty1Var.f);
        ir4 ir4Var = jr4VarC.z;
        if (ir4Var != null) {
            r92 r92Var = ir4Var.A;
            ir4Var.X.g(null);
            ty1 ty1Var2 = ir4Var.z;
            if (ty1Var2 instanceof ca2) {
                r92Var.c(ty1Var2);
            }
            r92Var.c(ir4Var);
        }
        jr4VarC.z = this;
        throw new CancellationException("'ViewTarget.view' must be attached to a window.");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onCreate(da2 da2Var) {
        da2Var.getClass();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onDestroy(da2 da2Var) {
        jr4 jr4VarC = j.c(this.z.f);
        synchronized (jr4VarC) {
            try {
                z14 z14Var = jr4VarC.f;
                ge0 ge0Var = null;
                if (z14Var != null) {
                    z14Var.g(null);
                }
                gp1 gp1Var = gp1.b;
                gm0 gm0Var = qv0.a;
                jr4VarC.f = ji0.B(gp1Var, qf2.a.X, null, new gt(jr4VarC, ge0Var, 11), 2);
                jr4VarC.b = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onPause(da2 da2Var) {
        da2Var.getClass();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onResume(da2 da2Var) {
        da2Var.getClass();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStart(da2 da2Var) {
        da2Var.getClass();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStop(da2 da2Var) {
        da2Var.getClass();
    }

    @Override // defpackage.jj3
    public final void start() {
        r92 r92Var = this.A;
        r92Var.a(this);
        ty1 ty1Var = this.z;
        if (ty1Var instanceof ca2) {
            ty1 ty1Var2 = ty1Var;
            r92Var.c(ty1Var2);
            r92Var.a(ty1Var2);
        }
        jr4 jr4VarC = j.c(ty1Var.f);
        ir4 ir4Var = jr4VarC.z;
        if (ir4Var != null) {
            r92 r92Var2 = ir4Var.A;
            ir4Var.X.g(null);
            ty1 ty1Var3 = ir4Var.z;
            if (ty1Var3 instanceof ca2) {
                r92Var2.c(ty1Var3);
            }
            r92Var2.c(ir4Var);
        }
        jr4VarC.z = this;
    }

    @Override // defpackage.jj3
    public final void s() {
    }
}
