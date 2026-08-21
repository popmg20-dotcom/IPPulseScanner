package defpackage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class xe2 {
    public static volatile int a;
    public static final fa5 b = new fa5(7);
    public static final go2 c = new go2();
    public static final boolean d;
    public static final String[] e;
    public static final String f;

    static {
        String property;
        try {
            property = System.getProperty("slf4j.detectLoggerNameMismatch");
        } catch (SecurityException unused) {
            property = null;
        }
        d = property == null ? false : property.equalsIgnoreCase("true");
        e = new String[]{"1.6", "1.7"};
        f = "org/slf4j/impl/StaticLoggerBinder.class";
    }

    public static LinkedHashSet a() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = xe2.class.getClassLoader();
            String str = f;
            Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources(str) : classLoader.getResources(str);
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add(systemResources.nextElement());
            }
            return linkedHashSet;
        } catch (IOException e2) {
            co4.Q("Error getting resources from path", e2);
            return linkedHashSet;
        }
    }

    public static qv1 b() {
        if (a == 0) {
            synchronized (xe2.class) {
                try {
                    if (a == 0) {
                        a = 1;
                        f();
                    }
                } finally {
                }
            }
        }
        int i = a;
        if (i == 1) {
            return b;
        }
        if (i == 2) {
            xe.q("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
            return null;
        }
        if (i == 3) {
            return v24.b.a;
        }
        if (i == 4) {
            return c;
        }
        xe.q("Unreachable code");
        return null;
    }

    public static we2 c(Class cls) {
        int i;
        we2 we2VarD = d(cls.getName());
        if (d) {
            bo4 bo4Var = co4.a;
            Class cls2 = null;
            if (bo4Var == null) {
                if (co4.b) {
                    bo4Var = null;
                } else {
                    try {
                        bo4Var = new bo4();
                    } catch (SecurityException unused) {
                        bo4Var = null;
                    }
                    co4.a = bo4Var;
                    co4.b = true;
                }
            }
            if (bo4Var != null) {
                Class[] classContext = bo4Var.getClassContext();
                String name = co4.class.getName();
                int i2 = 0;
                while (i2 < classContext.length && !name.equals(classContext[i2].getName())) {
                    i2++;
                }
                if (i2 >= classContext.length || (i = i2 + 2) >= classContext.length) {
                    xe.q("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
                    return null;
                }
                cls2 = classContext[i];
            }
            if (cls2 != null && !cls2.isAssignableFrom(cls)) {
                co4.P("Detected logger name mismatch. Given name: \"" + we2VarD.getName() + "\"; computed name: \"" + cls2.getName() + "\".");
                co4.P("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
            }
        }
        return we2VarD;
    }

    public static we2 d(String str) {
        return b().b(str);
    }

    public static boolean e() {
        String property;
        try {
            property = System.getProperty("java.vendor.url");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            return false;
        }
        return property.toLowerCase().contains("android");
    }

    public static final void f() {
        LinkedHashSet linkedHashSetA;
        try {
            try {
                try {
                    if (e()) {
                        linkedHashSetA = null;
                    } else {
                        linkedHashSetA = a();
                        i(linkedHashSetA);
                    }
                    v24 v24Var = v24.b;
                    a = 3;
                    h(linkedHashSetA);
                } catch (NoClassDefFoundError e2) {
                    String message = e2.getMessage();
                    if (message == null || (!message.contains("org/slf4j/impl/StaticLoggerBinder") && !message.contains("org.slf4j.impl.StaticLoggerBinder"))) {
                        a = 2;
                        co4.Q("Failed to instantiate SLF4J LoggerFactory", e2);
                        throw e2;
                    }
                    a = 4;
                    co4.P("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                    co4.P("Defaulting to no-operation (NOP) logger implementation");
                    co4.P("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
                }
                if (a == 3) {
                    String[] strArr = e;
                    try {
                        String str = v24.c;
                        boolean z = false;
                        for (String str2 : strArr) {
                            if (str.startsWith(str2)) {
                                z = true;
                            }
                        }
                        if (z) {
                            return;
                        }
                        co4.P("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(strArr).toString());
                        co4.P("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
                    } catch (NoSuchFieldError unused) {
                    } catch (Throwable th) {
                        co4.Q("Unexpected problem occured during version sanity check", th);
                    }
                }
            } catch (Exception e3) {
                a = 2;
                co4.Q("Failed to instantiate SLF4J LoggerFactory", e3);
                throw new IllegalStateException("Unexpected initialization failure", e3);
            } catch (NoSuchMethodError e4) {
                String message2 = e4.getMessage();
                if (message2 != null && message2.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                    a = 2;
                    co4.P("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                    co4.P("Your binding is version 1.5.5 or earlier.");
                    co4.P("Upgrade your binding to version 1.6.x.");
                }
                throw e4;
            }
        } finally {
            g();
        }
    }

    public static void g() {
        fa5 fa5Var = b;
        synchronized (fa5Var) {
            try {
                fa5Var.b = true;
                for (j54 j54Var : new ArrayList(((HashMap) fa5Var.f).values())) {
                    j54Var.f = d(j54Var.b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        LinkedBlockingQueue linkedBlockingQueue = (LinkedBlockingQueue) b.z;
        int size = linkedBlockingQueue.size();
        ArrayList<k54> arrayList = new ArrayList(128);
        int i = 0;
        while (linkedBlockingQueue.drainTo(arrayList, 128) != 0) {
            for (k54 k54Var : arrayList) {
                if (k54Var != null) {
                    j54 j54Var2 = k54Var.a;
                    String str = j54Var2.b;
                    if (j54Var2.f == null) {
                        xe.q("Delegate logger cannot be null at this state.");
                        return;
                    } else if (!(j54Var2.f instanceof fo2)) {
                        if (!j54Var2.b()) {
                            co4.P(str);
                        } else if (j54Var2.b()) {
                            try {
                                j54Var2.A.invoke(j54Var2.f, k54Var);
                            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
                            }
                        }
                    }
                }
                int i2 = i + 1;
                if (i == 0) {
                    if (k54Var.a.b()) {
                        co4.P("A number (" + size + ") of logging calls during the initialization phase have been intercepted and are");
                        co4.P("now being replayed. These are subject to the filtering rules of the underlying logging system.");
                        co4.P("See also http://www.slf4j.org/codes.html#replay");
                    } else if (!(k54Var.a.f instanceof fo2)) {
                        co4.P("The following set of substitute loggers may have been accessed");
                        co4.P("during the initialization phase. Logging calls during this");
                        co4.P("phase were not honored. However, subsequent logging calls to these");
                        co4.P("loggers will work as normally expected.");
                        co4.P("See also http://www.slf4j.org/codes.html#substituteLogger");
                    }
                }
                i = i2;
            }
            arrayList.clear();
        }
        fa5 fa5Var2 = b;
        ((HashMap) fa5Var2.f).clear();
        ((LinkedBlockingQueue) fa5Var2.z).clear();
    }

    public static void h(LinkedHashSet linkedHashSet) {
        if (linkedHashSet == null || linkedHashSet.size() <= 1) {
            return;
        }
        StringBuilder sb = new StringBuilder("Actual binding is of type [");
        v24.b.getClass();
        sb.append(v24.d);
        sb.append("]");
        co4.P(sb.toString());
    }

    public static void i(LinkedHashSet linkedHashSet) {
        if (linkedHashSet.size() > 1) {
            co4.P("Class path contains multiple SLF4J bindings.");
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                co4.P("Found binding in [" + ((URL) it.next()) + "]");
            }
            co4.P("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }
}
