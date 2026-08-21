package io.sentry;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j5 implements j1 {
    public final ScheduledThreadPoolExecutor a;
    public final io.sentry.util.a b;
    public final p6 c;

    public j5(p6 p6Var) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new n0(1));
        this.b = new io.sentry.util.a();
        this.a = scheduledThreadPoolExecutor;
        this.c = p6Var;
    }

    @Override // io.sentry.j1
    public final void a(long j) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.a;
        io.sentry.util.a aVar = this.b;
        aVar.g();
        try {
            if (!scheduledThreadPoolExecutor.isShutdown()) {
                scheduledThreadPoolExecutor.shutdown();
                try {
                    if (!scheduledThreadPoolExecutor.awaitTermination(j, TimeUnit.MILLISECONDS)) {
                        scheduledThreadPoolExecutor.shutdownNow();
                    }
                } catch (InterruptedException unused) {
                    scheduledThreadPoolExecutor.shutdownNow();
                    Thread.currentThread().interrupt();
                }
            }
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // io.sentry.j1
    public final Future b(Runnable runnable, long j) {
        return this.a.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    @Override // io.sentry.j1
    public final boolean isClosed() {
        io.sentry.util.a aVar = this.b;
        aVar.g();
        try {
            boolean zIsShutdown = this.a.isShutdown();
            aVar.close();
            return zIsShutdown;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // io.sentry.j1
    public final Future submit(Runnable runnable) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.a;
        if (scheduledThreadPoolExecutor.getQueue().size() >= 271) {
            scheduledThreadPoolExecutor.purge();
        }
        if (scheduledThreadPoolExecutor.getQueue().size() < 271) {
            return scheduledThreadPoolExecutor.submit(runnable);
        }
        p6 p6Var = this.c;
        if (p6Var != null) {
            p6Var.getLogger().h(p5.WARNING, "Task " + runnable + " rejected from " + scheduledThreadPoolExecutor, new Object[0]);
        }
        return new h5();
    }

    public j5(p6 p6Var, int i) {
        this(p6Var);
        this.a.setRemoveOnCancelPolicy(true);
        this.a.setKeepAliveTime(30L, TimeUnit.SECONDS);
        this.a.allowCoreThreadTimeOut(true);
    }
}
