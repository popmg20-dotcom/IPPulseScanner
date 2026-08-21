package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class iv0 extends ge1 {
    public final ge1 f;

    public iv0(ge1 ge1Var) {
        ge1Var.getClass();
        this.f = ge1Var;
    }

    @Override // defpackage.ge1
    public final List I(u03 u03Var) {
        List<u03> listI = this.f.I(u03Var);
        ArrayList arrayList = new ArrayList();
        for (u03 u03Var2 : listI) {
            u03Var2.getClass();
            arrayList.add(u03Var2);
        }
        h70.S(arrayList);
        return arrayList;
    }

    @Override // defpackage.ge1
    public final no0 N(u03 u03Var) {
        u03Var.getClass();
        no0 no0VarN = this.f.N(u03Var);
        if (no0VarN == null) {
            return null;
        }
        u03 u03Var2 = (u03) no0VarN.d;
        if (u03Var2 == null) {
            return no0VarN;
        }
        boolean z = no0VarN.b;
        boolean z2 = no0VarN.c;
        Long l = (Long) no0VarN.e;
        Long l2 = (Long) no0VarN.f;
        Long l3 = (Long) no0VarN.g;
        Long l4 = (Long) no0VarN.h;
        Map map = (Map) no0VarN.i;
        map.getClass();
        return new no0(z, z2, u03Var2, l, l2, l3, l4, map);
    }

    @Override // defpackage.ge1
    public final w72 Q(u03 u03Var) {
        return this.f.Q(u03Var);
    }

    @Override // defpackage.ge1
    public final vx3 U(u03 u03Var) {
        u03 u03VarB = u03Var.b();
        if (u03VarB != null) {
            ae aeVar = new ae();
            while (u03VarB != null && !F(u03VarB)) {
                aeVar.addFirst(u03VarB);
                u03VarB = u03VarB.b();
            }
            Iterator<E> it = aeVar.iterator();
            while (it.hasNext()) {
                s((u03) it.next());
            }
        }
        return this.f.U(u03Var);
    }

    @Override // defpackage.ge1
    public final lz3 X(u03 u03Var) {
        u03Var.getClass();
        return this.f.X(u03Var);
    }

    @Override // defpackage.ge1, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f.close();
    }

    @Override // defpackage.ge1
    public final vx3 g(u03 u03Var) {
        return this.f.g(u03Var);
    }

    @Override // defpackage.ge1
    public final void n(u03 u03Var, u03 u03Var2) {
        u03Var2.getClass();
        this.f.n(u03Var, u03Var2);
    }

    @Override // defpackage.ge1
    public final void s(u03 u03Var) {
        u03Var.getClass();
        this.f.s(u03Var);
    }

    public final String toString() {
        return dh3.a(iv0.class).c() + '(' + this.f + ')';
    }

    @Override // defpackage.ge1
    public final void x(u03 u03Var) {
        u03Var.getClass();
        this.f.x(u03Var);
    }
}
