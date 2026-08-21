package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i24 {
    public static final /* synthetic */ i24[] A;
    public static final i24 b;
    public static final i24 f;
    public static final i24 z;

    static {
        i24 i24Var = new i24("LOADING", 0);
        b = i24Var;
        i24 i24Var2 = new i24("SUCCESS", 1);
        f = i24Var2;
        i24 i24Var3 = new i24("FAILED", 2);
        z = i24Var3;
        A = new i24[]{i24Var, i24Var2, i24Var3};
    }

    public static i24 valueOf(String str) {
        return (i24) Enum.valueOf(i24.class, str);
    }

    public static i24[] values() {
        return (i24[]) A.clone();
    }
}
