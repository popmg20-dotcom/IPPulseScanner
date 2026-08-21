package j$.util.stream;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class x6 {
    public static final x6 DOUBLE_VALUE;
    public static final x6 INT_VALUE;
    public static final x6 LONG_VALUE;
    public static final x6 REFERENCE;
    public static final /* synthetic */ x6[] a;

    static {
        x6 x6Var = new x6("REFERENCE", 0);
        REFERENCE = x6Var;
        x6 x6Var2 = new x6("INT_VALUE", 1);
        INT_VALUE = x6Var2;
        x6 x6Var3 = new x6("LONG_VALUE", 2);
        LONG_VALUE = x6Var3;
        x6 x6Var4 = new x6("DOUBLE_VALUE", 3);
        DOUBLE_VALUE = x6Var4;
        a = new x6[]{x6Var, x6Var2, x6Var3, x6Var4};
    }

    public static x6 valueOf(String str) {
        return (x6) Enum.valueOf(x6.class, str);
    }

    public static x6[] values() {
        return (x6[]) a.clone();
    }
}
