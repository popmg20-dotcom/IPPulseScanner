package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import defpackage.co4;
import defpackage.dw2;
import defpackage.fi2;
import defpackage.fx3;
import defpackage.ga1;
import defpackage.gi2;
import defpackage.hi2;
import defpackage.ii2;
import defpackage.jd;
import defpackage.jl3;
import defpackage.l72;
import defpackage.nu3;
import defpackage.ou3;
import defpackage.p24;
import defpackage.q24;
import defpackage.rc3;
import defpackage.tj4;
import defpackage.uf2;
import defpackage.v9;
import defpackage.vo;
import defpackage.x04;
import defpackage.xe;
import defpackage.yi2;
import defpackage.yu3;
import io.sentry.android.core.a1;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class MaterialButton extends AppCompatButton implements Checkable, yu3 {
    public static final int[] c1 = {R.attr.state_checkable};
    public static final int[] d1 = {R.attr.state_checked};
    public final ii2 A;
    public ColorStateList A0;
    public Drawable B0;
    public PorterDuff.Mode C0;
    public ColorStateList D0;
    public Drawable E0;
    public boolean F0;
    public String G0;
    public int H0;
    public int I0;
    public int J0;
    public int K0;
    public int L0;
    public int M0;
    public boolean N0;
    public boolean O0;
    public int P0;
    public int Q0;
    public int R0;
    public float S0;
    public int T0;
    public int U0;
    public boolean V0;
    public int W0;
    public int X0;
    public int Y0;
    public hi2 Z0;
    public float a1;
    public float b1;
    public final LinkedHashSet y0;
    public PorterDuff.Mode z0;

    public MaterialButton(Context context, AttributeSet attributeSet, int i) {
        super(co4.e0(context, attributeSet, i, com.getsurfboard.R.style.Widget_MaterialComponents_Button, new int[]{com.getsurfboard.R.attr.materialSizeOverlay}), attributeSet, i);
        this.y0 = new LinkedHashSet();
        this.N0 = false;
        this.O0 = false;
        this.R0 = Integer.MIN_VALUE;
        this.S0 = -2.1474836E9f;
        this.T0 = Integer.MIN_VALUE;
        this.U0 = Integer.MIN_VALUE;
        this.X0 = Integer.MIN_VALUE;
        this.Z0 = hi2.b;
        Context context2 = getContext();
        TypedArray typedArrayV = fx3.v(context2, attributeSet, rc3.u, i, com.getsurfboard.R.style.Widget_MaterialComponents_Button, new int[0]);
        this.K0 = typedArrayV.getDimensionPixelSize(13, 0);
        int i2 = typedArrayV.getInt(16, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.z0 = tj4.V(i2, mode);
        this.A0 = l72.r(getContext(), typedArrayV, 15);
        this.B0 = l72.u(getContext(), typedArrayV, 11);
        this.P0 = typedArrayV.getInteger(12, 1);
        this.H0 = typedArrayV.getDimensionPixelSize(14, 0);
        this.C0 = tj4.V(typedArrayV.getInt(22, -1), mode);
        this.D0 = typedArrayV.hasValue(21) ? l72.r(getContext(), typedArrayV, 21) : this.A0;
        this.Q0 = typedArrayV.getInteger(20, 3);
        Drawable drawableU = l72.u(getContext(), typedArrayV, 19);
        this.E0 = drawableU;
        this.F0 = drawableU == null;
        nu3 nu3VarF = p24.f(context2, typedArrayV, 23);
        nu3VarF = nu3VarF == null ? ou3.h(context2, attributeSet, i, com.getsurfboard.R.style.Widget_MaterialComponents_Button).b() : nu3VarF;
        boolean z = typedArrayV.getBoolean(17, false);
        ii2 ii2Var = new ii2(this, nu3VarF);
        this.A = ii2Var;
        ii2Var.e = typedArrayV.getDimensionPixelOffset(2, 0);
        ii2Var.f = typedArrayV.getDimensionPixelOffset(3, 0);
        ii2Var.g = typedArrayV.getDimensionPixelOffset(4, 0);
        ii2Var.h = typedArrayV.getDimensionPixelOffset(5, 0);
        if (typedArrayV.hasValue(9)) {
            int dimensionPixelSize = typedArrayV.getDimensionPixelSize(9, -1);
            ii2Var.i = dimensionPixelSize;
            ii2Var.b = ii2Var.b.a(dimensionPixelSize);
            ii2Var.d();
            ii2Var.r = true;
        }
        ii2Var.j = typedArrayV.getDimensionPixelSize(26, 0);
        ii2Var.k = tj4.V(typedArrayV.getInt(8, -1), mode);
        ii2Var.l = l72.r(getContext(), typedArrayV, 7);
        ii2Var.m = l72.r(getContext(), typedArrayV, 25);
        ii2Var.n = l72.r(getContext(), typedArrayV, 18);
        ii2Var.s = typedArrayV.getBoolean(6, false);
        ii2Var.v = typedArrayV.getDimensionPixelSize(10, 0);
        ii2Var.t = typedArrayV.getBoolean(27, true);
        int paddingStart = getPaddingStart();
        int paddingTop = getPaddingTop();
        int paddingEnd = getPaddingEnd();
        int paddingBottom = getPaddingBottom();
        if (typedArrayV.hasValue(0)) {
            ii2Var.q = true;
            setSupportBackgroundTintList(ii2Var.l);
            setSupportBackgroundTintMode(ii2Var.k);
        } else {
            ii2Var.c();
        }
        setPaddingRelative(paddingStart + ii2Var.e, paddingTop + ii2Var.g, paddingEnd + ii2Var.f, paddingBottom + ii2Var.h);
        setCheckedInternal(typedArrayV.getBoolean(1, false));
        if (nu3VarF instanceof p24) {
            ii2Var.c = l72.X(getContext());
            if (ii2Var.b instanceof p24) {
                ii2Var.d();
            }
        }
        setOpticalCenterEnabled(z);
        typedArrayV.recycle();
        setCompoundDrawablePadding(this.K0);
        q(this.B0 != null);
        t(this.E0 != null);
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getDisplayedWidthIncrease() {
        return this.a1;
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getOpticalCenterShift() {
        return 0;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float fMax = 0.0f;
        for (int i = 0; i < lineCount; i++) {
            fMax = Math.max(fMax, getLayout().getLineWidth(i));
        }
        return (int) Math.ceil(fMax);
    }

    private void setCheckedInternal(boolean z) {
        ii2 ii2Var = this.A;
        if (ii2Var == null || !ii2Var.s || this.N0 == z) {
            return;
        }
        this.N0 = z;
        refreshDrawableState();
        getParent();
        if (this.O0) {
            return;
        }
        this.O0 = true;
        Iterator it = this.y0.iterator();
        if (it.hasNext()) {
            throw dw2.z(it);
        }
        this.O0 = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayedWidthIncrease(float f) {
        if (this.a1 != f) {
            this.a1 = f;
            s();
            invalidate();
            getParent();
        }
    }

    public final boolean c() {
        if (j() && m()) {
            return true;
        }
        if (i() && l()) {
            return true;
        }
        return k() && n();
    }

    public final boolean d(int i) {
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        return i == 1 || i == 3 || (i == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE);
    }

    public final int e(int i, int i2) {
        int intrinsicWidth;
        int intrinsicWidth2;
        Drawable drawable = this.B0;
        if (drawable != null) {
            intrinsicWidth = this.H0;
            if (intrinsicWidth == 0) {
                intrinsicWidth = drawable.getIntrinsicWidth();
            }
        } else {
            intrinsicWidth = 0;
        }
        Drawable drawable2 = this.E0;
        if (drawable2 != null) {
            intrinsicWidth2 = this.H0;
            if (intrinsicWidth2 == 0) {
                intrinsicWidth2 = drawable2.getIntrinsicWidth();
            }
        } else {
            intrinsicWidth2 = 0;
        }
        int textLayoutWidth = (((((i - getTextLayoutWidth()) - getPaddingEnd()) - intrinsicWidth) - intrinsicWidth2) - this.K0) - getPaddingStart();
        if (getActualTextAlignment() == Layout.Alignment.ALIGN_CENTER) {
            textLayoutWidth /= 2;
        }
        return (getLayoutDirection() == 1) != (i2 == 4) ? -textLayoutWidth : textLayoutWidth;
    }

    public final int f(int i, int i2) {
        return Math.max(0, (((((i - getTextHeight()) - getPaddingTop()) - i2) - this.K0) - getPaddingBottom()) / 2);
    }

    public final Drawable g(int i) {
        if (i == 0) {
            if (this.E0 == null || !m()) {
                return null;
            }
            return this.E0;
        }
        if (i == 1) {
            if (this.E0 == null || !n()) {
                return null;
            }
            return this.E0;
        }
        if (i == 2 && this.E0 != null && l()) {
            return this.E0;
        }
        return null;
    }

    public String getA11yClassName() {
        if (!TextUtils.isEmpty(this.G0)) {
            return this.G0;
        }
        ii2 ii2Var = this.A;
        return ((ii2Var == null || !ii2Var.s) ? Button.class : CompoundButton.class).getName();
    }

    public int getAllowedWidthDecrease() {
        return this.X0;
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (o()) {
            return this.A.i;
        }
        return 0;
    }

    public x04 getCornerSpringForce() {
        return this.A.c;
    }

    public Drawable getIcon() {
        return this.B0;
    }

    public int getIconGravity() {
        return this.P0;
    }

    public int getIconPadding() {
        return this.K0;
    }

    public int getIconSize() {
        return this.H0;
    }

    public ColorStateList getIconTint() {
        return this.A0;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.z0;
    }

    public int getInsetBottom() {
        return this.A.h;
    }

    public int getInsetTop() {
        return this.A.g;
    }

    public ColorStateList getRippleColor() {
        if (o()) {
            return this.A.n;
        }
        return null;
    }

    public Drawable getSecondaryIcon() {
        return this.E0;
    }

    public int getSecondaryIconGravity() {
        return this.Q0;
    }

    public ColorStateList getSecondaryIconTint() {
        return this.D0;
    }

    public PorterDuff.Mode getSecondaryIconTintMode() {
        return this.C0;
    }

    public nu3 getShapeAppearance() {
        if (o()) {
            return this.A.b;
        }
        xe.q("Attempted to get ShapeAppearance from a MaterialButton which has an overwritten background.");
        return null;
    }

    @Override // defpackage.yu3
    public ou3 getShapeAppearanceModel() {
        if (o()) {
            return this.A.b.d();
        }
        xe.q("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
        return null;
    }

    public ColorStateList getStrokeColor() {
        if (o()) {
            return this.A.m;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (o()) {
            return this.A.j;
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public ColorStateList getSupportBackgroundTintList() {
        return o() ? this.A.l : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return o() ? this.A.k : super.getSupportBackgroundTintMode();
    }

    public final Drawable h(int i) {
        if (i == 0) {
            if (this.B0 == null || !j()) {
                return null;
            }
            return this.B0;
        }
        if (i == 1) {
            if (this.B0 == null || !i()) {
                return null;
            }
            return this.B0;
        }
        if (i == 2 && this.B0 != null && i()) {
            return this.B0;
        }
        return null;
    }

    public final boolean i() {
        int i = this.P0;
        return i == 3 || i == 4;
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.N0;
    }

    public final boolean j() {
        int i = this.P0;
        return i == 1 || i == 2;
    }

    public final boolean k() {
        int i = this.P0;
        return i == 16 || i == 32;
    }

    public final boolean l() {
        int i = this.Q0;
        return i == 3 || i == 4;
    }

    public final boolean m() {
        int i = this.Q0;
        return i == 1 || i == 2;
    }

    public final boolean n() {
        int i = this.Q0;
        return i == 16 || i == 32;
    }

    public final boolean o() {
        ii2 ii2Var = this.A;
        return (ii2Var == null || ii2Var.q) ? false : true;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (o()) {
            uf2.N(this, this.A.a(false));
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        ii2 ii2Var = this.A;
        if (ii2Var != null && ii2Var.s) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, c1);
        }
        if (this.N0) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, d1);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(this.N0);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        ii2 ii2Var = this.A;
        accessibilityNodeInfo.setCheckable(ii2Var != null && ii2Var.s);
        accessibilityNodeInfo.setChecked(this.N0);
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        super.onLayout(z, i, i2, i3, i4);
        r(getMeasuredWidth(), getMeasuredHeight());
        u(getMeasuredWidth(), getMeasuredHeight());
        int i6 = getResources().getConfiguration().orientation;
        if (this.R0 != i6) {
            this.R0 = i6;
            this.S0 = -2.1474836E9f;
        }
        if (this.S0 == -2.1474836E9f) {
            this.S0 = getMeasuredWidth();
            getParent();
        }
        if (this.X0 == Integer.MIN_VALUE) {
            if (this.B0 == null) {
                i5 = 0;
            } else {
                int iconPadding = getIconPadding();
                int intrinsicWidth = this.H0;
                if (intrinsicWidth == 0) {
                    intrinsicWidth = this.B0.getIntrinsicWidth();
                }
                i5 = iconPadding + intrinsicWidth;
            }
            this.X0 = (getMeasuredWidth() - getTextLayoutWidth()) - i5;
        }
        if (this.T0 == Integer.MIN_VALUE) {
            this.T0 = getPaddingStart();
        }
        if (this.U0 == Integer.MIN_VALUE) {
            this.U0 = getPaddingEnd();
        }
        getParent();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof gi2)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        gi2 gi2Var = (gi2) parcelable;
        super.onRestoreInstanceState(gi2Var.b);
        setChecked(gi2Var.z);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        gi2 gi2Var = new gi2(super.onSaveInstanceState());
        gi2Var.z = this.N0;
        return gi2Var;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        r(getMeasuredWidth(), getMeasuredHeight());
        u(getMeasuredWidth(), getMeasuredHeight());
    }

    public final /* synthetic */ void p() {
        this.W0 = getOpticalCenterShift();
        s();
        invalidate();
    }

    @Override // android.view.View
    public final boolean performClick() {
        boolean z;
        if (isEnabled() && this.A.t) {
            toggle();
            z = true;
        } else {
            z = false;
        }
        boolean zPerformClick = super.performClick();
        if (z && !zPerformClick) {
            playSoundEffect(0);
        }
        return zPerformClick;
    }

    public final void q(boolean z) {
        Drawable drawable = this.B0;
        if (drawable != null) {
            Drawable drawableMutate = drawable.mutate();
            this.B0 = drawableMutate;
            drawableMutate.setTintList(this.A0);
            PorterDuff.Mode mode = this.z0;
            if (mode != null) {
                this.B0.setTintMode(mode);
            }
            int intrinsicWidth = this.H0;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.B0.getIntrinsicWidth();
            }
            int intrinsicHeight = this.H0;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.B0.getIntrinsicHeight();
            }
            Drawable drawable2 = this.B0;
            int i = this.I0;
            int i2 = this.J0;
            drawable2.setBounds(i, i2, intrinsicWidth + i, intrinsicHeight + i2);
            this.B0.setVisible(true, z);
        }
        if (this.B0 != null && this.E0 != null && c()) {
            xe.k("iconGravity cannot have the same alignment as secondaryIconGravity");
            return;
        }
        if (this.B0 == null && this.E0 != null && c()) {
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        boolean z2 = (j() && compoundDrawablesRelative[0] != this.B0) || (i() && compoundDrawablesRelative[2] != this.B0) || (k() && compoundDrawablesRelative[1] != this.B0);
        if (z || z2) {
            if (j()) {
                setCompoundDrawablesRelative(this.B0, g(1), g(2), null);
            } else if (i()) {
                setCompoundDrawablesRelative(g(0), g(1), this.B0, null);
            } else if (k()) {
                setCompoundDrawablesRelative(g(0), this.B0, g(2), null);
            }
        }
    }

    public final void r(int i, int i2) {
        if (this.B0 == null || getLayout() == null) {
            return;
        }
        if (j() || i()) {
            this.J0 = 0;
            if (d(this.P0)) {
                this.I0 = 0;
                q(false);
                return;
            }
            int iE = e(i, this.P0);
            if (this.I0 != iE) {
                this.I0 = iE;
                q(false);
                return;
            }
            return;
        }
        if (k()) {
            this.I0 = 0;
            if (this.P0 == 16) {
                this.J0 = 0;
                q(false);
                return;
            }
            int intrinsicHeight = this.H0;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.B0.getIntrinsicHeight();
            }
            int iF = f(i2, intrinsicHeight);
            if (this.J0 != iF) {
                this.J0 = iF;
                q(false);
            }
        }
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.B0 != null) {
            if (this.B0.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public final void s() {
        int i = (int) (this.a1 - this.b1);
        int i2 = (i / 2) + this.W0;
        getLayoutParams().width = (int) (this.S0 + i);
        setPaddingRelative(this.T0 + i2, getPaddingTop(), (this.U0 + i) - i2, getPaddingBottom());
    }

    public void setA11yClassName(String str) {
        this.G0 = str;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (!o()) {
            super.setBackgroundColor(i);
            return;
        }
        ii2 ii2Var = this.A;
        if (ii2Var.a(false) != null) {
            ii2Var.a(false).setTint(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!o()) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        if (drawable == getBackground()) {
            getBackground().setState(drawable.getState());
            return;
        }
        a1.n("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
        ii2 ii2Var = this.A;
        ii2Var.q = true;
        MaterialButton materialButton = ii2Var.a;
        materialButton.setSupportBackgroundTintList(ii2Var.l);
        materialButton.setSupportBackgroundTintMode(ii2Var.k);
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? vo.r(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (o()) {
            this.A.s = z;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        setCheckedInternal(z);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablePadding(int i) {
        if (getCompoundDrawablePadding() != i) {
            this.S0 = -2.1474836E9f;
        }
        super.setCompoundDrawablePadding(i);
    }

    public void setCornerRadius(int i) {
        if (o()) {
            ii2 ii2Var = this.A;
            if (ii2Var.r && ii2Var.i == i) {
                return;
            }
            ii2Var.i = i;
            ii2Var.r = true;
            ii2Var.b = ii2Var.b.a(i);
            ii2Var.d();
        }
    }

    public void setCornerRadiusResource(int i) {
        if (o()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    public void setCornerSpringForce(x04 x04Var) {
        ii2 ii2Var = this.A;
        ii2Var.c = x04Var;
        if (ii2Var.b instanceof p24) {
            ii2Var.d();
        }
    }

    public void setDisplayedWidthDecrease(int i) {
        this.b1 = Math.min(i, this.X0);
        s();
        invalidate();
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        if (o()) {
            this.A.a(false).o(f);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.B0 != drawable) {
            this.S0 = -2.1474836E9f;
            this.B0 = drawable;
            q(true);
            r(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i) {
        if (this.P0 != i) {
            if (this.B0 != null && this.E0 != null && c()) {
                xe.k("iconGravity cannot have the same alignment as secondaryIconGravity");
            } else {
                this.P0 = i;
                r(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void setIconPadding(int i) {
        if (this.K0 != i) {
            this.K0 = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(int i) {
        setIcon(i != 0 ? vo.r(getContext(), i) : null);
    }

    public void setIconSize(int i) {
        if (i < 0) {
            xe.k("iconSize cannot be less than 0");
        } else if (this.H0 != i) {
            this.S0 = -2.1474836E9f;
            this.H0 = i;
            q(true);
            t(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.A0 != colorStateList) {
            this.A0 = colorStateList;
            q(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.z0 != mode) {
            this.z0 = mode;
            q(false);
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(v9.g(getContext(), i));
    }

    public void setInsetBottom(int i) {
        ii2 ii2Var = this.A;
        ii2Var.b(ii2Var.g, i);
    }

    public void setInsetTop(int i) {
        ii2 ii2Var = this.A;
        ii2Var.b(i, ii2Var.h);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOpticalCenterEnabled(boolean z) {
        if (this.V0 != z) {
            this.V0 = z;
            ii2 ii2Var = this.A;
            if (z) {
                jd jdVar = new jd(22, this);
                ii2Var.d = jdVar;
                yi2 yi2VarA = ii2Var.a(false);
                if (yi2VarA != null) {
                    yi2VarA.V0 = jdVar;
                }
            } else {
                ii2Var.d = null;
                yi2 yi2VarA2 = ii2Var.a(false);
                if (yi2VarA2 != null) {
                    yi2VarA2.V0 = null;
                }
            }
            post(new ga1(13, this));
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        super.setPressed(z);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (o()) {
            ii2 ii2Var = this.A;
            MaterialButton materialButton = ii2Var.a;
            if (ii2Var.n != colorStateList) {
                ii2Var.n = colorStateList;
                if (materialButton.getBackground() instanceof RippleDrawable) {
                    ((RippleDrawable) materialButton.getBackground()).setColor(jl3.c(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(int i) {
        if (o()) {
            setRippleColor(v9.g(getContext(), i));
        }
    }

    public void setSecondaryIcon(Drawable drawable) {
        if (this.E0 != drawable) {
            this.S0 = -2.1474836E9f;
            this.E0 = drawable;
            this.F0 = false;
            t(true);
            u(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setSecondaryIconGravity(int i) {
        if (this.Q0 != i) {
            if (this.E0 != null && this.B0 != null && c()) {
                xe.k("secondaryIconGravity cannot have the same alignment as iconGravity");
            } else {
                this.Q0 = i;
                u(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void setSecondaryIconResource(int i) {
        setSecondaryIcon(i != 0 ? vo.r(getContext(), i) : null);
    }

    public void setSecondaryIconTint(ColorStateList colorStateList) {
        if (this.D0 != colorStateList) {
            this.D0 = colorStateList;
            t(false);
        }
    }

    public void setSecondaryIconTintMode(PorterDuff.Mode mode) {
        if (this.C0 != mode) {
            this.C0 = mode;
            t(false);
        }
    }

    public void setSecondaryIconTintResource(int i) {
        setSecondaryIconTint(v9.g(getContext(), i));
    }

    public void setShapeAppearance(nu3 nu3Var) {
        if (!o()) {
            xe.q("Attempted to set ShapeAppearance on a MaterialButton which has an overwritten background.");
            return;
        }
        ii2 ii2Var = this.A;
        if (ii2Var.c == null && nu3Var.e()) {
            ii2Var.c = l72.X(getContext());
            if (ii2Var.b instanceof p24) {
                ii2Var.d();
            }
        }
        ii2Var.b = nu3Var;
        ii2Var.d();
    }

    @Override // defpackage.yu3
    public void setShapeAppearanceModel(ou3 ou3Var) {
        if (!o()) {
            xe.q("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
            return;
        }
        ii2 ii2Var = this.A;
        ii2Var.b = ou3Var;
        ii2Var.d();
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (o()) {
            ii2 ii2Var = this.A;
            ii2Var.p = z;
            ii2Var.e();
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (o()) {
            ii2 ii2Var = this.A;
            if (ii2Var.m != colorStateList) {
                ii2Var.m = colorStateList;
                ii2Var.e();
            }
        }
    }

    public void setStrokeColorResource(int i) {
        if (o()) {
            setStrokeColor(v9.g(getContext(), i));
        }
    }

    public void setStrokeWidth(int i) {
        if (o()) {
            ii2 ii2Var = this.A;
            if (ii2Var.j != i) {
                ii2Var.j = i;
                ii2Var.e();
            }
        }
    }

    public void setStrokeWidthResource(int i) {
        if (o()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (!o()) {
            super.setSupportBackgroundTintList(colorStateList);
            return;
        }
        ii2 ii2Var = this.A;
        if (ii2Var.l != colorStateList) {
            ii2Var.l = colorStateList;
            if (ii2Var.a(false) != null) {
                ii2Var.a(false).setTintList(ii2Var.l);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (!o()) {
            super.setSupportBackgroundTintMode(mode);
            return;
        }
        ii2 ii2Var = this.A;
        if (ii2Var.k != mode) {
            ii2Var.k = mode;
            if (ii2Var.a(false) == null || ii2Var.k == null) {
                return;
            }
            ii2Var.a(false).setTintMode(ii2Var.k);
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.S0 = -2.1474836E9f;
        super.setText(charSequence, bufferType);
    }

    @Override // android.view.View
    public void setTextAlignment(int i) {
        super.setTextAlignment(i);
        r(getMeasuredWidth(), getMeasuredHeight());
        u(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        this.S0 = -2.1474836E9f;
        super.setTextAppearance(context, i);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public final void setTextSize(int i, float f) {
        this.S0 = -2.1474836E9f;
        super.setTextSize(i, f);
    }

    public void setToggleCheckedStateOnClick(boolean z) {
        this.A.t = z;
    }

    @Override // android.widget.TextView
    public void setWidth(int i) {
        this.S0 = -2.1474836E9f;
        super.setWidth(i);
    }

    public void setWidthChangeDirection(hi2 hi2Var) {
        if (this.Z0 != hi2Var) {
            this.Z0 = hi2Var;
        }
    }

    public void setWidthChangeMax(int i) {
        if (this.Y0 != i) {
            this.Y0 = i;
        }
    }

    public final void t(boolean z) {
        Drawable drawable = this.E0;
        if (drawable != null) {
            Drawable drawableMutate = drawable.mutate();
            this.E0 = drawableMutate;
            drawableMutate.setTintList(this.D0);
            PorterDuff.Mode mode = this.C0;
            if (mode != null) {
                this.E0.setTintMode(mode);
            }
            int intrinsicWidth = this.H0;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.E0.getIntrinsicWidth();
            }
            int intrinsicHeight = this.H0;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.E0.getIntrinsicHeight();
            }
            Drawable drawable2 = this.E0;
            int i = this.L0;
            int i2 = this.M0;
            drawable2.setBounds(i, i2, intrinsicWidth + i, intrinsicHeight + i2);
            this.E0.setVisible(true, z);
        }
        if (this.E0 != null && this.B0 != null && c()) {
            xe.k("secondaryIconGravity cannot have the same alignment as iconGravity");
            return;
        }
        if (this.E0 == null) {
            if (this.F0) {
                return;
            }
            if (this.B0 != null && c()) {
                return;
            }
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        boolean z2 = (m() && compoundDrawablesRelative[0] != this.E0) || (l() && compoundDrawablesRelative[2] != this.E0) || (n() && compoundDrawablesRelative[1] != this.E0);
        if (z || z2) {
            if (m()) {
                setCompoundDrawablesRelative(this.E0, h(1), h(2), null);
            } else if (l()) {
                setCompoundDrawablesRelative(h(0), h(1), this.E0, null);
            } else if (n()) {
                setCompoundDrawablesRelative(h(0), this.E0, h(2), null);
            }
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.N0);
    }

    public final void u(int i, int i2) {
        if (this.E0 == null || getLayout() == null) {
            return;
        }
        if (m() || l()) {
            this.M0 = 0;
            if (d(this.Q0)) {
                this.L0 = 0;
                t(false);
                return;
            }
            int iE = e(i, this.Q0);
            if (this.L0 != iE) {
                this.L0 = iE;
                t(false);
                return;
            }
            return;
        }
        if (n()) {
            this.L0 = 0;
            if (this.Q0 == 16) {
                this.M0 = 0;
                t(false);
                return;
            }
            int intrinsicHeight = this.H0;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.E0.getIntrinsicHeight();
            }
            int iF = f(i2, intrinsicHeight);
            if (this.M0 != iF) {
                this.M0 = iF;
                t(false);
            }
        }
    }

    public void setOnPressedChangeListenerInternal(fi2 fi2Var) {
    }

    public void setSizeChange(q24 q24Var) {
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.getsurfboard.R.attr.materialButtonStyle);
    }

    public MaterialButton(Context context) {
        this(context, null);
    }
}
