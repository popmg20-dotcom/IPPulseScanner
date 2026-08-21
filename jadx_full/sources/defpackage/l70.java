package defpackage;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class l70 {
    public final boolean a;
    public int b = -1;
    public final ArrayList c = new ArrayList();
    public final LinkedHashMap d = new LinkedHashMap();

    public l70(List list) {
        if (list == null) {
            this.a = false;
            return;
        }
        this.a = true;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.d.put((String) list.get(i), Integer.valueOf(i));
            this.c.add((String) list.get(i));
        }
    }

    public final int a(String str) {
        if (str == null) {
            return 0;
        }
        String upperCase = str.toUpperCase();
        LinkedHashMap linkedHashMap = this.d;
        Integer num = (Integer) linkedHashMap.get(upperCase);
        if (num != null) {
            return num.intValue();
        }
        if (this.a) {
            throw new r94(ha0.n("Missing color in color map - ", upperCase));
        }
        int i = this.b + 1;
        this.b = i;
        linkedHashMap.put(upperCase, Integer.valueOf(i));
        ArrayList arrayList = this.c;
        if (i >= arrayList.size()) {
            arrayList.add(upperCase);
            return i;
        }
        arrayList.set(i, upperCase);
        return i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l70)) {
            return false;
        }
        l70 l70Var = (l70) obj;
        return this.b == l70Var.b && this.d.equals(l70Var.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + ((this.b + 31) * 31);
    }
}
