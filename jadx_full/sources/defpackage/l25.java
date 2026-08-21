package defpackage;

import com.tencent.mars.xlog.Xlog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.conscrypt.FileClientSessionCache;

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
    */
    public final d25 a(String str, ih4 ih4Var, ArrayList arrayList) {
        boolean zF;
        boolean zF2;
        d25 d25Var;
        d25 d25VarI;
        j25 j25Var;
        n15 n15Var;
        d25 i25Var;
        ?? h15Var;
        String str2;
        int i = 0;
        switch (this.b) {
            case 0:
                a35 a35Var = a35.ADD;
                switch (je.p0(str).ordinal()) {
                    case 4:
                        je.k0("BITWISE_AND", 2, arrayList);
                        return new p15(Double.valueOf(je.r0(((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0)).g().doubleValue()) & je.r0(((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1)).g().doubleValue())));
                    case 5:
                        je.k0("BITWISE_LEFT_SHIFT", 2, arrayList);
                        return new p15(Double.valueOf(je.r0(((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0)).g().doubleValue()) << ((int) (((long) je.r0(((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1)).g().doubleValue())) & 31))));
                    case 6:
                        je.k0("BITWISE_NOT", 1, arrayList);
                        return new p15(Double.valueOf(~je.r0(((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0)).g().doubleValue())));
                    case 7:
                        je.k0("BITWISE_OR", 2, arrayList);
                        return new p15(Double.valueOf(je.r0(((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0)).g().doubleValue()) | je.r0(((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1)).g().doubleValue())));
                    case 8:
                        je.k0("BITWISE_RIGHT_SHIFT", 2, arrayList);
                        return new p15(Double.valueOf(je.r0(((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0)).g().doubleValue()) >> ((int) (((long) je.r0(((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1)).g().doubleValue())) & 31))));
                    case Xlog.COMPRESS_LEVEL9 /* 9 */:
                        je.k0("BITWISE_UNSIGNED_RIGHT_SHIFT", 2, arrayList);
                        return new p15(Double.valueOf((((long) je.r0(((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0)).g().doubleValue())) & 4294967295L) >>> ((int) (((long) je.r0(((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1)).g().doubleValue())) & 31))));
                    case 10:
                        je.k0("BITWISE_XOR", 2, arrayList);
                        return new p15(Double.valueOf(je.r0(((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0)).g().doubleValue()) ^ je.r0(((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1)).g().doubleValue())));
                    default:
                        b(str);
                        throw null;
                }
            case 1:
                je.k0(je.p0(str).name(), 2, arrayList);
                d25 d25VarK = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0));
                d25 d25VarK2 = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1));
                int iOrdinal = je.p0(str).ordinal();
                if (iOrdinal != 23) {
                    if (iOrdinal == 48) {
                        zF2 = f(d25VarK, d25VarK2);
                    } else if (iOrdinal == 42) {
                        zF = d(d25VarK, d25VarK2);
                    } else if (iOrdinal != 43) {
                        switch (iOrdinal) {
                            case 37:
                                zF = d(d25VarK2, d25VarK);
                                break;
                            case 38:
                                zF = h(d25VarK2, d25VarK);
                                break;
                            case 39:
                                zF = je.q0(d25VarK, d25VarK2);
                                break;
                            case 40:
                                zF2 = je.q0(d25VarK, d25VarK2);
                                break;
                            default:
                                b(str);
                                throw null;
                        }
                    } else {
                        zF = h(d25VarK, d25VarK2);
                    }
                    zF = !zF2;
                } else {
                    zF = f(d25VarK, d25VarK2);
                }
                return zF ? d25.v0 : d25.w0;
            case 2:
                a35 a35Var2 = a35.ADD;
                int iOrdinal2 = je.p0(str).ordinal();
                if (iOrdinal2 == 2) {
                    je.k0("APPLY", 3, arrayList);
                    d25 d25Var2 = (d25) arrayList.get(0);
                    e24 e24Var = (e24) ih4Var.b;
                    e24 e24Var2 = (e24) ih4Var.b;
                    d25 d25VarK3 = e24Var.K(ih4Var, d25Var2);
                    String strH = e24Var2.K(ih4Var, (d25) arrayList.get(1)).h();
                    d25 d25VarK4 = e24Var2.K(ih4Var, (d25) arrayList.get(2));
                    if (!(d25VarK4 instanceof h15)) {
                        xe.k(ha0.n("Function arguments for Apply are not a list found ", d25VarK4.getClass().getCanonicalName()));
                        return null;
                    }
                    if (!strH.isEmpty()) {
                        return d25VarK3.f(strH, ih4Var, (ArrayList) ((h15) d25VarK4).j());
                    }
                    xe.k("Function name for apply is undefined");
                    return null;
                }
                if (iOrdinal2 == 15) {
                    je.k0("BREAK", 0, arrayList);
                    return d25.s0;
                }
                if (iOrdinal2 == 25) {
                    return c(ih4Var, arrayList);
                }
                if (iOrdinal2 != 41) {
                    if (iOrdinal2 == 54) {
                        return new h15(arrayList);
                    }
                    if (iOrdinal2 == 57) {
                        if (arrayList.isEmpty()) {
                            return d25.u0;
                        }
                        je.k0("RETURN", 1, arrayList);
                        return new n15("return", ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0)));
                    }
                    if (iOrdinal2 != 19) {
                        if (iOrdinal2 == 20) {
                            je.m0("DEFINE_FUNCTION", 2, arrayList);
                            b25 b25VarC = c(ih4Var, arrayList);
                            String str3 = b25VarC.b;
                            if (str3 == null) {
                                ih4Var.m("", b25VarC);
                                return b25VarC;
                            }
                            ih4Var.m(str3, b25VarC);
                            return b25VarC;
                        }
                        if (iOrdinal2 == 60) {
                            je.k0("SWITCH", 3, arrayList);
                            d25 d25Var3 = (d25) arrayList.get(0);
                            e24 e24Var3 = (e24) ih4Var.b;
                            e24 e24Var4 = (e24) ih4Var.b;
                            d25 d25VarK5 = e24Var3.K(ih4Var, d25Var3);
                            d25 d25VarK6 = e24Var4.K(ih4Var, (d25) arrayList.get(1));
                            d25 d25VarK7 = e24Var4.K(ih4Var, (d25) arrayList.get(2));
                            if (!(d25VarK6 instanceof h15)) {
                                xe.k("Malformed SWITCH statement, cases are not a list");
                                return null;
                            }
                            if (!(d25VarK7 instanceof h15)) {
                                xe.k("Malformed SWITCH statement, case statements are not a list");
                                return null;
                            }
                            h15 h15Var2 = (h15) d25VarK6;
                            h15 h15Var3 = (h15) d25VarK7;
                            boolean z = false;
                            for (int i2 = 0; i2 < h15Var2.l(); i2++) {
                                if (z || d25VarK5.equals(e24Var4.K(ih4Var, h15Var2.m(i2)))) {
                                    d25 d25VarK8 = e24Var4.K(ih4Var, h15Var3.m(i2));
                                    if (d25VarK8 instanceof n15) {
                                        return ((n15) d25VarK8).f.equals("break") ? d25.q0 : d25VarK8;
                                    }
                                    z = true;
                                } else {
                                    z = false;
                                }
                            }
                            if (h15Var2.l() + 1 == h15Var3.l()) {
                                d25 d25VarK9 = e24Var4.K(ih4Var, h15Var3.m(h15Var2.l()));
                                if (d25VarK9 instanceof n15) {
                                    String str4 = ((n15) d25VarK9).f;
                                    if (str4.equals("return") || str4.equals("continue")) {
                                        return d25VarK9;
                                    }
                                }
                            }
                            return d25.q0;
                        }
                        if (iOrdinal2 == 61) {
                            je.k0("TERNARY", 3, arrayList);
                            d25 d25Var4 = (d25) arrayList.get(0);
                            e24 e24Var5 = (e24) ih4Var.b;
                            e24 e24Var6 = (e24) ih4Var.b;
                            return e24Var5.K(ih4Var, d25Var4).d().booleanValue() ? e24Var6.K(ih4Var, (d25) arrayList.get(1)) : e24Var6.K(ih4Var, (d25) arrayList.get(2));
                        }
                        switch (iOrdinal2) {
                            case 11:
                                return ih4Var.k().i(new h15(arrayList));
                            case FileClientSessionCache.MAX_SIZE /* 12 */:
                                je.k0("BREAK", 0, arrayList);
                                return d25.t0;
                            case 13:
                                break;
                            default:
                                b(str);
                                throw null;
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return d25.q0;
                    }
                    d25 d25VarK10 = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0));
                    return d25VarK10 instanceof h15 ? ih4Var.i((h15) d25VarK10) : d25.q0;
                }
                je.m0("IF", 2, arrayList);
                d25 d25Var5 = (d25) arrayList.get(0);
                e24 e24Var7 = (e24) ih4Var.b;
                e24 e24Var8 = (e24) ih4Var.b;
                d25 d25VarK11 = e24Var7.K(ih4Var, d25Var5);
                d25 d25VarK12 = e24Var8.K(ih4Var, (d25) arrayList.get(1));
                d25 d25VarK13 = arrayList.size() > 2 ? e24Var8.K(ih4Var, (d25) arrayList.get(2)) : null;
                j25 j25Var2 = d25.q0;
                if (d25VarK11.d().booleanValue()) {
                    d25VarI = ih4Var.i((h15) d25VarK12);
                } else {
                    if (d25VarK13 == null) {
                        d25Var = j25Var2;
                        return true == (d25Var instanceof n15) ? j25Var2 : d25Var;
                    }
                    d25VarI = ih4Var.i((h15) d25VarK13);
                }
                d25Var = d25VarI;
                if (true == (d25Var instanceof n15)) {
                }
                break;
            case 3:
                a35 a35Var3 = a35.ADD;
                int iOrdinal3 = je.p0(str).ordinal();
                if (iOrdinal3 == 1) {
                    je.k0("AND", 2, arrayList);
                    d25 d25VarK14 = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0));
                    return d25VarK14.d().booleanValue() ? ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1)) : d25VarK14;
                }
                if (iOrdinal3 == 47) {
                    je.k0("NOT", 1, arrayList);
                    return new j15(Boolean.valueOf(!((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0)).d().booleanValue()));
                }
                if (iOrdinal3 != 50) {
                    b(str);
                    throw null;
                }
                je.k0("OR", 2, arrayList);
                d25 d25VarK15 = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0));
                return !d25VarK15.d().booleanValue() ? ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1)) : d25VarK15;
            case 4:
                a35 a35Var4 = a35.ADD;
                int iOrdinal4 = je.p0(str).ordinal();
                if (iOrdinal4 == 65) {
                    je.k0("WHILE", 4, arrayList);
                    d25 d25Var6 = (d25) arrayList.get(0);
                    d25 d25Var7 = (d25) arrayList.get(1);
                    d25 d25Var8 = (d25) arrayList.get(2);
                    d25 d25Var9 = (d25) arrayList.get(3);
                    e24 e24Var9 = (e24) ih4Var.b;
                    e24 e24Var10 = (e24) ih4Var.b;
                    d25 d25VarK16 = e24Var9.K(ih4Var, d25Var9);
                    if (e24Var10.K(ih4Var, d25Var8).d().booleanValue()) {
                        d25 d25VarI2 = ih4Var.i((h15) d25VarK16);
                        if (d25VarI2 instanceof n15) {
                            n15 n15Var2 = (n15) d25VarI2;
                            String str5 = n15Var2.f;
                            if ("break".equals(str5)) {
                                return d25.q0;
                            }
                            if ("return".equals(str5)) {
                                return n15Var2;
                            }
                        }
                    }
                    while (e24Var10.K(ih4Var, d25Var6).d().booleanValue()) {
                        d25 d25VarI3 = ih4Var.i((h15) d25VarK16);
                        if (d25VarI3 instanceof n15) {
                            n15 n15Var3 = (n15) d25VarI3;
                            String str6 = n15Var3.f;
                            if ("break".equals(str6)) {
                                return d25.q0;
                            }
                            if ("return".equals(str6)) {
                                return n15Var3;
                            }
                        }
                        ih4Var.h(d25Var7);
                    }
                    return d25.q0;
                }
                switch (iOrdinal4) {
                    case 26:
                        je.k0("FOR_IN", 3, arrayList);
                        if (!(arrayList.get(0) instanceof i25)) {
                            xe.k("Variable name in FOR_IN must be a string");
                            return null;
                        }
                        String strH2 = ((d25) arrayList.get(0)).h();
                        d25 d25VarK17 = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1));
                        d25 d25VarK18 = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(2));
                        Iterator itE = d25VarK17.e();
                        if (itE != null) {
                            while (itE.hasNext()) {
                                ih4Var.n(strH2, (d25) itE.next());
                                d25 d25VarI4 = ih4Var.i((h15) d25VarK18);
                                if (d25VarI4 instanceof n15) {
                                    n15Var = (n15) d25VarI4;
                                    String str7 = n15Var.f;
                                    if ("break".equals(str7)) {
                                        j25Var = d25.q0;
                                    } else if ("return".equals(str7)) {
                                        return n15Var;
                                    }
                                }
                            }
                            j25Var = d25.q0;
                        } else {
                            j25Var = d25.q0;
                        }
                        return j25Var;
                    case 27:
                        je.k0("FOR_IN_CONST", 3, arrayList);
                        if (arrayList.get(0) instanceof i25) {
                            return g(new x25(ih4Var, ((d25) arrayList.get(0)).h(), 0), ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1)).e(), ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(2)));
                        }
                        xe.k("Variable name in FOR_IN_CONST must be a string");
                        return null;
                    case 28:
                        je.k0("FOR_IN_LET", 3, arrayList);
                        if (!(arrayList.get(0) instanceof i25)) {
                            xe.k("Variable name in FOR_IN_LET must be a string");
                            return null;
                        }
                        String strH3 = ((d25) arrayList.get(0)).h();
                        d25 d25VarK19 = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1));
                        d25 d25VarK20 = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(2));
                        Iterator itE2 = d25VarK19.e();
                        if (itE2 != null) {
                            while (itE2.hasNext()) {
                                d25 d25Var10 = (d25) itE2.next();
                                ih4 ih4VarK = ih4Var.k();
                                ih4VarK.n(strH3, d25Var10);
                                d25 d25VarI5 = ih4VarK.i((h15) d25VarK20);
                                if (d25VarI5 instanceof n15) {
                                    n15Var = (n15) d25VarI5;
                                    String str8 = n15Var.f;
                                    if ("break".equals(str8)) {
                                        j25Var = d25.q0;
                                    } else if ("return".equals(str8)) {
                                        return n15Var;
                                    }
                                }
                            }
                            j25Var = d25.q0;
                        } else {
                            j25Var = d25.q0;
                        }
                        return j25Var;
                    case 29:
                        je.k0("FOR_LET", 4, arrayList);
                        d25 d25Var11 = (d25) arrayList.get(0);
                        e24 e24Var11 = (e24) ih4Var.b;
                        e24 e24Var12 = (e24) ih4Var.b;
                        d25 d25VarK21 = e24Var11.K(ih4Var, d25Var11);
                        if (!(d25VarK21 instanceof h15)) {
                            xe.k("Initializer variables in FOR_LET must be an ArrayList");
                            return null;
                        }
                        h15 h15Var4 = (h15) d25VarK21;
                        d25 d25Var12 = (d25) arrayList.get(1);
                        d25 d25Var13 = (d25) arrayList.get(2);
                        d25 d25VarK22 = e24Var12.K(ih4Var, (d25) arrayList.get(3));
                        ih4 ih4VarK2 = ih4Var.k();
                        for (int i3 = 0; i3 < h15Var4.l(); i3++) {
                            String strH4 = h15Var4.m(i3).h();
                            ih4VarK2.m(strH4, ih4Var.o(strH4));
                        }
                        while (e24Var12.K(ih4Var, d25Var12).d().booleanValue()) {
                            d25 d25VarI6 = ih4Var.i((h15) d25VarK22);
                            if (d25VarI6 instanceof n15) {
                                n15 n15Var4 = (n15) d25VarI6;
                                String str9 = n15Var4.f;
                                if ("break".equals(str9)) {
                                    return d25.q0;
                                }
                                if ("return".equals(str9)) {
                                    return n15Var4;
                                }
                            }
                            ih4 ih4VarK3 = ih4Var.k();
                            for (int i4 = 0; i4 < h15Var4.l(); i4++) {
                                String strH5 = h15Var4.m(i4).h();
                                ih4VarK3.m(strH5, ih4VarK2.o(strH5));
                            }
                            ih4VarK3.h(d25Var13);
                            ih4VarK2 = ih4VarK3;
                        }
                        return d25.q0;
                    case 30:
                        je.k0("FOR_OF", 3, arrayList);
                        if (arrayList.get(0) instanceof i25) {
                            return e(new x25(ih4Var, ((d25) arrayList.get(0)).h(), 2), ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1)), ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(2)));
                        }
                        xe.k("Variable name in FOR_OF must be a string");
                        return null;
                    case 31:
                        je.k0("FOR_OF_CONST", 3, arrayList);
                        if (arrayList.get(0) instanceof i25) {
                            return e(new x25(ih4Var, ((d25) arrayList.get(0)).h(), 0), ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1)), ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(2)));
                        }
                        xe.k("Variable name in FOR_OF_CONST must be a string");
                        return null;
                    case 32:
                        je.k0("FOR_OF_LET", 3, arrayList);
                        if (arrayList.get(0) instanceof i25) {
                            return e(new x25(ih4Var, ((d25) arrayList.get(0)).h(), 1), ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1)), ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(2)));
                        }
                        xe.k("Variable name in FOR_OF_LET must be a string");
                        return null;
                    default:
                        b(str);
                        throw null;
                }
            case 5:
                a35 a35Var5 = a35.ADD;
                int iOrdinal5 = je.p0(str).ordinal();
                if (iOrdinal5 == 0) {
                    je.k0("ADD", 2, arrayList);
                    d25 d25VarK23 = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0));
                    d25 d25VarK24 = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1));
                    i25Var = ((d25VarK23 instanceof v15) || (d25VarK23 instanceof i25) || (d25VarK24 instanceof v15) || (d25VarK24 instanceof i25)) ? new i25(String.valueOf(d25VarK23.h()).concat(String.valueOf(d25VarK24.h()))) : new p15(Double.valueOf(d25VarK24.g().doubleValue() + d25VarK23.g().doubleValue()));
                } else if (iOrdinal5 == 21) {
                    je.k0("DIVIDE", 2, arrayList);
                    i25Var = new p15(Double.valueOf(((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0)).g().doubleValue() / ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1)).g().doubleValue()));
                } else {
                    if (iOrdinal5 == 59) {
                        je.k0("SUBTRACT", 2, arrayList);
                        return new p15(Double.valueOf(((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0)).g().doubleValue() + (-((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1)).g().doubleValue())));
                    }
                    if (iOrdinal5 == 52 || iOrdinal5 == 53) {
                        je.k0(str, 2, arrayList);
                        d25 d25VarK25 = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0));
                        ih4Var.h((d25) arrayList.get(1));
                        return d25VarK25;
                    }
                    if (iOrdinal5 == 55 || iOrdinal5 == 56) {
                        je.k0(str, 1, arrayList);
                        return ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0));
                    }
                    switch (iOrdinal5) {
                        case 44:
                            je.k0("MODULUS", 2, arrayList);
                            i25Var = new p15(Double.valueOf(((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0)).g().doubleValue() % ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1)).g().doubleValue()));
                            break;
                        case 45:
                            je.k0("MULTIPLY", 2, arrayList);
                            return new p15(Double.valueOf(((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1)).g().doubleValue() * ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0)).g().doubleValue()));
                        case 46:
                            je.k0("NEGATE", 1, arrayList);
                            return new p15(Double.valueOf(-((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0)).g().doubleValue()));
                        default:
                            b(str);
                            throw null;
                    }
                }
                return i25Var;
            case 6:
                if (str == null || str.isEmpty() || !ih4Var.l(str)) {
                    xe.k(ha0.n("Command not found: ", str));
                    return null;
                }
                d25 d25VarO = ih4Var.o(str);
                if (d25VarO instanceof s15) {
                    return ((s15) d25VarO).j(ih4Var, arrayList);
                }
                xe.k(ha0.o("Function ", str, " is not defined"));
                return null;
            default:
                a35 a35Var6 = a35.ADD;
                int iOrdinal6 = je.p0(str).ordinal();
                if (iOrdinal6 == 3) {
                    je.k0("ASSIGN", 2, arrayList);
                    d25 d25VarK26 = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0));
                    if (!(d25VarK26 instanceof i25)) {
                        xe.k(ha0.n("Expected string for assign var. got ", d25VarK26.getClass().getCanonicalName()));
                        return null;
                    }
                    String str10 = ((i25) d25VarK26).b;
                    if (!ih4Var.l(str10)) {
                        xe.k(ha0.n("Attempting to assign undefined value ", str10));
                        return null;
                    }
                    d25 d25VarK27 = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1));
                    ih4Var.m(str10, d25VarK27);
                    return d25VarK27;
                }
                if (iOrdinal6 == 14) {
                    je.m0("CONST", 2, arrayList);
                    if (arrayList.size() % 2 != 0) {
                        xe.k(dw2.A(arrayList.size(), "CONST requires an even number of arguments, found "));
                        return null;
                    }
                    while (i < arrayList.size() - 1) {
                        d25 d25VarK28 = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(i));
                        if (!(d25VarK28 instanceof i25)) {
                            xe.k(ha0.n("Expected string for const name. got ", d25VarK28.getClass().getCanonicalName()));
                            return null;
                        }
                        String str11 = ((i25) d25VarK28).b;
                        ih4Var.n(str11, ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(i + 1)));
                        ((HashMap) ih4Var.d).put(str11, Boolean.TRUE);
                        i += 2;
                    }
                    return d25.q0;
                }
                if (iOrdinal6 == 24) {
                    je.m0("EXPRESSION_LIST", 1, arrayList);
                    h15Var = d25.q0;
                    while (i < arrayList.size()) {
                        d25 d25VarK29 = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(i));
                        if (d25VarK29 instanceof n15) {
                            xe.q("ControlValue cannot be in an expression list");
                            return null;
                        }
                        i++;
                        h15Var = d25VarK29;
                    }
                } else {
                    if (iOrdinal6 == 33) {
                        je.k0("GET", 1, arrayList);
                        d25 d25VarK30 = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0));
                        if (d25VarK30 instanceof i25) {
                            return ih4Var.o(((i25) d25VarK30).b);
                        }
                        xe.k(ha0.n("Expected string for get var. got ", d25VarK30.getClass().getCanonicalName()));
                        return null;
                    }
                    if (iOrdinal6 == 49) {
                        je.k0("NULL", 0, arrayList);
                        return d25.r0;
                    }
                    if (iOrdinal6 == 58) {
                        je.k0("SET_PROPERTY", 3, arrayList);
                        d25 d25Var14 = (d25) arrayList.get(0);
                        e24 e24Var13 = (e24) ih4Var.b;
                        e24 e24Var14 = (e24) ih4Var.b;
                        d25 d25VarK31 = e24Var13.K(ih4Var, d25Var14);
                        d25 d25VarK32 = e24Var14.K(ih4Var, (d25) arrayList.get(1));
                        d25 d25VarK33 = e24Var14.K(ih4Var, (d25) arrayList.get(2));
                        if (d25VarK31 == d25.q0 || d25VarK31 == d25.r0) {
                            xe.q(fw.u("Can't set property ", d25VarK32.h(), " of ", d25VarK31.h()));
                            return null;
                        }
                        if ((d25VarK31 instanceof h15) && (d25VarK32 instanceof p15)) {
                            ((h15) d25VarK31).o(((p15) d25VarK32).b.intValue(), d25VarK33);
                        } else if (d25VarK31 instanceof v15) {
                            ((v15) d25VarK31).b(d25VarK32.h(), d25VarK33);
                        }
                        return d25VarK33;
                    }
                    if (iOrdinal6 != 17) {
                        if (iOrdinal6 != 18) {
                            if (iOrdinal6 == 35 || iOrdinal6 == 36) {
                                je.k0("GET_PROPERTY", 2, arrayList);
                                d25 d25VarK34 = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0));
                                d25 d25VarK35 = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1));
                                if ((d25VarK34 instanceof h15) && je.o0(d25VarK35)) {
                                    return ((h15) d25VarK34).m(d25VarK35.g().intValue());
                                }
                                if (d25VarK34 instanceof v15) {
                                    return ((v15) d25VarK34).a(d25VarK35.h());
                                }
                                if (d25VarK34 instanceof i25) {
                                    if ("length".equals(d25VarK35.h())) {
                                        return new p15(Double.valueOf(((i25) d25VarK34).b.length()));
                                    }
                                    if (je.o0(d25VarK35)) {
                                        double dDoubleValue = d25VarK35.g().doubleValue();
                                        String str12 = ((i25) d25VarK34).b;
                                        if (dDoubleValue < str12.length()) {
                                            return new i25(String.valueOf(str12.charAt(d25VarK35.g().intValue())));
                                        }
                                    }
                                }
                                return d25.q0;
                            }
                            switch (iOrdinal6) {
                                case 62:
                                    je.k0("TYPEOF", 1, arrayList);
                                    d25 d25VarK36 = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0));
                                    if (d25VarK36 instanceof j25) {
                                        str2 = "undefined";
                                    } else if (d25VarK36 instanceof j15) {
                                        str2 = "boolean";
                                    } else if (d25VarK36 instanceof p15) {
                                        str2 = "number";
                                    } else if (d25VarK36 instanceof i25) {
                                        str2 = "string";
                                    } else if (d25VarK36 instanceof b25) {
                                        str2 = "function";
                                    } else {
                                        if ((d25VarK36 instanceof e25) || (d25VarK36 instanceof n15)) {
                                            zo2.p("Unsupported value type %s in typeof", new Object[]{d25VarK36});
                                            return null;
                                        }
                                        str2 = "object";
                                    }
                                    return new i25(str2);
                                case 63:
                                    je.k0("UNDEFINED", 0, arrayList);
                                    return d25.q0;
                                case 64:
                                    je.m0("VAR", 1, arrayList);
                                    Iterator it = arrayList.iterator();
                                    while (it.hasNext()) {
                                        d25 d25VarK37 = ((e24) ih4Var.b).K(ih4Var, (d25) it.next());
                                        if (!(d25VarK37 instanceof i25)) {
                                            xe.k(ha0.n("Expected string for var name. got ", d25VarK37.getClass().getCanonicalName()));
                                            return null;
                                        }
                                        ih4Var.n(((i25) d25VarK37).b, d25.q0);
                                    }
                                    return d25.q0;
                                default:
                                    b(str);
                                    throw null;
                            }
                        }
                        if (arrayList.isEmpty()) {
                            return new y15();
                        }
                        if (arrayList.size() % 2 != 0) {
                            xe.k(dw2.A(arrayList.size(), "CREATE_OBJECT requires an even number of arguments, found "));
                            return null;
                        }
                        h15Var = new y15();
                        while (i < arrayList.size() - 1) {
                            d25 d25VarK38 = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(i));
                            d25 d25VarK39 = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(i + 1));
                            if ((d25VarK38 instanceof n15) || (d25VarK39 instanceof n15)) {
                                xe.q("Failed to evaluate map entry");
                                return null;
                            }
                            h15Var.b(d25VarK38.h(), d25VarK39);
                            i += 2;
                        }
                    } else {
                        if (arrayList.isEmpty()) {
                            return new h15();
                        }
                        h15Var = new h15();
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            d25 d25VarK40 = ((e24) ih4Var.b).K(ih4Var, (d25) it2.next());
                            if (d25VarK40 instanceof n15) {
                                xe.q("Failed to evaluate array element");
                                return null;
                            }
                            h15Var.o(i, d25VarK40);
                            i++;
                        }
                    }
                }
                return h15Var;
        }
    }

    public final void b(String str) {
        if (!this.a.contains(je.p0(str))) {
            throw new IllegalArgumentException("Command not supported");
        }
        throw new UnsupportedOperationException("Command not implemented: ".concat(String.valueOf(str)));
    }
}
