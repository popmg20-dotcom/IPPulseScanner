package com.google.android.material.carousel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import defpackage.ag3;
import defpackage.bg3;
import defpackage.d8;
import defpackage.dw2;
import defpackage.i22;
import defpackage.ig3;
import defpackage.lw0;
import defpackage.mg3;
import defpackage.ng3;
import defpackage.r10;
import defpackage.rc3;
import defpackage.s10;
import defpackage.t10;
import defpackage.xe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class CarouselLayoutManager extends ag3 implements mg3 {
    public final d8 p;
    public i22 q;
    public final View.OnLayoutChangeListener r;

    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        new lw0();
        this.r = new r10(0, this);
        this.p = new d8();
        u0();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, rc3.g);
            typedArrayObtainStyledAttributes.getInt(0, 0);
            u0();
            M0(typedArrayObtainStyledAttributes.getInt(0, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // defpackage.ag3
    public final void G0(RecyclerView recyclerView, int i) {
        s10 s10Var = new s10(this, recyclerView.getContext());
        s10Var.a = i;
        H0(s10Var);
    }

    public final float J0(float f, float f2) {
        return L0() ? f - f2 : f + f2;
    }

    public final boolean K0() {
        return this.q.a == 0;
    }

    public final boolean L0() {
        return K0() && this.b.getLayoutDirection() == 1;
    }

    public final void M0(int i) {
        t10 t10Var;
        if (i != 0 && i != 1) {
            xe.k(dw2.A(i, "invalid orientation:"));
            return;
        }
        c(null);
        i22 i22Var = this.q;
        if (i22Var == null || i != i22Var.a) {
            if (i == 0) {
                t10Var = new t10(this, 1);
            } else {
                if (i != 1) {
                    xe.k("invalid orientation");
                    return;
                }
                t10Var = new t10(this, 0);
            }
            this.q = t10Var;
            u0();
        }
    }

    @Override // defpackage.ag3
    public final boolean O() {
        return true;
    }

    @Override // defpackage.ag3
    public final void V(RecyclerView recyclerView) {
        Context context = recyclerView.getContext();
        d8 d8Var = this.p;
        float dimension = d8Var.a;
        if (dimension <= 0.0f) {
            dimension = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_min);
        }
        d8Var.a = dimension;
        float dimension2 = d8Var.b;
        if (dimension2 <= 0.0f) {
            dimension2 = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_max);
        }
        d8Var.b = dimension2;
        u0();
        recyclerView.addOnLayoutChangeListener(this.r);
    }

    @Override // defpackage.ag3
    public final void W(RecyclerView recyclerView, ig3 ig3Var) {
        recyclerView.removeOnLayoutChangeListener(this.r);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0058  */
    @Override // defpackage.ag3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View X(android.view.View r5, int r6, defpackage.ig3 r7, defpackage.ng3 r8) {
        /*
            r4 = this;
            int r7 = r4.v()
            r8 = 0
            if (r7 != 0) goto L9
            goto L96
        L9:
            i22 r7 = r4.q
            int r7 = r7.a
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = -1
            r2 = 1
            if (r6 == r2) goto L47
            r3 = 2
            if (r6 == r3) goto L3d
            r3 = 17
            if (r6 == r3) goto L4c
            r3 = 33
            if (r6 == r3) goto L49
            r3 = 66
            if (r6 == r3) goto L3f
            r3 = 130(0x82, float:1.82E-43)
            if (r6 == r3) goto L3b
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r3 = "Unknown focus request:"
            r7.<init>(r3)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "CarouselLayoutManager"
            android.util.Log.d(r7, r6)
        L39:
            r6 = r0
            goto L55
        L3b:
            if (r7 != r2) goto L39
        L3d:
            r6 = r2
            goto L55
        L3f:
            if (r7 != 0) goto L39
            boolean r6 = r4.L0()
            if (r6 == 0) goto L3d
        L47:
            r6 = r1
            goto L55
        L49:
            if (r7 != r2) goto L39
            goto L47
        L4c:
            if (r7 != 0) goto L39
            boolean r6 = r4.L0()
            if (r6 == 0) goto L47
            goto L3d
        L55:
            if (r6 != r0) goto L58
            goto L96
        L58:
            r7 = 0
            if (r6 != r1) goto L8b
            int r5 = defpackage.ag3.K(r5)
            if (r5 != 0) goto L62
            goto L96
        L62:
            android.view.View r5 = r4.u(r7)
            int r5 = defpackage.ag3.K(r5)
            int r5 = r5 - r2
            if (r5 < 0) goto L7a
            int r6 = r4.F()
            if (r5 < r6) goto L74
            goto L7a
        L74:
            i22 r4 = r4.q
            r4.h()
            throw r8
        L7a:
            boolean r5 = r4.L0()
            if (r5 == 0) goto L86
            int r5 = r4.v()
            int r7 = r5 + (-1)
        L86:
            android.view.View r4 = r4.u(r7)
            return r4
        L8b:
            int r5 = defpackage.ag3.K(r5)
            int r6 = r4.F()
            int r6 = r6 - r2
            if (r5 != r6) goto L97
        L96:
            return r8
        L97:
            int r5 = r4.v()
            int r5 = r5 - r2
            android.view.View r5 = r4.u(r5)
            int r5 = defpackage.ag3.K(r5)
            int r5 = r5 + r2
            if (r5 < 0) goto Lb4
            int r6 = r4.F()
            if (r5 < r6) goto Lae
            goto Lb4
        Lae:
            i22 r4 = r4.q
            r4.h()
            throw r8
        Lb4:
            boolean r5 = r4.L0()
            if (r5 == 0) goto Lbb
            goto Lc1
        Lbb:
            int r5 = r4.v()
            int r7 = r5 + (-1)
        Lc1:
            android.view.View r4 = r4.u(r7)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.carousel.CarouselLayoutManager.X(android.view.View, int, ig3, ng3):android.view.View");
    }

    @Override // defpackage.ag3
    public final void Y(AccessibilityEvent accessibilityEvent) {
        super.Y(accessibilityEvent);
        if (v() > 0) {
            accessibilityEvent.setFromIndex(ag3.K(u(0)));
            accessibilityEvent.setToIndex(ag3.K(u(v() - 1)));
        }
    }

    @Override // defpackage.mg3
    public final PointF a(int i) {
        return null;
    }

    @Override // defpackage.ag3
    public final boolean d() {
        return K0();
    }

    @Override // defpackage.ag3
    public final void d0(int i, int i2) {
        F();
    }

    @Override // defpackage.ag3
    public final boolean e() {
        return !K0();
    }

    @Override // defpackage.ag3
    public final void e0() {
        F();
    }

    @Override // defpackage.ag3
    public final void g0(int i, int i2) {
        F();
    }

    @Override // defpackage.ag3
    public final void i0(ig3 ig3Var, ng3 ng3Var) {
        if (ng3Var.b() > 0) {
            if ((K0() ? this.n : this.o) > 0.0f) {
                L0();
                ig3Var.d(0);
                xe.q("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
                return;
            }
        }
        p0(ig3Var);
    }

    @Override // defpackage.ag3
    public final int j(ng3 ng3Var) {
        v();
        return 0;
    }

    @Override // defpackage.ag3
    public final void j0(ng3 ng3Var) {
        if (v() == 0) {
            return;
        }
        ag3.K(u(0));
    }

    @Override // defpackage.ag3
    public final int k(ng3 ng3Var) {
        return 0;
    }

    @Override // defpackage.ag3
    public final int l(ng3 ng3Var) {
        return 0;
    }

    @Override // defpackage.ag3
    public final int m(ng3 ng3Var) {
        v();
        return 0;
    }

    @Override // defpackage.ag3
    public final int n(ng3 ng3Var) {
        return 0;
    }

    @Override // defpackage.ag3
    public final int o(ng3 ng3Var) {
        return 0;
    }

    @Override // defpackage.ag3
    public final bg3 r() {
        return new bg3(-2, -2);
    }

    @Override // defpackage.ag3
    public final boolean t0(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
        return false;
    }

    @Override // defpackage.ag3
    public final int v0(int i, ig3 ig3Var, ng3 ng3Var) {
        if (!K0() || v() == 0 || i == 0) {
            return 0;
        }
        ig3Var.d(0);
        xe.q("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
        return 0;
    }

    @Override // defpackage.ag3
    public final int x0(int i, ig3 ig3Var, ng3 ng3Var) {
        if (!e() || v() == 0 || i == 0) {
            return 0;
        }
        ig3Var.d(0);
        xe.q("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
        return 0;
    }

    @Override // defpackage.ag3
    public final void z(View view, Rect rect) {
        RecyclerView.P(view, rect);
        rect.centerY();
        if (K0()) {
            rect.centerX();
        }
        throw null;
    }

    @Override // defpackage.ag3
    public final void w0(int i) {
    }

    public CarouselLayoutManager() {
        d8 d8Var = new d8();
        new lw0();
        this.r = new r10(0, this);
        this.p = d8Var;
        u0();
        M0(0);
    }
}
