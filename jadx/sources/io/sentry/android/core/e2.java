package io.sentry.android.core;

import android.content.BroadcastReceiver;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e2 extends BroadcastReceiver {
    public final io.sentry.f1 a;
    public final SentryAndroidOptions b;
    public final io.sentry.android.core.internal.util.f c = new io.sentry.android.core.internal.util.f(60000, 0);
    public final char[] d = new char[64];
    public final /* synthetic */ SystemEventsBreadcrumbsIntegration e;

    public e2(SystemEventsBreadcrumbsIntegration systemEventsBreadcrumbsIntegration, io.sentry.f1 f1Var, SentryAndroidOptions sentryAndroidOptions) {
        this.e = systemEventsBreadcrumbsIntegration;
        this.a = f1Var;
        this.b = sentryAndroidOptions;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x008e, code lost:
    
        r2 = r13;
     */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onReceive(android.content.Context r13, android.content.Intent r14) {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.e2.onReceive(android.content.Context, android.content.Intent):void");
    }
}
