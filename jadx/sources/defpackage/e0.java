package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class e0 {
    public static final e0 A;
    public static final /* synthetic */ e0[] X;
    public static final e0 b;
    public static final e0 f;
    public static final e0 z;

    static {
        e0 e0Var = new e0("Opened", 0);
        b = e0Var;
        e0 e0Var2 = new e0("Graceful", 1);
        f = e0Var2;
        e0 e0Var3 = new e0("Immediate", 2);
        z = e0Var3;
        e0 e0Var4 = new e0("Closed", 3);
        A = e0Var4;
        X = new e0[]{e0Var, e0Var2, e0Var3, e0Var4};
    }

    public static e0 valueOf(String str) {
        return (e0) Enum.valueOf(e0.class, str);
    }

    public static e0[] values() {
        return (e0[]) X.clone();
    }
}
