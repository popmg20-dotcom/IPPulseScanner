package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.getsurfboard.R;
import defpackage.a71;
import defpackage.ar4;
import defpackage.ba4;
import defpackage.c23;
import defpackage.ca4;
import defpackage.cd3;
import defpackage.co4;
import defpackage.d23;
import defpackage.e21;
import defpackage.ea4;
import defpackage.ek0;
import defpackage.fa4;
import defpackage.fx3;
import defpackage.ga4;
import defpackage.hz2;
import defpackage.io;
import defpackage.l72;
import defpackage.p84;
import defpackage.rc3;
import defpackage.t8;
import defpackage.tj4;
import defpackage.uf2;
import defpackage.v9;
import defpackage.vo;
import defpackage.yi2;
import io.netty.channel.internal.ChannelUtils;
import io.sentry.android.core.a1;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class TabLayout extends HorizontalScrollView {
    public static final d23 j1 = new d23(16);
    public final ea4 A;
    public final int A0;
    public final int B0;
    public final int C0;
    public final int D0;
    public final int E0;
    public ColorStateList F0;
    public ColorStateList G0;
    public ColorStateList H0;
    public Drawable I0;
    public int J0;
    public final float K0;
    public final float L0;
    public final float M0;
    public final int N0;
    public int O0;
    public final int P0;
    public final int Q0;
    public final int R0;
    public final int S0;
    public int T0;
    public final int U0;
    public int V0;
    public int W0;
    public boolean X0;
    public boolean Y0;
    public int Z0;
    public int a1;
    public int b;
    public boolean b1;
    public p84 c1;
    public final TimeInterpolator d1;
    public ba4 e1;
    public final ArrayList f;
    public final ArrayList f1;
    public ValueAnimator g1;
    public int h1;
    public final c23 i1;
    public final int y0;
    public fa4 z;
    public final int z0;

    public TabLayout(Context context, AttributeSet attributeSet) {
        int resourceId;
        super(co4.d0(context, attributeSet, R.attr.tabStyle, R.style.Widget_Design_TabLayout), attributeSet, R.attr.tabStyle);
        this.b = -1;
        this.f = new ArrayList();
        this.E0 = -1;
        this.J0 = 0;
        this.O0 = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        this.Z0 = -1;
        this.f1 = new ArrayList();
        this.i1 = new c23(12);
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        ea4 ea4Var = new ea4(this, context2);
        this.A = ea4Var;
        super.addView(ea4Var, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray typedArrayV = fx3.v(context2, attributeSet, rc3.O, R.attr.tabStyle, R.style.Widget_Design_TabLayout, 24);
        ColorStateList colorStateListH = v9.h(getBackground());
        if (colorStateListH != null) {
            yi2 yi2Var = new yi2();
            yi2Var.p(colorStateListH);
            yi2Var.l(context2);
            yi2Var.o(getElevation());
            setBackground(yi2Var);
        }
        setSelectedTabIndicator(l72.u(context2, typedArrayV, 5));
        setSelectedTabIndicatorColor(typedArrayV.getColor(8, 0));
        ea4Var.b(typedArrayV.getDimensionPixelSize(11, -1));
        setSelectedTabIndicatorGravity(typedArrayV.getInt(10, 0));
        setTabIndicatorAnimationMode(typedArrayV.getInt(7, 0));
        setTabIndicatorFullWidth(typedArrayV.getBoolean(9, true));
        int dimensionPixelSize = typedArrayV.getDimensionPixelSize(16, 0);
        this.B0 = dimensionPixelSize;
        this.A0 = dimensionPixelSize;
        this.z0 = dimensionPixelSize;
        this.y0 = dimensionPixelSize;
        this.y0 = typedArrayV.getDimensionPixelSize(19, dimensionPixelSize);
        this.z0 = typedArrayV.getDimensionPixelSize(20, dimensionPixelSize);
        this.A0 = typedArrayV.getDimensionPixelSize(18, dimensionPixelSize);
        this.B0 = typedArrayV.getDimensionPixelSize(17, dimensionPixelSize);
        if (ek0.B(context2, R.attr.isMaterial3Theme, false)) {
            this.C0 = R.attr.textAppearanceTitleSmall;
        } else {
            this.C0 = R.attr.textAppearanceButton;
        }
        int resourceId2 = typedArrayV.getResourceId(24, R.style.TextAppearance_Design_Tab);
        this.D0 = resourceId2;
        int[] iArr = cd3.x;
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId2, iArr);
        try {
            this.K0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
            this.F0 = l72.r(context2, typedArrayObtainStyledAttributes, 3);
            typedArrayObtainStyledAttributes.recycle();
            if (typedArrayV.hasValue(22)) {
                resourceId = typedArrayV.getResourceId(22, resourceId2);
                this.E0 = resourceId;
            } else {
                resourceId = -1;
            }
            int[] iArr2 = HorizontalScrollView.EMPTY_STATE_SET;
            int[] iArr3 = HorizontalScrollView.SELECTED_STATE_SET;
            if (resourceId != -1) {
                typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId, iArr);
                try {
                    this.L0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, (int) r6);
                    ColorStateList colorStateListR = l72.r(context2, typedArrayObtainStyledAttributes, 3);
                    if (colorStateListR != null) {
                        this.F0 = new ColorStateList(new int[][]{iArr3, iArr2}, new int[]{colorStateListR.getColorForState(new int[]{android.R.attr.state_selected}, colorStateListR.getDefaultColor()), this.F0.getDefaultColor()});
                    }
                } finally {
                }
            }
            if (typedArrayV.hasValue(25)) {
                this.F0 = l72.r(context2, typedArrayV, 25);
            }
            if (typedArrayV.hasValue(23)) {
                this.F0 = new ColorStateList(new int[][]{iArr3, iArr2}, new int[]{typedArrayV.getColor(23, 0), this.F0.getDefaultColor()});
            }
            this.G0 = l72.r(context2, typedArrayV, 3);
            tj4.V(typedArrayV.getInt(4, -1), null);
            this.H0 = l72.r(context2, typedArrayV, 21);
            this.U0 = typedArrayV.getInt(6, 300);
            this.d1 = l72.W(context2, R.attr.motionEasingEmphasizedInterpolator, t8.b);
            this.P0 = typedArrayV.getDimensionPixelSize(14, -1);
            this.Q0 = typedArrayV.getDimensionPixelSize(13, -1);
            this.N0 = typedArrayV.getResourceId(0, 0);
            this.S0 = typedArrayV.getDimensionPixelSize(1, 0);
            this.W0 = typedArrayV.getInt(15, 1);
            this.T0 = typedArrayV.getInt(2, 0);
            this.X0 = typedArrayV.getBoolean(12, false);
            this.b1 = typedArrayV.getBoolean(26, false);
            typedArrayV.recycle();
            Resources resources = getResources();
            this.M0 = resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            this.R0 = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
            b();
        } finally {
        }
    }

    private int getDefaultHeight() {
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i = this.P0;
        if (i != -1) {
            return i;
        }
        int i2 = this.W0;
        if (i2 == 0 || i2 == 2) {
            return this.R0;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.A.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i) {
        ea4 ea4Var = this.A;
        int childCount = ea4Var.getChildCount();
        if (i < childCount) {
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = ea4Var.getChildAt(i2);
                if ((i2 != i || childAt.isSelected()) && (i2 == i || !childAt.isSelected())) {
                    childAt.setSelected(i2 == i);
                    childAt.setActivated(i2 == i);
                } else {
                    childAt.setSelected(i2 == i);
                    childAt.setActivated(i2 == i);
                    if (childAt instanceof ga4) {
                        ((ga4) childAt).f();
                    }
                }
                i2++;
            }
        }
    }

    public final void a(int i) {
        if (i == -1) {
            return;
        }
        if (getWindowToken() != null && isLaidOut()) {
            ea4 ea4Var = this.A;
            int childCount = ea4Var.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (ea4Var.getChildAt(i2).getWidth() > 0) {
                }
            }
            int scrollX = getScrollX();
            int iC = c(i, 0.0f);
            if (scrollX != iC) {
                d();
                this.g1.setIntValues(scrollX, iC);
                this.g1.start();
            }
            ValueAnimator valueAnimator = ea4Var.b;
            if (valueAnimator != null && valueAnimator.isRunning() && ea4Var.f.b != i) {
                ea4Var.b.cancel();
            }
            ea4Var.d(i, this.U0, true);
            return;
        }
        h(i, 0.0f, true, true, true);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    public final void b() {
        int i = this.W0;
        int iMax = (i == 0 || i == 2) ? Math.max(0, this.S0 - this.y0) : 0;
        ea4 ea4Var = this.A;
        ea4Var.setPaddingRelative(iMax, 0, 0, 0);
        int i2 = this.W0;
        if (i2 == 0) {
            int i3 = this.T0;
            if (i3 == 0) {
                a1.n("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
            } else if (i3 == 1) {
                ea4Var.setGravity(1);
            } else if (i3 == 2) {
            }
            ea4Var.setGravity(8388611);
        } else if (i2 == 1 || i2 == 2) {
            if (this.T0 == 2) {
                a1.n("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            ea4Var.setGravity(1);
        }
        i(true);
    }

    public final int c(int i, float f) {
        ea4 ea4Var;
        View childAt;
        int i2 = this.W0;
        if ((i2 != 0 && i2 != 2) || (childAt = (ea4Var = this.A).getChildAt(i)) == null) {
            return 0;
        }
        int i3 = i + 1;
        View childAt2 = i3 < ea4Var.getChildCount() ? ea4Var.getChildAt(i3) : null;
        int width = childAt.getWidth();
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = ((width / 2) + childAt.getLeft()) - (getWidth() / 2);
        int i4 = (int) ((width + width2) * 0.5f * f);
        return getLayoutDirection() == 0 ? left + i4 : left - i4;
    }

    public final void d() {
        if (this.g1 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.g1 = valueAnimator;
            valueAnimator.setInterpolator(this.d1);
            this.g1.setDuration(this.U0);
            this.g1.addUpdateListener(new io(5, this));
        }
    }

    public final fa4 e() {
        fa4 fa4Var = (fa4) j1.a();
        if (fa4Var == null) {
            fa4Var = new fa4();
            fa4Var.b = -1;
        }
        fa4Var.d = this;
        c23 c23Var = this.i1;
        ga4 ga4Var = c23Var != null ? (ga4) c23Var.a() : null;
        if (ga4Var == null) {
            ga4Var = new ga4(this, getContext());
        }
        ga4Var.setTab(fa4Var);
        ga4Var.setFocusable(true);
        ga4Var.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(null)) {
            ga4Var.setContentDescription(fa4Var.a);
        } else {
            ga4Var.setContentDescription(null);
        }
        fa4Var.e = ga4Var;
        return fa4Var;
    }

    public final void f() {
        ea4 ea4Var = this.A;
        int childCount = ea4Var.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                break;
            }
            ga4 ga4Var = (ga4) ea4Var.getChildAt(childCount);
            ea4Var.removeViewAt(childCount);
            if (ga4Var != null) {
                ga4Var.setTab(null);
                ga4Var.setSelected(false);
                this.i1.c(ga4Var);
            }
            requestLayout();
        }
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            fa4 fa4Var = (fa4) it.next();
            it.remove();
            fa4Var.d = null;
            fa4Var.e = null;
            fa4Var.a = null;
            fa4Var.b = -1;
            fa4Var.c = null;
            j1.c(fa4Var);
        }
        this.z = null;
    }

    public final void g(fa4 fa4Var, boolean z) {
        TabLayout tabLayout;
        fa4 fa4Var2 = this.z;
        ArrayList arrayList = this.f1;
        if (fa4Var2 == fa4Var) {
            if (fa4Var2 != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((ba4) arrayList.get(size)).getClass();
                }
                a(fa4Var.b);
                return;
            }
            return;
        }
        int i = fa4Var != null ? fa4Var.b : -1;
        if (z) {
            if ((fa4Var2 == null || fa4Var2.b == -1) && i != -1) {
                tabLayout = this;
                tabLayout.h(i, 0.0f, true, true, true);
            } else {
                tabLayout = this;
                tabLayout.a(i);
            }
            if (i != -1) {
                tabLayout.setSelectedTabView(i);
            }
        } else {
            tabLayout = this;
        }
        tabLayout.z = fa4Var;
        if (fa4Var2 != null && fa4Var2.d != null) {
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                ((ba4) arrayList.get(size2)).getClass();
            }
        }
        if (fa4Var != null) {
            for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                ((ba4) arrayList.get(size3)).a(fa4Var);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        fa4 fa4Var = this.z;
        if (fa4Var != null) {
            return fa4Var.b;
        }
        return -1;
    }

    public int getTabCount() {
        return this.f.size();
    }

    public int getTabGravity() {
        return this.T0;
    }

    public ColorStateList getTabIconTint() {
        return this.G0;
    }

    public int getTabIndicatorAnimationMode() {
        return this.a1;
    }

    public int getTabIndicatorGravity() {
        return this.V0;
    }

    public int getTabMaxWidth() {
        return this.O0;
    }

    public int getTabMode() {
        return this.W0;
    }

    public ColorStateList getTabRippleColor() {
        return this.H0;
    }

    public Drawable getTabSelectedIndicator() {
        return this.I0;
    }

    public ColorStateList getTabTextColors() {
        return this.F0;
    }

    public final void h(int i, float f, boolean z, boolean z2, boolean z3) {
        float f2 = i + f;
        int iRound = Math.round(f2);
        if (iRound >= 0) {
            ea4 ea4Var = this.A;
            if (iRound >= ea4Var.getChildCount()) {
                return;
            }
            if (z2) {
                ea4Var.f.b = Math.round(f2);
                ValueAnimator valueAnimator = ea4Var.b;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    ea4Var.b.cancel();
                }
                ea4Var.c(ea4Var.getChildAt(i), ea4Var.getChildAt(i + 1), f);
            }
            ValueAnimator valueAnimator2 = this.g1;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.g1.cancel();
            }
            int iC = c(i, f);
            int scrollX = getScrollX();
            boolean z4 = (i < getSelectedTabPosition() && iC >= scrollX) || (i > getSelectedTabPosition() && iC <= scrollX) || i == getSelectedTabPosition();
            if (getLayoutDirection() == 1) {
                z4 = (i < getSelectedTabPosition() && iC <= scrollX) || (i > getSelectedTabPosition() && iC >= scrollX) || i == getSelectedTabPosition();
            }
            if (z4 || this.h1 == 1 || z3) {
                if (i < 0) {
                    iC = 0;
                }
                scrollTo(iC, 0);
            }
            if (z) {
                setSelectedTabView(iRound);
            }
        }
    }

    public final void i(boolean z) {
        int i = 0;
        while (true) {
            ea4 ea4Var = this.A;
            if (i >= ea4Var.getChildCount()) {
                return;
            }
            View childAt = ea4Var.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            if (this.W0 == 1 && this.T0 == 0) {
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
            } else {
                layoutParams.width = -2;
                layoutParams.weight = 0.0f;
            }
            if (z) {
                childAt.requestLayout();
            }
            i++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        uf2.O(this);
        getParent();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int i = 0;
        while (true) {
            ea4 ea4Var = this.A;
            if (i >= ea4Var.getChildCount()) {
                super.onDraw(canvas);
                return;
            }
            View childAt = ea4Var.getChildAt(i);
            if (childAt instanceof ga4) {
                ga4 ga4Var = (ga4) childAt;
                int i2 = ga4.F0;
                Drawable drawable = ga4Var.C0;
                if (drawable != null) {
                    drawable.setBounds(ga4Var.getLeft(), ga4Var.getTop(), ga4Var.getRight(), ga4Var.getBottom());
                    ga4Var.C0.draw(canvas);
                }
            }
            i++;
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, getTabCount(), false, 1));
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return (getTabMode() == 0 || getTabMode() == 2) && super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = defpackage.tj4.y(r0, r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 0
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 1
            if (r1 == r2) goto L2e
            if (r1 == 0) goto L1f
            goto L41
        L1f:
            int r8 = r6.getPaddingTop()
            int r8 = r8 + r0
            int r0 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r4)
            goto L41
        L2e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L41
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L41
            android.view.View r1 = r6.getChildAt(r3)
            r1.setMinimumHeight(r0)
        L41:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L5f
            int r1 = r6.Q0
            if (r1 <= 0) goto L50
            goto L5d
        L50:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = defpackage.tj4.y(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L5d:
            r6.O0 = r1
        L5f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto Laa
            android.view.View r7 = r6.getChildAt(r3)
            int r0 = r6.W0
            if (r0 == 0) goto L82
            if (r0 == r5) goto L76
            r1 = 2
            if (r0 == r1) goto L82
            goto Laa
        L76:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L81
            goto L8c
        L81:
            return
        L82:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto Laa
        L8c:
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r1 = r1 + r0
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            int r0 = r0.height
            int r8 = android.view.ViewGroup.getChildMeasureSpec(r8, r1, r0)
            int r6 = r6.getMeasuredWidth()
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r4)
            r7.measure(r6, r8)
        Laa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 8 || getTabMode() == 0 || getTabMode() == 2) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        uf2.L(this, f);
    }

    public void setInlineLabel(boolean z) {
        if (this.X0 == z) {
            return;
        }
        this.X0 = z;
        int i = 0;
        while (true) {
            ea4 ea4Var = this.A;
            if (i >= ea4Var.getChildCount()) {
                b();
                return;
            }
            View childAt = ea4Var.getChildAt(i);
            if (childAt instanceof ga4) {
                ga4 ga4Var = (ga4) childAt;
                ga4Var.setOrientation(!ga4Var.E0.X0 ? 1 : 0);
                TextView textView = ga4Var.A0;
                if (textView == null && ga4Var.B0 == null) {
                    ga4Var.g(ga4Var.f, ga4Var.z, true);
                } else {
                    ga4Var.g(textView, ga4Var.B0, false);
                }
            }
            i++;
        }
    }

    public void setInlineLabelResource(int i) {
        setInlineLabel(getResources().getBoolean(i));
    }

    @Deprecated
    public void setOnTabSelectedListener(ba4 ba4Var) {
        ba4 ba4Var2 = this.e1;
        ArrayList arrayList = this.f1;
        if (ba4Var2 != null) {
            arrayList.remove(ba4Var2);
        }
        this.e1 = ba4Var;
        if (ba4Var == null || arrayList.contains(ba4Var)) {
            return;
        }
        arrayList.add(ba4Var);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        d();
        this.g1.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        Drawable drawableMutate = drawable.mutate();
        this.I0 = drawableMutate;
        int i = this.J0;
        if (i != 0) {
            drawableMutate.setTint(i);
        } else {
            drawableMutate.setTintList(null);
        }
        int intrinsicHeight = this.Z0;
        if (intrinsicHeight == -1) {
            intrinsicHeight = this.I0.getIntrinsicHeight();
        }
        this.A.b(intrinsicHeight);
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.J0 = i;
        Drawable drawable = this.I0;
        if (i != 0) {
            drawable.setTint(i);
        } else {
            drawable.setTintList(null);
        }
        i(false);
    }

    public void setSelectedTabIndicatorGravity(int i) {
        if (this.V0 != i) {
            this.V0 = i;
            this.A.postInvalidateOnAnimation();
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i) {
        this.Z0 = i;
        this.A.b(i);
    }

    public void setTabGravity(int i) {
        if (this.T0 != i) {
            this.T0 = i;
            b();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.G0 != colorStateList) {
            this.G0 = colorStateList;
            ArrayList arrayList = this.f;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ga4 ga4Var = ((fa4) arrayList.get(i)).e;
                if (ga4Var != null) {
                    ga4Var.d();
                }
            }
        }
    }

    public void setTabIconTintResource(int i) {
        setTabIconTint(v9.g(getContext(), i));
    }

    public void setTabIndicatorAnimationMode(int i) {
        this.a1 = i;
        if (i == 0) {
            this.c1 = new p84(1);
            return;
        }
        if (i == 1) {
            this.c1 = new e21(0);
        } else if (i == 2) {
            this.c1 = new e21(1);
        } else {
            a71.d(i, " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.Y0 = z;
        int i = ea4.z;
        ea4 ea4Var = this.A;
        ea4Var.a(ea4Var.f.getSelectedTabPosition());
        ea4Var.postInvalidateOnAnimation();
    }

    public void setTabMode(int i) {
        if (i != this.W0) {
            this.W0 = i;
            b();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.H0 == colorStateList) {
            return;
        }
        this.H0 = colorStateList;
        int i = 0;
        while (true) {
            ea4 ea4Var = this.A;
            if (i >= ea4Var.getChildCount()) {
                return;
            }
            View childAt = ea4Var.getChildAt(i);
            if (childAt instanceof ga4) {
                Context context = getContext();
                int i2 = ga4.F0;
                ((ga4) childAt).e(context);
            }
            i++;
        }
    }

    public void setTabRippleColorResource(int i) {
        setTabRippleColor(v9.g(getContext(), i));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.F0 != colorStateList) {
            this.F0 = colorStateList;
            ArrayList arrayList = this.f;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ga4 ga4Var = ((fa4) arrayList.get(i)).e;
                if (ga4Var != null) {
                    ga4Var.d();
                }
            }
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(hz2 hz2Var) {
        f();
    }

    public void setUnboundedRipple(boolean z) {
        if (this.b1 == z) {
            return;
        }
        this.b1 = z;
        int i = 0;
        while (true) {
            ea4 ea4Var = this.A;
            if (i >= ea4Var.getChildCount()) {
                return;
            }
            View childAt = ea4Var.getChildAt(i);
            if (childAt instanceof ga4) {
                Context context = getContext();
                int i2 = ga4.F0;
                ((ga4) childAt).e(context);
            }
            i++;
        }
    }

    public void setUnboundedRippleResource(int i) {
        setUnboundedRipple(getResources().getBoolean(i));
    }

    public void setupWithViewPager(ar4 ar4Var) {
        f();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    @Deprecated
    public void setOnTabSelectedListener(ca4 ca4Var) {
        setOnTabSelectedListener((ba4) ca4Var);
    }

    public void setSelectedTabIndicator(int i) {
        if (i != 0) {
            setSelectedTabIndicator(vo.r(getContext(), i));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    public TabLayout(Context context) {
        this(context, null);
    }
}
