package io.sentry.android.fragment;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.p;
import defpackage.ak1;
import defpackage.eg0;
import defpackage.k41;
import defpackage.n12;
import defpackage.qj1;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.f1;
import io.sentry.l4;
import io.sentry.n5;
import io.sentry.p5;
import io.sentry.v1;
import java.io.Closeable;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentLifecycleIntegration implements Application.ActivityLifecycleCallbacks, v1, Closeable {
    public f1 A;
    public SentryAndroidOptions X;
    public final Application b;
    public final Set f;
    public final boolean z;

    static {
        n5.d().b("maven:io.sentry:sentry-android-fragment", "8.51.0");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FragmentLifecycleIntegration(Application application, boolean z, boolean z2) {
        application.getClass();
        b.Companion.getClass();
        Set set = z ? b.states : null;
        this(application, (Set<? extends b>) (set == null ? k41.b : set), z2);
    }

    @Override // io.sentry.v1
    public final void M(SentryAndroidOptions sentryAndroidOptions) {
        this.A = l4.a;
        this.X = sentryAndroidOptions;
        this.b.registerActivityLifecycleCallbacks(this);
        sentryAndroidOptions.getLogger().h(p5.DEBUG, "FragmentLifecycleIntegration installed.", new Object[0]);
        io.sentry.util.b.a("FragmentLifecycle");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.b.unregisterActivityLifecycleCallbacks(this);
        SentryAndroidOptions sentryAndroidOptions = this.X;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().h(p5.DEBUG, "FragmentLifecycleIntegration removed.", new Object[0]);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        activity.getClass();
        p pVar = activity instanceof p ? (p) activity : null;
        if (pVar != null) {
            ak1 ak1VarU = pVar.u();
            f1 f1Var = this.A;
            if (f1Var == null) {
                n12.T("scopes");
                throw null;
            }
            d dVar = new d(f1Var, this.f, this.z);
            eg0 eg0Var = ak1VarU.p;
            eg0Var.getClass();
            ((CopyOnWriteArrayList) eg0Var.z).add(new qj1(dVar, true));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        activity.getClass();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        activity.getClass();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        activity.getClass();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        activity.getClass();
        bundle.getClass();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        activity.getClass();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        activity.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FragmentLifecycleIntegration(Application application) {
        this(application, (Set<? extends b>) b.states, false);
        application.getClass();
        b.Companion.getClass();
    }

    public FragmentLifecycleIntegration(Application application, Set<? extends b> set, boolean z) {
        application.getClass();
        set.getClass();
        this.b = application;
        this.f = set;
        this.z = z;
    }
}
