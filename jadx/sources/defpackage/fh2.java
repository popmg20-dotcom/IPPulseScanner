package defpackage;

import io.netty.channel.internal.ChannelUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class fh2 extends vo {
    public static Object T(LinkedHashMap linkedHashMap, Object obj) {
        linkedHashMap.getClass();
        Object obj2 = linkedHashMap.get(obj);
        if (obj2 != null || linkedHashMap.containsKey(obj)) {
            return obj2;
        }
        throw new NoSuchElementException("Key " + obj + " is missing in the map.");
    }

    public static int U(int i) {
        return i < 0 ? i : i < 3 ? i + 1 : i < 1073741824 ? (int) ((i / 0.75f) + 1.0f) : ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
    }

    public static Map V(e03... e03VarArr) {
        if (e03VarArr.length <= 0) {
            return h41.b;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(U(e03VarArr.length));
        for (e03 e03Var : e03VarArr) {
            linkedHashMap.put(e03Var.b, e03Var.f);
        }
        return linkedHashMap;
    }

    public static void W(Map map, ArrayList arrayList) {
        map.getClass();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            e03 e03Var = (e03) it.next();
            map.put(e03Var.b, e03Var.f);
        }
    }

    public static Map X(ArrayList arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return h41.b;
        }
        if (size != 1) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(U(arrayList.size()));
            W(linkedHashMap, arrayList);
            return linkedHashMap;
        }
        e03 e03Var = (e03) arrayList.get(0);
        e03Var.getClass();
        Map mapSingletonMap = Collections.singletonMap(e03Var.b, e03Var.f);
        mapSingletonMap.getClass();
        return mapSingletonMap;
    }

    public static Map Y(Map map) {
        map.getClass();
        int size = map.size();
        if (size == 0) {
            return h41.b;
        }
        if (size != 1) {
            return new LinkedHashMap(map);
        }
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        mapSingletonMap.getClass();
        return mapSingletonMap;
    }
}
