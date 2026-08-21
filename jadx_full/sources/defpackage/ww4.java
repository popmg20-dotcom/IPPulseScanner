package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ww4 {
    public static final ww4 A;
    public static final ww4 X;
    public static final ww4 Y;
    public static final /* synthetic */ ww4[] Z;
    public static final ww4 b;
    public static final ww4 f;
    public static final ww4 z;

    static {
        ww4 ww4Var = new ww4("ENQUEUED", 0);
        b = ww4Var;
        ww4 ww4Var2 = new ww4("RUNNING", 1);
        f = ww4Var2;
        ww4 ww4Var3 = new ww4("SUCCEEDED", 2);
        z = ww4Var3;
        ww4 ww4Var4 = new ww4("FAILED", 3);
        A = ww4Var4;
        ww4 ww4Var5 = new ww4("BLOCKED", 4);
        X = ww4Var5;
        ww4 ww4Var6 = new ww4("CANCELLED", 5);
        Y = ww4Var6;
        Z = new ww4[]{ww4Var, ww4Var2, ww4Var3, ww4Var4, ww4Var5, ww4Var6};
    }

    public static ww4 valueOf(String str) {
        return (ww4) Enum.valueOf(ww4.class, str);
    }

    public static ww4[] values() {
        return (ww4[]) Z.clone();
    }

    public final boolean a() {
        return this == z || this == A || this == Y;
    }
}
