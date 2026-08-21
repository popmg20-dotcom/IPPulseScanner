package com.google.android.material.bottomsheet;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.MotionEvent;
import android.view.RoundedCorner;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.getsurfboard.R;
import defpackage.ai2;
import defpackage.d3;
import defpackage.dw2;
import defpackage.ec;
import defpackage.ei2;
import defpackage.fu4;
import defpackage.fw;
import defpackage.g2;
import defpackage.h2;
import defpackage.i2;
import defpackage.io;
import defpackage.jo;
import defpackage.ko;
import defpackage.l72;
import defpackage.lo;
import defpackage.mo;
import defpackage.ou3;
import defpackage.qe0;
import defpackage.rc3;
import defpackage.sn;
import defpackage.t6;
import defpackage.t8;
import defpackage.te0;
import defpackage.tj4;
import defpackage.u02;
import defpackage.ub1;
import defpackage.wp4;
import defpackage.xe;
import defpackage.yh;
import defpackage.yi2;
import defpackage.zp4;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.sentry.android.core.a1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends qe0 implements ai2 {
    public final int A;
    public final yi2 A0;
    public final SparseIntArray A1;
    public final ColorStateList B0;
    public final SparseIntArray B1;
    public final int C0;
    public final SparseIntArray C1;
    public final int D0;
    public final jo D1;
    public int E0;
    public final boolean F0;
    public final boolean G0;
    public final boolean H0;
    public final boolean I0;
    public final boolean J0;
    public final boolean K0;
    public final boolean L0;
    public final boolean M0;
    public int N0;
    public int O0;
    public final boolean P0;
    public final ou3 Q0;
    public boolean R0;
    public final mo S0;
    public final ValueAnimator T0;
    public final int U0;
    public int V0;
    public int W0;
    public final boolean X;
    public final float X0;
    public int Y;
    public int Y0;
    public boolean Z;
    public final float Z0;
    public boolean a1;
    public final int b;
    public boolean b1;
    public final boolean c1;
    public final boolean d1;
    public boolean e1;
    public boolean f;
    public int f1;
    public zp4 g1;
    public boolean h1;
    public int i1;
    public boolean j1;
    public final float k1;
    public int l1;
    public int m1;
    public int n1;
    public WeakReference o1;
    public WeakReference p1;
    public WeakReference q1;
    public final ArrayList r1;
    public final ArrayList s1;
    public VelocityTracker t1;
    public ei2 u1;
    public int v1;
    public int w1;
    public WeakReference x1;
    public int y0;
    public boolean y1;
    public final float z;
    public final int z0;
    public HashMap z1;

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i;
        int i2 = 0;
        this.b = 0;
        this.f = true;
        this.C0 = -1;
        this.D0 = -1;
        this.S0 = new mo(this);
        this.X0 = 0.5f;
        this.Z0 = -1.0f;
        this.c1 = true;
        this.d1 = true;
        this.f1 = 4;
        this.k1 = 0.1f;
        this.r1 = new ArrayList();
        this.s1 = new ArrayList();
        this.w1 = -1;
        this.A1 = new SparseIntArray();
        this.B1 = new SparseIntArray();
        this.C1 = new SparseIntArray();
        this.D1 = new jo(i2, this);
        this.z0 = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, rc3.f);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            this.B0 = l72.r(context, typedArrayObtainStyledAttributes, 3);
        }
        if (typedArrayObtainStyledAttributes.hasValue(23)) {
            this.Q0 = ou3.h(context, attributeSet, R.attr.bottomSheetStyle, R.style.Widget_Design_BottomSheet_Modal).b();
        }
        ou3 ou3Var = this.Q0;
        if (ou3Var != null) {
            yi2 yi2Var = new yi2(ou3Var);
            this.A0 = yi2Var;
            yi2Var.l(context);
            ColorStateList colorStateList = this.B0;
            if (colorStateList != null) {
                this.A0.p(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.A0.setTint(typedValue.data);
            }
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(y(), 1.0f);
        this.T0 = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.T0.addUpdateListener(new io(i2, this));
        this.Z0 = typedArrayObtainStyledAttributes.getDimension(2, -1.0f);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            this.C0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            this.D0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, -1);
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(11);
        if (typedValuePeekValue == null || (i = typedValuePeekValue.data) != -1) {
            M(typedArrayObtainStyledAttributes.getDimensionPixelSize(11, -1));
        } else {
            M(i);
        }
        L(typedArrayObtainStyledAttributes.getBoolean(9, false));
        this.F0 = typedArrayObtainStyledAttributes.getBoolean(15, false);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(7, true);
        if (this.f != z) {
            this.f = z;
            if (this.o1 != null) {
                x();
            }
            O((this.f && this.f1 == 6) ? 3 : this.f1);
            T(this.f1, true);
            R();
        }
        this.b1 = typedArrayObtainStyledAttributes.getBoolean(14, false);
        this.c1 = typedArrayObtainStyledAttributes.getBoolean(4, true);
        this.d1 = typedArrayObtainStyledAttributes.getBoolean(5, true);
        this.b = typedArrayObtainStyledAttributes.getInt(12, 0);
        float f = typedArrayObtainStyledAttributes.getFloat(8, 0.5f);
        if (f <= 0.0f || f >= 1.0f) {
            xe.k("ratio must be a float value between 0 and 1");
            throw null;
        }
        this.X0 = f;
        if (this.o1 != null) {
            this.W0 = (int) ((1.0f - f) * this.n1);
        }
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(6);
        if (typedValuePeekValue2 == null || typedValuePeekValue2.type != 16) {
            int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(6, 0);
            if (dimensionPixelOffset < 0) {
                xe.k("offset must be greater than or equal to 0");
                throw null;
            }
            this.U0 = dimensionPixelOffset;
            T(this.f1, true);
        } else {
            int i3 = typedValuePeekValue2.data;
            if (i3 < 0) {
                xe.k("offset must be greater than or equal to 0");
                throw null;
            }
            this.U0 = i3;
            T(this.f1, true);
        }
        this.A = typedArrayObtainStyledAttributes.getInt(13, 500);
        this.X = typedArrayObtainStyledAttributes.getBoolean(10, false);
        this.G0 = typedArrayObtainStyledAttributes.getBoolean(19, false);
        this.H0 = typedArrayObtainStyledAttributes.getBoolean(20, false);
        this.I0 = typedArrayObtainStyledAttributes.getBoolean(21, false);
        this.J0 = typedArrayObtainStyledAttributes.getBoolean(22, true);
        this.K0 = typedArrayObtainStyledAttributes.getBoolean(16, false);
        this.L0 = typedArrayObtainStyledAttributes.getBoolean(17, false);
        this.M0 = typedArrayObtainStyledAttributes.getBoolean(18, false);
        this.P0 = typedArrayObtainStyledAttributes.getBoolean(25, true);
        typedArrayObtainStyledAttributes.recycle();
        this.z = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public static View C(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (view.isNestedScrollingEnabled()) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View viewC = C(viewGroup.getChildAt(i));
            if (viewC != null) {
                return viewC;
            }
        }
        return null;
    }

    public static BottomSheetBehavior D(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof te0)) {
            xe.k("The view is not a child of CoordinatorLayout");
            return null;
        }
        qe0 qe0Var = ((te0) layoutParams).a;
        if (qe0Var instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) qe0Var;
        }
        xe.k("The view is not associated with BottomSheetBehavior");
        return null;
    }

    public static int E(int i, int i2, int i3, int i4) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, i2, i4);
        if (i3 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i3), Pow2.MAX_POW2);
        }
        if (size != 0) {
            i3 = Math.min(size, i3);
        }
        return View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
    }

    public final void A(View view, int i) {
        if (view == null) {
            return;
        }
        wp4.k(view, 1048576);
        wp4.i(view, 0);
        wp4.k(view, 524288);
        wp4.i(view, 0);
        wp4.k(view, 262144);
        wp4.i(view, 0);
        SparseIntArray sparseIntArray = this.B1;
        int i2 = sparseIntArray.get(i, -1);
        if (i2 != -1) {
            wp4.k(view, i2);
            wp4.i(view, 0);
            sparseIntArray.delete(i);
        }
        SparseIntArray sparseIntArray2 = this.A1;
        int i3 = sparseIntArray2.get(i, -1);
        if (i3 != -1) {
            wp4.k(view, i3);
            wp4.i(view, 0);
            sparseIntArray2.delete(i);
        }
        SparseIntArray sparseIntArray3 = this.C1;
        int i4 = sparseIntArray3.get(i, -1);
        if (i4 != -1) {
            wp4.k(view, i4);
            wp4.i(view, 0);
            sparseIntArray3.delete(i);
        }
    }

    public final void B(int i) {
        View view = (View) this.o1.get();
        if (view != null) {
            ArrayList arrayList = this.s1;
            if (arrayList.isEmpty()) {
                return;
            }
            int i2 = this.Y0;
            if (i <= i2 && i2 != F()) {
                F();
            }
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                ((ko) arrayList.get(i3)).b(view);
            }
        }
    }

    public final int F() {
        if (this.f) {
            return this.V0;
        }
        return Math.max(this.U0, this.J0 ? 0 : this.O0);
    }

    public final int G(int i) {
        if (i == 3) {
            return F();
        }
        if (i == 4) {
            return this.Y0;
        }
        if (i == 5) {
            return this.n1;
        }
        if (i == 6) {
            return this.W0;
        }
        xe.k(dw2.A(i, "Invalid state to get top offset: "));
        return 0;
    }

    public final boolean H() {
        WeakReference weakReference = this.o1;
        if (weakReference != null && weakReference.get() != null) {
            int[] iArr = new int[2];
            ((View) this.o1.get()).getLocationOnScreen(iArr);
            if (iArr[1] == 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean I(View view) {
        Iterator it = this.r1.iterator();
        while (it.hasNext()) {
            if (((WeakReference) it.next()).get() == view) {
                return true;
            }
        }
        return false;
    }

    public final void J(View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view.isNestedScrollingEnabled()) {
            this.r1.add(new WeakReference(view));
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                J(viewGroup.getChildAt(i));
            }
        }
    }

    public final void K(BottomSheetDragHandleView bottomSheetDragHandleView) {
        WeakReference weakReference;
        if (bottomSheetDragHandleView != null || (weakReference = this.p1) == null) {
            this.p1 = new WeakReference(bottomSheetDragHandleView);
            S(bottomSheetDragHandleView, 1);
        } else {
            A((View) weakReference.get(), 1);
            this.p1 = null;
        }
    }

    public final void L(boolean z) {
        if (this.a1 != z) {
            this.a1 = z;
            if (!z && this.f1 == 5) {
                N(4);
            }
            R();
        }
    }

    public final void M(int i) {
        boolean z = this.Z;
        if (i == -1) {
            if (z) {
                return;
            } else {
                this.Z = true;
            }
        } else {
            if (!z && this.Y == i) {
                return;
            }
            this.Z = false;
            this.Y = Math.max(0, i);
        }
        V();
    }

    public final void N(int i) {
        int i2 = 1;
        if (i == 1 || i == 2) {
            throw new IllegalArgumentException(fw.y(new StringBuilder("STATE_"), i == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        if (!this.a1 && i == 5) {
            a1.n("BottomSheetBehavior", "Cannot set state: " + i);
            return;
        }
        int i3 = (i == 6 && this.f && G(i) <= this.V0) ? 3 : i;
        WeakReference weakReference = this.o1;
        if (weakReference == null || weakReference.get() == null) {
            O(i);
            return;
        }
        View view = (View) this.o1.get();
        ec ecVar = new ec(this, view, i3, i2);
        ViewParent parent = view.getParent();
        if (parent != null && parent.isLayoutRequested() && view.isAttachedToWindow()) {
            view.post(ecVar);
        } else {
            ecVar.run();
        }
    }

    public final void O(int i) {
        View view;
        if (this.f1 == i) {
            return;
        }
        this.f1 = i;
        if (i != 4 && i != 3 && i != 6) {
            boolean z = this.a1;
        }
        WeakReference weakReference = this.o1;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        int i2 = 0;
        if (i == 3) {
            U(true);
        } else if (i == 6 || i == 5 || i == 4) {
            U(false);
        }
        T(i, true);
        while (true) {
            ArrayList arrayList = this.s1;
            if (i2 >= arrayList.size()) {
                R();
                return;
            } else {
                ((ko) arrayList.get(i2)).c(view, i);
                i2++;
            }
        }
    }

    public final boolean P(View view, float f) {
        if (this.b1) {
            return true;
        }
        if (view.getTop() < this.Y0) {
            return false;
        }
        return Math.abs(((f * this.k1) + ((float) view.getTop())) - ((float) this.Y0)) / ((float) z()) > 0.5f;
    }

    public final void Q(View view, int i, boolean z) {
        int iG = G(i);
        zp4 zp4Var = this.g1;
        if (zp4Var == null || (!z ? zp4Var.t(view, view.getLeft(), iG) : zp4Var.r(view.getLeft(), iG))) {
            O(i);
            return;
        }
        O(2);
        T(i, true);
        this.S0.a(i);
    }

    public final void R() {
        WeakReference weakReference = this.o1;
        if (weakReference != null) {
            S((View) weakReference.get(), 0);
        }
        WeakReference weakReference2 = this.p1;
        if (weakReference2 != null) {
            S((View) weakReference2.get(), 1);
        }
    }

    public final void S(View view, int i) {
        if (view == null) {
            return;
        }
        A(view, i);
        if (!this.f && this.f1 != 6) {
            this.A1.put(i, w(view, R.string.bottomsheet_action_expand_halfway, 6));
        }
        if (this.a1) {
            int i2 = 5;
            if (this.f1 != 5) {
                wp4.l(view, i2.i, null, new t6(i2, 1, this));
            }
        }
        int i3 = this.f1;
        SparseIntArray sparseIntArray = this.C1;
        if (i3 == 3) {
            sparseIntArray.put(i, w(view, R.string.bottomsheet_action_collapse, 4));
            return;
        }
        SparseIntArray sparseIntArray2 = this.B1;
        if (i3 == 4) {
            sparseIntArray2.put(i, w(view, R.string.bottomsheet_action_expand, 3));
        } else {
            if (i3 != 6) {
                return;
            }
            sparseIntArray.put(i, w(view, R.string.bottomsheet_action_collapse, 4));
            sparseIntArray2.put(i, w(view, R.string.bottomsheet_action_expand, 3));
        }
    }

    public final void T(int i, boolean z) {
        yi2 yi2Var;
        if (i == 2) {
            return;
        }
        boolean z2 = this.f1 == 3 && (this.P0 || H());
        if (this.R0 == z2 || (yi2Var = this.A0) == null) {
            return;
        }
        this.R0 = z2;
        ValueAnimator valueAnimator = this.T0;
        if (!z || valueAnimator == null) {
            if (valueAnimator != null && valueAnimator.isRunning()) {
                valueAnimator.cancel();
            }
            yi2Var.q(this.R0 ? y() : 1.0f);
            return;
        }
        if (valueAnimator.isRunning()) {
            valueAnimator.reverse();
        } else {
            valueAnimator.setFloatValues(yi2Var.f.i, z2 ? y() : 1.0f);
            valueAnimator.start();
        }
    }

    public final void U(boolean z) {
        WeakReference weakReference = this.o1;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                if (this.z1 != null) {
                    return;
                } else {
                    this.z1 = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.o1.get() && z) {
                    this.z1.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z) {
                return;
            }
            this.z1 = null;
        }
    }

    public final void V() {
        View view;
        if (this.o1 != null) {
            x();
            if (this.f1 != 4 || (view = (View) this.o1.get()) == null) {
                return;
            }
            view.requestLayout();
        }
    }

    @Override // defpackage.ai2
    public final void a() {
        ei2 ei2Var = this.u1;
        if (ei2Var == null) {
            return;
        }
        int i = ei2Var.c;
        int i2 = ei2Var.b;
        yh yhVar = (yh) ei2Var.g;
        ei2Var.g = null;
        if (yhVar != null) {
            float f = yhVar.c;
            if (Build.VERSION.SDK_INT >= 34) {
                if (!this.a1) {
                    AnimatorSet animatorSetA = ei2Var.a();
                    animatorSetA.setDuration(t8.c(i2, f, i));
                    animatorSetA.start();
                    N(4);
                    return;
                }
                d3 d3Var = new d3(3, this);
                View view = (View) ei2Var.f;
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, view.getScaleY() * view.getHeight());
                objectAnimatorOfFloat.setInterpolator(new ub1());
                objectAnimatorOfFloat.setDuration(t8.c(i2, f, i));
                objectAnimatorOfFloat.addListener(new d3(11, ei2Var));
                objectAnimatorOfFloat.addListener(d3Var);
                objectAnimatorOfFloat.start();
                return;
            }
        }
        N(this.a1 ? 5 : 4);
    }

    @Override // defpackage.ai2
    public final void b(yh yhVar) {
        ei2 ei2Var = this.u1;
        if (ei2Var == null) {
            return;
        }
        if (((yh) ei2Var.g) == null) {
            a1.n("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        yh yhVar2 = (yh) ei2Var.g;
        ei2Var.g = yhVar;
        if (yhVar2 == null) {
            return;
        }
        ei2Var.b(yhVar.c);
    }

    @Override // defpackage.ai2
    public final void c(yh yhVar) {
        ei2 ei2Var = this.u1;
        if (ei2Var == null) {
            return;
        }
        ei2Var.g = yhVar;
    }

    @Override // defpackage.ai2
    public final void d() {
        ei2 ei2Var = this.u1;
        if (ei2Var == null) {
            return;
        }
        if (((yh) ei2Var.g) == null) {
            a1.n("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        yh yhVar = (yh) ei2Var.g;
        ei2Var.g = null;
        if (yhVar == null) {
            return;
        }
        AnimatorSet animatorSetA = ei2Var.a();
        animatorSetA.setDuration(ei2Var.d);
        animatorSetA.start();
    }

    @Override // defpackage.qe0
    public final void g(te0 te0Var) {
        this.o1 = null;
        this.g1 = null;
        this.u1 = null;
    }

    @Override // defpackage.qe0
    public final void j() {
        this.o1 = null;
        this.g1 = null;
        this.u1 = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0139  */
    @Override // defpackage.qe0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        View view2;
        View view3;
        int i;
        zp4 zp4Var;
        if (!view.isShown() || !this.c1) {
            this.h1 = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.v1 = -1;
            this.w1 = -1;
            this.x1 = null;
            VelocityTracker velocityTracker = this.t1;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.t1 = null;
            }
        }
        VelocityTracker velocityTrackerObtain = this.t1;
        if (velocityTrackerObtain == null) {
            velocityTrackerObtain = VelocityTracker.obtain();
            this.t1 = velocityTrackerObtain;
        }
        velocityTrackerObtain.addMovement(motionEvent);
        ArrayList arrayList = this.r1;
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.w1 = (int) motionEvent.getY();
            int x2 = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (arrayList.isEmpty()) {
                view2 = null;
                WeakReference weakReference = new WeakReference(view2);
                this.x1 = weakReference;
                if (this.f1 != 2 && weakReference.get() != null) {
                    this.v1 = motionEvent.getPointerId(motionEvent.getActionIndex());
                    int i2 = this.w1;
                    WeakReference weakReference2 = this.q1;
                    view3 = weakReference2 == null ? (View) weakReference2.get() : null;
                    if (view3 != null || !coordinatorLayout.o(view3, x, i2)) {
                        this.y1 = true;
                    }
                }
                this.h1 = (this.v1 == -1 || coordinatorLayout.o(view, x, this.w1)) ? false : true;
            } else {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    view2 = (View) ((WeakReference) it.next()).get();
                    if (view2 != null && coordinatorLayout.o(view2, x2, y)) {
                        break;
                    }
                }
                view2 = null;
                WeakReference weakReference3 = new WeakReference(view2);
                this.x1 = weakReference3;
                if (this.f1 != 2) {
                    this.v1 = motionEvent.getPointerId(motionEvent.getActionIndex());
                    int i22 = this.w1;
                    WeakReference weakReference22 = this.q1;
                    if (weakReference22 == null) {
                    }
                    if (view3 != null) {
                        this.y1 = true;
                    }
                }
                if (this.v1 == -1) {
                    this.h1 = (this.v1 == -1 || coordinatorLayout.o(view, x, this.w1)) ? false : true;
                }
            }
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.y1 = false;
            this.x1 = null;
            this.v1 = -1;
            if (this.h1) {
                this.h1 = false;
                return false;
            }
        }
        if (this.h1 || (zp4Var = this.g1) == null || !zp4Var.s(motionEvent)) {
            if (actionMasked == 2) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (((WeakReference) it2.next()).get() != null) {
                        if (!this.h1 && this.f1 != 1) {
                            if (this.X) {
                                WeakReference weakReference4 = this.x1;
                                if (weakReference4 == null || weakReference4.get() == null) {
                                    if (this.g1 == null || (i = this.w1) == -1 || Math.abs(i - motionEvent.getY()) <= this.g1.b) {
                                        break;
                                    }
                                }
                            } else {
                                View view4 = arrayList.isEmpty() ? null : (View) ((WeakReference) arrayList.get(0)).get();
                                if (view4 == null || !coordinatorLayout.o(view4, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // defpackage.qe0
    public final boolean l(CoordinatorLayout coordinatorLayout, View view, int i) {
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        int i2 = 0;
        if (this.o1 == null) {
            this.y0 = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            boolean z = (Build.VERSION.SDK_INT < 29 || this.F0 || this.Z) ? false : true;
            if (this.G0 || this.H0 || this.I0 || this.K0 || this.L0 || this.M0 || z) {
                tj4.x(view, new sn(this, z));
            }
            u02 u02Var = new u02(view);
            WeakHashMap weakHashMap = wp4.a;
            fu4.a(view, u02Var);
            this.o1 = new WeakReference(view);
            this.u1 = new ei2(view);
            yi2 yi2Var = this.A0;
            if (yi2Var != null) {
                view.setBackground(yi2Var);
                float elevation = this.Z0;
                if (elevation == -1.0f) {
                    elevation = view.getElevation();
                }
                yi2Var.o(elevation);
            } else {
                ColorStateList colorStateList = this.B0;
                if (colorStateList != null) {
                    view.setBackgroundTintList(colorStateList);
                }
            }
            R();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
        }
        if (this.g1 == null) {
            this.g1 = new zp4(coordinatorLayout.getContext(), coordinatorLayout, this.D1);
        }
        int top = view.getTop();
        coordinatorLayout.q(view, i);
        this.m1 = coordinatorLayout.getWidth();
        this.n1 = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.l1 = height;
        int i3 = this.n1;
        int i4 = i3 - height;
        int i5 = this.O0;
        if (i4 < i5) {
            boolean z2 = this.J0;
            int i6 = this.D0;
            if (z2) {
                height = i6 == -1 ? i3 : Math.min(i3, i6);
                this.l1 = height;
            } else {
                int i7 = i3 - i5;
                height = i6 == -1 ? i7 : Math.min(i7, i6);
                this.l1 = height;
            }
        }
        this.V0 = Math.max(0, this.n1 - height);
        this.W0 = (int) ((1.0f - this.X0) * this.n1);
        x();
        int i8 = this.f1;
        if (i8 == 3) {
            int iF = F();
            WeakHashMap weakHashMap2 = wp4.a;
            view.offsetTopAndBottom(iF);
        } else if (i8 == 6) {
            int i9 = this.W0;
            WeakHashMap weakHashMap3 = wp4.a;
            view.offsetTopAndBottom(i9);
        } else if (this.a1 && i8 == 5) {
            int i10 = this.n1;
            WeakHashMap weakHashMap4 = wp4.a;
            view.offsetTopAndBottom(i10);
        } else if (i8 == 4) {
            int i11 = this.Y0;
            WeakHashMap weakHashMap5 = wp4.a;
            view.offsetTopAndBottom(i11);
        } else if (i8 == 1 || i8 == 2) {
            int top2 = top - view.getTop();
            WeakHashMap weakHashMap6 = wp4.a;
            view.offsetTopAndBottom(top2);
        }
        T(this.f1, false);
        ArrayList arrayList = this.r1;
        arrayList.clear();
        if (this.X) {
            J(view);
        } else {
            arrayList.add(new WeakReference(C(view)));
        }
        while (true) {
            ArrayList arrayList2 = this.s1;
            if (i2 >= arrayList2.size()) {
                return true;
            }
            ((ko) arrayList2.get(i2)).a(view);
            i2++;
        }
    }

    @Override // defpackage.qe0
    public final boolean m(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(E(i, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, this.C0, marginLayoutParams.width), E(i3, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, this.D0, marginLayoutParams.height));
        return true;
    }

    @Override // defpackage.qe0
    public final boolean n(View view) {
        Iterator it = this.r1.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (((WeakReference) it.next()).get() != null) {
                if (!I(view) || this.f1 == 3 || this.e1) {
                    break;
                }
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.qe0
    public final void o(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
        boolean zI;
        if (i3 != 1 && (zI = I(view2))) {
            int top = view.getTop();
            int i4 = top - i2;
            boolean z = this.c1;
            boolean z2 = this.d1;
            if (i2 > 0) {
                if (!this.j1 && !z2 && zI && view2.canScrollVertically(1)) {
                    this.e1 = true;
                    return;
                }
                if (i4 < F()) {
                    int iF = top - F();
                    iArr[1] = iF;
                    WeakHashMap weakHashMap = wp4.a;
                    view.offsetTopAndBottom(-iF);
                    O(3);
                } else {
                    if (!z) {
                        return;
                    }
                    iArr[1] = i2;
                    WeakHashMap weakHashMap2 = wp4.a;
                    view.offsetTopAndBottom(-i2);
                    O(1);
                }
            } else if (i2 < 0) {
                boolean zCanScrollVertically = view2.canScrollVertically(-1);
                if (!this.j1 && !z2 && zI && zCanScrollVertically) {
                    this.e1 = true;
                    return;
                }
                if (!zCanScrollVertically) {
                    int i5 = this.Y0;
                    if (i4 > i5 && !this.a1) {
                        int i6 = top - i5;
                        iArr[1] = i6;
                        WeakHashMap weakHashMap3 = wp4.a;
                        view.offsetTopAndBottom(-i6);
                        O(4);
                    } else {
                        if (!z) {
                            return;
                        }
                        iArr[1] = i2;
                        WeakHashMap weakHashMap4 = wp4.a;
                        view.offsetTopAndBottom(-i2);
                        O(1);
                    }
                }
            }
            B(view.getTop());
            this.i1 = i2;
            this.j1 = true;
            this.e1 = false;
        }
    }

    @Override // defpackage.qe0
    public final void r(View view, Parcelable parcelable) {
        lo loVar = (lo) parcelable;
        int i = this.b;
        if (i != 0) {
            if (i == -1 || (i & 1) == 1) {
                this.Y = loVar.A;
            }
            if (i == -1 || (i & 2) == 2) {
                this.f = loVar.X;
            }
            if (i == -1 || (i & 4) == 4) {
                this.a1 = loVar.Y;
            }
            if (i == -1 || (i & 8) == 8) {
                this.b1 = loVar.Z;
            }
        }
        int i2 = loVar.z;
        if (i2 == 1 || i2 == 2) {
            this.f1 = 4;
        } else {
            this.f1 = i2;
        }
    }

    @Override // defpackage.qe0
    public final Parcelable s(View view) {
        AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
        return new lo(this);
    }

    @Override // defpackage.qe0
    public final boolean t(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2) {
        this.i1 = 0;
        this.j1 = false;
        return (i & 2) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00aa  */
    @Override // defpackage.qe0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void u(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
        float yVelocity;
        int i2 = 3;
        if (view.getTop() == F()) {
            O(3);
            return;
        }
        if (I(view2) && this.j1) {
            if (this.i1 > 0) {
                if (!this.f && view.getTop() > this.W0) {
                    i2 = 6;
                }
            } else if (this.a1) {
                VelocityTracker velocityTracker = this.t1;
                if (velocityTracker == null) {
                    yVelocity = 0.0f;
                } else {
                    velocityTracker.computeCurrentVelocity(1000, this.z);
                    yVelocity = this.t1.getYVelocity(this.v1);
                }
                if (P(view, yVelocity)) {
                    i2 = 5;
                }
            } else if (this.i1 == 0) {
                int top = view.getTop();
                if (!this.f) {
                    int i3 = this.W0;
                    if (top < i3) {
                        if (top >= Math.abs(top - this.Y0)) {
                        }
                    } else if (Math.abs(top - i3) < Math.abs(top - this.Y0)) {
                    }
                    i2 = 6;
                } else if (Math.abs(top - this.V0) >= Math.abs(top - this.Y0)) {
                    i2 = 4;
                }
            } else {
                if (!this.f) {
                    int top2 = view.getTop();
                    if (Math.abs(top2 - this.W0) < Math.abs(top2 - this.Y0)) {
                    }
                }
                i2 = 4;
            }
            Q(view, i2, false);
            this.j1 = false;
        }
    }

    @Override // defpackage.qe0
    public final boolean v(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i = this.f1;
        if (i == 1 && actionMasked == 0) {
            return true;
        }
        zp4 zp4Var = this.g1;
        boolean z = this.c1;
        if (zp4Var != null && (z || i == 1)) {
            zp4Var.l(motionEvent);
        }
        if (actionMasked == 0) {
            this.v1 = -1;
            this.w1 = -1;
            this.x1 = null;
            VelocityTracker velocityTracker = this.t1;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.t1 = null;
            }
        }
        VelocityTracker velocityTrackerObtain = this.t1;
        if (velocityTrackerObtain == null) {
            velocityTrackerObtain = VelocityTracker.obtain();
            this.t1 = velocityTrackerObtain;
        }
        velocityTrackerObtain.addMovement(motionEvent);
        if (this.g1 != null && ((z || this.f1 == 1) && actionMasked == 2 && !this.h1)) {
            float fAbs = Math.abs(this.w1 - motionEvent.getY());
            zp4 zp4Var2 = this.g1;
            if (fAbs > zp4Var2.b) {
                zp4Var2.c(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.h1;
    }

    public final int w(View view, int i, int i2) {
        int iA;
        String string = view.getResources().getString(i);
        t6 t6Var = new t6(i2, 1, this);
        ArrayList arrayListG = wp4.g(view);
        int i3 = 0;
        while (true) {
            if (i3 >= arrayListG.size()) {
                int i4 = 0;
                int i5 = -1;
                while (true) {
                    int[] iArr = wp4.d;
                    if (i4 >= 32 || i5 != -1) {
                        break;
                    }
                    int i6 = iArr[i4];
                    boolean z = true;
                    for (int i7 = 0; i7 < arrayListG.size(); i7++) {
                        z &= ((i2) arrayListG.get(i7)).a() != i6;
                    }
                    if (z) {
                        i5 = i6;
                    }
                    i4++;
                }
                iA = i5;
            } else {
                if (TextUtils.equals(string, ((AccessibilityNodeInfo.AccessibilityAction) ((i2) arrayListG.get(i3)).a).getLabel())) {
                    iA = ((i2) arrayListG.get(i3)).a();
                    break;
                }
                i3++;
            }
        }
        if (iA != -1) {
            i2 i2Var = new i2(null, iA, string, t6Var, null);
            View.AccessibilityDelegate accessibilityDelegateE = wp4.e(view);
            h2 h2Var = accessibilityDelegateE == null ? null : accessibilityDelegateE instanceof g2 ? ((g2) accessibilityDelegateE).a : new h2(accessibilityDelegateE);
            if (h2Var == null) {
                h2Var = new h2();
            }
            wp4.n(view, h2Var);
            wp4.k(view, i2Var.a());
            wp4.g(view).add(i2Var);
            wp4.i(view, 0);
        }
        return iA;
    }

    public final void x() {
        int iZ = z();
        boolean z = this.f;
        int i = this.n1;
        if (z) {
            this.Y0 = Math.max(i - iZ, this.V0);
        } else {
            this.Y0 = i - iZ;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float y() {
        WeakReference weakReference;
        WindowInsets rootWindowInsets;
        float f;
        float f2 = 0.0f;
        yi2 yi2Var = this.A0;
        if (yi2Var != null && (weakReference = this.o1) != null && weakReference.get() != null && Build.VERSION.SDK_INT >= 31) {
            View view = (View) this.o1.get();
            if (H() && (rootWindowInsets = view.getRootWindowInsets()) != null) {
                float fI = yi2Var.i();
                RoundedCorner roundedCorner = rootWindowInsets.getRoundedCorner(0);
                if (roundedCorner != null) {
                    float radius = roundedCorner.getRadius();
                    f = (radius <= 0.0f || fI <= 0.0f) ? 0.0f : radius / fI;
                }
                float[] fArr = yi2Var.T0;
                float fA = fArr != null ? fArr[0] : yi2Var.f.a.d().f.a(yi2Var.g());
                RoundedCorner roundedCorner2 = rootWindowInsets.getRoundedCorner(1);
                if (roundedCorner2 != null) {
                    float radius2 = roundedCorner2.getRadius();
                    if (radius2 > 0.0f && fA > 0.0f) {
                        f2 = radius2 / fA;
                    }
                }
                return Math.max(f, f2);
            }
        }
        return 0.0f;
    }

    public final int z() {
        int iMin;
        int i;
        int i2;
        if (this.Z) {
            iMin = Math.min(Math.max(this.y0, this.n1 - ((this.m1 * 9) / 16)), this.l1);
            i = this.N0;
        } else {
            if (!this.F0 && !this.G0 && (i2 = this.E0) > 0) {
                return Math.max(this.Y, i2 + this.z0);
            }
            iMin = this.Y;
            i = this.N0;
        }
        return iMin + i;
    }

    public BottomSheetBehavior() {
        this.b = 0;
        this.f = true;
        this.C0 = -1;
        this.D0 = -1;
        this.S0 = new mo(this);
        this.X0 = 0.5f;
        this.Z0 = -1.0f;
        this.c1 = true;
        this.d1 = true;
        this.f1 = 4;
        this.k1 = 0.1f;
        this.r1 = new ArrayList();
        this.s1 = new ArrayList();
        this.w1 = -1;
        this.A1 = new SparseIntArray();
        this.B1 = new SparseIntArray();
        this.C1 = new SparseIntArray();
        this.D1 = new jo(0, this);
    }

    @Override // defpackage.qe0
    public final void p(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int[] iArr) {
    }
}
