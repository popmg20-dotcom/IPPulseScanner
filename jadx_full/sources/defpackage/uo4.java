package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class uo4 {
    public static final /* synthetic */ uo4[] A;
    public static final uo4 b;
    public static final uo4 f;
    public static final uo4 z;

    static {
        uo4 uo4Var = new uo4("STRICT", 0);
        b = uo4Var;
        uo4 uo4Var2 = new uo4("LOG", 1);
        f = uo4Var2;
        uo4 uo4Var3 = new uo4("QUIET", 2);
        z = uo4Var3;
        A = new uo4[]{uo4Var, uo4Var2, uo4Var3};
    }

    public static uo4 valueOf(String str) {
        return (uo4) Enum.valueOf(uo4.class, str);
    }

    public static uo4[] values() {
        return (uo4[]) A.clone();
    }
}
