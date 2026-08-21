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
public final class et0 {
    public static final et0 A;
    public static final et0 X;
    public static final et0 Y;
    public static final et0[] Z;
    public static final et0 f;
    public static final /* synthetic */ et0[] y0;
    public static final et0 z;
    public final ct0 b;

    /* JADX INFO: Fake field, exist only in values array */
    et0 EF0;

    /* JADX INFO: Fake field, exist only in values array */
    et0 EF1;

    /* JADX INFO: Fake field, exist only in values array */
    et0 EF2;

    static {
        et0 et0Var = new et0("DOUBLE", 0, ct0.DOUBLE);
        et0 et0Var2 = new et0("FLOAT", 1, ct0.FLOAT);
        ct0 ct0Var = ct0.LONG;
        et0 et0Var3 = new et0("INT64", 2, ct0Var);
        et0 et0Var4 = new et0("UINT64", 3, ct0Var);
        ct0 ct0Var2 = ct0.INT;
        et0 et0Var5 = new et0("INT32", 4, ct0Var2);
        et0 et0Var6 = new et0("FIXED64", 5, ct0Var);
        et0 et0Var7 = new et0("FIXED32", 6, ct0Var2);
        et0 et0Var8 = new et0("BOOL", 7, ct0.BOOLEAN);
        et0 et0Var9 = new et0(SettingValue.TYPE_STRING, 8, ct0.STRING);
        f = et0Var9;
        ct0 ct0Var3 = ct0.MESSAGE;
        et0 et0Var10 = new et0("GROUP", 9, ct0Var3);
        z = et0Var10;
        et0 et0Var11 = new et0("MESSAGE", 10, ct0Var3);
        A = et0Var11;
        et0 et0Var12 = new et0("BYTES", 11, ct0.BYTE_STRING);
        X = et0Var12;
        et0 et0Var13 = new et0("UINT32", 12, ct0Var2);
        et0 et0Var14 = new et0(SettingValue.TYPE_ENUM, 13, ct0.ENUM);
        Y = et0Var14;
        y0 = new et0[]{et0Var, et0Var2, et0Var3, et0Var4, et0Var5, et0Var6, et0Var7, et0Var8, et0Var9, et0Var10, et0Var11, et0Var12, et0Var13, et0Var14, new et0("SFIXED32", 14, ct0Var2), new et0("SFIXED64", 15, ct0Var), new et0("SINT32", 16, ct0Var2), new et0("SINT64", 17, ct0Var)};
        Z = values();
    }

    public et0(String str, int i, ct0 ct0Var) {
        this.b = ct0Var;
    }

    public static et0 valueOf(String str) {
        return (et0) Enum.valueOf(et0.class, str);
    }

    public static et0[] values() {
        return (et0[]) y0.clone();
    }
}
