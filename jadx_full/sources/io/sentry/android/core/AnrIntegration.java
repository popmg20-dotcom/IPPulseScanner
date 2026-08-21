package io.sentry.android.core;

import android.content.Context;
import com.getsurfboard.ui.SurfboardApp;
import defpackage.ed;
import io.sentry.ILogger;
import io.sentry.p5;
import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class AnrIntegration implements io.sentry.v1, Closeable {
    public static a X;
    public static final io.sentry.util.a Y = new io.sentry.util.a();
    public SentryAndroidOptions A;
    public final Context b;
    public boolean f = false;
    public final io.sentry.util.a z = new io.sentry.util.a();

    public AnrIntegration(SurfboardApp surfboardApp) {
        Context applicationContext = surfboardApp.getApplicationContext();
        this.b = applicationContext != null ? applicationContext : surfboardApp;
    }

    @Override // io.sentry.v1
    public final void M(SentryAndroidOptions sentryAndroidOptions) {
        this.A = sentryAndroidOptions;
        sentryAndroidOptions.getLogger().h(p5.DEBUG, "AnrIntegration enabled: %s", Boolean.valueOf(sentryAndroidOptions.isAnrEnabled()));
        if (sentryAndroidOptions.isAnrEnabled()) {
            io.sentry.util.b.a("Anr");
            try {
                sentryAndroidOptions.getExecutorService().submit(new z(0, this, sentryAndroidOptions));
            } catch (Throwable th) {
                sentryAndroidOptions.getLogger().d(p5.DEBUG, "Failed to start AnrIntegration on executor thread.", th);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        io.sentry.util.a aVar = this.z;
        aVar.g();
        try {
            this.f = true;
            aVar.close();
            io.sentry.util.a aVar2 = Y;
            aVar2.g();
            try {
                a aVar3 = X;
                if (aVar3 != null) {
                    aVar3.interrupt();
                    X = null;
                    SentryAndroidOptions sentryAndroidOptions = this.A;
                    if (sentryAndroidOptions != null) {
                        sentryAndroidOptions.getLogger().h(p5.DEBUG, "AnrIntegration removed.", new Object[0]);
                    }
                }
                aVar2.close();
            } catch (Throwable th) {
                try {
                    aVar2.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            try {
                aVar.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public final void g(SentryAndroidOptions sentryAndroidOptions) {
        io.sentry.util.a aVar = Y;
        aVar.g();
        try {
            if (X == null) {
                ILogger logger = sentryAndroidOptions.getLogger();
                p5 p5Var = p5.DEBUG;
                logger.h(p5Var, "ANR timeout in milliseconds: %d", Long.valueOf(sentryAndroidOptions.getAnrTimeoutIntervalMillis()));
                a aVar2 = new a(sentryAndroidOptions.getAnrTimeoutIntervalMillis(), sentryAndroidOptions.isAnrReportInDebug(), new ed(25, this, sentryAndroidOptions), sentryAndroidOptions.getLogger(), this.b);
                X = aVar2;
                aVar2.start();
                sentryAndroidOptions.getLogger().h(p5Var, "AnrIntegration installed.", new Object[0]);
            }
            aVar.close();
        } finally {
        }
    }
}
