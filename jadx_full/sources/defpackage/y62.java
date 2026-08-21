package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class y62 {
    public static final /* synthetic */ y62[] A;
    public static final y62 b;
    public static final y62 f;
    public static final y62 z;

    static {
        y62 y62Var = new y62("DYNAMIC", 0);
        b = y62Var;
        y62 y62Var2 = new y62("STATIC", 1);
        f = y62Var2;
        y62 y62Var3 = new y62("DEFAULT_TYPING", 2);
        z = y62Var3;
        A = new y62[]{y62Var, y62Var2, y62Var3};
    }

    public static y62 valueOf(String str) {
        return (y62) Enum.valueOf(y62.class, str);
    }

    public static y62[] values() {
        return (y62[]) A.clone();
    }
}
