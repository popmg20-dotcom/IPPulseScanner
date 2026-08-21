package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cg4 {
    public static final cg4 b;
    public static final cg4 f;
    public static final /* synthetic */ cg4[] z;

    static {
        cg4 cg4Var = new cg4("SPEED", 0);
        b = cg4Var;
        cg4 cg4Var2 = new cg4("TRAFFIC", 1);
        f = cg4Var2;
        z = new cg4[]{cg4Var, cg4Var2};
    }

    public static cg4 valueOf(String str) {
        return (cg4) Enum.valueOf(cg4.class, str);
    }

    public static cg4[] values() {
        return (cg4[]) z.clone();
    }
}
