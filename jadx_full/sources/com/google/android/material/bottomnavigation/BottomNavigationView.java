package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.getsurfboard.R;
import defpackage.d7;
import defpackage.fo;
import defpackage.fx3;
import defpackage.go;
import defpackage.ho;
import defpackage.mp2;
import defpackage.n02;
import defpackage.rc3;
import defpackage.tj4;
import defpackage.up2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class BottomNavigationView extends up2 {
    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.bottomNavigationStyle, R.style.Widget_Design_BottomNavigationView);
        n02 n02VarW = fx3.w(getContext(), attributeSet, rc3.e, R.attr.bottomNavigationStyle, R.style.Widget_Design_BottomNavigationView, new int[0]);
        TypedArray typedArray = (TypedArray) n02VarW.z;
        setItemHorizontalTranslationEnabled(typedArray.getBoolean(2, true));
        if (typedArray.hasValue(0)) {
            setMinimumHeight(typedArray.getDimensionPixelSize(0, 0));
        }
        n02VarW.K();
        tj4.x(this, new d7(10));
    }

    @Override // defpackage.up2
    public final mp2 a(Context context) {
        return new fo(context);
    }

    @Override // defpackage.up2
    public int getMaxItemCount() {
        return 6;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int iMakeMeasureSpec;
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        if (View.MeasureSpec.getMode(i2) == 1073741824 || suggestedMinimumHeight <= 0) {
            iMakeMeasureSpec = i2;
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(View.MeasureSpec.getSize(i2), getPaddingBottom() + getPaddingTop() + suggestedMinimumHeight), Integer.MIN_VALUE);
        }
        super.onMeasure(i, iMakeMeasureSpec);
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            setMeasuredDimension(getMeasuredWidth(), Math.max(getMeasuredHeight(), getPaddingBottom() + getPaddingTop() + getSuggestedMinimumHeight()));
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        fo foVar = (fo) getMenuView();
        if (foVar.w1 != z) {
            foVar.setItemHorizontalTranslationEnabled(z);
            getPresenter().c(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(go goVar) {
        setOnItemReselectedListener(goVar);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(ho hoVar) {
        setOnItemSelectedListener(hoVar);
    }

    public BottomNavigationView(Context context) {
        this(context, null);
    }
}
