package com.google.android.material.card;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import defpackage.co4;
import defpackage.fb3;
import defpackage.fx3;
import defpackage.ji2;
import defpackage.l72;
import defpackage.li2;
import defpackage.n12;
import defpackage.o73;
import defpackage.ou3;
import defpackage.p24;
import defpackage.q10;
import defpackage.qa3;
import defpackage.qb0;
import defpackage.rc3;
import defpackage.uf2;
import defpackage.v9;
import defpackage.vo;
import defpackage.wi2;
import defpackage.x04;
import defpackage.yi2;
import defpackage.yu3;
import defpackage.zo2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class MaterialCardView extends q10 implements Checkable, yu3 {
    public static final int[] F0 = {R.attr.state_checkable};
    public static final int[] G0 = {R.attr.state_checked};
    public static final int[] H0 = {com.getsurfboard.R.attr.state_dragged};
    public static final int[] I0 = {R.attr.state_hovered};
    public final li2 A0;
    public final boolean B0;
    public boolean C0;
    public boolean D0;
    public ji2 E0;

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        p24 p24VarF;
        super(co4.d0(context, attributeSet, com.getsurfboard.R.attr.materialCardViewStyle, com.getsurfboard.R.style.Widget_MaterialComponents_CardView), attributeSet);
        this.C0 = false;
        this.D0 = false;
        this.B0 = true;
        TypedArray typedArrayV = fx3.v(getContext(), attributeSet, rc3.v, com.getsurfboard.R.attr.materialCardViewStyle, com.getsurfboard.R.style.Widget_MaterialComponents_CardView, new int[0]);
        li2 li2Var = new li2(this, attributeSet);
        this.A0 = li2Var;
        ColorStateList cardBackgroundColor = super.getCardBackgroundColor();
        yi2 yi2Var = li2Var.c;
        yi2Var.p(cardBackgroundColor);
        li2Var.b.set(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        li2Var.l();
        MaterialCardView materialCardView = li2Var.a;
        ColorStateList colorStateListR = l72.r(materialCardView.getContext(), typedArrayV, 11);
        li2Var.o = colorStateListR;
        if (colorStateListR == null) {
            li2Var.o = ColorStateList.valueOf(-1);
        }
        li2Var.i = typedArrayV.getDimensionPixelSize(12, 0);
        boolean z = typedArrayV.getBoolean(0, false);
        li2Var.t = z;
        materialCardView.setLongClickable(z);
        li2Var.m = l72.r(materialCardView.getContext(), typedArrayV, 6);
        li2Var.g(l72.u(materialCardView.getContext(), typedArrayV, 2));
        li2Var.g = typedArrayV.getDimensionPixelSize(5, 0);
        li2Var.f = typedArrayV.getDimensionPixelSize(4, 0);
        li2Var.h = typedArrayV.getInteger(3, 8388661);
        ColorStateList colorStateListR2 = l72.r(materialCardView.getContext(), typedArrayV, 7);
        li2Var.l = colorStateListR2;
        if (colorStateListR2 == null) {
            li2Var.l = ColorStateList.valueOf(n12.A(materialCardView, com.getsurfboard.R.attr.colorControlHighlight));
        }
        ColorStateList colorStateListR3 = l72.r(materialCardView.getContext(), typedArrayV, 1);
        colorStateListR3 = colorStateListR3 == null ? ColorStateList.valueOf(0) : colorStateListR3;
        yi2 yi2Var2 = li2Var.d;
        yi2Var2.p(colorStateListR3);
        RippleDrawable rippleDrawable = li2Var.p;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(li2Var.l);
        }
        yi2Var.o(materialCardView.getCardElevation());
        float f = li2Var.i;
        ColorStateList colorStateList = li2Var.o;
        yi2Var2.f.j = f;
        yi2Var2.invalidateSelf();
        wi2 wi2Var = yi2Var2.f;
        if (wi2Var.d != colorStateList) {
            wi2Var.d = colorStateList;
            yi2Var2.onStateChange(yi2Var2.getState());
        }
        materialCardView.setBackgroundInternal(li2Var.d(yi2Var));
        Drawable drawableC = li2Var.j() ? li2Var.c() : yi2Var2;
        li2Var.j = drawableC;
        materialCardView.setForeground(li2Var.d(drawableC));
        if (li2Var.e == -1.0f && (p24VarF = p24.f(materialCardView.getContext(), typedArrayV, 8)) != null) {
            x04 x04VarX = l72.X(materialCardView.getContext());
            yi2Var.n(x04VarX);
            yi2Var2.n(x04VarX);
            yi2 yi2Var3 = li2Var.r;
            if (yi2Var3 != null) {
                yi2Var3.n(x04VarX);
            }
            li2Var.h(p24VarF);
        }
        typedArrayV.recycle();
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.A0.c.getBounds());
        return rectF;
    }

    public final void b() {
        li2 li2Var;
        RippleDrawable rippleDrawable;
        if (Build.VERSION.SDK_INT <= 26 || (rippleDrawable = (li2Var = this.A0).p) == null) {
            return;
        }
        Rect bounds = rippleDrawable.getBounds();
        int i = bounds.bottom;
        li2Var.p.setBounds(bounds.left, bounds.top, bounds.right, i - 1);
        li2Var.p.setBounds(bounds.left, bounds.top, bounds.right, i);
    }

    @Override // defpackage.q10
    public ColorStateList getCardBackgroundColor() {
        return this.A0.c.f.c;
    }

    public ColorStateList getCardForegroundColor() {
        return this.A0.d.f.c;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.A0.k;
    }

    public int getCheckedIconGravity() {
        return this.A0.h;
    }

    public int getCheckedIconMargin() {
        return this.A0.f;
    }

    public int getCheckedIconSize() {
        return this.A0.g;
    }

    public ColorStateList getCheckedIconTint() {
        return this.A0.m;
    }

    @Override // defpackage.q10
    public int getContentPaddingBottom() {
        return this.A0.b.bottom;
    }

    @Override // defpackage.q10
    public int getContentPaddingLeft() {
        return this.A0.b.left;
    }

    @Override // defpackage.q10
    public int getContentPaddingRight() {
        return this.A0.b.right;
    }

    @Override // defpackage.q10
    public int getContentPaddingTop() {
        return this.A0.b.top;
    }

    public float getProgress() {
        return this.A0.c.f.i;
    }

    @Override // defpackage.q10
    public float getRadius() {
        return this.A0.c.i();
    }

    public ColorStateList getRippleColor() {
        return this.A0.l;
    }

    @Override // defpackage.yu3
    public ou3 getShapeAppearanceModel() {
        return this.A0.n.d();
    }

    @Deprecated
    public int getStrokeColor() {
        ColorStateList colorStateList = this.A0.o;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.A0.o;
    }

    public int getStrokeWidth() {
        return this.A0.i;
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.C0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        li2 li2Var = this.A0;
        li2Var.k();
        uf2.N(this, li2Var.c);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 8);
        li2 li2Var = this.A0;
        if (li2Var != null && li2Var.t) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, F0);
        }
        if (this.C0) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, G0);
        }
        if (this.D0) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, H0);
        }
        if (isDuplicateParentStateEnabled()) {
            if (isPressed()) {
                View.mergeDrawableStates(iArrOnCreateDrawableState, FrameLayout.PRESSED_STATE_SET);
            }
            if (isHovered()) {
                View.mergeDrawableStates(iArrOnCreateDrawableState, I0);
            }
            if (isEnabled()) {
                View.mergeDrawableStates(iArrOnCreateDrawableState, FrameLayout.ENABLED_STATE_SET);
            }
            if (isFocused()) {
                View.mergeDrawableStates(iArrOnCreateDrawableState, FrameLayout.FOCUSED_STATE_SET);
            }
            if (isSelected()) {
                View.mergeDrawableStates(iArrOnCreateDrawableState, FrameLayout.SELECTED_STATE_SET);
            }
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(this.C0);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        li2 li2Var = this.A0;
        accessibilityNodeInfo.setCheckable(li2Var != null && li2Var.t);
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(this.C0);
    }

    @Override // defpackage.q10, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.A0.e(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.B0) {
            li2 li2Var = this.A0;
            if (!li2Var.s) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                li2Var.s = true;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // defpackage.q10
    public void setCardBackgroundColor(int i) {
        this.A0.c.p(ColorStateList.valueOf(i));
    }

    @Override // defpackage.q10
    public void setCardElevation(float f) {
        super.setCardElevation(f);
        li2 li2Var = this.A0;
        li2Var.c.o(li2Var.a.getCardElevation());
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        yi2 yi2Var = this.A0.d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        yi2Var.p(colorStateList);
    }

    public void setCheckable(boolean z) {
        this.A0.t = z;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.C0 != z) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.A0.g(drawable);
    }

    public void setCheckedIconGravity(int i) {
        li2 li2Var = this.A0;
        if (li2Var.h != i) {
            li2Var.h = i;
            MaterialCardView materialCardView = li2Var.a;
            li2Var.e(materialCardView.getMeasuredWidth(), materialCardView.getMeasuredHeight());
        }
    }

    public void setCheckedIconMargin(int i) {
        this.A0.f = i;
    }

    public void setCheckedIconMarginResource(int i) {
        if (i != -1) {
            this.A0.f = getResources().getDimensionPixelSize(i);
        }
    }

    public void setCheckedIconResource(int i) {
        this.A0.g(vo.r(getContext(), i));
    }

    public void setCheckedIconSize(int i) {
        this.A0.g = i;
    }

    public void setCheckedIconSizeResource(int i) {
        if (i != 0) {
            this.A0.g = getResources().getDimensionPixelSize(i);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        li2 li2Var = this.A0;
        li2Var.m = colorStateList;
        Drawable drawable = li2Var.k;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        li2 li2Var = this.A0;
        if (li2Var != null) {
            li2Var.k();
        }
    }

    public void setDragged(boolean z) {
        if (this.D0 != z) {
            this.D0 = z;
            refreshDrawableState();
            b();
            invalidate();
        }
    }

    @Override // defpackage.q10
    public void setMaxCardElevation(float f) {
        super.setMaxCardElevation(f);
        this.A0.m();
    }

    public void setOnCheckedChangeListener(ji2 ji2Var) {
        this.E0 = ji2Var;
    }

    @Override // defpackage.q10
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        li2 li2Var = this.A0;
        li2Var.m();
        li2Var.l();
    }

    public void setProgress(float f) {
        li2 li2Var = this.A0;
        li2Var.c.q(f);
        yi2 yi2Var = li2Var.d;
        if (yi2Var != null) {
            yi2Var.q(f);
        }
        yi2 yi2Var2 = li2Var.r;
        if (yi2Var2 != null) {
            yi2Var2.q(f);
        }
    }

    @Override // defpackage.q10
    public void setRadius(float f) {
        super.setRadius(f);
        li2 li2Var = this.A0;
        li2Var.e = f;
        li2Var.h(li2Var.n.d().a(f));
        li2Var.j.invalidateSelf();
        if (li2Var.i() || (li2Var.a.getPreventCornerOverlap() && !li2Var.c.m())) {
            li2Var.l();
        }
        if (li2Var.i()) {
            li2Var.m();
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        li2 li2Var = this.A0;
        li2Var.l = colorStateList;
        RippleDrawable rippleDrawable = li2Var.p;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(colorStateList);
        }
    }

    public void setRippleColorResource(int i) {
        ColorStateList colorStateListG = v9.g(getContext(), i);
        li2 li2Var = this.A0;
        li2Var.l = colorStateListG;
        RippleDrawable rippleDrawable = li2Var.p;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(colorStateListG);
        }
    }

    @Override // defpackage.yu3
    public void setShapeAppearanceModel(ou3 ou3Var) {
        setClipToOutline(ou3Var.k(getBoundsAsRectF()));
        this.A0.h(ou3Var);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        li2 li2Var = this.A0;
        if (li2Var.o != colorStateList) {
            li2Var.o = colorStateList;
            yi2 yi2Var = li2Var.d;
            yi2Var.f.j = li2Var.i;
            yi2Var.invalidateSelf();
            wi2 wi2Var = yi2Var.f;
            if (wi2Var.d != colorStateList) {
                wi2Var.d = colorStateList;
                yi2Var.onStateChange(yi2Var.getState());
            }
        }
        invalidate();
    }

    public void setStrokeWidth(int i) {
        li2 li2Var = this.A0;
        if (i != li2Var.i) {
            li2Var.i = i;
            yi2 yi2Var = li2Var.d;
            ColorStateList colorStateList = li2Var.o;
            yi2Var.f.j = i;
            yi2Var.invalidateSelf();
            wi2 wi2Var = yi2Var.f;
            if (wi2Var.d != colorStateList) {
                wi2Var.d = colorStateList;
                yi2Var.onStateChange(yi2Var.getState());
            }
        }
        invalidate();
    }

    @Override // defpackage.q10
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        li2 li2Var = this.A0;
        li2Var.m();
        li2Var.l();
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        li2 li2Var = this.A0;
        if (li2Var != null && li2Var.t && isEnabled()) {
            this.C0 = !this.C0;
            refreshDrawableState();
            b();
            li2Var.f(this.C0, true);
            ji2 ji2Var = this.E0;
            if (ji2Var != null) {
                boolean z = this.C0;
                AppCompatTextView appCompatTextView = (AppCompatTextView) ((fb3) ((o73) ji2Var).f).u.X;
                ViewGroup.LayoutParams layoutParams = appCompatTextView.getLayoutParams();
                if (layoutParams == null) {
                    zo2.n("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    return;
                }
                qb0 qb0Var = (qb0) layoutParams;
                qb0Var.setMarginEnd(z ? qa3.a : 0);
                appCompatTextView.setLayoutParams(qb0Var);
            }
        }
    }

    @Override // defpackage.q10
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.A0.c.p(colorStateList);
    }

    public void setStrokeColor(int i) {
        setStrokeColor(ColorStateList.valueOf(i));
    }

    public MaterialCardView(Context context) {
        this(context, null);
    }
}
