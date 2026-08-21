package io.sentry.android.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.getsurfboard.ui.SurfboardApp;
import io.sentry.ILogger;
import io.sentry.l4;
import io.sentry.p5;
import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityBreadcrumbsIntegration implements io.sentry.v1, Closeable, Application.ActivityLifecycleCallbacks {
    public final io.sentry.util.a A = new io.sentry.util.a();
    public final SurfboardApp b;
    public io.sentry.f1 f;
    public boolean z;

    public ActivityBreadcrumbsIntegration(SurfboardApp surfboardApp) {
        this.b = surfboardApp;
    }

    @Override // io.sentry.v1
    public final void M(SentryAndroidOptions sentryAndroidOptions) {
        this.f = l4.a;
        this.z = sentryAndroidOptions.isEnableActivityLifecycleBreadcrumbs();
        ILogger logger = sentryAndroidOptions.getLogger();
        p5 p5Var = p5.DEBUG;
        logger.h(p5Var, "ActivityBreadcrumbsIntegration enabled: %s", Boolean.valueOf(this.z));
        if (this.z) {
            this.b.registerActivityLifecycleCallbacks(this);
            sentryAndroidOptions.getLogger().h(p5Var, "ActivityBreadcrumbIntegration installed.", new Object[0]);
            io.sentry.util.b.a("ActivityBreadcrumbs");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.z) {
            this.b.unregisterActivityLifecycleCallbacks(this);
            io.sentry.f1 f1Var = this.f;
            if (f1Var != null) {
                f1Var.getOptions().getLogger().h(p5.DEBUG, "ActivityBreadcrumbsIntegration removed.", new Object[0]);
            }
        }
    }

    public final void g(Activity activity, String str) {
        if (this.f == null) {
            return;
        }
        io.sentry.g gVar = new io.sentry.g();
        gVar.X = "navigation";
        gVar.d(str, "state");
        gVar.d(activity.getClass().getSimpleName(), "screen");
        gVar.Z = "ui.lifecycle";
        gVar.z0 = p5.INFO;
        io.sentry.l0 l0Var = new io.sentry.l0();
        l0Var.d(activity, "android:activity");
        this.f.c(gVar, l0Var);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        io.sentry.util.a aVar = this.A;
        aVar.g();
        try {
            g(activity, "created");
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        io.sentry.util.a aVar = this.A;
        aVar.g();
        try {
            g(activity, "destroyed");
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        io.sentry.util.a aVar = this.A;
        aVar.g();
        try {
            g(activity, "paused");
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        io.sentry.util.a aVar = this.A;
        aVar.g();
        try {
            g(activity, "resumed");
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        io.sentry.util.a aVar = this.A;
        aVar.g();
        try {
            g(activity, "saveInstanceState");
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        io.sentry.util.a aVar = this.A;
        aVar.g();
        try {
            g(activity, "started");
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        io.sentry.util.a aVar = this.A;
        aVar.g();
        try {
            g(activity, "stopped");
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
