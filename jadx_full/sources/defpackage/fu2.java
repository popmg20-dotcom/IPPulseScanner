package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fu2 {
    public static final /* synthetic */ fu2[] A;
    public static final fu2 b;
    public static final fu2 f;
    public static final fu2 z;

    static {
        fu2 fu2Var = new fu2("NO_OP", 0);
        b = fu2Var;
        fu2 fu2Var2 = new fu2("ADD", 1);
        f = fu2Var2;
        fu2 fu2Var3 = new fu2("REMOVE", 2);
        z = fu2Var3;
        A = new fu2[]{fu2Var, fu2Var2, fu2Var3};
    }

    public static fu2 valueOf(String str) {
        return (fu2) Enum.valueOf(fu2.class, str);
    }

    public static fu2[] values() {
        return (fu2[]) A.clone();
    }
}
