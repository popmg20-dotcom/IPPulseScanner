package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class of0 {
    public static final of0 A;
    public static final /* synthetic */ of0[] X;
    public static final of0 b;
    public static final of0 f;
    public static final of0 z;

    static {
        of0 of0Var = new of0("DEFAULT", 0);
        b = of0Var;
        of0 of0Var2 = new of0("LAZY", 1);
        f = of0Var2;
        of0 of0Var3 = new of0("ATOMIC", 2);
        z = of0Var3;
        of0 of0Var4 = new of0("UNDISPATCHED", 3);
        A = of0Var4;
        X = new of0[]{of0Var, of0Var2, of0Var3, of0Var4};
    }

    public static of0 valueOf(String str) {
        return (of0) Enum.valueOf(of0.class, str);
    }

    public static of0[] values() {
        return (of0[]) X.clone();
    }
}
