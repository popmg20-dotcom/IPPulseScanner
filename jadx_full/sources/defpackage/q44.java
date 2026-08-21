package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q44 extends n12 {
    public static String a0(String str) {
        return ws3.U(new go1(new j70(4, str), new ko0("    ", 10), 1), "\n");
    }

    public static String b0(String str) {
        int length;
        Comparable comparable;
        String strSubstring;
        List listB0 = p44.B0(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listB0) {
            if (!p44.x0((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(f70.Q(10, arrayList));
        Iterator it = arrayList.iterator();
        while (true) {
            length = 0;
            if (!it.hasNext()) {
                break;
            }
            String str2 = (String) it.next();
            int length2 = str2.length();
            while (true) {
                if (length >= length2) {
                    length = -1;
                    break;
                }
                if (!yr2.O(str2.charAt(length))) {
                    break;
                }
                length++;
            }
            if (length == -1) {
                length = str2.length();
            }
            arrayList2.add(Integer.valueOf(length));
        }
        Iterator it2 = arrayList2.iterator();
        if (it2.hasNext()) {
            comparable = (Comparable) it2.next();
            while (it2.hasNext()) {
                Comparable comparable2 = (Comparable) it2.next();
                if (comparable.compareTo(comparable2) > 0) {
                    comparable = comparable2;
                }
            }
        } else {
            comparable = null;
        }
        Integer num = (Integer) comparable;
        int iIntValue = num != null ? num.intValue() : 0;
        int length3 = str.length();
        listB0.size();
        int size = listB0.size() - 1;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listB0) {
            int i = length + 1;
            if (length < 0) {
                e70.P();
                throw null;
            }
            String str3 = (String) obj2;
            if ((length == 0 || length == size) && p44.x0(str3)) {
                strSubstring = null;
            } else {
                str3.getClass();
                if (iIntValue < 0) {
                    e04.f(ha0.k("Requested character count ", iIntValue, " is less than zero."));
                    return null;
                }
                int length4 = str3.length();
                if (iIntValue <= length4) {
                    length4 = iIntValue;
                }
                strSubstring = str3.substring(length4);
            }
            if (strSubstring != null) {
                arrayList3.add(strSubstring);
            }
            length = i;
        }
        StringBuilder sb = new StringBuilder(length3);
        d70.h0(arrayList3, sb, "\n", "", "", "...", null);
        return sb.toString();
    }

    public static String c0(String str) {
        if (p44.x0("|")) {
            xe.k("marginPrefix must be non-blank string.");
            return null;
        }
        List listB0 = p44.B0(str);
        int length = str.length();
        listB0.size();
        int size = listB0.size() - 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : listB0) {
            int i2 = i + 1;
            if (i < 0) {
                e70.P();
                throw null;
            }
            String str2 = (String) obj;
            if ((i == 0 || i == size) && p44.x0(str2)) {
                str2 = null;
            } else {
                int length2 = str2.length();
                int i3 = 0;
                while (true) {
                    if (i3 >= length2) {
                        i3 = -1;
                        break;
                    }
                    if (!yr2.O(str2.charAt(i3))) {
                        break;
                    }
                    i3++;
                }
                String strSubstring = (i3 != -1 && w44.k0(str2, "|", false, i3)) ? str2.substring("|".length() + i3) : null;
                if (strSubstring != null) {
                    str2 = strSubstring;
                }
            }
            if (str2 != null) {
                arrayList.add(str2);
            }
            i = i2;
        }
        StringBuilder sb = new StringBuilder(length);
        d70.h0(arrayList, sb, "\n", "", "", "...", null);
        return sb.toString();
    }
}
