package io.sentry.android.ndk;

import defpackage.hw;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.z;
import io.sentry.b7;
import io.sentry.f4;
import io.sentry.g;
import io.sentry.i4;
import io.sentry.p5;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b extends i4 {
    public final SentryAndroidOptions a;

    public b(SentryAndroidOptions sentryAndroidOptions) {
        this.a = sentryAndroidOptions;
    }

    @Override // io.sentry.e1
    public final void g(g gVar) {
        SentryAndroidOptions sentryAndroidOptions = this.a;
        try {
            sentryAndroidOptions.getExecutorService().submit(new z(8, this, gVar));
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().b(p5.ERROR, th, "Scope sync addBreadcrumb has an error.", new Object[0]);
        }
    }

    @Override // io.sentry.i4, io.sentry.e1
    public final void j(String str, String str2) {
        SentryAndroidOptions sentryAndroidOptions = this.a;
        try {
            sentryAndroidOptions.getExecutorService().submit(new z(this, str, str2));
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().b(p5.ERROR, th, "Scope sync setTag(%s) has an error.", str);
        }
    }

    @Override // io.sentry.i4, io.sentry.e1
    public final void k() {
        SentryAndroidOptions sentryAndroidOptions = this.a;
        try {
            sentryAndroidOptions.getExecutorService().submit(new hw(4, this));
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().b(p5.ERROR, th, "Scope sync clearAttachments has an error.", new Object[0]);
        }
    }

    @Override // io.sentry.e1
    public final void m(b7 b7Var, f4 f4Var) {
        SentryAndroidOptions sentryAndroidOptions = this.a;
        if (b7Var == null) {
            return;
        }
        try {
            sentryAndroidOptions.getExecutorService().submit(new io.sentry.android.core.g(11, this, b7Var));
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().b(p5.ERROR, th, "Scope sync setTrace failed.", new Object[0]);
        }
    }

    @Override // io.sentry.i4, io.sentry.e1
    public final void p(String str) {
        SentryAndroidOptions sentryAndroidOptions = this.a;
        try {
            sentryAndroidOptions.getExecutorService().submit(new io.sentry.android.core.g(10, this, str));
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().b(p5.ERROR, th, "Scope sync removeTag(%s) has an error.", str);
        }
    }
}
