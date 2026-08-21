package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class dh3 {
    public static final eh3 a;

    static {
        eh3 eh3Var = null;
        try {
            eh3Var = (eh3) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (eh3Var == null) {
            eh3Var = new eh3();
        }
        a = eh3Var;
    }

    public static j50 a(Class cls) {
        a.getClass();
        return new j50(cls);
    }
}
