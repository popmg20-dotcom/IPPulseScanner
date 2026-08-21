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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(int r9, int r10) {
        /*
            Method dump skipped, instruction units count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fb2.g(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(android.view.View r7, defpackage.lg3 r8) {
        /*
            r6 = this;
            android.graphics.PointF r0 = r6.k
            r1 = 0
            r2 = -1
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L15
            float r0 = r0.x
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto Lf
            goto L15
        Lf:
            if (r0 <= 0) goto L13
            r0 = r3
            goto L16
        L13:
            r0 = r2
            goto L16
        L15:
            r0 = r1
        L16:
            int r0 = r6.b(r7, r0)
            android.graphics.PointF r5 = r6.k
            if (r5 == 0) goto L2a
            float r5 = r5.y
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 != 0) goto L25
            goto L2a
        L25:
            if (r4 <= 0) goto L29
            r1 = r3
            goto L2a
        L29:
            r1 = r2
        L2a:
            int r7 = r6.c(r7, r1)
            int r1 = r0 * r0
            int r2 = r7 * r7
            int r2 = r2 + r1
            double r1 = (double) r2
            double r1 = java.lang.Math.sqrt(r1)
            int r1 = (int) r1
            int r1 = r6.e(r1)
            double r1 = (double) r1
            r4 = 4599717252057688074(0x3fd57a786c22680a, double:0.3356)
            double r1 = r1 / r4
            double r1 = java.lang.Math.ceil(r1)
            int r1 = (int) r1
            if (r1 <= 0) goto L59
            int r0 = -r0
            int r7 = -r7
            r8.a = r0
            r8.b = r7
            r8.c = r1
            android.view.animation.DecelerateInterpolator r6 = r6.j
            r8.e = r6
            r8.f = r3
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fb2.h(android.view.View, lg3):void");
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
