package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z93 {
    public static final z93 b;
    public static final z93 f;
    public static final /* synthetic */ z93[] z;

    static {
        z93 z93Var = new z93("DEBUG_FORMAT", 0);
        b = z93Var;
        z93 z93Var2 = new z93("TEXT_FORMAT", 1);
        z93 z93Var3 = new z93("DEFAULT_FORMAT", 2);
        f = z93Var3;
        z = new z93[]{z93Var, z93Var2, z93Var3};
    }

    public static z93 valueOf(String str) {
        return (z93) Enum.valueOf(z93.class, str);
    }

    public static z93[] values() {
        return (z93[]) z.clone();
    }
}
