package io.sentry.android.core.internal.util;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import defpackage.iy;
import io.sentry.android.core.q0;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i implements ViewTreeObserver.OnDrawListener {
    public final Handler b = new Handler(Looper.getMainLooper());
    public final AtomicReference f;
    public final Runnable z;

    public i(View view, Runnable runnable) {
        this.f = new AtomicReference(view);
        this.z = runnable;
    }

    public static void a(Activity activity, Runnable runnable, q0 q0Var) {
        Window window = activity.getWindow();
        if (window != null) {
            View viewPeekDecorView = window.peekDecorView();
            if (viewPeekDecorView != null) {
                b(viewPeekDecorView, runnable, q0Var);
            } else {
                Window.Callback callback = window.getCallback();
                window.setCallback(new io.sentry.android.core.performance.i(callback != null ? callback : new io.sentry.android.core.internal.gestures.b(), new iy(window, callback, runnable, q0Var, 9)));
            }
        }
    }

    public static void b(View view, Runnable runnable, q0 q0Var) {
        i iVar = new i(view, runnable);
        if (Build.VERSION.SDK_INT >= 26 || (view.getViewTreeObserver().isAlive() && view.isAttachedToWindow())) {
            view.getViewTreeObserver().addOnDrawListener(iVar);
        } else {
            view.addOnAttachStateChangeListener(new g(iVar));
        }
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        View view = (View) this.f.getAndSet(null);
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new h(this, view));
        this.b.postAtFrontOfQueue(this.z);
    }
}
