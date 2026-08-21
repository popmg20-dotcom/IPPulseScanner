package defpackage;

import android.hardware.camera2.params.DynamicRangeProfiles;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class pz0 {
    public static final HashMap a;
    public static final HashMap b;

    static {
        oz0 oz0Var;
        HashMap map = new HashMap();
        a = map;
        HashMap map2 = new HashMap();
        b = map2;
        oz0 oz0Var2 = oz0.d;
        map.put(1L, oz0Var2);
        map2.put(oz0Var2, Collections.singletonList(1L));
        map.put(2L, oz0.e);
        map2.put((oz0) map.get(2L), Collections.singletonList(2L));
        oz0 oz0Var3 = oz0.f;
        map.put(4L, oz0Var3);
        map2.put(oz0Var3, Collections.singletonList(4L));
        oz0 oz0Var4 = oz0.g;
        map.put(8L, oz0Var4);
        map2.put(oz0Var4, Collections.singletonList(8L));
        List listAsList = Arrays.asList(64L, 128L, 16L, 32L);
        Iterator it = listAsList.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            oz0Var = oz0.h;
            if (!zHasNext) {
                break;
            } else {
                a.put((Long) it.next(), oz0Var);
            }
        }
        b.put(oz0Var, listAsList);
        List listAsList2 = Arrays.asList(1024L, 2048L, 256L, 512L);
        Iterator it2 = listAsList2.iterator();
        while (true) {
            boolean zHasNext2 = it2.hasNext();
            oz0 oz0Var5 = oz0.i;
            if (!zHasNext2) {
                b.put(oz0Var5, listAsList2);
                return;
            }
            a.put((Long) it2.next(), oz0Var5);
        }
    }

    public static Long a(oz0 oz0Var, DynamicRangeProfiles dynamicRangeProfiles) {
        List<Long> list = (List) b.get(oz0Var);
        if (list == null) {
            return null;
        }
        Set<Long> supportedProfiles = dynamicRangeProfiles.getSupportedProfiles();
        for (Long l : list) {
            if (supportedProfiles.contains(l)) {
                return l;
            }
        }
        return null;
    }
}
