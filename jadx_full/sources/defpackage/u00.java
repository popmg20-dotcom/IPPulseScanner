package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class u00 {
    public static final u00 b;
    public static final u00 f;
    public static final /* synthetic */ u00[] z;

    static {
        u00 u00Var = new u00("CANCEL_ON_TIMEOUT", 0);
        b = u00Var;
        u00 u00Var2 = new u00("CANCEL_ON_INTERRUPT", 1);
        f = u00Var2;
        z = new u00[]{u00Var, u00Var2, new u00("NO_CANCELLATION", 2)};
    }

    public static u00 valueOf(String str) {
        return (u00) Enum.valueOf(u00.class, str);
    }

    public static u00[] values() {
        return (u00[]) z.clone();
    }
}
