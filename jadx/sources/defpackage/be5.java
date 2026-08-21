package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class be5 {
    public static final be5 b;
    public static final be5 f;
    public static final /* synthetic */ be5[] z;

    static {
        be5 be5Var = new be5("CONSENT", 0);
        b = be5Var;
        be5 be5Var2 = new be5("LEGITIMATE_INTEREST", 1);
        be5 be5Var3 = new be5("FLEXIBLE_CONSENT", 2);
        be5 be5Var4 = new be5("FLEXIBLE_LEGITIMATE_INTEREST", 3);
        f = be5Var4;
        z = new be5[]{be5Var, be5Var2, be5Var3, be5Var4};
    }

    public static be5[] values() {
        return (be5[]) z.clone();
    }
}
