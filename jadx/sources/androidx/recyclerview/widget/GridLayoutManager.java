package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import defpackage.ab2;
import defpackage.ag3;
import defpackage.bb2;
import defpackage.bg3;
import defpackage.cb2;
import defpackage.cq1;
import defpackage.dw2;
import defpackage.fw;
import defpackage.i2;
import defpackage.ig3;
import defpackage.ng3;
import defpackage.o2;
import defpackage.p2;
import defpackage.r02;
import defpackage.rf3;
import defpackage.vp1;
import defpackage.wh1;
import defpackage.wp4;
import defpackage.xe;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.sentry.android.core.a1;
import j$.util.DesugarCollections;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public static final Set Q = DesugarCollections.unmodifiableSet(new HashSet(Arrays.asList(17, 66, 33, 130)));
    public boolean F;
    public int G;
    public int[] H;
    public View[] I;
    public final SparseIntArray J;
    public final SparseIntArray K;
    public final wh1 L;
    public final Rect M;
    public int N;
    public int O;
    public int P;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.F = false;
        this.G = -1;
        this.J = new SparseIntArray();
        this.K = new SparseIntArray();
        this.L = new wh1();
        this.M = new Rect();
        this.N = -1;
        this.O = -1;
        this.P = -1;
        y1(ag3.L(context, attributeSet, i, i2).b);
    }

    @Override // defpackage.ag3
    public final void A0(Rect rect, int i, int i2) {
        int iG;
        int iG2;
        if (this.H == null) {
            super.A0(rect, i, i2);
        }
        int I = I() + H();
        int iG3 = G() + J();
        if (this.p == 1) {
            int iHeight = rect.height() + iG3;
            RecyclerView recyclerView = this.b;
            WeakHashMap weakHashMap = wp4.a;
            iG2 = ag3.g(i2, iHeight, recyclerView.getMinimumHeight());
            int[] iArr = this.H;
            iG = ag3.g(i, iArr[iArr.length - 1] + I, this.b.getMinimumWidth());
        } else {
            int iWidth = rect.width() + I;
            RecyclerView recyclerView2 = this.b;
            WeakHashMap weakHashMap2 = wp4.a;
            iG = ag3.g(i, iWidth, recyclerView2.getMinimumWidth());
            int[] iArr2 = this.H;
            iG2 = ag3.g(i2, iArr2[iArr2.length - 1] + iG3, this.b.getMinimumHeight());
        }
        this.b.setMeasuredDimension(iG, iG2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.ag3
    public final boolean I0() {
        return this.A == null && !this.F;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void K0(ng3 ng3Var, cb2 cb2Var, r02 r02Var) {
        int i;
        int i2 = this.G;
        for (int i3 = 0; i3 < this.G && (i = cb2Var.d) >= 0 && i < ng3Var.b() && i2 > 0; i3++) {
            r02Var.b(cb2Var.d, Math.max(0, cb2Var.g));
            this.L.getClass();
            i2--;
            cb2Var.d += cb2Var.e;
        }
    }

    @Override // defpackage.ag3
    public final int M(ig3 ig3Var, ng3 ng3Var) {
        if (this.p == 0) {
            return Math.min(this.G, F());
        }
        if (ng3Var.b() < 1) {
            return 0;
        }
        return u1(ng3Var.b() - 1, ig3Var, ng3Var) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final View V0(ig3 ig3Var, ng3 ng3Var, boolean z, boolean z2) {
        int i;
        int iV;
        int iV2 = v();
        int i2 = 1;
        if (z2) {
            iV = v() - 1;
            i = -1;
            i2 = -1;
        } else {
            i = iV2;
            iV = 0;
        }
        int iB = ng3Var.b();
        P0();
        int iM = this.r.m();
        int i3 = this.r.i();
        View view = null;
        View view2 = null;
        while (iV != i) {
            View viewU = u(iV);
            int iK = ag3.K(viewU);
            if (iK >= 0 && iK < iB && v1(iK, ig3Var, ng3Var) == 0) {
                if (((bg3) viewU.getLayoutParams()).a.j()) {
                    if (view2 == null) {
                        view2 = viewU;
                    }
                } else {
                    if (this.r.g(viewU) < i3 && this.r.d(viewU) >= iM) {
                        return viewU;
                    }
                    if (view == null) {
                        view = viewU;
                    }
                }
            }
            iV += i2;
        }
        return view != null ? view : view2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e2, code lost:
    
        if (r13 == (r2 > r15)) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x013f, code lost:
    
        if (r16 == null) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0141, code lost:
    
        return r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0142, code lost:
    
        return r17;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.ag3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View X(android.view.View r23, int r24, defpackage.ig3 r25, defpackage.ng3 r26) {
        /*
            Method dump skipped, instruction units count: 323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.X(android.view.View, int, ig3, ng3):android.view.View");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.ag3
    public final void Z(ig3 ig3Var, ng3 ng3Var, p2 p2Var) {
        super.Z(ig3Var, ng3Var, p2Var);
        p2Var.j(GridView.class.getName());
        rf3 rf3Var = this.b.G0;
        if (rf3Var == null || rf3Var.b() <= 1) {
            return;
        }
        p2Var.b(i2.m);
    }

    @Override // defpackage.ag3
    public final void a0(ig3 ig3Var, ng3 ng3Var, View view, p2 p2Var) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof cq1)) {
            b0(view, p2Var);
            return;
        }
        cq1 cq1Var = (cq1) layoutParams;
        int iU1 = u1(cq1Var.a.d(), ig3Var, ng3Var);
        int i = this.p;
        int i2 = cq1Var.e;
        int i3 = cq1Var.f;
        if (i == 0) {
            p2Var.k(o2.a(i2, i3, iU1, false, 1, false));
        } else {
            p2Var.k(o2.a(iU1, 1, i2, false, i3, false));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v20, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r12v31 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void b1(ig3 ig3Var, ng3 ng3Var, cb2 cb2Var, bb2 bb2Var) {
        int i;
        int i2;
        int i3;
        int iF;
        int iJ;
        int iH;
        int iW;
        int iW2;
        ?? r12;
        int i4;
        View viewB;
        int iL = this.r.l();
        boolean z = iL != 1073741824;
        int i5 = v() > 0 ? this.H[this.G] : 0;
        if (z) {
            z1();
        }
        boolean z2 = cb2Var.e == 1;
        int iV1 = this.G;
        if (!z2) {
            iV1 = v1(cb2Var.d, ig3Var, ng3Var) + w1(cb2Var.d, ig3Var, ng3Var);
        }
        int i6 = 0;
        while (i6 < this.G && (i4 = cb2Var.d) >= 0 && i4 < ng3Var.b() && iV1 > 0) {
            int i7 = cb2Var.d;
            int iW1 = w1(i7, ig3Var, ng3Var);
            if (iW1 > this.G) {
                xe.k(fw.w(" spans.", fw.A(i7, iW1, "Item at position ", " requires ", " spans but GridLayoutManager has only "), this.G));
                return;
            }
            iV1 -= iW1;
            if (iV1 < 0 || (viewB = cb2Var.b(ig3Var)) == null) {
                break;
            }
            this.I[i6] = viewB;
            i6++;
        }
        if (i6 == 0) {
            bb2Var.b = true;
            return;
        }
        if (z2) {
            i3 = 1;
            i2 = i6;
            i = 0;
        } else {
            i = i6 - 1;
            i2 = -1;
            i3 = -1;
        }
        int i8 = 0;
        while (i != i2) {
            View view = this.I[i];
            cq1 cq1Var = (cq1) view.getLayoutParams();
            int iW12 = w1(ag3.K(view), ig3Var, ng3Var);
            cq1Var.f = iW12;
            cq1Var.e = i8;
            i8 += iW12;
            i += i3;
        }
        float f = 0.0f;
        int i9 = 0;
        for (int i10 = 0; i10 < i6; i10++) {
            View view2 = this.I[i10];
            if (cb2Var.k != null) {
                r12 = 0;
                r12 = 0;
                if (z2) {
                    b(view2, -1, true);
                } else {
                    b(view2, 0, true);
                }
            } else if (z2) {
                r12 = 0;
                b(view2, -1, false);
            } else {
                r12 = 0;
                b(view2, 0, false);
            }
            RecyclerView recyclerView = this.b;
            Rect rect = this.M;
            if (recyclerView == null) {
                rect.set(r12, r12, r12, r12);
            } else {
                rect.set(recyclerView.Q(view2));
            }
            x1(view2, iL, r12);
            int iE = this.r.e(view2);
            if (iE > i9) {
                i9 = iE;
            }
            float f2 = (this.r.f(view2) * 1.0f) / ((cq1) view2.getLayoutParams()).f;
            if (f2 > f) {
                f = f2;
            }
        }
        if (z) {
            n1(Math.max(Math.round(f * this.G), i5));
            i9 = 0;
            for (int i11 = 0; i11 < i6; i11++) {
                View view3 = this.I[i11];
                x1(view3, Pow2.MAX_POW2, true);
                int iE2 = this.r.e(view3);
                if (iE2 > i9) {
                    i9 = iE2;
                }
            }
        }
        for (int i12 = 0; i12 < i6; i12++) {
            View view4 = this.I[i12];
            if (this.r.e(view4) != i9) {
                cq1 cq1Var2 = (cq1) view4.getLayoutParams();
                Rect rect2 = cq1Var2.b;
                int i13 = rect2.top + rect2.bottom + ((ViewGroup.MarginLayoutParams) cq1Var2).topMargin + ((ViewGroup.MarginLayoutParams) cq1Var2).bottomMargin;
                int i14 = rect2.left + rect2.right + ((ViewGroup.MarginLayoutParams) cq1Var2).leftMargin + ((ViewGroup.MarginLayoutParams) cq1Var2).rightMargin;
                int iT1 = t1(cq1Var2.e, cq1Var2.f);
                if (this.p == 1) {
                    iW2 = ag3.w(iT1, Pow2.MAX_POW2, i14, false, ((ViewGroup.MarginLayoutParams) cq1Var2).width);
                    iW = View.MeasureSpec.makeMeasureSpec(i9 - i13, Pow2.MAX_POW2);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9 - i14, Pow2.MAX_POW2);
                    iW = ag3.w(iT1, Pow2.MAX_POW2, i13, false, ((ViewGroup.MarginLayoutParams) cq1Var2).height);
                    iW2 = iMakeMeasureSpec;
                }
                if (F0(view4, iW2, iW, (bg3) view4.getLayoutParams())) {
                    view4.measure(iW2, iW);
                }
            }
        }
        bb2Var.a = i9;
        int i15 = this.p;
        int i16 = cb2Var.f;
        int iF2 = cb2Var.b;
        if (i15 != 1) {
            if (i16 == -1) {
                iH = iF2 - i9;
                iJ = 0;
                iF = iF2;
            } else {
                iF = iF2 + i9;
                iJ = 0;
                iH = iF2;
            }
            iF2 = iJ;
        } else if (i16 == -1) {
            iJ = iF2 - i9;
            iH = 0;
            iF = 0;
        } else {
            iF = 0;
            iJ = iF2;
            iF2 += i9;
            iH = 0;
        }
        int i17 = 0;
        while (true) {
            View[] viewArr = this.I;
            if (i17 >= i6) {
                Arrays.fill(viewArr, (Object) null);
                return;
            }
            View view5 = viewArr[i17];
            cq1 cq1Var3 = (cq1) view5.getLayoutParams();
            if (this.p != 1) {
                iJ = J() + this.H[cq1Var3.e];
                iF2 = this.r.f(view5) + iJ;
            } else if (a1()) {
                int iH2 = H() + this.H[this.G - cq1Var3.e];
                iF = iH2;
                iH = iH2 - this.r.f(view5);
            } else {
                iH = H() + this.H[cq1Var3.e];
                iF = this.r.f(view5) + iH;
            }
            ag3.R(view5, iH, iJ, iF, iF2);
            if (cq1Var3.a.j() || cq1Var3.a.m()) {
                bb2Var.c = true;
            }
            bb2Var.d = view5.hasFocusable() | bb2Var.d;
            i17++;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void c1(ig3 ig3Var, ng3 ng3Var, ab2 ab2Var, int i) {
        z1();
        if (ng3Var.b() > 0 && !ng3Var.g) {
            boolean z = i == 1;
            int iV1 = v1(ab2Var.b, ig3Var, ng3Var);
            if (z) {
                while (iV1 > 0) {
                    int i2 = ab2Var.b;
                    if (i2 <= 0) {
                        break;
                    }
                    int i3 = i2 - 1;
                    ab2Var.b = i3;
                    iV1 = v1(i3, ig3Var, ng3Var);
                }
            } else {
                int iB = ng3Var.b() - 1;
                int i4 = ab2Var.b;
                while (i4 < iB) {
                    int i5 = i4 + 1;
                    int iV12 = v1(i5, ig3Var, ng3Var);
                    if (iV12 <= iV1) {
                        break;
                    }
                    i4 = i5;
                    iV1 = iV12;
                }
                ab2Var.b = i4;
            }
        }
        o1();
    }

    @Override // defpackage.ag3
    public final void d0(int i, int i2) {
        wh1 wh1Var = this.L;
        wh1Var.b();
        wh1Var.b.clear();
    }

    @Override // defpackage.ag3
    public final void e0() {
        wh1 wh1Var = this.L;
        wh1Var.b();
        wh1Var.b.clear();
    }

    @Override // defpackage.ag3
    public final boolean f(bg3 bg3Var) {
        return bg3Var instanceof cq1;
    }

    @Override // defpackage.ag3
    public final void f0(int i, int i2) {
        wh1 wh1Var = this.L;
        wh1Var.b();
        wh1Var.b.clear();
    }

    @Override // defpackage.ag3
    public final void g0(int i, int i2) {
        wh1 wh1Var = this.L;
        wh1Var.b();
        wh1Var.b.clear();
    }

    @Override // defpackage.ag3
    public final void h0(int i, int i2) {
        wh1 wh1Var = this.L;
        wh1Var.b();
        wh1Var.b.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.ag3
    public final void i0(ig3 ig3Var, ng3 ng3Var) {
        boolean z = ng3Var.g;
        SparseIntArray sparseIntArray = this.K;
        SparseIntArray sparseIntArray2 = this.J;
        if (z) {
            int iV = v();
            for (int i = 0; i < iV; i++) {
                cq1 cq1Var = (cq1) u(i).getLayoutParams();
                int iD = cq1Var.a.d();
                sparseIntArray2.put(iD, cq1Var.f);
                sparseIntArray.put(iD, cq1Var.e);
            }
        }
        super.i0(ig3Var, ng3Var);
        sparseIntArray2.clear();
        sparseIntArray.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.ag3
    public final void j0(ng3 ng3Var) {
        View viewQ;
        super.j0(ng3Var);
        this.F = false;
        int i = this.N;
        if (i == -1 || (viewQ = q(i)) == null) {
            return;
        }
        viewQ.sendAccessibilityEvent(67108864);
        this.N = -1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void j1(boolean z) {
        if (z) {
            vp1.n("GridLayoutManager does not support stack from end. Consider using reverse layout");
        } else {
            super.j1(false);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.ag3
    public final int k(ng3 ng3Var) {
        return M0(ng3Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.ag3
    public final int l(ng3 ng3Var) {
        return N0(ng3Var);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.ag3
    public final int n(ng3 ng3Var) {
        return M0(ng3Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01a9 A[EDGE_INSN: B:206:0x01a9->B:122:0x01a9 BREAK  A[LOOP:2: B:126:0x01b9->B:135:0x01e2, LOOP_LABEL: LOOP:2: B:126:0x01b9->B:135:0x01e2], EDGE_INSN: B:213:0x01a9->B:122:0x01a9 BREAK  A[LOOP:5: B:148:0x0221->B:159:0x0251, LOOP_LABEL: LOOP:5: B:148:0x0221->B:159:0x0251]] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x027e  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.ag3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean n0(int r12, android.os.Bundle r13) {
        /*
            Method dump skipped, instruction units count: 729
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.n0(int, android.os.Bundle):boolean");
    }

    public final void n1(int i) {
        int i2;
        int[] iArr = this.H;
        int i3 = this.G;
        if (iArr == null || iArr.length != i3 + 1 || iArr[iArr.length - 1] != i) {
            iArr = new int[i3 + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i / i3;
        int i6 = i % i3;
        int i7 = 0;
        for (int i8 = 1; i8 <= i3; i8++) {
            i4 += i6;
            if (i4 <= 0 || i3 - i4 >= i6) {
                i2 = i5;
            } else {
                i2 = i5 + 1;
                i4 -= i3;
            }
            i7 += i2;
            iArr[i8] = i7;
        }
        this.H = iArr;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.ag3
    public final int o(ng3 ng3Var) {
        return N0(ng3Var);
    }

    public final void o1() {
        View[] viewArr = this.I;
        if (viewArr == null || viewArr.length != this.G) {
            this.I = new View[this.G];
        }
    }

    public final int p1(int i) {
        int i2 = this.p;
        RecyclerView recyclerView = this.b;
        return i2 == 0 ? u1(i, recyclerView.z, recyclerView.y1) : v1(i, recyclerView.z, recyclerView.y1);
    }

    public final int q1(int i) {
        int i2 = this.p;
        RecyclerView recyclerView = this.b;
        return i2 == 1 ? u1(i, recyclerView.z, recyclerView.y1) : v1(i, recyclerView.z, recyclerView.y1);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.ag3
    public final bg3 r() {
        return this.p == 0 ? new cq1(-2, -1) : new cq1(-1, -2);
    }

    public final HashSet r1(int i) {
        return s1(q1(i), i);
    }

    @Override // defpackage.ag3
    public final bg3 s(Context context, AttributeSet attributeSet) {
        cq1 cq1Var = new cq1(context, attributeSet);
        cq1Var.e = -1;
        cq1Var.f = 0;
        return cq1Var;
    }

    public final HashSet s1(int i, int i2) {
        HashSet hashSet = new HashSet();
        RecyclerView recyclerView = this.b;
        int iW1 = w1(i2, recyclerView.z, recyclerView.y1);
        for (int i3 = i; i3 < i + iW1; i3++) {
            hashSet.add(Integer.valueOf(i3));
        }
        return hashSet;
    }

    @Override // defpackage.ag3
    public final bg3 t(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            cq1 cq1Var = new cq1((ViewGroup.MarginLayoutParams) layoutParams);
            cq1Var.e = -1;
            cq1Var.f = 0;
            return cq1Var;
        }
        cq1 cq1Var2 = new cq1(layoutParams);
        cq1Var2.e = -1;
        cq1Var2.f = 0;
        return cq1Var2;
    }

    public final int t1(int i, int i2) {
        if (this.p != 1 || !a1()) {
            int[] iArr = this.H;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.H;
        int i3 = this.G;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    public final int u1(int i, ig3 ig3Var, ng3 ng3Var) {
        boolean z = ng3Var.g;
        wh1 wh1Var = this.L;
        if (!z) {
            int i2 = this.G;
            wh1Var.getClass();
            return wh1.a(i, i2);
        }
        int iB = ig3Var.b(i);
        if (iB != -1) {
            int i3 = this.G;
            wh1Var.getClass();
            return wh1.a(iB, i3);
        }
        a1.n("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.ag3
    public final int v0(int i, ig3 ig3Var, ng3 ng3Var) {
        z1();
        o1();
        return super.v0(i, ig3Var, ng3Var);
    }

    public final int v1(int i, ig3 ig3Var, ng3 ng3Var) {
        boolean z = ng3Var.g;
        wh1 wh1Var = this.L;
        if (!z) {
            int i2 = this.G;
            wh1Var.getClass();
            return i % i2;
        }
        int i3 = this.K.get(i, -1);
        if (i3 != -1) {
            return i3;
        }
        int iB = ig3Var.b(i);
        if (iB != -1) {
            int i4 = this.G;
            wh1Var.getClass();
            return iB % i4;
        }
        a1.n("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    public final int w1(int i, ig3 ig3Var, ng3 ng3Var) {
        boolean z = ng3Var.g;
        wh1 wh1Var = this.L;
        if (!z) {
            wh1Var.getClass();
            return 1;
        }
        int i2 = this.J.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        if (ig3Var.b(i) != -1) {
            wh1Var.getClass();
            return 1;
        }
        a1.n("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    @Override // defpackage.ag3
    public final int x(ig3 ig3Var, ng3 ng3Var) {
        if (this.p == 1) {
            return Math.min(this.G, F());
        }
        if (ng3Var.b() < 1) {
            return 0;
        }
        return u1(ng3Var.b() - 1, ig3Var, ng3Var) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, defpackage.ag3
    public final int x0(int i, ig3 ig3Var, ng3 ng3Var) {
        z1();
        o1();
        return super.x0(i, ig3Var, ng3Var);
    }

    public final void x1(View view, int i, boolean z) {
        int iW;
        int iW2;
        cq1 cq1Var = (cq1) view.getLayoutParams();
        Rect rect = cq1Var.b;
        int i2 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) cq1Var).topMargin + ((ViewGroup.MarginLayoutParams) cq1Var).bottomMargin;
        int i3 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) cq1Var).leftMargin + ((ViewGroup.MarginLayoutParams) cq1Var).rightMargin;
        int iT1 = t1(cq1Var.e, cq1Var.f);
        if (this.p == 1) {
            iW2 = ag3.w(iT1, i, i3, false, ((ViewGroup.MarginLayoutParams) cq1Var).width);
            iW = ag3.w(this.r.n(), this.m, i2, true, ((ViewGroup.MarginLayoutParams) cq1Var).height);
        } else {
            int iW3 = ag3.w(iT1, i, i2, false, ((ViewGroup.MarginLayoutParams) cq1Var).height);
            int iW4 = ag3.w(this.r.n(), this.l, i3, true, ((ViewGroup.MarginLayoutParams) cq1Var).width);
            iW = iW3;
            iW2 = iW4;
        }
        bg3 bg3Var = (bg3) view.getLayoutParams();
        if (z ? F0(view, iW2, iW, bg3Var) : D0(view, iW2, iW, bg3Var)) {
            view.measure(iW2, iW);
        }
    }

    public final void y1(int i) {
        if (i == this.G) {
            return;
        }
        this.F = true;
        if (i < 1) {
            xe.k(dw2.A(i, "Span count should be at least 1. Provided "));
            return;
        }
        this.G = i;
        this.L.b();
        u0();
    }

    public final void z1() {
        int iG;
        int iJ;
        if (this.p == 1) {
            iG = this.n - I();
            iJ = H();
        } else {
            iG = this.o - G();
            iJ = J();
        }
        n1(iG - iJ);
    }

    public GridLayoutManager(Context context) {
        super(context);
        this.F = false;
        this.G = -1;
        this.J = new SparseIntArray();
        this.K = new SparseIntArray();
        this.L = new wh1();
        this.M = new Rect();
        this.N = -1;
        this.O = -1;
        this.P = -1;
        y1(3);
    }
}
