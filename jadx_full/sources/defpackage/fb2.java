package defpackage;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class fb2 {
    public int a = -1;
    public RecyclerView b;
    public ag3 c;
    public boolean d;
    public boolean e;
    public View f;
    public final lg3 g;
    public boolean h;
    public final LinearInterpolator i;
    public final DecelerateInterpolator j;
    public PointF k;
    public final DisplayMetrics l;
    public boolean m;
    public float n;
    public int o;
    public int p;

    public fb2(Context context) {
        lg3 lg3Var = new lg3();
        lg3Var.d = -1;
        lg3Var.f = false;
        lg3Var.g = 0;
        lg3Var.a = 0;
        lg3Var.b = 0;
        lg3Var.c = Integer.MIN_VALUE;
        lg3Var.e = null;
        this.g = lg3Var;
        this.i = new LinearInterpolator();
        this.j = new DecelerateInterpolator();
        this.m = false;
        this.o = 0;
        this.p = 0;
        this.l = context.getResources().getDisplayMetrics();
    }

    public static int a(int i, int i2, int i3, int i4, int i5) {
        if (i5 == -1) {
            return i3 - i;
        }
        if (i5 != 0) {
            if (i5 == 1) {
                return i4 - i2;
            }
            xe.k("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
            return 0;
        }
        int i6 = i3 - i;
        if (i6 > 0) {
            return i6;
        }
        int i7 = i4 - i2;
        if (i7 < 0) {
            return i7;
        }
        return 0;
    }

    public int b(View view, int i) {
        ag3 ag3Var = this.c;
        if (ag3Var == null || !ag3Var.d()) {
            return 0;
        }
        bg3 bg3Var = (bg3) view.getLayoutParams();
        return a(ag3.A(view) - ((ViewGroup.MarginLayoutParams) bg3Var).leftMargin, ag3.D(view) + ((ViewGroup.MarginLayoutParams) bg3Var).rightMargin, ag3Var.H(), ag3Var.n - ag3Var.I(), i);
    }

    public int c(View view, int i) {
        ag3 ag3Var = this.c;
        if (ag3Var == null || !ag3Var.e()) {
            return 0;
        }
        bg3 bg3Var = (bg3) view.getLayoutParams();
        return a(ag3.E(view) - ((ViewGroup.MarginLayoutParams) bg3Var).topMargin, ag3.y(view) + ((ViewGroup.MarginLayoutParams) bg3Var).bottomMargin, ag3Var.J(), ag3Var.o - ag3Var.G(), i);
    }

    public float d(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int e(int i) {
        float fAbs = Math.abs(i);
        if (!this.m) {
            this.n = d(this.l);
            this.m = true;
        }
        return (int) Math.ceil(fAbs * this.n);
    }

    public PointF f(int i) {
        Object obj = this.c;
        if (obj instanceof mg3) {
            return ((mg3) obj).a(i);
        }
        a1.n("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + mg3.class.getCanonicalName());
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(int i, int i2) {
        PointF pointFF;
        RecyclerView recyclerView = this.b;
        if (this.a == -1 || recyclerView == null) {
            i();
        }
        if (this.d && this.f == null && this.c != null && (pointFF = f(this.a)) != null) {
            float f = pointFF.x;
            if (f != 0.0f || pointFF.y != 0.0f) {
                recyclerView.k0((int) Math.signum(f), (int) Math.signum(pointFF.y), null);
            }
        }
        this.d = false;
        View view = this.f;
        lg3 lg3Var = this.g;
        if (view != null) {
            this.b.getClass();
            rg3 rg3VarO = RecyclerView.O(view);
            if ((rg3VarO != null ? rg3VarO.d() : -1) == this.a) {
                View view2 = this.f;
                ng3 ng3Var = recyclerView.y1;
                h(view2, lg3Var);
                lg3Var.a(recyclerView);
                i();
            } else {
                a1.d("RecyclerView", "Passed over target position while smooth scrolling.");
                this.f = null;
            }
        }
        if (this.e) {
            ng3 ng3Var2 = recyclerView.y1;
            if (this.b.H0.v() == 0) {
                i();
            } else {
                int i3 = this.o;
                int i4 = i3 - i;
                if (i3 * i4 <= 0) {
                    i4 = 0;
                }
                this.o = i4;
                int i5 = this.p;
                int i6 = i5 - i2;
                if (i5 * i6 <= 0) {
                    i6 = 0;
                }
                this.p = i6;
                if (i4 == 0 && i6 == 0) {
                    PointF pointFF2 = f(this.a);
                    if (pointFF2 != null) {
                        if (pointFF2.x == 0.0f && pointFF2.y == 0.0f) {
                            lg3Var.d = this.a;
                            i();
                        } else {
                            float f2 = pointFF2.y;
                            float fSqrt = (float) Math.sqrt((f2 * f2) + (r10 * r10));
                            float f3 = pointFF2.x / fSqrt;
                            pointFF2.x = f3;
                            float f4 = pointFF2.y / fSqrt;
                            pointFF2.y = f4;
                            this.k = pointFF2;
                            this.o = (int) (f3 * 10000.0f);
                            this.p = (int) (f4 * 10000.0f);
                            int iE = e(10000);
                            lg3Var.a = (int) (this.o * 1.2f);
                            lg3Var.b = (int) (this.p * 1.2f);
                            lg3Var.c = (int) (iE * 1.2f);
                            lg3Var.e = this.i;
                            lg3Var.f = true;
                        }
                    }
                }
            }
            boolean z = lg3Var.d >= 0;
            lg3Var.a(recyclerView);
            if (z && this.e) {
                this.d = true;
                recyclerView.v1.b();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h(View view, lg3 lg3Var) {
        int i;
        PointF pointF = this.k;
        int i2 = 0;
        if (pointF != null) {
            float f = pointF.x;
            i = f == 0.0f ? 0 : f > 0.0f ? 1 : -1;
        }
        int iB = b(view, i);
        PointF pointF2 = this.k;
        if (pointF2 != null) {
            float f2 = pointF2.y;
            if (f2 != 0.0f) {
                i2 = f2 > 0.0f ? 1 : -1;
            }
        }
        int iC = c(view, i2);
        int iCeil = (int) Math.ceil(((double) e((int) Math.sqrt((iC * iC) + (iB * iB)))) / 0.3356d);
        if (iCeil > 0) {
            lg3Var.a = -iB;
            lg3Var.b = -iC;
            lg3Var.c = iCeil;
            lg3Var.e = this.j;
            lg3Var.f = true;
        }
    }

    public final void i() {
        if (this.e) {
            this.e = false;
            this.p = 0;
            this.o = 0;
            this.k = null;
            this.b.y1.a = -1;
            this.f = null;
            this.a = -1;
            this.d = false;
            ag3 ag3Var = this.c;
            if (ag3Var.e == this) {
                ag3Var.e = null;
            }
            this.c = null;
            this.b = null;
        }
    }
}
