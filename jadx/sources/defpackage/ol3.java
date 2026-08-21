package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ol3 {
    public static final ol3 b;
    public static final ol3 f;
    public static final /* synthetic */ ol3[] z;

    /* JADX INFO: Fake field, exist only in values array */
    ol3 EF0;

    static {
        ol3 ol3Var = new ol3("AUTOMATIC", 0);
        ol3 ol3Var2 = new ol3("TRUNCATE", 1);
        b = ol3Var2;
        ol3 ol3Var3 = new ol3("WRITE_AHEAD_LOGGING", 2);
        f = ol3Var3;
        z = new ol3[]{ol3Var, ol3Var2, ol3Var3};
    }

    public static ol3 valueOf(String str) {
        return (ol3) Enum.valueOf(ol3.class, str);
    }

    public static ol3[] values() {
        return (ol3[]) z.clone();
    }
}
