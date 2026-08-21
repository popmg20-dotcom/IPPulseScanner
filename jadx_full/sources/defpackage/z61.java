package defpackage;

import java.lang.reflect.Method;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class z61 extends y61 implements on0 {
    public final Executor z;

    public z61(Executor executor) {
        Method method;
        this.z = executor;
        Method method2 = ea0.a;
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = executor instanceof ScheduledThreadPoolExecutor ? (ScheduledThreadPoolExecutor) executor : null;
            if (scheduledThreadPoolExecutor != null && (method = ea0.a) != null) {
                method.invoke(scheduledThreadPoolExecutor, Boolean.TRUE);
            }
        } catch (Throwable unused) {
        }
    }

    public static void x0(cf0 cf0Var, RejectedExecutionException rejectedExecutionException) {
        CancellationException cancellationException = new CancellationException("The task was rejected");
        cancellationException.initCause(rejectedExecutionException);
        v32 v32Var = (v32) cf0Var.Z(pr1.X);
        if (v32Var != null) {
            v32Var.g(cancellationException);
        }
    }

    @Override // defpackage.on0
    public final zv0 I(long j, Runnable runnable, cf0 cf0Var) {
        Executor executor = this.z;
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(runnable, j, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e) {
                x0(cf0Var, e);
            }
        }
        return scheduledFutureSchedule != null ? new yv0(scheduledFutureSchedule) : il0.B0.I(j, runnable, cf0Var);
    }

    @Override // defpackage.on0
    public final void U(long j, z00 z00Var) {
        Executor executor = this.z;
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            um1 um1Var = new um1(8, this, z00Var);
            cf0 cf0Var = z00Var.X;
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(um1Var, j, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e) {
                x0(cf0Var, e);
            }
        }
        if (scheduledFutureSchedule != null) {
            z00Var.z(new s00(0, scheduledFutureSchedule));
        } else {
            il0.B0.U(j, z00Var);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Executor executor = this.z;
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof z61) && ((z61) obj).z == this.z;
    }

    public final int hashCode() {
        return System.identityHashCode(this.z);
    }

    @Override // defpackage.ef0
    public final void j0(cf0 cf0Var, Runnable runnable) {
        try {
            this.z.execute(runnable);
        } catch (RejectedExecutionException e) {
            CancellationException cancellationException = new CancellationException("The task was rejected");
            cancellationException.initCause(e);
            v32 v32Var = (v32) cf0Var.Z(pr1.X);
            if (v32Var != null) {
                v32Var.g(cancellationException);
            }
            gm0 gm0Var = qv0.a;
            pl0.z.j0(cf0Var, runnable);
        }
    }

    @Override // defpackage.ef0
    public final String toString() {
        return this.z.toString();
    }
}
