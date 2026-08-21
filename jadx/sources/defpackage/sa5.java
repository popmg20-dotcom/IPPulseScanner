package defpackage;

import android.os.Bundle;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sa5 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ AtomicReference f;
    public final /* synthetic */ ib5 z;

    public sa5(ib5 ib5Var, AtomicReference atomicReference, int i) {
        this.b = i;
        switch (i) {
            case 1:
                this.f = atomicReference;
                Objects.requireNonNull(ib5Var);
                this.z = ib5Var;
                break;
            case 2:
                this.z = ib5Var;
                this.f = atomicReference;
                break;
            default:
                this.f = atomicReference;
                Objects.requireNonNull(ib5Var);
                this.z = ib5Var;
                break;
        }
    }

    private final void a() {
        AtomicReference atomicReference = this.f;
        synchronized (atomicReference) {
            try {
                try {
                    k85 k85Var = (k85) this.z.f;
                    atomicReference.set(Double.valueOf(k85Var.A.e1(k85Var.l().b1(), r55.f0)));
                } finally {
                    this.f.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.b) {
            case 0:
                AtomicReference atomicReference = this.f;
                synchronized (atomicReference) {
                    try {
                        try {
                            k85 k85Var = (k85) this.z.f;
                            atomicReference.set(Long.valueOf(k85Var.A.c1(k85Var.l().b1(), r55.d0)));
                        } finally {
                            this.f.notify();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            case 1:
                a();
                return;
            default:
                ib5 ib5Var = this.z;
                l75 l75Var = ((k85) ib5Var.f).X;
                k85.f(l75Var);
                Bundle bundleF = l75Var.H0.f();
                dd5 dd5VarJ = ((k85) ib5Var.f).j();
                AtomicReference atomicReference2 = this.f;
                dd5VarJ.V0();
                dd5VarJ.W0();
                dd5VarJ.j1(new d20(dd5VarJ, atomicReference2, dd5VarJ.l1(false), bundleF, 8, false));
                return;
        }
    }
}
