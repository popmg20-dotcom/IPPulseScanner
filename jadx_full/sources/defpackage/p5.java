package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p5 {
    public static final p5 b;
    public static final p5 f;
    public static final /* synthetic */ p5[] z;

    static {
        p5 p5Var = new p5("NEW", 0);
        b = p5Var;
        p5 p5Var2 = new p5("EDIT", 1);
        f = p5Var2;
        z = new p5[]{p5Var, p5Var2};
    }

    public static p5 valueOf(String str) {
        return (p5) Enum.valueOf(p5.class, str);
    }

    public static p5[] values() {
        return (p5[]) z.clone();
    }
}
