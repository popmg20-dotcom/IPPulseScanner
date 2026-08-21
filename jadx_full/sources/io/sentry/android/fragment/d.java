package io.sentry.android.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks;
import androidx.fragment.app.o;
import androidx.fragment.app.u;
import defpackage.bd0;
import defpackage.bh3;
import defpackage.ca;
import io.sentry.f1;
import io.sentry.f7;
import io.sentry.g;
import io.sentry.l0;
import io.sentry.n1;
import io.sentry.p5;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d extends FragmentManager$FragmentLifecycleCallbacks {
    public final f1 a;
    public final Set b;
    public final boolean c;
    public final WeakHashMap d;

    public d(f1 f1Var, Set set, boolean z) {
        f1Var.getClass();
        set.getClass();
        this.a = f1Var;
        this.b = set;
        this.c = z;
        this.d = new WeakHashMap();
    }

    @Override // androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks
    public final void a(u uVar, o oVar, ca caVar) {
        l(oVar, b.ATTACHED);
    }

    @Override // androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks
    public final void b(u uVar, o oVar) {
        l(oVar, b.CREATED);
        m(oVar);
    }

    @Override // androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks
    public final void c(u uVar, o oVar) {
        l(oVar, b.DESTROYED);
        n(oVar);
    }

    @Override // androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks
    public final void d(u uVar, o oVar) {
        l(oVar, b.DETACHED);
    }

    @Override // androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks
    public final void e(u uVar, o oVar) {
        l(oVar, b.PAUSED);
    }

    @Override // androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks
    public final void f(u uVar, o oVar) {
        l(oVar, b.RESUMED);
        n(oVar);
    }

    @Override // androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks
    public final void g(u uVar, o oVar, Bundle bundle) {
        l(oVar, b.SAVE_INSTANCE_STATE);
    }

    @Override // androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks
    public final void h(u uVar, o oVar) {
        l(oVar, b.STARTED);
        n(oVar);
    }

    @Override // androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks
    public final void i(u uVar, o oVar) {
        l(oVar, b.STOPPED);
    }

    @Override // androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks
    public final void j(u uVar, o oVar, View view) {
        view.getClass();
        l(oVar, b.VIEW_CREATED);
        m(oVar);
    }

    @Override // androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks
    public final void k(u uVar, o oVar) {
        l(oVar, b.VIEW_DESTROYED);
        n(oVar);
    }

    public final void l(o oVar, b bVar) {
        if (this.b.contains(bVar)) {
            g gVar = new g();
            gVar.X = "navigation";
            gVar.d(bVar.getBreadcrumbName$sentry_android_fragment_release(), "state");
            String canonicalName = oVar.getClass().getCanonicalName();
            if (canonicalName == null) {
                canonicalName = oVar.getClass().getSimpleName();
            }
            gVar.d(canonicalName, "screen");
            gVar.Z = "ui.fragment.lifecycle";
            gVar.z0 = p5.INFO;
            l0 l0Var = new l0();
            l0Var.d(oVar, "android:fragment");
            this.a.c(gVar, l0Var);
        }
    }

    public final void m(o oVar) {
        if (oVar.isAdded()) {
            String canonicalName = oVar.getClass().getCanonicalName();
            if (canonicalName == null) {
                canonicalName = oVar.getClass().getSimpleName();
            }
            f1 f1Var = this.a;
            if (f1Var.getOptions().isEnableScreenTracking()) {
                f1Var.w(new bd0(canonicalName, 5));
            }
            if (f1Var.getOptions().isTracingEnabled() && this.c) {
                WeakHashMap weakHashMap = this.d;
                if (weakHashMap.containsKey(oVar)) {
                    return;
                }
                bh3 bh3Var = new bh3();
                f1Var.w(new c(bh3Var, 0));
                n1 n1Var = (n1) bh3Var.b;
                n1 n1VarO = n1Var != null ? n1Var.o(canonicalName) : null;
                if (n1VarO != null) {
                    weakHashMap.put(oVar, n1VarO);
                    n1VarO.r().z0 = "auto.ui.fragment";
                }
            }
        }
    }

    public final void n(o oVar) {
        n1 n1Var;
        if (this.a.getOptions().isTracingEnabled() && this.c) {
            WeakHashMap weakHashMap = this.d;
            if (weakHashMap.containsKey(oVar) && (n1Var = (n1) weakHashMap.get(oVar)) != null) {
                f7 status = n1Var.getStatus();
                if (status == null) {
                    status = f7.OK;
                }
                n1Var.f(status);
            }
        }
    }
}
