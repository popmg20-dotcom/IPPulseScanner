package defpackage;

import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class u94 {
    public static final u94 a = new u94();
    public static final iq1 b;

    static {
        u61 u61Var = u61.A;
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        si1 si1Var = iq1.j;
        int i = iq1.l;
        int i2 = iq1.m;
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList3 = new ArrayList(arrayList2.size() + arrayList.size() + 3);
        arrayList3.addAll(arrayList);
        Collections.reverse(arrayList3);
        ArrayList arrayList4 = new ArrayList(arrayList2);
        Collections.reverse(arrayList4);
        arrayList3.addAll(arrayList4);
        boolean z = d14.a;
        HashMap map2 = new HashMap(map);
        new ArrayList(arrayList);
        new ArrayList(arrayList2);
        b = new iq1(u61Var, 1, map2, si1Var, 1, arrayList3, i, i2, new ArrayList(arrayDeque));
    }

    public static void a(s94 s94Var, z94 z94Var, e93 e93Var, Object obj, Object obj2) {
        z94Var.add(obj);
        if (obj2 instanceof Map) {
            e93 e93VarT = s94Var.t(z94Var, Map.class);
            for (Map.Entry entry : ((Map) obj2).entrySet()) {
                a(s94Var, z94Var, e93VarT, entry.getKey(), entry.getValue());
            }
            e93Var.a(e93VarT, obj.toString());
        } else if (obj2 instanceof List) {
            List list = (List) obj2;
            e93 e93VarT2 = s94Var.t(z94Var, List.class);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                a(s94Var, z94Var, e93VarT2, Integer.valueOf(i), list.get(i));
            }
            e93Var.a(e93VarT2, obj.toString());
        } else {
            e93Var.a(obj2, obj.toString());
        }
        z94Var.remove(z94Var.size() - 1);
    }

    public Map b(StringReader stringReader) {
        iq1 iq1Var = b;
        iq1Var.getClass();
        return (Map) iq1Var.b(stringReader, new bk4(Map.class));
    }

    public final e93 c(StringReader stringReader, s94 s94Var) {
        Map mapB = b(stringReader);
        e93 e93VarS = s94Var.s();
        z94 z94Var = new z94();
        for (Map.Entry entry : mapB.entrySet()) {
            a(s94Var, z94Var, e93VarS, entry.getKey(), entry.getValue());
        }
        return e93VarS;
    }
}
