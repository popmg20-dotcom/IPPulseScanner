package io.sentry.android.core;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import defpackage.ft4;
import defpackage.iy;
import io.sentry.f5;
import io.sentry.p5;
import io.sentry.r5;
import io.sentry.r6;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

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
    */
    public final f5 n(f5 f5Var, io.sentry.l0 l0Var) {
        Bitmap bitmapA;
        ScreenshotEventProcessor screenshotEventProcessor;
        Bitmap bitmap;
        io.sentry.android.replay.viewhierarchy.h hVarA;
        Throwable th;
        ?? r6;
        io.sentry.android.replay.util.g gVar;
        boolean z;
        ?? r62;
        ?? IsMutable;
        Bitmap bitmap2;
        if (f5Var.g()) {
            SentryAndroidOptions sentryAndroidOptions = this.b;
            boolean z2 = false;
            if (!sentryAndroidOptions.isAttachScreenshot()) {
                sentryAndroidOptions.getLogger().h(p5.DEBUG, "attachScreenshot is disabled.", new Object[0]);
                return f5Var;
            }
            boolean z3 = this.A;
            if (z3 || ((CopyOnWriteArraySet) sentryAndroidOptions.getScreenshot().a).isEmpty()) {
                WeakReference weakReference = (WeakReference) q0.f.b;
                Bitmap bitmap3 = null;
                bitmap3 = null;
                bitmap3 = null;
                bitmap3 = null;
                Activity activity = weakReference != null ? (Activity) weakReference.get() : null;
                if (activity != null && !io.sentry.util.b.k(l0Var)) {
                    boolean zA = this.z.a();
                    sentryAndroidOptions.getBeforeScreenshotCaptureCallback();
                    if (!zA && (bitmapA = io.sentry.android.core.internal.util.k.a(activity, sentryAndroidOptions.getThreadChecker(), sentryAndroidOptions.getLogger(), this.f)) != null) {
                        if (((CopyOnWriteArraySet) sentryAndroidOptions.getScreenshot().a).isEmpty() || !z3) {
                            screenshotEventProcessor = this;
                            bitmap = bitmapA;
                        } else {
                            if (sentryAndroidOptions.getThreadChecker().c()) {
                                hVarA = a(activity);
                                screenshotEventProcessor = this;
                            } else {
                                AtomicReference atomicReference = new AtomicReference(null);
                                CountDownLatch countDownLatch = new CountDownLatch(1);
                                try {
                                    screenshotEventProcessor = this;
                                    try {
                                        activity.runOnUiThread(new iy(screenshotEventProcessor, atomicReference, activity, countDownLatch, 8));
                                        if (countDownLatch.await(2000L, TimeUnit.MILLISECONDS)) {
                                            hVarA = (io.sentry.android.replay.viewhierarchy.h) atomicReference.get();
                                        } else {
                                            sentryAndroidOptions.getLogger().h(p5.WARNING, "Timed out waiting for view hierarchy capture on main thread", new Object[0]);
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        sentryAndroidOptions.getLogger().d(p5.ERROR, "Failed to capture view hierarchy", th);
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    screenshotEventProcessor = this;
                                }
                                hVarA = null;
                            }
                            if (hVarA == null) {
                                bitmapA.recycle();
                                return f5Var;
                            }
                            try {
                                gVar = new io.sentry.android.replay.util.g();
                                try {
                                    IsMutable = bitmapA.isMutable();
                                } catch (Throwable th4) {
                                    th = th4;
                                    z = false;
                                    r62 = bitmapA;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                r6 = bitmapA;
                            }
                            try {
                                try {
                                } catch (Throwable th6) {
                                    th = th6;
                                    bitmap3 = bitmap3;
                                    r6 = IsMutable;
                                    sentryAndroidOptions.getLogger().d(p5.ERROR, "Failed to mask screenshot", th);
                                    if (z2) {
                                        r6.recycle();
                                    }
                                    if (!bitmapA.isRecycled()) {
                                    }
                                }
                                if (IsMutable == 0) {
                                    Bitmap bitmapCopy = bitmapA.copy(Bitmap.Config.ARGB_8888, true);
                                    if (bitmapCopy == null) {
                                        bitmapA.recycle();
                                        gVar.close();
                                        IsMutable = bitmapCopy;
                                        if (bitmap3 != null) {
                                            bitmap = bitmap3;
                                        }
                                    } else {
                                        z2 = true;
                                        bitmap2 = bitmapCopy;
                                    }
                                } else {
                                    bitmap2 = bitmapA;
                                }
                                gVar.g(bitmap2, hVarA, null);
                                if (z2 && !bitmapA.isRecycled()) {
                                    bitmapA.recycle();
                                }
                                gVar.close();
                                bitmap3 = bitmap2;
                                IsMutable = bitmap2;
                                if (bitmap3 != null) {
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                z = false;
                                r62 = IsMutable;
                                Throwable th8 = th;
                                try {
                                    try {
                                        gVar.close();
                                        throw th8;
                                    } catch (Throwable th9) {
                                        th8.addSuppressed(th9);
                                        throw th8;
                                    }
                                } catch (Throwable th10) {
                                    th = th10;
                                    z2 = z;
                                    r6 = r62;
                                    sentryAndroidOptions.getLogger().d(p5.ERROR, "Failed to mask screenshot", th);
                                    if (z2 && !r6.isRecycled()) {
                                        r6.recycle();
                                    }
                                    if (!bitmapA.isRecycled()) {
                                        bitmapA.recycle();
                                    }
                                    if (bitmap3 != null) {
                                    }
                                    return f5Var;
                                }
                            }
                        }
                        l0Var.d = new io.sentry.a(new ft4(9, screenshotEventProcessor, bitmap));
                        l0Var.d(activity, "android:activity");
                    }
                }
            } else if (!this.X.getAndSet(true)) {
                sentryAndroidOptions.getLogger().h(p5.WARNING, "Screenshot masking requires sentry-android-replay module", new Object[0]);
                return f5Var;
            }
        }
        return f5Var;
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
