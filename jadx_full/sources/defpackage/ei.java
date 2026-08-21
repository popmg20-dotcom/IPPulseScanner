package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ei {
    public static final ei b;
    public static final ei f;
    public static final /* synthetic */ ei[] z;

    static {
        ei eiVar = new ei("EXPONENTIAL", 0);
        b = eiVar;
        ei eiVar2 = new ei("LINEAR", 1);
        f = eiVar2;
        z = new ei[]{eiVar, eiVar2};
    }

    public static ei valueOf(String str) {
        return (ei) Enum.valueOf(ei.class, str);
    }

    public static ei[] values() {
        return (ei[]) z.clone();
    }
}
