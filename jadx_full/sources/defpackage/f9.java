package defpackage;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f9 extends k70 {
    public final g50 X;
    public final boolean Y;

    public f9(cu2 cu2Var, g50 g50Var, boolean z) {
        super(0, cu2Var);
        this.X = cu2Var == null ? null : g50Var;
        this.Y = z;
    }

    public static boolean Y0(Method method) {
        return (Modifier.isStatic(method.getModifiers()) || method.isSynthetic() || method.isBridge() || method.getParameterTypes().length > 2) ? false : true;
    }

    public final void W0(yj4 yj4Var, Class cls, LinkedHashMap linkedHashMap, Class cls2) {
        if (cls2 != null) {
            X0(yj4Var, cls, linkedHashMap, cls2);
        }
        if (cls == null) {
            return;
        }
        for (Method method : n50.j(cls)) {
            if (Y0(method)) {
                sj2 sj2Var = new sj2(method);
                e9 e9Var = (e9) linkedHashMap.get(sj2Var);
                if (e9Var == null) {
                    linkedHashMap.put(sj2Var, new e9(yj4Var, method, ((cu2) this.f) == null ? j9.e : H0(method.getDeclaredAnnotations())));
                } else {
                    if (this.Y) {
                        e9Var.c = I0(e9Var.c, method.getDeclaredAnnotations());
                    }
                    Method method2 = e9Var.b;
                    if (method2 == null) {
                        e9Var.b = method;
                    } else if (Modifier.isAbstract(method2.getModifiers()) && !Modifier.isAbstract(method.getModifiers())) {
                        e9Var.b = method;
                        e9Var.a = yj4Var;
                    }
                }
            }
        }
    }

    public final void X0(yj4 yj4Var, Class cls, LinkedHashMap linkedHashMap, Class cls2) {
        List list;
        if (((cu2) this.f) == null) {
            return;
        }
        Annotation[] annotationArr = n50.a;
        if (cls2 == null || cls2 == cls || cls2 == Object.class) {
            list = Collections.EMPTY_LIST;
        } else {
            ArrayList arrayList = new ArrayList(8);
            n50.a(cls2, cls, arrayList);
            list = arrayList;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            for (Method method : ((Class) it.next()).getDeclaredMethods()) {
                if (Y0(method)) {
                    sj2 sj2Var = new sj2(method);
                    e9 e9Var = (e9) linkedHashMap.get(sj2Var);
                    Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                    if (e9Var == null) {
                        linkedHashMap.put(sj2Var, new e9(yj4Var, null, H0(declaredAnnotations)));
                    } else {
                        e9Var.c = I0(e9Var.c, declaredAnnotations);
                    }
                }
            }
        }
    }
}
