package defpackage;

import android.util.Log;
import j$.util.DesugarCollections;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z05 {
    public final String a;
    public final int b;
    public Boolean c;
    public Boolean d;
    public Long e;
    public Long f;
    public final /* synthetic */ int g;
    public final /* synthetic */ e15 h;
    public final dc5 i;

    public z05(e15 e15Var, String str, int i, dc5 dc5Var, int i2) {
        this.g = i2;
        this.h = e15Var;
        this.a = str;
        this.b = i;
        this.i = dc5Var;
    }

    public static Boolean c(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Boolean d(String str, n55 n55Var, t65 t65Var) {
        List listS;
        tj4.i(n55Var);
        if (str != null && n55Var.n() && n55Var.v() != 1 && (n55Var.v() != 7 ? n55Var.o() : n55Var.t() != 0)) {
            int iV = n55Var.v();
            boolean zR = n55Var.r();
            String strP = (zR || iV == 2 || iV == 7) ? n55Var.p() : n55Var.p().toUpperCase(Locale.ENGLISH);
            if (n55Var.t() == 0) {
                listS = null;
            } else {
                listS = n55Var.s();
                if (!zR) {
                    ArrayList arrayList = new ArrayList(listS.size());
                    Iterator it = listS.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((String) it.next()).toUpperCase(Locale.ENGLISH));
                    }
                    listS = DesugarCollections.unmodifiableList(arrayList);
                }
            }
            String str2 = iV == 2 ? strP : null;
            if (iV != 7 ? strP != null : listS != null && !listS.isEmpty()) {
                if (!zR && iV != 2) {
                    str = str.toUpperCase(Locale.ENGLISH);
                }
                switch (iV - 1) {
                    case 1:
                        if (str2 != null) {
                            try {
                                return Boolean.valueOf(Pattern.compile(str2, true != zR ? 66 : 0).matcher(str).matches());
                            } catch (PatternSyntaxException unused) {
                                if (t65Var != null) {
                                    t65Var.C0.b(str2, "Invalid regular expression in REGEXP audience filter. expression");
                                }
                            }
                        }
                        break;
                    case 2:
                        return Boolean.valueOf(str.startsWith(strP));
                    case 3:
                        return Boolean.valueOf(str.endsWith(strP));
                    case 4:
                        return Boolean.valueOf(str.contains(strP));
                    case 5:
                        return Boolean.valueOf(str.equals(strP));
                    case 6:
                        if (listS != null) {
                            return Boolean.valueOf(listS.contains(str));
                        }
                        break;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Boolean e(BigDecimal bigDecimal, k55 k55Var, double d) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        int i;
        tj4.i(k55Var);
        if (k55Var.n()) {
            if (k55Var.x() != 1 && (k55Var.x() != 5 ? k55Var.q() : k55Var.s() && k55Var.u())) {
                int iX = k55Var.x();
                try {
                    if (k55Var.x() == 5) {
                        if (z65.B1(k55Var.t()) && z65.B1(k55Var.v())) {
                            BigDecimal bigDecimal5 = new BigDecimal(k55Var.t());
                            bigDecimal4 = new BigDecimal(k55Var.v());
                            bigDecimal3 = bigDecimal5;
                            bigDecimal2 = null;
                            if (iX == 5 ? bigDecimal2 != null : bigDecimal3 != null) {
                                i = iX - 1;
                                if (i != 1) {
                                    if (i != 2) {
                                        if (i != 3) {
                                            if (i == 4 && bigDecimal3 != null) {
                                                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal3) >= 0 && bigDecimal.compareTo(bigDecimal4) <= 0);
                                            }
                                        } else if (bigDecimal2 != null) {
                                            if (d != 0.0d) {
                                                return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d).multiply(new BigDecimal(2)))) > 0 && bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d).multiply(new BigDecimal(2)))) < 0);
                                            }
                                            return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) == 0);
                                        }
                                    } else if (bigDecimal2 != null) {
                                        return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) > 0);
                                    }
                                } else if (bigDecimal2 != null) {
                                    return Boolean.valueOf(bigDecimal.compareTo(bigDecimal2) < 0);
                                }
                            }
                        }
                    } else if (z65.B1(k55Var.r())) {
                        bigDecimal2 = new BigDecimal(k55Var.r());
                        bigDecimal3 = null;
                        bigDecimal4 = null;
                        if (iX == 5) {
                            i = iX - 1;
                            if (i != 1) {
                            }
                        } else {
                            i = iX - 1;
                            if (i != 1) {
                            }
                        }
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x03c9 A[EDGE_INSN: B:234:0x03c9->B:161:0x03c9 BREAK  A[LOOP:3: B:89:0x0246->B:238:0x0246], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x017c  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(Long l, Long l2, w75 w75Var, long j, w25 w25Var, boolean z) {
        boolean z2;
        t65 t65Var;
        Boolean boolE;
        Boolean boolE2;
        long j2;
        Boolean boolE3;
        Boolean boolE4;
        int i;
        uf5.a();
        e15 e15Var = this.h;
        k85 k85Var = (k85) e15Var.f;
        x15 x15Var = k85Var.A;
        t65 t65Var2 = k85Var.Y;
        k65 k65Var = k85Var.A0;
        q55 q55Var = r55.G0;
        String str = this.a;
        boolean zF1 = x15Var.f1(str, q55Var);
        f55 f55Var = (f55) this.i;
        long j3 = f55Var.y() ? w25Var.e : j;
        k85.h(t65Var2);
        q65 q65Var = t65Var2.H0;
        q65 q65Var2 = t65Var2.C0;
        boolean zIsLoggable = Log.isLoggable(t65Var2.b1(), 2);
        int i2 = this.b;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        Boolean bool = null;
        if (zIsLoggable) {
            k85.h(t65Var2);
            q65Var.d("Evaluating filter. audience, filter, event", Integer.valueOf(i2), f55Var.n() ? Integer.valueOf(f55Var.o()) : null, k65Var.a(f55Var.p()));
            k85.h(t65Var2);
            z65 z65Var = e15Var.X.Z;
            ff5.R(z65Var);
            StringBuilder sb = new StringBuilder();
            sb.append("\nevent_filter {\n");
            if (f55Var.n()) {
                i = 0;
                z65.n1(sb, 0, "filter_id", Integer.valueOf(f55Var.o()));
            } else {
                i = 0;
            }
            z65.n1(sb, i, "event_name", ((k85) z65Var.f).A0.a(f55Var.p()));
            String strJ1 = z65.j1(f55Var.v(), f55Var.w(), f55Var.y());
            if (!strJ1.isEmpty()) {
                z65.n1(sb, 0, "filter_type", strJ1);
            }
            if (f55Var.t()) {
                z65.o1(sb, 1, "event_count_filter", f55Var.u());
            }
            if (f55Var.r() > 0) {
                sb.append("  filters {\n");
                Iterator it = f55Var.q().iterator();
                while (it.hasNext()) {
                    z65Var.g1(sb, 2, (h55) it.next());
                }
            }
            z65.h1(1, sb);
            sb.append("}\n}\n");
            q65Var.b(sb.toString(), "Filter definition");
        }
        if (!f55Var.n() || f55Var.o() > 256) {
            k85.h(t65Var2);
            q65Var2.c("Invalid event filter ID. appId, id", t65.Z0(str), String.valueOf(f55Var.n() ? Integer.valueOf(f55Var.o()) : null));
            return false;
        }
        boolean z3 = f55Var.v() || f55Var.w() || f55Var.y();
        if (z && !z3) {
            k85.h(t65Var2);
            q65Var.c("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(i2), f55Var.n() ? Integer.valueOf(f55Var.o()) : null);
            return true;
        }
        String strQ = w75Var.q();
        if (f55Var.t()) {
            try {
                boolE4 = e(new BigDecimal(j3), f55Var.u(), 0.0d);
            } catch (NumberFormatException unused) {
                boolE4 = null;
            }
            if (boolE4 != null) {
                if (boolE4.booleanValue()) {
                    HashSet hashSet = new HashSet();
                    Iterator it2 = f55Var.q().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            ie ieVar = new ie(0);
                            Iterator it3 = w75Var.n().iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    Iterator it4 = f55Var.q().iterator();
                                    while (true) {
                                        if (!it4.hasNext()) {
                                            z2 = zF1;
                                            t65Var = t65Var2;
                                            bool = Boolean.TRUE;
                                            break;
                                        }
                                        h55 h55Var = (h55) it4.next();
                                        boolean z4 = h55Var.r() && h55Var.s();
                                        String strU = h55Var.u();
                                        if (strU.isEmpty()) {
                                            k85.h(t65Var2);
                                            q65Var2.b(k65Var.a(strQ), "Event has empty param name. event");
                                            break;
                                        }
                                        Object obj = ieVar.get(strU);
                                        if (obj instanceof Long) {
                                            if (!h55Var.p()) {
                                                k85.h(t65Var2);
                                                q65Var2.c("No number filter for long param. event, param", k65Var.a(strQ), k65Var.b(strU));
                                                break;
                                            }
                                            try {
                                                boolE = e(new BigDecimal(((Long) obj).longValue()), h55Var.q(), 0.0d);
                                            } catch (NumberFormatException unused2) {
                                                boolE = null;
                                            }
                                            if (boolE == null) {
                                                break;
                                            }
                                            if (boolE.booleanValue() == z4) {
                                                bool = Boolean.FALSE;
                                                break;
                                            }
                                        } else if (obj instanceof Double) {
                                            if (!h55Var.p()) {
                                                k85.h(t65Var2);
                                                q65Var2.c("No number filter for double param. event, param", k65Var.a(strQ), k65Var.b(strU));
                                                break;
                                            }
                                            double dDoubleValue = ((Double) obj).doubleValue();
                                            try {
                                                boolE2 = e(new BigDecimal(dDoubleValue), h55Var.q(), Math.ulp(dDoubleValue));
                                            } catch (NumberFormatException unused3) {
                                                boolE2 = null;
                                            }
                                            if (boolE2 == null) {
                                                break;
                                            }
                                            if (boolE2.booleanValue() == z4) {
                                                bool = Boolean.FALSE;
                                                break;
                                            }
                                        } else if (obj instanceof String) {
                                            if (!h55Var.n()) {
                                                if (!h55Var.p()) {
                                                    z2 = zF1;
                                                    t65Var = t65Var2;
                                                    k85.h(t65Var);
                                                    q65Var2.c("No filter for String param. event, param", k65Var.a(strQ), k65Var.b(strU));
                                                    break;
                                                }
                                                String str2 = (String) obj;
                                                if (!z65.B1(str2)) {
                                                    z2 = zF1;
                                                    t65Var = t65Var2;
                                                    k85.h(t65Var);
                                                    q65Var2.c("Invalid param value for number filter. event, param", k65Var.a(strQ), k65Var.b(strU));
                                                    break;
                                                }
                                                k55 k55VarQ = h55Var.q();
                                                if (z65.B1(str2)) {
                                                    try {
                                                        z2 = zF1;
                                                        t65Var = t65Var2;
                                                        j2 = 0;
                                                    } catch (NumberFormatException unused4) {
                                                        z2 = zF1;
                                                        t65Var = t65Var2;
                                                        j2 = 0;
                                                    }
                                                    try {
                                                        boolE3 = e(new BigDecimal(str2), k55VarQ, 0.0d);
                                                    } catch (NumberFormatException unused5) {
                                                        boolE3 = null;
                                                    }
                                                    if (boolE3 == null) {
                                                        break;
                                                    }
                                                    if (boolE3.booleanValue() == z4) {
                                                        bool = Boolean.FALSE;
                                                        break;
                                                    }
                                                    t65Var2 = t65Var;
                                                    zF1 = z2;
                                                } else {
                                                    z2 = zF1;
                                                    t65Var = t65Var2;
                                                    boolE3 = null;
                                                }
                                            } else {
                                                n55 n55VarO = h55Var.o();
                                                k85.h(t65Var2);
                                                boolE3 = d((String) obj, n55VarO, t65Var2);
                                                z2 = zF1;
                                                t65Var = t65Var2;
                                            }
                                            j2 = 0;
                                            if (boolE3 == null) {
                                            }
                                        } else {
                                            z2 = zF1;
                                            t65Var = t65Var2;
                                            if (obj == null) {
                                                k85.h(t65Var);
                                                q65Var.c("Missing param for filter. event, param", k65Var.a(strQ), k65Var.b(strU));
                                                bool = Boolean.FALSE;
                                            } else {
                                                k85.h(t65Var);
                                                q65Var2.c("Unknown param type. event, param", k65Var.a(strQ), k65Var.b(strU));
                                            }
                                        }
                                    }
                                } else {
                                    b85 b85Var = (b85) it3.next();
                                    if (hashSet.contains(b85Var.o())) {
                                        if (!b85Var.r()) {
                                            if (!b85Var.v()) {
                                                if (!b85Var.p()) {
                                                    k85.h(t65Var2);
                                                    q65Var2.c("Unknown value for param. event, param", k65Var.a(strQ), k65Var.b(b85Var.o()));
                                                    break;
                                                }
                                                ieVar.put(b85Var.o(), b85Var.q());
                                            } else {
                                                ieVar.put(b85Var.o(), b85Var.v() ? Double.valueOf(b85Var.w()) : null);
                                            }
                                        } else {
                                            ieVar.put(b85Var.o(), b85Var.r() ? Long.valueOf(b85Var.s()) : null);
                                        }
                                    }
                                }
                            }
                        } else {
                            h55 h55Var2 = (h55) it2.next();
                            if (h55Var2.u().isEmpty()) {
                                k85.h(t65Var2);
                                q65Var2.b(k65Var.a(strQ), "null or empty param name in filter. event");
                                break;
                            }
                            hashSet.add(h55Var2.u());
                        }
                    }
                } else {
                    bool = Boolean.FALSE;
                }
            }
            z2 = zF1;
            t65Var = t65Var2;
        }
        k85.h(t65Var);
        q65Var.b(bool == null ? "null" : bool, "Event filter result");
        if (bool == null) {
            return false;
        }
        Boolean bool2 = Boolean.TRUE;
        this.c = bool2;
        if (!bool.booleanValue()) {
            return true;
        }
        this.d = bool2;
        if (!z3 || !w75Var.r()) {
            return true;
        }
        Long lValueOf = Long.valueOf(w75Var.s());
        if (f55Var.w()) {
            if (z2 && f55Var.t()) {
                lValueOf = l;
            }
            this.f = lValueOf;
            return true;
        }
        if (z2 && f55Var.t()) {
            lValueOf = l2;
        }
        this.e = lValueOf;
        return true;
    }

    public boolean b(Long l, Long l2, a95 a95Var, boolean z) {
        boolean z2;
        Boolean boolC;
        Boolean boolE;
        Boolean boolE2;
        Boolean boolE3;
        uf5.a();
        k85 k85Var = (k85) this.h.f;
        x15 x15Var = k85Var.A;
        k65 k65Var = k85Var.A0;
        t65 t65Var = k85Var.Y;
        boolean zF1 = x15Var.f1(this.a, r55.E0);
        m55 m55Var = (m55) this.i;
        boolean zR = m55Var.r();
        boolean zS = m55Var.s();
        boolean zU = m55Var.u();
        boolean z3 = zR || zS || zU;
        if (z && !z3) {
            k85.h(t65Var);
            t65Var.H0.c("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.b), m55Var.n() ? Integer.valueOf(m55Var.o()) : null);
            return true;
        }
        h55 h55VarQ = m55Var.q();
        boolean zS2 = h55VarQ.s();
        if (!a95Var.s()) {
            z2 = zU;
            if (!a95Var.w()) {
                if (!a95Var.q()) {
                    k85.h(t65Var);
                    t65Var.C0.b(k65Var.c(a95Var.p()), "User property has no value, property");
                } else if (h55VarQ.n()) {
                    String strR = a95Var.r();
                    n55 n55VarO = h55VarQ.o();
                    k85.h(t65Var);
                    boolC = c(d(strR, n55VarO, t65Var), zS2);
                } else if (!h55VarQ.p()) {
                    k85.h(t65Var);
                    t65Var.C0.b(k65Var.c(a95Var.p()), "No string or number filter defined. property");
                } else if (z65.B1(a95Var.r())) {
                    String strR2 = a95Var.r();
                    k55 k55VarQ = h55VarQ.q();
                    if (z65.B1(strR2)) {
                        try {
                            boolE = e(new BigDecimal(strR2), k55VarQ, 0.0d);
                        } catch (NumberFormatException unused) {
                            boolE = null;
                        }
                        boolC = c(boolE, zS2);
                    } else {
                        boolE = null;
                        boolC = c(boolE, zS2);
                    }
                } else {
                    k85.h(t65Var);
                    t65Var.C0.c("Invalid user property value for Numeric number filter. property, value", k65Var.c(a95Var.p()), a95Var.r());
                }
                boolC = null;
            } else if (h55VarQ.p()) {
                double dX = a95Var.x();
                try {
                    boolE2 = e(new BigDecimal(dX), h55VarQ.q(), Math.ulp(dX));
                } catch (NumberFormatException unused2) {
                    boolE2 = null;
                }
                boolC = c(boolE2, zS2);
            } else {
                k85.h(t65Var);
                t65Var.C0.b(k65Var.c(a95Var.p()), "No number filter for double property. property");
                boolC = null;
            }
        } else if (h55VarQ.p()) {
            z2 = zU;
            try {
                boolE3 = e(new BigDecimal(a95Var.t()), h55VarQ.q(), 0.0d);
            } catch (NumberFormatException unused3) {
                boolE3 = null;
            }
            boolC = c(boolE3, zS2);
        } else {
            k85.h(t65Var);
            t65Var.C0.b(k65Var.c(a95Var.p()), "No number filter for long property. property");
            z2 = zU;
            boolC = null;
        }
        k85.h(t65Var);
        t65Var.H0.b(boolC == null ? "null" : boolC, "Property filter result");
        if (boolC == null) {
            return false;
        }
        this.c = Boolean.TRUE;
        if (!z2 || boolC.booleanValue()) {
            if (!z || m55Var.r()) {
                this.d = boolC;
            }
            if (boolC.booleanValue() && z3 && a95Var.n()) {
                long jO = a95Var.o();
                if (l != null) {
                    jO = l.longValue();
                }
                if (zF1 && m55Var.r() && !m55Var.s() && l2 != null) {
                    jO = l2.longValue();
                }
                if (m55Var.s()) {
                    this.f = Long.valueOf(jO);
                } else {
                    this.e = Long.valueOf(jO);
                }
            }
        }
        return true;
    }
}
