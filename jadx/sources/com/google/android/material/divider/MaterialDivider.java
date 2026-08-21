package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.getsurfboard.R;
import defpackage.co4;
import defpackage.fx3;
import defpackage.l72;
import defpackage.rc3;
import defpackage.yi2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class MaterialDivider extends View {
    public int A;
    public final yi2 b;
    public int f;
    public int y0;
    public int z;

    public MaterialDivider(Context context, AttributeSet attributeSet) {
        super(co4.d0(context, attributeSet, R.attr.materialDividerStyle, R.style.Widget_MaterialComponents_MaterialDivider), attributeSet, R.attr.materialDividerStyle);
        Context context2 = getContext();
        this.b = new yi2();
        TypedArray typedArrayV = fx3.v(context2, attributeSet, rc3.x, R.attr.materialDividerStyle, R.style.Widget_MaterialComponents_MaterialDivider, new int[0]);
        this.f = typedArrayV.getDimensionPixelSize(3, getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
        this.A = typedArrayV.getDimensionPixelOffset(2, 0);
        this.y0 = typedArrayV.getDimensionPixelOffset(1, 0);
        setDividerColor(l72.r(context2, typedArrayV, 0).getDefaultColor());
        typedArrayV.recycle();
    }

    public int getDividerColor() {
        return this.z;
    }

    public int getDividerInsetEnd() {
        return this.y0;
    }

    public int getDividerInsetStart() {
        return this.A;
    }

    public int getDividerThickness() {
        return this.f;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        int i;
        super.onDraw(canvas);
        boolean z = getLayoutDirection() == 1;
        int i2 = z ? this.y0 : this.A;
        if (z) {
            width = getWidth();
            i = this.A;
        } else {
            width = getWidth();
            i = this.y0;
        }
        int i3 = width - i;
        int bottom = getBottom() - getTop();
        yi2 yi2Var = this.b;
        yi2Var.setBounds(i2, 0, i3, bottom);
        yi2Var.draw(canvas);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i3 = this.f;
            if (i3 > 0 && measuredHeight != i3) {
                measuredHeight = i3;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(int i) {
        if (this.z != i) {
            this.z = i;
            this.b.p(ColorStateList.valueOf(i));
            invalidate();
        }
    }

    public void setDividerColorResource(int i) {
        setDividerColor(getContext().getColor(i));
    }

    public void setDividerInsetEnd(int i) {
        this.y0 = i;
    }

    public void setDividerInsetEndResource(int i) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i));
    }

    public void setDividerInsetStart(int i) {
        this.A = i;
    }

    public void setDividerInsetStartResource(int i) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i));
    }

    public void setDividerThickness(int i) {
        if (this.f != i) {
            this.f = i;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(int i) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i));
    }

    public MaterialDivider(Context context) {
        this(context, null);
    }
}
