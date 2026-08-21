package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class xd4 {
    public static final ThreadLocal a = new ThreadLocal();

    public static Object a(Class cls, Class cls2, String str) throws ClassNotFoundException {
        wd4 wd4Var = new wd4(cls);
        while (wd4Var.hasNext()) {
            try {
                return cls2.cast(((ClassLoader) wd4Var.next()).loadClass(str).getDeclaredConstructor(null).newInstance(null));
            } catch (ClassNotFoundException unused) {
            }
        }
        throw new ClassNotFoundException(str);
    }
}
