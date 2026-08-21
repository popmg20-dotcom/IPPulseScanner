package j$.util.stream;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static final g CONCURRENT;
    public static final g IDENTITY_FINISH;
    public static final g UNORDERED;
    public static final /* synthetic */ g[] a;

    static {
        g gVar = new g("CONCURRENT", 0);
        CONCURRENT = gVar;
        g gVar2 = new g("UNORDERED", 1);
        UNORDERED = gVar2;
        g gVar3 = new g("IDENTITY_FINISH", 2);
        IDENTITY_FINISH = gVar3;
        a = new g[]{gVar, gVar2, gVar3};
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) a.clone();
    }
}
