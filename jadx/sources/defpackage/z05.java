package defpackage;

import j$.util.DesugarCollections;
import java.math.BigDecimal;
import java.util.ArrayList;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Boolean e(java.math.BigDecimal r8, defpackage.k55 r9, double r10) {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z05.e(java.math.BigDecimal, k55, double):java.lang.Boolean");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.Long r22, java.lang.Long r23, defpackage.w75 r24, long r25, defpackage.w25 r27, boolean r28) {
        /*
            Method dump skipped, instruction units count: 1085
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z05.a(java.lang.Long, java.lang.Long, w75, long, w25, boolean):boolean");
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
