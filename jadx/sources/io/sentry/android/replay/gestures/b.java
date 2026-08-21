package io.sentry.android.replay.gestures;

import android.view.View;
import android.view.Window;
import defpackage.d70;
import defpackage.vf2;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.replay.ReplayIntegration;
import io.sentry.android.replay.b0;
import io.sentry.android.replay.e;
import io.sentry.p5;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b implements e {
    public final SentryAndroidOptions b;
    public final ReplayIntegration f;
    public final ArrayList z = new ArrayList();
    public final io.sentry.util.a A = new io.sentry.util.a();
    public final WeakHashMap X = new WeakHashMap();
    public final io.sentry.util.a Y = new io.sentry.util.a();

    public b(SentryAndroidOptions sentryAndroidOptions, ReplayIntegration replayIntegration) {
        this.b = sentryAndroidOptions;
        this.f = replayIntegration;
    }

    public final void a(View view) throws IllegalAccessException {
        WeakHashMap weakHashMap = this.X;
        Window windowJ = io.sentry.config.a.j(view);
        SentryAndroidOptions sentryAndroidOptions = this.b;
        if (windowJ == null) {
            sentryAndroidOptions.getLogger().h(p5.DEBUG, "Window is invalid, not tracking gestures", new Object[0]);
            return;
        }
        io.sentry.util.a aVar = this.Y;
        aVar.g();
        try {
            WeakReference weakReference = (WeakReference) weakHashMap.get(windowJ);
            if ((weakReference != null ? (a) weakReference.get() : null) != null) {
                vf2.e(aVar, null);
                return;
            }
            vf2.e(aVar, null);
            a aVar2 = new a(sentryAndroidOptions, this.f, windowJ.getCallback());
            windowJ.setCallback(aVar2);
            aVar.g();
            try {
                weakHashMap.put(windowJ, new WeakReference(aVar2));
                vf2.e(aVar, null);
            } finally {
            }
        } finally {
            try {
                throw th;
            } finally {
            }
        }
    }

    public final void b() {
        ArrayList arrayList = this.z;
        io.sentry.util.a aVar = this.A;
        aVar.g();
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                View view = (View) ((WeakReference) it.next()).get();
                if (view != null) {
                    c(view);
                }
            }
            arrayList.clear();
            vf2.e(aVar, null);
        } finally {
        }
    }

    public final void c(View view) throws IllegalAccessException {
        io.sentry.util.a aVar;
        Window windowJ = io.sentry.config.a.j(view);
        if (windowJ == null) {
            this.b.getLogger().h(p5.DEBUG, "Window was null in stopGestureTracking", new Object[0]);
            return;
        }
        Window.Callback callback = windowJ.getCallback();
        if (callback instanceof a) {
            windowJ.setCallback(((a) callback).b);
            aVar = this.Y;
            aVar.g();
            try {
                vf2.e(aVar, null);
                return;
            } finally {
                try {
                    throw th;
                } finally {
                }
            }
        }
        aVar = this.Y;
        aVar.g();
        try {
            WeakReference weakReference = (WeakReference) this.X.get(windowJ);
            a aVar2 = weakReference != null ? (a) weakReference.get() : null;
            vf2.e(aVar, null);
            if (aVar2 != null) {
                aVar2.z = null;
            }
        } catch (Throwable th) {
        }
    }

    @Override // io.sentry.android.replay.e
    public final void g(View view, boolean z) {
        view.getClass();
        io.sentry.util.a aVar = this.A;
        aVar.g();
        ArrayList arrayList = this.z;
        try {
            if (z) {
                arrayList.add(new WeakReference(view));
                a(view);
            } else {
                c(view);
                d70.o0(arrayList, new b0(view, 1));
            }
            vf2.e(aVar, null);
        } finally {
        }
    }
}
