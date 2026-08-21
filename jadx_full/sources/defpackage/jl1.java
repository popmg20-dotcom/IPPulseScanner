package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jl1 {
    public static final jl1 A;
    public static final jl1 X;
    public static final /* synthetic */ jl1[] Y;
    public static final jl1 b;
    public static final jl1 f;
    public static final jl1 z;

    static {
        jl1 jl1Var = new jl1("ON_CONFIGURE", 0);
        b = jl1Var;
        jl1 jl1Var2 = new jl1("ON_CREATE", 1);
        f = jl1Var2;
        jl1 jl1Var3 = new jl1("ON_UPGRADE", 2);
        z = jl1Var3;
        jl1 jl1Var4 = new jl1("ON_DOWNGRADE", 3);
        A = jl1Var4;
        jl1 jl1Var5 = new jl1("ON_OPEN", 4);
        X = jl1Var5;
        Y = new jl1[]{jl1Var, jl1Var2, jl1Var3, jl1Var4, jl1Var5};
    }

    public static jl1 valueOf(String str) {
        return (jl1) Enum.valueOf(jl1.class, str);
    }

    public static jl1[] values() {
        return (jl1[]) Y.clone();
    }
}
