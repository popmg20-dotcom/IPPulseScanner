package io.sentry.android.core;

import android.content.Context;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r implements Supplier {
    public final /* synthetic */ Context b;
    public final /* synthetic */ SentryAndroidOptions f;

    public /* synthetic */ r(Context context, SentryAndroidOptions sentryAndroidOptions) {
        this.b = context;
        this.f = sentryAndroidOptions;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        SentryAndroidOptions sentryAndroidOptions = this.f;
        return new m1(this.b, sentryAndroidOptions.getLogger(), sentryAndroidOptions.getExecutorService());
    }
}
