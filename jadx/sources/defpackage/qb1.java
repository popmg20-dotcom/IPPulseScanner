package defpackage;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class qb1 implements Serializable {
    public final int A;
    public final int X;
    public final transient ArrayList Y;
    public final String b;
    public final TimeZone f;
    public final Locale z;
    public static final Locale Z = new Locale("ja", "JP", "JP");
    public static final e1 y0 = new e1(13);
    public static final ConcurrentMap[] z0 = new ConcurrentMap[17];
    public static final gb1 A0 = new gb1(1, 0);
    public static final gb1 B0 = new gb1(2, 1);
    public static final kb1 C0 = new kb1(1);
    public static final kb1 D0 = new kb1(3);
    public static final kb1 E0 = new kb1(4);
    public static final kb1 F0 = new kb1(6);
    public static final kb1 G0 = new kb1(5);
    public static final gb1 H0 = new gb1(7, 2);
    public static final kb1 I0 = new kb1(8);
    public static final kb1 J0 = new kb1(11);
    public static final gb1 K0 = new gb1(11, 3);
    public static final gb1 L0 = new gb1(10, 4);
    public static final kb1 M0 = new kb1(10);
    public static final kb1 N0 = new kb1(12);
    public static final kb1 O0 = new kb1(13);
    public static final kb1 P0 = new kb1(14);

    /* JADX WARN: Removed duplicated region for block: B:23:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x015a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public qb1(java.lang.String r13, java.util.TimeZone r14, java.util.Locale r15) {
        /*
            Method dump skipped, instruction units count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qb1.<init>(java.lang.String, java.util.TimeZone, java.util.Locale):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(java.lang.StringBuilder r6, java.lang.String r7) {
        /*
            r0 = 0
        L1:
            int r1 = r7.length()
            r2 = 63
            r3 = 46
            if (r0 >= r1) goto L38
            char r1 = r7.charAt(r0)
            r4 = 36
            r5 = 92
            if (r1 == r4) goto L2f
            if (r1 == r3) goto L2f
            if (r1 == r2) goto L2f
            r2 = 94
            if (r1 == r2) goto L2f
            r2 = 91
            if (r1 == r2) goto L2f
            if (r1 == r5) goto L2f
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L2f
            r2 = 124(0x7c, float:1.74E-43)
            if (r1 == r2) goto L2f
            switch(r1) {
                case 40: goto L2f;
                case 41: goto L2f;
                case 42: goto L2f;
                case 43: goto L2f;
                default: goto L2e;
            }
        L2e:
            goto L32
        L2f:
            r6.append(r5)
        L32:
            r6.append(r1)
            int r0 = r0 + 1
            goto L1
        L38:
            int r7 = r6.length()
            int r7 = r7 + (-1)
            char r7 = r6.charAt(r7)
            if (r7 != r3) goto L47
            r6.append(r2)
        L47:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qb1.c(java.lang.StringBuilder, java.lang.String):void");
    }

    public final mb1 a(int i, Calendar calendar) {
        ConcurrentMap concurrentMap;
        ConcurrentMap[] concurrentMapArr = z0;
        synchronized (concurrentMapArr) {
            try {
                if (concurrentMapArr[i] == null) {
                    concurrentMapArr[i] = new ConcurrentHashMap(3);
                }
                concurrentMap = concurrentMapArr[i];
            } catch (Throwable th) {
                throw th;
            }
        }
        mb1 mb1Var = (mb1) concurrentMap.get(this.z);
        if (mb1Var != null) {
            return mb1Var;
        }
        Locale locale = this.z;
        mb1 pb1Var = i == 15 ? new pb1(locale) : new hb1(i, calendar, locale);
        mb1 mb1Var2 = (mb1) concurrentMap.putIfAbsent(this.z, pb1Var);
        return mb1Var2 != null ? mb1Var2 : pb1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(java.lang.String r11, java.text.ParsePosition r12, java.util.Calendar r13) {
        /*
            r10 = this;
            java.util.ArrayList r0 = r10.Y
            java.util.ListIterator r0 = r0.listIterator()
        L6:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L4a
            java.lang.Object r1 = r0.next()
            nb1 r1 = (defpackage.nb1) r1
            mb1 r2 = r1.a
            boolean r2 = r2.a()
            r3 = 0
            if (r2 == 0) goto L37
            boolean r2 = r0.hasNext()
            if (r2 != 0) goto L22
            goto L37
        L22:
            java.lang.Object r2 = r0.next()
            nb1 r2 = (defpackage.nb1) r2
            mb1 r2 = r2.a
            r0.previous()
            boolean r2 = r2.a()
            if (r2 == 0) goto L37
            int r2 = r1.b
            r9 = r2
            goto L38
        L37:
            r9 = r3
        L38:
            mb1 r4 = r1.a
            r5 = r10
            r7 = r11
            r8 = r12
            r6 = r13
            boolean r10 = r4.b(r5, r6, r7, r8, r9)
            if (r10 != 0) goto L45
            return r3
        L45:
            r10 = r5
            r13 = r6
            r11 = r7
            r12 = r8
            goto L6
        L4a:
            r10 = 1
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qb1.b(java.lang.String, java.text.ParsePosition, java.util.Calendar):boolean");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof qb1)) {
            return false;
        }
        qb1 qb1Var = (qb1) obj;
        return this.b.equals(qb1Var.b) && this.f.equals(qb1Var.f) && this.z.equals(qb1Var.z);
    }

    public final int hashCode() {
        return (((this.z.hashCode() * 13) + this.f.hashCode()) * 13) + this.b.hashCode();
    }

    public final String toString() {
        return "FastDateParser[" + this.b + "," + this.z + "," + this.f.getID() + "]";
    }
}
