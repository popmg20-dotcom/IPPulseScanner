package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import com.getsurfboard.R;
import defpackage.a64;
import defpackage.c3;
import defpackage.cd3;
import defpackage.df4;
import defpackage.ef4;
import defpackage.f33;
import defpackage.ff4;
import defpackage.gf4;
import defpackage.ha1;
import defpackage.hb;
import defpackage.hf4;
import defpackage.ib;
import defpackage.if4;
import defpackage.jf4;
import defpackage.lm3;
import defpackage.mf4;
import defpackage.n02;
import defpackage.nk2;
import defpackage.pr4;
import defpackage.q3;
import defpackage.qk2;
import defpackage.rk0;
import defpackage.sj1;
import defpackage.sk2;
import defpackage.sn;
import defpackage.st4;
import defpackage.vo;
import defpackage.wn1;
import defpackage.wp4;
import defpackage.ye;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup implements qk2 {
    public hb A;
    public final CharSequence A0;
    public hb B0;
    public View C0;
    public Context D0;
    public int E0;
    public int F0;
    public int G0;
    public final int H0;
    public final int I0;
    public int J0;
    public int K0;
    public int L0;
    public int M0;
    public lm3 N0;
    public int O0;
    public int P0;
    public final int Q0;
    public CharSequence R0;
    public CharSequence S0;
    public ColorStateList T0;
    public ColorStateList U0;
    public boolean V0;
    public boolean W0;
    public final ArrayList X0;
    public final ArrayList Y0;
    public final int[] Z0;
    public final n02 a1;
    public ActionMenuView b;
    public ArrayList b1;
    public hf4 c1;
    public final ha1 d1;
    public mf4 e1;
    public AppCompatTextView f;
    public q3 f1;
    public ff4 g1;
    public sn h1;
    public jf4 i1;
    public boolean j1;
    public OnBackInvokedCallback k1;
    public OnBackInvokedDispatcher l1;
    public boolean m1;
    public final f33 n1;
    public ib y0;
    public AppCompatTextView z;
    public final Drawable z0;

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, R.attr.toolbarStyle);
        this.Q0 = 8388627;
        this.X0 = new ArrayList();
        this.Y0 = new ArrayList();
        this.Z0 = new int[2];
        this.a1 = new n02(new df4(this, 1));
        this.b1 = new ArrayList();
        this.d1 = new ha1(29, this);
        this.n1 = new f33(26, this);
        Context context2 = getContext();
        int[] iArr = cd3.y;
        n02 n02VarY = n02.y(context2, attributeSet, iArr, R.attr.toolbarStyle);
        wp4.m(this, context, iArr, attributeSet, (TypedArray) n02VarY.z, R.attr.toolbarStyle);
        TypedArray typedArray = (TypedArray) n02VarY.z;
        this.F0 = typedArray.getResourceId(28, 0);
        this.G0 = typedArray.getResourceId(19, 0);
        this.Q0 = typedArray.getInteger(0, 8388627);
        this.H0 = typedArray.getInteger(2, 48);
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(22, 0);
        dimensionPixelOffset = typedArray.hasValue(27) ? typedArray.getDimensionPixelOffset(27, dimensionPixelOffset) : dimensionPixelOffset;
        this.M0 = dimensionPixelOffset;
        this.L0 = dimensionPixelOffset;
        this.K0 = dimensionPixelOffset;
        this.J0 = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(25, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.J0 = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray.getDimensionPixelOffset(24, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.K0 = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray.getDimensionPixelOffset(26, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.L0 = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray.getDimensionPixelOffset(23, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.M0 = dimensionPixelOffset5;
        }
        this.I0 = typedArray.getDimensionPixelSize(13, -1);
        int dimensionPixelOffset6 = typedArray.getDimensionPixelOffset(9, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray.getDimensionPixelOffset(5, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(8, 0);
        d();
        lm3 lm3Var = this.N0;
        lm3Var.h = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            lm3Var.e = dimensionPixelSize;
            lm3Var.a = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            lm3Var.f = dimensionPixelSize2;
            lm3Var.b = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            lm3Var.a(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.O0 = typedArray.getDimensionPixelOffset(10, Integer.MIN_VALUE);
        this.P0 = typedArray.getDimensionPixelOffset(6, Integer.MIN_VALUE);
        this.z0 = n02VarY.o(4);
        this.A0 = typedArray.getText(3);
        CharSequence text = typedArray.getText(21);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray.getText(18);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.D0 = getContext();
        setPopupTheme(typedArray.getResourceId(17, 0));
        Drawable drawableO = n02VarY.o(16);
        if (drawableO != null) {
            setNavigationIcon(drawableO);
        }
        CharSequence text3 = typedArray.getText(15);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawableO2 = n02VarY.o(11);
        if (drawableO2 != null) {
            setLogo(drawableO2);
        }
        CharSequence text4 = typedArray.getText(12);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (typedArray.hasValue(29)) {
            setTitleTextColor(n02VarY.n(29));
        }
        if (typedArray.hasValue(20)) {
            setSubtitleTextColor(n02VarY.n(20));
        }
        if (typedArray.hasValue(14)) {
            o(typedArray.getResourceId(14, 0));
        }
        n02VarY.K();
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i = 0; i < menu.size(); i++) {
            arrayList.add(menu.getItem(i));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new a64(getContext());
    }

    public static gf4 h() {
        gf4 gf4Var = new gf4(-2, -2);
        gf4Var.b = 0;
        gf4Var.a = 8388627;
        return gf4Var;
    }

    public static gf4 i(ViewGroup.LayoutParams layoutParams) {
        boolean z = layoutParams instanceof gf4;
        if (z) {
            gf4 gf4Var = (gf4) layoutParams;
            gf4 gf4Var2 = new gf4(gf4Var);
            gf4Var2.b = 0;
            gf4Var2.b = gf4Var.b;
            return gf4Var2;
        }
        if (z) {
            gf4 gf4Var3 = new gf4((gf4) layoutParams);
            gf4Var3.b = 0;
            return gf4Var3;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            gf4 gf4Var4 = new gf4(layoutParams);
            gf4Var4.b = 0;
            return gf4Var4;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        gf4 gf4Var5 = new gf4(marginLayoutParams);
        gf4Var5.b = 0;
        ((ViewGroup.MarginLayoutParams) gf4Var5).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) gf4Var5).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) gf4Var5).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) gf4Var5).bottomMargin = marginLayoutParams.bottomMargin;
        return gf4Var5;
    }

    public static int l(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
    }

    public static int m(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void a(ArrayList arrayList, int i) {
        boolean z = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i, getLayoutDirection());
        arrayList.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                gf4 gf4Var = (gf4) childAt.getLayoutParams();
                if (gf4Var.b == 0 && w(childAt)) {
                    int i3 = gf4Var.a;
                    int layoutDirection = getLayoutDirection();
                    int absoluteGravity2 = Gravity.getAbsoluteGravity(i3, layoutDirection) & 7;
                    if (absoluteGravity2 != 1 && absoluteGravity2 != 3 && absoluteGravity2 != 5) {
                        absoluteGravity2 = layoutDirection == 1 ? 5 : 3;
                    }
                    if (absoluteGravity2 == absoluteGravity) {
                        arrayList.add(childAt);
                    }
                }
            }
            return;
        }
        for (int i4 = childCount - 1; i4 >= 0; i4--) {
            View childAt2 = getChildAt(i4);
            gf4 gf4Var2 = (gf4) childAt2.getLayoutParams();
            if (gf4Var2.b == 0 && w(childAt2)) {
                int i5 = gf4Var2.a;
                int layoutDirection2 = getLayoutDirection();
                int absoluteGravity3 = Gravity.getAbsoluteGravity(i5, layoutDirection2) & 7;
                if (absoluteGravity3 != 1 && absoluteGravity3 != 3 && absoluteGravity3 != 5) {
                    absoluteGravity3 = layoutDirection2 == 1 ? 5 : 3;
                }
                if (absoluteGravity3 == absoluteGravity) {
                    arrayList.add(childAt2);
                }
            }
        }
    }

    public final void b(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        gf4 gf4VarH = layoutParams == null ? h() : !checkLayoutParams(layoutParams) ? i(layoutParams) : (gf4) layoutParams;
        gf4VarH.b = 1;
        if (!z || this.C0 == null) {
            addView(view, gf4VarH);
        } else {
            view.setLayoutParams(gf4VarH);
            this.Y0.add(view);
        }
    }

    public final void c() {
        if (this.B0 == null) {
            hb hbVar = new hb(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.B0 = hbVar;
            hbVar.setImageDrawable(this.z0);
            this.B0.setContentDescription(this.A0);
            gf4 gf4VarH = h();
            gf4VarH.a = (this.H0 & 112) | 8388611;
            gf4VarH.b = 2;
            this.B0.setLayoutParams(gf4VarH);
            this.B0.setOnClickListener(new c3(7, this));
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof gf4);
    }

    public final void d() {
        if (this.N0 == null) {
            lm3 lm3Var = new lm3();
            lm3Var.a = 0;
            lm3Var.b = 0;
            lm3Var.c = Integer.MIN_VALUE;
            lm3Var.d = Integer.MIN_VALUE;
            lm3Var.e = 0;
            lm3Var.f = 0;
            lm3Var.g = false;
            lm3Var.h = false;
            this.N0 = lm3Var;
        }
    }

    public final void e() {
        f();
        ActionMenuView actionMenuView = this.b;
        if (actionMenuView.J0 == null) {
            nk2 nk2Var = (nk2) actionMenuView.getMenu();
            if (this.g1 == null) {
                this.g1 = new ff4(this);
            }
            this.b.setExpandedActionViewsExclusive(true);
            nk2Var.b(this.g1, this.D0);
            y();
        }
    }

    public final void f() {
        if (this.b == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.b = actionMenuView;
            actionMenuView.setPopupTheme(this.E0);
            this.b.setOnMenuItemClickListener(this.d1);
            ActionMenuView actionMenuView2 = this.b;
            sn snVar = this.h1;
            wn1 wn1Var = new wn1(25, this);
            actionMenuView2.O0 = snVar;
            actionMenuView2.P0 = wn1Var;
            gf4 gf4VarH = h();
            gf4VarH.a = (this.H0 & 112) | 8388613;
            this.b.setLayoutParams(gf4VarH);
            b(this.b, false);
        }
    }

    public final void g() {
        if (this.A == null) {
            this.A = new hb(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            gf4 gf4VarH = h();
            gf4VarH.a = (this.H0 & 112) | 8388611;
            this.A.setLayoutParams(gf4VarH);
        }
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return h();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        gf4 gf4Var = new gf4(context, attributeSet);
        gf4Var.a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cd3.b);
        gf4Var.a = typedArrayObtainStyledAttributes.getInt(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        gf4Var.b = 0;
        return gf4Var;
    }

    public CharSequence getCollapseContentDescription() {
        hb hbVar = this.B0;
        if (hbVar != null) {
            return hbVar.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        hb hbVar = this.B0;
        if (hbVar != null) {
            return hbVar.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        lm3 lm3Var = this.N0;
        if (lm3Var != null) {
            return lm3Var.g ? lm3Var.a : lm3Var.b;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i = this.P0;
        return i != Integer.MIN_VALUE ? i : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        lm3 lm3Var = this.N0;
        if (lm3Var != null) {
            return lm3Var.a;
        }
        return 0;
    }

    public int getContentInsetRight() {
        lm3 lm3Var = this.N0;
        if (lm3Var != null) {
            return lm3Var.b;
        }
        return 0;
    }

    public int getContentInsetStart() {
        lm3 lm3Var = this.N0;
        if (lm3Var != null) {
            return lm3Var.g ? lm3Var.b : lm3Var.a;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.O0;
        return i != Integer.MIN_VALUE ? i : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        nk2 nk2Var;
        ActionMenuView actionMenuView = this.b;
        return (actionMenuView == null || (nk2Var = actionMenuView.J0) == null || !nk2Var.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.P0, 0));
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.O0, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ib ibVar = this.y0;
        if (ibVar != null) {
            return ibVar.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ib ibVar = this.y0;
        if (ibVar != null) {
            return ibVar.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        e();
        return this.b.getMenu();
    }

    public View getNavButtonView() {
        return this.A;
    }

    public CharSequence getNavigationContentDescription() {
        hb hbVar = this.A;
        if (hbVar != null) {
            return hbVar.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        hb hbVar = this.A;
        if (hbVar != null) {
            return hbVar.getDrawable();
        }
        return null;
    }

    public q3 getOuterActionMenuPresenter() {
        return this.f1;
    }

    public Drawable getOverflowIcon() {
        e();
        return this.b.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.D0;
    }

    public int getPopupTheme() {
        return this.E0;
    }

    public CharSequence getSubtitle() {
        return this.S0;
    }

    public final TextView getSubtitleTextView() {
        return this.z;
    }

    public CharSequence getTitle() {
        return this.R0;
    }

    public int getTitleMarginBottom() {
        return this.M0;
    }

    public int getTitleMarginEnd() {
        return this.K0;
    }

    public int getTitleMarginStart() {
        return this.J0;
    }

    public int getTitleMarginTop() {
        return this.L0;
    }

    public final TextView getTitleTextView() {
        return this.f;
    }

    public rk0 getWrapper() {
        mf4 mf4Var = this.e1;
        if (mf4Var != null) {
            return mf4Var;
        }
        mf4 mf4Var2 = new mf4(this, true);
        this.e1 = mf4Var2;
        return mf4Var2;
    }

    @Override // defpackage.qk2
    public final void j(sj1 sj1Var) {
        n02 n02Var = this.a1;
        ((CopyOnWriteArrayList) n02Var.z).remove(sj1Var);
        if (((HashMap) n02Var.A).remove(sj1Var) == null) {
            ((Runnable) n02Var.f).run();
        } else {
            st4.n();
        }
    }

    public final int k(View view, int i) {
        gf4 gf4Var = (gf4) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int i3 = gf4Var.a & 112;
        if (i3 != 16 && i3 != 48 && i3 != 80) {
            i3 = this.Q0 & 112;
        }
        if (i3 == 48) {
            return getPaddingTop() - i2;
        }
        if (i3 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) gf4Var).bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i4 = ((ViewGroup.MarginLayoutParams) gf4Var).topMargin;
        if (iMax < i4) {
            iMax = i4;
        } else {
            int i5 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i6 = ((ViewGroup.MarginLayoutParams) gf4Var).bottomMargin;
            if (i5 < i6) {
                iMax = Math.max(0, iMax - (i6 - i5));
            }
        }
        return paddingTop + iMax;
    }

    @Override // defpackage.qk2
    public final void n(sj1 sj1Var) {
        n02 n02Var = this.a1;
        ((CopyOnWriteArrayList) n02Var.z).add(sj1Var);
        ((Runnable) n02Var.f).run();
    }

    public final void o(int i) {
        getMenuInflater().inflate(i, getMenu());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        y();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.n1);
        y();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.W0 = false;
        }
        if (!this.W0) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.W0 = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.W0 = false;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0285 A[LOOP:0: B:107:0x0283->B:108:0x0285, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x029d A[LOOP:1: B:110:0x029b->B:111:0x029d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02bd A[LOOP:2: B:113:0x02bb->B:114:0x02bd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0310 A[LOOP:3: B:122:0x030e->B:123:0x0310, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x020e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iS;
        int iT;
        int iMax;
        boolean zW;
        boolean zW2;
        boolean z2;
        int measuredHeight;
        int i5;
        int paddingTop;
        int i6;
        int i7;
        int i8;
        int i9;
        int size;
        int iS2;
        int i10;
        int size2;
        int i11;
        int size3;
        int i12;
        int i13;
        int i14;
        int size4;
        boolean z3 = getLayoutDirection() == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i15 = width - paddingRight;
        int[] iArr = this.Z0;
        iArr[1] = 0;
        iArr[0] = 0;
        WeakHashMap weakHashMap = wp4.a;
        int minimumHeight = getMinimumHeight();
        int iMin = minimumHeight >= 0 ? Math.min(minimumHeight, i4 - i2) : 0;
        if (w(this.A)) {
            hb hbVar = this.A;
            if (z3) {
                iT = t(hbVar, i15, iMin, iArr);
                iS = paddingLeft;
                if (w(this.B0)) {
                    hb hbVar2 = this.B0;
                    if (z3) {
                        iT = t(hbVar2, iT, iMin, iArr);
                    } else {
                        iS = s(hbVar2, iS, iMin, iArr);
                    }
                }
                if (w(this.b)) {
                    ActionMenuView actionMenuView = this.b;
                    if (z3) {
                        iS = s(actionMenuView, iS, iMin, iArr);
                    } else {
                        iT = t(actionMenuView, iT, iMin, iArr);
                    }
                }
                int currentContentInsetLeft = getCurrentContentInsetLeft();
                int currentContentInsetRight = getCurrentContentInsetRight();
                iArr[0] = Math.max(0, currentContentInsetLeft - iS);
                iArr[1] = Math.max(0, currentContentInsetRight - (i15 - iT));
                iMax = Math.max(iS, currentContentInsetLeft);
                int iMin2 = Math.min(iT, i15 - currentContentInsetRight);
                if (w(this.C0)) {
                    View view = this.C0;
                    if (z3) {
                        iMin2 = t(view, iMin2, iMin, iArr);
                    } else {
                        iMax = s(view, iMax, iMin, iArr);
                    }
                }
                if (w(this.y0)) {
                    ib ibVar = this.y0;
                    if (z3) {
                        iMin2 = t(ibVar, iMin2, iMin, iArr);
                    } else {
                        iMax = s(ibVar, iMax, iMin, iArr);
                    }
                }
                zW = w(this.f);
                zW2 = w(this.z);
                if (zW) {
                    z2 = z3;
                    measuredHeight = 0;
                } else {
                    gf4 gf4Var = (gf4) this.f.getLayoutParams();
                    z2 = z3;
                    measuredHeight = this.f.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) gf4Var).topMargin + ((ViewGroup.MarginLayoutParams) gf4Var).bottomMargin;
                }
                if (!zW2) {
                    gf4 gf4Var2 = (gf4) this.z.getLayoutParams();
                    measuredHeight = this.z.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) gf4Var2).topMargin + ((ViewGroup.MarginLayoutParams) gf4Var2).bottomMargin + measuredHeight;
                }
                if (!zW || zW2) {
                    AppCompatTextView appCompatTextView = !zW ? this.f : this.z;
                    AppCompatTextView appCompatTextView2 = !zW2 ? this.z : this.f;
                    gf4 gf4Var3 = (gf4) appCompatTextView.getLayoutParams();
                    gf4 gf4Var4 = (gf4) appCompatTextView2.getLayoutParams();
                    int i16 = measuredHeight;
                    boolean z4 = (zW && this.f.getMeasuredWidth() > 0) || (zW2 && this.z.getMeasuredWidth() > 0);
                    i5 = this.Q0 & 112;
                    int i17 = iMax;
                    if (i5 == 48) {
                        paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) gf4Var3).topMargin + this.L0;
                    } else if (i5 != 80) {
                        int iMax2 = (((height - paddingTop2) - paddingBottom) - i16) / 2;
                        int i18 = ((ViewGroup.MarginLayoutParams) gf4Var3).topMargin + this.L0;
                        if (iMax2 < i18) {
                            iMax2 = i18;
                        } else {
                            int i19 = (((height - paddingBottom) - i16) - iMax2) - paddingTop2;
                            int i20 = ((ViewGroup.MarginLayoutParams) gf4Var3).bottomMargin;
                            int i21 = this.M0;
                            if (i19 < i20 + i21) {
                                iMax2 = Math.max(0, iMax2 - ((((ViewGroup.MarginLayoutParams) gf4Var4).bottomMargin + i21) - i19));
                            }
                        }
                        paddingTop = paddingTop2 + iMax2;
                    } else {
                        paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) gf4Var4).bottomMargin) - this.M0) - i16;
                    }
                    if (z2) {
                        int i22 = (z4 ? this.J0 : 0) - iArr[1];
                        iMin2 -= Math.max(0, i22);
                        iArr[1] = Math.max(0, -i22);
                        if (zW) {
                            gf4 gf4Var5 = (gf4) this.f.getLayoutParams();
                            int measuredWidth = iMin2 - this.f.getMeasuredWidth();
                            int measuredHeight2 = this.f.getMeasuredHeight() + paddingTop;
                            this.f.layout(measuredWidth, paddingTop, iMin2, measuredHeight2);
                            i8 = measuredWidth - this.K0;
                            paddingTop = measuredHeight2 + ((ViewGroup.MarginLayoutParams) gf4Var5).bottomMargin;
                        } else {
                            i8 = iMin2;
                        }
                        if (zW2) {
                            int i23 = paddingTop + ((ViewGroup.MarginLayoutParams) ((gf4) this.z.getLayoutParams())).topMargin;
                            this.z.layout(iMin2 - this.z.getMeasuredWidth(), i23, iMin2, this.z.getMeasuredHeight() + i23);
                            i9 = iMin2 - this.K0;
                        } else {
                            i9 = iMin2;
                        }
                        if (z4) {
                            iMin2 = Math.min(i8, i9);
                        }
                        iMax = i17;
                    } else {
                        int i24 = (z4 ? this.J0 : 0) - iArr[0];
                        iMax = Math.max(0, i24) + i17;
                        iArr[0] = Math.max(0, -i24);
                        if (zW) {
                            gf4 gf4Var6 = (gf4) this.f.getLayoutParams();
                            int measuredWidth2 = this.f.getMeasuredWidth() + iMax;
                            int measuredHeight3 = this.f.getMeasuredHeight() + paddingTop;
                            this.f.layout(iMax, paddingTop, measuredWidth2, measuredHeight3);
                            i6 = measuredWidth2 + this.K0;
                            paddingTop = measuredHeight3 + ((ViewGroup.MarginLayoutParams) gf4Var6).bottomMargin;
                        } else {
                            i6 = iMax;
                        }
                        if (zW2) {
                            int i25 = paddingTop + ((ViewGroup.MarginLayoutParams) ((gf4) this.z.getLayoutParams())).topMargin;
                            int measuredWidth3 = this.z.getMeasuredWidth() + iMax;
                            this.z.layout(iMax, i25, measuredWidth3, this.z.getMeasuredHeight() + i25);
                            i7 = measuredWidth3 + this.K0;
                        } else {
                            i7 = iMax;
                        }
                        if (z4) {
                            iMax = Math.max(i6, i7);
                        }
                    }
                }
                ArrayList arrayList = this.X0;
                a(arrayList, 3);
                size = arrayList.size();
                iS2 = iMax;
                for (i10 = 0; i10 < size; i10++) {
                    iS2 = s((View) arrayList.get(i10), iS2, iMin, iArr);
                }
                a(arrayList, 5);
                size2 = arrayList.size();
                for (i11 = 0; i11 < size2; i11++) {
                    iMin2 = t((View) arrayList.get(i11), iMin2, iMin, iArr);
                }
                a(arrayList, 1);
                int i26 = iArr[0];
                int i27 = iArr[1];
                size3 = arrayList.size();
                int i28 = i26;
                i12 = 0;
                int measuredWidth4 = 0;
                while (i12 < size3) {
                    View view2 = (View) arrayList.get(i12);
                    gf4 gf4Var7 = (gf4) view2.getLayoutParams();
                    int i29 = i27;
                    int i30 = ((ViewGroup.MarginLayoutParams) gf4Var7).leftMargin - i28;
                    int i31 = ((ViewGroup.MarginLayoutParams) gf4Var7).rightMargin - i29;
                    int iMax3 = Math.max(0, i30);
                    int iMax4 = Math.max(0, i31);
                    int iMax5 = Math.max(0, -i30);
                    int iMax6 = Math.max(0, -i31);
                    measuredWidth4 += view2.getMeasuredWidth() + iMax3 + iMax4;
                    i12++;
                    i28 = iMax5;
                    i27 = iMax6;
                }
                i14 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth4 / 2);
                int i32 = measuredWidth4 + i14;
                if (i14 >= iS2) {
                    iS2 = i32 > iMin2 ? i14 - (i32 - iMin2) : i14;
                }
                size4 = arrayList.size();
                for (i13 = 0; i13 < size4; i13++) {
                    iS2 = s((View) arrayList.get(i13), iS2, iMin, iArr);
                }
                arrayList.clear();
            }
            iS = s(hbVar, paddingLeft, iMin, iArr);
        } else {
            iS = paddingLeft;
        }
        iT = i15;
        if (w(this.B0)) {
        }
        if (w(this.b)) {
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - iS);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i15 - iT));
        iMax = Math.max(iS, currentContentInsetLeft2);
        int iMin22 = Math.min(iT, i15 - currentContentInsetRight2);
        if (w(this.C0)) {
        }
        if (w(this.y0)) {
        }
        zW = w(this.f);
        zW2 = w(this.z);
        if (zW) {
        }
        if (!zW2) {
        }
        if (!zW) {
            if (!zW) {
            }
            if (!zW2) {
            }
            gf4 gf4Var32 = (gf4) appCompatTextView.getLayoutParams();
            gf4 gf4Var42 = (gf4) appCompatTextView2.getLayoutParams();
            int i162 = measuredHeight;
            if (zW) {
                i5 = this.Q0 & 112;
                int i172 = iMax;
                if (i5 == 48) {
                }
                if (z2) {
                }
            } else {
                i5 = this.Q0 & 112;
                int i1722 = iMax;
                if (i5 == 48) {
                }
                if (z2) {
                }
            }
        }
        ArrayList arrayList2 = this.X0;
        a(arrayList2, 3);
        size = arrayList2.size();
        iS2 = iMax;
        while (i10 < size) {
        }
        a(arrayList2, 5);
        size2 = arrayList2.size();
        while (i11 < size2) {
        }
        a(arrayList2, 1);
        int i262 = iArr[0];
        int i272 = iArr[1];
        size3 = arrayList2.size();
        int i282 = i262;
        i12 = 0;
        int measuredWidth42 = 0;
        while (i12 < size3) {
        }
        i14 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (measuredWidth42 / 2);
        int i322 = measuredWidth42 + i14;
        if (i14 >= iS2) {
        }
        size4 = arrayList2.size();
        while (i13 < size4) {
        }
        arrayList2.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        char c;
        Object[] objArr;
        int iL;
        int iMax;
        int iCombineMeasuredStates;
        int iL2;
        int iM;
        int iCombineMeasuredStates2;
        int iMax2;
        boolean z = pr4.a;
        int i3 = 0;
        if (getLayoutDirection() == 1) {
            objArr = true;
            c = 0;
        } else {
            c = 1;
            objArr = false;
        }
        if (w(this.A)) {
            v(this.A, i, 0, i2, this.I0);
            iL = l(this.A) + this.A.getMeasuredWidth();
            iMax = Math.max(0, m(this.A) + this.A.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.A.getMeasuredState());
        } else {
            iL = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (w(this.B0)) {
            v(this.B0, i, 0, i2, this.I0);
            iL = l(this.B0) + this.B0.getMeasuredWidth();
            iMax = Math.max(iMax, m(this.B0) + this.B0.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.B0.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, iL);
        int iMax4 = Math.max(0, currentContentInsetStart - iL);
        Object[] objArr2 = objArr;
        int[] iArr = this.Z0;
        iArr[objArr2 == true ? 1 : 0] = iMax4;
        if (w(this.b)) {
            v(this.b, i, iMax3, i2, this.I0);
            iL2 = l(this.b) + this.b.getMeasuredWidth();
            iMax = Math.max(iMax, m(this.b) + this.b.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.b.getMeasuredState());
        } else {
            iL2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax5 = iMax3 + Math.max(currentContentInsetEnd, iL2);
        iArr[c] = Math.max(0, currentContentInsetEnd - iL2);
        if (w(this.C0)) {
            iMax5 += u(this.C0, i, iMax5, i2, 0, iArr);
            iMax = Math.max(iMax, m(this.C0) + this.C0.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.C0.getMeasuredState());
        }
        if (w(this.y0)) {
            iMax5 += u(this.y0, i, iMax5, i2, 0, iArr);
            iMax = Math.max(iMax, m(this.y0) + this.y0.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.y0.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (((gf4) childAt.getLayoutParams()).b == 0 && w(childAt)) {
                iMax5 += u(childAt, i, iMax5, i2, 0, iArr);
                int iMax6 = Math.max(iMax, m(childAt) + childAt.getMeasuredHeight());
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
                iMax = iMax6;
            } else {
                iMax5 = iMax5;
            }
        }
        int i5 = iMax5;
        int i6 = this.L0 + this.M0;
        int i7 = this.J0 + this.K0;
        if (w(this.f)) {
            u(this.f, i, i5 + i7, i2, i6, iArr);
            int iL3 = l(this.f) + this.f.getMeasuredWidth();
            iM = m(this.f) + this.f.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f.getMeasuredState());
            iMax2 = iL3;
        } else {
            iM = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (w(this.z)) {
            iMax2 = Math.max(iMax2, u(this.z, i, i5 + i7, i2, i6 + iM, iArr));
            iM += m(this.z) + this.z.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.z.getMeasuredState());
        }
        int iMax7 = Math.max(iMax, iM);
        int paddingRight = getPaddingRight() + getPaddingLeft() + i5 + iMax2;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + iMax7;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i, (-16777216) & iCombineMeasuredStates2);
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16);
        if (!this.j1) {
            i3 = iResolveSizeAndState2;
            break;
        }
        int childCount2 = getChildCount();
        for (int i8 = 0; i8 < childCount2; i8++) {
            View childAt2 = getChildAt(i8);
            if (w(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                i3 = iResolveSizeAndState2;
                break;
            }
        }
        setMeasuredDimension(iResolveSizeAndState, i3);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof if4)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        if4 if4Var = (if4) parcelable;
        super.onRestoreInstanceState(if4Var.b);
        ActionMenuView actionMenuView = this.b;
        nk2 nk2Var = actionMenuView != null ? actionMenuView.J0 : null;
        int i = if4Var.z;
        if (i != 0 && this.g1 != null && nk2Var != null && (menuItemFindItem = nk2Var.findItem(i)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (if4Var.A) {
            f33 f33Var = this.n1;
            removeCallbacks(f33Var);
            post(f33Var);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        d();
        lm3 lm3Var = this.N0;
        boolean z = i == 1;
        if (z == lm3Var.g) {
            return;
        }
        lm3Var.g = z;
        if (!lm3Var.h) {
            lm3Var.a = lm3Var.e;
            lm3Var.b = lm3Var.f;
            return;
        }
        if (z) {
            int i2 = lm3Var.d;
            if (i2 == Integer.MIN_VALUE) {
                i2 = lm3Var.e;
            }
            lm3Var.a = i2;
            int i3 = lm3Var.c;
            if (i3 == Integer.MIN_VALUE) {
                i3 = lm3Var.f;
            }
            lm3Var.b = i3;
            return;
        }
        int i4 = lm3Var.c;
        if (i4 == Integer.MIN_VALUE) {
            i4 = lm3Var.e;
        }
        lm3Var.a = i4;
        int i5 = lm3Var.d;
        if (i5 == Integer.MIN_VALUE) {
            i5 = lm3Var.f;
        }
        lm3Var.b = i5;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        sk2 sk2Var;
        if4 if4Var = new if4(super.onSaveInstanceState());
        ff4 ff4Var = this.g1;
        if (ff4Var != null && (sk2Var = ff4Var.f) != null) {
            if4Var.z = sk2Var.a;
        }
        if4Var.A = r();
        return if4Var;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.V0 = false;
        }
        if (!this.V0) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.V0 = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.V0 = false;
        return true;
    }

    public final void p() {
        Iterator it = this.b1.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(((MenuItem) it.next()).getItemId());
        }
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        MenuInflater menuInflater = getMenuInflater();
        Iterator it2 = ((CopyOnWriteArrayList) this.a1.z).iterator();
        while (it2.hasNext()) {
            ((sj1) it2.next()).a.k(menu, menuInflater);
        }
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.b1 = currentMenuItems2;
    }

    public final boolean q(View view) {
        return view.getParent() == this || this.Y0.contains(view);
    }

    public final boolean r() {
        q3 q3Var;
        ActionMenuView actionMenuView = this.b;
        return (actionMenuView == null || (q3Var = actionMenuView.N0) == null || !q3Var.k()) ? false : true;
    }

    public final int s(View view, int i, int i2, int[] iArr) {
        gf4 gf4Var = (gf4) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) gf4Var).leftMargin - iArr[0];
        int iMax = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        int iK = k(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iK, iMax + measuredWidth, view.getMeasuredHeight() + iK);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) gf4Var).rightMargin + iMax;
    }

    public void setBackInvokedCallbackEnabled(boolean z) {
        if (this.m1 != z) {
            this.m1 = z;
            y();
        }
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c();
        }
        hb hbVar = this.B0;
        if (hbVar != null) {
            hbVar.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            c();
            this.B0.setImageDrawable(drawable);
        } else {
            hb hbVar = this.B0;
            if (hbVar != null) {
                hbVar.setImageDrawable(this.z0);
            }
        }
    }

    public void setCollapsible(boolean z) {
        this.j1 = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.P0) {
            this.P0 = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.O0) {
            this.O0 = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(Drawable drawable) {
        ib ibVar = this.y0;
        if (drawable != null) {
            if (ibVar == null) {
                ibVar = new ib(getContext(), null, 0);
                this.y0 = ibVar;
            }
            if (!q(ibVar)) {
                b(this.y0, true);
            }
        } else if (ibVar != null && q(ibVar)) {
            removeView(this.y0);
            this.Y0.remove(this.y0);
        }
        ib ibVar2 = this.y0;
        if (ibVar2 != null) {
            ibVar2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.y0 == null) {
            this.y0 = new ib(getContext(), null, 0);
        }
        ib ibVar = this.y0;
        if (ibVar != null) {
            ibVar.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        hb hbVar = this.A;
        if (hbVar != null) {
            hbVar.setContentDescription(charSequence);
            ye.H(this.A, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            if (!q(this.A)) {
                b(this.A, true);
            }
        } else {
            hb hbVar = this.A;
            if (hbVar != null && q(hbVar)) {
                removeView(this.A);
                this.Y0.remove(this.A);
            }
        }
        hb hbVar2 = this.A;
        if (hbVar2 != null) {
            hbVar2.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        g();
        this.A.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(hf4 hf4Var) {
        this.c1 = hf4Var;
    }

    public void setOverflowIcon(Drawable drawable) {
        e();
        this.b.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.E0 != i) {
            this.E0 = i;
            if (i == 0) {
                this.D0 = getContext();
            } else {
                this.D0 = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        AppCompatTextView appCompatTextView = this.z;
        if (!zIsEmpty) {
            if (appCompatTextView == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(context);
                this.z = appCompatTextView2;
                appCompatTextView2.setSingleLine();
                this.z.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.G0;
                if (i != 0) {
                    this.z.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.U0;
                if (colorStateList != null) {
                    this.z.setTextColor(colorStateList);
                }
            }
            if (!q(this.z)) {
                b(this.z, true);
            }
        } else if (appCompatTextView != null && q(appCompatTextView)) {
            removeView(this.z);
            this.Y0.remove(this.z);
        }
        AppCompatTextView appCompatTextView3 = this.z;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.S0 = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.U0 = colorStateList;
        AppCompatTextView appCompatTextView = this.z;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        boolean zIsEmpty = TextUtils.isEmpty(charSequence);
        AppCompatTextView appCompatTextView = this.f;
        if (!zIsEmpty) {
            if (appCompatTextView == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(context);
                this.f = appCompatTextView2;
                appCompatTextView2.setSingleLine();
                this.f.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.F0;
                if (i != 0) {
                    this.f.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.T0;
                if (colorStateList != null) {
                    this.f.setTextColor(colorStateList);
                }
            }
            if (!q(this.f)) {
                b(this.f, true);
            }
        } else if (appCompatTextView != null && q(appCompatTextView)) {
            removeView(this.f);
            this.Y0.remove(this.f);
        }
        AppCompatTextView appCompatTextView3 = this.f;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.R0 = charSequence;
    }

    public void setTitleMarginBottom(int i) {
        this.M0 = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.K0 = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.J0 = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.L0 = i;
        requestLayout();
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.T0 = colorStateList;
        AppCompatTextView appCompatTextView = this.f;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public final int t(View view, int i, int i2, int[] iArr) {
        gf4 gf4Var = (gf4) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) gf4Var).rightMargin - iArr[1];
        int iMax = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int iK = k(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iK, iMax, view.getMeasuredHeight() + iK);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) gf4Var).leftMargin);
    }

    public final int u(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i6) + Math.max(0, i5);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + iMax + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    public final void v(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i4 >= 0) {
            if (mode != 0) {
                i4 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i4);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, Pow2.MAX_POW2);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final boolean w(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public final boolean x() {
        q3 q3Var;
        ActionMenuView actionMenuView = this.b;
        return (actionMenuView == null || (q3Var = actionMenuView.N0) == null || !q3Var.n()) ? false : true;
    }

    public final void y() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcherA = ef4.a(this);
            ff4 ff4Var = this.g1;
            int i = 0;
            boolean z = (ff4Var == null || ff4Var.f == null || onBackInvokedDispatcherA == null || !isAttachedToWindow() || !this.m1) ? false : true;
            if (!z || this.l1 != null) {
                if (z || (onBackInvokedDispatcher = this.l1) == null) {
                    return;
                }
                ef4.d(onBackInvokedDispatcher, this.k1);
                this.l1 = null;
                return;
            }
            OnBackInvokedCallback onBackInvokedCallbackB = this.k1;
            if (onBackInvokedCallbackB == null) {
                onBackInvokedCallbackB = ef4.b(new df4(this, i));
                this.k1 = onBackInvokedCallbackB;
            }
            ef4.c(onBackInvokedDispatcherA, onBackInvokedCallbackB);
            this.l1 = onBackInvokedDispatcherA;
        }
    }

    public void setSubtitleTextColor(int i) {
        setSubtitleTextColor(ColorStateList.valueOf(i));
    }

    public void setTitleTextColor(int i) {
        setTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setCollapseContentDescription(int i) {
        setCollapseContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setCollapseIcon(int i) {
        setCollapseIcon(vo.r(getContext(), i));
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return i(layoutParams);
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(vo.r(getContext(), i));
    }

    public void setLogo(int i) {
        setLogo(vo.r(getContext(), i));
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Toolbar(Context context) {
        this(context, null);
    }
}
