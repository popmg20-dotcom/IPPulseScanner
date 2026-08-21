package defpackage;

import com.getsurfboard.backup.model.SettingValue;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF0' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class md1 {
    public static final md1[] A;
    public static final /* synthetic */ md1[] X;
    public static final md1 f;
    public static final md1 z;
    public final int b;

    /* JADX INFO: Fake field, exist only in values array */
    md1 EF0;

    static {
        i32 i32Var = i32.DOUBLE;
        md1 md1Var = new md1("DOUBLE", 0, 0, 1, i32Var);
        i32 i32Var2 = i32.FLOAT;
        md1 md1Var2 = new md1("FLOAT", 1, 1, 1, i32Var2);
        i32 i32Var3 = i32.LONG;
        md1 md1Var3 = new md1("INT64", 2, 2, 1, i32Var3);
        md1 md1Var4 = new md1("UINT64", 3, 3, 1, i32Var3);
        i32 i32Var4 = i32.INT;
        md1 md1Var5 = new md1("INT32", 4, 4, 1, i32Var4);
        md1 md1Var6 = new md1("FIXED64", 5, 5, 1, i32Var3);
        md1 md1Var7 = new md1("FIXED32", 6, 6, 1, i32Var4);
        i32 i32Var5 = i32.BOOLEAN;
        md1 md1Var8 = new md1("BOOL", 7, 7, 1, i32Var5);
        i32 i32Var6 = i32.STRING;
        md1 md1Var9 = new md1(SettingValue.TYPE_STRING, 8, 8, 1, i32Var6);
        i32 i32Var7 = i32.MESSAGE;
        md1 md1Var10 = new md1("MESSAGE", 9, 9, 1, i32Var7);
        i32 i32Var8 = i32.BYTE_STRING;
        md1 md1Var11 = new md1("BYTES", 10, 10, 1, i32Var8);
        md1 md1Var12 = new md1("UINT32", 11, 11, 1, i32Var4);
        i32 i32Var9 = i32.ENUM;
        md1 md1Var13 = new md1(SettingValue.TYPE_ENUM, 12, 12, 1, i32Var9);
        md1 md1Var14 = new md1("SFIXED32", 13, 13, 1, i32Var4);
        md1 md1Var15 = new md1("SFIXED64", 14, 14, 1, i32Var3);
        md1 md1Var16 = new md1("SINT32", 15, 15, 1, i32Var4);
        md1 md1Var17 = new md1("SINT64", 16, 16, 1, i32Var3);
        md1 md1Var18 = new md1("GROUP", 17, 17, 1, i32Var7);
        md1 md1Var19 = new md1("DOUBLE_LIST", 18, 18, 2, i32Var);
        md1 md1Var20 = new md1("FLOAT_LIST", 19, 19, 2, i32Var2);
        md1 md1Var21 = new md1("INT64_LIST", 20, 20, 2, i32Var3);
        md1 md1Var22 = new md1("UINT64_LIST", 21, 21, 2, i32Var3);
        md1 md1Var23 = new md1("INT32_LIST", 22, 22, 2, i32Var4);
        md1 md1Var24 = new md1("FIXED64_LIST", 23, 23, 2, i32Var3);
        md1 md1Var25 = new md1("FIXED32_LIST", 24, 24, 2, i32Var4);
        md1 md1Var26 = new md1("BOOL_LIST", 25, 25, 2, i32Var5);
        md1 md1Var27 = new md1("STRING_LIST", 26, 26, 2, i32Var6);
        md1 md1Var28 = new md1("MESSAGE_LIST", 27, 27, 2, i32Var7);
        md1 md1Var29 = new md1("BYTES_LIST", 28, 28, 2, i32Var8);
        md1 md1Var30 = new md1("UINT32_LIST", 29, 29, 2, i32Var4);
        md1 md1Var31 = new md1("ENUM_LIST", 30, 30, 2, i32Var9);
        md1 md1Var32 = new md1("SFIXED32_LIST", 31, 31, 2, i32Var4);
        md1 md1Var33 = new md1("SFIXED64_LIST", 32, 32, 2, i32Var3);
        md1 md1Var34 = new md1("SINT32_LIST", 33, 33, 2, i32Var4);
        md1 md1Var35 = new md1("SINT64_LIST", 34, 34, 2, i32Var3);
        md1 md1Var36 = new md1("DOUBLE_LIST_PACKED", 35, 35, 3, i32Var);
        f = md1Var36;
        md1 md1Var37 = new md1("FLOAT_LIST_PACKED", 36, 36, 3, i32Var2);
        md1 md1Var38 = new md1("INT64_LIST_PACKED", 37, 37, 3, i32Var3);
        md1 md1Var39 = new md1("UINT64_LIST_PACKED", 38, 38, 3, i32Var3);
        md1 md1Var40 = new md1("INT32_LIST_PACKED", 39, 39, 3, i32Var4);
        md1 md1Var41 = new md1("FIXED64_LIST_PACKED", 40, 40, 3, i32Var3);
        md1 md1Var42 = new md1("FIXED32_LIST_PACKED", 41, 41, 3, i32Var4);
        md1 md1Var43 = new md1("BOOL_LIST_PACKED", 42, 42, 3, i32Var5);
        md1 md1Var44 = new md1("UINT32_LIST_PACKED", 43, 43, 3, i32Var4);
        md1 md1Var45 = new md1("ENUM_LIST_PACKED", 44, 44, 3, i32Var9);
        md1 md1Var46 = new md1("SFIXED32_LIST_PACKED", 45, 45, 3, i32Var4);
        md1 md1Var47 = new md1("SFIXED64_LIST_PACKED", 46, 46, 3, i32Var3);
        md1 md1Var48 = new md1("SINT32_LIST_PACKED", 47, 47, 3, i32Var4);
        md1 md1Var49 = new md1("SINT64_LIST_PACKED", 48, 48, 3, i32Var3);
        z = md1Var49;
        X = new md1[]{md1Var, md1Var2, md1Var3, md1Var4, md1Var5, md1Var6, md1Var7, md1Var8, md1Var9, md1Var10, md1Var11, md1Var12, md1Var13, md1Var14, md1Var15, md1Var16, md1Var17, md1Var18, md1Var19, md1Var20, md1Var21, md1Var22, md1Var23, md1Var24, md1Var25, md1Var26, md1Var27, md1Var28, md1Var29, md1Var30, md1Var31, md1Var32, md1Var33, md1Var34, md1Var35, md1Var36, md1Var37, md1Var38, md1Var39, md1Var40, md1Var41, md1Var42, md1Var43, md1Var44, md1Var45, md1Var46, md1Var47, md1Var48, md1Var49, new md1("GROUP_LIST", 49, 49, 2, i32Var7), new md1("MAP", 50, 50, 4, i32.VOID)};
        md1[] md1VarArrValues = values();
        A = new md1[md1VarArrValues.length];
        for (md1 md1Var50 : md1VarArrValues) {
            A[md1Var50.b] = md1Var50;
        }
    }

    public md1(String str, int i, int i2, int i3, i32 i32Var) {
        this.b = i2;
        int iG = fw.G(i3);
        if (iG == 1 || iG == 3) {
            Class cls = i32Var.b;
        }
        if (i3 == 1) {
            i32Var.ordinal();
        }
    }

    public static md1 valueOf(String str) {
        return (md1) Enum.valueOf(md1.class, str);
    }

    public static md1[] values() {
        return (md1[]) X.clone();
    }
}
