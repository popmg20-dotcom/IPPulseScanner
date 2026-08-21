package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.function.ToIntFunction;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class mt0 {
    public static final Logger a = Logger.getLogger(mt0.class.getName());
    public static final int[] b = new int[0];
    public static final ws0[] c = new ws0[0];
    public static final ft0[] d = new ft0[0];
    public static final zs0[] e = new zs0[0];
    public static final lt0[] f = new lt0[0];
    public static final kt0[] g = new kt0[0];
    public static final ConcurrentHashMap h = new ConcurrentHashMap();
    public static volatile mq0 i = null;

    public static Object a(Object[] objArr, int i2, ToIntFunction toIntFunction, int i3) {
        int i4 = i2 - 1;
        int i5 = 0;
        while (i5 <= i4) {
            int i6 = (i5 + i4) / 2;
            Object obj = objArr[i6];
            int iApplyAsInt = toIntFunction.applyAsInt(obj);
            if (i3 < iApplyAsInt) {
                i4 = i6 - 1;
            } else {
                if (i3 <= iApplyAsInt) {
                    return obj;
                }
                i5 = i6 + 1;
            }
        }
        return null;
    }

    public static String b(gt0 gt0Var, ws0 ws0Var, String str) {
        if (ws0Var != null) {
            return ws0Var.A + '.' + str;
        }
        String strK = gt0Var.f.K();
        if (strK.isEmpty()) {
            return str;
        }
        return strK + '.' + str;
    }
}
