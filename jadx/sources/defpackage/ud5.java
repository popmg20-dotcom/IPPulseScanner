package defpackage;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ud5 {
    public static final q84 a;

    static {
        od5 od5Var = od5.c;
        a = new q84(26);
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
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
    public static void b(Object obj, Object obj2) {
        dc5 dc5Var = (dc5) obj;
        fe5 fe5Var = dc5Var.zzc;
        fe5 fe5Var2 = ((dc5) obj2).zzc;
        fe5 fe5Var3 = fe5.f;
        if (!fe5Var3.equals(fe5Var2)) {
            if (fe5Var3.equals(fe5Var)) {
                int i = fe5Var.a + fe5Var2.a;
                int[] iArrCopyOf = Arrays.copyOf(fe5Var.b, i);
                System.arraycopy(fe5Var2.b, 0, iArrCopyOf, fe5Var.a, fe5Var2.a);
                Object[] objArrCopyOf = Arrays.copyOf(fe5Var.c, i);
                System.arraycopy(fe5Var2.c, 0, objArrCopyOf, fe5Var.a, fe5Var2.a);
                fe5Var = new fe5(i, iArrCopyOf, objArrCopyOf, true);
            } else {
                fe5Var.getClass();
                if (!fe5Var2.equals(fe5Var3)) {
                    if (!fe5Var.e) {
                        vp1.q();
                        return;
                    }
                    int i2 = fe5Var.a + fe5Var2.a;
                    fe5Var.e(i2);
                    System.arraycopy(fe5Var2.b, 0, fe5Var.b, fe5Var.a, fe5Var2.a);
                    System.arraycopy(fe5Var2.c, 0, fe5Var.c, fe5Var.a, fe5Var2.a);
                    fe5Var.a = i2;
                }
            }
        }
        dc5Var.zzc = fe5Var;
    }

    public static void c(int i, List list, ub4 ub4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kb5 kb5Var = (kb5) ub4Var.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                kb5Var.h(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        kb5Var.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).getClass();
            i3 += 8;
        }
        kb5Var.l(i3);
        while (i2 < list.size()) {
            kb5Var.o(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    public static void d(int i, List list, ub4 ub4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kb5 kb5Var = (kb5) ub4Var.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                kb5Var.f(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        kb5Var.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Float) list.get(i4)).getClass();
            i3 += 4;
        }
        kb5Var.l(i3);
        while (i2 < list.size()) {
            kb5Var.m(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
            i2++;
        }
    }

    public static void e(int i, List list, ub4 ub4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kb5 kb5Var = (kb5) ub4Var.b;
        int i2 = 0;
        if (!(list instanceof wc5)) {
            if (!z) {
                while (i2 < list.size()) {
                    kb5Var.g(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            kb5Var.c(i, 2);
            int iA = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iA += kb5.a(((Long) list.get(i3)).longValue());
            }
            kb5Var.l(iA);
            while (i2 < list.size()) {
                kb5Var.n(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        wc5 wc5Var = (wc5) list;
        if (!z) {
            while (i2 < wc5Var.z) {
                kb5Var.g(i, wc5Var.b(i2));
                i2++;
            }
            return;
        }
        kb5Var.c(i, 2);
        int iA2 = 0;
        for (int i4 = 0; i4 < wc5Var.z; i4++) {
            iA2 += kb5.a(wc5Var.b(i4));
        }
        kb5Var.l(iA2);
        while (i2 < wc5Var.z) {
            kb5Var.n(wc5Var.b(i2));
            i2++;
        }
    }

    public static void f(int i, List list, ub4 ub4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kb5 kb5Var = (kb5) ub4Var.b;
        int i2 = 0;
        if (!(list instanceof wc5)) {
            if (!z) {
                while (i2 < list.size()) {
                    kb5Var.g(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            kb5Var.c(i, 2);
            int iA = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iA += kb5.a(((Long) list.get(i3)).longValue());
            }
            kb5Var.l(iA);
            while (i2 < list.size()) {
                kb5Var.n(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        wc5 wc5Var = (wc5) list;
        if (!z) {
            while (i2 < wc5Var.z) {
                kb5Var.g(i, wc5Var.b(i2));
                i2++;
            }
            return;
        }
        kb5Var.c(i, 2);
        int iA2 = 0;
        for (int i4 = 0; i4 < wc5Var.z; i4++) {
            iA2 += kb5.a(wc5Var.b(i4));
        }
        kb5Var.l(iA2);
        while (i2 < wc5Var.z) {
            kb5Var.n(wc5Var.b(i2));
            i2++;
        }
    }

    public static void g(int i, List list, ub4 ub4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kb5 kb5Var = (kb5) ub4Var.b;
        int i2 = 0;
        if (!(list instanceof wc5)) {
            if (!z) {
                while (i2 < list.size()) {
                    long jLongValue = ((Long) list.get(i2)).longValue();
                    kb5Var.g(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                    i2++;
                }
                return;
            }
            kb5Var.c(i, 2);
            int iA = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                long jLongValue2 = ((Long) list.get(i3)).longValue();
                iA += kb5.a((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
            }
            kb5Var.l(iA);
            while (i2 < list.size()) {
                long jLongValue3 = ((Long) list.get(i2)).longValue();
                kb5Var.n((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
                i2++;
            }
            return;
        }
        wc5 wc5Var = (wc5) list;
        if (!z) {
            while (i2 < wc5Var.z) {
                long jB = wc5Var.b(i2);
                kb5Var.g(i, (jB >> 63) ^ (jB + jB));
                i2++;
            }
            return;
        }
        kb5Var.c(i, 2);
        int iA2 = 0;
        for (int i4 = 0; i4 < wc5Var.z; i4++) {
            long jB2 = wc5Var.b(i4);
            iA2 += kb5.a((jB2 >> 63) ^ (jB2 + jB2));
        }
        kb5Var.l(iA2);
        while (i2 < wc5Var.z) {
            long jB3 = wc5Var.b(i2);
            kb5Var.n((jB3 >> 63) ^ (jB3 + jB3));
            i2++;
        }
    }

    public static void h(int i, List list, ub4 ub4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kb5 kb5Var = (kb5) ub4Var.b;
        int i2 = 0;
        if (!(list instanceof wc5)) {
            if (!z) {
                while (i2 < list.size()) {
                    kb5Var.h(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            kb5Var.c(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).getClass();
                i3 += 8;
            }
            kb5Var.l(i3);
            while (i2 < list.size()) {
                kb5Var.o(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        wc5 wc5Var = (wc5) list;
        if (!z) {
            while (i2 < wc5Var.z) {
                kb5Var.h(i, wc5Var.b(i2));
                i2++;
            }
            return;
        }
        kb5Var.c(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < wc5Var.z; i6++) {
            wc5Var.b(i6);
            i5 += 8;
        }
        kb5Var.l(i5);
        while (i2 < wc5Var.z) {
            kb5Var.o(wc5Var.b(i2));
            i2++;
        }
    }

    public static void i(int i, List list, ub4 ub4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kb5 kb5Var = (kb5) ub4Var.b;
        int i2 = 0;
        if (!(list instanceof wc5)) {
            if (!z) {
                while (i2 < list.size()) {
                    kb5Var.h(i, ((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            kb5Var.c(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Long) list.get(i4)).getClass();
                i3 += 8;
            }
            kb5Var.l(i3);
            while (i2 < list.size()) {
                kb5Var.o(((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        wc5 wc5Var = (wc5) list;
        if (!z) {
            while (i2 < wc5Var.z) {
                kb5Var.h(i, wc5Var.b(i2));
                i2++;
            }
            return;
        }
        kb5Var.c(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < wc5Var.z; i6++) {
            wc5Var.b(i6);
            i5 += 8;
        }
        kb5Var.l(i5);
        while (i2 < wc5Var.z) {
            kb5Var.o(wc5Var.b(i2));
            i2++;
        }
    }

    public static void j(int i, List list, ub4 ub4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kb5 kb5Var = (kb5) ub4Var.b;
        int i2 = 0;
        if (!(list instanceof fc5)) {
            if (!z) {
                while (i2 < list.size()) {
                    kb5Var.d(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            kb5Var.c(i, 2);
            int iA = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iA += kb5.a(((Integer) list.get(i3)).intValue());
            }
            kb5Var.l(iA);
            while (i2 < list.size()) {
                kb5Var.k(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        fc5 fc5Var = (fc5) list;
        if (!z) {
            while (i2 < fc5Var.z) {
                kb5Var.d(i, fc5Var.c(i2));
                i2++;
            }
            return;
        }
        kb5Var.c(i, 2);
        int iA2 = 0;
        for (int i4 = 0; i4 < fc5Var.z; i4++) {
            iA2 += kb5.a(fc5Var.c(i4));
        }
        kb5Var.l(iA2);
        while (i2 < fc5Var.z) {
            kb5Var.k(fc5Var.c(i2));
            i2++;
        }
    }

    public static void k(int i, List list, ub4 ub4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kb5 kb5Var = (kb5) ub4Var.b;
        int i2 = 0;
        if (!(list instanceof fc5)) {
            if (!z) {
                while (i2 < list.size()) {
                    kb5Var.e(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            kb5Var.c(i, 2);
            int iR = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iR += kb5.r(((Integer) list.get(i3)).intValue());
            }
            kb5Var.l(iR);
            while (i2 < list.size()) {
                kb5Var.l(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        fc5 fc5Var = (fc5) list;
        if (!z) {
            while (i2 < fc5Var.z) {
                kb5Var.e(i, fc5Var.c(i2));
                i2++;
            }
            return;
        }
        kb5Var.c(i, 2);
        int iR2 = 0;
        for (int i4 = 0; i4 < fc5Var.z; i4++) {
            iR2 += kb5.r(fc5Var.c(i4));
        }
        kb5Var.l(iR2);
        while (i2 < fc5Var.z) {
            kb5Var.l(fc5Var.c(i2));
            i2++;
        }
    }

    public static void l(int i, List list, ub4 ub4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kb5 kb5Var = (kb5) ub4Var.b;
        int i2 = 0;
        if (!(list instanceof fc5)) {
            if (!z) {
                while (i2 < list.size()) {
                    int iIntValue = ((Integer) list.get(i2)).intValue();
                    kb5Var.e(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i2++;
                }
                return;
            }
            kb5Var.c(i, 2);
            int iR = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                int iIntValue2 = ((Integer) list.get(i3)).intValue();
                iR += kb5.r((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            kb5Var.l(iR);
            while (i2 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i2)).intValue();
                kb5Var.l((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i2++;
            }
            return;
        }
        fc5 fc5Var = (fc5) list;
        if (!z) {
            while (i2 < fc5Var.z) {
                int iC = fc5Var.c(i2);
                kb5Var.e(i, (iC >> 31) ^ (iC + iC));
                i2++;
            }
            return;
        }
        kb5Var.c(i, 2);
        int iR2 = 0;
        for (int i4 = 0; i4 < fc5Var.z; i4++) {
            int iC2 = fc5Var.c(i4);
            iR2 += kb5.r((iC2 >> 31) ^ (iC2 + iC2));
        }
        kb5Var.l(iR2);
        while (i2 < fc5Var.z) {
            int iC3 = fc5Var.c(i2);
            kb5Var.l((iC3 >> 31) ^ (iC3 + iC3));
            i2++;
        }
    }

    public static void m(int i, List list, ub4 ub4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kb5 kb5Var = (kb5) ub4Var.b;
        int i2 = 0;
        if (!(list instanceof fc5)) {
            if (!z) {
                while (i2 < list.size()) {
                    kb5Var.f(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            kb5Var.c(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).getClass();
                i3 += 4;
            }
            kb5Var.l(i3);
            while (i2 < list.size()) {
                kb5Var.m(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        fc5 fc5Var = (fc5) list;
        if (!z) {
            while (i2 < fc5Var.z) {
                kb5Var.f(i, fc5Var.c(i2));
                i2++;
            }
            return;
        }
        kb5Var.c(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < fc5Var.z; i6++) {
            fc5Var.c(i6);
            i5 += 4;
        }
        kb5Var.l(i5);
        while (i2 < fc5Var.z) {
            kb5Var.m(fc5Var.c(i2));
            i2++;
        }
    }

    public static void n(int i, List list, ub4 ub4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kb5 kb5Var = (kb5) ub4Var.b;
        int i2 = 0;
        if (!(list instanceof fc5)) {
            if (!z) {
                while (i2 < list.size()) {
                    kb5Var.f(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            kb5Var.c(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).getClass();
                i3 += 4;
            }
            kb5Var.l(i3);
            while (i2 < list.size()) {
                kb5Var.m(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        fc5 fc5Var = (fc5) list;
        if (!z) {
            while (i2 < fc5Var.z) {
                kb5Var.f(i, fc5Var.c(i2));
                i2++;
            }
            return;
        }
        kb5Var.c(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < fc5Var.z; i6++) {
            fc5Var.c(i6);
            i5 += 4;
        }
        kb5Var.l(i5);
        while (i2 < fc5Var.z) {
            kb5Var.m(fc5Var.c(i2));
            i2++;
        }
    }

    public static void o(int i, List list, ub4 ub4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kb5 kb5Var = (kb5) ub4Var.b;
        int i2 = 0;
        if (!(list instanceof fc5)) {
            if (!z) {
                while (i2 < list.size()) {
                    kb5Var.d(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            kb5Var.c(i, 2);
            int iA = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iA += kb5.a(((Integer) list.get(i3)).intValue());
            }
            kb5Var.l(iA);
            while (i2 < list.size()) {
                kb5Var.k(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        fc5 fc5Var = (fc5) list;
        if (!z) {
            while (i2 < fc5Var.z) {
                kb5Var.d(i, fc5Var.c(i2));
                i2++;
            }
            return;
        }
        kb5Var.c(i, 2);
        int iA2 = 0;
        for (int i4 = 0; i4 < fc5Var.z; i4++) {
            iA2 += kb5.a(fc5Var.c(i4));
        }
        kb5Var.l(iA2);
        while (i2 < fc5Var.z) {
            kb5Var.k(fc5Var.c(i2));
            i2++;
        }
    }

    public static void p(int i, List list, ub4 ub4Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        kb5 kb5Var = (kb5) ub4Var.b;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                boolean zBooleanValue = ((Boolean) list.get(i2)).booleanValue();
                kb5Var.l(i << 3);
                kb5Var.j(zBooleanValue ? (byte) 1 : (byte) 0);
                i2++;
            }
            return;
        }
        kb5Var.c(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).getClass();
            i3++;
        }
        kb5Var.l(i3);
        while (i2 < list.size()) {
            kb5Var.j(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    public static int q(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof wc5)) {
            int iA = 0;
            while (i < size) {
                iA += kb5.a(((Long) list.get(i)).longValue());
                i++;
            }
            return iA;
        }
        wc5 wc5Var = (wc5) list;
        int iA2 = 0;
        while (i < size) {
            iA2 += kb5.a(wc5Var.b(i));
            i++;
        }
        return iA2;
    }

    public static int r(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof wc5)) {
            int iA = 0;
            while (i < size) {
                iA += kb5.a(((Long) list.get(i)).longValue());
                i++;
            }
            return iA;
        }
        wc5 wc5Var = (wc5) list;
        int iA2 = 0;
        while (i < size) {
            iA2 += kb5.a(wc5Var.b(i));
            i++;
        }
        return iA2;
    }

    public static int s(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof wc5)) {
            int iA = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iA += kb5.a((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
            return iA;
        }
        wc5 wc5Var = (wc5) list;
        int iA2 = 0;
        while (i < size) {
            long jB = wc5Var.b(i);
            iA2 += kb5.a((jB >> 63) ^ (jB + jB));
            i++;
        }
        return iA2;
    }

    public static int t(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof fc5)) {
            int iA = 0;
            while (i < size) {
                iA += kb5.a(((Integer) list.get(i)).intValue());
                i++;
            }
            return iA;
        }
        fc5 fc5Var = (fc5) list;
        int iA2 = 0;
        while (i < size) {
            iA2 += kb5.a(fc5Var.c(i));
            i++;
        }
        return iA2;
    }

    public static int u(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof fc5)) {
            int iA = 0;
            while (i < size) {
                iA += kb5.a(((Integer) list.get(i)).intValue());
                i++;
            }
            return iA;
        }
        fc5 fc5Var = (fc5) list;
        int iA2 = 0;
        while (i < size) {
            iA2 += kb5.a(fc5Var.c(i));
            i++;
        }
        return iA2;
    }

    public static int v(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof fc5)) {
            int iR = 0;
            while (i < size) {
                iR += kb5.r(((Integer) list.get(i)).intValue());
                i++;
            }
            return iR;
        }
        fc5 fc5Var = (fc5) list;
        int iR2 = 0;
        while (i < size) {
            iR2 += kb5.r(fc5Var.c(i));
            i++;
        }
        return iR2;
    }

    public static int w(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof fc5)) {
            int iR = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iR += kb5.r((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
            return iR;
        }
        fc5 fc5Var = (fc5) list;
        int iR2 = 0;
        while (i < size) {
            int iC = fc5Var.c(i);
            iR2 += kb5.r((iC >> 31) ^ (iC + iC));
            i++;
        }
        return iR2;
    }

    public static int x(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (kb5.r(i << 3) + 4) * size;
    }

    public static int y(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (kb5.r(i << 3) + 8) * size;
    }
}
