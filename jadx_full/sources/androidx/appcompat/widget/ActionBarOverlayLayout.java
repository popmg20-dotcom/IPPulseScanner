package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import com.getsurfboard.R;
import defpackage.bv4;
import defpackage.d3;
import defpackage.dr4;
import defpackage.e3;
import defpackage.f3;
import defpackage.ff4;
import defpackage.fl2;
import defpackage.g3;
import defpackage.h3;
import defpackage.hm2;
import defpackage.iu4;
import defpackage.ju4;
import defpackage.ku4;
import defpackage.lu4;
import defpackage.mf4;
import defpackage.mp4;
import defpackage.mu4;
import defpackage.nk2;
import defpackage.nu4;
import defpackage.ou4;
import defpackage.pu4;
import defpackage.q3;
import defpackage.rk0;
import defpackage.t02;
import defpackage.vo;
import defpackage.vt4;
import defpackage.wp4;
import defpackage.xe;
import defpackage.yq2;
import defpackage.yu4;
import defpackage.zq2;
import io.netty.channel.internal.ChannelUtils;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements yq2, zq2 {
    public static final int[] W0 = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};
    public static final bv4 X0;
    public static final Rect Y0;
    public ActionBarContainer A;
    public boolean A0;
    public boolean B0;
    public boolean C0;
    public boolean D0;
    public int E0;
    public int F0;
    public final Rect G0;
    public final Rect H0;
    public final Rect I0;
    public final Rect J0;
    public bv4 K0;
    public bv4 L0;
    public bv4 M0;
    public bv4 N0;
    public f3 O0;
    public OverScroller P0;
    public ViewPropertyAnimator Q0;
    public final d3 R0;
    public final e3 S0;
    public final e3 T0;
    public final hm2 U0;
    public final h3 V0;
    public int b;
    public int f;
    public rk0 y0;
    public ContentFrameLayout z;
    public Drawable z0;

    static {
        int i = Build.VERSION.SDK_INT;
        pu4 ou4Var = i >= 36 ? new ou4() : i >= 35 ? new nu4() : i >= 34 ? new mu4() : i >= 31 ? new lu4() : i >= 30 ? new ku4() : i >= 29 ? new ju4() : new iu4();
        ou4Var.h(t02.c(0, 1, 0, 1));
        X0 = ou4Var.b();
        Y0 = new Rect();
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 0;
        this.G0 = new Rect();
        this.H0 = new Rect();
        this.I0 = new Rect();
        this.J0 = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        bv4 bv4Var = bv4.b;
        this.K0 = bv4Var;
        this.L0 = bv4Var;
        this.M0 = bv4Var;
        this.N0 = bv4Var;
        this.R0 = new d3(0, this);
        this.S0 = new e3(this, 0);
        this.T0 = new e3(this, 1);
        i(context);
        this.U0 = new hm2(4);
        h3 h3Var = new h3(context);
        h3Var.setWillNotDraw(true);
        this.V0 = h3Var;
        addView(h3Var);
    }

    public static boolean g(View view, Rect rect, boolean z) {
        boolean z2;
        g3 g3Var = (g3) view.getLayoutParams();
        int i = ((ViewGroup.MarginLayoutParams) g3Var).leftMargin;
        int i2 = rect.left;
        if (i != i2) {
            ((ViewGroup.MarginLayoutParams) g3Var).leftMargin = i2;
            z2 = true;
        } else {
            z2 = false;
        }
        int i3 = ((ViewGroup.MarginLayoutParams) g3Var).topMargin;
        int i4 = rect.top;
        if (i3 != i4) {
            ((ViewGroup.MarginLayoutParams) g3Var).topMargin = i4;
            z2 = true;
        }
        int i5 = ((ViewGroup.MarginLayoutParams) g3Var).rightMargin;
        int i6 = rect.right;
        if (i5 != i6) {
            ((ViewGroup.MarginLayoutParams) g3Var).rightMargin = i6;
            z2 = true;
        }
        if (z) {
            int i7 = ((ViewGroup.MarginLayoutParams) g3Var).bottomMargin;
            int i8 = rect.bottom;
            if (i7 != i8) {
                ((ViewGroup.MarginLayoutParams) g3Var).bottomMargin = i8;
                return true;
            }
        }
        return z2;
    }

    @Override // defpackage.zq2
    public final void a(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        b(view, i, i2, i3, i4, i5);
    }

    @Override // defpackage.yq2
    public final void b(View view, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    @Override // defpackage.yq2
    public final boolean c(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof g3;
    }

    @Override // defpackage.yq2
    public final void d(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int translationY;
        super.draw(canvas);
        if (this.z0 != null) {
            if (this.A.getVisibility() == 0) {
                translationY = (int) (this.A.getTranslationY() + this.A.getBottom() + 0.5f);
            } else {
                translationY = 0;
            }
            this.z0.setBounds(0, translationY, getWidth(), this.z0.getIntrinsicHeight() + translationY);
            this.z0.draw(canvas);
        }
    }

    @Override // defpackage.yq2
    public final void e(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new g3(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new g3(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.A;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        hm2 hm2Var = this.U0;
        return hm2Var.c | hm2Var.b;
    }

    public CharSequence getTitle() {
        k();
        return ((mf4) this.y0).a.getTitle();
    }

    public final void h() {
        removeCallbacks(this.S0);
        removeCallbacks(this.T0);
        ViewPropertyAnimator viewPropertyAnimator = this.Q0;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void i(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(W0);
        this.b = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(1);
        this.z0 = drawable;
        setWillNotDraw(drawable == null);
        typedArrayObtainStyledAttributes.recycle();
        this.P0 = new OverScroller(context);
    }

    public final void j(int i) {
        k();
        if (i == 2) {
            ((mf4) this.y0).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else if (i == 5) {
            ((mf4) this.y0).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else {
            if (i != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    public final void k() {
        rk0 wrapper;
        if (this.z == null) {
            this.z = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.A = (ActionBarContainer) findViewById(R.id.action_bar_container);
            KeyEvent.Callback callbackFindViewById = findViewById(R.id.action_bar);
            if (callbackFindViewById instanceof rk0) {
                wrapper = (rk0) callbackFindViewById;
            } else {
                if (!(callbackFindViewById instanceof Toolbar)) {
                    xe.q("Can't make a decor toolbar out of ".concat(callbackFindViewById.getClass().getSimpleName()));
                    return;
                }
                wrapper = ((Toolbar) callbackFindViewById).getWrapper();
            }
            this.y0 = wrapper;
        }
    }

    public final void l(nk2 nk2Var, fl2 fl2Var) {
        k();
        mf4 mf4Var = (mf4) this.y0;
        Toolbar toolbar = mf4Var.a;
        q3 q3Var = mf4Var.m;
        if (q3Var == null) {
            q3Var = new q3(toolbar.getContext());
            mf4Var.m = q3Var;
            q3Var.z0 = R.id.action_menu_presenter;
        }
        q3Var.X = fl2Var;
        if (nk2Var == null && toolbar.b == null) {
            return;
        }
        toolbar.f();
        nk2 nk2Var2 = toolbar.b.J0;
        if (nk2Var2 == nk2Var) {
            return;
        }
        if (nk2Var2 != null) {
            nk2Var2.t(toolbar.f1);
            nk2Var2.t(toolbar.g1);
        }
        if (toolbar.g1 == null) {
            toolbar.g1 = new ff4(toolbar);
        }
        q3Var.I0 = true;
        Context context = toolbar.D0;
        if (nk2Var != null) {
            nk2Var.b(q3Var, context);
            nk2Var.b(toolbar.g1, toolbar.D0);
        } else {
            q3Var.l(context, null);
            toolbar.g1.l(toolbar.D0, null);
            q3Var.c(true);
            toolbar.g1.c(true);
        }
        toolbar.b.setPopupTheme(toolbar.E0);
        toolbar.b.setPresenter(q3Var);
        toolbar.f1 = q3Var;
        toolbar.y();
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        k();
        bv4 bv4VarG = bv4.g(windowInsets, this);
        boolean zG = g(this.A, new Rect(bv4VarG.b(), bv4VarG.d(), bv4VarG.c(), bv4VarG.a()), false);
        WeakHashMap weakHashMap = wp4.a;
        Rect rect = this.G0;
        mp4.b(this, bv4VarG, rect);
        int i = rect.left;
        int i2 = rect.top;
        int i3 = rect.right;
        int i4 = rect.bottom;
        yu4 yu4Var = bv4VarG.a;
        bv4 bv4VarQ = yu4Var.q(i, i2, i3, i4);
        this.K0 = bv4VarQ;
        boolean z = true;
        if (!this.L0.equals(bv4VarQ)) {
            this.L0 = this.K0;
            zG = true;
        }
        Rect rect2 = this.H0;
        if (rect2.equals(rect)) {
            z = zG;
        } else {
            rect2.set(rect);
        }
        if (z) {
            requestLayout();
        }
        return yu4Var.a().a.c().a.b().f();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        i(getContext());
        WeakHashMap weakHashMap = wp4.a;
        requestApplyInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                g3 g3Var = (g3) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = ((ViewGroup.MarginLayoutParams) g3Var).leftMargin + paddingLeft;
                int i7 = ((ViewGroup.MarginLayoutParams) g3Var).topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00ab  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onMeasure(int i, int i2) {
        int measuredHeight;
        k();
        measureChildWithMargins(this.A, i, 0, i2, 0);
        g3 g3Var = (g3) this.A.getLayoutParams();
        int iMax = Math.max(0, this.A.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) g3Var).leftMargin + ((ViewGroup.MarginLayoutParams) g3Var).rightMargin);
        int iMax2 = Math.max(0, this.A.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) g3Var).topMargin + ((ViewGroup.MarginLayoutParams) g3Var).bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.A.getMeasuredState());
        WeakHashMap weakHashMap = wp4.a;
        boolean z = (getWindowSystemUiVisibility() & 256) != 0;
        if (z) {
            measuredHeight = this.b;
            if (this.B0 && this.A.getTabContainer() != null) {
                measuredHeight += this.b;
            }
        } else {
            measuredHeight = this.A.getVisibility() != 8 ? this.A.getMeasuredHeight() : 0;
        }
        Rect rect = this.G0;
        Rect rect2 = this.I0;
        rect2.set(rect);
        this.M0 = this.K0;
        if (this.A0 || z) {
            t02 t02VarC = t02.c(this.M0.b(), this.M0.d() + measuredHeight, this.M0.c(), this.M0.a());
            bv4 bv4Var = this.M0;
            int i3 = Build.VERSION.SDK_INT;
            pu4 ou4Var = i3 >= 36 ? new ou4(bv4Var) : i3 >= 35 ? new nu4(bv4Var) : i3 >= 34 ? new mu4(bv4Var) : i3 >= 31 ? new lu4(bv4Var) : i3 >= 30 ? new ku4(bv4Var) : i3 >= 29 ? new ju4(bv4Var) : new iu4(bv4Var);
            ou4Var.h(t02VarC);
            this.M0 = ou4Var.b();
        } else {
            h3 h3Var = this.V0;
            bv4 bv4Var2 = X0;
            Rect rect3 = this.J0;
            mp4.b(h3Var, bv4Var2, rect3);
            if (!rect3.equals(Y0)) {
                rect2.top += measuredHeight;
                rect2.bottom = rect2.bottom;
                this.M0 = this.M0.a.q(0, measuredHeight, 0, 0);
            }
        }
        g(this.z, rect2, true);
        if (!this.N0.equals(this.M0)) {
            bv4 bv4Var3 = this.M0;
            this.N0 = bv4Var3;
            wp4.b(this.z, bv4Var3);
        }
        measureChildWithMargins(this.z, i, 0, i2, 0);
        g3 g3Var2 = (g3) this.z.getLayoutParams();
        int iMax3 = Math.max(iMax, this.z.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) g3Var2).leftMargin + ((ViewGroup.MarginLayoutParams) g3Var2).rightMargin);
        int iMax4 = Math.max(iMax2, this.z.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) g3Var2).topMargin + ((ViewGroup.MarginLayoutParams) g3Var2).bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.z.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + iMax3, getSuggestedMinimumWidth()), i, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax4, getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.C0 || !z) {
            return false;
        }
        this.P0.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, ChannelUtils.WRITE_STATUS_SNDBUF_FULL);
        if (this.P0.getFinalY() > this.A.getHeight()) {
            h();
            this.T0.run();
        } else {
            h();
            this.S0.run();
        }
        this.D0 = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5 = this.E0 + i2;
        this.E0 = i5;
        setActionBarHideOffset(i5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        vt4 vt4Var;
        dr4 dr4Var;
        this.U0.b = i;
        this.E0 = getActionBarHideOffset();
        h();
        f3 f3Var = this.O0;
        if (f3Var == null || (dr4Var = (vt4Var = (vt4) f3Var).D) == null) {
            return;
        }
        dr4Var.a();
        vt4Var.D = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.A.getVisibility() != 0) {
            return false;
        }
        return this.C0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.C0 || this.D0) {
            return;
        }
        if (this.E0 <= this.A.getHeight()) {
            h();
            postDelayed(this.S0, 600L);
        } else {
            h();
            postDelayed(this.T0, 600L);
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i) {
        super.onWindowSystemUiVisibilityChanged(i);
        k();
        int i2 = this.F0 ^ i;
        this.F0 = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        f3 f3Var = this.O0;
        if (f3Var != null) {
            vt4 vt4Var = (vt4) f3Var;
            vt4Var.z = !z2;
            if (z || !z2) {
                if (vt4Var.A) {
                    vt4Var.A = false;
                    vt4Var.s0(true);
                }
            } else if (!vt4Var.A) {
                vt4Var.A = true;
                vt4Var.s0(true);
            }
        }
        if ((i2 & 256) == 0 || this.O0 == null) {
            return;
        }
        WeakHashMap weakHashMap = wp4.a;
        requestApplyInsets();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f = i;
        f3 f3Var = this.O0;
        if (f3Var != null) {
            ((vt4) f3Var).y = i;
        }
    }

    public void setActionBarHideOffset(int i) {
        h();
        this.A.setTranslationY(-Math.max(0, Math.min(i, this.A.getHeight())));
    }

    public void setActionBarVisibilityCallback(f3 f3Var) {
        this.O0 = f3Var;
        if (getWindowToken() != null) {
            ((vt4) this.O0).y = this.f;
            int i = this.F0;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                WeakHashMap weakHashMap = wp4.a;
                requestApplyInsets();
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.B0 = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.C0) {
            this.C0 = z;
            if (z) {
                return;
            }
            h();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i) {
        k();
        mf4 mf4Var = (mf4) this.y0;
        mf4Var.d = i != 0 ? vo.r(mf4Var.a.getContext(), i) : null;
        mf4Var.c();
    }

    public void setLogo(int i) {
        k();
        mf4 mf4Var = (mf4) this.y0;
        mf4Var.e = i != 0 ? vo.r(mf4Var.a.getContext(), i) : null;
        mf4Var.c();
    }

    public void setOverlayMode(boolean z) {
        this.A0 = z;
    }

    public void setWindowCallback(Window.Callback callback) {
        k();
        ((mf4) this.y0).k = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        k();
        mf4 mf4Var = (mf4) this.y0;
        if (mf4Var.g) {
            return;
        }
        Toolbar toolbar = mf4Var.a;
        mf4Var.h = charSequence;
        if ((mf4Var.b & 8) != 0) {
            toolbar.setTitle(charSequence);
            if (mf4Var.g) {
                wp4.o(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new g3(layoutParams);
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    public void setIcon(Drawable drawable) {
        k();
        mf4 mf4Var = (mf4) this.y0;
        mf4Var.d = drawable;
        mf4Var.c();
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // defpackage.yq2
    public final void f(View view, int i, int i2, int[] iArr, int i3) {
    }
}
