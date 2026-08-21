package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dn1 {
    public static final /* synthetic */ dn1[] A;
    public static final dn1 b;
    public static final dn1 f;
    public static final dn1 z;

    static {
        dn1 dn1Var = new dn1("UNKNOWN", 0);
        b = dn1Var;
        dn1 dn1Var2 = new dn1("DEFAULT", 1);
        f = dn1Var2;
        dn1 dn1Var3 = new dn1("YUV", 2);
        z = dn1Var3;
        A = new dn1[]{dn1Var, dn1Var2, dn1Var3};
    }

    public static dn1 valueOf(String str) {
        return (dn1) Enum.valueOf(dn1.class, str);
    }

    public static dn1[] values() {
        return (dn1[]) A.clone();
    }
}
