package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xv1 {
    public static final xv1 A;
    public static final /* synthetic */ xv1[] X;
    public static final wl3 b;
    public static final xv1 f;
    public static final xv1 z;

    static {
        xv1 xv1Var = new xv1("FOLLOW_PROFILE", 0);
        f = xv1Var;
        xv1 xv1Var2 = new xv1("ENABLE", 1);
        z = xv1Var2;
        xv1 xv1Var3 = new xv1("DISABLE", 2);
        A = xv1Var3;
        X = new xv1[]{xv1Var, xv1Var2, xv1Var3};
        b = new wl3(20);
    }

    public static xv1 valueOf(String str) {
        return (xv1) Enum.valueOf(xv1.class, str);
    }

    public static xv1[] values() {
        return (xv1[]) X.clone();
    }
}
