package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class x62 {
    public static final x62 b;
    public static final /* synthetic */ x62[] f;

    /* JADX INFO: Fake field, exist only in values array */
    x62 EF0;

    static {
        x62 x62Var = new x62("ALWAYS", 0);
        x62 x62Var2 = new x62("NON_NULL", 1);
        x62 x62Var3 = new x62("NON_DEFAULT", 2);
        x62 x62Var4 = new x62("NON_EMPTY", 3);
        x62 x62Var5 = new x62("DEFAULT_INCLUSION", 4);
        b = x62Var5;
        f = new x62[]{x62Var, x62Var2, x62Var3, x62Var4, x62Var5};
    }

    public static x62 valueOf(String str) {
        return (x62) Enum.valueOf(x62.class, str);
    }

    public static x62[] values() {
        return (x62[]) f.clone();
    }
}
