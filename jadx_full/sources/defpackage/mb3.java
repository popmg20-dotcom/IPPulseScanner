package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mb3 {
    public static final /* synthetic */ mb3[] A;
    public static final /* synthetic */ j51 X;
    public static final mb3 b;
    public static final mb3 f;
    public static final mb3 z;

    static {
        mb3 mb3Var = new mb3("DEFAULT", 0);
        b = mb3Var;
        mb3 mb3Var2 = new mb3("DELAY", 1);
        f = mb3Var2;
        mb3 mb3Var3 = new mb3("NAME", 2);
        z = mb3Var3;
        mb3[] mb3VarArr = {mb3Var, mb3Var2, mb3Var3};
        A = mb3VarArr;
        X = new j51(mb3VarArr);
    }

    public static mb3 valueOf(String str) {
        return (mb3) Enum.valueOf(mb3.class, str);
    }

    public static mb3[] values() {
        return (mb3[]) A.clone();
    }
}
