package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.getsurfboard.R;
import com.google.android.material.appbar.AppBarLayout;
import defpackage.bv4;
import defpackage.co4;
import defpackage.ek0;
import defpackage.fx3;
import defpackage.jr1;
import defpackage.kr1;
import defpackage.l72;
import defpackage.lb;
import defpackage.mp4;
import defpackage.pe0;
import defpackage.qe0;
import defpackage.r02;
import defpackage.rc3;
import defpackage.t8;
import defpackage.te0;
import defpackage.tj4;
import defpackage.uf2;
import defpackage.v9;
import defpackage.vo;
import defpackage.wp4;
import defpackage.wq2;
import defpackage.xe;
import defpackage.y;
import defpackage.yi2;
import defpackage.z3;
import defpackage.z9;
import defpackage.zf2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class AppBarLayout extends LinearLayout implements pe0 {
    public static final /* synthetic */ int U0 = 0;
    public int A;
    public bv4 A0;
    public boolean B0;
    public boolean C0;
    public boolean D0;
    public boolean E0;
    public ColorStateList F0;
    public int G0;
    public WeakReference H0;
    public ValueAnimator I0;
    public ValueAnimator.AnimatorUpdateListener J0;
    public final ArrayList K0;
    public final LinkedHashSet L0;
    public final long M0;
    public final TimeInterpolator N0;
    public int[] O0;
    public int P0;
    public Drawable Q0;
    public Integer R0;
    public final float S0;
    public Behavior T0;
    public int b;
    public int f;
    public boolean y0;
    public int z;
    public int z0;

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(co4.d0(context, attributeSet, R.attr.appBarLayoutStyle, R.style.Widget_Design_AppBarLayout), attributeSet, R.attr.appBarLayoutStyle);
        this.f = -1;
        this.z = -1;
        this.A = -1;
        this.z0 = 0;
        this.K0 = new ArrayList();
        this.L0 = new LinkedHashSet();
        Context context2 = getContext();
        setOrientation(1);
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
        Context context3 = getContext();
        TypedArray typedArrayV = fx3.v(context3, attributeSet, co4.g, R.attr.appBarLayoutStyle, R.style.Widget_Design_AppBarLayout, new int[0]);
        try {
            if (typedArrayV.hasValue(0)) {
                setStateListAnimator(AnimatorInflater.loadStateListAnimator(context3, typedArrayV.getResourceId(0, 0)));
            }
            typedArrayV.recycle();
            TypedArray typedArrayV2 = fx3.v(context2, attributeSet, rc3.a, R.attr.appBarLayoutStyle, R.style.Widget_Design_AppBarLayout, new int[0]);
            this.F0 = l72.r(context2, typedArrayV2, 6);
            this.M0 = ek0.C(context2, R.attr.motionDurationMedium2, getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
            this.N0 = l72.W(context2, R.attr.motionEasingStandardInterpolator, t8.a);
            int i = 4;
            if (typedArrayV2.hasValue(4)) {
                d(typedArrayV2.getBoolean(4, false), false, false);
            }
            if (typedArrayV2.hasValue(3)) {
                co4.U(this, typedArrayV2.getDimensionPixelSize(3, 0));
            }
            setBackground(typedArrayV2.getDrawable(0));
            if (Build.VERSION.SDK_INT >= 26) {
                if (typedArrayV2.hasValue(2)) {
                    setKeyboardNavigationCluster(typedArrayV2.getBoolean(2, false));
                }
                if (typedArrayV2.hasValue(1)) {
                    setTouchscreenBlocksFocus(typedArrayV2.getBoolean(1, false));
                }
            }
            this.S0 = getResources().getDimension(R.dimen.design_appbar_elevation);
            this.E0 = typedArrayV2.getBoolean(5, false);
            this.G0 = typedArrayV2.getResourceId(7, -1);
            setStatusBarForeground(typedArrayV2.getDrawable(8));
            typedArrayV2.recycle();
            zf2 zf2Var = new zf2(i, this);
            WeakHashMap weakHashMap = wp4.a;
            mp4.c(this, zf2Var);
        } catch (Throwable th) {
            typedArrayV.recycle();
            throw th;
        }
    }

    public static z9 b(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            z9 z9Var = new z9((LinearLayout.LayoutParams) layoutParams);
            z9Var.a = 1;
            return z9Var;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            z9 z9Var2 = new z9((ViewGroup.MarginLayoutParams) layoutParams);
            z9Var2.a = 1;
            return z9Var2;
        }
        z9 z9Var3 = new z9(layoutParams);
        z9Var3.a = 1;
        return z9Var3;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final z9 generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        z9 z9Var = new z9(context, attributeSet);
        z9Var.a = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, rc3.b);
        z9Var.a = typedArrayObtainStyledAttributes.getInt(1, 0);
        z9Var.b = typedArrayObtainStyledAttributes.getInt(0, 0) != 1 ? null : new lb(6);
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            z9Var.c = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(2, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
        return z9Var;
    }

    public final void c() {
        Behavior behavior = this.T0;
        d dVarE = (behavior == null || this.f == -1 || this.z0 != 0) ? null : behavior.E(y.f, this);
        this.f = -1;
        this.z = -1;
        this.A = -1;
        if (dVarE != null) {
            Behavior behavior2 = this.T0;
            if (behavior2.D0 != null) {
                return;
            }
            behavior2.D0 = dVarE;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof z9;
    }

    public final void d(boolean z, boolean z2, boolean z3) {
        this.z0 = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
        requestLayout();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.Q0 == null || getTopInset() <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(0.0f, -this.b);
        this.Q0.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.Q0;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public final boolean e(boolean z) {
        if (this.B0 || this.D0 == z) {
            return false;
        }
        this.D0 = z;
        refreshDrawableState();
        if (!(getBackground() instanceof yi2)) {
            return true;
        }
        if (this.F0 != null) {
            g(z ? 0.0f : 1.0f, z ? 1.0f : 0.0f);
            return true;
        }
        if (!this.E0) {
            return true;
        }
        float f = this.S0;
        g(z ? 0.0f : f, z ? f : 0.0f);
        return true;
    }

    public final boolean f(View view) {
        int i;
        if (this.H0 == null && (i = this.G0) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.G0);
            }
            if (viewFindViewById != null) {
                this.H0 = new WeakReference(viewFindViewById);
            }
        }
        WeakReference weakReference = this.H0;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view = view2;
        }
        if (view != null) {
            return view.canScrollVertically(-1) || view.getScrollY() > 0;
        }
        return false;
    }

    public final void g(float f, float f2) {
        ValueAnimator valueAnimator = this.I0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        this.I0 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.M0);
        this.I0.setInterpolator(this.N0);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.J0;
        if (animatorUpdateListener != null) {
            this.I0.addUpdateListener(animatorUpdateListener);
        }
        this.I0.start();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        z9 z9Var = new z9(-1, -2);
        z9Var.a = 1;
        return z9Var;
    }

    @Override // defpackage.pe0
    public qe0 getBehavior() {
        Behavior behavior = new Behavior();
        this.T0 = behavior;
        return behavior;
    }

    public int getDownNestedPreScrollRange() {
        int iMin;
        int minimumHeight;
        int i = this.z;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                z9 z9Var = (z9) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i3 = z9Var.a;
                if ((i3 & 5) != 5) {
                    if (i2 > 0) {
                        break;
                    }
                } else {
                    int i4 = ((LinearLayout.LayoutParams) z9Var).topMargin + ((LinearLayout.LayoutParams) z9Var).bottomMargin;
                    if ((i3 & 8) != 0) {
                        minimumHeight = childAt.getMinimumHeight();
                    } else if ((i3 & 2) != 0) {
                        minimumHeight = measuredHeight - childAt.getMinimumHeight();
                    } else {
                        iMin = i4 + measuredHeight;
                        if (childCount == 0 && childAt.getFitsSystemWindows()) {
                            iMin = Math.min(iMin, measuredHeight - getTopInset());
                        }
                        i2 += iMin;
                    }
                    iMin = minimumHeight + i4;
                    if (childCount == 0) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                    i2 += iMin;
                }
            }
        }
        int iMax = Math.max(0, i2);
        this.z = iMax;
        return iMax;
    }

    public int getDownNestedScrollRange() {
        int i = this.A;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                z9 z9Var = (z9) childAt.getLayoutParams();
                int measuredHeight = ((LinearLayout.LayoutParams) z9Var).topMargin + ((LinearLayout.LayoutParams) z9Var).bottomMargin + childAt.getMeasuredHeight();
                int i3 = z9Var.a;
                if ((i3 & 1) == 0) {
                    break;
                }
                minimumHeight += measuredHeight;
                if ((i3 & 2) != 0) {
                    minimumHeight -= childAt.getMinimumHeight();
                    break;
                }
            }
            i2++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.A = iMax;
        return iMax;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.G0;
    }

    public yi2 getMaterialShapeBackground() {
        Drawable background = getBackground();
        if (background instanceof yi2) {
            return (yi2) background;
        }
        return null;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = getMinimumHeight();
        if (minimumHeight != 0) {
            int i = (minimumHeight * 2) + topInset;
            return i < getHeight() ? i : minimumHeight + topInset;
        }
        int childCount = getChildCount();
        int minimumHeight2 = childCount >= 1 ? getChildAt(childCount - 1).getMinimumHeight() : 0;
        if (minimumHeight2 == 0) {
            return getHeight() / 3;
        }
        int i2 = (minimumHeight2 * 2) + topInset;
        return i2 < getHeight() ? i2 : minimumHeight2 + topInset;
    }

    public int getPendingAction() {
        return this.z0;
    }

    public Drawable getStatusBarForeground() {
        return this.Q0;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        bv4 bv4Var = this.A0;
        if (bv4Var != null) {
            return bv4Var.d();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i = this.f;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int minimumHeight = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                z9 z9Var = (z9) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i3 = z9Var.a;
                if ((i3 & 1) == 0) {
                    break;
                }
                int topInset = measuredHeight + ((LinearLayout.LayoutParams) z9Var).topMargin + ((LinearLayout.LayoutParams) z9Var).bottomMargin + minimumHeight;
                if (i2 == 0 && childAt.getFitsSystemWindows()) {
                    topInset -= getTopInset();
                }
                minimumHeight = topInset;
                if ((i3 & 2) != 0) {
                    minimumHeight -= childAt.getMinimumHeight();
                    break;
                }
            }
            i2++;
        }
        int iMax = Math.max(0, minimumHeight);
        this.f = iMax;
        return iMax;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        uf2.O(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArr = this.O0;
        if (iArr == null) {
            iArr = new int[4];
            this.O0 = iArr;
        }
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        boolean z = this.C0;
        int i2 = R.attr.state_liftable;
        if (!z) {
            i2 = -R.attr.state_liftable;
        }
        iArr[0] = i2;
        int i3 = R.attr.state_lifted;
        if (!z || !this.D0) {
            i3 = -R.attr.state_lifted;
        }
        iArr[1] = i3;
        int i4 = R.attr.state_collapsible;
        if (!z) {
            i4 = -R.attr.state_collapsible;
        }
        iArr[2] = i4;
        int i5 = R.attr.state_collapsed;
        if (!z || !this.D0) {
            i5 = -R.attr.state_collapsed;
        }
        iArr[3] = i5;
        return View.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference weakReference = this.H0;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.H0 = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        boolean z2 = true;
        if (getFitsSystemWindows() && getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !childAt.getFitsSystemWindows()) {
                int topInset = getTopInset();
                for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt2 = getChildAt(childCount);
                    WeakHashMap weakHashMap = wp4.a;
                    childAt2.offsetTopAndBottom(topInset);
                }
            }
        }
        c();
        this.y0 = false;
        int childCount2 = getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 >= childCount2) {
                break;
            }
            if (((z9) getChildAt(i5).getLayoutParams()).c != null) {
                this.y0 = true;
                break;
            }
            i5++;
        }
        Drawable drawable = this.Q0;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.B0) {
            return;
        }
        if (!this.E0) {
            int childCount3 = getChildCount();
            int i6 = 0;
            while (true) {
                if (i6 >= childCount3) {
                    z2 = false;
                    break;
                }
                int i7 = ((z9) getChildAt(i6).getLayoutParams()).a;
                if ((i7 & 1) == 1 && (i7 & 10) != 0) {
                    break;
                } else {
                    i6++;
                }
            }
        }
        if (this.C0 != z2) {
            this.C0 = z2;
            refreshDrawableState();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824 && getFitsSystemWindows() && getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !childAt.getFitsSystemWindows()) {
                int measuredHeight = getMeasuredHeight();
                if (mode == Integer.MIN_VALUE) {
                    measuredHeight = tj4.m(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(i2));
                } else if (mode == 0) {
                    measuredHeight += getTopInset();
                }
                setMeasuredDimension(getMeasuredWidth(), measuredHeight);
            }
        }
        c();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        final yi2 yi2Var;
        ColorStateList colorStateList;
        Context context = getContext();
        final Integer numValueOf = null;
        if (drawable instanceof yi2) {
            yi2Var = (yi2) drawable;
        } else {
            ColorStateList colorStateListH = v9.h(drawable);
            if (colorStateListH == null) {
                yi2Var = null;
            } else {
                yi2 yi2Var2 = new yi2();
                yi2Var2.p(colorStateListH);
                yi2Var = yi2Var2;
            }
        }
        if (yi2Var != null && (colorStateList = yi2Var.f.c) != null) {
            this.P0 = colorStateList.getDefaultColor();
            final ColorStateList colorStateList2 = this.F0;
            if (colorStateList2 != null) {
                Context context2 = getContext();
                TypedValue typedValueA = ek0.A(context2, R.attr.colorSurface);
                if (typedValueA != null) {
                    int i = typedValueA.resourceId;
                    numValueOf = Integer.valueOf(i != 0 ? context2.getColor(i) : typedValueA.data);
                }
                this.J0 = new ValueAnimator.AnimatorUpdateListener() { // from class: y9
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Integer num;
                        int i2 = AppBarLayout.U0;
                        AppBarLayout appBarLayout = this.a;
                        LinkedHashSet linkedHashSet = appBarLayout.L0;
                        ArrayList arrayList = appBarLayout.K0;
                        int I = n12.I(appBarLayout.P0, ((Float) valueAnimator.getAnimatedValue()).floatValue(), colorStateList2.getDefaultColor());
                        ColorStateList colorStateListValueOf = ColorStateList.valueOf(I);
                        yi2 yi2Var3 = yi2Var;
                        yi2Var3.p(colorStateListValueOf);
                        if (appBarLayout.Q0 != null && (num = appBarLayout.R0) != null && num.equals(numValueOf)) {
                            appBarLayout.Q0.setTint(I);
                        }
                        if (!arrayList.isEmpty()) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                if (it.next() != null) {
                                    st4.n();
                                    return;
                                } else if (yi2Var3.f.c != null) {
                                    throw null;
                                }
                            }
                        }
                        if (linkedHashSet.isEmpty()) {
                            return;
                        }
                        Iterator it2 = linkedHashSet.iterator();
                        if (it2.hasNext()) {
                            throw dw2.z(it2);
                        }
                    }
                };
            } else {
                yi2Var.l(context);
                this.J0 = new z3(1, this, yi2Var);
            }
            drawable = yi2Var;
        }
        super.setBackground(drawable);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        uf2.L(this, f);
    }

    public void setExpanded(boolean z) {
        d(z, isLaidOut(), true);
    }

    public void setLiftOnScroll(boolean z) {
        this.E0 = z;
    }

    public void setLiftOnScrollColor(ColorStateList colorStateList) {
        if (this.F0 != colorStateList) {
            this.F0 = colorStateList;
            setBackground(getBackground());
        }
    }

    public void setLiftOnScrollTargetView(View view) {
        this.G0 = -1;
        if (view != null) {
            this.H0 = new WeakReference(view);
            return;
        }
        WeakReference weakReference = this.H0;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.H0 = null;
    }

    public void setLiftOnScrollTargetViewId(int i) {
        this.G0 = i;
        WeakReference weakReference = this.H0;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.H0 = null;
    }

    public void setLiftableOverrideEnabled(boolean z) {
        this.B0 = z;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i == 1) {
            super.setOrientation(i);
        } else {
            xe.k("AppBarLayout is always vertical and does not support horizontal orientation");
        }
    }

    public void setPendingAction(int i) {
        this.z0 = i;
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.Q0;
        if (drawable2 != drawable) {
            Integer numValueOf = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.Q0 = drawableMutate;
            if (drawableMutate instanceof yi2) {
                numValueOf = Integer.valueOf(((yi2) drawableMutate).M0);
            } else {
                ColorStateList colorStateListH = v9.h(drawableMutate);
                if (colorStateListH != null) {
                    numValueOf = Integer.valueOf(colorStateListH.getDefaultColor());
                }
            }
            this.R0 = numValueOf;
            Drawable drawable3 = this.Q0;
            boolean z = false;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.Q0.setState(getDrawableState());
                }
                this.Q0.setLayoutDirection(getLayoutDirection());
                this.Q0.setVisible(getVisibility() == 0, false);
                this.Q0.setCallback(this);
            }
            if (this.Q0 != null && getTopInset() > 0) {
                z = true;
            }
            setWillNotDraw(!z);
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarForegroundColor(int i) {
        setStatusBarForeground(new ColorDrawable(i));
    }

    public void setStatusBarForegroundResource(int i) {
        setStatusBarForeground(vo.r(getContext(), i));
    }

    @Deprecated
    public void setTargetElevation(float f) {
        co4.U(this, f);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.Q0;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.Q0;
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return b(layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return b(layoutParams);
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static class BaseBehavior<T extends AppBarLayout> extends jr1 {
        public int A0;
        public int B0;
        public ValueAnimator C0;
        public d D0;
        public WeakReference E0;

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(0);
            this.Y = -1;
            this.y0 = -1;
        }

        public static View C(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if ((childAt instanceof wq2) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x005a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void G(androidx.coordinatorlayout.widget.CoordinatorLayout r6, com.google.android.material.appbar.AppBarLayout r7, int r8, int r9, boolean r10) {
            /*
                Method dump skipped, instruction units count: 207
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.G(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, boolean):void");
        }

        public final void B(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            int iAbs = Math.abs(y() - i);
            float fAbs = Math.abs(0.0f);
            int iRound = fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / appBarLayout.getHeight()) + 1.0f) * 150.0f);
            int iY = y();
            ValueAnimator valueAnimator = this.C0;
            if (iY == i) {
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.C0.cancel();
                return;
            }
            if (valueAnimator == null) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.C0 = valueAnimator2;
                valueAnimator2.setInterpolator(t8.e);
                this.C0.addUpdateListener(new a(coordinatorLayout, this, appBarLayout));
            } else {
                valueAnimator.cancel();
            }
            this.C0.setDuration(Math.min(iRound, 600));
            this.C0.setIntValues(iY, i);
            this.C0.start();
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void D(androidx.coordinatorlayout.widget.CoordinatorLayout r9, com.google.android.material.appbar.AppBarLayout r10, android.view.View r11, int r12, int[] r13) {
            /*
                r8 = this;
                if (r12 == 0) goto L2b
                if (r12 >= 0) goto L11
                int r0 = r10.getTotalScrollRange()
                int r0 = -r0
                int r1 = r10.getDownNestedPreScrollRange()
                int r1 = r1 + r0
            Le:
                r6 = r0
                r7 = r1
                goto L18
            L11:
                int r0 = r10.getUpNestedPreScrollRange()
                int r0 = -r0
                r1 = 0
                goto Le
            L18:
                if (r6 == r7) goto L2b
                int r0 = r8.y()
                int r5 = r0 - r12
                r2 = r8
                r3 = r9
                r4 = r10
                int r8 = r2.z(r3, r4, r5, r6, r7)
                r9 = 1
                r13[r9] = r8
                goto L2c
            L2b:
                r4 = r10
            L2c:
                boolean r8 = r4.E0
                if (r8 == 0) goto L37
                boolean r8 = r4.f(r11)
                r4.e(r8)
            L37:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.D(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, android.view.View, int, int[]):void");
        }

        public final d E(Parcelable parcelable, AppBarLayout appBarLayout) {
            int iW = w();
            int childCount = appBarLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + iW;
                if (childAt.getTop() + iW <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = y.f;
                    }
                    d dVar = new d(parcelable);
                    boolean z = iW == 0;
                    dVar.A = z;
                    dVar.z = !z && (-iW) >= appBarLayout.getTotalScrollRange();
                    dVar.X = i;
                    dVar.Z = bottom == appBarLayout.getTopInset() + childAt.getMinimumHeight();
                    dVar.Y = bottom / childAt.getHeight();
                    return dVar;
                }
            }
            return null;
        }

        public final void F(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int paddingTop = appBarLayout.getPaddingTop() + appBarLayout.getTopInset();
            int iY = y() - paddingTop;
            int childCount = appBarLayout.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    i = -1;
                    break;
                }
                View childAt = appBarLayout.getChildAt(i);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                z9 z9Var = (z9) childAt.getLayoutParams();
                if ((z9Var.a & 32) == 32) {
                    top -= ((LinearLayout.LayoutParams) z9Var).topMargin;
                    bottom += ((LinearLayout.LayoutParams) z9Var).bottomMargin;
                }
                int i2 = -iY;
                if (top <= i2 && bottom >= i2) {
                    break;
                } else {
                    i++;
                }
            }
            if (i >= 0) {
                View childAt2 = appBarLayout.getChildAt(i);
                z9 z9Var2 = (z9) childAt2.getLayoutParams();
                int i3 = z9Var2.a;
                if ((i3 & 17) == 17) {
                    int topInset = -childAt2.getTop();
                    int minimumHeight = -childAt2.getBottom();
                    if (i == 0 && appBarLayout.getFitsSystemWindows() && childAt2.getFitsSystemWindows()) {
                        topInset -= appBarLayout.getTopInset();
                    }
                    if ((i3 & 2) == 2) {
                        minimumHeight += childAt2.getMinimumHeight();
                    } else if ((i3 & 5) == 5) {
                        int minimumHeight2 = childAt2.getMinimumHeight() + minimumHeight;
                        if (iY < minimumHeight2) {
                            topInset = minimumHeight2;
                        } else {
                            minimumHeight = minimumHeight2;
                        }
                    }
                    if ((i3 & 32) == 32) {
                        topInset += ((LinearLayout.LayoutParams) z9Var2).topMargin;
                        minimumHeight -= ((LinearLayout.LayoutParams) z9Var2).bottomMargin;
                    }
                    if (iY < (minimumHeight + topInset) / 2) {
                        topInset = minimumHeight;
                    }
                    B(coordinatorLayout, appBarLayout, tj4.m(topInset + paddingTop, -appBarLayout.getTotalScrollRange(), 0));
                }
            }
        }

        @Override // defpackage.qq4, defpackage.qe0
        public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            super.l(coordinatorLayout, appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            d dVar = this.D0;
            if (dVar == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i2 = -appBarLayout.getUpNestedPreScrollRange();
                        if (z) {
                            B(coordinatorLayout, appBarLayout, i2);
                        } else {
                            A(coordinatorLayout, appBarLayout, i2);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z) {
                            B(coordinatorLayout, appBarLayout, 0);
                        } else {
                            A(coordinatorLayout, appBarLayout, 0);
                        }
                    }
                }
            } else if (dVar.z) {
                A(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange());
            } else if (dVar.A) {
                A(coordinatorLayout, appBarLayout, 0);
            } else {
                View childAt = appBarLayout.getChildAt(dVar.X);
                int i3 = -childAt.getBottom();
                A(coordinatorLayout, appBarLayout, this.D0.Z ? appBarLayout.getTopInset() + childAt.getMinimumHeight() + i3 : Math.round(childAt.getHeight() * this.D0.Y) + i3);
            }
            appBarLayout.z0 = 0;
            this.D0 = null;
            int iM = tj4.m(w(), -appBarLayout.getTotalScrollRange(), 0);
            r02 r02Var = this.b;
            if (r02Var == null) {
                this.f = iM;
            } else if (r02Var.c != iM) {
                r02Var.c = iM;
                r02Var.c();
            }
            G(coordinatorLayout, appBarLayout, w(), 0, true);
            appBarLayout.b = w();
            if (!appBarLayout.willNotDraw()) {
                appBarLayout.postInvalidateOnAnimation();
            }
            if (wp4.e(coordinatorLayout) != null) {
                return true;
            }
            wp4.n(coordinatorLayout, new b(coordinatorLayout, this, appBarLayout));
            return true;
        }

        @Override // defpackage.qe0
        public final boolean m(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (((ViewGroup.MarginLayoutParams) ((te0) appBarLayout.getLayoutParams())).height != -2) {
                return false;
            }
            coordinatorLayout.r(appBarLayout, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0));
            return true;
        }

        @Override // defpackage.qe0
        public final /* bridge */ /* synthetic */ void o(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
            D(coordinatorLayout, (AppBarLayout) view, view2, i2, iArr);
        }

        @Override // defpackage.qe0
        public final void p(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int[] iArr) {
            BaseBehavior<T> baseBehavior;
            CoordinatorLayout coordinatorLayout2;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i3 < 0) {
                baseBehavior = this;
                coordinatorLayout2 = coordinatorLayout;
                iArr[1] = baseBehavior.z(coordinatorLayout2, appBarLayout, y() - i3, -appBarLayout.getDownNestedScrollRange(), 0);
            } else {
                baseBehavior = this;
                coordinatorLayout2 = coordinatorLayout;
            }
            if (i3 == 0 && wp4.e(coordinatorLayout2) == null) {
                wp4.n(coordinatorLayout2, new b(coordinatorLayout2, baseBehavior, appBarLayout));
            }
        }

        @Override // defpackage.qe0
        public final void r(View view, Parcelable parcelable) {
            if (parcelable instanceof d) {
                this.D0 = (d) parcelable;
            } else {
                this.D0 = null;
            }
        }

        @Override // defpackage.qe0
        public final Parcelable s(View view) {
            AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
            d dVarE = E(absSavedState, (AppBarLayout) view);
            return dVarE == null ? absSavedState : dVarE;
        }

        @Override // defpackage.qe0
        public final boolean t(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2) {
            ValueAnimator valueAnimator;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            boolean z = (i & 2) != 0 && (appBarLayout.E0 || appBarLayout.D0 || (appBarLayout.getTotalScrollRange() != 0 && coordinatorLayout.getHeight() - view2.getHeight() <= appBarLayout.getHeight()));
            if (z && (valueAnimator = this.C0) != null) {
                valueAnimator.cancel();
            }
            this.E0 = null;
            this.B0 = i2;
            return z;
        }

        @Override // defpackage.qe0
        public final void u(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this.B0 == 0 || i == 1) {
                F(coordinatorLayout, appBarLayout);
                if (appBarLayout.E0) {
                    appBarLayout.e(appBarLayout.f(view2));
                }
            }
            this.E0 = new WeakReference(view2);
        }

        @Override // defpackage.jr1
        public final int y() {
            return w() + this.A0;
        }

        /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0144  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0157  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x015c  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x015e  */
        @Override // defpackage.jr1
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int z(androidx.coordinatorlayout.widget.CoordinatorLayout r18, android.view.View r19, int r20, int r21, int r22) {
            /*
                Method dump skipped, instruction units count: 374
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.z(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, int, int, int):int");
        }

        public BaseBehavior() {
            this.Y = -1;
            this.y0 = -1;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        z9 z9Var = new z9(-1, -2);
        z9Var.a = 1;
        return z9Var;
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static class ScrollingViewBehavior extends kr1 {
        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(0);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, rc3.K);
            this.Y = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public static AppBarLayout z(ArrayList arrayList) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                View view = (View) arrayList.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // defpackage.qe0
        public final boolean f(View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // defpackage.qe0
        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            qe0 qe0Var = ((te0) view2.getLayoutParams()).a;
            if (qe0Var instanceof BaseBehavior) {
                int bottom = (((view2.getBottom() - view.getTop()) + ((BaseBehavior) qe0Var).A0) + this.X) - y(view2);
                WeakHashMap weakHashMap = wp4.a;
                view.offsetTopAndBottom(bottom);
            }
            if (!(view2 instanceof AppBarLayout)) {
                return false;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view2;
            if (!appBarLayout.E0) {
                return false;
            }
            appBarLayout.e(appBarLayout.f(view));
            return false;
        }

        @Override // defpackage.qe0
        public final void i(CoordinatorLayout coordinatorLayout, View view) {
            if (view instanceof AppBarLayout) {
                wp4.n(coordinatorLayout, null);
            }
        }

        @Override // defpackage.qe0
        public final boolean q(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout appBarLayoutZ = z(coordinatorLayout.k(view));
            if (appBarLayoutZ != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                int width = coordinatorLayout.getWidth();
                int height = coordinatorLayout.getHeight();
                Rect rect3 = this.z;
                rect3.set(0, 0, width, height);
                if (!rect3.contains(rect2)) {
                    appBarLayoutZ.d(false, !z, true);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior() {
        }
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }
}
