package j$.util.stream;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class x7 {
    public static final x7 MAYBE_MORE;
    public static final x7 NO_MORE;
    public static final x7 UNLIMITED;
    public static final /* synthetic */ x7[] a;

    static {
        x7 x7Var = new x7("NO_MORE", 0);
        NO_MORE = x7Var;
        x7 x7Var2 = new x7("MAYBE_MORE", 1);
        MAYBE_MORE = x7Var2;
        x7 x7Var3 = new x7("UNLIMITED", 2);
        UNLIMITED = x7Var3;
        a = new x7[]{x7Var, x7Var2, x7Var3};
    }

    public static x7 valueOf(String str) {
        return (x7) Enum.valueOf(x7.class, str);
    }

    public static x7[] values() {
        return (x7[]) a.clone();
    }
}
