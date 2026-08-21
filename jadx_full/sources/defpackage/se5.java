package defpackage;

import com.getsurfboard.backup.model.SettingValue;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF2' uses external variables
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
public final class se5 {
    public static final se5 A;
    public static final /* synthetic */ se5[] X;
    public static final se5 z;
    public final ue5 b;
    public final int f;

    /* JADX INFO: Fake field, exist only in values array */
    se5 EF0;

    /* JADX INFO: Fake field, exist only in values array */
    se5 EF1;

    /* JADX INFO: Fake field, exist only in values array */
    se5 EF2;

    static {
        se5 se5Var = new se5("DOUBLE", 0, ue5.A, 1);
        se5 se5Var2 = new se5("FLOAT", 1, ue5.z, 5);
        ue5 ue5Var = ue5.f;
        se5 se5Var3 = new se5("INT64", 2, ue5Var, 0);
        se5 se5Var4 = new se5("UINT64", 3, ue5Var, 0);
        ue5 ue5Var2 = ue5.b;
        se5 se5Var5 = new se5("INT32", 4, ue5Var2, 0);
        se5 se5Var6 = new se5("FIXED64", 5, ue5Var, 1);
        se5 se5Var7 = new se5("FIXED32", 6, ue5Var2, 5);
        se5 se5Var8 = new se5("BOOL", 7, ue5.X, 0);
        se5 se5Var9 = new se5(SettingValue.TYPE_STRING, 8, ue5.Y, 2);
        z = se5Var9;
        ue5 ue5Var3 = ue5.z0;
        se5 se5Var10 = new se5("GROUP", 9, ue5Var3, 3);
        A = se5Var10;
        X = new se5[]{se5Var, se5Var2, se5Var3, se5Var4, se5Var5, se5Var6, se5Var7, se5Var8, se5Var9, se5Var10, new se5("MESSAGE", 10, ue5Var3, 2), new se5("BYTES", 11, ue5.Z, 2), new se5("UINT32", 12, ue5Var2, 0), new se5(SettingValue.TYPE_ENUM, 13, ue5.y0, 0), new se5("SFIXED32", 14, ue5Var2, 5), new se5("SFIXED64", 15, ue5Var, 1), new se5("SINT32", 16, ue5Var2, 0), new se5("SINT64", 17, ue5Var, 0)};
    }

    public se5(String str, int i, ue5 ue5Var, int i2) {
        this.b = ue5Var;
        this.f = i2;
    }

    public static se5[] values() {
        return (se5[]) X.clone();
    }
}
