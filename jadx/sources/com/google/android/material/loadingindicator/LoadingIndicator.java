package com.google.android.material.loadingindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import com.getsurfboard.R;
import defpackage.co4;
import defpackage.fx3;
import defpackage.ld2;
import defpackage.md2;
import defpackage.n12;
import defpackage.nd2;
import defpackage.od2;
import defpackage.pd2;
import defpackage.qo4;
import defpackage.rc3;
import defpackage.u8;
import defpackage.xe;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class LoadingIndicator extends View implements Drawable.Callback {
    public final md2 b;
    public final pd2 f;
    public final int z;

    public LoadingIndicator(Context context, AttributeSet attributeSet) {
        super(co4.d0(context, attributeSet, R.attr.loadingIndicatorStyle, R.style.Widget_Material3_LoadingIndicator), attributeSet, R.attr.loadingIndicatorStyle);
        Context context2 = getContext();
        pd2 pd2Var = new pd2();
        pd2Var.d = new int[0];
        int dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.m3_loading_indicator_shape_size);
        int dimensionPixelSize2 = context2.getResources().getDimensionPixelSize(R.dimen.m3_loading_indicator_container_size);
        fx3.c(context2, attributeSet, R.attr.loadingIndicatorStyle, R.style.Widget_Material3_LoadingIndicator);
        int[] iArr = rc3.r;
        fx3.e(context2, attributeSet, iArr, R.attr.loadingIndicatorStyle, R.style.Widget_Material3_LoadingIndicator, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, R.attr.loadingIndicatorStyle, R.style.Widget_Material3_LoadingIndicator);
        pd2Var.a = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, dimensionPixelSize);
        pd2Var.b = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, dimensionPixelSize2);
        pd2Var.c = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, dimensionPixelSize2);
        if (!typedArrayObtainStyledAttributes.hasValue(3)) {
            pd2Var.d = new int[]{n12.z(context2, R.attr.colorPrimary, -1)};
        } else if (typedArrayObtainStyledAttributes.peekValue(3).type != 1) {
            pd2Var.d = new int[]{typedArrayObtainStyledAttributes.getColor(3, -1)};
        } else {
            int[] intArray = context2.getResources().getIntArray(typedArrayObtainStyledAttributes.getResourceId(3, -1));
            pd2Var.d = intArray;
            if (intArray.length == 0) {
                xe.k("indicatorColors cannot be empty when indicatorColor is not used.");
                throw null;
            }
        }
        pd2Var.e = typedArrayObtainStyledAttributes.getColor(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        od2 od2Var = new od2(pd2Var);
        ld2 ld2Var = new ld2();
        ld2Var.f = pd2Var;
        ld2Var.h = new nd2();
        md2 md2Var = new md2(context2, pd2Var, od2Var, ld2Var);
        md2Var.y0 = qo4.a(context2.getResources(), R.drawable.ic_mtrl_arrow_circle, null);
        this.b = md2Var;
        md2Var.setCallback(this);
        this.f = md2Var.A.a;
        fx3.c(context2, attributeSet, R.attr.loadingIndicatorStyle, R.style.Widget_Material3_LoadingIndicator);
        fx3.e(context2, attributeSet, iArr, R.attr.loadingIndicatorStyle, R.style.Widget_Material3_LoadingIndicator, new int[0]);
        TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, iArr, R.attr.loadingIndicatorStyle, R.style.Widget_Material3_LoadingIndicator);
        typedArrayObtainStyledAttributes2.getInt(6, -1);
        this.z = Math.min(typedArrayObtainStyledAttributes2.getInt(5, -1), 1000);
        typedArrayObtainStyledAttributes2.recycle();
        setAnimatorDurationScaleProvider(new u8());
    }

    public final boolean a() {
        if (!isAttachedToWindow() || getWindowVisibility() != 0) {
            return false;
        }
        View view = this;
        while (view.getVisibility() == 0) {
            Object parent = view.getParent();
            if (parent == null) {
                return getWindowVisibility() == 0;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return ProgressBar.class.getName();
    }

    public int getContainerColor() {
        return this.f.e;
    }

    public int getContainerHeight() {
        return this.f.c;
    }

    public int getContainerWidth() {
        return this.f.b;
    }

    public md2 getDrawable() {
        return this.b;
    }

    public int[] getIndicatorColor() {
        return this.f.d;
    }

    public int getIndicatorSize() {
        return this.f.a;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        invalidate();
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (a()) {
            if (this.z > 0) {
                SystemClock.uptimeMillis();
            }
            setVisibility(0);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int iSave = canvas.save();
        if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
            canvas.translate(getPaddingLeft(), getPaddingTop());
        }
        if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
            canvas.clipRect(0, 0, getWidth() - (getPaddingRight() + getPaddingLeft()), getHeight() - (getPaddingBottom() + getPaddingTop()));
        }
        this.b.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        od2 od2Var = this.b.A;
        pd2 pd2Var = od2Var.a;
        int paddingRight = getPaddingRight() + getPaddingLeft() + Math.max(pd2Var.c, pd2Var.a);
        pd2 pd2Var2 = od2Var.a;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + Math.max(pd2Var2.b, pd2Var2.a);
        if (mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(size, paddingRight), Pow2.MAX_POW2);
        } else if (mode == 0) {
            i = View.MeasureSpec.makeMeasureSpec(paddingRight, Pow2.MAX_POW2);
        }
        if (mode2 == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(size2, paddingBottom), Pow2.MAX_POW2);
        } else if (mode2 == 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(paddingBottom, Pow2.MAX_POW2);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.b.setBounds(0, 0, i, i2);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        this.b.a(a(), false, i == 0);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.b.a(a(), false, i == 0);
    }

    public void setAnimatorDurationScaleProvider(u8 u8Var) {
        this.b.b = u8Var;
    }

    public void setContainerColor(int i) {
        pd2 pd2Var = this.f;
        if (pd2Var.e != i) {
            pd2Var.e = i;
            invalidate();
        }
    }

    public void setContainerHeight(int i) {
        pd2 pd2Var = this.f;
        if (pd2Var.c != i) {
            pd2Var.c = i;
            requestLayout();
            invalidate();
        }
    }

    public void setContainerWidth(int i) {
        pd2 pd2Var = this.f;
        if (pd2Var.b != i) {
            pd2Var.b = i;
            requestLayout();
            invalidate();
        }
    }

    public void setIndicatorColor(int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{n12.z(getContext(), R.attr.colorPrimary, -1)};
        }
        if (Arrays.equals(getIndicatorColor(), iArr)) {
            return;
        }
        this.f.d = iArr;
        ld2 ld2Var = this.b.X;
        ld2Var.a = 1;
        ld2Var.a(0.0f);
        ld2Var.h.a = ld2Var.f.d[0];
        invalidate();
    }

    public void setIndicatorSize(int i) {
        pd2 pd2Var = this.f;
        if (pd2Var.a != i) {
            pd2Var.a = i;
            requestLayout();
            invalidate();
        }
    }

    public LoadingIndicator(Context context) {
        this(context, null);
    }
}
