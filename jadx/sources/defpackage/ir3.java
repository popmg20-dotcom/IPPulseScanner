package defpackage;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;
import java.security.Provider;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ir3 implements jr3 {
    public final /* synthetic */ int a = 0;
    public final String b;
    public final /* synthetic */ Class c;
    public final /* synthetic */ Method d;
    public final /* synthetic */ Serializable e;

    public ir3(Class cls, Provider provider, Method method) {
        this.c = cls;
        this.e = provider;
        this.d = method;
        this.b = jr3.class.getSimpleName() + "[" + cls.getSimpleName() + "][Provider][" + provider.getName() + "]";
    }

    @Override // defpackage.jr3
    public final Object a(String str) throws GeneralSecurityException {
        int i = this.a;
        Class cls = this.c;
        Serializable serializable = this.e;
        Method method = this.d;
        switch (i) {
            case 0:
                try {
                    return cls.cast(method.invoke(null, str, (String) serializable));
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
            default:
                try {
                    return cls.cast(method.invoke(null, str, (Provider) serializable));
                } catch (ReflectiveOperationException e2) {
                    Throwable thA2 = n61.a(e2);
                    if (thA2 instanceof GeneralSecurityException) {
                        throw ((GeneralSecurityException) thA2);
                    }
                    if (thA2 instanceof RuntimeException) {
                        throw ((RuntimeException) thA2);
                    }
                    if (thA2 instanceof Error) {
                        throw ((Error) thA2);
                    }
                    throw new GeneralSecurityException(thA2);
                }
        }
    }

    public final String toString() {
        int i = this.a;
        return this.b;
    }

    public ir3(Class cls, String str, Method method) {
        this.c = cls;
        this.e = str;
        this.d = method;
        this.b = jr3.class.getSimpleName() + "[" + cls.getSimpleName() + "][" + str + "]";
    }
}
