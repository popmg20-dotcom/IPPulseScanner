package defpackage;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i4 implements Application.ActivityLifecycleCallbacks {
    public boolean A = false;
    public boolean X = false;
    public boolean Y = false;
    public Object b;
    public Activity f;
    public final int z;

    public i4(Activity activity) {
        this.f = activity;
        this.z = activity.hashCode();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (this.f == activity) {
            this.f = null;
            this.X = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (!this.X || this.Y || this.A) {
            return;
        }
        Object obj = this.b;
        try {
            Object obj2 = j4.c.get(activity);
            if (obj2 == obj && activity.hashCode() == this.z) {
                j4.g.postAtFrontOfQueue(new um1(2, j4.b.get(activity), obj2));
                this.Y = true;
                this.b = null;
            }
        } catch (Throwable th) {
            a1.e("ActivityRecreator", "Exception while fetching field values", th);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        if (this.f == activity) {
            this.A = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
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
