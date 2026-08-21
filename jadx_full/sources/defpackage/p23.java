package defpackage;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class p23 implements InvocationHandler {
    public final j50 a;

    public p23(j50 j50Var) {
        this.a = j50Var;
    }

    public abstract boolean a(Object obj, Object obj2);

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        obj.getClass();
        method.getClass();
        boolean zC = n12.c(method.getName(), "test");
        Class cls = Boolean.TYPE;
        if (zC && method.getReturnType().equals(cls) && objArr != null && objArr.length == 1) {
            Object obj2 = objArr[0];
            ke0.e(this.a, obj2);
            return Boolean.valueOf(a(obj, obj2));
        }
        if (n12.c(method.getName(), "equals") && method.getReturnType().equals(cls) && objArr != null && objArr.length == 1) {
            Object obj3 = objArr[0];
            obj3.getClass();
            return Boolean.valueOf(obj == obj3);
        }
        if (n12.c(method.getName(), "hashCode") && method.getReturnType().equals(Integer.TYPE) && objArr == null) {
            return Integer.valueOf(hashCode());
        }
        if (n12.c(method.getName(), "toString") && method.getReturnType().equals(String.class) && objArr == null) {
            return toString();
        }
        throw new UnsupportedOperationException("Unexpected method call object:" + obj + ", method: " + method + ", args: " + objArr);
    }
}
