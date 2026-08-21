package defpackage;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lr1 implements Iterable, z72 {
    public static final lr1 f = new lr1(new String[0]);
    public final String[] b;

    public lr1(String[] strArr) {
        strArr.getClass();
        this.b = strArr;
    }

    public final String a(String str) {
        String[] strArr = this.b;
        strArr.getClass();
        int length = strArr.length - 2;
        int iZ = ye.z(length, 0, -2);
        if (iZ > length) {
            return null;
        }
        while (!str.equalsIgnoreCase(strArr[length])) {
            if (length == iZ) {
                return null;
            }
            length -= 2;
        }
        return strArr[length + 1];
    }

    public final Date b(String str) {
        String strA = a(str);
        if (strA == null) {
            return null;
        }
        uj0 uj0Var = vj0.a;
        if (strA.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = ((DateFormat) vj0.a.get()).parse(strA, parsePosition);
        if (parsePosition.getIndex() == strA.length()) {
            return date;
        }
        String[] strArr = vj0.b;
        synchronized (strArr) {
            try {
                int length = strArr.length;
                for (int i = 0; i < length; i++) {
                    DateFormat[] dateFormatArr = vj0.c;
                    DateFormat simpleDateFormat = dateFormatArr[i];
                    if (simpleDateFormat == null) {
                        simpleDateFormat = new SimpleDateFormat(vj0.b[i], Locale.US);
                        simpleDateFormat.setTimeZone(jz4.a);
                        dateFormatArr[i] = simpleDateFormat;
                    }
                    parsePosition.setIndex(0);
                    Date date2 = simpleDateFormat.parse(strA, parsePosition);
                    if (parsePosition.getIndex() != 0) {
                        return date2;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final TreeMap c() {
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        comparator.getClass();
        TreeMap treeMap = new TreeMap(comparator);
        int size = size();
        for (int i = 0; i < size; i++) {
            String strZ = gb4.z(this, i);
            Locale locale = Locale.US;
            locale.getClass();
            String lowerCase = strZ.toLowerCase(locale);
            lowerCase.getClass();
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(gb4.B(this, i));
        }
        return treeMap;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof lr1) {
            return Arrays.equals(this.b, ((lr1) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.b);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        int size = size();
        e03[] e03VarArr = new e03[size];
        for (int i = 0; i < size; i++) {
            e03VarArr[i] = new e03(gb4.z(this, i), gb4.B(this, i));
        }
        return new w0(e03VarArr);
    }

    public final int size() {
        return this.b.length / 2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            String strZ = gb4.z(this, i);
            String strB = gb4.B(this, i);
            sb.append(strZ);
            sb.append(": ");
            if (hz4.j(strZ)) {
                strB = "██";
            }
            sb.append(strB);
            sb.append("\n");
        }
        return sb.toString();
    }
}
