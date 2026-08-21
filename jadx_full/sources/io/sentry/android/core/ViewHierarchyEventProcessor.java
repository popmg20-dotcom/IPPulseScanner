package io.sentry.android.core;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import defpackage.dw2;
import defpackage.iw2;
import io.sentry.ILogger;
import io.sentry.f5;
import io.sentry.p5;
import io.sentry.r5;
import io.sentry.r6;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ViewHierarchyEventProcessor implements io.sentry.f0 {
    public final SentryAndroidOptions b;
    public final io.sentry.android.core.internal.util.f f = new io.sentry.android.core.internal.util.f(2000, 3);

    public ViewHierarchyEventProcessor(SentryAndroidOptions sentryAndroidOptions) {
        this.b = sentryAndroidOptions;
        if (sentryAndroidOptions.isAttachViewHierarchy()) {
            io.sentry.util.b.a("ViewHierarchy");
        }
    }

    public static void a(View view, io.sentry.protocol.l0 l0Var, List list) {
        if (view instanceof ViewGroup) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                throw dw2.z(it);
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList(childCount);
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != null) {
                    io.sentry.protocol.l0 l0VarB = b(childAt);
                    arrayList.add(l0VarB);
                    a(childAt, l0VarB, list);
                }
            }
            l0Var.B0 = arrayList;
        }
    }

    public static io.sentry.protocol.l0 b(View view) {
        io.sentry.protocol.l0 l0Var = new io.sentry.protocol.l0();
        l0Var.f = io.sentry.config.a.g(view);
        try {
            String strK = io.sentry.config.a.k(view);
            if (strK != null) {
                l0Var.z = strK;
            }
        } catch (Throwable unused) {
        }
        l0Var.Z = Double.valueOf(view.getX());
        l0Var.y0 = Double.valueOf(view.getY());
        l0Var.X = Double.valueOf(view.getWidth());
        l0Var.Y = Double.valueOf(view.getHeight());
        l0Var.A0 = Double.valueOf(view.getAlpha());
        int visibility = view.getVisibility();
        if (visibility == 0) {
            l0Var.z0 = "visible";
        } else if (visibility == 4) {
            l0Var.z0 = "invisible";
        } else if (visibility == 8) {
            l0Var.z0 = "gone";
        }
        return l0Var;
    }

    @Override // io.sentry.f0
    public final f5 n(f5 f5Var, io.sentry.l0 l0Var) {
        if (f5Var.g()) {
            SentryAndroidOptions sentryAndroidOptions = this.b;
            if (!sentryAndroidOptions.isAttachViewHierarchy()) {
                sentryAndroidOptions.getLogger().h(p5.DEBUG, "attachViewHierarchy is disabled.", new Object[0]);
                return f5Var;
            }
            if (!io.sentry.util.b.k(l0Var)) {
                boolean zA = this.f.a();
                sentryAndroidOptions.getBeforeViewHierarchyCaptureCallback();
                if (!zA) {
                    WeakReference weakReference = (WeakReference) q0.f.b;
                    io.sentry.protocol.k0 k0Var = null;
                    Activity activity = weakReference != null ? (Activity) weakReference.get() : null;
                    List<Object> viewHierarchyExporters = sentryAndroidOptions.getViewHierarchyExporters();
                    io.sentry.util.thread.a threadChecker = sentryAndroidOptions.getThreadChecker();
                    ILogger logger = sentryAndroidOptions.getLogger();
                    if (activity == null) {
                        logger.h(p5.INFO, "Missing activity for view hierarchy snapshot.", new Object[0]);
                    } else {
                        Window window = activity.getWindow();
                        if (window == null) {
                            logger.h(p5.INFO, "Missing window for view hierarchy snapshot.", new Object[0]);
                        } else {
                            View viewPeekDecorView = window.peekDecorView();
                            if (viewPeekDecorView == null) {
                                logger.h(p5.INFO, "Missing decor view for view hierarchy snapshot.", new Object[0]);
                            } else {
                                try {
                                    if (threadChecker.c()) {
                                        ArrayList arrayList = new ArrayList(1);
                                        io.sentry.protocol.k0 k0Var2 = new io.sentry.protocol.k0("android_view_system", arrayList);
                                        io.sentry.protocol.l0 l0VarB = b(viewPeekDecorView);
                                        arrayList.add(l0VarB);
                                        a(viewPeekDecorView, l0VarB, viewHierarchyExporters);
                                        k0Var = k0Var2;
                                    } else {
                                        CountDownLatch countDownLatch = new CountDownLatch(1);
                                        AtomicReference atomicReference = new AtomicReference(null);
                                        activity.runOnUiThread(new iw2(atomicReference, viewPeekDecorView, viewHierarchyExporters, countDownLatch, logger, 1));
                                        if (countDownLatch.await(1000L, TimeUnit.MILLISECONDS)) {
                                            k0Var = (io.sentry.protocol.k0) atomicReference.get();
                                        }
                                    }
                                } catch (Throwable th) {
                                    logger.d(p5.ERROR, "Failed to process view hierarchy.", th);
                                }
                            }
                        }
                    }
                    if (k0Var != null) {
                        l0Var.e = new io.sentry.a(k0Var);
                    }
                }
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
