package com.google.android.material.sidesheet;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Property;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.getsurfboard.R;
import defpackage.a0;
import defpackage.ai2;
import defpackage.bj2;
import defpackage.cj2;
import defpackage.co4;
import defpackage.d3;
import defpackage.dw2;
import defpackage.fw;
import defpackage.ha0;
import defpackage.i2;
import defpackage.i92;
import defpackage.ja2;
import defpackage.jo;
import defpackage.jw;
import defpackage.l72;
import defpackage.mo;
import defpackage.ou3;
import defpackage.qe0;
import defpackage.qy1;
import defpackage.rc3;
import defpackage.st4;
import defpackage.t8;
import defpackage.te0;
import defpackage.ub1;
import defpackage.wp4;
import defpackage.xe;
import defpackage.yh;
import defpackage.yi2;
import defpackage.yv3;
import defpackage.zp4;
import io.sentry.android.core.a1;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class SideSheetBehavior<V extends View> extends qe0 implements ai2 {
    public final ou3 A;
    public boolean A0;
    public final float B0;
    public int C0;
    public int D0;
    public int E0;
    public int F0;
    public WeakReference G0;
    public WeakReference H0;
    public final int I0;
    public VelocityTracker J0;
    public cj2 K0;
    public int L0;
    public final LinkedHashSet M0;
    public final jo N0;
    public final mo X;
    public final float Y;
    public final boolean Z;
    public co4 b;
    public final yi2 f;
    public int y0;
    public final ColorStateList z;
    public zp4 z0;

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        this.X = new mo(this);
        this.Z = true;
        this.y0 = 5;
        this.B0 = 0.1f;
        this.I0 = -1;
        this.M0 = new LinkedHashSet();
        this.N0 = new jo(1, this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, rc3.M);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            this.z = l72.r(context, typedArrayObtainStyledAttributes, 3);
        }
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            this.A = ou3.h(context, attributeSet, 0, R.style.Widget_Material3_SideSheet).b();
        }
        if (typedArrayObtainStyledAttributes.hasValue(5)) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(5, -1);
            this.I0 = resourceId;
            WeakReference weakReference = this.H0;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.H0 = null;
            WeakReference weakReference2 = this.G0;
            if (weakReference2 != null) {
                View view = (View) weakReference2.get();
                if (resourceId != -1 && view.isLaidOut()) {
                    view.requestLayout();
                }
            }
        }
        ou3 ou3Var = this.A;
        if (ou3Var != null) {
            yi2 yi2Var = new yi2(ou3Var);
            this.f = yi2Var;
            yi2Var.l(context);
            ColorStateList colorStateList = this.z;
            if (colorStateList != null) {
                this.f.p(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.f.setTint(typedValue.data);
            }
        }
        this.Y = typedArrayObtainStyledAttributes.getDimension(2, -1.0f);
        this.Z = typedArrayObtainStyledAttributes.getBoolean(4, true);
        typedArrayObtainStyledAttributes.recycle();
        ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public final void A() {
        View view;
        WeakReference weakReference = this.G0;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        wp4.k(view, 262144);
        wp4.i(view, 0);
        wp4.k(view, 1048576);
        wp4.i(view, 0);
        int i = 5;
        if (this.y0 != 5) {
            wp4.l(view, i2.i, null, new ja2(i, this));
        }
        int i2 = 3;
        if (this.y0 != 3) {
            wp4.l(view, i2.h, null, new ja2(i2, this));
        }
    }

    @Override // defpackage.ai2
    public final void a() {
        int i;
        final ViewGroup.MarginLayoutParams marginLayoutParams;
        cj2 cj2Var = this.K0;
        if (cj2Var == null) {
            return;
        }
        yh yhVar = (yh) cj2Var.g;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
        cj2Var.g = null;
        int i2 = 5;
        if (yhVar == null || Build.VERSION.SDK_INT < 34) {
            w(5);
            return;
        }
        co4 co4Var = this.b;
        if (co4Var != null && co4Var.A() != 0) {
            i2 = 3;
        }
        d3 d3Var = new d3(12, this);
        WeakReference weakReference = this.H0;
        final View view = weakReference != null ? (View) weakReference.get() : null;
        if (view != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) != null) {
            final int iS = this.b.s(marginLayoutParams);
            animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: xv3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.a.b.a0(marginLayoutParams, t8.c(iS, valueAnimator.getAnimatedFraction(), 0));
                    view.requestLayout();
                }
            };
        }
        View view2 = (View) cj2Var.f;
        boolean z = yhVar.d == 0;
        boolean z2 = (Gravity.getAbsoluteGravity(i2, view2.getLayoutDirection()) & 3) == 3;
        float scaleX = view2.getScaleX() * view2.getWidth();
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
            i = z2 ? marginLayoutParams2.leftMargin : marginLayoutParams2.rightMargin;
        } else {
            i = 0;
        }
        float f = scaleX + i;
        Property property = View.TRANSLATION_X;
        if (z2) {
            f = -f;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) property, f);
        if (animatorUpdateListener != null) {
            objectAnimatorOfFloat.addUpdateListener(animatorUpdateListener);
        }
        objectAnimatorOfFloat.setInterpolator(new ub1());
        objectAnimatorOfFloat.setDuration(t8.c(cj2Var.b, yhVar.c, cj2Var.c));
        objectAnimatorOfFloat.addListener(new bj2(cj2Var, z, i2));
        objectAnimatorOfFloat.addListener(d3Var);
        objectAnimatorOfFloat.start();
    }

    @Override // defpackage.ai2
    public final void b(yh yhVar) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        cj2 cj2Var = this.K0;
        if (cj2Var == null) {
            return;
        }
        co4 co4Var = this.b;
        int i = (co4Var == null || co4Var.A() == 0) ? 5 : 3;
        if (((yh) cj2Var.g) == null) {
            a1.n("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        yh yhVar2 = (yh) cj2Var.g;
        cj2Var.g = yhVar;
        if (yhVar2 != null) {
            cj2Var.a(yhVar.c, yhVar.d == 0, i);
        }
        WeakReference weakReference = this.G0;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view = (View) this.G0.get();
        WeakReference weakReference2 = this.H0;
        View view2 = weakReference2 != null ? (View) weakReference2.get() : null;
        if (view2 == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) == null) {
            return;
        }
        this.b.a0(marginLayoutParams, (int) ((view.getScaleX() * this.C0) + this.F0));
        view2.requestLayout();
    }

    @Override // defpackage.ai2
    public final void c(yh yhVar) {
        cj2 cj2Var = this.K0;
        if (cj2Var == null) {
            return;
        }
        cj2Var.g = yhVar;
    }

    @Override // defpackage.ai2
    public final void d() {
        cj2 cj2Var = this.K0;
        if (cj2Var == null) {
            return;
        }
        View view = (View) cj2Var.f;
        if (((yh) cj2Var.g) == null) {
            a1.n("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        yh yhVar = (yh) cj2Var.g;
        cj2Var.g = null;
        if (yhVar == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(view, (Property<View, Float>) View.SCALE_Y, 1.0f));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i), (Property<View, Float>) View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setDuration(cj2Var.d);
        animatorSet.start();
    }

    @Override // defpackage.qe0
    public final void g(te0 te0Var) {
        this.G0 = null;
        this.z0 = null;
        this.K0 = null;
    }

    @Override // defpackage.qe0
    public final void j() {
        this.G0 = null;
        this.z0 = null;
        this.K0 = null;
    }

    @Override // defpackage.qe0
    public final boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        zp4 zp4Var;
        VelocityTracker velocityTracker;
        if ((!view.isShown() && wp4.f(view) == null) || !this.Z) {
            this.A0 = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && (velocityTracker = this.J0) != null) {
            velocityTracker.recycle();
            this.J0 = null;
        }
        VelocityTracker velocityTrackerObtain = this.J0;
        if (velocityTrackerObtain == null) {
            velocityTrackerObtain = VelocityTracker.obtain();
            this.J0 = velocityTrackerObtain;
        }
        velocityTrackerObtain.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.L0 = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.A0) {
            this.A0 = false;
            return false;
        }
        return (this.A0 || (zp4Var = this.z0) == null || !zp4Var.s(motionEvent)) ? false : true;
    }

    @Override // defpackage.qe0
    public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        View view2;
        View view3;
        int iY;
        int i2;
        View viewFindViewById;
        int i3 = 1;
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        WeakReference weakReference = this.G0;
        yi2 yi2Var = this.f;
        int i4 = 0;
        if (weakReference == null) {
            this.G0 = new WeakReference(view);
            this.K0 = new cj2(view);
            if (yi2Var != null) {
                view.setBackground(yi2Var);
                float elevation = this.Y;
                if (elevation == -1.0f) {
                    elevation = view.getElevation();
                }
                yi2Var.o(elevation);
            } else {
                ColorStateList colorStateList = this.z;
                if (colorStateList != null) {
                    WeakHashMap weakHashMap = wp4.a;
                    view.setBackgroundTintList(colorStateList);
                }
            }
            int i5 = this.y0 == 5 ? 4 : 0;
            if (view.getVisibility() != i5) {
                view.setVisibility(i5);
            }
            A();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
            if (wp4.f(view) == null) {
                wp4.o(view, view.getResources().getString(R.string.side_sheet_accessibility_pane_title));
            }
        }
        int i6 = Gravity.getAbsoluteGravity(((te0) view.getLayoutParams()).c, i) == 3 ? 1 : 0;
        co4 co4Var = this.b;
        if (co4Var == null || co4Var.A() != i6) {
            te0 te0Var = null;
            ou3 ou3Var = this.A;
            if (i6 == 0) {
                this.b = new i92(this, i3);
                if (ou3Var != null) {
                    WeakReference weakReference2 = this.G0;
                    if (weakReference2 != null && (view3 = (View) weakReference2.get()) != null && (view3.getLayoutParams() instanceof te0)) {
                        te0Var = (te0) view3.getLayoutParams();
                    }
                    if (te0Var == null || ((ViewGroup.MarginLayoutParams) te0Var).rightMargin <= 0) {
                        qy1 qy1VarL = ou3Var.l();
                        qy1VarL.f = new a0(0.0f);
                        qy1VarL.g = new a0(0.0f);
                        ou3 ou3VarB = qy1VarL.b();
                        if (yi2Var != null) {
                            yi2Var.setShapeAppearanceModel(ou3VarB);
                        }
                    }
                }
            } else {
                if (i6 != 1) {
                    xe.k(ha0.k("Invalid sheet edge position value: ", i6, ". Must be 0 or 1."));
                    return false;
                }
                this.b = new i92(this, i4);
                if (ou3Var != null) {
                    WeakReference weakReference3 = this.G0;
                    if (weakReference3 != null && (view2 = (View) weakReference3.get()) != null && (view2.getLayoutParams() instanceof te0)) {
                        te0Var = (te0) view2.getLayoutParams();
                    }
                    if (te0Var == null || ((ViewGroup.MarginLayoutParams) te0Var).leftMargin <= 0) {
                        qy1 qy1VarL2 = ou3Var.l();
                        qy1VarL2.e = new a0(0.0f);
                        qy1VarL2.h = new a0(0.0f);
                        ou3 ou3VarB2 = qy1VarL2.b();
                        if (yi2Var != null) {
                            yi2Var.setShapeAppearanceModel(ou3VarB2);
                        }
                    }
                }
            }
        }
        if (this.z0 == null) {
            this.z0 = new zp4(coordinatorLayout.getContext(), coordinatorLayout, this.N0);
        }
        int iY2 = this.b.y(view);
        coordinatorLayout.q(view, i);
        this.D0 = coordinatorLayout.getWidth();
        this.E0 = this.b.z(coordinatorLayout);
        this.C0 = view.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        this.F0 = marginLayoutParams != null ? this.b.e(marginLayoutParams) : 0;
        int i7 = this.y0;
        if (i7 == 1 || i7 == 2) {
            iY = iY2 - this.b.y(view);
        } else if (i7 == 3) {
            iY = 0;
        } else {
            if (i7 != 5) {
                xe.d(this.y0, "Unexpected value: ");
                return false;
            }
            iY = this.b.v();
        }
        WeakHashMap weakHashMap2 = wp4.a;
        view.offsetLeftAndRight(iY);
        if (this.H0 == null && (i2 = this.I0) != -1 && (viewFindViewById = coordinatorLayout.findViewById(i2)) != null) {
            this.H0 = new WeakReference(viewFindViewById);
        }
        Iterator it = this.M0.iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                st4.n();
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.qe0
    public final boolean m(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
        return true;
    }

    @Override // defpackage.qe0
    public final void r(View view, Parcelable parcelable) {
        int i = ((yv3) parcelable).z;
        if (i == 1 || i == 2) {
            i = 5;
        }
        this.y0 = i;
    }

    @Override // defpackage.qe0
    public final Parcelable s(View view) {
        AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
        return new yv3(this);
    }

    @Override // defpackage.qe0
    public final boolean v(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.y0 == 1 && actionMasked == 0) {
            return true;
        }
        if (y()) {
            this.z0.l(motionEvent);
        }
        if (actionMasked == 0 && (velocityTracker = this.J0) != null) {
            velocityTracker.recycle();
            this.J0 = null;
        }
        VelocityTracker velocityTrackerObtain = this.J0;
        if (velocityTrackerObtain == null) {
            velocityTrackerObtain = VelocityTracker.obtain();
            this.J0 = velocityTrackerObtain;
        }
        velocityTrackerObtain.addMovement(motionEvent);
        if (y() && actionMasked == 2 && !this.A0 && y()) {
            float fAbs = Math.abs(this.L0 - motionEvent.getX());
            zp4 zp4Var = this.z0;
            if (fAbs > zp4Var.b) {
                zp4Var.c(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.A0;
    }

    public final void w(int i) {
        if (i == 1 || i == 2) {
            throw new IllegalArgumentException(fw.y(new StringBuilder("STATE_"), i == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        WeakReference weakReference = this.G0;
        if (weakReference == null || weakReference.get() == null) {
            x(i);
            return;
        }
        View view = (View) this.G0.get();
        jw jwVar = new jw(i, 3, this);
        ViewParent parent = view.getParent();
        if (parent != null && parent.isLayoutRequested() && view.isAttachedToWindow()) {
            view.post(jwVar);
        } else {
            jwVar.run();
        }
    }

    public final void x(int i) {
        View view;
        if (this.y0 == i) {
            return;
        }
        this.y0 = i;
        WeakReference weakReference = this.G0;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        int i2 = this.y0 == 5 ? 4 : 0;
        if (view.getVisibility() != i2) {
            view.setVisibility(i2);
        }
        Iterator it = this.M0.iterator();
        if (it.hasNext()) {
            throw dw2.z(it);
        }
        A();
    }

    public final boolean y() {
        if (this.z0 != null) {
            return this.Z || this.y0 == 1;
        }
        return false;
    }

    public final void z(View view, int i, boolean z) {
        int iT;
        if (i == 3) {
            iT = this.b.t();
        } else {
            if (i != 5) {
                xe.k(dw2.A(i, "Invalid state to get outer edge offset: "));
                return;
            }
            iT = this.b.v();
        }
        zp4 zp4Var = this.z0;
        if (zp4Var == null || (!z ? zp4Var.t(view, iT, view.getTop()) : zp4Var.r(iT, view.getTop()))) {
            x(i);
        } else {
            x(2);
            this.X.a(i);
        }
    }

    public SideSheetBehavior() {
        this.X = new mo(this);
        this.Z = true;
        this.y0 = 5;
        this.B0 = 0.1f;
        this.I0 = -1;
        this.M0 = new LinkedHashSet();
        this.N0 = new jo(1, this);
    }
}
