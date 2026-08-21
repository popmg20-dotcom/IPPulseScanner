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
public class bw4 {
    public static final vv4 A;
    public static final xv4 X;
    public static final /* synthetic */ bw4[] Y;
    public static final tv4 z;
    public final dw4 b;
    public final int f;

    /* JADX INFO: Fake field, exist only in values array */
    bw4 EF0;

    /* JADX INFO: Fake field, exist only in values array */
    bw4 EF1;

    /* JADX INFO: Fake field, exist only in values array */
    bw4 EF2;

    static {
        bw4 bw4Var = new bw4("DOUBLE", 0, dw4.DOUBLE, 1);
        bw4 bw4Var2 = new bw4("FLOAT", 1, dw4.FLOAT, 5);
        dw4 dw4Var = dw4.LONG;
        bw4 bw4Var3 = new bw4("INT64", 2, dw4Var, 0);
        bw4 bw4Var4 = new bw4("UINT64", 3, dw4Var, 0);
        dw4 dw4Var2 = dw4.INT;
        bw4 bw4Var5 = new bw4("INT32", 4, dw4Var2, 0);
        bw4 bw4Var6 = new bw4("FIXED64", 5, dw4Var, 1);
        bw4 bw4Var7 = new bw4("FIXED32", 6, dw4Var2, 5);
        bw4 bw4Var8 = new bw4("BOOL", 7, dw4.BOOLEAN, 0);
        tv4 tv4Var = new tv4(SettingValue.TYPE_STRING, 8, dw4.STRING, 2);
        z = tv4Var;
        dw4 dw4Var3 = dw4.MESSAGE;
        vv4 vv4Var = new vv4("GROUP", 9, dw4Var3, 3);
        A = vv4Var;
        xv4 xv4Var = new xv4("MESSAGE", 10, dw4Var3, 2);
        X = xv4Var;
        Y = new bw4[]{bw4Var, bw4Var2, bw4Var3, bw4Var4, bw4Var5, bw4Var6, bw4Var7, bw4Var8, tv4Var, vv4Var, xv4Var, new zv4("BYTES", 11, dw4.BYTE_STRING, 2), new bw4("UINT32", 12, dw4Var2, 0), new bw4(SettingValue.TYPE_ENUM, 13, dw4.ENUM, 0), new bw4("SFIXED32", 14, dw4Var2, 5), new bw4("SFIXED64", 15, dw4Var, 1), new bw4("SINT32", 16, dw4Var2, 0), new bw4("SINT64", 17, dw4Var, 0)};
    }

    public bw4(String str, int i, dw4 dw4Var, int i2) {
        this.b = dw4Var;
        this.f = i2;
    }

    public static bw4 valueOf(String str) {
        return (bw4) Enum.valueOf(bw4.class, str);
    }

    public static bw4[] values() {
        return (bw4[]) Y.clone();
    }
}
