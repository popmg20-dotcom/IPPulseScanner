package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f85 extends k95 {
    public static final AtomicLong E0 = new AtomicLong(Long.MIN_VALUE);
    public final a85 A0;
    public final a85 B0;
    public final Object C0;
    public final Semaphore D0;
    public d85 Y;
    public d85 Z;
    public final PriorityBlockingQueue y0;
    public final LinkedBlockingQueue z0;

    public f85(k85 k85Var) {
        super(k85Var);
        this.C0 = new Object();
        this.D0 = new Semaphore(2);
        this.y0 = new PriorityBlockingQueue();
        this.z0 = new LinkedBlockingQueue();
        this.A0 = new a85(this, "Thread death: Uncaught exception on worker thread");
        this.B0 = new a85(this, "Thread death: Uncaught exception on network thread");
    }

    @Override // defpackage.k70
    public final void V0() {
        if (Thread.currentThread() == this.Y) {
            return;
        }
        xe.q("Call expected from worker thread");
    }

    @Override // defpackage.k95
    public final boolean W0() {
        return false;
    }

    public final void Z0() {
        if (Thread.currentThread() == this.Z) {
            return;
        }
        xe.q("Call expected from network thread");
    }

    public final void a1() {
        if (Thread.currentThread() != this.Y) {
            return;
        }
        xe.q("Call not expected from worker thread");
    }

    public final boolean b1() {
        return Thread.currentThread() == this.Y;
    }

    public final c85 c1(Callable callable) {
        X0();
        c85 c85Var = new c85(this, callable, false);
        if (Thread.currentThread() != this.Y) {
            i1(c85Var);
            return c85Var;
        }
        if (!this.y0.isEmpty()) {
            t65 t65Var = ((k85) this.f).Y;
            k85.h(t65Var);
            t65Var.C0.a("Callable skipped the worker queue.");
        }
        c85Var.run();
        return c85Var;
    }

    public final c85 d1(Callable callable) {
        X0();
        c85 c85Var = new c85(this, callable, true);
        if (Thread.currentThread() == this.Y) {
            c85Var.run();
            return c85Var;
        }
        i1(c85Var);
        return c85Var;
    }

    public final void e1(Runnable runnable) {
        X0();
        tj4.i(runnable);
        i1(new c85(this, runnable, false, "Task exception on worker thread"));
    }

    public final Object f1(AtomicReference atomicReference, long j, String str, Runnable runnable) {
        synchronized (atomicReference) {
            f85 f85Var = ((k85) this.f).Z;
            k85.h(f85Var);
            f85Var.e1(runnable);
            try {
                atomicReference.wait(j);
            } catch (InterruptedException unused) {
                t65 t65Var = ((k85) this.f).Y;
                k85.h(t65Var);
                q65 q65Var = t65Var.C0;
                StringBuilder sb = new StringBuilder(str.length() + 24);
                sb.append("Interrupted waiting for ");
                sb.append(str);
                q65Var.a(sb.toString());
                return null;
            }
        }
        Object obj = atomicReference.get();
        if (obj == null) {
            t65 t65Var2 = ((k85) this.f).Y;
            k85.h(t65Var2);
            t65Var2.C0.a("Timed out waiting for ".concat(str));
        }
        return obj;
    }

    public final void g1(Runnable runnable) {
        X0();
        i1(new c85(this, runnable, true, "Task exception on worker thread"));
    }

    public final void h1(Runnable runnable) {
        X0();
        c85 c85Var = new c85(this, runnable, false, "Task exception on network thread");
        synchronized (this.C0) {
            try {
                LinkedBlockingQueue linkedBlockingQueue = this.z0;
                linkedBlockingQueue.add(c85Var);
                d85 d85Var = this.Z;
                if (d85Var == null) {
                    d85 d85Var2 = new d85(this, "Measurement Network", linkedBlockingQueue);
                    this.Z = d85Var2;
                    d85Var2.setUncaughtExceptionHandler(this.B0);
                    this.Z.start();
                } else {
                    d85Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void i1(c85 c85Var) {
        synchronized (this.C0) {
            try {
                PriorityBlockingQueue priorityBlockingQueue = this.y0;
                priorityBlockingQueue.add(c85Var);
                d85 d85Var = this.Y;
                if (d85Var == null) {
                    d85 d85Var2 = new d85(this, "Measurement Worker", priorityBlockingQueue);
                    this.Y = d85Var2;
                    d85Var2.setUncaughtExceptionHandler(this.A0);
                    this.Y.start();
                } else {
                    d85Var.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
