package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yp2 {
    public final m24 a = n24.a(zp2.Z);
    public final m24 b;
    public final fe3 c;
    public final ae d;
    public final ae e;
    public qu2 f;
    public int g;
    public xp2 h;
    public final LinkedHashSet i;
    public final LinkedHashSet j;
    public final LinkedHashSet k;
    public boolean l;
    public boolean m;
    public boolean n;

    public yp2() {
        m24 m24VarA = n24.a(new wp2());
        this.b = m24VarA;
        this.c = new fe3(m24VarA);
        this.d = new ae();
        this.e = new ae();
        this.i = new LinkedHashSet();
        this.j = new LinkedHashSet();
        this.k = new LinkedHashSet();
    }

    public final void a(iv1 iv1Var, xp2 xp2Var, int i) {
        iv1Var.getClass();
        if (xp2Var.a == null) {
            (i != 0 ? i != 1 ? this.i : this.j : this.k).add(xp2Var);
            xp2Var.a = iv1Var;
            ((wp2) this.c.b.i()).getClass();
            xp2Var.b(i != 0 ? i != 1 ? this.n : this.l : this.m);
            return;
        }
        StringBuilder sb = new StringBuilder("Input '");
        sb.append(xp2Var);
        iv1 iv1Var2 = xp2Var.a;
        sb.append("' is already added to dispatcher ");
        sb.append(iv1Var2);
        sb.append('.');
        throw new IllegalArgumentException(sb.toString().toString());
    }

    public final void b() {
        boolean z;
        boolean z2;
        wp2 wp2Var;
        ae aeVar = this.d;
        if (aeVar.isEmpty()) {
            z = false;
        } else {
            Iterator it = aeVar.iterator();
            while (it.hasNext()) {
                if (((qu2) it.next()).b) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        ae aeVar2 = this.e;
        if (aeVar2.isEmpty()) {
            z2 = false;
        } else {
            Iterator it2 = aeVar2.iterator();
            while (it2.hasNext()) {
                if (((qu2) it2.next()).b) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        boolean z3 = z || z2;
        boolean z4 = this.m != z;
        boolean z5 = this.l != z2;
        boolean z6 = this.n != z3;
        LinkedHashSet linkedHashSet = this.k;
        if (z4) {
            Iterator it3 = linkedHashSet.iterator();
            while (it3.hasNext()) {
                ((xp2) it3.next()).b(z);
            }
        }
        LinkedHashSet linkedHashSet2 = this.j;
        if (z5) {
            Iterator it4 = linkedHashSet2.iterator();
            while (it4.hasNext()) {
                ((xp2) it4.next()).b(z2);
            }
        }
        LinkedHashSet linkedHashSet3 = this.i;
        if (z6) {
            Iterator it5 = linkedHashSet3.iterator();
            while (it5.hasNext()) {
                ((xp2) it5.next()).b(z3);
            }
        }
        this.m = z;
        this.l = z2;
        this.n = z3;
        qu2 qu2VarC = this.f;
        if (qu2VarC == null) {
            qu2VarC = c(0);
        }
        qu2 qu2VarC2 = this.f;
        if (qu2VarC2 == null) {
            qu2VarC2 = c(0);
        }
        if (n12.c(qu2VarC2, qu2VarC)) {
            if (qu2VarC2 == null) {
                wp2Var = new wp2();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator<E> it6 = aeVar.iterator();
                while (it6.hasNext()) {
                    ((qu2) it6.next()).getClass();
                }
                Iterator<E> it7 = aeVar2.iterator();
                while (it7.hasNext()) {
                    ((qu2) it7.next()).getClass();
                }
                su2 su2Var = qu2VarC2.a;
                ub2 ub2VarI = p95.i();
                d70.U(arrayList, ub2VarI);
                ub2VarI.add(su2Var);
                d70.U(g41.b, ub2VarI);
                wp2Var = new wp2(arrayList.size(), p95.c(ub2VarI));
            }
            m24 m24Var = this.b;
            if (n12.c((wp2) m24Var.i(), wp2Var)) {
                return;
            }
            m24Var.j(null, wp2Var);
            Iterator it8 = linkedHashSet.iterator();
            while (it8.hasNext()) {
                ((xp2) it8.next()).getClass();
            }
            Iterator it9 = linkedHashSet2.iterator();
            while (it9.hasNext()) {
                ((xp2) it9.next()).getClass();
            }
            Iterator it10 = linkedHashSet3.iterator();
            while (it10.hasNext()) {
                ((xp2) it10.next()).getClass();
            }
        }
    }

    public final qu2 c(int i) {
        Object next;
        Object next2;
        ae aeVar = this.e;
        ae aeVar2 = this.d;
        Object obj = null;
        if (i == -1) {
            Iterator it = aeVar2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((qu2) next).b) {
                    break;
                }
            }
            qu2 qu2Var = (qu2) next;
            if (qu2Var != null) {
                return qu2Var;
            }
            Iterator it2 = aeVar.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next3 = it2.next();
                if (((qu2) next3).b) {
                    obj = next3;
                    break;
                }
            }
            return (qu2) obj;
        }
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException(("Unsupported direction: '" + i + "'.").toString());
            }
            Iterator it3 = aeVar2.iterator();
            while (it3.hasNext()) {
                ((qu2) it3.next()).getClass();
            }
            Iterator it4 = aeVar.iterator();
            while (it4.hasNext()) {
                ((qu2) it4.next()).getClass();
            }
            return null;
        }
        Iterator it5 = aeVar2.iterator();
        while (true) {
            if (!it5.hasNext()) {
                next2 = null;
                break;
            }
            next2 = it5.next();
            if (((qu2) next2).b) {
                break;
            }
        }
        qu2 qu2Var2 = (qu2) next2;
        if (qu2Var2 != null) {
            return qu2Var2;
        }
        Iterator it6 = aeVar.iterator();
        while (true) {
            if (!it6.hasNext()) {
                break;
            }
            Object next4 = it6.next();
            if (((qu2) next4).b) {
                obj = next4;
                break;
            }
        }
        return (qu2) obj;
    }
}
