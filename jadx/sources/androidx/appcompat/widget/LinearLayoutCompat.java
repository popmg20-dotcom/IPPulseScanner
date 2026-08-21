package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import defpackage.cd3;
import defpackage.n02;
import defpackage.pr4;
import defpackage.wp4;
import defpackage.za2;
import defpackage.zo2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {
    public int A;
    public float A0;
    public boolean B0;
    public int[] C0;
    public int[] D0;
    public Drawable E0;
    public int F0;
    public int G0;
    public int H0;
    public int I0;
    public boolean b;
    public int f;
    public int y0;
    public int z;
    public int z0;

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = true;
        this.f = -1;
        this.z = 0;
        this.y0 = 8388659;
        int[] iArr = cd3.n;
        n02 n02VarY = n02.y(context, attributeSet, iArr, i);
        wp4.m(this, context, iArr, attributeSet, (TypedArray) n02VarY.z, i);
        TypedArray typedArray = (TypedArray) n02VarY.z;
        int i2 = typedArray.getInt(1, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = typedArray.getInt(0, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = typedArray.getBoolean(2, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.A0 = typedArray.getFloat(4, -1.0f);
        this.f = typedArray.getInt(3, -1);
        this.B0 = typedArray.getBoolean(7, false);
        setDividerDrawable(n02VarY.o(5));
        this.H0 = typedArray.getInt(8, 0);
        this.I0 = typedArray.getDimensionPixelSize(6, 0);
        n02VarY.K();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof za2;
    }

    public final void d(Canvas canvas, int i) {
        this.E0.setBounds(getPaddingLeft() + this.I0, i, (getWidth() - getPaddingRight()) - this.I0, this.G0 + i);
        this.E0.draw(canvas);
    }

    public final void e(Canvas canvas, int i) {
        this.E0.setBounds(i, getPaddingTop() + this.I0, this.F0 + i, (getHeight() - getPaddingBottom()) - this.I0);
        this.E0.draw(canvas);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public za2 generateDefaultLayoutParams() {
        int i = this.A;
        if (i == 0) {
            return new za2(-2, -2);
        }
        if (i == 1) {
            return new za2(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public za2 generateLayoutParams(AttributeSet attributeSet) {
        return new za2(getContext(), attributeSet);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.f < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.f;
        if (childCount <= i2) {
            zo2.w("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
            return 0;
        }
        View childAt = getChildAt(i2);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f == 0) {
                return -1;
            }
            zo2.w("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            return 0;
        }
        int bottom = this.z;
        if (this.A == 1 && (i = this.y0 & 112) != 48) {
            if (i == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.z0) / 2;
            } else if (i == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.z0;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((za2) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f;
    }

    public Drawable getDividerDrawable() {
        return this.E0;
    }

    public int getDividerPadding() {
        return this.I0;
    }

    public int getDividerWidth() {
        return this.F0;
    }

    public int getGravity() {
        return this.y0;
    }

    public int getOrientation() {
        return this.A;
    }

    public int getShowDividers() {
        return this.H0;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.A0;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public za2 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof za2 ? new za2((za2) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new za2((ViewGroup.MarginLayoutParams) layoutParams) : new za2(layoutParams);
    }

    public final boolean i(int i) {
        if (i == 0) {
            return (this.H0 & 1) != 0;
        }
        int childCount = getChildCount();
        int i2 = this.H0;
        if (i == childCount) {
            return (i2 & 4) != 0;
        }
        if ((i2 & 2) != 0) {
            for (int i3 = i - 1; i3 >= 0; i3--) {
                if (getChildAt(i3).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int right;
        int left;
        int i;
        if (this.E0 == null) {
            return;
        }
        int i2 = 0;
        if (this.A == 1) {
            int virtualChildCount = getVirtualChildCount();
            while (i2 < virtualChildCount) {
                View childAt = getChildAt(i2);
                if (childAt != null && childAt.getVisibility() != 8 && i(i2)) {
                    d(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((za2) childAt.getLayoutParams())).topMargin) - this.G0);
                }
                i2++;
            }
            if (i(virtualChildCount)) {
                View childAt2 = getChildAt(virtualChildCount - 1);
                d(canvas, childAt2 == null ? (getHeight() - getPaddingBottom()) - this.G0 : childAt2.getBottom() + ((LinearLayout.LayoutParams) ((za2) childAt2.getLayoutParams())).bottomMargin);
                return;
            }
            return;
        }
        int virtualChildCount2 = getVirtualChildCount();
        boolean z = pr4.a;
        boolean z2 = getLayoutDirection() == 1;
        while (i2 < virtualChildCount2) {
            View childAt3 = getChildAt(i2);
            if (childAt3 != null && childAt3.getVisibility() != 8 && i(i2)) {
                za2 za2Var = (za2) childAt3.getLayoutParams();
                e(canvas, z2 ? childAt3.getRight() + ((LinearLayout.LayoutParams) za2Var).rightMargin : (childAt3.getLeft() - ((LinearLayout.LayoutParams) za2Var).leftMargin) - this.F0);
            }
            i2++;
        }
        if (i(virtualChildCount2)) {
            View childAt4 = getChildAt(virtualChildCount2 - 1);
            if (childAt4 != null) {
                za2 za2Var2 = (za2) childAt4.getLayoutParams();
                if (z2) {
                    left = childAt4.getLeft() - ((LinearLayout.LayoutParams) za2Var2).leftMargin;
                    i = this.F0;
                    right = left - i;
                } else {
                    right = childAt4.getRight() + ((LinearLayout.LayoutParams) za2Var2).rightMargin;
                }
            } else if (z2) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i = this.F0;
                right = left - i;
            }
            e(canvas, right);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01a9  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        /*
            Method dump skipped, instruction units count: 461
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:231:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x04f2  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0520  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0530  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0541  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0792  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0146  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r39, int r40) {
        /*
            Method dump skipped, instruction units count: 2140
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.onMeasure(int, int):void");
    }

    public void setBaselineAligned(boolean z) {
        this.b = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.f = i;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.E0) {
            return;
        }
        this.E0 = drawable;
        if (drawable != null) {
            this.F0 = drawable.getIntrinsicWidth();
            this.G0 = drawable.getIntrinsicHeight();
        } else {
            this.F0 = 0;
            this.G0 = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.I0 = i;
    }

    public void setGravity(int i) {
        if (this.y0 != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.y0 = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        int i3 = this.y0;
        if ((8388615 & i3) != i2) {
            this.y0 = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.B0 = z;
    }

    public void setOrientation(int i) {
        if (this.A != i) {
            this.A = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.H0) {
            requestLayout();
        }
        this.H0 = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.y0;
        if ((i3 & 112) != i2) {
            this.y0 = i2 | (i3 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.A0 = Math.max(0.0f, f);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }
}
