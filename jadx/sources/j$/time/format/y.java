package j$.time.format;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class y {
    public static final y FULL;
    public static final y FULL_STANDALONE;
    public static final y NARROW;
    public static final y NARROW_STANDALONE;
    public static final y SHORT;
    public static final y SHORT_STANDALONE;
    public static final /* synthetic */ y[] a;

    static {
        y yVar = new y("FULL", 0);
        FULL = yVar;
        y yVar2 = new y("FULL_STANDALONE", 1);
        FULL_STANDALONE = yVar2;
        y yVar3 = new y("SHORT", 2);
        SHORT = yVar3;
        y yVar4 = new y("SHORT_STANDALONE", 3);
        SHORT_STANDALONE = yVar4;
        y yVar5 = new y("NARROW", 4);
        NARROW = yVar5;
        y yVar6 = new y("NARROW_STANDALONE", 5);
        NARROW_STANDALONE = yVar6;
        a = new y[]{yVar, yVar2, yVar3, yVar4, yVar5, yVar6};
    }

    public static y valueOf(String str) {
        return (y) Enum.valueOf(y.class, str);
    }

    public static y[] values() {
        return (y[]) a.clone();
    }
}
