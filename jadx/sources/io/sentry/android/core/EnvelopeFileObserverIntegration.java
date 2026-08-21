package io.sentry.android.core;

import io.sentry.ILogger;
import io.sentry.l4;
import io.sentry.o3;
import io.sentry.p5;
import java.io.Closeable;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class EnvelopeFileObserverIntegration implements io.sentry.v1, Closeable {
    public w0 b;
    public ILogger f;
    public boolean z = false;
    public final io.sentry.util.a A = new io.sentry.util.a();

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class OutboxEnvelopeFileObserverIntegration extends EnvelopeFileObserverIntegration {
    }

    @Override // io.sentry.v1
    public final void M(SentryAndroidOptions sentryAndroidOptions) {
        this.f = sentryAndroidOptions.getLogger();
        String outboxPath = sentryAndroidOptions.getOutboxPath();
        ILogger iLogger = this.f;
        if (outboxPath == null) {
            iLogger.h(p5.WARNING, "Null given as a path to EnvelopeFileObserverIntegration. Nothing will be registered.", new Object[0]);
            return;
        }
        iLogger.h(p5.DEBUG, "Registering EnvelopeFileObserverIntegration for path: %s", outboxPath);
        try {
            sentryAndroidOptions.getExecutorService().submit(new p1(3, this, sentryAndroidOptions, outboxPath));
        } catch (Throwable th) {
            this.f.d(p5.DEBUG, "Failed to start EnvelopeFileObserverIntegration on executor thread.", th);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        io.sentry.util.a aVar = this.A;
        aVar.g();
        try {
            this.z = true;
            aVar.close();
            w0 w0Var = this.b;
            if (w0Var != null) {
                w0Var.stopWatching();
                ILogger iLogger = this.f;
                if (iLogger != null) {
                    iLogger.h(p5.DEBUG, "EnvelopeFileObserverIntegration removed.", new Object[0]);
                }
            }
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void g(SentryAndroidOptions sentryAndroidOptions, String str) {
        if (!io.sentry.util.b.e(new File(str))) {
            sentryAndroidOptions.getLogger().h(p5.ERROR, "Failed to create outbox dir %s", str);
        }
        w0 w0Var = new w0(str, new o3(l4.a, sentryAndroidOptions.getEnvelopeReader(), sentryAndroidOptions.getSerializer(), sentryAndroidOptions.getLogger(), sentryAndroidOptions.getFlushTimeoutMillis(), sentryAndroidOptions.getMaxQueueSize()), sentryAndroidOptions.getLogger(), sentryAndroidOptions.getFlushTimeoutMillis());
        this.b = w0Var;
        try {
            w0Var.startWatching();
            sentryAndroidOptions.getLogger().h(p5.DEBUG, "EnvelopeFileObserverIntegration installed.", new Object[0]);
            io.sentry.util.b.a("EnvelopeFileObserver");
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().d(p5.ERROR, "Failed to initialize EnvelopeFileObserverIntegration.", th);
        }
    }
}
