package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v70 {
    public static final /* synthetic */ v70[] A;
    public static final /* synthetic */ j51 X;
    public static final v70 b;
    public static final v70 f;
    public static final v70 z;

    static {
        v70 v70Var = new v70("Small", 0);
        b = v70Var;
        v70 v70Var2 = new v70("Medium", 1);
        f = v70Var2;
        v70 v70Var3 = new v70("Large", 2);
        z = v70Var3;
        v70[] v70VarArr = {v70Var, v70Var2, v70Var3};
        A = v70VarArr;
        X = new j51(v70VarArr);
    }

    public static v70 valueOf(String str) {
        return (v70) Enum.valueOf(v70.class, str);
    }

    public static v70[] values() {
        return (v70[]) A.clone();
    }
}
