package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ul {
    public static final Class[] j = new Class[0];
    public boolean a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;
    public Object h;
    public Object i;

    public ul(nj4 nj4Var) {
        this.b = nj4Var;
    }

    public static ul d(yg2 yg2Var, nj4 nj4Var, w8 w8Var) {
        List list = Collections.EMPTY_LIST;
        List list2 = Collections.EMPTY_LIST;
        ul ulVar = new ul(nj4Var);
        ulVar.c = null;
        ulVar.d = yg2Var;
        if (yg2Var == null) {
            ulVar.e = null;
        } else {
            ulVar.e = yg2Var.d();
        }
        ulVar.f = w8Var;
        ulVar.h = list2;
        return ulVar;
    }

    public List a() {
        List list = (List) this.h;
        if (list != null) {
            return list;
        }
        by2 by2Var = (by2) this.c;
        if (!by2Var.i) {
            by2Var.h();
        }
        ArrayList arrayList = new ArrayList(by2Var.j.values());
        this.h = arrayList;
        return arrayList;
    }

    public e52 b() {
        by2 by2Var = (by2) this.c;
        if (by2Var == null) {
            return e52.y0;
        }
        e52 e52Var = by2Var.t;
        if (e52Var != null) {
            return e52Var;
        }
        cu2 cu2Var = by2Var.f;
        e52 e52VarH = cu2Var != null ? cu2Var.h(by2Var.d) : null;
        Class cls = by2Var.c.L0;
        e52 e52Var2 = e52.y0;
        if (e52Var2 != null) {
            e52VarH = e52VarH == null ? e52Var2 : e52VarH.d(e52Var2);
        }
        if (e52VarH != null) {
            e52Var2 = e52VarH;
        }
        by2Var.t = e52Var2;
        return e52Var2;
    }

    public c9 c() {
        by2 by2Var = (by2) this.c;
        if (by2Var != null) {
            if (!by2Var.i) {
                by2Var.h();
            }
            LinkedList linkedList = by2Var.r;
            if (linkedList != null) {
                if (linkedList.size() <= 1 || by2.g(by2Var.r)) {
                    return (c9) by2Var.r.get(0);
                }
                by2Var.i("Multiple 'as-value' properties defined (%s vs %s)", by2Var.r.get(0), by2Var.r.get(1));
                throw null;
            }
        }
        return null;
    }
}
