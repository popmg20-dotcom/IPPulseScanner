package defpackage;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class l50 {
    public final Constructor a;
    public transient Annotation[] b;
    public transient Annotation[][] c;
    public int d = -1;

    public l50(Constructor constructor) {
        this.a = constructor;
    }

    public final int a() {
        int i = this.d;
        if (i >= 0) {
            return i;
        }
        int parameterCount = this.a.getParameterCount();
        this.d = parameterCount;
        return parameterCount;
    }
}
