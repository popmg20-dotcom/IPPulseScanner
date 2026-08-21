package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j43 extends in4 {
    public static final h43 w = new h43();
    public static final ScheduledExecutorService x = vf2.q();
    public i43 p;
    public Executor q;
    public pt3 r;
    public az1 s;
    public c74 t;
    public j74 u;
    public qt3 v;

    @Override // defpackage.in4
    public final void A(Rect rect) {
        this.j = rect;
        mz mzVarC = c();
        c74 c74Var = this.t;
        if (mzVarC == null || c74Var == null) {
            return;
        }
        co4.S(new yk0(c74Var, h(mzVarC, m(mzVarC)), ((hy1) this.g).h0(), 1));
    }

    public final void D() {
        qt3 qt3Var = this.v;
        if (qt3Var != null) {
            qt3Var.b();
            this.v = null;
        }
        az1 az1Var = this.s;
        if (az1Var != null) {
            az1Var.a();
            this.s = null;
        }
        c74 c74Var = this.t;
        if (c74Var != null) {
            c74Var.b();
            this.t = null;
        }
        j74 j74Var = this.u;
        if (j74Var != null) {
            synchronized (j74Var.a) {
                j74Var.m = null;
                j74Var.n = null;
            }
        }
        this.u = null;
    }

    public final void E(i43 i43Var) {
        co4.h();
        if (i43Var == null) {
            this.p = null;
            this.c = 2;
            q();
            return;
        }
        this.p = i43Var;
        this.q = x;
        ih ihVar = this.h;
        if ((ihVar != null ? ihVar.a : null) != null) {
            F((k43) this.g, ihVar);
            p();
        }
        o();
    }

    public final void F(k43 k43Var, ih ihVar) {
        co4.h();
        mz mzVarC = c();
        Objects.requireNonNull(mzVarC);
        D();
        int i = 1;
        r25.j(null, this.t == null);
        Matrix matrix = this.k;
        boolean zP = mzVarC.p();
        Size size = ihVar.a;
        Rect rect = this.j;
        if (rect == null) {
            rect = size != null ? new Rect(0, 0, size.getWidth(), size.getHeight()) : null;
        }
        Objects.requireNonNull(rect);
        c74 c74Var = new c74(1, 34, ihVar, matrix, zP, rect, h(mzVarC, m(mzVarC)), ((hy1) this.g).h0(), mzVarC.p() && m(mzVarC));
        this.t = c74Var;
        ga1 ga1Var = new ga1(15, this);
        co4.h();
        c74Var.a();
        c74Var.m.add(ga1Var);
        j74 j74VarC = this.t.c(mzVarC, true);
        this.u = j74VarC;
        this.s = j74VarC.k;
        if (this.p != null) {
            mz mzVarC2 = c();
            c74 c74Var2 = this.t;
            if (mzVarC2 != null && c74Var2 != null) {
                co4.S(new yk0(c74Var2, h(mzVarC2, m(mzVarC2)), ((hy1) this.g).h0(), i));
            }
            i43 i43Var = this.p;
            i43Var.getClass();
            j74 j74Var = this.u;
            j74Var.getClass();
            this.q.execute(new xy0(13, i43Var, j74Var));
        }
        pt3 pt3VarD = pt3.d(k43Var, ihVar.a);
        e10 e10Var = pt3VarD.b;
        pt3VarD.h = ihVar.d;
        a(pt3VarD, ihVar);
        int iB = qe4.b(k43Var);
        if (iB != 0 && iB != 0) {
            ((qn2) e10Var.A).g(mn4.l0, Integer.valueOf(iB));
        }
        ka0 ka0Var = ihVar.f;
        if (ka0Var != null) {
            e10Var.d(ka0Var);
        }
        if (this.p != null) {
            pt3VarD.b(this.s, ihVar.c, ((hy1) this.g).q());
        }
        qt3 qt3Var = this.v;
        if (qt3Var != null) {
            qt3Var.b();
        }
        qt3 qt3Var2 = new qt3(new tx1(2, this));
        this.v = qt3Var2;
        pt3VarD.f = qt3Var2;
        this.r = pt3VarD;
        Object[] objArr = {pt3VarD.c()};
        ArrayList arrayList = new ArrayList(1);
        Object obj = objArr[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        C(DesugarCollections.unmodifiableList(arrayList));
    }

    @Override // defpackage.in4
    public final mn4 f(boolean z, pn4 pn4Var) {
        w.getClass();
        k43 k43Var = h43.a;
        k43Var.getClass();
        ka0 ka0VarA = pn4Var.a(qe4.a(k43Var), 1);
        if (z) {
            ka0VarA = ha0.y(ka0VarA, k43Var);
        }
        if (ka0VarA == null) {
            return null;
        }
        return new k43(sw2.a(((qx) l(ka0VarA)).b));
    }

    @Override // defpackage.in4
    public final Set k() {
        HashSet hashSet = new HashSet();
        hashSet.add(1);
        return hashSet;
    }

    @Override // defpackage.in4
    public final ln4 l(ka0 ka0Var) {
        return new qx(qn2.d(ka0Var), 4);
    }

    @Override // defpackage.in4
    public final mn4 t(kz kzVar, ln4 ln4Var) {
        ln4Var.a().g(dy1.s, 34);
        return ln4Var.b();
    }

    public final String toString() {
        return "Preview:".concat(g());
    }

    @Override // defpackage.in4
    public final ih w(ka0 ka0Var) {
        this.r.a(ka0Var);
        Object[] objArr = {this.r.c()};
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
        ez4.o("Preview", "onSuggestedStreamSpecUpdated: primaryStreamSpec = " + ihVar + ", secondaryStreamSpec " + ihVar2);
        F((k43) this.g, ihVar);
        return ihVar;
    }

    @Override // defpackage.in4
    public final void y() {
        D();
    }
}
