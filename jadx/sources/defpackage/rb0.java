package defpackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import io.netty.util.internal.shaded.org.jctools.util.Pow2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rb0 {
    public final ConstraintLayout a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public final /* synthetic */ ConstraintLayout h;

    public rb0(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        this.h = constraintLayout;
        this.a = constraintLayout2;
    }

    public static boolean a(int i, int i2, int i3) {
        if (i == i2) {
            return true;
        }
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode2 == 1073741824) {
            return (mode == Integer.MIN_VALUE || mode == 0) && i3 == size;
        }
        return false;
    }

    public final void b(jc0 jc0Var, zl zlVar) {
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        int iMax;
        int iMax2;
        boolean z;
        int baseline;
        int i;
        lb0 lb0Var = jc0Var.J;
        lb0 lb0Var2 = jc0Var.H;
        if (jc0Var.f0 == 8) {
            zlVar.e = 0;
            zlVar.f = 0;
            zlVar.g = 0;
            return;
        }
        if (jc0Var.S == null) {
            return;
        }
        uv3 uv3Var = ConstraintLayout.J0;
        int i2 = zlVar.a;
        int i3 = zlVar.b;
        int i4 = zlVar.c;
        int i5 = zlVar.d;
        int i6 = this.b + this.c;
        int i7 = this.d;
        View view = jc0Var.e0;
        int iG = fw.G(i2);
        if (iG == 0) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, Pow2.MAX_POW2);
        } else if (iG == 1) {
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f, i7, -2);
        } else if (iG == 2) {
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f, i7, -2);
            boolean z2 = jc0Var.r == 1;
            int i8 = zlVar.j;
            if (i8 == 1 || i8 == 2) {
                boolean z3 = view.getMeasuredHeight() == jc0Var.i();
                if (zlVar.j == 2 || !z2 || ((z2 && z3) || jc0Var.y())) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jc0Var.o(), Pow2.MAX_POW2);
                }
            }
        } else if (iG != 3) {
            iMakeMeasureSpec = 0;
        } else {
            int i9 = this.f;
            int i10 = lb0Var2 != null ? lb0Var2.g : 0;
            if (lb0Var != null) {
                i10 += lb0Var.g;
            }
            iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(i9, i7 + i10, -1);
        }
        int iG2 = fw.G(i3);
        if (iG2 == 0) {
            iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, Pow2.MAX_POW2);
        } else if (iG2 == 1) {
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.g, i6, -2);
        } else if (iG2 == 2) {
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.g, i6, -2);
            boolean z4 = jc0Var.s == 1;
            int i11 = zlVar.j;
            if (i11 == 1 || i11 == 2) {
                boolean z5 = view.getMeasuredWidth() == jc0Var.o();
                if (zlVar.j == 2 || !z4 || ((z4 && z5) || jc0Var.z())) {
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(jc0Var.i(), Pow2.MAX_POW2);
                }
            }
        } else if (iG2 != 3) {
            iMakeMeasureSpec2 = 0;
        } else {
            int i12 = this.g;
            int i13 = lb0Var2 != null ? jc0Var.I.g : 0;
            if (lb0Var != null) {
                i13 += jc0Var.K.g;
            }
            iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(i12, i6 + i13, -1);
        }
        kc0 kc0Var = jc0Var.S;
        ConstraintLayout constraintLayout = this.h;
        if (kc0Var != null && ye.k(constraintLayout.C0, 256) && view.getMeasuredWidth() == jc0Var.o() && view.getMeasuredWidth() < kc0Var.o() && view.getMeasuredHeight() == jc0Var.i() && view.getMeasuredHeight() < kc0Var.i() && view.getBaseline() == jc0Var.Z && !jc0Var.x() && a(jc0Var.F, iMakeMeasureSpec, jc0Var.o()) && a(jc0Var.G, iMakeMeasureSpec2, jc0Var.i())) {
            zlVar.e = jc0Var.o();
            zlVar.f = jc0Var.i();
            zlVar.g = jc0Var.Z;
            return;
        }
        boolean z6 = i2 == 3;
        boolean z7 = i3 == 3;
        boolean z8 = i3 == 4 || i3 == 1;
        boolean z9 = i2 == 4 || i2 == 1;
        boolean z10 = z6 && jc0Var.V > 0.0f;
        boolean z11 = z7 && jc0Var.V > 0.0f;
        if (view == null) {
            return;
        }
        qb0 qb0Var = (qb0) view.getLayoutParams();
        int i14 = zlVar.j;
        if (i14 != 1 && i14 != 2 && z6 && jc0Var.r == 0 && z7 && jc0Var.s == 0) {
            i = -1;
            z = false;
            baseline = 0;
            iMax2 = 0;
            iMax = 0;
        } else {
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            jc0Var.F = iMakeMeasureSpec;
            jc0Var.G = iMakeMeasureSpec2;
            jc0Var.g = false;
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int baseline2 = view.getBaseline();
            int i15 = jc0Var.u;
            iMax = i15 > 0 ? Math.max(i15, measuredWidth) : measuredWidth;
            int i16 = jc0Var.v;
            if (i16 > 0) {
                iMax = Math.min(i16, iMax);
            }
            int i17 = jc0Var.x;
            iMax2 = i17 > 0 ? Math.max(i17, measuredHeight) : measuredHeight;
            int i18 = iMakeMeasureSpec2;
            int i19 = jc0Var.y;
            if (i19 > 0) {
                iMax2 = Math.min(i19, iMax2);
            }
            if (!ye.k(constraintLayout.C0, 1)) {
                if (z10 && z8) {
                    iMax = (int) ((iMax2 * jc0Var.V) + 0.5f);
                } else if (z11 && z9) {
                    iMax2 = (int) ((iMax / jc0Var.V) + 0.5f);
                }
            }
            if (measuredWidth == iMax && measuredHeight == iMax2) {
                baseline = baseline2;
                i = -1;
                z = false;
            } else {
                if (measuredWidth != iMax) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, Pow2.MAX_POW2);
                }
                int iMakeMeasureSpec3 = measuredHeight != iMax2 ? View.MeasureSpec.makeMeasureSpec(iMax2, Pow2.MAX_POW2) : i18;
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec3);
                jc0Var.F = iMakeMeasureSpec;
                jc0Var.G = iMakeMeasureSpec3;
                z = false;
                jc0Var.g = false;
                int measuredWidth2 = view.getMeasuredWidth();
                int measuredHeight2 = view.getMeasuredHeight();
                baseline = view.getBaseline();
                iMax = measuredWidth2;
                iMax2 = measuredHeight2;
                i = -1;
            }
        }
        boolean z12 = baseline != i ? true : z;
        zlVar.i = (iMax == zlVar.c && iMax2 == zlVar.d) ? z : true;
        boolean z13 = qb0Var.c0 ? true : z12;
        if (z13 && baseline != -1 && jc0Var.Z != baseline) {
            zlVar.i = true;
        }
        zlVar.e = iMax;
        zlVar.f = iMax2;
        zlVar.h = z13;
        zlVar.g = baseline;
    }
}
