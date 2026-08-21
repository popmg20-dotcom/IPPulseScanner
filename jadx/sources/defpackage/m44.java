package defpackage;

import j$.util.DesugarCollections;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class m44 {
    public static final List a;
    public static final Pattern b;
    public static final Pattern c;
    public static final Pattern d;
    public static final Pattern e;

    static {
        ArrayList arrayList = new ArrayList(1);
        Object obj = new Object[]{""}[0];
        Objects.requireNonNull(obj);
        arrayList.add(obj);
        a = DesugarCollections.unmodifiableList(arrayList);
        b = Pattern.compile("^#[0-9a-f]{6}", 2);
        c = Pattern.compile("^#[0-9a-f]{8}", 2);
        d = Pattern.compile("^#[0-9a-f]{3}", 2);
        e = Pattern.compile("^#[0-9a-f]{4}", 2);
    }

    public static boolean a(String str) {
        if (str.length() < 1) {
            return false;
        }
        return b.matcher(str).matches() || c.matcher(str).matches() || d.matcher(str).matches() || e.matcher(str).matches();
    }

    public static String[] b(String str) {
        if (str.isEmpty()) {
            return new String[]{""};
        }
        String[] strArr = new String[8];
        int iIndexOf = str.indexOf(32, 0);
        int i = 0;
        int i2 = 0;
        while (iIndexOf >= 0) {
            if (i == strArr.length) {
                String[] strArr2 = new String[strArr.length + (strArr.length >> 1)];
                System.arraycopy(strArr, 0, strArr2, 0, i);
                strArr = strArr2;
            }
            strArr[i] = str.substring(i2, iIndexOf);
            i++;
            i2 = iIndexOf + 1;
            if (i == -1) {
                break;
            }
            iIndexOf = str.indexOf(32, i2);
        }
        if (i == strArr.length) {
            String[] strArr3 = new String[strArr.length + 1];
            System.arraycopy(strArr, 0, strArr3, 0, i);
            strArr = strArr3;
        }
        strArr[i] = str.substring(i2);
        int i3 = i + 1;
        if (i3 == strArr.length) {
            return strArr;
        }
        String[] strArr4 = new String[i3];
        System.arraycopy(strArr, 0, strArr4, 0, i3);
        return strArr4;
    }

    public static List c(String str, char c2) {
        if (str.isEmpty()) {
            return a;
        }
        ArrayList arrayList = new ArrayList(8);
        int i = 0;
        int iIndexOf = str.indexOf(c2, 0);
        while (iIndexOf >= 0) {
            arrayList.add(str.substring(i, iIndexOf));
            i = iIndexOf + 1;
            iIndexOf = str.indexOf(c2, i);
        }
        arrayList.add(str.substring(i));
        return arrayList;
    }

    public static int d(List list, List list2) {
        if (list != null || list2 != null) {
            if (list == null) {
                return -1;
            }
            if (list2 == null) {
                return 1;
            }
            int size = list.size();
            int size2 = list2.size();
            if (size != size2) {
                return size - size2;
            }
            for (int i = 0; i < size; i++) {
                int iCompareTo = ((String) list.get(i)).compareTo((String) list2.get(i));
                int i2 = iCompareTo < 0 ? -1 : iCompareTo > 0 ? 1 : 0;
                if (i2 != 0) {
                    return i2;
                }
            }
        }
        return 0;
    }

    public static String e(Object obj, Consumer consumer) {
        if (obj == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder(obj.getClass().getSimpleName());
        sb.append('{');
        consumer.accept(sb);
        sb.append('}');
        return sb.toString();
    }
}
