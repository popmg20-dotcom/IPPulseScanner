package defpackage;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cy4 {
    public final tt2 a;
    public Object b;
    public boolean c = false;

    public cy4(tt2 tt2Var) {
        this.a = tt2Var;
    }

    public final Object a(Object obj) {
        Object obj2 = this.b;
        if (obj2 != null) {
            return obj2;
        }
        pm pmVar = ((m83) this.a).f;
        try {
            Method method = pmVar.y0;
            Object objInvoke = method == null ? pmVar.z0.get(obj) : method.invoke(obj, null);
            this.b = objInvoke;
            return objInvoke;
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new IllegalStateException("Problem accessing property '" + pmVar.f.b + "': " + e2.getMessage(), e2);
        }
    }
}
