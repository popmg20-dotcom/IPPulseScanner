package io.sentry.android.replay;

import android.graphics.Point;
import android.view.View;
import android.view.ViewTreeObserver;
import defpackage.d70;
import defpackage.n12;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a0 implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ c0 b;
    public final /* synthetic */ View f;

    public a0(c0 c0Var, View view) {
        this.b = c0Var;
        this.f = view;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        c0 c0Var = this.b;
        Point point = c0Var.y0;
        WeakReference weakReference = (WeakReference) d70.l0(c0Var.Z);
        View view = weakReference != null ? (View) weakReference.get() : null;
        View view2 = this.f;
        if (n12.c(view2, view)) {
            view2.getClass();
            if (view2.getWidth() > 0 && view2.getHeight() > 0) {
                if (view2.getViewTreeObserver() != null && view2.getViewTreeObserver().isAlive()) {
                    try {
                        view2.getViewTreeObserver().removeOnPreDrawListener(this);
                    } catch (IllegalStateException unused) {
                    }
                }
                if (view2.getWidth() != point.x || view2.getHeight() != point.y) {
                    point.set(view2.getWidth(), view2.getHeight());
                    c0Var.z.n0(view2.getWidth(), view2.getHeight());
                }
            }
        } else if (view2 != null && view2.getViewTreeObserver() != null && view2.getViewTreeObserver().isAlive()) {
            try {
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            } catch (IllegalStateException unused2) {
            }
        }
        return true;
    }
}
