package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.view.ScrollingView;
import defpackage.ad0;
import defpackage.ag3;
import defpackage.b23;
import defpackage.bd3;
import defpackage.bg3;
import defpackage.cc1;
import defpackage.cg3;
import defpackage.dg3;
import defpackage.dw2;
import defpackage.e24;
import defpackage.eg3;
import defpackage.fb2;
import defpackage.ff2;
import defpackage.fg3;
import defpackage.fq4;
import defpackage.fw;
import defpackage.gb4;
import defpackage.gg3;
import defpackage.gk1;
import defpackage.h22;
import defpackage.h31;
import defpackage.hg3;
import defpackage.hm2;
import defpackage.i40;
import defpackage.ig3;
import defpackage.ik1;
import defpackage.in1;
import defpackage.iz2;
import defpackage.j40;
import defpackage.j5;
import defpackage.jg3;
import defpackage.k5;
import defpackage.kg3;
import defpackage.mg3;
import defpackage.n12;
import defpackage.ng3;
import defpackage.nu0;
import defpackage.of3;
import defpackage.og3;
import defpackage.pf3;
import defpackage.pg3;
import defpackage.pp4;
import defpackage.qe4;
import defpackage.qf3;
import defpackage.qg3;
import defpackage.r02;
import defpackage.rf3;
import defpackage.rg3;
import defpackage.s53;
import defpackage.st4;
import defpackage.tg3;
import defpackage.v02;
import defpackage.vf3;
import defpackage.vp1;
import defpackage.wf3;
import defpackage.wp4;
import defpackage.wq2;
import defpackage.xe;
import defpackage.xf3;
import defpackage.xp4;
import defpackage.xq2;
import defpackage.xq4;
import defpackage.xw3;
import defpackage.yf3;
import defpackage.yl0;
import io.netty.channel.internal.ChannelUtils;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.sentry.android.core.a1;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements ScrollingView, wq2 {
    public static boolean T1 = false;
    public static boolean U1 = false;
    public static final int[] V1 = {R.attr.nestedScrollingEnabled};
    public static final float W1 = (float) (Math.log(0.78d) / Math.log(0.9d));
    public static final boolean X1 = true;
    public static final boolean Y1 = true;
    public static final Class[] Z1;
    public static final h22 a2;
    public static final og3 b2;
    public kg3 A;
    public final e24 A0;
    public ArrayList A1;
    public boolean B0;
    public boolean B1;
    public final of3 C0;
    public boolean C1;
    public final Rect D0;
    public final qf3 D1;
    public final Rect E0;
    public boolean E1;
    public final RectF F0;
    public tg3 F1;
    public rf3 G0;
    public final int[] G1;
    public ag3 H0;
    public xq2 H1;
    public final ArrayList I0;
    public final int[] I1;
    public final ArrayList J0;
    public final int[] J1;
    public final ArrayList K0;
    public final int[] K1;
    public eg3 L0;
    public final ArrayList L1;
    public boolean M0;
    public final of3 M1;
    public boolean N0;
    public boolean N1;
    public boolean O0;
    public int O1;
    public int P0;
    public int P1;
    public boolean Q0;
    public final boolean Q1;
    public boolean R0;
    public final pf3 R1;
    public boolean S0;
    public final nu0 S1;
    public int T0;
    public boolean U0;
    public final AccessibilityManager V0;
    public ArrayList W0;
    public boolean X0;
    public boolean Y0;
    public int Z0;
    public int a1;
    public final float b;
    public wf3 b1;
    public EdgeEffect c1;
    public EdgeEffect d1;
    public EdgeEffect e1;
    public final ik1 f;
    public EdgeEffect f1;
    public xf3 g1;
    public int h1;
    public int i1;
    public VelocityTracker j1;
    public int k1;
    public int l1;
    public int m1;
    public int n1;
    public int o1;
    public dg3 p1;
    public final int q1;
    public final int r1;
    public final float s1;
    public final float t1;
    public boolean u1;
    public final qg3 v1;
    public in1 w1;
    public final r02 x1;
    public final k5 y0;
    public final ng3 y1;
    public final ig3 z;
    public final j40 z0;
    public fg3 z1;

    static {
        Class cls = Integer.TYPE;
        Z1 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        a2 = new h22(2);
        b2 = new og3();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RecyclerView(Context context, AttributeSet attributeSet, int i) throws NoSuchMethodException {
        float fA;
        TypedArray typedArray;
        char c;
        char c2;
        char c3;
        AttributeSet attributeSet2;
        int i2;
        int i3;
        Object[] objArr;
        Constructor constructor;
        super(context, attributeSet, i);
        this.f = new ik1(3, this);
        this.z = new ig3(this);
        this.A0 = new e24(16);
        this.C0 = new of3(this, 0);
        this.D0 = new Rect();
        this.E0 = new Rect();
        this.F0 = new RectF();
        this.I0 = new ArrayList();
        this.J0 = new ArrayList();
        this.K0 = new ArrayList();
        this.P0 = 0;
        this.X0 = false;
        this.Y0 = false;
        this.Z0 = 0;
        this.a1 = 0;
        this.b1 = b2;
        this.g1 = new yl0();
        this.h1 = 0;
        this.i1 = -1;
        this.s1 = Float.MIN_VALUE;
        this.t1 = Float.MIN_VALUE;
        int i4 = 1;
        this.u1 = true;
        this.v1 = new qg3(this);
        this.x1 = Y1 ? new r02() : null;
        ng3 ng3Var = new ng3();
        ng3Var.a = -1;
        ng3Var.b = 0;
        ng3Var.c = 0;
        ng3Var.d = 1;
        ng3Var.e = 0;
        ng3Var.f = false;
        ng3Var.g = false;
        ng3Var.h = false;
        ng3Var.i = false;
        ng3Var.j = false;
        ng3Var.k = false;
        this.y1 = ng3Var;
        this.B1 = false;
        this.C1 = false;
        qf3 qf3Var = new qf3(this);
        this.D1 = qf3Var;
        this.E1 = false;
        this.G1 = new int[2];
        this.I1 = new int[2];
        this.J1 = new int[2];
        this.K1 = new int[2];
        this.L1 = new ArrayList();
        this.M1 = new of3(this, i4);
        this.O1 = 0;
        this.P1 = 0;
        this.R1 = new pf3(this);
        this.S1 = new nu0(getContext(), new qf3(this));
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.o1 = viewConfiguration.getScaledTouchSlop();
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 26) {
            Method method = xp4.a;
            fA = v02.l(viewConfiguration);
        } else {
            fA = xp4.a(viewConfiguration, context);
        }
        this.s1 = fA;
        this.t1 = i5 >= 26 ? v02.m(viewConfiguration) : xp4.a(viewConfiguration, context);
        this.q1 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.r1 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.b = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setWillNotDraw(getOverScrollMode() == 2);
        this.g1.a = qf3Var;
        this.y0 = new k5(new pf3(this));
        this.z0 = new j40(new gk1(this));
        WeakHashMap weakHashMap = wp4.a;
        if ((i5 >= 26 ? pp4.a(this) : 0) == 0 && i5 >= 26) {
            pp4.b(this, 8);
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.V0 = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new tg3(this));
        int[] iArr = bd3.a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        wp4.m(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i);
        String string = typedArrayObtainStyledAttributes.getString(8);
        if (typedArrayObtainStyledAttributes.getInt(2, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.B0 = typedArrayObtainStyledAttributes.getBoolean(1, true);
        if (typedArrayObtainStyledAttributes.getBoolean(3, false)) {
            StateListDrawable stateListDrawable = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(6);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(7);
            StateListDrawable stateListDrawable2 = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(4);
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(5);
            if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
                xe.k("Trying to set fast scroller without both required drawables.".concat(C()));
                throw null;
            }
            Resources resources = getContext().getResources();
            c = 3;
            c3 = 2;
            i2 = i;
            typedArray = typedArrayObtainStyledAttributes;
            c2 = 1;
            i3 = 4;
            attributeSet2 = attributeSet;
            new cc1(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(com.getsurfboard.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(com.getsurfboard.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(com.getsurfboard.R.dimen.fastscroll_margin));
        } else {
            typedArray = typedArrayObtainStyledAttributes;
            c = 3;
            c2 = 1;
            c3 = 2;
            attributeSet2 = attributeSet;
            i2 = i;
            i3 = 4;
        }
        typedArray.recycle();
        this.Q1 = context.getPackageManager().hasSystemFeature("android.hardware.rotaryencoder.lowres");
        if (string != null) {
            String strTrim = string.trim();
            if (!strTrim.isEmpty()) {
                if (strTrim.charAt(0) == '.') {
                    strTrim = context.getPackageName() + strTrim;
                } else if (!strTrim.contains(".")) {
                    strTrim = RecyclerView.class.getPackage().getName() + '.' + strTrim;
                }
                String str = strTrim;
                try {
                    Class<? extends U> clsAsSubclass = Class.forName(str, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(ag3.class);
                    try {
                        Constructor constructor2 = clsAsSubclass.getConstructor(Z1);
                        objArr = new Object[i3];
                        objArr[0] = context;
                        objArr[c2] = attributeSet2;
                        objArr[c3] = Integer.valueOf(i2);
                        objArr[c] = 0;
                        constructor = constructor2;
                    } catch (NoSuchMethodException e) {
                        try {
                            objArr = null;
                            constructor = clsAsSubclass.getConstructor(null);
                        } catch (NoSuchMethodException e2) {
                            e2.initCause(e);
                            throw new IllegalStateException(attributeSet2.getPositionDescription() + ": Error creating LayoutManager " + str, e2);
                        }
                    }
                    constructor.setAccessible(c2);
                    setLayoutManager((ag3) constructor.newInstance(objArr));
                } catch (ClassCastException e3) {
                    s53.i(attributeSet2.getPositionDescription(), ": Class is not a LayoutManager ", str, e3);
                    throw null;
                } catch (ClassNotFoundException e4) {
                    s53.i(attributeSet2.getPositionDescription(), ": Unable to find LayoutManager ", str, e4);
                    throw null;
                } catch (IllegalAccessException e5) {
                    s53.i(attributeSet2.getPositionDescription(), ": Cannot access non-public constructor ", str, e5);
                    throw null;
                } catch (InstantiationException e6) {
                    s53.i(attributeSet2.getPositionDescription(), ": Could not instantiate the LayoutManager: ", str, e6);
                    throw null;
                } catch (InvocationTargetException e7) {
                    s53.i(attributeSet2.getPositionDescription(), ": Could not instantiate the LayoutManager: ", str, e7);
                    throw null;
                }
            }
        }
        int[] iArr2 = V1;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet2, iArr2, i2, 0);
        wp4.m(this, context, iArr2, attributeSet2, typedArrayObtainStyledAttributes2, i2);
        boolean z = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z);
        setTag(com.getsurfboard.R.id.is_pooling_container_tag, Boolean.TRUE);
    }

    public static RecyclerView I(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView recyclerViewI = I(viewGroup.getChildAt(i));
            if (recyclerViewI != null) {
                return recyclerViewI;
            }
        }
        return null;
    }

    public static rg3 O(View view) {
        if (view == null) {
            return null;
        }
        return ((bg3) view.getLayoutParams()).a;
    }

    public static void P(View view, Rect rect) {
        bg3 bg3Var = (bg3) view.getLayoutParams();
        Rect rect2 = bg3Var.b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) bg3Var).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) bg3Var).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) bg3Var).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) bg3Var).bottomMargin);
    }

    private xq2 getScrollingChildHelper() {
        xq2 xq2Var = this.H1;
        if (xq2Var != null) {
            return xq2Var;
        }
        xq2 xq2Var2 = new xq2(this);
        this.H1 = xq2Var2;
        return xq2Var2;
    }

    public static void l(rg3 rg3Var) {
        WeakReference weakReference = rg3Var.b;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view == rg3Var.a) {
                    return;
                }
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            rg3Var.b = null;
        }
    }

    public static int o(int i, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i2) {
        if (i > 0 && edgeEffect != null && n12.B(edgeEffect) != 0.0f) {
            int iRound = Math.round(n12.L(edgeEffect, ((-i) * 4.0f) / i2, 0.5f) * ((-i2) / 4.0f));
            if (iRound != i) {
                edgeEffect.finish();
            }
            return i - iRound;
        }
        if (i >= 0 || edgeEffect2 == null || n12.B(edgeEffect2) == 0.0f) {
            return i;
        }
        float f = i2;
        int iRound2 = Math.round(n12.L(edgeEffect2, (i * 4.0f) / f, 0.5f) * (f / 4.0f));
        if (iRound2 != i) {
            edgeEffect2.finish();
        }
        return i - iRound2;
    }

    public static void setDebugAssertionsEnabled(boolean z) {
        T1 = z;
    }

    public static void setVerboseLoggingEnabled(boolean z) {
        U1 = z;
    }

    public final void A() {
        if (this.e1 != null) {
            return;
        }
        ((og3) this.b1).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.e1 = edgeEffect;
        if (this.B0) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void B() {
        if (this.d1 != null) {
            return;
        }
        ((og3) this.b1).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.d1 = edgeEffect;
        if (this.B0) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final String C() {
        return " " + super.toString() + ", adapter:" + this.G0 + ", layout:" + this.H0 + ", context:" + getContext();
    }

    public final void D(ng3 ng3Var) {
        if (getScrollState() != 2) {
            ng3Var.getClass();
            return;
        }
        OverScroller overScroller = this.v1.z;
        overScroller.getFinalX();
        overScroller.getCurrX();
        ng3Var.getClass();
        overScroller.getFinalY();
        overScroller.getCurrY();
    }

    public final View E(float f, float f2) {
        j40 j40Var = this.z0;
        for (int iE = j40Var.e() - 1; iE >= 0; iE--) {
            View viewD = j40Var.d(iE);
            float translationX = viewD.getTranslationX();
            float translationY = viewD.getTranslationY();
            if (f >= viewD.getLeft() + translationX && f <= viewD.getRight() + translationX && f2 >= viewD.getTop() + translationY && f2 <= viewD.getBottom() + translationY) {
                return viewD;
            }
        }
        return null;
    }

    public final View F(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public final boolean G(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        ArrayList arrayList = this.K0;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            eg3 eg3Var = (eg3) arrayList.get(i);
            if (eg3Var.c(this, motionEvent) && action != 3) {
                this.L0 = eg3Var;
                return true;
            }
        }
        return false;
    }

    public final void H(int[] iArr) {
        j40 j40Var = this.z0;
        int iE = j40Var.e();
        if (iE == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < iE; i3++) {
            rg3 rg3VarO = O(j40Var.d(i3));
            if (!rg3VarO.q()) {
                int iD = rg3VarO.d();
                if (iD < i) {
                    i = iD;
                }
                if (iD > i2) {
                    i2 = iD;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    public final rg3 J(int i) {
        rg3 rg3Var = null;
        if (this.X0) {
            return null;
        }
        j40 j40Var = this.z0;
        int iH = j40Var.h();
        for (int i2 = 0; i2 < iH; i2++) {
            rg3 rg3VarO = O(j40Var.g(i2));
            if (rg3VarO != null && !rg3VarO.j() && L(rg3VarO) == i) {
                if (!((ArrayList) j40Var.e).contains(rg3VarO.a)) {
                    return rg3VarO;
                }
                rg3Var = rg3VarO;
            }
        }
        return rg3Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean K(int i, int i2, int i3, int i4) {
        int iMax;
        int i5;
        qg3 qg3Var;
        float f;
        float f2;
        boolean z;
        boolean z2;
        boolean z3;
        int minFlingVelocity;
        boolean z4;
        int iK;
        PointF pointFA;
        int i6;
        ag3 ag3Var = this.H0;
        if (ag3Var == null) {
            a1.d("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (!this.R0) {
            boolean zD = ag3Var.d();
            boolean zE = this.H0.e();
            int i7 = (!zD || Math.abs(i) < i3) ? 0 : i;
            int iMax2 = (!zE || Math.abs(i2) < i3) ? 0 : i2;
            if (i7 != 0 || iMax2 != 0) {
                if (i7 == 0) {
                    iMax = 0;
                    if (iMax2 == 0) {
                        i5 = iMax2;
                        iMax2 = 0;
                        qg3Var = this.v1;
                        if (iMax == 0 || iMax2 != 0) {
                            int i8 = -i4;
                            iMax = Math.max(i8, Math.min(iMax, i4));
                            iMax2 = Math.max(i8, Math.min(iMax2, i4));
                            q0(1);
                            qg3Var.a(iMax, iMax2);
                        }
                        if (i7 == 0 || i5 != 0) {
                            f = i7;
                            f2 = i5;
                            if (!dispatchNestedPreFling(f, f2)) {
                                boolean z5 = zD || zE;
                                dispatchNestedFling(f, f2, z5);
                                dg3 dg3Var = this.p1;
                                if (dg3Var != null) {
                                    xq4 xq4Var = (xq4) dg3Var;
                                    ag3 layoutManager = xq4Var.a.getLayoutManager();
                                    if (layoutManager != 0 && xq4Var.a.getAdapter() != null && ((Math.abs(i5) > (minFlingVelocity = xq4Var.a.getMinFlingVelocity()) || Math.abs(i7) > minFlingVelocity) && ((z4 = layoutManager instanceof mg3)))) {
                                        View view = null;
                                        iz2 iz2Var = !z4 ? null : new iz2(xq4Var, xq4Var.a.getContext());
                                        if (iz2Var == null) {
                                            z = z5;
                                            z2 = false;
                                            z3 = true;
                                        } else {
                                            int iF = layoutManager.F();
                                            if (iF != 0) {
                                                h31 h31VarF = layoutManager.e() ? xq4Var.f(layoutManager) : layoutManager.d() ? xq4Var.e(layoutManager) : null;
                                                if (h31VarF == null) {
                                                    z = z5;
                                                    z2 = false;
                                                    z3 = true;
                                                } else {
                                                    z2 = false;
                                                    int iV = layoutManager.v();
                                                    z3 = true;
                                                    int i9 = 0;
                                                    int i10 = Integer.MIN_VALUE;
                                                    int i11 = Integer.MAX_VALUE;
                                                    View view2 = null;
                                                    while (i9 < iV) {
                                                        boolean z6 = z5;
                                                        View viewU = layoutManager.u(i9);
                                                        if (viewU == null) {
                                                            i6 = iV;
                                                        } else {
                                                            i6 = iV;
                                                            int iB = xq4.b(viewU, h31VarF);
                                                            if (iB <= 0 && iB > i10) {
                                                                view2 = viewU;
                                                                i10 = iB;
                                                            }
                                                            if (iB >= 0 && iB < i11) {
                                                                view = viewU;
                                                                i11 = iB;
                                                            }
                                                        }
                                                        i9++;
                                                        z5 = z6;
                                                        iV = i6;
                                                    }
                                                    z = z5;
                                                    Object[] objArr = !layoutManager.d() ? i5 <= 0 : i7 <= 0;
                                                    if (objArr == true && view != null) {
                                                        iK = ag3.K(view);
                                                    } else if (objArr == true || view2 == null) {
                                                        if (objArr != false) {
                                                            view = view2;
                                                        }
                                                        if (view != null) {
                                                            iK = ((z4 && (pointFA = ((mg3) layoutManager).a(layoutManager.F() + (-1))) != null && ((pointFA.x > 0.0f ? 1 : (pointFA.x == 0.0f ? 0 : -1)) < 0 || (pointFA.y > 0.0f ? 1 : (pointFA.y == 0.0f ? 0 : -1)) < 0)) == objArr ? -1 : 1) + ag3.K(view);
                                                            if (iK < 0 || iK >= iF) {
                                                            }
                                                        }
                                                    } else {
                                                        iK = ag3.K(view2);
                                                    }
                                                    if (iK != -1) {
                                                        iz2Var.a = iK;
                                                        layoutManager.H0(iz2Var);
                                                        return z3;
                                                    }
                                                }
                                                iK = -1;
                                                if (iK != -1) {
                                                }
                                            }
                                        }
                                    }
                                }
                                if (!z) {
                                    return z2;
                                }
                                boolean z7 = z3;
                                q0(z7 ? 1 : 0);
                                int i12 = -i4;
                                qg3Var.a(Math.max(i12, Math.min(i7, i4)), Math.max(i12, Math.min(i5, i4)));
                                return z7;
                            }
                        } else if (iMax != 0 || iMax2 != 0) {
                            return true;
                        }
                    } else {
                        EdgeEffect edgeEffect = this.d1;
                        if (edgeEffect == null || n12.B(edgeEffect) == 0.0f) {
                            EdgeEffect edgeEffect2 = this.f1;
                            if (edgeEffect2 != null && n12.B(edgeEffect2) != 0.0f) {
                                if (m0(this.f1, iMax2, getHeight())) {
                                    this.f1.onAbsorb(iMax2);
                                    iMax2 = 0;
                                }
                                i5 = 0;
                                qg3Var = this.v1;
                                if (iMax == 0) {
                                    int i82 = -i4;
                                    iMax = Math.max(i82, Math.min(iMax, i4));
                                    iMax2 = Math.max(i82, Math.min(iMax2, i4));
                                    q0(1);
                                    qg3Var.a(iMax, iMax2);
                                    if (i7 == 0) {
                                        f = i7;
                                        f2 = i5;
                                        if (!dispatchNestedPreFling(f, f2)) {
                                        }
                                    }
                                }
                            }
                            i5 = iMax2;
                            iMax2 = 0;
                            qg3Var = this.v1;
                            if (iMax == 0) {
                            }
                        } else {
                            int i13 = -iMax2;
                            if (m0(this.d1, i13, getHeight())) {
                                this.d1.onAbsorb(i13);
                                iMax2 = 0;
                            }
                            i5 = 0;
                            qg3Var = this.v1;
                            if (iMax == 0) {
                            }
                        }
                    }
                } else {
                    EdgeEffect edgeEffect3 = this.c1;
                    if (edgeEffect3 == null || n12.B(edgeEffect3) == 0.0f) {
                        EdgeEffect edgeEffect4 = this.e1;
                        if (edgeEffect4 != null && n12.B(edgeEffect4) != 0.0f) {
                            if (m0(this.e1, i7, getWidth())) {
                                this.e1.onAbsorb(i7);
                                i7 = 0;
                            }
                            iMax = i7;
                            i7 = 0;
                            if (iMax2 == 0) {
                            }
                        }
                        iMax = 0;
                        if (iMax2 == 0) {
                        }
                    } else {
                        int i14 = -i7;
                        if (m0(this.c1, i14, getWidth())) {
                            this.c1.onAbsorb(i14);
                            i7 = 0;
                        }
                        iMax = i7;
                        i7 = 0;
                        if (iMax2 == 0) {
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int L(rg3 rg3Var) {
        if ((rg3Var.j & 524) == 0 && rg3Var.g()) {
            int i = rg3Var.c;
            ArrayList arrayList = (ArrayList) this.y0.c;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                j5 j5Var = (j5) arrayList.get(i2);
                int i3 = j5Var.a;
                if (i3 != 1) {
                    if (i3 == 2) {
                        int i4 = j5Var.b;
                        if (i4 <= i) {
                            int i5 = j5Var.d;
                            if (i4 + i5 <= i) {
                                i -= i5;
                            }
                        } else {
                            continue;
                        }
                    } else if (i3 == 8) {
                        int i6 = j5Var.b;
                        if (i6 == i) {
                            i = j5Var.d;
                        } else {
                            if (i6 < i) {
                                i--;
                            }
                            if (j5Var.d <= i) {
                                i++;
                            }
                        }
                    }
                } else if (j5Var.b <= i) {
                    i += j5Var.d;
                }
            }
            return i;
        }
        return -1;
    }

    public final long M(rg3 rg3Var) {
        return this.G0.b ? rg3Var.e : rg3Var.c;
    }

    public final rg3 N(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return O(view);
        }
        ad0.k("View ", view, " is not a direct child of ", this);
        return null;
    }

    public final Rect Q(View view) {
        bg3 bg3Var = (bg3) view.getLayoutParams();
        boolean z = bg3Var.c;
        Rect rect = bg3Var.b;
        if (!z || (this.y1.g && (bg3Var.a.m() || bg3Var.a.h()))) {
            return rect;
        }
        rect.set(0, 0, 0, 0);
        ArrayList arrayList = this.J0;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Rect rect2 = this.D0;
            rect2.set(0, 0, 0, 0);
            ((yf3) arrayList.get(i)).f(rect2, view, this);
            rect.left += rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        bg3Var.c = false;
        return rect;
    }

    public final boolean R() {
        return !this.O0 || this.X0 || this.y0.k();
    }

    public final void S() {
        if (this.J0.size() == 0) {
            return;
        }
        ag3 ag3Var = this.H0;
        if (ag3Var != null) {
            ag3Var.c("Cannot invalidate item decorations during a scroll or layout");
        }
        V();
        requestLayout();
    }

    public final boolean T() {
        return this.Z0 > 0;
    }

    public final void U(int i) {
        if (this.H0 == null) {
            return;
        }
        setScrollState(2);
        this.H0.w0(i);
        awakenScrollBars();
    }

    public final void V() {
        j40 j40Var = this.z0;
        int iH = j40Var.h();
        for (int i = 0; i < iH; i++) {
            ((bg3) j40Var.g(i).getLayoutParams()).c = true;
        }
        ArrayList arrayList = this.z.c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            bg3 bg3Var = (bg3) ((rg3) arrayList.get(i2)).a.getLayoutParams();
            if (bg3Var != null) {
                bg3Var.c = true;
            }
        }
    }

    public final void W(int i, int i2, boolean z) {
        int i3 = i + i2;
        j40 j40Var = this.z0;
        int iH = j40Var.h();
        for (int i4 = 0; i4 < iH; i4++) {
            rg3 rg3VarO = O(j40Var.g(i4));
            if (rg3VarO != null && !rg3VarO.q()) {
                int i5 = rg3VarO.c;
                ng3 ng3Var = this.y1;
                if (i5 >= i3) {
                    if (U1) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + i4 + " holder " + rg3VarO + " now at position " + (rg3VarO.c - i2));
                    }
                    rg3VarO.n(-i2, z);
                    ng3Var.f = true;
                } else if (i5 >= i) {
                    if (U1) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + i4 + " holder " + rg3VarO + " now REMOVED");
                    }
                    rg3VarO.a(8);
                    rg3VarO.n(-i2, z);
                    rg3VarO.c = i - 1;
                    ng3Var.f = true;
                }
            }
        }
        ig3 ig3Var = this.z;
        ArrayList arrayList = ig3Var.c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            rg3 rg3Var = (rg3) arrayList.get(size);
            if (rg3Var != null) {
                int i6 = rg3Var.c;
                if (i6 >= i3) {
                    if (U1) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove cached " + size + " holder " + rg3Var + " now at position " + (rg3Var.c - i2));
                    }
                    rg3Var.n(-i2, z);
                } else if (i6 >= i) {
                    rg3Var.a(8);
                    ig3Var.h(size);
                }
            }
        }
        requestLayout();
    }

    public final void X() {
        this.Z0++;
    }

    public final void Y(boolean z) {
        int i;
        AccessibilityManager accessibilityManager;
        int i2 = this.Z0 - 1;
        this.Z0 = i2;
        if (i2 < 1) {
            if (T1 && i2 < 0) {
                xe.q("layout or scroll counter cannot go below zero.Some calls are not matching".concat(C()));
                return;
            }
            this.Z0 = 0;
            if (z) {
                int i3 = this.T0;
                this.T0 = 0;
                if (i3 != 0 && (accessibilityManager = this.V0) != null && accessibilityManager.isEnabled()) {
                    AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                    accessibilityEventObtain.setEventType(2048);
                    accessibilityEventObtain.setContentChangeTypes(i3);
                    sendAccessibilityEventUnchecked(accessibilityEventObtain);
                }
                ArrayList arrayList = this.L1;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    rg3 rg3Var = (rg3) arrayList.get(size);
                    if (rg3Var.a.getParent() == this && !rg3Var.q() && (i = rg3Var.q) != -1) {
                        rg3Var.a.setImportantForAccessibility(i);
                        rg3Var.q = -1;
                    }
                }
                arrayList.clear();
            }
        }
    }

    public final void Z(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.i1) {
            int i = actionIndex == 0 ? 1 : 0;
            this.i1 = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.m1 = x;
            this.k1 = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.n1 = y;
            this.l1 = y;
        }
    }

    public final void a0() {
        if (this.E1 || !this.M0) {
            return;
        }
        WeakHashMap weakHashMap = wp4.a;
        postOnAnimation(this.M1);
        this.E1 = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i, int i2) {
        ag3 ag3Var = this.H0;
        if (ag3Var != null) {
            ag3Var.getClass();
        }
        super.addFocusables(arrayList, i, i2);
    }

    public final void b0() {
        boolean z;
        boolean z2 = this.X0;
        k5 k5Var = this.y0;
        boolean z3 = false;
        if (z2) {
            k5Var.s((ArrayList) k5Var.c);
            k5Var.s((ArrayList) k5Var.d);
            k5Var.a = 0;
            if (this.Y0) {
                this.H0.e0();
            }
        }
        if (this.g1 != null && this.H0.I0()) {
            k5Var.r();
        } else {
            k5Var.e();
        }
        boolean z4 = this.B1 || this.C1;
        boolean z5 = this.O0 && this.g1 != null && ((z = this.X0) || z4 || this.H0.f) && (!z || this.G0.b);
        ng3 ng3Var = this.y1;
        ng3Var.j = z5;
        if (z5 && z4 && !this.X0 && this.g1 != null && this.H0.I0()) {
            z3 = true;
        }
        ng3Var.k = z3;
    }

    public final void c0(boolean z) {
        this.Y0 = z | this.Y0;
        this.X0 = true;
        j40 j40Var = this.z0;
        int iH = j40Var.h();
        for (int i = 0; i < iH; i++) {
            rg3 rg3VarO = O(j40Var.g(i));
            if (rg3VarO != null && !rg3VarO.q()) {
                rg3VarO.a(6);
            }
        }
        V();
        ig3 ig3Var = this.z;
        ArrayList arrayList = ig3Var.c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            rg3 rg3Var = (rg3) arrayList.get(i2);
            if (rg3Var != null) {
                rg3Var.a(6);
                rg3Var.a(1024);
            }
        }
        rf3 rf3Var = ig3Var.h.G0;
        if (rf3Var == null || !rf3Var.b) {
            ig3Var.g();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof bg3) && this.H0.f((bg3) layoutParams);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeHorizontalScrollExtent() {
        ag3 ag3Var = this.H0;
        if (ag3Var != null && ag3Var.d()) {
            return this.H0.j(this.y1);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeHorizontalScrollOffset() {
        ag3 ag3Var = this.H0;
        if (ag3Var != null && ag3Var.d()) {
            return this.H0.k(this.y1);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeHorizontalScrollRange() {
        ag3 ag3Var = this.H0;
        if (ag3Var != null && ag3Var.d()) {
            return this.H0.l(this.y1);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeVerticalScrollExtent() {
        ag3 ag3Var = this.H0;
        if (ag3Var != null && ag3Var.e()) {
            return this.H0.m(this.y1);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeVerticalScrollOffset() {
        ag3 ag3Var = this.H0;
        if (ag3Var != null && ag3Var.e()) {
            return this.H0.n(this.y1);
        }
        return 0;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public final int computeVerticalScrollRange() {
        ag3 ag3Var = this.H0;
        if (ag3Var != null && ag3Var.e()) {
            return this.H0.o(this.y1);
        }
        return 0;
    }

    public final void d0(rg3 rg3Var, hm2 hm2Var) {
        rg3Var.j &= -8193;
        boolean z = this.y1.h;
        e24 e24Var = this.A0;
        if (z && rg3Var.m() && !rg3Var.j() && !rg3Var.q()) {
            ((ff2) e24Var.z).h(M(rg3Var), rg3Var);
        }
        xw3 xw3Var = (xw3) e24Var.f;
        fq4 fq4VarA = (fq4) xw3Var.get(rg3Var);
        if (fq4VarA == null) {
            fq4VarA = fq4.a();
            xw3Var.put(rg3Var, fq4VarA);
        }
        fq4VarA.b = hm2Var;
        fq4VarA.a |= 4;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        ag3 layoutManager = getLayoutManager();
        int iB = 0;
        if (layoutManager != null) {
            if (layoutManager.e()) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 92 || keyCode == 93) {
                    int measuredHeight = getMeasuredHeight();
                    if (keyCode == 93) {
                        n0(0, measuredHeight, false);
                        return true;
                    }
                    n0(0, -measuredHeight, false);
                    return true;
                }
                if (keyCode == 122 || keyCode == 123) {
                    boolean zP = layoutManager.P();
                    if (keyCode == 122) {
                        if (zP) {
                            iB = getAdapter().b();
                        }
                    } else if (!zP) {
                        iB = getAdapter().b();
                    }
                    o0(iB);
                    return true;
                }
            } else if (layoutManager.d()) {
                int keyCode2 = keyEvent.getKeyCode();
                if (keyCode2 == 92 || keyCode2 == 93) {
                    int measuredWidth = getMeasuredWidth();
                    if (keyCode2 == 93) {
                        n0(measuredWidth, 0, false);
                        return true;
                    }
                    n0(-measuredWidth, 0, false);
                    return true;
                }
                if (keyCode2 == 122 || keyCode2 == 123) {
                    boolean zP2 = layoutManager.P();
                    if (keyCode2 == 122) {
                        if (zP2) {
                            iB = getAdapter().b();
                        }
                    } else if (!zP2) {
                        iB = getAdapter().b();
                    }
                    o0(iB);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().a(f, f2, z);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().b(f, f2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(iArr, i, iArr2, i2, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().d(i, i2, i3, i4, iArr, 0, null);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        boolean z;
        super.draw(canvas);
        ArrayList arrayList = this.J0;
        int size = arrayList.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            ((yf3) arrayList.get(i)).h(canvas, this);
        }
        EdgeEffect edgeEffect = this.c1;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.B0 ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.c1;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.d1;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.B0) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.d1;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.e1;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.B0 ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.e1;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.f1;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.B0) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.f1;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(iSave4);
        }
        if ((z || this.g1 == null || arrayList.size() <= 0 || !this.g1.f()) ? z : true) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public final void e0() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.c1;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.c1.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.d1;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.d1.isFinished();
        }
        EdgeEffect edgeEffect3 = this.e1;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.e1.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f1;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.f1.isFinished();
        }
        if (zIsFinished) {
            postInvalidateOnAnimation();
        }
    }

    public final int f0(int i, float f) {
        float height = f / getHeight();
        float width = i / getWidth();
        EdgeEffect edgeEffect = this.c1;
        float f2 = 0.0f;
        if (edgeEffect == null || n12.B(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.e1;
            if (edgeEffect2 != null && n12.B(edgeEffect2) != 0.0f) {
                boolean zCanScrollHorizontally = canScrollHorizontally(1);
                EdgeEffect edgeEffect3 = this.e1;
                if (zCanScrollHorizontally) {
                    edgeEffect3.onRelease();
                } else {
                    float fL = n12.L(edgeEffect3, width, height);
                    if (n12.B(this.e1) == 0.0f) {
                        this.e1.onRelease();
                    }
                    f2 = fL;
                }
                invalidate();
            }
        } else {
            boolean zCanScrollHorizontally2 = canScrollHorizontally(-1);
            EdgeEffect edgeEffect4 = this.c1;
            if (zCanScrollHorizontally2) {
                edgeEffect4.onRelease();
            } else {
                float f3 = -n12.L(edgeEffect4, -width, 1.0f - height);
                if (n12.B(this.c1) == 0.0f) {
                    this.c1.onRelease();
                }
                f2 = f3;
            }
            invalidate();
        }
        return Math.round(f2 * getWidth());
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x0165, code lost:
    
        if (r16 > 0) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0183, code lost:
    
        if (r5 > 0) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0186, code lost:
    
        if (r16 < 0) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0189, code lost:
    
        if (r5 < 0) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0191, code lost:
    
        if ((r5 * r6) <= 0) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0199, code lost:
    
        if ((r5 * r6) >= 0) goto L138;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0119  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View focusSearch(View view, int i) {
        View viewX;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        byte b;
        boolean z;
        View viewC0 = this.H0.c0(view, i);
        if (viewC0 != null) {
            return viewC0;
        }
        boolean z2 = (this.G0 == null || this.H0 == null || T() || this.R0) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        ng3 ng3Var = this.y1;
        ig3 ig3Var = this.z;
        if (z2 && (i == 2 || i == 1)) {
            if (this.H0.e()) {
                if (focusFinder.findNextFocus(this, view, i == 2 ? 130 : 33) == null) {
                    z = true;
                }
                if (!z && this.H0.d()) {
                    z = focusFinder.findNextFocus(this, view, !((this.H0.b.getLayoutDirection() != 1) ^ (i != 2)) ? 66 : 17) != null;
                }
                if (z) {
                    p();
                    if (F(view) != null) {
                        p0();
                        this.H0.X(view, i, ig3Var, ng3Var);
                        r0(false);
                    }
                    return null;
                }
                viewX = focusFinder.findNextFocus(this, view, i);
                if (viewX == null) {
                }
                if (viewX != null) {
                    if (view != null) {
                        int width = view.getWidth();
                        int height = view.getHeight();
                        Rect rect = this.D0;
                        rect.set(0, 0, width, height);
                        int width2 = viewX.getWidth();
                        int height2 = viewX.getHeight();
                        Rect rect2 = this.E0;
                        rect2.set(0, 0, width2, height2);
                        offsetDescendantRectToMyCoords(view, rect);
                        offsetDescendantRectToMyCoords(viewX, rect2);
                        if (this.H0.b.getLayoutDirection() != 1) {
                        }
                        i2 = rect.left;
                        i3 = rect2.left;
                        if (i2 >= i3) {
                        }
                        i5 = 1;
                        i6 = rect.top;
                        i7 = rect2.top;
                        if (i6 >= i7) {
                        }
                        b = 1;
                        if (i == 1) {
                        }
                    }
                    return viewX;
                }
                return super.focusSearch(view, i);
            }
            z = false;
            if (!z) {
                if (focusFinder.findNextFocus(this, view, !((this.H0.b.getLayoutDirection() != 1) ^ (i != 2)) ? 66 : 17) != null) {
                }
            }
            if (z) {
            }
            viewX = focusFinder.findNextFocus(this, view, i);
            if (viewX == null) {
            }
            if (viewX != null) {
            }
            return super.focusSearch(view, i);
        }
        View viewFindNextFocus = focusFinder.findNextFocus(this, view, i);
        if (viewFindNextFocus == null && z2) {
            p();
            if (F(view) != null) {
                p0();
                viewX = this.H0.X(view, i, ig3Var, ng3Var);
                r0(false);
            }
            return null;
        }
        viewX = viewFindNextFocus;
        if (viewX == null && !viewX.hasFocusable()) {
            if (getFocusedChild() == null) {
                return super.focusSearch(view, i);
            }
            i0(viewX, null);
            return view;
        }
        if (viewX != null && viewX != this && viewX != view && F(viewX) != null) {
            if (view != null && F(view) != null) {
                int width3 = view.getWidth();
                int height3 = view.getHeight();
                Rect rect3 = this.D0;
                rect3.set(0, 0, width3, height3);
                int width22 = viewX.getWidth();
                int height22 = viewX.getHeight();
                Rect rect22 = this.E0;
                rect22.set(0, 0, width22, height22);
                offsetDescendantRectToMyCoords(view, rect3);
                offsetDescendantRectToMyCoords(viewX, rect22);
                int i9 = this.H0.b.getLayoutDirection() != 1 ? -1 : 1;
                i2 = rect3.left;
                i3 = rect22.left;
                if ((i2 >= i3 || (i4 = rect3.right) <= i3) && (i4 = rect3.right) < rect22.right) {
                    i5 = 1;
                } else {
                    int i10 = rect22.right;
                    i5 = ((i4 > i10 || i2 >= i10) && i2 > i3) ? -1 : 0;
                }
                i6 = rect3.top;
                i7 = rect22.top;
                if ((i6 >= i7 || (i8 = rect3.bottom) <= i7) && (i8 = rect3.bottom) < rect22.bottom) {
                    b = 1;
                } else {
                    int i11 = rect22.bottom;
                    b = ((i8 > i11 || i6 >= i11) && i6 > i7) ? (byte) -1 : (byte) 0;
                }
                if (i == 1) {
                    if (i != 2) {
                        if (i != 17) {
                            if (i != 33) {
                                if (i != 66) {
                                    if (i != 130) {
                                        throw new IllegalArgumentException("Invalid direction: " + i + C());
                                    }
                                }
                            }
                        }
                    } else if (b <= 0) {
                        if (b == 0) {
                        }
                    }
                } else if (b >= 0) {
                    if (b == 0) {
                    }
                }
            }
            return viewX;
        }
        return super.focusSearch(view, i);
    }

    public final int g0(int i, float f) {
        float width = f / getWidth();
        float height = i / getHeight();
        EdgeEffect edgeEffect = this.d1;
        float f2 = 0.0f;
        if (edgeEffect == null || n12.B(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.f1;
            if (edgeEffect2 != null && n12.B(edgeEffect2) != 0.0f) {
                boolean zCanScrollVertically = canScrollVertically(1);
                EdgeEffect edgeEffect3 = this.f1;
                if (zCanScrollVertically) {
                    edgeEffect3.onRelease();
                } else {
                    float fL = n12.L(edgeEffect3, height, 1.0f - width);
                    if (n12.B(this.f1) == 0.0f) {
                        this.f1.onRelease();
                    }
                    f2 = fL;
                }
                invalidate();
            }
        } else {
            boolean zCanScrollVertically2 = canScrollVertically(-1);
            EdgeEffect edgeEffect4 = this.d1;
            if (zCanScrollVertically2) {
                edgeEffect4.onRelease();
            } else {
                float f3 = -n12.L(edgeEffect4, -height, width);
                if (n12.B(this.d1) == 0.0f) {
                    this.d1.onRelease();
                }
                f2 = f3;
            }
            invalidate();
        }
        return Math.round(f2 * getHeight());
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ag3 ag3Var = this.H0;
        if (ag3Var != null) {
            return ag3Var.r();
        }
        xe.q("RecyclerView has no LayoutManager".concat(C()));
        return null;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        ag3 ag3Var = this.H0;
        if (ag3Var != null) {
            return ag3Var.s(getContext(), attributeSet);
        }
        xe.q("RecyclerView has no LayoutManager".concat(C()));
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public rf3 getAdapter() {
        return this.G0;
    }

    @Override // android.view.View
    public int getBaseline() {
        ag3 ag3Var = this.H0;
        if (ag3Var == null) {
            return super.getBaseline();
        }
        ag3Var.getClass();
        return -1;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i, int i2) {
        return super.getChildDrawingOrder(i, i2);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.B0;
    }

    public tg3 getCompatAccessibilityDelegate() {
        return this.F1;
    }

    public wf3 getEdgeEffectFactory() {
        return this.b1;
    }

    public xf3 getItemAnimator() {
        return this.g1;
    }

    public int getItemDecorationCount() {
        return this.J0.size();
    }

    public ag3 getLayoutManager() {
        return this.H0;
    }

    public int getMaxFlingVelocity() {
        return this.r1;
    }

    public int getMinFlingVelocity() {
        return this.q1;
    }

    public long getNanoTime() {
        if (Y1) {
            return System.nanoTime();
        }
        return 0L;
    }

    public dg3 getOnFlingListener() {
        return this.p1;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.u1;
    }

    public hg3 getRecycledViewPool() {
        return this.z.c();
    }

    public int getScrollState() {
        return this.h1;
    }

    public final void h(rg3 rg3Var) {
        View view = rg3Var.a;
        boolean z = view.getParent() == this;
        this.z.m(N(view));
        boolean zL = rg3Var.l();
        j40 j40Var = this.z0;
        if (zL) {
            j40Var.b(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!z) {
            j40Var.a(view, -1, true);
            return;
        }
        int iIndexOfChild = ((gk1) j40Var.c).a.indexOfChild(view);
        if (iIndexOfChild < 0) {
            vp1.h(view, "view is not a child, cannot hide ");
        } else {
            ((i40) j40Var.d).j(iIndexOfChild);
            j40Var.i(view);
        }
    }

    public final void h0(yf3 yf3Var) {
        ag3 ag3Var = this.H0;
        if (ag3Var != null) {
            ag3Var.c("Cannot remove item decoration during a scroll  or layout");
        }
        ArrayList arrayList = this.J0;
        arrayList.remove(yf3Var);
        if (arrayList.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        V();
        requestLayout();
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().f(0);
    }

    public final void i(yf3 yf3Var) {
        ag3 ag3Var = this.H0;
        if (ag3Var != null) {
            ag3Var.c("Cannot add item decoration during a scroll  or layout");
        }
        ArrayList arrayList = this.J0;
        if (arrayList.isEmpty()) {
            setWillNotDraw(false);
        }
        arrayList.add(yf3Var);
        V();
        requestLayout();
    }

    public final void i0(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        int width = view3.getWidth();
        int height = view3.getHeight();
        Rect rect = this.D0;
        rect.set(0, 0, width, height);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof bg3) {
            bg3 bg3Var = (bg3) layoutParams;
            if (!bg3Var.c) {
                Rect rect2 = bg3Var.b;
                rect.left -= rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, rect);
            offsetRectIntoDescendantCoords(view, rect);
        }
        this.H0.t0(this, view, this.D0, !this.O0, view2 == null);
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.M0;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.R0;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().d;
    }

    public final void j(fg3 fg3Var) {
        ArrayList arrayList = this.A1;
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.A1 = arrayList;
        }
        arrayList.add(fg3Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean j0(int i, int i2, MotionEvent motionEvent, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z;
        boolean z2;
        boolean z3;
        p();
        rf3 rf3Var = this.G0;
        int[] iArr = this.K1;
        if (rf3Var != null) {
            iArr[0] = 0;
            iArr[1] = 0;
            k0(i, i2, iArr);
            i4 = iArr[0];
            i5 = iArr[1];
            i6 = i - i4;
            i7 = i2 - i5;
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        if (!this.J0.isEmpty()) {
            invalidate();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        w(i4, i5, i6, i7, this.I1, i3, iArr);
        int i8 = iArr[0];
        int i9 = i6 - i8;
        int i10 = iArr[1];
        int i11 = i7 - i10;
        boolean z4 = (i8 == 0 && i10 == 0) ? false : true;
        int i12 = this.m1;
        int[] iArr2 = this.I1;
        int i13 = iArr2[0];
        this.m1 = i12 - i13;
        int i14 = this.n1;
        int i15 = iArr2[1];
        this.n1 = i14 - i15;
        int[] iArr3 = this.J1;
        iArr3[0] = iArr3[0] + i13;
        iArr3[1] = iArr3[1] + i15;
        if (getOverScrollMode() != 2) {
            if (motionEvent == null || n12.H(motionEvent, 8194)) {
                z = true;
                z2 = false;
            } else {
                float x = motionEvent.getX();
                float f = i9;
                float y = motionEvent.getY();
                float f2 = i11;
                if (f < 0.0f) {
                    z();
                    z = true;
                    z2 = false;
                    n12.L(this.c1, (-f) / getWidth(), 1.0f - (y / getHeight()));
                } else {
                    z = true;
                    z2 = false;
                    if (f > 0.0f) {
                        A();
                        n12.L(this.e1, f / getWidth(), y / getHeight());
                    } else {
                        z3 = false;
                        if (f2 >= 0.0f) {
                            B();
                            n12.L(this.d1, (-f2) / getHeight(), x / getWidth());
                        } else {
                            if (f2 > 0.0f) {
                                y();
                                n12.L(this.f1, f2 / getHeight(), 1.0f - (x / getWidth()));
                            }
                            if (z3 || f != 0.0f || f2 != 0.0f) {
                                postInvalidateOnAnimation();
                            }
                            if (Build.VERSION.SDK_INT >= 31 && n12.H(motionEvent, 4194304)) {
                                e0();
                            }
                        }
                        z3 = z;
                        if (z3) {
                            postInvalidateOnAnimation();
                            if (Build.VERSION.SDK_INT >= 31) {
                                e0();
                            }
                        }
                    }
                }
                z3 = z;
                if (f2 >= 0.0f) {
                }
                z3 = z;
                if (z3) {
                }
            }
            n(i, i2);
        } else {
            z = true;
            z2 = false;
        }
        if (i4 != 0 || i5 != 0) {
            x(i4, i5);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z4 && i4 == 0 && i5 == 0) ? z2 : z;
    }

    public final void k(String str) {
        if (!T()) {
            if (this.a1 > 0) {
                a1.o("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(C()));
            }
        } else if (str == null) {
            xe.q("Cannot call this method while RecyclerView is computing a layout or scrolling".concat(C()));
        } else {
            xe.q(str);
        }
    }

    public final void k0(int i, int i2, int[] iArr) {
        rg3 rg3Var;
        p0();
        X();
        Trace.beginSection("RV Scroll");
        ng3 ng3Var = this.y1;
        D(ng3Var);
        ig3 ig3Var = this.z;
        int iV0 = i != 0 ? this.H0.v0(i, ig3Var, ng3Var) : 0;
        int iX0 = i2 != 0 ? this.H0.x0(i2, ig3Var, ng3Var) : 0;
        Trace.endSection();
        j40 j40Var = this.z0;
        int iE = j40Var.e();
        for (int i3 = 0; i3 < iE; i3++) {
            View viewD = j40Var.d(i3);
            rg3 rg3VarN = N(viewD);
            if (rg3VarN != null && (rg3Var = rg3VarN.i) != null) {
                View view = rg3Var.a;
                int left = viewD.getLeft();
                int top = viewD.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        Y(true);
        r0(false);
        if (iArr != null) {
            iArr[0] = iV0;
            iArr[1] = iX0;
        }
    }

    public final void l0(int i) {
        if (this.R0) {
            return;
        }
        t0();
        ag3 ag3Var = this.H0;
        if (ag3Var == null) {
            a1.d("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            ag3Var.w0(i);
            awakenScrollBars();
        }
    }

    public final void m() {
        j40 j40Var = this.z0;
        int iH = j40Var.h();
        for (int i = 0; i < iH; i++) {
            rg3 rg3VarO = O(j40Var.g(i));
            if (!rg3VarO.q()) {
                rg3VarO.d = -1;
                rg3VarO.g = -1;
            }
        }
        ig3 ig3Var = this.z;
        ArrayList arrayList = ig3Var.a;
        ArrayList arrayList2 = ig3Var.c;
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            rg3 rg3Var = (rg3) arrayList2.get(i2);
            rg3Var.d = -1;
            rg3Var.g = -1;
        }
        int size2 = arrayList.size();
        for (int i3 = 0; i3 < size2; i3++) {
            rg3 rg3Var2 = (rg3) arrayList.get(i3);
            rg3Var2.d = -1;
            rg3Var2.g = -1;
        }
        ArrayList arrayList3 = ig3Var.b;
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            for (int i4 = 0; i4 < size3; i4++) {
                rg3 rg3Var3 = (rg3) ig3Var.b.get(i4);
                rg3Var3.d = -1;
                rg3Var3.g = -1;
            }
        }
    }

    public final boolean m0(EdgeEffect edgeEffect, int i, int i2) {
        if (i > 0) {
            return true;
        }
        float fB = n12.B(edgeEffect) * i2;
        float fAbs = Math.abs(-i) * 0.35f;
        float f = this.b * 0.015f;
        double dLog = Math.log(fAbs / f);
        double d = W1;
        return ((float) (Math.exp((d / (d - 1.0d)) * dLog) * ((double) f))) < fB;
    }

    public final void n(int i, int i2) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.c1;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            zIsFinished = false;
        } else {
            this.c1.onRelease();
            zIsFinished = this.c1.isFinished();
        }
        EdgeEffect edgeEffect2 = this.e1;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.e1.onRelease();
            zIsFinished |= this.e1.isFinished();
        }
        EdgeEffect edgeEffect3 = this.d1;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.d1.onRelease();
            zIsFinished |= this.d1.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f1;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.f1.onRelease();
            zIsFinished |= this.f1.isFinished();
        }
        if (zIsFinished) {
            postInvalidateOnAnimation();
        }
    }

    public final void n0(int i, int i2, boolean z) {
        ag3 ag3Var = this.H0;
        if (ag3Var == null) {
            a1.d("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.R0) {
            return;
        }
        if (!ag3Var.d()) {
            i = 0;
        }
        if (!this.H0.e()) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        if (z) {
            int i3 = i != 0 ? 1 : 0;
            if (i2 != 0) {
                i3 |= 2;
            }
            getScrollingChildHelper().g(i3, 1);
        }
        this.v1.c(i, i2, Integer.MIN_VALUE, null);
    }

    public final void o0(int i) {
        if (this.R0) {
            return;
        }
        ag3 ag3Var = this.H0;
        if (ag3Var == null) {
            a1.d("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            ag3Var.G0(this, i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onAttachedToWindow() {
        float refreshRate;
        super.onAttachedToWindow();
        this.Z0 = 0;
        this.M0 = true;
        this.O0 = this.O0 && !isLayoutRequested();
        this.z.e();
        ag3 ag3Var = this.H0;
        if (ag3Var != null) {
            ag3Var.g = true;
            ag3Var.V(this);
        }
        this.E1 = false;
        if (Y1) {
            ThreadLocal threadLocal = in1.X;
            in1 in1Var = (in1) threadLocal.get();
            this.w1 = in1Var;
            if (in1Var == null) {
                this.w1 = new in1();
                WeakHashMap weakHashMap = wp4.a;
                Display display = getDisplay();
                if (isInEditMode() || display == null) {
                    refreshRate = 60.0f;
                    in1 in1Var2 = this.w1;
                    in1Var2.z = (long) (1.0E9f / refreshRate);
                    threadLocal.set(in1Var2);
                } else {
                    refreshRate = display.getRefreshRate();
                    if (refreshRate < 30.0f) {
                    }
                    in1 in1Var22 = this.w1;
                    in1Var22.z = (long) (1.0E9f / refreshRate);
                    threadLocal.set(in1Var22);
                }
            }
            ArrayList arrayList = this.w1.b;
            if (T1 && arrayList.contains(this)) {
                xe.q("RecyclerView already present in worker list!");
            } else {
                arrayList.add(this);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        in1 in1Var;
        super.onDetachedFromWindow();
        xf3 xf3Var = this.g1;
        if (xf3Var != null) {
            xf3Var.e();
        }
        t0();
        int i = 0;
        this.M0 = false;
        ag3 ag3Var = this.H0;
        ig3 ig3Var = this.z;
        if (ag3Var != null) {
            ag3Var.g = false;
            ag3Var.W(this, ig3Var);
        }
        this.L1.clear();
        removeCallbacks(this.M1);
        this.A0.getClass();
        while (fq4.d.a() != null) {
        }
        ArrayList arrayList = ig3Var.c;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            gb4.p(((rg3) arrayList.get(i2)).a);
        }
        ig3Var.f(ig3Var.h.G0, false);
        while (i < getChildCount()) {
            int i3 = i + 1;
            View childAt = getChildAt(i);
            if (childAt == null) {
                throw new IndexOutOfBoundsException();
            }
            b23 b23Var = (b23) childAt.getTag(com.getsurfboard.R.id.pooling_container_listener_holder_tag);
            if (b23Var == null) {
                b23Var = new b23();
                childAt.setTag(com.getsurfboard.R.id.pooling_container_listener_holder_tag, b23Var);
            }
            ArrayList arrayList2 = b23Var.a;
            int size = arrayList2.size() - 1;
            if (-1 < size) {
                throw qe4.r(arrayList2, size);
            }
            i = i3;
        }
        if (!Y1 || (in1Var = this.w1) == null) {
            return;
        }
        boolean zRemove = in1Var.b.remove(this);
        if (!T1 || zRemove) {
            this.w1 = null;
        } else {
            xe.q("RecyclerView removal failed!");
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList arrayList = this.J0;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((yf3) arrayList.get(i)).g(canvas, this);
        }
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue;
        int i;
        boolean z;
        if (this.H0 != null && !this.R0 && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                float f = this.H0.e() ? -motionEvent.getAxisValue(9) : 0.0f;
                axisValue = this.H0.d() ? motionEvent.getAxisValue(10) : 0.0f;
                i = 0;
                z = false;
                f = f;
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                axisValue = motionEvent.getAxisValue(26);
                if (this.H0.e()) {
                    float f2 = -axisValue;
                    axisValue = 0.0f;
                    f = f2;
                } else if (!this.H0.d()) {
                    axisValue = 0.0f;
                }
                i = 26;
                z = this.Q1;
            } else {
                axisValue = 0.0f;
                i = 0;
                z = false;
            }
            int i2 = (int) (f * this.t1);
            int i3 = (int) (axisValue * this.s1);
            if (z) {
                OverScroller overScroller = this.v1.z;
                n0((overScroller.getFinalX() - overScroller.getCurrX()) + i3, (overScroller.getFinalY() - overScroller.getCurrY()) + i2, true);
            } else {
                ag3 ag3Var = this.H0;
                if (ag3Var == null) {
                    a1.d("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
                } else if (!this.R0) {
                    int[] iArr = this.K1;
                    iArr[0] = 0;
                    iArr[1] = 0;
                    boolean zD = ag3Var.d();
                    boolean zE = this.H0.e();
                    int i4 = zE ? (zD ? 1 : 0) | 2 : zD ? 1 : 0;
                    float y = motionEvent.getY();
                    float x = motionEvent.getX();
                    int iF0 = i3 - f0(i3, y);
                    int iG0 = i2 - g0(i2, x);
                    getScrollingChildHelper().g(i4, 1);
                    if (v(this.K1, zD ? iF0 : 0, this.I1, zE ? iG0 : 0, 1)) {
                        iF0 -= iArr[0];
                        iG0 -= iArr[1];
                    }
                    j0(zD ? iF0 : 0, zE ? iG0 : 0, motionEvent, 1);
                    in1 in1Var = this.w1;
                    if (in1Var != null && (iF0 != 0 || iG0 != 0)) {
                        in1Var.a(this, iF0, iG0);
                    }
                    s0(1);
                }
            }
            if (i != 0 && !z) {
                this.S1.a(motionEvent, i);
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        if (!this.R0) {
            this.L0 = null;
            if (G(motionEvent)) {
                VelocityTracker velocityTracker = this.j1;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
                s0(0);
                e0();
                setScrollState(0);
                return true;
            }
            ag3 ag3Var = this.H0;
            if (ag3Var != null) {
                boolean zD = ag3Var.d();
                boolean zE = this.H0.e();
                VelocityTracker velocityTrackerObtain = this.j1;
                if (velocityTrackerObtain == null) {
                    velocityTrackerObtain = VelocityTracker.obtain();
                    this.j1 = velocityTrackerObtain;
                }
                velocityTrackerObtain.addMovement(motionEvent);
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                if (actionMasked == 0) {
                    if (this.S0) {
                        this.S0 = false;
                    }
                    this.i1 = motionEvent.getPointerId(0);
                    int x = (int) (motionEvent.getX() + 0.5f);
                    this.m1 = x;
                    this.k1 = x;
                    int y = (int) (motionEvent.getY() + 0.5f);
                    this.n1 = y;
                    this.l1 = y;
                    EdgeEffect edgeEffect = this.c1;
                    if (edgeEffect == null || n12.B(edgeEffect) == 0.0f || canScrollHorizontally(-1)) {
                        z = false;
                    } else {
                        n12.L(this.c1, 0.0f, 1.0f - (motionEvent.getY() / getHeight()));
                        z = true;
                    }
                    EdgeEffect edgeEffect2 = this.e1;
                    if (edgeEffect2 != null && n12.B(edgeEffect2) != 0.0f && !canScrollHorizontally(1)) {
                        n12.L(this.e1, 0.0f, motionEvent.getY() / getHeight());
                        z = true;
                    }
                    EdgeEffect edgeEffect3 = this.d1;
                    if (edgeEffect3 != null && n12.B(edgeEffect3) != 0.0f && !canScrollVertically(-1)) {
                        n12.L(this.d1, 0.0f, motionEvent.getX() / getWidth());
                        z = true;
                    }
                    EdgeEffect edgeEffect4 = this.f1;
                    if (edgeEffect4 != null && n12.B(edgeEffect4) != 0.0f && !canScrollVertically(1)) {
                        n12.L(this.f1, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
                        z = true;
                    }
                    if (z || this.h1 == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                        s0(1);
                    }
                    int[] iArr = this.J1;
                    iArr[1] = 0;
                    iArr[0] = 0;
                    q0(0);
                } else if (actionMasked == 1) {
                    this.j1.clear();
                    s0(0);
                } else if (actionMasked == 2) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.i1);
                    if (iFindPointerIndex < 0) {
                        a1.d("RecyclerView", "Error processing scroll; pointer index for id " + this.i1 + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x2 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                    int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                    if (this.h1 != 1) {
                        int i = x2 - this.k1;
                        int i2 = y2 - this.l1;
                        if (!zD || Math.abs(i) <= this.o1) {
                            z2 = false;
                        } else {
                            this.m1 = x2;
                            z2 = true;
                        }
                        if (zE && Math.abs(i2) > this.o1) {
                            this.n1 = y2;
                            z2 = true;
                        }
                        if (z2) {
                            setScrollState(1);
                        }
                    }
                } else if (actionMasked == 3) {
                    VelocityTracker velocityTracker2 = this.j1;
                    if (velocityTracker2 != null) {
                        velocityTracker2.clear();
                    }
                    s0(0);
                    e0();
                    setScrollState(0);
                } else if (actionMasked == 5) {
                    this.i1 = motionEvent.getPointerId(actionIndex);
                    int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.m1 = x3;
                    this.k1 = x3;
                    int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.n1 = y3;
                    this.l1 = y3;
                } else if (actionMasked == 6) {
                    Z(motionEvent);
                }
                if (this.h1 == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Trace.beginSection("RV OnLayout");
        s();
        Trace.endSection();
        this.O0 = true;
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        ag3 ag3Var = this.H0;
        if (ag3Var == null) {
            q(i, i2);
            return;
        }
        boolean zO = ag3Var.O();
        boolean z = false;
        ng3 ng3Var = this.y1;
        if (zO) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.H0.b.q(i, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.N1 = z;
            if (z || this.G0 == null) {
                return;
            }
            if (ng3Var.d == 1) {
                t();
            }
            this.H0.z0(i, i2);
            ng3Var.i = true;
            u();
            this.H0.B0(i, i2);
            if (this.H0.E0()) {
                this.H0.z0(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), Pow2.MAX_POW2), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), Pow2.MAX_POW2));
                ng3Var.i = true;
                u();
                this.H0.B0(i, i2);
            }
            this.O1 = getMeasuredWidth();
            this.P1 = getMeasuredHeight();
            return;
        }
        if (this.N0) {
            this.H0.b.q(i, i2);
            return;
        }
        if (this.U0) {
            p0();
            X();
            b0();
            Y(true);
            if (ng3Var.k) {
                ng3Var.g = true;
            } else {
                this.y0.e();
                ng3Var.g = false;
            }
            this.U0 = false;
            r0(false);
        } else if (ng3Var.k) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        rf3 rf3Var = this.G0;
        if (rf3Var != null) {
            ng3Var.e = rf3Var.b();
        } else {
            ng3Var.e = 0;
        }
        p0();
        this.H0.b.q(i, i2);
        r0(false);
        ng3Var.g = false;
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (T()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof kg3)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        kg3 kg3Var = (kg3) parcelable;
        this.A = kg3Var;
        super.onRestoreInstanceState(kg3Var.b);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        kg3 kg3Var = new kg3(super.onSaveInstanceState());
        kg3 kg3Var2 = this.A;
        if (kg3Var2 != null) {
            kg3Var.z = kg3Var2.z;
            return kg3Var;
        }
        ag3 ag3Var = this.H0;
        if (ag3Var != null) {
            kg3Var.z = ag3Var.l0();
            return kg3Var;
        }
        kg3Var.z = null;
        return kg3Var;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        this.f1 = null;
        this.d1 = null;
        this.e1 = null;
        this.c1 = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x010f A[PHI: r1
      0x010f: PHI (r1v44 int) = (r1v30 int), (r1v48 int) binds: [B:56:0x00fa, B:61:0x010b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zG;
        if (!this.R0 && !this.S0) {
            eg3 eg3Var = this.L0;
            if (eg3Var == null) {
                zG = motionEvent.getAction() == 0 ? false : G(motionEvent);
            } else {
                eg3Var.a(this, motionEvent);
                int action = motionEvent.getAction();
                if (action == 3 || action == 1) {
                    this.L0 = null;
                }
                zG = true;
            }
            if (zG) {
                VelocityTracker velocityTracker = this.j1;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
                s0(0);
                e0();
                setScrollState(0);
                return true;
            }
            ag3 ag3Var = this.H0;
            if (ag3Var != null) {
                boolean zD = ag3Var.d();
                boolean zE = this.H0.e();
                if (this.j1 == null) {
                    this.j1 = VelocityTracker.obtain();
                }
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                int[] iArr = this.J1;
                if (actionMasked == 0) {
                    iArr[1] = 0;
                    iArr[0] = 0;
                }
                MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                motionEventObtain.offsetLocation(iArr[0], iArr[1]);
                if (actionMasked == 0) {
                    this.i1 = motionEvent.getPointerId(0);
                    int x = (int) (motionEvent.getX() + 0.5f);
                    this.m1 = x;
                    this.k1 = x;
                    int y = (int) (motionEvent.getY() + 0.5f);
                    this.n1 = y;
                    this.l1 = y;
                    q0(0);
                } else {
                    if (actionMasked == 1) {
                        this.j1.addMovement(motionEventObtain);
                        VelocityTracker velocityTracker2 = this.j1;
                        int i = this.r1;
                        velocityTracker2.computeCurrentVelocity(1000, i);
                        float f = zD ? -this.j1.getXVelocity(this.i1) : 0.0f;
                        float f2 = zE ? -this.j1.getYVelocity(this.i1) : 0.0f;
                        if ((f == 0.0f && f2 == 0.0f) || !K((int) f, (int) f2, this.q1, i)) {
                            setScrollState(0);
                        }
                        VelocityTracker velocityTracker3 = this.j1;
                        if (velocityTracker3 != null) {
                            velocityTracker3.clear();
                        }
                        s0(0);
                        e0();
                        motionEventObtain.recycle();
                        return true;
                    }
                    if (actionMasked == 2) {
                        int iFindPointerIndex = motionEvent.findPointerIndex(this.i1);
                        if (iFindPointerIndex < 0) {
                            a1.d("RecyclerView", "Error processing scroll; pointer index for id " + this.i1 + " not found. Did any MotionEvents get skipped?");
                            return false;
                        }
                        int x2 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                        int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                        int iMax = this.m1 - x2;
                        int iMax2 = this.n1 - y2;
                        if (this.h1 != 1) {
                            if (zD) {
                                int i2 = this.o1;
                                iMax = iMax > 0 ? Math.max(0, iMax - i2) : Math.min(0, iMax + i2);
                                boolean z = iMax != 0;
                                if (zE) {
                                    int i3 = this.o1;
                                    iMax2 = iMax2 > 0 ? Math.max(0, iMax2 - i3) : Math.min(0, iMax2 + i3);
                                    if (iMax2 != 0) {
                                        z = true;
                                    }
                                }
                                if (z) {
                                    setScrollState(1);
                                }
                            }
                            motionEventObtain.recycle();
                            return true;
                        }
                        if (this.h1 == 1) {
                            int[] iArr2 = this.K1;
                            iArr2[0] = 0;
                            iArr2[1] = 0;
                            int iF0 = iMax - f0(iMax, motionEvent.getY());
                            int iG0 = iMax2 - g0(iMax2, motionEvent.getX());
                            boolean zV = v(this.K1, zD ? iF0 : 0, this.I1, zE ? iG0 : 0, 0);
                            int[] iArr3 = this.I1;
                            if (zV) {
                                iF0 -= iArr2[0];
                                iG0 -= iArr2[1];
                                iArr[0] = iArr[0] + iArr3[0];
                                iArr[1] = iArr[1] + iArr3[1];
                                getParent().requestDisallowInterceptTouchEvent(true);
                            }
                            int i4 = iF0;
                            int i5 = iG0;
                            this.m1 = x2 - iArr3[0];
                            this.n1 = y2 - iArr3[1];
                            if (j0(zD ? i4 : 0, zE ? i5 : 0, motionEvent, 0)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                            }
                            in1 in1Var = this.w1;
                            if (in1Var != null && (i4 != 0 || i5 != 0)) {
                                in1Var.a(this, i4, i5);
                            }
                        }
                    } else if (actionMasked == 3) {
                        VelocityTracker velocityTracker4 = this.j1;
                        if (velocityTracker4 != null) {
                            velocityTracker4.clear();
                        }
                        s0(0);
                        e0();
                        setScrollState(0);
                    } else if (actionMasked == 5) {
                        this.i1 = motionEvent.getPointerId(actionIndex);
                        int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                        this.m1 = x3;
                        this.k1 = x3;
                        int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                        this.n1 = y3;
                        this.l1 = y3;
                    } else if (actionMasked == 6) {
                        Z(motionEvent);
                    }
                }
                this.j1.addMovement(motionEventObtain);
                motionEventObtain.recycle();
                return true;
            }
        }
        return false;
    }

    public final void p() {
        if (!this.O0 || this.X0) {
            Trace.beginSection("RV FullInvalidate");
            s();
            Trace.endSection();
            return;
        }
        k5 k5Var = this.y0;
        if (k5Var.k()) {
            int i = k5Var.a;
            if ((i & 4) == 0 || (i & 11) != 0) {
                if (k5Var.k()) {
                    Trace.beginSection("RV FullInvalidate");
                    s();
                    Trace.endSection();
                    return;
                }
                return;
            }
            Trace.beginSection("RV PartialInvalidate");
            p0();
            X();
            k5Var.r();
            if (!this.Q0) {
                j40 j40Var = this.z0;
                int iE = j40Var.e();
                int i2 = 0;
                while (true) {
                    if (i2 < iE) {
                        rg3 rg3VarO = O(j40Var.d(i2));
                        if (rg3VarO != null && !rg3VarO.q() && rg3VarO.m()) {
                            s();
                            break;
                        }
                        i2++;
                    } else {
                        k5Var.d();
                        break;
                    }
                }
            }
            r0(true);
            Y(true);
            Trace.endSection();
        }
    }

    public final void p0() {
        int i = this.P0 + 1;
        this.P0 = i;
        if (i != 1 || this.R0) {
            return;
        }
        this.Q0 = false;
    }

    public final void q(int i, int i2) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap weakHashMap = wp4.a;
        setMeasuredDimension(ag3.g(i, paddingRight, getMinimumWidth()), ag3.g(i2, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void q0(int i) {
        boolean zD = this.H0.d();
        int i2 = zD;
        if (this.H0.e()) {
            i2 = (zD ? 1 : 0) | 2;
        }
        getScrollingChildHelper().g(i2, i);
    }

    public final void r(View view) {
        O(view);
        ArrayList arrayList = this.W0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((cg3) this.W0.get(size)).b(view);
            }
        }
    }

    public final void r0(boolean z) {
        int i = this.P0;
        if (i < 1) {
            if (T1) {
                xe.q("stopInterceptRequestLayout was called more times than startInterceptRequestLayout.".concat(C()));
                return;
            } else {
                this.P0 = 1;
                i = 1;
            }
        }
        if (!z && !this.R0) {
            this.Q0 = false;
        }
        if (i == 1) {
            if (z && this.Q0 && !this.R0 && this.H0 != null && this.G0 != null) {
                s();
            }
            if (!this.R0) {
                this.Q0 = false;
            }
        }
        this.P0--;
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z) {
        rg3 rg3VarO = O(view);
        if (rg3VarO != null) {
            if (rg3VarO.l()) {
                rg3VarO.j &= -257;
            } else if (!rg3VarO.q()) {
                StringBuilder sb = new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(rg3VarO);
                xe.n(sb, C());
                return;
            }
        } else if (T1) {
            StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
            sb2.append(view);
            xe.n(sb2, C());
            return;
        }
        view.clearAnimation();
        r(view);
        super.removeDetachedView(view, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        fb2 fb2Var = this.H0.e;
        if ((fb2Var == null || !fb2Var.e) && !T() && view2 != null) {
            i0(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.H0.t0(this, view, rect, z, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        ArrayList arrayList = this.K0;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((eg3) arrayList.get(i)).e(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.P0 != 0 || this.R0) {
            this.Q0 = true;
        } else {
            super.requestLayout();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x039f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void s() {
        boolean z;
        rg3 rg3Var;
        View viewFindViewById;
        boolean z2;
        xw3 xw3Var;
        hm2 hm2Var;
        boolean zG;
        boolean z3;
        if (this.G0 == null) {
            a1.n("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.H0 == null) {
            a1.d("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        ng3 ng3Var = this.y1;
        boolean z4 = false;
        ng3Var.i = false;
        boolean z5 = true;
        Object[] objArr = this.N1 && !(this.O1 == getWidth() && this.P1 == getHeight());
        this.O1 = 0;
        this.P1 = 0;
        this.N1 = false;
        if (ng3Var.d == 1) {
            t();
            this.H0.y0(this);
            u();
        } else {
            k5 k5Var = this.y0;
            if ((((ArrayList) k5Var.d).isEmpty() || ((ArrayList) k5Var.c).isEmpty()) && !objArr == true && this.H0.n == getWidth() && this.H0.o == getHeight()) {
                this.H0.y0(this);
            } else {
                this.H0.y0(this);
                u();
            }
        }
        ng3Var.a(4);
        p0();
        X();
        ng3Var.d = 1;
        boolean z6 = ng3Var.j;
        j40 j40Var = this.z0;
        ig3 ig3Var = this.z;
        e24 e24Var = this.A0;
        if (z6) {
            int iE = j40Var.e() - 1;
            while (iE >= 0) {
                rg3 rg3VarO = O(j40Var.d(iE));
                if (rg3VarO.q()) {
                    z3 = z5;
                } else {
                    long jM = M(rg3VarO);
                    this.g1.getClass();
                    hm2 hm2Var2 = new hm2(7);
                    hm2Var2.g(rg3VarO);
                    ff2 ff2Var = (ff2) e24Var.z;
                    z3 = z5;
                    xw3 xw3Var2 = (xw3) e24Var.f;
                    rg3 rg3Var2 = (rg3) ff2Var.d(jM);
                    if (rg3Var2 == null || rg3Var2.q()) {
                        e24Var.d(rg3VarO, hm2Var2);
                    } else {
                        fq4 fq4Var = (fq4) xw3Var2.get(rg3Var2);
                        boolean z7 = (fq4Var == null || (fq4Var.a & 1) == 0) ? z4 : z3;
                        fq4 fq4Var2 = (fq4) xw3Var2.get(rg3VarO);
                        boolean z8 = (fq4Var2 == null || (fq4Var2.a & 1) == 0) ? z4 : z3;
                        if (z7 && rg3Var2 == rg3VarO) {
                            e24Var.d(rg3VarO, hm2Var2);
                        } else {
                            hm2 hm2VarX = e24Var.x(rg3Var2, 4);
                            e24Var.d(rg3VarO, hm2Var2);
                            hm2 hm2VarX2 = e24Var.x(rg3VarO, 8);
                            if (hm2VarX == null) {
                                int iE2 = j40Var.e();
                                for (int i = 0; i < iE2; i++) {
                                    rg3 rg3VarO2 = O(j40Var.d(i));
                                    if (rg3VarO2 != rg3VarO && M(rg3VarO2) == jM) {
                                        rf3 rf3Var = this.G0;
                                        if (rf3Var == null || !rf3Var.b) {
                                            StringBuilder sb = new StringBuilder("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
                                            sb.append(rg3VarO2);
                                            sb.append(" \n View Holder 2:");
                                            sb.append(rg3VarO);
                                            st4.m(sb, C());
                                            return;
                                        }
                                        StringBuilder sb2 = new StringBuilder("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                                        sb2.append(rg3VarO2);
                                        sb2.append(" \n View Holder 2:");
                                        sb2.append(rg3VarO);
                                        st4.m(sb2, C());
                                        return;
                                    }
                                }
                                a1.d("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + rg3Var2 + " cannot be found but it is necessary for " + rg3VarO + C());
                            } else {
                                rg3Var2.p(false);
                                if (z7) {
                                    h(rg3Var2);
                                }
                                if (rg3Var2 != rg3VarO) {
                                    if (z8) {
                                        h(rg3VarO);
                                    }
                                    rg3Var2.h = rg3VarO;
                                    h(rg3Var2);
                                    ig3Var.m(rg3Var2);
                                    rg3VarO.p(false);
                                    rg3VarO.i = rg3Var2;
                                }
                                if (this.g1.a(rg3Var2, rg3VarO, hm2VarX, hm2VarX2)) {
                                    a0();
                                }
                            }
                        }
                    }
                }
                iE--;
                z5 = z3;
                z4 = false;
            }
            z = z5;
            xw3 xw3Var3 = (xw3) e24Var.f;
            int i2 = xw3Var3.z - 1;
            while (i2 >= 0) {
                rg3 rg3Var3 = (rg3) xw3Var3.f(i2);
                fq4 fq4Var3 = (fq4) xw3Var3.g(i2);
                int i3 = fq4Var3.a;
                int i4 = i3 & 3;
                pf3 pf3Var = this.R1;
                if (i4 == 3) {
                    RecyclerView recyclerView = pf3Var.a;
                    recyclerView.H0.r0(rg3Var3.a, recyclerView.z);
                } else if ((i3 & 1) != 0) {
                    hm2 hm2Var3 = fq4Var3.b;
                    if (hm2Var3 == null) {
                        RecyclerView recyclerView2 = pf3Var.a;
                        recyclerView2.H0.r0(rg3Var3.a, recyclerView2.z);
                    } else {
                        pf3Var.g(rg3Var3, hm2Var3, fq4Var3.c);
                    }
                } else if ((i3 & 14) == 14) {
                    pf3Var.f(rg3Var3, fq4Var3.b, fq4Var3.c);
                } else if ((i3 & 12) == 12) {
                    hm2 hm2Var4 = fq4Var3.b;
                    hm2 hm2Var5 = fq4Var3.c;
                    pf3Var.getClass();
                    rg3Var3.p(false);
                    RecyclerView recyclerView3 = pf3Var.a;
                    boolean z9 = recyclerView3.X0;
                    xf3 xf3Var = recyclerView3.g1;
                    if (!z9) {
                        yl0 yl0Var = (yl0) xf3Var;
                        yl0Var.getClass();
                        int i5 = hm2Var4.b;
                        int i6 = hm2Var5.b;
                        if (i5 == i6) {
                            xw3Var = xw3Var3;
                            if (hm2Var4.c == hm2Var5.c) {
                                yl0Var.c(rg3Var3);
                                zG = false;
                            }
                            if (zG) {
                                recyclerView3.a0();
                            }
                            hm2Var = null;
                            fq4Var3.a = 0;
                            fq4Var3.b = hm2Var;
                            fq4Var3.c = hm2Var;
                            fq4.d.c(fq4Var3);
                            i2--;
                            xw3Var3 = xw3Var;
                        } else {
                            xw3Var = xw3Var3;
                        }
                        zG = yl0Var.g(rg3Var3, i5, hm2Var4.c, i6, hm2Var5.c);
                        if (zG) {
                        }
                        hm2Var = null;
                        fq4Var3.a = 0;
                        fq4Var3.b = hm2Var;
                        fq4Var3.c = hm2Var;
                        fq4.d.c(fq4Var3);
                        i2--;
                        xw3Var3 = xw3Var;
                    } else if (xf3Var.a(rg3Var3, rg3Var3, hm2Var4, hm2Var5)) {
                        recyclerView3.a0();
                    }
                } else {
                    xw3Var = xw3Var3;
                    if ((i3 & 4) != 0) {
                        hm2Var = null;
                        pf3Var.g(rg3Var3, fq4Var3.b, null);
                    } else {
                        hm2Var = null;
                        if ((i3 & 8) != 0) {
                            pf3Var.f(rg3Var3, fq4Var3.b, fq4Var3.c);
                        }
                    }
                    fq4Var3.a = 0;
                    fq4Var3.b = hm2Var;
                    fq4Var3.c = hm2Var;
                    fq4.d.c(fq4Var3);
                    i2--;
                    xw3Var3 = xw3Var;
                }
                xw3Var = xw3Var3;
                hm2Var = null;
                fq4Var3.a = 0;
                fq4Var3.b = hm2Var;
                fq4Var3.c = hm2Var;
                fq4.d.c(fq4Var3);
                i2--;
                xw3Var3 = xw3Var;
            }
        } else {
            z = true;
        }
        View view = null;
        this.H0.q0(ig3Var);
        ng3Var.b = ng3Var.e;
        this.X0 = false;
        this.Y0 = false;
        ng3Var.j = false;
        ng3Var.k = false;
        this.H0.f = false;
        ArrayList arrayList = ig3Var.b;
        if (arrayList != null) {
            arrayList.clear();
        }
        ag3 ag3Var = this.H0;
        if (ag3Var.k) {
            ag3Var.j = 0;
            ag3Var.k = false;
            ig3Var.n();
        }
        this.H0.j0(ng3Var);
        boolean z10 = z;
        Y(z10);
        r0(false);
        ((xw3) e24Var.f).clear();
        ((ff2) e24Var.z).b();
        int[] iArr = this.G1;
        int i7 = iArr[0];
        int i8 = iArr[z10 ? 1 : 0];
        H(iArr);
        if (iArr[0] != i7 || iArr[z10 ? 1 : 0] != i8) {
            x(0, 0);
        }
        if (this.u1 && this.G0 != null && hasFocus() && getDescendantFocusability() != 393216 && (getDescendantFocusability() != 131072 || !isFocused())) {
            if (!isFocused()) {
                if (((ArrayList) j40Var.e).contains(getFocusedChild())) {
                    long j = ng3Var.m;
                    if (j != -1 && (z2 = this.G0.b) && z2) {
                        int iH = j40Var.h();
                        rg3Var = null;
                        int i9 = 0;
                        while (true) {
                            if (i9 >= iH) {
                                break;
                            }
                            rg3 rg3VarO3 = O(j40Var.g(i9));
                            if (rg3VarO3 != null && !rg3VarO3.j() && rg3VarO3.e == j) {
                                if (!((ArrayList) j40Var.e).contains(rg3VarO3.a)) {
                                    rg3Var = rg3VarO3;
                                    break;
                                }
                                rg3Var = rg3VarO3;
                            }
                            i9++;
                        }
                    } else {
                        rg3Var = null;
                    }
                    if (rg3Var != null) {
                        View view2 = rg3Var.a;
                        if (!((ArrayList) j40Var.e).contains(view2) && view2.hasFocusable()) {
                            view = view2;
                        } else if (j40Var.e() > 0) {
                            int i10 = ng3Var.l;
                            if (i10 == -1) {
                                i10 = 0;
                            }
                            int iB = ng3Var.b();
                            for (int i11 = i10; i11 < iB; i11++) {
                                rg3 rg3VarJ = J(i11);
                                if (rg3VarJ == null) {
                                    break;
                                }
                                View view3 = rg3VarJ.a;
                                if (view3.hasFocusable()) {
                                    view = view3;
                                    break;
                                }
                            }
                            int iMin = Math.min(iB, i10) - 1;
                            while (true) {
                                if (iMin < 0) {
                                    break;
                                }
                                rg3 rg3VarJ2 = J(iMin);
                                if (rg3VarJ2 == null) {
                                    break;
                                }
                                View view4 = rg3VarJ2.a;
                                if (view4.hasFocusable()) {
                                    view = view4;
                                    break;
                                }
                                iMin--;
                            }
                        }
                        if (view != null) {
                            int i12 = ng3Var.n;
                            if (i12 != -1 && (viewFindViewById = view.findViewById(i12)) != null && viewFindViewById.isFocusable()) {
                                view = viewFindViewById;
                            }
                            view.requestFocus();
                        }
                    }
                }
            }
        }
        ng3Var.m = -1L;
        ng3Var.l = -1;
        ng3Var.n = -1;
    }

    public final void s0(int i) {
        getScrollingChildHelper().h(i);
    }

    @Override // android.view.View
    public final void scrollBy(int i, int i2) {
        ag3 ag3Var = this.H0;
        if (ag3Var == null) {
            a1.d("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.R0) {
            return;
        }
        boolean zD = ag3Var.d();
        boolean zE = this.H0.e();
        if (zD || zE) {
            if (!zD) {
                i = 0;
            }
            if (!zE) {
                i2 = 0;
            }
            j0(i, i2, null, 0);
        }
    }

    @Override // android.view.View
    public final void scrollTo(int i, int i2) {
        a1.n("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!T()) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        } else {
            int contentChangeTypes = accessibilityEvent != null ? accessibilityEvent.getContentChangeTypes() : 0;
            this.T0 |= contentChangeTypes != 0 ? contentChangeTypes : 0;
        }
    }

    public void setAccessibilityDelegateCompat(tg3 tg3Var) {
        this.F1 = tg3Var;
        wp4.n(this, tg3Var);
    }

    public void setAdapter(rf3 rf3Var) {
        setLayoutFrozen(false);
        rf3 rf3Var2 = this.G0;
        ik1 ik1Var = this.f;
        if (rf3Var2 != null) {
            rf3Var2.p(ik1Var);
            this.G0.j(this);
        }
        xf3 xf3Var = this.g1;
        if (xf3Var != null) {
            xf3Var.e();
        }
        ag3 ag3Var = this.H0;
        ig3 ig3Var = this.z;
        if (ag3Var != null) {
            ag3Var.p0(ig3Var);
            this.H0.q0(ig3Var);
        }
        ig3Var.a.clear();
        ig3Var.g();
        k5 k5Var = this.y0;
        k5Var.s((ArrayList) k5Var.c);
        k5Var.s((ArrayList) k5Var.d);
        k5Var.a = 0;
        rf3 rf3Var3 = this.G0;
        this.G0 = rf3Var;
        if (rf3Var != null) {
            rf3Var.n(ik1Var);
            rf3Var.f(this);
        }
        ag3 ag3Var2 = this.H0;
        if (ag3Var2 != null) {
            ag3Var2.U();
        }
        rf3 rf3Var4 = this.G0;
        ig3Var.a.clear();
        ig3Var.g();
        ig3Var.f(rf3Var3, true);
        hg3 hg3VarC = ig3Var.c();
        if (rf3Var3 != null) {
            hg3VarC.b--;
        }
        if (hg3VarC.b == 0) {
            SparseArray sparseArray = hg3VarC.a;
            for (int i = 0; i < sparseArray.size(); i++) {
                gg3 gg3Var = (gg3) sparseArray.valueAt(i);
                Iterator it = gg3Var.a.iterator();
                while (it.hasNext()) {
                    gb4.p(((rg3) it.next()).a);
                }
                gg3Var.a.clear();
            }
        }
        if (rf3Var4 != null) {
            hg3VarC.b++;
        }
        ig3Var.e();
        this.y1.f = true;
        c0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(vf3 vf3Var) {
        if (vf3Var == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.B0) {
            this.f1 = null;
            this.d1 = null;
            this.e1 = null;
            this.c1 = null;
        }
        this.B0 = z;
        super.setClipToPadding(z);
        if (this.O0) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(wf3 wf3Var) {
        wf3Var.getClass();
        this.b1 = wf3Var;
        this.f1 = null;
        this.d1 = null;
        this.e1 = null;
        this.c1 = null;
    }

    public void setHasFixedSize(boolean z) {
        this.N0 = z;
    }

    public void setItemAnimator(xf3 xf3Var) {
        xf3 xf3Var2 = this.g1;
        if (xf3Var2 != null) {
            xf3Var2.e();
            this.g1.a = null;
        }
        this.g1 = xf3Var;
        if (xf3Var != null) {
            xf3Var.a = this.D1;
        }
    }

    public void setItemViewCacheSize(int i) {
        ig3 ig3Var = this.z;
        ig3Var.e = i;
        ig3Var.n();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    public void setLayoutManager(ag3 ag3Var) {
        RecyclerView recyclerView;
        if (ag3Var == this.H0) {
            return;
        }
        t0();
        ag3 ag3Var2 = this.H0;
        ig3 ig3Var = this.z;
        if (ag3Var2 != null) {
            xf3 xf3Var = this.g1;
            if (xf3Var != null) {
                xf3Var.e();
            }
            this.H0.p0(ig3Var);
            this.H0.q0(ig3Var);
            ig3Var.a.clear();
            ig3Var.g();
            if (this.M0) {
                ag3 ag3Var3 = this.H0;
                ag3Var3.g = false;
                ag3Var3.W(this, ig3Var);
            }
            this.H0.C0(null);
            this.H0 = null;
        } else {
            ig3Var.a.clear();
            ig3Var.g();
        }
        j40 j40Var = this.z0;
        ((i40) j40Var.d).i();
        ArrayList arrayList = (ArrayList) j40Var.e;
        int size = arrayList.size() - 1;
        while (true) {
            recyclerView = ((gk1) j40Var.c).a;
            if (size < 0) {
                break;
            }
            rg3 rg3VarO = O((View) arrayList.get(size));
            if (rg3VarO != null) {
                int i = rg3VarO.p;
                if (recyclerView.T()) {
                    rg3VarO.q = i;
                    recyclerView.L1.add(rg3VarO);
                } else {
                    rg3VarO.a.setImportantForAccessibility(i);
                }
                rg3VarO.p = 0;
            }
            arrayList.remove(size);
            size--;
        }
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            recyclerView.r(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeAllViews();
        this.H0 = ag3Var;
        if (ag3Var != null) {
            if (ag3Var.b != null) {
                StringBuilder sb = new StringBuilder("LayoutManager ");
                sb.append(ag3Var);
                String strC = ag3Var.b.C();
                sb.append(" is already attached to a RecyclerView:");
                sb.append(strC);
                throw new IllegalArgumentException(sb.toString());
            }
            ag3Var.C0(this);
            if (this.M0) {
                ag3 ag3Var4 = this.H0;
                ag3Var4.g = true;
                ag3Var4.V(this);
            }
        }
        ig3Var.n();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
        } else {
            xe.k("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        xq2 scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.d) {
            ViewGroup viewGroup = scrollingChildHelper.c;
            WeakHashMap weakHashMap = wp4.a;
            viewGroup.stopNestedScroll();
        }
        scrollingChildHelper.d = z;
    }

    public void setOnFlingListener(dg3 dg3Var) {
        this.p1 = dg3Var;
    }

    @Deprecated
    public void setOnScrollListener(fg3 fg3Var) {
        this.z1 = fg3Var;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.u1 = z;
    }

    public void setRecycledViewPool(hg3 hg3Var) {
        ig3 ig3Var = this.z;
        RecyclerView recyclerView = ig3Var.h;
        ig3Var.f(recyclerView.G0, false);
        if (ig3Var.g != null) {
            r1.b--;
        }
        ig3Var.g = hg3Var;
        if (hg3Var != null && recyclerView.getAdapter() != null) {
            ig3Var.g.b++;
        }
        ig3Var.e();
    }

    public void setScrollState(int i) {
        fb2 fb2Var;
        if (i == this.h1) {
            return;
        }
        if (U1) {
            StringBuilder sbD = dw2.D("setting scroll state to ", i, " from ");
            sbD.append(this.h1);
            Log.d("RecyclerView", sbD.toString(), new Exception());
        }
        this.h1 = i;
        if (i != 2) {
            qg3 qg3Var = this.v1;
            qg3Var.Z.removeCallbacks(qg3Var);
            qg3Var.z.abortAnimation();
            ag3 ag3Var = this.H0;
            if (ag3Var != null && (fb2Var = ag3Var.e) != null) {
                fb2Var.i();
            }
        }
        ag3 ag3Var2 = this.H0;
        if (ag3Var2 != null) {
            ag3Var2.m0(i);
        }
        fg3 fg3Var = this.z1;
        if (fg3Var != null) {
            fg3Var.a(this, i);
        }
        ArrayList arrayList = this.A1;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((fg3) this.A1.get(size)).a(this, i);
            }
        }
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i != 0) {
            if (i == 1) {
                this.o1 = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            a1.n("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
        }
        this.o1 = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(pg3 pg3Var) {
        this.z.getClass();
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i) {
        return getScrollingChildHelper().g(i, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        getScrollingChildHelper().h(0);
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z) {
        if (z != this.R0) {
            k("Do not suppressLayout in layout or scroll");
            if (z) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.R0 = true;
                this.S0 = true;
                t0();
                return;
            }
            this.R0 = false;
            if (this.Q0 && this.H0 != null && this.G0 != null) {
                requestLayout();
            }
            this.Q0 = false;
        }
    }

    public final void t() {
        fq4 fq4Var;
        View viewF;
        ng3 ng3Var = this.y1;
        ng3Var.a(1);
        D(ng3Var);
        ng3Var.i = false;
        p0();
        e24 e24Var = this.A0;
        xw3 xw3Var = (xw3) e24Var.f;
        xw3 xw3Var2 = (xw3) e24Var.f;
        xw3Var.clear();
        ff2 ff2Var = (ff2) e24Var.z;
        ff2Var.b();
        X();
        b0();
        rg3 rg3VarN = null;
        View focusedChild = (this.u1 && hasFocus() && this.G0 != null) ? getFocusedChild() : null;
        if (focusedChild != null && (viewF = F(focusedChild)) != null) {
            rg3VarN = N(viewF);
        }
        if (rg3VarN == null) {
            ng3Var.m = -1L;
            ng3Var.l = -1;
            ng3Var.n = -1;
        } else {
            ng3Var.m = this.G0.b ? rg3VarN.e : -1L;
            ng3Var.l = this.X0 ? -1 : rg3VarN.j() ? rg3VarN.d : rg3VarN.b();
            View focusedChild2 = rg3VarN.a;
            int id = focusedChild2.getId();
            while (!focusedChild2.isFocused() && (focusedChild2 instanceof ViewGroup) && focusedChild2.hasFocus()) {
                focusedChild2 = ((ViewGroup) focusedChild2).getFocusedChild();
                if (focusedChild2.getId() != -1) {
                    id = focusedChild2.getId();
                }
            }
            ng3Var.n = id;
        }
        ng3Var.h = ng3Var.j && this.C1;
        this.C1 = false;
        this.B1 = false;
        ng3Var.g = ng3Var.k;
        ng3Var.e = this.G0.b();
        H(this.G1);
        boolean z = ng3Var.j;
        int i = 7;
        j40 j40Var = this.z0;
        if (z) {
            int iE = j40Var.e();
            for (int i2 = 0; i2 < iE; i2++) {
                rg3 rg3VarO = O(j40Var.d(i2));
                if (!rg3VarO.q() && (!rg3VarO.h() || this.G0.b)) {
                    xf3 xf3Var = this.g1;
                    xf3.b(rg3VarO);
                    rg3VarO.e();
                    xf3Var.getClass();
                    hm2 hm2Var = new hm2(i);
                    hm2Var.g(rg3VarO);
                    fq4 fq4VarA = (fq4) xw3Var2.get(rg3VarO);
                    if (fq4VarA == null) {
                        fq4VarA = fq4.a();
                        xw3Var2.put(rg3VarO, fq4VarA);
                    }
                    fq4VarA.b = hm2Var;
                    fq4VarA.a |= 4;
                    if (ng3Var.h && rg3VarO.m() && !rg3VarO.j() && !rg3VarO.q() && !rg3VarO.h()) {
                        ff2Var.h(M(rg3VarO), rg3VarO);
                    }
                }
            }
        }
        if (ng3Var.k) {
            int iH = j40Var.h();
            for (int i3 = 0; i3 < iH; i3++) {
                rg3 rg3VarO2 = O(j40Var.g(i3));
                if (T1 && rg3VarO2.c == -1 && !rg3VarO2.j()) {
                    xe.q("view holder cannot have position -1 unless it is removed".concat(C()));
                    return;
                }
                if (!rg3VarO2.q() && rg3VarO2.d == -1) {
                    rg3VarO2.d = rg3VarO2.c;
                }
            }
            boolean z2 = ng3Var.f;
            ng3Var.f = false;
            this.H0.i0(this.z, ng3Var);
            ng3Var.f = z2;
            for (int i4 = 0; i4 < j40Var.e(); i4++) {
                rg3 rg3VarO3 = O(j40Var.d(i4));
                if (!rg3VarO3.q() && ((fq4Var = (fq4) xw3Var2.get(rg3VarO3)) == null || (fq4Var.a & 4) == 0)) {
                    xf3.b(rg3VarO3);
                    boolean z3 = (rg3VarO3.j & 8192) != 0;
                    xf3 xf3Var2 = this.g1;
                    rg3VarO3.e();
                    xf3Var2.getClass();
                    hm2 hm2Var2 = new hm2(i);
                    hm2Var2.g(rg3VarO3);
                    if (z3) {
                        d0(rg3VarO3, hm2Var2);
                    } else {
                        fq4 fq4VarA2 = (fq4) xw3Var2.get(rg3VarO3);
                        if (fq4VarA2 == null) {
                            fq4VarA2 = fq4.a();
                            xw3Var2.put(rg3VarO3, fq4VarA2);
                        }
                        fq4VarA2.a |= 2;
                        fq4VarA2.b = hm2Var2;
                    }
                }
            }
            m();
        } else {
            m();
        }
        Y(true);
        r0(false);
        ng3Var.d = 2;
    }

    public final void t0() {
        fb2 fb2Var;
        setScrollState(0);
        qg3 qg3Var = this.v1;
        qg3Var.Z.removeCallbacks(qg3Var);
        qg3Var.z.abortAnimation();
        ag3 ag3Var = this.H0;
        if (ag3Var == null || (fb2Var = ag3Var.e) == null) {
            return;
        }
        fb2Var.i();
    }

    public final void u() {
        p0();
        X();
        ng3 ng3Var = this.y1;
        ng3Var.a(6);
        this.y0.e();
        ng3Var.e = this.G0.b();
        ng3Var.c = 0;
        if (this.A != null) {
            rf3 rf3Var = this.G0;
            int iG = fw.G(rf3Var.c);
            if (iG == 1 ? rf3Var.b() > 0 : iG != 2) {
                Parcelable parcelable = this.A.z;
                if (parcelable != null) {
                    this.H0.k0(parcelable);
                }
                this.A = null;
            }
        }
        ng3Var.g = false;
        this.H0.i0(this.z, ng3Var);
        ng3Var.f = false;
        ng3Var.j = ng3Var.j && this.g1 != null;
        ng3Var.d = 4;
        Y(true);
        r0(false);
    }

    public final boolean v(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        return getScrollingChildHelper().c(iArr, i, iArr2, i2, i3);
    }

    public final void w(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        getScrollingChildHelper().d(i, i2, i3, i4, iArr, i5, iArr2);
    }

    public final void x(int i, int i2) {
        this.a1++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i, scrollY - i2);
        fg3 fg3Var = this.z1;
        if (fg3Var != null) {
            fg3Var.b(this, i, i2);
        }
        ArrayList arrayList = this.A1;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((fg3) this.A1.get(size)).b(this, i, i2);
            }
        }
        this.a1--;
    }

    public final void y() {
        if (this.f1 != null) {
            return;
        }
        ((og3) this.b1).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f1 = edgeEffect;
        if (this.B0) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final void z() {
        if (this.c1 != null) {
            return;
        }
        ((og3) this.b1).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.c1 = edgeEffect;
        if (this.B0) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    @Deprecated
    public void setRecyclerListener(jg3 jg3Var) {
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        ag3 ag3Var = this.H0;
        if (ag3Var != null) {
            return ag3Var.t(layoutParams);
        }
        xe.q("RecyclerView has no LayoutManager".concat(C()));
        return null;
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.getsurfboard.R.attr.recyclerViewStyle);
    }

    public RecyclerView(Context context) {
        this(context, null);
    }
}
