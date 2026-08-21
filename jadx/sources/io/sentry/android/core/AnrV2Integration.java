package io.sentry.android.core;

import android.content.Context;
import com.getsurfboard.ui.SurfboardApp;
import io.sentry.ILogger;
import io.sentry.p5;
import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class AnrV2Integration implements io.sentry.v1, Closeable {
    public final Context b;
    public SentryAndroidOptions f;

    public AnrV2Integration(SurfboardApp surfboardApp) {
        Context applicationContext = surfboardApp.getApplicationContext();
        this.b = applicationContext != null ? applicationContext : surfboardApp;
    }

    @Override // io.sentry.v1
    public final void M(SentryAndroidOptions sentryAndroidOptions) {
        this.f = sentryAndroidOptions;
        ILogger logger = sentryAndroidOptions.getLogger();
        p5 p5Var = p5.DEBUG;
        logger.h(p5Var, "AnrIntegration enabled: %s", Boolean.valueOf(this.f.isAnrEnabled()));
        String cacheDirPath = this.f.getCacheDirPath();
        SentryAndroidOptions sentryAndroidOptions2 = this.f;
        if (cacheDirPath == null) {
            sentryAndroidOptions2.getLogger().h(p5.INFO, "Cache dir is not set, unable to process ANRs", new Object[0]);
            return;
        }
        if (sentryAndroidOptions2.isAnrEnabled()) {
            try {
                io.sentry.j1 executorService = sentryAndroidOptions.getExecutorService();
                Context context = this.b;
                SentryAndroidOptions sentryAndroidOptions3 = this.f;
                executorService.submit(new o0(context, sentryAndroidOptions3, new c0(sentryAndroidOptions3)));
            } catch (Throwable th) {
                ILogger logger2 = sentryAndroidOptions.getLogger();
                p5Var = p5.DEBUG;
                logger2.d(p5Var, "Failed to start ANR processor.", th);
            }
            sentryAndroidOptions.getLogger().h(p5Var, "AnrV2Integration installed.", new Object[0]);
            io.sentry.util.b.a("AnrV2");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        SentryAndroidOptions sentryAndroidOptions = this.f;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().h(p5.DEBUG, "AnrV2Integration removed.", new Object[0]);
        }
    }
}
