package io.sentry.android.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.getsurfboard.ui.SurfboardApp;
import defpackage.o73;
import io.sentry.p5;
import io.sentry.w2;
import java.io.Closeable;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class FeedbackShakeIntegration implements io.sentry.v1, Closeable, Application.ActivityLifecycleCallbacks {
    public volatile WeakReference A;
    public volatile Runnable Y;
    public final SurfboardApp b;
    public SentryAndroidOptions z;
    public volatile boolean X = false;
    public final w1 f = new w1(w2.b);

    public FeedbackShakeIntegration(SurfboardApp surfboardApp) {
        this.b = surfboardApp;
    }

    @Override // io.sentry.v1
    public final void M(SentryAndroidOptions sentryAndroidOptions) {
        this.z = sentryAndroidOptions;
        if (sentryAndroidOptions.getFeedbackOptions().g) {
            w1 w1Var = this.f;
            synchronized (w1Var) {
                w1Var.g = false;
            }
            try {
                sentryAndroidOptions.getExecutorService().submit(new z(2, this, sentryAndroidOptions));
            } catch (Throwable th) {
                sentryAndroidOptions.getLogger().d(p5.WARNING, "Failed to submit shake detector initialization.", th);
            }
            io.sentry.util.b.a("FeedbackShake");
            this.b.registerActivityLifecycleCallbacks(this);
            sentryAndroidOptions.getLogger().h(p5.DEBUG, "FeedbackShakeIntegration installed.", new Object[0]);
            WeakReference weakReference = (WeakReference) q0.f.b;
            Activity activity = weakReference != null ? (Activity) weakReference.get() : null;
            if (activity != null) {
                this.A = new WeakReference(activity);
                w1 w1Var2 = this.f;
                if (this.z == null) {
                    return;
                }
                w1Var2.d();
                w1Var2.c(activity, new o73(20, this));
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.b.unregisterActivityLifecycleCallbacks(this);
        this.f.a();
        if (this.X) {
            this.X = false;
            SentryAndroidOptions sentryAndroidOptions = this.z;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getFeedbackOptions().h = this.Y;
            }
            this.Y = null;
        }
        this.A = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        Activity activity2 = this.A != null ? (Activity) this.A.get() : null;
        if (this.X && activity == activity2) {
            this.X = false;
            this.A = null;
            SentryAndroidOptions sentryAndroidOptions = this.z;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getFeedbackOptions().h = this.Y;
            }
            this.Y = null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (activity == (this.A != null ? (Activity) this.A.get() : null)) {
            this.f.d();
            if (this.X) {
                return;
            }
            this.A = null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        Activity activity2 = this.A != null ? (Activity) this.A.get() : null;
        if (this.X && activity2 != null && activity2 != activity) {
            this.X = false;
            SentryAndroidOptions sentryAndroidOptions = this.z;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getFeedbackOptions().h = this.Y;
            }
            this.Y = null;
        }
        this.A = new WeakReference(activity);
        w1 w1Var = this.f;
        if (this.z == null) {
            return;
        }
        w1Var.d();
        w1Var.c(activity, new o73(20, this));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
