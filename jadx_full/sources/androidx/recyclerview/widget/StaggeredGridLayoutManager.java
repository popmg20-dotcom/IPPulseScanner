package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
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
import defpackage.fw;
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
import defpackage.w14;
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
    */
    public final void U0(int i, int i2, int i3) {
        int i4;
        int i5;
        v62 v62Var;
        int[] iArr;
        ArrayList arrayList;
        w14 w14Var;
        int i6;
        int iR0 = this.x ? R0() : Q0();
        if (i3 != 8) {
            i4 = i + i2;
        } else {
            if (i >= i2) {
                i4 = i + 1;
                i5 = i2;
                v62Var = this.B;
                iArr = (int[]) v62Var.f;
                if (iArr != null && i5 < iArr.length) {
                    arrayList = (ArrayList) v62Var.z;
                    if (arrayList != null) {
                        i6 = -1;
                        int[] iArr2 = (int[]) v62Var.f;
                        if (i6 != -1) {
                            Arrays.fill(iArr2, i5, iArr2.length, -1);
                            int length = ((int[]) v62Var.f).length;
                        } else {
                            Arrays.fill((int[]) v62Var.f, i5, Math.min(i6 + 1, iArr2.length), -1);
                        }
                    } else {
                        int size = arrayList.size() - 1;
                        while (true) {
                            if (size < 0) {
                                w14Var = null;
                                break;
                            }
                            w14Var = (w14) ((ArrayList) v62Var.z).get(size);
                            if (w14Var.b == i5) {
                                break;
                            } else {
                                size--;
                            }
                        }
                        if (w14Var != null) {
                            ((ArrayList) v62Var.z).remove(w14Var);
                        }
                        int size2 = ((ArrayList) v62Var.z).size();
                        int i7 = 0;
                        while (true) {
                            if (i7 >= size2) {
                                i7 = -1;
                                break;
                            } else if (((w14) ((ArrayList) v62Var.z).get(i7)).b >= i5) {
                                break;
                            } else {
                                i7++;
                            }
                        }
                        if (i7 != -1) {
                            w14 w14Var2 = (w14) ((ArrayList) v62Var.z).get(i7);
                            ((ArrayList) v62Var.z).remove(i7);
                            i6 = w14Var2.b;
                        }
                        int[] iArr22 = (int[]) v62Var.f;
                        if (i6 != -1) {
                        }
                    }
                }
                if (i3 != 1) {
                    v62Var.I(i, i2);
                } else if (i3 == 2) {
                    v62Var.J(i, i2);
                } else if (i3 == 8) {
                    v62Var.J(i, 1);
                    v62Var.I(i2, 1);
                }
                if (i4 > iR0) {
                    return;
                }
                if (i5 <= (this.x ? Q0() : R0())) {
                    u0();
                    return;
                }
                return;
            }
            i4 = i2 + 1;
        }
        i5 = i;
        v62Var = this.B;
        iArr = (int[]) v62Var.f;
        if (iArr != null) {
            arrayList = (ArrayList) v62Var.z;
            if (arrayList != null) {
            }
        }
        if (i3 != 1) {
        }
        if (i4 > iR0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00f4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x002c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View V0() {
        int iV = v();
        int i = iV - 1;
        BitSet bitSet = new BitSet(this.p);
        bitSet.set(0, this.p, true);
        byte b = (this.t == 1 && W0()) ? (byte) 1 : (byte) -1;
        if (this.x) {
            iV = -1;
        } else {
            i = 0;
        }
        int i2 = i < iV ? 1 : -1;
        while (i != iV) {
            View viewU = u(i);
            v14 v14Var = (v14) viewU.getLayoutParams();
            boolean z = bitSet.get(v14Var.e.e);
            h31 h31Var = this.r;
            if (z) {
                if2 if2Var = v14Var.e;
                if (this.x) {
                    int i3 = if2Var.c;
                    if (i3 == Integer.MIN_VALUE) {
                        if2Var.a();
                        i3 = if2Var.c;
                    }
                    if (i3 < h31Var.i()) {
                        ((v14) ((View) fw.r((ArrayList) if2Var.f, 1)).getLayoutParams()).getClass();
                        return viewU;
                    }
                } else {
                    int i4 = if2Var.b;
                    ArrayList arrayList = (ArrayList) if2Var.f;
                    if (i4 == Integer.MIN_VALUE) {
                        View view = (View) arrayList.get(0);
                        v14 v14Var2 = (v14) view.getLayoutParams();
                        if2Var.b = ((StaggeredGridLayoutManager) if2Var.g).r.g(view);
                        v14Var2.getClass();
                        i4 = if2Var.b;
                    }
                    if (i4 > h31Var.m()) {
                        ((v14) ((View) arrayList.get(0)).getLayoutParams()).getClass();
                        return viewU;
                    }
                }
                bitSet.clear(v14Var.e.e);
            }
            i += i2;
            if (i != iV) {
                View viewU2 = u(i);
                if (this.x) {
                    int iD = h31Var.d(viewU);
                    int iD2 = h31Var.d(viewU2);
                    if (iD < iD2) {
                        return viewU;
                    }
                    if (iD == iD2) {
                        if ((v14Var.e.e - ((v14) viewU2.getLayoutParams()).e.e >= 0) == (b >= 0)) {
                            return viewU;
                        }
                    } else {
                        continue;
                    }
                } else {
                    int iG = h31Var.g(viewU);
                    int iG2 = h31Var.g(viewU2);
                    if (iG > iG2) {
                        return viewU;
                    }
                    if (iG == iG2) {
                        if ((v14Var.e.e - ((v14) viewU2.getLayoutParams()).e.e >= 0) == (b >= 0)) {
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
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
    */
    public final View X(View view, int i, ig3 ig3Var, ng3 ng3Var) {
        View viewF;
        int i2;
        if (v() != 0) {
            RecyclerView recyclerView = this.b;
            if (recyclerView == null || (viewF = recyclerView.F(view)) == null || ((ArrayList) this.a.e).contains(viewF)) {
                viewF = null;
            }
            if (viewF != null) {
                e1();
                int i3 = this.t;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 17) {
                            if (i != 33) {
                                if (i == 66 ? i3 == 0 : !(i != 130 || i3 != 1)) {
                                    i2 = 1;
                                }
                            } else if (i3 == 1) {
                                i2 = -1;
                            }
                            i2 = Integer.MIN_VALUE;
                        } else if (i3 != 0) {
                            i2 = Integer.MIN_VALUE;
                        }
                    } else if (i3 != 1 && W0()) {
                    }
                } else if (i3 != 1 && W0()) {
                }
                if (i2 != Integer.MIN_VALUE) {
                    v14 v14Var = (v14) viewF.getLayoutParams();
                    v14Var.getClass();
                    if2 if2Var = v14Var.e;
                    int iR0 = i2 == 1 ? R0() : Q0();
                    i1(iR0, ng3Var);
                    g1(i2);
                    x82 x82Var = this.v;
                    x82Var.c = x82Var.d + iR0;
                    x82Var.b = (int) (this.r.n() * 0.33333334f);
                    x82Var.h = true;
                    x82Var.a = false;
                    L0(ig3Var, x82Var, ng3Var);
                    this.D = this.x;
                    View viewJ = if2Var.j(iR0, i2);
                    if (viewJ != null && viewJ != viewF) {
                        return viewJ;
                    }
                    if (Z0(i2)) {
                        for (int i4 = this.p - 1; i4 >= 0; i4--) {
                            View viewJ2 = this.q[i4].j(iR0, i2);
                            if (viewJ2 != null && viewJ2 != viewF) {
                                return viewJ2;
                            }
                        }
                    } else {
                        for (int i5 = 0; i5 < this.p; i5++) {
                            View viewJ3 = this.q[i5].j(iR0, i2);
                            if (viewJ3 != null && viewJ3 != viewF) {
                                return viewJ3;
                            }
                        }
                    }
                    boolean z = (this.w ^ true) == (i2 == -1);
                    View viewQ = q(z ? if2Var.e() : if2Var.f());
                    if (viewQ != null && viewQ != viewF) {
                        return viewQ;
                    }
                    if (Z0(i2)) {
                        for (int i6 = this.p - 1; i6 >= 0; i6--) {
                            if (i6 != if2Var.e) {
                                if2[] if2VarArr = this.q;
                                View viewQ2 = q(z ? if2VarArr[i6].e() : if2VarArr[i6].f());
                                if (viewQ2 != null && viewQ2 != viewF) {
                                    return viewQ2;
                                }
                            }
                        }
                    } else {
                        for (int i7 = 0; i7 < this.p; i7++) {
                            if2[] if2VarArr2 = this.q;
                            View viewQ3 = q(z ? if2VarArr2[i7].e() : if2VarArr2[i7].f());
                            if (viewQ3 != null && viewQ3 != viewF) {
                                return viewQ3;
                            }
                        }
                    }
                }
            }
        }
        return null;
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
    */
    public final void Y0(ig3 ig3Var, ng3 ng3Var, boolean z) {
        x14 x14Var;
        if2[] if2VarArr;
        int iK;
        int i;
        boolean z2;
        x14 x14Var2 = this.F;
        u14 u14Var = this.H;
        if (!(x14Var2 == null && this.z == -1) && ng3Var.b() == 0) {
            p0(ig3Var);
            u14Var.a();
            return;
        }
        boolean z3 = u14Var.e;
        StaggeredGridLayoutManager staggeredGridLayoutManager = u14Var.g;
        boolean z4 = true;
        boolean z5 = (z3 && this.z == -1 && this.F == null) ? false : true;
        v62 v62Var = this.B;
        if (z5) {
            u14Var.a();
            x14 x14Var3 = this.F;
            h31 h31Var = this.r;
            if (x14Var3 != null) {
                int i2 = x14Var3.z;
                if (i2 > 0) {
                    if (i2 == this.p) {
                        for (int i3 = 0; i3 < this.p; i3++) {
                            this.q[i3].b();
                            x14 x14Var4 = this.F;
                            int i4 = x14Var4.A[i3];
                            if (i4 != Integer.MIN_VALUE) {
                                i4 += x14Var4.z0 ? h31Var.i() : h31Var.m();
                            }
                            if2 if2Var = this.q[i3];
                            if2Var.b = i4;
                            if2Var.c = i4;
                        }
                    } else {
                        x14Var3.A = null;
                        x14Var3.z = 0;
                        x14Var3.X = 0;
                        x14Var3.Y = null;
                        x14Var3.Z = null;
                        x14Var3.b = x14Var3.f;
                    }
                }
                x14 x14Var5 = this.F;
                this.E = x14Var5.A0;
                boolean z6 = x14Var5.y0;
                c(null);
                x14 x14Var6 = this.F;
                if (x14Var6 != null && x14Var6.y0 != z6) {
                    x14Var6.y0 = z6;
                }
                this.w = z6;
                u0();
                e1();
                x14 x14Var7 = this.F;
                int i5 = x14Var7.b;
                if (i5 != -1) {
                    this.z = i5;
                    u14Var.c = x14Var7.z0;
                } else {
                    u14Var.c = this.x;
                }
                if (x14Var7.X > 1) {
                    v62Var.f = x14Var7.Y;
                    v62Var.z = x14Var7.Z;
                }
            } else {
                e1();
                u14Var.c = this.x;
            }
            if (ng3Var.g || (i = this.z) == -1) {
                if (this.D) {
                    int iB = ng3Var.b();
                    int iV = v();
                    for (int i6 = 0; i6 < iV; i6++) {
                        int iK2 = ag3.K(u(i6));
                        if (iK2 >= 0 && iK2 < iB) {
                            iK = iK2;
                            break;
                        }
                    }
                    iK = 0;
                    u14Var.a = iK;
                    u14Var.b = Integer.MIN_VALUE;
                    u14Var.e = true;
                } else {
                    int iB2 = ng3Var.b();
                    for (int iV2 = v() - 1; iV2 >= 0; iV2--) {
                        iK = ag3.K(u(iV2));
                        if (iK >= 0 && iK < iB2) {
                            break;
                        }
                    }
                    iK = 0;
                    u14Var.a = iK;
                    u14Var.b = Integer.MIN_VALUE;
                    u14Var.e = true;
                }
            } else if (i < 0 || i >= ng3Var.b()) {
                this.z = -1;
                this.A = Integer.MIN_VALUE;
                if (this.D) {
                }
            } else {
                x14 x14Var8 = this.F;
                if (x14Var8 == null || x14Var8.b == -1 || x14Var8.z < 1) {
                    View viewQ = q(this.z);
                    if (viewQ != null) {
                        u14Var.a = this.x ? R0() : Q0();
                        if (this.A != Integer.MIN_VALUE) {
                            if (u14Var.c) {
                                u14Var.b = (h31Var.i() - this.A) - h31Var.d(viewQ);
                            } else {
                                u14Var.b = (h31Var.m() + this.A) - h31Var.g(viewQ);
                            }
                        } else if (h31Var.e(viewQ) > h31Var.n()) {
                            u14Var.b = u14Var.c ? h31Var.i() : h31Var.m();
                        } else {
                            int iG = h31Var.g(viewQ) - h31Var.m();
                            if (iG < 0) {
                                u14Var.b = -iG;
                            } else {
                                int i7 = h31Var.i() - h31Var.d(viewQ);
                                if (i7 < 0) {
                                    u14Var.b = i7;
                                } else {
                                    u14Var.b = Integer.MIN_VALUE;
                                }
                            }
                        }
                    } else {
                        int i8 = this.z;
                        u14Var.a = i8;
                        int i9 = this.A;
                        if (i9 == Integer.MIN_VALUE) {
                            if (v() == 0) {
                                z2 = this.x;
                            } else if ((i8 < Q0()) != this.x) {
                            }
                            u14Var.c = z2;
                            h31 h31Var2 = staggeredGridLayoutManager.r;
                            u14Var.b = z2 ? h31Var2.i() : h31Var2.m();
                        } else {
                            boolean z7 = u14Var.c;
                            h31 h31Var3 = staggeredGridLayoutManager.r;
                            if (z7) {
                                u14Var.b = h31Var3.i() - i9;
                            } else {
                                u14Var.b = h31Var3.m() + i9;
                            }
                        }
                        u14Var.d = true;
                    }
                } else {
                    u14Var.b = Integer.MIN_VALUE;
                    u14Var.a = this.z;
                }
                u14Var.e = true;
            }
        }
        if (this.F == null && this.z == -1 && (u14Var.c != this.D || W0() != this.E)) {
            v62Var.s();
            u14Var.d = true;
        }
        if (v() > 0 && ((x14Var = this.F) == null || x14Var.z < 1)) {
            if (u14Var.d) {
                for (int i10 = 0; i10 < this.p; i10++) {
                    this.q[i10].b();
                    int i11 = u14Var.b;
                    if (i11 != Integer.MIN_VALUE) {
                        if2 if2Var2 = this.q[i10];
                        if2Var2.b = i11;
                        if2Var2.c = i11;
                    }
                }
            } else if (z5 || u14Var.f == null) {
                int i12 = 0;
                while (true) {
                    int i13 = this.p;
                    if2VarArr = this.q;
                    if (i12 >= i13) {
                        break;
                    }
                    if2 if2Var3 = if2VarArr[i12];
                    boolean z8 = this.x;
                    int i14 = u14Var.b;
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = (StaggeredGridLayoutManager) if2Var3.g;
                    int i15 = z8 ? if2Var3.i(Integer.MIN_VALUE) : if2Var3.k(Integer.MIN_VALUE);
                    if2Var3.b();
                    if (i15 != Integer.MIN_VALUE && ((!z8 || i15 >= staggeredGridLayoutManager2.r.i()) && (z8 || i15 <= staggeredGridLayoutManager2.r.m()))) {
                        if (i14 != Integer.MIN_VALUE) {
                            i15 += i14;
                        }
                        if2Var3.c = i15;
                        if2Var3.b = i15;
                    }
                    i12++;
                }
                int length = if2VarArr.length;
                int[] iArr = u14Var.f;
                if (iArr == null || iArr.length < length) {
                    u14Var.f = new int[staggeredGridLayoutManager.q.length];
                }
                for (int i16 = 0; i16 < length; i16++) {
                    u14Var.f[i16] = if2VarArr[i16].k(Integer.MIN_VALUE);
                }
            } else {
                for (int i17 = 0; i17 < this.p; i17++) {
                    if2 if2Var4 = this.q[i17];
                    if2Var4.b();
                    int i18 = u14Var.f[i17];
                    if2Var4.b = i18;
                    if2Var4.c = i18;
                }
            }
        }
        p(ig3Var);
        x82 x82Var = this.v;
        x82Var.a = false;
        h31 h31Var4 = this.s;
        int iN = h31Var4.n();
        this.u = iN / this.p;
        View.MeasureSpec.makeMeasureSpec(iN, h31Var4.k());
        i1(u14Var.a, ng3Var);
        if (u14Var.c) {
            g1(-1);
            L0(ig3Var, x82Var, ng3Var);
            g1(1);
            x82Var.c = u14Var.a + x82Var.d;
            L0(ig3Var, x82Var, ng3Var);
        } else {
            g1(1);
            L0(ig3Var, x82Var, ng3Var);
            g1(-1);
            x82Var.c = u14Var.a + x82Var.d;
            L0(ig3Var, x82Var, ng3Var);
        }
        if (h31Var4.k() != 1073741824) {
            int iV3 = v();
            float fMax = 0.0f;
            for (int i19 = 0; i19 < iV3; i19++) {
                View viewU = u(i19);
                float fE = h31Var4.e(viewU);
                if (fE >= fMax) {
                    ((v14) viewU.getLayoutParams()).getClass();
                    fMax = Math.max(fMax, fE);
                }
            }
            int i20 = this.u;
            int iRound = Math.round(fMax * this.p);
            if (h31Var4.k() == Integer.MIN_VALUE) {
                iRound = Math.min(iRound, h31Var4.n());
            }
            this.u = iRound / this.p;
            View.MeasureSpec.makeMeasureSpec(iRound, h31Var4.k());
            if (this.u != i20) {
                for (int i21 = 0; i21 < iV3; i21++) {
                    View viewU2 = u(i21);
                    v14 v14Var = (v14) viewU2.getLayoutParams();
                    v14Var.getClass();
                    boolean zW0 = W0();
                    int i22 = this.t;
                    if (zW0 && i22 == 1) {
                        int i23 = -((this.p - 1) - v14Var.e.e);
                        viewU2.offsetLeftAndRight((this.u * i23) - (i23 * i20));
                    } else {
                        int i24 = v14Var.e.e;
                        int i25 = this.u * i24;
                        int i26 = i24 * i20;
                        if (i22 == 1) {
                            viewU2.offsetLeftAndRight(i25 - i26);
                        } else {
                            viewU2.offsetTopAndBottom(i25 - i26);
                        }
                    }
                }
            }
        }
        if (v() > 0) {
            if (this.x) {
                O0(ig3Var, ng3Var, true);
                P0(ig3Var, ng3Var, false);
            } else {
                P0(ig3Var, ng3Var, true);
                O0(ig3Var, ng3Var, false);
            }
        }
        if (!z || ng3Var.g || this.C == 0 || v() <= 0 || V0() == null) {
            z4 = false;
        } else {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                recyclerView.removeCallbacks(this.K);
            }
            if (!J0()) {
            }
        }
        if (ng3Var.g) {
            u14Var.a();
        }
        this.D = u14Var.c;
        this.E = W0();
        if (z4) {
            u14Var.a();
            Y0(ig3Var, ng3Var, false);
        }
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
    */
    public final PointF a(int i) {
        int i2 = -1;
        if (v() != 0) {
            if ((i < Q0()) == this.x) {
            }
        } else if (this.x) {
            i2 = 1;
        }
        PointF pointF = new PointF();
        if (i2 == 0) {
            return null;
        }
        if (this.t == 0) {
            pointF.x = i2;
            pointF.y = 0.0f;
            return pointF;
        }
        pointF.x = 0.0f;
        pointF.y = i2;
        return pointF;
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
