package io.sentry.android.core.internal.gestures;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import defpackage.ed;
import defpackage.fw;
import defpackage.ha0;
import defpackage.o73;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.f1;
import io.sentry.f7;
import io.sentry.j7;
import io.sentry.k7;
import io.sentry.l0;
import io.sentry.p1;
import io.sentry.p5;
import io.sentry.protocol.i0;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class g implements GestureDetector.OnGestureListener {
    public final WeakReference a;
    public final f1 b;
    public final SentryAndroidOptions c;
    public io.sentry.internal.gestures.b d = null;
    public p1 e = null;
    public e f;
    public final f g;

    public g(Activity activity, f1 f1Var, SentryAndroidOptions sentryAndroidOptions) {
        e eVar = e.Unknown;
        this.f = eVar;
        f fVar = new f();
        fVar.a = eVar;
        fVar.c = 0.0f;
        fVar.d = 0.0f;
        this.g = fVar;
        this.a = new WeakReference(activity);
        this.b = f1Var;
        this.c = sentryAndroidOptions;
    }

    public final void a(io.sentry.internal.gestures.b bVar, e eVar, Map map, MotionEvent motionEvent) {
        if (this.c.isEnableUserInteractionBreadcrumbs()) {
            int i = d.a[eVar.ordinal()];
            String str = i != 1 ? i != 2 ? i != 3 ? "unknown" : "swipe" : "scroll" : "click";
            l0 l0Var = new l0();
            l0Var.d(motionEvent, "android:motionEvent");
            l0Var.d(bVar.a.get(), "android:view");
            String str2 = bVar.c;
            String str3 = bVar.b;
            io.sentry.g gVar = new io.sentry.g();
            gVar.X = "user";
            gVar.Z = "ui.".concat(str);
            gVar.d(str2, "view.id");
            if (str3 != null) {
                gVar.d(str3, "view.class");
            }
            for (Map.Entry entry : map.entrySet()) {
                gVar.d(entry.getValue(), (String) entry.getKey());
            }
            gVar.z0 = p5.INFO;
            this.b.c(gVar, l0Var);
        }
    }

    public final View b(String str) {
        Activity activity = (Activity) this.a.get();
        SentryAndroidOptions sentryAndroidOptions = this.c;
        if (activity == null) {
            sentryAndroidOptions.getLogger().h(p5.DEBUG, ha0.o("Activity is null in ", str, ". No breadcrumb captured."), new Object[0]);
            return null;
        }
        Window window = activity.getWindow();
        if (window == null) {
            sentryAndroidOptions.getLogger().h(p5.DEBUG, ha0.o("Window is null in ", str, ". No breadcrumb captured."), new Object[0]);
            return null;
        }
        View viewPeekDecorView = window.peekDecorView();
        if (viewPeekDecorView != null) {
            return viewPeekDecorView;
        }
        sentryAndroidOptions.getLogger().h(p5.DEBUG, ha0.o("DecorView is null in ", str, ". No breadcrumb captured."), new Object[0]);
        return null;
    }

    public final void c(io.sentry.internal.gestures.b bVar, e eVar) {
        boolean z = eVar == e.Click || !(eVar == this.f && bVar.equals(this.d));
        SentryAndroidOptions sentryAndroidOptions = this.c;
        boolean zIsTracingEnabled = sentryAndroidOptions.isTracingEnabled();
        f1 f1Var = this.b;
        if (!zIsTracingEnabled || !sentryAndroidOptions.isEnableUserInteractionTracing()) {
            if (z) {
                if (sentryAndroidOptions.isEnableAutoTraceIdGeneration()) {
                    f1Var.w(new io.sentry.android.core.cache.a(7));
                }
                this.d = bVar;
                this.f = eVar;
                return;
            }
            return;
        }
        Activity activity = (Activity) this.a.get();
        if (activity == null) {
            sentryAndroidOptions.getLogger().h(p5.DEBUG, "Activity is null, no transaction captured.", new Object[0]);
            return;
        }
        String str = bVar.c;
        p1 p1Var = this.e;
        if (p1Var != null) {
            if (!z && !p1Var.isFinished()) {
                sentryAndroidOptions.getLogger().h(p5.DEBUG, ha0.o("The view with id: ", str, " already has an ongoing transaction assigned. Rescheduling finish"), new Object[0]);
                if (sentryAndroidOptions.getIdleTimeout() != null) {
                    this.e.p();
                    return;
                }
                return;
            }
            d(f7.OK);
        }
        p1[] p1VarArr = {null};
        f1Var.w(new o73(24, p1VarArr));
        if (p1VarArr[0] != null) {
            sentryAndroidOptions.getLogger().h(p5.DEBUG, "Transaction won't be created for view with id: %s since there's already a transaction bound to the Scope.", str);
            return;
        }
        String strY = fw.y(new StringBuilder(activity.getClass().getSimpleName()), ".", str);
        int i = d.a[eVar.ordinal()];
        String strConcat = "ui.action.".concat(i != 1 ? i != 2 ? i != 3 ? "unknown" : "swipe" : "scroll" : "click");
        k7 k7Var = new k7();
        k7Var.f = true;
        long deadlineTimeout = sentryAndroidOptions.getDeadlineTimeout();
        k7Var.h = deadlineTimeout <= 0 ? null : Long.valueOf(deadlineTimeout);
        k7Var.g = sentryAndroidOptions.getIdleTimeout();
        k7Var.c = true;
        k7Var.d = "auto.ui.gesture_listener.old_view_system";
        p1 p1VarM = f1Var.m(new j7(strY, i0.COMPONENT, strConcat, null), k7Var);
        f1Var.w(new ed(27, this, p1VarM));
        this.e = p1VarM;
        this.d = bVar;
        this.f = eVar;
    }

    public final void d(f7 f7Var) {
        p1 p1Var = this.e;
        if (p1Var != null) {
            f7 status = p1Var.getStatus();
            p1 p1Var2 = this.e;
            if (status == null) {
                p1Var2.f(f7Var);
            } else {
                p1Var2.g();
            }
        }
        this.b.w(new o73(23, this));
        this.e = null;
        if (this.d != null) {
            this.d = null;
        }
        this.f = e.Unknown;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        f fVar = this.g;
        fVar.b = null;
        fVar.a = e.Unknown;
        fVar.c = 0.0f;
        fVar.d = 0.0f;
        fVar.c = motionEvent.getX();
        fVar.d = motionEvent.getY();
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.g.a = e.Swipe;
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        View viewB = b("onScroll");
        if (viewB != null && motionEvent != null) {
            f fVar = this.g;
            if (fVar.a == e.Unknown) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                io.sentry.internal.gestures.a aVar = io.sentry.internal.gestures.a.SCROLLABLE;
                SentryAndroidOptions sentryAndroidOptions = this.c;
                io.sentry.internal.gestures.b bVarD = io.sentry.config.a.d(sentryAndroidOptions, viewB, x, y, aVar);
                if (bVarD == null) {
                    sentryAndroidOptions.getLogger().h(p5.DEBUG, "Unable to find scroll target. No breadcrumb captured.", new Object[0]);
                    fVar.a = e.Scroll;
                    return false;
                }
                sentryAndroidOptions.getLogger().h(p5.DEBUG, "Scroll target found: ".concat(bVarD.c), new Object[0]);
                fVar.b = bVarD;
                fVar.a = e.Scroll;
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        View viewB = b("onSingleTapUp");
        if (viewB != null && motionEvent != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            io.sentry.internal.gestures.a aVar = io.sentry.internal.gestures.a.CLICKABLE;
            SentryAndroidOptions sentryAndroidOptions = this.c;
            io.sentry.internal.gestures.b bVarD = io.sentry.config.a.d(sentryAndroidOptions, viewB, x, y, aVar);
            if (bVarD == null) {
                sentryAndroidOptions.getLogger().h(p5.DEBUG, "Unable to find click target. No breadcrumb captured.", new Object[0]);
                return false;
            }
            e eVar = e.Click;
            a(bVarD, eVar, Collections.EMPTY_MAP, motionEvent);
            c(bVarD, eVar);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent motionEvent) {
    }
}
