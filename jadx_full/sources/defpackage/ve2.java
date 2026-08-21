package defpackage;

import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ve2 {
    public static final WeakHashMap b = new WeakHashMap();
    public final String a;

    public ve2(String str) {
        this.a = str;
    }

    public static synchronized ve2 a(String str) {
        ve2 ve2Var;
        WeakHashMap weakHashMap = b;
        ve2Var = (ve2) weakHashMap.get(str);
        if (ve2Var == null) {
            ve2Var = new ve2(str);
            weakHashMap.put(str, ve2Var);
        }
        return ve2Var;
    }
}
