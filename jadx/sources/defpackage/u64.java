package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u64 {
    public static final u64 b;
    public static final u64 f;
    public static final /* synthetic */ u64[] z;

    static {
        u64 u64Var = new u64("FEATURE_COMBINATION_TABLE", 0);
        b = u64Var;
        u64 u64Var2 = new u64("CAPTURE_SESSION_TABLES", 1);
        f = u64Var2;
        z = new u64[]{u64Var, u64Var2};
    }

    public static u64 valueOf(String str) {
        return (u64) Enum.valueOf(u64.class, str);
    }

    public static u64[] values() {
        return (u64[]) z.clone();
    }
}
