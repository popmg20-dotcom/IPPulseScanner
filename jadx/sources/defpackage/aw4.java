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
public class aw4 {
    public static final wv4 A;
    public static final aw4 X;
    public static final aw4 Y;
    public static final /* synthetic */ aw4[] Z;
    public static final uv4 z;
    public final cw4 b;
    public final int f;

    /* JADX INFO: Fake field, exist only in values array */
    aw4 EF0;

    /* JADX INFO: Fake field, exist only in values array */
    aw4 EF1;

    /* JADX INFO: Fake field, exist only in values array */
    aw4 EF2;

    static {
        aw4 aw4Var = new aw4("DOUBLE", 0, cw4.DOUBLE, 1);
        aw4 aw4Var2 = new aw4("FLOAT", 1, cw4.FLOAT, 5);
        cw4 cw4Var = cw4.LONG;
        aw4 aw4Var3 = new aw4("INT64", 2, cw4Var, 0);
        aw4 aw4Var4 = new aw4("UINT64", 3, cw4Var, 0);
        cw4 cw4Var2 = cw4.INT;
        aw4 aw4Var5 = new aw4("INT32", 4, cw4Var2, 0);
        aw4 aw4Var6 = new aw4("FIXED64", 5, cw4Var, 1);
        aw4 aw4Var7 = new aw4("FIXED32", 6, cw4Var2, 5);
        aw4 aw4Var8 = new aw4("BOOL", 7, cw4.BOOLEAN, 0);
        sv4 sv4Var = new sv4(SettingValue.TYPE_STRING, 8, cw4.STRING, 2);
        cw4 cw4Var3 = cw4.MESSAGE;
        uv4 uv4Var = new uv4("GROUP", 9, cw4Var3, 3);
        z = uv4Var;
        wv4 wv4Var = new wv4("MESSAGE", 10, cw4Var3, 2);
        A = wv4Var;
        yv4 yv4Var = new yv4("BYTES", 11, cw4.BYTE_STRING, 2);
        aw4 aw4Var9 = new aw4("UINT32", 12, cw4Var2, 0);
        X = aw4Var9;
        aw4 aw4Var10 = new aw4(SettingValue.TYPE_ENUM, 13, cw4.ENUM, 0);
        Y = aw4Var10;
        Z = new aw4[]{aw4Var, aw4Var2, aw4Var3, aw4Var4, aw4Var5, aw4Var6, aw4Var7, aw4Var8, sv4Var, uv4Var, wv4Var, yv4Var, aw4Var9, aw4Var10, new aw4("SFIXED32", 14, cw4Var2, 5), new aw4("SFIXED64", 15, cw4Var, 1), new aw4("SINT32", 16, cw4Var2, 0), new aw4("SINT64", 17, cw4Var, 0)};
    }

    public aw4(String str, int i, cw4 cw4Var, int i2) {
        this.b = cw4Var;
        this.f = i2;
    }

    public static aw4 valueOf(String str) {
        return (aw4) Enum.valueOf(aw4.class, str);
    }

    public static aw4[] values() {
        return (aw4[]) Z.clone();
    }

    public boolean a() {
        return !(this instanceof sv4);
    }
}
