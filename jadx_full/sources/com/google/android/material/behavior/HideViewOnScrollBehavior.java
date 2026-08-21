package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.getsurfboard.R;
import defpackage.c20;
import defpackage.cs1;
import defpackage.d3;
import defpackage.ds1;
import defpackage.dw2;
import defpackage.ek0;
import defpackage.ha0;
import defpackage.l72;
import defpackage.qe0;
import defpackage.t8;
import defpackage.te0;
import defpackage.xb5;
import defpackage.xe;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class HideViewOnScrollBehavior<V extends View> extends qe0 {
    public ViewPropertyAnimator B0;
    public int X;
    public int Y;
    public TimeInterpolator Z;
    public xb5 b;
    public AccessibilityManager f;
    public TimeInterpolator y0;
    public cs1 z;
    public final LinkedHashSet A = new LinkedHashSet();
    public int z0 = 0;
    public int A0 = 2;

    public HideViewOnScrollBehavior() {
    }

    @Override // defpackage.qe0
    public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        AccessibilityManager accessibilityManager = this.f;
        if (accessibilityManager == null) {
            accessibilityManager = (AccessibilityManager) view.getContext().getSystemService(AccessibilityManager.class);
            this.f = accessibilityManager;
        }
        if (accessibilityManager != null && this.z == null) {
            cs1 cs1Var = new cs1(this, view, 1);
            this.z = cs1Var;
            accessibilityManager.addTouchExplorationStateChangeListener(cs1Var);
            view.addOnAttachStateChangeListener(new c20(4, this));
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i2 = ((te0) view.getLayoutParams()).c;
        if (i2 == 80 || i2 == 81) {
            w(1);
        } else {
            int absoluteGravity = Gravity.getAbsoluteGravity(i2, i);
            w((absoluteGravity == 3 || absoluteGravity == 19) ? 2 : 0);
        }
        this.z0 = this.b.w(view, marginLayoutParams);
        this.X = ek0.C(view.getContext(), R.attr.motionDurationLong2, 225);
        this.Y = ek0.C(view.getContext(), R.attr.motionDurationMedium4, 175);
        this.Z = l72.W(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, t8.d);
        this.y0 = l72.W(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, t8.c);
        return false;
    }

    @Override // defpackage.qe0
    public final void p(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int[] iArr) {
        if (i <= 0) {
            if (i < 0) {
                x(view);
                return;
            }
            return;
        }
        if (this.A0 == 1) {
            return;
        }
        AccessibilityManager accessibilityManager = this.f;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            ViewPropertyAnimator viewPropertyAnimator = this.B0;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                view.clearAnimation();
            }
            this.A0 = 1;
            Iterator it = this.A.iterator();
            if (it.hasNext()) {
                throw dw2.z(it);
            }
            this.B0 = this.b.z(view, this.z0).setInterpolator(this.y0).setDuration(this.Y).setListener(new d3(8, this));
        }
    }

    @Override // defpackage.qe0
    public final boolean t(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2) {
        return i == 2;
    }

    public final void w(int i) {
        xb5 xb5Var = this.b;
        if (xb5Var == null || xb5Var.y() != i) {
            if (i == 0) {
                this.b = new ds1(2);
                return;
            }
            if (i == 1) {
                this.b = new ds1(0);
            } else if (i == 2) {
                this.b = new ds1(1);
            } else {
                xe.k(ha0.k("Invalid view edge position value: ", i, ". Must be 0, 1 or 2."));
            }
        }
    }

    public final void x(View view) {
        if (this.A0 == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.B0;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.A0 = 2;
        Iterator it = this.A.iterator();
        if (it.hasNext()) {
            throw dw2.z(it);
        }
        this.b.getClass();
        this.B0 = this.b.z(view, 0).setInterpolator(this.Z).setDuration(this.X).setListener(new d3(8, this));
    }

    public HideViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
    }
}
