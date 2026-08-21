package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class di implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    public static final di X = new di();
    public final AtomicBoolean b = new AtomicBoolean();
    public final AtomicBoolean f = new AtomicBoolean();
    public final ArrayList z = new ArrayList();
    public boolean A = false;

    public static void b(Application application) {
        di diVar = X;
        synchronized (diVar) {
            try {
                if (!diVar.A) {
                    application.registerActivityLifecycleCallbacks(diVar);
                    application.registerComponentCallbacks(diVar);
                    diVar.A = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(ci ciVar) {
        synchronized (X) {
            this.z.add(ciVar);
        }
    }

    public final void c(boolean z) {
        synchronized (X) {
            try {
                Iterator it = this.z.iterator();
                while (it.hasNext()) {
                    ((ci) it.next()).a(z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean zCompareAndSet = this.b.compareAndSet(true, false);
        this.f.set(true);
        if (zCompareAndSet) {
            c(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        boolean zCompareAndSet = this.b.compareAndSet(true, false);
        this.f.set(true);
        if (zCompareAndSet) {
            c(false);
        }
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        if (i == 20 && this.b.compareAndSet(false, true)) {
            this.f.set(true);
            c(true);
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
