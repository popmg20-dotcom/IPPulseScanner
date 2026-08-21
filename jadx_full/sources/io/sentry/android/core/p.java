package io.sentry.android.core;

import defpackage.cm2;
import io.sentry.p5;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p extends cm2 implements g0 {
    @Override // defpackage.cm2, io.sentry.metrics.a
    public final void a(boolean z) {
        j0.X.x(this);
        super.a(z);
    }

    @Override // io.sentry.android.core.g0
    public final void n() {
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) this.f;
        try {
            sentryAndroidOptions.getExecutorService().submit(new m(this, 1));
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().b(p5.ERROR, th, "Failed to submit metrics flush in onBackground()", new Object[0]);
        }
    }

    @Override // io.sentry.android.core.g0
    public final void g() {
    }
}
