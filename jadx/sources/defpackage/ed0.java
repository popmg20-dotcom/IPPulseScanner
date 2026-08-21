package defpackage;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ed0 implements InvocationHandler {
    public final j50 a;
    public final am1 b;

    public ed0(j50 j50Var, am1 am1Var) {
        this.a = j50Var;
        this.b = am1Var;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        obj.getClass();
        method.getClass();
        boolean zC = n12.c(method.getName(), "accept");
        am1 am1Var = this.b;
        if (zC && objArr != null && objArr.length == 1) {
            Object obj2 = objArr[0];
            ke0.e(this.a, obj2);
            am1Var.g(obj2);
            return xl4.a;
        }
        if (n12.c(method.getName(), "equals") && method.getReturnType().equals(Boolean.TYPE) && objArr != null && objArr.length == 1) {
            return Boolean.valueOf(obj == objArr[0]);
        }
        if (n12.c(method.getName(), "hashCode") && method.getReturnType().equals(Integer.TYPE) && objArr == null) {
            return Integer.valueOf(am1Var.hashCode());
        }
        if (n12.c(method.getName(), "toString") && method.getReturnType().equals(String.class) && objArr == null) {
            return am1Var.toString();
        }
        throw new UnsupportedOperationException("Unexpected method call object:" + obj + ", method: " + method + ", args: " + objArr);
    }
}
