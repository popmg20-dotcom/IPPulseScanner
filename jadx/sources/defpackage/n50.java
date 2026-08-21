package defpackage;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class n50 {
    public static final Annotation[] a = new Annotation[0];
    public static final l50[] b = new l50[0];

    static {
        Collections.emptyIterator();
    }

    public static void a(Class cls, Class cls2, ArrayList arrayList) {
        if (cls == cls2 || cls == null || cls == Object.class || arrayList.contains(cls)) {
            return;
        }
        arrayList.add(cls);
        for (Class<?> cls3 : cls.getInterfaces()) {
            a(cls3, cls2, arrayList);
        }
        a(cls.getSuperclass(), cls2, arrayList);
    }

    public static void b(Class cls, Throwable th) {
        String name = cls.getName();
        String name2 = th.getClass().getName();
        String message = th.getMessage();
        StringBuilder sbE = fw.E("Failed on call to `getDeclaredMethods()` on class `", name, "`, problem: (", name2, ") ");
        sbE.append(message);
        throw new IllegalArgumentException(sbE.toString(), th);
    }

    public static String c(String str) {
        if (str == null) {
            return "[null]";
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append('\'');
        sb.append(str);
        sb.append('\'');
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(Member member, boolean z) {
        AccessibleObject accessibleObject = (AccessibleObject) member;
        try {
            Class<?> declaringClass = member.getDeclaringClass();
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(declaringClass.getModifiers()) && (!z || p(declaringClass))) {
                return;
            }
            accessibleObject.setAccessible(true);
        } catch (SecurityException e) {
            if (accessibleObject.isAccessible()) {
                return;
            }
            Class<?> declaringClass2 = member.getDeclaringClass();
            StringBuilder sb = new StringBuilder("Cannot access ");
            sb.append(member);
            String name = declaringClass2.getName();
            String message = e.getMessage();
            sb.append(" (from class ");
            sb.append(name);
            sb.append("; failed to set access: ");
            sb.append(message);
            throw new IllegalArgumentException(sb.toString());
        } catch (RuntimeException e2) {
            if (!"InaccessibleObjectException".equals(e2.getClass().getSimpleName())) {
                throw e2;
            }
            String simpleName = member.getClass().getSimpleName();
            String name2 = member.getName();
            String strT = t(member.getDeclaringClass());
            String name3 = e2.getClass().getName();
            String message2 = e2.getMessage();
            StringBuilder sbE = fw.E("Failed to call `setAccess()` on ", simpleName, " '", name2, "' (of class ");
            ha0.v(sbE, strT, ") due to `", name3, "`, problem: ");
            sbE.append(message2);
            throw new IllegalArgumentException(sbE.toString(), e2);
        }
    }

    public static String e(Object obj) {
        if (obj == null) {
            return "[null]";
        }
        return t(obj instanceof Class ? (Class) obj : obj.getClass());
    }

    public static Object f(Class cls, boolean z) {
        Constructor declaredConstructor;
        try {
            declaredConstructor = cls.getDeclaredConstructor(null);
            if (z) {
                d(declaredConstructor, z);
            } else if (!Modifier.isPublic(declaredConstructor.getModifiers())) {
                throw new IllegalArgumentException("Default constructor for " + cls.getName() + " is not accessible (non-public?): not allowed to try modify access via Reflection: cannot instantiate type");
            }
        } catch (NoSuchMethodException unused) {
            declaredConstructor = null;
        } catch (Exception e) {
            e = e;
            String str = "Failed to find default constructor of class " + cls.getName() + ", problem: " + e.getMessage();
            while (e.getCause() != null) {
                e = e.getCause();
            }
            v(e);
            if (e instanceof Error) {
                throw ((Error) e);
            }
            st4.l(str, e);
            return null;
        }
        if (declaredConstructor == null) {
            xe.r("Class ", cls.getName(), " has no default (no arg) constructor");
            return null;
        }
        try {
            return declaredConstructor.newInstance(null);
        } catch (Exception e2) {
            e = e2;
            String str2 = "Failed to instantiate class " + cls.getName() + ", problem: " + e.getMessage();
            while (e.getCause() != null) {
                e = e.getCause();
            }
            v(e);
            if (e instanceof Error) {
                throw ((Error) e);
            }
            st4.l(str2, e);
            return null;
        }
    }

    public static String g(Throwable th) {
        return th instanceof l62 ? ((l62) th).a() : (!(th instanceof InvocationTargetException) || th.getCause() == null) ? th.getMessage() : th.getCause().getMessage();
    }

    public static Annotation[] h(Class cls) {
        return r(cls) ? a : cls.getDeclaredAnnotations();
    }

    public static ArrayList i(Class cls, Class cls2, boolean z) {
        ArrayList arrayList = new ArrayList(8);
        if (cls != null && cls != cls2) {
            if (z) {
                arrayList.add(cls);
            }
            while (true) {
                cls = cls.getSuperclass();
                if (cls == null || cls == cls2) {
                    break;
                }
                arrayList.add(cls);
            }
        }
        return arrayList;
    }

    public static Method[] j(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (Exception e) {
            b(cls, e);
            throw null;
        } catch (NoClassDefFoundError e2) {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader == null) {
                b(cls, e2);
                throw null;
            }
            try {
                try {
                    return contextClassLoader.loadClass(cls.getName()).getDeclaredMethods();
                } catch (Exception e3) {
                    b(cls, e3);
                    throw null;
                }
            } catch (ClassNotFoundException e4) {
                e2.addSuppressed(e4);
                b(cls, e2);
                throw null;
            }
        }
    }

    public static l50[] k(Class cls) {
        if (cls.isInterface() || r(cls)) {
            return b;
        }
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        int length = declaredConstructors.length;
        l50[] l50VarArr = new l50[length];
        for (int i = 0; i < length; i++) {
            l50VarArr[i] = new l50(declaredConstructors[i]);
        }
        return l50VarArr;
    }

    public static Class l(Class cls) {
        if (!Modifier.isStatic(cls.getModifiers())) {
            try {
                if ((r(cls) || cls.getEnclosingMethod() == null) && !r(cls)) {
                    return cls.getEnclosingClass();
                }
                return null;
            } catch (SecurityException unused) {
            }
        }
        return null;
    }

    public static String m(nj4 nj4Var) {
        if (nj4Var == null) {
            return "[null]";
        }
        int i = 0;
        while (true) {
            nj4Var.getClass();
            if (!(nj4Var instanceof ne)) {
                break;
            }
            i++;
            nj4Var = ((ne) nj4Var).U0;
        }
        StringBuilder sb = new StringBuilder(80);
        sb.append('`');
        sb.append(nj4Var.V());
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                sb.append('`');
                return sb.toString();
            }
            sb.append("[]");
            i = i2;
        }
    }

    public static boolean n(Object obj, Class cls) {
        return obj != null && obj.getClass() == cls;
    }

    public static boolean o(Class cls) {
        return cls == Void.class || cls == Void.TYPE || cls == yr2.class;
    }

    public static boolean p(Class cls) {
        String name = cls.getName();
        return name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("sun.");
    }

    public static boolean q(b72 b72Var) {
        return b72Var == null || b72Var.getClass().getAnnotation(w22.class) != null;
    }

    public static boolean r(Class cls) {
        return cls == Object.class || cls.isPrimitive();
    }

    public static boolean s(Class cls) {
        Class superclass = cls.getSuperclass();
        return superclass != null && "ra2".equals(superclass.getName());
    }

    public static String t(Class cls) {
        if (cls == null) {
            return "[null]";
        }
        int i = 0;
        while (cls.isArray()) {
            i++;
            cls = cls.getComponentType();
        }
        String simpleName = cls.isPrimitive() ? cls.getSimpleName() : cls.getName();
        if (i > 0) {
            StringBuilder sb = new StringBuilder(simpleName);
            do {
                sb.append("[]");
                i--;
            } while (i > 0);
            simpleName = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder(simpleName.length() + 2);
        sb2.append('`');
        sb2.append(simpleName);
        sb2.append('`');
        return sb2.toString();
    }

    public static Class u(Class cls) {
        if (cls.isPrimitive()) {
            return cls;
        }
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Long.class) {
            return Long.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        if (cls == Double.class) {
            return Double.TYPE;
        }
        if (cls == Float.class) {
            return Float.TYPE;
        }
        if (cls == Byte.class) {
            return Byte.TYPE;
        }
        if (cls == Short.class) {
            return Short.TYPE;
        }
        if (cls == Character.class) {
            return Character.TYPE;
        }
        return null;
    }

    public static void v(Throwable th) {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
    }

    public static void w(Class cls, l34 l34Var, String str) {
        if (l34Var.getClass() == cls) {
            return;
        }
        xe.q(fw.y(fw.E("Sub-class ", l34Var.getClass().getName(), " (of class ", cls.getName(), ") must override method '"), str, "'"));
    }
}
