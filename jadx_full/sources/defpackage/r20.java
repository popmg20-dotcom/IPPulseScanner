package defpackage;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r20 extends pm1 implements Runnable {
    public final LinkedBlockingQueue A = new LinkedBlockingQueue(1);
    public final CountDownLatch X = new CountDownLatch(1);
    public nc2 Y;
    public volatile nc2 Z;
    public gf z;

    public r20(gf gfVar, nc2 nc2Var) {
        this.z = gfVar;
        nc2Var.getClass();
        this.Y = nc2Var;
    }

    public static Object c(LinkedBlockingQueue linkedBlockingQueue) {
        Object objTake;
        boolean z = false;
        while (true) {
            try {
                objTake = linkedBlockingQueue.take();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return objTake;
    }

    @Override // defpackage.pm1, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        boolean z2 = false;
        if (!this.b.cancel(z)) {
            return false;
        }
        while (true) {
            try {
                this.A.put(Boolean.valueOf(z));
                break;
            } catch (InterruptedException unused) {
                z2 = true;
            } catch (Throwable th) {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        nc2 nc2Var = this.Y;
        if (nc2Var != null) {
            nc2Var.cancel(z);
        }
        nc2 nc2Var2 = this.Z;
        if (nc2Var2 != null) {
            nc2Var2.cancel(z);
        }
        return true;
    }

    @Override // defpackage.pm1, java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        if (!this.b.isDone()) {
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            if (timeUnit != timeUnit2) {
                j = timeUnit2.convert(j, timeUnit);
                timeUnit = timeUnit2;
            }
            nc2 nc2Var = this.Y;
            if (nc2Var != null) {
                long jNanoTime = System.nanoTime();
                nc2Var.get(j, timeUnit);
                j -= Math.max(0L, System.nanoTime() - jNanoTime);
            }
            long jNanoTime2 = System.nanoTime();
            if (!this.X.await(j, timeUnit)) {
                throw new TimeoutException();
            }
            j -= Math.max(0L, System.nanoTime() - jNanoTime2);
            nc2 nc2Var2 = this.Z;
            if (nc2Var2 != null) {
                nc2Var2.get(j, timeUnit);
            }
        }
        return this.b.get(j, timeUnit);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, pm1, r20] */
    /* JADX WARN: Type inference failed for: r5v1, types: [r20] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v3, types: [pm1] */
    /* JADX WARN: Type inference failed for: r5v4, types: [r20] */
    /* JADX WARN: Type inference failed for: r5v6, types: [pm1] */
    /* JADX WARN: Type inference failed for: r5v7, types: [pm1] */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.util.concurrent.CountDownLatch] */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // java.lang.Runnable
    public final void run() {
        ?? r5;
        boolean z = false;
        try {
            try {
                try {
                    try {
                        try {
                            nc2 nc2VarMo23apply = this.z.mo23apply(n12.E(this.Y));
                            this.Z = nc2VarMo23apply;
                            if (this.b.isCancelled()) {
                                nc2VarMo23apply.cancel(((Boolean) c(this.A)).booleanValue());
                                this.Z = null;
                            } else {
                                nc2VarMo23apply.a(new tm1(5, this, nc2VarMo23apply, z), yu0.a());
                            }
                        } catch (Error e) {
                            vv vvVar = this.f;
                            r5 = this;
                            if (vvVar != null) {
                                vvVar.d(e);
                                r5 = this;
                            }
                        }
                    } catch (UndeclaredThrowableException e2) {
                        Throwable cause = e2.getCause();
                        vv vvVar2 = this.f;
                        r5 = this;
                        if (vvVar2 != null) {
                            vvVar2.d(cause);
                            r5 = this;
                        }
                    }
                } finally {
                    this.z = null;
                    this.Y = null;
                    this.X.countDown();
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e3) {
                Throwable cause2 = e3.getCause();
                vv vvVar3 = this.f;
                if (vvVar3 != null) {
                    vvVar3.d(cause2);
                }
            }
        } catch (Exception e4) {
            vv vvVar4 = this.f;
            r5 = this;
            if (vvVar4 != null) {
                vvVar4.d(e4);
                r5 = this;
            }
        }
    }

    @Override // defpackage.pm1, java.util.concurrent.Future
    public final Object get() throws ExecutionException, InterruptedException {
        if (!this.b.isDone()) {
            nc2 nc2Var = this.Y;
            if (nc2Var != null) {
                nc2Var.get();
            }
            this.X.await();
            nc2 nc2Var2 = this.Z;
            if (nc2Var2 != null) {
                nc2Var2.get();
            }
        }
        return this.b.get();
    }
}
