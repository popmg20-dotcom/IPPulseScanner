package io.sentry;

import defpackage.xy0;
import io.sentry.android.core.SentryAndroidOptions;
import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ShutdownHookIntegration implements v1, Closeable {
    public final Runtime b;
    public Thread f;

    public ShutdownHookIntegration() {
        Runtime runtime = Runtime.getRuntime();
        io.sentry.util.b.r(runtime, "Runtime is required");
        this.b = runtime;
    }

    @Override // io.sentry.v1
    public final void M(SentryAndroidOptions sentryAndroidOptions) {
        if (!sentryAndroidOptions.isEnableShutdownHook()) {
            sentryAndroidOptions.getLogger().h(p5.INFO, "enableShutdownHook is disabled.", new Object[0]);
            return;
        }
        this.f = new Thread(new o4(sentryAndroidOptions, 3), "sentry-shutdownhook");
        try {
            new xy0(28, this, sentryAndroidOptions).run();
        } catch (IllegalStateException e) {
            String message = e.getMessage();
            if (message == null || !(message.equals("Shutdown in progress") || message.equals("VM already shutting down"))) {
                throw e;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f != null) {
            try {
                this.b.removeShutdownHook(this.f);
            } catch (IllegalStateException e) {
                String message = e.getMessage();
                if (message == null || !(message.equals("Shutdown in progress") || message.equals("VM already shutting down"))) {
                    throw e;
                }
            }
        }
    }
}
