package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class qb4 {
    public static final qb4 b;
    public static final /* synthetic */ qb4[] f;

    /* JADX INFO: Fake field, exist only in values array */
    qb4 EF0;

    static {
        qb4 qb4Var = new qb4("REPORT_ALL", 0);
        qb4 qb4Var2 = new qb4("TEXT_GENERATOR", 1);
        qb4 qb4Var3 = new qb4("PRINT", 2);
        qb4 qb4Var4 = new qb4("PRINTER_PRINT_TO_STRING", 3);
        qb4 qb4Var5 = new qb4("TEXTFORMAT_PRINT_TO_STRING", 4);
        qb4 qb4Var6 = new qb4("PRINT_UNICODE", 5);
        qb4 qb4Var7 = new qb4("SHORT_DEBUG_STRING", 6);
        qb4 qb4Var8 = new qb4("LEGACY_MULTILINE", 7);
        qb4 qb4Var9 = new qb4("LEGACY_SINGLE_LINE", 8);
        qb4 qb4Var10 = new qb4("DEBUG_MULTILINE", 9);
        qb4 qb4Var11 = new qb4("DEBUG_SINGLE_LINE", 10);
        qb4 qb4Var12 = new qb4("ABSTRACT_TO_STRING", 11);
        b = qb4Var12;
        f = new qb4[]{qb4Var, qb4Var2, qb4Var3, qb4Var4, qb4Var5, qb4Var6, qb4Var7, qb4Var8, qb4Var9, qb4Var10, qb4Var11, qb4Var12, new qb4("ABSTRACT_BUILDER_TO_STRING", 12), new qb4("ABSTRACT_MUTABLE_TO_STRING", 13), new qb4("REPORT_NONE", 14)};
    }

    public static qb4 valueOf(String str) {
        return (qb4) Enum.valueOf(qb4.class, str);
    }

    public static qb4[] values() {
        return (qb4[]) f.clone();
    }
}
