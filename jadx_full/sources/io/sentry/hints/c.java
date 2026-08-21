package io.sentry.hints;

import io.sentry.ILogger;
import io.sentry.p5;
import io.sentry.protocol.w;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class c implements f {
    public final CountDownLatch b = new CountDownLatch(1);
    public final long f;
    public final ILogger z;

    public c(long j, ILogger iLogger) {
        this.f = j;
        this.z = iLogger;
    }

    @Override // io.sentry.hints.f
    public final boolean d() {
        try {
            return this.b.await(this.f, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            this.z.d(p5.ERROR, "Exception while awaiting for flush in BlockingFlushHint", e);
            return false;
        }
    }

    public abstract boolean f(w wVar);

    public abstract void g(w wVar);
}
