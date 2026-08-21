package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ep4 {
    public static final ep4 b;
    public static final ep4 f;
    public static final /* synthetic */ ep4[] z;

    static {
        ep4 ep4Var = new ep4("OFF", 0);
        b = ep4Var;
        ep4 ep4Var2 = new ep4("ON", 1);
        ep4 ep4Var3 = new ep4("PREVIEW", 2);
        f = ep4Var3;
        z = new ep4[]{ep4Var, ep4Var2, ep4Var3};
    }

    public static ep4 valueOf(String str) {
        return (ep4) Enum.valueOf(ep4.class, str);
    }

    public static ep4[] values() {
        return (ep4[]) z.clone();
    }
}
