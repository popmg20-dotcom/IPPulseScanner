package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kz1 {
    public static final kz1 A;
    public static final /* synthetic */ kz1[] X;
    public static final kz1 b;
    public static final kz1 f;
    public static final kz1 z;

    static {
        kz1 kz1Var = new kz1("PENDING", 0);
        b = kz1Var;
        kz1 kz1Var2 = new kz1("RUNNING", 1);
        f = kz1Var2;
        kz1 kz1Var3 = new kz1("COMPLETED", 2);
        z = kz1Var3;
        kz1 kz1Var4 = new kz1("FAILED", 3);
        A = kz1Var4;
        X = new kz1[]{kz1Var, kz1Var2, kz1Var3, kz1Var4};
    }

    public static kz1 valueOf(String str) {
        return (kz1) Enum.valueOf(kz1.class, str);
    }

    public static kz1[] values() {
        return (kz1[]) X.clone();
    }
}
