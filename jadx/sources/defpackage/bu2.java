package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import io.sentry.android.core.cache.a;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bu2 extends oz4 implements wv1 {
    public final Object d;

    public bu2(Object obj) {
        super("com.google.android.gms.dynamic.IObjectWrapper");
        this.d = obj;
    }

    public static wv1 F(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
        return iInterfaceQueryLocalInterface instanceof wv1 ? (wv1) iInterfaceQueryLocalInterface : new q25(iBinder, "com.google.android.gms.dynamic.IObjectWrapper", 1);
    }

    public static Object G(wv1 wv1Var) {
        if (wv1Var instanceof bu2) {
            return ((bu2) wv1Var).d;
        }
        IBinder iBinderAsBinder = wv1Var.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        Field field = null;
        int i = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i++;
                field = field2;
            }
        }
        if (i != 1) {
            int length = declaredFields.length;
            a.b(String.valueOf(length).length() + 53, length, "Unexpected number of IObjectWrapper declared fields: ");
            return null;
        }
        tj4.i(field);
        if (field.isAccessible()) {
            xe.k("IObjectWrapper declared field not private!");
            return null;
        }
        field.setAccessible(true);
        try {
            return field.get(iBinderAsBinder);
        } catch (IllegalAccessException e) {
            st4.l("Could not access the field in remoteBinder.", e);
            return null;
        } catch (NullPointerException e2) {
            st4.l("Binder object is null.", e2);
            return null;
        }
    }
}
