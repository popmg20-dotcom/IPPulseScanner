package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class o71 {
    public static final o71 A;
    public static final /* synthetic */ o71[] X;
    public static final o71 b;
    public static final o71 f;
    public static final o71 z;

    static {
        o71 o71Var = new o71("REPLACE", 0);
        b = o71Var;
        o71 o71Var2 = new o71("KEEP", 1);
        f = o71Var2;
        o71 o71Var3 = new o71("APPEND", 2);
        z = o71Var3;
        o71 o71Var4 = new o71("APPEND_OR_REPLACE", 3);
        A = o71Var4;
        X = new o71[]{o71Var, o71Var2, o71Var3, o71Var4};
    }

    public static o71 valueOf(String str) {
        return (o71) Enum.valueOf(o71.class, str);
    }

    public static o71[] values() {
        return (o71[]) X.clone();
    }
}
