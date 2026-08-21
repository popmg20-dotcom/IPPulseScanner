package com.getsurfboard.ui.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.getsurfboard.R;
import defpackage.d70;
import defpackage.e03;
import defpackage.e70;
import defpackage.em2;
import defpackage.fw;
import defpackage.n12;
import defpackage.qc3;
import defpackage.vp1;
import defpackage.w0;
import defpackage.xe;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class MetroLayout extends ViewGroup {
    public final boolean A;
    public final HashMap A0;
    public final int b;
    public int f;
    public final int y0;
    public final int z;
    public final ArrayList z0;

    /* JADX WARN: Illegal instructions before constructor call */
    public MetroLayout(Context context, AttributeSet attributeSet, int i) {
        attributeSet = (i & 2) != 0 ? null : attributeSet;
        super(context, attributeSet, 0);
        this.z0 = new ArrayList();
        this.A0 = new HashMap();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, qc3.a, 0, 0);
        try {
            this.b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, 0);
            this.f = typedArrayObtainStyledAttributes.getInteger(4, 1);
            this.z = typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0);
            this.A = typedArrayObtainStyledAttributes.getBoolean(0, false);
            this.y0 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, typedArrayObtainStyledAttributes.getResources().getDimensionPixelOffset(R.dimen.metro_default_dynamic_column_size));
            typedArrayObtainStyledAttributes.recycle();
            LayoutTransition layoutTransition = new LayoutTransition();
            layoutTransition.enableTransitionType(4);
            setLayoutTransition(layoutTransition);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private final int getHorizontalSpanUnitSize() {
        int measuredWidth = (getMeasuredWidth() - getPaddingStart()) - getPaddingEnd();
        int i = this.f;
        return (measuredWidth - ((i - 1) * this.b)) / i;
    }

    public final e03 a(int i, int i2) {
        boolean zC;
        ArrayList arrayList = this.z0;
        int i3 = 0;
        for (Object obj : arrayList) {
            int i4 = i3 + 1;
            Boolean boolValueOf = null;
            if (i3 < 0) {
                e70.P();
                throw null;
            }
            boolean[] zArr = (boolean[]) obj;
            int length = zArr.length;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                if (i5 < length) {
                    int i7 = i6 + 1;
                    if (zArr[i5]) {
                        i5++;
                        i6 = i7;
                    } else {
                        e03 e03Var = new e03(Integer.valueOf(i3), Integer.valueOf(i6));
                        int i8 = i6 + i;
                        int i9 = i8 - 1;
                        Boolean boolValueOf2 = (i9 < 0 || i9 >= zArr.length) ? null : Boolean.valueOf(zArr[i9]);
                        Boolean bool = Boolean.FALSE;
                        if (n12.c(boolValueOf2, bool)) {
                            int i10 = i3 + i2;
                            boolean[] zArr2 = (boolean[]) d70.f0(i10 - 1, arrayList);
                            if (zArr2 != null) {
                                if (i6 >= 0 && i6 < zArr2.length) {
                                    boolValueOf = Boolean.valueOf(zArr2[i6]);
                                }
                                zC = n12.c(boolValueOf, bool);
                            } else {
                                zC = false;
                            }
                            if (zC) {
                                while (i3 < i10) {
                                    boolean[] zArr3 = (boolean[]) arrayList.get(i3);
                                    for (int i11 = i6; i11 < i8; i11++) {
                                        zArr3[i11] = true;
                                    }
                                    i3++;
                                }
                                return e03Var;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            i3 = i4;
        }
        arrayList.add(new boolean[this.f]);
        return a(i, i2);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        layoutParams.getClass();
        return layoutParams instanceof em2;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        attributeSet.getClass();
        Context context = getContext();
        context.getClass();
        em2 em2Var = new em2(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, qc3.b);
        try {
            em2Var.a = typedArrayObtainStyledAttributes.getInteger(0, 1);
            em2Var.b = typedArrayObtainStyledAttributes.getInteger(1, 1);
            typedArrayObtainStyledAttributes.recycle();
            int i = em2Var.a;
            int i2 = this.f;
            if (i <= i2) {
                return em2Var;
            }
            xe.k(fw.s(i, i2, "Children spanHorizontal shouldn't be large than parent's spanHorizontal: child value: ", ", parent value: "));
            return null;
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int horizontalSpanUnitSize = getHorizontalSpanUnitSize();
        w0 w0Var = new w0(3, this);
        while (w0Var.hasNext()) {
            View view = (View) w0Var.next();
            e03 e03Var = (e03) this.A0.get(view);
            if (e03Var != null) {
                int iIntValue = ((Number) e03Var.f).intValue();
                int i5 = this.b;
                int paddingStart = getPaddingStart() + ((horizontalSpanUnitSize + i5) * iIntValue);
                int paddingTop = getPaddingTop() + ((this.z + i5) * ((Number) e03Var.b).intValue());
                view.layout(paddingStart, paddingTop, view.getMeasuredWidth() + paddingStart, view.getMeasuredHeight() + paddingTop);
            } else {
                view.layout(0, 0, 0, 0);
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int defaultSize = View.getDefaultSize(getSuggestedMinimumWidth(), i);
        boolean z = this.A;
        int i3 = this.b;
        if (z) {
            this.f = (((defaultSize - getPaddingStart()) - getPaddingEnd()) - i3) / (this.y0 + i3);
            w0 w0Var = new w0(3, this);
            if (!w0Var.hasNext()) {
                vp1.g();
                return;
            }
            ViewGroup.LayoutParams layoutParams = ((View) w0Var.next()).getLayoutParams();
            int i4 = layoutParams instanceof em2 ? ((em2) layoutParams).a : 1;
            while (w0Var.hasNext()) {
                ViewGroup.LayoutParams layoutParams2 = ((View) w0Var.next()).getLayoutParams();
                int i5 = layoutParams2 instanceof em2 ? ((em2) layoutParams2).a : 1;
                if (i4 < i5) {
                    i4 = i5;
                }
            }
            int i6 = this.f;
            if (i6 >= i4) {
                i4 = i6;
            }
            this.f = i4;
        }
        HashMap map = this.A0;
        map.clear();
        this.z0.clear();
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (!(i8 < getChildCount())) {
                int i9 = this.z;
                int i10 = i7 * i9;
                int i11 = i7 - 1;
                if (i11 <= 0) {
                    i11 = 0;
                }
                setMeasuredDimension(defaultSize, View.getDefaultSize(getSuggestedMinimumHeight(), View.MeasureSpec.makeMeasureSpec(getPaddingBottom() + getPaddingTop() + (i11 * i3) + i10, Pow2.MAX_POW2)));
                int horizontalSpanUnitSize = getHorizontalSpanUnitSize();
                w0 w0Var2 = new w0(3, this);
                while (w0Var2.hasNext()) {
                    View view = (View) w0Var2.next();
                    if (((e03) map.get(view)) != null) {
                        ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
                        layoutParams3.getClass();
                        em2 em2Var = (em2) layoutParams3;
                        int i12 = em2Var.a;
                        int i13 = em2Var.b;
                        view.measure(View.MeasureSpec.makeMeasureSpec(((i12 - 1) * i3) + (horizontalSpanUnitSize * i12), Pow2.MAX_POW2), View.MeasureSpec.makeMeasureSpec(((i13 - 1) * i3) + (i9 * i13), Pow2.MAX_POW2));
                    } else {
                        view.measure(View.MeasureSpec.makeMeasureSpec(0, Pow2.MAX_POW2), View.MeasureSpec.makeMeasureSpec(0, Pow2.MAX_POW2));
                    }
                }
                return;
            }
            int i14 = i8 + 1;
            View childAt = getChildAt(i8);
            if (childAt == null) {
                throw new IndexOutOfBoundsException();
            }
            if (childAt.getVisibility() == 0) {
                ViewGroup.LayoutParams layoutParams4 = childAt.getLayoutParams();
                layoutParams4.getClass();
                em2 em2Var2 = (em2) layoutParams4;
                int i15 = em2Var2.b;
                e03 e03VarA = a(em2Var2.a, i15);
                map.put(childAt, e03VarA);
                int iIntValue = ((Number) e03VarA.b).intValue() + i15;
                if (i7 < iIntValue) {
                    i7 = iIntValue;
                }
            }
            i8 = i14;
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        layoutParams.getClass();
        em2 em2Var = new em2(-2, -2);
        em2Var.a = 1;
        em2Var.b = 1;
        return em2Var;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MetroLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4);
        context.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MetroLayout(Context context) {
        this(context, null, 6);
        context.getClass();
    }
}
