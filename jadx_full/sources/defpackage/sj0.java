package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class sj0 {
    public static final tj0 a;

    static {
        for (k51 k51Var : k51.values()) {
            k51Var.getClass();
        }
        int i = 0;
        for (e62 e62Var : e62.values()) {
            if (e62Var.b) {
                i |= e62Var.f;
            }
        }
        a = new tj0(0, i);
    }
}
