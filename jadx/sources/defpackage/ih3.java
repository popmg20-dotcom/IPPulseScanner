package defpackage;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ih3 {
    public final String a;
    public final Field b;
    public final String c;
    public final /* synthetic */ Method d;
    public final /* synthetic */ hi4 e;
    public final /* synthetic */ hi4 f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ boolean h;

    public ih3(String str, Field field, Method method, hi4 hi4Var, hi4 hi4Var2, boolean z, boolean z2) {
        this.d = method;
        this.e = hi4Var;
        this.f = hi4Var2;
        this.g = z;
        this.h = z2;
        this.a = str;
        this.b = field;
        this.c = field.getName();
    }

    public final void a(v72 v72Var, Object obj) throws IllegalAccessException {
        Object objInvoke;
        Method method = this.d;
        if (method != null) {
            try {
                objInvoke = method.invoke(obj, null);
            } catch (InvocationTargetException e) {
                throw new l52(ha0.o("Accessor ", hh3.d(method, false), " threw exception"), e.getCause());
            }
        } else {
            objInvoke = this.b.get(obj);
        }
        if (objInvoke == obj) {
            return;
        }
        v72Var.s(this.a);
        this.e.c(v72Var, objInvoke);
    }
}
