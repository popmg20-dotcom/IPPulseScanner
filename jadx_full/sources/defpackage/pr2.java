package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pr2 {
    public static final pr2 A;
    public static final pr2 X;
    public static final pr2 Y;
    public static final /* synthetic */ pr2[] Z;
    public static final pr2 b;
    public static final pr2 f;
    public static final pr2 z;

    static {
        pr2 pr2Var = new pr2("NOT_REQUIRED", 0);
        b = pr2Var;
        pr2 pr2Var2 = new pr2("CONNECTED", 1);
        f = pr2Var2;
        pr2 pr2Var3 = new pr2("UNMETERED", 2);
        z = pr2Var3;
        pr2 pr2Var4 = new pr2("NOT_ROAMING", 3);
        A = pr2Var4;
        pr2 pr2Var5 = new pr2("METERED", 4);
        X = pr2Var5;
        pr2 pr2Var6 = new pr2("TEMPORARILY_UNMETERED", 5);
        Y = pr2Var6;
        Z = new pr2[]{pr2Var, pr2Var2, pr2Var3, pr2Var4, pr2Var5, pr2Var6};
    }

    public static pr2 valueOf(String str) {
        return (pr2) Enum.valueOf(pr2.class, str);
    }

    public static pr2[] values() {
        return (pr2[]) Z.clone();
    }
}
