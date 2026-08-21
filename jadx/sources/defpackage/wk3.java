package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wk3 {
    public static final wk3 A;
    public static final wk3 A0;
    public static final wk3 B0;
    public static final wk3 C0;
    public static final wk3 D0;
    public static final /* synthetic */ wk3[] E0;
    public static final wk3 X;
    public static final wk3 Y;
    public static final wk3 Z;
    public static final wk3 b;
    public static final wk3 f;
    public static final wk3 y0;
    public static final wk3 z;
    public static final wk3 z0;

    /* JADX INFO: Fake field, exist only in values array */
    wk3 EF0;

    static {
        wk3 wk3Var = new wk3("OTHER", 0);
        wk3 wk3Var2 = new wk3("ORIENTATION", 1);
        b = wk3Var2;
        wk3 wk3Var3 = new wk3("BYTE_SEGMENTS", 2);
        f = wk3Var3;
        wk3 wk3Var4 = new wk3("ERROR_CORRECTION_LEVEL", 3);
        z = wk3Var4;
        wk3 wk3Var5 = new wk3("ERRORS_CORRECTED", 4);
        A = wk3Var5;
        wk3 wk3Var6 = new wk3("ERASURES_CORRECTED", 5);
        X = wk3Var6;
        wk3 wk3Var7 = new wk3("ISSUE_NUMBER", 6);
        Y = wk3Var7;
        wk3 wk3Var8 = new wk3("SUGGESTED_PRICE", 7);
        Z = wk3Var8;
        wk3 wk3Var9 = new wk3("POSSIBLE_COUNTRY", 8);
        y0 = wk3Var9;
        wk3 wk3Var10 = new wk3("UPC_EAN_EXTENSION", 9);
        z0 = wk3Var10;
        wk3 wk3Var11 = new wk3("PDF417_EXTRA_METADATA", 10);
        A0 = wk3Var11;
        wk3 wk3Var12 = new wk3("STRUCTURED_APPEND_SEQUENCE", 11);
        B0 = wk3Var12;
        wk3 wk3Var13 = new wk3("STRUCTURED_APPEND_PARITY", 12);
        C0 = wk3Var13;
        wk3 wk3Var14 = new wk3("SYMBOLOGY_IDENTIFIER", 13);
        D0 = wk3Var14;
        E0 = new wk3[]{wk3Var, wk3Var2, wk3Var3, wk3Var4, wk3Var5, wk3Var6, wk3Var7, wk3Var8, wk3Var9, wk3Var10, wk3Var11, wk3Var12, wk3Var13, wk3Var14};
    }

    public static wk3 valueOf(String str) {
        return (wk3) Enum.valueOf(wk3.class, str);
    }

    public static wk3[] values() {
        return (wk3[]) E0.clone();
    }
}
