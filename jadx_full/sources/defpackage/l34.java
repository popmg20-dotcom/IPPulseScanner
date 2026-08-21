package defpackage;

import java.io.IOException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class l34 extends b72 implements Serializable {
    public static final Object f = new Object();
    public final Class b;

    public l34(l34 l34Var) {
        this.b = l34Var.b;
    }

    public static b72 j(gt3 gt3Var, nm nmVar, b72 b72Var) {
        c9 c9VarA;
        Object objD;
        Object obj = f;
        Map identityHashMap = (Map) gt3Var.r(obj);
        if (identityHashMap == null) {
            identityHashMap = new IdentityHashMap();
            zd0 zd0Var = (zd0) gt3Var.A;
            zd0 zd0Var2 = zd0.C0;
            zd0Var.getClass();
            Map map = Collections.EMPTY_MAP;
            HashMap map2 = zd0Var.B0;
            if (map2 == null) {
                HashMap map3 = new HashMap();
                map3.put(obj, identityHashMap);
                zd0Var = new zd0(map3);
            } else {
                map2.put(obj, identityHashMap);
            }
            gt3Var.A = zd0Var;
        } else if (identityHashMap.get(nmVar) != null) {
            return b72Var;
        }
        identityHashMap.put(nmVar, Boolean.TRUE);
        try {
            cu2 cu2VarD = gt3Var.b.d();
            if ((nmVar != null) && (c9VarA = nmVar.a()) != null && (objD = cu2VarD.D(c9VarA)) != null) {
                nmVar.a();
                gt3Var.f(objD);
                gt3Var.s();
                throw null;
            }
            return b72Var != null ? gt3Var.v(b72Var, nmVar) : b72Var;
        } finally {
            identityHashMap.remove(nmVar);
        }
    }

    public static e52 k(gt3 gt3Var, nm nmVar, Class cls) {
        if (nmVar != null) {
            return nmVar.b(gt3Var.b, cls);
        }
        gt3Var.b.getClass();
        return e52.y0;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m(gt3 gt3Var, Exception exc, Object obj, int i) throws IOException {
        boolean z;
        Throwable cause = exc;
        while ((cause instanceof InvocationTargetException) && cause.getCause() != null) {
            cause = cause.getCause();
        }
        Annotation[] annotationArr = n50.a;
        if (cause instanceof Error) {
            throw ((Error) cause);
        }
        if (gt3Var != null) {
            z = gt3Var.b.h(dt3.WRAP_EXCEPTIONS);
        }
        if (cause instanceof IOException) {
            if (!z || !(cause instanceof l62)) {
                throw ((IOException) cause);
            }
        } else if (!z) {
            n50.v(cause);
        }
        z52 z52Var = new z52();
        z52Var.b = obj;
        z52Var.z = i;
        throw a62.d(cause, z52Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void n(gt3 gt3Var, Exception exc, Object obj, String str) throws IOException {
        boolean z;
        Throwable cause = exc;
        while ((cause instanceof InvocationTargetException) && cause.getCause() != null) {
            cause = cause.getCause();
        }
        Annotation[] annotationArr = n50.a;
        if (cause instanceof Error) {
            throw ((Error) cause);
        }
        if (gt3Var != null) {
            z = gt3Var.b.h(dt3.WRAP_EXCEPTIONS);
        }
        if (cause instanceof IOException) {
            if (!z || !(cause instanceof l62)) {
                throw ((IOException) cause);
            }
        } else if (!z) {
            n50.v(cause);
        }
        throw a62.d(cause, new z52(obj, str));
    }

    @Override // defpackage.b72
    public final Class b() {
        return this.b;
    }

    public final void l(gt3 gt3Var, Object obj) {
        gt3Var.b.getClass();
        gt3Var.z(this.b, "Cannot resolve PropertyFilter with id '" + obj + "'; no FilterProvider configured");
        throw null;
    }

    public l34(nj4 nj4Var) {
        this.b = nj4Var.L0;
    }

    public l34(Class cls) {
        this.b = cls;
    }

    public l34(Class cls, int i) {
        this.b = cls;
    }
}
