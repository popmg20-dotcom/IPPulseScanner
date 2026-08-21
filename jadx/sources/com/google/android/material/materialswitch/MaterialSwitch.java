package com.google.android.material.materialswitch;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import com.getsurfboard.R;
import defpackage.co4;
import defpackage.fx3;
import defpackage.n02;
import defpackage.rc3;
import defpackage.tj4;
import defpackage.u70;
import defpackage.v9;
import defpackage.vo;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class MaterialSwitch extends SwitchCompat {
    public static final int[] A1 = {R.attr.state_with_icon};
    public Drawable n1;
    public Drawable o1;
    public int p1;
    public Drawable q1;
    public Drawable r1;
    public ColorStateList s1;
    public ColorStateList t1;
    public PorterDuff.Mode u1;
    public ColorStateList v1;
    public ColorStateList w1;
    public PorterDuff.Mode x1;
    public int[] y1;
    public int[] z1;

    public MaterialSwitch(Context context, AttributeSet attributeSet) {
        super(co4.d0(context, attributeSet, R.attr.materialSwitchStyle, R.style.Widget_Material3_CompoundButton_MaterialSwitch), attributeSet, R.attr.materialSwitchStyle);
        this.p1 = -1;
        Context context2 = getContext();
        this.n1 = super.getThumbDrawable();
        this.s1 = super.getThumbTintList();
        super.setThumbTintList(null);
        this.q1 = super.getTrackDrawable();
        this.v1 = super.getTrackTintList();
        super.setTrackTintList(null);
        n02 n02VarW = fx3.w(context2, attributeSet, rc3.B, R.attr.materialSwitchStyle, R.style.Widget_Material3_CompoundButton_MaterialSwitch, new int[0]);
        this.o1 = n02VarW.o(0);
        TypedArray typedArray = (TypedArray) n02VarW.z;
        this.p1 = typedArray.getDimensionPixelSize(1, -1);
        this.t1 = n02VarW.n(2);
        int i = typedArray.getInt(3, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.u1 = tj4.V(i, mode);
        this.r1 = n02VarW.o(4);
        this.w1 = n02VarW.n(5);
        this.x1 = tj4.V(typedArray.getInt(6, -1), mode);
        n02VarW.K();
        setEnforceSwitchWidth(false);
        e();
        f();
    }

    public static void g(Drawable drawable, ColorStateList colorStateList, int[] iArr, int[] iArr2, float f) {
        if (drawable == null || colorStateList == null) {
            return;
        }
        drawable.setTint(u70.b(colorStateList.getColorForState(iArr, 0), f, colorStateList.getColorForState(iArr2, 0)));
    }

    public final void e() {
        this.n1 = v9.d(this.n1, this.s1, getThumbTintMode());
        this.o1 = v9.d(this.o1, this.t1, this.u1);
        h();
        Drawable drawable = this.n1;
        Drawable drawable2 = this.o1;
        int i = this.p1;
        super.setThumbDrawable(v9.b(drawable, drawable2, i, i));
        refreshDrawableState();
    }

    public final void f() {
        this.q1 = v9.d(this.q1, this.v1, getTrackTintMode());
        this.r1 = v9.d(this.r1, this.w1, this.x1);
        h();
        Drawable layerDrawable = this.q1;
        if (layerDrawable != null && this.r1 != null) {
            layerDrawable = new LayerDrawable(new Drawable[]{this.q1, this.r1});
        } else if (layerDrawable == null) {
            layerDrawable = this.r1;
        }
        if (layerDrawable != null) {
            setSwitchMinWidth(layerDrawable.getIntrinsicWidth());
        }
        super.setTrackDrawable(layerDrawable);
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public Drawable getThumbDrawable() {
        return this.n1;
    }

    public Drawable getThumbIconDrawable() {
        return this.o1;
    }

    public int getThumbIconSize() {
        return this.p1;
    }

    public ColorStateList getThumbIconTintList() {
        return this.t1;
    }

    public PorterDuff.Mode getThumbIconTintMode() {
        return this.u1;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public ColorStateList getThumbTintList() {
        return this.s1;
    }

    public Drawable getTrackDecorationDrawable() {
        return this.r1;
    }

    public ColorStateList getTrackDecorationTintList() {
        return this.w1;
    }

    public PorterDuff.Mode getTrackDecorationTintMode() {
        return this.x1;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public Drawable getTrackDrawable() {
        return this.q1;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public ColorStateList getTrackTintList() {
        return this.v1;
    }

    public final void h() {
        if (this.s1 == null && this.t1 == null && this.v1 == null && this.w1 == null) {
            return;
        }
        float thumbPosition = getThumbPosition();
        ColorStateList colorStateList = this.s1;
        if (colorStateList != null) {
            g(this.n1, colorStateList, this.y1, this.z1, thumbPosition);
        }
        ColorStateList colorStateList2 = this.t1;
        if (colorStateList2 != null) {
            g(this.o1, colorStateList2, this.y1, this.z1, thumbPosition);
        }
        ColorStateList colorStateList3 = this.v1;
        if (colorStateList3 != null) {
            g(this.q1, colorStateList3, this.y1, this.z1, thumbPosition);
        }
        ColorStateList colorStateList4 = this.w1;
        if (colorStateList4 != null) {
            g(this.r1, colorStateList4, this.y1, this.z1, thumbPosition);
        }
    }

    @Override // android.view.View
    public final void invalidate() {
        h();
        super.invalidate();
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.o1 != null) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, A1);
        }
        int[] iArr = new int[iArrOnCreateDrawableState.length];
        int i2 = 0;
        for (int i3 : iArrOnCreateDrawableState) {
            if (i3 != 16842912) {
                iArr[i2] = i3;
                i2++;
            }
        }
        this.y1 = iArr;
        this.z1 = v9.f(iArrOnCreateDrawableState);
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbDrawable(Drawable drawable) {
        this.n1 = drawable;
        e();
    }

    public void setThumbIconDrawable(Drawable drawable) {
        this.o1 = drawable;
        e();
    }

    public void setThumbIconResource(int i) {
        setThumbIconDrawable(vo.r(getContext(), i));
    }

    public void setThumbIconSize(int i) {
        if (this.p1 != i) {
            this.p1 = i;
            e();
        }
    }

    public void setThumbIconTintList(ColorStateList colorStateList) {
        this.t1 = colorStateList;
        e();
    }

    public void setThumbIconTintMode(PorterDuff.Mode mode) {
        this.u1 = mode;
        e();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintList(ColorStateList colorStateList) {
        this.s1 = colorStateList;
        e();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setThumbTintMode(PorterDuff.Mode mode) {
        super.setThumbTintMode(mode);
        e();
    }

    public void setTrackDecorationDrawable(Drawable drawable) {
        this.r1 = drawable;
        f();
    }

    public void setTrackDecorationResource(int i) {
        setTrackDecorationDrawable(vo.r(getContext(), i));
    }

    public void setTrackDecorationTintList(ColorStateList colorStateList) {
        this.w1 = colorStateList;
        f();
    }

    public void setTrackDecorationTintMode(PorterDuff.Mode mode) {
        this.x1 = mode;
        f();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackDrawable(Drawable drawable) {
        this.q1 = drawable;
        f();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintList(ColorStateList colorStateList) {
        this.v1 = colorStateList;
        f();
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setTrackTintMode(PorterDuff.Mode mode) {
        super.setTrackTintMode(mode);
        f();
    }

    public MaterialSwitch(Context context) {
        this(context, null);
    }
}
