package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class jf0 {
    public static final jf0 A;
    public static final jf0 X;
    public static final /* synthetic */ jf0[] Y;
    public static final jf0 b;
    public static final jf0 f;
    public static final jf0 z;

    static {
        jf0 jf0Var = new jf0("CPU_ACQUIRED", 0);
        b = jf0Var;
        jf0 jf0Var2 = new jf0("BLOCKING", 1);
        f = jf0Var2;
        jf0 jf0Var3 = new jf0("PARKING", 2);
        z = jf0Var3;
        jf0 jf0Var4 = new jf0("DORMANT", 3);
        A = jf0Var4;
        jf0 jf0Var5 = new jf0("TERMINATED", 4);
        X = jf0Var5;
        Y = new jf0[]{jf0Var, jf0Var2, jf0Var3, jf0Var4, jf0Var5};
    }

    public static jf0 valueOf(String str) {
        return (jf0) Enum.valueOf(jf0.class, str);
    }

    public static jf0[] values() {
        return (jf0[]) Y.clone();
    }
}
