package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cd4 {
    public static final cd4 A;
    public static final cd4 X;
    public static final cd4 Y;
    public static final cd4 Z;
    public static final cd4 b;
    public static final cd4 f;
    public static final /* synthetic */ cd4[] y0;
    public static final cd4 z;

    static {
        cd4 cd4Var = new cd4("AUTO", 0);
        b = cd4Var;
        cd4 cd4Var2 = new cd4("GREEN", 1);
        f = cd4Var2;
        cd4 cd4Var3 = new cd4("PINK", 2);
        z = cd4Var3;
        cd4 cd4Var4 = new cd4("PURPLE", 3);
        A = cd4Var4;
        cd4 cd4Var5 = new cd4("ORANGE", 4);
        X = cd4Var5;
        cd4 cd4Var6 = new cd4("GREEN_1", 5);
        Y = cd4Var6;
        cd4 cd4Var7 = new cd4("YELLOW_1", 6);
        Z = cd4Var7;
        y0 = new cd4[]{cd4Var, cd4Var2, cd4Var3, cd4Var4, cd4Var5, cd4Var6, cd4Var7};
    }

    public static cd4 valueOf(String str) {
        return (cd4) Enum.valueOf(cd4.class, str);
    }

    public static cd4[] values() {
        return (cd4[]) y0.clone();
    }
}
