package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q92 {
    public static final q92 A;
    public static final q92 X;
    public static final /* synthetic */ q92[] Y;
    public static final q92 b;
    public static final q92 f;
    public static final q92 z;

    static {
        q92 q92Var = new q92("DESTROYED", 0);
        b = q92Var;
        q92 q92Var2 = new q92("INITIALIZED", 1);
        f = q92Var2;
        q92 q92Var3 = new q92("CREATED", 2);
        z = q92Var3;
        q92 q92Var4 = new q92("STARTED", 3);
        A = q92Var4;
        q92 q92Var5 = new q92("RESUMED", 4);
        X = q92Var5;
        Y = new q92[]{q92Var, q92Var2, q92Var3, q92Var4, q92Var5};
    }

    public static q92 valueOf(String str) {
        return (q92) Enum.valueOf(q92.class, str);
    }

    public static q92[] values() {
        return (q92[]) Y.clone();
    }
}
