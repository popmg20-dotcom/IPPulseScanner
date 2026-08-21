package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j72 {
    public static final j72 A;
    public static final j72 X;
    public static final /* synthetic */ j72[] Y;
    public static final j72 b;
    public static final j72 f;
    public static final j72 z;

    static {
        j72 j72Var = new j72("PROPERTY", 0);
        b = j72Var;
        j72 j72Var2 = new j72("WRAPPER_OBJECT", 1);
        f = j72Var2;
        j72 j72Var3 = new j72("WRAPPER_ARRAY", 2);
        z = j72Var3;
        j72 j72Var4 = new j72("EXTERNAL_PROPERTY", 3);
        A = j72Var4;
        j72 j72Var5 = new j72("EXISTING_PROPERTY", 4);
        X = j72Var5;
        Y = new j72[]{j72Var, j72Var2, j72Var3, j72Var4, j72Var5};
    }

    public static j72 valueOf(String str) {
        return (j72) Enum.valueOf(j72.class, str);
    }

    public static j72[] values() {
        return (j72[]) Y.clone();
    }
}
