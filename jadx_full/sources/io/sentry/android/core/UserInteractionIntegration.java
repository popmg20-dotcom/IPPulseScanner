package io.sentry.android.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.Window;
import com.getsurfboard.ui.SurfboardApp;
import defpackage.da2;
import defpackage.q92;
import io.sentry.ILogger;
import io.sentry.f7;
import io.sentry.l4;
import io.sentry.p5;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class UserInteractionIntegration implements io.sentry.v1, Closeable, Application.ActivityLifecycleCallbacks {
    public final SurfboardApp b;
    public io.sentry.f1 f;
    public final WeakHashMap X = new WeakHashMap();
    public final Object Y = new Object();
    public SentryAndroidOptions z;
    public final boolean A = io.sentry.util.g.b(this.z, "androidx.lifecycle.Lifecycle");

    public UserInteractionIntegration(SurfboardApp surfboardApp) {
        this.b = surfboardApp;
    }

    @Override // io.sentry.v1
    public final void M(SentryAndroidOptions sentryAndroidOptions) {
        this.z = sentryAndroidOptions;
        this.f = l4.a;
        boolean z = sentryAndroidOptions.isEnableUserInteractionBreadcrumbs() || this.z.isEnableUserInteractionTracing();
        ILogger logger = this.z.getLogger();
        p5 p5Var = p5.DEBUG;
        logger.h(p5Var, "UserInteractionIntegration enabled: %s", Boolean.valueOf(z));
        if (z) {
            this.b.registerActivityLifecycleCallbacks(this);
            this.z.getLogger().h(p5Var, "UserInteractionIntegration installed.", new Object[0]);
            io.sentry.util.b.a("UserInteraction");
            if (this.A) {
                WeakReference weakReference = (WeakReference) q0.f.b;
                Activity activity = weakReference != null ? (Activity) weakReference.get() : null;
                if ((activity instanceof da2) && ((da2) activity).getLifecycle().b() == q92.X) {
                    g(activity);
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ArrayList<Window> arrayList;
        this.b.unregisterActivityLifecycleCallbacks(this);
        synchronized (this.Y) {
            arrayList = new ArrayList(this.X.keySet());
        }
        for (Window window : arrayList) {
            if (window != null) {
                n(window);
            }
        }
        synchronized (this.Y) {
            this.X.clear();
        }
        SentryAndroidOptions sentryAndroidOptions = this.z;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().h(p5.DEBUG, "UserInteractionIntegration removed.", new Object[0]);
        }
    }

    public final void g(Activity activity) {
        Window window = activity.getWindow();
        if (window == null) {
            SentryAndroidOptions sentryAndroidOptions = this.z;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().h(p5.INFO, "Window was null in startTracking", new Object[0]);
                return;
            }
            return;
        }
        if (this.f == null || this.z == null) {
            return;
        }
        synchronized (this.Y) {
            try {
                WeakReference weakReference = (WeakReference) this.X.get(window);
                if (weakReference == null || weakReference.get() == null) {
                    Window.Callback callback = window.getCallback();
                    if (callback == null) {
                        callback = new io.sentry.android.core.internal.gestures.b();
                    }
                    io.sentry.android.core.internal.gestures.h hVar = new io.sentry.android.core.internal.gestures.h(callback, activity, new io.sentry.android.core.internal.gestures.g(activity, this.f, this.z), this.z);
                    window.setCallback(hVar);
                    synchronized (this.Y) {
                        this.X.put(window, new WeakReference(hVar));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void n(Window window) {
        io.sentry.android.core.internal.gestures.h hVar;
        Window.Callback callback = window.getCallback();
        if (callback instanceof io.sentry.android.core.internal.gestures.h) {
            io.sentry.android.core.internal.gestures.h hVar2 = (io.sentry.android.core.internal.gestures.h) callback;
            hVar2.Y = true;
            hVar2.z.d(f7.CANCELLED);
            hVar2.A.a();
            Window.Callback callback2 = hVar2.f;
            if (callback2 instanceof io.sentry.android.core.internal.gestures.b) {
                window.setCallback(null);
            } else {
                window.setCallback(callback2);
            }
            synchronized (this.Y) {
                this.X.remove(window);
            }
            return;
        }
        synchronized (this.Y) {
            try {
                WeakReference weakReference = (WeakReference) this.X.remove(window);
                hVar = weakReference != null ? (io.sentry.android.core.internal.gestures.h) weakReference.get() : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (hVar != null) {
            hVar.Y = true;
            hVar.z.d(f7.CANCELLED);
            hVar.A.a();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        Window window = activity.getWindow();
        if (window != null) {
            n(window);
            return;
        }
        SentryAndroidOptions sentryAndroidOptions = this.z;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().h(p5.INFO, "Window was null in stopTracking", new Object[0]);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        g(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
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
