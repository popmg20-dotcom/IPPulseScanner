package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xc1 {
    public static final xc1 A;
    public static final /* synthetic */ xc1[] X;
    public static final /* synthetic */ j51 Y;
    public static final xc1 b;
    public static final xc1 f;
    public static final xc1 z;

    static {
        xc1 xc1Var = new xc1("DYNAMIC_RANGE", 0);
        b = xc1Var;
        xc1 xc1Var2 = new xc1("FPS_RANGE", 1);
        f = xc1Var2;
        xc1 xc1Var3 = new xc1("VIDEO_STABILIZATION", 2);
        z = xc1Var3;
        xc1 xc1Var4 = new xc1("IMAGE_FORMAT", 3);
        A = xc1Var4;
        xc1[] xc1VarArr = {xc1Var, xc1Var2, xc1Var3, xc1Var4};
        X = xc1VarArr;
        Y = new j51(xc1VarArr);
    }

    public static xc1 valueOf(String str) {
        return (xc1) Enum.valueOf(xc1.class, str);
    }

    public static xc1[] values() {
        return (xc1[]) X.clone();
    }
}
