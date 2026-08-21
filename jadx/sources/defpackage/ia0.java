package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ia0 {
    public static final ia0 A;
    public static final /* synthetic */ ia0[] X;
    public static final ia0 b;
    public static final ia0 f;
    public static final ia0 z;

    static {
        ia0 ia0Var = new ia0("ALWAYS_OVERRIDE", 0);
        b = ia0Var;
        ia0 ia0Var2 = new ia0("HIGH_PRIORITY_REQUIRED", 1);
        f = ia0Var2;
        ia0 ia0Var3 = new ia0("REQUIRED", 2);
        z = ia0Var3;
        ia0 ia0Var4 = new ia0("OPTIONAL", 3);
        A = ia0Var4;
        X = new ia0[]{ia0Var, ia0Var2, ia0Var3, ia0Var4};
    }

    public static ia0 valueOf(String str) {
        return (ia0) Enum.valueOf(ia0.class, str);
    }

    public static ia0[] values() {
        return (ia0[]) X.clone();
    }
}
