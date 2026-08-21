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
public final class wb5 {
    public static final wb5[] A;
    public static final /* synthetic */ wb5[] X;
    public static final wb5 f;
    public static final wb5 z;
    public final int b;

    /* JADX INFO: Fake field, exist only in values array */
    wb5 EF0;

    static {
        qc5 qc5Var = qc5.Y;
        wb5 wb5Var = new wb5("DOUBLE", 0, 0, 1, qc5Var);
        qc5 qc5Var2 = qc5.X;
        wb5 wb5Var2 = new wb5("FLOAT", 1, 1, 1, qc5Var2);
        qc5 qc5Var3 = qc5.A;
        wb5 wb5Var3 = new wb5("INT64", 2, 2, 1, qc5Var3);
        wb5 wb5Var4 = new wb5("UINT64", 3, 3, 1, qc5Var3);
        qc5 qc5Var4 = qc5.z;
        wb5 wb5Var5 = new wb5("INT32", 4, 4, 1, qc5Var4);
        wb5 wb5Var6 = new wb5("FIXED64", 5, 5, 1, qc5Var3);
        wb5 wb5Var7 = new wb5("FIXED32", 6, 6, 1, qc5Var4);
        qc5 qc5Var5 = qc5.Z;
        wb5 wb5Var8 = new wb5("BOOL", 7, 7, 1, qc5Var5);
        qc5 qc5Var6 = qc5.y0;
        wb5 wb5Var9 = new wb5(SettingValue.TYPE_STRING, 8, 8, 1, qc5Var6);
        qc5 qc5Var7 = qc5.B0;
        wb5 wb5Var10 = new wb5("MESSAGE", 9, 9, 1, qc5Var7);
        qc5 qc5Var8 = qc5.z0;
        wb5 wb5Var11 = new wb5("BYTES", 10, 10, 1, qc5Var8);
        wb5 wb5Var12 = new wb5("UINT32", 11, 11, 1, qc5Var4);
        qc5 qc5Var9 = qc5.A0;
        wb5 wb5Var13 = new wb5(SettingValue.TYPE_ENUM, 12, 12, 1, qc5Var9);
        wb5 wb5Var14 = new wb5("SFIXED32", 13, 13, 1, qc5Var4);
        wb5 wb5Var15 = new wb5("SFIXED64", 14, 14, 1, qc5Var3);
        wb5 wb5Var16 = new wb5("SINT32", 15, 15, 1, qc5Var4);
        wb5 wb5Var17 = new wb5("SINT64", 16, 16, 1, qc5Var3);
        wb5 wb5Var18 = new wb5("GROUP", 17, 17, 1, qc5Var7);
        wb5 wb5Var19 = new wb5("DOUBLE_LIST", 18, 18, 2, qc5Var);
        wb5 wb5Var20 = new wb5("FLOAT_LIST", 19, 19, 2, qc5Var2);
        wb5 wb5Var21 = new wb5("INT64_LIST", 20, 20, 2, qc5Var3);
        wb5 wb5Var22 = new wb5("UINT64_LIST", 21, 21, 2, qc5Var3);
        wb5 wb5Var23 = new wb5("INT32_LIST", 22, 22, 2, qc5Var4);
        wb5 wb5Var24 = new wb5("FIXED64_LIST", 23, 23, 2, qc5Var3);
        wb5 wb5Var25 = new wb5("FIXED32_LIST", 24, 24, 2, qc5Var4);
        wb5 wb5Var26 = new wb5("BOOL_LIST", 25, 25, 2, qc5Var5);
        wb5 wb5Var27 = new wb5("STRING_LIST", 26, 26, 2, qc5Var6);
        wb5 wb5Var28 = new wb5("MESSAGE_LIST", 27, 27, 2, qc5Var7);
        wb5 wb5Var29 = new wb5("BYTES_LIST", 28, 28, 2, qc5Var8);
        wb5 wb5Var30 = new wb5("UINT32_LIST", 29, 29, 2, qc5Var4);
        wb5 wb5Var31 = new wb5("ENUM_LIST", 30, 30, 2, qc5Var9);
        wb5 wb5Var32 = new wb5("SFIXED32_LIST", 31, 31, 2, qc5Var4);
        wb5 wb5Var33 = new wb5("SFIXED64_LIST", 32, 32, 2, qc5Var3);
        wb5 wb5Var34 = new wb5("SINT32_LIST", 33, 33, 2, qc5Var4);
        wb5 wb5Var35 = new wb5("SINT64_LIST", 34, 34, 2, qc5Var3);
        wb5 wb5Var36 = new wb5("DOUBLE_LIST_PACKED", 35, 35, 3, qc5Var);
        f = wb5Var36;
        wb5 wb5Var37 = new wb5("FLOAT_LIST_PACKED", 36, 36, 3, qc5Var2);
        wb5 wb5Var38 = new wb5("INT64_LIST_PACKED", 37, 37, 3, qc5Var3);
        wb5 wb5Var39 = new wb5("UINT64_LIST_PACKED", 38, 38, 3, qc5Var3);
        wb5 wb5Var40 = new wb5("INT32_LIST_PACKED", 39, 39, 3, qc5Var4);
        wb5 wb5Var41 = new wb5("FIXED64_LIST_PACKED", 40, 40, 3, qc5Var3);
        wb5 wb5Var42 = new wb5("FIXED32_LIST_PACKED", 41, 41, 3, qc5Var4);
        wb5 wb5Var43 = new wb5("BOOL_LIST_PACKED", 42, 42, 3, qc5Var5);
        wb5 wb5Var44 = new wb5("UINT32_LIST_PACKED", 43, 43, 3, qc5Var4);
        wb5 wb5Var45 = new wb5("ENUM_LIST_PACKED", 44, 44, 3, qc5Var9);
        wb5 wb5Var46 = new wb5("SFIXED32_LIST_PACKED", 45, 45, 3, qc5Var4);
        wb5 wb5Var47 = new wb5("SFIXED64_LIST_PACKED", 46, 46, 3, qc5Var3);
        wb5 wb5Var48 = new wb5("SINT32_LIST_PACKED", 47, 47, 3, qc5Var4);
        wb5 wb5Var49 = new wb5("SINT64_LIST_PACKED", 48, 48, 3, qc5Var3);
        z = wb5Var49;
        X = new wb5[]{wb5Var, wb5Var2, wb5Var3, wb5Var4, wb5Var5, wb5Var6, wb5Var7, wb5Var8, wb5Var9, wb5Var10, wb5Var11, wb5Var12, wb5Var13, wb5Var14, wb5Var15, wb5Var16, wb5Var17, wb5Var18, wb5Var19, wb5Var20, wb5Var21, wb5Var22, wb5Var23, wb5Var24, wb5Var25, wb5Var26, wb5Var27, wb5Var28, wb5Var29, wb5Var30, wb5Var31, wb5Var32, wb5Var33, wb5Var34, wb5Var35, wb5Var36, wb5Var37, wb5Var38, wb5Var39, wb5Var40, wb5Var41, wb5Var42, wb5Var43, wb5Var44, wb5Var45, wb5Var46, wb5Var47, wb5Var48, wb5Var49, new wb5("GROUP_LIST", 49, 49, 2, qc5Var7), new wb5("MAP", 50, 50, 4, qc5.f)};
        wb5[] wb5VarArrValues = values();
        A = new wb5[wb5VarArrValues.length];
        for (wb5 wb5Var50 : wb5VarArrValues) {
            A[wb5Var50.b] = wb5Var50;
        }
    }

    public wb5(String str, int i, int i2, int i3, qc5 qc5Var) {
        this.b = i2;
        int i4 = i3 - 1;
        if (i4 == 1 || i4 == 3) {
            Class cls = qc5Var.b;
        }
        if (i3 == 1) {
            qc5 qc5Var2 = qc5.f;
            qc5Var.ordinal();
        }
    }

    public static wb5[] values() {
        return (wb5[]) X.clone();
    }
}
