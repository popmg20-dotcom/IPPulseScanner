package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.getsurfboard.R;
import defpackage.a50;
import defpackage.c50;
import defpackage.d50;
import defpackage.dl;
import defpackage.el;
import defpackage.fx3;
import defpackage.l72;
import defpackage.m0;
import defpackage.qo4;
import defpackage.rc3;
import defpackage.rz1;
import defpackage.tt0;
import defpackage.xe;
import defpackage.y40;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class CircularProgressIndicator extends dl {
    public CircularProgressIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.circularProgressIndicatorStyle, R.style.Widget_MaterialComponents_CircularProgressIndicator);
        d50 d50Var = (d50) this.b;
        y40 y40Var = new y40(d50Var);
        Context context2 = getContext();
        rz1 rz1Var = new rz1(context2, d50Var, y40Var, d50Var.q == 1 ? new c50(context2, d50Var) : new a50(d50Var));
        rz1Var.G0 = qo4.a(context2.getResources(), R.drawable.ic_mtrl_arrow_circle, null);
        setIndeterminateDrawable(rz1Var);
        setProgressDrawable(new tt0(getContext(), d50Var, y40Var));
        this.D0 = true;
    }

    @Override // defpackage.dl
    public final el a(Context context, AttributeSet attributeSet) {
        d50 d50Var = new d50(context, attributeSet, R.attr.circularProgressIndicatorStyle, R.style.Widget_MaterialComponents_CircularProgressIndicator);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_size_medium);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_inset_medium);
        fx3.c(context, attributeSet, R.attr.circularProgressIndicatorStyle, R.style.Widget_MaterialComponents_CircularProgressIndicator);
        int[] iArr = rc3.j;
        fx3.e(context, attributeSet, iArr, R.attr.circularProgressIndicatorStyle, R.style.Widget_MaterialComponents_CircularProgressIndicator, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, R.attr.circularProgressIndicatorStyle, R.style.Widget_MaterialComponents_CircularProgressIndicator);
        d50Var.q = typedArrayObtainStyledAttributes.getInt(0, 0);
        d50Var.r = Math.max(l72.s(context, typedArrayObtainStyledAttributes, 4, dimensionPixelSize), d50Var.a * 2);
        d50Var.s = l72.s(context, typedArrayObtainStyledAttributes, 3, dimensionPixelSize2);
        d50Var.t = typedArrayObtainStyledAttributes.getInt(2, 0);
        d50Var.u = typedArrayObtainStyledAttributes.getBoolean(1, true);
        typedArrayObtainStyledAttributes.recycle();
        d50Var.d();
        return d50Var;
    }

    public int getIndeterminateAnimationType() {
        return ((d50) this.b).q;
    }

    public int getIndicatorDirection() {
        return ((d50) this.b).t;
    }

    public int getIndicatorInset() {
        return ((d50) this.b).s;
    }

    public int getIndicatorSize() {
        return ((d50) this.b).r;
    }

    public void setIndeterminateAnimationType(int i) {
        el elVar = this.b;
        if (((d50) elVar).q == i) {
            return;
        }
        if (f() && isIndeterminate()) {
            xe.q("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
            return;
        }
        ((d50) elVar).q = i;
        ((d50) elVar).d();
        m0 c50Var = i == 1 ? new c50(getContext(), (d50) elVar) : new a50((d50) elVar);
        rz1 indeterminateDrawable = getIndeterminateDrawable();
        indeterminateDrawable.F0 = c50Var;
        c50Var.a = indeterminateDrawable;
        c();
        invalidate();
    }

    public void setIndicatorDirection(int i) {
        ((d50) this.b).t = i;
        invalidate();
    }

    public void setIndicatorInset(int i) {
        el elVar = this.b;
        if (((d50) elVar).s != i) {
            ((d50) elVar).s = i;
            invalidate();
        }
    }

    public void setIndicatorSize(int i) {
        int iMax = Math.max(i, getTrackThickness() * 2);
        el elVar = this.b;
        if (((d50) elVar).r != iMax) {
            ((d50) elVar).r = iMax;
            ((d50) elVar).d();
            requestLayout();
            invalidate();
        }
    }

    @Override // defpackage.dl
    public void setTrackThickness(int i) {
        super.setTrackThickness(i);
        ((d50) this.b).d();
    }

    public CircularProgressIndicator(Context context) {
        this(context, null);
    }
}
