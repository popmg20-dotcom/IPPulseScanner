package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ni3 {
    public static final ni3 b;
    public static final /* synthetic */ ni3[] f;

    static {
        ni3 ni3Var = new ni3("LAUNCH_INITIAL_REFRESH", 0);
        b = ni3Var;
        f = new ni3[]{ni3Var, new ni3("SKIP_INITIAL_REFRESH", 1)};
    }

    public static ni3 valueOf(String str) {
        return (ni3) Enum.valueOf(ni3.class, str);
    }

    public static ni3[] values() {
        return (ni3[]) f.clone();
    }
}
