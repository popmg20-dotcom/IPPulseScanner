package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tn {
    public static final /* synthetic */ tn[] A;
    public static final tn b;
    public static final tn f;
    public static final tn z;

    static {
        tn tnVar = new tn("AUTO", 0);
        b = tnVar;
        tn tnVar2 = new tn("ON", 1);
        f = tnVar2;
        tn tnVar3 = new tn("OFF", 2);
        z = tnVar3;
        A = new tn[]{tnVar, tnVar2, tnVar3};
    }

    public static tn valueOf(String str) {
        return (tn) Enum.valueOf(tn.class, str);
    }

    public static tn[] values() {
        return (tn[]) A.clone();
    }
}
