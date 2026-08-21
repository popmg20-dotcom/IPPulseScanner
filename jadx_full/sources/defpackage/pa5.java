package defpackage;

import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pa5 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ AtomicReference f;
    public final /* synthetic */ ib5 z;

    public pa5(ib5 ib5Var, AtomicReference atomicReference, int i) {
        this.b = i;
        switch (i) {
            case 1:
                this.f = atomicReference;
                Objects.requireNonNull(ib5Var);
                this.z = ib5Var;
                break;
            case 2:
                this.f = atomicReference;
                Objects.requireNonNull(ib5Var);
                this.z = ib5Var;
                break;
            case 3:
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
                    atomicReference.set(k85Var.A.b1(k85Var.l().b1(), r55.c0));
                } finally {
                    this.f.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void b() {
        AtomicReference atomicReference = this.f;
        synchronized (atomicReference) {
            try {
                try {
                    k85 k85Var = (k85) this.z.f;
                    atomicReference.set(Integer.valueOf(k85Var.A.d1(k85Var.l().b1(), r55.e0)));
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
                            atomicReference.set(Boolean.valueOf(k85Var.A.f1(k85Var.l().b1(), r55.b0)));
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
            case 2:
                b();
                return;
            default:
                dd5 dd5VarJ = ((k85) this.z.f).j();
                le5 le5VarA = le5.a(qb5.SGTM_CLIENT);
                AtomicReference atomicReference2 = this.f;
                dd5VarJ.V0();
                dd5VarJ.W0();
                dd5VarJ.j1(new d20(dd5VarJ, atomicReference2, dd5VarJ.l1(false), le5VarA, 9, false));
                return;
        }
    }
}
