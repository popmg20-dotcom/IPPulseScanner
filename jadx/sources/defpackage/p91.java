package defpackage;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p91 {
    public static volatile p91 b;
    public static final p91 c = new p91();
    public final Map a = Collections.EMPTY_MAP;

    public static p91 a() {
        p91 p91Var;
        v93 v93Var = v93.c;
        p91 p91Var2 = b;
        if (p91Var2 != null) {
            return p91Var2;
        }
        synchronized (p91.class) {
            try {
                p91Var = b;
                if (p91Var == null) {
                    Class cls = n91.a;
                    p91 p91Var3 = null;
                    if (cls != null) {
                        try {
                            p91Var3 = (p91) cls.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                        } catch (Exception unused) {
                        }
                    }
                    p91Var = p91Var3 != null ? p91Var3 : c;
                    b = p91Var;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return p91Var;
    }
}
