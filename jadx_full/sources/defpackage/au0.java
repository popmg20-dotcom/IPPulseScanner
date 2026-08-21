package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class au0 {
    public static final au0 b;
    public static final /* synthetic */ au0[] f;

    /* JADX INFO: Fake field, exist only in values array */
    au0 EF0;

    static {
        au0 au0Var = new au0("NONE", 0);
        au0 au0Var2 = new au0("LINE", 1);
        au0 au0Var3 = new au0("DOUBLE_LINE", 2);
        au0 au0Var4 = new au0("WAVY_LINE", 3);
        b = au0Var4;
        f = new au0[]{au0Var, au0Var2, au0Var3, au0Var4};
    }

    public static au0 valueOf(String str) {
        return (au0) Enum.valueOf(au0.class, str);
    }

    public static au0[] values() {
        return (au0[]) f.clone();
    }
}
