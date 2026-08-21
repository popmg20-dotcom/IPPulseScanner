package defpackage;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class kk implements ge0, nf0, Serializable {
    public final ge0 b;

    public kk(ge0 ge0Var) {
        this.b = ge0Var;
    }

    @Override // defpackage.nf0
    public nf0 c() {
        ge0 ge0Var = this.b;
        if (ge0Var instanceof nf0) {
            return (nf0) ge0Var;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    @Override // defpackage.ge0
    public final void d(Object obj) {
        ?? r2 = this;
        while (true) {
            kk kkVar = (kk) r2;
            ge0 ge0Var = kkVar.b;
            ge0Var.getClass();
            try {
                obj = kkVar.p(obj);
                if (obj == mf0.b) {
                    return;
                }
            } catch (Throwable th) {
                obj = new tk3(th);
            }
            kkVar.q();
            if (!(ge0Var instanceof kk)) {
                ge0Var.d(obj);
                return;
            }
            r2 = ge0Var;
        }
    }

    public ge0 n(ge0 ge0Var, Object obj) {
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public StackTraceElement o() {
        int iIntValue;
        String strC;
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        dk0 dk0Var = (dk0) getClass().getAnnotation(dk0.class);
        String str = null;
        if (dk0Var == null || dk0Var.v() < 1) {
            return null;
        }
        try {
            Field declaredField = getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            iIntValue = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            iIntValue = -1;
        }
        int i = iIntValue >= 0 ? dk0Var.l()[iIntValue] : -1;
        nm2 nm2Var = p95.g;
        nm2 nm2Var2 = p95.h;
        if (nm2Var2 == null) {
            try {
                nm2 nm2Var3 = new nm2(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
                p95.h = nm2Var3;
                nm2Var2 = nm2Var3;
            } catch (Exception unused2) {
                p95.h = nm2Var;
                nm2Var2 = nm2Var;
            }
        }
        if (nm2Var2 != nm2Var && (method = nm2Var2.a) != null && (objInvoke = method.invoke(getClass(), null)) != null && (method2 = nm2Var2.b) != null && (objInvoke2 = method2.invoke(objInvoke, null)) != null) {
            Method method3 = nm2Var2.c;
            Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
            if (objInvoke3 instanceof String) {
                str = (String) objInvoke3;
            }
        }
        if (str == null) {
            strC = dk0Var.c();
        } else {
            strC = str + '/' + dk0Var.c();
        }
        return new StackTraceElement(strC, dk0Var.m(), dk0Var.f(), i);
    }

    public abstract Object p(Object obj);

    public String toString() {
        StringBuilder sb = new StringBuilder("Continuation at ");
        Object objO = o();
        if (objO == null) {
            objO = getClass().getName();
        }
        sb.append(objO);
        return sb.toString();
    }

    public void q() {
    }
}
