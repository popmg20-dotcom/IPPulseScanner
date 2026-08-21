package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class tq1 extends ef0 implements on0 {
    public final boolean A;
    public final tq1 X;
    public final Handler z;

    public tq1(Handler handler, boolean z) {
        this.z = handler;
        this.A = z;
        this.X = z ? this : new tq1(handler, true);
    }

    @Override // defpackage.on0
    public final zv0 I(long j, final Runnable runnable, cf0 cf0Var) {
        if (j > 4611686018427387903L) {
            j = 4611686018427387903L;
        }
        if (this.z.postDelayed(runnable, j)) {
            return new zv0() { // from class: sq1
                @Override // defpackage.zv0
                public final void c() {
                    this.b.z.removeCallbacks(runnable);
                }
            };
        }
        x0(cf0Var, runnable);
        return js2.b;
    }

    @Override // defpackage.on0
    public final void U(long j, z00 z00Var) {
        xy0 xy0Var = new xy0(3, z00Var, this);
        if (j > 4611686018427387903L) {
            j = 4611686018427387903L;
        }
        if (this.z.postDelayed(xy0Var, j)) {
            z00Var.y(new gj(5, this, xy0Var));
        } else {
            x0(z00Var.X, xy0Var);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof tq1)) {
            return false;
        }
        tq1 tq1Var = (tq1) obj;
        return tq1Var.z == this.z && tq1Var.A == this.A;
    }

    public final int hashCode() {
        return (this.A ? 1231 : 1237) ^ System.identityHashCode(this.z);
    }

    @Override // defpackage.ef0
    public final void j0(cf0 cf0Var, Runnable runnable) {
        if (this.z.post(runnable)) {
            return;
        }
        x0(cf0Var, runnable);
    }

    @Override // defpackage.ef0
    public final boolean q0(cf0 cf0Var) {
        return (this.A && n12.c(Looper.myLooper(), this.z.getLooper())) ? false : true;
    }

    @Override // defpackage.ef0
    public final ef0 r0(int i) {
        vf2.d(1);
        return this;
    }

    @Override // defpackage.ef0
    public final String toString() {
        tq1 tq1Var;
        String str;
        gm0 gm0Var = qv0.a;
        tq1 tq1Var2 = qf2.a;
        if (this == tq1Var2) {
            str = "Dispatchers.Main";
        } else {
            try {
                tq1Var = tq1Var2.X;
            } catch (UnsupportedOperationException unused) {
                tq1Var = null;
            }
            str = this == tq1Var ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.z.toString();
        return this.A ? ha0.x(string, ".immediate") : string;
    }

    public final void x0(cf0 cf0Var, Runnable runnable) {
        CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        v32 v32Var = (v32) cf0Var.Z(pr1.X);
        if (v32Var != null) {
            v32Var.g(cancellationException);
        }
        gm0 gm0Var = qv0.a;
        pl0.z.j0(cf0Var, runnable);
    }
}
