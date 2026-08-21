package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import io.sentry.android.core.a1;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ag3 {
    public j40 a;
    public RecyclerView b;
    public final e24 c;
    public final e24 d;
    public fb2 e;
    public boolean f;
    public boolean g;
    public final boolean h;
    public final boolean i;
    public int j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public int o;

    public ag3() {
        wn1 wn1Var = new wn1(15, this);
        oj1 oj1Var = new oj1(23, this);
        this.c = new e24((gp4) wn1Var);
        this.d = new e24(oj1Var);
        this.f = false;
        this.g = false;
        this.h = true;
        this.i = true;
    }

    public static int A(View view) {
        return view.getLeft() - ((bg3) view.getLayoutParams()).b.left;
    }

    public static int B(View view) {
        Rect rect = ((bg3) view.getLayoutParams()).b;
        return view.getMeasuredHeight() + rect.top + rect.bottom;
    }

    public static int C(View view) {
        Rect rect = ((bg3) view.getLayoutParams()).b;
        return view.getMeasuredWidth() + rect.left + rect.right;
    }

    public static int D(View view) {
        return view.getRight() + ((bg3) view.getLayoutParams()).b.right;
    }

    public static int E(View view) {
        return view.getTop() - ((bg3) view.getLayoutParams()).b.top;
    }

    public static int K(View view) {
        return ((bg3) view.getLayoutParams()).a.d();
    }

    public static zf3 L(Context context, AttributeSet attributeSet, int i, int i2) {
        zf3 zf3Var = new zf3();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, bd3.a, i, i2);
        zf3Var.a = typedArrayObtainStyledAttributes.getInt(0, 1);
        zf3Var.b = typedArrayObtainStyledAttributes.getInt(10, 1);
        zf3Var.c = typedArrayObtainStyledAttributes.getBoolean(9, false);
        zf3Var.d = typedArrayObtainStyledAttributes.getBoolean(11, false);
        typedArrayObtainStyledAttributes.recycle();
        return zf3Var;
    }

    public static boolean Q(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (i3 > 0 && i != i3) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i;
        }
        return true;
    }

    public static void R(View view, int i, int i2, int i3, int i4) {
        bg3 bg3Var = (bg3) view.getLayoutParams();
        Rect rect = bg3Var.b;
        view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) bg3Var).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) bg3Var).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) bg3Var).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) bg3Var).bottomMargin);
    }

    public static int g(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i2, i3) : size : Math.min(size, Math.max(i2, i3));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int w(int r4, int r5, int r6, boolean r7, int r8) {
        /*
            int r4 = r4 - r6
            r6 = 0
            int r4 = java.lang.Math.max(r6, r4)
            r0 = -2
            r1 = -1
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            if (r7 == 0) goto L1d
            if (r8 < 0) goto L12
        L10:
            r5 = r3
            goto L30
        L12:
            if (r8 != r1) goto L1a
            if (r5 == r2) goto L22
            if (r5 == 0) goto L1a
            if (r5 == r3) goto L22
        L1a:
            r5 = r6
            r8 = r5
            goto L30
        L1d:
            if (r8 < 0) goto L20
            goto L10
        L20:
            if (r8 != r1) goto L24
        L22:
            r8 = r4
            goto L30
        L24:
            if (r8 != r0) goto L1a
            if (r5 == r2) goto L2e
            if (r5 != r3) goto L2b
            goto L2e
        L2b:
            r8 = r4
            r5 = r6
            goto L30
        L2e:
            r8 = r4
            r5 = r2
        L30:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ag3.w(int, int, int, boolean, int):int");
    }

    public static int y(View view) {
        return view.getBottom() + ((bg3) view.getLayoutParams()).b.bottom;
    }

    public void A0(Rect rect, int i, int i2) {
        int I = I() + H() + rect.width();
        int iG = G() + J() + rect.height();
        RecyclerView recyclerView = this.b;
        WeakHashMap weakHashMap = wp4.a;
        this.b.setMeasuredDimension(g(i, I, recyclerView.getMinimumWidth()), g(i2, iG, this.b.getMinimumHeight()));
    }

    public final void B0(int i, int i2) {
        int iV = v();
        if (iV == 0) {
            this.b.q(i, i2);
            return;
        }
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MAX_VALUE;
        int i5 = Integer.MIN_VALUE;
        int i6 = Integer.MAX_VALUE;
        for (int i7 = 0; i7 < iV; i7++) {
            View viewU = u(i7);
            Rect rect = this.b.D0;
            z(viewU, rect);
            int i8 = rect.left;
            if (i8 < i6) {
                i6 = i8;
            }
            int i9 = rect.right;
            if (i9 > i3) {
                i3 = i9;
            }
            int i10 = rect.top;
            if (i10 < i4) {
                i4 = i10;
            }
            int i11 = rect.bottom;
            if (i11 > i5) {
                i5 = i11;
            }
        }
        this.b.D0.set(i6, i4, i3, i5);
        A0(this.b.D0, i, i2);
    }

    public final void C0(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.b = null;
            this.a = null;
            this.n = 0;
            this.o = 0;
        } else {
            this.b = recyclerView;
            this.a = recyclerView.z0;
            this.n = recyclerView.getWidth();
            this.o = recyclerView.getHeight();
        }
        this.l = Pow2.MAX_POW2;
        this.m = Pow2.MAX_POW2;
    }

    public final boolean D0(View view, int i, int i2, bg3 bg3Var) {
        return (!view.isLayoutRequested() && this.h && Q(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) bg3Var).width) && Q(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) bg3Var).height)) ? false : true;
    }

    public boolean E0() {
        return false;
    }

    public final int F() {
        RecyclerView recyclerView = this.b;
        rf3 adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        if (adapter != null) {
            return adapter.b();
        }
        return 0;
    }

    public final boolean F0(View view, int i, int i2, bg3 bg3Var) {
        return (this.h && Q(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) bg3Var).width) && Q(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) bg3Var).height)) ? false : true;
    }

    public final int G() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            return recyclerView.getPaddingBottom();
        }
        return 0;
    }

    public abstract void G0(RecyclerView recyclerView, int i);

    public final int H() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    public final void H0(fb2 fb2Var) {
        fb2 fb2Var2 = this.e;
        if (fb2Var2 != null && fb2Var != fb2Var2 && fb2Var2.e) {
            fb2Var2.i();
        }
        this.e = fb2Var;
        RecyclerView recyclerView = this.b;
        qg3 qg3Var = recyclerView.v1;
        qg3Var.Z.removeCallbacks(qg3Var);
        qg3Var.z.abortAnimation();
        if (fb2Var.h) {
            a1.n("RecyclerView", "An instance of " + fb2Var.getClass().getSimpleName() + " was started more than once. Each instance of" + fb2Var.getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
        }
        fb2Var.b = recyclerView;
        fb2Var.c = this;
        int i = fb2Var.a;
        if (i == -1) {
            xe.k("Invalid target position");
            return;
        }
        recyclerView.y1.a = i;
        fb2Var.e = true;
        fb2Var.d = true;
        fb2Var.f = recyclerView.H0.q(i);
        fb2Var.b.v1.b();
        fb2Var.h = true;
    }

    public final int I() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            return recyclerView.getPaddingRight();
        }
        return 0;
    }

    public boolean I0() {
        return false;
    }

    public final int J() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    public int M(ig3 ig3Var, ng3 ng3Var) {
        RecyclerView recyclerView = this.b;
        if (recyclerView == null || recyclerView.G0 == null || !e()) {
            return 1;
        }
        return this.b.G0.b();
    }

    public final void N(View view, Rect rect) {
        Matrix matrix;
        Rect rect2 = ((bg3) view.getLayoutParams()).b;
        rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
        if (this.b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
            RectF rectF = this.b.F0;
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
        }
        rect.offset(view.getLeft(), view.getTop());
    }

    public abstract boolean O();

    public boolean P() {
        return false;
    }

    public void S(int i) {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            int iE = recyclerView.z0.e();
            for (int i2 = 0; i2 < iE; i2++) {
                recyclerView.z0.d(i2).offsetLeftAndRight(i);
            }
        }
    }

    public void T(int i) {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            int iE = recyclerView.z0.e();
            for (int i2 = 0; i2 < iE; i2++) {
                recyclerView.z0.d(i2).offsetTopAndBottom(i);
            }
        }
    }

    public abstract void W(RecyclerView recyclerView, ig3 ig3Var);

    public abstract View X(View view, int i, ig3 ig3Var, ng3 ng3Var);

    public void Y(AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView = this.b;
        ig3 ig3Var = recyclerView.z;
        if (accessibilityEvent == null) {
            return;
        }
        boolean z = true;
        if (!recyclerView.canScrollVertically(1) && !this.b.canScrollVertically(-1) && !this.b.canScrollHorizontally(-1) && !this.b.canScrollHorizontally(1)) {
            z = false;
        }
        accessibilityEvent.setScrollable(z);
        rf3 rf3Var = this.b.G0;
        if (rf3Var != null) {
            accessibilityEvent.setItemCount(rf3Var.b());
        }
    }

    public void Z(ig3 ig3Var, ng3 ng3Var, p2 p2Var) {
        if (this.b.canScrollVertically(-1) || this.b.canScrollHorizontally(-1)) {
            p2Var.a(8192);
            p2Var.p(true);
            p2Var.i(67108864, true);
        }
        if (this.b.canScrollVertically(1) || this.b.canScrollHorizontally(1)) {
            p2Var.a(4096);
            p2Var.p(true);
            p2Var.i(67108864, true);
        }
        p2Var.a.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(M(ig3Var, ng3Var), x(ig3Var, ng3Var), false, 0));
    }

    public void a0(ig3 ig3Var, ng3 ng3Var, View view, p2 p2Var) {
        p2Var.k(o2.a(e() ? K(view) : 0, 1, d() ? K(view) : 0, false, 1, false));
    }

    public final void b(View view, int i, boolean z) {
        rg3 rg3VarO = RecyclerView.O(view);
        if (z || rg3VarO.j()) {
            xw3 xw3Var = (xw3) this.b.A0.f;
            fq4 fq4VarA = (fq4) xw3Var.get(rg3VarO);
            if (fq4VarA == null) {
                fq4VarA = fq4.a();
                xw3Var.put(rg3VarO, fq4VarA);
            }
            fq4VarA.a |= 1;
        } else {
            this.b.A0.C(rg3VarO);
        }
        bg3 bg3Var = (bg3) view.getLayoutParams();
        if (rg3VarO.r() || rg3VarO.k()) {
            if (rg3VarO.k()) {
                rg3VarO.n.m(rg3VarO);
            } else {
                rg3VarO.j &= -33;
            }
            this.a.b(view, i, view.getLayoutParams(), false);
        } else {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.b;
            j40 j40Var = this.a;
            if (parent == recyclerView) {
                i40 i40Var = (i40) j40Var.d;
                int iIndexOfChild = ((gk1) j40Var.c).a.indexOfChild(view);
                int iB = (iIndexOfChild == -1 || i40Var.e(iIndexOfChild)) ? -1 : iIndexOfChild - i40Var.b(iIndexOfChild);
                if (i == -1) {
                    i = this.a.e();
                }
                if (iB == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.b.indexOfChild(view) + this.b.C());
                }
                if (iB != i) {
                    ag3 ag3Var = this.b.H0;
                    View viewU = ag3Var.u(iB);
                    if (viewU == null) {
                        throw new IllegalArgumentException("Cannot move a child from non-existing index:" + iB + ag3Var.b.toString());
                    }
                    ag3Var.u(iB);
                    ag3Var.a.c(iB);
                    bg3 bg3Var2 = (bg3) viewU.getLayoutParams();
                    rg3 rg3VarO2 = RecyclerView.O(viewU);
                    boolean zJ = rg3VarO2.j();
                    RecyclerView recyclerView2 = ag3Var.b;
                    if (zJ) {
                        xw3 xw3Var2 = (xw3) recyclerView2.A0.f;
                        fq4 fq4VarA2 = (fq4) xw3Var2.get(rg3VarO2);
                        if (fq4VarA2 == null) {
                            fq4VarA2 = fq4.a();
                            xw3Var2.put(rg3VarO2, fq4VarA2);
                        }
                        fq4VarA2.a = 1 | fq4VarA2.a;
                    } else {
                        recyclerView2.A0.C(rg3VarO2);
                    }
                    ag3Var.a.b(viewU, i, bg3Var2, rg3VarO2.j());
                }
            } else {
                j40Var.a(view, i, false);
                bg3Var.c = true;
                fb2 fb2Var = this.e;
                if (fb2Var != null && fb2Var.e) {
                    fb2Var.b.getClass();
                    rg3 rg3VarO3 = RecyclerView.O(view);
                    if ((rg3VarO3 != null ? rg3VarO3.d() : -1) == fb2Var.a) {
                        fb2Var.f = view;
                        if (RecyclerView.U1) {
                            Log.d("RecyclerView", "smooth scroll target view has been attached");
                        }
                    }
                }
            }
        }
        if (bg3Var.d) {
            if (RecyclerView.U1) {
                Log.d("RecyclerView", "consuming pending invalidate on child " + bg3Var.a);
            }
            rg3VarO.a.invalidate();
            bg3Var.d = false;
        }
    }

    public final void b0(View view, p2 p2Var) {
        rg3 rg3VarO = RecyclerView.O(view);
        if (rg3VarO == null || rg3VarO.j()) {
            return;
        }
        j40 j40Var = this.a;
        if (((ArrayList) j40Var.e).contains(rg3VarO.a)) {
            return;
        }
        RecyclerView recyclerView = this.b;
        a0(recyclerView.z, recyclerView.y1, view, p2Var);
    }

    public void c(String str) {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            recyclerView.k(str);
        }
    }

    public View c0(View view, int i) {
        return null;
    }

    public abstract boolean d();

    public abstract boolean e();

    public boolean f(bg3 bg3Var) {
        return true;
    }

    public abstract void i0(ig3 ig3Var, ng3 ng3Var);

    public abstract int j(ng3 ng3Var);

    public abstract void j0(ng3 ng3Var);

    public abstract int k(ng3 ng3Var);

    public abstract int l(ng3 ng3Var);

    public Parcelable l0() {
        return null;
    }

    public abstract int m(ng3 ng3Var);

    public abstract int n(ng3 ng3Var);

    public boolean n0(int i, Bundle bundle) {
        RecyclerView recyclerView = this.b;
        return o0(recyclerView.z, recyclerView.y1, i, bundle);
    }

    public abstract int o(ng3 ng3Var);

    /* JADX WARN: Removed duplicated region for block: B:21:0x0062 A[PHI: r8
      0x0062: PHI (r8v8 int) = (r8v5 int), (r8v20 int) binds: [B:27:0x007e, B:19:0x0054] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean o0(defpackage.ig3 r8, defpackage.ng3 r9, int r10, android.os.Bundle r11) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ag3.o0(ig3, ng3, int, android.os.Bundle):boolean");
    }

    public final void p(ig3 ig3Var) {
        for (int iV = v() - 1; iV >= 0; iV--) {
            View viewU = u(iV);
            rg3 rg3VarO = RecyclerView.O(viewU);
            if (rg3VarO.q()) {
                if (RecyclerView.U1) {
                    Log.d("RecyclerView", "ignoring view " + rg3VarO);
                }
            } else if (!rg3VarO.h() || rg3VarO.j() || this.b.G0.b) {
                u(iV);
                this.a.c(iV);
                ig3Var.k(viewU);
                this.b.A0.C(rg3VarO);
            } else {
                s0(iV);
                ig3Var.j(rg3VarO);
            }
        }
    }

    public final void p0(ig3 ig3Var) {
        for (int iV = v() - 1; iV >= 0; iV--) {
            if (!RecyclerView.O(u(iV)).q()) {
                View viewU = u(iV);
                s0(iV);
                ig3Var.i(viewU);
            }
        }
    }

    public View q(int i) {
        int iV = v();
        for (int i2 = 0; i2 < iV; i2++) {
            View viewU = u(i2);
            rg3 rg3VarO = RecyclerView.O(viewU);
            if (rg3VarO != null && rg3VarO.d() == i && !rg3VarO.q() && (this.b.y1.g || !rg3VarO.j())) {
                return viewU;
            }
        }
        return null;
    }

    public final void q0(ig3 ig3Var) {
        ArrayList arrayList;
        int size = ig3Var.a.size();
        int i = size - 1;
        while (true) {
            arrayList = ig3Var.a;
            if (i < 0) {
                break;
            }
            View view = ((rg3) arrayList.get(i)).a;
            rg3 rg3VarO = RecyclerView.O(view);
            if (!rg3VarO.q()) {
                rg3VarO.p(false);
                if (rg3VarO.l()) {
                    this.b.removeDetachedView(view, false);
                }
                xf3 xf3Var = this.b.g1;
                if (xf3Var != null) {
                    xf3Var.d(rg3VarO);
                }
                rg3VarO.p(true);
                rg3 rg3VarO2 = RecyclerView.O(view);
                rg3VarO2.n = null;
                rg3VarO2.o = false;
                rg3VarO2.j &= -33;
                ig3Var.j(rg3VarO2);
            }
            i--;
        }
        arrayList.clear();
        ArrayList arrayList2 = ig3Var.b;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        if (size > 0) {
            this.b.invalidate();
        }
    }

    public abstract bg3 r();

    public final void r0(View view, ig3 ig3Var) {
        j40 j40Var = this.a;
        gk1 gk1Var = (gk1) j40Var.c;
        int i = j40Var.b;
        if (i == 1) {
            xe.q("Cannot call removeView(At) within removeView(At)");
            return;
        }
        if (i == 2) {
            xe.q("Cannot call removeView(At) within removeViewIfHidden");
            return;
        }
        try {
            j40Var.b = 1;
            j40Var.f = view;
            int iIndexOfChild = gk1Var.a.indexOfChild(view);
            if (iIndexOfChild >= 0) {
                if (((i40) j40Var.d).h(iIndexOfChild)) {
                    j40Var.j(view);
                }
                gk1Var.a(iIndexOfChild);
            }
            j40Var.b = 0;
            j40Var.f = null;
            ig3Var.i(view);
        } catch (Throwable th) {
            j40Var.b = 0;
            j40Var.f = null;
            throw th;
        }
    }

    public bg3 s(Context context, AttributeSet attributeSet) {
        return new bg3(context, attributeSet);
    }

    public final void s0(int i) {
        if (u(i) != null) {
            j40 j40Var = this.a;
            gk1 gk1Var = (gk1) j40Var.c;
            int i2 = j40Var.b;
            if (i2 == 1) {
                xe.q("Cannot call removeView(At) within removeView(At)");
                return;
            }
            if (i2 == 2) {
                xe.q("Cannot call removeView(At) within removeViewIfHidden");
                return;
            }
            try {
                int iF = j40Var.f(i);
                View childAt = gk1Var.a.getChildAt(iF);
                if (childAt == null) {
                    j40Var.b = 0;
                    j40Var.f = null;
                    return;
                }
                j40Var.b = 1;
                j40Var.f = childAt;
                if (((i40) j40Var.d).h(iF)) {
                    j40Var.j(childAt);
                }
                gk1Var.a(iF);
                j40Var.b = 0;
                j40Var.f = null;
            } catch (Throwable th) {
                j40Var.b = 0;
                j40Var.f = null;
                throw th;
            }
        }
    }

    public bg3 t(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof bg3 ? new bg3((bg3) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new bg3((ViewGroup.MarginLayoutParams) layoutParams) : new bg3(layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean t0(androidx.recyclerview.widget.RecyclerView r9, android.view.View r10, android.graphics.Rect r11, boolean r12, boolean r13) {
        /*
            r8 = this;
            int r0 = r8.H()
            int r1 = r8.J()
            int r2 = r8.n
            int r3 = r8.I()
            int r2 = r2 - r3
            int r3 = r8.o
            int r4 = r8.G()
            int r3 = r3 - r4
            int r4 = r10.getLeft()
            int r5 = r11.left
            int r4 = r4 + r5
            int r5 = r10.getScrollX()
            int r4 = r4 - r5
            int r5 = r10.getTop()
            int r6 = r11.top
            int r5 = r5 + r6
            int r10 = r10.getScrollY()
            int r5 = r5 - r10
            int r10 = r11.width()
            int r10 = r10 + r4
            int r11 = r11.height()
            int r11 = r11 + r5
            int r4 = r4 - r0
            r0 = 0
            int r6 = java.lang.Math.min(r0, r4)
            int r5 = r5 - r1
            int r1 = java.lang.Math.min(r0, r5)
            int r10 = r10 - r2
            int r2 = java.lang.Math.max(r0, r10)
            int r11 = r11 - r3
            int r11 = java.lang.Math.max(r0, r11)
            androidx.recyclerview.widget.RecyclerView r3 = r8.b
            int r3 = r3.getLayoutDirection()
            r7 = 1
            if (r3 != r7) goto L5e
            if (r2 == 0) goto L59
            goto L66
        L59:
            int r2 = java.lang.Math.max(r6, r10)
            goto L66
        L5e:
            if (r6 == 0) goto L61
            goto L65
        L61:
            int r6 = java.lang.Math.min(r4, r2)
        L65:
            r2 = r6
        L66:
            if (r1 == 0) goto L69
            goto L6d
        L69:
            int r1 = java.lang.Math.min(r5, r11)
        L6d:
            int[] r10 = new int[]{r2, r1}
            r11 = r10[r0]
            r10 = r10[r7]
            if (r13 == 0) goto Lb0
            android.view.View r13 = r9.getFocusedChild()
            if (r13 != 0) goto L7e
            goto Lb5
        L7e:
            int r1 = r8.H()
            int r2 = r8.J()
            int r3 = r8.n
            int r4 = r8.I()
            int r3 = r3 - r4
            int r4 = r8.o
            int r5 = r8.G()
            int r4 = r4 - r5
            androidx.recyclerview.widget.RecyclerView r5 = r8.b
            android.graphics.Rect r5 = r5.D0
            r8.z(r13, r5)
            int r8 = r5.left
            int r8 = r8 - r11
            if (r8 >= r3) goto Lb5
            int r8 = r5.right
            int r8 = r8 - r11
            if (r8 <= r1) goto Lb5
            int r8 = r5.top
            int r8 = r8 - r10
            if (r8 >= r4) goto Lb5
            int r8 = r5.bottom
            int r8 = r8 - r10
            if (r8 > r2) goto Lb0
            goto Lb5
        Lb0:
            if (r11 != 0) goto Lb6
            if (r10 == 0) goto Lb5
            goto Lb6
        Lb5:
            return r0
        Lb6:
            if (r12 == 0) goto Lbc
            r9.scrollBy(r11, r10)
            return r7
        Lbc:
            r9.n0(r11, r10, r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ag3.t0(androidx.recyclerview.widget.RecyclerView, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
    }

    public final View u(int i) {
        j40 j40Var = this.a;
        if (j40Var != null) {
            return j40Var.d(i);
        }
        return null;
    }

    public final void u0() {
        RecyclerView recyclerView = this.b;
        if (recyclerView != null) {
            recyclerView.requestLayout();
        }
    }

    public final int v() {
        j40 j40Var = this.a;
        if (j40Var != null) {
            return j40Var.e();
        }
        return 0;
    }

    public abstract int v0(int i, ig3 ig3Var, ng3 ng3Var);

    public abstract void w0(int i);

    public int x(ig3 ig3Var, ng3 ng3Var) {
        RecyclerView recyclerView = this.b;
        if (recyclerView == null || recyclerView.G0 == null || !d()) {
            return 1;
        }
        return this.b.G0.b();
    }

    public abstract int x0(int i, ig3 ig3Var, ng3 ng3Var);

    public final void y0(RecyclerView recyclerView) {
        z0(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), Pow2.MAX_POW2), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), Pow2.MAX_POW2));
    }

    public void z(View view, Rect rect) {
        RecyclerView.P(view, rect);
    }

    public final void z0(int i, int i2) {
        this.n = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        this.l = mode;
        if (mode == 0 && !RecyclerView.X1) {
            this.n = 0;
        }
        this.o = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        this.m = mode2;
        if (mode2 != 0 || RecyclerView.X1) {
            return;
        }
        this.o = 0;
    }

    public void U() {
    }

    public void e0() {
    }

    public void V(RecyclerView recyclerView) {
    }

    public void k0(Parcelable parcelable) {
    }

    public void m0(int i) {
    }

    public void d0(int i, int i2) {
    }

    public void f0(int i, int i2) {
    }

    public void g0(int i, int i2) {
    }

    public void h0(int i, int i2) {
    }

    public void i(int i, r02 r02Var) {
    }

    public void h(int i, int i2, ng3 ng3Var, r02 r02Var) {
    }
}
