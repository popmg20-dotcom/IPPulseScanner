package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.google.android.material.internal.NavigationMenuView;
import defpackage.a64;
import defpackage.ai2;
import defpackage.av3;
import defpackage.bi2;
import defpackage.bq2;
import defpackage.cj2;
import defpackage.co4;
import defpackage.cv3;
import defpackage.eq2;
import defpackage.fx3;
import defpackage.jl3;
import defpackage.jq2;
import defpackage.l72;
import defpackage.mp4;
import defpackage.mq2;
import defpackage.n02;
import defpackage.nq3;
import defpackage.oj1;
import defpackage.ou3;
import defpackage.qq2;
import defpackage.rc3;
import defpackage.rq2;
import defpackage.sb;
import defpackage.sk2;
import defpackage.uf2;
import defpackage.v9;
import defpackage.wn1;
import defpackage.wp4;
import defpackage.xe;
import defpackage.yh;
import defpackage.yi2;
import defpackage.zu3;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class NavigationView extends nq3 implements ai2 {
    public static final int[] P0 = {R.attr.state_checked};
    public static final int[] Q0 = {-16842910};
    public final bq2 B0;
    public final mq2 C0;
    public qq2 D0;
    public final int E0;
    public final int[] F0;
    public a64 G0;
    public final sb H0;
    public boolean I0;
    public boolean J0;
    public boolean K0;
    public boolean L0;
    public final zu3 M0;
    public final cj2 N0;
    public final n02 O0;

    /* JADX WARN: Illegal instructions before constructor call */
    public NavigationView(Context context, AttributeSet attributeSet) {
        int i;
        InsetDrawable insetDrawable;
        Context contextD0 = co4.d0(context, attributeSet, com.getsurfboard.R.attr.navigationViewStyle, com.getsurfboard.R.style.Widget_Design_NavigationView);
        super(contextD0, attributeSet, com.getsurfboard.R.attr.navigationViewStyle);
        this.z = new Rect();
        this.A = true;
        this.y0 = true;
        this.z0 = true;
        this.A0 = true;
        TypedArray typedArrayV = fx3.v(contextD0, attributeSet, rc3.J, com.getsurfboard.R.attr.navigationViewStyle, com.getsurfboard.R.style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.b = typedArrayV.getDrawable(0);
        typedArrayV.recycle();
        setWillNotDraw(true);
        oj1 oj1Var = new oj1(25, this);
        WeakHashMap weakHashMap = wp4.a;
        mp4.c(this, oj1Var);
        mq2 mq2Var = new mq2();
        this.C0 = mq2Var;
        this.F0 = new int[2];
        this.I0 = true;
        this.J0 = true;
        this.K0 = true;
        this.L0 = true;
        this.M0 = Build.VERSION.SDK_INT >= 33 ? new cv3(this) : new av3(this);
        this.N0 = new cj2(this);
        this.O0 = new n02(this, this);
        Context context2 = getContext();
        bq2 bq2Var = new bq2(context2);
        this.B0 = bq2Var;
        n02 n02VarW = fx3.w(context2, attributeSet, rc3.I, com.getsurfboard.R.attr.navigationViewStyle, com.getsurfboard.R.style.Widget_Design_NavigationView, new int[0]);
        TypedArray typedArray = (TypedArray) n02VarW.z;
        if (typedArray.hasValue(1)) {
            setBackground(n02VarW.o(1));
        }
        typedArray.getDimensionPixelSize(7, 0);
        getResources().getDimensionPixelSize(com.getsurfboard.R.dimen.m3_navigation_drawer_layout_corner_size);
        Drawable background = getBackground();
        ColorStateList colorStateListH = v9.h(background);
        if (background == null || colorStateListH != null) {
            yi2 yi2Var = new yi2(ou3.h(context2, attributeSet, com.getsurfboard.R.attr.navigationViewStyle, com.getsurfboard.R.style.Widget_Design_NavigationView).b());
            if (colorStateListH != null) {
                yi2Var.p(colorStateListH);
            }
            yi2Var.l(context2);
            setBackground(yi2Var);
        }
        if (typedArray.hasValue(8)) {
            setElevation(typedArray.getDimensionPixelSize(8, 0));
        }
        setFitsSystemWindows(typedArray.getBoolean(2, false));
        this.E0 = typedArray.getDimensionPixelSize(3, 0);
        ColorStateList colorStateListN = typedArray.hasValue(33) ? n02VarW.n(33) : null;
        int resourceId = typedArray.hasValue(36) ? typedArray.getResourceId(36, 0) : 0;
        if (resourceId == 0 && colorStateListN == null) {
            colorStateListN = e(R.attr.textColorSecondary);
        }
        ColorStateList colorStateListN2 = typedArray.hasValue(15) ? n02VarW.n(15) : e(R.attr.textColorSecondary);
        int resourceId2 = typedArray.hasValue(25) ? typedArray.getResourceId(25, 0) : 0;
        boolean z = typedArray.getBoolean(26, true);
        if (typedArray.hasValue(14)) {
            setItemIconSize(typedArray.getDimensionPixelSize(14, 0));
        }
        ColorStateList colorStateListN3 = typedArray.hasValue(27) ? n02VarW.n(27) : null;
        if (resourceId2 == 0 && colorStateListN3 == null) {
            colorStateListN3 = e(R.attr.textColorPrimary);
        }
        Drawable drawableO = n02VarW.o(11);
        if (drawableO == null && (typedArray.hasValue(18) || typedArray.hasValue(19))) {
            InsetDrawable insetDrawableF = f(n02VarW, l72.q(getContext(), n02VarW, 20));
            ColorStateList colorStateListQ = l72.q(context2, n02VarW, 17);
            if (colorStateListQ != null) {
                insetDrawable = insetDrawableF;
                mq2Var.E0 = new RippleDrawable(jl3.c(colorStateListQ), null, f(n02VarW, null));
                mq2Var.k();
            } else {
                insetDrawable = insetDrawableF;
            }
            drawableO = insetDrawable;
        }
        if (typedArray.hasValue(12)) {
            i = 0;
            setItemHorizontalPadding(typedArray.getDimensionPixelSize(12, 0));
        } else {
            i = 0;
        }
        if (typedArray.hasValue(28)) {
            setItemVerticalPadding(typedArray.getDimensionPixelSize(28, i));
        }
        setDividerInsetStart(typedArray.getDimensionPixelSize(6, i));
        setDividerInsetEnd(typedArray.getDimensionPixelSize(5, i));
        setSubheaderInsetStart(typedArray.getDimensionPixelSize(35, i));
        setSubheaderInsetEnd(typedArray.getDimensionPixelSize(34, i));
        setTopInsetScrimEnabled(typedArray.getBoolean(37, this.I0));
        setBottomInsetScrimEnabled(typedArray.getBoolean(4, this.J0));
        setStartInsetScrimEnabled(typedArray.getBoolean(32, this.K0));
        setEndInsetScrimEnabled(typedArray.getBoolean(9, this.L0));
        int dimensionPixelSize = typedArray.getDimensionPixelSize(13, 0);
        setItemMaxLines(typedArray.getInt(16, 1));
        bq2Var.e = new wn1(8, this);
        mq2Var.A = 1;
        mq2Var.l(context2, bq2Var);
        if (resourceId != 0) {
            mq2Var.Z = resourceId;
            mq2Var.g();
        }
        mq2Var.y0 = colorStateListN;
        mq2Var.g();
        mq2Var.C0 = colorStateListN2;
        mq2Var.k();
        int overScrollMode = getOverScrollMode();
        mq2Var.S0 = overScrollMode;
        NavigationMenuView navigationMenuView = mq2Var.b;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(overScrollMode);
        }
        if (resourceId2 != 0) {
            mq2Var.z0 = resourceId2;
            mq2Var.k();
        }
        mq2Var.A0 = z;
        mq2Var.k();
        mq2Var.B0 = colorStateListN3;
        mq2Var.k();
        mq2Var.D0 = drawableO;
        mq2Var.k();
        mq2Var.H0 = dimensionPixelSize;
        mq2Var.k();
        bq2Var.b(mq2Var, bq2Var.a);
        if (mq2Var.b == null) {
            NavigationMenuView navigationMenuView2 = (NavigationMenuView) mq2Var.Y.inflate(com.getsurfboard.R.layout.design_navigation_menu, (ViewGroup) this, false);
            mq2Var.b = navigationMenuView2;
            navigationMenuView2.setAccessibilityDelegateCompat(new jq2(mq2Var, mq2Var.b));
            if (mq2Var.X == null) {
                eq2 eq2Var = new eq2(mq2Var);
                mq2Var.X = eq2Var;
                eq2Var.o(true);
            }
            int i2 = mq2Var.S0;
            if (i2 != -1) {
                mq2Var.b.setOverScrollMode(i2);
            }
            LinearLayout linearLayout = (LinearLayout) mq2Var.Y.inflate(com.getsurfboard.R.layout.design_navigation_item_header, (ViewGroup) mq2Var.b, false);
            mq2Var.f = linearLayout;
            linearLayout.setImportantForAccessibility(2);
            mq2Var.b.setAdapter(mq2Var.X);
        }
        addView(mq2Var.b);
        if (typedArray.hasValue(29)) {
            int resourceId3 = typedArray.getResourceId(29, 0);
            eq2 eq2Var2 = mq2Var.X;
            if (eq2Var2 != null) {
                eq2Var2.f = true;
            }
            getMenuInflater().inflate(resourceId3, bq2Var);
            eq2 eq2Var3 = mq2Var.X;
            if (eq2Var3 != null) {
                eq2Var3.f = false;
            }
            mq2Var.c(false);
        }
        if (typedArray.hasValue(10)) {
            mq2Var.f.addView(mq2Var.Y.inflate(typedArray.getResourceId(10, 0), (ViewGroup) mq2Var.f, false));
            NavigationMenuView navigationMenuView3 = mq2Var.b;
            navigationMenuView3.setPadding(0, 0, 0, navigationMenuView3.getPaddingBottom());
        }
        n02VarW.K();
        this.H0 = new sb(3, this);
        getViewTreeObserver().addOnGlobalLayoutListener(this.H0);
    }

    private MenuInflater getMenuInflater() {
        a64 a64Var = this.G0;
        if (a64Var != null) {
            return a64Var;
        }
        a64 a64Var2 = new a64(getContext());
        this.G0 = a64Var2;
        return a64Var2;
    }

    @Override // defpackage.ai2
    public final void a() {
        g();
        throw null;
    }

    @Override // defpackage.ai2
    public final void b(yh yhVar) {
        g();
        throw null;
    }

    @Override // defpackage.ai2
    public final void c(yh yhVar) {
        g();
        throw null;
    }

    @Override // defpackage.ai2
    public final void d() {
        g();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        zu3 zu3Var = this.M0;
        Path path = zu3Var.c;
        if (!zu3Var.b() || path.isEmpty()) {
            super.dispatchDraw(canvas);
            return;
        }
        canvas.save();
        canvas.clipPath(path);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public final ColorStateList e(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListG = v9.g(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(com.getsurfboard.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateListG.getDefaultColor();
        int[] iArr = Q0;
        return new ColorStateList(new int[][]{iArr, P0, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateListG.getColorForState(iArr, defaultColor), i2, defaultColor});
    }

    public final InsetDrawable f(n02 n02Var, ColorStateList colorStateList) {
        TypedArray typedArray = (TypedArray) n02Var.z;
        yi2 yi2Var = new yi2(ou3.f(getContext(), typedArray.getResourceId(18, 0), typedArray.getResourceId(19, 0)).b());
        yi2Var.p(colorStateList);
        return new InsetDrawable((Drawable) yi2Var, typedArray.getDimensionPixelSize(23, 0), typedArray.getDimensionPixelSize(24, 0), typedArray.getDimensionPixelSize(22, 0), typedArray.getDimensionPixelSize(21, 0));
    }

    public final void g() {
        getParent();
        getLayoutParams();
        throw new IllegalStateException("NavigationView back progress requires the direct parent view to be a DrawerLayout.");
    }

    public cj2 getBackHelper() {
        return this.N0;
    }

    public MenuItem getCheckedItem() {
        return this.C0.X.e;
    }

    public int getDividerInsetEnd() {
        return this.C0.K0;
    }

    public int getDividerInsetStart() {
        return this.C0.J0;
    }

    public int getHeaderCount() {
        return this.C0.f.getChildCount();
    }

    public Drawable getItemBackground() {
        return this.C0.D0;
    }

    public int getItemHorizontalPadding() {
        return this.C0.F0;
    }

    public int getItemIconPadding() {
        return this.C0.H0;
    }

    public ColorStateList getItemIconTintList() {
        return this.C0.C0;
    }

    public int getItemMaxLines() {
        return this.C0.P0;
    }

    public ColorStateList getItemTextColor() {
        return this.C0.B0;
    }

    public int getItemVerticalPadding() {
        return this.C0.G0;
    }

    public Menu getMenu() {
        return this.B0;
    }

    public int getSubheaderInsetEnd() {
        return this.C0.M0;
    }

    public int getSubheaderInsetStart() {
        return this.C0.L0;
    }

    @Override // defpackage.nq3, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        uf2.O(this);
        getParent();
    }

    @Override // defpackage.nq3, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.H0);
        getParent();
        n02 n02Var = this.O0;
        bi2 bi2Var = (bi2) n02Var.f;
        if (bi2Var != null) {
            bi2Var.c((View) n02Var.A);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int i3 = this.E0;
        if (mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), i3), Pow2.MAX_POW2);
        } else if (mode == 0) {
            i = View.MeasureSpec.makeMeasureSpec(i3, Pow2.MAX_POW2);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof rq2)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        rq2 rq2Var = (rq2) parcelable;
        super.onRestoreInstanceState(rq2Var.b);
        this.B0.f(rq2Var.z);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        rq2 rq2Var = new rq2(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        rq2Var.z = bundle;
        this.B0.g(bundle);
        return rq2Var;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        getParent();
    }

    public void setBottomInsetScrimEnabled(boolean z) {
        this.J0 = z;
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem menuItemFindItem = this.B0.findItem(menuItem.getItemId());
        if (menuItemFindItem == null) {
            xe.k("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
        } else {
            this.C0.X.r((sk2) menuItemFindItem);
        }
    }

    public void setDividerInsetEnd(int i) {
        mq2 mq2Var = this.C0;
        mq2Var.K0 = i;
        mq2Var.b();
    }

    public void setDividerInsetStart(int i) {
        mq2 mq2Var = this.C0;
        mq2Var.J0 = i;
        mq2Var.b();
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        uf2.L(this, f);
    }

    public void setEndInsetScrimEnabled(boolean z) {
        this.L0 = z;
    }

    public void setForceCompatClippingEnabled(boolean z) {
        zu3 zu3Var = this.M0;
        if (z != zu3Var.a) {
            zu3Var.a = z;
            zu3Var.a(this);
        }
    }

    public void setItemBackground(Drawable drawable) {
        mq2 mq2Var = this.C0;
        mq2Var.D0 = drawable;
        mq2Var.k();
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(getContext().getDrawable(i));
    }

    public void setItemHorizontalPadding(int i) {
        mq2 mq2Var = this.C0;
        mq2Var.F0 = i;
        mq2Var.k();
    }

    public void setItemHorizontalPaddingResource(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        mq2 mq2Var = this.C0;
        mq2Var.F0 = dimensionPixelSize;
        mq2Var.k();
    }

    public void setItemIconPadding(int i) {
        mq2 mq2Var = this.C0;
        mq2Var.H0 = i;
        mq2Var.k();
    }

    public void setItemIconPaddingResource(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        mq2 mq2Var = this.C0;
        mq2Var.H0 = dimensionPixelSize;
        mq2Var.k();
    }

    public void setItemIconSize(int i) {
        mq2 mq2Var = this.C0;
        if (mq2Var.I0 != i) {
            mq2Var.I0 = i;
            mq2Var.N0 = true;
            mq2Var.k();
        }
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        mq2 mq2Var = this.C0;
        mq2Var.C0 = colorStateList;
        mq2Var.k();
    }

    public void setItemMaxLines(int i) {
        mq2 mq2Var = this.C0;
        mq2Var.P0 = i;
        mq2Var.k();
    }

    public void setItemTextAppearance(int i) {
        mq2 mq2Var = this.C0;
        mq2Var.z0 = i;
        mq2Var.k();
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z) {
        mq2 mq2Var = this.C0;
        mq2Var.A0 = z;
        mq2Var.k();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        mq2 mq2Var = this.C0;
        mq2Var.B0 = colorStateList;
        mq2Var.k();
    }

    public void setItemVerticalPadding(int i) {
        mq2 mq2Var = this.C0;
        mq2Var.G0 = i;
        mq2Var.k();
    }

    public void setItemVerticalPaddingResource(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        mq2 mq2Var = this.C0;
        mq2Var.G0 = dimensionPixelSize;
        mq2Var.k();
    }

    public void setNavigationItemSelectedListener(qq2 qq2Var) {
        this.D0 = qq2Var;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        super.setOverScrollMode(i);
        mq2 mq2Var = this.C0;
        if (mq2Var != null) {
            mq2Var.S0 = i;
            NavigationMenuView navigationMenuView = mq2Var.b;
            if (navigationMenuView != null) {
                navigationMenuView.setOverScrollMode(i);
            }
        }
    }

    public void setStartInsetScrimEnabled(boolean z) {
        this.K0 = z;
    }

    public void setSubheaderInsetEnd(int i) {
        mq2 mq2Var = this.C0;
        mq2Var.M0 = i;
        mq2Var.g();
    }

    public void setSubheaderInsetStart(int i) {
        mq2 mq2Var = this.C0;
        mq2Var.L0 = i;
        mq2Var.g();
    }

    public void setTopInsetScrimEnabled(boolean z) {
        this.I0 = z;
    }

    public void setCheckedItem(int i) {
        MenuItem menuItemFindItem = this.B0.findItem(i);
        if (menuItemFindItem != null) {
            this.C0.X.r((sk2) menuItemFindItem);
        }
    }

    public NavigationView(Context context) {
        this(context, null);
    }
}
