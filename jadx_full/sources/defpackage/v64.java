package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v64 {
    public static final v64 A;
    public static final v64 X;
    public static final /* synthetic */ v64[] Y;
    public static final v64 b;
    public static final v64 f;
    public static final v64 z;

    static {
        v64 v64Var = new v64("PRIV", 0);
        b = v64Var;
        v64 v64Var2 = new v64("YUV", 1);
        f = v64Var2;
        v64 v64Var3 = new v64("JPEG", 2);
        z = v64Var3;
        v64 v64Var4 = new v64("JPEG_R", 3);
        A = v64Var4;
        v64 v64Var5 = new v64("RAW", 4);
        X = v64Var5;
        Y = new v64[]{v64Var, v64Var2, v64Var3, v64Var4, v64Var5};
    }

    public static v64 valueOf(String str) {
        return (v64) Enum.valueOf(v64.class, str);
    }

    public static v64[] values() {
        return (v64[]) Y.clone();
    }
}
