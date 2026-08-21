package androidx.viewpager2.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.fragment.app.o;
import androidx.fragment.app.u;
import defpackage.ag3;
import defpackage.bm0;
import defpackage.cp1;
import defpackage.f33;
import defpackage.ff2;
import defpackage.fw;
import defpackage.fz2;
import defpackage.ha0;
import defpackage.ih4;
import defpackage.ij1;
import defpackage.kk1;
import defpackage.oc3;
import defpackage.pq3;
import defpackage.qq3;
import defpackage.rf3;
import defpackage.rq4;
import defpackage.ry3;
import defpackage.sq4;
import defpackage.st4;
import defpackage.tq4;
import defpackage.uq4;
import defpackage.wp4;
import defpackage.wq4;
import defpackage.x90;
import defpackage.xe;
import defpackage.xf3;
import defpackage.xq4;
import defpackage.yq4;
import defpackage.zq4;
import defpackage.zv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {
    public int A;
    public uq4 A0;
    public int B0;
    public Parcelable C0;
    public yq4 D0;
    public xq4 E0;
    public qq3 F0;
    public x90 G0;
    public cp1 H0;
    public fz2 I0;
    public xf3 J0;
    public boolean K0;
    public boolean L0;
    public int M0;
    public ih4 N0;
    public final Rect b;
    public final Rect f;
    public boolean y0;
    public final x90 z;
    public final rq4 z0;

    public ViewPager2(Context context) {
        super(context);
        this.b = new Rect();
        this.f = new Rect();
        this.z = new x90();
        this.y0 = false;
        this.z0 = new rq4(0, this);
        this.B0 = -1;
        this.J0 = null;
        this.K0 = false;
        this.L0 = true;
        this.M0 = -1;
        a(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        this.N0 = new ih4(this);
        yq4 yq4Var = new yq4(this, context);
        this.D0 = yq4Var;
        WeakHashMap weakHashMap = wp4.a;
        yq4Var.setId(View.generateViewId());
        this.D0.setDescendantFocusability(131072);
        uq4 uq4Var = new uq4(this, context);
        this.A0 = uq4Var;
        this.D0.setLayoutManager(uq4Var);
        int i = 1;
        this.D0.setScrollingTouchSlop(1);
        int[] iArr = oc3.a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        wp4.m(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0);
        int i2 = 0;
        try {
            setOrientation(typedArrayObtainStyledAttributes.getInt(0, 0));
            typedArrayObtainStyledAttributes.recycle();
            this.D0.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            yq4 yq4Var2 = this.D0;
            tq4 tq4Var = new tq4();
            ArrayList arrayList = yq4Var2.W0;
            if (arrayList == null) {
                arrayList = new ArrayList();
                yq4Var2.W0 = arrayList;
            }
            arrayList.add(tq4Var);
            qq3 qq3Var = new qq3(this);
            this.F0 = qq3Var;
            this.H0 = new cp1(27, qq3Var);
            xq4 xq4Var = new xq4(this);
            this.E0 = xq4Var;
            yq4 yq4Var3 = this.D0;
            yq4 yq4Var4 = xq4Var.a;
            if (yq4Var4 != yq4Var3) {
                ry3 ry3Var = xq4Var.b;
                if (yq4Var4 != null) {
                    ArrayList arrayList2 = yq4Var4.A1;
                    if (arrayList2 != null) {
                        arrayList2.remove(ry3Var);
                    }
                    xq4Var.a.setOnFlingListener(null);
                }
                xq4Var.a = yq4Var3;
                if (yq4Var3 != null) {
                    if (yq4Var3.getOnFlingListener() != null) {
                        xe.q("An instance of OnFlingListener already set.");
                        return;
                    }
                    xq4Var.a.j(ry3Var);
                    xq4Var.a.setOnFlingListener(xq4Var);
                    new Scroller(xq4Var.a.getContext(), new DecelerateInterpolator());
                    xq4Var.g();
                }
            }
            this.D0.j(this.F0);
            x90 x90Var = new x90();
            this.G0 = x90Var;
            this.F0.a = x90Var;
            sq4 sq4Var = new sq4(this, i2);
            sq4 sq4Var2 = new sq4(this, i);
            ((ArrayList) x90Var.b).add(sq4Var);
            ((ArrayList) this.G0.b).add(sq4Var2);
            ih4 ih4Var = this.N0;
            yq4 yq4Var5 = this.D0;
            ih4Var.getClass();
            yq4Var5.setImportantForAccessibility(2);
            ih4Var.c = new rq4(i, ih4Var);
            ViewPager2 viewPager2 = (ViewPager2) ih4Var.d;
            if (viewPager2.getImportantForAccessibility() == 0) {
                viewPager2.setImportantForAccessibility(1);
            }
            ((ArrayList) this.G0.b).add(this.z);
            fz2 fz2Var = new fz2();
            this.I0 = fz2Var;
            ((ArrayList) this.G0.b).add(fz2Var);
            yq4 yq4Var6 = this.D0;
            attachViewToParent(yq4Var6, 0, yq4Var6.getLayoutParams());
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void b() {
        rf3 adapter;
        String next;
        o oVarB;
        if (this.B0 == -1 || (adapter = getAdapter()) == null) {
            return;
        }
        Parcelable parcelable = this.C0;
        if (parcelable != null) {
            if (adapter instanceof kk1) {
                kk1 kk1Var = (kk1) adapter;
                ff2 ff2Var = kk1Var.f;
                ff2 ff2Var2 = kk1Var.g;
                if (ff2Var2.j() != 0 || ff2Var.j() != 0) {
                    xe.q("Expected the adapter to be 'fresh' while restoring state.");
                    return;
                }
                Bundle bundle = (Bundle) parcelable;
                if (bundle.getClassLoader() == null) {
                    bundle.setClassLoader(kk1Var.getClass().getClassLoader());
                }
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    int i = 2;
                    if (it.hasNext()) {
                        next = it.next();
                        if (next.startsWith("f#") && next.length() > 2) {
                            long j = Long.parseLong(next.substring(2));
                            u uVar = kk1Var.e;
                            uVar.getClass();
                            String string = bundle.getString(next);
                            if (string == null) {
                                oVarB = null;
                            } else {
                                oVarB = uVar.c.b(string);
                                if (oVarB == null) {
                                    uVar.j0(new IllegalStateException(fw.u("Fragment no longer exists for key ", next, ": unique id ", string)));
                                    throw null;
                                }
                            }
                            ff2Var.h(j, oVarB);
                        } else {
                            if (!next.startsWith("s#") || next.length() <= 2) {
                                break;
                            }
                            long j2 = Long.parseLong(next.substring(2));
                            ij1 ij1Var = (ij1) bundle.getParcelable(next);
                            if (kk1Var.r(j2)) {
                                ff2Var2.h(j2, ij1Var);
                            }
                        }
                    } else if (ff2Var.j() != 0) {
                        kk1Var.l = true;
                        kk1Var.k = true;
                        kk1Var.t();
                        Handler handler = new Handler(Looper.getMainLooper());
                        f33 f33Var = new f33(12, kk1Var);
                        kk1Var.d.a(new bm0(i, handler, f33Var));
                        handler.postDelayed(f33Var, 10000L);
                    }
                }
                xe.k("Unexpected key in savedState: ".concat(next));
                return;
            }
            this.C0 = null;
        }
        int iMax = Math.max(0, Math.min(this.B0, adapter.b() - 1));
        this.A = iMax;
        this.B0 = -1;
        this.D0.l0(iMax);
        this.N0.e();
    }

    public final void c(int i) {
        Object obj = this.H0.f;
        d(i);
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i) {
        return this.D0.canScrollHorizontally(i);
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int i) {
        return this.D0.canScrollVertically(i);
    }

    public final void d(int i) {
        rf3 adapter = getAdapter();
        if (adapter == null) {
            if (this.B0 != -1) {
                this.B0 = Math.max(i, 0);
                return;
            }
            return;
        }
        if (adapter.b() <= 0) {
            return;
        }
        int iMin = Math.min(Math.max(i, 0), adapter.b() - 1);
        int i2 = this.A;
        if ((iMin == i2 && this.F0.f == 0) || iMin == i2) {
            return;
        }
        double d = i2;
        this.A = iMin;
        this.N0.e();
        qq3 qq3Var = this.F0;
        if (qq3Var.f != 0) {
            qq3Var.f();
            pq3 pq3Var = qq3Var.g;
            d = ((double) pq3Var.a) + ((double) pq3Var.b);
        }
        qq3 qq3Var2 = this.F0;
        qq3Var2.getClass();
        qq3Var2.e = 2;
        boolean z = qq3Var2.i != iMin;
        qq3Var2.i = iMin;
        qq3Var2.d(2);
        if (z) {
            qq3Var2.c(iMin);
        }
        double d2 = iMin;
        double dAbs = Math.abs(d2 - d);
        yq4 yq4Var = this.D0;
        if (dAbs <= 3.0d) {
            yq4Var.o0(iMin);
            return;
        }
        yq4Var.l0(d2 > d ? iMin - 3 : iMin + 3);
        yq4 yq4Var2 = this.D0;
        yq4Var2.post(new zv(iMin, yq4Var2));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        Parcelable parcelable = (Parcelable) sparseArray.get(getId());
        if (parcelable instanceof zq4) {
            int i = ((zq4) parcelable).b;
            sparseArray.put(this.D0.getId(), (Parcelable) sparseArray.get(i));
            sparseArray.remove(i);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        b();
    }

    public final void e() {
        xq4 xq4Var = this.E0;
        if (xq4Var == null) {
            xe.q("Design assumption violated.");
            return;
        }
        View viewD = xq4Var.d(this.A0);
        if (viewD == null) {
            return;
        }
        this.A0.getClass();
        int iK = ag3.K(viewD);
        if (iK != this.A && getScrollState() == 0) {
            this.G0.c(iK);
        }
        this.y0 = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        this.N0.getClass();
        this.N0.getClass();
        return "androidx.viewpager.widget.ViewPager";
    }

    public rf3 getAdapter() {
        return this.D0.getAdapter();
    }

    public int getCurrentItem() {
        return this.A;
    }

    public int getItemDecorationCount() {
        return this.D0.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.M0;
    }

    public int getOrientation() {
        return this.A0.p == 1 ? 1 : 0;
    }

    public int getPageSize() {
        int height;
        int paddingBottom;
        yq4 yq4Var = this.D0;
        if (getOrientation() == 0) {
            height = yq4Var.getWidth() - yq4Var.getPaddingLeft();
            paddingBottom = yq4Var.getPaddingRight();
        } else {
            height = yq4Var.getHeight() - yq4Var.getPaddingTop();
            paddingBottom = yq4Var.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.F0.f;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int iB;
        int iB2;
        int iB3;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        ViewPager2 viewPager2 = (ViewPager2) this.N0.d;
        if (viewPager2.getAdapter() == null) {
            iB = 0;
            iB2 = 0;
        } else if (viewPager2.getOrientation() == 1) {
            iB = viewPager2.getAdapter().b();
            iB2 = 1;
        } else {
            iB2 = viewPager2.getAdapter().b();
            iB = 1;
        }
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(iB, iB2, false, 0));
        rf3 adapter = viewPager2.getAdapter();
        if (adapter == null || (iB3 = adapter.b()) == 0 || !viewPager2.L0) {
            return;
        }
        if (viewPager2.A > 0) {
            accessibilityNodeInfo.addAction(8192);
        }
        if (viewPager2.A < iB3 - 1) {
            accessibilityNodeInfo.addAction(4096);
        }
        accessibilityNodeInfo.setScrollable(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = this.D0.getMeasuredWidth();
        int measuredHeight = this.D0.getMeasuredHeight();
        int paddingLeft = getPaddingLeft();
        Rect rect = this.b;
        rect.left = paddingLeft;
        rect.right = (i3 - i) - getPaddingRight();
        rect.top = getPaddingTop();
        rect.bottom = (i4 - i2) - getPaddingBottom();
        Rect rect2 = this.f;
        Gravity.apply(8388659, measuredWidth, measuredHeight, rect, rect2);
        this.D0.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
        if (this.y0) {
            e();
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        measureChild(this.D0, i, i2);
        int measuredWidth = this.D0.getMeasuredWidth();
        int measuredHeight = this.D0.getMeasuredHeight();
        int measuredState = this.D0.getMeasuredState();
        int paddingRight = getPaddingRight() + getPaddingLeft() + measuredWidth;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + measuredHeight;
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i, measuredState), View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i2, measuredState << 16));
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof zq4)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        zq4 zq4Var = (zq4) parcelable;
        super.onRestoreInstanceState(zq4Var.getSuperState());
        this.B0 = zq4Var.f;
        this.C0 = zq4Var.z;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        zq4 zq4Var = new zq4(super.onSaveInstanceState());
        zq4Var.b = this.D0.getId();
        int i = this.B0;
        if (i == -1) {
            i = this.A;
        }
        zq4Var.f = i;
        Parcelable parcelable = this.C0;
        if (parcelable != null) {
            zq4Var.z = parcelable;
            return zq4Var;
        }
        rf3 adapter = this.D0.getAdapter();
        if (adapter instanceof kk1) {
            kk1 kk1Var = (kk1) adapter;
            ff2 ff2Var = kk1Var.f;
            int iJ = ff2Var.j();
            ff2 ff2Var2 = kk1Var.g;
            Bundle bundle = new Bundle(ff2Var2.j() + iJ);
            for (int i2 = 0; i2 < ff2Var.j(); i2++) {
                long jG = ff2Var.g(i2);
                o oVar = (o) ff2Var.d(jG);
                if (oVar != null && oVar.isAdded()) {
                    kk1Var.e.X(bundle, ha0.j(jG, "f#"), oVar);
                }
            }
            for (int i3 = 0; i3 < ff2Var2.j(); i3++) {
                long jG2 = ff2Var2.g(i3);
                if (kk1Var.r(jG2)) {
                    bundle.putParcelable(ha0.j(jG2, "s#"), (Parcelable) ff2Var2.d(jG2));
                }
            }
            zq4Var.z = bundle;
        }
        return zq4Var;
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        throw new IllegalStateException("ViewPager2 does not support direct child views");
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int i, Bundle bundle) {
        this.N0.getClass();
        if (i != 8192 && i != 4096) {
            return super.performAccessibilityAction(i, bundle);
        }
        ih4 ih4Var = this.N0;
        ih4Var.getClass();
        ViewPager2 viewPager2 = (ViewPager2) ih4Var.d;
        if (i != 8192 && i != 4096) {
            st4.g();
            return false;
        }
        int currentItem = i == 8192 ? viewPager2.getCurrentItem() - 1 : viewPager2.getCurrentItem() + 1;
        if (viewPager2.L0) {
            viewPager2.d(currentItem);
        }
        return true;
    }

    public void setAdapter(rf3 rf3Var) {
        rf3 adapter = this.D0.getAdapter();
        ih4 ih4Var = this.N0;
        if (adapter != null) {
            adapter.p((rq4) ih4Var.c);
        } else {
            ih4Var.getClass();
        }
        rq4 rq4Var = this.z0;
        if (adapter != null) {
            adapter.p(rq4Var);
        }
        this.D0.setAdapter(rf3Var);
        this.A = 0;
        b();
        ih4 ih4Var2 = this.N0;
        ih4Var2.e();
        if (rf3Var != null) {
            rf3Var.n((rq4) ih4Var2.c);
        }
        if (rf3Var != null) {
            rf3Var.n(rq4Var);
        }
    }

    public void setCurrentItem(int i) {
        c(i);
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        super.setLayoutDirection(i);
        this.N0.e();
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1 && i != -1) {
            xe.k("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        } else {
            this.M0 = i;
            this.D0.requestLayout();
        }
    }

    public void setOrientation(int i) {
        this.A0.i1(i);
        this.N0.e();
    }

    public void setPageTransformer(wq4 wq4Var) {
        boolean z = this.K0;
        if (wq4Var != null) {
            if (!z) {
                this.J0 = this.D0.getItemAnimator();
                this.K0 = true;
            }
            this.D0.setItemAnimator(null);
        } else if (z) {
            this.D0.setItemAnimator(this.J0);
            this.J0 = null;
            this.K0 = false;
        }
        this.I0.getClass();
        if (wq4Var == null) {
            return;
        }
        this.I0.getClass();
        this.I0.getClass();
    }

    public void setUserInputEnabled(boolean z) {
        this.L0 = z;
        this.N0.e();
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new Rect();
        this.f = new Rect();
        this.z = new x90();
        this.y0 = false;
        this.z0 = new rq4(0, this);
        this.B0 = -1;
        this.J0 = null;
        this.K0 = false;
        this.L0 = true;
        this.M0 = -1;
        a(context, attributeSet);
    }
}
