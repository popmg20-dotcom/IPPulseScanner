package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class s43 {
    public static final s43 b;
    public static final s43 f;
    public static final /* synthetic */ s43[] z;

    static {
        s43 s43Var = new s43("IDLE", 0);
        b = s43Var;
        s43 s43Var2 = new s43("STREAMING", 1);
        f = s43Var2;
        z = new s43[]{s43Var, s43Var2};
    }

    public static s43 valueOf(String str) {
        return (s43) Enum.valueOf(s43.class, str);
    }

    public static s43[] values() {
        return (s43[]) z.clone();
    }
}
