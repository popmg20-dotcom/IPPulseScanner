package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dy {
    public static final dy A;
    public static final dy X;
    public static final dy Y;
    public static final dy Z;
    public static final dy b;
    public static final dy f;
    public static final /* synthetic */ dy[] y0;
    public static final dy z;

    static {
        dy dyVar = new dy("UNKNOWN", 0);
        b = dyVar;
        dy dyVar2 = new dy("INACTIVE", 1);
        f = dyVar2;
        dy dyVar3 = new dy("SCANNING", 2);
        z = dyVar3;
        dy dyVar4 = new dy("PASSIVE_FOCUSED", 3);
        A = dyVar4;
        dy dyVar5 = new dy("PASSIVE_NOT_FOCUSED", 4);
        X = dyVar5;
        dy dyVar6 = new dy("LOCKED_FOCUSED", 5);
        Y = dyVar6;
        dy dyVar7 = new dy("LOCKED_NOT_FOCUSED", 6);
        Z = dyVar7;
        y0 = new dy[]{dyVar, dyVar2, dyVar3, dyVar4, dyVar5, dyVar6, dyVar7};
    }

    public static dy valueOf(String str) {
        return (dy) Enum.valueOf(dy.class, str);
    }

    public static dy[] values() {
        return (dy[]) y0.clone();
    }
}
