package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
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
import io.netty.util.internal.shaded.org.jctools.util.Pow2;

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
    */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int measuredHeight;
        char c;
        int i12;
        int i13;
        int i14;
        int i15 = 8;
        char c2 = 2;
        if (this.A == 1) {
            int paddingLeft = getPaddingLeft();
            int i16 = i3 - i;
            int paddingRight = i16 - getPaddingRight();
            int paddingRight2 = (i16 - paddingLeft) - getPaddingRight();
            int virtualChildCount = getVirtualChildCount();
            int i17 = this.y0;
            int i18 = i17 & 112;
            int i19 = 8388615 & i17;
            int paddingTop = i18 != 16 ? i18 != 80 ? getPaddingTop() : ((getPaddingTop() + i4) - i2) - this.z0 : getPaddingTop() + (((i4 - i2) - this.z0) / 2);
            int i20 = 0;
            while (i20 < virtualChildCount) {
                View childAt = getChildAt(i20);
                if (childAt == null || childAt.getVisibility() == i15) {
                    c = c2;
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight2 = childAt.getMeasuredHeight();
                    za2 za2Var = (za2) childAt.getLayoutParams();
                    c = c2;
                    int i21 = ((LinearLayout.LayoutParams) za2Var).gravity;
                    if (i21 < 0) {
                        i21 = i19;
                    }
                    int absoluteGravity = Gravity.getAbsoluteGravity(i21, getLayoutDirection()) & 7;
                    if (absoluteGravity == 1) {
                        i12 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((LinearLayout.LayoutParams) za2Var).leftMargin;
                        i13 = ((LinearLayout.LayoutParams) za2Var).rightMargin;
                    } else if (absoluteGravity != 5) {
                        i14 = ((LinearLayout.LayoutParams) za2Var).leftMargin + paddingLeft;
                        if (i(i20)) {
                            paddingTop += this.G0;
                        }
                        int i22 = paddingTop + ((LinearLayout.LayoutParams) za2Var).topMargin;
                        childAt.layout(i14, i22, measuredWidth + i14, i22 + measuredHeight2);
                        paddingTop = measuredHeight2 + ((LinearLayout.LayoutParams) za2Var).bottomMargin + i22;
                    } else {
                        i12 = paddingRight - measuredWidth;
                        i13 = ((LinearLayout.LayoutParams) za2Var).rightMargin;
                    }
                    i14 = i12 - i13;
                    if (i(i20)) {
                    }
                    int i222 = paddingTop + ((LinearLayout.LayoutParams) za2Var).topMargin;
                    childAt.layout(i14, i222, measuredWidth + i14, i222 + measuredHeight2);
                    paddingTop = measuredHeight2 + ((LinearLayout.LayoutParams) za2Var).bottomMargin + i222;
                }
                i20++;
                c2 = c;
                i15 = 8;
            }
            return;
        }
        boolean z2 = pr4.a;
        boolean z3 = getLayoutDirection() == 1;
        int paddingTop2 = getPaddingTop();
        int i23 = i4 - i2;
        int paddingBottom = i23 - getPaddingBottom();
        int paddingBottom2 = (i23 - paddingTop2) - getPaddingBottom();
        int virtualChildCount2 = getVirtualChildCount();
        int i24 = this.y0;
        int i25 = 8388615 & i24;
        int i26 = i24 & 112;
        boolean z4 = this.b;
        int[] iArr = this.C0;
        int[] iArr2 = this.D0;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i25, getLayoutDirection());
        int paddingLeft2 = absoluteGravity2 != 1 ? absoluteGravity2 != 5 ? getPaddingLeft() : ((getPaddingLeft() + i3) - i) - this.z0 : getPaddingLeft() + (((i3 - i) - this.z0) / 2);
        if (z3) {
            i6 = virtualChildCount2 - 1;
            i5 = -1;
        } else {
            i5 = 1;
            i6 = 0;
        }
        int i27 = 0;
        while (i27 < virtualChildCount2) {
            int i28 = (i5 * i27) + i6;
            View childAt2 = getChildAt(i28);
            if (childAt2 == null) {
                i7 = i6;
            } else {
                i7 = i6;
                if (childAt2.getVisibility() != 8) {
                    int measuredWidth2 = childAt2.getMeasuredWidth();
                    int measuredHeight3 = childAt2.getMeasuredHeight();
                    za2 za2Var2 = (za2) childAt2.getLayoutParams();
                    int i29 = paddingLeft2;
                    if (z4) {
                        i8 = paddingTop2;
                        int baseline = ((LinearLayout.LayoutParams) za2Var2).height != -1 ? childAt2.getBaseline() : -1;
                        i9 = ((LinearLayout.LayoutParams) za2Var2).gravity;
                        if (i9 < 0) {
                            i9 = i26;
                        }
                        i10 = i9 & 112;
                        if (i10 == 16) {
                            if (i10 == 48) {
                                i11 = i8 + ((LinearLayout.LayoutParams) za2Var2).topMargin;
                                if (baseline != -1) {
                                    i11 = (iArr[1] - baseline) + i11;
                                }
                            } else if (i10 != 80) {
                                i11 = i8;
                            } else {
                                i11 = (paddingBottom - measuredHeight3) - ((LinearLayout.LayoutParams) za2Var2).bottomMargin;
                                if (baseline != -1) {
                                    measuredHeight = iArr2[2] - (childAt2.getMeasuredHeight() - baseline);
                                }
                            }
                            int i30 = (i(i28) ? i29 + this.F0 : i29) + ((LinearLayout.LayoutParams) za2Var2).leftMargin;
                            childAt2.layout(i30, i11, i30 + measuredWidth2, i11 + measuredHeight3);
                            paddingLeft2 = measuredWidth2 + ((LinearLayout.LayoutParams) za2Var2).rightMargin + i30;
                            i27++;
                            i6 = i7;
                            paddingTop2 = i8;
                        } else {
                            i11 = ((paddingBottom2 - measuredHeight3) / 2) + i8 + ((LinearLayout.LayoutParams) za2Var2).topMargin;
                            measuredHeight = ((LinearLayout.LayoutParams) za2Var2).bottomMargin;
                        }
                        i11 -= measuredHeight;
                        int i302 = (i(i28) ? i29 + this.F0 : i29) + ((LinearLayout.LayoutParams) za2Var2).leftMargin;
                        childAt2.layout(i302, i11, i302 + measuredWidth2, i11 + measuredHeight3);
                        paddingLeft2 = measuredWidth2 + ((LinearLayout.LayoutParams) za2Var2).rightMargin + i302;
                        i27++;
                        i6 = i7;
                        paddingTop2 = i8;
                    } else {
                        i8 = paddingTop2;
                    }
                    i9 = ((LinearLayout.LayoutParams) za2Var2).gravity;
                    if (i9 < 0) {
                    }
                    i10 = i9 & 112;
                    if (i10 == 16) {
                    }
                    i11 -= measuredHeight;
                    int i3022 = (i(i28) ? i29 + this.F0 : i29) + ((LinearLayout.LayoutParams) za2Var2).leftMargin;
                    childAt2.layout(i3022, i11, i3022 + measuredWidth2, i11 + measuredHeight3);
                    paddingLeft2 = measuredWidth2 + ((LinearLayout.LayoutParams) za2Var2).rightMargin + i3022;
                    i27++;
                    i6 = i7;
                    paddingTop2 = i8;
                }
            }
            i8 = paddingTop2;
            i27++;
            i6 = i7;
            paddingTop2 = i8;
        }
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
    */
    public void onMeasure(int i, int i2) {
        int[] iArr;
        int i3;
        int i4;
        int i5;
        int iMax;
        int i6;
        int i7;
        int baseline;
        int i8;
        int i9;
        int[] iArr2;
        int i10;
        int i11;
        boolean z;
        boolean z2;
        za2 za2Var;
        int i12;
        int[] iArr3;
        int i13;
        View view;
        int i14;
        boolean z3;
        boolean z4;
        int iMax2;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        boolean z5;
        int i23;
        int i24;
        int i25;
        View view2;
        boolean z6;
        LinearLayoutCompat linearLayoutCompat = this;
        int i26 = linearLayoutCompat.A;
        int i27 = -2;
        int iMax3 = 0;
        int i28 = Pow2.MAX_POW2;
        int i29 = 8;
        if (i26 == 1) {
            linearLayoutCompat.z0 = 0;
            int virtualChildCount = linearLayoutCompat.getVirtualChildCount();
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int i30 = linearLayoutCompat.f;
            boolean z7 = linearLayoutCompat.B0;
            int i31 = 0;
            int iMax4 = 0;
            int iMax5 = 0;
            boolean z8 = false;
            int i32 = 0;
            boolean z9 = false;
            boolean z10 = true;
            float f = 0.0f;
            int iMax6 = 0;
            while (i31 < virtualChildCount) {
                int i33 = mode;
                View childAt = linearLayoutCompat.getChildAt(i31);
                if (childAt == null) {
                    linearLayoutCompat.z0 = linearLayoutCompat.z0;
                } else {
                    if (childAt.getVisibility() != i29) {
                        if (linearLayoutCompat.i(i31)) {
                            linearLayoutCompat.z0 += linearLayoutCompat.G0;
                        }
                        za2 za2Var2 = (za2) childAt.getLayoutParams();
                        float f2 = ((LinearLayout.LayoutParams) za2Var2).weight;
                        f += f2;
                        if (mode2 == i28 && ((LinearLayout.LayoutParams) za2Var2).height == 0 && f2 > 0.0f) {
                            int i34 = linearLayoutCompat.z0;
                            linearLayoutCompat.z0 = Math.max(i34, ((LinearLayout.LayoutParams) za2Var2).topMargin + i34 + ((LinearLayout.LayoutParams) za2Var2).bottomMargin);
                            view2 = childAt;
                            i22 = mode2;
                            i23 = i30;
                            z5 = z7;
                            i24 = i31;
                            z8 = true;
                            i25 = i33;
                        } else {
                            if (((LinearLayout.LayoutParams) za2Var2).height != 0 || f2 <= 0.0f) {
                                i19 = Integer.MIN_VALUE;
                            } else {
                                ((LinearLayout.LayoutParams) za2Var2).height = i27;
                                i19 = 0;
                            }
                            if (f == 0.0f) {
                                i20 = i31;
                                i21 = linearLayoutCompat.z0;
                            } else {
                                i20 = i31;
                                i21 = 0;
                            }
                            i22 = mode2;
                            z5 = z7;
                            i23 = i30;
                            i24 = i20;
                            i25 = i33;
                            linearLayoutCompat.measureChildWithMargins(childAt, i, 0, i2, i21);
                            if (i19 != Integer.MIN_VALUE) {
                                ((LinearLayout.LayoutParams) za2Var2).height = i19;
                            }
                            int measuredHeight = childAt.getMeasuredHeight();
                            int i35 = linearLayoutCompat.z0;
                            view2 = childAt;
                            linearLayoutCompat.z0 = Math.max(i35, i35 + measuredHeight + ((LinearLayout.LayoutParams) za2Var2).topMargin + ((LinearLayout.LayoutParams) za2Var2).bottomMargin);
                            if (z5) {
                                iMax6 = Math.max(measuredHeight, iMax6);
                            }
                        }
                        if (i23 >= 0 && i23 == i24 + 1) {
                            linearLayoutCompat.z = linearLayoutCompat.z0;
                        }
                        if (i24 < i23 && ((LinearLayout.LayoutParams) za2Var2).weight > 0.0f) {
                            zo2.w("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                            return;
                        }
                        if (i25 == 1073741824 || ((LinearLayout.LayoutParams) za2Var2).width != -1) {
                            z6 = false;
                        } else {
                            z6 = true;
                            z9 = true;
                        }
                        int i36 = ((LinearLayout.LayoutParams) za2Var2).leftMargin + ((LinearLayout.LayoutParams) za2Var2).rightMargin;
                        int measuredWidth = view2.getMeasuredWidth() + i36;
                        iMax3 = Math.max(iMax3, measuredWidth);
                        int measuredState = view2.getMeasuredState();
                        boolean z11 = z6;
                        int iCombineMeasuredStates = View.combineMeasuredStates(i32, measuredState);
                        if (z10) {
                            i32 = iCombineMeasuredStates;
                            boolean z12 = ((LinearLayout.LayoutParams) za2Var2).width == -1;
                            if (((LinearLayout.LayoutParams) za2Var2).weight <= 0.0f) {
                                if (!z11) {
                                    i36 = measuredWidth;
                                }
                                iMax5 = Math.max(iMax5, i36);
                            } else {
                                if (!z11) {
                                    i36 = measuredWidth;
                                }
                                iMax4 = Math.max(iMax4, i36);
                            }
                            z10 = z12;
                        } else {
                            i32 = iCombineMeasuredStates;
                        }
                        if (((LinearLayout.LayoutParams) za2Var2).weight <= 0.0f) {
                        }
                        z10 = z12;
                    }
                    i31 = i24 + 1;
                    i30 = i23;
                    mode = i25;
                    z7 = z5;
                    mode2 = i22;
                    i27 = -2;
                    i28 = Pow2.MAX_POW2;
                    i29 = 8;
                }
                i22 = mode2;
                i23 = i30;
                z5 = z7;
                i24 = i31;
                i25 = i33;
                i31 = i24 + 1;
                i30 = i23;
                mode = i25;
                z7 = z5;
                mode2 = i22;
                i27 = -2;
                i28 = Pow2.MAX_POW2;
                i29 = 8;
            }
            int i37 = mode;
            int i38 = mode2;
            boolean z13 = z7;
            int i39 = i32;
            int i40 = i2;
            if (linearLayoutCompat.z0 > 0 && linearLayoutCompat.i(virtualChildCount)) {
                linearLayoutCompat.z0 += linearLayoutCompat.G0;
            }
            if (z13 && (i38 == Integer.MIN_VALUE || i38 == 0)) {
                linearLayoutCompat.z0 = 0;
                for (int i41 = 0; i41 < virtualChildCount; i41++) {
                    View childAt2 = linearLayoutCompat.getChildAt(i41);
                    if (childAt2 == null) {
                        linearLayoutCompat.z0 = linearLayoutCompat.z0;
                    } else if (childAt2.getVisibility() != 8) {
                        za2 za2Var3 = (za2) childAt2.getLayoutParams();
                        int i42 = linearLayoutCompat.z0;
                        linearLayoutCompat.z0 = Math.max(i42, i42 + iMax6 + ((LinearLayout.LayoutParams) za2Var3).topMargin + ((LinearLayout.LayoutParams) za2Var3).bottomMargin);
                    }
                }
            }
            int paddingBottom = linearLayoutCompat.getPaddingBottom() + linearLayoutCompat.getPaddingTop() + linearLayoutCompat.z0;
            linearLayoutCompat.z0 = paddingBottom;
            int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingBottom, linearLayoutCompat.getSuggestedMinimumHeight()), i40, 0);
            int i43 = (iResolveSizeAndState & 16777215) - linearLayoutCompat.z0;
            if (z8 || (i43 != 0 && f > 0.0f)) {
                float f3 = linearLayoutCompat.A0;
                if (f3 > 0.0f) {
                    f = f3;
                }
                linearLayoutCompat.z0 = 0;
                int iCombineMeasuredStates2 = i39;
                int i44 = 0;
                while (i44 < virtualChildCount) {
                    View childAt3 = linearLayoutCompat.getChildAt(i44);
                    if (childAt3.getVisibility() == 8) {
                        i16 = i44;
                    } else {
                        za2 za2Var4 = (za2) childAt3.getLayoutParams();
                        float f4 = ((LinearLayout.LayoutParams) za2Var4).weight;
                        if (f4 > 0.0f) {
                            int i45 = (int) ((i43 * f4) / f);
                            f -= f4;
                            i43 -= i45;
                            i16 = i44;
                            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, linearLayoutCompat.getPaddingRight() + linearLayoutCompat.getPaddingLeft() + ((LinearLayout.LayoutParams) za2Var4).leftMargin + ((LinearLayout.LayoutParams) za2Var4).rightMargin, ((LinearLayout.LayoutParams) za2Var4).width);
                            if (((LinearLayout.LayoutParams) za2Var4).height == 0) {
                                i18 = Pow2.MAX_POW2;
                                if (i38 == 1073741824) {
                                    if (i45 <= 0) {
                                        i45 = 0;
                                    }
                                    childAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i45, Pow2.MAX_POW2));
                                }
                                iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, childAt3.getMeasuredState() & (-256));
                            } else {
                                i18 = Pow2.MAX_POW2;
                            }
                            int measuredHeight2 = childAt3.getMeasuredHeight() + i45;
                            if (measuredHeight2 < 0) {
                                measuredHeight2 = 0;
                            }
                            childAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight2, i18));
                            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, childAt3.getMeasuredState() & (-256));
                        } else {
                            i16 = i44;
                        }
                        int i46 = ((LinearLayout.LayoutParams) za2Var4).leftMargin + ((LinearLayout.LayoutParams) za2Var4).rightMargin;
                        int measuredWidth2 = childAt3.getMeasuredWidth() + i46;
                        iMax3 = Math.max(iMax3, measuredWidth2);
                        if (i37 != 1073741824) {
                            i17 = -1;
                            if (((LinearLayout.LayoutParams) za2Var4).width == -1) {
                                measuredWidth2 = i46;
                            }
                        } else {
                            i17 = -1;
                        }
                        iMax4 = Math.max(iMax4, measuredWidth2);
                        boolean z14 = z10 && ((LinearLayout.LayoutParams) za2Var4).width == i17;
                        int i47 = linearLayoutCompat.z0;
                        linearLayoutCompat.z0 = Math.max(i47, childAt3.getMeasuredHeight() + i47 + ((LinearLayout.LayoutParams) za2Var4).topMargin + ((LinearLayout.LayoutParams) za2Var4).bottomMargin);
                        z10 = z14;
                    }
                    i44 = i16 + 1;
                }
                linearLayoutCompat.z0 = linearLayoutCompat.getPaddingBottom() + linearLayoutCompat.getPaddingTop() + linearLayoutCompat.z0;
                i39 = iCombineMeasuredStates2;
            } else {
                iMax4 = Math.max(iMax4, iMax5);
                if (z13 && i38 != 1073741824) {
                    for (int i48 = 0; i48 < virtualChildCount; i48++) {
                        View childAt4 = linearLayoutCompat.getChildAt(i48);
                        if (childAt4 != null && childAt4.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((za2) childAt4.getLayoutParams())).weight > 0.0f) {
                            childAt4.measure(View.MeasureSpec.makeMeasureSpec(childAt4.getMeasuredWidth(), Pow2.MAX_POW2), View.MeasureSpec.makeMeasureSpec(iMax6, Pow2.MAX_POW2));
                        }
                    }
                }
            }
            if (z10 || i37 == 1073741824) {
                iMax4 = iMax3;
            }
            linearLayoutCompat.setMeasuredDimension(View.resolveSizeAndState(Math.max(linearLayoutCompat.getPaddingRight() + linearLayoutCompat.getPaddingLeft() + iMax4, linearLayoutCompat.getSuggestedMinimumWidth()), i, i39), iResolveSizeAndState);
            if (z9) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(linearLayoutCompat.getMeasuredWidth(), Pow2.MAX_POW2);
                int i49 = 0;
                while (i49 < virtualChildCount) {
                    View childAt5 = linearLayoutCompat.getChildAt(i49);
                    if (childAt5.getVisibility() != 8) {
                        za2 za2Var5 = (za2) childAt5.getLayoutParams();
                        if (((LinearLayout.LayoutParams) za2Var5).width == -1) {
                            int i50 = ((LinearLayout.LayoutParams) za2Var5).height;
                            ((LinearLayout.LayoutParams) za2Var5).height = childAt5.getMeasuredHeight();
                            linearLayoutCompat.measureChildWithMargins(childAt5, iMakeMeasureSpec, 0, i40, 0);
                            ((LinearLayout.LayoutParams) za2Var5).height = i50;
                        }
                    }
                    i49++;
                    i40 = i2;
                }
                return;
            }
            return;
        }
        int i51 = i;
        linearLayoutCompat.z0 = 0;
        int virtualChildCount2 = linearLayoutCompat.getVirtualChildCount();
        int mode3 = View.MeasureSpec.getMode(i51);
        int mode4 = View.MeasureSpec.getMode(i2);
        int[] iArr4 = linearLayoutCompat.C0;
        if (iArr4 == null || (iArr = linearLayoutCompat.D0) == null) {
            iArr4 = new int[4];
            linearLayoutCompat.C0 = iArr4;
            iArr = new int[4];
            linearLayoutCompat.D0 = iArr;
        }
        int[] iArr5 = iArr4;
        int[] iArr6 = iArr;
        iArr5[3] = -1;
        char c = 2;
        iArr5[2] = -1;
        iArr5[1] = -1;
        iArr5[0] = -1;
        iArr6[3] = -1;
        iArr6[2] = -1;
        iArr6[1] = -1;
        iArr6[0] = -1;
        boolean z15 = linearLayoutCompat.b;
        boolean z16 = linearLayoutCompat.B0;
        boolean z17 = mode3 == 1073741824;
        float f5 = 0.0f;
        boolean z18 = true;
        int i52 = 0;
        int i53 = 0;
        int i54 = 0;
        int iMax7 = 0;
        int iMax8 = 0;
        int iCombineMeasuredStates3 = 0;
        boolean z19 = false;
        boolean z20 = false;
        while (i52 < virtualChildCount2) {
            char c2 = c;
            View childAt6 = linearLayoutCompat.getChildAt(i52);
            if (childAt6 == null) {
                linearLayoutCompat.z0 = linearLayoutCompat.z0;
                i11 = i52;
                i15 = i54;
                iArr3 = iArr5;
                iArr2 = iArr6;
                z = z15;
                z2 = z16;
            } else {
                int i55 = i53;
                if (childAt6.getVisibility() == 8) {
                    i51 = i;
                    i11 = i52;
                    i15 = i54;
                    iArr2 = iArr6;
                    z = z15;
                    z2 = z16;
                    i53 = i55;
                    iArr3 = iArr5;
                } else {
                    if (linearLayoutCompat.i(i52)) {
                        linearLayoutCompat.z0 += linearLayoutCompat.F0;
                    }
                    za2 za2Var6 = (za2) childAt6.getLayoutParams();
                    float f6 = ((LinearLayout.LayoutParams) za2Var6).weight;
                    f5 += f6;
                    int i56 = i52;
                    if (mode3 == 1073741824 && ((LinearLayout.LayoutParams) za2Var6).width == 0 && f6 > 0.0f) {
                        int i57 = linearLayoutCompat.z0;
                        int i58 = ((LinearLayout.LayoutParams) za2Var6).leftMargin;
                        if (z17) {
                            linearLayoutCompat.z0 = i58 + ((LinearLayout.LayoutParams) za2Var6).rightMargin + i57;
                        } else {
                            linearLayoutCompat.z0 = Math.max(i57, i57 + i58 + ((LinearLayout.LayoutParams) za2Var6).rightMargin);
                        }
                        if (z15) {
                            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
                            childAt6.measure(iMakeMeasureSpec2, iMakeMeasureSpec2);
                            view = childAt6;
                            z = z15;
                            z2 = z16;
                            i12 = i55;
                            i11 = i56;
                            za2Var = za2Var6;
                            iArr3 = iArr5;
                            iArr2 = iArr6;
                            i51 = i;
                            i13 = i54;
                            i10 = iMax7;
                        } else {
                            view = childAt6;
                            z = z15;
                            z2 = z16;
                            z20 = true;
                            i12 = i55;
                            i11 = i56;
                            i14 = Pow2.MAX_POW2;
                            za2Var = za2Var6;
                            iArr3 = iArr5;
                            iArr2 = iArr6;
                            i51 = i;
                            i13 = i54;
                            i10 = iMax7;
                            if (mode4 == i14 && ((LinearLayout.LayoutParams) za2Var).height == -1) {
                                z3 = true;
                                z19 = true;
                            } else {
                                z3 = false;
                            }
                            int i59 = ((LinearLayout.LayoutParams) za2Var).topMargin + ((LinearLayout.LayoutParams) za2Var).bottomMargin;
                            int measuredHeight3 = view.getMeasuredHeight() + i59;
                            iCombineMeasuredStates3 = View.combineMeasuredStates(iCombineMeasuredStates3, view.getMeasuredState());
                            if (z) {
                                z4 = z3;
                            } else {
                                int baseline2 = view.getBaseline();
                                z4 = z3;
                                if (baseline2 != -1) {
                                    int i60 = ((LinearLayout.LayoutParams) za2Var).gravity;
                                    if (i60 < 0) {
                                        i60 = linearLayoutCompat.y0;
                                    }
                                    int i61 = (((i60 & 112) >> 4) & (-2)) >> 1;
                                    iArr3[i61] = Math.max(iArr3[i61], baseline2);
                                    iArr2[i61] = Math.max(iArr2[i61], measuredHeight3 - baseline2);
                                }
                            }
                            int iMax9 = Math.max(i12, measuredHeight3);
                            boolean z21 = !z18 && ((LinearLayout.LayoutParams) za2Var).height == -1;
                            if (((LinearLayout.LayoutParams) za2Var).weight <= 0.0f) {
                                if (!z4) {
                                    i59 = measuredHeight3;
                                }
                                iMax7 = Math.max(i10, i59);
                                iMax2 = i13;
                            } else {
                                if (!z4) {
                                    i59 = measuredHeight3;
                                }
                                iMax2 = Math.max(i13, i59);
                                iMax7 = i10;
                            }
                            int i62 = iMax2;
                            i53 = iMax9;
                            i15 = i62;
                            z18 = z21;
                        }
                    } else {
                        if (((LinearLayout.LayoutParams) za2Var6).width != 0 || f6 <= 0.0f) {
                            i9 = Integer.MIN_VALUE;
                        } else {
                            ((LinearLayout.LayoutParams) za2Var6).width = -2;
                            i9 = 0;
                        }
                        iArr2 = iArr6;
                        i10 = iMax7;
                        i11 = i56;
                        z = z15;
                        z2 = z16;
                        int i63 = i9;
                        za2Var = za2Var6;
                        i12 = i55;
                        i51 = i;
                        iArr3 = iArr5;
                        i13 = i54;
                        linearLayoutCompat.measureChildWithMargins(childAt6, i51, f5 == 0.0f ? linearLayoutCompat.z0 : 0, i2, 0);
                        if (i63 != Integer.MIN_VALUE) {
                            ((LinearLayout.LayoutParams) za2Var).width = i63;
                        }
                        int measuredWidth3 = childAt6.getMeasuredWidth();
                        int i64 = linearLayoutCompat.z0;
                        int i65 = ((LinearLayout.LayoutParams) za2Var).leftMargin;
                        if (z17) {
                            view = childAt6;
                            linearLayoutCompat.z0 = i65 + measuredWidth3 + ((LinearLayout.LayoutParams) za2Var).rightMargin + i64;
                        } else {
                            view = childAt6;
                            linearLayoutCompat.z0 = Math.max(i64, i64 + measuredWidth3 + i65 + ((LinearLayout.LayoutParams) za2Var).rightMargin);
                        }
                        if (z2) {
                            iMax8 = Math.max(measuredWidth3, iMax8);
                        }
                    }
                    i14 = Pow2.MAX_POW2;
                    if (mode4 == i14) {
                        z3 = false;
                        int i592 = ((LinearLayout.LayoutParams) za2Var).topMargin + ((LinearLayout.LayoutParams) za2Var).bottomMargin;
                        int measuredHeight32 = view.getMeasuredHeight() + i592;
                        iCombineMeasuredStates3 = View.combineMeasuredStates(iCombineMeasuredStates3, view.getMeasuredState());
                        if (z) {
                        }
                        int iMax92 = Math.max(i12, measuredHeight32);
                        if (z18) {
                            if (((LinearLayout.LayoutParams) za2Var).weight <= 0.0f) {
                            }
                            int i622 = iMax2;
                            i53 = iMax92;
                            i15 = i622;
                            z18 = z21;
                        }
                    }
                }
            }
            i54 = i15;
            i52 = i11 + 1;
            c = c2;
            iArr5 = iArr3;
            iArr6 = iArr2;
            z15 = z;
            z16 = z2;
        }
        int[] iArr7 = iArr5;
        int[] iArr8 = iArr6;
        char c3 = c;
        boolean z22 = z15;
        boolean z23 = z16;
        int i66 = i53;
        int i67 = i54;
        int i68 = iMax7;
        if (linearLayoutCompat.z0 > 0 && linearLayoutCompat.i(virtualChildCount2)) {
            linearLayoutCompat.z0 += linearLayoutCompat.F0;
        }
        int i69 = iArr7[1];
        int iMax10 = (i69 == -1 && iArr7[0] == -1 && iArr7[c3] == -1 && iArr7[3] == -1) ? i66 : Math.max(i66, Math.max(iArr8[3], Math.max(iArr8[0], Math.max(iArr8[1], iArr8[c3]))) + Math.max(iArr7[3], Math.max(iArr7[0], Math.max(i69, iArr7[c3]))));
        if (z23 && (mode3 == Integer.MIN_VALUE || mode3 == 0)) {
            linearLayoutCompat.z0 = 0;
            for (int i70 = 0; i70 < virtualChildCount2; i70++) {
                View childAt7 = linearLayoutCompat.getChildAt(i70);
                if (childAt7 == null) {
                    linearLayoutCompat.z0 = linearLayoutCompat.z0;
                } else if (childAt7.getVisibility() != 8) {
                    za2 za2Var7 = (za2) childAt7.getLayoutParams();
                    int i71 = linearLayoutCompat.z0;
                    if (z17) {
                        linearLayoutCompat.z0 = ((LinearLayout.LayoutParams) za2Var7).leftMargin + iMax8 + ((LinearLayout.LayoutParams) za2Var7).rightMargin + i71;
                    } else {
                        linearLayoutCompat.z0 = Math.max(i71, i71 + iMax8 + ((LinearLayout.LayoutParams) za2Var7).leftMargin + ((LinearLayout.LayoutParams) za2Var7).rightMargin);
                    }
                }
            }
        }
        int paddingRight = linearLayoutCompat.getPaddingRight() + linearLayoutCompat.getPaddingLeft() + linearLayoutCompat.z0;
        linearLayoutCompat.z0 = paddingRight;
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingRight, linearLayoutCompat.getSuggestedMinimumWidth()), i51, 0);
        int i72 = (iResolveSizeAndState2 & 16777215) - linearLayoutCompat.z0;
        if (z20 || (i72 != 0 && f5 > 0.0f)) {
            float f7 = linearLayoutCompat.A0;
            if (f7 > 0.0f) {
                f5 = f7;
            }
            iArr7[3] = -1;
            iArr7[c3] = -1;
            iArr7[1] = -1;
            iArr7[0] = -1;
            iArr8[3] = -1;
            iArr8[c3] = -1;
            iArr8[1] = -1;
            iArr8[0] = -1;
            linearLayoutCompat.z0 = 0;
            iMax10 = -1;
            int i73 = 0;
            while (i73 < virtualChildCount2) {
                View childAt8 = linearLayoutCompat.getChildAt(i73);
                if (childAt8 == null || childAt8.getVisibility() == 8) {
                    i6 = iResolveSizeAndState2;
                } else {
                    za2 za2Var8 = (za2) childAt8.getLayoutParams();
                    float f8 = ((LinearLayout.LayoutParams) za2Var8).weight;
                    if (f8 > 0.0f) {
                        int i74 = (int) ((i72 * f8) / f5);
                        f5 -= f8;
                        i72 -= i74;
                        i6 = iResolveSizeAndState2;
                        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, linearLayoutCompat.getPaddingBottom() + linearLayoutCompat.getPaddingTop() + ((LinearLayout.LayoutParams) za2Var8).topMargin + ((LinearLayout.LayoutParams) za2Var8).bottomMargin, ((LinearLayout.LayoutParams) za2Var8).height);
                        if (((LinearLayout.LayoutParams) za2Var8).width == 0) {
                            i8 = Pow2.MAX_POW2;
                            if (mode3 == 1073741824) {
                                if (i74 <= 0) {
                                    i74 = 0;
                                }
                                childAt8.measure(View.MeasureSpec.makeMeasureSpec(i74, Pow2.MAX_POW2), childMeasureSpec2);
                            }
                            iCombineMeasuredStates3 = View.combineMeasuredStates(iCombineMeasuredStates3, childAt8.getMeasuredState() & (-16777216));
                        } else {
                            i8 = Pow2.MAX_POW2;
                        }
                        int measuredWidth4 = childAt8.getMeasuredWidth() + i74;
                        if (measuredWidth4 < 0) {
                            measuredWidth4 = 0;
                        }
                        childAt8.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth4, i8), childMeasureSpec2);
                        iCombineMeasuredStates3 = View.combineMeasuredStates(iCombineMeasuredStates3, childAt8.getMeasuredState() & (-16777216));
                    } else {
                        i6 = iResolveSizeAndState2;
                    }
                    int i75 = linearLayoutCompat.z0;
                    if (z17) {
                        linearLayoutCompat.z0 = childAt8.getMeasuredWidth() + ((LinearLayout.LayoutParams) za2Var8).leftMargin + ((LinearLayout.LayoutParams) za2Var8).rightMargin + i75;
                    } else {
                        linearLayoutCompat.z0 = Math.max(i75, childAt8.getMeasuredWidth() + i75 + ((LinearLayout.LayoutParams) za2Var8).leftMargin + ((LinearLayout.LayoutParams) za2Var8).rightMargin);
                    }
                    boolean z24 = mode4 != 1073741824 && ((LinearLayout.LayoutParams) za2Var8).height == -1;
                    int i76 = ((LinearLayout.LayoutParams) za2Var8).topMargin + ((LinearLayout.LayoutParams) za2Var8).bottomMargin;
                    int measuredHeight4 = childAt8.getMeasuredHeight() + i76;
                    iMax10 = Math.max(iMax10, measuredHeight4);
                    if (!z24) {
                        i76 = measuredHeight4;
                    }
                    int iMax11 = Math.max(i67, i76);
                    if (z18) {
                        i7 = -1;
                        boolean z25 = ((LinearLayout.LayoutParams) za2Var8).height == -1;
                        if (!z22 && (baseline = childAt8.getBaseline()) != i7) {
                            int i77 = ((LinearLayout.LayoutParams) za2Var8).gravity;
                            if (i77 < 0) {
                                i77 = linearLayoutCompat.y0;
                            }
                            int i78 = (((i77 & 112) >> 4) & (-2)) >> 1;
                            iArr7[i78] = Math.max(iArr7[i78], baseline);
                            iArr8[i78] = Math.max(iArr8[i78], measuredHeight4 - baseline);
                        }
                        z18 = z25;
                        i67 = iMax11;
                    } else {
                        i7 = -1;
                    }
                    if (!z22) {
                        z18 = z25;
                        i67 = iMax11;
                    }
                }
                i73++;
                iResolveSizeAndState2 = i6;
            }
            i3 = iResolveSizeAndState2;
            i4 = -16777216;
            linearLayoutCompat.z0 = linearLayoutCompat.getPaddingRight() + linearLayoutCompat.getPaddingLeft() + linearLayoutCompat.z0;
            int i79 = iArr7[1];
            if (i79 == -1 && iArr7[0] == -1 && iArr7[c3] == -1 && iArr7[3] == -1) {
                i5 = 0;
            } else {
                i5 = 0;
                iMax10 = Math.max(iMax10, Math.max(iArr8[3], Math.max(iArr8[0], Math.max(iArr8[1], iArr8[c3]))) + Math.max(iArr7[3], Math.max(iArr7[0], Math.max(i79, iArr7[c3]))));
            }
            iMax = i67;
        } else {
            iMax = Math.max(i67, i68);
            if (z23 && mode3 != 1073741824) {
                for (int i80 = 0; i80 < virtualChildCount2; i80++) {
                    View childAt9 = linearLayoutCompat.getChildAt(i80);
                    if (childAt9 != null && childAt9.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((za2) childAt9.getLayoutParams())).weight > 0.0f) {
                        childAt9.measure(View.MeasureSpec.makeMeasureSpec(iMax8, Pow2.MAX_POW2), View.MeasureSpec.makeMeasureSpec(childAt9.getMeasuredHeight(), Pow2.MAX_POW2));
                    }
                }
            }
            i3 = iResolveSizeAndState2;
            i4 = -16777216;
            i5 = 0;
        }
        if (!z18 && mode4 != 1073741824) {
            iMax10 = iMax;
        }
        linearLayoutCompat.setMeasuredDimension(i3 | (iCombineMeasuredStates3 & i4), View.resolveSizeAndState(Math.max(linearLayoutCompat.getPaddingBottom() + linearLayoutCompat.getPaddingTop() + iMax10, linearLayoutCompat.getSuggestedMinimumHeight()), i2, iCombineMeasuredStates3 << 16));
        if (z19) {
            int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(linearLayoutCompat.getMeasuredHeight(), Pow2.MAX_POW2);
            int i81 = i5;
            while (i81 < virtualChildCount2) {
                View childAt10 = linearLayoutCompat.getChildAt(i81);
                if (childAt10.getVisibility() != 8) {
                    za2 za2Var9 = (za2) childAt10.getLayoutParams();
                    if (((LinearLayout.LayoutParams) za2Var9).height == -1) {
                        int i82 = ((LinearLayout.LayoutParams) za2Var9).width;
                        ((LinearLayout.LayoutParams) za2Var9).width = childAt10.getMeasuredWidth();
                        linearLayoutCompat.measureChildWithMargins(childAt10, i51, 0, iMakeMeasureSpec3, 0);
                        ((LinearLayout.LayoutParams) za2Var9).width = i82;
                    }
                }
                i81++;
                linearLayoutCompat = this;
                i51 = i;
            }
        }
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
