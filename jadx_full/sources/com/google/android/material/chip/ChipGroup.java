package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import com.getsurfboard.R;
import defpackage.a40;
import defpackage.co4;
import defpackage.cp1;
import defpackage.fx3;
import defpackage.nh1;
import defpackage.oi2;
import defpackage.q40;
import defpackage.r40;
import defpackage.rc3;
import defpackage.s40;
import defpackage.t40;
import defpackage.w7;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ChipGroup extends nh1 {
    public s40 A0;
    public final a40 B0;
    public final int C0;
    public final t40 D0;
    public int y0;
    public int z0;

    /* JADX WARN: Illegal instructions before constructor call */
    public ChipGroup(Context context, AttributeSet attributeSet) {
        Context contextD0 = co4.d0(context, attributeSet, R.attr.chipGroupStyle, R.style.Widget_MaterialComponents_ChipGroup);
        super(contextD0, attributeSet, R.attr.chipGroupStyle);
        this.z = false;
        TypedArray typedArrayObtainStyledAttributes = contextD0.getTheme().obtainStyledAttributes(attributeSet, rc3.o, 0, 0);
        this.b = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        a40 a40Var = new a40();
        this.B0 = a40Var;
        t40 t40Var = new t40(this);
        this.D0 = t40Var;
        TypedArray typedArrayV = fx3.v(getContext(), attributeSet, rc3.i, R.attr.chipGroupStyle, R.style.Widget_MaterialComponents_ChipGroup, new int[0]);
        int dimensionPixelOffset = typedArrayV.getDimensionPixelOffset(1, 0);
        setChipSpacingHorizontal(typedArrayV.getDimensionPixelOffset(2, dimensionPixelOffset));
        setChipSpacingVertical(typedArrayV.getDimensionPixelOffset(3, dimensionPixelOffset));
        setSingleLine(typedArrayV.getBoolean(5, false));
        setSingleSelection(typedArrayV.getBoolean(6, false));
        setSelectionRequired(typedArrayV.getBoolean(4, false));
        this.C0 = typedArrayV.getResourceId(0, -1);
        typedArrayV.recycle();
        a40Var.X = new cp1(16, this);
        super.setOnHierarchyChangeListener(t40Var);
    }

    private int getVisibleChipCount() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if ((getChildAt(i2) instanceof Chip) && getChildAt(i2).getVisibility() == 0) {
                i++;
            }
        }
        return i;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof q40);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new q40(-2, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new q40(getContext(), attributeSet);
    }

    public int getCheckedChipId() {
        return this.B0.f();
    }

    public List<Integer> getCheckedChipIds() {
        return this.B0.c(this);
    }

    public int getChipSpacingHorizontal() {
        return this.y0;
    }

    public int getChipSpacingVertical() {
        return this.z0;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i = this.C0;
        if (i != -1) {
            a40 a40Var = this.B0;
            oi2 oi2Var = (oi2) ((HashMap) a40Var.z).get(Integer.valueOf(i));
            if (oi2Var != null && a40Var.a(oi2Var)) {
                a40Var.i();
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(getRowCount(), this.z ? getVisibleChipCount() : -1, false, this.B0.b ? 1 : 2));
    }

    public void setChipSpacing(int i) {
        setChipSpacingHorizontal(i);
        setChipSpacingVertical(i);
    }

    public void setChipSpacingHorizontal(int i) {
        if (this.y0 != i) {
            this.y0 = i;
            setItemSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingResource(int i) {
        setChipSpacing(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingVertical(int i) {
        if (this.z0 != i) {
            this.z0 = i;
            setLineSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(r40 r40Var) {
        if (r40Var == null) {
            setOnCheckedStateChangeListener(null);
        } else {
            setOnCheckedStateChangeListener(new w7(17, this));
        }
    }

    public void setOnCheckedStateChangeListener(s40 s40Var) {
        this.A0 = s40Var;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.D0.b = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z) {
        this.B0.f = z;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(int i) {
        setSingleLine(getResources().getBoolean(i));
    }

    public void setSingleSelection(boolean z) {
        a40 a40Var = this.B0;
        if (a40Var.b != z) {
            a40Var.b = z;
            boolean zIsEmpty = ((HashSet) a40Var.A).isEmpty();
            Iterator it = ((HashMap) a40Var.z).values().iterator();
            while (it.hasNext()) {
                a40Var.k((oi2) it.next(), false);
            }
            if (zIsEmpty) {
                return;
            }
            a40Var.i();
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new q40(layoutParams);
    }

    @Override // defpackage.nh1
    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
    }

    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }

    public ChipGroup(Context context) {
        this(context, null);
    }
}
