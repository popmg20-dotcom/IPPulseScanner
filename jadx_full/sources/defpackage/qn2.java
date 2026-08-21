package defpackage;

import android.util.ArrayMap;
import j$.util.Objects;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qn2 extends sw2 {
    public static qn2 c() {
        return new qn2(new TreeMap(sw2.f));
    }

    public static qn2 d(ka0 ka0Var) {
        TreeMap treeMap = new TreeMap(sw2.f);
        for (pg pgVar : ka0Var.t()) {
            Set<ia0> setY = ka0Var.y(pgVar);
            ArrayMap arrayMap = new ArrayMap();
            for (ia0 ia0Var : setY) {
                arrayMap.put(ia0Var, ka0Var.C(pgVar, ia0Var));
            }
            treeMap.put(pgVar, arrayMap);
        }
        return new qn2(treeMap);
    }

    public final void f(pg pgVar, ia0 ia0Var, Object obj) {
        ia0 ia0Var2;
        TreeMap treeMap = this.b;
        Map map = (Map) treeMap.get(pgVar);
        if (map == null) {
            ArrayMap arrayMap = new ArrayMap();
            treeMap.put(pgVar, arrayMap);
            arrayMap.put(ia0Var, obj);
            return;
        }
        ia0 ia0Var3 = (ia0) Collections.min(map.keySet());
        if (Objects.equals(map.get(ia0Var3), obj) || ia0Var3 != (ia0Var2 = ia0.z) || ia0Var != ia0Var2) {
            map.put(ia0Var, obj);
            return;
        }
        StringBuilder sb = new StringBuilder("Option values conflicts: ");
        sb.append(pgVar.a);
        sb.append(", existing value (");
        sb.append(ia0Var3);
        Object obj2 = map.get(ia0Var3);
        sb.append(")=");
        sb.append(obj2);
        sb.append(", conflicting (");
        sb.append(ia0Var);
        sb.append(")=");
        sb.append(obj);
        throw new IllegalArgumentException(sb.toString());
    }

    public final void g(pg pgVar, Object obj) {
        f(pgVar, ia0.A, obj);
    }
}
