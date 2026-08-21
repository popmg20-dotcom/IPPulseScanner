package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.internal.compat.quirk.OnePixelShiftQuirk;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lx1 extends in4 {
    public static final jx1 y = new jx1();
    public final Object p;
    public nx1 q;
    public Executor r;
    public n02 s;
    public Rect t;
    public Matrix u;
    public pt3 v;
    public az1 w;
    public qt3 x;

    public lx1(px1 px1Var) {
        super(px1Var);
        this.p = new Object();
    }

    @Override // defpackage.in4
    public final void A(Rect rect) {
        this.j = rect;
        synchronized (this.p) {
            try {
                nx1 nx1Var = this.q;
                if (nx1Var != null) {
                    nx1Var.k(rect);
                }
                this.t = rect;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.pt3 D(defpackage.px1 r17, defpackage.ih r18) {
        /*
            Method dump skipped, instruction units count: 433
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lx1.D(px1, ih):pt3");
    }

    public final int E() {
        px1 px1Var = (px1) this.g;
        px1Var.getClass();
        return ((Integer) dw2.n(px1Var, px1.X, 1)).intValue();
    }

    public final void F() {
        nx1 ox1Var;
        n02 n02Var;
        synchronized (this.p) {
            try {
                px1 px1Var = (px1) this.g;
                if (((Integer) ((sw2) px1Var.m()).p(px1.f, 0)).intValue() == 1) {
                    ox1Var = new ox1();
                    this.q = ox1Var;
                } else {
                    sx1 sx1Var = new sx1((Executor) px1Var.p(md4.V, fs1.a()));
                    this.q = sx1Var;
                    ox1Var = sx1Var;
                }
                ox1Var.A = E();
                nx1 nx1Var = this.q;
                px1 px1Var2 = (px1) this.g;
                Boolean bool = Boolean.FALSE;
                px1Var2.getClass();
                nx1Var.X = ((Boolean) dw2.n(px1Var2, px1.Z, bool)).booleanValue();
                mz mzVarC = c();
                px1 px1Var3 = (px1) this.g;
                px1Var3.getClass();
                Boolean bool2 = (Boolean) dw2.n(px1Var3, px1.Y, null);
                boolean zY = mzVarC != null ? mzVarC.r().n().y(OnePixelShiftQuirk.class) : false;
                nx1 nx1Var2 = this.q;
                if (bool2 != null) {
                    zY = bool2.booleanValue();
                }
                nx1Var2.Y = zY;
                if (mzVarC != null) {
                    this.q.f = h(mzVarC, false);
                }
                Rect rect = this.t;
                if (rect != null) {
                    this.q.k(rect);
                }
                Matrix matrix = this.u;
                if (matrix != null) {
                    this.q.j(matrix);
                }
                Executor executor = this.r;
                if (executor != null && (n02Var = this.s) != null) {
                    this.q.h(executor, n02Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void G() {
        synchronized (this.p) {
            try {
                mz mzVarC = c();
                if (mzVarC != null) {
                    this.q.f = h(mzVarC, false);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.in4
    public final mn4 f(boolean z, pn4 pn4Var) {
        y.getClass();
        px1 px1Var = jx1.a;
        px1Var.getClass();
        ka0 ka0VarA = pn4Var.a(qe4.a(px1Var), 1);
        if (z) {
            ka0VarA = ha0.y(ka0VarA, px1Var);
        }
        if (ka0VarA == null) {
            return null;
        }
        return new px1(sw2.a(((qx) l(ka0VarA)).b));
    }

    @Override // defpackage.in4
    public final ln4 l(ka0 ka0Var) {
        return new qx(qn2.d(ka0Var), 2);
    }

    @Override // defpackage.in4
    public final mn4 t(kz kzVar, ln4 ln4Var) {
        synchronized (this.p) {
        }
        return ln4Var.b();
    }

    public final String toString() {
        return "ImageAnalysis:".concat(g());
    }

    @Override // defpackage.in4
    public final ih w(ka0 ka0Var) {
        this.v.a(ka0Var);
        Object[] objArr = {this.v.c()};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        C(DesugarCollections.unmodifiableList(arrayList));
        r90 r90VarB = this.h.b();
        r90VarB.f = ka0Var;
        return r90VarB.e();
    }

    @Override // defpackage.in4
    public final ih x(ih ihVar, ih ihVar2) {
        ez4.o("ImageAnalysis", "onSuggestedStreamSpecUpdated: primaryStreamSpec = " + ihVar + ", secondaryStreamSpec " + ihVar2);
        px1 px1Var = (px1) this.g;
        e();
        pt3 pt3VarD = D(px1Var, ihVar);
        this.v = pt3VarD;
        Object[] objArr = {pt3VarD.c()};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        C(DesugarCollections.unmodifiableList(arrayList));
        return ihVar;
    }

    @Override // defpackage.in4
    public final void y() {
        co4.h();
        qt3 qt3Var = this.x;
        if (qt3Var != null) {
            qt3Var.b();
            this.x = null;
        }
        az1 az1Var = this.w;
        if (az1Var != null) {
            az1Var.a();
            this.w = null;
        }
        synchronized (this.p) {
            nx1 nx1Var = this.q;
            nx1Var.L0 = false;
            nx1Var.c();
            this.q = null;
        }
    }

    @Override // defpackage.in4
    public final void z(Matrix matrix) {
        super.z(matrix);
        synchronized (this.p) {
            try {
                nx1 nx1Var = this.q;
                if (nx1Var != null) {
                    nx1Var.j(matrix);
                }
                this.u = matrix;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
