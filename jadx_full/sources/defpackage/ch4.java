package defpackage;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ch4 extends vg4 {
    public int Z0;
    public ArrayList X0 = new ArrayList();
    public boolean Y0 = true;
    public boolean a1 = false;
    public int b1 = 0;

    @Override // defpackage.vg4
    public final void C(View view) {
        super.C(view);
        int size = this.X0.size();
        for (int i = 0; i < size; i++) {
            ((vg4) this.X0.get(i)).C(view);
        }
    }

    @Override // defpackage.vg4
    public final void D() {
        this.Q0 = 0L;
        int i = 0;
        bh4 bh4Var = new bh4(this, i);
        while (i < this.X0.size()) {
            vg4 vg4Var = (vg4) this.X0.get(i);
            vg4Var.a(bh4Var);
            vg4Var.D();
            long j = vg4Var.Q0;
            boolean z = this.Y0;
            long j2 = this.Q0;
            if (z) {
                this.Q0 = Math.max(j2, j);
            } else {
                vg4Var.S0 = j2;
                this.Q0 = j2 + j;
            }
            i++;
        }
    }

    @Override // defpackage.vg4
    public final vg4 E(tg4 tg4Var) {
        super.E(tg4Var);
        return this;
    }

    @Override // defpackage.vg4
    public final void G(View view) {
        for (int i = 0; i < this.X0.size(); i++) {
            ((vg4) this.X0.get(i)).G(view);
        }
        this.Y.remove(view);
    }

    @Override // defpackage.vg4
    public final void H(View view) {
        super.H(view);
        int size = this.X0.size();
        for (int i = 0; i < size; i++) {
            ((vg4) this.X0.get(i)).H(view);
        }
    }

    @Override // defpackage.vg4
    public final void J() {
        ArrayList arrayList;
        if (this.X0.isEmpty()) {
            S();
            n();
            return;
        }
        bh4 bh4Var = new bh4();
        bh4Var.b = this;
        Iterator it = this.X0.iterator();
        while (it.hasNext()) {
            ((vg4) it.next()).a(bh4Var);
        }
        this.Z0 = this.X0.size();
        if (this.Y0) {
            Iterator it2 = this.X0.iterator();
            while (it2.hasNext()) {
                ((vg4) it2.next()).J();
            }
            return;
        }
        int i = 1;
        while (true) {
            int size = this.X0.size();
            arrayList = this.X0;
            if (i >= size) {
                break;
            }
            ((vg4) arrayList.get(i - 1)).a(new bh4((vg4) this.X0.get(i), 2));
            i++;
        }
        vg4 vg4Var = (vg4) arrayList.get(0);
        if (vg4Var != null) {
            vg4Var.J();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    @Override // defpackage.vg4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void K(long j, long j2) {
        long j3;
        long j4 = this.Q0;
        long j5 = 0;
        if (this.B0 != null) {
            if (j < 0 && j2 < 0) {
                return;
            }
            if (j > j4 && j2 > j4) {
                return;
            }
        }
        boolean z = j < j2;
        if ((j >= 0 && j2 < 0) || (j <= j4 && j2 > j4)) {
            this.K0 = false;
            B(this, e04.f, z);
        }
        if (!this.Y0) {
            int size = 1;
            while (true) {
                int size2 = this.X0.size();
                ArrayList arrayList = this.X0;
                if (size >= size2) {
                    size = arrayList.size();
                    break;
                } else if (((vg4) arrayList.get(size)).S0 > j2) {
                    break;
                } else {
                    size++;
                }
            }
            int i = size - 1;
            if (j >= j2) {
                while (i < this.X0.size()) {
                    vg4 vg4Var = (vg4) this.X0.get(i);
                    long j6 = vg4Var.S0;
                    j3 = j5;
                    long j7 = j - j6;
                    if (j7 < j3) {
                        break;
                    }
                    vg4Var.K(j7, j2 - j6);
                    i++;
                    j5 = j3;
                }
            } else {
                j3 = 0;
                while (i >= 0) {
                    vg4 vg4Var2 = (vg4) this.X0.get(i);
                    long j8 = vg4Var2.S0;
                    long j9 = j - j8;
                    vg4Var2.K(j9, j2 - j8);
                    if (j9 >= 0) {
                        break;
                    } else {
                        i--;
                    }
                }
            }
            if (this.B0 == null) {
                if ((j <= j4 || j2 > j4) && (j >= 0 || j2 < j3)) {
                    return;
                }
                if (j > j4) {
                    this.K0 = true;
                }
                B(this, e04.z, z);
                return;
            }
            return;
        }
        for (int i2 = 0; i2 < this.X0.size(); i2++) {
            ((vg4) this.X0.get(i2)).K(j, j2);
        }
        j3 = j5;
        if (this.B0 == null) {
        }
    }

    @Override // defpackage.vg4
    public final void N(ek0 ek0Var) {
        this.O0 = ek0Var;
        this.b1 |= 8;
        int size = this.X0.size();
        for (int i = 0; i < size; i++) {
            ((vg4) this.X0.get(i)).N(ek0Var);
        }
    }

    @Override // defpackage.vg4
    public final void P(ek0 ek0Var) {
        super.P(ek0Var);
        this.b1 |= 4;
        if (this.X0 != null) {
            for (int i = 0; i < this.X0.size(); i++) {
                ((vg4) this.X0.get(i)).P(ek0Var);
            }
        }
    }

    @Override // defpackage.vg4
    public final void Q() {
        this.b1 |= 2;
        int size = this.X0.size();
        for (int i = 0; i < size; i++) {
            ((vg4) this.X0.get(i)).Q();
        }
    }

    @Override // defpackage.vg4
    public final void R(long j) {
        this.f = j;
    }

    @Override // defpackage.vg4
    public final String T(String str) {
        String strT = super.T(str);
        for (int i = 0; i < this.X0.size(); i++) {
            StringBuilder sbQ = ha0.q(strT, "\n");
            sbQ.append(((vg4) this.X0.get(i)).T(str.concat("  ")));
            strT = sbQ.toString();
        }
        return strT;
    }

    public final void U(vg4 vg4Var) {
        this.X0.add(vg4Var);
        vg4Var.B0 = this;
        long j = this.z;
        if (j >= 0) {
            vg4Var.L(j);
        }
        if ((this.b1 & 1) != 0) {
            vg4Var.O(this.A);
        }
        if ((this.b1 & 2) != 0) {
            vg4Var.Q();
        }
        if ((this.b1 & 4) != 0) {
            vg4Var.P(this.P0);
        }
        if ((this.b1 & 8) != 0) {
            vg4Var.N(this.O0);
        }
    }

    public final vg4 V(int i) {
        if (i < 0 || i >= this.X0.size()) {
            return null;
        }
        return (vg4) this.X0.get(i);
    }

    @Override // defpackage.vg4
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public final void L(long j) {
        ArrayList arrayList;
        this.z = j;
        if (j < 0 || (arrayList = this.X0) == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((vg4) this.X0.get(i)).L(j);
        }
    }

    @Override // defpackage.vg4
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public final void O(TimeInterpolator timeInterpolator) {
        this.b1 |= 1;
        ArrayList arrayList = this.X0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((vg4) this.X0.get(i)).O(timeInterpolator);
            }
        }
        this.A = timeInterpolator;
    }

    public final void Y(int i) {
        if (i == 0) {
            this.Y0 = true;
        } else {
            if (i != 1) {
                throw new AndroidRuntimeException(dw2.A(i, "Invalid parameter for TransitionSet ordering: "));
            }
            this.Y0 = false;
        }
    }

    @Override // defpackage.vg4
    public final void b(View view) {
        for (int i = 0; i < this.X0.size(); i++) {
            ((vg4) this.X0.get(i)).b(view);
        }
        this.Y.add(view);
    }

    @Override // defpackage.vg4
    public final void d() {
        super.d();
        int size = this.X0.size();
        for (int i = 0; i < size; i++) {
            ((vg4) this.X0.get(i)).d();
        }
    }

    @Override // defpackage.vg4
    public final void e(hh4 hh4Var) {
        if (z(hh4Var.b)) {
            for (vg4 vg4Var : this.X0) {
                if (vg4Var.z(hh4Var.b)) {
                    vg4Var.e(hh4Var);
                    hh4Var.c.add(vg4Var);
                }
            }
        }
    }

    @Override // defpackage.vg4
    public final void g(hh4 hh4Var) {
        int size = this.X0.size();
        for (int i = 0; i < size; i++) {
            ((vg4) this.X0.get(i)).g(hh4Var);
        }
    }

    @Override // defpackage.vg4
    public final void h(hh4 hh4Var) {
        if (z(hh4Var.b)) {
            for (vg4 vg4Var : this.X0) {
                if (vg4Var.z(hh4Var.b)) {
                    vg4Var.h(hh4Var);
                    hh4Var.c.add(vg4Var);
                }
            }
        }
    }

    @Override // defpackage.vg4
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public final vg4 clone() {
        ch4 ch4Var = (ch4) super.clone();
        ch4Var.X0 = new ArrayList();
        int size = this.X0.size();
        for (int i = 0; i < size; i++) {
            vg4 vg4VarClone = ((vg4) this.X0.get(i)).clone();
            ch4Var.X0.add(vg4VarClone);
            vg4VarClone.B0 = ch4Var;
        }
        return ch4Var;
    }

    @Override // defpackage.vg4
    public final void m(ViewGroup viewGroup, ih4 ih4Var, ih4 ih4Var2, ArrayList arrayList, ArrayList arrayList2) {
        long j = this.f;
        int size = this.X0.size();
        for (int i = 0; i < size; i++) {
            vg4 vg4Var = (vg4) this.X0.get(i);
            if (j > 0 && (this.Y0 || i == 0)) {
                long j2 = vg4Var.f;
                if (j2 > 0) {
                    vg4Var.R(j2 + j);
                } else {
                    vg4Var.R(j);
                }
            }
            vg4Var.m(viewGroup, ih4Var, ih4Var2, arrayList, arrayList2);
        }
    }

    @Override // defpackage.vg4
    public final vg4 o(View view) {
        throw null;
    }

    @Override // defpackage.vg4
    public final void p() {
        for (int i = 0; i < this.X0.size(); i++) {
            ((vg4) this.X0.get(i)).p();
        }
        super.p();
    }

    @Override // defpackage.vg4
    public final boolean w() {
        for (int i = 0; i < this.X0.size(); i++) {
            if (((vg4) this.X0.get(i)).w()) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.vg4
    public final boolean x() {
        int size = this.X0.size();
        for (int i = 0; i < size; i++) {
            if (!((vg4) this.X0.get(i)).x()) {
                return false;
            }
        }
        return true;
    }
}
