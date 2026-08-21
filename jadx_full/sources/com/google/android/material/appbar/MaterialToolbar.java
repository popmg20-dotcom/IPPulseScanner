package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.getsurfboard.R;
import defpackage.co4;
import defpackage.e1;
import defpackage.fx3;
import defpackage.gb4;
import defpackage.ou3;
import defpackage.rc3;
import defpackage.uf2;
import defpackage.v9;
import defpackage.yi2;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {
    public static final ImageView.ScaleType[] t1 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    public Integer o1;
    public boolean p1;
    public boolean q1;
    public ImageView.ScaleType r1;
    public Boolean s1;

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        super(co4.d0(context, attributeSet, R.attr.toolbarStyle, R.style.Widget_MaterialComponents_Toolbar), attributeSet, 0);
        Context context2 = getContext();
        TypedArray typedArrayV = fx3.v(context2, attributeSet, rc3.E, R.attr.toolbarStyle, R.style.Widget_MaterialComponents_Toolbar, new int[0]);
        if (typedArrayV.hasValue(2)) {
            setNavigationIconTint(typedArrayV.getColor(2, -1));
        }
        this.p1 = typedArrayV.getBoolean(6, false);
        this.q1 = typedArrayV.getBoolean(5, false);
        int i = typedArrayV.getInt(1, -1);
        if (i >= 0) {
            ImageView.ScaleType[] scaleTypeArr = t1;
            if (i < scaleTypeArr.length) {
                this.r1 = scaleTypeArr[i];
            }
        }
        if (typedArrayV.hasValue(0)) {
            this.s1 = Boolean.valueOf(typedArrayV.getBoolean(0, false));
        }
        typedArrayV.recycle();
        ou3 ou3VarB = ou3.h(context2, attributeSet, R.attr.toolbarStyle, R.style.Widget_MaterialComponents_Toolbar).b();
        Drawable background = getBackground();
        ColorStateList colorStateListValueOf = background == null ? ColorStateList.valueOf(0) : v9.h(background);
        if (colorStateListValueOf != null) {
            yi2 yi2Var = new yi2(ou3VarB);
            yi2Var.p(colorStateListValueOf);
            yi2Var.l(context2);
            yi2Var.o(getElevation());
            setBackground(yi2Var);
        }
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.r1;
    }

    public Integer getNavigationIconTint() {
        return this.o1;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        uf2.O(this);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ImageView imageView;
        Drawable drawable;
        super.onLayout(z, i, i2, i3, i4);
        e1 e1Var = gb4.f;
        int i5 = 0;
        ImageView imageView2 = null;
        if (this.p1 || this.q1) {
            ArrayList arrayListL = gb4.L(this, getTitle());
            TextView textView = arrayListL.isEmpty() ? null : (TextView) Collections.min(arrayListL, e1Var);
            ArrayList arrayListL2 = gb4.L(this, getSubtitle());
            TextView textView2 = arrayListL2.isEmpty() ? null : (TextView) Collections.max(arrayListL2, e1Var);
            if (textView != null || textView2 != null) {
                int measuredWidth = getMeasuredWidth();
                int i6 = measuredWidth / 2;
                int paddingLeft = getPaddingLeft();
                int paddingRight = measuredWidth - getPaddingRight();
                for (int i7 = 0; i7 < getChildCount(); i7++) {
                    View childAt = getChildAt(i7);
                    if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                        if (childAt.getRight() < i6 && childAt.getRight() > paddingLeft) {
                            paddingLeft = childAt.getRight();
                        }
                        if (childAt.getLeft() > i6 && childAt.getLeft() < paddingRight) {
                            paddingRight = childAt.getLeft();
                        }
                    }
                }
                Pair pair = new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
                if (this.p1 && textView != null) {
                    z(textView, pair);
                }
                if (this.q1 && textView2 != null) {
                    z(textView2, pair);
                }
            }
        }
        Drawable logo = getLogo();
        if (logo != null) {
            while (true) {
                if (i5 >= getChildCount()) {
                    break;
                }
                View childAt2 = getChildAt(i5);
                if ((childAt2 instanceof ImageView) && (drawable = (imageView = (ImageView) childAt2).getDrawable()) != null && drawable.getConstantState() != null && drawable.getConstantState().equals(logo.getConstantState())) {
                    imageView2 = imageView;
                    break;
                }
                i5++;
            }
        }
        if (imageView2 != null) {
            Boolean bool = this.s1;
            if (bool != null) {
                imageView2.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.r1;
            if (scaleType != null) {
                imageView2.setScaleType(scaleType);
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        uf2.L(this, f);
    }

    public void setLogoAdjustViewBounds(boolean z) {
        Boolean bool = this.s1;
        if (bool == null || bool.booleanValue() != z) {
            this.s1 = Boolean.valueOf(z);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.r1 != scaleType) {
            this.r1 = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null && this.o1 != null) {
            drawable = drawable.mutate();
            drawable.setTint(this.o1.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i) {
        this.o1 = Integer.valueOf(i);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z) {
        if (this.q1 != z) {
            this.q1 = z;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z) {
        if (this.p1 != z) {
            this.p1 = z;
            requestLayout();
        }
    }

    public final void z(TextView textView, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = textView.getMeasuredWidth();
        int i = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i2 = measuredWidth2 + i;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i, 0), Math.max(i2 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i += iMax;
            i2 -= iMax;
            textView.measure(View.MeasureSpec.makeMeasureSpec(i2 - i, Pow2.MAX_POW2), textView.getMeasuredHeightAndState());
        }
        textView.layout(i, textView.getTop(), i2, textView.getBottom());
    }

    public MaterialToolbar(Context context) {
        this(context, null);
    }
}
