package defpackage;

import java.io.Serializable;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public static void m(defpackage.gt3 r1, java.lang.Exception r2, java.lang.Object r3, int r4) throws java.io.IOException {
        /*
        L0:
            boolean r0 = r2 instanceof java.lang.reflect.InvocationTargetException
            if (r0 == 0) goto Lf
            java.lang.Throwable r0 = r2.getCause()
            if (r0 == 0) goto Lf
            java.lang.Throwable r2 = r2.getCause()
            goto L0
        Lf:
            java.lang.annotation.Annotation[] r0 = defpackage.n50.a
            boolean r0 = r2 instanceof java.lang.Error
            if (r0 != 0) goto L45
            if (r1 == 0) goto L24
            dt3 r0 = defpackage.dt3.WRAP_EXCEPTIONS
            bt3 r1 = r1.b
            boolean r1 = r1.h(r0)
            if (r1 == 0) goto L22
            goto L24
        L22:
            r1 = 0
            goto L25
        L24:
            r1 = 1
        L25:
            boolean r0 = r2 instanceof java.io.IOException
            if (r0 == 0) goto L32
            if (r1 == 0) goto L2f
            boolean r1 = r2 instanceof defpackage.l62
            if (r1 != 0) goto L37
        L2f:
            java.io.IOException r2 = (java.io.IOException) r2
            throw r2
        L32:
            if (r1 != 0) goto L37
            defpackage.n50.v(r2)
        L37:
            z52 r1 = new z52
            r1.<init>()
            r1.b = r3
            r1.z = r4
            a62 r1 = defpackage.a62.d(r2, r1)
            throw r1
        L45:
            java.lang.Error r2 = (java.lang.Error) r2
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l34.m(gt3, java.lang.Exception, java.lang.Object, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void n(defpackage.gt3 r1, java.lang.Exception r2, java.lang.Object r3, java.lang.String r4) throws java.io.IOException {
        /*
        L0:
            boolean r0 = r2 instanceof java.lang.reflect.InvocationTargetException
            if (r0 == 0) goto Lf
            java.lang.Throwable r0 = r2.getCause()
            if (r0 == 0) goto Lf
            java.lang.Throwable r2 = r2.getCause()
            goto L0
        Lf:
            java.lang.annotation.Annotation[] r0 = defpackage.n50.a
            boolean r0 = r2 instanceof java.lang.Error
            if (r0 != 0) goto L41
            if (r1 == 0) goto L24
            dt3 r0 = defpackage.dt3.WRAP_EXCEPTIONS
            bt3 r1 = r1.b
            boolean r1 = r1.h(r0)
            if (r1 == 0) goto L22
            goto L24
        L22:
            r1 = 0
            goto L25
        L24:
            r1 = 1
        L25:
            boolean r0 = r2 instanceof java.io.IOException
            if (r0 == 0) goto L32
            if (r1 == 0) goto L2f
            boolean r1 = r2 instanceof defpackage.l62
            if (r1 != 0) goto L37
        L2f:
            java.io.IOException r2 = (java.io.IOException) r2
            throw r2
        L32:
            if (r1 != 0) goto L37
            defpackage.n50.v(r2)
        L37:
            z52 r1 = new z52
            r1.<init>(r3, r4)
            a62 r1 = defpackage.a62.d(r2, r1)
            throw r1
        L41:
            java.lang.Error r2 = (java.lang.Error) r2
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l34.n(gt3, java.lang.Exception, java.lang.Object, java.lang.String):void");
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
