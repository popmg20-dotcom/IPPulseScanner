package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class p92 {
    private static final /* synthetic */ i51 $ENTRIES;
    private static final /* synthetic */ p92[] $VALUES;
    public static final n92 Companion;
    public static final p92 ON_ANY;
    public static final p92 ON_CREATE;
    public static final p92 ON_DESTROY;
    public static final p92 ON_PAUSE;
    public static final p92 ON_RESUME;
    public static final p92 ON_START;
    public static final p92 ON_STOP;

    static {
        p92 p92Var = new p92("ON_CREATE", 0);
        ON_CREATE = p92Var;
        p92 p92Var2 = new p92("ON_START", 1);
        ON_START = p92Var2;
        p92 p92Var3 = new p92("ON_RESUME", 2);
        ON_RESUME = p92Var3;
        p92 p92Var4 = new p92("ON_PAUSE", 3);
        ON_PAUSE = p92Var4;
        p92 p92Var5 = new p92("ON_STOP", 4);
        ON_STOP = p92Var5;
        p92 p92Var6 = new p92("ON_DESTROY", 5);
        ON_DESTROY = p92Var6;
        p92 p92Var7 = new p92("ON_ANY", 6);
        ON_ANY = p92Var7;
        p92[] p92VarArr = {p92Var, p92Var2, p92Var3, p92Var4, p92Var5, p92Var6, p92Var7};
        $VALUES = p92VarArr;
        $ENTRIES = new j51(p92VarArr);
        Companion = new n92();
    }

    public static p92 valueOf(String str) {
        return (p92) Enum.valueOf(p92.class, str);
    }

    public static p92[] values() {
        return (p92[]) $VALUES.clone();
    }

    public final q92 a() {
        switch (o92.a[ordinal()]) {
            case 1:
            case 2:
                return q92.z;
            case 3:
            case 4:
                return q92.A;
            case 5:
                return q92.X;
            case 6:
                return q92.b;
            case 7:
                throw new IllegalArgumentException(this + " has no target state");
            default:
                g.d();
                return null;
        }
    }
}
