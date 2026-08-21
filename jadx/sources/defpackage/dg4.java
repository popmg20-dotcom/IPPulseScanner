package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dg4 {
    public static long b;
    public static long c;
    public static long d;
    public static long e;
    public static long f;
    public static long g;
    public static long h;
    public static long i;
    public static boolean n;
    public static re2 o;
    public static final dg4 a = new dg4();
    public static final HashMap j = new HashMap();
    public static final HashMap k = new HashMap();
    public static final HashMap l = new HashMap();
    public static final HashMap m = new HashMap();
    public static final on2 p = new on2(new eg4(0, 0, 0, 0, 0, 0, 0, 0));
    public static final on2 q = new on2(g41.b);
    public static final hw r = new hw(2);

    public final void a(long j2, int i2, boolean z) {
        Object obj = 0L;
        if (j2 == 0) {
            return;
        }
        synchronized (this) {
            try {
                long jAbs = Math.abs(j2);
                if (j2 < 0) {
                    b += jAbs;
                    if (z) {
                        c += jAbs;
                    }
                    if (i2 != -1) {
                        HashMap map = j;
                        Integer numValueOf = Integer.valueOf(i2);
                        Object obj2 = map.get(numValueOf);
                        if (obj2 == null) {
                            map.put(numValueOf, obj);
                        } else {
                            obj = obj2;
                        }
                        map.put(Integer.valueOf(i2), Long.valueOf(((Number) obj).longValue() + jAbs));
                    }
                } else {
                    f += jAbs;
                    if (z) {
                        g += jAbs;
                    }
                    if (i2 != -1) {
                        HashMap map2 = l;
                        Integer numValueOf2 = Integer.valueOf(i2);
                        Object obj3 = map2.get(numValueOf2);
                        if (obj3 == null) {
                            map2.put(numValueOf2, obj);
                        } else {
                            obj = obj3;
                        }
                        map2.put(Integer.valueOf(i2), Long.valueOf(((Number) obj).longValue() + jAbs));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
