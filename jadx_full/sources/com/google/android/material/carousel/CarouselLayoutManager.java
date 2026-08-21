package com.google.android.material.carousel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
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
    */
    public final View X(View view, int i, ig3 ig3Var, ng3 ng3Var) {
        byte b;
        if (v() != 0) {
            int i2 = this.q.a;
            if (i == 1) {
                b = -1;
                if (b != -2147483648) {
                    if (b == -1) {
                        if (ag3.K(view) != 0) {
                            int iK = ag3.K(u(0)) - 1;
                            if (iK < 0 || iK >= F()) {
                                return u(L0() ? v() - 1 : 0);
                            }
                            this.q.h();
                            throw null;
                        }
                    } else if (ag3.K(view) != F() - 1) {
                        int iK2 = ag3.K(u(v() - 1)) + 1;
                        if (iK2 < 0 || iK2 >= F()) {
                            return u(L0() ? 0 : v() - 1);
                        }
                        this.q.h();
                        throw null;
                    }
                }
            } else if (i == 2) {
                b = 1;
                if (b != -2147483648) {
                }
            } else {
                if (i == 17) {
                    if (i2 == 0) {
                        if (L0()) {
                        }
                    }
                    b = -2147483648;
                } else if (i != 33) {
                    if (i != 66) {
                        if (i != 130) {
                            Log.d("CarouselLayoutManager", "Unknown focus request:" + i);
                        } else if (i2 == 1) {
                        }
                        b = -2147483648;
                    } else {
                        if (i2 == 0) {
                            if (L0()) {
                            }
                        }
                        b = -2147483648;
                    }
                } else if (i2 != 1) {
                    b = -2147483648;
                }
                if (b != -2147483648) {
                }
            }
        }
        return null;
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
