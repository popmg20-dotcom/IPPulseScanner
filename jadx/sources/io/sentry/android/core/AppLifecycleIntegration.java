package io.sentry.android.core;

import io.sentry.ILogger;
import io.sentry.p5;
import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class AppLifecycleIntegration implements io.sentry.v1, Closeable {
    public final io.sentry.util.a b = new io.sentry.util.a();
    public volatile z0 f;
    public SentryAndroidOptions z;

    @Override // io.sentry.v1
    public final void M(SentryAndroidOptions sentryAndroidOptions) {
        this.z = sentryAndroidOptions;
        ILogger logger = sentryAndroidOptions.getLogger();
        p5 p5Var = p5.DEBUG;
        logger.h(p5Var, "enableSessionTracking enabled: %s", Boolean.valueOf(this.z.isEnableAutoSessionTracking()));
        this.z.getLogger().h(p5Var, "enableAppLifecycleBreadcrumbs enabled: %s", Boolean.valueOf(this.z.isEnableAppLifecycleBreadcrumbs()));
        if (this.z.isEnableAutoSessionTracking() || this.z.isEnableAppLifecycleBreadcrumbs()) {
            io.sentry.util.a aVar = this.b;
            aVar.g();
            try {
                if (this.f != null) {
                    aVar.close();
                    return;
                }
                this.f = new z0(this.z.getSessionTrackingIntervalMillis(), this.z.isEnableAutoSessionTracking(), this.z.isEnableAppLifecycleBreadcrumbs());
                j0.X.g(this.f);
                aVar.close();
                sentryAndroidOptions.getLogger().h(p5Var, "AppLifecycleIntegration installed.", new Object[0]);
                io.sentry.util.b.a("AppLifecycle");
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

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        io.sentry.util.a aVar = this.b;
        aVar.g();
        try {
            z0 z0Var = this.f;
            this.f = null;
            aVar.close();
            if (z0Var != null) {
                j0.X.x(z0Var);
                SentryAndroidOptions sentryAndroidOptions = this.z;
                if (sentryAndroidOptions != null) {
                    sentryAndroidOptions.getLogger().h(p5.DEBUG, "AppLifecycleIntegration removed.", new Object[0]);
                }
            }
            j0.X.C();
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
