package io.sentry.android.core;

import io.sentry.e4;
import io.sentry.p5;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements e4 {
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public /* synthetic */ e(Object obj, Object obj2, Object obj3) {
        this.b = obj;
        this.f = obj2;
        this.z = obj3;
    }

    @Override // io.sentry.e4
    public void h(io.sentry.p1 p1Var) {
        ActivityLifecycleIntegration activityLifecycleIntegration = (ActivityLifecycleIntegration) this.b;
        io.sentry.d1 d1Var = (io.sentry.d1) this.f;
        io.sentry.p1 p1Var2 = (io.sentry.p1) this.z;
        if (p1Var == null) {
            d1Var.F(p1Var2);
            return;
        }
        SentryAndroidOptions sentryAndroidOptions = activityLifecycleIntegration.A;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().h(p5.DEBUG, "Transaction '%s' won't be bound to the Scope since there's one already in there.", p1Var2.getName());
        }
    }
}
