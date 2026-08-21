package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class d34 {
    public static final HashMap a;

    static {
        HashMap map = new HashMap();
        a = map;
        map.put(boolean[].class.getName(), new w24(boolean[].class));
        map.put(byte[].class.getName(), new zs2(2));
        map.put(char[].class.getName(), new zs2(6));
        map.put(short[].class.getName(), new b34(short[].class));
        map.put(int[].class.getName(), new z24(int[].class));
        map.put(long[].class.getName(), new a34(long[].class));
        map.put(float[].class.getName(), new y24(float[].class));
        map.put(double[].class.getName(), new x24(double[].class));
    }

    public static void a(Class cls) {
        rj4.z.getClass();
        qj4 qj4Var = rj4.A;
        if (!qj4Var.f() || rj4.a(cls) == null) {
            new jx3(cls, qj4Var, null, null);
        }
    }
}
