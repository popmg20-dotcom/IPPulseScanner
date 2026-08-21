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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(defpackage.ev1 r25, java.lang.String r26) {
        /*
            Method dump skipped, instruction units count: 769
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dv1.c(ev1, java.lang.String):void");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instruction units count: 207
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dv1.toString():java.lang.String");
    }
}
