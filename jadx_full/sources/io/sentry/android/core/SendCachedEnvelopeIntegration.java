package io.sentry.android.core;

import defpackage.l84;
import io.sentry.ILogger;
import io.sentry.l4;
import io.sentry.n4;
import io.sentry.p5;
import java.io.Closeable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
final class SendCachedEnvelopeIntegration implements io.sentry.v1, io.sentry.s0, Closeable {
    public io.sentry.t0 A;
    public io.sentry.f1 X;
    public SentryAndroidOptions Y;
    public l84 Z;
    public final n4 b;
    public final io.sentry.util.f f;
    public final AtomicBoolean z = new AtomicBoolean(false);
    public final AtomicBoolean y0 = new AtomicBoolean(false);
    public final AtomicBoolean z0 = new AtomicBoolean(false);
    public final io.sentry.util.a A0 = new io.sentry.util.a();

    public SendCachedEnvelopeIntegration(n4 n4Var, io.sentry.util.f fVar) {
        this.b = n4Var;
        this.f = fVar;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0012. Please report as an issue. */
    @Override // io.sentry.v1
    public final void M(SentryAndroidOptions sentryAndroidOptions) {
        l4 l4Var = l4.a;
        this.X = l4Var;
        this.Y = sentryAndroidOptions;
        String cacheDirPath = sentryAndroidOptions.getCacheDirPath();
        ILogger logger = sentryAndroidOptions.getLogger();
        switch (this.b.a) {
        }
        if (!io.sentry.e.b(cacheDirPath, logger)) {
            sentryAndroidOptions.getLogger().h(p5.ERROR, "No cache dir path is defined in options.", new Object[0]);
        } else {
            io.sentry.util.b.a("SendCachedEnvelope");
            g(l4Var, this.Y);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.z0.set(true);
        io.sentry.t0 t0Var = this.A;
        if (t0Var != null) {
            t0Var.s0(this);
        }
    }

    public final void g(io.sentry.f1 f1Var, SentryAndroidOptions sentryAndroidOptions) {
        try {
            io.sentry.util.a aVar = this.A0;
            aVar.g();
            try {
                Future futureSubmit = sentryAndroidOptions.getExecutorService().submit(new p1(0, this, sentryAndroidOptions, f1Var));
                if (((Boolean) this.f.a()).booleanValue() && this.z.compareAndSet(false, true)) {
                    sentryAndroidOptions.getLogger().h(p5.DEBUG, "Startup Crash marker exists, blocking flush.", new Object[0]);
                    try {
                        futureSubmit.get(sentryAndroidOptions.getStartupCrashFlushTimeoutMillis(), TimeUnit.MILLISECONDS);
                    } catch (TimeoutException unused) {
                        sentryAndroidOptions.getLogger().h(p5.DEBUG, "Synchronous send timed out, continuing in the background.", new Object[0]);
                    }
                }
                sentryAndroidOptions.getLogger().h(p5.DEBUG, "SendCachedEnvelopeIntegration installed.", new Object[0]);
                aVar.close();
            } finally {
            }
        } catch (RejectedExecutionException e) {
            sentryAndroidOptions.getLogger().d(p5.ERROR, "Failed to call the executor. Cached events will not be sent. Did you call Sentry.close()?", e);
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().d(p5.ERROR, "Failed to call the executor. Cached events will not be sent", th);
        }
    }

    @Override // io.sentry.s0
    public final void s(io.sentry.r0 r0Var) {
        SentryAndroidOptions sentryAndroidOptions;
        io.sentry.f1 f1Var = this.X;
        if (f1Var == null || (sentryAndroidOptions = this.Y) == null || r0Var == io.sentry.r0.DISCONNECTED) {
            return;
        }
        g(f1Var, sentryAndroidOptions);
    }
}
