package defpackage;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lq4 extends ck1 {
    public static lq4 d;
    public static final q84 e = new q84(3);
    public final Application c;

    public lq4(Application application) {
        super(3);
        this.c = application;
    }

    @Override // defpackage.ck1, defpackage.mq4
    public final iq4 a(Class cls) {
        Application application = this.c;
        if (application != null) {
            return d(cls, application);
        }
        vp1.n("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        return null;
    }

    @Override // defpackage.ck1, defpackage.mq4
    public final iq4 b(Class cls, in2 in2Var) {
        if (this.c != null) {
            return a(cls);
        }
        Application application = (Application) in2Var.a.get(e);
        if (application != null) {
            return d(cls, application);
        }
        if (!b8.class.isAssignableFrom(cls)) {
            return vo.j(cls);
        }
        xe.k("CreationExtras must have an application by `APPLICATION_KEY`");
        return null;
    }

    public final iq4 d(Class cls, Application application) {
        if (!b8.class.isAssignableFrom(cls)) {
            return vo.j(cls);
        }
        try {
            iq4 iq4Var = (iq4) cls.getConstructor(Application.class).newInstance(application);
            iq4Var.getClass();
            return iq4Var;
        } catch (IllegalAccessException e2) {
            zo2.o(dw2.B(cls, "Cannot create an instance of "), e2);
            return null;
        } catch (InstantiationException e3) {
            zo2.o(dw2.B(cls, "Cannot create an instance of "), e3);
            return null;
        } catch (NoSuchMethodException e4) {
            zo2.o(dw2.B(cls, "Cannot create an instance of "), e4);
            return null;
        } catch (InvocationTargetException e5) {
            zo2.o(dw2.B(cls, "Cannot create an instance of "), e5);
            return null;
        }
    }
}
