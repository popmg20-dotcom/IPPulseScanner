package io.sentry.android.core;

import androidx.lifecycle.DefaultLifecycleObserver;
import defpackage.da2;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i0 implements DefaultLifecycleObserver {
    public final h0 b = new h0(0, this);
    public final /* synthetic */ j0 f;

    public i0(j0 j0Var) {
        this.f = j0Var;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onCreate(da2 da2Var) {
        da2Var.getClass();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onDestroy(da2 da2Var) {
        da2Var.getClass();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onPause(da2 da2Var) {
        da2Var.getClass();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onResume(da2 da2Var) {
        da2Var.getClass();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStart(da2 da2Var) {
        this.f.A = Boolean.FALSE;
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((g0) it.next()).g();
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStop(da2 da2Var) {
        this.f.A = Boolean.TRUE;
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((g0) it.next()).n();
        }
    }
}
