package io.sentry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class l0 {
    public static final HashMap i;
    public final HashMap a = new HashMap();
    public final ArrayList b = new ArrayList();
    public final io.sentry.util.a c = new io.sentry.util.a();
    public a d = null;
    public a e = null;
    public a f = null;
    public a g = null;
    public b4 h = null;

    static {
        HashMap map = new HashMap();
        i = map;
        map.put("boolean", Boolean.class);
        map.put("char", Character.class);
        map.put("byte", Byte.class);
        map.put("short", Short.class);
        map.put("int", Integer.class);
        map.put("long", Long.class);
        map.put("float", Float.class);
        map.put("double", Double.class);
    }

    public final void a() {
        io.sentry.util.a aVar = this.c;
        aVar.g();
        try {
            Iterator it = this.a.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (entry.getKey() == null || !((String) entry.getKey()).startsWith("sentry:")) {
                    it.remove();
                }
            }
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final Object b(String str) {
        io.sentry.util.a aVar = this.c;
        aVar.g();
        try {
            Object obj = this.a.get(str);
            aVar.close();
            return obj;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final Object c(Class cls, String str) {
        io.sentry.util.a aVar = this.c;
        aVar.g();
        try {
            Object obj = this.a.get(str);
            if (cls.isInstance(obj)) {
                aVar.close();
                return obj;
            }
            Class cls2 = (Class) i.get(cls.getCanonicalName());
            if (obj != null && cls.isPrimitive() && cls2 != null) {
                if (cls2.isInstance(obj)) {
                    aVar.close();
                    return obj;
                }
            }
            aVar.close();
            return null;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void d(Object obj, String str) {
        io.sentry.util.a aVar = this.c;
        aVar.g();
        try {
            this.a.put(str, obj);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
