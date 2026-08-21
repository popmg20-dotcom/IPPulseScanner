package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sj {
    public static final sj A;
    public static final sj A0;
    public static final sj B0;
    public static final sj C0;
    public static final sj D0;
    public static final sj E0;
    public static final sj F0;
    public static final sj G0;
    public static final sj H0;
    public static final /* synthetic */ sj[] I0;
    public static final sj X;
    public static final sj Y;
    public static final sj Z;
    public static final sj b;
    public static final sj f;
    public static final sj y0;
    public static final sj z;
    public static final sj z0;

    static {
        sj sjVar = new sj("AZTEC", 0);
        b = sjVar;
        sj sjVar2 = new sj("CODABAR", 1);
        f = sjVar2;
        sj sjVar3 = new sj("CODE_39", 2);
        z = sjVar3;
        sj sjVar4 = new sj("CODE_93", 3);
        A = sjVar4;
        sj sjVar5 = new sj("CODE_128", 4);
        X = sjVar5;
        sj sjVar6 = new sj("DATA_MATRIX", 5);
        Y = sjVar6;
        sj sjVar7 = new sj("EAN_8", 6);
        Z = sjVar7;
        sj sjVar8 = new sj("EAN_13", 7);
        y0 = sjVar8;
        sj sjVar9 = new sj("ITF", 8);
        z0 = sjVar9;
        sj sjVar10 = new sj("MAXICODE", 9);
        A0 = sjVar10;
        sj sjVar11 = new sj("PDF_417", 10);
        B0 = sjVar11;
        sj sjVar12 = new sj("QR_CODE", 11);
        C0 = sjVar12;
        sj sjVar13 = new sj("RSS_14", 12);
        D0 = sjVar13;
        sj sjVar14 = new sj("RSS_EXPANDED", 13);
        E0 = sjVar14;
        sj sjVar15 = new sj("UPC_A", 14);
        F0 = sjVar15;
        sj sjVar16 = new sj("UPC_E", 15);
        G0 = sjVar16;
        sj sjVar17 = new sj("UPC_EAN_EXTENSION", 16);
        H0 = sjVar17;
        I0 = new sj[]{sjVar, sjVar2, sjVar3, sjVar4, sjVar5, sjVar6, sjVar7, sjVar8, sjVar9, sjVar10, sjVar11, sjVar12, sjVar13, sjVar14, sjVar15, sjVar16, sjVar17};
    }

    public static sj valueOf(String str) {
        return (sj) Enum.valueOf(sj.class, str);
    }

    public static sj[] values() {
        return (sj[]) I0.clone();
    }
}
