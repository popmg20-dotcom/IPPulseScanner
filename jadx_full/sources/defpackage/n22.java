package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n22 {
    public static final n22 d;
    public static final RuntimeException e;
    public final Method a;
    public final Method b;
    public final Method c;

    static {
        n22 n22Var = null;
        try {
            e = null;
            n22Var = new n22();
        } catch (RuntimeException e2) {
            e = e2;
        }
        d = n22Var;
        e = e;
    }

    public n22() {
        try {
            this.a = Class.class.getMethod("getRecordComponents", null);
            Class<?> cls = Class.forName("java.lang.reflect.RecordComponent");
            this.b = cls.getMethod("getName", null);
            this.c = cls.getMethod("getType", null);
        } catch (Exception e2) {
            zo2.o(fw.u("Failed to access Methods needed to support `java.lang.Record`: (", e2.getClass().getName(), ") ", e2.getMessage()), e2);
            throw null;
        }
    }

    public final Object[] a(Class cls) {
        boolean zEquals;
        try {
            return (Object[]) this.a.invoke(cls, null);
        } catch (Exception e2) {
            e = e2;
            if (yo2.a && "runtime".equals(System.getProperty("org.graalvm.nativeimage.imagecode"))) {
                if (e instanceof InvocationTargetException) {
                    e = e.getCause();
                }
                zEquals = e.getClass().getName().equals("com.oracle.svm.core.jdk.UnsupportedFeatureError");
            } else {
                zEquals = false;
            }
            if (zEquals) {
                return null;
            }
            xe.k("Failed to access RecordComponents of type ".concat(n50.t(cls)));
            return null;
        }
    }
}
