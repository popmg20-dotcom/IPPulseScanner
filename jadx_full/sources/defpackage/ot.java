package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ot {
    public static final ot A;
    public static final /* synthetic */ ot[] X;
    public static final /* synthetic */ j51 Y;
    public static final ot b;
    public static final ot f;
    public static final ot z;

    static {
        ot otVar = new ot("NAME", 0);
        b = otVar;
        ot otVar2 = new ot("PACKAGE_NAME", 1);
        f = otVar2;
        ot otVar3 = new ot("INSTALL_TIME", 2);
        z = otVar3;
        ot otVar4 = new ot("UPDATE_TIME", 3);
        A = otVar4;
        ot[] otVarArr = {otVar, otVar2, otVar3, otVar4};
        X = otVarArr;
        Y = new j51(otVarArr);
    }

    public static ot valueOf(String str) {
        return (ot) Enum.valueOf(ot.class, str);
    }

    public static ot[] values() {
        return (ot[]) X.clone();
    }
}
