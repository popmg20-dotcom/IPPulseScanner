package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ww2 {
    public static final ww2 b;
    public static final ww2 f;
    public static final /* synthetic */ ww2[] z;

    static {
        ww2 ww2Var = new ww2("RUN_AS_NON_EXPEDITED_WORK_REQUEST", 0);
        b = ww2Var;
        ww2 ww2Var2 = new ww2("DROP_WORK_REQUEST", 1);
        f = ww2Var2;
        z = new ww2[]{ww2Var, ww2Var2};
    }

    public static ww2 valueOf(String str) {
        return (ww2) Enum.valueOf(ww2.class, str);
    }

    public static ww2[] values() {
        return (ww2[]) z.clone();
    }
}
