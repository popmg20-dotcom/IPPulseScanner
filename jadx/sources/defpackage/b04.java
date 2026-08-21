package defpackage;

import android.os.Handler;
import android.os.Looper;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class b04 {
    public static final ConcurrentHashMap a = new ConcurrentHashMap();
    public static final LinkedHashSet b = new LinkedHashSet();
    public static final Handler c = new Handler(Looper.getMainLooper());

    public static void a(String str, String str2, String str3) {
        int i;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : a.entrySet()) {
            f82 f82Var = (f82) entry.getKey();
            if (n12.c(f82Var.b, str) && n12.c(f82Var.f, str2)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        int i2 = 0;
        if (linkedHashMap.isEmpty()) {
            i = 0;
        } else {
            Iterator it = linkedHashMap.entrySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                if (((pn0) ((Map.Entry) it.next()).getValue()) instanceof nn0) {
                    i3++;
                }
            }
            i = i3;
        }
        if (!linkedHashMap.isEmpty()) {
            Iterator it2 = linkedHashMap.entrySet().iterator();
            while (it2.hasNext()) {
                if (((pn0) ((Map.Entry) it2.next()).getValue()) instanceof ln0) {
                    i2++;
                }
            }
        }
        ve1 ve1Var = new ve1(i, i2, str, str2, str3);
        Iterator it3 = b.iterator();
        while (it3.hasNext()) {
            c.post(new xy0(19, (ya3) it3.next(), ve1Var));
        }
    }
}
