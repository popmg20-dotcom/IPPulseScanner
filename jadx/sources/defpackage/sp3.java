package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sp3 {
    public static final sp3 b;
    public static final sp3 f;
    public static final /* synthetic */ sp3[] z;

    static {
        sp3 sp3Var = new sp3("FILL", 0);
        b = sp3Var;
        sp3 sp3Var2 = new sp3("FIT", 1);
        f = sp3Var2;
        z = new sp3[]{sp3Var, sp3Var2};
    }

    public static sp3 valueOf(String str) {
        return (sp3) Enum.valueOf(sp3.class, str);
    }

    public static sp3[] values() {
        return (sp3[]) z.clone();
    }
}
