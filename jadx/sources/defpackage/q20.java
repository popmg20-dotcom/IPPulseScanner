package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q20 extends nt4 {
    public final ArrayList k;
    public int l;

    public q20(jc0 jc0Var, int i) {
        jc0 jc0Var2;
        super(jc0Var);
        ArrayList<nt4> arrayList = new ArrayList();
        this.k = arrayList;
        this.f = i;
        jc0 jc0Var3 = this.b;
        jc0 jc0VarK = jc0Var3.k(i);
        while (true) {
            jc0Var2 = jc0Var3;
            jc0Var3 = jc0VarK;
            if (jc0Var3 == null) {
                break;
            } else {
                jc0VarK = jc0Var3.k(this.f);
            }
        }
        this.b = jc0Var2;
        int i2 = this.f;
        arrayList.add(i2 == 0 ? jc0Var2.d : i2 == 1 ? jc0Var2.e : null);
        jc0 jc0VarJ = jc0Var2.j(this.f);
        while (jc0VarJ != null) {
            int i3 = this.f;
            arrayList.add(i3 == 0 ? jc0VarJ.d : i3 == 1 ? jc0VarJ.e : null);
            jc0VarJ = jc0VarJ.j(this.f);
        }
        for (nt4 nt4Var : arrayList) {
            int i4 = this.f;
            if (i4 == 0) {
                nt4Var.b.b = this;
            } else if (i4 == 1) {
                nt4Var.b.c = this;
            }
        }
        if (this.f == 0 && this.b.S.u0 && arrayList.size() > 1) {
            this.b = ((nt4) fw.r(arrayList, 1)).b;
        }
        int i5 = this.f;
        jc0 jc0Var4 = this.b;
        this.l = i5 == 0 ? jc0Var4.h0 : jc0Var4.i0;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d9  */
    @Override // defpackage.io0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(defpackage.io0 r28) {
        /*
            Method dump skipped, instruction units count: 939
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.q20.a(io0):void");
    }

    @Override // defpackage.nt4
    public final void d() {
        ArrayList arrayList = this.k;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((nt4) it.next()).d();
        }
        int size = arrayList.size();
        if (size < 1) {
            return;
        }
        jc0 jc0Var = ((nt4) arrayList.get(0)).b;
        jc0 jc0Var2 = ((nt4) arrayList.get(size - 1)).b;
        int i = this.f;
        oo0 oo0Var = this.i;
        oo0 oo0Var2 = this.h;
        if (i == 0) {
            lb0 lb0Var = jc0Var.H;
            lb0 lb0Var2 = jc0Var2.J;
            oo0 oo0VarI = nt4.i(lb0Var, 0);
            int iD = lb0Var.d();
            jc0 jc0VarM = m();
            if (jc0VarM != null) {
                iD = jc0VarM.H.d();
            }
            if (oo0VarI != null) {
                nt4.b(oo0Var2, oo0VarI, iD);
            }
            oo0 oo0VarI2 = nt4.i(lb0Var2, 0);
            int iD2 = lb0Var2.d();
            jc0 jc0VarN = n();
            if (jc0VarN != null) {
                iD2 = jc0VarN.J.d();
            }
            if (oo0VarI2 != null) {
                nt4.b(oo0Var, oo0VarI2, -iD2);
            }
        } else {
            lb0 lb0Var3 = jc0Var.I;
            lb0 lb0Var4 = jc0Var2.K;
            oo0 oo0VarI3 = nt4.i(lb0Var3, 1);
            int iD3 = lb0Var3.d();
            jc0 jc0VarM2 = m();
            if (jc0VarM2 != null) {
                iD3 = jc0VarM2.I.d();
            }
            if (oo0VarI3 != null) {
                nt4.b(oo0Var2, oo0VarI3, iD3);
            }
            oo0 oo0VarI4 = nt4.i(lb0Var4, 1);
            int iD4 = lb0Var4.d();
            jc0 jc0VarN2 = n();
            if (jc0VarN2 != null) {
                iD4 = jc0VarN2.K.d();
            }
            if (oo0VarI4 != null) {
                nt4.b(oo0Var, oo0VarI4, -iD4);
            }
        }
        oo0Var2.a = this;
        oo0Var.a = this;
    }

    @Override // defpackage.nt4
    public final void e() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.k;
            if (i >= arrayList.size()) {
                return;
            }
            ((nt4) arrayList.get(i)).e();
            i++;
        }
    }

    @Override // defpackage.nt4
    public final void f() {
        this.c = null;
        Iterator it = this.k.iterator();
        while (it.hasNext()) {
            ((nt4) it.next()).f();
        }
    }

    @Override // defpackage.nt4
    public final long j() {
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            nt4 nt4Var = (nt4) arrayList.get(i);
            j = ((long) nt4Var.i.f) + nt4Var.j() + j + ((long) nt4Var.h.f);
        }
        return j;
    }

    @Override // defpackage.nt4
    public final boolean k() {
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (!((nt4) arrayList.get(i)).k()) {
                return false;
            }
        }
        return true;
    }

    public final jc0 m() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.k;
            if (i >= arrayList.size()) {
                return null;
            }
            jc0 jc0Var = ((nt4) arrayList.get(i)).b;
            if (jc0Var.f0 != 8) {
                return jc0Var;
            }
            i++;
        }
    }

    public final jc0 n() {
        ArrayList arrayList = this.k;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            jc0 jc0Var = ((nt4) arrayList.get(size)).b;
            if (jc0Var.f0 != 8) {
                return jc0Var;
            }
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.f == 0 ? "horizontal : " : "vertical : ");
        for (nt4 nt4Var : this.k) {
            sb.append("<");
            sb.append(nt4Var);
            sb.append("> ");
        }
        return sb.toString();
    }
}
