package io.sentry.android.core;

import android.app.Activity;
import android.view.View;
import io.sentry.p5;
import io.sentry.r5;
import io.sentry.r6;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ScreenshotEventProcessor implements io.sentry.f0 {
    public final boolean A;
    public final SentryAndroidOptions b;
    public final q0 f;
    public final AtomicBoolean X = new AtomicBoolean(false);
    public final io.sentry.android.core.internal.util.f z = new io.sentry.android.core.internal.util.f(2000, 3);

    public ScreenshotEventProcessor(SentryAndroidOptions sentryAndroidOptions, q0 q0Var, boolean z) {
        this.b = sentryAndroidOptions;
        this.f = q0Var;
        this.A = z;
        if (sentryAndroidOptions.isAttachScreenshot()) {
            io.sentry.util.b.a("Screenshot");
        }
    }

    public final io.sentry.android.replay.viewhierarchy.h a(Activity activity) {
        SentryAndroidOptions sentryAndroidOptions = this.b;
        try {
            View rootView = (activity.getWindow() == null || activity.getWindow().peekDecorView() == null || activity.getWindow().peekDecorView().getRootView() == null) ? null : activity.getWindow().peekDecorView().getRootView();
            if (rootView == null) {
                return null;
            }
            io.sentry.android.replay.viewhierarchy.h hVarE = io.sentry.config.a.e(rootView, null, sentryAndroidOptions.getScreenshot());
            io.sentry.android.replay.util.o.b(rootView, hVarE, sentryAndroidOptions.getScreenshot(), sentryAndroidOptions.getLogger(), null);
            return hVarE;
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().d(p5.ERROR, "Failed to build view hierarchy", th);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:94:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0160  */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [android.graphics.Bitmap] */
    @Override // io.sentry.f0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final io.sentry.f5 n(io.sentry.f5 r14, io.sentry.l0 r15) {
        /*
            Method dump skipped, instruction units count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.ScreenshotEventProcessor.n(io.sentry.f5, io.sentry.l0):io.sentry.f5");
    }

    @Override // io.sentry.f0
    public final r5 x(r5 r5Var) {
        return r5Var;
    }

    @Override // io.sentry.f0
    public final r6 g(r6 r6Var, io.sentry.l0 l0Var) {
        return r6Var;
    }

    @Override // io.sentry.f0
    public final io.sentry.protocol.f0 s(io.sentry.protocol.f0 f0Var, io.sentry.l0 l0Var) {
        return f0Var;
    }
}
