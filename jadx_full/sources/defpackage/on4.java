package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class on4 {
    public static final on4 A;
    public static final on4 X;
    public static final on4 Y;
    public static final /* synthetic */ on4[] Z;
    public static final on4 b;
    public static final on4 f;
    public static final on4 z;

    static {
        on4 on4Var = new on4("IMAGE_CAPTURE", 0);
        b = on4Var;
        on4 on4Var2 = new on4("PREVIEW", 1);
        f = on4Var2;
        on4 on4Var3 = new on4("IMAGE_ANALYSIS", 2);
        z = on4Var3;
        on4 on4Var4 = new on4("VIDEO_CAPTURE", 3);
        A = on4Var4;
        on4 on4Var5 = new on4("STREAM_SHARING", 4);
        X = on4Var5;
        on4 on4Var6 = new on4("METERING_REPEATING", 5);
        Y = on4Var6;
        Z = new on4[]{on4Var, on4Var2, on4Var3, on4Var4, on4Var5, on4Var6};
    }

    public static on4 valueOf(String str) {
        return (on4) Enum.valueOf(on4.class, str);
    }

    public static on4[] values() {
        return (on4[]) Z.clone();
    }
}
