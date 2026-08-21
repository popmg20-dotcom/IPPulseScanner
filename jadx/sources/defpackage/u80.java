package defpackage;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF265' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:343)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class u80 {
    public static final u80 A;
    public static final u80 X;
    public static final /* synthetic */ u80[] Y;
    public final int b;
    public final long f;
    public final String z;

    /* JADX INFO: Fake field, exist only in values array */
    u80 EF1;

    /* JADX INFO: Fake field, exist only in values array */
    u80 EF2;

    /* JADX INFO: Fake field, exist only in values array */
    u80 EF3;

    /* JADX INFO: Fake field, exist only in values array */
    u80 EF4;

    /* JADX INFO: Fake field, exist only in values array */
    u80 EF5;

    /* JADX INFO: Fake field, exist only in values array */
    u80 EF6;

    /* JADX INFO: Fake field, exist only in values array */
    u80 EF7;

    /* JADX INFO: Fake field, exist only in values array */
    u80 EF8;

    /* JADX INFO: Fake field, exist only in values array */
    u80 EF9;

    /* JADX INFO: Fake field, exist only in values array */
    u80 EF10;

    /* JADX INFO: Fake field, exist only in values array */
    u80 EF11;

    /* JADX INFO: Fake field, exist only in values array */
    u80 EF15;

    /* JADX INFO: Fake field, exist only in values array */
    u80 EF16;

    /* JADX INFO: Fake field, exist only in values array */
    u80 EF17;

    /* JADX INFO: Fake field, exist only in values array */
    u80 EF252;

    /* JADX INFO: Fake field, exist only in values array */
    u80 EF265;

    static {
        u80 u80Var = new u80(0, 0, 4289443517L, "Identifier");
        A = u80Var;
        u80 u80Var2 = new u80(1, 0, 4289443517L, "Text");
        u80 u80Var3 = new u80(2, 1, 4294226622L, "Method");
        u80 u80Var4 = new u80(3, 2, 4294226622L, "Function");
        u80 u80Var5 = new u80(4, 3, 4294226622L, "Constructor");
        u80 u80Var6 = new u80(5, 4, 4294035587L, "Field");
        u80 u80Var7 = new u80(6, 5, 4294035587L, "Variable");
        u80 u80Var8 = new u80(7, 6, 4286958821L, "Class");
        u80 u80Var9 = new u80(8, 7, 4288269191L, "Interface");
        u80 u80Var10 = new u80(9, 8, 4286958821L, "Module");
        u80 u80Var11 = new u80(10, 9, 4291738868L, "Property");
        u80 u80Var12 = new u80("Unit", 11, 10);
        u80 u80Var13 = new u80(12, 11, 4294035587L, "Value");
        u80 u80Var14 = new u80(13, 12, 4286958821L, "Enum");
        u80 u80Var15 = new u80(14, 13, 4291590194L, "Keyword");
        u80 u80Var16 = new u80("Snippet", 15, 14);
        X = u80Var16;
        int i = 17;
        int i2 = 18;
        int i3 = 19;
        int i4 = 26;
        Y = new u80[]{u80Var, u80Var2, u80Var3, u80Var4, u80Var5, u80Var6, u80Var7, u80Var8, u80Var9, u80Var10, u80Var11, u80Var12, u80Var13, u80Var14, u80Var15, u80Var16, new u80(16, 15, 4294226622L, "Color"), new u80("Reference", i, i), new u80("File", i2, 16), new u80("Folder", i3, i2), new u80("EnumMember", 20, i3), new u80(21, 20, 4294035587L, "Constant"), new u80(22, 21, 4291738868L, "Struct"), new u80("Event", 23, 22), new u80(24, 23, 4293569462L, "Operator"), new u80(25, 24, 4294035587L, "TypeParameter"), new u80("User", i4, 25), new u80("Issue", 27, i4)};
    }

    public u80(int i, int i2, long j, String str) {
        this.b = i2;
        this.f = j;
        this.z = String.valueOf(name().charAt(0));
    }

    public static u80 valueOf(String str) {
        return (u80) Enum.valueOf(u80.class, str);
    }

    public static u80[] values() {
        return (u80[]) Y.clone();
    }

    public /* synthetic */ u80(String str, int i, int i2) {
        this(i, i2, 0L, str);
    }
}
