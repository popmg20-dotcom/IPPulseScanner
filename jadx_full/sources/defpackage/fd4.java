package defpackage;

import j$.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class fd4 {
    public final gd4 a;
    public final List b;
    public final HashMap c;

    public fd4(gd4 gd4Var, List list) {
        HashMap map = new HashMap();
        this.a = gd4Var;
        this.b = list;
        this.c = map;
    }

    public final void a(int i, String str, List list, int i2, int i3, int i4) {
        String strSubstring;
        fd4 fd4Var;
        String str2 = str;
        boolean zIsEmpty = str2.isEmpty();
        gd4 gd4Var = this.a;
        List<gd4> list2 = this.b;
        if (!zIsEmpty) {
            int iIndexOf = str2.indexOf(46);
            if (iIndexOf == -1) {
                strSubstring = "";
            } else {
                String strSubstring2 = str2.substring(0, iIndexOf);
                strSubstring = str2.substring(iIndexOf + 1);
                str2 = strSubstring2;
            }
            HashMap map = this.c;
            if (map.containsKey(str2)) {
                fd4Var = (fd4) map.get(str2);
            } else {
                gd4 gd4Var2 = new gd4(gd4Var.a, gd4Var.b, gd4Var.c, gd4Var.d, gd4Var.e);
                ArrayList arrayList = new ArrayList(list2.size());
                for (gd4 gd4Var3 : list2) {
                    arrayList.add(new gd4(gd4Var3.a, gd4Var3.b, gd4Var3.c, gd4Var3.d, gd4Var3.e));
                }
                fd4 fd4Var2 = new fd4(gd4Var2, arrayList);
                map.put(str2, fd4Var2);
                fd4Var = fd4Var2;
            }
            fd4Var.a(i + 1, strSubstring, list, i2, i3, i4);
            return;
        }
        if (list == null) {
            if (gd4Var.a <= i) {
                gd4Var.a = i;
            }
            if (i2 != -1) {
                gd4Var.c = i2;
            }
            if (i3 != 0) {
                gd4Var.d = i3;
            }
            if (i4 != 0) {
                gd4Var.e = i4;
                return;
            }
            return;
        }
        for (gd4 gd4Var4 : list2) {
            if (m44.d(gd4Var4.b, list) == 0) {
                if (gd4Var4.a <= i) {
                    gd4Var4.a = i;
                }
                if (i2 != -1) {
                    gd4Var4.c = i2;
                }
                if (i3 != 0) {
                    gd4Var4.d = i3;
                }
                if (i4 != 0) {
                    gd4Var4.e = i4;
                    return;
                }
                return;
            }
        }
        list2.add(new gd4(i, list, i2 == -1 ? gd4Var.c : i2, i3 == 0 ? gd4Var.d : i3, i4 == 0 ? gd4Var.e : i4));
    }

    public final List b(String str) {
        String strSubstring = "";
        boolean zEquals = "".equals(str);
        List list = this.b;
        gd4 gd4Var = this.a;
        if (zEquals) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(gd4Var);
            arrayList.addAll(list);
            if (arrayList.size() == 1) {
                return arrayList;
            }
            List.EL.sort(arrayList, new i60(13));
            return arrayList;
        }
        int iIndexOf = str.indexOf(46);
        if (iIndexOf != -1) {
            String strSubstring2 = str.substring(0, iIndexOf);
            strSubstring = str.substring(iIndexOf + 1);
            str = strSubstring2;
        }
        HashMap map = this.c;
        if (map.containsKey(str)) {
            return ((fd4) map.get(str)).b(strSubstring);
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(gd4Var);
        arrayList2.addAll(list);
        if (arrayList2.size() == 1) {
            return arrayList2;
        }
        List.EL.sort(arrayList2, new i60(13));
        return arrayList2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fd4)) {
            return false;
        }
        fd4 fd4Var = (fd4) obj;
        return this.c.equals(fd4Var.c) && this.a.equals(fd4Var.a) && this.b.equals(fd4Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + ((this.a.hashCode() + ((this.c.hashCode() + 31) * 31)) * 31);
    }
}
