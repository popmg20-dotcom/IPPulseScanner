package io.sentry.backpressure;

import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.j1;
import io.sentry.p4;
import io.sentry.p5;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a implements b, Runnable {
    public final SentryAndroidOptions b;
    public int f = 0;
    public volatile Future z = null;
    public final io.sentry.util.a A = new io.sentry.util.a();

    public a(SentryAndroidOptions sentryAndroidOptions) {
        this.b = sentryAndroidOptions;
    }

    @Override // io.sentry.backpressure.b
    public final int a() {
        return this.f;
    }

    public final void b(int i) {
        j1 executorService = this.b.getExecutorService();
        if (executorService.isClosed()) {
            return;
        }
        io.sentry.util.a aVar = this.A;
        aVar.g();
        try {
            try {
                this.z = executorService.b(this, i);
            } catch (RejectedExecutionException e) {
                this.b.getLogger().d(p5.WARNING, "Backpressure monitor reschedule task rejected", e);
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

    @Override // io.sentry.backpressure.b
    public final void close() {
        Future future = this.z;
        if (future != null) {
            io.sentry.util.a aVar = this.A;
            aVar.g();
            try {
                future.cancel(true);
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
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zE = p4.c().e();
        int i = this.f;
        SentryAndroidOptions sentryAndroidOptions = this.b;
        if (zE) {
            if (i > 0) {
                sentryAndroidOptions.getLogger().h(p5.DEBUG, "Health check positive, reverting to normal sampling.", new Object[0]);
            }
            this.f = 0;
        } else if (i < 10) {
            this.f = i + 1;
            sentryAndroidOptions.getLogger().h(p5.DEBUG, "Health check negative, downsampling with a factor of %d", Integer.valueOf(this.f));
        }
        b(10000);
    }

    @Override // io.sentry.backpressure.b
    public final void start() {
        b(500);
    }
}
