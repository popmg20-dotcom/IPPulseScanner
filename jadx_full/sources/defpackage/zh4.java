package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class zh4 {
    public static final zh4 A;
    public static final /* synthetic */ zh4[] X;
    public static final zh4 b;
    public static final zh4 f;
    public static final zh4 z;

    static {
        zh4 zh4Var = new zh4("SUCCESSFUL", 0);
        b = zh4Var;
        zh4 zh4Var2 = new zh4("REREGISTER", 1);
        f = zh4Var2;
        zh4 zh4Var3 = new zh4("CANCELLED", 2);
        z = zh4Var3;
        zh4 zh4Var4 = new zh4("ALREADY_SELECTED", 3);
        A = zh4Var4;
        X = new zh4[]{zh4Var, zh4Var2, zh4Var3, zh4Var4};
    }

    public static zh4 valueOf(String str) {
        return (zh4) Enum.valueOf(zh4.class, str);
    }

    public static zh4[] values() {
        return (zh4[]) X.clone();
    }
}
