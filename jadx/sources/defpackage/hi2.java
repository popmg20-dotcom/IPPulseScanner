package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hi2 {
    public static final hi2 b;
    public static final /* synthetic */ hi2[] f;

    /* JADX INFO: Fake field, exist only in values array */
    hi2 EF0;

    static {
        hi2 hi2Var = new hi2("NONE", 0);
        hi2 hi2Var2 = new hi2("START", 1);
        hi2 hi2Var3 = new hi2("END", 2);
        hi2 hi2Var4 = new hi2("BOTH", 3);
        b = hi2Var4;
        f = new hi2[]{hi2Var, hi2Var2, hi2Var3, hi2Var4};
    }

    public static hi2 valueOf(String str) {
        return (hi2) Enum.valueOf(hi2.class, str);
    }

    public static hi2[] values() {
        return (hi2[]) f.clone();
    }
}
