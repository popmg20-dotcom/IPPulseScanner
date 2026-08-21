package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class dv1 {
    public String a;
    public String d;
    public ArrayList g;
    public String h;
    public String b = "";
    public String c = "";
    public int e = -1;
    public final ArrayList f = e70.L("");

    public static ArrayList e(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int iU0 = p44.u0(str, '&', i, 4);
            if (iU0 == -1) {
                iU0 = str.length();
            }
            int iU02 = p44.u0(str, '=', i, 4);
            if (iU02 == -1 || iU02 > iU0) {
                arrayList.add(str.substring(i, iU0));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i, iU02));
                arrayList.add(str.substring(iU02 + 1, iU0));
            }
            i = iU0 + 1;
        }
        return arrayList;
    }

    public final ev1 a() {
        ArrayList arrayList;
        String str = this.a;
        if (str == null) {
            xe.q("scheme == null");
            return null;
        }
        String strN = ez4.N(0, 0, 7, this.b);
        String strN2 = ez4.N(0, 0, 7, this.c);
        String str2 = this.d;
        if (str2 == null) {
            xe.q("host == null");
            return null;
        }
        int iB = b();
        ArrayList arrayList2 = this.f;
        ArrayList arrayList3 = new ArrayList(f70.Q(10, arrayList2));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(ez4.N(0, 0, 7, (String) it.next()));
        }
        ArrayList<String> arrayList4 = this.g;
        if (arrayList4 != null) {
            arrayList = new ArrayList(f70.Q(10, arrayList4));
            for (String str3 : arrayList4) {
                arrayList.add(str3 != null ? ez4.N(0, 0, 3, str3) : null);
            }
        } else {
            arrayList = null;
        }
        String str4 = this.h;
        return new ev1(str, strN, strN2, str2, iB, arrayList3, arrayList, str4 != null ? ez4.N(0, 0, 7, str4) : null, toString());
    }

    public final int b() {
        int i = this.e;
        if (i != -1) {
            return i;
        }
        String str = this.a;
        str.getClass();
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(ev1 ev1Var, String str) {
        int i;
        int i2;
        ArrayList arrayList;
        int i3;
        int i4;
        ArrayList arrayList2;
        char cCharAt;
        dv1 dv1Var = this;
        String str2 = str;
        str2.getClass();
        byte[] bArr = hz4.a;
        int iG = hz4.g(0, str2.length(), str2);
        int iH = hz4.h(iG, str2.length(), str2);
        int i5 = -1;
        if (iH - iG < 2) {
            i = -1;
        } else {
            char cCharAt2 = str2.charAt(iG);
            if ((n12.l(cCharAt2, 97) >= 0 && n12.l(cCharAt2, 122) <= 0) || (n12.l(cCharAt2, 65) >= 0 && n12.l(cCharAt2, 90) <= 0)) {
                i = iG + 1;
                while (true) {
                    if (i >= iH) {
                        break;
                    }
                    char cCharAt3 = str2.charAt(i);
                    if (('a' <= cCharAt3 && cCharAt3 < '{') || (('A' <= cCharAt3 && cCharAt3 < '[') || (('0' <= cCharAt3 && cCharAt3 < ':') || cCharAt3 == '+' || cCharAt3 == '-' || cCharAt3 == '.'))) {
                        i++;
                    } else if (cCharAt3 != ':') {
                        break;
                    }
                }
                i = -1;
            }
        }
        int i6 = 1;
        if (i != -1) {
            if (w44.k0(str2, "https:", true, iG)) {
                dv1Var.a = "https";
                iG += 6;
            } else {
                if (!w44.k0(str2, "http:", true, iG)) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str2.substring(0, i) + '\'');
                }
                dv1Var.a = "http";
                iG += 5;
            }
        } else {
            if (ev1Var == null) {
                xe.k("Expected URL scheme 'http' or 'https' but no scheme was found for ".concat(str2.length() > 6 ? p44.T0(6, str2).concat("...") : str2));
                return;
            }
            dv1Var.a = ev1Var.a;
        }
        int i7 = iG;
        int i8 = 0;
        while (true) {
            i2 = i6;
            if (i7 >= iH || !((cCharAt = str2.charAt(i7)) == '/' || cCharAt == '\\')) {
                break;
            }
            i8++;
            i7++;
            i6 = i2;
        }
        char c = '?';
        ArrayList arrayList3 = dv1Var.f;
        char c2 = '#';
        if (i8 >= 2 || ev1Var == null || !n12.c(ev1Var.a, dv1Var.a)) {
            int i9 = iG + i8;
            int i10 = 0;
            int i11 = 0;
            while (true) {
                iG = hz4.c(i9, iH, str2, "@/\\?#");
                byte bCharAt = iG != iH ? str2.charAt(iG) : (byte) -1;
                if (bCharAt == -1 || bCharAt == c2 || bCharAt == 47 || bCharAt == 92 || bCharAt == c) {
                    break;
                }
                if (bCharAt == 64) {
                    if (i10 == 0) {
                        int iD = hz4.d(str2, ':', i9, iG);
                        arrayList2 = arrayList3;
                        String strJ = ez4.j(i9, iD, 112, str2, " \"':;<=>@[]^`{}|/\\?#", true);
                        if (i11 != 0) {
                            strJ = fw.y(new StringBuilder(dv1Var.b), "%40", strJ);
                        }
                        dv1Var.b = strJ;
                        if (iD != iG) {
                            int i12 = iD + 1;
                            iG = iG;
                            dv1Var.c = ez4.j(i12, iG, 112, str, " \"':;<=>@[]^`{}|/\\?#", true);
                            i10 = i2;
                        } else {
                            iG = iG;
                        }
                        str2 = str;
                        i11 = i2;
                    } else {
                        arrayList2 = arrayList3;
                        StringBuilder sb = new StringBuilder(dv1Var.c);
                        sb.append("%40");
                        str2 = str;
                        sb.append(ez4.j(i9, iG, 112, str2, " \"':;<=>@[]^`{}|/\\?#", true));
                        dv1Var.c = sb.toString();
                    }
                    i9 = iG + 1;
                    arrayList3 = arrayList2;
                    c2 = '#';
                    c = '?';
                }
            }
            int i13 = i9;
            arrayList = arrayList3;
            int i14 = i13;
            while (true) {
                if (i14 < iG) {
                    char cCharAt4 = str2.charAt(i14);
                    if (cCharAt4 == ':') {
                        i3 = i14;
                        break;
                    }
                    if (cCharAt4 == '[') {
                        do {
                            i14++;
                            if (i14 < iG) {
                            }
                        } while (str2.charAt(i14) != ']');
                    }
                    i14++;
                } else {
                    i3 = iG;
                    break;
                }
            }
            int i15 = i3 + 1;
            if (i15 < iG) {
                dv1Var.d = fz4.b(ez4.N(i13, i3, 4, str2));
                try {
                    i4 = Integer.parseInt(ez4.j(i15, iG, 120, str2, "", false));
                } catch (NumberFormatException unused) {
                }
                if (i2 > i4 || i4 >= 65536) {
                    i4 = -1;
                }
                dv1Var.e = i4;
                if (i4 == -1) {
                    ad0.f(str2.substring(i15, iG), 34, "Invalid URL port: \"");
                    return;
                }
            } else {
                dv1Var.d = fz4.b(ez4.N(i13, i3, 4, str2));
                String str3 = dv1Var.a;
                str3.getClass();
                if (str3.equals("http")) {
                    i5 = 80;
                } else if (str3.equals("https")) {
                    i5 = 443;
                }
                dv1Var.e = i5;
            }
            if (dv1Var.d == null) {
                ad0.f(str2.substring(i13, i3), 34, "Invalid URL host: \"");
                return;
            }
        } else {
            dv1Var.b = ev1Var.e();
            dv1Var.c = ev1Var.a();
            dv1Var.d = ev1Var.d;
            dv1Var.e = ev1Var.e;
            arrayList3.clear();
            arrayList3.addAll(ev1Var.c());
            if (iG == iH || str2.charAt(iG) == '#') {
                String strD = ev1Var.d();
                dv1Var.g = strD != null ? e(ez4.j(0, 0, 83, strD, " \"'<>#", true)) : null;
            }
            arrayList = arrayList3;
        }
        int iC = hz4.c(iG, iH, str2, "?#");
        if (iG != iC) {
            char cCharAt5 = str2.charAt(iG);
            if (cCharAt5 == '/' || cCharAt5 == '\\') {
                ArrayList arrayList4 = arrayList;
                arrayList4.clear();
                arrayList4.add("");
                iG++;
            } else {
                arrayList.set(arrayList.size() - 1, "");
            }
            while (iG < iC) {
                int iC2 = hz4.c(iG, iC, str2, "/\\");
                boolean z = iC2 < iC;
                String str4 = str2;
                dv1Var.d(str4, iG, iC2, z, true);
                dv1 dv1Var2 = dv1Var;
                str2 = str4;
                iG = z ? iC2 + 1 : iC2;
                dv1Var = dv1Var2;
            }
        }
        dv1 dv1Var3 = dv1Var;
        if (iC < iH && str2.charAt(iC) == '?') {
            int iD2 = hz4.d(str2, '#', iC, iH);
            str2 = str;
            dv1Var3.g = e(ez4.j(iC + 1, iD2, 80, str, " \"'<>#", true));
            iC = iD2;
        }
        if (iC >= iH || str2.charAt(iC) != '#') {
            return;
        }
        dv1Var3.h = ez4.j(iC + 1, iH, 48, str, "", true);
    }

    public final void d(String str, int i, int i2, boolean z, boolean z2) {
        String strJ = ez4.j(i, i2, 112, str, " \"<>^`{}|/\\?#", z2);
        if (strJ.equals(".") || strJ.equalsIgnoreCase("%2e")) {
            return;
        }
        boolean zEquals = strJ.equals("..");
        ArrayList arrayList = this.f;
        if (zEquals || strJ.equalsIgnoreCase("%2e.") || strJ.equalsIgnoreCase(".%2e") || strJ.equalsIgnoreCase("%2e%2e")) {
            if (((String) arrayList.remove(arrayList.size() - 1)).length() != 0 || arrayList.isEmpty()) {
                arrayList.add("");
                return;
            } else {
                arrayList.set(arrayList.size() - 1, "");
                return;
            }
        }
        if (((CharSequence) fw.r(arrayList, 1)).length() == 0) {
            arrayList.set(arrayList.size() - 1, strJ);
        } else {
            arrayList.add(strJ);
        }
        if (z) {
            arrayList.add("");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.a;
        if (str != null) {
            sb.append(str);
            sb.append("://");
        } else {
            sb.append("//");
        }
        if (this.b.length() > 0 || this.c.length() > 0) {
            sb.append(this.b);
            if (this.c.length() > 0) {
                sb.append(':');
                sb.append(this.c);
            }
            sb.append('@');
        }
        String str2 = this.d;
        if (str2 != null) {
            if (p44.p0(str2, ':')) {
                sb.append('[');
                sb.append(this.d);
                sb.append(']');
            } else {
                sb.append(this.d);
            }
        }
        int i = -1;
        if (this.e != -1 || this.a != null) {
            int iB = b();
            String str3 = this.a;
            if (str3 == null) {
                sb.append(':');
                sb.append(iB);
            } else {
                if (str3.equals("http")) {
                    i = 80;
                } else if (str3.equals("https")) {
                    i = 443;
                }
                if (iB != i) {
                }
            }
        }
        ArrayList arrayList = this.f;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append('/');
            sb.append((String) arrayList.get(i2));
        }
        if (this.g != null) {
            sb.append('?');
            ArrayList arrayList2 = this.g;
            arrayList2.getClass();
            n12.V(arrayList2, sb);
        }
        if (this.h != null) {
            sb.append('#');
            sb.append(this.h);
        }
        return sb.toString();
    }
}
