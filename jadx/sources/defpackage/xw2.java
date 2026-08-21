package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xw2 {
    public static final /* synthetic */ xw2[] A;
    public static final /* synthetic */ j51 X;
    public static final xw2 b;
    public static final xw2 f;
    public static final xw2 z;

    static {
        xw2 xw2Var = new xw2("RuleBased", 0);
        b = xw2Var;
        xw2 xw2Var2 = new xw2("Direct", 1);
        f = xw2Var2;
        xw2 xw2Var3 = new xw2("Global", 2);
        z = xw2Var3;
        xw2[] xw2VarArr = {xw2Var, xw2Var2, xw2Var3};
        A = xw2VarArr;
        X = new j51(xw2VarArr);
    }

    public static xw2 valueOf(String str) {
        return (xw2) Enum.valueOf(xw2.class, str);
    }

    public static xw2[] values() {
        return (xw2[]) A.clone();
    }
}
