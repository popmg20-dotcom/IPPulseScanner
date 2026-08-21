package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class qd4 {
    public static final ThreadLocal a = new ThreadLocal();

    public static b61 a() {
        ThreadLocal threadLocal = a;
        b61 b61Var = (b61) threadLocal.get();
        if (b61Var != null) {
            return b61Var;
        }
        wn wnVar = new wn(Thread.currentThread());
        threadLocal.set(wnVar);
        return wnVar;
    }
}
