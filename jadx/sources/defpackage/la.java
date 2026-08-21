package defpackage;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class la implements Executor {
    public final Object A;
    public final Executor X;
    public final /* synthetic */ int b;
    public final ArrayDeque f;
    public Runnable z;

    public la(Executor executor) {
        this.b = 2;
        executor.getClass();
        this.X = executor;
        this.f = new ArrayDeque();
        this.A = new Object();
    }

    private final void a(Runnable runnable) {
        synchronized (this.A) {
            try {
                this.f.add(new s7(1, this, runnable));
                if (this.z == null) {
                    c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void b(Runnable runnable) {
        synchronized (this.A) {
            try {
                this.f.add(new um1(9, this, runnable));
                if (this.z == null) {
                    c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void d() {
        synchronized (this.A) {
            try {
                Runnable runnable = (Runnable) this.f.poll();
                this.z = runnable;
                if (runnable != null) {
                    ((yu0) this.X).execute(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c() {
        switch (this.b) {
            case 0:
                d();
                return;
            case 1:
                Runnable runnable = (Runnable) this.f.poll();
                this.z = runnable;
                if (runnable != null) {
                    ((ExecutorService) this.X).execute(runnable);
                    return;
                }
                return;
            default:
                synchronized (this.A) {
                    Object objPoll = this.f.poll();
                    Runnable runnable2 = (Runnable) objPoll;
                    this.z = runnable2;
                    if (objPoll != null) {
                        this.X.execute(runnable2);
                    }
                    break;
                }
                return;
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.b) {
            case 0:
                a(runnable);
                return;
            case 1:
                b(runnable);
                return;
            default:
                runnable.getClass();
                synchronized (this.A) {
                    this.f.offer(new xy0(25, runnable, this));
                    if (this.z == null) {
                        c();
                    }
                    break;
                }
                return;
        }
    }

    public la(ExecutorService executorService) {
        this.b = 1;
        this.X = executorService;
        this.f = new ArrayDeque();
        this.A = new Object();
    }

    public la(yu0 yu0Var) {
        this.b = 0;
        this.A = new Object();
        this.f = new ArrayDeque();
        this.X = yu0Var;
    }
}
