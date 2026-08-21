package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class b53 {
    public static final /* synthetic */ b53[] A;
    public static final y43 b;
    public static final z43 f;
    public static final a53 z;

    static {
        y43 y43Var = new y43();
        b = y43Var;
        z43 z43Var = new z43();
        f = z43Var;
        a53 a53Var = new a53();
        z = a53Var;
        A = new b53[]{y43Var, z43Var, a53Var};
    }

    public static b53 valueOf(String str) {
        return (b53) Enum.valueOf(b53.class, str);
    }

    public static b53[] values() {
        return (b53[]) A.clone();
    }

    public abstract boolean a(boolean z2);
}
