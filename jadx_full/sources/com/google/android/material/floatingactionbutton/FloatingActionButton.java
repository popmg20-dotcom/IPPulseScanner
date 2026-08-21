package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.getsurfboard.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import defpackage.a91;
import defpackage.bo;
import defpackage.co4;
import defpackage.db;
import defpackage.fx3;
import defpackage.j81;
import defpackage.jl3;
import defpackage.ks4;
import defpackage.l72;
import defpackage.ou3;
import defpackage.pe0;
import defpackage.po0;
import defpackage.qe0;
import defpackage.qt;
import defpackage.rc3;
import defpackage.rm2;
import defpackage.te0;
import defpackage.tj4;
import defpackage.ua1;
import defpackage.uf2;
import defpackage.v;
import defpackage.vf1;
import defpackage.wp4;
import defpackage.xe;
import defpackage.xf1;
import defpackage.yf1;
import defpackage.yu3;
import defpackage.zf2;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class FloatingActionButton extends ks4 implements j81, yu3, pe0 {
    public ColorStateList A;
    public int A0;
    public int B0;
    public int C0;
    public int D0;
    public boolean E0;
    public final Rect F0;
    public final Rect G0;
    public final qt H0;
    public final v I0;
    public yf1 J0;
    public ColorStateList f;
    public PorterDuff.Mode y0;
    public PorterDuff.Mode z;
    public ColorStateList z0;

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        ColorStateList colorStateList;
        Drawable drawable;
        Drawable layerDrawable;
        super(co4.d0(context, attributeSet, R.attr.floatingActionButtonStyle, R.style.Widget_Design_FloatingActionButton), attributeSet, R.attr.floatingActionButtonStyle);
        this.b = getVisibility();
        this.F0 = new Rect();
        this.G0 = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayV = fx3.v(context2, attributeSet, rc3.m, R.attr.floatingActionButtonStyle, R.style.Widget_Design_FloatingActionButton, new int[0]);
        this.f = l72.r(context2, typedArrayV, 1);
        this.z = tj4.V(typedArrayV.getInt(2, -1), null);
        this.z0 = l72.r(context2, typedArrayV, 12);
        this.A0 = typedArrayV.getInt(7, -1);
        this.B0 = typedArrayV.getDimensionPixelSize(6, 0);
        int dimensionPixelSize = typedArrayV.getDimensionPixelSize(3, 0);
        float dimension = typedArrayV.getDimension(4, 0.0f);
        float dimension2 = typedArrayV.getDimension(9, 0.0f);
        float dimension3 = typedArrayV.getDimension(11, 0.0f);
        this.E0 = typedArrayV.getBoolean(16, false);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.mtrl_fab_min_touch_target);
        setMaxImageSize(typedArrayV.getDimensionPixelSize(10, 0));
        rm2 rm2VarA = rm2.a(context2, typedArrayV, 15);
        rm2 rm2VarA2 = rm2.a(context2, typedArrayV, 8);
        ou3 ou3VarB = ou3.i(context2, attributeSet, R.attr.floatingActionButtonStyle, R.style.Widget_Design_FloatingActionButton, ou3.m).b();
        boolean z = typedArrayV.getBoolean(5, false);
        setEnabled(typedArrayV.getBoolean(0, true));
        typedArrayV.recycle();
        qt qtVar = new qt(this);
        this.H0 = qtVar;
        qtVar.n(attributeSet, R.attr.floatingActionButtonStyle);
        this.I0 = new v(this);
        getImpl().g(ou3VarB);
        yf1 impl = getImpl();
        ColorStateList colorStateList2 = this.f;
        PorterDuff.Mode mode = this.z;
        ColorStateList colorStateList3 = this.z0;
        FloatingActionButton floatingActionButton = impl.s;
        ou3 ou3Var = impl.a;
        ou3Var.getClass();
        xf1 xf1Var = new xf1(ou3Var);
        impl.b = xf1Var;
        xf1Var.setTintList(colorStateList2);
        if (mode != null) {
            impl.b.setTintMode(mode);
        }
        impl.b.l(floatingActionButton.getContext());
        if (dimensionPixelSize > 0) {
            Context context3 = floatingActionButton.getContext();
            ou3 ou3Var2 = impl.a;
            ou3Var2.getClass();
            bo boVar = new bo(ou3Var2);
            int color = context3.getColor(R.color.design_fab_stroke_top_outer_color);
            int color2 = context3.getColor(R.color.design_fab_stroke_top_inner_color);
            colorStateList = colorStateList3;
            int color3 = context3.getColor(R.color.design_fab_stroke_end_inner_color);
            int color4 = context3.getColor(R.color.design_fab_stroke_end_outer_color);
            boVar.i = color;
            boVar.j = color2;
            boVar.k = color3;
            boVar.l = color4;
            float f = dimensionPixelSize;
            if (boVar.h != f) {
                boVar.h = f;
                boVar.b.setStrokeWidth(f * 1.3333f);
                boVar.n = true;
                boVar.invalidateSelf();
            }
            if (colorStateList2 != null) {
                boVar.m = colorStateList2.getColorForState(boVar.getState(), boVar.m);
            }
            boVar.p = colorStateList2;
            boVar.n = true;
            boVar.invalidateSelf();
            impl.d = boVar;
            bo boVar2 = impl.d;
            boVar2.getClass();
            xf1 xf1Var2 = impl.b;
            xf1Var2.getClass();
            layerDrawable = new LayerDrawable(new Drawable[]{boVar2, xf1Var2});
            drawable = null;
        } else {
            colorStateList = colorStateList3;
            drawable = null;
            impl.d = null;
            layerDrawable = impl.b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(jl3.c(colorStateList), layerDrawable, drawable);
        impl.c = rippleDrawable;
        impl.e = rippleDrawable;
        getImpl().k = dimensionPixelSize2;
        yf1 impl2 = getImpl();
        if (impl2.h != dimension) {
            impl2.h = dimension;
            impl2.e(dimension, impl2.i, impl2.j);
        }
        yf1 impl3 = getImpl();
        if (impl3.i != dimension2) {
            impl3.i = dimension2;
            impl3.e(impl3.h, dimension2, impl3.j);
        }
        yf1 impl4 = getImpl();
        if (impl4.j != dimension3) {
            impl4.j = dimension3;
            impl4.e(impl4.h, impl4.i, dimension3);
        }
        getImpl().n = rm2VarA;
        getImpl().o = rm2VarA2;
        getImpl().f = z;
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private yf1 getImpl() {
        yf1 yf1Var = this.J0;
        if (yf1Var != null) {
            return yf1Var;
        }
        yf1 yf1Var2 = new yf1(this, new zf2(25, this));
        this.J0 = yf1Var2;
        return yf1Var2;
    }

    public final int c(int i) {
        int i2 = this.B0;
        if (i2 != 0) {
            return i2;
        }
        Resources resources = getResources();
        return i != -1 ? i != 1 ? resources.getDimensionPixelSize(R.dimen.design_fab_size_normal) : resources.getDimensionPixelSize(R.dimen.design_fab_size_mini) : Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? c(1) : c(0);
    }

    public final void d(boolean z) {
        yf1 impl = getImpl();
        FloatingActionButton floatingActionButton = impl.s;
        int visibility = floatingActionButton.getVisibility();
        int i = impl.r;
        if (visibility == 0) {
            if (i == 1) {
                return;
            }
        } else if (i != 2) {
            return;
        }
        Animator animator = impl.m;
        if (animator != null) {
            animator.cancel();
        }
        FloatingActionButton floatingActionButton2 = impl.s;
        if (!floatingActionButton2.isLaidOut() || floatingActionButton2.isInEditMode()) {
            floatingActionButton.a(z ? 8 : 4, z);
            return;
        }
        rm2 rm2Var = impl.o;
        AnimatorSet animatorSetB = rm2Var != null ? impl.b(rm2Var, 0.0f, 0.0f, 0.0f) : impl.c(0.0f, 0.4f, 0.4f, yf1.B, yf1.C);
        animatorSetB.addListener(new vf1(impl, z));
        animatorSetB.start();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public final void e() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.A;
        if (colorStateList == null) {
            drawable.clearColorFilter();
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.y0;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(db.c(colorForState, mode));
    }

    public final void f(boolean z) {
        yf1 impl = getImpl();
        FloatingActionButton floatingActionButton = impl.s;
        Matrix matrix = impl.x;
        FloatingActionButton floatingActionButton2 = impl.s;
        int visibility = floatingActionButton.getVisibility();
        int i = impl.r;
        if (visibility != 0) {
            if (i == 2) {
                return;
            }
        } else if (i != 1) {
            return;
        }
        Animator animator = impl.m;
        if (animator != null) {
            animator.cancel();
        }
        boolean z2 = impl.n == null;
        if (!floatingActionButton2.isLaidOut() || floatingActionButton2.isInEditMode()) {
            floatingActionButton.a(0, z);
            floatingActionButton.setAlpha(1.0f);
            floatingActionButton.setScaleY(1.0f);
            floatingActionButton.setScaleX(1.0f);
            impl.p = 1.0f;
            impl.a(1.0f, matrix);
            floatingActionButton2.setImageMatrix(matrix);
            return;
        }
        if (floatingActionButton.getVisibility() != 0) {
            floatingActionButton.setAlpha(0.0f);
            floatingActionButton.setScaleY(z2 ? 0.4f : 0.0f);
            floatingActionButton.setScaleX(z2 ? 0.4f : 0.0f);
            float f = z2 ? 0.4f : 0.0f;
            impl.p = f;
            impl.a(f, matrix);
            floatingActionButton2.setImageMatrix(matrix);
        }
        rm2 rm2Var = impl.n;
        AnimatorSet animatorSetB = rm2Var != null ? impl.b(rm2Var, 1.0f, 1.0f, 1.0f) : impl.c(1.0f, 1.0f, 1.0f, yf1.z, yf1.A);
        animatorSetB.addListener(new ua1(impl, z));
        animatorSetB.start();
    }

    @Override // android.widget.ImageButton, android.widget.ImageView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "com.google.android.material.floatingactionbutton.FloatingActionButton";
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.z;
    }

    @Override // defpackage.pe0
    public qe0 getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().s.getElevation();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().i;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().j;
    }

    public Drawable getContentBackground() {
        return getImpl().e;
    }

    public int getCustomSize() {
        return this.B0;
    }

    public int getExpandedComponentIdHint() {
        return this.I0.b;
    }

    public rm2 getHideMotionSpec() {
        return getImpl().o;
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.z0;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.z0;
    }

    @Override // defpackage.yu3
    public ou3 getShapeAppearanceModel() {
        ou3 ou3Var = getImpl().a;
        ou3Var.getClass();
        return ou3Var;
    }

    public rm2 getShowMotionSpec() {
        return getImpl().n;
    }

    public int getSize() {
        return this.A0;
    }

    public int getSizeDimension() {
        return c(this.A0);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.A;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.y0;
    }

    public boolean getUseCompatPadding() {
        return this.E0;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        yf1 impl = getImpl();
        xf1 xf1Var = impl.b;
        if (xf1Var != null) {
            uf2.N(impl.s, xf1Var);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().s.getViewTreeObserver();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.C0 = (sizeDimension - this.D0) / 2;
        getImpl().h();
        int iMin = Math.min(View.resolveSize(sizeDimension, i), View.resolveSize(sizeDimension, i2));
        Rect rect = this.F0;
        setMeasuredDimension(rect.left + iMin + rect.right, iMin + rect.top + rect.bottom);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a91)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a91 a91Var = (a91) parcelable;
        super.onRestoreInstanceState(a91Var.b);
        Bundle bundle = (Bundle) a91Var.z.get("expandableWidgetHelper");
        bundle.getClass();
        v vVar = this.I0;
        vVar.getClass();
        vVar.a = bundle.getBoolean("expanded", false);
        vVar.b = bundle.getInt("expandedComponentIdHint", 0);
        if (vVar.a) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) vVar.c;
            ViewParent parent = floatingActionButton.getParent();
            if (parent instanceof CoordinatorLayout) {
                ((CoordinatorLayout) parent).i(floatingActionButton);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = new Bundle();
        }
        a91 a91Var = new a91(parcelableOnSaveInstanceState);
        v vVar = this.I0;
        vVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", vVar.a);
        bundle.putInt("expandedComponentIdHint", vVar.b);
        a91Var.z.put("expandableWidgetHelper", bundle);
        return a91Var;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            Rect rect = this.G0;
            rect.set(0, 0, measuredWidth, measuredHeight);
            int i = rect.left;
            Rect rect2 = this.F0;
            rect.left = i + rect2.left;
            rect.top += rect2.top;
            rect.right -= rect2.right;
            rect.bottom -= rect2.bottom;
            yf1 yf1Var = this.J0;
            int i2 = -(yf1Var.f ? Math.max((yf1Var.k - yf1Var.s.getSizeDimension()) / 2, 0) : 0);
            rect.inset(i2, i2);
            if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f != colorStateList) {
            this.f = colorStateList;
            yf1 impl = getImpl();
            xf1 xf1Var = impl.b;
            if (xf1Var != null) {
                xf1Var.setTintList(colorStateList);
            }
            bo boVar = impl.d;
            if (boVar != null) {
                if (colorStateList != null) {
                    boVar.m = colorStateList.getColorForState(boVar.getState(), boVar.m);
                }
                boVar.p = colorStateList;
                boVar.n = true;
                boVar.invalidateSelf();
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.z != mode) {
            this.z = mode;
            xf1 xf1Var = getImpl().b;
            if (xf1Var != null) {
                xf1Var.setTintMode(mode);
            }
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        if (Build.VERSION.SDK_INT >= 26) {
            setTooltipText(isClickable() ? getContentDescription() : null);
        }
    }

    public void setCompatElevation(float f) {
        yf1 impl = getImpl();
        if (impl.h != f) {
            impl.h = f;
            impl.e(f, impl.i, impl.j);
        }
    }

    public void setCompatElevationResource(int i) {
        setCompatElevation(getResources().getDimension(i));
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        yf1 impl = getImpl();
        if (impl.i != f) {
            impl.i = f;
            impl.e(impl.h, f, impl.j);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(int i) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
    }

    public void setCompatPressedTranslationZ(float f) {
        yf1 impl = getImpl();
        if (impl.j != f) {
            impl.j = f;
            impl.e(impl.h, impl.i, f);
        }
    }

    public void setCompatPressedTranslationZResource(int i) {
        setCompatPressedTranslationZ(getResources().getDimension(i));
    }

    @Override // android.view.View
    public void setContentDescription(CharSequence charSequence) {
        super.setContentDescription(charSequence);
        if (Build.VERSION.SDK_INT >= 26) {
            setTooltipText(isClickable() ? getContentDescription() : null);
        }
    }

    public void setCustomSize(int i) {
        if (i < 0) {
            xe.k("Custom size must be non-negative");
        } else if (i != this.B0) {
            this.B0 = i;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        xf1 xf1Var = getImpl().b;
        if (xf1Var != null) {
            xf1Var.o(f);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != getImpl().f) {
            getImpl().f = z;
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i) {
        this.I0.b = i;
    }

    public void setHideMotionSpec(rm2 rm2Var) {
        getImpl().o = rm2Var;
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(rm2.b(getContext(), i));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            yf1 impl = getImpl();
            float f = impl.p;
            impl.p = f;
            Matrix matrix = impl.x;
            impl.a(f, matrix);
            impl.s.setImageMatrix(matrix);
            if (this.A != null) {
                e();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.H0.t(i);
        e();
    }

    public void setMaxImageSize(int i) {
        this.D0 = i;
        yf1 impl = getImpl();
        if (impl.q != i) {
            impl.q = i;
            float f = impl.p;
            impl.p = f;
            Matrix matrix = impl.x;
            impl.a(f, matrix);
            impl.s.setImageMatrix(matrix);
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.z0 != colorStateList) {
            this.z0 = colorStateList;
            yf1 impl = getImpl();
            ColorStateList colorStateList2 = this.z0;
            RippleDrawable rippleDrawable = impl.c;
            if (rippleDrawable != null) {
                rippleDrawable.setColor(jl3.c(colorStateList2));
            } else if (rippleDrawable != null) {
                rippleDrawable.setTintList(jl3.c(colorStateList2));
            }
        }
    }

    @Override // android.view.View
    public void setScaleX(float f) {
        super.setScaleX(f);
        getImpl().getClass();
    }

    @Override // android.view.View
    public void setScaleY(float f) {
        super.setScaleY(f);
        getImpl().getClass();
    }

    public void setShadowPaddingEnabled(boolean z) {
        yf1 impl = getImpl();
        impl.g = z;
        impl.h();
    }

    @Override // defpackage.yu3
    public void setShapeAppearanceModel(ou3 ou3Var) {
        getImpl().g(ou3Var);
    }

    public void setShowMotionSpec(rm2 rm2Var) {
        getImpl().n = rm2Var;
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(rm2.b(getContext(), i));
    }

    public void setSize(int i) {
        this.B0 = 0;
        if (i != this.A0) {
            this.A0 = i;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            e();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.y0 != mode) {
            this.y0 = mode;
            e();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        super.setTranslationX(f);
        getImpl().f();
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        super.setTranslationY(f);
        getImpl().f();
    }

    @Override // android.view.View
    public void setTranslationZ(float f) {
        super.setTranslationZ(f);
        getImpl().f();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.E0 != z) {
            this.E0 = z;
            getImpl().h();
        }
    }

    @Override // defpackage.ks4, android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static class BaseBehavior<T extends FloatingActionButton> extends qe0 {
        public Rect b;
        public final boolean f;

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, rc3.n);
            this.f = typedArrayObtainStyledAttributes.getBoolean(0, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // defpackage.qe0
        public final boolean e(View view, Rect rect) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            Rect rect2 = floatingActionButton.F0;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override // defpackage.qe0
        public final void g(te0 te0Var) {
            if (te0Var.h == 0) {
                te0Var.h = 80;
            }
        }

        @Override // defpackage.qe0
        public final boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                w(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof te0 ? ((te0) layoutParams).a instanceof BottomSheetBehavior : false) {
                    x(view2, floatingActionButton);
                }
            }
            return false;
        }

        @Override // defpackage.qe0
        public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            ArrayList arrayListK = coordinatorLayout.k(floatingActionButton);
            int size = arrayListK.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                View view2 = (View) arrayListK.get(i3);
                if (!(view2 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof te0 ? ((te0) layoutParams).a instanceof BottomSheetBehavior : false) && x(view2, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (w(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.q(floatingActionButton, i);
            Rect rect = floatingActionButton.F0;
            if (rect.centerX() > 0 && rect.centerY() > 0) {
                te0 te0Var = (te0) floatingActionButton.getLayoutParams();
                int i4 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) te0Var).rightMargin ? rect.right : floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) te0Var).leftMargin ? -rect.left : 0;
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) te0Var).bottomMargin) {
                    i2 = rect.bottom;
                } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) te0Var).topMargin) {
                    i2 = -rect.top;
                }
                if (i2 != 0) {
                    WeakHashMap weakHashMap = wp4.a;
                    floatingActionButton.offsetTopAndBottom(i2);
                }
                if (i4 != 0) {
                    WeakHashMap weakHashMap2 = wp4.a;
                    floatingActionButton.offsetLeftAndRight(i4);
                }
            }
            return true;
        }

        public final boolean w(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            te0 te0Var = (te0) floatingActionButton.getLayoutParams();
            if (!this.f || te0Var.f != appBarLayout.getId() || floatingActionButton.getUserSetVisibility() != 0) {
                return false;
            }
            Rect rect = this.b;
            if (rect == null) {
                rect = new Rect();
                this.b = rect;
            }
            po0.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.d(false);
                return true;
            }
            floatingActionButton.f(false);
            return true;
        }

        public final boolean x(View view, FloatingActionButton floatingActionButton) {
            te0 te0Var = (te0) floatingActionButton.getLayoutParams();
            if (!this.f || te0Var.f != view.getId() || floatingActionButton.getUserSetVisibility() != 0) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((te0) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.d(false);
                return true;
            }
            floatingActionButton.f(false);
            return true;
        }

        public BaseBehavior() {
            this.f = true;
        }
    }

    public void setRippleColor(int i) {
        setRippleColor(ColorStateList.valueOf(i));
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }
}
