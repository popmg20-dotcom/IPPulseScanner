package defpackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Z(android.view.View r7, float r8, float r9) {
        /*
            Method dump skipped, instruction units count: 408
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jo.Z(android.view.View, float, float):void");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p0(android.view.View r5, int r6) {
        /*
            r4 = this;
            int r0 = r4.g
            r1 = 1
            java.lang.Object r2 = r4.h
            r3 = 0
            switch(r0) {
                case 0: goto L2d;
                case 1: goto L19;
                default: goto L9;
            }
        L9:
            boolean r4 = r4.t0()
            if (r4 != 0) goto L10
            goto L18
        L10:
            android.view.ViewGroup$LayoutParams r4 = r5.getLayoutParams()
            ey3 r4 = (defpackage.ey3) r4
            boolean r3 = r4.b
        L18:
            return r3
        L19:
            com.google.android.material.sidesheet.SideSheetBehavior r2 = (com.google.android.material.sidesheet.SideSheetBehavior) r2
            int r4 = r2.y0
            if (r4 != r1) goto L20
            goto L2b
        L20:
            java.lang.ref.WeakReference r4 = r2.G0
            if (r4 == 0) goto L2b
            java.lang.Object r4 = r4.get()
            if (r4 != r5) goto L2b
            goto L2c
        L2b:
            r1 = r3
        L2c:
            return r1
        L2d:
            com.google.android.material.bottomsheet.BottomSheetBehavior r2 = (com.google.android.material.bottomsheet.BottomSheetBehavior) r2
            int r4 = r2.f1
            if (r4 != r1) goto L34
            goto L7e
        L34:
            boolean r0 = r2.y1
            if (r0 == 0) goto L39
            goto L7e
        L39:
            r0 = 3
            if (r4 != r0) goto L70
            int r4 = r2.v1
            if (r4 != r6) goto L70
            boolean r4 = r2.X
            r6 = 0
            if (r4 == 0) goto L51
            java.lang.ref.WeakReference r4 = r2.x1
            if (r4 == 0) goto L66
            java.lang.Object r4 = r4.get()
            r6 = r4
            android.view.View r6 = (android.view.View) r6
            goto L66
        L51:
            java.util.ArrayList r4 = r2.r1
            boolean r0 = r4.isEmpty()
            if (r0 != 0) goto L66
            java.lang.Object r4 = r4.get(r3)
            java.lang.ref.WeakReference r4 = (java.lang.ref.WeakReference) r4
            java.lang.Object r4 = r4.get()
            r6 = r4
            android.view.View r6 = (android.view.View) r6
        L66:
            if (r6 == 0) goto L70
            r4 = -1
            boolean r4 = r6.canScrollVertically(r4)
            if (r4 == 0) goto L70
            goto L7e
        L70:
            android.os.SystemClock.uptimeMillis()
            java.lang.ref.WeakReference r4 = r2.o1
            if (r4 == 0) goto L7e
            java.lang.Object r4 = r4.get()
            if (r4 != r5) goto L7e
            goto L7f
        L7e:
            r1 = r3
        L7f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jo.p0(android.view.View, int):boolean");
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
