package defpackage;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q50 {
    public static final q50 c = new q50();
    public final HashMap a = new HashMap();
    public final HashMap b = new HashMap();

    public static void b(HashMap map, p50 p50Var, p92 p92Var, Class cls) {
        p92 p92Var2 = (p92) map.get(p50Var);
        if (p92Var2 == null || p92Var == p92Var2) {
            if (p92Var2 == null) {
                map.put(p50Var, p92Var);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + p50Var.b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + p92Var2 + ", new value " + p92Var);
    }

    public final o50 a(Class cls, Method[] methodArr) {
        int i;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        HashMap map2 = this.a;
        if (superclass != null) {
            o50 o50VarA = (o50) map2.get(superclass);
            if (o50VarA == null) {
                o50VarA = a(superclass, null);
            }
            map.putAll(o50VarA.b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            o50 o50VarA2 = (o50) map2.get(cls2);
            if (o50VarA2 == null) {
                o50VarA2 = a(cls2, null);
            }
            for (Map.Entry entry : o50VarA2.b.entrySet()) {
                b(map, (p50) entry.getKey(), (p92) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e) {
                st4.l("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
                return null;
            }
        }
        boolean z = false;
        for (Method method : methodArr) {
            ev2 ev2Var = (ev2) method.getAnnotation(ev2.class);
            if (ev2Var != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else {
                    if (!da2.class.isAssignableFrom(parameterTypes[0])) {
                        xe.k("invalid parameter type. Must be one and instanceof LifecycleOwner");
                        return null;
                    }
                    i = 1;
                }
                p92 p92VarValue = ev2Var.value();
                if (parameterTypes.length > 1) {
                    if (!p92.class.isAssignableFrom(parameterTypes[1])) {
                        xe.k("invalid parameter type. second arg must be an event");
                        return null;
                    }
                    if (p92VarValue != p92.ON_ANY) {
                        xe.k("Second arg is supported only for ON_ANY value");
                        return null;
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    xe.k("cannot have more than 2 params");
                    return null;
                }
                b(map, new p50(i, method), p92VarValue, cls);
                z = true;
            }
        }
        o50 o50Var = new o50(map);
        map2.put(cls, o50Var);
        this.b.put(cls, Boolean.valueOf(z));
        return o50Var;
    }
}
