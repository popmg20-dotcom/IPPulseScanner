package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pv3 extends v74 implements em1 {
    public /* synthetic */ tv3 X;
    public /* synthetic */ rn2 Y;

    @Override // defpackage.em1
    public final Object e(Object obj, Object obj2, Object obj3) {
        pv3 pv3Var = new pv3(3, (ge0) obj3);
        pv3Var.X = (tv3) obj;
        pv3Var.Y = (rn2) obj2;
        return pv3Var.p(xl4.a);
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        n12.S(obj);
        tv3 tv3Var = this.X;
        rn2 rn2Var = this.Y;
        Set setKeySet = rn2Var.a().keySet();
        ArrayList arrayList = new ArrayList(f70.Q(10, setKeySet));
        Iterator it = setKeySet.iterator();
        while (it.hasNext()) {
            arrayList.add(((u33) it.next()).a);
        }
        Map<String, ?> all = tv3Var.a.getAll();
        all.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<String, ?>> it2 = all.entrySet().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Map.Entry<String, ?> next = it2.next();
            String key = next.getKey();
            Set set = tv3Var.b;
            if (set != null ? set.contains(key) : true) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(fh2.U(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key2 = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Set) {
                value = d70.C0((Iterable) value);
            }
            linkedHashMap2.put(key2, value);
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            if (!arrayList.contains((String) entry2.getKey())) {
                linkedHashMap3.put(entry2.getKey(), entry2.getValue());
            }
        }
        rn2 rn2Var2 = new rn2(new LinkedHashMap(rn2Var.a()), false);
        for (Map.Entry entry3 : linkedHashMap3.entrySet()) {
            String str = (String) entry3.getKey();
            Object value2 = entry3.getValue();
            if (value2 instanceof Boolean) {
                str.getClass();
                rn2Var2.d(new u33(str), value2);
            } else if (value2 instanceof Float) {
                str.getClass();
                rn2Var2.d(new u33(str), value2);
            } else if (value2 instanceof Integer) {
                str.getClass();
                rn2Var2.d(new u33(str), value2);
            } else if (value2 instanceof Long) {
                str.getClass();
                rn2Var2.d(new u33(str), value2);
            } else if (value2 instanceof String) {
                str.getClass();
                rn2Var2.d(new u33(str), value2);
            } else if (value2 instanceof Set) {
                str.getClass();
                rn2Var2.d(new u33(str), (Set) value2);
            }
        }
        return new rn2(new LinkedHashMap(rn2Var2.a()), true);
    }
}
