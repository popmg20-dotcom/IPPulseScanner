package defpackage;

import android.util.ArrayMap;
import j$.util.DesugarCollections;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class sw2 implements ka0 {
    public static final i60 f;
    public static final sw2 z;
    public final TreeMap b;

    static {
        i60 i60Var = new i60(8);
        f = i60Var;
        z = new sw2(new TreeMap(i60Var));
    }

    public sw2(TreeMap treeMap) {
        this.b = treeMap;
    }

    public static sw2 a(ka0 ka0Var) {
        if (sw2.class.equals(ka0Var.getClass())) {
            return (sw2) ka0Var;
        }
        TreeMap treeMap = new TreeMap(f);
        for (pg pgVar : ka0Var.t()) {
            Set<ia0> setY = ka0Var.y(pgVar);
            ArrayMap arrayMap = new ArrayMap();
            for (ia0 ia0Var : setY) {
                arrayMap.put(ia0Var, ka0Var.C(pgVar, ia0Var));
            }
            treeMap.put(pgVar, arrayMap);
        }
        return new sw2(treeMap);
    }

    @Override // defpackage.ka0
    public final Object C(pg pgVar, ia0 ia0Var) {
        Map map = (Map) this.b.get(pgVar);
        if (map == null) {
            vp1.h(pgVar, "Option does not exist: ");
            return null;
        }
        if (map.containsKey(ia0Var)) {
            return map.get(ia0Var);
        }
        ad0.k("Option does not exist: ", pgVar, " with priority=", ia0Var);
        return null;
    }

    @Override // defpackage.ka0
    public final boolean K(pg pgVar) {
        return this.b.containsKey(pgVar);
    }

    @Override // defpackage.ka0
    public final ia0 S(pg pgVar) {
        Map map = (Map) this.b.get(pgVar);
        if (map != null) {
            return (ia0) Collections.min(map.keySet());
        }
        vp1.h(pgVar, "Option does not exist: ");
        return null;
    }

    @Override // defpackage.ka0
    public final void l(ed edVar) {
        for (Map.Entry entry : this.b.tailMap(new pg("camera2.captureRequest.option.", Void.class, null)).entrySet()) {
            if (!((pg) entry.getKey()).a.startsWith("camera2.captureRequest.option.")) {
                return;
            }
            pg pgVar = (pg) entry.getKey();
            qx qxVar = (qx) edVar.f;
            ka0 ka0Var = (ka0) edVar.z;
            qxVar.b.f(pgVar, ka0Var.S(pgVar), ka0Var.u(pgVar));
        }
    }

    @Override // defpackage.ka0
    public final Object p(pg pgVar, Object obj) {
        Map map = (Map) this.b.get(pgVar);
        return map == null ? obj : map.get((ia0) Collections.min(map.keySet()));
    }

    @Override // defpackage.ka0
    public final Set t() {
        return DesugarCollections.unmodifiableSet(this.b.keySet());
    }

    @Override // defpackage.ka0
    public final Object u(pg pgVar) {
        Map map = (Map) this.b.get(pgVar);
        if (map != null) {
            return map.get((ia0) Collections.min(map.keySet()));
        }
        vp1.h(pgVar, "Option does not exist: ");
        return null;
    }

    @Override // defpackage.ka0
    public final Set y(pg pgVar) {
        Map map = (Map) this.b.get(pgVar);
        return map == null ? Collections.EMPTY_SET : DesugarCollections.unmodifiableSet(map.keySet());
    }
}
