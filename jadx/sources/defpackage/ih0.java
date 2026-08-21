package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ih0 {
    public static final /* synthetic */ ih0[] A;
    public static final ih0 b;
    public static final ih0 f;
    public static final ih0 z;

    static {
        ih0 ih0Var = new ih0("AUTO", 0);
        b = ih0Var;
        ih0 ih0Var2 = new ih0("LIGHT", 1);
        f = ih0Var2;
        ih0 ih0Var3 = new ih0("DARK", 2);
        z = ih0Var3;
        A = new ih0[]{ih0Var, ih0Var2, ih0Var3};
    }

    public static ih0 valueOf(String str) {
        return (ih0) Enum.valueOf(ih0.class, str);
    }

    public static ih0[] values() {
        return (ih0[]) A.clone();
    }
}
