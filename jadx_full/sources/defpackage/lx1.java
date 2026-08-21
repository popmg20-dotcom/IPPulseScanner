package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
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
    */
    public final pt3 D(px1 px1Var, ih ihVar) {
        int iIntValue;
        final nx1 nx1Var;
        boolean z;
        boolean z2;
        co4.h();
        Size size = ihVar.a;
        Executor executorA = fs1.a();
        px1Var.getClass();
        Executor executor = (Executor) px1Var.p(md4.V, executorA);
        executor.getClass();
        if (((Integer) ((sw2) ((px1) this.g).m()).p(px1.f, 0)).intValue() == 1) {
            px1 px1Var2 = (px1) this.g;
            px1Var2.getClass();
            iIntValue = ((Integer) ((sw2) px1Var2.m()).p(px1.z, 6)).intValue();
        } else {
            iIntValue = 4;
        }
        e10 e10Var = null;
        if (((sw2) px1Var.m()).p(px1.A, null) != null) {
            st4.n();
            return null;
        }
        e10 e10Var2 = new e10(yr2.p(size.getWidth(), size.getHeight(), this.g.n(), iIntValue));
        synchronized (this.p) {
            F();
            nx1Var = this.q;
        }
        if (c() != null) {
            mz mzVarC = c();
            px1 px1Var3 = (px1) this.g;
            Boolean bool = Boolean.FALSE;
            px1Var3.getClass();
            z = ((Boolean) dw2.n(px1Var3, px1.Z, bool)).booleanValue() && h(mzVarC, false) % 180 != 0;
        }
        int height = z ? size.getHeight() : size.getWidth();
        int width = z ? size.getWidth() : size.getHeight();
        int i = E() == 2 ? 1 : 35;
        boolean z3 = this.g.n() == 35 && E() == 2;
        boolean z4 = this.g.n() == 35 && E() == 3;
        if (this.g.n() != 35) {
            z2 = false;
        } else {
            if (c() == null || h(c(), false) == 0) {
                Boolean bool2 = Boolean.TRUE;
                px1 px1Var4 = (px1) this.g;
                px1Var4.getClass();
                if (bool2.equals((Boolean) dw2.n(px1Var4, px1.Y, null))) {
                }
            }
            z2 = true;
        }
        if (z3 || (z2 && !z4)) {
            e10Var = new e10(yr2.p(height, width, i, e10Var2.s()));
        }
        if (e10Var != null) {
            nx1Var.i(e10Var);
        }
        G();
        e10Var2.p(nx1Var, executor);
        pt3 pt3VarD = pt3.d(px1Var, ihVar.a);
        ka0 ka0Var = ihVar.f;
        if (ka0Var != null) {
            pt3VarD.b.d(ka0Var);
        }
        az1 az1Var = this.w;
        if (az1Var != null) {
            az1Var.a();
        }
        az1 az1Var2 = new az1(e10Var2.getSurface(), size, this.g.n());
        this.w = az1Var2;
        n12.K(az1Var2.e).a(new xy0(4, e10Var2, e10Var), vf2.q());
        pt3VarD.h = ihVar.d;
        a(pt3VarD, ihVar);
        pt3VarD.b(this.w, ihVar.c, -1);
        qt3 qt3Var = this.x;
        if (qt3Var != null) {
            qt3Var.b();
        }
        qt3 qt3Var2 = new qt3(new rt3() { // from class: gx1
            @Override // defpackage.rt3
            public final void a(tt3 tt3Var) {
                lx1 lx1Var = this.a;
                if (lx1Var.c() == null) {
                    return;
                }
                co4.h();
                qt3 qt3Var3 = lx1Var.x;
                if (qt3Var3 != null) {
                    qt3Var3.b();
                    lx1Var.x = null;
                }
                az1 az1Var3 = lx1Var.w;
                if (az1Var3 != null) {
                    az1Var3.a();
                    lx1Var.w = null;
                }
                nx1Var.c();
                lx1Var.e();
                px1 px1Var5 = (px1) lx1Var.g;
                ih ihVar2 = lx1Var.h;
                ihVar2.getClass();
                pt3 pt3VarD2 = lx1Var.D(px1Var5, ihVar2);
                lx1Var.v = pt3VarD2;
                Object[] objArr = {pt3VarD2.c()};
                ArrayList arrayList = new ArrayList(1);
                Object obj = objArr[0];
                Objects.requireNonNull(obj);
                arrayList.add(obj);
                lx1Var.C(DesugarCollections.unmodifiableList(arrayList));
                lx1Var.p();
            }
        });
        this.x = qt3Var2;
        pt3VarD.f = qt3Var2;
        return pt3VarD;
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
