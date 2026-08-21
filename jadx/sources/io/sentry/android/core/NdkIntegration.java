package io.sentry.android.core;

import io.sentry.ILogger;
import io.sentry.p5;
import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class NdkIntegration implements io.sentry.v1, Closeable {
    public final Class b;
    public SentryAndroidOptions f;

    public NdkIntegration(Class cls) {
        this.b = cls;
    }

    public static void g(SentryAndroidOptions sentryAndroidOptions) {
        sentryAndroidOptions.setEnableNdk(false);
        sentryAndroidOptions.setEnableScopeSync(false);
    }

    @Override // io.sentry.v1
    public final void M(SentryAndroidOptions sentryAndroidOptions) {
        Class cls;
        this.f = sentryAndroidOptions;
        boolean zIsEnableNdk = sentryAndroidOptions.isEnableNdk();
        ILogger logger = this.f.getLogger();
        p5 p5Var = p5.DEBUG;
        logger.h(p5Var, "NdkIntegration enabled: %s", Boolean.valueOf(zIsEnableNdk));
        if (!zIsEnableNdk || (cls = this.b) == null) {
            g(this.f);
            return;
        }
        if (this.f.getCacheDirPath() == null) {
            this.f.getLogger().h(p5.ERROR, "No cache dir path is defined in options.", new Object[0]);
            g(this.f);
            return;
        }
        try {
            cls.getMethod("init", SentryAndroidOptions.class).invoke(null, this.f);
            this.f.getLogger().h(p5Var, "NdkIntegration installed.", new Object[0]);
            io.sentry.util.b.a("Ndk");
        } catch (NoSuchMethodException e) {
            g(this.f);
            this.f.getLogger().d(p5.ERROR, "Failed to invoke the SentryNdk.init method.", e);
        } catch (Throwable th) {
            g(this.f);
            this.f.getLogger().d(p5.ERROR, "Failed to initialize SentryNdk.", th);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        SentryAndroidOptions sentryAndroidOptions = this.f;
        if (sentryAndroidOptions == null || !sentryAndroidOptions.isEnableNdk()) {
            return;
        }
        Class cls = this.b;
        try {
            if (cls != null) {
                try {
                    try {
                        cls.getMethod("close", null).invoke(null, null);
                        this.f.getLogger().h(p5.DEBUG, "NdkIntegration removed.", new Object[0]);
                        g(this.f);
                    } catch (NoSuchMethodException e) {
                        this.f.getLogger().d(p5.ERROR, "Failed to invoke the SentryNdk.close method.", e);
                        g(this.f);
                    }
                } catch (Throwable th) {
                    this.f.getLogger().d(p5.ERROR, "Failed to close SentryNdk.", th);
                    g(this.f);
                }
            }
        } catch (Throwable th2) {
            g(this.f);
            throw th2;
        }
    }
}
