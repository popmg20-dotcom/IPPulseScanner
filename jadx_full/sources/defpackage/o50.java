package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o50 {
    public final HashMap a = new HashMap();
    public final HashMap b;

    public o50(HashMap map) {
        this.b = map;
        for (Map.Entry entry : map.entrySet()) {
            p92 p92Var = (p92) entry.getValue();
            List arrayList = (List) this.a.get(p92Var);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.a.put(p92Var, arrayList);
            }
            arrayList.add((p50) entry.getKey());
        }
    }

    public static void a(List list, da2 da2Var, p92 p92Var, ca2 ca2Var) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                p50 p50Var = (p50) list.get(size);
                Method method = p50Var.b;
                try {
                    int i = p50Var.a;
                    if (i == 0) {
                        method.invoke(ca2Var, null);
                    } else if (i == 1) {
                        method.invoke(ca2Var, da2Var);
                    } else if (i == 2) {
                        method.invoke(ca2Var, da2Var, p92Var);
                    }
                } catch (IllegalAccessException e) {
                    vp1.p(e);
                    return;
                } catch (InvocationTargetException e2) {
                    zo2.o("Failed to call observer method", e2.getCause());
                    return;
                }
            }
        }
    }
}
