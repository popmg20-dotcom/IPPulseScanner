package defpackage;

import java.lang.reflect.Method;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class hr3 implements jr3 {
    public final String a;
    public final /* synthetic */ Class b;
    public final /* synthetic */ Method c;

    public hr3(Class cls, Method method) {
        this.b = cls;
        this.c = method;
        this.a = jr3.class.getSimpleName() + "[" + cls.getSimpleName() + "][default]";
    }

    @Override // defpackage.jr3
    public final Object a(String str) throws GeneralSecurityException {
        try {
            return this.b.cast(this.c.invoke(null, str));
        } catch (ReflectiveOperationException e) {
            Throwable thA = n61.a(e);
            if (thA instanceof GeneralSecurityException) {
                throw ((GeneralSecurityException) thA);
            }
            if (thA instanceof RuntimeException) {
                throw ((RuntimeException) thA);
            }
            if (thA instanceof Error) {
                throw ((Error) thA);
            }
            throw new GeneralSecurityException(thA);
        }
    }

    public final String toString() {
        return this.a;
    }
}
