package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import defpackage.ag3;
import defpackage.bg3;
import defpackage.f33;
import defpackage.fb2;
import defpackage.h31;
import defpackage.if2;
import defpackage.ig3;
import defpackage.ji0;
import defpackage.mg3;
import defpackage.ng3;
import defpackage.o2;
import defpackage.p2;
import defpackage.r02;
import defpackage.u14;
import defpackage.v14;
import defpackage.v62;
import defpackage.wp4;
import defpackage.x14;
import defpackage.x82;
import defpackage.xe;
import defpackage.zf3;
import io.netty.channel.internal.ChannelUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends ag3 implements mg3 {
    public int A;
    public final v62 B;
    public final int C;
    public boolean D;
    public boolean E;
    public x14 F;
    public final Rect G;
    public final u14 H;
    public final boolean I;
    public int[] J;
    public final f33 K;
    public int p;
    public if2[] q;
    public final h31 r;
    public final h31 s;
    public final int t;
    public int u;
    public final x82 v;
    public boolean w;
    public boolean x;
    public BitSet y;
    public int z;

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.p = -1;
        this.w = false;
        this.x = false;
        this.z = -1;
        this.A = Integer.MIN_VALUE;
        this.B = new v62(29, false);
        this.C = 2;
        this.G = new Rect();
        this.H = new u14(this);
        this.I = true;
        this.K = new f33(22, this);
        zf3 zf3VarL = ag3.L(context, attributeSet, i, i2);
        int i3 = zf3VarL.a;
        if (i3 != 0 && i3 != 1) {
            xe.k("invalid orientation.");
            throw null;
        }
        c(null);
        if (i3 != this.t) {
            this.t = i3;
            h31 h31Var = this.r;
            this.r = this.s;
            this.s = h31Var;
            u0();
        }
        h1(zf3VarL.b);
        boolean z = zf3VarL.c;
        c(null);
        x14 x14Var = this.F;
        if (x14Var != null && x14Var.y0 != z) {
            x14Var.y0 = z;
        }
        this.w = z;
        u0();
        this.v = new x82();
        this.r = h31.b(this, this.t);
        this.s = h31.b(this, 1 - this.t);
    }

    public static int k1(int i, int i2, int i3) {
        int mode;
        return (!(i2 == 0 && i3 == 0) && ((mode = View.MeasureSpec.getMode(i)) == Integer.MIN_VALUE || mode == 1073741824)) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    @Override // defpackage.ag3
    public final void A0(Rect rect, int i, int i2) {
        int iG;
        int iG2;
        int I = I() + H();
        int iG3 = G() + J();
        if (this.t == 1) {
            int iHeight = rect.height() + iG3;
            RecyclerView recyclerView = this.b;
            WeakHashMap weakHashMap = wp4.a;
            iG2 = ag3.g(i2, iHeight, recyclerView.getMinimumHeight());
            iG = ag3.g(i, (this.u * this.p) + I, this.b.getMinimumWidth());
        } else {
            int iWidth = rect.width() + I;
            RecyclerView recyclerView2 = this.b;
            WeakHashMap weakHashMap2 = wp4.a;
            iG = ag3.g(i, iWidth, recyclerView2.getMinimumWidth());
            iG2 = ag3.g(i2, (this.u * this.p) + iG3, this.b.getMinimumHeight());
        }
        this.b.setMeasuredDimension(iG, iG2);
    }

    @Override // defpackage.ag3
    public final void G0(RecyclerView recyclerView, int i) {
        fb2 fb2Var = new fb2(recyclerView.getContext());
        fb2Var.a = i;
        H0(fb2Var);
    }

    @Override // defpackage.ag3
    public final boolean I0() {
        return this.F == null;
    }

    public final boolean J0() {
        int iQ0;
        if (v() != 0 && this.C != 0 && this.g) {
            if (this.x) {
                iQ0 = R0();
                Q0();
            } else {
                iQ0 = Q0();
                R0();
            }
            if (iQ0 == 0 && V0() != null) {
                this.B.s();
                this.f = true;
                u0();
                return true;
            }
        }
        return false;
    }

    public final int K0(ng3 ng3Var) {
        if (v() == 0) {
            return 0;
        }
        boolean z = !this.I;
        return ji0.e(ng3Var, this.r, N0(z), M0(z), this, this.I, this.x);
    }

    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [boolean, int] */
    public final int L0(ig3 ig3Var, x82 x82Var, ng3 ng3Var) {
        int i;
        int i2;
        if2 if2Var;
        ?? r8;
        int iK;
        int iE;
        int iE2;
        int i3;
        int i4;
        int i5;
        int i6;
        ig3 ig3Var2 = ig3Var;
        int i7 = 0;
        int i8 = 1;
        this.y.set(0, this.p, true);
        x82 x82Var2 = this.v;
        if (x82Var2.i) {
            i = x82Var.e;
            i2 = i == 1 ? ChannelUtils.WRITE_STATUS_SNDBUF_FULL : Integer.MIN_VALUE;
        } else {
            i = x82Var.e;
            i2 = i == 1 ? x82Var.g + x82Var.b : x82Var.f - x82Var.b;
        }
        for (int i9 = 0; i9 < this.p; i9++) {
            if (!((ArrayList) this.q[i9].f).isEmpty()) {
                j1(this.q[i9], i, i2);
            }
        }
        boolean z = this.x;
        h31 h31Var = this.r;
        int i10 = z ? h31Var.i() : h31Var.m();
        boolean z2 = false;
        while (true) {
            int i11 = x82Var.c;
            if (i11 < 0 || i11 >= ng3Var.b() || (!x82Var2.i && this.y.isEmpty())) {
                break;
            }
            View viewD = ig3Var2.d(x82Var.c);
            x82Var.c += x82Var.d;
            v14 v14Var = (v14) viewD.getLayoutParams();
            int iD = v14Var.a.d();
            v62 v62Var = this.B;
            int[] iArr = (int[]) v62Var.f;
            int i12 = (iArr == null || iD >= iArr.length) ? -1 : iArr[iD];
            if (i12 == -1) {
                boolean zZ0 = Z0(x82Var.e);
                int i13 = this.p;
                if (zZ0) {
                    i6 = i13 - 1;
                    i5 = -1;
                    i4 = -1;
                } else {
                    i4 = i8;
                    i5 = i13;
                    i6 = i7;
                }
                if2 if2Var2 = null;
                if (x82Var.e == i8) {
                    int iM = h31Var.m();
                    int i14 = ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
                    while (i6 != i5) {
                        if2 if2Var3 = this.q[i6];
                        int i15 = i6;
                        int i16 = if2Var3.i(iM);
                        if (i16 < i14) {
                            if2Var2 = if2Var3;
                            i14 = i16;
                        }
                        i6 = i15 + i4;
                    }
                } else {
                    int i17 = h31Var.i();
                    int i18 = Integer.MIN_VALUE;
                    while (i6 != i5) {
                        if2 if2Var4 = this.q[i6];
                        int i19 = i5;
                        int iK2 = if2Var4.k(i17);
                        if (iK2 > i18) {
                            i18 = iK2;
                            if2Var2 = if2Var4;
                        }
                        i6 += i4;
                        i5 = i19;
                    }
                }
                if2Var = if2Var2;
                v62Var.u(iD);
                ((int[]) v62Var.f)[iD] = if2Var.e;
            } else {
                if2Var = this.q[i12];
            }
            v14Var.e = if2Var;
            if (x82Var.e == 1) {
                r8 = 0;
                b(viewD, -1, false);
            } else {
                r8 = 0;
                b(viewD, 0, false);
            }
            int i20 = this.t;
            if (i20 == 1) {
                X0(viewD, ag3.w(this.u, this.l, r8, r8, ((ViewGroup.MarginLayoutParams) v14Var).width), ag3.w(this.o, this.m, G() + J(), true, ((ViewGroup.MarginLayoutParams) v14Var).height));
            } else {
                X0(viewD, ag3.w(this.n, this.l, I() + H(), true, ((ViewGroup.MarginLayoutParams) v14Var).width), ag3.w(this.u, this.m, 0, false, ((ViewGroup.MarginLayoutParams) v14Var).height));
            }
            if (x82Var.e == 1) {
                iE = if2Var.i(i10);
                iK = h31Var.e(viewD) + iE;
            } else {
                iK = if2Var.k(i10);
                iE = iK - h31Var.e(viewD);
            }
            int i21 = x82Var.e;
            if2 if2Var5 = v14Var.e;
            if (i21 == 1) {
                if2Var5.getClass();
                v14 v14Var2 = (v14) viewD.getLayoutParams();
                v14Var2.e = if2Var5;
                ArrayList arrayList = (ArrayList) if2Var5.f;
                arrayList.add(viewD);
                if2Var5.c = Integer.MIN_VALUE;
                if (arrayList.size() == 1) {
                    if2Var5.b = Integer.MIN_VALUE;
                }
                if (v14Var2.a.j() || v14Var2.a.m()) {
                    if2Var5.d = ((StaggeredGridLayoutManager) if2Var5.g).r.e(viewD) + if2Var5.d;
                }
            } else {
                if2Var5.getClass();
                v14 v14Var3 = (v14) viewD.getLayoutParams();
                v14Var3.e = if2Var5;
                ArrayList arrayList2 = (ArrayList) if2Var5.f;
                arrayList2.add(0, viewD);
                if2Var5.b = Integer.MIN_VALUE;
                if (arrayList2.size() == 1) {
                    if2Var5.c = Integer.MIN_VALUE;
                }
                if (v14Var3.a.j() || v14Var3.a.m()) {
                    if2Var5.d = ((StaggeredGridLayoutManager) if2Var5.g).r.e(viewD) + if2Var5.d;
                }
            }
            boolean zW0 = W0();
            h31 h31Var2 = this.s;
            if (zW0 && i20 == 1) {
                i3 = h31Var2.i() - (((this.p - 1) - if2Var.e) * this.u);
                iE2 = i3 - h31Var2.e(viewD);
            } else {
                int iM2 = (if2Var.e * this.u) + h31Var2.m();
                int iE3 = h31Var2.e(viewD) + iM2;
                iE2 = iM2;
                i3 = iE3;
            }
            if (i20 == 1) {
                ag3.R(viewD, iE2, iE, i3, iK);
            } else {
                ag3.R(viewD, iE, iE2, iK, i3);
            }
            j1(if2Var, x82Var2.e, i2);
            ig3Var2 = ig3Var;
            b1(ig3Var2, x82Var2);
            if (x82Var2.h && viewD.hasFocusable()) {
                this.y.set(if2Var.e, false);
            }
            i8 = 1;
            z2 = true;
            i7 = 0;
        }
        if (!z2) {
            b1(ig3Var2, x82Var2);
        }
        int iM3 = x82Var2.e == -1 ? h31Var.m() - T0(h31Var.m()) : S0(h31Var.i()) - h31Var.i();
        if (iM3 > 0) {
            return Math.min(x82Var.b, iM3);
        }
        return 0;
    }

    @Override // defpackage.ag3
    public final int M(ig3 ig3Var, ng3 ng3Var) {
        if (this.t == 0) {
            return Math.min(this.p, ng3Var.b());
        }
        return -1;
    }

    public final View M0(boolean z) {
        h31 h31Var = this.r;
        int iM = h31Var.m();
        int i = h31Var.i();
        View view = null;
        for (int iV = v() - 1; iV >= 0; iV--) {
            View viewU = u(iV);
            int iG = h31Var.g(viewU);
            int iD = h31Var.d(viewU);
            if (iD > iM && iG < i) {
                if (iD <= i || !z) {
                    return viewU;
                }
                if (view == null) {
                    view = viewU;
                }
            }
        }
        return view;
    }

    public final View N0(boolean z) {
        h31 h31Var = this.r;
        int iM = h31Var.m();
        int i = h31Var.i();
        int iV = v();
        View view = null;
        for (int i2 = 0; i2 < iV; i2++) {
            View viewU = u(i2);
            int iG = h31Var.g(viewU);
            if (h31Var.d(viewU) > iM && iG < i) {
                if (iG >= iM || !z) {
                    return viewU;
                }
                if (view == null) {
                    view = viewU;
                }
            }
        }
        return view;
    }

    @Override // defpackage.ag3
    public final boolean O() {
        return this.C != 0;
    }

    public final void O0(ig3 ig3Var, ng3 ng3Var, boolean z) {
        int i;
        int iS0 = S0(Integer.MIN_VALUE);
        if (iS0 != Integer.MIN_VALUE && (i = this.r.i() - iS0) > 0) {
            int i2 = i - (-f1(-i, ig3Var, ng3Var));
            if (!z || i2 <= 0) {
                return;
            }
            this.r.q(i2);
        }
    }

    @Override // defpackage.ag3
    public final boolean P() {
        return this.w;
    }

    public final void P0(ig3 ig3Var, ng3 ng3Var, boolean z) {
        int iM;
        int iT0 = T0(ChannelUtils.WRITE_STATUS_SNDBUF_FULL);
        if (iT0 != Integer.MAX_VALUE && (iM = iT0 - this.r.m()) > 0) {
            int iF1 = iM - f1(iM, ig3Var, ng3Var);
            if (!z || iF1 <= 0) {
                return;
            }
            this.r.q(-iF1);
        }
    }

    public final int Q0() {
        if (v() == 0) {
            return 0;
        }
        return ag3.K(u(0));
    }

    public final int R0() {
        int iV = v();
        if (iV == 0) {
            return 0;
        }
        return ag3.K(u(iV - 1));
    }

    @Override // defpackage.ag3
    public final void S(int i) {
        super.S(i);
        for (int i2 = 0; i2 < this.p; i2++) {
            if2 if2Var = this.q[i2];
            int i3 = if2Var.b;
            if (i3 != Integer.MIN_VALUE) {
                if2Var.b = i3 + i;
            }
            int i4 = if2Var.c;
            if (i4 != Integer.MIN_VALUE) {
                if2Var.c = i4 + i;
            }
        }
    }

    public final int S0(int i) {
        int i2 = this.q[0].i(i);
        for (int i3 = 1; i3 < this.p; i3++) {
            int i4 = this.q[i3].i(i);
            if (i4 > i2) {
                i2 = i4;
            }
        }
        return i2;
    }

    @Override // defpackage.ag3
    public final void T(int i) {
        super.T(i);
        for (int i2 = 0; i2 < this.p; i2++) {
            if2 if2Var = this.q[i2];
            int i3 = if2Var.b;
            if (i3 != Integer.MIN_VALUE) {
                if2Var.b = i3 + i;
            }
            int i4 = if2Var.c;
            if (i4 != Integer.MIN_VALUE) {
                if2Var.c = i4 + i;
            }
        }
    }

    public final int T0(int i) {
        int iK = this.q[0].k(i);
        for (int i2 = 1; i2 < this.p; i2++) {
            int iK2 = this.q[i2].k(i);
            if (iK2 < iK) {
                iK = iK2;
            }
        }
        return iK;
    }

    @Override // defpackage.ag3
    public final void U() {
        this.B.s();
        for (int i = 0; i < this.p; i++) {
            this.q[i].b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void U0(int r11, int r12, int r13) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.U0(int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x002c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View V0() {
        /*
            Method dump skipped, instruction units count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.V0():android.view.View");
    }

    @Override // defpackage.ag3
    public final void W(RecyclerView recyclerView, ig3 ig3Var) {
        RecyclerView recyclerView2 = this.b;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(this.K);
        }
        for (int i = 0; i < this.p; i++) {
            this.q[i].b();
        }
        recyclerView.requestLayout();
    }

    public final boolean W0() {
        return this.b.getLayoutDirection() == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x004f  */
    @Override // defpackage.ag3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View X(android.view.View r9, int r10, defpackage.ig3 r11, defpackage.ng3 r12) {
        /*
            Method dump skipped, instruction units count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.X(android.view.View, int, ig3, ng3):android.view.View");
    }

    public final void X0(View view, int i, int i2) {
        RecyclerView recyclerView = this.b;
        Rect rect = this.G;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(recyclerView.Q(view));
        }
        v14 v14Var = (v14) view.getLayoutParams();
        int iK1 = k1(i, ((ViewGroup.MarginLayoutParams) v14Var).leftMargin + rect.left, ((ViewGroup.MarginLayoutParams) v14Var).rightMargin + rect.right);
        int iK12 = k1(i2, ((ViewGroup.MarginLayoutParams) v14Var).topMargin + rect.top, ((ViewGroup.MarginLayoutParams) v14Var).bottomMargin + rect.bottom);
        if (D0(view, iK1, iK12, v14Var)) {
            view.measure(iK1, iK12);
        }
    }

    @Override // defpackage.ag3
    public final void Y(AccessibilityEvent accessibilityEvent) {
        super.Y(accessibilityEvent);
        if (v() > 0) {
            View viewN0 = N0(false);
            View viewM0 = M0(false);
            if (viewN0 == null || viewM0 == null) {
                return;
            }
            int iK = ag3.K(viewN0);
            int iK2 = ag3.K(viewM0);
            if (iK < iK2) {
                accessibilityEvent.setFromIndex(iK);
                accessibilityEvent.setToIndex(iK2);
            } else {
                accessibilityEvent.setFromIndex(iK2);
                accessibilityEvent.setToIndex(iK);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x03eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Y0(defpackage.ig3 r17, defpackage.ng3 r18, boolean r19) {
        /*
            Method dump skipped, instruction units count: 1030
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.Y0(ig3, ng3, boolean):void");
    }

    @Override // defpackage.ag3
    public final void Z(ig3 ig3Var, ng3 ng3Var, p2 p2Var) {
        super.Z(ig3Var, ng3Var, p2Var);
        p2Var.j("androidx.recyclerview.widget.StaggeredGridLayoutManager");
    }

    public final boolean Z0(int i) {
        if (this.t == 0) {
            return (i == -1) != this.x;
        }
        return ((i == -1) == this.x) == W0();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000c  */
    @Override // defpackage.mg3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.PointF a(int r4) {
        /*
            r3 = this;
            int r0 = r3.v()
            r1 = -1
            r2 = 1
            if (r0 != 0) goto Le
            boolean r4 = r3.x
            if (r4 == 0) goto L1b
        Lc:
            r1 = r2
            goto L1b
        Le:
            int r0 = r3.Q0()
            if (r4 >= r0) goto L16
            r4 = r2
            goto L17
        L16:
            r4 = 0
        L17:
            boolean r0 = r3.x
            if (r4 == r0) goto Lc
        L1b:
            android.graphics.PointF r4 = new android.graphics.PointF
            r4.<init>()
            if (r1 != 0) goto L24
            r3 = 0
            return r3
        L24:
            int r3 = r3.t
            r0 = 0
            if (r3 != 0) goto L2f
            float r3 = (float) r1
            r4.x = r3
            r4.y = r0
            return r4
        L2f:
            r4.x = r0
            float r3 = (float) r1
            r4.y = r3
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.a(int):android.graphics.PointF");
    }

    @Override // defpackage.ag3
    public final void a0(ig3 ig3Var, ng3 ng3Var, View view, p2 p2Var) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof v14)) {
            b0(view, p2Var);
            return;
        }
        if2 if2Var = ((v14) layoutParams).e;
        if (this.t == 0) {
            p2Var.k(o2.a(if2Var != null ? if2Var.e : -1, 1, -1, false, -1, false));
        } else {
            p2Var.k(o2.a(-1, -1, if2Var != null ? if2Var.e : -1, false, 1, false));
        }
    }

    public final void a1(int i, ng3 ng3Var) {
        int iQ0;
        int i2;
        if (i > 0) {
            iQ0 = R0();
            i2 = 1;
        } else {
            iQ0 = Q0();
            i2 = -1;
        }
        x82 x82Var = this.v;
        x82Var.a = true;
        i1(iQ0, ng3Var);
        g1(i2);
        x82Var.c = iQ0 + x82Var.d;
        x82Var.b = Math.abs(i);
    }

    public final void b1(ig3 ig3Var, x82 x82Var) {
        if (!x82Var.a || x82Var.i) {
            return;
        }
        int i = x82Var.b;
        int i2 = x82Var.e;
        if (i == 0) {
            if (i2 == -1) {
                c1(ig3Var, x82Var.g);
                return;
            } else {
                d1(ig3Var, x82Var.f);
                return;
            }
        }
        int i3 = 1;
        if (i2 == -1) {
            int i4 = x82Var.f;
            int iK = this.q[0].k(i4);
            while (i3 < this.p) {
                int iK2 = this.q[i3].k(i4);
                if (iK2 > iK) {
                    iK = iK2;
                }
                i3++;
            }
            int i5 = i4 - iK;
            int iMin = x82Var.g;
            if (i5 >= 0) {
                iMin -= Math.min(i5, x82Var.b);
            }
            c1(ig3Var, iMin);
            return;
        }
        int i6 = x82Var.g;
        int i7 = this.q[0].i(i6);
        while (i3 < this.p) {
            int i8 = this.q[i3].i(i6);
            if (i8 < i7) {
                i7 = i8;
            }
            i3++;
        }
        int i9 = i7 - x82Var.g;
        int iMin2 = x82Var.f;
        if (i9 >= 0) {
            iMin2 += Math.min(i9, x82Var.b);
        }
        d1(ig3Var, iMin2);
    }

    @Override // defpackage.ag3
    public final void c(String str) {
        if (this.F == null) {
            super.c(str);
        }
    }

    public final void c1(ig3 ig3Var, int i) {
        for (int iV = v() - 1; iV >= 0; iV--) {
            View viewU = u(iV);
            h31 h31Var = this.r;
            if (h31Var.g(viewU) < i || h31Var.p(viewU) < i) {
                return;
            }
            v14 v14Var = (v14) viewU.getLayoutParams();
            v14Var.getClass();
            if (((ArrayList) v14Var.e.f).size() == 1) {
                return;
            }
            if2 if2Var = v14Var.e;
            ArrayList arrayList = (ArrayList) if2Var.f;
            int size = arrayList.size();
            View view = (View) arrayList.remove(size - 1);
            v14 v14Var2 = (v14) view.getLayoutParams();
            v14Var2.e = null;
            if (v14Var2.a.j() || v14Var2.a.m()) {
                if2Var.d -= ((StaggeredGridLayoutManager) if2Var.g).r.e(view);
            }
            if (size == 1) {
                if2Var.b = Integer.MIN_VALUE;
            }
            if2Var.c = Integer.MIN_VALUE;
            r0(viewU, ig3Var);
        }
    }

    @Override // defpackage.ag3
    public final boolean d() {
        return this.t == 0;
    }

    @Override // defpackage.ag3
    public final void d0(int i, int i2) {
        U0(i, i2, 1);
    }

    public final void d1(ig3 ig3Var, int i) {
        while (v() > 0) {
            View viewU = u(0);
            h31 h31Var = this.r;
            if (h31Var.d(viewU) > i || h31Var.o(viewU) > i) {
                return;
            }
            v14 v14Var = (v14) viewU.getLayoutParams();
            v14Var.getClass();
            if (((ArrayList) v14Var.e.f).size() == 1) {
                return;
            }
            if2 if2Var = v14Var.e;
            ArrayList arrayList = (ArrayList) if2Var.f;
            View view = (View) arrayList.remove(0);
            v14 v14Var2 = (v14) view.getLayoutParams();
            v14Var2.e = null;
            if (arrayList.size() == 0) {
                if2Var.c = Integer.MIN_VALUE;
            }
            if (v14Var2.a.j() || v14Var2.a.m()) {
                if2Var.d -= ((StaggeredGridLayoutManager) if2Var.g).r.e(view);
            }
            if2Var.b = Integer.MIN_VALUE;
            r0(viewU, ig3Var);
        }
    }

    @Override // defpackage.ag3
    public final boolean e() {
        return this.t == 1;
    }

    @Override // defpackage.ag3
    public final void e0() {
        this.B.s();
        u0();
    }

    public final void e1() {
        if (this.t == 1 || !W0()) {
            this.x = this.w;
        } else {
            this.x = !this.w;
        }
    }

    @Override // defpackage.ag3
    public final boolean f(bg3 bg3Var) {
        return bg3Var instanceof v14;
    }

    @Override // defpackage.ag3
    public final void f0(int i, int i2) {
        U0(i, i2, 8);
    }

    public final int f1(int i, ig3 ig3Var, ng3 ng3Var) {
        if (v() == 0 || i == 0) {
            return 0;
        }
        a1(i, ng3Var);
        x82 x82Var = this.v;
        int iL0 = L0(ig3Var, x82Var, ng3Var);
        if (x82Var.b >= iL0) {
            i = i < 0 ? -iL0 : iL0;
        }
        this.r.q(-i);
        this.D = this.x;
        x82Var.b = 0;
        b1(ig3Var, x82Var);
        return i;
    }

    @Override // defpackage.ag3
    public final void g0(int i, int i2) {
        U0(i, i2, 2);
    }

    public final void g1(int i) {
        x82 x82Var = this.v;
        x82Var.e = i;
        x82Var.d = this.x != (i == -1) ? -1 : 1;
    }

    @Override // defpackage.ag3
    public final void h(int i, int i2, ng3 ng3Var, r02 r02Var) {
        x82 x82Var;
        int i3;
        int iK;
        if (this.t != 0) {
            i = i2;
        }
        if (v() == 0 || i == 0) {
            return;
        }
        a1(i, ng3Var);
        int[] iArr = this.J;
        if (iArr == null || iArr.length < this.p) {
            this.J = new int[this.p];
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = this.p;
            x82Var = this.v;
            if (i4 >= i6) {
                break;
            }
            if (x82Var.d == -1) {
                i3 = x82Var.f;
                iK = this.q[i4].k(i3);
            } else {
                i3 = this.q[i4].i(x82Var.g);
                iK = x82Var.g;
            }
            int i7 = i3 - iK;
            if (i7 >= 0) {
                this.J[i5] = i7;
                i5++;
            }
            i4++;
        }
        Arrays.sort(this.J, 0, i5);
        for (int i8 = 0; i8 < i5; i8++) {
            int i9 = x82Var.c;
            if (i9 < 0 || i9 >= ng3Var.b()) {
                return;
            }
            r02Var.b(x82Var.c, this.J[i8]);
            x82Var.c += x82Var.d;
        }
    }

    @Override // defpackage.ag3
    public final void h0(int i, int i2) {
        U0(i, i2, 4);
    }

    public final void h1(int i) {
        c(null);
        if (i != this.p) {
            this.B.s();
            u0();
            this.p = i;
            this.y = new BitSet(this.p);
            this.q = new if2[this.p];
            for (int i2 = 0; i2 < this.p; i2++) {
                this.q[i2] = new if2(this, i2);
            }
            u0();
        }
    }

    @Override // defpackage.ag3
    public final void i0(ig3 ig3Var, ng3 ng3Var) {
        Y0(ig3Var, ng3Var, true);
    }

    public final void i1(int i, ng3 ng3Var) {
        int iN;
        int iN2;
        int i2;
        x82 x82Var = this.v;
        boolean z = false;
        x82Var.b = 0;
        x82Var.c = i;
        fb2 fb2Var = this.e;
        h31 h31Var = this.r;
        if (fb2Var == null || !fb2Var.e || (i2 = ng3Var.a) == -1) {
            iN = 0;
            iN2 = 0;
        } else {
            if (this.x == (i2 < i)) {
                iN = h31Var.n();
                iN2 = 0;
            } else {
                iN2 = h31Var.n();
                iN = 0;
            }
        }
        RecyclerView recyclerView = this.b;
        if (recyclerView == null || !recyclerView.B0) {
            x82Var.g = h31Var.h() + iN;
            x82Var.f = -iN2;
        } else {
            x82Var.f = h31Var.m() - iN2;
            x82Var.g = h31Var.i() + iN;
        }
        x82Var.h = false;
        x82Var.a = true;
        if (h31Var.k() == 0 && h31Var.h() == 0) {
            z = true;
        }
        x82Var.i = z;
    }

    @Override // defpackage.ag3
    public final int j(ng3 ng3Var) {
        if (v() == 0) {
            return 0;
        }
        boolean z = !this.I;
        return ji0.d(ng3Var, this.r, N0(z), M0(z), this, this.I);
    }

    @Override // defpackage.ag3
    public final void j0(ng3 ng3Var) {
        this.z = -1;
        this.A = Integer.MIN_VALUE;
        this.F = null;
        this.H.a();
    }

    public final void j1(if2 if2Var, int i, int i2) {
        int i3 = if2Var.d;
        int i4 = if2Var.e;
        if (i != -1) {
            int i5 = if2Var.c;
            if (i5 == Integer.MIN_VALUE) {
                if2Var.a();
                i5 = if2Var.c;
            }
            if (i5 - i3 >= i2) {
                this.y.set(i4, false);
                return;
            }
            return;
        }
        int i6 = if2Var.b;
        if (i6 == Integer.MIN_VALUE) {
            View view = (View) ((ArrayList) if2Var.f).get(0);
            v14 v14Var = (v14) view.getLayoutParams();
            if2Var.b = ((StaggeredGridLayoutManager) if2Var.g).r.g(view);
            v14Var.getClass();
            i6 = if2Var.b;
        }
        if (i6 + i3 <= i2) {
            this.y.set(i4, false);
        }
    }

    @Override // defpackage.ag3
    public final int k(ng3 ng3Var) {
        return K0(ng3Var);
    }

    @Override // defpackage.ag3
    public final void k0(Parcelable parcelable) {
        if (parcelable instanceof x14) {
            x14 x14Var = (x14) parcelable;
            this.F = x14Var;
            if (this.z != -1) {
                x14Var.b = -1;
                x14Var.f = -1;
                x14Var.A = null;
                x14Var.z = 0;
                x14Var.X = 0;
                x14Var.Y = null;
                x14Var.Z = null;
            }
            u0();
        }
    }

    @Override // defpackage.ag3
    public final int l(ng3 ng3Var) {
        if (v() == 0) {
            return 0;
        }
        boolean z = !this.I;
        return ji0.f(ng3Var, this.r, N0(z), M0(z), this, this.I);
    }

    @Override // defpackage.ag3
    public final Parcelable l0() {
        int iK;
        int iM;
        int[] iArr;
        x14 x14Var = this.F;
        if (x14Var != null) {
            x14 x14Var2 = new x14();
            x14Var2.z = x14Var.z;
            x14Var2.b = x14Var.b;
            x14Var2.f = x14Var.f;
            x14Var2.A = x14Var.A;
            x14Var2.X = x14Var.X;
            x14Var2.Y = x14Var.Y;
            x14Var2.y0 = x14Var.y0;
            x14Var2.z0 = x14Var.z0;
            x14Var2.A0 = x14Var.A0;
            x14Var2.Z = x14Var.Z;
            return x14Var2;
        }
        x14 x14Var3 = new x14();
        x14Var3.y0 = this.w;
        x14Var3.z0 = this.D;
        x14Var3.A0 = this.E;
        v62 v62Var = this.B;
        if (v62Var == null || (iArr = (int[]) v62Var.f) == null) {
            x14Var3.X = 0;
        } else {
            x14Var3.Y = iArr;
            x14Var3.X = iArr.length;
            x14Var3.Z = (ArrayList) v62Var.z;
        }
        if (v() <= 0) {
            x14Var3.b = -1;
            x14Var3.f = -1;
            x14Var3.z = 0;
            return x14Var3;
        }
        x14Var3.b = this.D ? R0() : Q0();
        View viewM0 = this.x ? M0(true) : N0(true);
        x14Var3.f = viewM0 != null ? ag3.K(viewM0) : -1;
        int i = this.p;
        x14Var3.z = i;
        x14Var3.A = new int[i];
        for (int i2 = 0; i2 < this.p; i2++) {
            boolean z = this.D;
            if2[] if2VarArr = this.q;
            h31 h31Var = this.r;
            if (z) {
                iK = if2VarArr[i2].i(Integer.MIN_VALUE);
                if (iK != Integer.MIN_VALUE) {
                    iM = h31Var.i();
                    iK -= iM;
                }
            } else {
                iK = if2VarArr[i2].k(Integer.MIN_VALUE);
                if (iK != Integer.MIN_VALUE) {
                    iM = h31Var.m();
                    iK -= iM;
                }
            }
            x14Var3.A[i2] = iK;
        }
        return x14Var3;
    }

    @Override // defpackage.ag3
    public final int m(ng3 ng3Var) {
        if (v() == 0) {
            return 0;
        }
        boolean z = !this.I;
        return ji0.d(ng3Var, this.r, N0(z), M0(z), this, this.I);
    }

    @Override // defpackage.ag3
    public final void m0(int i) {
        if (i == 0) {
            J0();
        }
    }

    @Override // defpackage.ag3
    public final int n(ng3 ng3Var) {
        return K0(ng3Var);
    }

    @Override // defpackage.ag3
    public final int o(ng3 ng3Var) {
        if (v() == 0) {
            return 0;
        }
        boolean z = !this.I;
        return ji0.f(ng3Var, this.r, N0(z), M0(z), this, this.I);
    }

    @Override // defpackage.ag3
    public final bg3 r() {
        return this.t == 0 ? new v14(-2, -1) : new v14(-1, -2);
    }

    @Override // defpackage.ag3
    public final bg3 s(Context context, AttributeSet attributeSet) {
        return new v14(context, attributeSet);
    }

    @Override // defpackage.ag3
    public final bg3 t(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new v14((ViewGroup.MarginLayoutParams) layoutParams) : new v14(layoutParams);
    }

    @Override // defpackage.ag3
    public final int v0(int i, ig3 ig3Var, ng3 ng3Var) {
        return f1(i, ig3Var, ng3Var);
    }

    @Override // defpackage.ag3
    public final void w0(int i) {
        x14 x14Var = this.F;
        if (x14Var != null && x14Var.b != i) {
            x14Var.A = null;
            x14Var.z = 0;
            x14Var.b = -1;
            x14Var.f = -1;
        }
        this.z = i;
        this.A = Integer.MIN_VALUE;
        u0();
    }

    @Override // defpackage.ag3
    public final int x(ig3 ig3Var, ng3 ng3Var) {
        if (this.t == 1) {
            return Math.min(this.p, ng3Var.b());
        }
        return -1;
    }

    @Override // defpackage.ag3
    public final int x0(int i, ig3 ig3Var, ng3 ng3Var) {
        return f1(i, ig3Var, ng3Var);
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        this.p = -1;
        this.w = false;
        this.x = false;
        this.z = -1;
        this.A = Integer.MIN_VALUE;
        this.B = new v62(29, false);
        this.C = 2;
        this.G = new Rect();
        this.H = new u14(this);
        this.I = true;
        this.K = new f33(22, this);
        this.t = i2;
        h1(i);
        this.v = new x82();
        this.r = h31.b(this, this.t);
        this.s = h31.b(this, 1 - this.t);
    }
}
