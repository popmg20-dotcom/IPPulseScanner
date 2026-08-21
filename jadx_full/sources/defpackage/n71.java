package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class n71 {
    public static final n71 b;
    public static final n71 f;
    public static final /* synthetic */ n71[] z;

    /* JADX INFO: Fake field, exist only in values array */
    n71 EF0;

    static {
        n71 n71Var = new n71("REPLACE", 0);
        n71 n71Var2 = new n71("KEEP", 1);
        b = n71Var2;
        n71 n71Var3 = new n71("UPDATE", 2);
        f = n71Var3;
        z = new n71[]{n71Var, n71Var2, n71Var3, new n71("CANCEL_AND_REENQUEUE", 3)};
    }

    public static n71 valueOf(String str) {
        return (n71) Enum.valueOf(n71.class, str);
    }

    public static n71[] values() {
        return (n71[]) z.clone();
    }
}
