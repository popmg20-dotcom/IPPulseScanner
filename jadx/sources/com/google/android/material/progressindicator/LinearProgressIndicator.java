package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import com.getsurfboard.R;
import defpackage.dl;
import defpackage.eb2;
import defpackage.el;
import defpackage.fx3;
import defpackage.rc3;
import defpackage.rz1;
import defpackage.tt0;
import defpackage.va2;
import defpackage.wa2;
import defpackage.xe;
import defpackage.ya2;
import defpackage.zx0;
import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class LinearProgressIndicator extends dl {
    public LinearProgressIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.linearProgressIndicatorStyle, R.style.Widget_MaterialComponents_LinearProgressIndicator);
        eb2 eb2Var = (eb2) this.b;
        va2 va2Var = new va2(eb2Var);
        va2Var.f = 300.0f;
        va2Var.o = new Pair(new zx0(), new zx0());
        Context context2 = getContext();
        setIndeterminateDrawable(new rz1(context2, eb2Var, va2Var, eb2Var.q == 0 ? new wa2(eb2Var) : new ya2(context2, eb2Var)));
        setProgressDrawable(new tt0(getContext(), eb2Var, va2Var));
        this.D0 = true;
    }

    @Override // defpackage.dl
    public final el a(Context context, AttributeSet attributeSet) {
        eb2 eb2Var = new eb2(context, attributeSet, R.attr.linearProgressIndicatorStyle, R.style.Widget_MaterialComponents_LinearProgressIndicator);
        fx3.c(context, attributeSet, R.attr.linearProgressIndicatorStyle, R.style.Widget_MaterialComponents_LinearProgressIndicator);
        int[] iArr = rc3.q;
        fx3.e(context, attributeSet, iArr, R.attr.linearProgressIndicatorStyle, R.style.Widget_MaterialComponents_LinearProgressIndicator, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, R.attr.linearProgressIndicatorStyle, R.style.Widget_MaterialComponents_LinearProgressIndicator);
        eb2Var.q = typedArrayObtainStyledAttributes.getInt(0, 1);
        eb2Var.r = typedArrayObtainStyledAttributes.getInt(1, 0);
        eb2Var.t = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, 0);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            eb2Var.u = Integer.valueOf(typedArrayObtainStyledAttributes.getDimensionPixelSize(3, 0));
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(2);
        if (typedValuePeekValue != null) {
            int i = typedValuePeekValue.type;
            if (i == 5) {
                eb2Var.v = Math.min(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArrayObtainStyledAttributes.getResources().getDisplayMetrics()), eb2Var.a / 2);
                eb2Var.x = false;
                eb2Var.y = true;
            } else if (i == 6) {
                eb2Var.w = Math.min(typedValuePeekValue.getFraction(1.0f, 1.0f), 0.5f);
                eb2Var.x = true;
                eb2Var.y = true;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        eb2Var.d();
        eb2Var.s = eb2Var.r == 1;
        return eb2Var;
    }

    @Override // defpackage.dl
    public final void d(int i) {
        el elVar = this.b;
        if (elVar != null && ((eb2) elVar).q == 0 && isIndeterminate()) {
            return;
        }
        super.d(i);
    }

    public int getIndeterminateAnimationType() {
        return ((eb2) this.b).q;
    }

    public int getIndicatorDirection() {
        return ((eb2) this.b).r;
    }

    public int getTrackInnerCornerRadius() {
        return ((eb2) this.b).v;
    }

    public Integer getTrackStopIndicatorPadding() {
        return ((eb2) this.b).u;
    }

    public int getTrackStopIndicatorSize() {
        return ((eb2) this.b).t;
    }

    @Override // defpackage.dl, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        el elVar = this.b;
        eb2 eb2Var = (eb2) elVar;
        boolean z2 = true;
        if (((eb2) elVar).r != 1 && ((getLayoutDirection() != 1 || ((eb2) elVar).r != 2) && (getLayoutDirection() != 0 || ((eb2) elVar).r != 3))) {
            z2 = false;
        }
        eb2Var.s = z2;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingRight = i - (getPaddingRight() + getPaddingLeft());
        int paddingBottom = i2 - (getPaddingBottom() + getPaddingTop());
        rz1 indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingRight, paddingBottom);
        }
        tt0 progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingRight, paddingBottom);
        }
    }

    public void setIndeterminateAnimationType(int i) {
        el elVar = this.b;
        if (((eb2) elVar).q == i) {
            return;
        }
        if (f() && isIndeterminate()) {
            xe.q("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
            return;
        }
        ((eb2) elVar).q = i;
        ((eb2) elVar).d();
        if (i == 0) {
            rz1 indeterminateDrawable = getIndeterminateDrawable();
            wa2 wa2Var = new wa2((eb2) elVar);
            indeterminateDrawable.F0 = wa2Var;
            wa2Var.a = indeterminateDrawable;
        } else {
            rz1 indeterminateDrawable2 = getIndeterminateDrawable();
            ya2 ya2Var = new ya2(getContext(), (eb2) elVar);
            indeterminateDrawable2.F0 = ya2Var;
            ya2Var.a = indeterminateDrawable2;
        }
        c();
        invalidate();
    }

    @Override // defpackage.dl
    public void setIndicatorColor(int... iArr) {
        super.setIndicatorColor(iArr);
        ((eb2) this.b).d();
    }

    public void setIndicatorDirection(int i) {
        el elVar = this.b;
        ((eb2) elVar).r = i;
        eb2 eb2Var = (eb2) elVar;
        boolean z = true;
        if (i != 1 && ((getLayoutDirection() != 1 || ((eb2) elVar).r != 2) && (getLayoutDirection() != 0 || i != 3))) {
            z = false;
        }
        eb2Var.s = z;
        invalidate();
    }

    @Override // defpackage.dl
    public void setTrackCornerRadius(int i) {
        super.setTrackCornerRadius(i);
        ((eb2) this.b).d();
        invalidate();
    }

    public void setTrackInnerCornerRadius(int i) {
        el elVar = this.b;
        if (((eb2) elVar).v != i) {
            ((eb2) elVar).v = Math.round(Math.min(i, ((eb2) elVar).a / 2.0f));
            ((eb2) elVar).x = false;
            ((eb2) elVar).y = true;
            ((eb2) elVar).d();
            invalidate();
        }
    }

    public void setTrackInnerCornerRadiusFraction(float f) {
        el elVar = this.b;
        if (((eb2) elVar).w != f) {
            ((eb2) elVar).w = Math.min(f, 0.5f);
            ((eb2) elVar).x = true;
            ((eb2) elVar).y = true;
            ((eb2) elVar).d();
            invalidate();
        }
    }

    public void setTrackStopIndicatorPadding(Integer num) {
        el elVar = this.b;
        if (Objects.equals(((eb2) elVar).u, num)) {
            return;
        }
        ((eb2) elVar).u = num;
        invalidate();
    }

    public void setTrackStopIndicatorSize(int i) {
        el elVar = this.b;
        if (((eb2) elVar).t != i) {
            ((eb2) elVar).t = i;
            ((eb2) elVar).d();
            invalidate();
        }
    }

    public LinearProgressIndicator(Context context) {
        this(context, null);
    }
}
