package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class yo2 {
    public static final boolean a;

    static {
        a = System.getProperty("org.graalvm.nativeimage.imagecode") != null;
    }

    public static boolean a(Class cls) {
        return a && "runtime".equals(System.getProperty("org.graalvm.nativeimage.imagecode")) && (cls.getDeclaredFields().length == 0 || n50.s(cls)) && cls.getDeclaredMethods().length == 0 && cls.getDeclaredConstructors().length == 0;
    }
}
