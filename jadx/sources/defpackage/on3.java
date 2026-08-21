package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class on3 {
    public static final /* synthetic */ on3[] A;
    public static final on3 b;
    public static final on3 f;
    public static final on3 z;

    static {
        on3 on3Var = new on3("WIFI", 0);
        b = on3Var;
        on3 on3Var2 = new on3("WIRED", 1);
        f = on3Var2;
        on3 on3Var3 = new on3("CELLULAR", 2);
        z = on3Var3;
        A = new on3[]{on3Var, on3Var2, on3Var3};
    }

    public static on3 valueOf(String str) {
        return (on3) Enum.valueOf(on3.class, str);
    }

    public static on3[] values() {
        return (on3[]) A.clone();
    }
}
