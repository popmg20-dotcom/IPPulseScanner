package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m62 {
    public static final /* synthetic */ m62[] A;
    public static final m62 b;
    public static final m62 f;
    public static final m62 z;

    static {
        m62 m62Var = new m62("AUTO", 0);
        b = m62Var;
        m62 m62Var2 = new m62("READ_ONLY", 1);
        f = m62Var2;
        m62 m62Var3 = new m62("WRITE_ONLY", 2);
        z = m62Var3;
        A = new m62[]{m62Var, m62Var2, m62Var3, new m62("READ_WRITE", 3)};
    }

    public static m62 valueOf(String str) {
        return (m62) Enum.valueOf(m62.class, str);
    }

    public static m62[] values() {
        return (m62[]) A.clone();
    }
}
