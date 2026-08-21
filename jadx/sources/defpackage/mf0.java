package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mf0 {
    public static final mf0 b;
    public static final /* synthetic */ mf0[] f;

    static {
        mf0 mf0Var = new mf0("COROUTINE_SUSPENDED", 0);
        b = mf0Var;
        f = new mf0[]{mf0Var, new mf0("UNDECIDED", 1), new mf0("RESUMED", 2)};
    }

    public static mf0 valueOf(String str) {
        return (mf0) Enum.valueOf(mf0.class, str);
    }

    public static mf0[] values() {
        return (mf0[]) f.clone();
    }
}
