package defpackage;

import com.google.firebase.components.ComponentRegistrar;
import io.sentry.android.core.a1;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m90 implements da3 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ m90(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.da3
    public final Object get() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                String str = (String) obj;
                try {
                    Class<?> cls = Class.forName(str);
                    if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                        return (ComponentRegistrar) cls.getDeclaredConstructor(null).newInstance(null);
                    }
                    throw new u12("Class " + str + " is not an instance of com.google.firebase.components.ComponentRegistrar");
                } catch (ClassNotFoundException unused) {
                    a1.n("ComponentDiscovery", "Class " + str + " is not an found.");
                    return null;
                } catch (IllegalAccessException e) {
                    throw new u12(ha0.o("Could not instantiate ", str, "."), e);
                } catch (InstantiationException e2) {
                    throw new u12(ha0.o("Could not instantiate ", str, "."), e2);
                } catch (NoSuchMethodException e3) {
                    throw new u12(ha0.n("Could not instantiate ", str), e3);
                } catch (InvocationTargetException e4) {
                    throw new u12(ha0.n("Could not instantiate ", str), e4);
                }
            case 1:
                return (ComponentRegistrar) obj;
            default:
                return new fx1((ze1) obj);
        }
    }
}
