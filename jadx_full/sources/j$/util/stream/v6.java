package j$.util.stream;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class v6 {
    public static final v6 OP;
    public static final v6 SPLITERATOR;
    public static final v6 STREAM;
    public static final v6 TERMINAL_OP;
    public static final v6 UPSTREAM_TERMINAL_OP;
    public static final /* synthetic */ v6[] a;

    static {
        v6 v6Var = new v6("SPLITERATOR", 0);
        SPLITERATOR = v6Var;
        v6 v6Var2 = new v6("STREAM", 1);
        STREAM = v6Var2;
        v6 v6Var3 = new v6("OP", 2);
        OP = v6Var3;
        v6 v6Var4 = new v6("TERMINAL_OP", 3);
        TERMINAL_OP = v6Var4;
        v6 v6Var5 = new v6("UPSTREAM_TERMINAL_OP", 4);
        UPSTREAM_TERMINAL_OP = v6Var5;
        a = new v6[]{v6Var, v6Var2, v6Var3, v6Var4, v6Var5};
    }

    public static v6 valueOf(String str) {
        return (v6) Enum.valueOf(v6.class, str);
    }

    public static v6[] values() {
        return (v6[]) a.clone();
    }
}
