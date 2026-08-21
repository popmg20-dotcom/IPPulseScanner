package defpackage;

import j$.util.Objects;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class di0 {
    public static final di0 b;
    public final HashMap a;

    static {
        di0 di0Var = new di0(new LinkedHashMap());
        ek0.F(di0Var);
        b = di0Var;
    }

    public di0(di0 di0Var) {
        di0Var.getClass();
        this.a = new HashMap(di0Var.a);
    }

    public final boolean a(String str) {
        Object obj = this.a.get(str);
        return obj != null && String.class.isAssignableFrom(obj.getClass());
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean equals(Object obj) {
        boolean zB0;
        if (this != obj) {
            if (obj != null && di0.class.equals(obj.getClass())) {
                HashMap map = ((di0) obj).a;
                HashMap map2 = this.a;
                Set<String> setKeySet = map2.keySet();
                if (n12.c(setKeySet, map.keySet())) {
                    for (String str : setKeySet) {
                        Object obj2 = map2.get(str);
                        Object obj3 = map.get(str);
                        if (obj2 == null || obj3 == null) {
                            zB0 = obj2 == obj3;
                        } else if (obj2 instanceof Object[]) {
                            zB0 = obj3 instanceof Object[] ? qe.b0((Object[]) obj2, (Object[]) obj3) : obj2.equals(obj3);
                        }
                        if (!zB0) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int iHashCode = 0;
        for (Map.Entry entry : this.a.entrySet()) {
            Object value = entry.getValue();
            iHashCode += value instanceof Object[] ? Objects.hashCode(entry.getKey()) ^ Arrays.deepHashCode((Object[]) value) : entry.hashCode();
        }
        return iHashCode * 31;
    }

    public final String toString() {
        return fw.y(new StringBuilder("Data {"), d70.j0(this.a.entrySet(), null, null, null, new ji(3), 31), "}");
    }

    public di0(LinkedHashMap linkedHashMap) {
        this.a = new HashMap(linkedHashMap);
    }
}
