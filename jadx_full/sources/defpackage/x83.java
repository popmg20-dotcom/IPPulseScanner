package defpackage;

import java.util.Collections;
import java.util.Map;
import java.util.NavigableSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class x83 {
    public static final NavigableSet a = Collections.unmodifiableNavigableSet(ga5.b("true", "t", "yes", "y", "on"));
    public static final NavigableSet b = Collections.unmodifiableNavigableSet(ga5.b("false", "f", "no", "n", "off"));

    public static boolean a(v83 v83Var, String str) {
        Object objB = b(v83Var, str);
        Boolean bool = null;
        if (objB != null) {
            if (objB instanceof Boolean) {
                bool = (Boolean) objB;
            } else {
                if (!(objB instanceof CharSequence)) {
                    throw new UnsupportedOperationException("Cannot convert " + objB.getClass().getSimpleName() + "[" + objB + "] to boolean");
                }
                String string = objB.toString();
                if (!ga5.t(string)) {
                    if (a.contains(string)) {
                        bool = Boolean.TRUE;
                    } else if (b.contains(string)) {
                        bool = Boolean.FALSE;
                    } else {
                        xe.k(ha0.o("Unknown boolean value: '", string, "'"));
                    }
                }
            }
        }
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public static Object b(v83 v83Var, String str) {
        String strG = n12.g(str, "No property name");
        while (true) {
            if (v83Var == null) {
                return null;
            }
            Map mapF = v83Var.F();
            Object obj = mapF != null ? mapF.get(n12.g(strG, "No property name")) : null;
            if (obj != null) {
                return obj;
            }
            v83Var = v83Var.q0();
        }
    }

    public static Long c(Object obj) {
        return obj instanceof Long ? (Long) obj : obj instanceof Number ? Long.valueOf(((Number) obj).longValue()) : Long.valueOf(obj.toString());
    }
}
