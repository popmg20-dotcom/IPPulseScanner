package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u42 {
    public static final u42 b;
    public static final u42 f;
    public static final /* synthetic */ u42[] z;

    static {
        u42 u42Var = new u42("DEFAULT", 0);
        b = u42Var;
        u42 u42Var2 = new u42("DELEGATING", 1);
        u42 u42Var3 = new u42("PROPERTIES", 2);
        u42 u42Var4 = new u42("DISABLED", 3);
        f = u42Var4;
        z = new u42[]{u42Var, u42Var2, u42Var3, u42Var4};
    }

    public static u42 valueOf(String str) {
        return (u42) Enum.valueOf(u42.class, str);
    }

    public static u42[] values() {
        return (u42[]) z.clone();
    }
}
