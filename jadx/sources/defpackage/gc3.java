package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class gc3 {
    public static final gc3 A;
    public static final gc3 X;
    public static final gc3 Y;
    public static final /* synthetic */ gc3[] Z;
    public static final gc3 b;
    public static final gc3 f;
    public static final gc3 z;

    static {
        gc3 gc3Var = new gc3("ASIS", 0);
        b = gc3Var;
        gc3 gc3Var2 = new gc3("DEL", 1);
        f = gc3Var2;
        gc3 gc3Var3 = new gc3("A", 2);
        z = gc3Var3;
        gc3 gc3Var4 = new gc3("AQ", 3);
        A = gc3Var4;
        gc3 gc3Var5 = new gc3("QQ", 4);
        X = gc3Var5;
        gc3 gc3Var6 = new gc3("P_QQ", 5);
        Y = gc3Var6;
        Z = new gc3[]{gc3Var, gc3Var2, gc3Var3, gc3Var4, gc3Var5, gc3Var6};
    }

    public static gc3 valueOf(String str) {
        return (gc3) Enum.valueOf(gc3.class, str);
    }

    public static gc3[] values() {
        return (gc3[]) Z.clone();
    }
}
