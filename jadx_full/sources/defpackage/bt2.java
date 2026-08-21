package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bt2 {
    public static final bt2 b;
    public static final /* synthetic */ bt2[] f;

    /* JADX INFO: Fake field, exist only in values array */
    bt2 EF0;

    static {
        bt2 bt2Var = new bt2("SET", 0);
        bt2 bt2Var2 = new bt2("SKIP", 1);
        bt2 bt2Var3 = new bt2("FAIL", 2);
        bt2 bt2Var4 = new bt2("AS_EMPTY", 3);
        bt2 bt2Var5 = new bt2("DEFAULT", 4);
        b = bt2Var5;
        f = new bt2[]{bt2Var, bt2Var2, bt2Var3, bt2Var4, bt2Var5};
    }

    public static bt2 valueOf(String str) {
        return (bt2) Enum.valueOf(bt2.class, str);
    }

    public static bt2[] values() {
        return (bt2[]) f.clone();
    }
}
