package io.sentry.android.core;

import io.sentry.ILogger;
import io.sentry.p5;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v0 implements io.sentry.hints.d, io.sentry.hints.h, io.sentry.hints.k, io.sentry.hints.f {
    public final long A;
    public final ILogger X;
    public CountDownLatch z = new CountDownLatch(1);
    public boolean b = false;
    public boolean f = false;

    public v0(long j, ILogger iLogger) {
        this.A = j;
        io.sentry.util.b.r(iLogger, "ILogger is required.");
        this.X = iLogger;
    }

    @Override // io.sentry.hints.h
    public final boolean a() {
        return this.b;
    }

    @Override // io.sentry.hints.k
    public final void b(boolean z) {
        this.f = z;
        this.z.countDown();
    }

    @Override // io.sentry.hints.h
    public final void c(boolean z) {
        this.b = z;
    }

    @Override // io.sentry.hints.f
    public final boolean d() {
        try {
            return this.z.await(this.A, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            this.X.d(p5.ERROR, "Exception while awaiting on lock.", e);
            return false;
        }
    }

    @Override // io.sentry.hints.k
    public final boolean isSuccess() {
        return this.f;
    }
}
