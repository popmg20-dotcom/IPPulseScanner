package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m23 {
    public static final m23 b;
    public static final /* synthetic */ m23[] f;

    /* JADX INFO: Fake field, exist only in values array */
    m23 EF0;

    static {
        m23 m23Var = new m23("EXACT", 0);
        m23 m23Var2 = new m23("INEXACT", 1);
        m23 m23Var3 = new m23("AUTOMATIC", 2);
        b = m23Var3;
        f = new m23[]{m23Var, m23Var2, m23Var3};
    }

    public static m23 valueOf(String str) {
        return (m23) Enum.valueOf(m23.class, str);
    }

    public static m23[] values() {
        return (m23[]) f.clone();
    }
}
