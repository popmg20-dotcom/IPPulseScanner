package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class jp {
    public static final /* synthetic */ jp[] A;
    public static final jp b;
    public static final jp f;
    public static final jp z;

    static {
        jp jpVar = new jp("SUSPEND", 0);
        b = jpVar;
        jp jpVar2 = new jp("DROP_OLDEST", 1);
        f = jpVar2;
        jp jpVar3 = new jp("DROP_LATEST", 2);
        z = jpVar3;
        A = new jp[]{jpVar, jpVar2, jpVar3};
    }

    public static jp valueOf(String str) {
        return (jp) Enum.valueOf(jp.class, str);
    }

    public static jp[] values() {
        return (jp[]) A.clone();
    }
}
