package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import defpackage.fl2;
import defpackage.il2;
import defpackage.l3;
import defpackage.lk2;
import defpackage.mk2;
import defpackage.n3;
import defpackage.nk2;
import defpackage.pr1;
import defpackage.pr4;
import defpackage.q3;
import defpackage.r3;
import defpackage.s3;
import defpackage.sk2;
import defpackage.sn;
import defpackage.t3;
import defpackage.za2;
import defpackage.zf2;
import io.netty.channel.internal.ChannelUtils;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements mk2, il2 {
    public nk2 J0;
    public Context K0;
    public int L0;
    public boolean M0;
    public q3 N0;
    public sn O0;
    public lk2 P0;
    public boolean Q0;
    public int R0;
    public final int S0;
    public final int T0;
    public t3 U0;

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.S0 = (int) (56.0f * f);
        this.T0 = (int) (f * 4.0f);
        this.K0 = context;
        this.L0 = 0;
    }

    public static s3 j() {
        s3 s3Var = new s3(-2, -2);
        s3Var.a = false;
        ((LinearLayout.LayoutParams) s3Var).gravity = 16;
        return s3Var;
    }

    public static s3 k(ViewGroup.LayoutParams layoutParams) {
        s3 s3Var;
        if (layoutParams == null) {
            return j();
        }
        if (layoutParams instanceof s3) {
            s3 s3Var2 = (s3) layoutParams;
            s3Var = new s3(s3Var2);
            s3Var.a = s3Var2.a;
        } else {
            s3Var = new s3(layoutParams);
        }
        if (((LinearLayout.LayoutParams) s3Var).gravity <= 0) {
            ((LinearLayout.LayoutParams) s3Var).gravity = 16;
        }
        return s3Var;
    }

    @Override // defpackage.mk2
    public final boolean a(sk2 sk2Var) {
        return this.J0.s(sk2Var, null, 0);
    }

    @Override // defpackage.il2
    public final void b(nk2 nk2Var) {
        this.J0 = nk2Var;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof s3;
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* JADX INFO: renamed from: f */
    public final /* bridge */ /* synthetic */ za2 generateDefaultLayoutParams() {
        return j();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* JADX INFO: renamed from: g */
    public final za2 generateLayoutParams(AttributeSet attributeSet) {
        return new s3(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return j();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new s3(getContext(), attributeSet);
    }

    public Menu getMenu() {
        nk2 nk2Var = this.J0;
        if (nk2Var != null) {
            return nk2Var;
        }
        Context context = getContext();
        nk2 nk2Var2 = new nk2(context);
        this.J0 = nk2Var2;
        nk2Var2.e = new zf2(1, this);
        q3 q3Var = new q3(context);
        this.N0 = q3Var;
        q3Var.D0 = true;
        q3Var.E0 = true;
        fl2 pr1Var = this.O0;
        if (pr1Var == null) {
            pr1Var = new pr1();
        }
        q3Var.X = pr1Var;
        this.J0.b(q3Var, this.K0);
        q3 q3Var2 = this.N0;
        q3Var2.y0 = this;
        nk2 nk2Var3 = q3Var2.z;
        this.J0 = nk2Var3;
        return nk2Var3;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        q3 q3Var = this.N0;
        n3 n3Var = q3Var.A0;
        if (n3Var != null) {
            return n3Var.getDrawable();
        }
        if (q3Var.C0) {
            return q3Var.B0;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.L0;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* JADX INFO: renamed from: h */
    public final /* bridge */ /* synthetic */ za2 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return k(layoutParams);
    }

    public final boolean l(int i) {
        boolean zA = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof r3)) {
            zA = ((r3) childAt).a();
        }
        return (i <= 0 || !(childAt2 instanceof r3)) ? zA : ((r3) childAt2).b() | zA;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        q3 q3Var = this.N0;
        if (q3Var != null) {
            q3Var.c(false);
            if (this.N0.k()) {
                this.N0.g();
                this.N0.n();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q3 q3Var = this.N0;
        if (q3Var != null) {
            q3Var.g();
            l3 l3Var = q3Var.L0;
            if (l3Var == null || !l3Var.b()) {
                return;
            }
            l3Var.i.dismiss();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width;
        int paddingLeft;
        if (!this.Q0) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i5 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i6 = i3 - i;
        int paddingRight = (i6 - getPaddingRight()) - getPaddingLeft();
        boolean z2 = pr4.a;
        boolean z3 = getLayoutDirection() == 1;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                s3 s3Var = (s3) childAt.getLayoutParams();
                if (s3Var.a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (l(i9)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (z3) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) s3Var).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) s3Var).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i10 = i5 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i10, width, measuredHeight + i10);
                    paddingRight -= measuredWidth;
                    i7 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) s3Var).leftMargin) + ((LinearLayout.LayoutParams) s3Var).rightMargin;
                    l(i9);
                    i8++;
                }
            }
        }
        if (childCount == 1 && i7 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i11 = (i6 / 2) - (measuredWidth2 / 2);
            int i12 = i5 - (measuredHeight2 / 2);
            childAt2.layout(i11, i12, measuredWidth2 + i11, measuredHeight2 + i12);
            return;
        }
        int i13 = i8 - (i7 ^ 1);
        int iMax = Math.max(0, i13 > 0 ? paddingRight / i13 : 0);
        if (z3) {
            int width2 = getWidth() - getPaddingRight();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt3 = getChildAt(i14);
                s3 s3Var2 = (s3) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !s3Var2.a) {
                    int i15 = width2 - ((LinearLayout.LayoutParams) s3Var2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i16 = i5 - (measuredHeight3 / 2);
                    childAt3.layout(i15 - measuredWidth3, i16, i15, measuredHeight3 + i16);
                    width2 = i15 - ((measuredWidth3 + ((LinearLayout.LayoutParams) s3Var2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt4 = getChildAt(i17);
            s3 s3Var3 = (s3) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !s3Var3.a) {
                int i18 = paddingLeft2 + ((LinearLayout.LayoutParams) s3Var3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i19 = i5 - (measuredHeight4 / 2);
                childAt4.layout(i18, i19, i18 + measuredWidth4, measuredHeight4 + i19);
                paddingLeft2 = measuredWidth4 + ((LinearLayout.LayoutParams) s3Var3).rightMargin + iMax + i18;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v41 */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        int i4;
        ?? r11;
        int i5;
        int i6;
        nk2 nk2Var;
        boolean z = this.Q0;
        boolean z2 = View.MeasureSpec.getMode(i) == 1073741824;
        this.Q0 = z2;
        if (z != z2) {
            this.R0 = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.Q0 && (nk2Var = this.J0) != null && size != this.R0) {
            this.R0 = size;
            nk2Var.r(true);
        }
        int childCount = getChildCount();
        if (!this.Q0 || childCount <= 0) {
            for (int i7 = 0; i7 < childCount; i7++) {
                s3 s3Var = (s3) getChildAt(i7).getLayoutParams();
                ((LinearLayout.LayoutParams) s3Var).rightMargin = 0;
                ((LinearLayout.LayoutParams) s3Var).leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i);
        int size3 = View.MeasureSpec.getSize(i2);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingBottom, -2);
        int i8 = size2 - paddingRight;
        int i9 = this.S0;
        int i10 = i8 / i9;
        int i11 = i8 % i9;
        if (i10 == 0) {
            setMeasuredDimension(i8, 0);
            return;
        }
        int i12 = (i11 / i10) + i9;
        int childCount2 = getChildCount();
        int iMax = 0;
        int i13 = 0;
        int iMax2 = 0;
        int i14 = 0;
        boolean z3 = false;
        int i15 = 0;
        long j = 0;
        while (true) {
            i3 = this.T0;
            if (i14 >= childCount2) {
                break;
            }
            View childAt = getChildAt(i14);
            int i16 = size3;
            int i17 = paddingBottom;
            if (childAt.getVisibility() == 8) {
                i5 = i12;
            } else {
                boolean z4 = childAt instanceof ActionMenuItemView;
                i13++;
                if (z4) {
                    childAt.setPadding(i3, 0, i3, 0);
                }
                s3 s3Var2 = (s3) childAt.getLayoutParams();
                s3Var2.f = false;
                s3Var2.c = 0;
                s3Var2.b = 0;
                s3Var2.d = false;
                ((LinearLayout.LayoutParams) s3Var2).leftMargin = 0;
                ((LinearLayout.LayoutParams) s3Var2).rightMargin = 0;
                s3Var2.e = z4 && !TextUtils.isEmpty(((ActionMenuItemView) childAt).getText());
                int i18 = s3Var2.a ? 1 : i10;
                s3 s3Var3 = (s3) childAt.getLayoutParams();
                int i19 = i10;
                i5 = i12;
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - i17, View.MeasureSpec.getMode(childMeasureSpec));
                ActionMenuItemView actionMenuItemView = z4 ? (ActionMenuItemView) childAt : null;
                boolean z5 = (actionMenuItemView == null || TextUtils.isEmpty(actionMenuItemView.getText())) ? false : true;
                boolean z6 = z5;
                if (i18 <= 0 || (z5 && i18 < 2)) {
                    i6 = 0;
                } else {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i5 * i18, Integer.MIN_VALUE), iMakeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i6 = measuredWidth / i5;
                    if (measuredWidth % i5 != 0) {
                        i6++;
                    }
                    if (z6 && i6 < 2) {
                        i6 = 2;
                    }
                }
                s3Var3.d = !s3Var3.a && z6;
                s3Var3.b = i6;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i6 * i5, Pow2.MAX_POW2), iMakeMeasureSpec);
                iMax2 = Math.max(iMax2, i6);
                if (s3Var2.d) {
                    i15++;
                }
                if (s3Var2.a) {
                    z3 = true;
                }
                i10 = i19 - i6;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (i6 == 1) {
                    j |= (long) (1 << i14);
                }
            }
            i14++;
            size3 = i16;
            paddingBottom = i17;
            i12 = i5;
        }
        int i20 = size3;
        int i21 = i10;
        int i22 = i12;
        boolean z7 = z3 && i13 == 2;
        int i23 = i21;
        boolean z8 = false;
        while (i15 > 0 && i23 > 0) {
            int i24 = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
            long j2 = 0;
            int i25 = 0;
            int i26 = 0;
            while (i26 < childCount2) {
                int i27 = iMax;
                s3 s3Var4 = (s3) getChildAt(i26).getLayoutParams();
                boolean z9 = z7;
                if (s3Var4.d) {
                    int i28 = s3Var4.b;
                    if (i28 < i24) {
                        j2 = 1 << i26;
                        i24 = i28;
                        i25 = 1;
                    } else if (i28 == i24) {
                        j2 |= 1 << i26;
                        i25++;
                    }
                }
                i26++;
                z7 = z9;
                iMax = i27;
            }
            i4 = iMax;
            boolean z10 = z7;
            j |= j2;
            if (i25 > i23) {
                break;
            }
            int i29 = i24 + 1;
            int i30 = 0;
            while (i30 < childCount2) {
                View childAt2 = getChildAt(i30);
                s3 s3Var5 = (s3) childAt2.getLayoutParams();
                boolean z11 = z3;
                long j3 = 1 << i30;
                if ((j2 & j3) != 0) {
                    if (z10 && s3Var5.e) {
                        r11 = 1;
                        r11 = 1;
                        if (i23 == 1) {
                            childAt2.setPadding(i3 + i22, 0, i3, 0);
                        }
                    } else {
                        r11 = 1;
                    }
                    s3Var5.b += r11;
                    s3Var5.f = r11;
                    i23--;
                } else if (s3Var5.b == i29) {
                    j |= j3;
                }
                i30++;
                z3 = z11;
            }
            z7 = z10;
            iMax = i4;
            z8 = true;
        }
        i4 = iMax;
        boolean z12 = !z3 && i13 == 1;
        if (i23 > 0 && j != 0 && (i23 < i13 - 1 || z12 || iMax2 > 1)) {
            float fBitCount = Long.bitCount(j);
            if (!z12) {
                if ((j & 1) != 0 && !((s3) getChildAt(0).getLayoutParams()).e) {
                    fBitCount -= 0.5f;
                }
                int i31 = childCount2 - 1;
                if ((j & ((long) (1 << i31))) != 0 && !((s3) getChildAt(i31).getLayoutParams()).e) {
                    fBitCount -= 0.5f;
                }
            }
            int i32 = fBitCount > 0.0f ? (int) ((i23 * i22) / fBitCount) : 0;
            boolean z13 = z8;
            for (int i33 = 0; i33 < childCount2; i33++) {
                if ((j & ((long) (1 << i33))) != 0) {
                    View childAt3 = getChildAt(i33);
                    s3 s3Var6 = (s3) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        s3Var6.c = i32;
                        s3Var6.f = true;
                        if (i33 == 0 && !s3Var6.e) {
                            ((LinearLayout.LayoutParams) s3Var6).leftMargin = (-i32) / 2;
                        }
                        z13 = true;
                    } else if (s3Var6.a) {
                        s3Var6.c = i32;
                        s3Var6.f = true;
                        ((LinearLayout.LayoutParams) s3Var6).rightMargin = (-i32) / 2;
                        z13 = true;
                    } else {
                        if (i33 != 0) {
                            ((LinearLayout.LayoutParams) s3Var6).leftMargin = i32 / 2;
                        }
                        if (i33 != childCount2 - 1) {
                            ((LinearLayout.LayoutParams) s3Var6).rightMargin = i32 / 2;
                        }
                    }
                }
            }
            z8 = z13;
        }
        if (z8) {
            for (int i34 = 0; i34 < childCount2; i34++) {
                View childAt4 = getChildAt(i34);
                s3 s3Var7 = (s3) childAt4.getLayoutParams();
                if (s3Var7.f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((s3Var7.b * i22) + s3Var7.c, Pow2.MAX_POW2), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i8, mode != 1073741824 ? i4 : i20);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.N0.I0 = z;
    }

    public void setOnMenuItemClickListener(t3 t3Var) {
        this.U0 = t3Var;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        q3 q3Var = this.N0;
        n3 n3Var = q3Var.A0;
        if (n3Var != null) {
            n3Var.setImageDrawable(drawable);
        } else {
            q3Var.C0 = true;
            q3Var.B0 = drawable;
        }
    }

    public void setOverflowReserved(boolean z) {
        this.M0 = z;
    }

    public void setPopupTheme(int i) {
        if (this.L0 != i) {
            this.L0 = i;
            if (i == 0) {
                this.K0 = getContext();
            } else {
                this.K0 = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(q3 q3Var) {
        this.N0 = q3Var;
        q3Var.y0 = this;
        this.J0 = q3Var.z;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return k(layoutParams);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }
}
