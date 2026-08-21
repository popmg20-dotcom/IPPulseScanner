package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pu0 {
    public static final /* synthetic */ pu0[] A;
    public static final pu0 b;
    public static final pu0 f;
    public static final pu0 z;

    static {
        pu0 pu0Var = new pu0("ITEM_TO_PLACEHOLDER", 0);
        b = pu0Var;
        pu0 pu0Var2 = new pu0("PLACEHOLDER_TO_ITEM", 1);
        f = pu0Var2;
        pu0 pu0Var3 = new pu0("PLACEHOLDER_POSITION_CHANGE", 2);
        z = pu0Var3;
        A = new pu0[]{pu0Var, pu0Var2, pu0Var3};
    }

    public static pu0 valueOf(String str) {
        return (pu0) Enum.valueOf(pu0.class, str);
    }

    public static pu0[] values() {
        return (pu0[]) A.clone();
    }
}
