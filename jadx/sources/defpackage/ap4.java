package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ap4 {
    public final ie a;
    public final ie b;
    public final ie c;

    public ap4(ie ieVar, ie ieVar2, ie ieVar3) {
        this.a = ieVar;
        this.b = ieVar2;
        this.c = ieVar3;
    }

    public abstract bp4 a();

    public final Class b(Class cls) throws ClassNotFoundException {
        String name = cls.getName();
        ie ieVar = this.c;
        Class cls2 = (Class) ieVar.get(name);
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(cls.getPackage().getName() + "." + cls.getSimpleName() + "Parcelizer", false, cls.getClassLoader());
        ieVar.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method c(String str) throws NoSuchMethodException {
        ie ieVar = this.a;
        Method method = (Method) ieVar.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, ap4.class.getClassLoader()).getDeclaredMethod("read", ap4.class);
        ieVar.put(str, declaredMethod);
        return declaredMethod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Method d(Class cls) throws NoSuchMethodException, ClassNotFoundException {
        String name = cls.getName();
        ie ieVar = this.b;
        Method method = (Method) ieVar.get(name);
        if (method != null) {
            return method;
        }
        Class clsB = b(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsB.getDeclaredMethod("write", cls, ap4.class);
        ieVar.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public abstract boolean e(int i);

    public final Parcelable f(Parcelable parcelable, int i) {
        if (!e(i)) {
            return parcelable;
        }
        return ((bp4) this).e.readParcelable(bp4.class.getClassLoader());
    }

    public final cp4 g() {
        String string = ((bp4) this).e.readString();
        if (string == null) {
            return null;
        }
        try {
            return (cp4) c(string).invoke(null, a());
        } catch (ClassNotFoundException e) {
            zo2.o("VersionedParcel encountered ClassNotFoundException", e);
            return null;
        } catch (IllegalAccessException e2) {
            zo2.o("VersionedParcel encountered IllegalAccessException", e2);
            return null;
        } catch (NoSuchMethodException e3) {
            zo2.o("VersionedParcel encountered NoSuchMethodException", e3);
            return null;
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            zo2.o("VersionedParcel encountered InvocationTargetException", e4);
            return null;
        }
    }

    public abstract void h(int i);

    public final void i(cp4 cp4Var) {
        if (cp4Var == null) {
            ((bp4) this).e.writeString(null);
            return;
        }
        try {
            ((bp4) this).e.writeString(b(cp4Var.getClass()).getName());
            bp4 bp4VarA = a();
            try {
                d(cp4Var.getClass()).invoke(null, cp4Var, bp4VarA);
                Parcel parcel = bp4VarA.e;
                int i = bp4VarA.i;
                if (i >= 0) {
                    int i2 = bp4VarA.d.get(i);
                    int iDataPosition = parcel.dataPosition();
                    parcel.setDataPosition(i2);
                    parcel.writeInt(iDataPosition - i2);
                    parcel.setDataPosition(iDataPosition);
                }
            } catch (ClassNotFoundException e) {
                zo2.o("VersionedParcel encountered ClassNotFoundException", e);
            } catch (IllegalAccessException e2) {
                zo2.o("VersionedParcel encountered IllegalAccessException", e2);
            } catch (NoSuchMethodException e3) {
                zo2.o("VersionedParcel encountered NoSuchMethodException", e3);
            } catch (InvocationTargetException e4) {
                if (e4.getCause() instanceof RuntimeException) {
                    throw ((RuntimeException) e4.getCause());
                }
                zo2.o("VersionedParcel encountered InvocationTargetException", e4);
            }
        } catch (ClassNotFoundException e5) {
            zo2.o(cp4Var.getClass().getSimpleName().concat(" does not have a Parcelizer"), e5);
        }
    }
}
