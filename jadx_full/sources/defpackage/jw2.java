package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jw2 {
    public static final jw2 b;
    public static final jw2 f;
    public static final /* synthetic */ jw2[] z;

    static {
        jw2 jw2Var = new jw2("TRUE", 0);
        b = jw2Var;
        jw2 jw2Var2 = new jw2("FALSE", 1);
        jw2 jw2Var3 = new jw2("DEFAULT", 2);
        f = jw2Var3;
        z = new jw2[]{jw2Var, jw2Var2, jw2Var3};
    }

    public static jw2 valueOf(String str) {
        return (jw2) Enum.valueOf(jw2.class, str);
    }

    public static jw2[] values() {
        return (jw2[]) z.clone();
    }

    public final Boolean a() {
        if (this == f) {
            return null;
        }
        return this == b ? Boolean.TRUE : Boolean.FALSE;
    }
}
