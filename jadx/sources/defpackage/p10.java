package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p10 {
    public static final p10 A;
    public static final /* synthetic */ j51 A0;
    public static final p10 X;
    public static final p10 Y;
    public static final p10 Z;
    public static final p10 b;
    public static final p10 f;
    public static final p10 y0;
    public static final p10 z;
    public static final /* synthetic */ p10[] z0;

    static {
        p10 p10Var = new p10("NETWORK_SPEED", 0);
        b = p10Var;
        p10 p10Var2 = new p10("OUTBOUND_MODE", 1);
        f = p10Var2;
        p10 p10Var3 = new p10("PUBLIC_IP", 2);
        z = p10Var3;
        p10 p10Var4 = new p10("DNS", 3);
        A = p10Var4;
        p10 p10Var5 = new p10("LOCAL_PROXY", 4);
        X = p10Var5;
        p10 p10Var6 = new p10("ACTIVE_CONNECTIONS", 5);
        Y = p10Var6;
        p10 p10Var7 = new p10("TRAFFIC_USAGE", 6);
        Z = p10Var7;
        p10 p10Var8 = new p10("PRIVATE_IP", 7);
        y0 = p10Var8;
        p10[] p10VarArr = {p10Var, p10Var2, p10Var3, p10Var4, p10Var5, p10Var6, p10Var7, p10Var8};
        z0 = p10VarArr;
        A0 = new j51(p10VarArr);
    }

    public static p10 valueOf(String str) {
        return (p10) Enum.valueOf(p10.class, str);
    }

    public static p10[] values() {
        return (p10[]) z0.clone();
    }
}
