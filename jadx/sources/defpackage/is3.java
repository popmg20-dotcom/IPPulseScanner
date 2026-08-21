package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class is3 {
    public static final /* synthetic */ is3[] A;
    public static final is3 b;
    public static final is3 f;
    public static final is3 z;

    static {
        is3 is3Var = new is3("LEFT_SELECTION", 0);
        b = is3Var;
        is3 is3Var2 = new is3("RIGHT_SELECTION", 1);
        f = is3Var2;
        is3 is3Var3 = new is3("SELECTION_ANCHOR", 2);
        z = is3Var3;
        A = new is3[]{is3Var, is3Var2, is3Var3};
    }

    public static is3 valueOf(String str) {
        return (is3) Enum.valueOf(is3.class, str);
    }

    public static is3[] values() {
        return (is3[]) A.clone();
    }
}
