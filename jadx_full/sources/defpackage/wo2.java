package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wo2 {
    public static final wo2 A;
    public static final wo2 X;
    public static final wo2 Y;
    public static final wo2 Z;
    public static final wo2 b;
    public static final wo2 f;
    public static final wo2 y0;
    public static final wo2 z;
    public static final /* synthetic */ wo2[] z0;

    static {
        wo2 wo2Var = new wo2("UDP_BLOCKED", 0);
        b = wo2Var;
        wo2 wo2Var2 = new wo2("OPEN_INTERNET", 1);
        f = wo2Var2;
        wo2 wo2Var3 = new wo2("FULL_CONE", 2);
        z = wo2Var3;
        wo2 wo2Var4 = new wo2("RESTRICTED_CONE", 3);
        A = wo2Var4;
        wo2 wo2Var5 = new wo2("PORT_RESTRICTED_CONE", 4);
        X = wo2Var5;
        wo2 wo2Var6 = new wo2("SYMMETRIC_NAT", 5);
        Y = wo2Var6;
        wo2 wo2Var7 = new wo2("SYMMETRIC_UDP_FIREWALL", 6);
        Z = wo2Var7;
        wo2 wo2Var8 = new wo2("ENDPOINT_INDEPENDENT", 7);
        y0 = wo2Var8;
        z0 = new wo2[]{wo2Var, wo2Var2, wo2Var3, wo2Var4, wo2Var5, wo2Var6, wo2Var7, wo2Var8};
    }

    public static wo2 valueOf(String str) {
        return (wo2) Enum.valueOf(wo2.class, str);
    }

    public static wo2[] values() {
        return (wo2[]) z0.clone();
    }
}
