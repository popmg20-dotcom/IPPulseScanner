package io.sentry.android.core;

import android.content.Context;
import android.os.Build;
import com.getsurfboard.ui.SurfboardApp;
import io.sentry.ILogger;
import io.sentry.p5;
import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class NetworkBreadcrumbsIntegration implements io.sentry.v1, Closeable {
    public volatile g1 A;
    public final Context b;
    public final q0 f;
    public final io.sentry.util.a z = new io.sentry.util.a();

    public NetworkBreadcrumbsIntegration(SurfboardApp surfboardApp, q0 q0Var) {
        Context applicationContext = surfboardApp.getApplicationContext();
        this.b = applicationContext != null ? applicationContext : surfboardApp;
        this.f = q0Var;
    }

    @Override // io.sentry.v1
    public final void M(SentryAndroidOptions sentryAndroidOptions) {
        ILogger logger = sentryAndroidOptions.getLogger();
        p5 p5Var = p5.DEBUG;
        logger.h(p5Var, "NetworkBreadcrumbsIntegration enabled: %s", Boolean.valueOf(sentryAndroidOptions.isEnableNetworkEventBreadcrumbs()));
        if (sentryAndroidOptions.isEnableNetworkEventBreadcrumbs()) {
            if (Build.VERSION.SDK_INT < 24) {
                sentryAndroidOptions.getLogger().h(p5Var, "NetworkCallbacks need Android N+.", new Object[0]);
                return;
            }
            io.sentry.util.a aVar = this.z;
            aVar.g();
            try {
                this.A = new g1(this.f, sentryAndroidOptions.getDateProvider());
                if (io.sentry.android.core.internal.util.b.s(this.b, sentryAndroidOptions.getLogger(), this.f, this.A)) {
                    sentryAndroidOptions.getLogger().h(p5Var, "NetworkBreadcrumbsIntegration installed.", new Object[0]);
                    io.sentry.util.b.a("NetworkBreadcrumbs");
                } else {
                    sentryAndroidOptions.getLogger().h(p5Var, "NetworkBreadcrumbsIntegration not installed.", new Object[0]);
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
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        io.sentry.util.a aVar = this.z;
        aVar.g();
        try {
            g1 g1Var = this.A;
            this.A = null;
            aVar.close();
            if (g1Var != null) {
                io.sentry.util.a aVar2 = io.sentry.android.core.internal.util.b.E0;
                aVar2.g();
                try {
                    io.sentry.android.core.internal.util.b.F0.remove(g1Var);
                    aVar2.close();
                } catch (Throwable th) {
                    try {
                        aVar2.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
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
}
