package defpackage;

import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class sj4 {
    public final rj4 b;
    public final nj4 f;

    public sj4(nj4 nj4Var, rj4 rj4Var) {
        this.f = nj4Var;
        this.b = rj4Var;
    }

    public static Class a(Class cls) {
        Annotation[] annotationArr = n50.a;
        return (!Enum.class.isAssignableFrom(cls) || cls.isEnum()) ? cls : cls.getSuperclass();
    }

    public abstract String b(Object obj);

    public abstract String c(Object obj, Class cls);

    public sj4() {
        this(null, null);
    }
}
