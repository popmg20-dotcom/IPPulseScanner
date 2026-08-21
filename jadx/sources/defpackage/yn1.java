package defpackage;

import j$.util.DesugarCollections;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class yn1 extends c1 implements Serializable {
    public static final /* synthetic */ int A = 0;
    public final cm4 z;

    static {
        Logger.getLogger(yn1.class.getName());
        new CopyOnWriteArraySet();
    }

    public yn1(kn1 kn1Var) {
        this.z = kn1Var.i();
    }

    public static Object B(Object obj, Method method, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            e04.l("Couldn't use Java reflection to implement protocol message reflection.", e);
            return null;
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            e04.l("Unexpected exception thrown by generated accessor method.", cause);
            return null;
        }
    }

    public static boolean C(Object obj) {
        return obj instanceof String ? ((String) obj).isEmpty() : ((zt) obj).isEmpty();
    }

    public static k1 D(k1 k1Var) {
        int size = k1Var.size();
        int i = size >= 0 ? size * 2 : 0;
        if (i <= 0) {
            i = 10;
        }
        return k1Var.c(i);
    }

    public static void E(q60 q60Var, og2 og2Var, ig2 ig2Var, int i) throws a60 {
        Map mapA0 = og2Var.a0();
        q60Var.getClass();
        for (Map.Entry entry : mapA0.entrySet()) {
            gg2 gg2VarK = ig2Var.k();
            gg2VarK.f = entry.getKey();
            gg2VarK.A = true;
            gg2VarK.z = entry.getValue();
            gg2VarK.X = true;
            q60Var.u(i, gg2VarK.build());
        }
    }

    public static void G(q60 q60Var, int i, Object obj) {
        if (!(obj instanceof String)) {
            q60Var.o(i, (zt) obj);
        } else {
            q60Var.x(i, 2);
            q60Var.w((String) obj);
        }
    }

    public static int v(int i, Object obj) {
        if (!(obj instanceof String)) {
            return q60.c(i, (zt) obj);
        }
        return q60.g((String) obj) + q60.h(i);
    }

    public static int w(Object obj) {
        if (obj instanceof String) {
            return q60.g((String) obj);
        }
        Logger logger = q60.d;
        int size = ((zt) obj).size();
        return q60.j(size) + size;
    }

    public static Method y(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e);
        }
    }

    public ye A(int i) {
        throw new IllegalArgumentException("No map fields found in ".concat(getClass().getName()));
    }

    @Override // defpackage.ql2
    public boolean b(ft0 ft0Var) {
        return z().b(ft0Var).g(this);
    }

    @Override // defpackage.ql2
    public final ws0 f() {
        return z().a;
    }

    @Override // defpackage.ql2
    public final cm4 i() {
        return this.z;
    }

    @Override // defpackage.ql2
    public Map l() {
        return DesugarCollections.unmodifiableMap(x());
    }

    @Override // defpackage.ql2
    public Object n(ft0 ft0Var) {
        return z().b(ft0Var).e(this);
    }

    public final TreeMap x() {
        TreeMap treeMap = new TreeMap();
        List listM = z().a.m();
        int i = 0;
        while (i < listM.size()) {
            ft0 ft0VarE = (ft0) listM.get(i);
            kt0 kt0Var = ft0VarE.C0;
            if (kt0Var != null) {
                i += kt0Var.Y - 1;
                if (z().c(kt0Var).g(this)) {
                    ft0VarE = z().c(kt0Var).e(this);
                    treeMap.put(ft0VarE, n(ft0VarE));
                }
            } else if (ft0VarE.y()) {
                List list = (List) n(ft0VarE);
                if (!list.isEmpty()) {
                    treeMap.put(ft0VarE, list);
                }
            } else if (b(ft0VarE)) {
                treeMap.put(ft0VarE, n(ft0VarE));
            }
            i++;
        }
        return treeMap;
    }

    public abstract vn1 z();

    public yn1() {
        this.z = cm4.f;
    }
}
