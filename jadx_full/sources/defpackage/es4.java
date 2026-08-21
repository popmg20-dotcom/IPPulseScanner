package defpackage;

import android.graphics.Rect;
import android.util.Size;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class es4 implements hn4 {
    public final HashMap A0;
    public final uj3 B0;
    public final uj3 C0;
    public final pn4 X;
    public final mz Y;
    public final mz Z;
    public final HashSet b;
    public final HashSet z0;
    public final HashMap f = new HashMap();
    public final HashMap z = new HashMap();
    public final HashMap A = new HashMap();
    public final vl2 y0 = new vl2(this);

    public es4(mz mzVar, mz mzVar2, HashSet hashSet, pn4 pn4Var, e04 e04Var) {
        this.Y = mzVar;
        this.Z = mzVar2;
        this.X = pn4Var;
        this.b = hashSet;
        HashMap map = new HashMap();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            in4 in4Var = (in4) it.next();
            map.put(in4Var, in4Var.n(mzVar.r(), null, in4Var.f(true, pn4Var)));
        }
        this.A0 = map;
        HashSet hashSet2 = new HashSet(map.values());
        this.z0 = hashSet2;
        this.B0 = new uj3(mzVar, hashSet2);
        if (this.Z != null) {
            this.C0 = new uj3(this.Z, hashSet2);
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            in4 in4Var2 = (in4) it2.next();
            this.A.put(in4Var2, Boolean.FALSE);
            this.z.put(in4Var2, new ds4(mzVar, this, e04Var));
        }
    }

    public static void s(c74 c74Var, dn0 dn0Var, tt3 tt3Var) {
        c74Var.d();
        try {
            co4.h();
            c74Var.a();
            b74 b74Var = c74Var.l;
            b74Var.g(dn0Var, new y64(b74Var, 0));
        } catch (cn0 unused) {
            rt3 rt3Var = tt3Var.f;
            if (rt3Var != null) {
                rt3Var.a(tt3Var);
            }
        }
    }

    public static dn0 t(in4 in4Var) {
        List listB = in4Var instanceof xx1 ? in4Var.n.b() : DesugarCollections.unmodifiableList(in4Var.n.g.a);
        r25.j(null, listB.size() <= 1);
        if (listB.size() == 1) {
            return (dn0) listB.get(0);
        }
        return null;
    }

    public final bh d(in4 in4Var, uj3 uj3Var, mz mzVar, c74 c74Var, int i, boolean z) {
        int iK = mzVar.b().k(i);
        boolean zE = kg4.e(c74Var.b);
        mn4 mn4Var = (mn4) this.A0.get(in4Var);
        Objects.requireNonNull(mn4Var);
        e43 e43VarB = uj3Var.b(mn4Var, c74Var.d, kg4.b(c74Var.b), z);
        Rect rect = e43VarB.a;
        Size size = e43VarB.b;
        int i2 = kg4.i((c74Var.i + mzVar.b().k(((hy1) in4Var.g).f0(0))) - iK);
        return new bh(UUID.randomUUID(), in4Var instanceof j43 ? 1 : in4Var instanceof xx1 ? 4 : 2, in4Var instanceof xx1 ? 256 : 34, rect, kg4.g(size, i2), i2, in4Var.m(mzVar) ^ zE);
    }

    @Override // defpackage.hn4
    public final void e(in4 in4Var) {
        dn0 dn0VarT;
        co4.h();
        c74 c74VarV = v(in4Var);
        if (w(in4Var) && (dn0VarT = t(in4Var)) != null) {
            s(c74VarV, dn0VarT, in4Var.n);
        }
    }

    @Override // defpackage.hn4
    public final void g(in4 in4Var) {
        co4.h();
        if (w(in4Var)) {
            return;
        }
        this.A.put(in4Var, Boolean.TRUE);
        dn0 dn0VarT = t(in4Var);
        if (dn0VarT != null) {
            s(v(in4Var), dn0VarT, in4Var.n);
        }
    }

    @Override // defpackage.hn4
    public final void j(in4 in4Var) {
        co4.h();
        if (w(in4Var)) {
            c74 c74VarV = v(in4Var);
            dn0 dn0VarT = t(in4Var);
            if (dn0VarT != null) {
                s(c74VarV, dn0VarT, in4Var.n);
                return;
            }
            co4.h();
            c74VarV.a();
            c74VarV.l.a();
        }
    }

    @Override // defpackage.hn4
    public final void n(in4 in4Var) {
        co4.h();
        if (w(in4Var)) {
            this.A.put(in4Var, Boolean.FALSE);
            c74 c74VarV = v(in4Var);
            co4.h();
            c74VarV.a();
            c74VarV.l.a();
        }
    }

    public final HashMap u(c74 c74Var, boolean z) {
        HashMap map = new HashMap();
        for (in4 in4Var : this.b) {
            mn4 mn4Var = (mn4) this.A0.get(in4Var);
            Objects.requireNonNull(mn4Var);
            Size size = this.B0.b(mn4Var, c74Var.d, kg4.b(c74Var.b), z).c;
            map.put(in4Var, size);
            ez4.o("VirtualCameraAdapter", "Selected child size: " + size + ", useCase: " + in4Var);
        }
        return map;
    }

    public final c74 v(in4 in4Var) {
        c74 c74Var = (c74) this.f.get(in4Var);
        Objects.requireNonNull(c74Var);
        return c74Var;
    }

    public final boolean w(in4 in4Var) {
        Boolean bool = (Boolean) this.A.get(in4Var);
        Objects.requireNonNull(bool);
        return bool.booleanValue();
    }

    public final void x(HashMap map, HashMap map2) {
        HashMap map3 = this.f;
        map3.clear();
        map3.putAll(map);
        for (Map.Entry entry : map3.entrySet()) {
            in4 in4Var = (in4) entry.getKey();
            c74 c74Var = (c74) entry.getValue();
            in4Var.A(c74Var.d);
            in4Var.z(c74Var.b);
            r90 r90VarB = c74Var.g.b();
            Size size = (Size) map2.get(in4Var);
            if (size != null) {
                r90VarB.b = size;
            }
            in4Var.h = in4Var.x(r90VarB.e(), null);
            in4Var.q();
        }
    }
}
