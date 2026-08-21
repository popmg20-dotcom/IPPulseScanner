package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s52 {
    public static final s52 A;
    public static final s52 X;
    public static final /* synthetic */ s52[] Y;
    public static final s52 b;
    public static final s52 f;
    public static final s52 z;

    static {
        s52 s52Var = new s52("ALWAYS", 0);
        b = s52Var;
        s52 s52Var2 = new s52("NON_NULL", 1);
        f = s52Var2;
        s52 s52Var3 = new s52("NON_ABSENT", 2);
        s52 s52Var4 = new s52("NON_EMPTY", 3);
        z = s52Var4;
        s52 s52Var5 = new s52("NON_DEFAULT", 4);
        A = s52Var5;
        s52 s52Var6 = new s52("CUSTOM", 5);
        s52 s52Var7 = new s52("USE_DEFAULTS", 6);
        X = s52Var7;
        Y = new s52[]{s52Var, s52Var2, s52Var3, s52Var4, s52Var5, s52Var6, s52Var7};
    }

    public static s52 valueOf(String str) {
        return (s52) Enum.valueOf(s52.class, str);
    }

    public static s52[] values() {
        return (s52[]) Y.clone();
    }
}
