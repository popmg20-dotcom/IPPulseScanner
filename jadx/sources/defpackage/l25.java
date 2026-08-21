package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class l25 {
    public final ArrayList a = new ArrayList();
    public final /* synthetic */ int b;

    public l25(int i) {
        this.b = i;
    }

    public static b25 c(ih4 ih4Var, ArrayList arrayList) {
        a35 a35Var = a35.ADD;
        je.m0("FN", 2, arrayList);
        d25 d25VarK = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0));
        d25 d25VarK2 = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1));
        if (!(d25VarK2 instanceof h15)) {
            xe.k(ha0.n("FN requires an ArrayValue of parameter names found ", d25VarK2.getClass().getCanonicalName()));
            return null;
        }
        List listJ = ((h15) d25VarK2).j();
        List arrayList2 = new ArrayList();
        if (arrayList.size() > 2) {
            arrayList2 = arrayList.subList(2, arrayList.size());
        }
        return new b25(d25VarK.h(), (ArrayList) listJ, arrayList2, ih4Var);
    }

    public static boolean d(d25 d25Var, d25 d25Var2) {
        if (d25Var instanceof v15) {
            d25Var = new i25(d25Var.h());
        }
        if (d25Var2 instanceof v15) {
            d25Var2 = new i25(d25Var2.h());
        }
        if ((d25Var instanceof i25) && (d25Var2 instanceof i25)) {
            return ((i25) d25Var).b.compareTo(((i25) d25Var2).b) < 0;
        }
        double dDoubleValue = d25Var.g().doubleValue();
        double dDoubleValue2 = d25Var2.g().doubleValue();
        return (Double.isNaN(dDoubleValue) || Double.isNaN(dDoubleValue2) || (dDoubleValue == 0.0d && dDoubleValue2 == 0.0d) || ((dDoubleValue == 0.0d && dDoubleValue2 == 0.0d) || Double.compare(dDoubleValue, dDoubleValue2) >= 0)) ? false : true;
    }

    public static d25 e(x25 x25Var, d25 d25Var, d25 d25Var2) {
        if (d25Var instanceof Iterable) {
            return g(x25Var, ((Iterable) d25Var).iterator(), d25Var2);
        }
        xe.k("Non-iterable type in for...of loop.");
        return null;
    }

    public static boolean f(d25 d25Var, d25 d25Var2) {
        if (d25Var.getClass().equals(d25Var2.getClass())) {
            if ((d25Var instanceof j25) || (d25Var instanceof a25)) {
                return true;
            }
            return d25Var instanceof p15 ? (Double.isNaN(d25Var.g().doubleValue()) || Double.isNaN(d25Var2.g().doubleValue()) || d25Var.g().doubleValue() != d25Var2.g().doubleValue()) ? false : true : d25Var instanceof i25 ? d25Var.h().equals(d25Var2.h()) : d25Var instanceof j15 ? d25Var.d().equals(d25Var2.d()) : d25Var == d25Var2;
        }
        if (((d25Var instanceof j25) || (d25Var instanceof a25)) && ((d25Var2 instanceof j25) || (d25Var2 instanceof a25))) {
            return true;
        }
        boolean z = d25Var instanceof p15;
        if (z && (d25Var2 instanceof i25)) {
            return f(d25Var, new p15(d25Var2.g()));
        }
        boolean z2 = d25Var instanceof i25;
        if (z2 && (d25Var2 instanceof p15)) {
            return f(new p15(d25Var.g()), d25Var2);
        }
        if (d25Var instanceof j15) {
            return f(new p15(d25Var.g()), d25Var2);
        }
        if (d25Var2 instanceof j15) {
            return f(d25Var, new p15(d25Var2.g()));
        }
        if ((z2 || z) && (d25Var2 instanceof v15)) {
            return f(d25Var, new i25(d25Var2.h()));
        }
        if ((d25Var instanceof v15) && ((d25Var2 instanceof i25) || (d25Var2 instanceof p15))) {
            return f(new i25(d25Var.h()), d25Var2);
        }
        return false;
    }

    public static d25 g(x25 x25Var, Iterator it, d25 d25Var) {
        ih4 ih4VarK;
        if (it != null) {
            while (it.hasNext()) {
                d25 d25Var2 = (d25) it.next();
                switch (x25Var.a) {
                    case 0:
                        ih4VarK = x25Var.b.k();
                        String str = x25Var.c;
                        ih4VarK.n(str, d25Var2);
                        ((HashMap) ih4VarK.d).put(str, Boolean.TRUE);
                        break;
                    case 1:
                        ih4VarK = x25Var.b.k();
                        ih4VarK.n(x25Var.c, d25Var2);
                        break;
                    default:
                        ih4VarK = x25Var.b;
                        ih4VarK.n(x25Var.c, d25Var2);
                        break;
                }
                d25 d25VarI = ih4VarK.i((h15) d25Var);
                if (d25VarI instanceof n15) {
                    n15 n15Var = (n15) d25VarI;
                    String str2 = n15Var.f;
                    if ("break".equals(str2)) {
                        return d25.q0;
                    }
                    if ("return".equals(str2)) {
                        return n15Var;
                    }
                }
            }
        }
        return d25.q0;
    }

    public static boolean h(d25 d25Var, d25 d25Var2) {
        if (d25Var instanceof v15) {
            d25Var = new i25(d25Var.h());
        }
        if (d25Var2 instanceof v15) {
            d25Var2 = new i25(d25Var2.h());
        }
        return (((d25Var instanceof i25) && (d25Var2 instanceof i25)) || !(Double.isNaN(d25Var.g().doubleValue()) || Double.isNaN(d25Var2.g().doubleValue()))) && !d(d25Var2, d25Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:400:0x0bb6  */
    /* JADX WARN: Removed duplicated region for block: B:564:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v315 */
    /* JADX WARN: Type inference failed for: r10v320 */
    /* JADX WARN: Type inference failed for: r10v340, types: [h15] */
    /* JADX WARN: Type inference failed for: r10v347, types: [y15] */
    /* JADX WARN: Type inference failed for: r10v382 */
    /* JADX WARN: Type inference failed for: r10v383 */
    /* JADX WARN: Type inference failed for: r12v0, types: [ih4] */
    /* JADX WARN: Type inference failed for: r7v54, types: [d25] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.d25 a(java.lang.String r11, defpackage.ih4 r12, java.util.ArrayList r13) {
        /*
            Method dump skipped, instruction units count: 3816
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l25.a(java.lang.String, ih4, java.util.ArrayList):d25");
    }

    public final void b(String str) {
        if (!this.a.contains(je.p0(str))) {
            throw new IllegalArgumentException("Command not supported");
        }
        throw new UnsupportedOperationException("Command not implemented: ".concat(String.valueOf(str)));
    }
}
