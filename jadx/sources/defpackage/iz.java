package defpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class iz implements Executor {
    public static final hz z = new hz(0);
    public final Object b = new Object();
    public ThreadPoolExecutor f;

    public iz() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), z);
        threadPoolExecutor.setRejectedExecutionHandler(new gz());
        this.f = threadPoolExecutor;
    }

    public final void a() {
        synchronized (this.b) {
            try {
                if (!this.f.isShutdown()) {
                    this.f.shutdown();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(rw rwVar) {
        ThreadPoolExecutor threadPoolExecutor;
        rwVar.getClass();
        synchronized (this.b) {
            try {
                if (this.f.isShutdown()) {
                    ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), z);
                    threadPoolExecutor2.setRejectedExecutionHandler(new gz());
                    this.f = threadPoolExecutor2;
                }
                threadPoolExecutor = this.f;
            } catch (Throwable th) {
                throw th;
            }
        }
        int iMax = Math.max(1, rwVar.a().size());
        threadPoolExecutor.setMaximumPoolSize(iMax);
        threadPoolExecutor.setCorePoolSize(iMax);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.getClass();
        synchronized (this.b) {
            this.f.execute(runnable);
        }
    }
}
