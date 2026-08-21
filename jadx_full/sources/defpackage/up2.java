package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.getsurfboard.R;
import com.google.android.material.navigationrail.NavigationRailView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class up2 extends FrameLayout {
    public a64 A;
    public final jp2 b;
    public final mp2 f;
    public sp2 y0;
    public final op2 z;
    public rp2 z0;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v9 */
    public up2(Context context, AttributeSet attributeSet, int i, int i2) {
        ?? r11;
        super(co4.d0(context, attributeSet, i, i2), attributeSet, i);
        op2 op2Var = new op2();
        op2Var.f = false;
        this.z = op2Var;
        Context context2 = getContext();
        n02 n02VarW = fx3.w(context2, attributeSet, rc3.G, i, i2, 17, 15);
        boolean z = this instanceof NavigationRailView;
        jp2 jp2Var = new jp2(context2, getClass(), getMaxItemCount(), z);
        this.b = jp2Var;
        mp2 mp2VarA = a(context2);
        this.f = mp2VarA;
        mp2VarA.setMinimumHeight(getSuggestedMinimumHeight());
        mp2VarA.setCollapsedMaxItemCount(getCollapsedMaxItemCount());
        op2Var.b = mp2VarA;
        op2Var.z = 1;
        mp2VarA.setPresenter(op2Var);
        jp2Var.b(op2Var, jp2Var.a);
        op2Var.l(getContext(), jp2Var);
        TypedArray typedArray = (TypedArray) n02VarW.z;
        if (typedArray.hasValue(11)) {
            mp2VarA.setIconTintList(n02VarW.n(11));
        } else {
            mp2VarA.setIconTintList(mp2VarA.c());
        }
        setItemIconSize(typedArray.getDimensionPixelSize(10, getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_bar_item_default_icon_size)));
        if (typedArray.hasValue(17)) {
            setItemTextAppearanceInactive(typedArray.getResourceId(17, 0));
        }
        if (typedArray.hasValue(15)) {
            setItemTextAppearanceActive(typedArray.getResourceId(15, 0));
        }
        if (typedArray.hasValue(4)) {
            setHorizontalItemTextAppearanceInactive(typedArray.getResourceId(4, 0));
        }
        if (typedArray.hasValue(3)) {
            setHorizontalItemTextAppearanceActive(typedArray.getResourceId(3, 0));
        }
        setItemTextAppearanceActiveBoldEnabled(typedArray.getBoolean(16, true));
        if (typedArray.hasValue(18)) {
            setItemTextColor(n02VarW.n(18));
        }
        Drawable background = getBackground();
        ColorStateList colorStateListH = v9.h(background);
        if (background == null || colorStateListH != null) {
            yi2 yi2Var = new yi2(ou3.h(context2, attributeSet, i, i2).b());
            if (colorStateListH != null) {
                yi2Var.p(colorStateListH);
            }
            yi2Var.l(context2);
            setBackground(yi2Var);
        }
        if (typedArray.hasValue(13)) {
            setItemPaddingTop(typedArray.getDimensionPixelSize(13, 0));
        }
        if (typedArray.hasValue(12)) {
            setItemPaddingBottom(typedArray.getDimensionPixelSize(12, 0));
        }
        if (typedArray.hasValue(0)) {
            setActiveIndicatorLabelPadding(typedArray.getDimensionPixelSize(0, 0));
        }
        if (typedArray.hasValue(5)) {
            setIconLabelHorizontalSpacing(typedArray.getDimensionPixelSize(5, 0));
        }
        if (typedArray.hasValue(2)) {
            setElevation(typedArray.getDimensionPixelSize(2, 0));
        }
        getBackground().mutate().setTintList(l72.q(context2, n02VarW, 1));
        setLabelVisibilityMode(typedArray.getInteger(21, -1));
        setItemIconGravity(typedArray.getInteger(9, 0));
        setItemGravity(typedArray.getInteger(8, 49));
        int resourceId = typedArray.getResourceId(7, 0);
        if (resourceId != 0) {
            mp2VarA.setItemBackgroundRes(resourceId);
        } else {
            setItemRippleColor(l72.q(context2, n02VarW, 14));
        }
        setMeasureBottomPaddingFromLabelBaseline(typedArray.getBoolean(22, true));
        setLabelFontScalingEnabled(typedArray.getBoolean(19, false));
        setLabelMaxLines(typedArray.getInteger(20, 1));
        int resourceId2 = typedArray.getResourceId(6, 0);
        if (resourceId2 != 0) {
            setItemActiveIndicatorEnabled(true);
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId2, rc3.F);
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
            setItemActiveIndicatorWidth(dimensionPixelSize);
            setItemActiveIndicatorHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0));
            int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(10, 0);
            setItemActiveIndicatorMarginHorizontal(dimensionPixelOffset);
            String string = typedArrayObtainStyledAttributes.getString(9);
            int dimensionPixelSize2 = -2;
            if (string != null) {
                if (String.valueOf(-1).equals(string)) {
                    dimensionPixelSize2 = -1;
                } else if (!String.valueOf(-2).equals(string)) {
                    dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, -2);
                }
            }
            setItemActiveIndicatorExpandedWidth(dimensionPixelSize2);
            setItemActiveIndicatorExpandedHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(7, dimensionPixelSize));
            setItemActiveIndicatorExpandedMarginHorizontal(typedArrayObtainStyledAttributes.getDimensionPixelOffset(8, dimensionPixelOffset));
            int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.m3_navigation_item_leading_trailing_space);
            int dimensionPixelOffset2 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(5, dimensionPixelSize3);
            int dimensionPixelOffset3 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(4, dimensionPixelSize3);
            int i3 = getLayoutDirection() == 1 ? dimensionPixelOffset3 : dimensionPixelOffset2;
            int dimensionPixelOffset4 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(6, 0);
            dimensionPixelOffset2 = getLayoutDirection() != 1 ? dimensionPixelOffset3 : dimensionPixelOffset2;
            int dimensionPixelOffset5 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0);
            Rect rect = mp2VarA.p1;
            rect.left = i3;
            rect.top = dimensionPixelOffset4;
            rect.right = dimensionPixelOffset2;
            rect.bottom = dimensionPixelOffset5;
            lp2[] lp2VarArr = mp2VarA.A0;
            if (lp2VarArr != null) {
                for (lp2 lp2Var : lp2VarArr) {
                    if (lp2Var instanceof ip2) {
                        ((ip2) lp2Var).setActiveIndicatorExpandedPadding(rect);
                    }
                }
            }
            setItemActiveIndicatorColor(l72.r(context2, typedArrayObtainStyledAttributes, 2));
            r11 = 0;
            setItemActiveIndicatorShapeAppearance(ou3.f(context2, typedArrayObtainStyledAttributes.getResourceId(11, 0), 0).b());
            typedArrayObtainStyledAttributes.recycle();
        } else {
            r11 = 0;
        }
        if (typedArray.hasValue(23)) {
            int resourceId3 = typedArray.getResourceId(23, r11);
            op2 op2Var2 = this.z;
            op2Var2.f = true;
            getMenuInflater().inflate(resourceId3, this.b);
            op2Var2.f = r11;
            op2Var2.c(true);
        }
        n02VarW.K();
        if (!z) {
            addView(this.f);
        }
        this.b.e = new oj1(14, this);
    }

    private MenuInflater getMenuInflater() {
        a64 a64Var = this.A;
        if (a64Var != null) {
            return a64Var;
        }
        a64 a64Var2 = new a64(getContext());
        this.A = a64Var2;
        return a64Var2;
    }

    private void setMeasureBottomPaddingFromLabelBaseline(boolean z) {
        this.f.setMeasurePaddingFromLabelBaseline(z);
    }

    public abstract mp2 a(Context context);

    public int getActiveIndicatorLabelPadding() {
        return this.f.getActiveIndicatorLabelPadding();
    }

    public int getCollapsedMaxItemCount() {
        return getMaxItemCount();
    }

    public int getHorizontalItemTextAppearanceActive() {
        return this.f.getHorizontalItemTextAppearanceActive();
    }

    public int getHorizontalItemTextAppearanceInactive() {
        return this.f.getHorizontalItemTextAppearanceInactive();
    }

    public int getIconLabelHorizontalSpacing() {
        return this.f.getIconLabelHorizontalSpacing();
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.f.getItemActiveIndicatorColor();
    }

    public int getItemActiveIndicatorExpandedHeight() {
        return this.f.getItemActiveIndicatorExpandedHeight();
    }

    public int getItemActiveIndicatorExpandedMarginHorizontal() {
        return this.f.getItemActiveIndicatorExpandedMarginHorizontal();
    }

    public int getItemActiveIndicatorExpandedWidth() {
        return this.f.getItemActiveIndicatorExpandedWidth();
    }

    public int getItemActiveIndicatorHeight() {
        return this.f.getItemActiveIndicatorHeight();
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f.getItemActiveIndicatorMarginHorizontal();
    }

    public ou3 getItemActiveIndicatorShapeAppearance() {
        return this.f.getItemActiveIndicatorShapeAppearance();
    }

    public int getItemActiveIndicatorWidth() {
        return this.f.getItemActiveIndicatorWidth();
    }

    public Drawable getItemBackground() {
        return this.f.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.f.getItemBackgroundRes();
    }

    public int getItemGravity() {
        return this.f.getItemGravity();
    }

    public int getItemIconGravity() {
        return this.f.getItemIconGravity();
    }

    public int getItemIconSize() {
        return this.f.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.f.getIconTintList();
    }

    public int getItemPaddingBottom() {
        return this.f.getItemPaddingBottom();
    }

    public int getItemPaddingTop() {
        return this.f.getItemPaddingTop();
    }

    public ColorStateList getItemRippleColor() {
        return this.f.getItemRippleColor();
    }

    public int getItemTextAppearanceActive() {
        return this.f.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.f.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.f.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    public Menu getMenu() {
        return this.b;
    }

    public il2 getMenuView() {
        return this.f;
    }

    public ViewGroup getMenuViewGroup() {
        return this.f;
    }

    public op2 getPresenter() {
        return this.z;
    }

    public boolean getScaleLabelTextWithFont() {
        return this.f.getScaleLabelTextWithFont();
    }

    public int getSelectedItemId() {
        return this.f.getSelectedItemId();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        uf2.O(this);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof tp2)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        tp2 tp2Var = (tp2) parcelable;
        super.onRestoreInstanceState(tp2Var.b);
        this.b.f(tp2Var.z);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        tp2 tp2Var = new tp2(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        tp2Var.z = bundle;
        this.b.g(bundle);
        return tp2Var;
    }

    public void setActiveIndicatorLabelPadding(int i) {
        this.f.setActiveIndicatorLabelPadding(i);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        uf2.L(this, f);
    }

    public void setHorizontalItemTextAppearanceActive(int i) {
        this.f.setHorizontalItemTextAppearanceActive(i);
    }

    public void setHorizontalItemTextAppearanceInactive(int i) {
        this.f.setHorizontalItemTextAppearanceInactive(i);
    }

    public void setIconLabelHorizontalSpacing(int i) {
        this.f.setIconLabelHorizontalSpacing(i);
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.f.setItemActiveIndicatorColor(colorStateList);
    }

    public void setItemActiveIndicatorEnabled(boolean z) {
        this.f.setItemActiveIndicatorEnabled(z);
    }

    public void setItemActiveIndicatorExpandedHeight(int i) {
        this.f.setItemActiveIndicatorExpandedHeight(i);
    }

    public void setItemActiveIndicatorExpandedMarginHorizontal(int i) {
        this.f.setItemActiveIndicatorExpandedMarginHorizontal(i);
    }

    public void setItemActiveIndicatorExpandedWidth(int i) {
        this.f.setItemActiveIndicatorExpandedWidth(i);
    }

    public void setItemActiveIndicatorHeight(int i) {
        this.f.setItemActiveIndicatorHeight(i);
    }

    public void setItemActiveIndicatorMarginHorizontal(int i) {
        this.f.setItemActiveIndicatorMarginHorizontal(i);
    }

    public void setItemActiveIndicatorShapeAppearance(ou3 ou3Var) {
        this.f.setItemActiveIndicatorShapeAppearance(ou3Var);
    }

    public void setItemActiveIndicatorWidth(int i) {
        this.f.setItemActiveIndicatorWidth(i);
    }

    public void setItemBackground(Drawable drawable) {
        this.f.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(int i) {
        this.f.setItemBackgroundRes(i);
    }

    public void setItemGravity(int i) {
        mp2 mp2Var = this.f;
        if (mp2Var.getItemGravity() != i) {
            mp2Var.setItemGravity(i);
            this.z.c(false);
        }
    }

    public void setItemIconGravity(int i) {
        mp2 mp2Var = this.f;
        if (mp2Var.getItemIconGravity() != i) {
            mp2Var.setItemIconGravity(i);
            this.z.c(false);
        }
    }

    public void setItemIconSize(int i) {
        this.f.setItemIconSize(i);
    }

    public void setItemIconSizeRes(int i) {
        setItemIconSize(getResources().getDimensionPixelSize(i));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f.setIconTintList(colorStateList);
    }

    public void setItemPaddingBottom(int i) {
        this.f.setItemPaddingBottom(i);
    }

    public void setItemPaddingTop(int i) {
        this.f.setItemPaddingTop(i);
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.f.setItemRippleColor(colorStateList);
    }

    public void setItemTextAppearanceActive(int i) {
        this.f.setItemTextAppearanceActive(i);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z) {
        this.f.setItemTextAppearanceActiveBoldEnabled(z);
    }

    public void setItemTextAppearanceInactive(int i) {
        this.f.setItemTextAppearanceInactive(i);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f.setItemTextColor(colorStateList);
    }

    public void setLabelFontScalingEnabled(boolean z) {
        this.f.setLabelFontScalingEnabled(z);
    }

    public void setLabelMaxLines(int i) {
        this.f.setLabelMaxLines(i);
    }

    public void setLabelVisibilityMode(int i) {
        mp2 mp2Var = this.f;
        if (mp2Var.getLabelVisibilityMode() != i) {
            mp2Var.setLabelVisibilityMode(i);
            this.z.c(false);
        }
    }

    public void setOnItemReselectedListener(rp2 rp2Var) {
        this.z0 = rp2Var;
    }

    public void setOnItemSelectedListener(sp2 sp2Var) {
        this.y0 = sp2Var;
    }

    public void setSelectedItemId(int i) {
        jp2 jp2Var = this.b;
        MenuItem menuItemFindItem = jp2Var.findItem(i);
        if (menuItemFindItem != null) {
            boolean zS = jp2Var.s(menuItemFindItem, this.z, 0);
            if (menuItemFindItem.isCheckable()) {
                if (!zS || menuItemFindItem.isChecked()) {
                    this.f.setCheckedItem(menuItemFindItem);
                }
            }
        }
    }
}
