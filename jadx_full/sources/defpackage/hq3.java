package defpackage;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class hq3 {
    public static final Class a;
    public static final em4 b;
    public static final em4 c;

    static {
        Class<?> cls;
        Class<?> cls2;
        v93 v93Var = v93.c;
        em4 em4Var = null;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        a = cls;
        try {
            v93 v93Var2 = v93.c;
            try {
                cls2 = Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
            } catch (Throwable unused2) {
                cls2 = null;
            }
            if (cls2 != null) {
                em4Var = (em4) cls2.getConstructor(null).newInstance(null);
            }
        } catch (Throwable unused3) {
        }
        b = em4Var;
        c = new em4();
    }

    public static int a(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iJ = 0;
        for (int i = 0; i < size; i++) {
            iJ += r60.j(((Integer) list.get(i)).intValue());
        }
        return iJ;
    }

    public static int b(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (r60.h(i) + 4) * size;
    }

    public static int c(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (r60.h(i) + 8) * size;
    }

    public static int d(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iJ = 0;
        for (int i = 0; i < size; i++) {
            iJ += r60.j(((Integer) list.get(i)).intValue());
        }
        return iJ;
    }

    public static int e(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iJ = 0;
        for (int i = 0; i < size; i++) {
            iJ += r60.j(((Long) list.get(i)).longValue());
        }
        return iJ;
    }

    public static int f(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            int iIntValue = ((Integer) list.get(i2)).intValue();
            i += r60.i((iIntValue >> 31) ^ (iIntValue << 1));
        }
        return i;
    }

    public static int g(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iJ = 0;
        for (int i = 0; i < size; i++) {
            long jLongValue = ((Long) list.get(i)).longValue();
            iJ += r60.j((jLongValue >> 63) ^ (jLongValue << 1));
        }
        return iJ;
    }

    public static int h(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += r60.i(((Integer) list.get(i2)).intValue());
        }
        return i;
    }

    public static int i(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iJ = 0;
        for (int i = 0; i < size; i++) {
            iJ += r60.j(((Long) list.get(i)).longValue());
        }
        return iJ;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void k(em4 em4Var, Object obj, Object obj2) {
        em4Var.getClass();
        co1 co1Var = (co1) obj;
        dm4 dm4Var = co1Var.unknownFields;
        dm4 dm4Var2 = ((co1) obj2).unknownFields;
        dm4 dm4Var3 = dm4.f;
        if (!dm4Var3.equals(dm4Var2)) {
            if (dm4Var3.equals(dm4Var)) {
                int i = dm4Var.a + dm4Var2.a;
                int[] iArrCopyOf = Arrays.copyOf(dm4Var.b, i);
                System.arraycopy(dm4Var2.b, 0, iArrCopyOf, dm4Var.a, dm4Var2.a);
                Object[] objArrCopyOf = Arrays.copyOf(dm4Var.c, i);
                System.arraycopy(dm4Var2.c, 0, objArrCopyOf, dm4Var.a, dm4Var2.a);
                dm4Var = new dm4(i, iArrCopyOf, objArrCopyOf, true);
            } else {
                dm4Var.getClass();
                if (!dm4Var2.equals(dm4Var3)) {
                    if (!dm4Var.e) {
                        vp1.q();
                        return;
                    }
                    int i2 = dm4Var.a + dm4Var2.a;
                    dm4Var.a(i2);
                    System.arraycopy(dm4Var2.b, 0, dm4Var.b, dm4Var.a, dm4Var2.a);
                    System.arraycopy(dm4Var2.c, 0, dm4Var.c, dm4Var.a, dm4Var2.a);
                    dm4Var.a = i2;
                }
            }
        }
        co1Var.unknownFields = dm4Var;
    }

    public static boolean l(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void m(int i, List list, zf2 zf2Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r60 r60Var = (r60) zf2Var.f;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                r60Var.o(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        r60Var.B(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).getClass();
            i3++;
        }
        r60Var.D(i3);
        while (i2 < list.size()) {
            r60Var.m(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    public static void n(int i, List list, zf2 zf2Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r60 r60Var = (r60) zf2Var.f;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                r60Var.t(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        r60Var.B(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).getClass();
            i3 += 8;
        }
        r60Var.D(i3);
        while (i2 < list.size()) {
            r60Var.u(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    public static void o(int i, List list, zf2 zf2Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r60 r60Var = (r60) zf2Var.f;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                r60Var.v(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        r60Var.B(i, 2);
        int iJ = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iJ += r60.j(((Integer) list.get(i3)).intValue());
        }
        r60Var.D(iJ);
        while (i2 < list.size()) {
            r60Var.w(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void p(int i, List list, zf2 zf2Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r60 r60Var = (r60) zf2Var.f;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                r60Var.r(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        r60Var.B(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).getClass();
            i3 += 4;
        }
        r60Var.D(i3);
        while (i2 < list.size()) {
            r60Var.s(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void q(int i, List list, zf2 zf2Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r60 r60Var = (r60) zf2Var.f;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                r60Var.t(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        r60Var.B(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            i3 += 8;
        }
        r60Var.D(i3);
        while (i2 < list.size()) {
            r60Var.u(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void r(int i, List list, zf2 zf2Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r60 r60Var = (r60) zf2Var.f;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                r60Var.r(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        r60Var.B(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Float) list.get(i4)).getClass();
            i3 += 4;
        }
        r60Var.D(i3);
        while (i2 < list.size()) {
            r60Var.s(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
            i2++;
        }
    }

    public static void s(int i, List list, zf2 zf2Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r60 r60Var = (r60) zf2Var.f;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                r60Var.v(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        r60Var.B(i, 2);
        int iJ = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iJ += r60.j(((Integer) list.get(i3)).intValue());
        }
        r60Var.D(iJ);
        while (i2 < list.size()) {
            r60Var.w(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void t(int i, List list, zf2 zf2Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r60 r60Var = (r60) zf2Var.f;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                r60Var.E(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        r60Var.B(i, 2);
        int iJ = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iJ += r60.j(((Long) list.get(i3)).longValue());
        }
        r60Var.D(iJ);
        while (i2 < list.size()) {
            r60Var.F(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void u(int i, List list, zf2 zf2Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r60 r60Var = (r60) zf2Var.f;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                r60Var.r(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        r60Var.B(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).getClass();
            i3 += 4;
        }
        r60Var.D(i3);
        while (i2 < list.size()) {
            r60Var.s(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void v(int i, List list, zf2 zf2Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r60 r60Var = (r60) zf2Var.f;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                r60Var.t(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        r60Var.B(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            i3 += 8;
        }
        r60Var.D(i3);
        while (i2 < list.size()) {
            r60Var.u(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void w(int i, List list, zf2 zf2Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r60 r60Var = (r60) zf2Var.f;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                int iIntValue = ((Integer) list.get(i2)).intValue();
                r60Var.C(i, (iIntValue >> 31) ^ (iIntValue << 1));
                i2++;
            }
            return;
        }
        r60Var.B(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            int iIntValue2 = ((Integer) list.get(i4)).intValue();
            i3 += r60.i((iIntValue2 >> 31) ^ (iIntValue2 << 1));
        }
        r60Var.D(i3);
        while (i2 < list.size()) {
            int iIntValue3 = ((Integer) list.get(i2)).intValue();
            r60Var.D((iIntValue3 >> 31) ^ (iIntValue3 << 1));
            i2++;
        }
    }

    public static void x(int i, List list, zf2 zf2Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r60 r60Var = (r60) zf2Var.f;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                long jLongValue = ((Long) list.get(i2)).longValue();
                r60Var.E(i, (jLongValue >> 63) ^ (jLongValue << 1));
                i2++;
            }
            return;
        }
        r60Var.B(i, 2);
        int iJ = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            long jLongValue2 = ((Long) list.get(i3)).longValue();
            iJ += r60.j((jLongValue2 >> 63) ^ (jLongValue2 << 1));
        }
        r60Var.D(iJ);
        while (i2 < list.size()) {
            long jLongValue3 = ((Long) list.get(i2)).longValue();
            r60Var.F((jLongValue3 >> 63) ^ (jLongValue3 << 1));
            i2++;
        }
    }

    public static void y(int i, List list, zf2 zf2Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r60 r60Var = (r60) zf2Var.f;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                r60Var.C(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        r60Var.B(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += r60.i(((Integer) list.get(i4)).intValue());
        }
        r60Var.D(i3);
        while (i2 < list.size()) {
            r60Var.D(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public static void z(int i, List list, zf2 zf2Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r60 r60Var = (r60) zf2Var.f;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                r60Var.E(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        r60Var.B(i, 2);
        int iJ = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iJ += r60.j(((Long) list.get(i3)).longValue());
        }
        r60Var.D(iJ);
        while (i2 < list.size()) {
            r60Var.F(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static Object j(Object obj, int i, h12 h12Var, Object obj2, em4 em4Var) {
        return obj2;
    }
}
