package com.google.android.material.navigationrail;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.getsurfboard.R;
import defpackage.ah4;
import defpackage.ch4;
import defpackage.fp2;
import defpackage.fx3;
import defpackage.ha1;
import defpackage.ip2;
import defpackage.lp2;
import defpackage.mp2;
import defpackage.n02;
import defpackage.nq2;
import defpackage.pq2;
import defpackage.q82;
import defpackage.rc3;
import defpackage.t8;
import defpackage.tj4;
import defpackage.up2;
import defpackage.w20;
import defpackage.xa1;
import io.netty.channel.internal.ChannelUtils;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class NavigationRailView extends up2 {
    public static final PathInterpolator R0 = new PathInterpolator(0.38f, 1.21f, 0.22f, 1.0f);
    public final int A0;
    public final int B0;
    public boolean C0;
    public final View D0;
    public final Boolean E0;
    public final Boolean F0;
    public final Boolean G0;
    public boolean H0;
    public int I0;
    public int J0;
    public int K0;
    public int L0;
    public int M0;
    public int N0;
    public int O0;
    public int P0;
    public final nq2 Q0;

    public NavigationRailView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.navigationRailStyle, R.style.Widget_MaterialComponents_NavigationRailView);
        this.E0 = null;
        this.F0 = null;
        this.G0 = null;
        this.H0 = false;
        this.J0 = -1;
        this.K0 = 0;
        this.L0 = 49;
        Context context2 = getContext();
        this.P0 = getContext().getResources().getDimensionPixelSize(R.dimen.m3_navigation_rail_expanded_item_spacing);
        this.O0 = 8388627;
        this.N0 = 1;
        n02 n02VarW = fx3.w(context2, attributeSet, rc3.H, R.attr.navigationRailStyle, R.style.Widget_MaterialComponents_NavigationRailView, new int[0]);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_rail_margin);
        TypedArray typedArray = (TypedArray) n02VarW.z;
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(1, dimensionPixelSize);
        int dimensionPixelSize3 = typedArray.getDimensionPixelSize(7, getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_rail_margin));
        int i = 14;
        boolean z = typedArray.getBoolean(14, false);
        setSubmenuDividersEnabled(typedArray.getBoolean(17, false));
        View view = (View) getMenuView();
        nq2 nq2Var = new nq2(getContext());
        nq2Var.b = 0;
        nq2Var.f = false;
        this.Q0 = nq2Var;
        nq2Var.setPaddingTop(dimensionPixelSize2);
        this.Q0.setScrollingEnabled(z);
        this.Q0.setClipChildren(false);
        this.Q0.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.Q0.addView(view);
        if (z) {
            ScrollView scrollView = new ScrollView(getContext());
            scrollView.setVerticalScrollBarEnabled(false);
            scrollView.addView(this.Q0);
            scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(scrollView);
        } else {
            addView(this.Q0);
        }
        int resourceId = typedArray.getResourceId(6, 0);
        if (resourceId != 0) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(resourceId, (ViewGroup) this, false);
            View view2 = this.D0;
            if (view2 != null) {
                this.Q0.removeView(view2);
                this.D0 = null;
            }
            this.D0 = viewInflate;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 49;
            layoutParams.bottomMargin = dimensionPixelSize3;
            this.Q0.addView(viewInflate, 0, layoutParams);
        }
        setMenuGravity(typedArray.getInt(10, 49));
        int dimensionPixelSize4 = typedArray.getDimensionPixelSize(8, -1);
        int dimensionPixelSize5 = typedArray.getDimensionPixelSize(8, -1);
        dimensionPixelSize4 = typedArray.hasValue(0) ? typedArray.getDimensionPixelSize(0, -1) : dimensionPixelSize4;
        dimensionPixelSize5 = typedArray.hasValue(3) ? typedArray.getDimensionPixelSize(3, -1) : dimensionPixelSize5;
        setCollapsedItemMinimumHeight(dimensionPixelSize4);
        setExpandedItemMinimumHeight(dimensionPixelSize5);
        this.A0 = typedArray.getDimensionPixelSize(5, context2.getResources().getDimensionPixelSize(R.dimen.m3_navigation_rail_min_expanded_width));
        this.B0 = typedArray.getDimensionPixelSize(4, context2.getResources().getDimensionPixelSize(R.dimen.m3_navigation_rail_max_expanded_width));
        if (typedArray.hasValue(13)) {
            this.E0 = Boolean.valueOf(typedArray.getBoolean(13, false));
        }
        if (typedArray.hasValue(11)) {
            this.F0 = Boolean.valueOf(typedArray.getBoolean(11, false));
        }
        if (typedArray.hasValue(12)) {
            this.G0 = Boolean.valueOf(typedArray.getBoolean(12, false));
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.m3_navigation_rail_item_padding_top_with_large_font);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.m3_navigation_rail_item_padding_bottom_with_large_font);
        float fB = t8.b(0.0f, 1.0f, 0.3f, 1.0f, context2.getResources().getConfiguration().fontScale - 1.0f);
        float fC = t8.c(getItemPaddingTop(), fB, dimensionPixelOffset);
        float fC2 = t8.c(getItemPaddingBottom(), fB, dimensionPixelOffset2);
        setItemPaddingTop(Math.round(fC));
        setItemPaddingBottom(Math.round(fC2));
        setCollapsedItemSpacing(typedArray.getDimensionPixelSize(9, 0));
        setExpanded(typedArray.getBoolean(2, false));
        n02VarW.K();
        tj4.x(this, new ha1(i, this));
    }

    private int getMaxChildWidth() {
        int childCount = getNavigationRailMenuView().getChildCount();
        int iMax = 0;
        for (int i = 0; i < childCount; i++) {
            View childAt = getNavigationRailMenuView().getChildAt(i);
            if (childAt.getVisibility() != 8 && !(childAt instanceof fp2)) {
                iMax = Math.max(iMax, childAt.getMeasuredWidth());
            }
        }
        return iMax;
    }

    private pq2 getNavigationRailMenuView() {
        return (pq2) getMenuView();
    }

    private void setExpanded(boolean z) {
        if (this.H0 == z) {
            return;
        }
        if (isLaidOut()) {
            w20 w20Var = new w20();
            w20Var.z = 500L;
            w20Var.A = R0;
            xa1 xa1Var = new xa1();
            xa1Var.z = 100L;
            xa1 xa1Var2 = new xa1();
            xa1Var2.z = 100L;
            q82 q82Var = new q82(0);
            xa1 xa1Var3 = new xa1();
            xa1Var3.z = 100L;
            int childCount = getNavigationRailMenuView().getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getNavigationRailMenuView().getChildAt(i);
                if (childAt instanceof ip2) {
                    ip2 ip2Var = (ip2) childAt;
                    w20Var.o(ip2Var.getLabelGroup());
                    w20Var.o(ip2Var.getExpandedLabelGroup());
                    if (this.H0) {
                        xa1Var2.b(ip2Var.getExpandedLabelGroup());
                        xa1Var.b(ip2Var.getLabelGroup());
                    } else {
                        xa1Var2.b(ip2Var.getLabelGroup());
                        xa1Var.b(ip2Var.getExpandedLabelGroup());
                    }
                    q82Var.b(ip2Var.getExpandedLabelGroup());
                }
                xa1Var3.b(childAt);
            }
            ch4 ch4Var = new ch4();
            ch4Var.Y(0);
            ch4Var.U(w20Var);
            ch4Var.U(xa1Var);
            ch4Var.U(q82Var);
            if (!this.H0) {
                ch4Var.U(xa1Var3);
            }
            ch4 ch4Var2 = new ch4();
            ch4Var2.Y(0);
            ch4Var2.U(xa1Var2);
            if (this.H0) {
                ch4Var2.U(xa1Var3);
            }
            ch4 ch4Var3 = new ch4();
            ch4Var3.Y(1);
            ch4Var3.U(ch4Var2);
            ch4Var3.U(ch4Var);
            ah4.a((ViewGroup) getParent(), ch4Var3);
        }
        this.H0 = z;
        int i2 = this.K0;
        int i3 = this.I0;
        int i4 = this.J0;
        int i5 = this.L0;
        if (z) {
            i2 = this.N0;
            i3 = this.P0;
            i4 = this.M0;
            i5 = this.O0;
        }
        getNavigationRailMenuView().setItemGravity(i5);
        super.setItemIconGravity(i2);
        getNavigationRailMenuView().setItemSpacing(i3);
        getNavigationRailMenuView().setItemMinimumHeight(i4);
        getNavigationRailMenuView().setExpanded(z);
    }

    @Override // defpackage.up2
    public final mp2 a(Context context) {
        return new pq2(context);
    }

    public int getCollapsedItemMinimumHeight() {
        return this.J0;
    }

    @Override // defpackage.up2
    public int getCollapsedMaxItemCount() {
        return 7;
    }

    public int getExpandedItemMinimumHeight() {
        return this.M0;
    }

    public View getHeaderView() {
        return this.D0;
    }

    @Override // defpackage.up2
    public int getItemGravity() {
        return getNavigationRailMenuView().getItemGravity();
    }

    @Override // defpackage.up2
    public int getItemIconGravity() {
        return getNavigationRailMenuView().getItemIconGravity();
    }

    public int getItemMinimumHeight() {
        return getNavigationRailMenuView().getItemMinimumHeight();
    }

    public int getItemSpacing() {
        return getNavigationRailMenuView().getItemSpacing();
    }

    @Override // defpackage.up2
    public int getMaxItemCount() {
        return ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    public boolean getSubmenuDividersEnabled() {
        return this.C0;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int iMakeMeasureSpec = (View.MeasureSpec.getMode(i) == 1073741824 || suggestedMinimumWidth <= 0) ? i : View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), getPaddingRight() + getPaddingLeft() + suggestedMinimumWidth), Pow2.MAX_POW2);
        if (this.H0) {
            measureChild(getNavigationRailMenuView(), i, i2);
            View view = this.D0;
            if (view != null) {
                measureChild(view, i, i2);
            }
            int maxChildWidth = getMaxChildWidth();
            int iMin = Math.min(this.A0, View.MeasureSpec.getSize(i));
            if (View.MeasureSpec.getMode(i) != 1073741824) {
                int iMax = Math.max(maxChildWidth, iMin);
                if (view != null) {
                    iMax = Math.max(iMax, view.getMeasuredWidth());
                }
                i = View.MeasureSpec.makeMeasureSpec(Math.max(getSuggestedMinimumWidth(), Math.min(iMax, this.B0)), Pow2.MAX_POW2);
            }
            if (getItemActiveIndicatorExpandedWidth() == -1) {
                pq2 navigationRailMenuView = getNavigationRailMenuView();
                int size = View.MeasureSpec.getSize(i);
                lp2[] lp2VarArr = navigationRailMenuView.A0;
                if (lp2VarArr != null) {
                    for (lp2 lp2Var : lp2VarArr) {
                        if (lp2Var instanceof ip2) {
                            ((ip2) lp2Var).j(size);
                        }
                    }
                }
            }
            iMakeMeasureSpec = i;
        }
        super.onMeasure(iMakeMeasureSpec, i2);
        nq2 nq2Var = this.Q0;
        if (nq2Var.getMeasuredHeight() < getMeasuredHeight()) {
            measureChild(nq2Var, iMakeMeasureSpec, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), Pow2.MAX_POW2));
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setCollapsedItemMinimumHeight(int i) {
        this.J0 = i;
        if (this.H0) {
            return;
        }
        ((pq2) getMenuView()).setItemMinimumHeight(i);
    }

    public void setCollapsedItemSpacing(int i) {
        this.I0 = i;
        if (this.H0) {
            return;
        }
        getNavigationRailMenuView().setItemSpacing(i);
    }

    public void setExpandedItemMinimumHeight(int i) {
        this.M0 = i;
        if (this.H0) {
            ((pq2) getMenuView()).setItemMinimumHeight(i);
        }
    }

    @Override // defpackage.up2
    public void setItemGravity(int i) {
        this.L0 = i;
        this.O0 = i;
        super.setItemGravity(i);
    }

    @Override // defpackage.up2
    public void setItemIconGravity(int i) {
        this.K0 = i;
        this.N0 = i;
        super.setItemIconGravity(i);
    }

    public void setItemMinimumHeight(int i) {
        this.J0 = i;
        this.M0 = i;
        ((pq2) getMenuView()).setItemMinimumHeight(i);
    }

    public void setItemSpacing(int i) {
        this.I0 = i;
        this.P0 = i;
        getNavigationRailMenuView().setItemSpacing(i);
    }

    public void setMenuGravity(int i) {
        getNavigationRailMenuView().setMenuGravity(i);
    }

    public void setSubmenuDividersEnabled(boolean z) {
        if (this.C0 == z) {
            return;
        }
        this.C0 = z;
        getNavigationRailMenuView().setSubmenuDividersEnabled(z);
    }

    public NavigationRailView(Context context) {
        this(context, null);
    }
}
