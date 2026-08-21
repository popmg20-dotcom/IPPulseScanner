package j$.util.stream;

import j$.util.Map;
import j$.util.Spliterator;
import java.util.EnumMap;
import java.util.Map;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'DISTINCT' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class w6 {
    public static final w6 DISTINCT;
    public static final w6 ORDERED;
    public static final w6 SHORT_CIRCUIT;
    public static final w6 SIZED;
    public static final w6 SORTED;
    public static final int f;
    public static final int g;
    public static final int h;
    public static final int i;
    public static final int j;
    public static final int k;
    public static final int l;
    public static final int m;
    public static final int n;
    public static final int o;
    public static final int p;
    public static final int q;
    public static final int r;
    public static final int s;
    public static final int t;
    public static final int u;
    public static final /* synthetic */ w6[] v;
    public final Map a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    static {
        v6 v6Var = v6.SPLITERATOR;
        j$.util.p pVarM = m(v6Var);
        v6 v6Var2 = v6.STREAM;
        pVarM.a(v6Var2);
        v6 v6Var3 = v6.OP;
        ((EnumMap) ((Map) pVarM.b)).put(v6Var3, 3);
        w6 w6Var = new w6("DISTINCT", 0, 0, pVarM);
        DISTINCT = w6Var;
        j$.util.p pVarM2 = m(v6Var);
        pVarM2.a(v6Var2);
        ((EnumMap) ((Map) pVarM2.b)).put(v6Var3, 3);
        w6 w6Var2 = new w6("SORTED", 1, 1, pVarM2);
        SORTED = w6Var2;
        j$.util.p pVarM3 = m(v6Var);
        pVarM3.a(v6Var2);
        ((EnumMap) ((Map) pVarM3.b)).put(v6Var3, 3);
        v6 v6Var4 = v6.TERMINAL_OP;
        ((EnumMap) ((Map) pVarM3.b)).put(v6Var4, 2);
        v6 v6Var5 = v6.UPSTREAM_TERMINAL_OP;
        ((EnumMap) ((Map) pVarM3.b)).put(v6Var5, 2);
        w6 w6Var3 = new w6("ORDERED", 2, 2, pVarM3);
        ORDERED = w6Var3;
        j$.util.p pVarM4 = m(v6Var);
        pVarM4.a(v6Var2);
        ((EnumMap) ((Map) pVarM4.b)).put(v6Var3, 2);
        w6 w6Var4 = new w6("SIZED", 3, 3, pVarM4);
        SIZED = w6Var4;
        j$.util.p pVarM5 = m(v6Var3);
        pVarM5.a(v6Var4);
        int i2 = 0;
        w6 w6Var5 = new w6("SHORT_CIRCUIT", 4, 12, pVarM5);
        SHORT_CIRCUIT = w6Var5;
        v = new w6[]{w6Var, w6Var2, w6Var3, w6Var4, w6Var5};
        f = i(v6Var);
        g = i(v6Var2);
        h = i(v6Var3);
        i(v6Var4);
        i(v6Var5);
        for (w6 w6Var6 : values()) {
            i2 |= w6Var6.e;
        }
        i = i2;
        int i3 = g;
        j = i3;
        int i4 = i3 << 1;
        k = i4;
        l = i3 | i4;
        w6 w6Var7 = DISTINCT;
        m = w6Var7.c;
        n = w6Var7.d;
        w6 w6Var8 = SORTED;
        o = w6Var8.c;
        p = w6Var8.d;
        w6 w6Var9 = ORDERED;
        q = w6Var9.c;
        r = w6Var9.d;
        w6 w6Var10 = SIZED;
        s = w6Var10.c;
        t = w6Var10.d;
        u = SHORT_CIRCUIT.c;
    }

    public w6(String str, int i2, int i3, j$.util.p pVar) {
        for (v6 v6Var : v6.values()) {
            Map.EL.b((java.util.Map) pVar.b, v6Var, 0);
        }
        this.a = (java.util.Map) pVar.b;
        int i4 = i3 * 2;
        this.b = i4;
        this.c = 1 << i4;
        this.d = 2 << i4;
        this.e = 3 << i4;
    }

    public static int h(int i2, int i3) {
        return i2 | (i3 & (i2 == 0 ? i : ~(((j & i2) << 1) | i2 | ((k & i2) >> 1))));
    }

    public static int i(v6 v6Var) {
        int iIntValue = 0;
        for (w6 w6Var : values()) {
            iIntValue |= ((Integer) ((EnumMap) w6Var.a).get(v6Var)).intValue() << w6Var.b;
        }
        return iIntValue;
    }

    public static int j(Spliterator spliterator) {
        int iCharacteristics = spliterator.characteristics();
        int i2 = iCharacteristics & 4;
        int i3 = f;
        return (i2 == 0 || spliterator.getComparator() == null) ? iCharacteristics & i3 : iCharacteristics & i3 & (-5);
    }

    public static j$.util.p m(v6 v6Var) {
        j$.util.p pVar = new j$.util.p(11, new EnumMap(v6.class));
        pVar.a(v6Var);
        return pVar;
    }

    public static w6 valueOf(String str) {
        return (w6) Enum.valueOf(w6.class, str);
    }

    public static w6[] values() {
        return (w6[]) v.clone();
    }

    public final boolean k(int i2) {
        return (i2 & this.e) == this.c;
    }
}
