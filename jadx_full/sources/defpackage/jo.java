package defpackage;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jo extends yr2 {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    public /* synthetic */ jo(int i, Object obj) {
        this.g = i;
        this.h = obj;
    }

    @Override // defpackage.yr2
    public int F(View view) {
        int i = this.g;
        Object obj = this.h;
        switch (i) {
            case 1:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) obj;
                return sideSheetBehavior.C0 + sideSheetBehavior.F0;
            case 2:
                return ((SlidingPaneLayout) obj).C0;
            default:
                return super.F(view);
        }
    }

    @Override // defpackage.yr2
    public int G() {
        switch (this.g) {
            case 0:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.h;
                return bottomSheetBehavior.a1 ? bottomSheetBehavior.n1 : bottomSheetBehavior.Y0;
            default:
                return super.G();
        }
    }

    @Override // defpackage.yr2
    public void U(int i) {
        switch (this.g) {
            case 2:
                if (t0()) {
                    SlidingPaneLayout slidingPaneLayout = (SlidingPaneLayout) this.h;
                    slidingPaneLayout.J0.c(slidingPaneLayout.z0, i);
                    break;
                }
                break;
        }
    }

    @Override // defpackage.yr2
    public void V(int i) {
        switch (this.g) {
            case 2:
                if (t0()) {
                    SlidingPaneLayout slidingPaneLayout = (SlidingPaneLayout) this.h;
                    slidingPaneLayout.J0.c(slidingPaneLayout.z0, i);
                    break;
                }
                break;
        }
    }

    @Override // defpackage.yr2
    public void W(View view, int i) {
        switch (this.g) {
            case 2:
                SlidingPaneLayout slidingPaneLayout = (SlidingPaneLayout) this.h;
                int childCount = slidingPaneLayout.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = slidingPaneLayout.getChildAt(i2);
                    if (childAt.getVisibility() == 4) {
                        childAt.setVisibility(0);
                    }
                }
                break;
        }
    }

    @Override // defpackage.yr2
    public final void X(int i) {
        int i2 = this.g;
        Object obj = this.h;
        switch (i2) {
            case 0:
                if (i == 1) {
                    BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) obj;
                    if (bottomSheetBehavior.c1) {
                        bottomSheetBehavior.O(1);
                    }
                }
                break;
            case 1:
                if (i == 1) {
                    SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) obj;
                    if (sideSheetBehavior.Z) {
                        sideSheetBehavior.x(1);
                    }
                }
                break;
            default:
                SlidingPaneLayout slidingPaneLayout = (SlidingPaneLayout) obj;
                CopyOnWriteArrayList copyOnWriteArrayList = slidingPaneLayout.H0;
                if (slidingPaneLayout.J0.a == 0) {
                    float f = slidingPaneLayout.A0;
                    View view = slidingPaneLayout.z0;
                    if (f != 1.0f) {
                        Iterator it = copyOnWriteArrayList.iterator();
                        while (it.hasNext()) {
                            o33 o33Var = (o33) ((fy3) it.next());
                            o33Var.getClass();
                            view.getClass();
                            o33Var.f(true);
                        }
                        slidingPaneLayout.sendAccessibilityEvent(32);
                        slidingPaneLayout.K0 = true;
                    } else {
                        slidingPaneLayout.h(view);
                        View view2 = slidingPaneLayout.z0;
                        Iterator it2 = copyOnWriteArrayList.iterator();
                        while (it2.hasNext()) {
                            o33 o33Var2 = (o33) ((fy3) it2.next());
                            o33Var2.getClass();
                            view2.getClass();
                            o33Var2.f(false);
                        }
                        slidingPaneLayout.sendAccessibilityEvent(32);
                        slidingPaneLayout.K0 = false;
                    }
                }
                break;
        }
    }

    @Override // defpackage.yr2
    public final void Y(View view, int i, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i3 = this.g;
        Object obj = this.h;
        switch (i3) {
            case 0:
                ((BottomSheetBehavior) obj).B(i2);
                return;
            case 1:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) obj;
                WeakReference weakReference = sideSheetBehavior.H0;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) != null) {
                    sideSheetBehavior.b.b0(marginLayoutParams, view.getLeft(), view.getRight());
                    view2.setLayoutParams(marginLayoutParams);
                }
                LinkedHashSet linkedHashSet = sideSheetBehavior.M0;
                if (linkedHashSet.isEmpty()) {
                    return;
                }
                sideSheetBehavior.b.f(i);
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    throw dw2.z(it);
                }
                return;
            default:
                SlidingPaneLayout slidingPaneLayout = (SlidingPaneLayout) obj;
                if (slidingPaneLayout.z0 == null) {
                    slidingPaneLayout.A0 = 0.0f;
                } else {
                    boolean zC = slidingPaneLayout.c();
                    ey3 ey3Var = (ey3) slidingPaneLayout.z0.getLayoutParams();
                    int width = slidingPaneLayout.z0.getWidth();
                    if (zC) {
                        i = (slidingPaneLayout.getWidth() - i) - width;
                    }
                    float paddingRight = (i - ((zC ? slidingPaneLayout.getPaddingRight() : slidingPaneLayout.getPaddingLeft()) + (zC ? ((ViewGroup.MarginLayoutParams) ey3Var).rightMargin : ((ViewGroup.MarginLayoutParams) ey3Var).leftMargin))) / slidingPaneLayout.C0;
                    slidingPaneLayout.A0 = paddingRight;
                    if (slidingPaneLayout.E0 != 0) {
                        slidingPaneLayout.f(paddingRight);
                    }
                    View view3 = slidingPaneLayout.z0;
                    Iterator it2 = slidingPaneLayout.H0.iterator();
                    while (it2.hasNext()) {
                        ((o33) ((fy3) it2.next())).getClass();
                        view3.getClass();
                    }
                }
                slidingPaneLayout.invalidate();
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ff A[PHI: r3
      0x00ff: PHI (r3v2 int) = (r3v1 int), (r3v1 int), (r3v1 int), (r3v1 int), (r3v0 int), (r3v0 int) binds: [B:89:0x0189, B:81:0x016a, B:73:0x013a, B:76:0x0150, B:58:0x00fd, B:56:0x00ee] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0124  */
    @Override // defpackage.yr2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Z(View view, float f, float f2) {
        int paddingLeft;
        int i = this.g;
        int i2 = 3;
        int i3 = 5;
        Object obj = this.h;
        switch (i) {
            case 0:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) obj;
                if (f2 < 0.0f) {
                    if (!bottomSheetBehavior.f) {
                        int top = view.getTop();
                        SystemClock.uptimeMillis();
                        if (top > bottomSheetBehavior.W0) {
                            i2 = 6;
                        }
                    }
                } else if (!bottomSheetBehavior.a1 || !bottomSheetBehavior.P(view, f2)) {
                    i3 = 4;
                    if (f2 == 0.0f || Math.abs(f) > Math.abs(f2)) {
                        int top2 = view.getTop();
                        if (!bottomSheetBehavior.f) {
                            int i4 = bottomSheetBehavior.W0;
                            if (top2 < i4) {
                                if (top2 >= Math.abs(top2 - bottomSheetBehavior.Y0)) {
                                }
                            } else if (Math.abs(top2 - i4) < Math.abs(top2 - bottomSheetBehavior.Y0)) {
                            }
                            i2 = 6;
                        } else if (Math.abs(top2 - bottomSheetBehavior.V0) >= Math.abs(top2 - bottomSheetBehavior.Y0)) {
                            i2 = i3;
                        }
                    } else {
                        if (!bottomSheetBehavior.f) {
                            int top3 = view.getTop();
                            if (Math.abs(top3 - bottomSheetBehavior.W0) < Math.abs(top3 - bottomSheetBehavior.Y0)) {
                            }
                        }
                        i2 = i3;
                    }
                } else if (Math.abs(f) >= Math.abs(f2) || f2 <= bottomSheetBehavior.A) {
                    if (view.getTop() <= (bottomSheetBehavior.F() + bottomSheetBehavior.n1) / 2) {
                        if (!bottomSheetBehavior.f && Math.abs(view.getTop() - bottomSheetBehavior.F()) >= Math.abs(view.getTop() - bottomSheetBehavior.W0)) {
                        }
                    }
                }
                bottomSheetBehavior.Q(view, i2, true);
                break;
            case 1:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) obj;
                if (!sideSheetBehavior.b.D(f)) {
                    if (sideSheetBehavior.b.X(view, f)) {
                        if (sideSheetBehavior.b.G(f, f2) || sideSheetBehavior.b.F(view)) {
                            i2 = 5;
                        }
                    } else if (f == 0.0f || Math.abs(f) <= Math.abs(f2)) {
                        int left = view.getLeft();
                        if (Math.abs(left - sideSheetBehavior.b.t()) >= Math.abs(left - sideSheetBehavior.b.v())) {
                        }
                    }
                }
                sideSheetBehavior.z(view, i2, true);
                break;
            default:
                ey3 ey3Var = (ey3) view.getLayoutParams();
                SlidingPaneLayout slidingPaneLayout = (SlidingPaneLayout) obj;
                if (slidingPaneLayout.c()) {
                    int paddingRight = slidingPaneLayout.getPaddingRight() + ((ViewGroup.MarginLayoutParams) ey3Var).rightMargin;
                    if (f < 0.0f || (f == 0.0f && slidingPaneLayout.A0 > 0.5f)) {
                        paddingRight += slidingPaneLayout.C0;
                    }
                    paddingLeft = (slidingPaneLayout.getWidth() - paddingRight) - slidingPaneLayout.z0.getWidth();
                } else {
                    paddingLeft = ((ViewGroup.MarginLayoutParams) ey3Var).leftMargin + slidingPaneLayout.getPaddingLeft();
                    if (f > 0.0f || (f == 0.0f && slidingPaneLayout.A0 > 0.5f)) {
                        paddingLeft += slidingPaneLayout.C0;
                    }
                }
                slidingPaneLayout.J0.r(paddingLeft, view.getTop());
                slidingPaneLayout.invalidate();
                break;
        }
    }

    @Override // defpackage.yr2
    public final int h(View view, int i) {
        int i2 = this.g;
        Object obj = this.h;
        switch (i2) {
            case 0:
                return view.getLeft();
            case 1:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) obj;
                return tj4.m(i, sideSheetBehavior.b.x(), sideSheetBehavior.b.w());
            default:
                SlidingPaneLayout slidingPaneLayout = (SlidingPaneLayout) obj;
                ey3 ey3Var = (ey3) slidingPaneLayout.z0.getLayoutParams();
                if (!slidingPaneLayout.c()) {
                    int paddingLeft = slidingPaneLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) ey3Var).leftMargin;
                    return Math.min(Math.max(i, paddingLeft), slidingPaneLayout.C0 + paddingLeft);
                }
                int width = slidingPaneLayout.getWidth() - (slidingPaneLayout.z0.getWidth() + (slidingPaneLayout.getPaddingRight() + ((ViewGroup.MarginLayoutParams) ey3Var).rightMargin));
                return Math.max(Math.min(i, width), width - slidingPaneLayout.C0);
        }
    }

    @Override // defpackage.yr2
    public final int i(View view, int i) {
        switch (this.g) {
        }
        return view.getTop();
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0070  */
    @Override // defpackage.yr2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean p0(View view, int i) {
        WeakReference weakReference;
        int i2 = this.g;
        Object obj = this.h;
        switch (i2) {
            case 0:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) obj;
                int i3 = bottomSheetBehavior.f1;
                if (i3 != 1 && !bottomSheetBehavior.y1) {
                    if (i3 == 3 && bottomSheetBehavior.v1 == i) {
                        View view2 = null;
                        if (bottomSheetBehavior.X) {
                            WeakReference weakReference2 = bottomSheetBehavior.x1;
                            if (weakReference2 != null) {
                                view2 = (View) weakReference2.get();
                            }
                        } else {
                            ArrayList arrayList = bottomSheetBehavior.r1;
                            if (!arrayList.isEmpty()) {
                                view2 = (View) ((WeakReference) arrayList.get(0)).get();
                            }
                        }
                        if (view2 == null || !view2.canScrollVertically(-1)) {
                        }
                    } else {
                        SystemClock.uptimeMillis();
                        WeakReference weakReference3 = bottomSheetBehavior.o1;
                        if (weakReference3 != null && weakReference3.get() == view) {
                            return true;
                        }
                    }
                }
                return false;
            case 1:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) obj;
                return (sideSheetBehavior.y0 == 1 || (weakReference = sideSheetBehavior.G0) == null || weakReference.get() != view) ? false : true;
            default:
                if (t0()) {
                    return ((ey3) view.getLayoutParams()).b;
                }
                return false;
        }
    }

    public boolean t0() {
        SlidingPaneLayout slidingPaneLayout = (SlidingPaneLayout) this.h;
        if (slidingPaneLayout.D0 || slidingPaneLayout.getLockMode() == 3) {
            return false;
        }
        if (slidingPaneLayout.d() && slidingPaneLayout.getLockMode() == 1) {
            return false;
        }
        return slidingPaneLayout.d() || slidingPaneLayout.getLockMode() != 2;
    }
}
