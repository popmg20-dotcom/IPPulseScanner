package io.sentry.transport;

import io.sentry.ILogger;
import io.sentry.n0;
import io.sentry.n2;
import io.sentry.p5;
import io.sentry.w4;
import io.sentry.x4;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n extends ThreadPoolExecutor implements AutoCloseable {
    public final x4 A;
    public final n2 X;
    public final int b;
    public w4 f;
    public final ILogger z;

    public n(int i, n0 n0Var, a aVar, ILogger iLogger, x4 x4Var) {
        super(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), n0Var, aVar);
        this.f = null;
        this.X = new n2(8);
        this.b = i;
        this.z = iLogger;
        this.A = x4Var;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void afterExecute(Runnable runnable, Throwable th) {
        p pVar = (p) this.X.f;
        try {
            super.afterExecute(runnable, th);
        } finally {
            int i = p.b;
            pVar.releaseShared(1);
        }
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        io.sentry.android.core.internal.util.q.d(this);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public final Future submit(Runnable runnable) {
        p pVar = (p) this.X.f;
        int i = p.b;
        int iA = pVar.a();
        int i2 = this.b;
        ILogger iLogger = this.z;
        x4 x4Var = this.A;
        if (iA >= i2) {
            this.f = x4Var.a();
            iLogger.h(p5.WARNING, "Submit cancelled", new Object[0]);
            return new m();
        }
        pVar.b();
        try {
            return super.submit(runnable);
        } catch (RejectedExecutionException e) {
            pVar.releaseShared(1);
            this.f = x4Var.a();
            iLogger.d(p5.WARNING, "Submit rejected by thread pool executor", e);
            return new m();
        }
    }
}
