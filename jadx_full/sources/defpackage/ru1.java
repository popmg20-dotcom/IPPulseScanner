package defpackage;

import io.netty.handler.codec.http.HttpHeaders;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ru1 {
    public static final bu a;
    public static final bu b;

    static {
        bu buVar = bu.A;
        a = t60.n("\"\\");
        b = t60.n("\t ,=");
    }

    public static final boolean a(kk3 kk3Var) {
        if (n12.c((String) kk3Var.b.z, "HEAD")) {
            return false;
        }
        int i = kk3Var.A;
        return (((i >= 100 && i < 200) || i == 204 || i == 304) && jz4.e(kk3Var) == -1 && !HttpHeaders.Values.CHUNKED.equalsIgnoreCase(kk3.g(kk3Var, HttpHeaders.Names.TRANSFER_ENCODING))) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x0103, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0103, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void b(hp hpVar, ArrayList arrayList) {
        String strC;
        int iM;
        LinkedHashMap linkedHashMap;
        String strC2;
        while (true) {
            String strC3 = null;
            while (true) {
                if (strC3 == null) {
                    e(hpVar);
                    strC3 = c(hpVar);
                    if (strC3 == null) {
                        return;
                    }
                }
                boolean zE = e(hpVar);
                strC = c(hpVar);
                if (strC == null) {
                    if (hpVar.x()) {
                        arrayList.add(new s20(strC3, h41.b));
                        return;
                    }
                    return;
                }
                iM = hz4.m(hpVar);
                boolean zE2 = e(hpVar);
                if (zE || (!zE2 && !hpVar.x())) {
                    linkedHashMap = new LinkedHashMap();
                    int iM2 = hz4.m(hpVar) + iM;
                    while (true) {
                        if (strC == null) {
                            strC = c(hpVar);
                            if (!e(hpVar)) {
                                iM2 = hz4.m(hpVar);
                                if (iM2 == 0) {
                                    if (iM2 > 1 || e(hpVar)) {
                                        return;
                                    }
                                    if (hpVar.x() || hpVar.C(0L) != 34) {
                                        strC2 = c(hpVar);
                                    } else {
                                        if (hpVar.U() != 34) {
                                            xe.k("Failed requirement.");
                                            return;
                                        }
                                        hp hpVar2 = new hp();
                                        while (true) {
                                            long jN = hpVar.N(a);
                                            if (jN == -1) {
                                                break;
                                            }
                                            if (hpVar.C(jN) == 34) {
                                                hpVar2.a0(hpVar, jN);
                                                hpVar.U();
                                                strC2 = hpVar2.x0();
                                                break;
                                            } else {
                                                if (hpVar.f == jN + 1) {
                                                    break;
                                                }
                                                hpVar2.a0(hpVar, jN);
                                                hpVar.U();
                                                hpVar2.a0(hpVar, 1L);
                                            }
                                        }
                                        strC2 = null;
                                    }
                                    if (strC2 == null || ((String) linkedHashMap.put(strC, strC2)) != null) {
                                        return;
                                    }
                                    if (!e(hpVar) && !hpVar.x()) {
                                        return;
                                    } else {
                                        strC = null;
                                    }
                                }
                            }
                        } else if (iM2 == 0) {
                            break;
                        }
                    }
                }
                arrayList.add(new s20(strC3, linkedHashMap));
                strC3 = strC;
            }
            Map mapSingletonMap = Collections.singletonMap(null, strC + w44.h0(iM, "="));
            mapSingletonMap.getClass();
            arrayList.add(new s20(strC3, mapSingletonMap));
        }
    }

    public static final String c(hp hpVar) {
        long jN = hpVar.N(b);
        if (jN == -1) {
            jN = hpVar.f;
        }
        if (jN != 0) {
            return hpVar.r0(jN, y30.a);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void d(ne0 ne0Var, ev1 ev1Var, lr1 lr1Var) {
        List listUnmodifiableList;
        List listUnmodifiableList2;
        g41 g41Var;
        me0 me0Var;
        int i;
        long j;
        me0 me0Var2;
        String strSubstring;
        ne0Var.getClass();
        ev1Var.getClass();
        lr1Var.getClass();
        if (ne0Var == ne0.n) {
            return;
        }
        Pattern pattern = me0.k;
        int size = lr1Var.size();
        int i2 = 0;
        ArrayList arrayList = null;
        for (int i3 = 0; i3 < size; i3++) {
            if (HttpHeaders.Names.SET_COOKIE.equalsIgnoreCase(gb4.z(lr1Var, i3))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(gb4.B(lr1Var, i3));
            }
        }
        if (arrayList != null) {
            listUnmodifiableList = DesugarCollections.unmodifiableList(arrayList);
            listUnmodifiableList.getClass();
        } else {
            listUnmodifiableList = null;
        }
        g41 g41Var2 = g41.b;
        List list = listUnmodifiableList == null ? g41Var2 : listUnmodifiableList;
        int size2 = list.size();
        int i4 = 0;
        ArrayList arrayList2 = null;
        while (i4 < size2) {
            String str = (String) list.get(i4);
            str.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            byte[] bArr = hz4.a;
            char c = ';';
            int iD = hz4.d(str, ';', i2, str.length());
            char c2 = '=';
            int iD2 = hz4.d(str, '=', i2, iD);
            if (iD2 == iD) {
                g41Var = g41Var2;
                me0Var = null;
                i = 0;
            } else {
                int iG = hz4.g(i2, iD2, str);
                String strSubstring2 = str.substring(iG, hz4.h(iG, iD2, str));
                if (strSubstring2.length() != 0 && hz4.f(strSubstring2) == -1) {
                    int iG2 = hz4.g(iD2 + 1, iD, str);
                    String strSubstring3 = str.substring(iG2, hz4.h(iG2, iD, str));
                    if (hz4.f(strSubstring3) == -1) {
                        int i5 = iD + 1;
                        int length = str.length();
                        long j2 = -1;
                        long jA0 = 253402300799999L;
                        String strSubstring4 = null;
                        String str2 = null;
                        boolean z = false;
                        boolean z2 = false;
                        boolean z3 = true;
                        String str3 = null;
                        boolean z4 = false;
                        while (true) {
                            if (i5 < length) {
                                g41 g41Var3 = g41Var2;
                                int iD3 = hz4.d(str, c, i5, length);
                                int iD4 = hz4.d(str, c2, i5, iD3);
                                int iG3 = hz4.g(i5, iD4, str);
                                String strSubstring5 = str.substring(iG3, hz4.h(iG3, iD4, str));
                                if (iD4 < iD3) {
                                    int iG4 = hz4.g(iD4 + 1, iD3, str);
                                    strSubstring = str.substring(iG4, hz4.h(iG4, iD3, str));
                                } else {
                                    strSubstring = "";
                                }
                                if (strSubstring5.equalsIgnoreCase("expires")) {
                                    try {
                                        jA0 = yr2.a0(strSubstring.length(), strSubstring);
                                        z2 = true;
                                    } catch (NumberFormatException | IllegalArgumentException unused) {
                                    }
                                } else if (strSubstring5.equalsIgnoreCase("max-age")) {
                                    try {
                                        long j3 = Long.parseLong(strSubstring);
                                        j2 = j3 <= 0 ? Long.MIN_VALUE : j3;
                                    } catch (NumberFormatException e) {
                                        Pattern patternCompile = Pattern.compile("-?\\d+");
                                        patternCompile.getClass();
                                        if (!patternCompile.matcher(strSubstring).matches()) {
                                            throw e;
                                        }
                                        j2 = w44.j0(strSubstring, "-", false) ? Long.MIN_VALUE : Long.MAX_VALUE;
                                    }
                                    z2 = true;
                                } else if (strSubstring5.equalsIgnoreCase("domain")) {
                                    if (w44.d0(strSubstring, ".", false)) {
                                        throw new IllegalArgumentException("Failed requirement.");
                                    }
                                    String strB = fz4.b(p44.F0(strSubstring, "."));
                                    if (strB == null) {
                                        throw new IllegalArgumentException();
                                    }
                                    str2 = strB;
                                    z3 = false;
                                } else if (strSubstring5.equalsIgnoreCase("path")) {
                                    strSubstring4 = strSubstring;
                                } else if (strSubstring5.equalsIgnoreCase("secure")) {
                                    z4 = true;
                                } else if (strSubstring5.equalsIgnoreCase("httponly")) {
                                    z = true;
                                } else if (strSubstring5.equalsIgnoreCase("samesite")) {
                                    str3 = strSubstring;
                                }
                                i5 = iD3 + 1;
                                g41Var2 = g41Var3;
                                c = ';';
                                c2 = '=';
                            } else {
                                g41Var = g41Var2;
                                if (j2 == Long.MIN_VALUE) {
                                    j = Long.MIN_VALUE;
                                } else if (j2 != -1) {
                                    long j4 = jCurrentTimeMillis + (j2 <= 9223372036854775L ? j2 * 1000 : Long.MAX_VALUE);
                                    j = (j4 < jCurrentTimeMillis || j4 > 253402300799999L) ? 253402300799999L : j4;
                                } else {
                                    j = jA0;
                                }
                                String str4 = ev1Var.d;
                                if (str2 == null) {
                                    str2 = str4;
                                } else if (!yr2.v(str4, str2)) {
                                    i = 0;
                                    me0Var2 = null;
                                    me0Var = me0Var2;
                                }
                                if (str4.length() == str2.length() || sb3.d.a(str2) != null) {
                                    i = 0;
                                    if (strSubstring4 == null || !w44.j0(strSubstring4, "/", false)) {
                                        String strB2 = ev1Var.b();
                                        int iZ0 = p44.z0(strB2, '/', 0, 6);
                                        strSubstring4 = iZ0 != 0 ? strB2.substring(0, iZ0) : "/";
                                    }
                                    me0Var2 = new me0(strSubstring2, strSubstring3, j, str2, strSubstring4, z4, z, z2, z3, str3);
                                }
                                me0Var = me0Var2;
                            }
                        }
                    }
                }
            }
            if (me0Var != null) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(me0Var);
            }
            i4++;
            i2 = i;
            g41Var2 = g41Var;
        }
        g41 g41Var4 = g41Var2;
        if (arrayList2 != null) {
            listUnmodifiableList2 = DesugarCollections.unmodifiableList(arrayList2);
            listUnmodifiableList2.getClass();
        } else {
            listUnmodifiableList2 = null;
        }
        List list2 = listUnmodifiableList2 == null ? g41Var4 : listUnmodifiableList2;
        if (list2.isEmpty()) {
            return;
        }
        ne0Var.g(ev1Var, list2);
    }

    public static final boolean e(hp hpVar) {
        boolean z = false;
        while (!hpVar.x()) {
            byte bC = hpVar.C(0L);
            if (bC != 44) {
                if (bC != 32 && bC != 9) {
                    break;
                }
                hpVar.U();
            } else {
                hpVar.U();
                z = true;
            }
        }
        return z;
    }
}
