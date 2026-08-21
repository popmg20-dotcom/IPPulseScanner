package defpackage;

import io.sentry.android.core.cache.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h15 implements Iterable, d25, v15 {
    public final TreeMap b;
    public final TreeMap f;

    public h15(List list) {
        this();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                o(i, (d25) list.get(i));
            }
        }
    }

    @Override // defpackage.v15
    public final d25 a(String str) {
        d25 d25Var;
        return "length".equals(str) ? new p15(Double.valueOf(l())) : (!c(str) || (d25Var = (d25) this.f.get(str)) == null) ? d25.q0 : d25Var;
    }

    @Override // defpackage.v15
    public final void b(String str, d25 d25Var) {
        TreeMap treeMap = this.f;
        if (d25Var == null) {
            treeMap.remove(str);
        } else {
            treeMap.put(str, d25Var);
        }
    }

    @Override // defpackage.v15
    public final boolean c(String str) {
        return "length".equals(str) || this.f.containsKey(str);
    }

    @Override // defpackage.d25
    public final Boolean d() {
        return Boolean.TRUE;
    }

    @Override // defpackage.d25
    public final Iterator e() {
        return new c15(this, this.b.keySet().iterator(), this.f.keySet().iterator());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h15)) {
            return false;
        }
        h15 h15Var = (h15) obj;
        if (l() != h15Var.l()) {
            return false;
        }
        TreeMap treeMap = this.b;
        if (treeMap.isEmpty()) {
            return h15Var.b.isEmpty();
        }
        for (int iIntValue = ((Integer) treeMap.firstKey()).intValue(); iIntValue <= ((Integer) treeMap.lastKey()).intValue(); iIntValue++) {
            if (!m(iIntValue).equals(h15Var.m(iIntValue))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x02dc, code lost:
    
        if (defpackage.ez4.f0(r7, r2, (defpackage.b25) r0, java.lang.Boolean.FALSE, java.lang.Boolean.TRUE).l() == r7.l()) goto L169;
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x052c  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x05d2  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0604  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0722  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0730  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x0797  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x07fe  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0816  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01fe  */
    @Override // defpackage.d25
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d25 f(String str, ih4 ih4Var, ArrayList arrayList) {
        String str2;
        String str3;
        Object obj;
        String str4;
        ih4 ih4Var2;
        String str5;
        Object obj2;
        h15 h15Var;
        ArrayList arrayList2;
        int iHashCode;
        TreeMap treeMap;
        double dL;
        String strH;
        s15 s15Var;
        String str6 = "toString";
        String str7 = "splice";
        if (!"concat".equals(str) && !"every".equals(str) && !"filter".equals(str) && !"forEach".equals(str) && !"indexOf".equals(str) && !"join".equals(str) && !"lastIndexOf".equals(str) && !"map".equals(str) && !"pop".equals(str) && !"push".equals(str) && !"reduce".equals(str) && !"reduceRight".equals(str) && !"reverse".equals(str) && !"shift".equals(str) && !"slice".equals(str) && !"some".equals(str)) {
            str3 = "filter";
            str4 = "sort";
            if (str4.equals(str)) {
                str2 = "lastIndexOf";
                obj2 = "reduce";
            } else {
                obj2 = "reduce";
                if (str7.equals(str)) {
                    str2 = "lastIndexOf";
                    str7 = str7;
                } else {
                    str7 = str7;
                    if (str6.equals(str)) {
                        str2 = "lastIndexOf";
                        str6 = str6;
                    } else {
                        str6 = str6;
                        if (!"unshift".equals(str)) {
                            return qe4.v(this, new i25(str), ih4Var, arrayList);
                        }
                        str2 = "lastIndexOf";
                        str5 = "forEach";
                        obj = "unshift";
                        h15Var = this;
                        ih4Var2 = ih4Var;
                    }
                }
            }
            obj = "unshift";
            ih4Var2 = ih4Var;
            arrayList2 = arrayList;
            str5 = "forEach";
            h15Var = this;
            Double dValueOf = Double.valueOf(-1.0d);
            iHashCode = str.hashCode();
            TreeMap treeMap2 = h15Var.b;
            d25 d25VarK = d25.q0;
            TreeMap treeMap3 = treeMap2;
            double dL2 = 0.0d;
            switch (iHashCode) {
                case -1776922004:
                    String str8 = str6;
                    if (str.equals(str8)) {
                        je.k0(str8, 0, arrayList2);
                        return new i25(h15Var.r(","));
                    }
                    xe.k("Command not supported");
                    return null;
                case -1354795244:
                    if (str.equals("concat")) {
                        h15 h15Var2 = (h15) h15Var.i();
                        if (!arrayList2.isEmpty()) {
                            Iterator it = arrayList2.iterator();
                            while (it.hasNext()) {
                                d25 d25VarK2 = ((e24) ih4Var2.b).K(ih4Var2, (d25) it.next());
                                if (d25VarK2 instanceof n15) {
                                    xe.q("Failed evaluation of arguments");
                                    return null;
                                }
                                int iL = h15Var2.l();
                                if (d25VarK2 instanceof h15) {
                                    h15 h15Var3 = (h15) d25VarK2;
                                    Iterator itK = h15Var3.k();
                                    while (itK.hasNext()) {
                                        Integer num = (Integer) itK.next();
                                        h15Var2.o(num.intValue() + iL, h15Var3.m(num.intValue()));
                                    }
                                } else {
                                    h15Var2.o(iL, d25VarK2);
                                }
                            }
                        }
                        return h15Var2;
                    }
                    xe.k("Command not supported");
                    return null;
                case -1274492040:
                    String str9 = str3;
                    if (str.equals(str9)) {
                        je.k0(str9, 1, arrayList2);
                        d25 d25VarK3 = ((e24) ih4Var2.b).K(ih4Var2, (d25) arrayList2.get(0));
                        if (!(d25VarK3 instanceof b25)) {
                            xe.k("Callback should be a method");
                            return null;
                        }
                        if (treeMap3.size() == 0) {
                            return new h15();
                        }
                        h15 h15Var4 = (h15) h15Var.i();
                        h15 h15VarF0 = ez4.f0(h15Var, ih4Var2, (b25) d25VarK3, null, Boolean.TRUE);
                        h15 h15Var5 = new h15();
                        Iterator itK2 = h15VarF0.k();
                        while (itK2.hasNext()) {
                            h15Var5.o(h15Var5.l(), h15Var4.m(((Integer) itK2.next()).intValue()));
                        }
                        return h15Var5;
                    }
                    xe.k("Command not supported");
                    return null;
                case -934873754:
                    if (str.equals(obj2)) {
                        return ez4.e0(h15Var, ih4Var2, arrayList2, true);
                    }
                    xe.k("Command not supported");
                    return null;
                case -895859076:
                    if (str.equals(str7)) {
                        if (arrayList2.isEmpty()) {
                            return new h15();
                        }
                        d25 d25Var = (d25) arrayList2.get(0);
                        e24 e24Var = (e24) ih4Var2.b;
                        e24 e24Var2 = (e24) ih4Var2.b;
                        int iS0 = (int) je.s0(e24Var.K(ih4Var2, d25Var).g().doubleValue());
                        if (iS0 < 0) {
                            iS0 = Math.max(0, h15Var.l() + iS0);
                        } else if (iS0 > h15Var.l()) {
                            iS0 = h15Var.l();
                        }
                        int iL2 = h15Var.l();
                        h15 h15Var6 = new h15();
                        if (arrayList2.size() > 1) {
                            int iMax = Math.max(0, (int) je.s0(e24Var2.K(ih4Var2, (d25) arrayList2.get(1)).g().doubleValue()));
                            if (iMax > 0) {
                                for (int i = iS0; i < Math.min(iL2, iS0 + iMax); i++) {
                                    h15Var6.o(h15Var6.l(), h15Var.m(iS0));
                                    h15Var.q(iS0);
                                }
                            }
                            int i2 = 2;
                            if (arrayList2.size() > 2) {
                                while (i2 < arrayList2.size()) {
                                    d25 d25VarK4 = e24Var2.K(ih4Var2, (d25) arrayList2.get(i2));
                                    if (d25VarK4 instanceof n15) {
                                        xe.k("Failed to parse elements to add");
                                        return null;
                                    }
                                    int i3 = (iS0 + i2) - 2;
                                    if (i3 < 0) {
                                        a.b(String.valueOf(i3).length() + 21, i3, "Invalid value index: ");
                                        return null;
                                    }
                                    if (i3 >= h15Var.l()) {
                                        h15Var.o(i3, d25VarK4);
                                        treeMap = treeMap3;
                                    } else {
                                        int iIntValue = ((Integer) treeMap3.lastKey()).intValue();
                                        while (iIntValue >= i3) {
                                            Integer numValueOf = Integer.valueOf(iIntValue);
                                            TreeMap treeMap4 = treeMap3;
                                            d25 d25Var2 = (d25) treeMap4.get(numValueOf);
                                            if (d25Var2 != null) {
                                                h15Var.o(iIntValue + 1, d25Var2);
                                                treeMap4.remove(numValueOf);
                                            }
                                            iIntValue--;
                                            treeMap3 = treeMap4;
                                        }
                                        treeMap = treeMap3;
                                        h15Var.o(i3, d25VarK4);
                                    }
                                    i2++;
                                    treeMap3 = treeMap;
                                }
                            }
                        } else {
                            while (iS0 < iL2) {
                                h15Var6.o(h15Var6.l(), h15Var.m(iS0));
                                h15Var.o(iS0, null);
                                iS0++;
                            }
                        }
                        return h15Var6;
                    }
                    xe.k("Command not supported");
                    return null;
                case -678635926:
                    String str10 = str5;
                    if (str.equals(str10)) {
                        je.k0(str10, 1, arrayList2);
                        d25 d25VarK5 = ((e24) ih4Var2.b).K(ih4Var2, (d25) arrayList2.get(0));
                        if (!(d25VarK5 instanceof b25)) {
                            xe.k("Callback should be a method");
                            return null;
                        }
                        if (treeMap3.size() != 0) {
                            ez4.f0(h15Var, ih4Var2, (b25) d25VarK5, null, null);
                            return d25VarK;
                        }
                        return d25VarK;
                    }
                    xe.k("Command not supported");
                    return null;
                case -467511597:
                    String str11 = str2;
                    if (str.equals(str11)) {
                        je.n0(str11, 2, arrayList2);
                        if (!arrayList2.isEmpty()) {
                            d25VarK = ((e24) ih4Var2.b).K(ih4Var2, (d25) arrayList2.get(0));
                        }
                        d25 d25Var3 = d25VarK;
                        int iL3 = h15Var.l() - 1;
                        if (arrayList2.size() > 1) {
                            d25 d25VarK6 = ((e24) ih4Var2.b).K(ih4Var2, (d25) arrayList2.get(1));
                            dL = Double.isNaN(d25VarK6.g().doubleValue()) ? h15Var.l() - 1 : je.s0(d25VarK6.g().doubleValue());
                            if (dL < 0.0d) {
                                dL += (double) h15Var.l();
                            }
                        } else {
                            dL = iL3;
                        }
                        if (dL < 0.0d) {
                            return new p15(dValueOf);
                        }
                        for (int iMin = (int) Math.min(h15Var.l(), dL); iMin >= 0; iMin--) {
                            if (h15Var.p(iMin) && je.q0(h15Var.m(iMin), d25Var3)) {
                                return new p15(Double.valueOf(iMin));
                            }
                        }
                        return new p15(dValueOf);
                    }
                    xe.k("Command not supported");
                    return null;
                case -277637751:
                    if (str.equals(obj)) {
                        if (!arrayList2.isEmpty()) {
                            h15 h15Var7 = new h15();
                            Iterator it2 = arrayList2.iterator();
                            while (it2.hasNext()) {
                                d25 d25VarK7 = ((e24) ih4Var2.b).K(ih4Var2, (d25) it2.next());
                                if (d25VarK7 instanceof n15) {
                                    xe.q("Argument evaluation failed");
                                    return null;
                                }
                                h15Var7.o(h15Var7.l(), d25VarK7);
                            }
                            int iL4 = h15Var7.l();
                            Iterator itK3 = h15Var.k();
                            while (itK3.hasNext()) {
                                Integer num2 = (Integer) itK3.next();
                                h15Var7.o(num2.intValue() + iL4, h15Var.m(num2.intValue()));
                            }
                            treeMap3.clear();
                            Iterator itK4 = h15Var7.k();
                            while (itK4.hasNext()) {
                                Integer num3 = (Integer) itK4.next();
                                h15Var.o(num3.intValue(), h15Var7.m(num3.intValue()));
                            }
                        }
                        return new p15(Double.valueOf(h15Var.l()));
                    }
                    xe.k("Command not supported");
                    return null;
                case 107868:
                    if (str.equals("map")) {
                        je.k0("map", 1, arrayList2);
                        d25 d25VarK8 = ((e24) ih4Var2.b).K(ih4Var2, (d25) arrayList2.get(0));
                        if (d25VarK8 instanceof b25) {
                            return h15Var.l() == 0 ? new h15() : ez4.f0(h15Var, ih4Var2, (b25) d25VarK8, null, null);
                        }
                        xe.k("Callback should be a method");
                        return null;
                    }
                    xe.k("Command not supported");
                    return null;
                case 111185:
                    if (str.equals("pop")) {
                        je.k0("pop", 0, arrayList2);
                        int iL5 = h15Var.l();
                        if (iL5 != 0) {
                            int i4 = iL5 - 1;
                            d25 d25VarM = h15Var.m(i4);
                            h15Var.q(i4);
                            return d25VarM;
                        }
                        return d25VarK;
                    }
                    xe.k("Command not supported");
                    return null;
                case 3267882:
                    if (str.equals("join")) {
                        je.n0("join", 1, arrayList2);
                        if (h15Var.l() == 0) {
                            return d25.x0;
                        }
                        if (arrayList2.isEmpty()) {
                            strH = ",";
                        } else {
                            d25 d25VarK9 = ((e24) ih4Var2.b).K(ih4Var2, (d25) arrayList2.get(0));
                            strH = ((d25VarK9 instanceof a25) || (d25VarK9 instanceof j25)) ? "" : d25VarK9.h();
                        }
                        return new i25(h15Var.r(strH));
                    }
                    xe.k("Command not supported");
                    return null;
                case 3452698:
                    if (str.equals("push")) {
                        if (!arrayList2.isEmpty()) {
                            Iterator it3 = arrayList2.iterator();
                            while (it3.hasNext()) {
                                h15Var.o(h15Var.l(), ((e24) ih4Var2.b).K(ih4Var2, (d25) it3.next()));
                            }
                        }
                        return new p15(Double.valueOf(h15Var.l()));
                    }
                    xe.k("Command not supported");
                    return null;
                case 3536116:
                    if (str.equals("some")) {
                        je.k0("some", 1, arrayList2);
                        d25 d25VarK10 = ((e24) ih4Var2.b).K(ih4Var2, (d25) arrayList2.get(0));
                        if (!(d25VarK10 instanceof s15)) {
                            xe.k("Callback should be a method");
                            return null;
                        }
                        if (h15Var.l() != 0) {
                            s15 s15Var2 = (s15) d25VarK10;
                            Iterator itK5 = h15Var.k();
                            while (itK5.hasNext()) {
                                int iIntValue2 = ((Integer) itK5.next()).intValue();
                                if (h15Var.p(iIntValue2) && s15Var2.j(ih4Var2, Arrays.asList(h15Var.m(iIntValue2), new p15(Double.valueOf(iIntValue2)), h15Var)).d().booleanValue()) {
                                    return d25.v0;
                                }
                            }
                        }
                        return d25.w0;
                    }
                    xe.k("Command not supported");
                    return null;
                case 3536286:
                    if (str.equals(str4)) {
                        je.n0(str4, 1, arrayList2);
                        if (h15Var.l() >= 2) {
                            List listJ = h15Var.j();
                            if (arrayList2.isEmpty()) {
                                s15Var = null;
                            } else {
                                d25 d25VarK11 = ((e24) ih4Var2.b).K(ih4Var2, (d25) arrayList2.get(0));
                                if (!(d25VarK11 instanceof s15)) {
                                    xe.k("Comparator should be a method");
                                    return null;
                                }
                                s15Var = (s15) d25VarK11;
                            }
                            Collections.sort(listJ, new ze(s15Var, ih4Var2));
                            treeMap3.clear();
                            Iterator it4 = ((ArrayList) listJ).iterator();
                            int i5 = 0;
                            while (it4.hasNext()) {
                                h15Var.o(i5, (d25) it4.next());
                                i5++;
                            }
                        }
                        return h15Var;
                    }
                    xe.k("Command not supported");
                    return null;
                case 96891675:
                    if (str.equals("every")) {
                        je.k0("every", 1, arrayList2);
                        d25 d25VarK12 = ((e24) ih4Var2.b).K(ih4Var2, (d25) arrayList2.get(0));
                        if (!(d25VarK12 instanceof b25)) {
                            xe.k("Callback should be a method");
                            return null;
                        }
                        if (h15Var.l() != 0) {
                            break;
                        }
                        return d25.v0;
                    }
                    xe.k("Command not supported");
                    return null;
                case 109407362:
                    if (str.equals("shift")) {
                        je.k0("shift", 0, arrayList2);
                        if (h15Var.l() != 0) {
                            d25 d25VarM2 = h15Var.m(0);
                            h15Var.q(0);
                            return d25VarM2;
                        }
                        return d25VarK;
                    }
                    xe.k("Command not supported");
                    return null;
                case 109526418:
                    if (str.equals("slice")) {
                        je.n0("slice", 2, arrayList2);
                        if (arrayList2.isEmpty()) {
                            return h15Var.i();
                        }
                        double dL3 = h15Var.l();
                        double dS0 = je.s0(((e24) ih4Var2.b).K(ih4Var2, (d25) arrayList2.get(0)).g().doubleValue());
                        double dMax = dS0 < 0.0d ? Math.max(dS0 + dL3, 0.0d) : Math.min(dS0, dL3);
                        if (arrayList2.size() == 2) {
                            double dS02 = je.s0(((e24) ih4Var2.b).K(ih4Var2, (d25) arrayList2.get(1)).g().doubleValue());
                            dL3 = dS02 < 0.0d ? Math.max(dL3 + dS02, 0.0d) : Math.min(dL3, dS02);
                        }
                        h15 h15Var8 = new h15();
                        for (int i6 = (int) dMax; i6 < dL3; i6++) {
                            h15Var8.o(h15Var8.l(), h15Var.m(i6));
                        }
                        return h15Var8;
                    }
                    xe.k("Command not supported");
                    return null;
                case 965561430:
                    if (str.equals("reduceRight")) {
                        return ez4.e0(h15Var, ih4Var2, arrayList2, false);
                    }
                    xe.k("Command not supported");
                    return null;
                case 1099846370:
                    if (str.equals("reverse")) {
                        je.k0("reverse", 0, arrayList2);
                        int iL6 = h15Var.l();
                        if (iL6 != 0) {
                            for (int i7 = 0; i7 < iL6 / 2; i7++) {
                                if (h15Var.p(i7)) {
                                    d25 d25VarM3 = h15Var.m(i7);
                                    h15Var.o(i7, null);
                                    int i8 = (iL6 - 1) - i7;
                                    if (h15Var.p(i8)) {
                                        h15Var.o(i7, h15Var.m(i8));
                                    }
                                    h15Var.o(i8, d25VarM3);
                                }
                            }
                        }
                        return h15Var;
                    }
                    xe.k("Command not supported");
                    return null;
                case 1943291465:
                    if (str.equals("indexOf")) {
                        je.n0("indexOf", 2, arrayList2);
                        if (!arrayList2.isEmpty()) {
                            d25VarK = ((e24) ih4Var2.b).K(ih4Var2, (d25) arrayList2.get(0));
                        }
                        d25 d25Var4 = d25VarK;
                        if (arrayList2.size() > 1) {
                            double dS03 = je.s0(((e24) ih4Var2.b).K(ih4Var2, (d25) arrayList2.get(1)).g().doubleValue());
                            if (dS03 >= h15Var.l()) {
                                return new p15(dValueOf);
                            }
                            dL2 = dS03 < 0.0d ? ((double) h15Var.l()) + dS03 : dS03;
                        }
                        Iterator itK6 = h15Var.k();
                        while (itK6.hasNext()) {
                            int iIntValue3 = ((Integer) itK6.next()).intValue();
                            double d = iIntValue3;
                            if (d >= dL2 && je.q0(h15Var.m(iIntValue3), d25Var4)) {
                                return new p15(Double.valueOf(d));
                            }
                        }
                        return new p15(dValueOf);
                    }
                    xe.k("Command not supported");
                    return null;
                default:
                    xe.k("Command not supported");
                    return null;
            }
        }
        str2 = "lastIndexOf";
        str3 = "filter";
        obj = "unshift";
        str4 = "sort";
        ih4Var2 = ih4Var;
        str5 = "forEach";
        obj2 = "reduce";
        h15Var = this;
        arrayList2 = arrayList;
        Double dValueOf2 = Double.valueOf(-1.0d);
        iHashCode = str.hashCode();
        TreeMap treeMap22 = h15Var.b;
        d25 d25VarK13 = d25.q0;
        TreeMap treeMap32 = treeMap22;
        double dL22 = 0.0d;
        switch (iHashCode) {
            case -1776922004:
                break;
            case -1354795244:
                break;
            case -1274492040:
                break;
            case -934873754:
                break;
            case -895859076:
                break;
            case -678635926:
                break;
            case -467511597:
                break;
            case -277637751:
                break;
            case 107868:
                break;
            case 111185:
                break;
            case 3267882:
                break;
            case 3452698:
                break;
            case 3536116:
                break;
            case 3536286:
                break;
            case 96891675:
                break;
            case 109407362:
                break;
            case 109526418:
                break;
            case 965561430:
                break;
            case 1099846370:
                break;
            case 1943291465:
                break;
        }
    }

    @Override // defpackage.d25
    public final Double g() {
        TreeMap treeMap = this.b;
        return treeMap.size() == 1 ? m(0).g() : treeMap.size() <= 0 ? Double.valueOf(0.0d) : Double.valueOf(Double.NaN);
    }

    @Override // defpackage.d25
    public final String h() {
        return r(",");
    }

    public final int hashCode() {
        return this.b.hashCode() * 31;
    }

    @Override // defpackage.d25
    public final d25 i() {
        h15 h15Var = new h15();
        for (Map.Entry entry : this.b.entrySet()) {
            boolean z = entry.getValue() instanceof v15;
            TreeMap treeMap = h15Var.b;
            if (z) {
                treeMap.put((Integer) entry.getKey(), (d25) entry.getValue());
            } else {
                treeMap.put((Integer) entry.getKey(), ((d25) entry.getValue()).i());
            }
        }
        return h15Var;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new wd4(this);
    }

    public final List j() {
        ArrayList arrayList = new ArrayList(l());
        for (int i = 0; i < l(); i++) {
            arrayList.add(m(i));
        }
        return arrayList;
    }

    public final Iterator k() {
        return this.b.keySet().iterator();
    }

    public final int l() {
        TreeMap treeMap = this.b;
        if (treeMap.isEmpty()) {
            return 0;
        }
        return ((Integer) treeMap.lastKey()).intValue() + 1;
    }

    public final d25 m(int i) {
        d25 d25Var;
        if (i < l()) {
            return (!p(i) || (d25Var = (d25) this.b.get(Integer.valueOf(i))) == null) ? d25.q0 : d25Var;
        }
        s53.k("Attempting to get element outside of current array");
        return null;
    }

    public final void o(int i, d25 d25Var) {
        if (i > 32468) {
            xe.q("Array too large");
            return;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
            sb.append("Out of bounds index: ");
            sb.append(i);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        TreeMap treeMap = this.b;
        if (d25Var == null) {
            treeMap.remove(Integer.valueOf(i));
        } else {
            treeMap.put(Integer.valueOf(i), d25Var);
        }
    }

    public final boolean p(int i) {
        if (i >= 0) {
            TreeMap treeMap = this.b;
            if (i <= ((Integer) treeMap.lastKey()).intValue()) {
                return treeMap.containsKey(Integer.valueOf(i));
            }
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
        sb.append("Out of bounds index: ");
        sb.append(i);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final void q(int i) {
        TreeMap treeMap = this.b;
        int iIntValue = ((Integer) treeMap.lastKey()).intValue();
        if (i > iIntValue || i < 0) {
            return;
        }
        treeMap.remove(Integer.valueOf(i));
        if (i == iIntValue) {
            int i2 = i - 1;
            Integer numValueOf = Integer.valueOf(i2);
            if (treeMap.containsKey(numValueOf) || i2 < 0) {
                return;
            }
            treeMap.put(numValueOf, d25.q0);
            return;
        }
        while (true) {
            i++;
            if (i > ((Integer) treeMap.lastKey()).intValue()) {
                return;
            }
            Integer numValueOf2 = Integer.valueOf(i);
            d25 d25Var = (d25) treeMap.get(numValueOf2);
            if (d25Var != null) {
                treeMap.put(Integer.valueOf(i - 1), d25Var);
                treeMap.remove(numValueOf2);
            }
        }
    }

    public final String r(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        if (!this.b.isEmpty()) {
            int i = 0;
            while (true) {
                str2 = str == null ? "" : str;
                if (i >= l()) {
                    break;
                }
                d25 d25VarM = m(i);
                sb.append(str2);
                if (!(d25VarM instanceof j25) && !(d25VarM instanceof a25)) {
                    sb.append(d25VarM.h());
                }
                i++;
            }
            sb.delete(0, str2.length());
        }
        return sb.toString();
    }

    public final String toString() {
        return r(",");
    }

    public h15() {
        this.b = new TreeMap();
        this.f = new TreeMap();
    }
}
