package defpackage;

import io.sentry.android.core.a1;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jf2 {
    public final LinkedHashMap a;

    public jf2(int i) {
        switch (i) {
            case 2:
                this.a = new LinkedHashMap();
                break;
            default:
                this.a = new LinkedHashMap(0, 0.75f, true);
                break;
        }
    }

    public void a(fm2 fm2Var) {
        fm2Var.getClass();
        int i = fm2Var.a;
        int i2 = fm2Var.b;
        Integer numValueOf = Integer.valueOf(i);
        LinkedHashMap linkedHashMap = this.a;
        Object treeMap = linkedHashMap.get(numValueOf);
        if (treeMap == null) {
            treeMap = new TreeMap();
            linkedHashMap.put(numValueOf, treeMap);
        }
        TreeMap treeMap2 = (TreeMap) treeMap;
        if (treeMap2.containsKey(Integer.valueOf(i2))) {
            a1.n("ROOM", "Overriding migration " + treeMap2.get(Integer.valueOf(i2)) + " with " + fm2Var);
        }
        treeMap2.put(Integer.valueOf(i2), fm2Var);
    }

    public jf2(i03 i03Var) {
        Map map = i03Var.b;
        map.getClass();
        this.a = new LinkedHashMap(map);
    }
}
