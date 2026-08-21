package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.getsurfboard.R;
import defpackage.c20;
import defpackage.cs1;
import defpackage.d3;
import defpackage.dw2;
import defpackage.ek0;
import defpackage.l72;
import defpackage.qe0;
import defpackage.t8;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class HideBottomViewOnScrollBehavior<V extends View> extends qe0 {
    public TimeInterpolator A;
    public ViewPropertyAnimator B0;
    public TimeInterpolator X;
    public AccessibilityManager Z;
    public int f;
    public cs1 y0;
    public int z;
    public final LinkedHashSet b = new LinkedHashSet();
    public int Y = 0;
    public final boolean z0 = true;
    public int A0 = 2;

    public HideBottomViewOnScrollBehavior() {
    }

    @Override // defpackage.qe0
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        this.Y = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.f = ek0.C(view.getContext(), R.attr.motionDurationLong2, 225);
        this.z = ek0.C(view.getContext(), R.attr.motionDurationMedium4, 175);
        this.A = l72.W(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, t8.d);
        this.X = l72.W(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, t8.c);
        AccessibilityManager accessibilityManager = this.Z;
        if (accessibilityManager == null) {
            accessibilityManager = (AccessibilityManager) view.getContext().getSystemService(AccessibilityManager.class);
            this.Z = accessibilityManager;
        }
        if (accessibilityManager != null && this.y0 == null) {
            cs1 cs1Var = new cs1(this, view, 0);
            this.y0 = cs1Var;
            accessibilityManager.addTouchExplorationStateChangeListener(cs1Var);
            view.addOnAttachStateChangeListener(new c20(3, this));
        }
        return false;
    }

    @Override // defpackage.qe0
    public final void p(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int[] iArr) {
        AccessibilityManager accessibilityManager;
        if (i <= 0) {
            if (i < 0) {
                w(view);
                return;
            }
            return;
        }
        if (this.A0 == 1) {
            return;
        }
        if (this.z0 && (accessibilityManager = this.Z) != null && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.B0;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.A0 = 1;
        Iterator it = this.b.iterator();
        if (it.hasNext()) {
            throw dw2.z(it);
        }
        this.B0 = view.animate().translationY(this.Y).setInterpolator(this.X).setDuration(this.z).setListener(new d3(7, this));
    }

    @Override // defpackage.qe0
    public boolean t(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2) {
        return i == 2;
    }

    public final void w(View view) {
        if (this.A0 == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.B0;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.A0 = 2;
        Iterator it = this.b.iterator();
        if (it.hasNext()) {
            throw dw2.z(it);
        }
        this.B0 = view.animate().translationY(0.0f).setInterpolator(this.A).setDuration(this.f).setListener(new d3(7, this));
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
    }
}
