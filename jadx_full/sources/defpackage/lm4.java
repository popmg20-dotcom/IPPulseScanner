package defpackage;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lm4 extends pm4 {
    public final /* synthetic */ Method b;
    public final /* synthetic */ Object c;

    public lm4(Method method, Object obj) {
        this.b = method;
        this.c = obj;
    }

    @Override // defpackage.pm4
    public final Object a(Class cls) {
        String strP = lb.p(cls);
        if (strP == null) {
            return this.b.invoke(this.c, cls);
        }
        xe.i("UnsafeAllocator is used for non-instantiable type: ".concat(strP));
        return null;
    }
}
