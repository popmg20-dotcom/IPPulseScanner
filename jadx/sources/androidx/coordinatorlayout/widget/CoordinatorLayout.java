package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.getsurfboard.R;
import defpackage.bv4;
import defpackage.d23;
import defpackage.e1;
import defpackage.eq4;
import defpackage.hm2;
import defpackage.iv1;
import defpackage.mp4;
import defpackage.pe0;
import defpackage.qe0;
import defpackage.re0;
import defpackage.se0;
import defpackage.te0;
import defpackage.ue0;
import defpackage.ve0;
import defpackage.w7;
import defpackage.wp4;
import defpackage.xc3;
import defpackage.xe;
import defpackage.xw3;
import defpackage.yq2;
import defpackage.zq2;
import io.sentry.android.core.a1;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements yq2, zq2 {
    public static final String N0;
    public static final Class[] O0;
    public static final ThreadLocal P0;
    public static final e1 Q0;
    public static final d23 R0;
    public final ArrayList A;
    public boolean A0;
    public boolean B0;
    public final int[] C0;
    public View D0;
    public View E0;
    public ue0 F0;
    public boolean G0;
    public bv4 H0;
    public boolean I0;
    public Drawable J0;
    public ViewGroup.OnHierarchyChangeListener K0;
    public w7 L0;
    public final hm2 M0;
    public final ArrayList b;
    public final iv1 f;
    public final int[] y0;
    public final ArrayList z;
    public final int[] z0;

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        N0 = r0 != null ? r0.getName() : null;
        Q0 = new e1(9);
        O0 = new Class[]{Context.class, AttributeSet.class};
        P0 = new ThreadLocal();
        R0 = new d23(12);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        CoordinatorLayout coordinatorLayout;
        Context context2;
        super(context, attributeSet, R.attr.coordinatorLayoutStyle);
        this.b = new ArrayList();
        this.f = new iv1(11);
        this.z = new ArrayList();
        this.A = new ArrayList();
        this.y0 = new int[2];
        this.z0 = new int[2];
        this.M0 = new hm2(4);
        int[] iArr = xc3.a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, R.attr.coordinatorLayoutStyle, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            coordinatorLayout = this;
            context2 = context;
            coordinatorLayout.saveAttributeDataForStyleable(context2, iArr, attributeSet, typedArrayObtainStyledAttributes, R.attr.coordinatorLayoutStyle, 0);
        } else {
            coordinatorLayout = this;
            context2 = context;
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context2.getResources();
            int[] intArray = resources.getIntArray(resourceId);
            coordinatorLayout.C0 = intArray;
            float f = resources.getDisplayMetrics().density;
            int length = intArray.length;
            for (int i = 0; i < length; i++) {
                coordinatorLayout.C0[i] = (int) (r10[i] * f);
            }
        }
        coordinatorLayout.J0 = typedArrayObtainStyledAttributes.getDrawable(1);
        typedArrayObtainStyledAttributes.recycle();
        coordinatorLayout.x();
        super.setOnHierarchyChangeListener(new se0(coordinatorLayout));
        WeakHashMap weakHashMap = wp4.a;
        if (coordinatorLayout.getImportantForAccessibility() == 0) {
            coordinatorLayout.setImportantForAccessibility(1);
        }
    }

    public static Rect g() {
        Rect rect = (Rect) R0.a();
        return rect == null ? new Rect() : rect;
    }

    public static void l(int i, Rect rect, Rect rect2, te0 te0Var, int i2, int i3) {
        int i4 = te0Var.c;
        if (i4 == 0) {
            i4 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i4, i);
        int i5 = te0Var.d;
        if ((i5 & 7) == 0) {
            i5 |= 8388611;
        }
        if ((i5 & 112) == 0) {
            i5 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i5, i);
        int i6 = absoluteGravity & 7;
        int i7 = absoluteGravity & 112;
        int i8 = absoluteGravity2 & 7;
        int i9 = absoluteGravity2 & 112;
        int iWidth = i8 != 1 ? i8 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int iHeight = i9 != 16 ? i9 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i6 == 1) {
            iWidth -= i2 / 2;
        } else if (i6 != 5) {
            iWidth -= i2;
        }
        if (i7 == 16) {
            iHeight -= i3 / 2;
        } else if (i7 != 80) {
            iHeight -= i3;
        }
        rect2.set(iWidth, iHeight, i2 + iWidth, i3 + iHeight);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static te0 n(View view) {
        te0 te0Var = (te0) view.getLayoutParams();
        if (!te0Var.b) {
            if (view instanceof pe0) {
                qe0 behavior = ((pe0) view).getBehavior();
                if (behavior == null) {
                    a1.d("CoordinatorLayout", "Attached behavior class is null");
                }
                te0Var.b(behavior);
                te0Var.b = true;
                return te0Var;
            }
            re0 re0Var = null;
            for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                re0Var = (re0) superclass.getAnnotation(re0.class);
                if (re0Var != null) {
                    break;
                }
            }
            if (re0Var != null) {
                try {
                    te0Var.b((qe0) re0Var.value().getDeclaredConstructor(null).newInstance(null));
                } catch (Exception e) {
                    a1.e("CoordinatorLayout", "Default behavior class " + re0Var.value().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                }
            }
            te0Var.b = true;
        }
        return te0Var;
    }

    public static void v(View view, int i) {
        te0 te0Var = (te0) view.getLayoutParams();
        int i2 = te0Var.i;
        if (i2 != i) {
            WeakHashMap weakHashMap = wp4.a;
            view.offsetLeftAndRight(i - i2);
            te0Var.i = i;
        }
    }

    public static void w(View view, int i) {
        te0 te0Var = (te0) view.getLayoutParams();
        int i2 = te0Var.j;
        if (i2 != i) {
            WeakHashMap weakHashMap = wp4.a;
            view.offsetTopAndBottom(i - i2);
            te0Var.j = i;
        }
    }

    @Override // defpackage.zq2
    public final void a(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        qe0 qe0Var;
        int childCount = getChildCount();
        int iMax = 0;
        int iMax2 = 0;
        boolean z = false;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                te0 te0Var = (te0) childAt.getLayoutParams();
                if (te0Var.a(i5) && (qe0Var = te0Var.a) != null) {
                    int[] iArr2 = this.y0;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    qe0Var.p(this, childAt, i2, i3, i4, iArr2);
                    iMax = i3 > 0 ? Math.max(iMax, iArr2[0]) : Math.min(iMax, iArr2[0]);
                    iMax2 = i4 > 0 ? Math.max(iMax2, iArr2[1]) : Math.min(iMax2, iArr2[1]);
                    z = true;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + iMax2;
        if (z) {
            p(1);
        }
    }

    @Override // defpackage.yq2
    public final void b(View view, int i, int i2, int i3, int i4, int i5) {
        a(view, i, i2, i3, i4, 0, this.z0);
    }

    @Override // defpackage.yq2
    public final boolean c(View view, View view2, int i, int i2) {
        CoordinatorLayout coordinatorLayout;
        View view3;
        int i3;
        int i4;
        int childCount = getChildCount();
        int i5 = 0;
        boolean z = false;
        while (i5 < childCount) {
            View childAt = this.getChildAt(i5);
            if (childAt.getVisibility() == 8) {
                coordinatorLayout = this;
                view3 = view;
                i3 = i;
                i4 = i2;
            } else {
                te0 te0Var = (te0) childAt.getLayoutParams();
                qe0 qe0Var = te0Var.a;
                if (qe0Var != null) {
                    coordinatorLayout = this;
                    view3 = view;
                    i3 = i;
                    i4 = i2;
                    boolean zT = qe0Var.t(coordinatorLayout, childAt, view3, i3, i4);
                    z |= zT;
                    if (i4 == 0) {
                        te0Var.m = zT;
                    } else if (i4 == 1) {
                        te0Var.n = zT;
                    }
                } else {
                    coordinatorLayout = this;
                    view3 = view;
                    i3 = i;
                    i4 = i2;
                    if (i4 == 0) {
                        te0Var.m = false;
                    } else if (i4 == 1) {
                        te0Var.n = false;
                    }
                }
            }
            i5++;
            this = coordinatorLayout;
            view = view3;
            i = i3;
            i2 = i4;
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof te0) && super.checkLayoutParams(layoutParams);
    }

    @Override // defpackage.yq2
    public final void d(View view, View view2, int i, int i2) {
        hm2 hm2Var = this.M0;
        if (i2 == 1) {
            hm2Var.c = i;
        } else {
            hm2Var.b = i;
        }
        this.E0 = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            ((te0) getChildAt(i3).getLayoutParams()).getClass();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        qe0 qe0Var = ((te0) view.getLayoutParams()).a;
        if (qe0Var != null) {
            qe0Var.getClass();
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.J0;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    @Override // defpackage.yq2
    public final void e(View view, int i) {
        hm2 hm2Var = this.M0;
        if (i == 1) {
            hm2Var.c = 0;
        } else {
            hm2Var.b = 0;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            te0 te0Var = (te0) childAt.getLayoutParams();
            if (te0Var.a(i)) {
                qe0 qe0Var = te0Var.a;
                if (qe0Var != null) {
                    qe0Var.u(this, childAt, view, i);
                }
                if (i == 0) {
                    te0Var.m = false;
                } else if (i == 1) {
                    te0Var.n = false;
                }
                te0Var.o = false;
            }
        }
        this.E0 = null;
    }

    @Override // defpackage.yq2
    public final void f(View view, int i, int i2, int[] iArr, int i3) {
        qe0 qe0Var;
        int childCount = getChildCount();
        boolean z = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                te0 te0Var = (te0) childAt.getLayoutParams();
                if (te0Var.a(i3) && (qe0Var = te0Var.a) != null) {
                    int[] iArr2 = this.y0;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    qe0Var.o(this, childAt, view, i, i2, iArr2, i3);
                    iMax = i > 0 ? Math.max(iMax, iArr2[0]) : Math.min(iMax, iArr2[0]);
                    iMax2 = i2 > 0 ? Math.max(iMax2, iArr2[1]) : Math.min(iMax2, iArr2[1]);
                    z = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z) {
            p(1);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new te0();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof te0 ? new te0((te0) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new te0((ViewGroup.MarginLayoutParams) layoutParams) : new te0(layoutParams);
    }

    public final List<View> getDependencySortedChildren() {
        t();
        return DesugarCollections.unmodifiableList(this.b);
    }

    public final bv4 getLastWindowInsets() {
        return this.H0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        hm2 hm2Var = this.M0;
        return hm2Var.c | hm2Var.b;
    }

    public Drawable getStatusBarBackground() {
        return this.J0;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    public final void h(te0 te0Var, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) te0Var).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - ((ViewGroup.MarginLayoutParams) te0Var).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) te0Var).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - ((ViewGroup.MarginLayoutParams) te0Var).bottomMargin));
        rect.set(iMax, iMax2, i + iMax, i2 + iMax2);
    }

    public final void i(View view) {
        List list = (List) ((xw3) this.f.z).get(view);
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            View view2 = (View) list.get(i);
            qe0 qe0Var = ((te0) view2.getLayoutParams()).a;
            if (qe0Var != null) {
                qe0Var.h(this, view2, view);
            }
        }
    }

    public final void j(View view, Rect rect, boolean z) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            eq4.a(this, view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public final ArrayList k(View view) {
        xw3 xw3Var = (xw3) this.f.z;
        int i = xw3Var.z;
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < i; i2++) {
            ArrayList arrayList2 = (ArrayList) xw3Var.i(i2);
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(xw3Var.f(i2));
            }
        }
        ArrayList arrayList3 = this.A;
        arrayList3.clear();
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        return arrayList3;
    }

    public final int m(int i) {
        int[] iArr = this.C0;
        if (iArr == null) {
            a1.d("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        }
        if (i >= 0 && i < iArr.length) {
            return iArr[i];
        }
        a1.d("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
        return 0;
    }

    public final boolean o(View view, int i, int i2) {
        d23 d23Var = R0;
        Rect rectG = g();
        eq4.a(this, view, rectG);
        try {
            return rectG.contains(i, i2);
        } finally {
            rectG.setEmpty();
            d23Var.c(rectG);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        u(false);
        if (this.G0) {
            if (this.F0 == null) {
                this.F0 = new ue0(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.F0);
        }
        if (this.H0 == null) {
            WeakHashMap weakHashMap = wp4.a;
            if (getFitsSystemWindows()) {
                requestApplyInsets();
            }
        }
        this.B0 = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u(false);
        if (this.G0 && this.F0 != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.F0);
        }
        View view = this.E0;
        if (view != null) {
            e(view, 0);
        }
        this.B0 = false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.I0 || this.J0 == null) {
            return;
        }
        bv4 bv4Var = this.H0;
        int iD = bv4Var != null ? bv4Var.d() : 0;
        if (iD > 0) {
            this.J0.setBounds(0, 0, getWidth(), iD);
            this.J0.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            u(true);
        }
        boolean zS = s(motionEvent, 0);
        if (actionMasked != 1 && actionMasked != 3) {
            return zS;
        }
        u(true);
        return zS;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        qe0 qe0Var;
        WeakHashMap weakHashMap = wp4.a;
        int layoutDirection = getLayoutDirection();
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) arrayList.get(i5);
            if (view.getVisibility() != 8 && ((qe0Var = ((te0) view.getLayoutParams()).a) == null || !qe0Var.l(this, view, layoutDirection))) {
                q(view, layoutDirection);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0189  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r27, int r28) {
        /*
            Method dump skipped, instruction units count: 499
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                te0 te0Var = (te0) childAt.getLayoutParams();
                if (te0Var.a(0)) {
                    qe0 qe0Var = te0Var.a;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f2) {
        qe0 qe0Var;
        int childCount = getChildCount();
        boolean zN = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                te0 te0Var = (te0) childAt.getLayoutParams();
                if (te0Var.a(0) && (qe0Var = te0Var.a) != null) {
                    zN |= qe0Var.n(view);
                }
            }
        }
        return zN;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        f(view, i, i2, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        b(view, i, i2, i3, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        d(view, view2, i, 0);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof ve0)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ve0 ve0Var = (ve0) parcelable;
        super.onRestoreInstanceState(ve0Var.b);
        SparseArray sparseArray = ve0Var.z;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            qe0 qe0Var = n(childAt).a;
            if (id != -1 && qe0Var != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                qe0Var.r(childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableS;
        ve0 ve0Var = new ve0(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            qe0 qe0Var = ((te0) childAt.getLayoutParams()).a;
            if (id != -1 && qe0Var != null && (parcelableS = qe0Var.s(childAt)) != null) {
                sparseArray.append(id, parcelableS);
            }
        }
        ve0Var.z = sparseArray;
        return ve0Var;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        return c(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        e(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015 A[PHI: r3
      0x0015: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:10:0x0022, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r1.getActionMasked()
            android.view.View r3 = r0.D0
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.s(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = r5
            goto L2a
        L17:
            r3 = r5
        L18:
            android.view.View r6 = r0.D0
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            te0 r6 = (defpackage.te0) r6
            qe0 r6 = r6.a
            if (r6 == 0) goto L15
            android.view.View r7 = r0.D0
            boolean r6 = r6.v(r0, r7, r1)
        L2a:
            android.view.View r7 = r0.D0
            r8 = 0
            if (r7 != 0) goto L35
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L48
        L35:
            if (r3 == 0) goto L48
            long r9 = android.os.SystemClock.uptimeMillis()
            r15 = 0
            r16 = 0
            r13 = 3
            r14 = 0
            r11 = r9
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L48:
            if (r8 == 0) goto L4d
            r8.recycle()
        L4d:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L53
            goto L54
        L53:
            return r6
        L54:
            r0.u(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(int r23) {
        /*
            Method dump skipped, instruction units count: 735
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.p(int):void");
    }

    public final void q(View view, int i) {
        Rect rectG;
        Rect rectG2;
        te0 te0Var = (te0) view.getLayoutParams();
        View view2 = te0Var.k;
        if (view2 == null && te0Var.f != -1) {
            xe.q("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
            return;
        }
        d23 d23Var = R0;
        if (view2 != null) {
            rectG = g();
            rectG2 = g();
            try {
                eq4.a(this, view2, rectG);
                te0 te0Var2 = (te0) view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                l(i, rectG, rectG2, te0Var2, measuredWidth, measuredHeight);
                h(te0Var2, rectG2, measuredWidth, measuredHeight);
                view.layout(rectG2.left, rectG2.top, rectG2.right, rectG2.bottom);
                return;
            } finally {
                rectG.setEmpty();
                d23Var.c(rectG);
                rectG2.setEmpty();
                d23Var.c(rectG2);
            }
        }
        int i2 = te0Var.e;
        if (i2 < 0) {
            te0 te0Var3 = (te0) view.getLayoutParams();
            rectG = g();
            rectG.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) te0Var3).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) te0Var3).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) te0Var3).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) te0Var3).bottomMargin);
            if (this.H0 != null) {
                WeakHashMap weakHashMap = wp4.a;
                if (getFitsSystemWindows() && !view.getFitsSystemWindows()) {
                    rectG.left = this.H0.b() + rectG.left;
                    rectG.top = this.H0.d() + rectG.top;
                    rectG.right -= this.H0.c();
                    rectG.bottom -= this.H0.a();
                }
            }
            rectG2 = g();
            int i3 = te0Var3.c;
            if ((i3 & 7) == 0) {
                i3 |= 8388611;
            }
            if ((i3 & 112) == 0) {
                i3 |= 48;
            }
            Gravity.apply(i3, view.getMeasuredWidth(), view.getMeasuredHeight(), rectG, rectG2, i);
            view.layout(rectG2.left, rectG2.top, rectG2.right, rectG2.bottom);
            return;
        }
        te0 te0Var4 = (te0) view.getLayoutParams();
        int i4 = te0Var4.c;
        if (i4 == 0) {
            i4 = 8388661;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i4, i);
        int i5 = absoluteGravity & 7;
        int i6 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth2 = view.getMeasuredWidth();
        int measuredHeight2 = view.getMeasuredHeight();
        if (i == 1) {
            i2 = width - i2;
        }
        int iM = m(i2) - measuredWidth2;
        if (i5 == 1) {
            iM += measuredWidth2 / 2;
        } else if (i5 == 5) {
            iM += measuredWidth2;
        }
        int i7 = i6 != 16 ? i6 != 80 ? 0 : measuredHeight2 : measuredHeight2 / 2;
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) te0Var4).leftMargin, Math.min(iM, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) te0Var4).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) te0Var4).topMargin, Math.min(i7, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) te0Var4).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth2 + iMax, measuredHeight2 + iMax2);
    }

    public final void r(View view, int i, int i2, int i3) {
        measureChildWithMargins(view, i, i2, i3, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        qe0 qe0Var = ((te0) view.getLayoutParams()).a;
        if (qe0Var == null || !qe0Var.q(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.A0) {
            return;
        }
        u(false);
        this.A0 = true;
    }

    public final boolean s(MotionEvent motionEvent, int i) {
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.z;
        arrayList.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            arrayList.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i2) : i2));
        }
        e1 e1Var = Q0;
        if (e1Var != null) {
            Collections.sort(arrayList, e1Var);
        }
        int size = arrayList.size();
        MotionEvent motionEventObtain = null;
        boolean zK = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) arrayList.get(i3);
            qe0 qe0Var = ((te0) view.getLayoutParams()).a;
            if (zK && actionMasked != 0) {
                if (qe0Var != null) {
                    if (motionEventObtain == null) {
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    if (i == 0) {
                        qe0Var.k(this, view, motionEventObtain);
                    } else if (i == 1) {
                        qe0Var.v(this, view, motionEventObtain);
                    }
                }
            } else if (!zK && qe0Var != null) {
                if (i == 0) {
                    zK = qe0Var.k(this, view, motionEvent);
                } else if (i == 1) {
                    zK = qe0Var.v(this, view, motionEvent);
                }
                if (zK) {
                    this.D0 = view;
                }
            }
        }
        arrayList.clear();
        return zK;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        x();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.K0 = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.J0;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.J0 = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.J0.setState(getDrawableState());
                }
                Drawable drawable3 = this.J0;
                WeakHashMap weakHashMap = wp4.a;
                drawable3.setLayoutDirection(getLayoutDirection());
                this.J0.setVisible(getVisibility() == 0, false);
                this.J0.setCallback(this);
            }
            WeakHashMap weakHashMap2 = wp4.a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? getContext().getDrawable(i) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.J0;
        if (drawable == null || drawable.isVisible() == z) {
            return;
        }
        this.J0.setVisible(z, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t() {
        /*
            Method dump skipped, instruction units count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.t():void");
    }

    public final void u(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            qe0 qe0Var = ((te0) childAt.getLayoutParams()).a;
            if (qe0Var != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    qe0Var.k(this, childAt, motionEventObtain);
                } else {
                    qe0Var.v(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((te0) getChildAt(i2).getLayoutParams()).getClass();
        }
        this.D0 = null;
        this.A0 = false;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.J0;
    }

    public final void x() {
        WeakHashMap weakHashMap = wp4.a;
        if (!getFitsSystemWindows()) {
            mp4.c(this, null);
            return;
        }
        w7 w7Var = this.L0;
        if (w7Var == null) {
            w7Var = new w7(19, this);
            this.L0 = w7Var;
        }
        mp4.c(this, w7Var);
        setSystemUiVisibility(1280);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new te0(getContext(), attributeSet);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }
}
