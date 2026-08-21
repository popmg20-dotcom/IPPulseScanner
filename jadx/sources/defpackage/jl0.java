package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class jl0 {
    public static final on0 a;

    static {
        String property;
        on0 on0Var;
        int i = p94.a;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null ? Boolean.parseBoolean(property) : false) {
            gm0 gm0Var = qv0.a;
            tq1 tq1Var = qf2.a;
            tq1 tq1Var2 = tq1Var.X;
            on0Var = tq1Var;
            if (tq1Var == null) {
                on0Var = il0.B0;
            }
        } else {
            on0Var = il0.B0;
        }
        a = on0Var;
    }
}
