package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pv2 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    public final View b;
    public ViewTreeObserver f;
    public final Runnable z;

    public pv2(View view, Runnable runnable) {
        this.b = view;
        this.f = view.getViewTreeObserver();
        this.z = runnable;
    }

    public static void a(View view, Runnable runnable) {
        if (view == null) {
            zo2.n("view == null");
            return;
        }
        pv2 pv2Var = new pv2(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(pv2Var);
        view.addOnAttachStateChangeListener(pv2Var);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        boolean zIsAlive = this.f.isAlive();
        View view = this.b;
        if (zIsAlive) {
            this.f.removeOnPreDrawListener(this);
        } else {
            view.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view.removeOnAttachStateChangeListener(this);
        this.z.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        boolean zIsAlive = this.f.isAlive();
        View view2 = this.b;
        if (zIsAlive) {
            this.f.removeOnPreDrawListener(this);
        } else {
            view2.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view2.removeOnAttachStateChangeListener(this);
    }
}
