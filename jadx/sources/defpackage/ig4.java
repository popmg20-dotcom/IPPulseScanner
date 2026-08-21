package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ig4 {
    public static final ig4 b;
    public static final ig4 f;
    public static final /* synthetic */ ig4[] z;

    static {
        ig4 ig4Var = new ig4("DEFERRED", 0);
        b = ig4Var;
        ig4 ig4Var2 = new ig4("IMMEDIATE", 1);
        f = ig4Var2;
        z = new ig4[]{ig4Var, ig4Var2, new ig4("EXCLUSIVE", 2)};
    }

    public static ig4 valueOf(String str) {
        return (ig4) Enum.valueOf(ig4.class, str);
    }

    public static ig4[] values() {
        return (ig4[]) z.clone();
    }
}
