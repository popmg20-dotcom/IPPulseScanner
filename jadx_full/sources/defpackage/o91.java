package defpackage;

import j$.util.DesugarCollections;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class o91 {
    public static volatile o91 b;
    public static final o91 c = new o91(0);
    public final Map a;

    public o91(o91 o91Var) {
        if (o91Var == c) {
            this.a = Collections.EMPTY_MAP;
        } else {
            this.a = DesugarCollections.unmodifiableMap(o91Var.a);
        }
    }

    public static o91 a() {
        o91 o91Var;
        Class cls = l7.a;
        o91 o91Var2 = b;
        if (o91Var2 != null) {
            return o91Var2;
        }
        synchronized (o91.class) {
            try {
                o91Var = b;
                if (o91Var == null) {
                    Class cls2 = m91.a;
                    o91 o91Var3 = null;
                    if (cls2 != null) {
                        try {
                            o91Var3 = (o91) cls2.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                        } catch (Exception unused) {
                        }
                    }
                    o91Var = o91Var3 != null ? o91Var3 : c;
                    b = o91Var;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return o91Var;
    }

    public o91() {
        this.a = new HashMap();
    }

    public o91(int i) {
        this.a = Collections.EMPTY_MAP;
    }
}
