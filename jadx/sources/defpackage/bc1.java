package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bc1 {
    public final int a;
    public final int b;
    public final ViewGroup c;
    public final n02 d;
    public final ac1 e;
    public final int f;
    public final int g;
    public final int h;
    public final View i;
    public final View j;
    public final AppCompatTextView k;
    public boolean l;
    public int m;
    public float n;
    public float o;
    public float p;
    public float q;
    public int r;
    public boolean s;
    public final zb1 t;
    public final Rect u;

    public bc1(ViewGroup viewGroup, n02 n02Var, Drawable drawable, Drawable drawable2, dd0 dd0Var, ac1 ac1Var) {
        RecyclerView recyclerView = (RecyclerView) n02Var.f;
        this.t = new zb1(this, 0);
        this.u = new Rect();
        this.a = viewGroup.getResources().getDimensionPixelSize(R.dimen.afs_min_touch_target_size);
        Context context = viewGroup.getContext();
        this.b = ViewConfiguration.get(context).getScaledTouchSlop();
        this.c = viewGroup;
        this.d = n02Var;
        this.e = ac1Var;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicWidth < 0) {
            xe.k("trackDrawable.getIntrinsicWidth() < 0");
            throw null;
        }
        this.f = intrinsicWidth;
        int intrinsicWidth2 = drawable2.getIntrinsicWidth();
        if (intrinsicWidth2 < 0) {
            xe.k("thumbDrawable.getIntrinsicWidth() < 0");
            throw null;
        }
        this.g = intrinsicWidth2;
        int intrinsicHeight = drawable2.getIntrinsicHeight();
        if (intrinsicHeight < 0) {
            xe.k("thumbDrawable.getIntrinsicHeight() < 0");
            throw null;
        }
        this.h = intrinsicHeight;
        View view = new View(context);
        this.i = view;
        view.setBackground(drawable);
        View view2 = new View(context);
        this.j = view2;
        view2.setBackground(drawable2);
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        this.k = appCompatTextView;
        appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        dd0Var.accept(appCompatTextView);
        ViewGroupOverlay overlay = viewGroup.getOverlay();
        overlay.add(view);
        overlay.add(view2);
        overlay.add(appCompatTextView);
        f();
        appCompatTextView.setAlpha(0.0f);
        recyclerView.i(new ug3(new zb1(this, 1)));
        recyclerView.j(new jt(2, new zb1(this, 2)));
        recyclerView.K0.add(new f22(1, new jd(13, this)));
    }

    public final Rect a() {
        ViewGroup viewGroup = this.c;
        int paddingLeft = viewGroup.getPaddingLeft();
        int paddingTop = viewGroup.getPaddingTop();
        int paddingRight = viewGroup.getPaddingRight();
        int paddingBottom = viewGroup.getPaddingBottom();
        Rect rect = this.u;
        rect.set(paddingLeft, paddingTop, paddingRight, paddingBottom);
        return rect;
    }

    public final int b() {
        int iF;
        int iS;
        n02 n02Var = this.d;
        RecyclerView recyclerView = (RecyclerView) n02Var.f;
        LinearLayoutManager linearLayoutManagerU = n02Var.u();
        int paddingBottom = 0;
        if (linearLayoutManagerU == null || (iF = linearLayoutManagerU.F()) == 0) {
            iF = 0;
        } else if (linearLayoutManagerU instanceof GridLayoutManager) {
            iF = ((iF - 1) / ((GridLayoutManager) linearLayoutManagerU).G) + 1;
        }
        if (iF != 0 && (iS = n02Var.s()) != 0) {
            paddingBottom = recyclerView.getPaddingBottom() + (iF * iS) + recyclerView.getPaddingTop();
        }
        return paddingBottom - this.c.getHeight();
    }

    public final boolean c(float f, int i, int i2, int i3) {
        int i4 = i2 - i;
        int i5 = this.a;
        if (i4 < i5) {
            int i6 = i - ((i5 - i4) / 2);
            if (i6 < 0) {
                i6 = 0;
            }
            int i7 = i6 + i5;
            if (i7 > i3) {
                i6 = i3 - i5;
                if (i6 < 0) {
                    i6 = 0;
                }
            } else {
                i3 = i7;
            }
            if (f >= i6 && f < i3) {
                return true;
            }
        } else if (f >= i && f < i2) {
            return true;
        }
        return false;
    }

    public final boolean d(View view, float f, float f2) {
        ViewGroup viewGroup = this.c;
        int scrollX = viewGroup.getScrollX();
        int scrollY = viewGroup.getScrollY();
        return c(f, view.getLeft() - scrollX, view.getRight() - scrollX, viewGroup.getWidth()) && c(f2, view.getTop() - scrollY, view.getBottom() - scrollY, viewGroup.getHeight());
    }

    public final void e(View view, int i, int i2, int i3, int i4) {
        ViewGroup viewGroup = this.c;
        int scrollX = viewGroup.getScrollX();
        int scrollY = viewGroup.getScrollY();
        view.layout(i + scrollX, i2 + scrollY, scrollX + i3, scrollY + i4);
    }

    public final void f() {
        ViewGroup viewGroup = this.c;
        zb1 zb1Var = this.t;
        viewGroup.removeCallbacks(zb1Var);
        ac1 ac1Var = this.e;
        if (ac1Var.c()) {
            ac1Var.g();
            viewGroup.postDelayed(zb1Var, 1500L);
        }
    }

    public final void g(int i) {
        Rect rectA = a();
        int height = ((this.c.getHeight() - rectA.top) - rectA.bottom) - this.h;
        int iB = (int) ((((long) b()) * ((long) tj4.m(i, 0, height))) / ((long) height));
        n02 n02Var = this.d;
        RecyclerView recyclerView = (RecyclerView) n02Var.f;
        recyclerView.t0();
        int paddingTop = iB - recyclerView.getPaddingTop();
        int iS = n02Var.s();
        int iMax = Math.max(0, paddingTop / iS);
        int i2 = (iS * iMax) - paddingTop;
        LinearLayoutManager linearLayoutManagerU = n02Var.u();
        if (linearLayoutManagerU == null) {
            return;
        }
        if (linearLayoutManagerU instanceof GridLayoutManager) {
            iMax *= ((GridLayoutManager) linearLayoutManagerU).G;
        }
        linearLayoutManagerU.h1(iMax, i2 - recyclerView.getPaddingTop());
    }

    public final void h(boolean z) {
        if (this.s == z) {
            return;
        }
        this.s = z;
        ViewGroup viewGroup = this.c;
        if (z) {
            viewGroup.getParent().requestDisallowInterceptTouchEvent(true);
        }
        boolean z2 = this.s;
        View view = this.i;
        view.setPressed(z2);
        boolean z3 = this.s;
        View view2 = this.j;
        view2.setPressed(z3);
        boolean z4 = this.s;
        AppCompatTextView appCompatTextView = this.k;
        ac1 ac1Var = this.e;
        if (!z4) {
            f();
            ac1Var.f(appCompatTextView);
        } else {
            viewGroup.removeCallbacks(this.t);
            ac1Var.l(view, view2);
            ac1Var.a(appCompatTextView);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i() {
        /*
            r10 = this;
            int r0 = r10.b()
            r1 = 0
            if (r0 <= 0) goto L9
            r2 = 1
            goto La
        L9:
            r2 = r1
        La:
            r10.l = r2
            if (r2 == 0) goto L79
            android.graphics.Rect r2 = r10.a()
            android.view.ViewGroup r3 = r10.c
            int r3 = r3.getHeight()
            int r4 = r2.top
            int r3 = r3 - r4
            int r2 = r2.bottom
            int r3 = r3 - r2
            int r2 = r10.h
            int r3 = r3 - r2
            long r2 = (long) r3
            n02 r4 = r10.d
            java.lang.Object r5 = r4.f
            androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) r5
            int r6 = r5.getChildCount()
            r7 = -1
            if (r6 != 0) goto L30
            goto L3a
        L30:
            android.view.View r6 = r5.getChildAt(r1)
            androidx.recyclerview.widget.LinearLayoutManager r8 = r4.u()
            if (r8 != 0) goto L3c
        L3a:
            r6 = r7
            goto L40
        L3c:
            int r6 = defpackage.ag3.K(r6)
        L40:
            androidx.recyclerview.widget.LinearLayoutManager r8 = r4.u()
            if (r8 != 0) goto L48
            r6 = r7
            goto L51
        L48:
            boolean r9 = r8 instanceof androidx.recyclerview.widget.GridLayoutManager
            if (r9 == 0) goto L51
            androidx.recyclerview.widget.GridLayoutManager r8 = (androidx.recyclerview.widget.GridLayoutManager) r8
            int r8 = r8.G
            int r6 = r6 / r8
        L51:
            if (r6 != r7) goto L54
            goto L74
        L54:
            int r8 = r4.s()
            java.lang.Object r4 = r4.A
            android.graphics.Rect r4 = (android.graphics.Rect) r4
            int r9 = r5.getChildCount()
            if (r9 != 0) goto L63
            goto L6c
        L63:
            android.view.View r1 = r5.getChildAt(r1)
            androidx.recyclerview.widget.RecyclerView.P(r1, r4)
            int r7 = r4.top
        L6c:
            int r1 = r5.getPaddingTop()
            int r6 = r6 * r8
            int r6 = r6 + r1
            int r1 = r6 - r7
        L74:
            long r4 = (long) r1
            long r2 = r2 * r4
            long r0 = (long) r0
            long r2 = r2 / r0
            int r1 = (int) r2
        L79:
            r10.m = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bc1.i():void");
    }
}
