package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ey {
    public static final ey A;
    public static final ey X;
    public static final /* synthetic */ ey[] Y;
    public static final ey b;
    public static final ey f;
    public static final ey z;

    static {
        ey eyVar = new ey("UNKNOWN", 0);
        b = eyVar;
        ey eyVar2 = new ey("INACTIVE", 1);
        f = eyVar2;
        ey eyVar3 = new ey("METERING", 2);
        z = eyVar3;
        ey eyVar4 = new ey("CONVERGED", 3);
        A = eyVar4;
        ey eyVar5 = new ey("LOCKED", 4);
        X = eyVar5;
        Y = new ey[]{eyVar, eyVar2, eyVar3, eyVar4, eyVar5};
    }

    public static ey valueOf(String str) {
        return (ey) Enum.valueOf(ey.class, str);
    }

    public static ey[] values() {
        return (ey[]) Y.clone();
    }
}
