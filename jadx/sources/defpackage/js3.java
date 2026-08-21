package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'z' uses external variables
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
public final class js3 {
    public static final js3 A;
    public static final js3 A0;
    public static final js3 B0;
    public static final js3 C0;
    public static final js3 D0;
    public static final js3 E0;
    public static final js3 F0;
    public static final js3 G0;
    public static final js3 H0;
    public static final js3 I0;
    public static final /* synthetic */ js3[] J0;
    public static final js3 X;
    public static final js3 Y;
    public static final js3 Z;
    public static final js3 y0;
    public static final js3 z;
    public static final js3 z0;
    public final Function2 b;
    public final is3 f;

    static {
        dt dtVar = new dt(10);
        is3 is3Var = is3.b;
        js3 js3Var = new js3("UP", 0, dtVar, is3Var);
        z = js3Var;
        dt dtVar2 = new dt(23);
        is3 is3Var2 = is3.f;
        js3 js3Var2 = new js3("DOWN", 1, dtVar2, is3Var2);
        A = js3Var2;
        js3 js3Var3 = new js3("LEFT", 2, new dt(24), is3Var);
        X = js3Var3;
        js3 js3Var4 = new js3("RIGHT", 3, new dt(25), is3Var2);
        Y = js3Var4;
        js3 js3Var5 = new js3("PREVIOUS_WORD_BOUNDARY", 4, new dt(11));
        Z = js3Var5;
        js3 js3Var6 = new js3("NEXT_WORD_BOUNDARY", 5, new dt(12));
        y0 = js3Var6;
        js3 js3Var7 = new js3("PAGE_UP", 6, new dt(13));
        z0 = js3Var7;
        js3 js3Var8 = new js3("PAGE_DOWN", 7, new dt(14));
        A0 = js3Var8;
        js3 js3Var9 = new js3("PAGE_TOP", 8, new dt(15));
        B0 = js3Var9;
        js3 js3Var10 = new js3("PAGE_BOTTOM", 9, new dt(16));
        C0 = js3Var10;
        js3 js3Var11 = new js3("LINE_START", 10, new dt(17));
        D0 = js3Var11;
        js3 js3Var12 = new js3("LINE_END", 11, new dt(18));
        E0 = js3Var12;
        js3 js3Var13 = new js3("TEXT_START", 12, new dt(19));
        F0 = js3Var13;
        js3 js3Var14 = new js3("TEXT_END", 13, new dt(20));
        G0 = js3Var14;
        js3 js3Var15 = new js3("ROW_START", 14, new dt(21));
        H0 = js3Var15;
        js3 js3Var16 = new js3("ROW_END", 15, new dt(22));
        I0 = js3Var16;
        J0 = new js3[]{js3Var, js3Var2, js3Var3, js3Var4, js3Var5, js3Var6, js3Var7, js3Var8, js3Var9, js3Var10, js3Var11, js3Var12, js3Var13, js3Var14, js3Var15, js3Var16};
    }

    public js3(String str, int i, Function2 function2, is3 is3Var) {
        this.b = function2;
        this.f = is3Var;
    }

    public static js3 valueOf(String str) {
        return (js3) Enum.valueOf(js3.class, str);
    }

    public static js3[] values() {
        return (js3[]) J0.clone();
    }

    public /* synthetic */ js3(String str, int i, Function2 function2) {
        this(str, i, function2, is3.z);
    }
}
