package io.sentry.android.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import defpackage.ed;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z1 implements Application.ActivityLifecycleCallbacks {
    public final WeakReference b;
    public final /* synthetic */ a2 f;

    public z1(a2 a2Var, WeakReference weakReference) {
        this.f = a2Var;
        this.b = weakReference;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        Activity activity2;
        if (activity == this.b.get()) {
            a2 a2Var = this.f;
            w1 w1Var = a2Var.X;
            if (w1Var != null) {
                w1Var.a();
                a2Var.X = null;
            }
            if (a2Var.Y != null) {
                Context context = a2Var.getContext();
                while (true) {
                    if (!(context instanceof ContextWrapper)) {
                        activity2 = null;
                        break;
                    } else {
                        if (context instanceof Activity) {
                            activity2 = (Activity) context;
                            break;
                        }
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                }
                if (activity2 != null) {
                    activity2.getApplication().unregisterActivityLifecycleCallbacks(a2Var.Y);
                }
                a2Var.Y = null;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        w1 w1Var;
        if (activity != this.b.get() || (w1Var = this.f.X) == null) {
            return;
        }
        w1Var.d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a2 a2Var;
        w1 w1Var;
        WeakReference weakReference = this.b;
        if (activity != weakReference.get() || (w1Var = (a2Var = this.f).X) == null) {
            return;
        }
        w1Var.c(activity, new ed(26, a2Var, weakReference));
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
