package androidx.slidingpanelayout.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import defpackage.bv4;
import defpackage.cr1;
import defpackage.dy3;
import defpackage.ey3;
import defpackage.fw3;
import defpackage.fy3;
import defpackage.ge0;
import defpackage.gy3;
import defpackage.ha1;
import defpackage.hj;
import defpackage.hw3;
import defpackage.hy3;
import defpackage.ji0;
import defpackage.jo;
import defpackage.jw3;
import defpackage.n12;
import defpackage.np4;
import defpackage.o84;
import defpackage.ot4;
import defpackage.p95;
import defpackage.qe4;
import defpackage.t02;
import defpackage.ue2;
import defpackage.v9;
import defpackage.vh1;
import defpackage.wn1;
import defpackage.wp4;
import defpackage.wt4;
import defpackage.xo4;
import defpackage.xt4;
import defpackage.yd;
import defpackage.yt4;
import defpackage.z14;
import defpackage.zp4;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class SlidingPaneLayout extends ViewGroup {
    public static final boolean S0;
    public Drawable A;
    public float A0;
    public float B0;
    public int C0;
    public boolean D0;
    public int E0;
    public float F0;
    public float G0;
    public final CopyOnWriteArrayList H0;
    public fy3 I0;
    public final zp4 J0;
    public boolean K0;
    public boolean L0;
    public final Rect M0;
    public final ArrayList N0;
    public int O0;
    public cr1 P0;
    public final ha1 Q0;
    public vh1 R0;
    public int b;
    public int f;
    public boolean y0;
    public Drawable z;
    public View z0;

    static {
        S0 = Build.VERSION.SDK_INT >= 29;
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.b = 0;
        this.A0 = 1.0f;
        this.H0 = new CopyOnWriteArrayList();
        this.L0 = true;
        this.M0 = new Rect();
        this.N0 = new ArrayList();
        this.Q0 = new ha1(24, this);
        float f = context.getResources().getDisplayMetrics().density;
        setWillNotDraw(false);
        wp4.n(this, new dy3(this));
        setImportantForAccessibility(1);
        zp4 zp4Var = new zp4(getContext(), this, new jo(2, this));
        zp4Var.b = (int) (2.0f * zp4Var.b);
        this.J0 = zp4Var;
        zp4Var.n = f * 400.0f;
        int i = wt4.a;
        yt4.p0.getClass();
        ot4 ot4Var = (ot4) xt4.b.getValue();
        if (ot4Var == null) {
            jw3 jw3Var = jw3.c;
            if (jw3.c == null) {
                ReentrantLock reentrantLock = jw3.d;
                reentrantLock.lock();
                try {
                    if (jw3.c == null) {
                        hw3 hw3Var = null;
                        try {
                            xo4 xo4VarB = fw3.b();
                            if (xo4VarB != null) {
                                xo4 xo4Var = xo4.Y;
                                xo4Var.getClass();
                                Object value = xo4VarB.X.getValue();
                                value.getClass();
                                Object value2 = xo4Var.X.getValue();
                                value2.getClass();
                                if (((BigInteger) value).compareTo((BigInteger) value2) >= 0) {
                                    hw3 hw3Var2 = new hw3(context);
                                    if (hw3Var2.e()) {
                                        hw3Var = hw3Var2;
                                    }
                                }
                            }
                        } catch (Throwable unused) {
                        }
                        jw3.c = new jw3(hw3Var);
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            ot4Var = jw3.c;
            ot4Var.getClass();
        }
        o84 o84Var = new o84(4);
        new ArrayList(new yd(new Integer[]{1, 2, 4, 8, 16, 32, 64, 128}, true));
        wn1 wn1Var = new wn1(o84Var, ot4Var, new ue2(9));
        xt4.c.getClass();
        setFoldingFeatureObserver(new vh1(wn1Var, v9.i(context)));
    }

    private t02 getSystemGestureInsets() {
        if (!S0) {
            return null;
        }
        WeakHashMap weakHashMap = wp4.a;
        bv4 bv4VarA = np4.a(this);
        if (bv4VarA != null) {
            return bv4VarA.a.l();
        }
        return null;
    }

    private void setFoldingFeatureObserver(vh1 vh1Var) {
        this.R0 = vh1Var;
        vh1Var.getClass();
        ha1 ha1Var = this.Q0;
        ha1Var.getClass();
        vh1Var.d = ha1Var;
    }

    public final boolean a() {
        if (!this.y0) {
            this.K0 = false;
        }
        if (!this.L0 && !g(1.0f)) {
            return false;
        }
        this.K0 = false;
        return true;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() != 1) {
            super.addView(view, i, layoutParams);
            return;
        }
        hy3 hy3Var = new hy3(view.getContext());
        hy3Var.addView(view);
        super.addView(hy3Var, i, layoutParams);
    }

    public final boolean b(View view) {
        if (view == null) {
            return false;
        }
        return this.y0 && ((ey3) view.getLayoutParams()).c && this.A0 > 0.0f;
    }

    public final boolean c() {
        WeakHashMap weakHashMap = wp4.a;
        return getLayoutDirection() == 1;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof ey3) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public final void computeScroll() {
        zp4 zp4Var = this.J0;
        if (zp4Var.h()) {
            if (!this.y0) {
                zp4Var.a();
            } else {
                WeakHashMap weakHashMap = wp4.a;
                postInvalidateOnAnimation();
            }
        }
    }

    public final boolean d() {
        return !this.y0 || this.A0 == 0.0f;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i;
        int right;
        super.draw(canvas);
        Drawable drawable = c() ? this.A : this.z;
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt == null || drawable == null) {
            return;
        }
        int top = childAt.getTop();
        int bottom = childAt.getBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (c()) {
            right = childAt.getRight();
            i = intrinsicWidth + right;
        } else {
            int left = childAt.getLeft();
            int i2 = left - intrinsicWidth;
            i = left;
            right = i2;
        }
        drawable.setBounds(right, top, i, bottom);
        drawable.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        boolean zC = c() ^ d();
        zp4 zp4Var = this.J0;
        if (zC) {
            zp4Var.q = 1;
            t02 systemGestureInsets = getSystemGestureInsets();
            if (systemGestureInsets != null) {
                zp4Var.o = Math.max(zp4Var.p, systemGestureInsets.a);
            }
        } else {
            zp4Var.q = 2;
            t02 systemGestureInsets2 = getSystemGestureInsets();
            if (systemGestureInsets2 != null) {
                zp4Var.o = Math.max(zp4Var.p, systemGestureInsets2.c);
            }
        }
        ey3 ey3Var = (ey3) view.getLayoutParams();
        int iSave = canvas.save();
        if (this.y0 && !ey3Var.b && this.z0 != null) {
            Rect rect = this.M0;
            canvas.getClipBounds(rect);
            if (c()) {
                rect.left = Math.max(rect.left, this.z0.getRight());
            } else {
                rect.right = Math.min(rect.right, this.z0.getLeft());
            }
            canvas.clipRect(rect);
        }
        boolean zDrawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(iSave);
        return zDrawChild;
    }

    public final void e() {
        if (!this.y0) {
            this.K0 = true;
        }
        if (this.L0 || g(0.0f)) {
            this.K0 = true;
        }
    }

    public final void f(float f) {
        boolean zC = c();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != this.z0) {
                float f2 = 1.0f - this.B0;
                int i2 = this.E0;
                this.B0 = f;
                int i3 = ((int) (f2 * i2)) - ((int) ((1.0f - f) * i2));
                if (zC) {
                    i3 = -i3;
                }
                childAt.offsetLeftAndRight(i3);
            }
        }
    }

    public final boolean g(float f) {
        int paddingLeft;
        if (this.y0) {
            boolean zC = c();
            ey3 ey3Var = (ey3) this.z0.getLayoutParams();
            if (zC) {
                int paddingRight = getPaddingRight() + ((ViewGroup.MarginLayoutParams) ey3Var).rightMargin;
                paddingLeft = (int) (getWidth() - (((f * this.C0) + paddingRight) + this.z0.getWidth()));
            } else {
                paddingLeft = (int) ((f * this.C0) + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) ey3Var).leftMargin);
            }
            View view = this.z0;
            if (this.J0.t(view, paddingLeft, view.getTop())) {
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    if (childAt.getVisibility() == 4) {
                        childAt.setVisibility(0);
                    }
                }
                WeakHashMap weakHashMap = wp4.a;
                postInvalidateOnAnimation();
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ey3 ey3Var = new ey3(-1, -1);
        ey3Var.a = 0.0f;
        return ey3Var;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        ey3 ey3Var = new ey3(context, attributeSet);
        ey3Var.a = 0.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ey3.d);
        ey3Var.a = typedArrayObtainStyledAttributes.getFloat(0, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        return ey3Var;
    }

    @Deprecated
    public int getCoveredFadeColor() {
        return this.f;
    }

    public final int getLockMode() {
        return this.O0;
    }

    public int getParallaxDistance() {
        return this.E0;
    }

    @Deprecated
    public int getSliderFadeColor() {
        return this.b;
    }

    public final void h(View view) {
        int left;
        int right;
        int top;
        int bottom;
        boolean z;
        View view2 = view;
        boolean zC = c();
        int width = zC ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = zC ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !view2.isOpaque()) {
            left = 0;
            right = 0;
            top = 0;
            bottom = 0;
        } else {
            left = view2.getLeft();
            right = view2.getRight();
            top = view2.getTop();
            bottom = view2.getBottom();
        }
        int childCount = getChildCount();
        int i = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (childAt == view2) {
                return;
            }
            if (childAt.getVisibility() == 8) {
                z = zC;
            } else {
                z = zC;
                childAt.setVisibility((Math.max(zC ? paddingLeft : width, childAt.getLeft()) < left || Math.max(paddingTop, childAt.getTop()) < top || Math.min(zC ? width : paddingLeft, childAt.getRight()) > right || Math.min(height, childAt.getBottom()) > bottom) ? 0 : 4);
            }
            i++;
            view2 = view;
            zC = z;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        ge0 ge0Var;
        Activity activity;
        super.onAttachedToWindow();
        this.L0 = true;
        if (this.R0 != null) {
            Context context = getContext();
            while (true) {
                ge0Var = null;
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                } else {
                    if (context instanceof Activity) {
                        activity = (Activity) context;
                        break;
                    }
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            if (activity != null) {
                vh1 vh1Var = this.R0;
                vh1Var.getClass();
                z14 z14Var = vh1Var.c;
                if (z14Var != null) {
                    z14Var.g(null);
                }
                vh1Var.c = ji0.B(p95.a(n12.x(vh1Var.b)), null, null, new hj(vh1Var, activity, ge0Var, 17), 3);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        z14 z14Var;
        super.onDetachedFromWindow();
        this.L0 = true;
        vh1 vh1Var = this.R0;
        if (vh1Var != null && (z14Var = vh1Var.c) != null) {
            z14Var.g(null);
        }
        ArrayList arrayList = this.N0;
        if (arrayList.size() > 0) {
            throw qe4.r(arrayList, 0);
        }
        arrayList.clear();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        boolean z2 = this.y0;
        zp4 zp4Var = this.J0;
        if (!z2 && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            zp4Var.getClass();
            this.K0 = zp4.k(childAt, x, y);
        }
        if (!this.y0 || (this.D0 && actionMasked != 0)) {
            zp4Var.b();
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (actionMasked == 3 || actionMasked == 1) {
            zp4Var.b();
            return false;
        }
        if (actionMasked == 0) {
            this.D0 = false;
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            this.F0 = x2;
            this.G0 = y2;
            zp4Var.getClass();
            if (zp4.k(this.z0, (int) x2, (int) y2) && b(this.z0)) {
                z = true;
            }
            return !zp4Var.s(motionEvent) || z;
        }
        if (actionMasked == 2) {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            float fAbs = Math.abs(x3 - this.F0);
            float fAbs2 = Math.abs(y3 - this.G0);
            if (fAbs > zp4Var.b && fAbs2 > fAbs) {
                zp4Var.b();
                this.D0 = true;
                return false;
            }
        }
        z = false;
        if (zp4Var.s(motionEvent)) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e6  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0089 A[PHI: r17
      0x0089: PHI (r17v3 float) = (r17v1 float), (r17v4 float) binds: [B:19:0x007f, B:21:0x0085] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01b6  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v30 */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r24, int r25) {
        /*
            Method dump skipped, instruction units count: 815
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof gy3)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        gy3 gy3Var = (gy3) parcelable;
        super.onRestoreInstanceState(gy3Var.b);
        if (gy3Var.z) {
            e();
        } else {
            a();
        }
        this.K0 = gy3Var.z;
        setLockMode(gy3Var.A);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        gy3 gy3Var = new gy3(super.onSaveInstanceState());
        gy3Var.z = this.y0 ? d() : this.K0;
        gy3Var.A = this.O0;
        return gy3Var;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.L0 = true;
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.y0) {
            return super.onTouchEvent(motionEvent);
        }
        zp4 zp4Var = this.J0;
        zp4Var.l(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.F0 = x;
            this.G0 = y;
            return true;
        }
        if (actionMasked == 1 && b(this.z0)) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float f = x2 - this.F0;
            float f2 = y2 - this.G0;
            int i = zp4Var.b;
            if ((f2 * f2) + (f * f) < i * i && zp4.k(this.z0, (int) x2, (int) y2)) {
                a();
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (view.getParent() instanceof hy3) {
            super.removeView((View) view.getParent());
        } else {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (isInTouchMode() || this.y0) {
            return;
        }
        this.K0 = view == this.z0;
    }

    @Deprecated
    public void setCoveredFadeColor(int i) {
        this.f = i;
    }

    public final void setLockMode(int i) {
        this.O0 = i;
    }

    @Deprecated
    public void setPanelSlideListener(fy3 fy3Var) {
        fy3 fy3Var2 = this.I0;
        CopyOnWriteArrayList copyOnWriteArrayList = this.H0;
        if (fy3Var2 != null) {
            copyOnWriteArrayList.remove(fy3Var2);
        }
        if (fy3Var != null) {
            copyOnWriteArrayList.add(fy3Var);
        }
        this.I0 = fy3Var;
    }

    public void setParallaxDistance(int i) {
        this.E0 = i;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.z = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.A = drawable;
    }

    @Deprecated
    public void setShadowResource(int i) {
        setShadowDrawableLeft(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(getContext().getDrawable(i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(getContext().getDrawable(i));
    }

    @Deprecated
    public void setSliderFadeColor(int i) {
        this.b = i;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ey3 ey3Var = new ey3((ViewGroup.MarginLayoutParams) layoutParams);
            ey3Var.a = 0.0f;
            return ey3Var;
        }
        ey3 ey3Var2 = new ey3(layoutParams);
        ey3Var2.a = 0.0f;
        return ey3Var2;
    }

    public SlidingPaneLayout(Context context) {
        this(context, null);
    }
}
