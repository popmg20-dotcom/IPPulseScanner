package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Range;
import androidx.camera.camera2.internal.compat.quirk.AeFpsRangeLegacyQuirk;
import androidx.camera.core.internal.compat.quirk.AeFpsRangeQuirk;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class in4 {
    public mn4 d;
    public mn4 e;
    public HashSet f;
    public mn4 g;
    public ih h;
    public mn4 i;
    public Rect j;
    public mz l;
    public mz m;
    public final HashSet a = new HashSet();
    public final Object b = new Object();
    public int c = 2;
    public Matrix k = new Matrix();
    public tt3 n = tt3.a();
    public tt3 o = tt3.a();

    public in4(mn4 mn4Var) {
        this.e = mn4Var;
        this.g = mn4Var;
    }

    public void A(Rect rect) {
        this.j = rect;
    }

    public final void B(mz mzVar) {
        y();
        synchronized (this.b) {
            try {
                mz mzVar2 = this.l;
                if (mzVar == mzVar2) {
                    this.a.remove(mzVar2);
                    this.l = null;
                }
                mz mzVar3 = this.m;
                if (mzVar == mzVar3) {
                    this.a.remove(mzVar3);
                    this.m = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.h = null;
        this.j = null;
        this.g = this.e;
        this.d = null;
        this.i = null;
    }

    public final void C(List list) {
        if (list.isEmpty()) {
            return;
        }
        this.n = (tt3) list.get(0);
        if (list.size() > 1) {
            this.o = (tt3) list.get(1);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            for (dn0 dn0Var : ((tt3) it.next()).b()) {
                if (dn0Var.j == null) {
                    dn0Var.j = getClass();
                }
            }
        }
    }

    public final void a(pt3 pt3Var, ih ihVar) {
        Range range = ih.h;
        if (!range.equals(ihVar.e)) {
            ((qn2) pt3Var.b.A).g(f10.j, ihVar.e);
            return;
        }
        synchronized (this.b) {
            try {
                mz mzVar = this.l;
                mzVar.getClass();
                ArrayList arrayListA = mzVar.r().n().A(AeFpsRangeQuirk.class);
                boolean z = true;
                if (arrayListA.size() > 1) {
                    z = false;
                }
                r25.f(z, "There should not have more than one AeFpsRangeQuirk.");
                if (!arrayListA.isEmpty()) {
                    Range range2 = ((AeFpsRangeLegacyQuirk) ((AeFpsRangeQuirk) arrayListA.get(0))).a;
                    if (range2 != null) {
                        range = range2;
                    }
                    ((qn2) pt3Var.b.A).g(f10.j, range);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(mz mzVar, mz mzVar2, mn4 mn4Var, mn4 mn4Var2) {
        synchronized (this.b) {
            this.l = mzVar;
            this.m = mzVar2;
            this.a.add(mzVar);
            if (mzVar2 != null) {
                this.a.add(mzVar2);
            }
        }
        this.d = mn4Var;
        this.i = mn4Var2;
        this.g = n(mzVar.r(), this.d, this.i);
        r();
    }

    public final mz c() {
        mz mzVar;
        synchronized (this.b) {
            mzVar = this.l;
        }
        return mzVar;
    }

    public final xy d() {
        synchronized (this.b) {
            try {
                mz mzVar = this.l;
                if (mzVar == null) {
                    return xy.l;
                }
                return mzVar.h();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String e() {
        mz mzVarC = c();
        r25.i(mzVarC, "No camera attached to use case: " + this);
        return mzVarC.r().d();
    }

    public abstract mn4 f(boolean z, pn4 pn4Var);

    public final String g() {
        String strF = this.g.F("<UnknownUseCase-" + hashCode() + ">");
        Objects.requireNonNull(strF);
        return strF;
    }

    public final int h(mz mzVar, boolean z) {
        int iK = mzVar.r().k(((hy1) this.g).f0(0));
        return (mzVar.p() || !z) ? iK : kg4.i(-iK);
    }

    public final mz i() {
        mz mzVar;
        synchronized (this.b) {
            mzVar = this.m;
        }
        return mzVar;
    }

    public Set j(kz kzVar) {
        return null;
    }

    public Set k() {
        return Collections.EMPTY_SET;
    }

    public abstract ln4 l(ka0 ka0Var);

    public final boolean m(mz mzVar) {
        int iQ = ((hy1) this.g).q();
        if (iQ == -1 || iQ == 0) {
            return false;
        }
        if (iQ == 1) {
            return true;
        }
        if (iQ == 2) {
            return mzVar.f();
        }
        xe.i(dw2.A(iQ, "Unknown mirrorMode: "));
        return false;
    }

    public final mn4 n(kz kzVar, mn4 mn4Var, mn4 mn4Var2) {
        qn2 qn2VarC;
        if (mn4Var2 != null) {
            qn2VarC = qn2.d(mn4Var2);
            qn2VarC.b.remove(ta4.T);
        } else {
            qn2VarC = qn2.c();
        }
        TreeMap treeMap = qn2VarC.b;
        if (this.e.K(hy1.v) || this.e.K(hy1.B)) {
            pg pgVar = hy1.F;
            if (treeMap.containsKey(pgVar)) {
                treeMap.remove(pgVar);
            }
        }
        mn4 mn4Var3 = this.e;
        pg pgVar2 = hy1.F;
        if (mn4Var3.K(pgVar2)) {
            pg pgVar3 = hy1.D;
            if (treeMap.containsKey(pgVar3) && ((sj3) this.e.u(pgVar2)).b != null) {
                treeMap.remove(pgVar3);
            }
        }
        Iterator it = this.e.t().iterator();
        while (it.hasNext()) {
            ha0.z(qn2VarC, qn2VarC, this.e, (pg) it.next());
        }
        if (mn4Var != null) {
            for (pg pgVar4 : mn4Var.t()) {
                if (!pgVar4.a.equals(ta4.T.a)) {
                    ha0.z(qn2VarC, qn2VarC, mn4Var, pgVar4);
                }
            }
        }
        if (treeMap.containsKey(hy1.B)) {
            pg pgVar5 = hy1.v;
            if (treeMap.containsKey(pgVar5)) {
                treeMap.remove(pgVar5);
            }
        }
        pg pgVar6 = hy1.F;
        if (treeMap.containsKey(pgVar6)) {
            ((sj3) qn2VarC.u(pgVar6)).getClass();
        }
        ez4.o("UseCase", "applyFeaturesToConfig: mFeatureGroup = " + this.f + ", this = " + this);
        HashSet<eq1> hashSet = this.f;
        if (hashSet != null) {
            int i = qz0.c;
            Range range = ih.h;
            ep4 ep4Var = fp4.c;
            oz0 oz0Var = oz0.d;
            for (eq1 eq1Var : hashSet) {
                if (eq1Var instanceof qz0) {
                    oz0Var = ((qz0) eq1Var).a;
                } else if (eq1Var instanceof cj1) {
                    cj1 cj1Var = (cj1) eq1Var;
                    range = new Range(Integer.valueOf(cj1Var.a), Integer.valueOf(cj1Var.b));
                } else if (eq1Var instanceof fp4) {
                    ep4Var = ((fp4) eq1Var).a;
                }
            }
            if ((this instanceof j43) || j00.F(this)) {
                qn2VarC.g(dy1.u, oz0Var);
            }
            qn2VarC.g(mn4.g0, range);
            int iOrdinal = ep4Var.ordinal();
            if (iOrdinal == 0) {
                qn2VarC.g(mn4.l0, 1);
                qn2VarC.g(mn4.m0, 1);
            } else if (iOrdinal == 1) {
                qn2VarC.g(mn4.l0, 0);
                qn2VarC.g(mn4.m0, 2);
            } else if (iOrdinal == 2) {
                qn2VarC.g(mn4.l0, 2);
                qn2VarC.g(mn4.m0, 0);
            }
        }
        return t(kzVar, l(qn2VarC));
    }

    public final void o() {
        this.c = 1;
        q();
    }

    public final void p() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            ((hn4) it.next()).e(this);
        }
    }

    public final void q() {
        int iG = fw.G(this.c);
        HashSet hashSet = this.a;
        if (iG == 0) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((hn4) it.next()).g(this);
            }
        } else {
            if (iG != 1) {
                return;
            }
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                ((hn4) it2.next()).n(this);
            }
        }
    }

    public abstract mn4 t(kz kzVar, ln4 ln4Var);

    public abstract ih w(ka0 ka0Var);

    public abstract ih x(ih ihVar, ih ihVar2);

    public abstract void y();

    public void z(Matrix matrix) {
        this.k = new Matrix(matrix);
    }

    public void r() {
    }

    public void s() {
    }

    public void u() {
    }

    public void v() {
    }
}
