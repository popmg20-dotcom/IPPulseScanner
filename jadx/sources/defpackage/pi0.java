package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pi0 {
    public static final pi0 A;
    public static final /* synthetic */ pi0[] X;
    public static final pi0 b;
    public static final pi0 f;
    public static final pi0 z;

    static {
        pi0 pi0Var = new pi0("MEMORY_CACHE", 0);
        b = pi0Var;
        pi0 pi0Var2 = new pi0("MEMORY", 1);
        f = pi0Var2;
        pi0 pi0Var3 = new pi0("DISK", 2);
        z = pi0Var3;
        pi0 pi0Var4 = new pi0("NETWORK", 3);
        A = pi0Var4;
        X = new pi0[]{pi0Var, pi0Var2, pi0Var3, pi0Var4};
    }

    public static pi0 valueOf(String str) {
        return (pi0) Enum.valueOf(pi0.class, str);
    }

    public static pi0[] values() {
        return (pi0[]) X.clone();
    }
}
