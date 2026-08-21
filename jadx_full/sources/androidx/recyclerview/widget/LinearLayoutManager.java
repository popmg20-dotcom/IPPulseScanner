package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import defpackage.ab2;
import defpackage.ag3;
import defpackage.bb2;
import defpackage.bg3;
import defpackage.cb2;
import defpackage.db2;
import defpackage.dw2;
import defpackage.fb2;
import defpackage.h31;
import defpackage.i2;
import defpackage.ig3;
import defpackage.ji0;
import defpackage.mg3;
import defpackage.ng3;
import defpackage.p2;
import defpackage.r02;
import defpackage.rf3;
import defpackage.rg3;
import defpackage.xe;
import defpackage.zf3;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends ag3 implements mg3 {
    public db2 A;
    public final ab2 B;
    public final bb2 C;
    public final int D;
    public final int[] E;
    public int p;
    public cb2 q;
    public h31 r;
    public boolean s;
    public final boolean t;
    public boolean u;
    public boolean v;
    public final boolean w;
    public int x;
    public int y;
    public boolean z;

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.p = 1;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = true;
        this.x = -1;
        this.y = Integer.MIN_VALUE;
        this.A = null;
        this.B = new ab2();
        this.C = new bb2();
        this.D = 2;
        this.E = new int[2];
        zf3 zf3VarL = ag3.L(context, attributeSet, i, i2);
        i1(zf3VarL.a);
        boolean z = zf3VarL.c;
        c(null);
        if (z != this.t) {
            this.t = z;
            u0();
        }
        j1(zf3VarL.d);
    }

    @Override // defpackage.ag3
    public final boolean E0() {
        if (this.m != 1073741824 && this.l != 1073741824) {
            int iV = v();
            for (int i = 0; i < iV; i++) {
                ViewGroup.LayoutParams layoutParams = u(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // defpackage.ag3
    public final void G0(RecyclerView recyclerView, int i) {
        fb2 fb2Var = new fb2(recyclerView.getContext());
        fb2Var.a = i;
        H0(fb2Var);
    }

    @Override // defpackage.ag3
    public boolean I0() {
        return this.A == null && this.s == this.v;
    }

    public void J0(ng3 ng3Var, int[] iArr) {
        int i;
        int iN = ng3Var.a != -1 ? this.r.n() : 0;
        if (this.q.f == -1) {
            i = 0;
        } else {
            i = iN;
            iN = 0;
        }
        iArr[0] = iN;
        iArr[1] = i;
    }

    public void K0(ng3 ng3Var, cb2 cb2Var, r02 r02Var) {
        int i = cb2Var.d;
        if (i < 0 || i >= ng3Var.b()) {
            return;
        }
        r02Var.b(i, Math.max(0, cb2Var.g));
    }

    public final int L0(ng3 ng3Var) {
        if (v() == 0) {
            return 0;
        }
        P0();
        h31 h31Var = this.r;
        boolean z = !this.w;
        return ji0.d(ng3Var, h31Var, S0(z), R0(z), this, this.w);
    }

    public final int M0(ng3 ng3Var) {
        if (v() == 0) {
            return 0;
        }
        P0();
        h31 h31Var = this.r;
        boolean z = !this.w;
        return ji0.e(ng3Var, h31Var, S0(z), R0(z), this, this.w, this.u);
    }

    public final int N0(ng3 ng3Var) {
        if (v() == 0) {
            return 0;
        }
        P0();
        h31 h31Var = this.r;
        boolean z = !this.w;
        return ji0.f(ng3Var, h31Var, S0(z), R0(z), this, this.w);
    }

    @Override // defpackage.ag3
    public final boolean O() {
        return true;
    }

    public final int O0(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.p == 1) ? 1 : Integer.MIN_VALUE : this.p == 0 ? 1 : Integer.MIN_VALUE : this.p == 1 ? -1 : Integer.MIN_VALUE : this.p == 0 ? -1 : Integer.MIN_VALUE : (this.p != 1 && a1()) ? -1 : 1 : (this.p != 1 && a1()) ? 1 : -1;
    }

    @Override // defpackage.ag3
    public final boolean P() {
        return this.t;
    }

    public final void P0() {
        if (this.q == null) {
            cb2 cb2Var = new cb2();
            cb2Var.a = true;
            cb2Var.h = 0;
            cb2Var.i = 0;
            cb2Var.k = null;
            this.q = cb2Var;
        }
    }

    public final int Q0(ig3 ig3Var, cb2 cb2Var, ng3 ng3Var, boolean z) {
        int i;
        int i2 = cb2Var.c;
        int i3 = cb2Var.g;
        if (i3 != Integer.MIN_VALUE) {
            if (i2 < 0) {
                cb2Var.g = i3 + i2;
            }
            d1(ig3Var, cb2Var);
        }
        int i4 = cb2Var.c + cb2Var.h;
        while (true) {
            if ((!cb2Var.l && i4 <= 0) || (i = cb2Var.d) < 0 || i >= ng3Var.b()) {
                break;
            }
            bb2 bb2Var = this.C;
            bb2Var.a = 0;
            bb2Var.b = false;
            bb2Var.c = false;
            bb2Var.d = false;
            b1(ig3Var, ng3Var, cb2Var, bb2Var);
            if (!bb2Var.b) {
                int i5 = cb2Var.b;
                int i6 = bb2Var.a;
                cb2Var.b = (cb2Var.f * i6) + i5;
                if (!bb2Var.c || cb2Var.k != null || !ng3Var.g) {
                    cb2Var.c -= i6;
                    i4 -= i6;
                }
                int i7 = cb2Var.g;
                if (i7 != Integer.MIN_VALUE) {
                    int i8 = i7 + i6;
                    cb2Var.g = i8;
                    int i9 = cb2Var.c;
                    if (i9 < 0) {
                        cb2Var.g = i8 + i9;
                    }
                    d1(ig3Var, cb2Var);
                }
                if (z && bb2Var.d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i2 - cb2Var.c;
    }

    public final View R0(boolean z) {
        return this.u ? U0(0, v(), z, true) : U0(v() - 1, -1, z, true);
    }

    public final View S0(boolean z) {
        return this.u ? U0(v() - 1, -1, z, true) : U0(0, v(), z, true);
    }

    public final View T0(int i, int i2) {
        int i3;
        int i4;
        P0();
        if (i2 <= i && i2 >= i) {
            return u(i);
        }
        if (this.r.g(u(i)) < this.r.m()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        return this.p == 0 ? this.c.k(i, i2, i3, i4) : this.d.k(i, i2, i3, i4);
    }

    public final View U0(int i, int i2, boolean z, boolean z2) {
        P0();
        int i3 = z ? 24579 : 320;
        int i4 = z2 ? 320 : 0;
        return this.p == 0 ? this.c.k(i, i2, i3, i4) : this.d.k(i, i2, i3, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View V0(ig3 ig3Var, ng3 ng3Var, boolean z, boolean z2) {
        int i;
        int iV;
        int i2;
        P0();
        int iV2 = v();
        if (z2) {
            iV = v() - 1;
            i = -1;
            i2 = -1;
        } else {
            i = iV2;
            iV = 0;
            i2 = 1;
        }
        int iB = ng3Var.b();
        int iM = this.r.m();
        int i3 = this.r.i();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (iV != i) {
            View viewU = u(iV);
            int iK = ag3.K(viewU);
            int iG = this.r.g(viewU);
            int iD = this.r.d(viewU);
            if (iK >= 0 && iK < iB) {
                if (!((bg3) viewU.getLayoutParams()).a.j()) {
                    boolean z3 = iD <= iM && iG < iM;
                    boolean z4 = iG >= i3 && iD > i3;
                    if (!z3 && !z4) {
                        return viewU;
                    }
                    if (z) {
                        if (z4) {
                            view2 = viewU;
                        } else if (view == null) {
                            view = viewU;
                        }
                    } else if (!z3) {
                        if (view == null) {
                        }
                    }
                } else if (view3 == null) {
                    view3 = viewU;
                }
            }
            iV += i2;
        }
        return view != null ? view : view2 != null ? view2 : view3;
    }

    @Override // defpackage.ag3
    public final void W(RecyclerView recyclerView, ig3 ig3Var) {
        if (this.z) {
            p0(ig3Var);
            ig3Var.a.clear();
            ig3Var.g();
        }
    }

    public final int W0(int i, ig3 ig3Var, ng3 ng3Var, boolean z) {
        int i2;
        int i3 = this.r.i() - i;
        if (i3 <= 0) {
            return 0;
        }
        int i4 = -g1(-i3, ig3Var, ng3Var);
        int i5 = i + i4;
        if (!z || (i2 = this.r.i() - i5) <= 0) {
            return i4;
        }
        this.r.q(i2);
        return i2 + i4;
    }

    @Override // defpackage.ag3
    public View X(View view, int i, ig3 ig3Var, ng3 ng3Var) {
        int iO0;
        f1();
        if (v() != 0 && (iO0 = O0(i)) != Integer.MIN_VALUE) {
            P0();
            k1(iO0, (int) (this.r.n() * 0.33333334f), false, ng3Var);
            cb2 cb2Var = this.q;
            cb2Var.g = Integer.MIN_VALUE;
            cb2Var.a = false;
            Q0(ig3Var, cb2Var, ng3Var, true);
            boolean z = this.u;
            View viewT0 = iO0 == -1 ? z ? T0(v() - 1, -1) : T0(0, v()) : z ? T0(0, v()) : T0(v() - 1, -1);
            View viewZ0 = iO0 == -1 ? Z0() : Y0();
            if (!viewZ0.hasFocusable()) {
                return viewT0;
            }
            if (viewT0 != null) {
                return viewZ0;
            }
        }
        return null;
    }

    public final int X0(int i, ig3 ig3Var, ng3 ng3Var, boolean z) {
        int iM;
        int iM2 = i - this.r.m();
        if (iM2 <= 0) {
            return 0;
        }
        int i2 = -g1(iM2, ig3Var, ng3Var);
        int i3 = i + i2;
        if (!z || (iM = i3 - this.r.m()) <= 0) {
            return i2;
        }
        this.r.q(-iM);
        return i2 - iM;
    }

    @Override // defpackage.ag3
    public final void Y(AccessibilityEvent accessibilityEvent) {
        super.Y(accessibilityEvent);
        if (v() > 0) {
            View viewU0 = U0(0, v(), false, true);
            accessibilityEvent.setFromIndex(viewU0 == null ? -1 : ag3.K(viewU0));
            View viewU02 = U0(v() - 1, -1, false, true);
            accessibilityEvent.setToIndex(viewU02 != null ? ag3.K(viewU02) : -1);
        }
    }

    public final View Y0() {
        return u(this.u ? 0 : v() - 1);
    }

    @Override // defpackage.ag3
    public void Z(ig3 ig3Var, ng3 ng3Var, p2 p2Var) {
        super.Z(ig3Var, ng3Var, p2Var);
        rf3 rf3Var = this.b.G0;
        if (rf3Var == null || rf3Var.b() <= 0) {
            return;
        }
        p2Var.b(i2.j);
    }

    public final View Z0() {
        return u(this.u ? v() - 1 : 0);
    }

    @Override // defpackage.mg3
    public final PointF a(int i) {
        if (v() == 0) {
            return null;
        }
        int i2 = (i < ag3.K(u(0))) != this.u ? -1 : 1;
        return this.p == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    public final boolean a1() {
        return this.b.getLayoutDirection() == 1;
    }

    public void b1(ig3 ig3Var, ng3 ng3Var, cb2 cb2Var, bb2 bb2Var) {
        int i;
        int iF;
        int i2;
        int iF2;
        View viewB = cb2Var.b(ig3Var);
        if (viewB == null) {
            bb2Var.b = true;
            return;
        }
        bg3 bg3Var = (bg3) viewB.getLayoutParams();
        List list = cb2Var.k;
        boolean z = this.u;
        int i3 = cb2Var.f;
        if (list == null) {
            if (z == (i3 == -1)) {
                b(viewB, -1, false);
            } else {
                b(viewB, 0, false);
            }
        } else {
            if (z == (i3 == -1)) {
                b(viewB, -1, true);
            } else {
                b(viewB, 0, true);
            }
        }
        bg3 bg3Var2 = (bg3) viewB.getLayoutParams();
        Rect rectQ = this.b.Q(viewB);
        int i4 = rectQ.left + rectQ.right;
        int i5 = rectQ.top + rectQ.bottom;
        int iW = ag3.w(this.n, this.l, I() + H() + ((ViewGroup.MarginLayoutParams) bg3Var2).leftMargin + ((ViewGroup.MarginLayoutParams) bg3Var2).rightMargin + i4, d(), ((ViewGroup.MarginLayoutParams) bg3Var2).width);
        int iW2 = ag3.w(this.o, this.m, G() + J() + ((ViewGroup.MarginLayoutParams) bg3Var2).topMargin + ((ViewGroup.MarginLayoutParams) bg3Var2).bottomMargin + i5, e(), ((ViewGroup.MarginLayoutParams) bg3Var2).height);
        if (D0(viewB, iW, iW2, bg3Var2)) {
            viewB.measure(iW, iW2);
        }
        bb2Var.a = this.r.e(viewB);
        if (this.p == 1) {
            if (a1()) {
                iF2 = this.n - I();
                iF = iF2 - this.r.f(viewB);
            } else {
                int iH = H();
                iF2 = this.r.f(viewB) + iH;
                iF = iH;
            }
            int i6 = cb2Var.f;
            i2 = cb2Var.b;
            int i7 = bb2Var.a;
            if (i6 == -1) {
                int i8 = i2 - i7;
                i = i2;
                i2 = i8;
            } else {
                i = i7 + i2;
            }
        } else {
            int iJ = J();
            int iF3 = this.r.f(viewB) + iJ;
            int i9 = cb2Var.f;
            int i10 = cb2Var.b;
            int i11 = bb2Var.a;
            if (i9 == -1) {
                int i12 = i10 - i11;
                iF2 = i10;
                i2 = iJ;
                i = iF3;
                iF = i12;
            } else {
                int i13 = i10 + i11;
                i = iF3;
                iF = i10;
                i2 = iJ;
                iF2 = i13;
            }
        }
        ag3.R(viewB, iF, i2, iF2, i);
        if (bg3Var.a.j() || bg3Var.a.m()) {
            bb2Var.c = true;
        }
        bb2Var.d = viewB.hasFocusable();
    }

    @Override // defpackage.ag3
    public final void c(String str) {
        if (this.A == null) {
            super.c(str);
        }
    }

    @Override // defpackage.ag3
    public final boolean d() {
        return this.p == 0;
    }

    public final void d1(ig3 ig3Var, cb2 cb2Var) {
        if (!cb2Var.a || cb2Var.l) {
            return;
        }
        int i = cb2Var.g;
        int i2 = cb2Var.i;
        if (cb2Var.f == -1) {
            int iV = v();
            if (i < 0) {
                return;
            }
            int iH = (this.r.h() - i) + i2;
            if (this.u) {
                for (int i3 = 0; i3 < iV; i3++) {
                    View viewU = u(i3);
                    if (this.r.g(viewU) < iH || this.r.p(viewU) < iH) {
                        e1(ig3Var, 0, i3);
                        return;
                    }
                }
                return;
            }
            int i4 = iV - 1;
            for (int i5 = i4; i5 >= 0; i5--) {
                View viewU2 = u(i5);
                if (this.r.g(viewU2) < iH || this.r.p(viewU2) < iH) {
                    e1(ig3Var, i4, i5);
                    return;
                }
            }
            return;
        }
        if (i < 0) {
            return;
        }
        int i6 = i - i2;
        int iV2 = v();
        if (!this.u) {
            for (int i7 = 0; i7 < iV2; i7++) {
                View viewU3 = u(i7);
                if (this.r.d(viewU3) > i6 || this.r.o(viewU3) > i6) {
                    e1(ig3Var, 0, i7);
                    return;
                }
            }
            return;
        }
        int i8 = iV2 - 1;
        for (int i9 = i8; i9 >= 0; i9--) {
            View viewU4 = u(i9);
            if (this.r.d(viewU4) > i6 || this.r.o(viewU4) > i6) {
                e1(ig3Var, i8, i9);
                return;
            }
        }
    }

    @Override // defpackage.ag3
    public final boolean e() {
        return this.p == 1;
    }

    public final void e1(ig3 ig3Var, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                View viewU = u(i);
                s0(i);
                ig3Var.i(viewU);
                i--;
            }
            return;
        }
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            View viewU2 = u(i3);
            s0(i3);
            ig3Var.i(viewU2);
        }
    }

    public final void f1() {
        if (this.p == 1 || !a1()) {
            this.u = this.t;
        } else {
            this.u = !this.t;
        }
    }

    public final int g1(int i, ig3 ig3Var, ng3 ng3Var) {
        if (v() != 0 && i != 0) {
            P0();
            this.q.a = true;
            int i2 = i > 0 ? 1 : -1;
            int iAbs = Math.abs(i);
            k1(i2, iAbs, true, ng3Var);
            cb2 cb2Var = this.q;
            int iQ0 = Q0(ig3Var, cb2Var, ng3Var, false) + cb2Var.g;
            if (iQ0 >= 0) {
                if (iAbs > iQ0) {
                    i = i2 * iQ0;
                }
                this.r.q(-i);
                this.q.j = i;
                return i;
            }
        }
        return 0;
    }

    @Override // defpackage.ag3
    public final void h(int i, int i2, ng3 ng3Var, r02 r02Var) {
        if (this.p != 0) {
            i = i2;
        }
        if (v() == 0 || i == 0) {
            return;
        }
        P0();
        k1(i > 0 ? 1 : -1, Math.abs(i), true, ng3Var);
        K0(ng3Var, this.q, r02Var);
    }

    public final void h1(int i, int i2) {
        this.x = i;
        this.y = i2;
        db2 db2Var = this.A;
        if (db2Var != null) {
            db2Var.b = -1;
        }
        u0();
    }

    @Override // defpackage.ag3
    public final void i(int i, r02 r02Var) {
        boolean z;
        int i2;
        db2 db2Var = this.A;
        if (db2Var == null || (i2 = db2Var.b) < 0) {
            f1();
            z = this.u;
            i2 = this.x;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        } else {
            z = db2Var.z;
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.D && i2 >= 0 && i2 < i; i4++) {
            r02Var.b(i2, 0);
            i2 += i3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x018c  */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v14 */
    @Override // defpackage.ag3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i0(ig3 ig3Var, ng3 ng3Var) {
        View focusedChild;
        View focusedChild2;
        View viewV0;
        int i;
        int iG;
        int i2;
        int i3;
        ?? r4;
        List list;
        int i4;
        int i5;
        int iW0;
        int i6;
        View viewQ;
        int iG2;
        int i7;
        int i8;
        int i9 = -1;
        if (!(this.A == null && this.x == -1) && ng3Var.b() == 0) {
            p0(ig3Var);
            return;
        }
        db2 db2Var = this.A;
        if (db2Var != null && (i8 = db2Var.b) >= 0) {
            this.x = i8;
        }
        P0();
        boolean z = false;
        this.q.a = false;
        f1();
        RecyclerView recyclerView = this.b;
        if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || ((ArrayList) this.a.e).contains(focusedChild)) {
            focusedChild = null;
        }
        ab2 ab2Var = this.B;
        if (!ab2Var.e || this.x != -1 || this.A != null) {
            ab2Var.c();
            ab2Var.d = this.u ^ this.v;
            if (ng3Var.g || (i = this.x) == -1) {
                if (v() != 0) {
                    RecyclerView recyclerView2 = this.b;
                    if (recyclerView2 == null || (focusedChild2 = recyclerView2.getFocusedChild()) == null || ((ArrayList) this.a.e).contains(focusedChild2)) {
                        focusedChild2 = null;
                    }
                    if (focusedChild2 != null) {
                        bg3 bg3Var = (bg3) focusedChild2.getLayoutParams();
                        if (bg3Var.a.j() || bg3Var.a.d() < 0 || bg3Var.a.d() >= ng3Var.b()) {
                            boolean z2 = this.s;
                            boolean z3 = this.v;
                            if (z2 == z3 && (viewV0 = V0(ig3Var, ng3Var, ab2Var.d, z3)) != null) {
                                int iK = ag3.K(viewV0);
                                boolean z4 = ab2Var.d;
                                h31 h31Var = ab2Var.a;
                                if (z4) {
                                    int iD = h31Var.d(viewV0);
                                    h31 h31Var2 = ab2Var.a;
                                    ab2Var.c = (Integer.MIN_VALUE == h31Var2.a ? 0 : h31Var2.n() - h31Var2.a) + iD;
                                } else {
                                    ab2Var.c = h31Var.g(viewV0);
                                }
                                ab2Var.b = iK;
                                if (!ng3Var.g && I0()) {
                                    int iG3 = this.r.g(viewV0);
                                    int iD2 = this.r.d(viewV0);
                                    int iM = this.r.m();
                                    int i10 = this.r.i();
                                    boolean z5 = iD2 <= iM && iG3 < iM;
                                    boolean z6 = iG3 >= i10 && iD2 > i10;
                                    if (z5 || z6) {
                                        if (ab2Var.d) {
                                            iM = i10;
                                        }
                                        ab2Var.c = iM;
                                    }
                                }
                            } else {
                                ab2Var.a();
                                ab2Var.b = this.v ? ng3Var.b() - 1 : 0;
                            }
                        } else {
                            ab2Var.b(focusedChild2, ag3.K(focusedChild2));
                        }
                        ab2Var.e = true;
                    }
                }
            } else if (i < 0 || i >= ng3Var.b()) {
                this.x = -1;
                this.y = Integer.MIN_VALUE;
                if (v() != 0) {
                }
            } else {
                int i11 = this.x;
                ab2Var.b = i11;
                db2 db2Var2 = this.A;
                if (db2Var2 != null && db2Var2.b >= 0) {
                    boolean z7 = db2Var2.z;
                    ab2Var.d = z7;
                    h31 h31Var3 = this.r;
                    if (z7) {
                        ab2Var.c = h31Var3.i() - this.A.f;
                    } else {
                        ab2Var.c = h31Var3.m() + this.A.f;
                    }
                } else if (this.y == Integer.MIN_VALUE) {
                    View viewQ2 = q(i11);
                    if (viewQ2 == null) {
                        if (v() > 0) {
                            ab2Var.d = (this.x < ag3.K(u(0))) == this.u;
                        }
                        ab2Var.a();
                    } else if (this.r.e(viewQ2) > this.r.n()) {
                        ab2Var.a();
                    } else {
                        int iG4 = this.r.g(viewQ2) - this.r.m();
                        h31 h31Var4 = this.r;
                        if (iG4 < 0) {
                            ab2Var.c = h31Var4.m();
                            ab2Var.d = false;
                        } else if (h31Var4.i() - this.r.d(viewQ2) < 0) {
                            ab2Var.c = this.r.i();
                            ab2Var.d = true;
                        } else {
                            boolean z8 = ab2Var.d;
                            h31 h31Var5 = this.r;
                            if (z8) {
                                int iD3 = h31Var5.d(viewQ2);
                                h31 h31Var6 = this.r;
                                iG = (Integer.MIN_VALUE == h31Var6.a ? 0 : h31Var6.n() - h31Var6.a) + iD3;
                            } else {
                                iG = h31Var5.g(viewQ2);
                            }
                            ab2Var.c = iG;
                        }
                    }
                } else {
                    boolean z9 = this.u;
                    ab2Var.d = z9;
                    h31 h31Var7 = this.r;
                    if (z9) {
                        ab2Var.c = h31Var7.i() - this.y;
                    } else {
                        ab2Var.c = h31Var7.m() + this.y;
                    }
                }
                ab2Var.e = true;
            }
        } else if (focusedChild != null && (this.r.g(focusedChild) >= this.r.i() || this.r.d(focusedChild) <= this.r.m())) {
            ab2Var.b(focusedChild, ag3.K(focusedChild));
        }
        cb2 cb2Var = this.q;
        cb2Var.f = cb2Var.j >= 0 ? 1 : -1;
        int[] iArr = this.E;
        iArr[0] = 0;
        iArr[1] = 0;
        J0(ng3Var, iArr);
        int iM2 = this.r.m() + Math.max(0, iArr[0]);
        int iJ = this.r.j() + Math.max(0, iArr[1]);
        if (ng3Var.g && (i6 = this.x) != -1 && this.y != Integer.MIN_VALUE && (viewQ = q(i6)) != null) {
            boolean z10 = this.u;
            h31 h31Var8 = this.r;
            if (z10) {
                i7 = h31Var8.i() - this.r.d(viewQ);
                iG2 = this.y;
            } else {
                iG2 = h31Var8.g(viewQ) - this.r.m();
                i7 = this.y;
            }
            int i12 = i7 - iG2;
            if (i12 > 0) {
                iM2 += i12;
            } else {
                iJ -= i12;
            }
        }
        boolean z11 = ab2Var.d;
        boolean z12 = this.u;
        if (!z11 ? !z12 : z12) {
            i9 = 1;
        }
        c1(ig3Var, ng3Var, ab2Var, i9);
        p(ig3Var);
        this.q.l = this.r.k() == 0 && this.r.h() == 0;
        this.q.getClass();
        this.q.i = 0;
        boolean z13 = ab2Var.d;
        int i13 = ab2Var.b;
        if (z13) {
            m1(i13, ab2Var.c);
            cb2 cb2Var2 = this.q;
            cb2Var2.h = iM2;
            Q0(ig3Var, cb2Var2, ng3Var, false);
            cb2 cb2Var3 = this.q;
            i3 = cb2Var3.b;
            int i14 = cb2Var3.d;
            int i15 = cb2Var3.c;
            if (i15 > 0) {
                iJ += i15;
            }
            l1(ab2Var.b, ab2Var.c);
            cb2 cb2Var4 = this.q;
            cb2Var4.h = iJ;
            cb2Var4.d += cb2Var4.e;
            Q0(ig3Var, cb2Var4, ng3Var, false);
            cb2 cb2Var5 = this.q;
            i2 = cb2Var5.b;
            int i16 = cb2Var5.c;
            if (i16 > 0) {
                m1(i14, i3);
                cb2 cb2Var6 = this.q;
                cb2Var6.h = i16;
                Q0(ig3Var, cb2Var6, ng3Var, false);
                i3 = this.q.b;
            }
        } else {
            l1(i13, ab2Var.c);
            cb2 cb2Var7 = this.q;
            cb2Var7.h = iJ;
            Q0(ig3Var, cb2Var7, ng3Var, false);
            cb2 cb2Var8 = this.q;
            i2 = cb2Var8.b;
            int i17 = cb2Var8.d;
            int i18 = cb2Var8.c;
            if (i18 > 0) {
                iM2 += i18;
            }
            m1(ab2Var.b, ab2Var.c);
            cb2 cb2Var9 = this.q;
            cb2Var9.h = iM2;
            cb2Var9.d += cb2Var9.e;
            Q0(ig3Var, cb2Var9, ng3Var, false);
            cb2 cb2Var10 = this.q;
            int i19 = cb2Var10.b;
            int i20 = cb2Var10.c;
            if (i20 > 0) {
                l1(i17, i2);
                cb2 cb2Var11 = this.q;
                cb2Var11.h = i20;
                Q0(ig3Var, cb2Var11, ng3Var, false);
                i2 = this.q.b;
            }
            i3 = i19;
        }
        if (v() > 0) {
            if (this.u ^ this.v) {
                int iW02 = W0(i2, ig3Var, ng3Var, true);
                i4 = i3 + iW02;
                i5 = i2 + iW02;
                iW0 = X0(i4, ig3Var, ng3Var, false);
            } else {
                int iX0 = X0(i3, ig3Var, ng3Var, true);
                i4 = i3 + iX0;
                i5 = i2 + iX0;
                iW0 = W0(i5, ig3Var, ng3Var, false);
            }
            i3 = i4 + iW0;
            i2 = i5 + iW0;
        }
        if (ng3Var.k && v() != 0 && !ng3Var.g && I0()) {
            List list2 = ig3Var.d;
            int size = list2.size();
            int iK2 = ag3.K(u(0));
            int i21 = 0;
            int iE = 0;
            int iE2 = 0;
            while (i21 < size) {
                rg3 rg3Var = (rg3) list2.get(i21);
                boolean zJ = rg3Var.j();
                View view = rg3Var.a;
                if (!zJ) {
                    boolean z14 = rg3Var.d() < iK2 ? true : z;
                    boolean z15 = this.u;
                    h31 h31Var9 = this.r;
                    if (z14 != z15) {
                        iE += h31Var9.e(view);
                    } else {
                        iE2 += h31Var9.e(view);
                    }
                }
                i21++;
                z = false;
            }
            this.q.k = list2;
            if (iE > 0) {
                m1(ag3.K(Z0()), i3);
                cb2 cb2Var12 = this.q;
                cb2Var12.h = iE;
                r4 = 0;
                cb2Var12.c = 0;
                cb2Var12.a(null);
                Q0(ig3Var, this.q, ng3Var, false);
            } else {
                r4 = 0;
            }
            if (iE2 > 0) {
                l1(ag3.K(Y0()), i2);
                cb2 cb2Var13 = this.q;
                cb2Var13.h = iE2;
                cb2Var13.c = r4;
                list = null;
                cb2Var13.a(null);
                Q0(ig3Var, this.q, ng3Var, r4);
            } else {
                list = null;
            }
            this.q.k = list;
        }
        if (ng3Var.g) {
            ab2Var.c();
        } else {
            h31 h31Var10 = this.r;
            h31Var10.a = h31Var10.n();
        }
        this.s = this.v;
    }

    public final void i1(int i) {
        if (i != 0 && i != 1) {
            xe.k(dw2.A(i, "invalid orientation:"));
            return;
        }
        c(null);
        if (i != this.p || this.r == null) {
            h31 h31VarB = h31.b(this, i);
            this.r = h31VarB;
            this.B.a = h31VarB;
            this.p = i;
            u0();
        }
    }

    @Override // defpackage.ag3
    public final int j(ng3 ng3Var) {
        return L0(ng3Var);
    }

    @Override // defpackage.ag3
    public void j0(ng3 ng3Var) {
        this.A = null;
        this.x = -1;
        this.y = Integer.MIN_VALUE;
        this.B.c();
    }

    public void j1(boolean z) {
        c(null);
        if (this.v == z) {
            return;
        }
        this.v = z;
        u0();
    }

    @Override // defpackage.ag3
    public int k(ng3 ng3Var) {
        return M0(ng3Var);
    }

    @Override // defpackage.ag3
    public final void k0(Parcelable parcelable) {
        if (parcelable instanceof db2) {
            db2 db2Var = (db2) parcelable;
            this.A = db2Var;
            if (this.x != -1) {
                db2Var.b = -1;
            }
            u0();
        }
    }

    public final void k1(int i, int i2, boolean z, ng3 ng3Var) {
        int iM;
        this.q.l = this.r.k() == 0 && this.r.h() == 0;
        this.q.f = i;
        int[] iArr = this.E;
        iArr[0] = 0;
        iArr[1] = 0;
        J0(ng3Var, iArr);
        int iMax = Math.max(0, iArr[0]);
        int iMax2 = Math.max(0, iArr[1]);
        boolean z2 = i == 1;
        cb2 cb2Var = this.q;
        int i3 = z2 ? iMax2 : iMax;
        cb2Var.h = i3;
        if (!z2) {
            iMax = iMax2;
        }
        cb2Var.i = iMax;
        if (z2) {
            cb2Var.h = this.r.j() + i3;
            View viewY0 = Y0();
            cb2 cb2Var2 = this.q;
            cb2Var2.e = this.u ? -1 : 1;
            int iK = ag3.K(viewY0);
            cb2 cb2Var3 = this.q;
            cb2Var2.d = iK + cb2Var3.e;
            cb2Var3.b = this.r.d(viewY0);
            iM = this.r.d(viewY0) - this.r.i();
        } else {
            View viewZ0 = Z0();
            cb2 cb2Var4 = this.q;
            cb2Var4.h = this.r.m() + cb2Var4.h;
            cb2 cb2Var5 = this.q;
            cb2Var5.e = this.u ? 1 : -1;
            int iK2 = ag3.K(viewZ0);
            cb2 cb2Var6 = this.q;
            cb2Var5.d = iK2 + cb2Var6.e;
            cb2Var6.b = this.r.g(viewZ0);
            iM = (-this.r.g(viewZ0)) + this.r.m();
        }
        cb2 cb2Var7 = this.q;
        cb2Var7.c = i2;
        if (z) {
            cb2Var7.c = i2 - iM;
        }
        cb2Var7.g = iM;
    }

    @Override // defpackage.ag3
    public int l(ng3 ng3Var) {
        return N0(ng3Var);
    }

    @Override // defpackage.ag3
    public final Parcelable l0() {
        db2 db2Var = this.A;
        if (db2Var != null) {
            db2 db2Var2 = new db2();
            db2Var2.b = db2Var.b;
            db2Var2.f = db2Var.f;
            db2Var2.z = db2Var.z;
            return db2Var2;
        }
        db2 db2Var3 = new db2();
        if (v() <= 0) {
            db2Var3.b = -1;
            return db2Var3;
        }
        P0();
        boolean z = this.s ^ this.u;
        db2Var3.z = z;
        if (z) {
            View viewY0 = Y0();
            db2Var3.f = this.r.i() - this.r.d(viewY0);
            db2Var3.b = ag3.K(viewY0);
            return db2Var3;
        }
        View viewZ0 = Z0();
        db2Var3.b = ag3.K(viewZ0);
        db2Var3.f = this.r.g(viewZ0) - this.r.m();
        return db2Var3;
    }

    public final void l1(int i, int i2) {
        this.q.c = this.r.i() - i2;
        cb2 cb2Var = this.q;
        cb2Var.e = this.u ? -1 : 1;
        cb2Var.d = i;
        cb2Var.f = 1;
        cb2Var.b = i2;
        cb2Var.g = Integer.MIN_VALUE;
    }

    @Override // defpackage.ag3
    public final int m(ng3 ng3Var) {
        return L0(ng3Var);
    }

    public final void m1(int i, int i2) {
        this.q.c = i2 - this.r.m();
        cb2 cb2Var = this.q;
        cb2Var.d = i;
        cb2Var.e = this.u ? 1 : -1;
        cb2Var.f = -1;
        cb2Var.b = i2;
        cb2Var.g = Integer.MIN_VALUE;
    }

    @Override // defpackage.ag3
    public int n(ng3 ng3Var) {
        return M0(ng3Var);
    }

    @Override // defpackage.ag3
    public boolean n0(int i, Bundle bundle) {
        int iMin;
        if (super.n0(i, bundle)) {
            return true;
        }
        if (i == 16908343 && bundle != null) {
            if (this.p == 1) {
                int i2 = bundle.getInt("android.view.accessibility.action.ARGUMENT_ROW_INT", -1);
                if (i2 < 0) {
                    return false;
                }
                RecyclerView recyclerView = this.b;
                iMin = Math.min(i2, M(recyclerView.z, recyclerView.y1) - 1);
            } else {
                int i3 = bundle.getInt("android.view.accessibility.action.ARGUMENT_COLUMN_INT", -1);
                if (i3 < 0) {
                    return false;
                }
                RecyclerView recyclerView2 = this.b;
                iMin = Math.min(i3, x(recyclerView2.z, recyclerView2.y1) - 1);
            }
            if (iMin >= 0) {
                h1(iMin, 0);
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.ag3
    public int o(ng3 ng3Var) {
        return N0(ng3Var);
    }

    @Override // defpackage.ag3
    public final View q(int i) {
        int iV = v();
        if (iV == 0) {
            return null;
        }
        int iK = i - ag3.K(u(0));
        if (iK >= 0 && iK < iV) {
            View viewU = u(iK);
            if (ag3.K(viewU) == i) {
                return viewU;
            }
        }
        return super.q(i);
    }

    @Override // defpackage.ag3
    public bg3 r() {
        return new bg3(-2, -2);
    }

    @Override // defpackage.ag3
    public int v0(int i, ig3 ig3Var, ng3 ng3Var) {
        if (this.p == 1) {
            return 0;
        }
        return g1(i, ig3Var, ng3Var);
    }

    @Override // defpackage.ag3
    public final void w0(int i) {
        this.x = i;
        this.y = Integer.MIN_VALUE;
        db2 db2Var = this.A;
        if (db2Var != null) {
            db2Var.b = -1;
        }
        u0();
    }

    @Override // defpackage.ag3
    public int x0(int i, ig3 ig3Var, ng3 ng3Var) {
        if (this.p == 0) {
            return 0;
        }
        return g1(i, ig3Var, ng3Var);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.p = 1;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = true;
        this.x = -1;
        this.y = Integer.MIN_VALUE;
        this.A = null;
        this.B = new ab2();
        this.C = new bb2();
        this.D = 2;
        this.E = new int[2];
        i1(i);
        c(null);
        if (z == this.t) {
            return;
        }
        this.t = z;
        u0();
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public void c1(ig3 ig3Var, ng3 ng3Var, ab2 ab2Var, int i) {
    }
}
