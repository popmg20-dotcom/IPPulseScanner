package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hd2 {
    public static final /* synthetic */ hd2[] A;
    public static final hd2 b;
    public static final hd2 f;
    public static final hd2 z;

    static {
        hd2 hd2Var = new hd2("REFRESH", 0);
        b = hd2Var;
        hd2 hd2Var2 = new hd2("PREPEND", 1);
        f = hd2Var2;
        hd2 hd2Var3 = new hd2("APPEND", 2);
        z = hd2Var3;
        A = new hd2[]{hd2Var, hd2Var2, hd2Var3};
    }

    public static hd2 valueOf(String str) {
        return (hd2) Enum.valueOf(hd2.class, str);
    }

    public static hd2[] values() {
        return (hd2[]) A.clone();
    }
}
