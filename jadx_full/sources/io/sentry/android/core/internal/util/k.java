package io.sentry.android.core.internal.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.PixelCopy;
import android.view.View;
import android.view.Window;
import defpackage.iy;
import defpackage.mf2;
import io.sentry.ILogger;
import io.sentry.android.core.q0;
import io.sentry.p5;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class k {
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00da A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap a(Activity activity, io.sentry.util.thread.a aVar, ILogger iLogger, q0 q0Var) {
        ILogger iLogger2;
        Throwable th;
        boolean z = false;
        if (activity.isFinishing() || activity.isDestroyed()) {
            iLogger.h(p5.DEBUG, "Activity isn't valid, not taking screenshot.", new Object[0]);
            return null;
        }
        Window window = activity.getWindow();
        if (window == null) {
            iLogger.h(p5.DEBUG, "Activity window is null, not taking screenshot.", new Object[0]);
            return null;
        }
        View viewPeekDecorView = window.peekDecorView();
        if (viewPeekDecorView == null) {
            iLogger.h(p5.DEBUG, "DecorView is null, not taking screenshot.", new Object[0]);
            return null;
        }
        View rootView = viewPeekDecorView.getRootView();
        if (rootView == null) {
            iLogger.h(p5.DEBUG, "Root view is null, not taking screenshot.", new Object[0]);
            return null;
        }
        if (rootView.getWidth() <= 0 || rootView.getHeight() <= 0) {
            iLogger.h(p5.DEBUG, "View's width and height is zeroed, not taking screenshot.", new Object[0]);
            return null;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(rootView.getWidth(), rootView.getHeight(), Bitmap.Config.ARGB_8888);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            int i = Build.VERSION.SDK_INT;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            try {
                if (i >= 26) {
                    HandlerThread handlerThread = new HandlerThread("SentryScreenshot");
                    handlerThread.start();
                    try {
                        Handler handler = new Handler(handlerThread.getLooper());
                        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                        PixelCopy.request(window, bitmapCreateBitmap, new mf2(1, atomicBoolean, countDownLatch), handler);
                        if (countDownLatch.await(1000L, timeUnit)) {
                            if (atomicBoolean.get()) {
                                z = true;
                            }
                        }
                    } finally {
                        try {
                        } finally {
                        }
                    }
                    if (z) {
                        return bitmapCreateBitmap;
                    }
                    return null;
                }
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                if (aVar.c()) {
                    rootView.draw(canvas);
                    countDownLatch.countDown();
                    iLogger2 = iLogger;
                } else {
                    iLogger2 = iLogger;
                    try {
                        activity.runOnUiThread(new iy(rootView, canvas, iLogger2, countDownLatch, 10));
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                if (!countDownLatch.await(1000L, timeUnit)) {
                }
            } catch (Throwable th3) {
                th = th3;
                iLogger2 = iLogger;
            }
        } catch (Throwable th4) {
            th = th4;
            iLogger2 = iLogger;
        }
        th = th;
        iLogger2.d(p5.ERROR, "Taking screenshot failed.", th);
        return null;
    }
}
