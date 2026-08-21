package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fk0 {
    public static final fk0 A;
    public static final fk0 X;
    public static final fk0 Y;
    public static final /* synthetic */ fk0[] Z;
    public static final fk0 b;
    public static final fk0 f;
    public static final fk0 z;

    /* JADX INFO: Fake field, exist only in values array */
    fk0 EF0;

    static {
        fk0 fk0Var = new fk0("OTHER", 0);
        fk0 fk0Var2 = new fk0("PURE_BARCODE", 1);
        fk0 fk0Var3 = new fk0("POSSIBLE_FORMATS", 2);
        b = fk0Var3;
        fk0 fk0Var4 = new fk0("TRY_HARDER", 3);
        fk0 fk0Var5 = new fk0("CHARACTER_SET", 4);
        fk0 fk0Var6 = new fk0("ALLOWED_LENGTHS", 5);
        f = fk0Var6;
        fk0 fk0Var7 = new fk0("ASSUME_CODE_39_CHECK_DIGIT", 6);
        fk0 fk0Var8 = new fk0("ASSUME_GS1", 7);
        z = fk0Var8;
        fk0 fk0Var9 = new fk0("RETURN_CODABAR_START_END", 8);
        A = fk0Var9;
        fk0 fk0Var10 = new fk0("NEED_RESULT_POINT_CALLBACK", 9);
        X = fk0Var10;
        fk0 fk0Var11 = new fk0("ALLOWED_EAN_EXTENSIONS", 10);
        Y = fk0Var11;
        Z = new fk0[]{fk0Var, fk0Var2, fk0Var3, fk0Var4, fk0Var5, fk0Var6, fk0Var7, fk0Var8, fk0Var9, fk0Var10, fk0Var11, new fk0("ALSO_INVERTED", 11)};
    }

    public static fk0 valueOf(String str) {
        return (fk0) Enum.valueOf(fk0.class, str);
    }

    public static fk0[] values() {
        return (fk0[]) Z.clone();
    }
}
