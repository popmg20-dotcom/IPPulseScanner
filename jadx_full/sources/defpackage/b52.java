package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b52 {
    public static final b52 b;
    public static final b52 f;
    public static final /* synthetic */ b52[] z;

    /* JADX INFO: Fake field, exist only in values array */
    b52 EF0;

    static {
        b52 b52Var = new b52("ACCEPT_SINGLE_VALUE_AS_ARRAY", 0);
        b52 b52Var2 = new b52("ACCEPT_CASE_INSENSITIVE_PROPERTIES", 1);
        b52 b52Var3 = new b52("READ_UNKNOWN_ENUM_VALUES_AS_NULL", 2);
        b52 b52Var4 = new b52("READ_UNKNOWN_ENUM_VALUES_USING_DEFAULT_VALUE", 3);
        b52 b52Var5 = new b52("READ_DATE_TIMESTAMPS_AS_NANOSECONDS", 4);
        b52 b52Var6 = new b52("ACCEPT_CASE_INSENSITIVE_VALUES", 5);
        b52 b52Var7 = new b52("WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS", 6);
        b52 b52Var8 = new b52("WRITE_DATES_WITH_ZONE_ID", 7);
        b52 b52Var9 = new b52("WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED", 8);
        b = b52Var9;
        b52 b52Var10 = new b52("WRITE_SORTED_MAP_ENTRIES", 9);
        f = b52Var10;
        z = new b52[]{b52Var, b52Var2, b52Var3, b52Var4, b52Var5, b52Var6, b52Var7, b52Var8, b52Var9, b52Var10, new b52("ADJUST_DATES_TO_CONTEXT_TIME_ZONE", 10)};
    }

    public static b52 valueOf(String str) {
        return (b52) Enum.valueOf(b52.class, str);
    }

    public static b52[] values() {
        return (b52[]) z.clone();
    }
}
