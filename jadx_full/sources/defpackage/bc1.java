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
    */
    public final void i() {
        int iK;
        LinearLayoutManager linearLayoutManagerU;
        int iB = b();
        int paddingTop = 0;
        boolean z = iB > 0;
        this.l = z;
        if (z) {
            Rect rectA = a();
            long height = ((this.c.getHeight() - rectA.top) - rectA.bottom) - this.h;
            n02 n02Var = this.d;
            RecyclerView recyclerView = (RecyclerView) n02Var.f;
            int i = -1;
            if (recyclerView.getChildCount() == 0) {
                iK = -1;
                linearLayoutManagerU = n02Var.u();
                if (linearLayoutManagerU != null) {
                    iK = -1;
                } else if (linearLayoutManagerU instanceof GridLayoutManager) {
                    iK /= ((GridLayoutManager) linearLayoutManagerU).G;
                }
                if (iK != -1) {
                    int iS = n02Var.s();
                    Rect rect = (Rect) n02Var.A;
                    if (recyclerView.getChildCount() != 0) {
                        RecyclerView.P(recyclerView.getChildAt(0), rect);
                        i = rect.top;
                    }
                    paddingTop = ((iK * iS) + recyclerView.getPaddingTop()) - i;
                }
                paddingTop = (int) ((height * ((long) paddingTop)) / ((long) iB));
            } else {
                View childAt = recyclerView.getChildAt(0);
                if (n02Var.u() != null) {
                    iK = ag3.K(childAt);
                }
                linearLayoutManagerU = n02Var.u();
                if (linearLayoutManagerU != null) {
                }
                if (iK != -1) {
                }
                paddingTop = (int) ((height * ((long) paddingTop)) / ((long) iB));
            }
        }
        this.m = paddingTop;
    }
}
