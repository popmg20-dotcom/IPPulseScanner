package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i25 implements Iterable, d25 {
    public final String b;

    public i25(String str) {
        if (str != null) {
            this.b = str;
        } else {
            xe.k("StringValue cannot be null.");
            throw null;
        }
    }

    @Override // defpackage.d25
    public final Boolean d() {
        return Boolean.valueOf(!this.b.isEmpty());
    }

    @Override // defpackage.d25
    public final Iterator e() {
        return new f25(this, 0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i25) {
            return this.b.equals(((i25) obj).b);
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02e4 A[PHI: r8
      0x02e4: PHI (r8v6 boolean) = (r8v12 boolean), (r8v13 boolean), (r8v16 boolean) binds: [B:100:0x02d0, B:101:0x02d2, B:103:0x02e2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02ee A[LOOP:0: B:108:0x02ec->B:109:0x02ee, LOOP_END] */
    @Override // defpackage.d25
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d25 f(String str, ih4 ih4Var, ArrayList arrayList) {
        String str2;
        String str3;
        String strH;
        int i;
        int i2;
        int i3;
        ih4 ih4Var2;
        if ("charAt".equals(str) || "concat".equals(str) || "hasOwnProperty".equals(str) || "indexOf".equals(str) || "lastIndexOf".equals(str) || "match".equals(str) || "replace".equals(str) || "search".equals(str) || "slice".equals(str) || "split".equals(str) || "substring".equals(str) || "toLowerCase".equals(str) || "toLocaleLowerCase".equals(str) || "toString".equals(str) || "toUpperCase".equals(str) || "toLocaleUpperCase".equals(str)) {
            str2 = "hasOwnProperty";
            str3 = "trim";
        } else {
            str2 = "hasOwnProperty";
            str3 = "trim";
            if (!str3.equals(str)) {
                xe.k(str.concat(" is not a String function"));
                return null;
            }
        }
        int iHashCode = str.hashCode();
        strH = "undefined";
        String str4 = this.b;
        z = false;
        boolean z = false;
        switch (iHashCode) {
            case -1789698943:
                String str5 = str2;
                if (str.equals(str5)) {
                    je.k0(str5, 1, arrayList);
                    d25 d25VarK = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0));
                    boolean zEquals = "length".equals(d25VarK.h());
                    j15 j15Var = d25.v0;
                    if (zEquals) {
                        return j15Var;
                    }
                    double dDoubleValue = d25VarK.g().doubleValue();
                    return (dDoubleValue != Math.floor(dDoubleValue) || (i = (int) dDoubleValue) < 0 || i >= str4.length()) ? d25.w0 : j15Var;
                }
                xe.k("Command not supported");
                return null;
            case -1776922004:
                if (str.equals("toString")) {
                    je.k0("toString", 0, arrayList);
                    return this;
                }
                xe.k("Command not supported");
                return null;
            case -1464939364:
                if (str.equals("toLocaleLowerCase")) {
                    je.k0("toLocaleLowerCase", 0, arrayList);
                    return new i25(str4.toLowerCase());
                }
                xe.k("Command not supported");
                return null;
            case -1361633751:
                if (str.equals("charAt")) {
                    je.n0("charAt", 1, arrayList);
                    int iS0 = arrayList.isEmpty() ? 0 : (int) je.s0(((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0)).g().doubleValue());
                    return (iS0 < 0 || iS0 >= str4.length()) ? d25.x0 : new i25(String.valueOf(str4.charAt(iS0)));
                }
                xe.k("Command not supported");
                return null;
            case -1354795244:
                if (str.equals("concat")) {
                    if (!arrayList.isEmpty()) {
                        StringBuilder sb = new StringBuilder(str4);
                        for (int i4 = 0; i4 < arrayList.size(); i4++) {
                            sb.append(((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(i4)).h());
                        }
                        return new i25(sb.toString());
                    }
                    return this;
                }
                xe.k("Command not supported");
                return null;
            case -1137582698:
                if (str.equals("toLowerCase")) {
                    je.k0("toLowerCase", 0, arrayList);
                    return new i25(str4.toLowerCase(Locale.ENGLISH));
                }
                xe.k("Command not supported");
                return null;
            case -906336856:
                if (str.equals("search")) {
                    je.n0("search", 1, arrayList);
                    return Pattern.compile(arrayList.isEmpty() ? "undefined" : ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0)).h()).matcher(str4).find() ? new p15(Double.valueOf(r0.start())) : new p15(Double.valueOf(-1.0d));
                }
                xe.k("Command not supported");
                return null;
            case -726908483:
                if (str.equals("toLocaleUpperCase")) {
                    je.k0("toLocaleUpperCase", 0, arrayList);
                    return new i25(str4.toUpperCase());
                }
                xe.k("Command not supported");
                return null;
            case -467511597:
                if (str.equals("lastIndexOf")) {
                    je.n0("lastIndexOf", 2, arrayList);
                    String strH2 = arrayList.size() > 0 ? ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0)).h() : "undefined";
                    return new p15(Double.valueOf(str4.lastIndexOf(strH2, (int) (Double.isNaN(arrayList.size() < 2 ? Double.NaN : ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1)).g().doubleValue()) ? Double.POSITIVE_INFINITY : je.s0(r1)))));
                }
                xe.k("Command not supported");
                return null;
            case -399551817:
                if (str.equals("toUpperCase")) {
                    je.k0("toUpperCase", 0, arrayList);
                    return new i25(str4.toUpperCase(Locale.ENGLISH));
                }
                xe.k("Command not supported");
                return null;
            case 3568674:
                if (str.equals(str3)) {
                    je.k0("toUpperCase", 0, arrayList);
                    return new i25(str4.trim());
                }
                xe.k("Command not supported");
                return null;
            case 103668165:
                if (str.equals("match")) {
                    je.n0("match", 1, arrayList);
                    Matcher matcher = Pattern.compile(arrayList.size() <= 0 ? "" : ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0)).h()).matcher(str4);
                    return matcher.find() ? new h15(Arrays.asList(new i25(matcher.group()))) : d25.r0;
                }
                xe.k("Command not supported");
                return null;
            case 109526418:
                if (str.equals("slice")) {
                    je.n0("slice", 2, arrayList);
                    double dS0 = je.s0(!arrayList.isEmpty() ? ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0)).g().doubleValue() : 0.0d);
                    double dMax = dS0 < 0.0d ? Math.max(((double) str4.length()) + dS0, 0.0d) : Math.min(dS0, str4.length());
                    double dS02 = je.s0(arrayList.size() > 1 ? ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1)).g().doubleValue() : str4.length());
                    int i5 = (int) dMax;
                    return new i25(str4.substring(i5, Math.max(0, ((int) (dS02 < 0.0d ? Math.max(((double) str4.length()) + dS02, 0.0d) : Math.min(dS02, str4.length()))) - i5) + i5));
                }
                xe.k("Command not supported");
                return null;
            case 109648666:
                if (str.equals("split")) {
                    je.n0("split", 2, arrayList);
                    if (str4.length() == 0) {
                        return new h15(Arrays.asList(this));
                    }
                    ArrayList arrayList2 = new ArrayList();
                    if (arrayList.isEmpty()) {
                        arrayList2.add(this);
                    } else {
                        String strH3 = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0)).h();
                        long jR0 = arrayList.size() > 1 ? ((long) je.r0(((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1)).g().doubleValue())) & 4294967295L : 2147483647L;
                        if (jR0 == 0) {
                            return new h15();
                        }
                        String[] strArrSplit = str4.split(Pattern.quote(strH3), ((int) jR0) + 1);
                        int length = strArrSplit.length;
                        if (!strH3.isEmpty() || length <= 0) {
                            i2 = length;
                            i3 = z;
                            if (length > jR0) {
                                i2--;
                            }
                            while (i3 < i2) {
                                arrayList2.add(new i25(strArrSplit[i3]));
                                i3++;
                            }
                        } else {
                            boolean zIsEmpty = strArrSplit[0].isEmpty();
                            i2 = length - 1;
                            i3 = zIsEmpty;
                            z = zIsEmpty;
                            if (!strArrSplit[i2].isEmpty()) {
                            }
                            if (length > jR0) {
                            }
                            while (i3 < i2) {
                            }
                        }
                    }
                    return new h15(arrayList2);
                }
                xe.k("Command not supported");
                return null;
            case 530542161:
                if (str.equals("substring")) {
                    je.n0("substring", 2, arrayList);
                    int iS02 = !arrayList.isEmpty() ? (int) je.s0(((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0)).g().doubleValue()) : 0;
                    int iS03 = arrayList.size() > 1 ? (int) je.s0(((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1)).g().doubleValue()) : str4.length();
                    int iMin = Math.min(Math.max(iS02, 0), str4.length());
                    int iMin2 = Math.min(Math.max(iS03, 0), str4.length());
                    return new i25(str4.substring(Math.min(iMin, iMin2), Math.max(iMin, iMin2)));
                }
                xe.k("Command not supported");
                return null;
            case 1094496948:
                if (str.equals("replace")) {
                    je.n0("replace", 2, arrayList);
                    boolean zIsEmpty2 = arrayList.isEmpty();
                    d25 d25VarJ = d25.q0;
                    if (!zIsEmpty2) {
                        strH = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(0)).h();
                        if (arrayList.size() > 1) {
                            d25VarJ = ((e24) ih4Var.b).K(ih4Var, (d25) arrayList.get(1));
                        }
                    }
                    String str6 = strH;
                    int iIndexOf = str4.indexOf(str6);
                    if (iIndexOf >= 0) {
                        if (d25VarJ instanceof s15) {
                            d25VarJ = ((s15) d25VarJ).j(ih4Var, Arrays.asList(new i25(str6), new p15(Double.valueOf(iIndexOf)), this));
                        }
                        String strSubstring = str4.substring(0, iIndexOf);
                        String strH4 = d25VarJ.h();
                        String strSubstring2 = str4.substring(str6.length() + iIndexOf);
                        return new i25(fw.z(new StringBuilder(strSubstring.length() + String.valueOf(strH4).length() + strSubstring2.length()), strSubstring, strH4, strSubstring2));
                    }
                    return this;
                }
                xe.k("Command not supported");
                return null;
            case 1943291465:
                if (str.equals("indexOf")) {
                    je.n0("indexOf", 2, arrayList);
                    if (arrayList.size() <= 0) {
                        ih4Var2 = ih4Var;
                    } else {
                        ih4Var2 = ih4Var;
                        strH = ((e24) ih4Var2.b).K(ih4Var2, (d25) arrayList.get(0)).h();
                    }
                    return new p15(Double.valueOf(str4.indexOf(strH, (int) je.s0(arrayList.size() < 2 ? 0.0d : ((e24) ih4Var2.b).K(ih4Var2, (d25) arrayList.get(1)).g().doubleValue()))));
                }
                xe.k("Command not supported");
                return null;
            default:
                xe.k("Command not supported");
                return null;
        }
    }

    @Override // defpackage.d25
    public final Double g() {
        String str = this.b;
        if (str.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    @Override // defpackage.d25
    public final String h() {
        return this.b;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    @Override // defpackage.d25
    public final d25 i() {
        return new i25(this.b);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new f25(this, 1);
    }

    public final String toString() {
        String str = this.b;
        return fw.z(new StringBuilder(str.length() + 2), "\"", str, "\"");
    }
}
