package io.sentry.android.core;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import com.getsurfboard.ui.SurfboardApp;
import io.sentry.ILogger;
import io.sentry.l4;
import io.sentry.p5;
import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class AppComponentsBreadcrumbsIntegration implements io.sentry.v1, Closeable, ComponentCallbacks2 {
    public static final io.sentry.l0 X = new io.sentry.l0();
    public final io.sentry.android.core.internal.util.f A = new io.sentry.android.core.internal.util.f(60000, 0);
    public final Context b;
    public io.sentry.f1 f;
    public SentryAndroidOptions z;

    public AppComponentsBreadcrumbsIntegration(SurfboardApp surfboardApp) {
        Context applicationContext = surfboardApp.getApplicationContext();
        this.b = applicationContext != null ? applicationContext : surfboardApp;
    }

    @Override // io.sentry.v1
    public final void M(SentryAndroidOptions sentryAndroidOptions) {
        this.f = l4.a;
        this.z = sentryAndroidOptions;
        ILogger logger = sentryAndroidOptions.getLogger();
        p5 p5Var = p5.DEBUG;
        logger.h(p5Var, "AppComponentsBreadcrumbsIntegration enabled: %s", Boolean.valueOf(this.z.isEnableAppComponentBreadcrumbs()));
        if (this.z.isEnableAppComponentBreadcrumbs()) {
            try {
                this.b.registerComponentCallbacks(this);
                sentryAndroidOptions.getLogger().h(p5Var, "AppComponentsBreadcrumbsIntegration installed.", new Object[0]);
                io.sentry.util.b.a("AppComponentsBreadcrumbs");
            } catch (Throwable th) {
                this.z.setEnableAppComponentBreadcrumbs(false);
                sentryAndroidOptions.getLogger().b(p5.INFO, th, "ComponentCallbacks2 is not available.", new Object[0]);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            this.b.unregisterComponentCallbacks(this);
        } catch (Throwable th) {
            SentryAndroidOptions sentryAndroidOptions = this.z;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().b(p5.DEBUG, th, "It was not possible to unregisterComponentCallbacks", new Object[0]);
            }
        }
        SentryAndroidOptions sentryAndroidOptions2 = this.z;
        if (sentryAndroidOptions2 != null) {
            sentryAndroidOptions2.getLogger().h(p5.DEBUG, "AppComponentsBreadcrumbsIntegration removed.", new Object[0]);
        }
    }

    public final void g(Runnable runnable) {
        SentryAndroidOptions sentryAndroidOptions = this.z;
        if (sentryAndroidOptions != null) {
            try {
                sentryAndroidOptions.getExecutorService().submit(runnable);
            } catch (Throwable th) {
                this.z.getLogger().b(p5.ERROR, th, "Failed to submit app components breadcrumb task", new Object[0]);
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        g(new e0(this, System.currentTimeMillis(), configuration));
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(final int i) {
        if (i >= 40 && !this.A.a()) {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            g(new Runnable() { // from class: io.sentry.android.core.f0
                @Override // java.lang.Runnable
                public final void run() {
                    io.sentry.l0 l0Var = AppComponentsBreadcrumbsIntegration.X;
                    AppComponentsBreadcrumbsIntegration appComponentsBreadcrumbsIntegration = this.b;
                    if (appComponentsBreadcrumbsIntegration.f != null) {
                        io.sentry.g gVar = new io.sentry.g(jCurrentTimeMillis);
                        gVar.X = "system";
                        gVar.Z = "device.event";
                        gVar.A = "Low memory";
                        gVar.d("LOW_MEMORY", "action");
                        gVar.d(Integer.valueOf(i), "level");
                        gVar.z0 = p5.WARNING;
                        appComponentsBreadcrumbsIntegration.f.c(gVar, AppComponentsBreadcrumbsIntegration.X);
                    }
                }
            });
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }
}
