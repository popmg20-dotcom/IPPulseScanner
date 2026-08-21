package defpackage;

import androidx.fragment.app.o;
import androidx.fragment.app.u;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tj1 {
    public static final xw3 b = new xw3(0);
    public final /* synthetic */ u a;

    public tj1(u uVar) {
        this.a = uVar;
    }

    public static Class b(ClassLoader classLoader, String str) throws ClassNotFoundException {
        xw3 xw3Var = b;
        xw3 xw3Var2 = (xw3) xw3Var.get(classLoader);
        if (xw3Var2 == null) {
            xw3Var2 = new xw3(0);
            xw3Var.put(classLoader, xw3Var2);
        }
        Class cls = (Class) xw3Var2.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        xw3Var2.put(str, cls2);
        return cls2;
    }

    public static Class c(ClassLoader classLoader, String str) {
        try {
            return b(classLoader, str);
        } catch (ClassCastException e) {
            throw new t80(ha0.o("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e);
        } catch (ClassNotFoundException e2) {
            throw new t80(ha0.o("Unable to instantiate fragment ", str, ": make sure class name exists"), e2);
        }
    }

    public final o a(String str) {
        return o.instantiate(this.a.x.f, str, null);
    }
}
